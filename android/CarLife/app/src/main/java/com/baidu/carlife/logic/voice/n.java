package com.baidu.carlife.logic.voice;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.carlife.adpter.q.b;
import com.baidu.carlife.adpter.s.a;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.model.q;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.h.d;
import com.baidu.che.codriver.util.l;
import com.baidu.che.codriver.vr.o;
import com.baidu.che.codriver.vr.o.a;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.a;
import com.baidu.navi.cruise.control.ICruiseEnterQuiteLogic;
import com.baidu.navi.util.StatisticManager;
import java.util.List;

public class n
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 4;
  private static final int e = 4097;
  private static final String g = "CarLifeVoice-VrManager";
  private static final Object h = new Object();
  private static n i;
  private int f = 4;
  private Context j;
  private com.baidu.carlife.view.h k = new com.baidu.carlife.view.h();
  private q.b l;
  private List<MusicSongModel> m;
  private q n;
  private boolean o;
  private boolean p = false;
  private boolean q = false;
  private ICruiseEnterQuiteLogic r;
  private o s = o.a();
  private boolean t = false;
  private a u;
  private j v = new j()
  {
    public void careAbout()
    {
      addMsg(4160);
      addMsg(2004);
      addMsg(2002);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 2002: 
      case 2004: 
      case 4160: 
        n.this.i();
        return;
      case 1002: 
        n.a(n.this);
        return;
      case 1004: 
        n.b(n.this);
        return;
      }
      i.b("CarLifeVoice-VrManager", "############## delay enter scene and wakeup");
      n.this.g();
    }
  };
  private c w = new c()
  {
    public void a()
    {
      n.g(n.this);
      n.a(n.this, 4);
      n.this.a(4100);
      n.b(n.this, false);
    }
    
    public void a(int paramAnonymousInt)
    {
      i.b("CarLifeVoice-VrManager", "---errorCode:" + paramAnonymousInt);
      switch (paramAnonymousInt)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          StatisticManager.onEvent("VOICE_0003");
                        } while (com.baidu.carlife.l.a.a().N());
                        StatisticManager.onEvent("VOICE_PHONE_0002");
                        return;
                        StatisticManager.onEvent("VOICE_0004", "网络错误");
                      } while (com.baidu.carlife.l.a.a().N());
                      StatisticManager.onEvent("VOICE_PHONE_0003", "网络错误");
                      return;
                      StatisticManager.onEvent("VOICE_0004", "麦克风错误");
                    } while (com.baidu.carlife.l.a.a().N());
                    StatisticManager.onEvent("VOICE_PHONE_0003", "麦克风错误");
                    return;
                    StatisticManager.onEvent("VOICE_0004", "服务端错误");
                  } while (com.baidu.carlife.l.a.a().N());
                  StatisticManager.onEvent("VOICE_PHONE_0003", "服务端错误");
                  return;
                  StatisticManager.onEvent("VOICE_0004", "客户端错误");
                } while (com.baidu.carlife.l.a.a().N());
                StatisticManager.onEvent("VOICE_PHONE_0003", "客户端错误");
                return;
                StatisticManager.onEvent("VOICE_0004", "超时错误");
              } while (com.baidu.carlife.l.a.a().N());
              StatisticManager.onEvent("VOICE_PHONE_0003", "超时错误");
              return;
              StatisticManager.onEvent("VOICE_0004", "无匹配错误");
            } while (com.baidu.carlife.l.a.a().N());
            StatisticManager.onEvent("VOICE_PHONE_0003", "无匹配错误");
            return;
            StatisticManager.onEvent("VOICE_0004", "引擎忙错误");
          } while (com.baidu.carlife.l.a.a().N());
          StatisticManager.onEvent("VOICE_PHONE_0003", "引擎忙错误");
          return;
          StatisticManager.onEvent("VOICE_0004", "无权限错误");
        } while (com.baidu.carlife.l.a.a().N());
        StatisticManager.onEvent("VOICE_PHONE_0003", "无权限错误");
        return;
        StatisticManager.onEvent("VOICE_0004", "定位错误");
      } while (com.baidu.carlife.l.a.a().N());
      StatisticManager.onEvent("VOICE_PHONE_0003", "定位错误");
    }
    
    public void a(String paramAnonymousString)
    {
      n.b(n.this, true);
      i.b("CarLifeVoice-VrManager", "--onWakeUp---word:" + paramAnonymousString);
      if (n.this.m()) {
        com.baidu.che.codriver.ui.b.b.b().m();
      }
      n.this.a(4103);
      n.a(n.this, 0);
      com.baidu.carlife.o.b.a();
      com.baidu.carlife.o.b.a(1);
      StatisticManager.onEvent("VOICE_0020");
    }
    
    public boolean b()
    {
      if ((com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType() == 17) && (n.h(n.this) != null)) {
        n.h(n.this).quitCruise();
      }
      if (com.baidu.carlife.logic.k.a().c() != 0)
      {
        w.a(2131296843, 1);
        return false;
      }
      com.baidu.carlife.view.a.a().d();
      if (com.baidu.carlife.logic.k.a().d() == 2)
      {
        w.a("当前车机不支持语音功能！", 0);
        return false;
      }
      if (!n.i(n.this)) {
        com.baidu.carlife.core.k.b(4140);
      }
      com.baidu.carlife.logic.k.a().a(4, 1);
      com.baidu.carlife.logic.k.a().a(1);
      com.baidu.carlife.m.a.a().e();
      com.baidu.carlife.m.a.a().b(true);
      return true;
    }
    
    public void c()
    {
      n.this.g();
    }
    
    public void d()
    {
      com.baidu.carlife.wechat.f.b.d().c();
    }
    
    public void e()
    {
      StatisticManager.onEvent("VOICE_0002");
      if (!com.baidu.carlife.l.a.a().N()) {
        StatisticManager.onEvent("VOICE_PHONE_0001");
      }
    }
    
    public void f()
    {
      if ((n.j(n.this) == 1) && (n.i(n.this))) {
        i.b("CarLifeVoice-VrManager", "Vr State is already LISTENING");
      }
      do
      {
        return;
        n.k(n.this);
        n.this.a(4101);
      } while (!n.i(n.this));
      n.a(n.this, 1);
    }
    
    public void g()
    {
      n.this.a(4159);
      if (n.i(n.this)) {
        n.a(n.this, 2);
      }
    }
    
    public void h()
    {
      n.this.a(4100);
      n.a(n.this, 4);
    }
  };
  
  private void A()
  {
    i.b("CarLifeVoice-VrManager", "----MSG_CMD_MIC_RECORD_END----");
    com.baidu.carlife.l.a.a().c(65571);
    this.t = false;
  }
  
  public static n a()
  {
    if (i == null) {}
    synchronized (h)
    {
      if (i == null) {
        i = new n();
      }
      return i;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramString1 = paramString1 + "的" + paramString2;
    }
    do
    {
      return paramString1;
      if (!TextUtils.isEmpty(paramString1)) {
        return paramString1 + "的歌";
      }
      paramString1 = paramString2;
    } while (!TextUtils.isEmpty(paramString2));
    return null;
  }
  
  private void s()
  {
    if ((!this.p) && (!l())) {}
    do
    {
      return;
      i.b("#######", "####### prepareCloseVr !");
      if (!v()) {
        A();
      }
      com.baidu.carlife.m.a.a().b(false);
      com.baidu.carlife.logic.k.a().a(4, 0);
      com.baidu.carlife.logic.k.a().a(0);
    } while ((com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType() != 17) || (this.r == null));
    this.r.enterCruise();
  }
  
  private void t()
  {
    com.baidu.che.codriver.ui.b.b.b().a();
  }
  
  private void u()
  {
    this.o = true;
    if (!v()) {
      return;
    }
    w.a("唤醒关闭了！", 0);
    a(false);
    e.a().a(false);
    h();
    o();
  }
  
  private boolean v()
  {
    return e.a().o();
  }
  
  private void w()
  {
    this.v.removeMessages(4097);
    this.s.a(RecordHelper.a.a, null);
    this.o = false;
    this.t = false;
    switch (6.a[this.u.ordinal()])
    {
    default: 
      return;
    case 1: 
      i.b("CarLifeVoice-VrManager", "onUsbDisConnected  STATE_FOREGROUND");
      if (l())
      {
        i();
        com.baidu.che.codriver.ui.b.b.b().m();
        return;
      }
      g();
      return;
    }
    i.b("CarLifeVoice-VrManager", "onUsbDisConnected  STATE_BACKGROUND");
    if (l())
    {
      this.u = a.c;
      i();
      return;
    }
    h();
  }
  
  private void x()
  {
    if (!this.q) {
      this.v.postDelayed(new Runnable()
      {
        public void run()
        {
          n.b(n.this);
        }
      }, 1000L);
    }
    do
    {
      return;
      this.t = false;
      if (!d()) {
        t();
      }
      int i1 = com.baidu.carlife.logic.k.a().d();
      i.b("CarLifeVoice-VrManager", "-----onUsbConnectedImpl----micStatus:" + i1);
      if (i1 == 2)
      {
        w.a("当前车机不支持语音功能！", 0);
        if (l())
        {
          t();
          return;
        }
        h();
        return;
      }
      if ((!com.baidu.carlife.l.a.a().N()) || (i1 == 1)) {
        this.s.a(RecordHelper.a.a, null);
      }
      while (l())
      {
        t();
        return;
        if (i1 == 0)
        {
          this.s.a(RecordHelper.a.e, new com.baidu.carlife.logic.codriver.adapter.c());
          i.b("CarLifeVoice-VrManager", "AecVehicle OUTSIDE_RAW_PCM");
        }
        else if (i1 == 3)
        {
          this.s.a(RecordHelper.a.f, new com.baidu.carlife.logic.codriver.adapter.a(true));
          i.b("CarLifeVoice-VrManager", "AecVehicle OUTSIDE_AEC_MIC_LEFT_PCM");
        }
        else if (i1 == 4)
        {
          this.s.a(RecordHelper.a.g, new com.baidu.carlife.logic.codriver.adapter.a(false));
          i.b("CarLifeVoice-VrManager", "AecVehicle OUTSIDE_AEC_MIC_RIGHT_PCM");
        }
      }
    } while (!v());
    g();
  }
  
  private void y()
  {
    i.b("CarLifeVoice-VrManager", "----MSG_CMD_MIC_RECORD_WAKEUP_START----");
    com.baidu.carlife.l.a.a().c(65570);
  }
  
  private void z()
  {
    i.b("CarLifeVoice-VrManager", "----MSG_CMD_MIC_RECORD_RECOG_START----");
    com.baidu.carlife.l.a.a().c(65572);
    this.t = true;
  }
  
  public void a(int paramInt)
  {
    com.baidu.carlife.core.k.a(paramInt);
    com.baidu.carlife.core.k.b(paramInt);
  }
  
  public void a(Activity paramActivity)
  {
    this.j = paramActivity.getApplicationContext();
    com.baidu.carlife.core.k.a(this.v);
    com.baidu.che.codriver.util.c.a(this.j, "3", "cl", f.jx.a(), CommonParam.getCUID(this.j));
    boolean bool = v();
    l.b(this.j, "wake_up", bool);
    com.baidu.che.codriver.sdk.a.a.a().a(this.j, new o.a()
    {
      public void a()
      {
        d.a().a(n.c(n.this));
        if (n.d(n.this)) {
          n.e(n.this).o();
        }
        com.baidu.che.codriver.ui.b.b.b().a(n.f(n.this));
        com.baidu.carlife.logic.codriver.adapter.b.a().a(n.c(n.this));
        i.b("codrivervoice", "----onInitSuccess-----");
        n.a(n.this, true);
      }
    });
  }
  
  public void a(q.b paramb)
  {
    if (this.k == null) {
      return;
    }
    this.l = paramb;
  }
  
  public void a(ICruiseEnterQuiteLogic paramICruiseEnterQuiteLogic)
  {
    this.r = paramICruiseEnterQuiteLogic;
  }
  
  public void a(List paramList, int paramInt)
  {
    this.m = paramList;
    if (paramInt == 0) {}
    for (s.a locala = s.a.a;; locala = s.a.b)
    {
      a(paramList, locala);
      return;
    }
  }
  
  public void a(List paramList, s.a parama)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (parama == s.a.c)
      {
        this.v.sendMessage(Message.obtain(this.v, 4151, this.n.c()));
        return;
      }
      this.v.sendMessage(Message.obtain(this.v, 4161, a(this.n.b(), this.n.a())));
      return;
    }
    this.k.a(paramList, parama);
  }
  
  public void a(final boolean paramBoolean)
  {
    this.s.d(paramBoolean);
    this.v.post(new Runnable()
    {
      public void run()
      {
        l.b(n.c(n.this), "wake_up", paramBoolean);
      }
    });
  }
  
  public void b(boolean paramBoolean)
  {
    com.baidu.che.codriver.ui.b.b.b().a(paramBoolean);
  }
  
  public boolean b()
  {
    return this.f == 2;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      u();
    }
  }
  
  public boolean c()
  {
    return this.f == 1;
  }
  
  public void d(boolean paramBoolean)
  {
    com.baidu.che.codriver.ui.b.b.b().b(paramBoolean);
  }
  
  public boolean d()
  {
    return this.f == 4;
  }
  
  public void e()
  {
    i.b("CarLifeVoice-VrManager", "Vr State is: " + this.f);
  }
  
  public void f()
  {
    com.baidu.che.codriver.ui.b.b.b().t();
  }
  
  public void g()
  {
    if ((n()) || (!v()) || (this.u == a.c))
    {
      i.e("CarLifeVoice-VrManager", "-can not-startWakeUp--");
      return;
    }
    if (com.baidu.carlife.logic.k.a().d() == 2)
    {
      w.a(2131297227, 0);
      h();
      return;
    }
    y();
    this.s.o();
  }
  
  public void h()
  {
    A();
    this.s.k();
  }
  
  public void i()
  {
    t();
  }
  
  public void j()
  {
    t();
    com.baidu.che.codriver.ui.b.b.b().m();
  }
  
  public void k()
  {
    com.baidu.che.codriver.ui.b.b.b().c();
  }
  
  public boolean l()
  {
    return com.baidu.che.codriver.ui.b.b.b().q();
  }
  
  public boolean m()
  {
    return com.baidu.che.codriver.ui.b.b.b().r();
  }
  
  public boolean n()
  {
    return this.o;
  }
  
  public void o()
  {
    if (this.l != null) {
      this.l.a();
    }
  }
  
  public void p()
  {
    if ((com.baidu.carlife.core.b.a.a()) && (com.baidu.carlife.l.a.a().N()))
    {
      i.b("CarLifeVoice-VrManager", " onActivityPause internal screen capture ");
      this.u = a.b;
    }
    do
    {
      return;
      this.u = a.c;
      if (l())
      {
        i.b("CarLifeVoice-VrManager", " onActivityPause fullscreen capture, Invoke's vr.closeVr");
        t();
      }
    } while (!v());
    i.b("CarLifeVoice-VrManager", " onActivityPause fullscreen capture, Invoke's vr.closeWakeup() ");
    h();
  }
  
  public void q()
  {
    this.u = a.a;
    if (this.q)
    {
      i.b("CarLifeVoice-VrManager", " onActivityResume fullscreen capture, Invoke's vr.startWakeUp() ");
      g();
    }
  }
  
  public void r()
  {
    this.v.removeMessages(1004);
    this.v.sendEmptyMessageDelayed(1004, 1000L);
  }
  
  private static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */