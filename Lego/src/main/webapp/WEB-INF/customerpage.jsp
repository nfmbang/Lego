<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <center>
            <h1>Hello <%=request.getParameter( "email" )%> <br> Welcome to our site! </h1>

            <jsp:include page="shop.jsp">
                <jsp:param name="shop" value=""/>
            </jsp:include>           
            
                
            <jsp:include page="BoM.jsp">
                <jsp:param name="BoM" value=""/>
            </jsp:include>                
                
        </center
    </body>
</html>
