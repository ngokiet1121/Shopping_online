/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Rate {
    public int id;
    public User user;
    public Item item;
    public double rate;
    public double rateTotal;

    public Rate(){}
    
    public Rate(Item item,double rate){
        this.item = item;
        this.rate = rate;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRateTotal() {
        return rateTotal;
    }

    public void setRateTotal(double rateTotal) {
        this.rateTotal = rateTotal;
    }
    
}
