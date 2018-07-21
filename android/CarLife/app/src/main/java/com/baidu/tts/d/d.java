package com.baidu.tts.d;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.l.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d
{
  private c a = c.a();
  private ConcurrentMap<String, DownloadHandler> b = new ConcurrentHashMap();
  private a c;
  
  private void c()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((DownloadHandler)localIterator.next()).stop();
    }
  }
  
  public DownloadHandler a(b paramb)
  {
    if ((paramb != null) && (paramb.b()))
    {
      DownloadHandler localDownloadHandler = a(paramb.a());
      if (localDownloadHandler != null)
      {
        localDownloadHandler.reset(paramb);
        return this.a.a(localDownloadHandler);
      }
    }
    return null;
  }
  
  public DownloadHandler a(String paramString)
  {
    try
    {
      DownloadHandler localDownloadHandler2 = (DownloadHandler)this.b.get(paramString);
      localDownloadHandler1 = localDownloadHandler2;
      if (localDownloadHandler2 == null)
      {
        localDownloadHandler1 = new DownloadHandler(this.c);
        this.b.put(paramString, localDownloadHandler1);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        DownloadHandler localDownloadHandler1 = null;
      }
    }
    finally {}
    return localDownloadHandler1;
  }
  
  public void a()
  {
    this.a.g();
  }
  
  public void a(a parama)
  {
    this.c = parama;
    this.a.a(parama);
  }
  
  public void b()
  {
    c();
    this.a.e();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */