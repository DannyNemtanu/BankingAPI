/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jerseytutorial.resources;


import com.mycompany.jerseytutorial.model.Account;
import com.mycompany.jerseytutorial.model.Transaction;
import com.mycompany.jerseytutorial.services.AccountService;
import com.mycompany.jerseytutorial.services.TransactionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/account")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class AccountResource {
    AccountService as = new AccountService();
    TransactionService ts = new TransactionService();
    
    
    
    // curl -v -X GET http://localhost:49000/api/account?id=14343
    @GET
    public Response getAccount(@QueryParam("id") int id) {       
       Account temp = as.getAccount(id);
       Response response;
       if(temp != null){
           response =  Response.status(200).entity(temp).build();
       }else{
           response =  Response.status(200).entity("Not Found").build();
       }
       return response;
    }
    
    @GET
    @Path("/all")
    // curl -v -X GET http://localhost:49000/api/account/all
    public List<Account> getAllAccounts(){
        return as.getAllAccounts();
    }
    
    @POST
    @Path("/delete")    
    // curl -v -X POST http://localhost:49000/api/account/delete?id=14343
    public Response deleteAccount(@QueryParam("id") int id) {
       Account temp = as.deleteAccount(id);
       Response response;
       if(temp != null){
           response =  Response.status(200).entity("Account Succesfully Deleted!").build();
       }else{
           response =  Response.status(200).entity("Not Found").build();
       }
       return response;
    }
    @GET
    @Path("/transactions")
    public List<Transaction> getAccountTransactions(@QueryParam("id") int id) {
        return ts.getAccountTransaction(id);
    }

    // curl -v -X PUT http://localhost:49000/api/accounts/editaccount/2/25.50    
//    @POST
//    @Path("/edit")
//        
//        public Response updateAccount(@QueryParam("id") int id,
//            @PathParam("newBalance") double newBalance) {
//            as.editAccount(id, newBalance);
//            System.out.println("Account id: " +id+ " is edited!");
//
//        return Response.status(200).build();
//
//    }
//    
//    // Method to add stuff to the database !!!!
//    // curl -v -X PUT http://localhost:49000/api/accounts/addNewAccount/Savings
//    @POST
//    @Path("/addNewAccount/{type}")
//        
//    public Response addAccount(@PathParam("type") String type) {
//
//        
//        Account account = new Account();
//        account.setType(type);
//        
//        int num = 0;
//        String flo = "";
//        for(int i = 0; i < 9; i++)
//            flo += (int)(Math.random()*10);
//        num = Integer.parseInt(flo);
//        account.setNumber(num);
//        account.setType(type);
//        account.setBalance(0.0);
//        
//        as.addAccount(account.getType(), account.getNumber(), account.getBalance());
//
//        return Response.status(200).build();
//
//    }
    
}
