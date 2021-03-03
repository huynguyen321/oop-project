package Funtion;

import Framework.Account;
import static RunApp.App.choose;
import java.util.ArrayList;
import java.util.Scanner;

public class ActivitiesWithAccount {

    private static Scanner sc = new Scanner(System.in);
// tat ca loai tai khoan deu dung duoc

    public static void changePassword(ArrayList<Account> acc, int idAcc) {
        System.out.println("-----------Đổi mật khẩu-----------");
        System.out.println("Tên đang nhập: " + acc.get(idAcc).getUsername());
        enterOldPassword(acc, idAcc);
        acc.get(idAcc).setPassword(enterPasswordAgain(acc, idAcc));
        System.out.println("Đổi mật khẩu thành công!");
    }

    private static String enterOldPassword(ArrayList<Account> acc, int idAcc) {
        String password;
        System.out.print("Mật khẩu cũ: ");
        password = sc.next();
        while (!(checkOldPassword(acc, password, idAcc))) {
            System.err.println("       Mật khẩu cũ không đúng! Vui lòng nhập lại");
            System.out.print("Mật khẩu cũ: ");
            password = sc.next();
        }
        return password;
    }

    private static boolean checkOldPassword(ArrayList<Account> acc, String password, int idAcc) {
        return password.equals(acc.get(idAcc).getPassword());
    }

    private static String enterNewPassword(ArrayList<Account> acc, int idAcc) {
        String newPassword;
        System.out.print("Mật khẩu mới: ");
        newPassword = sc.next();
        while (newPassword.length() < 6 || checkOldPassword(acc, newPassword, idAcc)) {
            if (newPassword.length() < 6) {
                System.err.println("   *Độ dài mật khẩu phải >=6!\n Vui lòng nhập lại!");
            } else if (checkOldPassword(acc, newPassword, idAcc)) {
                System.err.println("   *Mật khẩu mới trùng với mật khẩu cũ!\n Vui lòng nhập lại!");
            }
            System.out.print("Mật khẩu mới: ");
            newPassword = sc.next();
        }
        return newPassword;
    }

    private static String enterPasswordAgain(ArrayList<Account> acc, int idAcc) {
        String newPassword1 = enterNewPassword(acc, idAcc);
        String newPassword2;
        System.out.print("Nhập lại mật khẩu mới: ");
        newPassword2 = sc.next();
        while (newPassword2.contentEquals(newPassword1) == false) {
            System.out.print("   Mật khẩu không trùng khớp! Mời nhập lại.\nNhập lại mật khẩu mới: ");
            newPassword2 = sc.next();
        }
        return newPassword2;
    }

    // admin
    private static void showAllAccount(ArrayList<Account> acc) {
        System.out.println("+---------------------Ứng dụng đọc Web Novel--------------------+");
        System.out.println("|                      Danh sách tài khoản                      |");
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|              Tên đăng nhập             |    Loại tài khoản    |");
        System.out.println("+---------------------------------------------------------------+");
        for (int i = 0; i < acc.size(); i++) {
            System.out.printf("|  %-1d. %-35s|  %-20s|\n", (i + 1), acc.get(i).getUsername(), acc.get(i).getRole());
        }
        System.out.println("+---------------------------------------------------------------+");
    }

    public static void deleteAnAccount(ArrayList<Account> acc,int idAccNow) {
        System.out.println("Chọn tài khoản muốn xóa:");
        showAllAccount(acc);
        int idAcc = choose() - 1;
        while (idAcc < -1 || idAcc >= acc.size()) {
            System.err.println("  *Không có lựa chọn này!");
            idAcc = choose();
        }
        if(idAccNow==idAcc){
            System.err.println("  *Không thể tự xóa tài khoản!");
        }else if (idAcc > -1 ) {
            acc.remove(idAcc);
            System.out.println("   *Xóa tài khoản thành công!");
        }
    }

    public static void addAnAccount(ArrayList<Account> acc) {
        acc.add(new Account());
        //nhap ten dang nhap
        acc.get(acc.size() - 1).setUsername(Register.enterUsername(acc));
        //nhap mat khau
        acc.get(acc.size() - 1).setPassword(Register.enterPassword());

        System.out.println("Loại tài khoản: ");
        System.out.println("1. User\n2. Translator\n3. Administrator");
        int choose = choose();
        while (choose < 1 || choose > 3) {
            System.err.println("  *Không có lựa chọn này!");
            choose = choose();
        }

        switch (choose) {
            case 1:
                acc.get(acc.size() - 1).setRole("User");
                break;
            case 2:
                acc.get(acc.size() - 1).setRole("Translator");
                break;
            case 3:
                acc.get(acc.size() - 1).setRole("Administrator");
                break;
        }
        System.out.println("Thêm tài khoản thành công!");
    }
}
