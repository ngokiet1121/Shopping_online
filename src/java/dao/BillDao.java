/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import helper.DateConverter;
import models.Bill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BillDao {

    UserDao userDao = new UserDao();

    Statement statement;
    Connection connection = ConnectionManager.getConnection();

    public Bill find(int id) {
        Bill bill = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalPrice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bill;
    }

    public void edit(Bill bill) {
        try {
            String sql = "UPDATE tbl_bills SET "
                    + "status = '" + bill.getStatus() + "'"
                    + " WHERE id = '" + bill.getId() + "'";
            System.out.println(sql);
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Bill find(String user) {
        Bill bill = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE user = '" + user + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bill;
    }

    public boolean add(Bill bill) {
        try {
            String sql = "INSERT INTO tbl_bills (user,totalprice,status,date,month,year,sale) VALUES ('"
                    + bill.getUser().getEmail()
                    + "', '" + bill.getTotalPrice()
                    + "', '" + bill.getStatus()
                    + "', '" + bill.getDate()
                    + "', '" + bill.getMonth()
                    + "', '" + bill.getYear()
                    + "', '" + bill.getSale()
                    + "')";
            System.out.println(sql);
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_bills"
                    + " WHERE id = '" + id + "'";
//            System.out.println(sql);
            statement = connection.createStatement();
            noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (noOfRecords > 0) {
            return true;
        }
        return false;
    }

    public List<Bill> findAll() {
        List<Bill> bills = null;
        try {
            String sql = "SELECT * FROM tbl_bills";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            bills = new ArrayList<Bill>();
            Bill bill;
            while (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalprice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    

    public List<Bill> findAllbyUser(String user) {
        List<Bill> bills = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE user = '" + user + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("cau sql la " + sql);
            bills = new ArrayList<Bill>();
            Bill bill;
            while (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalprice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }

    
    public List<Bill> findAllbyMonth(int month) {
        List<Bill> bills = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE month = '" + month + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("cau sql la " + sql);
            bills = new ArrayList<Bill>();
            Bill bill;
            while (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalprice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    public List<Bill> findAllbyYear(int year) {
        List<Bill> bills = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE year = '" + year + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("cau sql la " + sql);
            bills = new ArrayList<Bill>();
            Bill bill;
            while (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalprice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public List<Bill> findAllbyMonthAndYear(int month, int year) {
        List<Bill> bills = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE"
                    + " month = '" + month + "'"
                    + " AND year = '" + year + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.print(sql);
            bills = new ArrayList<Bill>();
            Bill bill;
             while (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalprice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bills;
    }
    
    public List<Bill> findAllbyUserAndStatus(String user, int status) {
        List<Bill> bills = null;
        try {
            String sql = "SELECT * FROM tbl_bills WHERE user = '" + user
                    + "' AND status = '" + status + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("cau sql la " + sql);
            bills = new ArrayList<Bill>();
            Bill bill;
            while (result.next()) {
                bill = new Bill();
                bill.setId(result.getInt("id"));
                bill.setUser(userDao.find(result.getString("user")));
                bill.setTotalPrice(result.getInt("totalprice"));
                bill.setStatus(result.getInt("status"));
                bill.setDate(result.getInt("date"));
                bill.setMonth(result.getInt("month"));
                bill.setYear(result.getInt("year"));
                bill.setSale(result.getInt("sale"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }

}
