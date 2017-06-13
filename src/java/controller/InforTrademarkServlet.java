/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItemDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Item;

/**
 *
 * @author ADMIN
 */
public class InforTrademarkServlet extends HttpServlet {

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
            out.println("<title>Servlet InforTrademarkServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InforTrademarkServlet at " + request.getContextPath() + "</h1>");
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
        int idTra = Integer.parseInt(request.getParameter("idTra"));
        request.getSession().setAttribute("idTra", idTra);
        
        int page = 1;
        int recordsPerPage = 12;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        ItemDao itemdao = new ItemDao();
        List<Item> i = (List<Item>) itemdao.findAllbyTrademark(idTra);
        int noOfRecords = i.size();
        List<Item> items = (List<Item>) itemdao.viewAllByTra(Integer.parseInt(request.getSession().getAttribute("idTra").toString()),(page-1)*recordsPerPage,
                                 recordsPerPage);
        System.out.println(items.size());
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        System.out.println("noOfpages" + noOfPages);
        request.getSession().setAttribute("items", items);       
        request.getSession().setAttribute("noOfPages", noOfPages);
        System.out.println( "noOfRecords "+ noOfRecords);
        System.out.println("page " + page);
        request.getSession().setAttribute("currentPage", page);
        response.sendRedirect("trademark.jsp");
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
