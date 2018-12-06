/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.services;


import com.mycompany.jerseytutorial.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    
    List<Transaction> list = new ArrayList<>();
    public static boolean init = true;
    int length;
    
    public TransactionService(){
        if (init) {
        Transaction t1 = new Transaction(1,"Debit", "Debit transaction", 200.5);
        Transaction t2 = new Transaction(2,"Credit","Credit Transaction", 300.00);        
        
        list.add(t1);
        list.add(t2);
        init = false;
     }
    }
    
    public List<Transaction> getAllTransactions() {
        return list;
    }
    
    public Transaction getTransaction(int id) {
        Transaction test = list.get(id-1);
            return test;
    }
    public int getLength(){
        return length;
    }
    
    public void deleteTransaction(int id) {
        Transaction test = list.get(id-1);
        if (test !=null) {
            list.remove(id);
        }
    }
    
    public void addTransaction(int id, String type, String description, double amount){
        Transaction test = list.get(id-1);
        Transaction newTransaction = new Transaction(id, type, description, amount);
        if (test != null) {
            System.out.println("No transaction found");
        }
        list.add(newTransaction);
    }
}
