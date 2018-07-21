package com.baidu.carlife.platform.service;

import android.text.TextUtils;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.platform.communication.CLPackage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class d
{
  private static d a;
  private static final Object b = new Object();
  private static final int j = 2;
  private String c;
  private a d;
  private RandomAccessFile e;
  private String f;
  private long g;
  private long h;
  private long i;
  private double k;
  
  public static d a()
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new d();
      }
      return a;
    }
  }
  
  private RandomAccessFile a(String paramString, long paramLong)
  {
    paramString = f.jm + "/" + paramString + ".mp3";
    File localFile = new File(paramString);
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      paramString = new RandomAccessFile(paramString, "rwd");
      if (paramLong > 0L) {}
      i.a("PlatformManager", paramString);
    }
    catch (IOException paramString)
    {
      try
      {
        paramString.setLength(paramLong);
        return paramString;
      }
      catch (IOException paramString)
      {
        for (;;) {}
      }
      paramString = paramString;
    }
    return null;
  }
  
  private void a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((this.d != null) && (paramString2 != null)) {
      this.d.a(paramInt, paramString1, paramString2, paramLong1, paramLong2, paramBoolean);
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    a(0, "", paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  private void c()
  {
    this.c = null;
    this.d = null;
    this.f = null;
    this.g = -1L;
    this.h = -1L;
    this.i = 0L;
    if (this.e != null) {}
    try
    {
      this.e.close();
      return;
    }
    catch (IOException localIOException)
    {
      i.a("PlatformManager", localIOException);
      return;
    }
    finally
    {
      this.e = null;
    }
  }
  
  public CLPackage a(CLPackage paramCLPackage)
  {
    if ((paramCLPackage == null) || (paramCLPackage.dataId != this.h) || (paramCLPackage.getData() == null) || (paramCLPackage.getDataLength() <= 0) || (this.e == null)) {
      return paramCLPackage;
    }
    for (;;)
    {
      try
      {
        this.e.write(paramCLPackage.getData(), 0, paramCLPackage.length);
        this.i += paramCLPackage.length;
        if (this.i > this.k)
        {
          if (this.k <= 120000.0D)
          {
            this.k *= 2.0D;
            a(this.f, this.i, this.g, false);
          }
        }
        else
        {
          if (this.i < this.g) {
            break;
          }
          a(this.f, this.i, this.g, true);
          c();
          return paramCLPackage;
        }
      }
      catch (IOException localIOException)
      {
        i.a("PlatformManager", localIOException);
        a(this.f, this.i, this.g, true);
        c();
        return paramCLPackage;
      }
      this.k += 120000.0D;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    i.b("CarLifePlatform", "stopDownloadSong() songId=" + this.f + " appName=" + this.c);
    a(paramInt, paramString, this.f, this.i, this.g, true);
    c();
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
    if ((this.e != null) && (this.g > 0L)) {}
    try
    {
      this.e.setLength(paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      i.a("PlatformManager", localIOException);
    }
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.c))) {
      return;
    }
    a(0, "");
  }
  
  public void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    i.b("CarLifePlatform", "startDownloadSong() requestId=" + paramLong2 + " totalSize=" + paramLong1);
    this.c = paramString1;
    this.d = parama;
    this.f = paramString2;
    this.g = paramLong1;
    this.h = paramLong2;
    this.i = 0L;
    this.k = 30000.0D;
    this.e = a(this.f, this.g);
    if (this.e == null)
    {
      a(this.f, this.i, this.g, true);
      c();
    }
  }
  
  public void b()
  {
    a(0, "");
  }
  
  public boolean b(long paramLong)
  {
    return paramLong == this.h;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */