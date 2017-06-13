/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import models.User;
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
public class UserDao {
    Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public User find(String email) {
        User user = null;
        try {
            String sql = "SELECT * FROM tbl_user WHERE email = '" + email + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            if (result.next()) {
                user = new User();
                user.setUserName(result.getString("username"));
                user.setEmail(result.getString("email"));              
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setAddress(result.getString("address"));
                user.setImg(result.getString("img"));
                user.setStatus(result.getInt("status"));
                user.setUrl(result.getLong("url"));
                System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
     public User find(int id) {
        User user = null;
        try {
            String sql = "SELECT * FROM tbl_user WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setUserName(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setAddress(result.getString("address"));
                user.setImg(result.getString("img"));
                user.setStatus(result.getInt("status"));
                user.setUrl(result.getLong("url"));
                System.out.println(user.getEmail()+ "|" + user.getPassword());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public boolean add(User user) {
        try {
            String sql = "INSERT INTO tbl_user (username, email, password,address,phone,img,url,status) VALUES ('"
                    + user.getUserName()
                    + "', '" + user.getEmail()
                    + "', '" + user.getPassword()
                    + "', '" + user.getAddress()
                    + "', '" + user.getPhone()
                    + "', '" + user.getImg()
                    + "', '" + user.getUrl()
                    + "', '" + user.getStatus()
                    
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
    
    public boolean edit(User user) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_user SET "
                    + "username = '" + user.getUserName()+ "'"
                    + ",password = '" + user.getPassword()+ "'"
                    + ",address = '" + user.getAddress()+ "'"
                    + ",email = '" + user.getEmail()+ "'"  
                    + ",phone = '" + user.getPhone()+ "'"                   
                    + " WHERE email = '" + user.getEmail()+ "'";
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
    public boolean editImg(User user) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_user SET "
                    + "img = '" + user.getImg()+ "'"                 
                    + " WHERE email = '" + user.getEmail()+ "'";
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
    public boolean delete(int userId) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_user"
                    + " WHERE id = '" + userId + "'";
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
    
    public List<User> findAll() {
        List<User> users = null;

        try {
            String sql = "SELECT * FROM tbl_user";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            users = new ArrayList<User>();
            User user;
            while (result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setUserName(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setAddress(result.getString("address"));
                user.setPhone(result.getString("phone"));
                user.setImg(result.getString("img"));
                user.setStatus(result.getInt("status"));
                user.setUrl(result.getLong("url"));
                //System.out.println(user.getId()+ "|" + user.getUserName()+ "|" + user.getAddress()+ "|" + user.getPhone());
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public User findUrl(long url){
        User user = null;
        try {
            String sql = "SELECT * FROM tbl_user WHERE url = '" + url +"'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);         
            if (result.next()) {
                user = new User();
                user.setUserName(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setAddress(result.getString("address"));
                user.setImg(result.getString("img"));
                user.setStatus(result.getInt("status"));
                user.setUrl(result.getLong("url"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return user;
    }
    
    public boolean editStatus(User user) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_user SET status = '" + user.getStatus() + "'"
                    + " WHERE url = '" + user.getUrl()+ "'";
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
    
    public boolean editPass(User user) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_user SET password = '" + user.getPassword() + "'"
                    + " WHERE email = '" + user.getEmail()+ "'";
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
    
    public boolean findPassword(String password){
         try {
            String sql = "SELECT * FROM tbl_user WHERE password = '" +password + "'";
                    
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }

    public boolean find(User user) {
        try {
            String sql = "SELECT * FROM tbl_user WHERE email = '" + user.getEmail()
                    + "' and password = '" + user.getPassword() + "'"
                    + "' and status = '"+user.getStatus()+"'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if (result.next()) {
                user = new User();
                user.setUserName(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setAddress(result.getString("address"));
                user.setImg(result.getString("img"));
                user.setStatus(result.getInt("status"));
                user.setUrl(result.getLong("url"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    
//    public static void main(String[] args){
//        
//        UserDao userDao = new UserDao();
//        String email = "kiet7@gmail.com";
//        
//        userDao.find(email);
//        
//    }
    
}
