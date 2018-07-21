package com.baidu.tts.d.b;

import com.baidu.tts.client.model.DownloadHandler;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e a = null;
  private ConcurrentHashMap<String, d> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, c> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, b> d = new ConcurrentHashMap();
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  public d a(String paramString)
  {
    try
    {
      d locald1 = new d(paramString);
      d locald2 = (d)this.b.putIfAbsent(paramString, locald1);
      paramString = locald2;
      if (locald2 == null) {
        paramString = locald1;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void a(DownloadHandler paramDownloadHandler)
  {
    a(paramDownloadHandler.getModelId()).b(paramDownloadHandler);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    if (paramString1 != null) {
      paramString1.b(paramString2);
    }
  }
  
  public c b(String paramString)
  {
    try
    {
      c localc1 = new c(paramString);
      c localc2 = (c)this.c.putIfAbsent(paramString, localc1);
      paramString = localc2;
      if (localc2 == null) {
        paramString = localc1;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void b()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a();
    }
  }
  
  public b c(String paramString)
  {
    try
    {
      b localb1 = new b(paramString);
      b localb2 = (b)this.d.putIfAbsent(paramString, localb1);
      paramString = localb2;
      if (localb2 == null) {
        paramString = localb1;
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public b d(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return c(paramString.a());
    }
    return null;
  }
  
  public long e(String paramString)
  {
    return d(paramString).a();
  }
  
  public int f(String paramString)
  {
    return d(paramString).d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */