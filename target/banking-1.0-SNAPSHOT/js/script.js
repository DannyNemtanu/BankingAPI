/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var customerID;

function registerAccount() {
    var fname = $("#full-name").val();
    var address = $("#add1").val() + ", " + $("#add2").val() + ", " + $("#add3").val();
    var eamil = $("#email").val();
    var pass = $("#pass").val();
    var cpass = $("#c_password").val();

    var url = "/api/customer/create?name=" + fname + "&address=" + address + "&email=" + email + "&password=" + pass;
    $.post(url, function (data) {
        console.log(data);
        alert("Account Created");
    });

}
$("#formsubmit").click(function () {
    registerAccount();
    $.get("/api/customer/all", function (data) {
        console.log(data);
        alert("Load was performed.");
    });
});

function loadAccounts() {
    $("#loadAccounts").addClass("disabled");
    $.get("/api/account/all", function (data) {
        var account = $(data).find("account").filter(function(){
              var id = $('id', this).text();
              var type = $('type', this).text();
              var sortCode = $('number', this).text();
              var balance = $('balance', this).text();
              $("#accountHTML").append(
                    '<tr>'+
                        '<th scope="row" id="showAccID">'+id+'</th>'+
                        '<td id="showAccType">'+type+'</td>'+
                        '<td id="showAccSortCode">'+sortCode+'</td>'+
                        '<td id="showAccBalance">'+balance+'</td>'+
                        '<td><button type="button" id="showTransactions" class="w-100 btn btn-primary">Show</button></td>'+
                        '<td><button type="button" id="deleteAccount" class="w-100 btn btn-danger">Delete</button></td>'+
                    '</tr>'
                );
              console.log("id: "+id+ "\ntype:"+type+"\nnumber:"+sortCode+"\nbalance:"+balance);
          });   
    });
 };

$("#login").click(function (e) {
    e.preventDefault();
    customerID = $("#customerID").val();
    var pass = $("#customerPassword").val();
    $(location).attr('href', 'http://localhost:49000/customer_main.html');
});