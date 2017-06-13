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
public class Size {
    public int id;
    public String size;
    public List<CTBill> ctBills;

    public List<CTBill> getCtBills() {
        return ctBills;
    }

    public void setCtBills(List<CTBill> ctBills) {
        this.ctBills = ctBills;
    }
    
    public Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public String toString(){
        return size;
    }
}
