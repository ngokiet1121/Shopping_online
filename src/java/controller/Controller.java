/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import dao.BannerDao;
import dao.BillDao;
import dao.CTBillDao;
import dao.ItemDao;
import dao.SaleDao;
import dao.ShopDao;
import dao.TrademarkDao;
import dao.TypeDao;
import dao.UserDao;
import helper.SimpleThread;
import java.util.Date;
import java.util.List;
import models.Admin;
import models.Banner;
import models.Bill;
import models.Item;
import models.Sale;
import models.Shop;
import models.Trademark;
import models.Type;
import models.User;

/**
 *
 * @author DELL
 */
public class Controller {

    public static int grand = 0;

    public static Controller controller = new Controller();
    UserDao userDao = new UserDao();
    ItemDao itemDao = new ItemDao();
    AdminDao adminDao = new AdminDao();
    BillDao billDao = new BillDao();
    CTBillDao ctbillDao = new CTBillDao();
    TypeDao typeDao = new TypeDao();
    BannerDao bannerDao = new BannerDao();
    SaleDao saleDao = new SaleDao();
    TrademarkDao trademarkDao = new TrademarkDao();
    ShopDao shopDao = new ShopDao();
    public Controller() {
        SimpleThread removeDataThread = new SimpleThread();
        Thread oneThread = new Thread(removeDataThread);
        oneThread.start();
    }

    public boolean checkLogin(User user) {
        User getUser = userDao.find(user.getEmail());
        if (getUser != null && getUser.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean checkLoginA(Admin admin) {
        Admin getAdmin = adminDao.find(admin.getEmail());
        if (getAdmin != null && getAdmin.getPassword().equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    public User findUser(String email) {
        User user = null;
        user = userDao.find(email);
        return user;
    }
    public Shop findShop(int id)
    {
        Shop shop = null;
        shop = shopDao.find(id);
        return shop;
    }
    
    public Type findT(int id){
        Type type ;
        type = typeDao.find(id);
        return type;
    }
    
    public Trademark findTra(int id){
        Trademark tra ;
        tra = trademarkDao.find(id);
        return tra;
    }
    

    public boolean addUser(User user) {
        return userDao.add(user);
    }

    public boolean changePassWord(User user) {
        return userDao.editPass(user);
    }
    public boolean changePassWordA(Admin admin) {
        return adminDao.editPass(admin);
    }
    public boolean editUser(User user) {
        return userDao.edit(user);
    }

    public User findById(int id) {
        return userDao.find(id);
    }

    public boolean deleteUser(int userId) {
        return userDao.delete(userId);
    }

    public boolean createItem(Item item) {
        return itemDao.add(item);
    }

    public Item findItem(int id) {
        return itemDao.find(id);
    }

    public boolean editItem(Item item) {
        return itemDao.edit(item);
    }

    public boolean deleteItem(int id) {
        return itemDao.delete(id);
    }

    public boolean changePassWordAdmin(Admin admin) {
        return adminDao.editPass(admin);
    }

    public boolean findEmail(String email) {
        Admin getAdmin = adminDao.find(email);
        if (getAdmin != null) {
            return true;
        }
        return false;
    }
    public boolean findEmailUser(String email) {
        User getUser = userDao.find(email);
        if (getUser != null) {
            return true;
        }
        return false;
    }

    public boolean findIdBill(int id) {
        Bill getbill = billDao.find(id);
        if (getbill != null) {
            return true;
        }
        return false;
    }
    
    
    
    public boolean findUrl(long url) {
        User getUser = userDao.findUrl(url);
        if (getUser != null) {
            return true;
        }
        return false;
    }

    public List<Type> findType() {
        return typeDao.findAll();
    }

    public List<Banner> findBanner() {
        return bannerDao.findAll();
    }

    public List<Sale> findSale() {
        return saleDao.findAll();
    }

    public List<Trademark> findTrademark(){
        return trademarkDao.findAll();
    }
    
    public boolean sale() {
        List<Sale> listSale = saleDao.findAll();
        Date date = new Date();
        try {
            if (listSale != null) {
                for (int i = 0; i < listSale.size();) {
                    if (listSale.get(i).getNgayBatdau().before(date)
                            && listSale.get(i).getNgayKetThuc().after(date)) {
                        grand = listSale.get(i).getSale();
                    }
                    i++;
                }
            } else {
                grand = 0;
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean autoRemove() {
        List<Bill> bills = billDao.findAll();
        Date date = new Date();
        try {
            for (int i = 0; i < bills.size();) {
                Bill bill = billDao.find(bills.get(i).getId());
                if (!((bill.getDate() - date.getDate() == 0))) {
                    if (bill.getStatus() == 1) {
                        billDao.delete(bill.getId());
                        ctbillDao.delete(bill.getId());
                        helper.SendMailTLS.sendEmail("ngoletuankiet1@gmail.com", "Thong Bao", "Don Hang cua ban da bi xoa");
                    } else {
                        System.out.println("Khong co bill nao phu hop dieu kien ");
                    }
                }
                i++;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Loi!" + e);
        } finally {
            System.out.println("Có lỗi hay không thì cái dòng cuối cùng này vẫn được in ra! :)");
        }
        return false;
    }
//
//    public static void main(String[] args) {
//        if(controller.sale()){
//            System.out.println("Done");
//            Date date = new Date();
//            System.out.println("day " + date.getDate()+ "ddd" );
//        }
//    }
}
