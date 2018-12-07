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


public class AccountService {
    
    public static List<Account> list = new ArrayList<>();
    public static boolean init = true;
    
    public AccountService(){
        if (init) {
        Account a1 = new Account(14343,"Current", 123,200.5,123413);
        Account a2 = new Account(21234,"Saving", 144,300.00,123413);
        
        list.add(a1);
        list.add(a2);
        init = false;
     }
    }
    
    public List<Account> getAllAccounts(){
        return list;
    }
    
    public List<Account> getCustomerAccounts(int customerId) {
        List<Account> custAccounts = new ArrayList();
        Account temp = new Account();
        for(Account na : getAllAccounts()){
            int tempID = na.getCustomerId();
            if (tempID == customerId) {
               custAccounts.add(na);
            }
        }
        return custAccounts;
    }
    
    public Account getAccount(int id) {        
            Account temp = new Account();
            for(Account na : getAllAccounts()){
                int tempID = na.getId();
                if (tempID == id) {
                   temp = na;
                }
            }
            return temp;
    }
    
    public Account deleteAccount(int id) {
        Account temp = new Account();
            for(Account na : getAllAccounts()){
                int tempID = na.getId();
                if (tempID == id) {
                   temp = na;
                   list.remove(na);
                   break;
                }
            }
            return temp;
        }
    
      public void makeLodgement(int accountId,double newBalance){
          Account temp;
            for(int i=0;i<list.size();i++){
                temp = list.get(i);
                if(accountId == temp.getId()){
                    Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance()+newBalance, temp.getCustomerId());
                    list.set(i,updatedAccount);
                    break;
                }
            }
      }
      public void makeWithdrawal(int accountId,double newBalance){
          Account temp;
            for(int i=0;i<list.size();i++){
                temp = list.get(i);
                if(accountId == temp.getId()){
                    Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance()-newBalance, temp.getCustomerId());
                    list.set(i,updatedAccount);
                    break;
                }
            }
      }
      public void makeTransfer(int fromAcc,int toAcc,double newBalance){
          Account temp;
            for(int i=0;i<list.size();i++){
                 temp = list.get(i);
                if(fromAcc == temp.getId()){
                    Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance()-newBalance, temp.getCustomerId());
                    list.set(i, updatedAccount);
                }else if(toAcc == temp.getId()){
                    Account updatedAccount = new Account(temp.getId(), temp.getType(), temp.getNumber(), temp.getBalance()+newBalance, temp.getCustomerId());
                    list.set(i, updatedAccount);
                }
            }
      }
//    public void editAccount(int id, double newBalance){
//        Account temp = new Account();
//            for(int i=0;i<list.size();i++){
//                temp = list.get(i);
//                if(id == temp.getId()){
//                    Account updatedAccount = new Account(id, temp.getType(), temp.getNumber(), newBalance, temp.getCustomerId());
//                    list.set(i,updatedAccount);
//                    break;
//                }
//            }
//        }
//    
//    public void addAccount(String type, int number, double balance, int customerId){
//        Account temp = list.get(list.size()-1);
//        int tempId = temp.getId();
//        
//        
//        Account newAccount = new Account(tempId+1, type, number, balance, customerId);
//        list.add(newAccount);
//    }
}
