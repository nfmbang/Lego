<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : Niels Bang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        
    <center>
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <center>
                        <input type="hidden" name="command" value="login">
                        Please log in:<br>
                        <input type="text" name="email" placeholder="Email" required>
                        <br><br>
                        <input type="password" name="password" placeholder="Password" required>
                        <br>
                        <input type="submit" value="Submit">
                        </center>
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <center>
                        <input type="hidden" name="command" value="register">
                        Please enter information for registration:<br>                        
                        <input type="email" name="email" placeholder="Your email here" required>
                        <br><br>                       
                        <input type="password" name="password1" placeholder="Desired password here" required>
                        <br><br>                       
                        <input type="password" name="password2" placeholder="Desired password again" required>
                        <br><br>
                        <input type="submit" value="Submit">
                        </center>
                    </form>
                </td>
            </tr>
        </table>
    
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
        </center>
    </body>
</html>
