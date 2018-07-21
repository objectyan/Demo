package com.baidu.carlife.wechat.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.wechat.b.c;
import com.baidu.carlife.wechat.b.i;

public class a
{
  private static final int a = 4097;
  private static final int b = 4098;
  private static final int c = 4099;
  private static final int d = 4100;
  private static final long e = 12000L;
  private static final long f = 20000L;
  private a g;
  private b h = null;
  private Handler i = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      a.a(a.this, null);
      a.a(a.this).c();
    }
  };
  
  private void a(b paramb)
  {
    this.h = paramb;
    switch (6.a[this.h.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.i.sendEmptyMessageDelayed(4097, 12000L);
      return;
    case 2: 
      this.i.sendEmptyMessageDelayed(4098, 12000L);
      return;
    case 3: 
      this.i.sendEmptyMessageDelayed(4099, 12000L);
      return;
    }
    this.i.sendEmptyMessageDelayed(4100, 20000L);
  }
  
  private boolean g()
  {
    return !TextUtils.isEmpty(c.a().f().d());
  }
  
  private void h()
  {
    com.baidu.che.codriver.sdk.a.a.b local2 = new com.baidu.che.codriver.sdk.a.a.b()
    {
      public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
      {
        a.b(a.this).removeMessages(4097);
        if (!a.c(a.this)) {}
        while ((a.d(a.this) != a.b.a) || (!TextUtils.equals(paramAnonymousString1, "wechat_play"))) {
          return;
        }
        a.a(a.this, null);
        if (TextUtils.equals(paramAnonymousString2, "播报"))
        {
          a.a(a.this).a();
          return;
        }
        a.a(a.this).c();
      }
    };
    local2.addCommand("wechat_play", new String[] { "播报", "取消" });
    com.baidu.carlife.logic.codriver.adapter.b.a().a(local2);
  }
  
  private void i()
  {
    com.baidu.che.codriver.sdk.a.a.b local3 = new com.baidu.che.codriver.sdk.a.a.b()
    {
      public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
      {
        a.b(a.this).removeMessages(4098);
        if (!a.c(a.this)) {}
        while ((a.d(a.this) != a.b.b) || (!TextUtils.equals(paramAnonymousString1, "wechat_music"))) {
          return;
        }
        a.a(a.this, null);
        if ((TextUtils.equals(paramAnonymousString2, "播放")) || (TextUtils.equals(paramAnonymousString2, "播放音乐")))
        {
          a.a(a.this).a();
          return;
        }
        a.a(a.this).c();
      }
    };
    local3.addCommand("wechat_music", new String[] { "播放", "播放音乐", "取消" });
    com.baidu.carlife.logic.codriver.adapter.b.a().a(local3);
  }
  
  private void j()
  {
    com.baidu.che.codriver.sdk.a.a.b local4 = new com.baidu.che.codriver.sdk.a.a.b()
    {
      public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
      {
        a.b(a.this).removeMessages(4099);
        if (!a.c(a.this)) {}
        while ((a.d(a.this) != a.b.d) || (!TextUtils.equals(paramAnonymousString1, "wechat_navi"))) {
          return;
        }
        a.a(a.this, null);
        if (TextUtils.equals(paramAnonymousString2, "开始导航"))
        {
          a.a(a.this).a();
          return;
        }
        a.a(a.this).c();
      }
    };
    local4.addCommand("wechat_navi", new String[] { "开始导航", "取消" });
    com.baidu.carlife.logic.codriver.adapter.b.a().a(local4);
  }
  
  private void k()
  {
    com.baidu.che.codriver.sdk.a.a.b local5 = new com.baidu.che.codriver.sdk.a.a.b()
    {
      public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
      {
        a.b(a.this).removeMessages(4100);
        if (!a.c(a.this)) {}
        while ((a.d(a.this) != a.b.c) || (!TextUtils.equals(paramAnonymousString1, "wechat_reply"))) {
          return;
        }
        a.a(a.this, null);
        if (TextUtils.equals(paramAnonymousString2, "回复"))
        {
          a.a(a.this).b();
          return;
        }
        a.a(a.this).c();
      }
    };
    local5.addCommand("wechat_reply", new String[] { "回复", "取消" });
    com.baidu.carlife.logic.codriver.adapter.b.a().a(local5);
  }
  
  public void a()
  {
    h();
    i();
    j();
    k();
  }
  
  public void a(com.baidu.carlife.wechat.b.b paramb)
  {
    paramb = new com.baidu.che.codriver.sdk.b.a(paramb.a(), paramb.b());
    com.baidu.carlife.logic.codriver.adapter.b.a().a(paramb);
  }
  
  public void a(a parama)
  {
    this.g = parama;
  }
  
  public void b()
  {
    a(b.a);
  }
  
  public void c()
  {
    a(b.b);
  }
  
  public void d()
  {
    a(b.d);
  }
  
  public void e()
  {
    a(b.c);
  }
  
  public void f()
  {
    this.h = null;
    this.i.removeMessages(4097);
    this.i.removeMessages(4098);
    this.i.removeMessages(4099);
    this.i.removeMessages(4100);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */