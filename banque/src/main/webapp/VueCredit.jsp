<%-- 
    Document   : VueVredit
    Created on : 29 oct. 2024, 20:06:51
    Author     : Alkaly
--%>

<%@page import="models.CreditModel"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%
    CreditModel creditModel = (CreditModel)request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calcule credit</title>
    </head>
    <body>
        <div>
            <form action="calculer" method="POST">
                <div class="form--row">
                    <label for="montant">Montant</label>
                    <input type="text" name="montant" value="<%=creditModel.getMontant()%>" id="montant" placeholder="en DH" />
                </div>
                <div class="form--row">
                    <label for="taux">Taux</label>
                    <input type="text" name="taux" value="<%=creditModel.getTaux()%>" id="taux" />
                </div>
                <div class="form--row">
                    <label for="duree">Duree</label>
                    <input type="text" name="duree" value="<%=creditModel.getDuree()%>" id="duree" placeholder="en mois" />
                </div>
                <button type="submit">Calculer</button>
            </form>
        </div>
        <div>
            Mensualite = <%= creditModel.getMensualite() %>
        </div>
    </body>
</html>
