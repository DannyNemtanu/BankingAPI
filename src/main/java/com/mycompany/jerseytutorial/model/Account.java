/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account{
    
    private int id;
    private String type;
    private int number;
    private double balance;
    private ArrayList<Transaction> transactions;
    
    public Account(){
        transactions = new ArrayList<>();
    }
    
    public Account(int id, String type, int number, double balance){
        this.id = id;
        this.type = type;
        this.number = number;
        this.balance = balance;
        transactions = new ArrayList<>();
    }
    
    public Account(int id, String type, int number){
        this.id = id;
        this.type = type;
        this.number = number;
        transactions = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

}
