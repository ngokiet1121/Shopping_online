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
import models.Shop;


/**
 *
 * @author ADMIN
 */
public class ShopDao {
         Statement statement;
    Connection connection = ConnectionManager.getConnection();
    
    public Shop find(int id) {
        Shop shop = null;
        try {
            String sql = "SELECT * FROM shop WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //System.out.println(sql);
            if (result.next()) {
                shop = new Shop();             
                shop.setId(result.getInt("id"));
                shop.setName(result.getString("name"));
                shop.setAddress(result.getString("address"));
                shop.setPhone(result.getString("phone"));
                shop.setEmail(result.getString("email"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shop;
    }         
    public boolean edit(Shop shop) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE shop SET "
                    + "name = '" + shop.getName()+ "'"
                    + ",address = '" + shop.getAddress()+ "'"
                    + ",phone = '" + shop.getPhone()+ "'"
                    + ",email = '" + shop.getEmail()+ "'"
                    + " WHERE id = '" + shop.getId()+ "'";
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
