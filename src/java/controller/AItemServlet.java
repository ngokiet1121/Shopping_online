/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItemDao;
import dao.SizeDao;
import dao.TrademarkDao;
import dao.TypeDao;
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
public class AItemServlet extends HttpServlet {

    ItemDao itemDao = new ItemDao();
    TypeDao typeDao = new TypeDao();
    SizeDao sizeDao = new SizeDao();
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
            out.println("<title>Servlet AItemServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AItemServlet at " + request.getContextPath() + "</h1>");
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
            List<Item> items = itemDao.findAll();
            request.getSession().setAttribute("items", items);
            request.getRequestDispatcher("list-item.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            if (Controller.controller.deleteItem(Integer.parseInt(id))) {
                response.sendRedirect("doItem");
            } else {
                response.sendRedirect("doItem");
            }
        } else if (action.equals("Create")) {
            request.setAttribute("dsTra", traDao.findAll());
            request.setAttribute("dsType", typeDao.findAll());
            request.getRequestDispatcher("create-item.jsp").forward(request, response);
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
        String idtrademark = request.getParameter("idtrademark");
        String Idtype = request.getParameter("Idtype");
        int price = Integer.parseInt(request.getParameter("price"));
        int number = Integer.parseInt(request.getParameter("number"));
        //String[] imgs = request.getParameterValues("img");
        String action = request.getParameter("action");

        String id = request.getParameter("id");

        //System.out.println("asdasdasdasdasd" + img);
//        String img = "";
//        for (String img1 : imgs) {
//            img += img1 + ",";
//        }
        switch (action) {
            case "Create":
                Item itemC = new Item(traDao.find(Integer.parseInt(idtrademark)), typeDao.find(Integer.parseInt(Idtype)), price, number);
                if (Controller.controller.createItem(itemC)) {
                    response.sendRedirect("doItem");
                } else {
                    response.sendRedirect("create-item.jsp");
                }
                break;
            case "Edit":
                Item itemE = new Item(Integer.parseInt(id), traDao.find(Integer.parseInt(idtrademark)), typeDao.find(Integer.parseInt(Idtype)),
                        price, number);
                if (itemDao.find(Integer.parseInt(id)) != null) {
                    Controller.controller.editItem(itemE);
                    response.sendRedirect("doItem");
                } else {
                    response.sendRedirect("doEdit?action=item&id="+id);
                }
                break;
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
