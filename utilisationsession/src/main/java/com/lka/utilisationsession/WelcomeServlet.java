/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lka.utilisationsession;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

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
            out.println("<title>Servlet WelcomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WelcomeServlet at " + request.getContextPath() + "</h1>");
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
   //        processRequest(request, response);
        response.setContentType("text/html; Charset=UTF-8");
//        creation ou recuperation d'une session existante
         HttpSession session = request.getSession();
//        verification si l'utilisateur a deja une session avec un nom stocke 
        String username = (String) session.getAttribute("username");
        
        if (username == null){
//            premiere visite : demander le nom de l'utilisateur
            response.getWriter().println("<form method='POST' action='/WelcomeServlet'>");
            response.getWriter().println("Entrez votre nom : <input type='text' name='username' >");
            response.getWriter().println("<input type='submit' value='Envoyer' >");
            response.getWriter().println("</form>");
        }else { 
//            session existante: message de bienvenue
            response.getWriter().println("<h1> Bienvenue,  " + username +"!</h1>");
        }
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
    //            Recuperer le nom de l'utilisateur et le stocker dans la session
            String username = request.getParameter("username");
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //redirection vers la meme page pour afficher le message de bienvenue
            response.sendRedirect("/WelcomeServlet");
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
