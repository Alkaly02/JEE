<%-- 
    Document   : Subtract
    Created on : 15 nov. 2024, 19:03:44
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//          Recuperer parametres inclus depuis Calculator.jsp
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
        %>
        
        <h1>Le resultat de la soustraction est : <%= Double.parseDouble(num1) - Double.parseDouble(num2) %></h1>
    </body>
</html>
