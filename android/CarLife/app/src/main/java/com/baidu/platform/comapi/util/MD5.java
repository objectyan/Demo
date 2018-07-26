package com.baidu.platform.comapi.util;

import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    protected static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int MD5_16_LENGTH = 16;
    private static final int MD5_16_START = 8;
    private static final int MD5_LENGTH = 32;

    public static String getMD5String(String s) {
        return getMD5String(s.getBytes());
    }

    public static String getMD5String(byte[] bytes) {
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        if (messagedigest == null) {
            return "";
        }
        messagedigest.update(bytes);
        try {
            return bufferToHex(messagedigest.digest());
        } catch (Exception e2) {
            return "";
        }
    }

    public static String getMD5String16(String s) {
        String md5 = getMD5String(s.getBytes());
        if (md5.length() == 32) {
            return md5.substring(8, 24);
        }
        return null;
    }

    public static boolean checkPassword(String password, String md5PwdStr) {
        return getMD5String(password).equals(md5PwdStr);
    }

    public static String getFileMD5String(File file) throws IOException {
        return getFileMD5String(file, 131072);
    }

    public static String getFileMD5String(File file, int bufSize) throws IOException {
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        if (messagedigest == null) {
            return "";
        }
        InputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[bufSize];
        while (true) {
            int numRead = fis.read(buffer);
            if (numRead > 0) {
                messagedigest.update(buffer, 0, numRead);
            } else {
                fis.close();
                try {
                    return bufferToHex(messagedigest.digest());
                } catch (Exception e2) {
                    throw new IOException(e2.toString());
                }
            }
        }
    }

    public static String getFileMD5StringNIO(File file) throws IOException {
        return getFileMD5StringNIO(file, 131072);
    }

    public static String getFileMD5StringNIO(File file, int bufSize) throws IOException {
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        if (messagedigest == null) {
            return "";
        }
        FileInputStream fis = new FileInputStream(file);
        FileChannel fChannel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(bufSize);
        for (int count = fChannel.read(buffer); count != -1; count = fChannel.read(buffer)) {
            buffer.flip();
            messagedigest.update(buffer);
            if (!buffer.hasRemaining()) {
                buffer.clear();
            }
        }
        fis.close();
        try {
            return bufferToHex(messagedigest.digest());
        } catch (Exception e2) {
            throw new IOException(e2.toString());
        }
    }

    public static String getSignMD5String(String params) {
        return URLEncodeUtils.generateSign(1, params);
    }

    public static String getWebSignMD5String(String params) {
        return URLEncodeUtils.generateSign(2, params);
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(n * 2);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = HEX_DIGITS[(bt & RGHUDDataModel.MAX_CAR_SPEED) >> 4];
        char c1 = HEX_DIGITS[bt & 15];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static String signOpra(String params) {
        return URLEncodeUtils.generateSign(3, params);
    }
}
