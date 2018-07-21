package com.baidu.carlife.wechat.f;

import com.baidu.baidunavis.tts.IBNTTSPlayerWeChatListener;
import com.baidu.carlife.wechat.a.b.c;
import com.baidu.carlife.wechat.b.k;

public class b
  implements a.a
{
  private com.baidu.carlife.wechat.b.d a;
  private com.baidu.carlife.wechat.b.b b;
  private a c;
  
  public static b d()
  {
    return a.a();
  }
  
  public void a()
  {
    c.c("");
    if (this.a != null)
    {
      k.a().c(this.a);
      return;
    }
    c();
  }
  
  public void a(com.baidu.carlife.wechat.b.b paramb)
  {
    c.c("");
    this.b = paramb;
    this.c.a(paramb);
  }
  
  public void a(com.baidu.carlife.wechat.b.b paramb, String paramString)
  {
    c.c("");
    this.b = paramb;
    d.a();
    d.a(new IBNTTSPlayerWeChatListener()
    {
      public void notifyTTSEnd()
      {
        d.a(null);
        b.a(b.this).e();
      }
      
      public void notifyTTSInterrupt()
      {
        d.a(null);
        b.this.c();
      }
      
      public void notifyTTSStart() {}
    });
    if (d.a(paramString) < 0)
    {
      d.a(null);
      c();
    }
  }
  
  public void a(com.baidu.carlife.wechat.b.d paramd, String paramString)
  {
    this.a = paramd;
    d.a();
    d.a(new IBNTTSPlayerWeChatListener()
    {
      public void notifyTTSEnd()
      {
        d.a(null);
        b.a(b.this).b();
      }
      
      public void notifyTTSInterrupt()
      {
        d.a(null);
        b.this.c();
      }
      
      public void notifyTTSStart() {}
    });
    if (d.a(paramString) < 0)
    {
      d.a(null);
      c();
    }
  }
  
  public void b()
  {
    g();
  }
  
  public void b(com.baidu.carlife.wechat.b.d paramd, String paramString)
  {
    this.a = paramd;
    d.a();
    d.a(new IBNTTSPlayerWeChatListener()
    {
      public void notifyTTSEnd()
      {
        d.a(null);
        b.a(b.this).c();
      }
      
      public void notifyTTSInterrupt()
      {
        d.a(null);
        b.this.c();
      }
      
      public void notifyTTSStart() {}
    });
    if (d.a(paramString) < 0)
    {
      d.a(null);
      c();
    }
  }
  
  public void c()
  {
    c.c("");
    f();
    d.a();
    k.a().f();
  }
  
  public void c(com.baidu.carlife.wechat.b.d paramd, String paramString)
  {
    this.a = paramd;
    d.a();
    d.a(new IBNTTSPlayerWeChatListener()
    {
      public void notifyTTSEnd()
      {
        d.a(null);
        b.a(b.this).d();
      }
      
      public void notifyTTSInterrupt()
      {
        d.a(null);
        b.this.c();
      }
      
      public void notifyTTSStart() {}
    });
    if (d.a(paramString) < 0)
    {
      d.a(null);
      c();
    }
  }
  
  public void e()
  {
    this.c = new a();
    this.c.a(this);
    this.c.a();
  }
  
  public void f()
  {
    this.c.f();
  }
  
  public void g()
  {
    if (this.b != null)
    {
      a(this.b);
      return;
    }
    c();
  }
  
  private static class a
  {
    private static final b a = new b(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */