package com.baidu.navi.track.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TrackFileUtil {
    private static final String UID = "";

    public static String trackFileSign(String path, String guid) {
        if (TextUtils.isEmpty(path) || TextUtils.isEmpty(guid)) {
            return "";
        }
        File file = new File(path + File.separator + guid + ".bin.gz");
        if (!file.exists()) {
            return "";
        }
        String md5 = getMd5OfFile(file.getAbsolutePath());
        if (TextUtils.isEmpty(md5)) {
            return "";
        }
        String strTmpMd5 = getMD5EncryptedString(md5 + "" + guid);
        if (TextUtils.isEmpty(strTmpMd5)) {
            return "";
        }
        return new StringBuffer(strTmpMd5).reverse().toString();
    }

    public static String getMd5OfFile(String filePath) {
        String returnVal = "";
        try {
            InputStream input = new FileInputStream(filePath);
            byte[] buffer = new byte[1024];
            MessageDigest md5Hash = MessageDigest.getInstance("MD5");
            int numRead = 0;
            while (numRead != -1) {
                numRead = input.read(buffer);
                if (numRead > 0) {
                    md5Hash.update(buffer, 0, numRead);
                }
            }
            input.close();
            for (byte b : md5Hash.digest()) {
                returnVal = returnVal + Integer.toString((b & 255) + 256, 16).substring(1);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return returnVal.toUpperCase();
    }

    public static String getMD5EncryptedString(String encTarget) {
        MessageDigest mdEnc = null;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception while encrypting to md5");
            e.printStackTrace();
        }
        mdEnc.update(encTarget.getBytes(), 0, encTarget.length());
        String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
        while (md5.length() < 32) {
            md5 = "0" + md5;
        }
        return md5;
    }
}
