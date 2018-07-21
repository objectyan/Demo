package com.baidu.tts.d.b;

import com.baidu.tts.client.model.DownloadHandler;

public class a
{
  private static volatile a a = null;
  private e b = e.a();
  private com.baidu.tts.database.a c;
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  public b a(String paramString)
  {
    return this.b.c(paramString);
  }
  
  public void a(DownloadHandler paramDownloadHandler)
  {
    this.b.a(paramDownloadHandler);
  }
  
  public void a(com.baidu.tts.database.a parama)
  {
    this.c = parama;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
  }
  
  public d b(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public com.baidu.tts.database.a b()
  {
    return this.c;
  }
  
  public c c(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public void c()
  {
    this.b.b();
  }
  
  public long d(String paramString)
  {
    return this.b.e(paramString);
  }
  
  public int e(String paramString)
  {
    return this.b.f(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */