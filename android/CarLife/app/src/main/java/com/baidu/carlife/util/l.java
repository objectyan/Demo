package com.baidu.carlife.util;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class l
{
  public static long a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return a(Environment.getExternalStorageDirectory().toString());
    }
    return 0L;
  }
  
  public static long a(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      localStatFs.restat(paramString);
      if (Build.VERSION.SDK_INT >= 18) {
        return localStatFs.getAvailableBlocksLong() * localStatFs.getBlockSizeLong();
      }
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      return l * i;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static long b()
  {
    return a("/data");
  }
  
  public static boolean b(String paramString)
  {
    long l = new File(paramString).length();
    if ((paramString.startsWith("/sdcard")) || (paramString.startsWith("/mnt/sdcard"))) {
      if (a() <= l) {}
    }
    while (b() > l)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static long c()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return c(Environment.getExternalStorageDirectory().toString());
    }
    return 0L;
  }
  
  private static long c(String paramString)
  {
    StatFs localStatFs = new StatFs(paramString);
    localStatFs.restat(paramString);
    if (Build.VERSION.SDK_INT >= 18) {
      return localStatFs.getBlockCountLong() * localStatFs.getBlockSizeLong();
    }
    return localStatFs.getBlockCount() * localStatFs.getBlockSize();
  }
  
  public static long d()
  {
    return c("/data");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */