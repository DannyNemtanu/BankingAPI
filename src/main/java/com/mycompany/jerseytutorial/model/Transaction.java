/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction{
    private int id;
    private String type;
    private String description;
    private double amount;

    public Transaction() {
    }

    public Transaction(int id, String type, String description, double amount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    public Transaction(int i, String dan_Nemtanu, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    

}
