/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Item {

    public int id;
    public String name;
    public String description;
    public int price;
    public int number;
    public String img;
    public Type type;
    public Trademark trademark;

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public List<CTBill> ctBills;

    public Item(Trademark trademark, Type type, int price, int number) {
        this.trademark = trademark;
        this.type = type;
        //this.description = description;
        this.price = price;
        this.number = number;
    }

    public Item(int id, Trademark trademark, Type type, int price, int number) {
        this.id = id;
        this.trademark = trademark;
        this.type = type;
        // this.description = description;
        this.price = price;
        this.number = number;
    }

    public Item(String name, String description, int price, int number, String img) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.number = number;
        this.img = img;
    }

    public Item(int id, int price, int number) {
        this.id = id;
        this.price = price;
        this.number = number;
    }

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String img) {
        this.id = id;
        this.img = img;
    }

    public Item(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<CTBill> getCtBills() {
        return ctBills;
    }

    public void setCtBills(List<CTBill> ctBills) {
        this.ctBills = ctBills;
    }

    @Override
    public String toString() {
        return name + description;
    }
}
