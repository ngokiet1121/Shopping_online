/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Sale {

    public int id;
    public Date ngayBatdau;
    public Date ngayKetThuc;
    public int sale;

    public Sale() {
    }

    public Sale(Date ngayBatDau, Date ngayKetThuc, int sale) {
        this.ngayBatdau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.sale = sale;
    }

    public Sale(int id, Date ngayBatDau, Date ngayKetThuc, int sale) {
        this.id = id;
        this.ngayBatdau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayBatdau() {
        return ngayBatdau;
    }

    public void setNgayBatdau(Date ngayBatdau) {
        this.ngayBatdau = ngayBatdau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

}
