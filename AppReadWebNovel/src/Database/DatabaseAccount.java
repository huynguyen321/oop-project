/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Framework.Account;
import java.util.ArrayList;

/**
 *
 * @author huy.nguyen22
 */
public class DatabaseAccount {
    // khoi tao cac tai khoan

    public static ArrayList<Account> arrAcc() {
        ArrayList<Account> acc = new ArrayList<>();
        ArrayList<Integer> bookmark1 = new ArrayList<>();
        bookmark1.add(0);
        bookmark1.add(1);
        ArrayList<Integer> bookmark2 = new ArrayList<>();
        bookmark2.add(0);
        acc.add(new Account("User1", "12345678", "User", bookmark1));
        acc.add(new Account("User2", "12345678", "User", bookmark1));
        acc.add(new Account("User3", "12345678", "User", bookmark2));
        acc.add(new Account("AdminHuy", "123456789", "Administrator", bookmark1));
        acc.add(new Account("AdminDiem", "123456789", "Administrator", bookmark2));
        acc.add(new Account("EmMo", "12345678", "Translator", bookmark1));
        acc.add(new Account("Roan", "12345678", "Translator", bookmark1));
        acc.get(5).addProject(0);
        acc.get(6).addProject(1);
        return acc;
    }
}
