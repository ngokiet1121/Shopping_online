/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import models.Admin;
import helper.BooleanConverter;
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
public class AdminDao {
    Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public Admin find(int id) {
        Admin admin = null;
        try {
            String sql = "SELECT * FROM tbl_admin WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                admin = new Admin();
                admin.setName(result.getString("name"));
                admin.setEmail(result.getString("email"));
                admin.setPassword(result.getString("password"));
                admin.setPhone(result.getString("phone"));
                admin.setAddress(result.getString("address"));
               // System.out.println(admin.getName() + "|" + admin.getPassword());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
    
    public Admin find(String email) {
        Admin admin = null;
        try {
            String sql = "SELECT * FROM tbl_admin WHERE email = '" + email + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            if (result.next()) {                
                admin = new Admin();  
                admin.setId(result.getInt("id"));
                admin.setName(result.getString("name"));
                admin.setEmail(result.getString("email"));
                admin.setPassword(result.getString("password")); 
                admin.setPhone(result.getString("phone"));
                admin.setAddress(result.getString("address"));
                System.out.println(admin.getName()+ "|" +admin.getEmail()+ "|" + admin.getPassword());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
    
    public boolean add(Admin admin) {
        try {
            String sql = "INSERT INTO tbl_admin (name, email, password,address,phone) VALUES ('"
                    + admin.getName()
                    + "', '" + admin.getEmail()
                    + "', '" + admin.getPassword()
                    + "', '" + admin.getAddress()
                    + "', '" + admin.getPhone()
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
    
    public void edit(Admin admin) {
        try {
            String sql = "UPDATE tbl_admin SET "
                    + "name = '" + admin.getName()+ "'"
                    + ",address = '" + admin.getAddress()+ "'"
                    + ",phone = '" + admin.getPhone()+ "'"    
                    + ",email = '" + admin.getEmail()+ "'"
                    + ",password = '" + admin.getPassword()+ "'"
                    + " WHERE email = '" + admin.getEmail()+ "'";
            System.out.println(sql);
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id) {
        try {
            String sql = "DELETE FROM tbl_admin"
                    + " WHERE id = '" + id + "'";
//            System.out.println(sql);
            statement = connection.createStatement();
            int noOfRecords = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Admin> findAll() {
        List<Admin> admins = null;

        try {
            String sql = "SELECT * FROM tbl_admin";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            admins = new ArrayList<Admin>();
            Admin admin;
            while (result.next()) {
                admin = new Admin();
                admin.setId(result.getInt("id"));
                admin.setName(result.getString("name"));
                admin.setName(result.getString("nmail"));
                admin.setName(result.getString("password"));
                admin.setName(result.getString("phone"));
                admin.setName(result.getString("address"));
                //System.out.println(admin.getName()+ "|" + admin.getPassword());
                admins.add(admin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return admins;
    }
    public boolean find(Admin admin) {
        try {
            String sql = "SELECT * FROM tbl_admin WHERE email = '" + admin.getEmail()
                    + "' and password = '" + admin.getPassword() + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                admin = new Admin();
                admin.setName(result.getString("name"));
                admin.setEmail(result.getString("email"));
                admin.setPassword(result.getString("password"));
                admin.setPhone(result.getString("phone"));
                admin.setAddress(result.getString("address"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//    public static void main(String[] args){
//        
//        AdminDao adminDao = new AdminDao();
//        Admin admin = new Admin();
//        adminDao.find(admin.getEmail());
//        
//    }
       public boolean editPass(Admin admin) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_admin SET password = '" + admin.getPassword() + "'"
                    + " WHERE email = '" + admin.getEmail()+ "'";
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
    
}
