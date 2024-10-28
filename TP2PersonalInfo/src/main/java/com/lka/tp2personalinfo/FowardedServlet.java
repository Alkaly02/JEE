/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lka.tp2personalinfo;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "FowardedServlet", urlPatterns = {"/fowardedServlet"})
public class FowardedServlet extends HttpServlet {

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
            out.println("<title>Servlet FowardedServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FowardedServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String prenom = (String)request.getAttribute("prenom");
        String nom = (String)request.getAttribute("nom");
        String age = (String)request.getAttribute("age");
        String sexe = (String)request.getAttribute("sexe");
        String hobbies[] = (String[])request.getAttribute("hobbies");
        String comments = (String)request.getAttribute("comments");
        
        String hobbiesSelected = "";
        if(hobbies!=null){
            for(String hobbie: hobbies){
                hobbiesSelected += hobbie + ", ";
            }
        }
        
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        
        PrintWriter os = response.getWriter();
        
        os.println("<!Doctype html>");
        os.println("<html>");
        os.println("<head>");
        os.println("<title>Information personnelles</title>");
        os.println("</head>");
        os.println("<body>");
        os.println("<h1>Information formulaire</h1>");
        os.println("<p>Prenom: " + prenom +"</p>");
        os.println("<p>Nom: " + nom +"</p>");
        os.println("<p>Age: " + age +"</p>");
        os.println("<p>Sexe: " + sexe +"</p>");
        os.println("<p>Hobbies: " + hobbiesSelected +"</p>");
        os.println("<p>Commentaires: " + comments +"</p>");
        os.println("<body>");
        os.println("</html>");
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
