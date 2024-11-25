<%-- 
    Document   : listeFactures
    Created on : 24 nov. 2024, 20:46:23
    Author     : HP
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="models.Facture" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste facttures</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
                margin: 20px 0;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            thead {
                background-color: #f4f4f4;
                color: #333;
                font-weight: bold;
                text-transform: uppercase;
            }
            tbody tr:nth-child(odd) {
                background-color: #f9f9f9;
            }

            tbody tr:nth-child(even) {
                background-color: #e8f5e9;
            }

        </style>
    </head>
    <body>
        <h1>Liste des factures</h1>
        <table>
            <thead>
                <th>ID</th>
                <th>Nom client</th>
                <th>Prix total</th>
                <th>Date facture</th>
            </thead>
            <tbody>
            <%
                ArrayList<Facture> factures = (ArrayList<Facture>)request.getAttribute("factures");
                if(factures != null){
                    for(Facture facture : factures){
            %>
                    <tr>
                        <td><%=facture.getId()%></td>
                        <td><%=facture.getNomClient()%></td>
                        <td><%=facture.getTotal()%></td>
                        <td><%=facture.getDateFacture()%></td>
                    </tr>
            <%
                    }
                }
                else{
            %>
                    <p>Pas encore de factures</p>
            <%
                }
            %>
        </tbody>
        </table>
    </body>
</html>
