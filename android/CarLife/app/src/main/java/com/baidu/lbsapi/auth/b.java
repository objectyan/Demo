package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

class b
{
  static String a()
  {
    return Locale.getDefault().getLanguage();
  }
  
  protected static String a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = a(paramContext, str);
    return paramContext + ";" + str;
  }
  
  private static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      paramContext = a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramContext[0].toByteArray())));
      paramString = new StringBuffer();
      int i = 0;
      while (i < paramContext.length())
      {
        paramString.append(paramContext.charAt(i));
        if ((i > 0) && (i % 2 == 1) && (i < paramContext.length() - 1)) {
          paramString.append(":");
        }
        i += 1;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
    catch (CertificateException paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
    return paramString.toString();
  }
  
  static String a(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = a.a(a(paramX509Certificate.getEncoded()));
      return paramX509Certificate;
    }
    catch (CertificateEncodingException paramX509Certificate) {}
    return null;
  }
  
  static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA1").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  protected static String[] b(Context paramContext)
  {
    Object localObject = null;
    String str = paramContext.getPackageName();
    String[] arrayOfString = b(paramContext, str);
    paramContext = (Context)localObject;
    if (arrayOfString != null)
    {
      paramContext = (Context)localObject;
      if (arrayOfString.length > 0)
      {
        paramContext = new String[arrayOfString.length];
        int i = 0;
        while (i < paramContext.length)
        {
          paramContext[i] = (arrayOfString[i] + ";" + str);
          if (a.a) {
            a.a("mcode" + paramContext[i]);
          }
          i += 1;
        }
      }
    }
    return paramContext;
  }
  
  /* Error */
  private static String[] b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 50	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: aload_1
    //   8: bipush 64
    //   10: invokevirtual 56	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   13: getfield 62	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +198 -> 216
    //   21: aload_1
    //   22: arraylength
    //   23: ifle +193 -> 216
    //   26: aload_1
    //   27: arraylength
    //   28: anewarray 95	java/lang/String
    //   31: astore_0
    //   32: iconst_0
    //   33: istore_2
    //   34: iload_2
    //   35: aload_1
    //   36: arraylength
    //   37: if_icmpge +40 -> 77
    //   40: aload_0
    //   41: iload_2
    //   42: ldc 64
    //   44: invokestatic 70	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   47: new 72	java/io/ByteArrayInputStream
    //   50: dup
    //   51: aload_1
    //   52: iload_2
    //   53: aaload
    //   54: invokevirtual 78	android/content/pm/Signature:toByteArray	()[B
    //   57: invokespecial 81	java/io/ByteArrayInputStream:<init>	([B)V
    //   60: invokevirtual 85	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   63: checkcast 87	java/security/cert/X509Certificate
    //   66: invokestatic 90	com/baidu/lbsapi/auth/b:a	(Ljava/security/cert/X509Certificate;)Ljava/lang/String;
    //   69: aastore
    //   70: iload_2
    //   71: iconst_1
    //   72: iadd
    //   73: istore_2
    //   74: goto -40 -> 34
    //   77: aload 4
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull +125 -> 206
    //   84: aload 4
    //   86: astore_1
    //   87: aload_0
    //   88: arraylength
    //   89: ifle +117 -> 206
    //   92: aload_0
    //   93: arraylength
    //   94: anewarray 95	java/lang/String
    //   97: astore 4
    //   99: iconst_0
    //   100: istore_2
    //   101: aload 4
    //   103: astore_1
    //   104: iload_2
    //   105: aload_0
    //   106: arraylength
    //   107: if_icmpge +99 -> 206
    //   110: new 92	java/lang/StringBuffer
    //   113: dup
    //   114: invokespecial 93	java/lang/StringBuffer:<init>	()V
    //   117: astore_1
    //   118: iconst_0
    //   119: istore_3
    //   120: iload_3
    //   121: aload_0
    //   122: iload_2
    //   123: aaload
    //   124: invokevirtual 99	java/lang/String:length	()I
    //   127: if_icmpge +64 -> 191
    //   130: aload_1
    //   131: aload_0
    //   132: iload_2
    //   133: aaload
    //   134: iload_3
    //   135: invokevirtual 103	java/lang/String:charAt	(I)C
    //   138: invokevirtual 106	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: iload_3
    //   143: ifle +29 -> 172
    //   146: iload_3
    //   147: iconst_2
    //   148: irem
    //   149: iconst_1
    //   150: if_icmpne +22 -> 172
    //   153: iload_3
    //   154: aload_0
    //   155: iload_2
    //   156: aaload
    //   157: invokevirtual 99	java/lang/String:length	()I
    //   160: iconst_1
    //   161: isub
    //   162: if_icmpge +10 -> 172
    //   165: aload_1
    //   166: ldc 108
    //   168: invokevirtual 111	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   171: pop
    //   172: iload_3
    //   173: iconst_1
    //   174: iadd
    //   175: istore_3
    //   176: goto -56 -> 120
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -105 -> 77
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_0
    //   188: goto -111 -> 77
    //   191: aload 4
    //   193: iload_2
    //   194: aload_1
    //   195: invokevirtual 114	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   198: aastore
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -102 -> 101
    //   206: aload_1
    //   207: areturn
    //   208: astore_1
    //   209: goto -21 -> 188
    //   212: astore_1
    //   213: goto -31 -> 182
    //   216: aconst_null
    //   217: astore_0
    //   218: goto -141 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramContext	Context
    //   0	221	1	paramString	String
    //   33	170	2	i	int
    //   119	57	3	j	int
    //   1	191	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   3	17	179	android/content/pm/PackageManager$NameNotFoundException
    //   21	32	179	android/content/pm/PackageManager$NameNotFoundException
    //   3	17	185	java/security/cert/CertificateException
    //   21	32	185	java/security/cert/CertificateException
    //   34	70	208	java/security/cert/CertificateException
    //   34	70	212	android/content/pm/PackageManager$NameNotFoundException
  }
  
  static String c(Context paramContext)
  {
    Object localObject = null;
    String str;
    if ((0 == 0) || ("".equals(null)))
    {
      str = paramContext.getSharedPreferences("mac", 0).getString("macaddr", null);
      localObject = str;
      if (str == null)
      {
        localObject = d(paramContext);
        if (localObject == null) {
          break label122;
        }
        str = Base64.encodeToString(((String)localObject).getBytes(), 0);
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          paramContext.getSharedPreferences("mac", 0).edit().putString("macaddr", str).commit();
        }
      }
    }
    label122:
    for (localObject = str;; localObject = "")
    {
      if (a.a) {
        a.a("getMacID mac_adress: " + (String)localObject);
      }
      return (String)localObject;
    }
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) != -1) {}
    for (boolean bool = true;; bool = false)
    {
      if (a.a) {
        a.a("hasPermission " + bool + " | " + paramString);
      }
      return bool;
    }
  }
  
  static String d(Context paramContext)
  {
    do
    {
      for (;;)
      {
        Context localContext;
        try
        {
          if (c(paramContext, "android.permission.ACCESS_WIFI_STATE"))
          {
            localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
            paramContext = localWifiInfo.getMacAddress();
          }
        }
        catch (Exception localException1)
        {
          WifiInfo localWifiInfo;
          paramContext = null;
        }
        try
        {
          if (!TextUtils.isEmpty(paramContext)) {
            Base64.encode(paramContext.getBytes(), 0);
          }
          localContext = paramContext;
          if (a.a)
          {
            a.a(String.format("ssid=%s mac=%s", new Object[] { localWifiInfo.getSSID(), localWifiInfo.getMacAddress() }));
            localContext = paramContext;
          }
          return localContext;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      if (a.a) {
        a.a("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE");
      }
      return null;
      localContext = paramContext;
    } while (!a.a);
    a.a(localException1.toString());
    return paramContext;
  }
  
  static class a
  {
    public static String a(byte[] paramArrayOfByte)
    {
      char[] arrayOfChar = new char[16];
      char[] tmp6_5 = arrayOfChar;
      tmp6_5[0] = 48;
      char[] tmp11_6 = tmp6_5;
      tmp11_6[1] = 49;
      char[] tmp16_11 = tmp11_6;
      tmp16_11[2] = 50;
      char[] tmp21_16 = tmp16_11;
      tmp21_16[3] = 51;
      char[] tmp26_21 = tmp21_16;
      tmp26_21[4] = 52;
      char[] tmp31_26 = tmp26_21;
      tmp31_26[5] = 53;
      char[] tmp36_31 = tmp31_26;
      tmp36_31[6] = 54;
      char[] tmp42_36 = tmp36_31;
      tmp42_36[7] = 55;
      char[] tmp48_42 = tmp42_36;
      tmp48_42[8] = 56;
      char[] tmp54_48 = tmp48_42;
      tmp54_48[9] = 57;
      char[] tmp60_54 = tmp54_48;
      tmp60_54[10] = 65;
      char[] tmp66_60 = tmp60_54;
      tmp66_60[11] = 66;
      char[] tmp72_66 = tmp66_60;
      tmp72_66[12] = 67;
      char[] tmp78_72 = tmp72_66;
      tmp78_72[13] = 68;
      char[] tmp84_78 = tmp78_72;
      tmp84_78[14] = 69;
      char[] tmp90_84 = tmp84_78;
      tmp90_84[15] = 70;
      tmp90_84;
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(arrayOfChar[((paramArrayOfByte[i] & 0xF0) >> 4)]);
        localStringBuilder.append(arrayOfChar[(paramArrayOfByte[i] & 0xF)]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/lbsapi/auth/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */