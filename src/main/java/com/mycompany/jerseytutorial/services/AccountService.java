/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author dannemtanu
 */

public class AccountService {

    public static List<Account> list = new ArrayList<>();
    public static boolean init = true;
    Random rnd = new Random();

    public AccountService() {
        if (init) {
            Account a1 = new Account(4046,"Current",336285,3207.00,8582);
            Account a2 = new Account(5812,"Current",183950,6546.27,5106);
            Account a3 = new Account(1244,"Saving",279509,6646.81,3574);
            Account a4 = new Account(9189,"Saving",878467,351.93,3574);
            Account a5 = new Account(4983,"Saving",167998,7966.90,6303);
            Account a6 = new Account(5351,"Current",276486,2582.08,6772);
            Account a7 = new Account(4932,"Saving",606020,6116.09,5106 );
            Account a8 = new Account(9514,"Saving",565897,3828.32,6772);
            Account a9 = new Account(7252,"Current",514179,3994.79,6772);
            Account a10 = new Account(3545,"Saving",698755,9792.45,8582);
            Account a11 = new Account(5792,"Saving",881603,7404.39,3574);
            Account a12 = new Account(8143,"Current",867843,8999.16,3574);
            Account a13 = new Account(2338,"Saving",688228,5723.26,5106 );
            Account a14 = new Account(6250,"Saving",534059,6841.41,8582);
            Account a15 = new Account(7889,"Current",849764,4387.97,8582);
            Account a16= new Account(7731,"Saving",898749,7021.27,5106 );
            Account a17 = new Account(7652,"Saving",399110,7198.92,5106 );
            Account a18 = new Account(5069,"Current",886994,2209.39,6772);
            Account a19= new Account(6478,"Current",826478,2001.39,5106 );
            Account a20 = new Account(8562,"Saving",759818,4059.02,5106 );
                    
            list.add(a1);
            list.add(a2);
            list.add(a3);
            list.add(a4);
            list.add(a5);
            list.add(a6);
            list.add(a7);
            list.add(a8);
            list.add(a9);
            list.add(a10);
            list.add(a11);
            list.add(a12);
            list.add(a13);
            list.add(a14);
            list.add(a15);
            list.add(a16);
            list.add(a17);
            list.add(a18);
            list.add(a19);
            list.add(a20);
            
            init = false;
        }
    }

    public List<Account> getAllAccounts() {
        return list;
    }

    public List<Account> getCustomerAccounts(int customerId) {
        List<Account> custAccounts = new ArrayList();
        Account temp = new Account();
        for (Account na : getAllAccounts()) {
            int tempID = na.getCustomerId();
            if (tempID == customerId) {
                custAccounts.add(na);
            }
        }
        return custAccounts;
    }

    public Account getAccount(int id) {
        Account temp = new Account();
        for (Account na : getAllAccounts()) {
            int tempID = na.getId();
            if (tempID == id) {
                temp = na;
            }
        }
        return temp;
    }

    public void addAccount(int id, String type, int number, double balance, int customerId) {
        Account newAccount = new Account(id, type, number, balance, customerId);
        list.add(newAccount);
    }

    public Account deleteAccount(int id) {
        Account temp = new Account();
        for (Account na : getAllAccounts()) {
            int tempID = na.getId();
            if (tempID == id) {
                temp = na;
                list.remove(na);
                break;
            }
        }
        return temp;
    }

    public void makeLodgement(int accountId, double newBalance) {
        Account temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            if (accountId == temp.getId()) {
                Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance() + newBalance, temp.getCustomerId());
                list.set(i, updatedAccount);
                break;
            }
        }
    }

    public void makeWithdrawal(int accountId, double newBalance) {
        Account temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            if (accountId == temp.getId()) {
                Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance() - newBalance, temp.getCustomerId());
                list.set(i, updatedAccount);
                break;
            }
        }
    }

    public void makeTransfer(int fromAcc, int toAcc, double newBalance) {
        Account temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            if (fromAcc == temp.getId()) {
                Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance() - newBalance, temp.getCustomerId());
                list.set(i, updatedAccount);
            } else if (toAcc == temp.getId()) {
                Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance() + newBalance, temp.getCustomerId());
                list.set(i, updatedAccount);
            }
        }
    }

}
