/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lka.factures;

import dao.FactureDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import metier.FactureMetier;
import models.Facture;
import models.Produit;

/**
 *
 * @author HP
 */
@WebServlet(name = "Facture", urlPatterns = {"/index"})
public class FactureController extends HttpServlet {
    private FactureDao factureDao;
    
    @Override
    public void init(){
        factureDao = new FactureDao();
    }

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
        List<Facture> factures = new ArrayList<>();
//      Recuperation des factures
        factures = factureDao.getAll();
//      set request
        request.setAttribute("factures", factures);
//      Transfert de la requete vers la vue
        RequestDispatcher dispatcher = request.getRequestDispatcher("listeFactures.jsp");
        dispatcher.forward(request, response);
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
        String nomClient = request.getParameter("nom_client");
        String dateFacture = request.getParameter("date_facture");
        
        String[] nomsProduits = request.getParameterValues("nom_produit[]");
        String[] prixProduits = request.getParameterValues("prix_produit[]");
        
        List<Produit> produits = new ArrayList();
        
        if(nomsProduits != null && prixProduits != null){
            for(int i = 0; i < nomsProduits.length; i++){
                String nomProduit = nomsProduits[i];
                Double prixProduit = Double.valueOf(prixProduits[i]);
                produits.add(new Produit(nomProduit, prixProduit));
            }
//          Calculer le prix total
            FactureMetier metier = new FactureMetier();
            Double prixTotal = metier.calculerPrixTotal(produits);
//          Creer une nouvelle facture
            Facture facture = new Facture(nomClient, dateFacture, produits, prixTotal);
//            Sauvegarde de la facture
            factureDao.save(facture);
//            Appeler do get
            doGet(request, response);
//          Sauvegarder dans la base de donnees
        }else{
            System.out.println("Hello");
        }
        
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
