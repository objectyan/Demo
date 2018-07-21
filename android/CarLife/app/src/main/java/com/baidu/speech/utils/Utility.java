package com.baidu.speech.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public final class Utility
{
  private static final int BYTES_PER_SAMPLE_16BIT = 2;
  private static final int BYTES_PER_SAMPLE_8BIT = 1;
  private static final int BYTES_PER_SHORT = 2;
  private static int EVR_NETWORK_TYPE_2G = 1;
  private static int EVR_NETWORK_TYPE_3G = 2;
  private static int EVR_NETWORK_TYPE_4G = 3;
  private static int EVR_NETWORK_TYPE_NO = 0;
  private static int EVR_NETWORK_TYPE_WIFI = 4;
  private static final String TAG = "Utility";
  private static final int THOUSAND_DIV = 1000;
  private static ConnectivityManager mConnManager = null;
  private static int maxCpuFreq = 0;
  
  static
  {
    EVR_NETWORK_TYPE_NO = 0;
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static String fun(Exception paramException)
  {
    paramException = paramException.getStackTrace();
    if (paramException == null) {
      return "";
    }
    return paramException[0].getMethodName() + "()";
  }
  
  static String generatePlatformString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Android");
    localStringBuilder.append('&');
    try
    {
      localStringBuilder.append(URLEncoder.encode(Build.MODEL, "utf-8"));
      localStringBuilder.append('&');
      localStringBuilder.append(URLEncoder.encode(Build.VERSION.RELEASE, "utf-8"));
      localStringBuilder.append('&');
      localStringBuilder.append(Build.VERSION.SDK_INT);
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  private static int getCpuInfo()
  {
    String str2 = "";
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 1024);
      String str3;
      do
      {
        str3 = localBufferedReader.readLine();
        str1 = str2;
        if (str3 == null) {
          break;
        }
      } while (str3.indexOf("BogoMIPS") == -1);
      String str1 = str3.split("\\s+")[2];
      localBufferedReader.close();
      float f = Float.parseFloat(str1.trim());
      return (int)(f * 1000.0F);
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static String getFileName(Exception paramException)
  {
    paramException = paramException.getStackTrace();
    if ((paramException == null) || (paramException.length == 0)) {
      return null;
    }
    return paramException[0].getFileName();
  }
  
  public static String getLineNumber(Exception paramException)
  {
    paramException = paramException.getStackTrace();
    if ((paramException == null) || (paramException.length == 0)) {
      return null;
    }
    return paramException[0].getFileName() + ":" + paramException[0].getLineNumber();
  }
  
  public static int getMaxCpuFreq()
  {
    String str = "";
    try
    {
      if (maxCpuFreq != 0) {
        return maxCpuFreq;
      }
      Object localObject1;
      Object localObject2;
      if (isRunningEmulator())
      {
        localObject1 = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start();
        localObject2 = ((Process)localObject1).getInputStream();
        byte[] arrayOfByte = new byte[24];
        while (((InputStream)localObject2).read(arrayOfByte) != -1) {
          str = str + new String(arrayOfByte);
        }
        ((InputStream)localObject2).close();
        ((Process)localObject1).destroy();
      }
      int j;
      for (;;)
      {
        int i = getCpuInfo();
        j = i;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        int k = Integer.parseInt(str.trim());
        j = i;
        if (k >= i) {
          j = k;
        }
        maxCpuFreq = j;
        return maxCpuFreq;
        localObject1 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
        localObject2 = new BufferedReader((Reader)localObject1);
        str = ((BufferedReader)localObject2).readLine();
        ((BufferedReader)localObject2).close();
        ((FileReader)localObject1).close();
      }
      return j;
    }
    catch (Exception localException)
    {
      j = 0;
    }
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  static int getStatusType(int paramInt)
  {
    return 0xFFFF0000 & paramInt;
  }
  
  public static int getVoiceDataSizeInShort(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    if ((paramInt3 != 2) && (paramInt3 != 3)) {
      throw new IllegalArgumentException("audio format invalid");
    }
    if (paramInt3 == 3) {
      i = 1;
    }
    return i * (paramInt1 * paramInt2) / 1000 / 2;
  }
  
  @SuppressLint({"DefaultLocale"})
  public static int getWifiOr2gOr3G(Context paramContext)
  {
    int i = EVR_NETWORK_TYPE_NO;
    int j;
    if (paramContext != null)
    {
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
        if (!isNetworkPerission(paramContext)) {
          return i;
        }
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isConnectedOrConnecting())) {
          break label247;
        }
        if (paramContext.getTypeName().toLowerCase().equals("wifi"))
        {
          j = EVR_NETWORK_TYPE_WIFI;
          i = j;
          break label250;
        }
        j = EVR_NETWORK_TYPE_2G;
        i = j;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      try
      {
        switch (paramContext.getSubtype())
        {
        case 3: 
          i = EVR_NETWORK_TYPE_3G;
        }
      }
      catch (Exception paramContext)
      {
        i = j;
        break label234;
      }
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_3G;
      break label250;
      i = EVR_NETWORK_TYPE_4G;
    }
    else {}
    for (;;)
    {
      label234:
      label247:
      label250:
      return i;
      i = j;
    }
  }
  
  static void init(Context paramContext)
  {
    if (paramContext != null) {
      mConnManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
  }
  
  public static boolean is2G(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (!isNetworkPerission(paramContext)) {
        return false;
      }
      paramContext = localConnectivityManager.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
      {
        if (paramContext.getTypeName().toLowerCase().equals("wifi")) {
          return false;
        }
        int i = paramContext.getSubtype();
        switch (i)
        {
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
    return true;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private static boolean isNetworkPerission(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean isRunningEmulator()
  {
    return (Build.MODEL.equals("sdk")) || (Build.MODEL.equals("google_sdk"));
  }
  
  @SuppressLint({"DefaultLocale"})
  static boolean isUsingWifi()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (mConnManager != null)
    {
      NetworkInfo localNetworkInfo = mConnManager.getActiveNetworkInfo();
      bool1 = bool2;
      if (localNetworkInfo != null) {
        bool1 = "wifi".equals(localNetworkInfo.getTypeName().toLowerCase());
      }
    }
    return bool1;
  }
  
  static boolean isUsingWifi(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (!isNetworkPerission(paramContext)) {
        return false;
      }
      paramContext = localConnectivityManager.getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = "wifi".equals(paramContext.getTypeName().toLowerCase(Locale.US));
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1);
  }
  
  public static String urlEncode(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      if (!TextUtils.isEmpty(paramString1)) {
        str = URLEncoder.encode(paramString1, paramString2);
      }
      return str;
    }
    catch (UnsupportedEncodingException paramString2) {}
    return paramString1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */