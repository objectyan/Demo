package com.baidu.carlife.logic;

import android.support.annotation.NonNull;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class e
  extends Thread
  implements w
{
  public static final int a = -1000;
  private static final String b = "DownLoadThread";
  private static final int c = 1024;
  private static final int d = 200;
  private static final int e = 206;
  private static final int f = 5000;
  private boolean g = false;
  private boolean h = false;
  private byte[] i = new byte['Ѐ'];
  
  private int a(InputStream paramInputStream, RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    int j = 0;
    while (c())
    {
      int k = paramInputStream.read(this.i, 0, 1024);
      if (k == -1) {
        break;
      }
      paramRandomAccessFile.write(this.i, 0, k);
      b(k);
      j += k;
    }
    return j;
  }
  
  private String d(String paramString)
  {
    if (paramString.endsWith(".m3u8")) {
      return ".m3u8";
    }
    if (paramString.endsWith(".aac")) {
      return ".aac";
    }
    return ".mp3";
  }
  
  public int a(String paramString, HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    paramString = c(paramString);
    if (paramHttpURLConnection.getResponseCode() == 206) {
      a(paramString);
    }
    InputStream localInputStream = paramHttpURLConnection.getInputStream();
    int j = paramHttpURLConnection.getContentLength();
    a(j);
    paramString.setLength(j);
    j = a(localInputStream, paramString);
    paramString.close();
    localInputStream.close();
    paramHttpURLConnection.disconnect();
    return j;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return f.jm + "/" + paramString2 + d(paramString1);
  }
  
  @NonNull
  public HttpURLConnection a(String paramString)
    throws IOException
  {
    i.b("DownLoadThread", "start to download " + paramString);
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(5000);
    paramString.setRequestMethod("GET");
    a(paramString);
    return paramString;
  }
  
  public void a()
  {
    a(false);
  }
  
  void a(int paramInt) {}
  
  void a(RandomAccessFile paramRandomAccessFile) {}
  
  void a(HttpURLConnection paramHttpURLConnection) {}
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b()
  {
    b(true);
  }
  
  void b(int paramInt) {}
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean b(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    try
    {
      int j = paramHttpURLConnection.getResponseCode();
      if ((206 == j) || (200 == j)) {
        j = paramHttpURLConnection.getContentLength();
      }
      return j < 0;
    }
    catch (ArrayIndexOutOfBoundsException paramHttpURLConnection) {}
    return true;
  }
  
  @NonNull
  RandomAccessFile c(String paramString)
    throws FileNotFoundException
  {
    int j = paramString.lastIndexOf("/");
    Object localObject = "";
    if (paramString.length() >= j) {
      localObject = paramString.substring(0, j);
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    return new RandomAccessFile(paramString, "rwd");
  }
  
  protected void c(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.h;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */