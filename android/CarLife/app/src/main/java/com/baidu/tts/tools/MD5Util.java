package com.baidu.tts.tools;

import android.annotation.SuppressLint;
import java.security.MessageDigest;

@SuppressLint({"DefaultLocale"})
public class MD5Util {
    public static String toMd5(byte[] paramArrayOfByte, boolean paramBoolean) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(paramArrayOfByte);
            return toHexString(instance.digest(), "", paramBoolean);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHexString(byte[] paramArrayOfByte, String paramString, boolean paramBoolean) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : paramArrayOfByte) {
            String toHexString = Integer.toHexString(b & 255);
            if (paramBoolean) {
                toHexString = toHexString.toUpperCase();
            }
            if (toHexString.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(toHexString).append(paramString);
        }
        return stringBuilder.toString();
    }
}
