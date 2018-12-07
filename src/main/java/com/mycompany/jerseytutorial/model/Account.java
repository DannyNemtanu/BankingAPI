/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account{
    
    private int id;
    private String type; //Saving - Current
    private int number;
    private double balance;
    private int customerId;
    
    public Account(){
       
    }

    public Account(int id, String type, int number, double balance, int customerId) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.balance = balance;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
