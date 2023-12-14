package com.scwl.utils;

import org.apache.poi.xdgf.usermodel.section.geometry.RelEllipticalArcTo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static String accessKey="0d28e5b233efbe246944c13af55d46cd7870a996cf3b6edc2353e9e5107e2cab";

    public static String encryptMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

   public static Boolean check(String input){
       if(input.equals(accessKey)){
           return true;
       }
       return false;
   }
    public static void main(String[] args) {
        String input = "Scwl666.*";
        String md5 = encryptMD5(input);
        //c972568f3f2fd94da0c111d7273fed48
        String s = encryptSHA(input);
        System.out.println("SHA加密后的字符串： " + s);
        System.out.println("MD5加密后的字符串： " + md5);
    }

    public static String encryptSHA(String text){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return  hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
