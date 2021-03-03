package Funtion;

import Framework.Account;
import Framework.Novel;
import java.util.ArrayList;

public class Bookmark {

    public static void ShowBookmark(ArrayList<Novel> novel, ArrayList<Account> acc, int idAcc) {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                   Danh sách truyện đang theo dõi                   |");
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        for (int i = 0; i < novel.size(); i++) {
            System.out.printf("|              %d. %-51s%s\n", (i + 1), novel.get(acc.get(idAcc).getBookmark().get(i)).getNameNovel(), "|");
        }
        System.out.println("+--------------------------------------------------------------------+");
    }
}
