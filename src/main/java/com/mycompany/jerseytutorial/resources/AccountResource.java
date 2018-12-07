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
}
