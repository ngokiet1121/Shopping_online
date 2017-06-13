/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DateConverter {

    public static java.util.Date convertToUtilDate(java.sql.Date date) {
        java.util.Date javaDate = null;
        if (date != null) {
            javaDate = new java.util.Date(date.getTime());
        }
        return date;

    }

    public static java.sql.Date convertToSqlDate(java.util.Date date) {
        java.sql.Date sqlDate = null;
        if (date != null) {
            sqlDate = new java.sql.Date(date.getTime());
        }
        return sqlDate;
    }
    
    public static java.util.Date convertStringToDate(String date){
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");        
            return df.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
