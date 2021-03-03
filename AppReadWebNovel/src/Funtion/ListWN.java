package Funtion;

import Framework.Novel;
import java.util.ArrayList;

public class ListWN {

    public static void ShowAllWN(ArrayList<Novel> novel) {
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                          Danh sách truyện                          |");
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        for (int i = 0; i < novel.size(); i++) {
            System.out.printf("|              %d. %-51s%s\n", (i + 1), novel.get(i).getNameNovel(), "|");
        }
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void ShowAllChapter(ArrayList<Novel> novel, int idWN) {
        System.out.println(novel.get(idWN).toString() + "\n");
        System.out.println("+-----------------------Ứng dụng đọc Web Novel-----------------------+");
        System.out.println("|                          Danh sách chương                          |");
        System.out.printf("|              %d. %-51s%s\n", 0, "Trở lại", "|");
        for (int i = 0; i < novel.get(idWN).getChapter().size(); i++) {
            System.out.printf("|              %d. Chapter %-43d%s\n", (i + 1), novel.get(idWN).getChapter().get(i).getNumChap(), "|");
        }
        System.out.println("+--------------------------------------------------------------------+");
    }

    public static void ShowContentChapter(ArrayList<Novel> novel, int idWN, int idChap) {
        System.out.println("   " + novel.get(idWN).getNameNovel() + "\n      Chapter " + novel.get(idWN).getChapter().get(idChap).getNumChap());
        System.out.println(novel.get(idWN).getChapter().get(idChap).getContent());
        System.out.println("\n\n*Nhập số bất kì để quay trở lại");
    }
}
