/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.services;


import com.mycompany.jerseytutorial.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class CustomerService {
    public static ArrayList<Customer> cust = new ArrayList<>();
    public static boolean init = true;
    

    
    
    
    public CustomerService(){
        if(init){
        Customer c1 = new Customer(123413,"Dan Nemtanu","Sample Address","dan@email.com",1234);
        Customer c2 = new Customer(412312,"Jordan Cogan","Sample Addr 2","jordan@email.com",1222);        
        Customer c3 = new Customer(521321,"Test Test","Sample Addr 3","test@email.com",1333);        
        
        cust.add(c1);
        cust.add(c2);
        cust.add(c3);
        init=false;
        }
    }
    public List<Customer> getAllCustomers() {
        return cust;
    }
    public int getLength(){
        return cust.size();
    }
    public Customer getCustomer(int id) {
        Customer temp = new Customer();
        int tempId = 0;
        for(int i = 0; i<cust.size();i++){
            temp = cust.get(i);
            tempId = temp.getId();
            if(id == tempId){
                temp = cust.get(i);
                break;
            }else{
                temp = null;
            }
        }
        return temp;
    }
    
    public void deleteCustomer(int id) {
        Customer temp;
        int tempId = 0;
        for(int i = 0; i<cust.size();i++){
            temp = cust.get(i);
            tempId = temp.getId();
            if(id == tempId){
                cust.remove(i);
                break;
            }else{
                temp = null;
            }
        }
    }

    public void editCustomer(int id, int password){
        Customer temp;
        int tempId = 0;
        for(int i = 0; i<cust.size();i++){
            temp = cust.get(i);
            tempId = temp.getId();
            if(id == tempId){
                String name = temp.getName();
                String address = temp.getAddress();
                String email = temp.getEmail();
                Customer updatedCustomer = new Customer(id,name,address,email,password);
                cust.set(i, updatedCustomer);
                break;
            }else{
                temp = null;
            }
        }
    }
 
    public void addCustomer(int id,String name, String address, String email, int password){
        
        Customer newCustomer = new Customer(id, name, address, email, password);
        cust.add(newCustomer);
    }
}
