/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Facture;

/**
 *
 * @author HP
 */
@WebServlet(name = "AjouterFactureServlet", urlPatterns = {"/ajouterFacture"})
public class AjouterFactureServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Initialisation du total produit
          Double totalPrixFacture = 0.0;
//        Recuperation des informations sur la facture
        String nomClient = request.getParameter("nom_client");
        String dateFacture = request.getParameter("date_facture");
        
        List<String> produits = new ArrayList<>();
        List<Double> prixProduits = new ArrayList<>();
        
        for(int i = 1; i <= 3; i++){
            String produit = request.getParameter("produit"+i);
            String prixProduit = request.getParameter("prix"+i);
//            Verifier si les champs ne sont pas vides
            if(produit != null && !produit.isEmpty()  && prixProduit != null && !prixProduit.isEmpty()){
                produits.add(produit);
                prixProduits.add(Double.valueOf(prixProduit));
            }
        }
//      calculer le total de la facture
        for(Double prix : prixProduits){
            totalPrixFacture += prix;
        }
        
//      Creer une nouvelle instance de facture
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
