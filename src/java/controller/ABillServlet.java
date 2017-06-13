/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDao;
import dao.CTBillDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Bill;

/**
 *
 * @author ADMIN
 */
public class ABillServlet extends HttpServlet {
    BillDao billDao = new BillDao();
    CTBillDao ctBillDao = new CTBillDao();
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
            out.println("<title>Servlet ABillServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ABillServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        
        
        
        if (action == null) {
            List<Bill> bills = billDao.findAll();
            request.getSession().setAttribute("bills", bills);
            request.getRequestDispatcher("list-bill.jsp").forward(request, response);
        } else if (action.equals("cancel")) {
            if (Controller.controller.findIdBill(Integer.parseInt(id))) {
                Bill bill = new Bill(Integer.parseInt(id), 3);
                billDao.edit(bill);
                response.sendRedirect("doBill");
            } else {
                response.sendRedirect("doBill");
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
        String id = request.getParameter("idbill");
        int status = Integer.parseInt(request.getParameter("status"));
        String action = request.getParameter("action");
        Bill bill = new Bill(Integer.parseInt(id), status);
        System.out.println("dasdasdadasd" + id);
        if (action.equals("Edit")) {
            if (Controller.controller.findIdBill(Integer.parseInt(id))) {
                billDao.edit(bill);
            }
            response.sendRedirect("doBill");
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
