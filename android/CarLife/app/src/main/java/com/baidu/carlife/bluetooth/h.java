package com.baidu.carlife.bluetooth;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.q.g;

public class h
  extends l
{
  public static final int a = 3000;
  public static final int b = 400;
  public static final int c = 1500;
  private static final String e = h.class.getSimpleName();
  public Handler d = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      i.b(h.f(), "Dont see telephone changing event, just send background message");
      c.a(false);
      q.f().b(h.a(h.this));
    }
  };
  private boolean f = false;
  private boolean g = false;
  private q.g h = new q.g()
  {
    public void a()
    {
      i.b(h.f(), "on PhoneStateActive");
    }
    
    public void a(boolean paramAnonymousBoolean)
    {
      i.b(h.f(), "on PhoneStateIDLE");
    }
    
    public void b(boolean paramAnonymousBoolean)
    {
      i.b(h.f(), "on PhoneCallRinging");
      if (paramAnonymousBoolean)
      {
        i.b(h.f(), "Telephone event is ongoing, stop send background");
        h.this.d.removeMessages(4304);
        q.f().b(h.a(h.this));
        h.this.d.postDelayed(new Runnable()
        {
          public void run()
          {
            b.a().l();
            h.a(h.this, true);
          }
        }, 400L);
      }
    }
    
    public void c(boolean paramAnonymousBoolean)
    {
      i.b(h.f(), "on PhoneStateOffhook");
      if (paramAnonymousBoolean)
      {
        i.b(h.f(), "Telephone event is ongoing, stop send background");
        h.this.d.removeMessages(4304);
        q.f().b(h.a(h.this));
        h.this.d.postDelayed(new Runnable()
        {
          public void run()
          {
            b.a().l();
            h.a(h.this, true);
          }
        }, 400L);
      }
    }
    
    public void d(boolean paramAnonymousBoolean) {}
  };
  
  public void a()
  {
    i.b(e, "onStart: ");
  }
  
  public void a(Intent paramIntent) {}
  
  public void b()
  {
    i.b(e, "onStop: ");
    this.f = true;
    if (b.a().k())
    {
      b.a().a(false);
      this.g = false;
      if (q.f().c() != 0)
      {
        this.d.postDelayed(new Runnable()
        {
          public void run()
          {
            b.a().l();
            h.a(h.this, true);
          }
        }, 400L);
        i.b(e, "Telephone is ongoing, stop send background message");
        return;
      }
      i.b(e, "Delay 1s to see telephone changed");
      q.f().a(this.h);
      Message localMessage = new Message();
      localMessage.what = 4304;
      this.d.sendMessageDelayed(localMessage, 1500L);
      return;
    }
    c.a(false);
  }
  
  public void c()
  {
    i.b(e, "onPause: ");
  }
  
  public void d()
  {
    i.b(e, "onResume: ");
    if (this.g)
    {
      i.b(e, "Telephone cause switching and bring carlife to foreground, resume video after 2s");
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          a.a().g();
        }
      }, 3000L);
      this.g = false;
      return;
    }
    i.b(e, "Resume video at once");
    a.a().g();
    b.a().a(true);
  }
  
  public void e()
  {
    if (!this.f)
    {
      i.b(e, "onConfigurationChanged:exe onstop");
      b();
    }
    for (;;)
    {
      this.f = false;
      return;
      i.b(e, "onConfigurationChanged:do nothing");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */