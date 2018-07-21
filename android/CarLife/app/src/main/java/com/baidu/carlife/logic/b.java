package com.baidu.carlife.logic;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.voice.n;
import com.baidu.navisdk.util.common.AudioUtils;

public class b
{
  private static final String a = "CarLifeMusic";
  private static b e;
  private static final Object f = new Object();
  private HandlerThread b;
  private j c;
  private Context d;
  private b g;
  
  public static b a()
  {
    if (e == null) {}
    synchronized (f)
    {
      if (e == null) {
        e = new b();
      }
      return e;
    }
  }
  
  public void a(Context paramContext, b paramb)
  {
    this.d = paramContext;
    this.g = paramb;
    this.b = new HandlerThread("AudioFocusManager");
    this.b.start();
    this.c = new a(this.b.getLooper());
    k.a(this.c);
  }
  
  private class a
    extends j
  {
    private int b = 0;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(270);
      addMsg(2004);
      addMsg(2009);
      addMsg(2002);
      addMsg(1002);
      addMsg(1004);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
      case 2009: 
      case 2004: 
      case 2002: 
      case 270: 
        do
        {
          do
          {
            return;
            i.b("CarLifeMusic", "---MSG_TELE_STATE_CHANGE_IDLE-----");
            AudioUtils.resumeTTS(b.a(b.this));
            b.b(b.this).a(false);
            return;
            i.b("CarLifeMusic", "---MSG_TELE_STATE_CHANGE_RINGING-----");
            b.b(b.this).b(false);
            AudioUtils.pauseTTS(b.a(b.this));
            AudioUtils.pauseTTS(b.a(b.this));
            return;
            i.b("CarLifeMusic", "---MSG_TELE_STATE_CHANGE_OFFHOOK-----");
            b.b(b.this).b(false);
            AudioUtils.pauseTTS(b.a(b.this));
            AudioUtils.pauseTTS(b.a(b.this));
            return;
            switch (paramMessage.arg1)
            {
            case 0: 
            default: 
              return;
            case -3: 
              i.b("CarLifeMusic", "---AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK-----");
            }
          } while ((g.a().f()) && (!a.a().J()));
          b.b(b.this).b();
          return;
          i.b("CarLifeMusic", "---AUDIOFOCUS_LOSS-----");
          b.b(b.this).b(false);
          return;
          i.b("CarLifeMusic", "---AUDIOFOCUS_LOSS_TRANSIENT-----");
          b.b(b.this).b(false);
          return;
          i.b("CarLifeMusic", "---AUDIOFOCUS_GAIN-----retry:" + this.b);
          if (n.a().l())
          {
            int i = this.b;
            this.b = (i + 1);
            if (i < 10)
            {
              sendMessageDelayed(Message.obtain(paramMessage), 100L);
              return;
            }
            this.b = 0;
            return;
          }
          b.b(b.this).a(false);
        } while ((g.a().f()) && (!a.a().J()));
        b.b(b.this).a();
        return;
      }
      b.b(b.this).b(true);
      b.b(b.this).a();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void b(boolean paramBoolean);
    
    public abstract void c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */