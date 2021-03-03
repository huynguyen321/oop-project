package Funtion;

import Framework.Account;
import Framework.Author;
import Framework.Chapter;
import Framework.Novel;
import static Framework.StatusAndCategory.listCategory;
import static RunApp.App.choose;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManageWN {

    private static Scanner sc = new Scanner(System.in);
// chuc nang cua translator

    public static void editWN(ArrayList<Novel> novel, ArrayList<Account> acc, int idAcc) {
        int caseEdit = 0;
        int idWN = 0;
        /* cac truong hop co the xay ra khi edit
        0. khong co truyen de edit
        1. tro ve menu khong edit truyen nua
        >1. edit thanh cong
         */
        System.out.println("       Vui lòng chọn truyện bạn muốn chỉnh sửa!");
        showProject(novel, acc, idAcc);
        if (acc.get(idAcc).getProject().size() <= 0) {
            while ((choose() - 1) != -1) {
                System.err.println("    *Không có lựa chọn này mời nhập lại!");
            }
        } else {
            while (true) {
                try {
                    idWN = choose() - 1;
                    if (idWN == -1) {
                        caseEdit = 1;
                    } else {
                        caseEdit = 2;
                    }
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    System.err.print("  Không có lựa chọn này!\n Vui lòng nhập lại. ");
                }
            }
        }

        Menu.EditWNTrans();
        if (caseEdit > 1) {
            int choose = choose();
            while (choose > 6 || choose < 1) {
                System.err.println("  *Không có lựa chọn này! Mời nhập lại!");
                choose = choose();
            }
            switch (choose) {
                case 1:
                    editNameWN(novel, idWN);
                    break;
                case 2:
                    editNameAuthor(novel, idWN);
                    break;
                case 3:
                    addAChapter(novel, idWN);
                    break;
                case 4:
                    deleteAChapter(novel, idWN);
                    break;
                case 5:
                    break;
            }
        }
    }

    private static void editNameWN(ArrayList<Novel> novel, int idWN) {
        System.out.println("Tên hiện tại: " + novel.get(idWN).getNameNovel());
        System.out.print("Tên mới: ");
        novel.get(idWN).setNameNovel(sc.nextLine());
        System.out.println("   Đổi tên truyện thành công!");
    }

    private static void editNameAuthor(ArrayList<Novel> novel, int idWN) {
        System.out.println("Tên tác giả hiện tại: " + novel.get(idWN).getAuthor().getNameAuthor());
        System.out.print("Tên mới: ");
        novel.get(idWN).setAuthor(new Author(sc.nextLine()));
        System.out.println("   Đổi tên tác giả thành công!");
    }

    private static void addAChapter(ArrayList<Novel> novel, int idWN) {
        Date timeUpdate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        System.out.println("     *Lưu ý: nhấn enter để hoàn thành việc nhập chương mới và trở lại trang trước đó");
        System.out.println("Nhập nội dung chương " + (novel.get(idWN).getChapter().size() + 1) + ": ");

        novel.get(idWN).getChapter().add(new Chapter(novel.get(idWN).getChapter().size(), formatter.format(timeUpdate), sc.nextLine()));
        System.out.println("     Đã thêm chương mới thành công vào " + formatter.format(timeUpdate) + "!");
    }

    private static void deleteAChapter(ArrayList<Novel> novel, int idWN) {
        System.out.println("Nhập chương(chapter) muốn xóa: ");
        ListWN.ShowAllChapter(novel, idWN);
        int idChap = choose() - 1;
        while (idChap < -1 || idChap >= novel.get(idWN).getChapter().size()) {
            System.err.println("*Không có lựa chọn này mời nhập lại");
            idChap = choose();
        }
        novel.get(idWN).getChapter().remove(idChap);
        System.out.println("Xóa chương truyện thành công!");
    }

    private static void showProject(ArrayList<Novel> novel, ArrayList<Account> acc, int idAcc) {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                           Dự án của bạn                            |");
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        if (acc.get(idAcc).getProject().size() > 0) {
            for (int i = 0; i < acc.get(idAcc).getProject().size(); i++) {
                System.out.printf("|              %d. %-51s%s\n", (i + 1), novel.get(acc.get(idAcc).getProject().get(i)).getNameNovel(), "|");
            }
        } else {
            System.out.println("|                    Bạn chưa thực hiện dự án nào!                   |");
        }
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void deleteWNTrans(ArrayList<Novel> novel, ArrayList<Account> acc, int idAcc) {
        System.out.println("Vui lòng chọn truyện muốn xóa.");
        showProject(novel, acc, idAcc);
        int idWN;
        do {
            idWN = choose() - 1;
        } while (idWN < -1 || idWN >= acc.get(idAcc).getProject().size());
        if (idWN >= 0) {
            acc.get(idAcc).getProject().remove(idWN);
            novel.remove(idWN);
            System.out.println("    *Xóa truyện thành công!");
        }
    }

    public static void addAWN(ArrayList<Novel> novel, ArrayList<Account> acc, int idAcc) {
        novel.add(new Novel());
        int idWN = novel.size() - 1;

        System.out.print("Nhập tên truyện: ");
        novel.get(idWN).setNameNovel(sc.nextLine());

        System.out.println("Nhập phần tóm tắt(hoặc giới thiệu chung) cho truyện: ");
        novel.get(idWN).setIntroNovel(sc.nextLine());

        System.out.print("Chọn thể loại cho truyện: ");
        ArrayList<Integer> category = new ArrayList<>();
        chooseCategory(novel, idWN, category);
        novel.get(idWN).setCategory(category);

        System.out.println("Nhập tên tác giả: ");
        novel.get(idWN).setAuthor(new Author(sc.nextLine()));
    }

    private static void chooseCategory(ArrayList<Novel> novel, int idWN, ArrayList<Integer> category) {
        SearchByCategory.ShowListCategory();
        int idCategory = choose() - 1;
        while (idCategory < -1 || idCategory > 17) {
            System.err.println("   *Không có lựa chọn này! Vui lòng nhập lại!");
            idCategory = choose() - 1;
        }

        if ((novel.get(idWN).getCategory()).indexOf(listCategory[idCategory][0]) >= 0 || (listCategory[idCategory][0]).indexOf(novel.get(idWN).getCategory()) >= 0) {
            System.err.println("   *Truyện đã có thể loại này, không cần phải thêm nữa");
        } else {
            category.add(idCategory);
        }
        askToContinueEnter(novel, idWN, category);
    }

    private static void askToContinueEnter(ArrayList<Novel> novel, int idWN, ArrayList<Integer> category) {
        System.out.println("Bạn có muốn tiếp tục thêm thể loại cho truyện nữa không?");
        System.out.println("+-----------------------------+");
        System.out.println("|   1. Tiếp tục thêm          |");
        System.out.println("|   2. Kết thúc               |");
        System.out.println("+-----------------------------+");
        switch (choose()) {
            case 1:
                chooseCategory(novel, idWN, category);
                break;
            case 2:
                break;
            default:
                System.err.println("Không có lựa chọn này mời chọn lại!");
                askToContinueEnter(novel, idWN, category);
        }
    }

// chuc nang rieng cho admin
    public static void deleteWNAdmin(ArrayList<Novel> novel) {
        System.out.println("Vui lòng chọn truyện muốn xóa.");
        ListWN.ShowAllWN(novel);
        int idWN;
        do {
            idWN = choose() - 1;
        } while (idWN < -1 || idWN >= novel.size());
        if (idWN >= 0) {
            novel.remove(idWN);
            System.out.println("    *Xóa truyện thành công!");
        }
    }
}
