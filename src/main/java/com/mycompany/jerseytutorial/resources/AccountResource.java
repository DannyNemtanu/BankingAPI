/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.resources;


import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.services.AccountService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/accounts")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class AccountResource {
    AccountService as = new AccountService();
    
    @GET
    public List<Account> getAllAccounts(){
        return as.getAllAccounts();
    }
    
    // curl -v -X GET http://localhost:49000/api/accounts/1
    @GET
    @Path("/{accountId}")
    public Account getAccount(@PathParam("accountId") int id) {       
       return as.getAccount(id);
    }
    // curl -v -X PUT http://localhost:49000/api/accounts/delacc/3    
    @POST
    @Path("/delacc/{accountId}")    
    public Response deleteAccount(@PathParam("accountId") int id) {
        as.deleteAccount(id);
        //return Response.status(200).entity(gson.toJson(m1)).build();
        return Response.status(200).build();
    }
    
    // Method to change stuff in the database !!!!
    // curl -v -X PUT http://localhost:49000/api/accounts/editaccount/2/25.50    
    @POST
    @Path("/editaccount/{accountId}/{newBalance}")
        
        public Response updateAccount(@PathParam("accountId") int id,
            @PathParam("newBalance") double newBalance) {
        as.editAccount(id, newBalance);
        System.out.println("Account id: " +id+ " is edited!");

        return Response.status(200).build();

    }
    
    // Method to add stuff to the database !!!!
    // curl -v -X PUT http://localhost:49000/api/accounts/addNewAccount/Savings
    @POST
    @Path("/addNewAccount/{type}")
        
    public Response addAccount(@PathParam("type") String type) {

        
        Account account = new Account();
        account.setType(type);
        
        int num = 0;
        String flo = "";
        for(int i = 0; i < 9; i++)
            flo += (int)(Math.random()*10);
        num = Integer.parseInt(flo);
        account.setNumber(num);
        account.setType(type);
        account.setBalance(0.0);
        
        as.addAccount(account.getType(), account.getNumber(), account.getBalance());

        return Response.status(200).build();

    }
    
}
