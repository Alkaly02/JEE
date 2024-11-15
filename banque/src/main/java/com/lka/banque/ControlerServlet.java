/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lka.banque;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetierImplementation;
import metier.ICreditMetier;
import models.CreditModel;

/**
 *
 * @author HP
 */
@WebServlet(name = "ControlerServlet", urlPatterns = {"/calculer"})
public class ControlerServlet extends HttpServlet {
    private ICreditMetier metier;
    
    @Override
    public void init() throws ServletException{
//        Utilisation du metier
        metier = new CreditMetierImplementation();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        request.setAttribute("creditModel", new CreditModel());
        request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
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
//        recuperation des donnees du formulaire
        double montant = Double.parseDouble(request.getParameter("montant"));
        double taux = Double.parseDouble(request.getParameter("taux"));
        int duree = Integer.parseInt(request.getParameter("duree"));
//        Faire appelle au model
        CreditModel credit = new CreditModel();
        credit.setMontant(montant);
        credit.setTaux(taux);
        credit.setDuree(duree);
//        Utilisation du metier
        double res = metier.calculerMensualiteCredit(montant, taux, duree);
//        Mettre a jour les valeurs du Model
        credit.setMensualite(res);
//        stockager du model dans l'objet request
        request.setAttribute("creditModel", credit);
//      Foward vers la vue
        request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
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
