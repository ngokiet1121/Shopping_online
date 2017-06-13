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
import models.Size;


/**
 *
 * @author ADMIN
 */
public class SizeDao {
     Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public Size find(int id) {
        Size size = null;
        try {
            String sql = "SELECT * FROM tbl_size WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                size = new Size();
                size.setId(result.getInt("id"));
                size.setSize(result.getString("size"));

                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size;
    }
    

    public Size find(String s) {
        Size size = null;
        try {
            String sql = "SELECT * FROM tbl_size WHERE size = '" + s + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                size = new Size();
                size.setId(result.getInt("id"));
                size.setSize(result.getString("size"));

                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size;
    }
    
    public boolean add(Size size) {
        try {
            String sql = "INSERT INTO tbl_size (size) VALUES ('"
                    + size.getSize()

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
    
    public boolean edit(Size type) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_size SET "
                    + "size = '" + type.getSize()+ "'"          
                    + " WHERE id = '" + type.getId()+ "'";
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
            String sql = "DELETE FROM tbl_size"
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
    
    public List<Size> findAll() {
        List<Size> sizes = null;
        try {
            String sql = "SELECT * FROM tbl_size";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            sizes = new ArrayList<Size>();
            Size size;
            while (result.next()) {
                size = new Size();
                size.setId(result.getInt("id"));
                size.setSize(result.getString("size"));              
                //System.out.println(user.getId()+ "|" + user.getUserName()+ "|" + user.getAddress()+ "|" + user.getPhone());
                sizes.add(size);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sizes;
    }
}
