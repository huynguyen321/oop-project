package Funtion;

import Framework.Account;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    public static ArrayList<Account> Register(ArrayList<Account> acc) {
        System.out.println("      Đăng kí: ");
        acc.add(new Account(Register.enterUsername(acc), Register.enterPasswordAgain()));
        NotificationRegister();
        return acc;
    }

    private static void NotificationRegister() {
        System.out.println("   Bạn đã đăng kí tài khoản thành công!\n   Vui lòng chọn đăng nhập để sử dụng ứng dụng");
    }

    public static String enterUsername(ArrayList<Account> acc) {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.print("Tên đang nhập: ");
        username = sc.next();
        while (checkUsername(acc, username)) {
            System.err.print("*Tên đăng nhập đã tồn tại!\n Vui lòng nhập lại!\nTên đăng nhập: ");
            username = sc.next();
        }
        return username;
    }

    public static String enterPassword() {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.print("Mật khẩu: ");
        password = sc.next();
        while (password.length() < 6) {
            System.err.print("*Độ dài mật khẩu phải >=6!\n Vui lòng nhập lại!");
            System.out.println("Mật khẩu: ");
            password = sc.next();
        }
        return password;
    }

    private static String enterPasswordAgain() {
        Scanner sc = new Scanner(System.in);
        String password1 = enterPassword();
        String password2;
        System.out.print("Nhập lại mật khẩu: ");
        password2 = sc.next();
        while (password2.contentEquals(password1) == false) {
            System.err.print("   Mật khẩu không trùng khớp! Mời nhập lại.");
            System.out.print("Nhập lại mật khẩu: ");
            password2 = sc.next();
        }
        return password2;
    }

    private static boolean checkUsername(ArrayList<Account> acc, String username) {
        boolean check = false;
        checkU:
        for (int i = 0; i < acc.size(); i++) {
            if (username.equals(acc.get(i).getUsername())) {
                check = true;
                break checkU;
            }
        }
        return check;
    }

}
