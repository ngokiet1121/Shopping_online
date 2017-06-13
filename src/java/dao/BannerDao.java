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
import models.Banner;

/**
 *
 * @author ADMIN
 */
public class BannerDao {
     Statement statement;
    Connection connection = ConnectionManager.getConnection();
    public Banner find(int id) {
        Banner banner = null;
        try {
            String sql = "SELECT * FROM tbl_banner WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                banner = new Banner();
                banner.setId(result.getInt("id"));
                banner.setBanner(result.getString("banner"));

                //System.out.println(user.getUserName()+ "|" +user.getEmail()+ "|" + user.getPassword() + "|" + user.getPhone() + "|" + user.getAddress());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banner;
    }
    

    public Banner find(String s) {
        Banner banner = null;
        try {
            String sql = "SELECT * FROM tbl_banner WHERE banner = '" + s + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                banner = new Banner();
                banner.setId(result.getInt("id"));
                banner.setBanner(result.getString("banner"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banner;
    }
    
    public boolean add( Banner banner) {
        try {
            String sql = "INSERT INTO tbl_banner (banner) VALUES ('"
                    + banner.getBanner()
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
    
    public boolean edit(Banner banner) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_banner SET "
                    + "banner = '" + banner.getBanner()+ "'"          
                    + " WHERE id = '" + banner.getId()+ "'";
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
            String sql = "DELETE FROM tbl_banner"
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
    
    public List<Banner> findAll() {
        List<Banner> banners = null;
        try {
            String sql = "SELECT * FROM tbl_banner";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            banners = new ArrayList<Banner>();
            Banner banner;
            while (result.next()) {
                banner = new Banner();
                banner.setId(result.getInt("id"));
                banner.setBanner(result.getString("banner"));              
                //System.out.println(user.getId()+ "|" + user.getUserName()+ "|" + user.getAddress()+ "|" + user.getPhone());
                banners.add(banner);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return banners;
    }
}
