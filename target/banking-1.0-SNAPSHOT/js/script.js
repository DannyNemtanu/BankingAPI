/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
alert("JS");
function registerAccount() {
    var fname = $("#full-name").val();
    var address = $("#add1").val() + ", " + $("#add2").val() + ", " + $("#add3").val();
    var eamil = $("#email").val();
    var pass = $("#pass").val();
    var cpass = $("#c_password").val();
    
    var url = "/api/customer/create?name="+fname+"&address="+address+"&email="+email+"&password="+pass;
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