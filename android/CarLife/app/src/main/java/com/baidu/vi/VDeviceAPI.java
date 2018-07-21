package com.baidu.vi;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class VDeviceAPI
{
  private static final int ERROR_INVALID_ADDRESS = 1;
  private static final int ERROR_INVALID_FILE_FORMAT = 2;
  private static final int NETWORK_TYPE_BLUETOOTH = 4;
  private static final int NETWORK_TYPE_MOBILE = 3;
  private static final int NETWORK_TYPE_NONE = 0;
  private static final int NETWORK_TYPE_UNKNOWN = 1;
  private static final int NETWORK_TYPE_WIFI = 2;
  private static final String TAG = "VDeviceAPI in java";
  private static BroadcastReceiver mNetworkStateReceiver = null;
  private static PowerManager.WakeLock mWakeLock = null;
  
  public static String getAppVersion()
  {
    return "10.1.0";
  }
  
  public static long getAvailableMemory()
  {
    ActivityManager localActivityManager = (ActivityManager)VIContext.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  public static String getCachePath()
  {
    return Environment.getDataDirectory().getAbsolutePath();
  }
  
  public static String getCellId()
  {
    Object localObject = (TelephonyManager)VIContext.getContext().getSystemService("phone");
    if (localObject == null) {
      return null;
    }
    localObject = ((TelephonyManager)localObject).getCellLocation();
    if ((localObject instanceof GsmCellLocation)) {
      return " " + ((GsmCellLocation)localObject).getCid();
    }
    return " ";
  }
  
  public static String getCuid()
  {
    return SysOSAPIv2.getInstance().getCuid();
  }
  
  public static int getCurrentNetworkType()
  {
    try
    {
      int i = Integer.parseInt(NetworkUtil.getCurrentNetMode(VIContext.getContext()));
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static long getFreeSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() / 1024L;
  }
  
  public static String getImei()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)VIContext.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      return localTelephonyManager.getDeviceId();
    }
    return null;
  }
  
  public static String getImsi()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)VIContext.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      return localTelephonyManager.getSubscriberId();
    }
    return null;
  }
  
  public static String getLac()
  {
    Object localObject = (TelephonyManager)VIContext.getContext().getSystemService("phone");
    if (localObject == null) {
      return null;
    }
    localObject = ((TelephonyManager)localObject).getCellLocation();
    if ((localObject instanceof GsmCellLocation)) {
      return "" + ((GsmCellLocation)localObject).getLac();
    }
    return "";
  }
  
  public static String getModuleFileName()
  {
    return VIContext.getContext().getFilesDir().getAbsolutePath();
  }
  
  public static VNetworkInfo getNetworkInfo(int paramInt)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)VIContext.getContext().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = null;
    switch (paramInt)
    {
    }
    while (localNetworkInfo != null)
    {
      return new VNetworkInfo(localNetworkInfo);
      localNetworkInfo = localConnectivityManager.getNetworkInfo(1);
      continue;
      localNetworkInfo = localConnectivityManager.getNetworkInfo(0);
    }
    return null;
  }
  
  public static String getOsVersion()
  {
    return "android";
  }
  
  @TargetApi(8)
  public static int getScreenBrightness()
  {
    ContentResolver localContentResolver = VIContext.getContext().getContentResolver();
    int j = 0;
    int i = j;
    if (8 <= Build.VERSION.SDK_INT) {}
    try
    {
      i = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
      if (i == 1) {
        return -1;
      }
      try
      {
        i = Settings.System.getInt(localContentResolver, "screen_brightness");
        return i;
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        return -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public static float getScreenDensity()
  {
    if (VIContext.getContext() == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.density;
  }
  
  public static int getScreenDensityDpi()
  {
    if (VIContext.getContext() == null) {
      return 0;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if ((localWindowManager != null) && (localWindowManager.getDefaultDisplay() != null)) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.densityDpi;
  }
  
  public static long getSdcardFreeSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks() / 1024L;
  }
  
  public static String getSdcardPath()
  {
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  public static long getSdcardTotalSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() / 1024L;
  }
  
  public static float getSystemMetricsX()
  {
    if (VIContext.getContext() == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.widthPixels;
  }
  
  public static float getSystemMetricsY()
  {
    if (VIContext.getContext() == null) {
      return 0.0F;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)VIContext.getContext().getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics.heightPixels;
  }
  
  @Deprecated
  public static int getTelecomInfo()
  {
    String str = ((TelephonyManager)VIContext.getContext().getSystemService("phone")).getSubscriberId();
    int j = -1;
    int i = j;
    if (str != null)
    {
      if ((!str.startsWith("46000")) && (!str.startsWith("46002"))) {
        break label47;
      }
      i = 0;
    }
    label47:
    do
    {
      return i;
      if (str.startsWith("46001")) {
        return 1;
      }
      i = j;
    } while (!str.startsWith("46003"));
    return 2;
  }
  
  public static long getTotalMemory()
  {
    long l3 = 0L;
    long l2 = l3;
    try
    {
      FileReader localFileReader = new FileReader("/proc/meminfo");
      l2 = l3;
      BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
      l2 = l3;
      String str = localBufferedReader.readLine();
      long l1 = l3;
      if (str != null)
      {
        l2 = l3;
        l1 = Integer.valueOf(str.split("\\s+")[1]).intValue();
      }
      l2 = l1;
      localBufferedReader.close();
      if (localFileReader != null)
      {
        l2 = l1;
        localFileReader.close();
      }
      return l1;
    }
    catch (IOException localIOException) {}
    return l2;
  }
  
  public static long getTotalSpace()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() / 1024L;
  }
  
  public static ScanResult[] getWifiHotpot()
  {
    List localList = ((WifiManager)VIContext.getContext().getSystemService("wifi")).getScanResults();
    return (ScanResult[])localList.toArray(new ScanResult[localList.size()]);
  }
  
  public static boolean isWifiConnected()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)VIContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  public static void makeCall(String paramString)
  {
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
    VIContext.getContext().startActivity(paramString);
  }
  
  public static native void onNetworkStateChanged();
  
  public static void openUrl(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    VIContext.getContext().startActivity(paramString);
  }
  
  public static int sendMMS(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!PhoneNumberUtils.isWellFormedSmsAddress(paramString1)) {
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
      VIContext.getContext().startActivity(localIntent);
      return 0;
    }
    catch (Exception paramString1) {}
    return 2;
  }
  
  public static void sendSMS(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
    paramString1.putExtra("sms_body", paramString2);
    VIContext.getContext().startActivity(paramString1);
  }
  
  public static void setNetworkChangedCallback()
  {
    unsetNetworkChangedCallback();
    mNetworkStateReceiver = new VDeviceAPI.1();
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    VIContext.getContext().registerReceiver(mNetworkStateReceiver, localIntentFilter);
  }
  
  public static void setScreenAlwaysOn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mWakeLock == null) {
        mWakeLock = ((PowerManager)VIContext.getContext().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
      }
      mWakeLock.acquire();
    }
    while ((mWakeLock == null) || (!mWakeLock.isHeld())) {
      return;
    }
    mWakeLock.release();
    mWakeLock = null;
  }
  
  public static void setupSoftware(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    VIContext.getContext().startActivity(localIntent);
  }
  
  public static void unsetNetworkChangedCallback()
  {
    if (mNetworkStateReceiver != null)
    {
      VIContext.getContext().unregisterReceiver(mNetworkStateReceiver);
      mNetworkStateReceiver = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/vi/VDeviceAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */