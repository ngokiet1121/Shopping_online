/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import helper.DateConverter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Sale;


/**
 *
 * @author ADMIN
 */
public class SaleDao {
     Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public Sale find(int id) {
        Sale sale = null;
        try {
            String sql = "SELECT * FROM tbl_sale WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                sale = new Sale();             
                sale.setId(result.getInt("id"));
                sale.setNgayBatdau(result.getDate("ngaybatdau"));
                sale.setNgayKetThuc(result.getDate("ngayketthuc"));
                sale.setSale(result.getInt("sale"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sale;
    }
    

    public Sale find(String s) {
        Sale sale = null;
        try {
            String sql = "SELECT * FROM tbl_sale WHERE size = '" + s + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                sale = new Sale();
               sale.setId(result.getInt("id"));
                sale.setNgayBatdau(result.getDate("ngaybatdau"));
                sale.setNgayKetThuc(result.getDate("ngayketthuc"));
                sale.setSale(result.getInt("sale"));

                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sale;
    }
    
    public boolean add(Sale sale) {
        try {
            String sql = "INSERT INTO tbl_sale (ngaybatdau,ngayketthuc,sale) VALUES ('"
                    + DateConverter.convertToSqlDate(sale.getNgayBatdau())+ "', '"
                    + DateConverter.convertToSqlDate(sale.getNgayKetThuc())+ "', '"
                    + sale.getSale()
                    + "')";
            System.out.println(DateConverter.convertToSqlDate(sale.getNgayBatdau()));
            System.out.println(DateConverter.convertToSqlDate(sale.getNgayKetThuc()));
            System.out.println(sale.getNgayBatdau());
            System.out.println(sale.getNgayKetThuc());
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean edit(Sale sale) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_sale SET "
                    + "sale = '" + sale.getSale()+ "'"          
                    + " WHERE id = '" + sale.getId()+ "'";
            System.out.println(sql);
            statement = connection.createStatement();
            noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        if (noOfRecords>0){
            return true;
        }
        return false;
    }
    
    public boolean delete(int id) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_sale"
                    + " WHERE id = '" + id + "'";
            System.out.println(sql);
            statement = connection.createStatement();
            noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (noOfRecords>0){
            return true;
        }
        return false;
    }
    
    public List<Sale> findAll() {
        List<Sale> sales = null;
        try {
            String sql = "SELECT * FROM tbl_sale";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            sales = new ArrayList<Sale>();
            Sale sale;
            while (result.next()) {
                sale = new Sale();
                sale.setId(result.getInt("id"));
                sale.setNgayBatdau(result.getDate("ngaybatdau"));
                sale.setNgayKetThuc(result.getDate("ngayketthuc"));
                sale.setSale(result.getInt("sale"));        
                sales.add(sale);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sales;
    }
}
