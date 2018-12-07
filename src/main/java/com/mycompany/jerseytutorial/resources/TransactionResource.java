/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Transaction;
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

/**
 *
 * @author dannemtanu
 */
@Path("/transaction")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TransactionResource {

    TransactionService ts = new TransactionService();

    @GET
    public Response getTransaction(@QueryParam("id") int id) {
        return Response.status(200).entity((ts.getTransaction(id))).build();
    }

    // curl -v -X GET http://localhost:49000/api/transactions/1
    @GET
    @Path("/all")
    public List<Transaction> getAllTransactions() {
        return ts.getAllTransactions();
    }

    @POST
    @Path("/lodgement")
    public Response Lodgement(@QueryParam("account") int accountID, @QueryParam("amount") int amount, @QueryParam("description") String description) {
        ts.lodgement(accountID, amount, description);
        return Response.status(200).entity("Lodgement Succesfully!").build();
    }

    @POST
    @Path("/withdrawal")
//    http://localhost:49000/api/transaction/withdrawal?account=14343&amount=50
    public Response Withdrawal(@QueryParam("account") int accountID, @QueryParam("amount") int amount) {
        ts.withdrawal(accountID, amount);
        return Response.status(200).entity("Withdrawal Succesfully!").build();
    }

    @POST
    @Path("/transfer")
//    http://localhost:49000/api/transaction/transfer?from=14343&to=21234&amount=150&desc=From 14343 to 21234
    public Response Transfer(@QueryParam("from") int fromAcc, @QueryParam("to") int toAcc, @QueryParam("amount") int amount, @QueryParam("desc") String description) {
        ts.transfer(fromAcc, toAcc, amount, description);
        return Response.status(200).entity("Transfer Succesfully!").build();
    }
}
