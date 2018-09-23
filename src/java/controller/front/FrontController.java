/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.front;

import controller.app.ApplicationController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pageresolver.PageResolver;


public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String akcija = request.getParameter("akcija");

        if (request.getParameter("movieID") != null) {
            System.out.println("MovieID: " + request.getParameter("movieID"));
            System.out.println("Akcija: " + akcija);
            String movieID = request.getParameter("movieID");
            String view = ApplicationController.getInstance().processRequest(movieID, akcija, request);
            String page = PageResolver.getPage(view);
            System.out.println("strana: " + page);
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
        } else {
            System.out.println("Akcija: " + akcija);
            String view = ApplicationController.getInstance().processRequest(akcija, request);
            String page = PageResolver.getPage(view);
            System.out.println("strana:" + page);
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
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
        processRequest(request, response);
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
