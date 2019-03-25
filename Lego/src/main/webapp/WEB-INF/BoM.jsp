<%-- 
    Document   : BoM
    Created on : 25-Mar-2019, 05:19:19
    Author     : nille
--%>
<%@page import = "Logic.BillDTO" %>
<%@page import = "Presentation.orderHistory" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History</title>
        <style>
         table, th, td {
            border: 1px solid black;
         }
         </style>
         
         <% new orderHistory().execute(request,response);
           BillDTO[] bills =(BillDTO[]) session.getAttribute("bills");
         %>
    </head>
    <body>
        <h1> Order History </h1>
        <form>
            <table>
               <tr>
                  <th>Order</th>
                  <th>Bill of Materials</th>
               </tr>
               <tr>
                    <%
                        for(BillDTO b: bills){
                    %>
                        <td><%=b.getOrder().getCustomerNo()%> </td>  
                    <%                      
                    %>
                    <td>
                        <%=b.getBill().get("2x4")%><br>   
                        <%=b.getBill().get("2x2")%><br>
                        <%=b.getBill().get("2x1")%><br>
                    </td>
                    <%
                        }
                    %>
               </tr>
            </table>
        </form>
            
    </body>
</html>
