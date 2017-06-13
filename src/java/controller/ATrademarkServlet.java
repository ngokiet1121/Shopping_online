/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TrademarkDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Trademark;

/**
 *
 * @author ADMIN
 */
public class ATrademarkServlet extends HttpServlet {
    TrademarkDao traDao = new TrademarkDao();
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
            out.println("<title>Servlet ATrademarkServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ATrademarkServlet at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        String action = request.getParameter("action");
        if (action == null) {
            List<Trademark> dstra = traDao.findAll();
            request.getSession().setAttribute("dstra", dstra);
            request.getRequestDispatcher("list-trademark.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            if (traDao.delete(Integer.parseInt(id))) {
                response.sendRedirect("doTra");
            } else {
                response.sendRedirect("doTra");
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
        String id = request.getParameter("id");
        String trademark = request.getParameter("trademark");
        String img = request.getParameter("img");
        String action = request.getParameter("action");
        Trademark tra = new Trademark(trademark, img);
        
        if (action.equals("Create") && traDao.find(trademark) == null) {
            if (traDao.add(tra)) {             
                response.sendRedirect("dotra");
            } else {
                response.sendRedirect("create-trademark.jsp");
            }
        } else if (action.equals("Edit")) {
            Trademark traE = new Trademark(Integer.parseInt(id),trademark, img);
            if (traDao.find(Integer.parseInt(id)) != null) {
                traDao.edit(traE);
                response.sendRedirect("doTra");
            } else {
                response.sendRedirect("doEdit?action=tra&id="+id);
            }
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
