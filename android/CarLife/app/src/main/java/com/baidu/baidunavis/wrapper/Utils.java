package com.baidu.baidunavis.wrapper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

public class Utils
{
  private static final String TAG = "Common";
  public static final int TITLE_HEIGHT = 25;
  public static String mUUID = "";
  
  public static void blurWindow(Activity paramActivity, boolean paramBoolean)
  {
    paramActivity = paramActivity.getWindow();
    if (paramBoolean)
    {
      paramActivity.setFlags(4, 4);
      return;
    }
    paramActivity.setFlags(0, 4);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (!paramFile1.exists()) {}
    while ((!paramFile1.isFile()) || (!paramFile1.canRead())) {
      return;
    }
    if (!paramFile2.getParentFile().exists()) {
      paramFile2.getParentFile().mkdirs();
    }
    if ((paramFile2.exists()) && (paramBoolean)) {
      paramFile2.delete();
    }
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      paramFile2 = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramFile2.write(arrayOfByte, 0, i);
      }
      paramFile1.close();
      paramFile2.close();
      return;
    }
    catch (Exception paramFile1) {}
  }
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          return;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return;
    }
    catch (Exception paramInputStream) {}
  }
  
  public static void createShortcut(Activity paramActivity, int paramInt, String paramString)
  {
    if ((paramActivity == null) || (isVoid(paramString))) {
      return;
    }
    try
    {
      Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
      localIntent.putExtra("duplicate", false);
      paramString = new Intent("android.intent.action.MAIN");
      paramString.addCategory("android.intent.category.LAUNCHER");
      paramString.setComponent(new ComponentName(paramActivity.getPackageName(), paramActivity.getClass().getName()));
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramString);
      localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity, paramInt));
      paramActivity.sendBroadcast(localIntent);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static boolean deleteDir(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          return deleteDir(localFile);
        }
        localFile.delete();
        i += 1;
      }
    }
    paramFile.delete();
    return true;
  }
  
  public static void disableOverScroll(View paramView) {}
  
  public static void expendNotification(Activity paramActivity)
    throws Exception
  {
    paramActivity = paramActivity.getSystemService("statusbar");
    if (paramActivity != null) {
      paramActivity.getClass().getMethod("expand", new Class[0]).invoke(paramActivity, new Object[0]);
    }
  }
  
  public static String getChangeableUUID()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String getContent(HttpResponse paramHttpResponse)
    throws IOException
  {
    if (paramHttpResponse == null) {
      return null;
    }
    int k = 0;
    Object localObject = paramHttpResponse.getHeaders("Content-Encoding");
    if ((localObject != null) && (localObject.length > 0))
    {
      int m = localObject.length;
      int i = 0;
      StringBuffer localStringBuffer;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          if (localObject[i].getValue().toLowerCase().indexOf("gzip") > -1) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label167;
          }
          paramHttpResponse = paramHttpResponse.getEntity().getContent();
          localObject = new GZIPInputStream(paramHttpResponse);
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject, "UTF-8"));
          localStringBuffer = new StringBuffer();
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            localStringBuffer.append(str);
          }
        }
        i += 1;
      }
      ((GZIPInputStream)localObject).close();
      paramHttpResponse.close();
      return localStringBuffer.toString();
    }
    label167:
    return EntityUtils.toString(paramHttpResponse.getEntity());
  }
  
  public static int getCpuMaxFreq()
  {
    String str1 = "";
    int j = 0;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          int i = Integer.valueOf(str1).intValue();
          return i;
        }
        catch (Exception localException) {}
        localIOException = localIOException;
        LogUtil.e("", localIOException.toString());
        String str2 = "1008000";
      }
    }
    str1 = str1.trim();
    i = j;
    if (str1 != null)
    {
      i = j;
      if (TextUtils.isEmpty(str1)) {}
    }
    return 0;
  }
  
  public static java.net.Proxy getDefaultProxy()
  {
    if (android.net.Proxy.getDefaultHost() != null) {
      return new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
    }
    return null;
  }
  
  public static float getDensity(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.density;
  }
  
  public static final String getIMEI(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static boolean getIsFullScreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) != 0;
  }
  
  public static String getModel(Context paramContext)
  {
    if (Build.MODEL != null) {
      return Build.MODEL.replace(" ", "");
    }
    return "unknown";
  }
  
  public static int getRequestedOrientation(Activity paramActivity)
  {
    return paramActivity.getRequestedOrientation();
  }
  
  public static boolean getScreenAutoLock(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x80) > 0;
  }
  
  public static float getScreenBrightness(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 1.0F;
    }
    return paramActivity.getWindow().getAttributes().screenBrightness;
  }
  
  public static String getSystemVersion(Context paramContext)
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getTotalMemory()
  {
    try
    {
      FileReader localFileReader = new FileReader("/proc/meminfo");
      BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
      String str1 = localBufferedReader.readLine();
      String[] arrayOfString = str1.split("\\s+");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        LogUtil.e(str1, str2 + "\t");
        i += 1;
      }
      i = Integer.valueOf(arrayOfString[1]).intValue();
      localBufferedReader.close();
      localFileReader.close();
      return i;
    }
    catch (IOException localIOException) {}
    return 0;
  }
  
  public static String getUniqueCode(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    String str = getIMEI(paramContext);
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    paramContext = str + "_" + paramContext.getMacAddress();
    LogUtil.e("Common", "mUniqueCode: " + paramContext);
    return paramContext;
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 1;
  }
  
  public static String getVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  public static void hideInputMethod(Activity paramActivity)
  {
    if (paramActivity == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    } while (paramActivity.getCurrentFocus() == null);
    localInputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 0);
  }
  
  public static boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean isMediaMounted()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean isShowInputMethod(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    return ((InputMethodManager)paramActivity.getSystemService("input_method")).isActive();
  }
  
  public static boolean isVoid(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isWifi(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static String md5Encode(String paramString)
  {
    localStringBuffer = new StringBuffer();
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = ((MessageDigest)localObject).digest();
      int i = 0;
      while (i < paramString.length)
      {
        localObject = Integer.toHexString(paramString[i] & 0xFF);
        if (((String)localObject).length() == 1) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append((String)localObject);
        i += 1;
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramString) {}
  }
  
  public static void openAppInMarket(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      int i = 1;
      String str2 = paramContext.getPackageName();
      String str1 = "market://details?id=" + str2;
      str2 = "http://market.android.com/details?id=" + str2;
      try
      {
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str1)));
        if (i != 0) {
          continue;
        }
        try
        {
          paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
          return;
        }
        catch (Exception paramContext) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
  }
  
  public static String readPrivateFileData(Context paramContext, String paramString)
  {
    return readPrivateFileData(paramContext, paramString, "UTF-8");
  }
  
  public static String readPrivateFileData(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    localObject = str;
    try
    {
      paramString1 = paramContext.openFileInput(paramString1);
      localObject = str;
      paramContext = new byte[paramString1.available()];
      localObject = str;
      paramString1.read(paramContext);
      localObject = str;
      paramContext = EncodingUtils.getString(paramContext, paramString2);
      localObject = paramContext;
      paramString1.close();
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        LogUtil.e("", paramContext.toString());
        paramContext = (Context)localObject;
      }
    }
    LogUtil.e("Common", "readPrivateFileData: " + paramContext);
    return paramContext;
  }
  
  public static String readSDFileData(String paramString)
  {
    return readSDFileData(paramString, "UTF-8");
  }
  
  public static String readSDFileData(String paramString1, String paramString2)
  {
    String str2 = "";
    Object localObject = new File(paramString1);
    if ((!Environment.getExternalStorageState().equals("mounted")) || (!((File)localObject).exists()) || (((File)localObject).isDirectory())) {
      return "";
    }
    str1 = str2;
    try
    {
      localObject = new FileInputStream((File)localObject);
      str1 = str2;
      byte[] arrayOfByte = new byte[((FileInputStream)localObject).available()];
      str1 = str2;
      ((FileInputStream)localObject).read(arrayOfByte);
      str1 = str2;
      paramString2 = EncodingUtils.getString(arrayOfByte, paramString2);
      str1 = paramString2;
      ((FileInputStream)localObject).close();
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        LogUtil.e("", paramString2.toString());
        paramString2 = str1;
      }
    }
    LogUtil.e("Common", "sdFilePath: " + paramString1);
    LogUtil.e("Common", "readSDFileData: " + paramString2);
    return paramString2;
  }
  
  public static void setFullScreen(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLayoutParams = paramActivity.getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      paramActivity.getWindow().setAttributes(localLayoutParams);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    localLayoutParams.flags &= 0xFBFF;
    paramActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public static void setHasTitle(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.requestWindowFeature(7);
      return;
    }
    paramActivity.requestWindowFeature(1);
  }
  
  public static void setLayoutFlag(Activity paramActivity, int paramInt)
  {
    paramActivity.getWindow().clearFlags(512);
    paramActivity.getWindow().addFlags(paramInt);
  }
  
  public static void setRequestedOrientation(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(paramInt);
  }
  
  public static void setScreenAutoLock(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getWindow();
    if (paramBoolean)
    {
      paramActivity.setFlags(128, 128);
      return;
    }
    paramActivity.setFlags(0, 128);
  }
  
  public static void setScreenBrightness(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getWindow();
    paramActivity.getAttributes().screenBrightness = paramFloat;
    paramActivity.setAttributes(paramActivity.getAttributes());
  }
  
  public static void showInputMethod(Activity paramActivity)
  {
    if (paramActivity == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    } while (paramActivity.getCurrentFocus() == null);
    localInputMethodManager.showSoftInput(paramActivity.getCurrentFocus(), 0);
  }
  
  public static boolean startWap(String paramString, Context paramContext)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String toGbk(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "GBK");
      return paramString;
    }
    catch (Exception paramString)
    {
      return null;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public static String utf8Togb2312(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        localStringBuffer.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(' ');
        continue;
        try
        {
          localStringBuffer.append((char)Integer.parseInt(paramString.substring(i + 1, i + 3), 16));
          i += 2;
        }
        catch (NumberFormatException paramString)
        {
          throw new IllegalArgumentException();
        }
      }
    }
    paramString = localStringBuffer.toString();
    try
    {
      paramString = new String(paramString.getBytes("8859_1"), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return null;
  }
  
  public static boolean writePrivateFile(Context paramContext, String paramString1, String paramString2)
  {
    return writePrivateFile(paramContext, paramString1, paramString2, "UTF-8");
  }
  
  public static boolean writePrivateFile(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.openFileOutput(paramString1, 0);
      paramContext.write(paramString2.getBytes("UTF-8"));
      paramContext.close();
      return true;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("", paramContext.toString());
    }
    return false;
  }
  
  public static boolean writeSDFile(String paramString1, String paramString2)
  {
    return writeSDFile(paramString1, paramString2, "UTF-8");
  }
  
  public static boolean writeSDFile(String paramString1, String paramString2, String paramString3)
  {
    if ((!Environment.getExternalStorageState().equals("mounted")) || (paramString2 == null)) {
      return false;
    }
    try
    {
      paramString1 = new File(paramString1);
      if (paramString1.isDirectory()) {
        deleteDir(paramString1);
      }
      paramString1 = new FileOutputStream(paramString1);
      paramString1.write(paramString2.getBytes(paramString3));
      paramString1.close();
      return true;
    }
    catch (IOException paramString1)
    {
      LogUtil.e("", paramString1.toString());
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/wrapper/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */