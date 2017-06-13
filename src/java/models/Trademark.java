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
public class Trademark {
    public int id;
    public String trademark;
    public String img;
    public List<Item> dsItem;
    public String banner;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    
    public Trademark(String trademark, String img){
        this.trademark = trademark;
        this.img = img;
    }
    
    public Trademark(int id,String trademark, String img){
        this.id = id;
        this.trademark = trademark;
        this.img = img;
    }
    
    public Trademark(){
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Item> getDsItem() {
        return dsItem;
    }

    public void setDsItem(List<Item> dsItem) {
        this.dsItem = dsItem;
    }
    @Override
    public String toString(){
        return trademark;
    }
    
}
