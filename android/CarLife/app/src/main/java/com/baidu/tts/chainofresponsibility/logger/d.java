package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import com.baidu.tts.g.a.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
{
  private static volatile d a = null;
  private List<b> b = g();
  private ExecutorService c;
  private f d = new f();
  private e e = new e();
  private a f = a.b;
  private boolean g = false;
  
  private d()
  {
    this.b.add(this.d);
    this.c = Executors.newSingleThreadExecutor(new a("LoggerChainPoolThread"));
  }
  
  public static d a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d();
      }
      return a;
    }
    finally {}
  }
  
  private void a(c paramc, int paramInt, String paramString1, String paramString2)
  {
    c localc = paramc;
    if (paramc == null) {
      localc = new c();
    }
    localc.a(paramInt);
    localc.a(paramString1);
    localc.b(paramString2);
    a(localc);
  }
  
  private void b(c paramc)
  {
    try
    {
      if ((this.c != null) && (!this.c.isShutdown())) {
        this.c.execute(new b(paramc));
      }
      return;
    }
    catch (Exception paramc)
    {
      Log.e("LoggerChain", "executeWork exception=" + paramc.toString());
    }
  }
  
  private List<b> g()
  {
    if (this.b == null) {
      return new CopyOnWriteArrayList();
    }
    return this.b;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(new c(), paramInt, paramString1, paramString2);
  }
  
  public void a(c paramc)
  {
    if (paramc != null) {
      switch (1.a[this.f.ordinal()])
      {
      }
    }
    for (;;)
    {
      b(paramc);
      return;
      paramc.a(6);
      this.e.a(paramc, null, a);
      continue;
      if (this.g) {
        this.e.a(paramc, null, a);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.e != null) {
      this.e.a(paramString);
    }
  }
  
  public void a(List<String> paramList)
  {
    if (this.e != null) {
      this.e.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void b(String paramString)
  {
    if (this.e != null) {
      this.e.b(paramString);
    }
  }
  
  public void c()
  {
    if (this.e != null) {
      this.e.a();
    }
  }
  
  public void d()
  {
    this.f = a.b;
  }
  
  public boolean e()
  {
    return (this.f == null) || (this.f == a.b);
  }
  
  private static enum a
  {
    private a() {}
  }
  
  private class b
    implements Runnable
  {
    private c b;
    
    public b(c paramc)
    {
      this.b = paramc;
    }
    
    public void run()
    {
      Iterator localIterator = d.a(d.this).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).a(this.b, null, d.f());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/chainofresponsibility/logger/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */