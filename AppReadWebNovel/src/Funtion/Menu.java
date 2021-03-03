package Funtion;

public class Menu {

    public static void Begin() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|          Bạn cần phải đăng nhập để sử dụng ứng dụng này!           |");
        System.out.println("|              1. Đăng nhập                                          |");// den phan dang nhap
        System.out.println("|              2. Đăng ký                                            |");// den phan dang ky
        System.out.println("|              3. Thoát ứng dụng                                     |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void MainPageUser() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                             Trang chủ                              |");
        System.out.println("|              1. Danh sách các Web Novel                            |");// hien thi tat ca cac Web Novel
        System.out.println("|              2. Tìm kiếm                                           |");
        System.out.println("|              3. Thể loại                                           |");// den menu ListCategory()
        System.out.println("|              4. Truyện đang theo dõi                               |");// den menu bookmark
        System.out.println("|              5. Tài khoản                                          |");// den optionAccount()
        System.out.println("|              6. Thoát ứng dụng                                     |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void OptionAccount() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                             Tài khoản                              |");
        System.out.println("|              1. Đổi mật khẩu                                       |");
        System.out.println("|              2. Đăng xuất                                          |");
        System.out.println("|              3. Về trang chủ                                       |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void MainPageTrans() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                             Trang chủ                              |");
        System.out.println("|              1. Danh sách các Web Novel                            |");// hien thi tat ca cac Web Novel
        System.out.println("|              2. Tìm kiếm                                           |");
        System.out.println("|              3. Thể loại                                           |");// den menu ListCategory() 
        System.out.println("|              4. Truyện đang theo dõi                               |");// den menu bookmark
        System.out.println("|              5. Quản lí truyện                                     |");// den menu ManageWNTrans()
        System.out.println("|              6. Tài khoản                                          |");// den optionAccount()
        System.out.println("|              7. Thoát ứng dụng                                     |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void ManageWNTrans() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                           Quản lý tuyện                            |");
        System.out.println("|              1. Chỉnh sửa truyện                                   |");// chon truyen roi den EditWNTrans()
        System.out.println("|              2. Xóa truyện                                         |");// chon truyen roi xoa truyen do khoi danh sach
        System.out.println("|              3. Đăng truyện mới                                    |");// phan dang them truyen moi
        System.out.println("|              4. Về trang chủ                                       |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void EditWNTrans() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                           Quản lý tuyện                            |");
        System.out.println("|              1. Chỉnh sửa tên truyện                               |");
        System.out.println("|              2. Chỉnh sửa tên tác giả                              |");
        System.out.println("|              3. Đăng chương mới                                    |");
        System.out.println("|              4. Xóa chương                                         |");
        System.out.println("|              5. Trở lại                                            |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void MainPageAdmin() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                             Trang chủ                              |");
        System.out.println("|              1. Danh sách các Web Novel                            |");// hien thi tat ca cac Web Novel
        System.out.println("|              2. Tìm kiếm                                           |");
        System.out.println("|              3. Thể loại                                           |");// den menu ListCategory() 
        System.out.println("|              4. Truyện đang theo dõi                               |");// den menu bookmark
        System.out.println("|              5. Xóa truyện không hợp lệ                            |");
        System.out.println("|              6. Quản lí tài khoản                                  |");// den menu ManageAccountAdmin()
        System.out.println("|              7. Tài khoản                                          |");// den optionAccount()
        System.out.println("|              8. Thoát ứng dụng                                     |");
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void ManageAccountAdmin() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                         Quản lí tài khoản                          |");
        System.out.println("|              1. Thêm tài khoản                                     |");
        System.out.println("|              2. Xóa tài khoản                                      |");
        System.out.println("|              3. Về trang chủ                                       |");
        System.out.println("+--------------------------------------------------------------------+");
    }

}
