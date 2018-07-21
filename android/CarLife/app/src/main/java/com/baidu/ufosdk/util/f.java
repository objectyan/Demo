package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

@SuppressLint({"DefaultLocale"})
public final class f
{
  private static String c = Environment.getExternalStorageDirectory().getPath() + "/image_cache";
  private static f d = null;
  public final int a = 1209600000;
  private final String b = "ufo";
  
  public static Bitmap a(String paramString)
  {
    paramString = b(paramString);
    if (!new File(paramString).exists()) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = BitmapFactory.decodeFile(paramString, null);
    } while (localBitmap == null);
    new File(c + "/cache/image/", paramString).setLastModified(System.currentTimeMillis());
    return localBitmap;
  }
  
  public static f a()
  {
    if (d == null) {
      d = new f();
    }
    return d;
  }
  
  private static String b(String paramString)
  {
    return c + "/cache/image/" + paramString;
  }
  
  public static void b()
  {
    String str = c + "/cache/image/";
    File[] arrayOfFile = new File(str).listFiles();
    if (arrayOfFile == null) {}
    for (;;)
    {
      return;
      c.b("ufo-->Clear all cache files,dir=" + str);
      int i = 0;
      while (i < arrayOfFile.length)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  private static int c()
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      double d1 = localStatFs.getAvailableBlocks();
      return (int)(localStatFs.getBlockSize() * d1 / 1048576.0D);
    }
    c.b("sdCard is not exist");
    return 0;
  }
  
  private void c(String paramString)
  {
    int k = 0;
    paramString = new File(paramString).listFiles();
    if (paramString == null) {
      return;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramString.length)
      {
        if ((j <= 20971520) && (20 <= c())) {
          break;
        }
        j = (int)(0.4D * paramString.length + 1.0D);
        Arrays.sort(paramString, new g(this));
        c.b("Clear some expiredcache files");
        i = k;
        while (i < j)
        {
          paramString[i].delete();
          i += 1;
        }
        break;
      }
      j = (int)(j + paramString[i].length());
      i += 1;
    }
  }
  
  public final void a(Bitmap paramBitmap, String paramString)
  {
    boolean bool;
    try
    {
      bool = Environment.getExternalStorageState().equals("mounted");
      if (!bool) {
        return;
      }
      paramString = new File(b(paramString));
      if (20 > c())
      {
        c.c("ufo-->Low free space onsd, do not cache");
        return;
      }
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
      return;
    }
    c(c + "/cache/image/");
    if (bool)
    {
      File localFile1 = new File(c);
      File localFile2 = new File(c + "/cache");
      File localFile3 = new File(c + "/cache/image");
      if (!localFile1.exists()) {
        localFile1.mkdir();
      }
      if (!localFile2.exists()) {
        localFile2.mkdir();
      }
      if (!localFile3.exists()) {
        localFile3.mkdir();
      }
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
    }
    paramString = new BufferedOutputStream(new FileOutputStream(paramString));
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
    paramString.flush();
    paramString.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */