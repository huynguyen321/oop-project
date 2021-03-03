package Funtion;

import Framework.Novel;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {

    public static ArrayList<Integer> Search(ArrayList<Novel> novel) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> searchIdWN = new ArrayList<Integer>();
        System.out.println("Nhập tên truyện cần tìm: ");
        String nameToSearch = sc.nextLine();
        for (int i = 0; i < novel.size(); i++) {
            if ((novel.get(i).getNameNovel().toLowerCase()).indexOf(nameToSearch.toLowerCase()) > -1) {
                searchIdWN.add(i);
            }
        }
        return searchIdWN;
    }

    public static int ShowResultSearch(ArrayList<Novel> novel) {
        ArrayList<Integer> searchIdWN = Search(novel);
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                               Tìm kiếm                             |");
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        if (searchIdWN.size() > 0) {
            for (int i = 0; i < searchIdWN.size(); i++) {
                System.out.printf("|              %-2d. %-50s%s\n", (i + 1), novel.get(searchIdWN.get(i)).getNameNovel(), "|");
            }
        }else System.out.println("|            Không tìm thấy truyện!                                  |");
        System.out.println("+--------------------------------------------------------------------+");
        return searchIdWN.size();
    }
}
