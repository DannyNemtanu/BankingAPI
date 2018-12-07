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
    Random rnd = new Random();
    
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
        for(Customer nc : getAllCustomers()){
            int tempID = nc.getId();
            if (tempID == id) {
               temp = nc;
               break;
            }
        }
        return temp;
    }
    
    public void deleteCustomer(int id) {
        for(Customer nc : getAllCustomers()){
            if (nc.getId() == id) {
               cust.remove(nc);
               break;
            }
        }
    }

    public void editCustomer(int id, String name, String email, String address, int password){
        Customer temp;
        int tempId = 0;
        for(int i = 0; i<cust.size();i++){
            temp = cust.get(i);
            tempId = temp.getId();
            if(id == tempId){
                if(!name.isEmpty()){
                    temp.setName(name);
                }
                if(!email.isEmpty()){
                    temp.setEmail(email);
                }
                if(!address.isEmpty()){
                    temp.setEmail(email);
                }
                if(password > 0){
                    temp.setPassword(password);
                }
                
                Customer updatedCustomer = new Customer(temp.getId(),temp.getName(),temp.getAddress(),temp.getEmail(),temp.getPassword());
                cust.set(i, updatedCustomer);
            }
        }
    }
 
    public void addCustomer(int id,String name, String address, String email, int password){
        Customer newCustomer = new Customer(id, name, address, email, password);
        cust.add(newCustomer);
    }
}
