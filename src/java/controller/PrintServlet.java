/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author ADMIN
 */
public class PrintServlet extends HttpServlet {

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
            out.println("<title>Servlet PrintServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PrintServlet at " + request.getContextPath() + "</h1>");
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
        String billId = request.getParameter("id");
        
        String lang = request.getParameter("lang");
        System.out.println("asdasd" + lang);
        String result = "";
//        if(lang.equals("en")){
            result = print(Integer.parseInt(billId));
//        }else if(lang.equals("vi")){
//            result = printVI(Integer.parseInt(billId));
//        }
        if (!result.equals("")) {
            open(result);
        }
        response.sendRedirect("history");
    }

    public String print(int billId) {
        String outputFile = "";
        try {
            String baseDirectory = "/report/";
            String reportFile = baseDirectory + "bill.jasper";
            outputFile = "D:\\HoaDon\\hoadon" + System.currentTimeMillis() + ".pdf";
            System.out.println("file" + outputFile);
            System.out.println("Real Path:" + getServletContext().getRealPath(reportFile));
            Map parametersMap = new HashMap();
            parametersMap.put("billId", billId);
            JasperPrint jasperPrint = JasperFillManager.fillReport(getServletContext().getRealPath(reportFile), parametersMap, ConnectionManager.getConnection());
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFile);
        } catch (JRException ex) {
            Logger.getLogger(PrintServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outputFile;
    }

    public String printVI(int billId) {
        String outputFile = "";
        try {
            String baseDirectory = "/report/";
            String reportFile = baseDirectory + "bill_vi.jasper";
            outputFile = "D:\\HoaDon\\hoadon" + System.currentTimeMillis() + ".pdf";
            System.out.println("file" + outputFile);
            System.out.println("Real Path:" + getServletContext().getRealPath(reportFile));
            Map parametersMap = new HashMap();
            parametersMap.put("billId", billId);
            JasperPrint jasperPrint = JasperFillManager.fillReport(getServletContext().getRealPath(reportFile), parametersMap, ConnectionManager.getConnection());
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFile);
        } catch (JRException ex) {
            Logger.getLogger(PrintServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outputFile;
    }

    public static void open(String fileName) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(fileName);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
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
