package Funtion;

import Framework.Novel;
import Framework.StatusAndCategory;
import java.util.ArrayList;

public class SearchByCategory {

    public static void ShowListCategory() {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                         Danh sách thể loại                         |");
        System.out.printf("|              %-2d. %-50s%s\n", 0, "Trở lại", "|");
        for (int i = 0; i < StatusAndCategory.listCategory.length; i++) {
            System.out.printf("|              %-2d. %-50s%s\n", (i + 1), StatusAndCategory.listCategory[i][0], "|");
        }
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static ArrayList<Integer> ChooseCategory(ArrayList<Novel> novel, int idCategory) {
        ArrayList<Integer> searchIdWN = new ArrayList<Integer>();
        for (int i = 0; i < novel.size(); i++) {
            if (novel.get(0).getCategory().indexOf(StatusAndCategory.listCategory[idCategory][0]) > -1) {
                searchIdWN.add(i);
            }
        }
        return searchIdWN;
    }

    public static int ShowResultSearch(ArrayList<Novel> novel, int idCategory) {
        ArrayList<Integer> searchIdWN = ChooseCategory(novel, idCategory);
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.printf("|                            %-11s                             |", StatusAndCategory.listCategory[idCategory][0]);
        System.out.println("\n"+StatusAndCategory.listCategory[idCategory][1]);
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        if (searchIdWN.size() > 0) {
            for (int i = 0; i < searchIdWN.size(); i++) {
                System.out.printf("|              %-2d. %-50s%s\n", (i + 1), novel.get(searchIdWN.get(i)).getNameNovel(), "|");
            }
        } else {
            System.out.println("|            Không có truyện nào thuộc thể loại này!                 |");
        }
        System.out.println("+--------------------------------------------------------------------+");
        return searchIdWN.size();
    }
}
