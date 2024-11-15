<%-- 
    Document   : Calculator
    Created on : 15 nov. 2024, 18:31:23
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
//            Recuperer les donnees du formulaire
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String operateur = request.getParameter("operateur");
            
//          Validation des champs
            if(num1 != null && !num1.isEmpty() && num2 != null && !num2.isEmpty()){
//            Cas de l'addition
               if(operateur.equals("addition")) {
        %>
                <jsp:include page="Add.jsp" flush="true">
                    <jsp:param name="num1" value="<%= num1 %>" />
                    <jsp:param name="num2" value="<%= num2 %>" />
                </jsp:include>
        <%
               }
//               Cas de la soustraction
                if(operateur.equals("soustraction")){
        %>
                    <jsp:include page="Subtract.jsp" flush="true">
                        <jsp:param name="num1" value="<%= num1 %>" />
                        <jsp:param name="num2" value="<%= num2 %>" />
                    </jsp:include>
        <%
                }
//              Cas de la multiplication
                if(operateur.equals("multiplication")){
        %>
                   <jsp:include page="Multiplication.jsp" flush="true">
                        <jsp:param name="num1" value="<%= num1 %>" />
                        <jsp:param name="num2" value="<%= num2 %>" />
                    </jsp:include>
        <%
                }
//                Cas de la division
                if(operateur.equals("division")){
                    if(Double.parseDouble(num2) != 0){
        %>
                    <jsp:include page="Division.jsp" flush="true">
                        <jsp:param name="num1" value="<%= num1 %>" />
                        <jsp:param name="num2" value="<%= num2 %>" />
                    </jsp:include>
        <%
                    }else{
        %>
                        <p>Division par 0 impossible</p>
        <%
                    }
                }
            }
            else{
        %>
                <p style="color: red;">Veuillez renseigner tous les champs</p>
        <%
            }
        %>
    </body>
</html>
