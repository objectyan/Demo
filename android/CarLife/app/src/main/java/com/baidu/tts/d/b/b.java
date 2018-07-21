package com.baidu.tts.d.b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class b
{
  private String a;
  private long b;
  private String c;
  private volatile int d = 0;
  private volatile int e = 9;
  private String f;
  private com.baidu.tts.d.a.e g;
  private CopyOnWriteArraySet<String> h = new CopyOnWriteArraySet();
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  private void j()
  {
    if (this.g != null)
    {
      LoggerProxy.d("FsFileInfoFlyweight", "unregisterObserver stop");
      this.g.a();
      this.g = null;
      if ((this.d == 4) || (this.d == 5))
      {
        this.d = 8;
        this.e = 8;
        a.a().b().a(this.a, this.e);
      }
    }
  }
  
  public int a(c paramc)
  {
    File localFile = new File(this.a);
    if (localFile.exists())
    {
      this.b = localFile.length();
      long l = Long.parseLong(paramc.b());
      if (this.b == l)
      {
        this.c = MD5.getInstance().getBigFileMd5(localFile);
        if (paramc.c().equalsIgnoreCase(this.c)) {
          this.d = 7;
        }
      }
    }
    for (;;)
    {
      return this.d;
      this.d = 3;
      continue;
      this.d = 2;
      continue;
      this.d = 1;
    }
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a locala = a.a();
    this.b = paramLong1;
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        locala.b((String)localIterator.next()).a(this);
      }
    }
  }
  
  public void a(TtsError paramTtsError)
  {
    LoggerProxy.d("FsFileInfoFlyweight", "onDownloadFailure");
    this.d = 8;
    this.e = 8;
    a locala = a.a();
    locala.b().a(this.a, this.e);
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        locala.b(str).a(this, paramTtsError);
        this.h.remove(str);
      }
    }
  }
  
  public void a(com.baidu.tts.d.a.e parame)
  {
    this.g = parame;
  }
  
  public void a(String paramString)
  {
    if (this.h != null) {
      this.h.add(paramString);
    }
  }
  
  public boolean a(com.baidu.tts.database.a parama)
  {
    c localc = e.a().b(this.f);
    if (this.d == 0)
    {
      a(localc);
      b(parama);
    }
    for (;;)
    {
      if ((this.d == 7) && (this.e != 7))
      {
        this.e = 7;
        parama.a(this.a, this.e);
      }
      LoggerProxy.d("FsFileInfoFlyweight", "fileId=" + this.f + "--filestate=" + this.d + "--dbstate=" + this.e);
      if ((this.d != 4) && (this.d != 5) && (this.d != 7)) {
        break;
      }
      return false;
      if ((this.d == 8) || (this.d == 7)) {
        a(localc);
      }
    }
    return true;
  }
  
  public int b(com.baidu.tts.database.a parama)
  {
    parama = DataTool.getMapValue(parama.c(this.a), g.a.b());
    if (StringTool.isEmpty(parama)) {}
    for (this.e = 9;; this.e = Integer.parseInt(parama)) {
      return this.e;
    }
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    boolean bool = DataTool.isSetEmpty(this.h);
    LoggerProxy.d("FsFileInfoFlyweight", "unregisterObserver 1isEmpty=" + bool);
    if (!bool)
    {
      this.h.remove(paramString);
      bool = DataTool.isSetEmpty(this.h);
      LoggerProxy.d("FsFileInfoFlyweight", "unregisterObserver 2isEmpty=" + bool);
      if (bool) {
        j();
      }
    }
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    if (this.d == 7) {}
    long l;
    do
    {
      do
      {
        return false;
      } while ((this.d == 4) || (this.d == 5));
      l = Long.parseLong(e.a().b(this.f).b());
    } while (this.b < l);
    return true;
  }
  
  public boolean f()
  {
    return new File(this.a).delete();
  }
  
  public void g()
  {
    LoggerProxy.d("FsFileInfoFlyweight", "queueForDownload fileId=" + this.f + "--filestate=" + this.d);
    this.d = 4;
  }
  
  public void h()
  {
    this.d = 5;
    this.e = 6;
    a.a().b().a(this.a, this.e);
  }
  
  public void i()
  {
    LoggerProxy.d("FsFileInfoFlyweight", "onDownloadSuccess");
    this.d = 7;
    this.e = 7;
    a locala = a.a();
    locala.b().a(this.a, this.e);
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        locala.b(str).b(this);
        this.h.remove(str);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */