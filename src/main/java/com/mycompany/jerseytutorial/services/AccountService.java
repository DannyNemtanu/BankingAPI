/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.model.Account;
import java.util.ArrayList;
import java.util.List;


public class AccountService {
    
    public static List<Account> list = new ArrayList<>();
    public static boolean init = true;
    
    public AccountService(){
        if (init) {
        Account a1 = new Account(1,"Debit", 123,122.00);
        Account a2 = new Account(2,"Credit", 144,132.00);        
        
        list.add(a1);
        list.add(a2);
        init = false;
     }
    }
    public List<Account> getAllAccounts() {
        return list;
    }
    
    public Account getAccount(int id) {        
            return list.get(id-1);
    }
    public int getLength(){
        return list.size();
    }
    
    public String deleteAccount(int id) {
        Account temp = list.get(id-1);
        if(temp != null){
            list.remove(temp);
            return "Account Deleted";
        }else{
            return "Account not found!";
        }
    }
    
    public void editAccount(int id, double newBalance){
            Account temp = list.get(id-1);
            if(temp != null){
                String type = temp.getType();
                int number = temp.getNumber();
                Account updatedAccount = new Account(id-1, type, number, newBalance);
                list.set(id-1, updatedAccount);
            }
        }
    
    public void addAccount(String type, int number, double balance){
        Account temp = list.get(list.size()-1);
        int tempId = temp.getId();
        
        
        Account newAccount = new Account(tempId+1, type, number, balance);
        list.add(newAccount);
    }
}
