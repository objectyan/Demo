package com.baidu.navisdk.util.common;

import android.os.Environment;
import android.util.Log;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogUtil
{
  private static final String DEFAULT_TAG = "com.baidu.carlife#navisdk#";
  public static boolean LOGGABLE = BNSettingManager.isShowJavaLog();
  public static boolean LOGWRITE = false;
  public static boolean PERFORMANCE_LOGGABLE = LOGGABLE & false;
  public static boolean PERFORMANCE_LOG_TO_FILE = PERFORMANCE_LOGGABLE;
  private static final String TAG = LogUtil.class.getSimpleName();
  
  public static void e(String paramString1, String paramString2)
  {
    if (LOGGABLE)
    {
      String str = makeLogDetailInfoString(paramString1, paramString2, getValidStackTrace());
      Log.e("com.baidu.carlife#navisdk#", str);
      SDKDebugFileUtil.get("normal_all_log").add(str);
    }
    if (LOGWRITE) {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", makeLogDetailInfoString(paramString1, paramString2, getValidStackTrace()));
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    String str1 = Environment.getExternalStorageDirectory().toString() + "/BaiduCarLifeLog.txt";
    String str2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date());
    StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
    paramString1 = str2 + " " + makeLogDetailInfoString(paramString1, paramString2, localStackTraceElement) + "\r\n";
    try
    {
      paramString2 = new FileWriter(str1, true);
      paramString2.write(paramString1);
      paramString2.flush();
      paramString2.close();
      return;
    }
    catch (IOException paramString1)
    {
      e("", paramString1.toString());
    }
  }
  
  public static String getCallStack()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        localStringBuffer.append("at " + arrayOfStackTraceElement[i].getClassName() + "." + arrayOfStackTraceElement[i].getMethodName() + "(" + arrayOfStackTraceElement[i].getFileName() + ":" + arrayOfStackTraceElement[i].getLineNumber() + ")\n");
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String getCallStack(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        if ((arrayOfStackTraceElement[i].getClassName() != null) && (arrayOfStackTraceElement[i].getClassName().contains(paramString))) {
          localStringBuffer.append("at " + arrayOfStackTraceElement[i].getClassName() + "." + arrayOfStackTraceElement[i].getMethodName() + "(" + arrayOfStackTraceElement[i].getFileName() + ":" + arrayOfStackTraceElement[i].getLineNumber() + ")\n");
        }
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  private static StackTraceElement getValidStackTrace()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    Object localObject2 = null;
    Object localObject3 = null;
    if (arrayOfStackTraceElement != null)
    {
      int i = 1;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject3;
        if (i >= arrayOfStackTraceElement.length) {
          break;
        }
        localObject1 = arrayOfStackTraceElement[i];
        if ((!((StackTraceElement)localObject1).getFileName().contains(TAG)) && (!((StackTraceElement)localObject1).getFileName().contains("NavLogUtils.java"))) {
          break;
        }
        i += 1;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = arrayOfStackTraceElement[0];
      }
    }
    return (StackTraceElement)localObject2;
  }
  
  private static String makeLogDetailInfoString(String paramString1, String paramString2, StackTraceElement paramStackTraceElement)
  {
    paramString1 = "[" + paramString1 + "]-" + paramStackTraceElement.getFileName() + "(" + paramStackTraceElement.getLineNumber() + "): ";
    return paramString1 + paramString2;
  }
  
  public static void printCallStatck()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      e("printCallStatck", "----start----");
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        e("printCallStatck", "at " + arrayOfStackTraceElement[i].getClassName() + "." + arrayOfStackTraceElement[i].getMethodName() + "(" + arrayOfStackTraceElement[i].getFileName() + ":" + arrayOfStackTraceElement[i].getLineNumber() + ")\n");
        i += 1;
      }
      e("printCallStatck", "----end----");
    }
  }
  
  public static void saveFellowLogToFile(String paramString1, String paramString2)
  {
    String str1;
    if (LOGGABLE)
    {
      str1 = SysOSAPI.getInstance().GetSDCardPath() + "/fellow/FellowPlayLog.txt";
      String str2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date());
      StackTraceElement localStackTraceElement = new Throwable().getStackTrace()[1];
      paramString1 = str2 + " " + makeLogDetailInfoString(paramString1, paramString2, localStackTraceElement) + "\r\n";
    }
    try
    {
      paramString2 = new FileWriter(str1, true);
      paramString2.write(paramString1);
      paramString2.flush();
      paramString2.close();
      return;
    }
    catch (IOException paramString1)
    {
      e("", paramString1.toString());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/LogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */