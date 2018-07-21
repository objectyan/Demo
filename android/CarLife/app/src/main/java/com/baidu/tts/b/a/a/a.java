package com.baidu.tts.b.a.a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.m.f;
import com.baidu.tts.m.g;
import com.baidu.tts.m.h;
import com.baidu.tts.m.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a
  extends com.baidu.tts.j.a
  implements d
{
  protected com.baidu.tts.b.a.b.b a;
  protected List<com.baidu.tts.b.a.b> b = new ArrayList();
  protected volatile b c;
  
  public int a(com.baidu.tts.m.e parame)
  {
    return this.c.a(parame);
  }
  
  public int a(f paramf)
  {
    return this.c.a(paramf);
  }
  
  public int a(g paramg)
  {
    return this.c.a(paramg);
  }
  
  public b a()
  {
    return this.c;
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
  }
  
  public void a(com.baidu.tts.b.a.b.b paramb)
  {
    this.c.a(paramb);
  }
  
  public void a(com.baidu.tts.b.a.b paramb)
  {
    this.c.a(paramb);
  }
  
  void a(h paramh)
  {
    if (C())
    {
      h localh = paramh;
      if (paramh == null) {
        localh = new h();
      }
      localh.a(com.baidu.tts.f.e.a);
      if (this.b != null)
      {
        paramh = this.b.iterator();
        while (paramh.hasNext())
        {
          com.baidu.tts.b.a.b localb = (com.baidu.tts.b.a.b)paramh.next();
          if (localb != null) {
            localb.a(localh);
          }
        }
      }
    }
  }
  
  public void a(i parami)
  {
    this.c.a(parami);
  }
  
  public void a(Object paramObject)
  {
    this.c.a(paramObject);
  }
  
  public int b(com.baidu.tts.m.e parame)
  {
    return this.c.b(parame);
  }
  
  void b(h paramh)
  {
    if (C())
    {
      h localh = paramh;
      if (paramh == null) {
        localh = new h();
      }
      localh.a(com.baidu.tts.f.e.c);
      if (this.b != null)
      {
        paramh = this.b.iterator();
        while (paramh.hasNext())
        {
          com.baidu.tts.b.a.b localb = (com.baidu.tts.b.a.b)paramh.next();
          if (localb != null) {
            localb.c(localh);
          }
        }
      }
    }
  }
  
  void c(h paramh)
  {
    if (C())
    {
      h localh = paramh;
      if (paramh == null) {
        localh = new h();
      }
      localh.a(com.baidu.tts.f.e.b);
      if (this.b != null)
      {
        paramh = this.b.iterator();
        while (paramh.hasNext())
        {
          com.baidu.tts.b.a.b localb = (com.baidu.tts.b.a.b)paramh.next();
          if (localb != null) {
            localb.b(localh);
          }
        }
      }
    }
  }
  
  void d(h paramh)
  {
    h localh = paramh;
    if (paramh == null) {
      localh = new h();
    }
    localh.a(com.baidu.tts.f.e.d);
    if (this.b != null)
    {
      paramh = this.b.iterator();
      while (paramh.hasNext())
      {
        com.baidu.tts.b.a.b localb = (com.baidu.tts.b.a.b)paramh.next();
        if (localb != null) {
          localb.e(localh);
        }
      }
    }
  }
  
  void e(h paramh)
  {
    h localh = paramh;
    if (paramh == null) {
      localh = new h();
    }
    localh.a(com.baidu.tts.f.e.g);
    if (this.b != null)
    {
      paramh = this.b.iterator();
      while (paramh.hasNext())
      {
        com.baidu.tts.b.a.b localb = (com.baidu.tts.b.a.b)paramh.next();
        if (localb != null) {
          localb.d(localh);
        }
      }
    }
  }
  
  protected TtsError g()
  {
    return this.c.b();
  }
  
  protected void h()
  {
    this.c.a();
  }
  
  protected void i()
  {
    this.c.c();
  }
  
  protected void j()
  {
    this.c.d();
  }
  
  protected void k()
  {
    this.c.e();
  }
  
  protected void l()
  {
    this.c.f();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */