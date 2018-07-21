package com.baidu.carlife.fragment;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.Time;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.adpter.h.a;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.logic.music.b.c;
import com.baidu.carlife.logic.music.j.a;
import com.baidu.carlife.logic.music.t;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.voice.m;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.a;
import com.baidu.carlife.view.MarqueeTextView;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.carlife.view.MusicCircleProgressView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayerFragment
  extends ContentFragment
{
  private static final int F = 10000;
  private MultiImageView A;
  private AnimationDrawable B;
  private com.baidu.carlife.view.dialog.a C;
  private long D = -1L;
  private long E = -1L;
  private Timer G;
  private TimerTask H;
  private b.c I = new b.c()
  {
    public void a()
    {
      MusicPlayerFragment.a(MusicPlayerFragment.this);
    }
    
    public void a(int paramAnonymousInt)
    {
      MusicPlayerFragment.a(MusicPlayerFragment.this, paramAnonymousInt);
    }
    
    public void a(String paramAnonymousString)
    {
      MusicPlayerFragment.a(MusicPlayerFragment.this, MusicPlayerFragment.this.u.p());
      MusicPlayerFragment.b(MusicPlayerFragment.this);
      MusicPlayerFragment.a(MusicPlayerFragment.this, MusicPlayerFragment.this.u.f(paramAnonymousString), MusicPlayerFragment.this.u.s());
      if (MusicPlayerFragment.this.w.b())
      {
        boolean bool = MusicPlayerFragment.this.u.i(paramAnonymousString);
        paramAnonymousString = MusicPlayerFragment.this.w;
        if (!bool) {
          break label97;
        }
      }
      label97:
      for (int i = 0;; i = 1)
      {
        paramAnonymousString.a(i);
        return;
      }
    }
    
    public void b()
    {
      MusicPlayerFragment.c(MusicPlayerFragment.this);
    }
    
    public void c()
    {
      MusicPlayerFragment.d(MusicPlayerFragment.this);
    }
    
    public void d()
    {
      MusicPlayerFragment.e(MusicPlayerFragment.this);
    }
    
    public void e()
    {
      MusicPlayerFragment.f(MusicPlayerFragment.this);
    }
  };
  private View.OnClickListener J = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (com.baidu.carlife.logic.k.a().c() != 0) {
        w.a(2131296842, 1);
      }
      do
      {
        return;
        switch (paramAnonymousView.getId())
        {
        default: 
          return;
        case 2131624258: 
          MusicPlayerFragment.k(MusicPlayerFragment.this);
          return;
        }
      } while (MusicPlayerFragment.this.s == null);
      if (com.baidu.carlife.custom.b.a().b())
      {
        boolean bool = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().isDriving();
        MusicPlayerFragment.a(MusicPlayerFragment.this, bool);
      }
      MusicPlayerFragment.this.showDialog(MusicPlayerFragment.this.s, BaseDialog.a.b);
      MusicPlayerFragment.this.s.a(MusicPlayerFragment.this.u.m());
      return;
      MusicPlayerFragment.g(MusicPlayerFragment.this);
      return;
      MusicPlayerFragment.this.v.m();
      MusicPlayerFragment.h(MusicPlayerFragment.this);
      return;
      m.a().b();
      if (MusicPlayerFragment.this.v.q()) {
        MusicPlayerFragment.i(MusicPlayerFragment.this);
      }
      MusicPlayerFragment.this.v.c(false);
      StatisticManager.onEvent("1063", "上一首");
      return;
      m.a().b();
      MusicPlayerFragment.i(MusicPlayerFragment.this);
      if ((MusicPlayerFragment.this.y != null) && (MusicPlayerFragment.this.y.k))
      {
        StatisticManager.onEvent("1063", "暂停");
        return;
      }
      StatisticManager.onEvent("1063", "播放");
      return;
      m.a().b();
      if (MusicPlayerFragment.this.v.q()) {
        MusicPlayerFragment.i(MusicPlayerFragment.this);
      }
      MusicPlayerFragment.this.v.c(true);
      StatisticManager.onEvent("1063", "下一首");
      return;
      MusicPlayerFragment.j(MusicPlayerFragment.this);
    }
  };
  private AdapterView.OnItemClickListener K = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if ((MusicPlayerFragment.this.w != null) && (MusicPlayerFragment.this.w.getItemViewType(paramAnonymousInt) == 1))
      {
        if (MusicPlayerFragment.this.w.a() != 2) {
          MusicPlayerFragment.this.w.c();
        }
        return;
      }
      if (com.baidu.carlife.logic.k.a().c() != 0)
      {
        w.a(2131296842, 1);
        return;
      }
      paramAnonymousAdapterView = (MusicSongModel)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
      paramAnonymousView = MusicPlayerFragment.this.v.h();
      if ((paramAnonymousView != null) && (paramAnonymousAdapterView.equals(paramAnonymousView))) {}
      for (;;)
      {
        MusicPlayerFragment.this.dismissDialog(MusicPlayerFragment.this.s);
        return;
        MusicPlayerFragment.this.u.f(paramAnonymousInt);
        if (MusicPlayerFragment.this.u.x() == 3) {
          MusicPlayerFragment.this.u.i(2);
        }
        com.baidu.carlife.core.k.a(307);
        MusicPlayerFragment.this.v.a(MusicPlayerFragment.this.u.s(), paramAnonymousAdapterView);
      }
    }
  };
  private com.baidu.carlife.core.j L = new com.baidu.carlife.core.j()
  {
    public void careAbout()
    {
      addMsg(307);
      addMsg(226);
      addMsg(225);
      addMsg(227);
      addMsg(218);
      addMsg(249);
      addMsg(310);
      addMsg(16875523);
      addMsg(407);
      addMsg(2004);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (MusicPlayerFragment.this.u == null) {
        sendMessageDelayed(Message.obtain(paramAnonymousMessage), 1000L);
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 218: 
      case 249: 
      case 310: 
      case 227: 
      case 226: 
      case 307: 
      case 225: 
      case 2004: 
      case 16875523: 
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
                        } while (paramAnonymousMessage.arg1 != MusicPlayerFragment.this.u.s());
                        MusicPlayerFragment.l(MusicPlayerFragment.this);
                        MusicPlayerFragment.this.t.setVisibility(0);
                        MusicPlayerFragment.this.u.a((Pair)paramAnonymousMessage.obj);
                        return;
                      } while (paramAnonymousMessage.arg1 != MusicPlayerFragment.this.u.s());
                      MusicPlayerFragment.l(MusicPlayerFragment.this);
                      MusicPlayerFragment.d(MusicPlayerFragment.this);
                      if ((paramAnonymousMessage.arg1 >= 3) && (paramAnonymousMessage.arg2 != -1)) {
                        w.a(MusicPlayerFragment.this.getString(2131296619), 1);
                      }
                      if (MusicPlayerFragment.this.x.isEmpty())
                      {
                        switch (paramAnonymousMessage.arg2)
                        {
                        default: 
                          MusicPlayerFragment.this.u.i(3);
                        }
                        for (;;)
                        {
                          MusicPlayerFragment.this.t.setVisibility(4);
                          return;
                          MusicPlayerFragment.this.u.i(6);
                          continue;
                          MusicPlayerFragment.this.u.i(4);
                          continue;
                          MusicPlayerFragment.this.u.i(5);
                        }
                      }
                      MusicPlayerFragment.this.w.a(1);
                      return;
                      MusicPlayerFragment.m(MusicPlayerFragment.this);
                      return;
                    } while (paramAnonymousMessage.arg1 != MusicPlayerFragment.this.u.s());
                    MusicPlayerFragment.this.v.a(MusicPlayerFragment.this.y);
                    MusicPlayerFragment.this.u.i(3);
                    return;
                  } while (paramAnonymousMessage.arg1 != MusicPlayerFragment.this.u.s());
                  removeMessages(307);
                  MusicPlayerFragment.this.u.i(2);
                  MusicPlayerFragment.a(MusicPlayerFragment.this, MusicPlayerFragment.this.v.h());
                  MusicPlayerFragment.b(MusicPlayerFragment.this);
                  return;
                } while ((MusicPlayerFragment.this.h == null) || (paramAnonymousMessage.arg2 != MusicPlayerFragment.this.u.s()) || ((paramAnonymousMessage.arg1 >= 3) && (paramAnonymousMessage.arg1 % 3 != 0)));
                MusicPlayerFragment.this.h.setProgress(paramAnonymousMessage.arg1);
                return;
              } while ((paramAnonymousMessage.arg1 != MusicPlayerFragment.this.u.s()) || (MusicPlayerFragment.this.k == null));
              if ((MusicPlayerFragment.this.y != null) && (MusicPlayerFragment.this.y.k))
              {
                MusicPlayerFragment.this.k.setImageDrawable(r.b(2130838970));
                return;
              }
              MusicPlayerFragment.this.k.setImageDrawable(r.b(2130838974));
              return;
              if (q.f().b())
              {
                MusicPlayerFragment.this.dismissDialog(MusicPlayerFragment.this.s);
                MusicPlayerFragment.this.dismissDialog(MusicPlayerFragment.n(MusicPlayerFragment.this));
              }
              if ((String)paramAnonymousMessage.obj != null) {
                break;
              }
              if (MusicPlayerFragment.this.s != null) {
                MusicPlayerFragment.this.s.setBtnVisibility(8);
              }
            } while (MusicPlayerFragment.n(MusicPlayerFragment.this) == null);
            MusicPlayerFragment.n(MusicPlayerFragment.this).setBtnVisibility(8);
            return;
            if (!com.baidu.carlife.custom.a.a().b()) {
              break;
            }
            if (MusicPlayerFragment.this.s != null) {
              MusicPlayerFragment.this.s.setBtnVisibility(0);
            }
          } while (MusicPlayerFragment.n(MusicPlayerFragment.this) == null);
          MusicPlayerFragment.n(MusicPlayerFragment.this).setBtnVisibility(8);
          return;
        } while (!com.baidu.carlife.custom.b.a().b());
        boolean bool = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().isDriving();
        MusicPlayerFragment.a(MusicPlayerFragment.this, bool);
        return;
      }
      MusicPlayerFragment.h(MusicPlayerFragment.this);
    }
  };
  private j.a M = new j.a()
  {
    public void a()
    {
      MusicPlayerFragment.this.dismissDialog(MusicPlayerFragment.n(MusicPlayerFragment.this));
    }
  };
  protected final String a = "CarLifeMusic";
  protected ImageButton b;
  protected MarqueeTextView c;
  protected MarqueeTextView d;
  protected MarqueeTextView e;
  protected View f;
  protected CommonTipView g;
  protected MusicCircleProgressView h;
  protected ImageButton i;
  protected ImageButton j;
  protected ImageButton k;
  protected ImageButton l;
  protected ImageButton m;
  protected RelativeLayout n;
  protected com.baidu.carlife.f.g o = null;
  protected com.baidu.carlife.f.g p = null;
  protected com.baidu.carlife.f.g q = null;
  protected RelativeLayout r;
  protected com.baidu.carlife.view.dialog.a s;
  protected ImageView t;
  protected com.baidu.carlife.logic.music.b u = null;
  protected com.baidu.carlife.logic.music.h v = null;
  protected com.baidu.carlife.adpter.j w;
  protected List<MusicSongModel> x;
  protected MusicSongModel y;
  protected int z = 0;
  
  private com.baidu.carlife.f.g A()
  {
    if (this.p == null)
    {
      this.p = new com.baidu.carlife.f.g(this.mContentView, 4);
      this.p.d(this.b).d(this.t).d(this.r).d(this.g.getFocusView());
      this.p.b(this.g.getFocusView());
    }
    for (;;)
    {
      return this.p;
      this.p.h();
    }
  }
  
  private com.baidu.carlife.f.g B()
  {
    if (this.q == null)
    {
      this.q = new com.baidu.carlife.f.g(this.mContentView, 4);
      this.q.d(this.b).d(this.r);
      this.q.b(this.b);
    }
    for (;;)
    {
      return this.q;
      this.q.h();
    }
  }
  
  private void a()
  {
    a(this.u.p());
    a(this.u.g(), this.u.s());
    if (this.y == null)
    {
      b();
      return;
    }
    if ((this.v.g(this.u.s())) && (this.y.j > 0))
    {
      d();
      this.v.d(true);
      this.v.H();
      return;
    }
    if ((this.u.s() == 0) && (this.v.g(-1)))
    {
      d();
      return;
    }
    this.v.f(true);
    this.v.a(this.u.s(), this.y);
  }
  
  private void a(int paramInt)
  {
    this.f.setVisibility(8);
    if (this.u.s() == 0)
    {
      this.b.setVisibility(4);
      this.i.setVisibility(4);
      this.g.a(2131296612, 2130838299);
      this.g.a();
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      onInitFocusAreas();
      return;
      if (this.u.s() == 1)
      {
        this.b.setVisibility(0);
        this.i.setVisibility(4);
        this.g.a(2131296598, 2131296600);
        this.g.a(true);
        break;
      }
      if (this.u.s() < 2) {
        break;
      }
      this.b.setVisibility(0);
      this.i.setVisibility(4);
      this.g.a(2131296598, 2131296600);
      this.g.a(true);
      break;
      this.n.setVisibility(0);
      this.g.setVisibility(8);
      continue;
      this.n.setVisibility(8);
      this.g.setVisibility(0);
      if (this.u.s() == 0)
      {
        this.f.setVisibility(0);
        continue;
        this.g.a(2131296630, 2131296600);
        this.g.a(false);
        this.n.setVisibility(8);
        this.g.setVisibility(0);
        if (this.u.s() == 0)
        {
          this.f.setVisibility(0);
          continue;
          this.v.a(this.u.q());
          this.g.a(2131296614, 2131296600);
          this.g.a(true);
          this.n.setVisibility(8);
          this.g.setVisibility(0);
          if (this.u.s() == 0)
          {
            this.f.setVisibility(0);
            continue;
            this.g.a(2131296633, 2131296600);
            this.g.a(true);
            this.n.setVisibility(8);
            this.g.setVisibility(0);
            if (this.u.s() == 0) {
              this.f.setVisibility(0);
            }
          }
        }
      }
    }
  }
  
  private void a(MusicSongModel paramMusicSongModel)
  {
    this.y = paramMusicSongModel;
  }
  
  private void a(String paramString)
  {
    long l1 = p.a().a("DAU" + paramString, 0L);
    if (l1 == 0L)
    {
      StatisticManager.onEvent("1067", paramString);
      p.a().b("DAU" + paramString, System.currentTimeMillis());
    }
    Time localTime1;
    Time localTime2;
    do
    {
      return;
      localTime1 = new Time();
      localTime1.set(l1);
      localTime2 = new Time();
      localTime2.setToNow();
    } while ((localTime2.year < localTime1.year) || ((localTime2.year <= localTime1.year) && (localTime2.yearDay <= localTime1.yearDay)));
    StatisticManager.onEvent("1067", paramString);
    p.a().b("DAU" + paramString, System.currentTimeMillis());
  }
  
  private void a(List<MusicSongModel> paramList, int paramInt)
  {
    this.x.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.x.addAll(paramList);
    }
    if (paramInt == 1) {
      this.w.b(false);
    }
    for (;;)
    {
      this.w.a(this.x);
      o();
      return;
      this.w.b(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.s != null) {
        this.s.setBtnVisibility(0);
      }
      if (this.C != null) {
        this.C.setBtnVisibility(0);
      }
    }
    do
    {
      return;
      if (this.s != null) {
        this.s.setBtnVisibility(8);
      }
    } while (this.C == null);
    this.C.setBtnVisibility(8);
  }
  
  private void b()
  {
    if (this.u.s() != 0)
    {
      if (!this.v.q()) {
        this.v.f(true);
      }
      v();
      this.u.f();
      return;
    }
    this.u.i(3);
  }
  
  private void b(int paramInt)
  {
    dismissDialog(this.C);
    com.baidu.carlife.model.j localj = this.v.m(paramInt);
    if (localj == null) {
      return;
    }
    if (localj.c >= 3)
    {
      this.A.setDefaultDrawable(r.b(2130838958));
      this.A.setImageUrl(localj.j);
    }
    for (;;)
    {
      a(localj.m);
      return;
      this.A.setDefaultDrawableResId(localj.b);
      this.A.setImageUrl(null);
    }
  }
  
  private void c()
  {
    if ((this.y == null) || (this.y.g == null)) {
      return;
    }
    com.baidu.carlife.g.a.a(Uri.parse(this.y.g), getContext());
  }
  
  private void d()
  {
    if ((this.y == null) || (this.c == null)) {
      return;
    }
    try
    {
      this.z = (Integer.parseInt(this.y.i) / 1000);
      this.h.setMax(this.z);
      this.h.setProgress(this.y.j);
      if (this.y.k)
      {
        this.k.setImageDrawable(r.b(2130838970));
        this.c.setText(this.y.b);
        this.e.setText(this.y.c);
        this.d.setText(this.y.f);
        e();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.z = 1;
        continue;
        this.k.setImageDrawable(r.b(2130838974));
      }
    }
  }
  
  private void e()
  {
    this.m.setBackground(r.b(2130838216));
    switch (this.v.k())
    {
    default: 
      this.m.setImageDrawable(r.b(2130838957));
      return;
    case 2: 
      this.m.setImageDrawable(r.b(2130838957));
      return;
    case 1: 
      this.m.setImageDrawable(r.b(2130838998));
      return;
    }
    this.m.setImageDrawable(r.b(2130838999));
  }
  
  private void f()
  {
    if (this.y == null) {}
    do
    {
      return;
      if (this.y.l)
      {
        w.a("正在缓冲", 0);
        return;
      }
      if (this.v.g(this.u.s()))
      {
        if (this.y.k)
        {
          this.v.f(true);
          return;
        }
        if (this.v.q()) {
          this.v.a(this.u.s(), this.y);
        }
        this.v.d(true);
        return;
      }
    } while (this.u.s() != 0);
    this.v.a(0, this.y);
  }
  
  private void g()
  {
    if (this.u != null)
    {
      this.u.h();
      l();
    }
  }
  
  private void h()
  {
    this.u.b(true);
  }
  
  private void i()
  {
    if (this.u != null) {
      this.u.u();
    }
  }
  
  private void j()
  {
    if (this.v.p())
    {
      this.t.setVisibility(0);
      this.t.setImageResource(2131034112);
      this.B = ((AnimationDrawable)this.t.getDrawable());
      this.B.start();
    }
    for (;;)
    {
      this.t.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MusicPlayerFragment.this.v.l(MusicPlayerFragment.this.v.f());
          ContentFragment localContentFragment;
          if (MusicPlayerFragment.this.v.n() >= 0)
          {
            paramAnonymousView = new Bundle();
            paramAnonymousView.putBoolean("music_playing_icon", true);
            localContentFragment = MusicPlayerFragment.this.getCurrentFragment();
            if (localContentFragment != null) {}
          }
          else
          {
            return;
          }
          if (localContentFragment.getType() == 737)
          {
            localContentFragment.getArguments().putBundle("show_bundle", paramAnonymousView);
            localContentFragment.onStart();
            return;
          }
          MusicPlayerFragment.this.showFragment(737, paramAnonymousView);
        }
      });
      return;
      this.t.setVisibility(0);
      this.t.setImageDrawable(r.b(2130838988));
      if (this.B != null) {
        this.B.stop();
      }
    }
  }
  
  private void k()
  {
    this.w.notifyDataSetChanged();
    dismissDialog(this.s);
  }
  
  private void l()
  {
    this.v.B();
  }
  
  private void m()
  {
    this.v.A();
  }
  
  private void n()
  {
    com.baidu.carlife.view.g.e().f();
  }
  
  private void o()
  {
    if ((this.u.g() == null) || (this.u.g().isEmpty()))
    {
      this.t.setVisibility(4);
      if ((this.u.s() == 0) && (this.v.n() > 0)) {
        j();
      }
    }
    do
    {
      return;
      this.t.setVisibility(0);
      this.t.setOnClickListener(this.J);
      this.t.setImageDrawable(r.b(2130838989));
    } while (this.B == null);
    this.B.stop();
  }
  
  private void p()
  {
    if (com.baidu.carlife.custom.b.a().b()) {
      a(com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().isDriving());
    }
    showDialog(this.C, BaseDialog.a.b);
  }
  
  private void q()
  {
    this.u = this.v.r();
    this.u.a(this.I);
    this.u.a(getArguments());
    s();
  }
  
  private void r()
  {
    this.c = ((MarqueeTextView)this.mContentView.findViewById(2131625665));
    this.e = ((MarqueeTextView)this.mContentView.findViewById(2131625667));
    this.d = ((MarqueeTextView)this.mContentView.findViewById(2131625666));
    this.j = ((ImageButton)this.mContentView.findViewById(2131625671));
    this.k = ((ImageButton)this.mContentView.findViewById(2131625672));
    this.l = ((ImageButton)this.mContentView.findViewById(2131625673));
    this.m = ((ImageButton)this.mContentView.findViewById(2131625668));
    this.i = ((ImageButton)this.mContentView.findViewById(2131625669));
    this.b = ((ImageButton)this.mContentView.findViewById(2131624258));
    this.h = ((MusicCircleProgressView)this.mContentView.findViewById(2131625099));
    this.A = ((MultiImageView)this.mContentView.findViewById(2131625676));
    this.t = ((ImageView)this.mContentView.findViewById(2131625674));
    this.g = ((CommonTipView)this.mContentView.findViewById(2131623981));
    this.g.setCommonTipCallBack(new CommonTipView.a()
    {
      public void a()
      {
        if (com.baidu.carlife.logic.k.a().c() != 0)
        {
          w.a(2131296842, 1);
          return;
        }
        MusicPlayerFragment.o(MusicPlayerFragment.this);
      }
    });
    this.n = ((RelativeLayout)this.mContentView.findViewById(2131625663));
    this.f = this.mContentView.findViewById(2131625662);
    this.r = ((RelativeLayout)this.mContentView.findViewById(2131625675));
    this.t.setOnClickListener(this.J);
    this.r.setOnClickListener(this.J);
    this.j.setOnClickListener(this.J);
    this.k.setOnClickListener(this.J);
    this.l.setOnClickListener(this.J);
    this.m.setOnClickListener(this.J);
    this.i.setOnClickListener(this.J);
    this.b.setOnClickListener(this.J);
    this.C = new com.baidu.carlife.view.dialog.a(mActivity, 2131296613, this.v.E(), this.v.F());
    this.C.j();
  }
  
  private void s()
  {
    int i1 = this.v.g();
    this.C.a(i1);
    b(i1);
    u();
    t();
    o();
  }
  
  private void t()
  {
    this.s = new com.baidu.carlife.view.dialog.a(mActivity, 2131296624, this.w, this.K);
    this.s.j();
    this.s.setTitle(this.u.o());
    int i1 = this.u.s();
    String str = this.u.n();
    if ((i1 == 1) || (i1 >= 3) || ((str != null) && (str.equalsIgnoreCase("TEMPLIST_ID"))))
    {
      this.w.a(true);
      y();
      return;
    }
    this.w.a(false);
  }
  
  private void u()
  {
    ((com.baidu.carlife.logic.music.j)this.v.F()).a(this.M);
  }
  
  private void v()
  {
    if (this.h != null) {
      this.h.post(new Runnable()
      {
        public void run()
        {
          MusicPlayerFragment.this.k.setImageDrawable(r.b(2130838974));
          MusicPlayerFragment.this.h.setProgress(0);
        }
      });
    }
  }
  
  private void w()
  {
    i.b("CarLifeMusic", "startTimerForLoadmore");
    if (this.u.s() == 2) {}
    for (final boolean bool = true;; bool = false)
    {
      x();
      final Handler localHandler = new Handler();
      try
      {
        this.G = new Timer();
        this.H = new TimerTask()
        {
          public void run()
          {
            if (MusicPlayerFragment.p(MusicPlayerFragment.this) != null)
            {
              MusicPlayerFragment.l(MusicPlayerFragment.this);
              localHandler.post(new Runnable()
              {
                public void run()
                {
                  if (MusicPlayerFragment.10.this.b) {
                    StatisticManager.onEvent("MUSIC_NETEASE_0005", "在线搜索歌单获取更多超时");
                  }
                  MusicPlayerFragment.this.w.a(1);
                  w.a(2131296604, 1);
                }
              });
            }
          }
        };
        this.G.schedule(this.H, 10000L);
        return;
      }
      catch (Exception localException)
      {
        i.b("CarLifeMusic", "startTimer get exception");
        localException.printStackTrace();
      }
    }
  }
  
  private void x()
  {
    if (this.G != null) {}
    try
    {
      this.G.cancel();
      this.G = null;
      i.b("CarLifeMusic", "stop timer");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void y()
  {
    this.w.a(new h.a()
    {
      public void a()
      {
        if (e.a().r())
        {
          int i;
          if (MusicPlayerFragment.this.u.n().equalsIgnoreCase("TEMPLIST_ID"))
          {
            i = MusicPlayerFragment.this.u.k();
            if (MusicPlayerFragment.this.w != null)
            {
              if (i != 0) {
                break label96;
              }
              MusicPlayerFragment.this.w.a(2);
            }
          }
          for (;;)
          {
            MusicPlayerFragment.q(MusicPlayerFragment.this);
            return;
            i = MusicPlayerFragment.this.u.a(1, MusicPlayerFragment.this.u.n());
            break;
            label96:
            if (i == 1) {
              MusicPlayerFragment.this.w.a(0);
            }
          }
        }
        w.a(MusicPlayerFragment.this.getContext().getString(2131296368), 0);
      }
    });
    if (this.u.i(this.u.n()))
    {
      this.w.a(0);
      return;
    }
    this.w.a(1);
  }
  
  private com.baidu.carlife.f.g z()
  {
    if (this.o == null)
    {
      this.o = new com.baidu.carlife.f.g(this.mContentView, 4);
      this.o.d(this.b).d(this.t).d(this.r).d(this.m).d(this.j).d(this.k).d(this.l);
      this.o.b(this.k);
    }
    for (;;)
    {
      return this.o;
      this.o.h();
    }
  }
  
  public void driving()
  {
    if (com.baidu.carlife.custom.b.a().b()) {
      a(true);
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.u != null) && (this.u.s() == 0)) {
      if (mActivity != null) {
        mActivity.d();
      }
    }
    for (;;)
    {
      return true;
      i();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.v = com.baidu.carlife.logic.music.h.b();
    this.w = new com.baidu.carlife.adpter.j(getContext());
    this.x = new ArrayList();
    com.baidu.carlife.core.k.a(this.L);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968784, null);
    r();
    u();
    return this.mContentView;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.D = SystemClock.elapsedRealtime();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    dismissDialog();
    n();
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    this.L.removeMessages(307);
    com.baidu.carlife.core.k.b(this.L);
    this.L = null;
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    i.b("CarLifeMusic");
    if (paramBoolean) {
      n();
    }
    while ((this.y == null) || (!this.y.l)) {
      return;
    }
    l();
  }
  
  public void onInitFocusAreas()
  {
    if ((this.v == null) || (!this.isDisplayed) || (this.u == null) || (getCurrentFragmentType() != 737)) {}
    while (isDialogShown()) {
      return;
    }
    d locald = d.a();
    locald.g();
    switch (this.u.x())
    {
    default: 
      i.b("CarLifeMusic", "onInitFocusAreas default");
      return;
    case 2: 
      i.b("CarLifeMusic", "onInitFocusAreas normal");
      locald.b(new com.baidu.carlife.f.a[] { z() });
      locald.h(z());
      return;
    case 4: 
      i.b("CarLifeMusic", "onInitFocusAreas notbuttonfail");
      locald.b(new com.baidu.carlife.f.a[] { B() });
      locald.h(B());
      return;
    }
    i.b("CarLifeMusic", "onInitFocusAreas nullfail");
    locald.b(new com.baidu.carlife.f.a[] { A() });
    locald.h(A());
  }
  
  @Deprecated
  protected void onInitView() {}
  
  public void onResume()
  {
    if ((this.y != null) && (this.y.l)) {
      l();
    }
    com.baidu.carlife.core.k.b(4023);
    super.onResume();
    onInitFocusAreas();
    i.b("CarLifeMusic");
    this.E = SystemClock.elapsedRealtime();
    i.b("CarLifeMusic", "--QA_Test---time:" + (this.E - this.D) + "ms");
  }
  
  public void onStart()
  {
    q();
    super.onStart();
    i.b("CarLifeMusic", "------onStart()------");
  }
  
  @Deprecated
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
    this.c.setTextColor(r.a(2131558699));
    this.e.setTextColor(r.a(2131558692));
    this.d.setTextColor(r.a(2131558692));
    this.i.setImageDrawable(r.b(2130838959));
    this.j.setImageDrawable(r.b(2130838960));
    this.l.setImageDrawable(r.b(2130838967));
    this.b.setImageDrawable(r.b(2130838256));
    this.i.setBackground(r.b(2130838216));
    this.j.setBackground(r.b(2130838216));
    this.l.setBackground(r.b(2130838216));
    this.b.setBackground(com.baidu.carlife.view.a.b.a(getContext()));
    this.r.setBackground(r.b(2130838216));
    if ((this.y != null) && (this.y.k)) {
      this.k.setImageDrawable(r.b(2130838970));
    }
    for (;;)
    {
      this.k.setBackground(r.b(2130838227));
      e();
      this.r.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
      this.t.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
      return;
      this.k.setImageDrawable(r.b(2130838974));
    }
  }
  
  @Deprecated
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    i.b("CarLifeMusic", "Voice Command: " + paramString1 + " # " + paramString2);
    if (t.a().a(paramString2) != -1)
    {
      this.v.F().onItemClick(null, null, t.a().a(paramString2), 0L);
      return true;
    }
    return false;
  }
  
  public void stopDriving()
  {
    if (com.baidu.carlife.custom.b.a().b()) {
      a(false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/MusicPlayerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */