/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.services;

import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author dannemtanu
 */
public class CustomerService {

    public static ArrayList<Customer> cust = new ArrayList<>();
    AccountService as = new AccountService();
    public static boolean init = true;
    Random rnd = new Random();

    public CustomerService() {
        if (init) {
            Customer c1 = new Customer (6772,"Liberty Dale","7937 Arcu. Avenue","Nullam@Morbisit.co.uk",311);
            Customer c2 = new Customer(6303,"Orlando Emerson","P.O. Box 754, 8626 Mattis Avenue","bibendum@eratvel.co.uk",425);
            Customer c3 = new Customer(3574,"McKenzie Whitaker","4342 Augue St.","adipiscing.ligula@nibhAliquamornare.net",929);
            Customer c4 = new Customer(8582,"Cedric Clemons","1822 Litora Road","arcu.iaculis@eleifend.com",970);
            Customer c5 = new Customer(5106,"Marshall Weaver","P.O. Box 759, 725 Cursus Rd.","nibh.lacinia.orci@fringillamilacinia.ca",609);
            

            cust.add(c1);
            cust.add(c2);
            cust.add(c3);
            cust.add(c4);
            cust.add(c5);
            init = false;
        }
    }

    public List<Customer> getAllCustomers() {
        return cust;
    }

    public int getLength() {
        return cust.size();
    }

    public Customer getCustomer(int id) {
        Customer temp = new Customer();
        for (Customer nc : getAllCustomers()) {
            int tempID = nc.getId();
            if (tempID == id) {
                temp = nc;
                break;
            }
        }
        return temp;
    }

    public void deleteCustomer(int id) {
        for (Customer nc : getAllCustomers()) {
            if (nc.getId() == id) {
                cust.remove(nc);
                break;
            }
        }
    }

    public void editCustomer(int id, String name, String address, String email, int password) {
        Customer temp = new Customer();
        for (Customer nc : getAllCustomers()) {
            if (nc.getId() == id) {
                temp.setId(id);
                if (name != null) {
                    temp.setName(name);
                }
                if (address != null) {
                    temp.setAddress(address);
                }
                if (email != null) {
                    temp.setEmail(email);
                }
                if (password > 0) {
                    temp.setPassword(password);
                }
                Customer editCustomer = new Customer(temp.getId(),temp.getName(),temp.getAddress(),temp.getEmail(),temp.getPassword());
                cust.remove(nc);
                cust.add(editCustomer);
                break;
            }
        }
    }

    public void addCustomer(int id, String name, String address, String email, int password) {
        Customer newCustomer = new Customer(id, name, address, email, password);
        cust.add(newCustomer);
    }
}
