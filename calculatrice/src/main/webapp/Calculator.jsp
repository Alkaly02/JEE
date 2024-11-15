<%-- 
    Document   : Calculator
    Created on : 15 nov. 2024, 05:38:34
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <%
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String operation = request.getParameter("operation");
            
//            Validation de num1 et num2
            if(num1 != null && num1 != "" && num2 != null && num2 != "" && operation!= null && operation != ""){
                if(operation.equals("addition")){
        %>
                    <jsp:include page="Add.jsp" flush="true">
                        <jsp:param name="num1" value="<%= num1 %>" />
                        <jsp:param name="num2" value="<%= num2 %>" />
                    </jsp:include>
        <%
                }
                if(operation.equals("soustraction")){
        %>
                    <jsp:include page="Subtract.jsp" flush="true">
                        <jsp:param name="num1" value="<%= num1 %>" />
                        <jsp:param name="num2" value="<%= num2 %>" />
                    </jsp:include>
        <%
                }
                if(operation.equals("multiplication")){
        %>
                    <jsp:include page="Multiplication.jsp" flush="true">
                        <jsp:param name="num1" value="<%= num1 %>" />
                        <jsp:param name="num2" value="<%= num2 %>" />
                    </jsp:include>
        <%
                }
                if(operation.equals("division")){
                    if(Integer.parseInt(num2) != 0){
        %>
                        <jsp:include page="Division.jsp" flush="true">
                            <jsp:param name="num1" value="<%= num1 %>" />
                            <jsp:param name="num2" value="<%= num2 %>" />
                        </jsp:include>
        <%
                    }
                    else{
        %>
                        <p>Division par 0 impossible</p>
        <%
                    }
                }
            }
        %>
    
</html>
