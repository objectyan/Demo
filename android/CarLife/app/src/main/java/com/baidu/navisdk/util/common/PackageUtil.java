package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Random;

public class PackageUtil
{
  public static final String SYSTEM_SEPARATOR = System.getProperty("file.separator");
  private static long apkUpdateTime = 0L;
  public static final String bNaviSDKVersion = "3.2.0";
  private static boolean fileexit;
  public static int iVersionCode;
  private static byte[] mPackageSignature;
  public static int sdkVersion = 0;
  private static String strBuildNo = "0";
  static String strCPUType;
  static String strCUID;
  public static String strChannel;
  static String strDeviceAndroidId;
  static String strDeviceIMEI;
  static String strDeviceIMSI;
  static String strDeviceImeiRand;
  static String strDeviceMac;
  public static String strOSVersion;
  private static String strOem = "baidu";
  private static String strPackageName;
  public static String strPhoneType;
  static String strRealDeviceID = null;
  public static String strSoftWareVer;
  
  static
  {
    fileexit = true;
  }
  
  private static String generateImeiNum(Context paramContext)
  {
    String str = null;
    if (paramContext == null) {
      return "";
    }
    Object localObject1;
    if (paramContext.getFilesDir() != null)
    {
      Object localObject2 = new File(paramContext.getFilesDir().getAbsolutePath() + "/" + "imei.dat");
      localObject1 = str;
      try
      {
        if (!((File)localObject2).exists())
        {
          localObject1 = str;
          fileexit = false;
          localObject1 = str;
          str = getDeviceId(paramContext);
          localObject1 = str;
          paramContext = paramContext.openFileOutput("imei.dat", 32768);
          localObject1 = str;
          paramContext.write(str.getBytes("UTF-8"));
          localObject1 = str;
          paramContext.close();
          paramContext = str;
        }
        else
        {
          localObject1 = str;
          fileexit = true;
          localObject1 = str;
          paramContext = paramContext.openFileInput("imei.dat");
          localObject1 = str;
          localObject2 = new byte[paramContext.available()];
          localObject1 = str;
          paramContext.read((byte[])localObject2);
          localObject1 = str;
          paramContext.close();
          localObject1 = str;
          paramContext = new String((byte[])localObject2, "UTF-8");
          LogUtil.e("", ((Exception)localObject1).toString());
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localObject1 = paramContext.substring(0, paramContext.indexOf('|'));
          paramContext = (Context)localObject1;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
        localException2 = localException2;
        paramContext = (Context)localObject1;
        localObject1 = localException2;
      }
    }
    else
    {
      paramContext = "";
    }
    return paramContext;
  }
  
  private static String generateImeiRand()
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer(10);
    int i = 0;
    while (i < 10)
    {
      localStringBuffer.append(localRandom.nextInt(10));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String generateImeiRand(Context paramContext)
  {
    String str = null;
    localObject = str;
    try
    {
      if (!fileexit)
      {
        localObject = str;
        str = generateImeiRand();
        localObject = str;
        paramContext = paramContext.openFileOutput("imei.dat", 32768);
        localObject = str;
        paramContext.write(("|" + str).getBytes("UTF-8"));
        localObject = str;
        paramContext.close();
        return str;
      }
      if (paramContext != null)
      {
        localObject = str;
        paramContext = paramContext.openFileInput("imei.dat");
        localObject = str;
        byte[] arrayOfByte = new byte[paramContext.available()];
        localObject = str;
        paramContext.read(arrayOfByte);
        localObject = str;
        paramContext.close();
        localObject = str;
        paramContext = new String(arrayOfByte, "UTF-8");
      }
      return null;
    }
    catch (Exception paramContext)
    {
      try
      {
        localObject = paramContext.substring(paramContext.indexOf('|') + 1);
        return (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject = paramContext;
          paramContext = localException;
        }
      }
      paramContext = paramContext;
      LogUtil.e("", paramContext.toString());
      return (String)localObject;
    }
  }
  
  static byte[] generateSHA1Fingerprint(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA1").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static String getAndroidId()
  {
    return strDeviceAndroidId;
  }
  
  public static long getApkUpdateTime()
  {
    return apkUpdateTime;
  }
  
  public static String getAuthString(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = getFingerPrint(paramContext, str);
    return paramContext + ";" + str;
  }
  
  public static String getBNaviSDKVersion()
  {
    return "3.2.0";
  }
  
  public static String getBuildNo()
  {
    return strBuildNo;
  }
  
  public static String getCPUType()
  {
    return strCPUType;
  }
  
  public static String getChannel()
  {
    if ((strChannel != null) && (strChannel.length() > 0)) {
      return strChannel;
    }
    return "baidu";
  }
  
  public static String getCuid()
  {
    if ((strCUID != null) && (strCUID.length() > 0)) {
      return strCUID;
    }
    return "00000000000000000000000000000000|000000000000000";
  }
  
  private static String getDeviceId(Context paramContext)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE")) {}
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = paramContext.getDeviceId();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtil.e("", paramContext.toString());
        localObject1 = localObject2;
      }
    }
    paramContext = (Context)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramContext = "000000000000000";
    }
    return paramContext;
  }
  
  protected static String getFingerPrint(Context paramContext, String paramString)
  {
    paramContext = "";
    try
    {
      paramString = getFingerprintAsString((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(getPackageSignature())));
      paramContext = paramString;
    }
    catch (CertificateException paramString)
    {
      int i;
      for (;;) {}
    }
    paramString = new StringBuffer();
    if (paramContext != null)
    {
      i = 0;
      while (i < paramContext.length())
      {
        paramString.append(paramContext.charAt(i));
        if ((i > 0) && (i % 2 == 1) && (i < paramContext.length() - 1)) {
          paramString.append(":");
        }
        i += 1;
      }
    }
    return paramString.toString();
  }
  
  static String getFingerprintAsString(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = Hex.encode(generateSHA1Fingerprint(paramX509Certificate.getEncoded()));
      return paramX509Certificate;
    }
    catch (CertificateEncodingException paramX509Certificate) {}
    return null;
  }
  
  public static String getImeiNum()
  {
    return strDeviceIMEI;
  }
  
  public static String getImeiRand()
  {
    return strDeviceImeiRand;
  }
  
  public static String getImsiNum()
  {
    return strDeviceIMSI;
  }
  
  public static String getMacNum()
  {
    return strDeviceMac;
  }
  
  public static String getPackageName()
  {
    return strPackageName;
  }
  
  public static byte[] getPackageSignature()
  {
    return mPackageSignature;
  }
  
  public static int getSystemVersion()
  {
    return sdkVersion;
  }
  
  public static int getVersionCode()
  {
    return iVersionCode;
  }
  
  public static int getVersionCode(Context paramContext)
  {
    return iVersionCode;
  }
  
  public static String getVersionName()
  {
    return strSoftWareVer;
  }
  
  public static void init(Context paramContext)
  {
    initAppVersion(paramContext);
    initAndroidId(paramContext);
    initIMEIandIMSI(paramContext);
    initMacNum(paramContext);
    initApkUpdateTime(paramContext);
    readAndCopyChannel(paramContext, paramContext.getAssets());
  }
  
  private static void initAndroidId(Context paramContext)
  {
    try
    {
      strDeviceAndroidId = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return;
    }
    catch (Exception paramContext)
    {
      strDeviceAndroidId = "0000000000000000";
    }
  }
  
  private static void initApkUpdateTime(Context paramContext)
  {
    try
    {
      paramContext = new File(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).sourceDir);
      boolean bool = paramContext.exists();
      LogUtil.e("PackageUtil", "initApkUpdateTime: apkFileExists " + bool);
      if (bool) {}
      for (long l = paramContext.lastModified();; l = System.currentTimeMillis())
      {
        apkUpdateTime = l;
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void initAppVersion(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      strPackageName = paramContext.getPackageName();
      localObject = ((PackageManager)localObject).getPackageInfo(strPackageName, 0);
      strSoftWareVer = ((PackageInfo)localObject).versionName;
      iVersionCode = ((PackageInfo)localObject).versionCode;
      mPackageSignature = paramContext.getPackageManager().getPackageInfo(strPackageName, 64).signatures[0].toByteArray();
    }
    catch (Exception paramContext)
    {
      try
      {
        for (;;)
        {
          sdkVersion = Integer.parseInt(Build.VERSION.SDK);
          strPhoneType = Build.MODEL;
          strOSVersion = "Android" + Build.VERSION.SDK;
          return;
          paramContext = paramContext;
          strSoftWareVer = "1.0.0";
          iVersionCode = 1;
        }
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  private static void initIMEIandIMSI(Context paramContext)
  {
    Object localObject;
    if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE"))
    {
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        strDeviceIMSI = ((TelephonyManager)localObject).getSubscriberId();
        strDeviceIMEI = generateImeiNum(paramContext);
        strDeviceImeiRand = generateImeiRand(paramContext);
        if (strCUID != null) {
          if (!StringUtils.isEmpty(strCUID)) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          localObject = Class.forName("com.baidu.android.common.util.CommonParam");
          if (localObject != null) {
            strCUID = (String)((Class)localObject).getMethod("getCUID", new Class[] { Context.class }).invoke(localObject, new Object[] { paramContext });
          }
          return;
        }
        catch (Exception paramContext)
        {
          if (!LogUtil.LOGGABLE) {
            continue;
          }
          paramContext.printStackTrace();
        }
        localException = localException;
        if (!LogUtil.LOGGABLE) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      strDeviceIMSI = "0000";
    }
  }
  
  private static void initMacNum(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE")) {
        try
        {
          if ((TelephonyManager)paramContext.getSystemService("phone") != null)
          {
            paramContext = (WifiManager)paramContext.getSystemService("wifi");
            if (paramContext != null)
            {
              paramContext = paramContext.getConnectionInfo();
              if (paramContext != null)
              {
                strDeviceMac = paramContext.getMacAddress();
                return;
              }
            }
          }
        }
        catch (Exception paramContext) {}
      }
    }
  }
  
  public static boolean isCalling(Context paramContext)
  {
    if (!SystemAuth.checkAuth("android.permission.READ_PHONE_STATE")) {
      return false;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getCallState())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isChannelAnzhi()
  {
    return "d1008".equals(strChannel);
  }
  
  public static boolean isChannelGooglePlay()
  {
    return "d1021".equals(strChannel);
  }
  
  public static boolean isSmartisanPhone()
  {
    return Build.MANUFACTURER.equals("smartisan");
  }
  
  private static void readAndCopyChannel(Context paramContext, AssetManager paramAssetManager)
  {
    try
    {
      File localFile = new File(SysOSAPI.getInstance().GetModuleFileName() + "/channel");
      paramAssetManager = paramAssetManager.open("channel");
      long l = paramAssetManager.available();
      if ((localFile.exists()) && (l == localFile.length()) && (localFile.lastModified() > getApkUpdateTime()))
      {
        paramAssetManager.close();
        strChannel = PreferenceHelper.getInstance(paramContext).getString("SysOSAPI.channel", strChannel);
        return;
      }
      byte[] arrayOfByte = new byte[(int)l];
      paramAssetManager.read(arrayOfByte);
      paramAssetManager.close();
      strChannel = new String(arrayOfByte).trim();
      PreferenceHelper.getInstance(paramContext).putString("SysOSAPI.channel", strChannel);
      paramContext = strChannel.getBytes("UTF-8");
      localFile.createNewFile();
      paramAssetManager = new FileOutputStream(localFile);
      paramAssetManager.write(paramContext);
      paramAssetManager.close();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void readAndCopyOem(Context paramContext, AssetManager paramAssetManager)
  {
    try
    {
      File localFile = new File(SysOSAPI.getInstance().GetModuleFileName() + "/oem");
      if (!localFile.exists())
      {
        paramAssetManager = paramAssetManager.open("oem");
        byte[] arrayOfByte = new byte[paramAssetManager.available()];
        paramAssetManager.read(arrayOfByte);
        strOem = new String(arrayOfByte, "UTF-8").trim();
        PreferenceHelper.getInstance(paramContext).putString("SysOSAPI.oem", strOem);
        paramContext = new String(arrayOfByte).trim().getBytes("UTF-8");
        paramAssetManager.close();
        localFile.createNewFile();
        paramAssetManager = new FileOutputStream(localFile);
        paramAssetManager.write(paramContext);
        paramAssetManager.close();
        return;
      }
      strOem = PreferenceHelper.getInstance(paramContext).getString("SysOSAPI.oem", strOem);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void readBuildNumber(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getAssets().open("build");
      byte[] arrayOfByte = new byte[paramContext.available()];
      paramContext.read(arrayOfByte);
      strBuildNo = new String(arrayOfByte).trim();
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void readSDKBuildNumber()
  {
    try
    {
      InputStream localInputStream = JarUtils.getResources().getAssets().open("build");
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      strBuildNo = new String(arrayOfByte).trim();
      localInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void setCPUType(String paramString)
  {
    strCPUType = paramString;
  }
  
  public static void setCuid(String paramString)
  {
    strCUID = paramString;
  }
  
  static class Hex
  {
    public static String encode(byte[] paramArrayOfByte)
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/PackageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */