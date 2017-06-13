/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
/**
 *
 * @author ADMIN
 */
public class SimpleThread implements Runnable {
    public static final long INTERVAL = 24*60*60*1000L; //1 day caculated by miliseconds
    public void run() {
        try {           
            if(controller.Controller.controller.autoRemove()){
                System.out.println("Done");
            } 
            Thread.sleep(INTERVAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
