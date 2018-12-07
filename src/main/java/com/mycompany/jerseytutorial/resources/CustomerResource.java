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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class CustomerResource {
    CustomerService cs = new CustomerService();
    AccountService as = new AccountService();
    Random rnd = new Random();
    
    @GET
    // curl -v -X GET http://localhost:49000/api/customer?id=123413
    public Response getCustomer(@QueryParam("id") int id) {
           Response response;
           if(id>0){
               response = Response.status(200).entity(cs.getCustomer(id)).build();
           }else{
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
    // curl -v -X POST http://localhost:49000/api/customer/delete?id=123413
    public Response deleteCustomer(@QueryParam("id") int id) {
        
        cs.deleteCustomer(id);
        return Response.status(200).entity(("Customer Deleted!")).build();
        
    }

    
    @POST
    @Path("/edit")
    // curl -v -X POST http://localhost:49000/api/customer/edit?id=123413&name=Dan N.&address=100A Mulvey Park&email=dan@nemtanu.com&password=123456
    public Response updateCustomer(@QueryParam("customerId") int id,
        @QueryParam("name") String name,@QueryParam("address") String address,
        @QueryParam("email") String email, @QueryParam("password") int password) {
        cs.editCustomer(id,name,address,email,password);
        return Response.status(200).entity(("Customer Edited!")).build();
    }
//    // curl -v -X POST http://localhost:49000/api/customer/create?name=New Customer&address=New Address&email=new@email.com&password=999999
    @POST
    @Path("/create")
    public Response addCustomer(
        @QueryParam("name") String name,@QueryParam("address") String address,
        @QueryParam("email") String email, @QueryParam("password") int password) {
        
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

    @GET
    @Path("/accounts")
    public List<Account> getCustomerAccounts(@QueryParam("id") int id) {
        return as.getCustomerAccounts(id);
    }
}
