package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.b;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class e
{
  public static String a()
  {
    try
    {
      if (TextUtils.isEmpty(Build.VERSION.RELEASE)) {}
      for (String str = "";; str = Build.VERSION.RELEASE) {
        return URLEncoder.encode(str, "UTF-8");
      }
      return "";
    }
    catch (Exception localException) {}
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    for (;;)
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream("/system/etc/hosts");
        Object localObject = new byte[localFileInputStream.available()];
        localFileInputStream.read((byte[])localObject);
        localObject = new String((byte[])localObject);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("passport.baidu.com")))
        {
          b.a(paramContext).b(true);
          localFileInputStream.close();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        b.a(paramContext).b(false);
        L.e(localThrowable);
        return;
      }
      b.a(paramContext).b(false);
    }
  }
  
  public static String b()
  {
    try
    {
      if (TextUtils.isEmpty(Build.BRAND)) {}
      for (String str = "";; str = Build.BRAND) {
        return URLEncoder.encode(str, "UTF-8");
      }
      return "";
    }
    catch (Exception localException) {}
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String c()
  {
    try
    {
      if (TextUtils.isEmpty(Build.MODEL)) {}
      for (String str = "";; str = Build.MODEL) {
        return URLEncoder.encode(str, "UTF-8");
      }
      return "";
    }
    catch (Exception localException) {}
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (TextUtils.isEmpty(paramContext.getMacAddress())) {
        return "";
      }
      paramContext = paramContext.getMacAddress();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String d()
  {
    return "os_version=" + a() + "&brand_name=" + b() + "&brand_model=" + c() + "&os_type=" + "Android";
  }
  
  public static String d(Context paramContext)
  {
    return MD5Util.toMd5((b(paramContext) + c(paramContext)).getBytes(), false).replace("\n", "");
  }
  
  public static class a
  {
    private static final String a = "MD5";
    private static final String b = "AES";
    private static final String c = "UTF-8";
    private static final int d = 16;
    private static final int e = 16;
    
    public static String a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramString = b(paramString.getBytes("UTF-8"));
        String str = a(b(paramString + "js52je)927!hsm^%3m"));
        paramString = a(paramString + "." + str, "js52je)927!hsm^%3m");
        return paramString;
      }
      catch (Exception paramString)
      {
        L.e(paramString);
      }
      return null;
    }
    
    public static String a(String paramString1, String paramString2)
    {
      try
      {
        String str = a(b(paramString2.trim()));
        paramString2 = str.substring(0, 16);
        str = new StringBuffer(str.substring(0, 16)).reverse().toString();
        Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
        localCipher.init(1, new SecretKeySpec(paramString2.getBytes("UTF-8"), "AES"), new IvParameterSpec(str.getBytes("UTF-8")));
        paramString1 = b(localCipher.doFinal(c(paramString1.getBytes("UTF-8"))));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        L.e(paramString1);
      }
      return null;
    }
    
    public static String a(byte[] paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public static String b(String paramString1, String paramString2)
    {
      try
      {
        String str = a(b(paramString2.trim()));
        paramString2 = str.substring(0, 16);
        str = new StringBuffer(str.substring(0, 16)).reverse().toString();
        Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
        localCipher.init(2, new SecretKeySpec(paramString2.getBytes("UTF-8"), "AES"), new IvParameterSpec(str.getBytes("UTF-8")));
        paramString1 = b(localCipher.doFinal(c(paramString1.getBytes("UTF-8"))));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        L.e(paramString1);
      }
      return null;
    }
    
    public static String b(byte[] paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int k = 0;
      int n = 6;
      int i1 = 0;
      int m = 0;
      int i2 = paramArrayOfByte.length * 8;
      int i = 0;
      int j;
      if ((k > 0) && (n > 0))
      {
        i = (byte)((byte)((paramArrayOfByte[i1] & 0xFF) << n | (paramArrayOfByte[(i1 + 1)] & 0xFF) >> 8 - n) & 0x3F);
        k = 8 - n;
        j = 6 - k;
      }
      for (;;)
      {
        localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i));
        m += 6;
        i1 = m / 8;
        int i3 = i2 - m;
        n = j;
        if (i3 >= 6) {
          break;
        }
        if (i3 > 0) {
          localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(paramArrayOfByte[(paramArrayOfByte.length - 1)] << 6 - i3 & 0x3F)));
        }
        i = 0;
        while (i < i2 % 3)
        {
          localStringBuilder.append("=");
          i += 1;
        }
        if (k == 0)
        {
          i = (byte)((paramArrayOfByte[i1] & 0xFF) >> 8 - n);
          k = 2;
          j = 4;
        }
        else
        {
          j = n;
          if (n == 0)
          {
            i = (byte)(paramArrayOfByte[i1] & 0x3F);
            k = 0;
            j = 6;
          }
        }
      }
      return localStringBuilder.toString();
    }
    
    private static byte[] b(String paramString)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes());
        paramString = localMessageDigest.digest();
        return paramString;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        L.e(paramString);
      }
      return null;
    }
    
    private static byte[] c(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte.length % 16 != 0)
      {
        byte[] arrayOfByte = new byte[(paramArrayOfByte.length / 16 + 1) * 16];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        int i = paramArrayOfByte.length;
        for (;;)
        {
          paramArrayOfByte = arrayOfByte;
          if (i >= arrayOfByte.length) {
            break;
          }
          arrayOfByte[i] = 0;
          i += 1;
        }
      }
      return paramArrayOfByte;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */