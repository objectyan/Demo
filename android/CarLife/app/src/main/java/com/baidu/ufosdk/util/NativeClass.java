package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class NativeClass
{
  private static final String UFO_NATIVE_LIB = "ufosdk";
  private Context mContext;
  
  public NativeClass(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private String getUserSerial()
  {
    Object localObject1 = this.mContext.getSystemService("user");
    if (localObject1 == null)
    {
      c.d("NativeClass-->userManager not exsit!!!");
      return null;
    }
    try
    {
      Object localObject2 = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);
      long l = ((Long)localObject1.getClass().getMethod("getSerialNumberForUser", new Class[] { localObject2.getClass() }).invoke(localObject1, new Object[] { localObject2 })).longValue();
      return String.valueOf(l);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
  }
  
  public native String init(String paramString1, String paramString2, String paramString3);
  
  public void init(String paramString1, String paramString2, HashMap paramHashMap)
  {
    paramString1 = this.mContext.getFilesDir().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramHashMap != null) {
      paramHashMap = paramHashMap.entrySet().iterator();
    }
    for (;;)
    {
      if (!paramHashMap.hasNext())
      {
        paramString2 = paramString2 + localStringBuilder.toString();
        c.b("ufosdk-->commonuninstall: " + paramString2);
        c.b("pkgNamePath-->pkgNamePath: " + paramString1);
        if (Build.VERSION.SDK_INT >= 17) {
          break;
        }
        init(paramString1, paramString2, null);
        return;
      }
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      localStringBuilder.append("&");
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)localObject);
    }
    init(paramString1, paramString2, getUserSerial());
  }
  
  @SuppressLint({"NewApi"})
  public boolean loadUFONativeLib()
  {
    for (;;)
    {
      try
      {
        if (this.mContext == null)
        {
          c.b("##################NativeCrashHandler loadNativeCrashHandler failed context is null!");
          return false;
        }
        if (i.a() < 9)
        {
          String str1 = this.mContext.getApplicationInfo().dataDir + "/lib/" + System.mapLibraryName("ufosdk");
          if ((TextUtils.isEmpty(str1)) || (new File(str1).exists())) {
            break;
          }
          c.b("###################NativeCrashHandler loadNativeCrashHandler failed so file is not exists! dir is " + str1);
          return false;
        }
      }
      catch (Exception localException)
      {
        c.d("###################NativeCrashHandler loadNativeCrashHandler failed!");
        localException.printStackTrace();
        return false;
      }
      str2 = this.mContext.getApplicationInfo().nativeLibraryDir + "/" + System.mapLibraryName("ufosdk");
    }
    String str2 = Build.CPU_ABI;
    c.b("cpu-->" + str2);
    if ((!TextUtils.isEmpty(str2)) && ((str2.contains("arm")) || (str2.contains("x86")) || (str2.contains("mips"))))
    {
      System.loadLibrary("ufosdk");
      c.b("###################NativeCrashHandler loadNativeCrashHandler success!  CPU_ABI is " + str2);
      return true;
    }
    c.b("###################NativeCrashHandler loadNativeCrashHandler failed, CPU_ABI is " + str2);
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/NativeClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */