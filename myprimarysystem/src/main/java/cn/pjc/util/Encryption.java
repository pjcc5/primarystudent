package cn.pjc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Encryption {
	public static String getKey(String password) 
	{
		MessageDigest md;
		StringBuilder sb =null;
		try {
			md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes());
			//生成结果
			byte[] result  = md.digest();
			sb = new StringBuilder();
			for (byte b : result) {
				sb.append(Integer.toHexString(b));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static String toSecretKey(String pass)
	{
		 byte[] secretBytes = null;
	        try {
	            secretBytes = MessageDigest.getInstance("md5").digest(
	            		pass.getBytes());
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("没有这个md5算法！");
	        }
	        String md5code = new BigInteger(1, secretBytes).toString(16);
	        for (int i = 0; i < 32 - md5code.length(); i++) {
	            md5code = "0" + md5code;
	        }
	        return md5code;
	    }
	}

