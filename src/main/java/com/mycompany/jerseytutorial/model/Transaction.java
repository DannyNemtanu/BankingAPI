/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author dannemtanu
 */
@XmlRootElement
public class Transaction{
    private int id;
    private String type; //Lodgement - Transfer - Withdrawal
    private String description; //Transaction Name
    private Date date;
    private double amount;
    private int fromAccount;
    private int toAccount;
    
    public Transaction() {
    }

    public Transaction(int id, String type, String description, double amount, Date date, int toAccount,int fromAccount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = new Date();
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }
    
}
