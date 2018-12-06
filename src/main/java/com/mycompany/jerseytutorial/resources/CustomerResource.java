/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Customer;
import com.mycompany.jerseytutorial.services.CustomerService;
import java.util.List;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class CustomerResource {
    CustomerService cs = new CustomerService();
    Random rnd = new Random();
    
    @GET
    public List<Customer> getAllCustomers() {
       return cs.getAllCustomers();
    }
    // curl -v -X GET http://localhost:49000/api/customers/1
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
       return cs.getCustomer(id);
    }
//     curl -v -X PUT http://localhost:49000/api/customers/delcus/2    
    @PUT
    @Path("/delcus/{customerId}")    
    public Response deleteCustomer(@PathParam("customerId") int id) {
        cs.deleteCustomer(id);
        return Response.status(200).entity(("Customer Deleted!")).build();
    }
//    // curl -v -X PUT http://localhost:49000/api/customers/editcust/2/4321    
    
    @POST
    @Path("/editcust/{customerId}/{newPassword}")
    public Customer updateCustomer(@PathParam("customerId") int id,
        @PathParam("newPassword") int password) {
        
        cs.editCustomer(id, password);
        Customer cust = cs.getCustomer(id);
        return cust;
    }
//    // curl -v -X PUT http://localhost:49000/api/customers/addNewCustomer/Javier/1234
    @POST
//    @Path("/addNewCustomer/{name}/{address}/{email}/{password}")
    @Path("/addNewCustomer/{name}/{address}/{email}/{password}")
    public Response addCustomer(@PathParam("name") String name, @PathParam("address") String address,
            @PathParam("email") String email, @PathParam("password") int password) {
        
        int n = 100000 + rnd.nextInt(900000);
        Customer customer = new Customer();
        customer.setId(n);
        customer.setName(name);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setPassword(password);
        
        cs.addCustomer(customer.getId(), customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPassword());
        
        return Response.status(200).build();
    }

}
