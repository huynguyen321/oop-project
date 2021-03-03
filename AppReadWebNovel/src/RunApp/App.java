package RunApp;

import static Funtion.Menu.*;
import static Database.DatabaseAccount.arrAcc;
import static Database.DatabaseWN.arrNovel;
import Framework.Novel;
import Framework.Account;
import Framework.StatusAndCategory;
import Funtion.ActivitiesWithAccount;
import Funtion.Bookmark;
import static Funtion.ListWN.*;
import Funtion.Login;
import Funtion.ManageWN;
import Funtion.Register;
import Funtion.Search;
import Funtion.SearchByCategory;
import static Funtion.SearchByCategory.ShowListCategory;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void goodbye() {
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println("|           Cảm ơn bạn đã sử dụng ứng dụng của chúng tôi.            |"
                + "\n|      Ứng dụng được tạo bởi Nguyễn Thị Diễm và Nguyễn Ngọc Huy      |");
        System.out.println("+--------------------------------------------------------------------+");
        System.out.println(" ^ ^              \n"
                + "(O,O)             \n"
                + "(   ) Tạm biệt    \n"
                + "-\"-\"--------------");
        
    }
    
    public static byte choose() {
        System.out.println("Vui lòng nhập lựa chọn của bạn(chỉ nhập số): ");
        byte choose;
        while (true) {
            try {
                choose = Byte.parseByte(sc.next());
                break;
            } catch (NumberFormatException ex) {
                System.err.println("    Bạn đã nhập chữ hoặc số quá lớn!\n    Vui lòng chỉ nhập số có trên menu!");
                System.out.print(" Nhập lại: ");
            }
        }
        return choose;
    }
    
    public static void main(String[] args) {
        //truy cap database tai khoan
        ArrayList<Account> acc = new ArrayList<>();
        acc = arrAcc();
        // truy cap database web novel
        ArrayList<Novel> novel = new ArrayList<>();
        novel = arrNovel();
        // id account
        int idAcc = 0;
        int idWN = 0;
        int idChap = 0;
        int idCategory = 0;
        
        int exit = 0;/* co 3 gia tri ma exit mang la
        1 thoat menu nao do vao den menu tiep theo
        2 thoat khoi chuong trinh
        0 van con hoat dong*/
        BeginPage:
        while (exit == 0) {
            Begin();
            switch (choose()) {
                case 1:
                    idAcc = Login.Login(acc);
                    if (idAcc < 0) {
                        continue BeginPage;
                    }
                    exit = 1;
                    break;
                case 2:
                    acc = Register.Register(acc);
                    continue BeginPage;
                case 3:
                    exit = 2;
                    break;
                default:
                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                    continue BeginPage;
            }
            
            MainPage:
            while (exit == 1) {
                if ("User".equals(acc.get(idAcc).getRole())) {
                    //User
                    MainPageUser();
                    switch (choose()) {
                        case 1:
                            // hien thi danh sach truyen va chon
                            BackToAllWN:
                            while (true) {
                                int check = 1;
                                ShowAllWN(novel);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idWN = choose() - 1;
                                    check = 0;
                                } while (idWN < -1 || idWN >= novel.size());
                                if (idWN == -1) {
                                    continue MainPage;
                                }
                                
                                check = 1;
                                //hien thi cac chapter
                                BackToChapter:
                                while (true) {
                                    ShowAllChapter(novel, idWN);
                                    
                                    do {
                                        if (check == 0) {
                                            System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                        }
                                        idChap = choose() - 1;
                                        check = 0;
                                    } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                    if (idChap == -1) {
                                        continue BackToAllWN;
                                    } else {
                                        ShowContentChapter(novel, idWN, idChap);
                                        System.out.println("");
                                        if (choose() != 100000) {
                                            continue BackToChapter;
                                        }
                                    }
                                    break;
                                }
                            }
                        case 2:
                            //thuc hien nhap truyen can tim va tim
                            int limitChoose = Search.ShowResultSearch(novel);
                            int check = 1;
                            // chon truyen
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            
                            check = 1;
                            // hien thi cac chapter
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        
                        case 3:
                            // chon the loai
                            ShowListCategory();
                            limitChoose = StatusAndCategory.listCategory.length;
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idCategory = choose() - 1;
                                check = 0;
                            } while (idCategory < -1 || idCategory >= limitChoose);
                            if (idCategory == -1) {
                                continue MainPage;
                            }
                            // chon truyen thuoc the loai do
                            limitChoose = SearchByCategory.ShowResultSearch(novel, idCategory);
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            // hien thi cac chuong truyen
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        case 4:
                            Bookmark.ShowBookmark(novel, acc, idAcc);
                            // chon truyen dang theo doi
                            limitChoose = acc.get(idAcc).getBookmark().size();
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            // hien thi cac chuong truyen
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        // mot vai tuy chon voi tai khoan    
                        case 5:
                            OptionAccount();
                            switch (choose()) {
                                case 1:
                                    ActivitiesWithAccount.changePassword(acc, idAcc);
                                    continue MainPage;
                                case 2:
                                    exit = 0;
                                    continue BeginPage;
                                case 3:
                                    continue MainPage;
                            }
                            break;
                        
                        case 6:
                            exit = 2;
                            break;
                        default:
                            System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                            continue MainPage;
                    }
                } else if ("Translator".equals(acc.get(idAcc).getRole())) {
                    //translator
                    MainPageTrans();
                    switch (choose()) {
                        case 1:
                            // hien thi danh sach truyen va chon
                            BackToAllWN:
                            while (true) {
                                int check = 1;
                                ShowAllWN(novel);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idWN = choose() - 1;
                                    check = 0;
                                } while (idWN < -1 || idWN >= novel.size());
                                if (idWN == -1) {
                                    continue MainPage;
                                }
                                
                                check = 1;
                                //hien thi cac chapter
                                BackToChapter:
                                while (true) {
                                    ShowAllChapter(novel, idWN);
                                    
                                    do {
                                        if (check == 0) {
                                            System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                        }
                                        idChap = choose() - 1;
                                        check = 0;
                                    } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                    if (idChap == -1) {
                                        continue BackToAllWN;
                                    } else {
                                        ShowContentChapter(novel, idWN, idChap);
                                        System.out.println("");
                                        if (choose() != 100000) {
                                            continue BackToChapter;
                                        }
                                    }
                                    break;
                                }
                            }
                        case 2:
                            //thuc hien nhap truyen can tim va tim
                            int limitChoose = Search.ShowResultSearch(novel);
                            int check = 1;
                            // chon truyen
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            
                            check = 1;
                            // hien thi cac chapter
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        
                        case 3:
                            // chon the loai
                            ShowListCategory();
                            limitChoose = StatusAndCategory.listCategory.length;
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idCategory = choose() - 1;
                                check = 0;
                            } while (idCategory < -1 || idCategory >= limitChoose);
                            if (idCategory == -1) {
                                continue MainPage;
                            }
                            // chon truyen thuoc the loai do
                            limitChoose = SearchByCategory.ShowResultSearch(novel, idCategory);
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            // hien thi cac chuong truyen
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        case 4:
                            Bookmark.ShowBookmark(novel, acc, idAcc);
                            // chon truyen dang theo doi
                            limitChoose = acc.get(idAcc).getBookmark().size();
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            // hien thi cac chuong truyen
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        
                        case 5:
                            ManageWNPageOfTrans:
                            while (true) {
                                ManageWNTrans();
                                switch (choose()) {
                                    case 1:
                                        ManageWN.editWN(novel, acc, idAcc);
                                        continue ManageWNPageOfTrans;
                                    case 2:
                                        ManageWN.deleteWNTrans(novel, acc, idAcc);
                                        continue ManageWNPageOfTrans;
                                    case 3:
                                        ManageWN.addAWN(novel, acc, idAcc);
                                        continue ManageWNPageOfTrans;
                                    case 4:
                                        continue MainPage;
                                    default:
                                        System.err.println("  Không có lựa chọn này! Vui lòng chọn lại.");
                                        continue ManageWNPageOfTrans;
                                }
                            }
                        // mot vai tuy chon voi tai khoan    
                        case 6:
                            OptionAccount();
                            switch (choose()) {
                                case 1:
                                    ActivitiesWithAccount.changePassword(acc, idAcc);
                                    continue MainPage;
                                case 2:
                                    exit = 0;
                                    continue BeginPage;
                                case 3:
                                    continue MainPage;
                            }
                            break;
                        
                        case 7:
                            exit = 2;
                            break;
                        default:
                            System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                            continue MainPage;
                    }
                } else {
                    //administrator
                    MainPageAdmin();
                    switch (choose()) {
                        case 1:
                            // hien thi danh sach truyen va chon
                            BackToAllWN:
                            while (true) {
                                int check = 1;
                                ShowAllWN(novel);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idWN = choose() - 1;
                                    check = 0;
                                } while (idWN < -1 || idWN >= novel.size());
                                if (idWN == -1) {
                                    continue MainPage;
                                }
                                
                                check = 1;
                                //hien thi cac chapter
                                BackToChapter:
                                while (true) {
                                    ShowAllChapter(novel, idWN);
                                    
                                    do {
                                        if (check == 0) {
                                            System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                        }
                                        idChap = choose() - 1;
                                        check = 0;
                                    } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                    if (idChap == -1) {
                                        continue BackToAllWN;
                                    } else {
                                        ShowContentChapter(novel, idWN, idChap);
                                        System.out.println("");
                                        if (choose() != 100000) {
                                            continue BackToChapter;
                                        }
                                    }
                                    break;
                                }
                            }
                        case 2:
                            //thuc hien nhap truyen can tim va tim
                            int limitChoose = Search.ShowResultSearch(novel);
                            int check = 1;
                            // chon truyen
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            
                            check = 1;
                            // hien thi cac chapter
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        
                        case 3:
                            // chon the loai
                            ShowListCategory();
                            limitChoose = StatusAndCategory.listCategory.length;
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idCategory = choose() - 1;
                                check = 0;
                            } while (idCategory < -1 || idCategory >= limitChoose);
                            if (idCategory == -1) {
                                continue MainPage;
                            }
                            // chon truyen thuoc the loai do
                            limitChoose = SearchByCategory.ShowResultSearch(novel, idCategory);
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            // hien thi cac chuong truyen
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        case 4:
                            Bookmark.ShowBookmark(novel, acc, idAcc);
                            // chon truyen dang theo doi
                            limitChoose = acc.get(idAcc).getBookmark().size();
                            check = 1;
                            do {
                                if (check == 0) {
                                    System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                }
                                idWN = choose() - 1;
                                check = 0;
                            } while (idWN < -1 || idWN >= limitChoose);
                            if (idWN == -1) {
                                continue MainPage;
                            }
                            // hien thi cac chuong truyen
                            BackToChapter:
                            while (true) {
                                ShowAllChapter(novel, idWN);
                                do {
                                    if (check == 0) {
                                        System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                                    }
                                    idChap = choose() - 1;
                                    check = 0;
                                } while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size());
                                if (idChap == -1) {
                                    continue MainPage;
                                } else {
                                    ShowContentChapter(novel, idWN, idChap);
                                    System.out.println("");
                                    if (choose() != 10000000) {
                                        continue BackToChapter;
                                    }
                                }
                                break;
                            }
                            break;
                        case 5:
                            ManageWN.deleteWNAdmin(novel);
                            continue MainPage;
                        
                        case 6:
                            ManageAccountAdmin();
                            switch (choose()) {
                                case 1:
                                    ActivitiesWithAccount.addAnAccount(acc);
                                    break;
                                case 2:
                                    ActivitiesWithAccount.deleteAnAccount(acc,idAcc);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.err.println("   *Không có lựa chọn này!");
                                    break;
                            }
                            continue MainPage;
                        // mot vai tuy chon voi tai khoan        
                        case 7:
                            OptionAccount();
                            switch (choose()) {
                                case 1:
                                    ActivitiesWithAccount.changePassword(acc, idAcc);
                                    continue MainPage;
                                case 2:
                                    exit = 0;
                                    continue BeginPage;
                                case 3:
                                    continue MainPage;
                            }
                            break;
                        
                        case 8:
                            exit = 2;
                            break;
                        default:
                            System.err.println("Không có lựa chọn này! Vui lòng chọn lại.");
                            continue MainPage;
                    }
                }
                exit = 2;
            }
        }
        goodbye();
        sc.close();
    }
}
