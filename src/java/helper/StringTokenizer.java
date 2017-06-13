/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class StringTokenizer {

    public static List<String> stringTokenizer(String str, String delim) {
        //java.util.StringTokenizer strtokenizer = new java.util.StringTokenizer(str);
        List<String> strs = new ArrayList<String>();
        java.util.StringTokenizer stokenizer = new java.util.StringTokenizer(str, delim);
        System.out.println("\nThe stokenizer includes " + stokenizer.countTokens() + " tokens.");
        while (stokenizer.hasMoreElements()) {
            // returns an object
            String tok = (String) stokenizer.nextElement();
            strs.add(tok);            
        }
        return strs;
    }
}
