/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Bill {
    public int id;
    public User user;
    public int totalPrice;
    public int status;
    public int date;
    public int month;
    public int year;
    public int sale;

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }  
    public Bill(int id,int status){
        this.id = id;
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public List<CTBill> ctBills;

    public Bill (){}
    
    public Bill(User user,int date,int month,int year,int totalPrice,int status,int sale){
        this.user = user;
        this.date = date;
        this.month = month;
        this.year = year;
        this.totalPrice = totalPrice;
        this.status = status;
        this.sale = sale;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

   

    public List<CTBill> getCtBills() {
        return ctBills;
    }

    public void setCtBills(List<CTBill> ctBills) {
        this.ctBills = ctBills;
    }
    
    
}
