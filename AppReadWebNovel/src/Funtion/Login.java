package Funtion;

import Framework.Account;
import static RunApp.App.choose;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static int Login(ArrayList<Account> acc) {
        // username
        int idAcc = -1;
        ennterUsn:
        while (true) {
            idAcc = checkUsername(acc, enterUsername());
            if (idAcc == -1) {
                NotificationLogin(1);
                System.out.println("+-----------------------------+");
                System.out.println("|   1. Nhập lại lần nữa       |");
                System.out.println("|   2. Quay lại               |");
                System.out.println("+-----------------------------+");
                switch (choose()) {
                    case 1:
                        continue ennterUsn;
                    case 2:
                        break;
                    default:
                        System.err.println("Không có lựa chọn này mời chọn lại!");
                        break;
                }
            }
            break;
        }
        //password
        if (idAcc > -1) {
            enterPw:
            while (checkPassword(acc, enterPassword(), idAcc) == false) {
                NotificationLogin(2);
                System.out.println("+-----------------------------+");
                System.out.println("|   1. Nhập lại lần nữa       |");
                System.out.println("|   2. Quay lại               |");
                System.out.println("+-----------------------------+");
                switch (choose()) {
                    case 1:
                        continue enterPw;
                    case 2:
                        idAcc = -1;
                        break enterPw;
                    default:
                        System.err.println("Không có lựa chọn này mời chọn lại!");
                        break;
                }
            }
        }
        //xac nhan dang nhap thanh cong
        if (idAcc > -1) {
            NotificationLogin(3);
        }
        return idAcc;
    }

    private static void NotificationLogin(int caseNotification) {
        switch (caseNotification) {
            case 1:
                System.err.println("Tên đăng nhập không có trong hệ thống!\nNếu chưa có tài khoản vui lòng đăng kí");
                break;
            case 2:
                System.err.println("Mật khẩu của bạn không chính xác!\nNếu quên mật khẩu vui lòng gửi mail đến:");
                System.err.println("huy.nguyen22@student.passerellesnumeriques.org");
                break;
            default:
                System.out.println("Đăng nhập hệ thống thành công!\nChúc bạn đọc truyện vui vẻ.");
                break;
        }
    }

    private static String enterUsername() {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.print("Tên đang nhập: ");
        username = sc.next();
        return username;
    }

    private static String enterPassword() {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.print("Mật khẩu: ");
        password = sc.next();
        return password;
    }

    private static int checkUsername(ArrayList<Account> acc, String username) {
        for (int i = 0; i < acc.size(); i++) {
            if (username.contentEquals(acc.get(i).getUsername())) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkPassword(ArrayList<Account> acc, String password, int idAcc) {
        boolean check = false;
        if (password.equals(acc.get(idAcc).getPassword())) {
            check = true;
        }
        return check;
    }
}
