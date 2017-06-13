/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import models.CTBill;

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
public class CTBillDao {
    
    
    BillDao billDao = new BillDao();
    ItemDao itemDao = new ItemDao();
    SizeDao sizeDao = new SizeDao();
     Statement statement;
    Connection connection = ConnectionManager.getConnection();    
    
    
    public CTBill find(int id) {
        CTBill ctBill = null;
        try {
            String sql = "SELECT * FROM tbl_ctbills WHERE idBills = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                ctBill = new CTBill();
                ctBill.setId(result.getInt("id"));
                ctBill.setBill(billDao.find(result.getInt("idBills")));
                ctBill.setItems(itemDao.find(result.getInt("idItems")));
                ctBill.setSize(sizeDao.find(result.getInt("idsize")));
                ctBill.setNumber(result.getInt("number"));
                ctBill.setPrice(result.getInt("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctBill;
    }
    
    public boolean add(CTBill ctBill) {
        try {
            String sql = "INSERT INTO tbl_ctbills (idBills,idItems,idsize, number,price,img) VALUES ('"
                    + ctBill.getBill().getId()
                    + "', '" + ctBill.getItems().getId()
                    + "', '" + ctBill.getSize().getId()
                    + "', '" + ctBill.getNumber()
                    + "', '" + ctBill.getPrice()
                    + "', '" + ctBill.getImg()
                    + "')";
//            System.out.println(sql);
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public void edit(CTBill ctBill){
        try {
            String sql = "UPDATE tbl_ctbills SET "
                    + "idBills = '" + ctBill.getBill().getId()+ "'"
                    + ",idItems = '" + ctBill.getItems().getId()+ "'"
                    + ",idsize = '" + ctBill.getSize().getId()+ "'"
                    + ",number = '" + ctBill.getNumber()+ "'"   
                    + ",price = '" + ctBill.getPrice()+ "'" 
                    + " WHERE id = '" + ctBill.getId()+ "'";
            System.out.println(sql);
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean delete(int id) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_ctbills"
                    + " WHERE idBills = '" + id + "'";
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
    public boolean deleteCtbill(int id) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_ctbills"
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
    
    public List<CTBill> findAll(int idBills) {
        List<CTBill> ctBills = null;
        try {
            String sql = "SELECT * FROM tbl_ctbills WHERE idBills = '"+ idBills +"'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            ctBills = new ArrayList<CTBill>();
            CTBill ctbill;
            while (result.next()) {
                ctbill = new CTBill();
                ctbill.setId(result.getInt("id"));
                ctbill.setBill(billDao.find(result.getInt("idBills")));
                ctbill.setItems(itemDao.find(result.getInt("idItems")));
                ctbill.setSize(sizeDao.find(result.getInt("idsize")));
                ctbill.setNumber(result.getInt("number"));    
                ctbill.setPrice(result.getInt("price")); 
                ctbill.setImg(result.getString("img")); 
                ctBills.add(ctbill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctBills;
    }   
}
