package com.baidu.mapframework.commonlib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public String str;

    public static String md5s(String plainText) {
        String str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();
            StringBuffer buf = new StringBuffer("");
            for (int i : b) {
                int i2;
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i2));
            }
            str = buf.toString();
            str = buf.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return str;
    }
}
