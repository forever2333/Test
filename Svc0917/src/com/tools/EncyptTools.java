package com.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncyptTools {
	private static String encyption="";
	
	public static String MessageEncypt(String msg){
		char[] hex="0123456789abcdef".toCharArray();
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			md.update(msg.getBytes());
			byte[] b=md.digest();
			char[] rc=new char[b.length*2];
			int k=0;
			for(int i=0;i<b.length;i++){
				rc[k++]=hex[b[i]>>>4&0xf];
				rc[k++]=hex[b[i]&0xf];
			}
			encyption=new String(rc);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encyption;
	}
}
