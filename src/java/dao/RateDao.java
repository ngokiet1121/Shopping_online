/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Rate;


/**
 *
 * @author ADMIN
 */
public class RateDao {
    Statement statement;
    Connection connection = ConnectionManager.getConnection();
    UserDao userDao = new UserDao();
    ItemDao itemDao = new ItemDao();
        public Rate find(int id) {
        Rate rate = null;
        try {
            String sql = "SELECT * FROM tbl_rate WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                rate = new Rate();
                rate.setId(result.getInt("id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rate;
    }
    

   
    public boolean add(Rate rate) {
        try {
            String sql = "INSERT INTO tbl_rate (idItem,rate) VALUES ('"
                    + rate.getItem().getId()+ "', '"
                    + rate.getRate()
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
//    
//    public boolean edit(Rate sale) {
//        int noOfRecords = 0;
//        try {
//            String sql = "UPDATE tbl_rate SET "
//                    + "size = '" + sale.getRate()+ "'"          
//                    + " WHERE id = '" + sale.getId()+ "'";
//            System.out.println(sql);
//            statement = connection.createStatement();
//            noOfRecords = statement.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//            
//        }
//        if (noOfRecords>0){
//            return true;
//        }
//        return false;
//    }
//    
    public boolean delete(int id) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_rate"
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
    
    public List<Rate> findAll() {
        List<Rate> rates = null;
        try {
            String sql = "SELECT * FROM tbl_rate";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            rates = new ArrayList<Rate>();
            Rate rate;
            while (result.next()) {
                rate = new Rate();
                rate.setId(result.getInt("id")); 
                rate.setUser(userDao.find(result.getInt("id"))); 
                rate.setItem(itemDao.find(result.getInt("id"))); 
                rate.setRate(result.getDouble("rate"));
                rates.add(rate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rates;
    }
    
    public List<Rate> findAll(int idItem) {
        List<Rate> rates = null;
        try {
            String sql = "SELECT * FROM tbl_rate WHERE idItem = '" + idItem + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            rates = new ArrayList<Rate>();
            Rate rate;
            while (result.next()) {
                rate = new Rate();
                rate.setId(result.getInt("id"));  
                rate.setItem(itemDao.find(result.getInt("idItem"))); 
                rate.setRate(result.getDouble("rate"));
                rates.add(rate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rates;
    }
}
