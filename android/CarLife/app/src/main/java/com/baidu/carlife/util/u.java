package com.baidu.carlife.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.baidunavis.tts.IBNTTSPlayerPCMListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.voice.n;

public class u
{
  private static final int b = 110;
  private static final int c = 111;
  private static final int d = 2000;
  private static u e = null;
  IBNTTSPlayerPCMListener a = new IBNTTSPlayerPCMListener()
  {
    public void handlePCMStream(byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
    {
      if (u.a(u.this)) {
        u.b(u.this).c(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
      }
      while (!u.c(u.this)) {
        return;
      }
      u.b(u.this).b(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
    }
    
    public void notifyTTSEnd()
    {
      k.b(509);
      i.b("jason2", "===============notifyTTSEnd");
      if (u.a(u.this)) {
        u.d(u.this).sendEmptyMessageDelayed(110, 2000L);
      }
      while (!u.c(u.this)) {
        return;
      }
      u.f(u.this);
      u.d(u.this).sendEmptyMessageDelayed(111, 2000L);
    }
    
    public void notifyTTSStart()
    {
      k.b(508);
      i.b("jason2", "==============notifyTTSStart");
      if (com.baidu.carlife.m.a.a().f())
      {
        if (u.c(u.this))
        {
          u.a(u.this, false);
          u.d(u.this).removeMessages(111);
          if (u.b(u.this).C())
          {
            u.a(u.this, 0);
            u.b(u.this).B();
          }
        }
        if (u.a(u.this))
        {
          u.d(u.this).removeMessages(110);
          if (u.b(u.this).D()) {
            u.b(u.this).E();
          }
          u.b(u.this).c(16000, 1, 16);
        }
      }
      while (com.baidu.carlife.m.a.a().f()) {
        for (;;)
        {
          return;
          u.b(u.this, true);
        }
      }
      if (u.a(u.this))
      {
        u.b(u.this, false);
        u.d(u.this).removeMessages(110);
        if (u.b(u.this).D()) {
          u.b(u.this).E();
        }
      }
      if (u.c(u.this))
      {
        u.d(u.this).removeMessages(111);
        if (!u.b(u.this).C()) {
          u.b(u.this).b(16000, 1, 16);
        }
      }
      for (;;)
      {
        u.e(u.this);
        return;
        u.a(u.this, true);
        u.b(u.this).b(16000, 1, 16);
      }
    }
  };
  private com.baidu.carlife.l.a f = com.baidu.carlife.l.a.a();
  private boolean g = false;
  private boolean h = false;
  private Handler i;
  private HandlerThread j = new HandlerThread("TTSPCMUtil");
  private int k = 0;
  
  private u()
  {
    this.j.start();
    this.i = new a(this.j.getLooper());
  }
  
  public static u a()
  {
    if (e == null) {
      e = new u();
    }
    return e;
  }
  
  public IBNTTSPlayerPCMListener b()
  {
    return this.a;
  }
  
  public void c()
  {
    if ((this.g) && (this.f != null))
    {
      this.g = false;
      this.k = 0;
      this.f.B();
    }
  }
  
  public void d()
  {
    if ((this.h) && (this.f != null))
    {
      this.h = false;
      this.f.E();
    }
  }
  
  public void e()
  {
    if (this.f != null)
    {
      if (n.a().l()) {
        this.f.E();
      }
    }
    else {
      return;
    }
    this.f.B();
  }
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 110) {
        if (u.a(u.this))
        {
          u.b(u.this, false);
          u.b(u.this).E();
        }
      }
      while ((paramMessage.what != 111) || (!u.c(u.this)) || (u.g(u.this) > 0)) {
        return;
      }
      u.a(u.this, 0);
      u.a(u.this, false);
      u.b(u.this).B();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */