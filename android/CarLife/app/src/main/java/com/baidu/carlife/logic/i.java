package com.baidu.carlife.logic;

import android.support.annotation.NonNull;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.a.n;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class i
  extends e
{
  private static final int b = 3;
  private static final int c = 20;
  private static final String d = "HlsDownloadThread";
  private String e = "http://ls.qingting.fm/live/386.m3u8";
  private List<String> f = new ArrayList();
  private List<String> g = new ArrayList();
  private ArrayList<String> h;
  private int i = -1;
  private f j;
  private f k;
  
  public i(ArrayList<String> paramArrayList)
  {
    this.h = paramArrayList;
    this.j = new a(this);
    this.k = new b(this);
  }
  
  private void a(File paramFile)
  {
    this.f.clear();
    this.g.clear();
    this.h.clear();
    b(paramFile);
  }
  
  private void a(String paramString, int paramInt)
  {
    a(true);
    try
    {
      this.j.a(paramString, String.valueOf(paramInt));
      return;
    }
    catch (SocketTimeoutException paramString)
    {
      com.baidu.carlife.core.i.e("HlsDownloadThread", "socket time out");
      paramString.printStackTrace();
      return;
    }
    catch (IOException paramString)
    {
      com.baidu.carlife.core.i.e("HlsDownloadThread", "io error");
      paramString.printStackTrace();
    }
  }
  
  private void b(File paramFile)
  {
    paramFile = paramFile.listFiles();
    int n = paramFile.length;
    int m = 0;
    while (m < n)
    {
      paramFile[m].delete();
      m += 1;
    }
  }
  
  private void d(String paramString)
  {
    com.baidu.carlife.core.i.b("HlsDownloadThread", "m3u8 url is " + paramString);
    a(true);
    try
    {
      this.k.a(paramString, "test");
      return;
    }
    catch (SocketTimeoutException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    File localFile = h();
    this.i = 1;
    this.f.clear();
    b(false);
    d(this.e);
    f();
    a(localFile);
  }
  
  private void e(String paramString)
    throws IOException
  {
    paramString = new FileReader(paramString);
    BufferedReader localBufferedReader = new BufferedReader(paramString);
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      str = n.a().a(str);
      if (f(str))
      {
        com.baidu.carlife.core.i.b("HlsDownloadThread", "aac url added " + str);
        this.f.add(str);
      }
    }
    if (paramString != null) {}
    try
    {
      paramString.close();
      if (localBufferedReader != null) {
        localBufferedReader.close();
      }
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void f()
  {
    while (c()) {
      if (this.f.size() == 0)
      {
        com.baidu.carlife.core.i.b("HlsDownloadThread", "load more aac url");
        c(1000);
        d(this.e);
      }
      else
      {
        a((String)this.f.get(0), this.i);
        this.g.add(this.f.get(0));
        this.f.remove(0);
        this.i += 1;
      }
    }
    com.baidu.carlife.core.i.b("HlsDownloadThread", "download aborted");
  }
  
  private boolean f(String paramString)
  {
    return (paramString != null) && (!this.f.contains(paramString)) && (!this.g.contains(paramString));
  }
  
  private boolean g()
  {
    return (this.e != null) && (!this.e.isEmpty());
  }
  
  @NonNull
  private File h()
  {
    File localFile = new File(com.baidu.carlife.core.f.jm + "/fm");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return localFile;
  }
  
  private boolean i()
  {
    return this.h.size() > 3;
  }
  
  private void j()
  {
    if (this.g.size() > 20) {
      this.g.remove(0);
    }
  }
  
  private void k()
  {
    while ((c()) && (i())) {
      c(300);
    }
  }
  
  public void b(String paramString)
  {
    this.e = n.a().a(paramString);
    b(true);
  }
  
  public void run()
  {
    while (this.f != null) {
      if ((d()) && (g())) {
        e();
      } else {
        c(300);
      }
    }
  }
  
  private class a
    extends f
  {
    public a(w paramw)
    {
      super();
    }
    
    void a(String paramString)
      throws IOException
    {
      i.a(i.this).add(paramString);
    }
  }
  
  private class b
    extends f
  {
    public b(w paramw)
    {
      super();
    }
    
    void a()
    {
      com.baidu.carlife.core.i.e("HlsDownloadThread", "index file download fail");
      k.b(424);
    }
    
    void a(String paramString)
      throws IOException
    {
      i.a(i.this, paramString);
      i.b(i.this);
      if (i.c(i.this))
      {
        com.baidu.carlife.core.i.e("HlsDownloadThread", "notify audio track to awake");
        k.b(426);
      }
      i.d(i.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */