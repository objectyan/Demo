package com.baidu.tts.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.tts.f.d;
import com.baidu.tts.f.n;
import com.baidu.tts.m.i;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class ResourceTools
{
  public static final int TEXT_LENGTH_LIMIT = 1024;
  
  public static i format(String paramString1, String paramString2, i parami)
  {
    try
    {
      parami.b(new String(parami.c().getBytes(paramString1), paramString2));
      parami.c(paramString2);
      return parami;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String getAppFilesDirPath(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath() + "/";
  }
  
  public static String getAppFilesPath(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      localObject = ((PackageInfo)localObject).applicationInfo.dataDir + "/files/";
      return (String)localObject;
    }
    catch (Exception localException) {}
    return paramContext.getFilesDir().getAbsolutePath() + "/";
  }
  
  public static String getByteMapAbsName(Context paramContext, String paramString)
  {
    return getModelFileAbsName(paramContext, paramString + ".bm");
  }
  
  public static String getDefaultResourcePath(Context paramContext, String paramString)
  {
    return getSdcardFilesDirPath(paramContext) + paramString;
  }
  
  public static String getModelFileAbsName(Context paramContext, String paramString)
  {
    return FileTools.jointPathAndName(getAppFilesPath(paramContext) + "modelDir/", paramString);
  }
  
  @SuppressLint({"SdCardPath"})
  public static String getSdcardFilesDirPath(Context paramContext)
  {
    return "/sdcard/tts/";
  }
  
  public static n isTextValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return n.P;
    }
    try
    {
      if (paramString.getBytes(d.d.a()).length > 1024)
      {
        paramString = n.Q;
        return paramString;
      }
      return null;
    }
    catch (UnsupportedEncodingException paramString) {}
    return n.R;
  }
  
  public static byte[] stringToByteArrayAddNull(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    paramString = ((String)localObject).getBytes();
    localObject = new byte[1];
    localObject[0] = 0;
    byte[] arrayOfByte = new byte[paramString.length + 1];
    System.arraycopy(paramString, 0, arrayOfByte, 0, paramString.length);
    System.arraycopy(localObject, 0, arrayOfByte, paramString.length, localObject.length);
    return arrayOfByte;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/ResourceTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */