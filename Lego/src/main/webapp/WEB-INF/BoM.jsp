<%-- 
    Document   : BoM
    Created on : 25-Mar-2019, 05:19:19
    Author     : nille
--%>
<%@page import="Logic.OrderDTO"%>
<%@page import="Logic.User"%>
<%@page import="Presentation.FrontController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logic.BillDTO" %>
<%@page import="Presentation.orderHistory" %>
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
           //ArrayList<BillDTO> bills = (ArrayList<BillDTO>) session.getAttribute("bills");
           ArrayList<BillDTO> bills = FrontController.getHistory(((User)session.getAttribute("user")).getId());
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
                <% for(BillDTO b: bills){%>
               <tr>
                   <%OrderDTO o = b.getOrder();%>
                   <td>
                       Order id:<%=o.getOrderId()%><br>
                       Date:<%=o.getDate()%><br>
                       Dimensions:(x,y,z)<%=o.getLength()%>,<%=o.getWidth()%>,<%=o.getHeight()%>
                   </td>
                   <td>
                       Bill id:<%=b.getBillId()%><br>
                       2x4:<%=b.getA()%><br>
                       2x2:<%=b.getB()%><br>
                       2x1:<%=b.getC()%>
                   </td>
                    
               </tr>
               <%}%>
            </table>
        </form>
            
    </body>
</html>
