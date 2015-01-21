package com.oracle.hackson.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class EncryptUtil {

    public static String md5Encryption(String str) {  
        String newStr = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            BASE64Encoder base = new BASE64Encoder();  
            newStr = base.encode(md5.digest(str.getBytes("UTF-8")));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return newStr;  
    } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = EncryptUtil.md5Encryption("123");
		System.out.println(EncryptUtil.md5Encryption("123").equals(a));
	}

}
