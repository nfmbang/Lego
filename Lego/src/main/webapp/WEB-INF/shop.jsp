<%-- 
    Document   : shop
    Created on : 24-Mar-2019, 10:06:20
    Author     : nille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    
    <body>    
    <center>
        <h4>Please enter  your construction requirements: </h4>
        <form name="bill" action="FrontController" method="POST">
            <input type="hidden" name="command" value="AddOrder">
            <input type="number" name="length" placeholder="Length" min="2" required><br>
            <input type="number" name="width" placeholder="Width" min="2" required><br>
            <input type="number" name="height" placeholder="Height" min="1" required><br>
            <input type="submit" name="Submit">            
        </form>
    </center>
    </body>
</html>
