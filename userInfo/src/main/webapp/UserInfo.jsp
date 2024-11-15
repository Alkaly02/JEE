<%-- 
    Document   : UserInfo
    Created on : 13 nov. 2024, 18:58:50
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User info</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <%
            String nom = request.getParameter("name");
            String age = request.getParameter("age");
            if(nom != null && nom != "" && age != null && age != ""){
        %>
                <p>Prenom : <%= nom %></p>
                <p>Age: <%= age %></p>
        <%
            }
            else{
        %>
                <p>Veuillez reseigner tous les champs</p>
        <%
            }
        %>
    </body>
</html>
