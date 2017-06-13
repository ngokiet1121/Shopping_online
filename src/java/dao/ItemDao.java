/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConnectionManager;
import models.Item;

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
public class ItemDao {

    TrademarkDao trademarkDao = new TrademarkDao();
    TypeDao typeDao = new TypeDao();
    SizeDao sizeDao = new SizeDao();
    Statement statement;
    Connection connection = ConnectionManager.getConnection();

    private int noOfRecords;
    public static int count = 0;

    public Item find(int id) {
        Item item = null;
        try {
            String sql = "SELECT * FROM tbl_items WHERE id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            if (result.next()) {
                item = new Item();
                item.setId(result.getInt("id"));
                item.setTrademark(trademarkDao.find(result.getInt("idtrademark")));
                item.setType(typeDao.find(result.getInt("Idtype")));
                item.setPrice(result.getInt("price"));
                item.setNumber(result.getInt("number"));
                item.setImg(result.getString("img"));
                //System.out.println(item.getId() + "|" + item.getDescription() + "|" + item.getPrice() + "|" + item.getNumber());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public boolean add(Item items) {
        try {
            String sql = "INSERT INTO tbl_items (idtrademark, Idtype,price,number) VALUES ('"
                    + items.getTrademark().getId()
                    + "', '" + items.getType().getId()
                    + "', '" + items.getPrice()
                    + "', '" + items.getNumber()
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

    public boolean edit(Item item) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_items SET "
                    + "idtrademark = '" + item.getTrademark().getId() + "'"
                    + ",Idtype = '" + item.getType().getId() + "'"
                    //+ ",description = '" + item.getDescription() + "'"
                    + ",price = '" + item.getPrice() + "'"
                    + ",number = '" + item.getNumber() + "'"
                    + " WHERE id = '" + item.getId() + "'";
            System.out.println(sql);
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
    public boolean addimage(Item item) {
        int noOfRecords = 0;
        try {
            String sql = "UPDATE tbl_items SET "                   
                    + "img = '" + item.getImg() + "'"
                    + " WHERE id = '" + item.getId() + "'";
            System.out.println(sql);
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

    public boolean delete(int id) {
        int noOfRecords = 0;
        try {
            String sql = "DELETE FROM tbl_items"
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

    public List<Item> findAll() {
        List<Item> items = null;

        try {
            String sql = "SELECT * FROM tbl_items";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            items = new ArrayList<Item>();
            Item item;
            while (result.next()) {
                item = new Item();
                item.setId(result.getInt("id"));
                item.setTrademark(trademarkDao.find(result.getInt("idtrademark")));
                item.setType(typeDao.find(result.getInt("Idtype")));
                item.setPrice(result.getInt("price"));
                item.setNumber(result.getInt("number"));
                item.setImg(result.getString("img"));
                items.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }

    public List<Item> findAllbyType(int Idtype) {
        List<Item> items = null;
        try {
            String sql = "SELECT * FROM tbl_items WHERE Idtype = '" + Idtype + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.print(sql);
            items = new ArrayList<Item>();
            Item item;
            while (result.next()) {
                item = new Item();
                item.setId(result.getInt("id"));
                item.setTrademark(trademarkDao.find(result.getInt("idtrademark")));
                item.setType(typeDao.find(result.getInt("Idtype")));
                // item.setDescription(result.getString("description"));
                item.setPrice(result.getInt("price"));
                item.setNumber(result.getInt("number"));
                item.setImg(result.getString("img"));
                items.add(item);
                System.out.println(item.getId() + " | " + item.getType());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }

    public List<Item> findAllbyTrademark(int idtrademark) {
        List<Item> items = null;
        try {
            String sql = "SELECT * FROM tbl_items WHERE idtrademark = '" + idtrademark + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.print(sql);
            items = new ArrayList<Item>();
            Item item;
            while (result.next()) {
                item = new Item();
                item.setId(result.getInt("id"));
                item.setTrademark(trademarkDao.find(result.getInt("idtrademark")));
                item.setType(typeDao.find(result.getInt("Idtype")));
                // item.setDescription(result.getString("description"));
                item.setPrice(result.getInt("price"));
                item.setNumber(result.getInt("number"));
                item.setImg(result.getString("img"));
                items.add(item);
                System.out.println(item.getId() + " | " + item.getTrademark());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    public List<Item> findAllbyTypeAndTra(int Idtype, int idTrademark) {
        List<Item> items = null;
        try {
            String sql = "SELECT * FROM tbl_items WHERE"
                    + " Idtype = '" + Idtype + "'"
                    + " AND idtrademark = '" + idTrademark + "'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.print(sql);
            items = new ArrayList<Item>();
            Item item;
            while (result.next()) {
                item = new Item();
                item.setId(result.getInt("id"));
                item.setTrademark(trademarkDao.find(result.getInt("idtrademark")));
                item.setType(typeDao.find(result.getInt("Idtype")));
                item.setPrice(result.getInt("price"));
                item.setNumber(result.getInt("number"));
                item.setImg(result.getString("img"));
                items.add(item);
                System.out.println(item.getId() + " | " + item.getType() + "|" + item.getTrademark());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }
    public List<Item> viewAllByTra(
            int idtra,
            int offset,
            int noOfRecords) {
        String query = "SELECT * FROM tbl_items WHERE idtrademark = '" + idtra + "' limit "
                + offset + ", " + noOfRecords + "";
        List<Item> list = new ArrayList<Item>();
        Item item = null;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("count   "+count);
            while (rs.next()) {
                item = new Item();
                item.setId(rs.getInt("id"));
                item.setPrice(rs.getInt("price"));
                item.setTrademark(trademarkDao.find(rs.getInt("idtrademark")));
                item.setType(typeDao.find(rs.getInt("Idtype")));
                item.setNumber(rs.getInt("number"));
                item.setImg(rs.getString("img"));
                list.add(item);
                System.out.println("id" + item.getId() + "price" + item.getPrice() );
            }
            rs = statement.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Item> viewAllByType(
            int idType,
            int offset,
            int noOfRecords) {
        String query = "SELECT * FROM tbl_items WHERE Idtype = '" + idType + "' limit "
                + offset + ", " + noOfRecords + "";
        List<Item> list = new ArrayList<Item>();
        Item item = null;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("count   "+count);
            while (rs.next()) {
                item = new Item();
                item.setId(rs.getInt("id"));
                item.setPrice(rs.getInt("price"));
                item.setTrademark(trademarkDao.find(rs.getInt("idtrademark")));
                item.setType(typeDao.find(rs.getInt("Idtype")));
                item.setNumber(rs.getInt("number"));
                item.setImg(rs.getString("img"));
                list.add(item);
                System.out.println("id" + item.getId() + "price" + item.getPrice() );
            }
            rs = statement.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
