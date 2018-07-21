package com.baidu.navisdk.vi;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.webkit.MimeTypeMap;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.VersionInfo;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import org.apache.http.util.EncodingUtils;

public class VDeviceAPI
{
  public static final String APP_NAME_BAIDU_MAP = "BaiduMap";
  public static final String APP_PRODUCT_KIND = "baiduNavi_SDK_FOR_Map";
  private static final int ERROR_INVALID_ADDRESS = 1;
  private static final int ERROR_INVALID_FILE_FORMAT = 2;
  private static final String TAG = "VDeviceAPI in java";
  private static BroadcastReceiver mNetworkStateReceiver = null;
  private static PowerManager.WakeLock mWakeLock = null;
  
  public static String add(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).add(new BigInteger(paramString2)).toString();
  }
  
  public static String divide(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).divide(new BigInteger(paramString2)).toString();
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).compareTo(new BigInteger(paramString2)) == 0;
  }
  
  public static String getAppPackageName()
  {
    return PackageUtil.getPackageName();
  }
  
  public static String getAppPackageVersion()
  {
    return PackageUtil.getVersionName();
  }
  
  public static String getAppProductKind()
  {
    LogUtil.e("VDeviceAPI", "getAppProductKind");
    return "baiduNavi_SDK_FOR_Map";
  }
  
  public static int getAppVersionCode()
  {
    return PackageUtil.getVersionCode();
  }
  
  public static long getAvailableMemory()
  {
    ActivityManager localActivityManager = (ActivityManager)BNaviModuleManager.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  public static String getCachePath()
  {
    return SysOSAPI.getInstance().GetSDCardCachePath();
  }
  
  public static String getCellId()
  {
    if (!SystemAuth.checkAuth("android.permission.READ_PHONE_STATE")) {
      return " ";
    }
    Object localObject = (TelephonyManager)BNaviModuleManager.getContext().getSystemService("phone");
    if (localObject == null) {
      return null;
    }
    localObject = ((TelephonyManager)localObject).getCellLocation();
    if ((localObject instanceof GsmCellLocation)) {
      return " " + ((GsmCellLocation)localObject).getCid();
    }
    return " ";
  }
  
  public static String getChannelID()
  {
    String str1 = "baidu";
    Object localObject3 = "/data/data/" + BNaviModuleManager.getContext().getPackageName() + "/channel";
    Object localObject2 = new File((String)localObject3);
    Object localObject1;
    if (!((File)localObject2).exists()) {
      localObject1 = str1;
    }
    for (;;)
    {
      try
      {
        localObject2 = JarUtils.getResources().getAssets().open("channel");
        localObject1 = str1;
        byte[] arrayOfByte = new byte[((InputStream)localObject2).available()];
        localObject1 = str1;
        ((InputStream)localObject2).read(arrayOfByte);
        localObject1 = str1;
        localObject3 = new FileOutputStream(new File((String)localObject3));
        localObject1 = str1;
        ((FileOutputStream)localObject3).write(arrayOfByte);
        localObject1 = str1;
        str1 = EncodingUtils.getString(arrayOfByte, "UTF-8");
        localObject1 = str1;
        ((FileOutputStream)localObject3).close();
        localObject1 = str1;
        ((InputStream)localObject2).close();
        localObject1 = str1;
      }
      catch (IOException localIOException)
      {
        LogUtil.e("", localIOException.toString());
        continue;
      }
      return ((String)localObject1).trim();
      localObject1 = localIOException;
      try
      {
        localObject2 = new FileInputStream((File)localObject2);
        localObject1 = localIOException;
        String str2 = new BufferedReader(new InputStreamReader((InputStream)localObject2, "UTF-8")).readLine().toString();
        localObject1 = str2;
        ((InputStream)localObject2).close();
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        LogUtil.e("", localException.toString());
      }
    }
  }
  
  public static String getCuid()
  {
    LogUtil.e("VDeviceAPI", "getCuid");
    return PackageUtil.getCuid();
  }
  
  public static int getCurrentNetworkType()
  {
    return NetworkUtils.getCurrentNetworkType();
  }
  
  public static String getDataVersion()
  {
    return VersionInfo.getDataVersion();
  }
  
  public static long getFreeSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() / 1024L;
  }
  
  public static String getImei()
  {
    if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE"))
    {
      Object localObject = (TelephonyManager)BNaviModuleManager.getContext().getSystemService("phone");
      if (localObject != null) {
        try
        {
          localObject = ((TelephonyManager)localObject).getDeviceId();
          return (String)localObject;
        }
        catch (Exception localException) {}
      }
    }
    String str = "";
    if (("" == null) || ("".length() == 0) || ("".equals("null"))) {
      str = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
    }
    LogUtil.e("VDeviceAPI in java", "VDeviceAPI getImei = " + str);
    return str;
  }
  
  public static String getImeiWithDefault()
  {
    if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE"))
    {
      Object localObject = (TelephonyManager)BNaviModuleManager.getContext().getSystemService("phone");
      if (localObject != null) {
        try
        {
          localObject = ((TelephonyManager)localObject).getDeviceId();
          return (String)localObject;
        }
        catch (Exception localException) {}
      }
    }
    LogUtil.e("VDeviceAPI in java", "VDeviceAPI getImei with default = 000000000000000");
    return "000000000000000";
  }
  
  public static String getImsi()
  {
    if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE"))
    {
      Object localObject = (TelephonyManager)BNaviModuleManager.getContext().getSystemService("phone");
      if (localObject != null) {
        try
        {
          localObject = ((TelephonyManager)localObject).getSubscriberId();
          return (String)localObject;
        }
        catch (Exception localException)
        {
          if (LogUtil.LOGGABLE) {
            localException.printStackTrace();
          }
        }
      }
    }
    return null;
  }
  
  public static String getLac()
  {
    if (!SystemAuth.checkAuth("android.permission.READ_PHONE_STATE")) {
      return "";
    }
    Object localObject = (TelephonyManager)BNaviModuleManager.getContext().getSystemService("phone");
    if (localObject == null) {
      return null;
    }
    localObject = ((TelephonyManager)localObject).getCellLocation();
    if ((localObject instanceof GsmCellLocation)) {
      return "" + ((GsmCellLocation)localObject).getLac();
    }
    return "";
  }
  
  public static String getMacAddress()
  {
    Object localObject = (WifiManager)BNaviModuleManager.getContext().getSystemService("wifi");
    if ((localObject == null) || (((WifiManager)localObject).getConnectionInfo() == null)) {
      return "";
    }
    localObject = ((WifiManager)localObject).getConnectionInfo().getMacAddress();
    LogUtil.e("VDeviceAPI in java", "===Mac Address = " + (String)localObject);
    return (String)localObject;
  }
  
  public static String getModuleFileName()
  {
    return BNaviModuleManager.getContext().getFilesDir().getAbsolutePath();
  }
  
  public static VNetworkInfo getNetworkInfo(int paramInt)
  {
    return NetworkUtils.getNetworkInfo(paramInt);
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String getPhoneType()
  {
    String str2 = Build.MODEL;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() != 0) {}
      }
    }
    else
    {
      str1 = "unknown";
    }
    return str1;
  }
  
  public static String getSDKVersion()
  {
    return VersionInfo.getApiVersion();
  }
  
  public static int getScreenBrightness()
  {
    ContentResolver localContentResolver = BNaviModuleManager.getContext().getContentResolver();
    int i = 0;
    try
    {
      int j = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
      i = j;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException2)
    {
      for (;;)
      {
        LogUtil.e("", localSettingNotFoundException2.toString());
      }
      try
      {
        i = Settings.System.getInt(localContentResolver, "screen_brightness");
        return i;
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException1) {}
    }
    if (i == 1) {
      return -1;
    }
    return -1;
  }
  
  public static float getScreenDensity()
  {
    return ScreenUtil.getInstance().getDensity();
  }
  
  public static int getScreenDensityDpi()
  {
    return ScreenUtil.getInstance().getDPI();
  }
  
  public static long getSdcardFreeSpace()
  {
    l2 = 0L;
    l3 = 0L;
    long l1 = l2;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l1 = l2;
      l2 = localStatFs.getBlockSize();
      l1 = l2;
      int i = localStatFs.getAvailableBlocks();
      l3 = i;
      l1 = l2;
      l2 = l3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("VDeviceAPI in java", "getSdcardFreeSpace fail");
        l2 = l3;
      }
    }
    return l1 * l2 / 1024L;
  }
  
  public static String getSdcardPath()
  {
    return SysOSAPI.getInstance().GetSDCardPath();
  }
  
  public static long getSdcardTotalSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() / 1024L;
  }
  
  public static float getSystemMetricsX()
  {
    return ScreenUtil.getInstance().getWidthPixels();
  }
  
  public static float getSystemMetricsY()
  {
    return ScreenUtil.getInstance().getHeightPixels();
  }
  
  public static long getTotalMemory()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      FileReader localFileReader = new FileReader("/proc/meminfo");
      l1 = l2;
      BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
      l1 = l2;
      l2 = Integer.valueOf(localBufferedReader.readLine().split("\\s+")[1]).intValue();
      l1 = l2;
      localBufferedReader.close();
      l1 = l2;
      localFileReader.close();
      return l2;
    }
    catch (IOException localIOException) {}
    return l1;
  }
  
  public static long getTotalSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() / 1024L;
  }
  
  public static ScanResult[] getWifiHotpot()
  {
    List localList = ((WifiManager)BNaviModuleManager.getContext().getSystemService("wifi")).getScanResults();
    return (ScanResult[])localList.toArray(new ScanResult[localList.size()]);
  }
  
  public static int getWindowHeight()
  {
    return ScreenUtil.getInstance().getWindowHeightPixels();
  }
  
  public static int getWindowWidth()
  {
    return ScreenUtil.getInstance().getWindowWidthPixels();
  }
  
  public static boolean gt(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).compareTo(new BigInteger(paramString2)) > 0;
  }
  
  public static int isWifiConnected()
  {
    if (NetworkUtils.isWifiConnected()) {
      return 1;
    }
    return 0;
  }
  
  public static boolean lt(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).compareTo(new BigInteger(paramString2)) < 0;
  }
  
  public static void makeCall(String paramString)
  {
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
    BNaviModuleManager.getContext().startActivity(paramString);
  }
  
  public static String mod(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).mod(new BigInteger(paramString2)).toString();
  }
  
  public static String multiply(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).multiply(new BigInteger(paramString2)).toString();
  }
  
  public static boolean nlt(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).compareTo(new BigInteger(paramString2)) >= 0;
  }
  
  public static native void onNetworkStateChanged();
  
  public static void openUrl(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    BNaviModuleManager.getContext().startActivity(paramString);
  }
  
  public static String powerMod(String paramString1, int paramInt, String paramString2)
  {
    BigInteger localBigInteger1 = new BigInteger(paramString1);
    BigInteger localBigInteger2 = new BigInteger(paramString2);
    paramString1 = new BigInteger("1");
    paramString2 = localBigInteger1;
    while (paramInt > 0) {
      if (paramInt % 2 != 0)
      {
        paramString1 = paramString1.multiply(paramString2).mod(localBigInteger2);
        paramInt -= 1;
      }
      else
      {
        paramString2 = paramString2.multiply(paramString2).mod(localBigInteger2);
        paramInt /= 2;
      }
    }
    return paramString1.mod(localBigInteger2).toString();
  }
  
  public static int sendMMS(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!PhoneNumberUtils.isWellFormedSmsAddress(paramString1))
    {
      LogUtil.e("VDeviceAPI in java", "invalid address: " + paramString1);
      return 1;
    }
    try
    {
      String str = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(paramString4)).toString());
      str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.putExtra("address", paramString1);
      localIntent.putExtra("subject", paramString2);
      localIntent.putExtra("sms_body", paramString3);
      localIntent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + paramString4));
      localIntent.setType(str);
      BNaviModuleManager.getContext().startActivity(localIntent);
      return 0;
    }
    catch (Exception paramString1)
    {
      LogUtil.e("VDeviceAPI in java", "can't get the mimetype of this file: " + paramString4);
    }
    return 2;
  }
  
  public static void sendSMS(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
    paramString1.putExtra("sms_body", paramString2);
    BNaviModuleManager.getContext().startActivity(paramString1);
  }
  
  public static boolean setNetworkChangedCallback()
  {
    unsetNetworkChangedCallback();
    mNetworkStateReceiver = new VDeviceAPI.2();
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      Context localContext = BNaviModuleManager.getContext();
      if (localContext != null) {
        localContext.getApplicationContext().registerReceiver(mNetworkStateReceiver, localIntentFilter);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return true;
  }
  
  @SuppressLint({"Wakelock"})
  public static void setScreenAlwaysOn(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject = mWakeLock;
        if (localObject != null) {}
      }
      catch (Exception localException1)
      {
        Object localObject;
        return;
      }
      try
      {
        localObject = (PowerManager)BNaviModuleManager.getContext().getSystemService("power");
        if (localObject != null) {
          mWakeLock = ((PowerManager)localObject).newWakeLock(536870922, "VDeviceAPI");
        }
      }
      catch (Exception localException2) {}
    }
    if (mWakeLock != null)
    {
      mWakeLock.acquire();
      return;
      if ((mWakeLock != null) && (mWakeLock.isHeld()))
      {
        mWakeLock.release();
        return;
      }
    }
  }
  
  public static void setupSoftware(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    BNaviModuleManager.getContext().startActivity(localIntent);
  }
  
  public static void showJniToast(String paramString)
  {
    if ((!BNSettingManager.isShowJavaLog()) || (BNaviModuleManager.getActivity() == null)) {
      return;
    }
    LogUtil.e("showJniToast", " showJniToast toast: " + paramString);
    BNWorkerCenter.getInstance().submitMainThreadTask(new VDeviceAPI.1("ShowJniToast-" + VDeviceAPI.class.getSimpleName(), null, paramString), new BNWorkerConfig(100, 0));
  }
  
  public static String subtract(String paramString1, String paramString2)
  {
    return new BigInteger(paramString1).subtract(new BigInteger(paramString2)).toString();
  }
  
  public static boolean unsetNetworkChangedCallback()
  {
    if (mNetworkStateReceiver != null) {}
    try
    {
      Context localContext = BNaviModuleManager.getContext();
      if (localContext != null) {
        localContext.getApplicationContext().unregisterReceiver(mNetworkStateReceiver);
      }
      mNetworkStateReceiver = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        mNetworkStateReceiver = null;
      }
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/vi/VDeviceAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */