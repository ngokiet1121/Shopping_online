/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Banner;

/**
 *
 * @author ADMIN
 */
public class ABannerServlet extends HttpServlet {
    BannerDao bannerDao = new BannerDao();
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
            out.println("<title>Servlet ABannerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ABannerServlet at " + request.getContextPath() + "</h1>");
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
            List<Banner> banners = bannerDao.findAll();
            request.setAttribute("banners", banners);
            request.getRequestDispatcher("list-banner.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            if (bannerDao.delete(Integer.parseInt(id))) {
                response.sendRedirect("doBanner");
            } else {
                response.sendRedirect("doBanner");
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
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String img = request.getParameter("banner");
        Banner bannerC = new Banner(img);
        if (action.equals("Create")){
            if (bannerDao.add(bannerC)) {
                response.sendRedirect("doBanner");
            } else {
                response.sendRedirect("create-banner.jsp");
            }
        } else if (action.equals("Edit")) {
            Banner bannerE = new Banner(Integer.parseInt(id), img);
            if (bannerDao.edit(bannerE)) {
                request.getRequestDispatcher("doBanner").forward(request, response);
            }else{
                request.getRequestDispatcher("doEdit?action=banner&id="+id).forward(request, response);
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
