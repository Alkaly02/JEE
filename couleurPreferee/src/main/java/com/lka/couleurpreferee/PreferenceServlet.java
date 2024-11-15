/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lka.couleurpreferee;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "PreferenceServlet", urlPatterns = {"/definirCouleur"})
public class PreferenceServlet extends HttpServlet {

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
//        Recuperation de tous les cookies envoyes par le client
//        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        String couleurPreferee = (String)session.getAttribute("couleurPreferee");
//        Verification si un cookie existe dans le tableau
//        if(cookies != null){
//            for(Cookie cookie: cookies){
//                //Verification si un cookie couleurPreferee existe
//                if(cookie.getName().equals("couleurPreferee")){
//                    couleurPreferee = cookie.getValue();
//                    break;
//                }
//            }
//        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
//          Si le cookie existe, appliquer la couleur en fond de la page
            if(couleurPreferee != null){
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet PreferenceServlet</title>");
                out.println("</head>");
                out.println("<body style='background-color:"+ couleurPreferee+ "' >");
                out.println("<h2>");
                out.println("La couleur preferee est: " + couleurPreferee);
                out.println("</h2>");
                out.println("<p><a href='definirCouleur'>Changer la couleur</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
//            Sinon, afficher un formulaire pour choisir la couleur
            else{
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet PreferenceServlet</title>");
                out.println("</head>");
                out.println("<body>;");
                out.println("<h1>Choisissez votre couleur preferee</h1>");
                out.println("<form method='POST' action='definirCouleur'>");
                out.println("<select name='color'>");
                out.println("<option value='Red'>Rouge</option>");
                out.println("<option value='Blue'>Bleu</option>");
                out.println("<option value='Green'>Vert</option>");
                out.println("</select>");
                out.println("<input type='submit' value='Enregistrer' />");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
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
//        Recuperer la couleur selectionnee
        String selectecColour = request.getParameter("color");
////        Creer un cookie avec la couleur selectionnee
//        Cookie colorCookie = new Cookie("couleurPreferee", selectecColour);
//        colorCookie.setMaxAge(10); // Le cookie est valable 30 jours
//        response.addCookie(colorCookie);
          HttpSession session = request.getSession();
          session.setAttribute("couleurPreferee", selectecColour);
//        Redirection ves doGet pour appliquer la couleur
        response.sendRedirect(request.getContextPath()+"/definirCouleur");
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
