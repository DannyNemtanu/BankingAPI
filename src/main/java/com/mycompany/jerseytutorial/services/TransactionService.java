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
            Transaction t1 = new Transaction(1, "Lodgement", "Christmas", 200.5, new Date(), 14343, 0);
            Transaction t2 = new Transaction(2, "Lodgement", "Holiday", 300.00, new Date(), 14343, 0);
            Transaction t3 = new Transaction(3, "Transfer", "Holiday", 300.00, new Date(), 21234, 14343);

            list.add(t1);
            list.add(t2);
            list.add(t3);
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
