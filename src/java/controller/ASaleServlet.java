/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SaleDao;
import helper.DateConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Sale;

/**
 *
 * @author ADMIN
 */
public class ASaleServlet extends HttpServlet {
    SaleDao saleDao = new SaleDao();
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
            out.println("<title>Servlet ASaleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ASaleServlet at " + request.getContextPath() + "</h1>");
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
        //String id = request.getParameter("idSale");
        List<Sale> sales = (List<Sale>) saleDao.findAll();
        if (action == null) {
            request.getSession().setAttribute("sales", sales);
            response.sendRedirect("list-sale.jsp");
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
        String id = request.getParameter("idSale");
        String ngayBatDau = request.getParameter("ngaybatdau");
        String ngayKetThuc = request.getParameter("ngayketthuc");
        String giamgia = request.getParameter("sale");
        String action = request.getParameter("action");
        System.out.println("date" + DateConverter.convertStringToDate(ngayBatDau));
        Sale sale;
        sale = new Sale(DateConverter.convertStringToDate(ngayBatDau), DateConverter.convertStringToDate(ngayKetThuc), Integer.parseInt(giamgia));
        if (action.equals("Create")) {            
                saleDao.add(sale);
                response.sendRedirect("doSale");          
        }else if(action.equals("Edit")){
            Sale saleE = new Sale(Integer.parseInt(id),DateConverter.convertStringToDate(ngayBatDau), DateConverter.convertStringToDate(ngayKetThuc),Integer.parseInt(giamgia));
            saleDao.edit(saleE);
            response.sendRedirect("doSale");
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
