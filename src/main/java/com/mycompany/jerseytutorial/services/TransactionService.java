/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dannemtanu
 */
public class TransactionService {

    AccountService as = new AccountService();
    public static List<Transaction> list = new ArrayList<>();
    public static boolean init = true;
    int length;

    public TransactionService() {
        if (init) {
            
            Transaction t1 = new Transaction(1,"Lodgement","adipiscing",682.09,new Date(),5812,0);
            Transaction t2 = new Transaction(2,"Lodgement","justo sit amet",555.87,new Date(),8562,0);
            Transaction t3 = new Transaction(3,"Lodgement","fermentum arcu",7422.99,new Date(),6250,0);
            Transaction t4 = new Transaction(4,"Lodgement","metus sit amet",9963.80,new Date(),5812,0);
            Transaction t5 = new Transaction(5,"Lodgement","ultrices sit",7318.96,new Date(),7652,0);
            Transaction t6 = new Transaction(6,"Lodgement","fringilla purus mauris",9843.23,new Date(),4046,0);
            Transaction t7 = new Transaction(7,"Lodgement","lacinia orci",3008.98,new Date(),7889,0);
            Transaction t8 = new Transaction(8,"Lodgement","imperdiet ullamcorper",9076.57,new Date(),7252,0);
            Transaction t9 = new Transaction(9,"Lodgement","Nam consequat dolor",3060.59,new Date(),2338,0);
            Transaction t10 = new Transaction(10,"Lodgement","imperdiet dictum magna",9213.82,new Date(),8562,0);
            Transaction t11 = new Transaction(11,"Transfer","ligula",5248.89,new Date(),4983,2338);
            Transaction t12 = new Transaction(12,"Transfer","dictum magna",5826.14,new Date(),7652,9514);
            Transaction t13 = new Transaction(13,"Transfer","elementum",8038.99,new Date(),9189,4046);
            Transaction t14 = new Transaction(14,"Transfer","a, enim. Suspendisse",6267.09,new Date(),5351,6250);
            Transaction t15 = new Transaction(15,"Transfer","eros",8855.42,new Date(),4983,5069);
            Transaction t16 = new Transaction(16,"Transfer","Morbi accumsan laoreet",7750.12,new Date(),7731,5351);
            Transaction t17 = new Transaction(17,"Transfer","mauris sit",531.24,new Date(),4932,5812);
            Transaction t18 = new Transaction(18,"Transfer","libero nec",2492.47,new Date(),2338,5792);
            Transaction t19 = new Transaction(19,"Transfer","urna justo",1533.85,new Date(),2338,2338);
            Transaction t20 = new Transaction(20,"Transfer","parturient montes,",6276.09,new Date(),9514,5351);
            Transaction t21 = new Transaction(22,"Withdrawal","Empty",5752.72,new Date(),0,4983);
            Transaction t22 = new Transaction(23,"Withdrawal","Empty",8857.44,new Date(),0,6478);
            Transaction t23 = new Transaction(24,"Withdrawal","Empty",9108.18,new Date(),0,5069);
            Transaction t24 = new Transaction(25,"Withdrawal","Empty",3843.47,new Date(),0,7652);
            Transaction t25 = new Transaction(26,"Withdrawal","Empty",1451.65,new Date(),0,8143);
            Transaction t26 = new Transaction(27,"Withdrawal","Empty",5946.53,new Date(),0,5792);
            Transaction t27 = new Transaction(28,"Withdrawal","Empty",9033.17,new Date(),0,4046);
            Transaction t28 = new Transaction(29,"Withdrawal","Empty",9735.63,new Date(),0,8143);
            Transaction t29 = new Transaction(30,"Withdrawal","Empty",8813.98,new Date(),0,7889);
            Transaction t30 = new Transaction(31,"Withdrawal","Empty",9694.96,new Date(),0,4046);
            list.add(t1);
            list.add(t2);
            list.add(t3);
            list.add(t4);
            list.add(t5);
            list.add(t6);
            list.add(t7);
            list.add(t8);
            list.add(t9);
            list.add(t10);
            list.add(t11);
            list.add(t12);
            list.add(t13);
            list.add(t14);
            list.add(t15);
            list.add(t16);
            list.add(t17);
            list.add(t18);
            list.add(t19);
            list.add(t20);
            list.add(t21);
            list.add(t22);
            list.add(t23);
            list.add(t24);
            list.add(t25);
            list.add(t26);
            list.add(t27);
            list.add(t28);
            list.add(t29);
            list.add(t30);
            init = false;
        }
    }

    public List<Transaction> getAllTransactions() {
        return list;
    }

    public Transaction getTransaction(int id) {
        Transaction temp = new Transaction();
        for (Transaction nt : getAllTransactions()) {
            int tempID = nt.getId();
            if (tempID == id) {
                temp = nt;
                break;
            }
        }
        return temp;
    }

    public List<Transaction> getAccountTransaction(int accountId) {
        List<Transaction> accT = new ArrayList();
        for (Transaction nt : getAllTransactions()) {
            int tempToID = nt.getToAccount();
            int tempFromID = nt.getFromAccount();
            if (tempToID == accountId || tempFromID == accountId) {
                accT.add(nt);
            }
        }
        return accT;
    }

    public int getLength() {
        return length;
    }

    public void lodgement(int toAccount, double amount, String desciption) {
        Transaction newTrasaction = new Transaction(list.size() + 1, "Lodgement", desciption, amount, new Date(), toAccount, 0);
        as.makeLodgement(toAccount, amount);
        list.add(newTrasaction);

    }

    public void transfer(int fromAcc, int toAcc, double amount, String description) {
        Transaction newTrasaction = new Transaction(list.size() + 1, "Transfer", description, amount, new Date(), toAcc, fromAcc);
        as.makeTransfer(fromAcc, toAcc, amount);
        list.add(newTrasaction);
    }

    public void withdrawal(int fromAccount, double amount) {
        Transaction newTrasaction = new Transaction(list.size() + 1, "Withdrawal", "Empty", amount, new Date(), 0, fromAccount);
        as.makeWithdrawal(fromAccount, amount);
        list.add(newTrasaction);
    }
}
