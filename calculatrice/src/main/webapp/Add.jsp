<%-- 
    Document   : Add
    Created on : 15 nov. 2024, 05:50:14
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

            Integer somme = Integer.parseInt(num1) + Integer.parseInt(num2);
        %>
        <h1>La somme de <%= num1 %> et <%= num2 %> font <%= somme %></h1>
    </body>
</html>
