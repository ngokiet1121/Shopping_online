package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author ADMIN
 */
public class SignupServlet extends HttpServlet {
    UserDao userDao = new UserDao();
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
            out.println("<title>Servlet SignupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
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
        String userName = request.getParameter("username");
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("comfirmpassword");
        String address  = request.getParameter("address");
        String phone    = request.getParameter("phone");
        int status = 0;
        long url = System.currentTimeMillis();
        String passMD5 = helper.MD5Generator.generate(password);
        String cpassMD5 = helper.MD5Generator.generate(confirmpassword);
        User user = new User(userName, email, passMD5, address, phone,status,url);  
        String link ="http://localhost:8084/banhangonlinev4.0/activate?url="+url ;
        String msg = "User Name" + userName + "\n Email " + email + "\npassword " + password 
                + "\nAddress" + address + "\nPhone " +phone ;
        String activate = "\nXac nhan email cua ban\n" + link;
        if(passMD5.equals(cpassMD5) && userDao.find(email) == null){            
            Controller.controller.addUser(user);
            helper.SendMailTLS.sendEmail(email, "Xin chao "+userName,"Thong tin tai khoan cua ban. \n"+ msg+ "\nMa kich hoac tai khoan" + activate);
            request.getRequestDispatcher("activate.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("fail-register.jsp").forward(request, response);
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
