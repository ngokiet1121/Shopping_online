/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDao;
import dao.CTBillDao;
import dao.ItemDao;
import dao.RateDao;
import dao.SizeDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Bill;
import models.CTBill;
import models.Item;
import models.User;

/**
 *
 * @author ADMIN
 */
public class BagServlet extends HttpServlet {
    SizeDao sizeDao = new SizeDao();
    ItemDao itemDao = new ItemDao();
    CTBillDao ctbDao = new CTBillDao();
    UserDao userDao = new UserDao();
    BillDao billDao = new BillDao();
    RateDao rateDao = new RateDao();
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
            out.println("<title>Servlet BagServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BagServlet at " + request.getContextPath() + "</h1>");
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
        String img = request.getParameter("img");
        System.out.println(img);
        int idItem = Integer.parseInt(request.getParameter("id"));
        String size = request.getParameter("size");
        String type = request.getParameter("type");
        String tra = request.getParameter("trademark");
        int number = Integer.parseInt(request.getParameter("number"));
        int price = Integer.parseInt(request.getParameter("price"));     
        int cookieId = 0;
        Item item = (Item) itemDao.find(idItem);
        Cookie[] cookies = request.getCookies();
        cookieId = cookies.length;
        Cookie cookie = new Cookie("item" + String.valueOf(cookieId), String.valueOf(idItem)
                + "|" + size + "|" + String.valueOf(number) + "|" + String.valueOf(price) + "|" + img + "|" + type + "|" + "|" + tra);

        response.addCookie(cookie);
        
        cookie.getMaxAge();

//        double danhgia = Double.parseDouble(request.getParameter("rate"));
//        Rate rate = new Rate(itemDao.find(idItem), danhgia);
//        rateDao.add(rate);
//        
        response.sendRedirect("information.jsp?id=" + item.getId() + "");
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
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String[] img = request.getParameterValues("img");
        String[] idItem = request.getParameterValues("id");
        String[] size = request.getParameterValues("size");
        String[] number = request.getParameterValues("number");
        String[] price = request.getParameterValues("price");
        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
        String sale = request.getParameter("sale");
        Date date = new Date();
        

        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Bill bill = new Bill(userDao.find(user.getEmail()),date.getDate(),date.getMonth()+1,date.getYear()+1900, totalPrice, 1,Integer.parseInt(sale));
            billDao.add(bill);
            List<Bill> bills = (List<Bill>) billDao.findAll();
            int idBill = 0;
            //lay id cua bill vua dat
            idBill = bills.get(bills.size()-1).getId();
            
            String str1 = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            
            for (int i = 0; i < idItem.length; i++) {
                CTBill ctBill = new CTBill(billDao.find(idBill), itemDao.find(Integer.parseInt(idItem[i])), sizeDao.find(size[i]),
                        Integer.parseInt(number[i]), Integer.parseInt(price[i]),img[i]);
                ctbDao.add(ctBill);                
                str1 = str1 + idItem[i] + ", ";
                str2 = str2 + size[i] + ", ";
                str3 = str3 + number[i] + ", ";
                str4 = str4 + price[i] + ", ";
                str5 = str5 + img[i] +",";               
            }
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookies[i].setValue("");
                    //cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            String msg =  "Chuc mung! Ban da dat hang thanh cong"
                    + "\nMa san pham: " + str1 
                    + "\nKich co: " + str2
                    + "\nSo luong: "+str3
                    + "\nGia : "+str4
                    + "\nGiam gia : "+sale +"%"
                    + "\nBan phai thanh toan truoc 0 gio neu khong thi don hang cua ban se bi huy";
            helper.SendMailTLS.sendEmail(user.getEmail(), "Ban Hang Online",msg);  
            response.sendRedirect("success-checkout.jsp");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
