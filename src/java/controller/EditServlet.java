/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDao;
import dao.BillDao;
import dao.CTBillDao;
import dao.ItemDao;
import dao.SaleDao;
import dao.TrademarkDao;
import dao.TypeDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Banner;
import models.Bill;
import models.CTBill;
import models.Item;
import models.Sale;
import models.Trademark;
import models.User;

/**
 *
 * @author ADMIN
 */
public class EditServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    ItemDao itemDao = new ItemDao();
    TrademarkDao traDao = new TrademarkDao();
    BillDao billDao = new BillDao();
    TypeDao typeDao = new TypeDao();
    CTBillDao ctbillDao = new CTBillDao();
    BannerDao bannerDao = new BannerDao();
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
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
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
        User user = userDao.find(Integer.parseInt(id));
        Item item = itemDao.find(Integer.parseInt(id));
        Trademark tra = traDao.find(Integer.parseInt(id));
        Bill bill = billDao.find(Integer.parseInt(id));
        Bill billedit = billDao.find(Integer.parseInt(id));
        Banner banner = bannerDao.find(Integer.parseInt(id));
        Sale sale = saleDao.find(Integer.parseInt(id));
        request.setAttribute("dsTra", traDao.findAll());
        request.setAttribute("dsType", typeDao.findAll());
        List<CTBill> ctbills = (List<CTBill>) ctbillDao.findAll(Integer.parseInt(id));
        request.getSession().setAttribute("ctbills", ctbills);
        if (action.equals("user") && user != null) {
            request.setAttribute("id", user);
            request.getRequestDispatcher("edit-user.jsp").forward(request, response);
        } else if (action.equals("item") && item != null) {
            request.setAttribute("id", item);
            request.getRequestDispatcher("edit-item.jsp").forward(request, response);
        } else if (action.equals("tra") && tra != null) {
            request.setAttribute("id", tra);
            request.getRequestDispatcher("edit-trademark.jsp").forward(request, response);
        } else if (action.equals("bill") && bill != null) {
            request.setAttribute("id", bill);
            request.getRequestDispatcher("list-ctbill.jsp").forward(request, response);
        } else if (action.equals("billedit") && billedit != null) {
            request.setAttribute("id", billedit);
            request.getRequestDispatcher("edit-bill.jsp").forward(request, response);
        }else if (action.equals("itemaddimg") && item != null) {
            request.setAttribute("id", item);
            request.getRequestDispatcher("add-image-item.jsp").forward(request, response);
        }else if (action.equals("banner") && banner != null) {
            request.setAttribute("id", banner);
            request.getRequestDispatcher("edit-banner.jsp").forward(request, response);
        }else if(action.equals("sale") && sale != null){
            request.setAttribute("id", sale);
            request.getRequestDispatcher("edit-sale.jsp").forward(request, response);
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
