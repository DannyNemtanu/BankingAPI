/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.services.AccountService;
import com.mycompany.jerseytutorial.services.CustomerService;
import java.util.List;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author dannemtanu
 */
@Path("/customer")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CustomerResource {
    
    CustomerService cs = new CustomerService();
    AccountService as = new AccountService();
    Random rnd = new Random();
    
    @GET
    // curl -v -X GET http://localhost:49000/api/customer?id=6772
    public Response getCustomer(@QueryParam("id") int id) {
        Response response;
        if (id > 0) {
            response = Response.status(200).entity(cs.getCustomer(id)).build();
        } else {
            response = Response.status(200).entity(("Follow /api/cusomer?id=xxxxx \nOr /api/customer/all")).build();
        }
        return response;
    }
    
    @GET
    @Path("/all")
    //curl -v -X PUT http://localhost:49000/api/customer/all   
    public List<Customer> getAllCustomers() {
        return cs.getAllCustomers();
    }
    
    @POST
    @Path("/delete")
    // curl -v -X POST http://localhost:49000/api/customer/delete?id=6772
    public Response deleteCustomer(@QueryParam("id") int id) {
        
        cs.deleteCustomer(id);
        return Response.status(200).entity(("Customer Deleted!")).build();
        
    }
    
    @POST
    @Path("/edit")
    // curl -v -X POST http://localhost:49000/api/customer/edit?id=6772&name=Dan N.&address=100A Mulvey Park&email=dan@nemtanu.com&password=123456
    public void updateCustomer(@QueryParam("id") int id,
            @QueryParam("name") String name, @QueryParam("address") String address,
            @QueryParam("email") String email, @QueryParam("password") String password) {
        
            cs.editCustomer(id,name,address,email,password);
    }

    // curl -v -X POST http://localhost:49000/api/customer/create?name=New Customer&address=New Address&email=new@email.com&password=999999
    @POST
    @Path("/create")
    public Response addCustomer(
            @QueryParam("name") String name, @QueryParam("address") String address,
            @QueryParam("email") String email, @QueryParam("password") String password) {
        
        int n = 100000 + rnd.nextInt(900000);
        Customer customer = new Customer();
        customer.setId(n);
        customer.setName(name);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setPassword(password);
        
        cs.addCustomer(customer.getId(), customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPassword());
        
        return Response.status(200).entity(("Customer Created!")).build();
    }
    
    @POST
    @Path("/account")
    //    Create New Account
    //    http://localhost:49000/api/customer/account?id=6772&type=Save
    public Response addCustomerAccount(@QueryParam("id") int id, @QueryParam("type") String type) {
        Account newAccount = new Account();
        int accountID = 100000 + rnd.nextInt(900000);
        int number = 100000 + rnd.nextInt(900000);
        newAccount.setId(accountID);
        newAccount.setType(type);
        newAccount.setNumber(number);
        newAccount.setBalance(0);
        newAccount.setCustomerId(id);
        
        as.addAccount(newAccount.getId(), newAccount.getType(), newAccount.getNumber(), newAccount.getBalance(), newAccount.getCustomerId());
        return Response.status(200).entity(("Account Created!")).build();
    }
    
    @GET
    @Path("/accounts")
    // curl -v -X GET http://localhost:49000/api/customer/accounts?id=6772
    public List<Account> getCustomerAccounts(@QueryParam("id") int id) {
        return as.getCustomerAccounts(id);
    }
    
}
