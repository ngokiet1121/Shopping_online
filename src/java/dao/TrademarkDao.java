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
import models.Trademark;


/**
 *
 * @author ADMIN
 */
public class TrademarkDao {
    Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public Trademark find(int id) {
        Trademark trademark = null;
        try {
            String sql = "SELECT * FROM tbl_trademark WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                trademark = new Trademark();
                trademark.setId(result.getInt("id"));
                trademark.setTrademark(result.getString("trademark"));
                trademark.setImg(result.getString("img"));
                trademark.setBanner(result.getString("banner"));
                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trademark;
    }
    
    public Trademark find(String trademark) {
        Trademark tra= null;
        try {
            String sql = "SELECT * FROM tbl_trademark WHERE trademark LIKE '%" + trademark + "%'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                tra = new Trademark();
                tra.setId(result.getInt("id"));
                tra.setTrademark(result.getString("trademark"));
                tra.setImg(result.getString("img"));
                tra.setBanner(result.getString("banner"));
                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tra;
    }

    
    public boolean add(Trademark trademark) {
        try {
            String sql = "INSERT INTO tbl_trademark (trademark,img) VALUES ('"
                    + trademark.getTrademark()
                    + "', '" + trademark.getImg()
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
    
    public boolean edit(Trademark trademark) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_trademark SET "
                    + "trademark = '" + trademark.getTrademark()+ "'" 
                    + ",img = '" + trademark.getImg()+ "'" 
                    + " WHERE id = '" + trademark.getId()+ "'";
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
            String sql = "DELETE FROM tbl_trademark"
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
    
    public List<Trademark> findAll() {
        List<Trademark> trademarks = null;
        try {
            String sql = "SELECT * FROM tbl_trademark";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            trademarks = new ArrayList<Trademark>();
            Trademark trademark;
            while (result.next()) {
                trademark = new Trademark();
                trademark.setId(result.getInt("id"));
                trademark.setTrademark(result.getString("trademark"));
                trademark.setImg(result.getString("img"));  
                trademark.setBanner(result.getString("banner"));
                trademarks.add(trademark);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trademarks;
    }
  
}
