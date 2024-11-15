<%-- 
    Document   : Multiplication
    Created on : 15 nov. 2024, 06:12:21
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
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");

            Integer multiplication = Integer.parseInt(num1) * Integer.parseInt(num2);
        %>
        <h1>La multiplication de <%= num1 %> et <%= num2 %> est de <%= multiplication %></h1>
    </body>
</html>
