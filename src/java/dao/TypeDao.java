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
import models.Type;

/**
 *
 * @author ADMIN
 */
public class TypeDao {
    Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public Type find(int id) {
        Type type = null;
        try {
            String sql = "SELECT * FROM tbl_type WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                type = new Type();
                type.setId(result.getInt("id"));
                type.setType(result.getString("type"));
                type.setImg(result.getString("img"));
                type.setBanner(result.getString("banner"));
                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
    

    
    public boolean add(Type type) {
        try {
            String sql = "INSERT INTO tbl_type (type,img) VALUES ('"
                    + type.getType()
                    + "', '" + type.getImg()
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
    
    public boolean edit(Type type) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_type SET "
                    + "type = '" + type.getType()+ "'"          
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
            String sql = "DELETE FROM tbl_type"
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
    
    public List<Type> findAll() {
        List<Type> types = null;

        try {
            String sql = "SELECT * FROM tbl_type";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            types = new ArrayList<Type>();
            Type type;
            while (result.next()) {
                type = new Type();
                type.setId(result.getInt("id"));
                type.setType(result.getString("type"));
                type.setImg(result.getString("img"));
                type.setBanner(result.getString("banner"));
                //System.out.println(user.getId()+ "|" + user.getUserName()+ "|" + user.getAddress()+ "|" + user.getPhone());
                types.add(type);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return types;
    }
  
}
