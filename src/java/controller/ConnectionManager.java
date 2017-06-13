package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;

/**
 *
 * @author DELL
 */
public class ConnectionManager {

    private static Connection connection = null;
    private static final String url = "jdbc:mysql://localhost:3307/";
    private static final String dbName = "banhangv4";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "usbw";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver).newInstance();
                connection = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            } catch (Exception sqle) {
                sqle.printStackTrace();
            }
        }

        return connection;
    }
    
//    public static void main(String[] args) {
//        System.out.println(getConnection()!=null);
//    }

}
