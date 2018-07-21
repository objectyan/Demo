package com.baidu.carlife.radio.player;

import android.os.Bundle;
import android.os.Message;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.logic.music.b.c;
import com.baidu.carlife.logic.music.c;
import com.baidu.carlife.logic.music.p;
import com.baidu.carlife.logic.voice.m;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.a;
import com.baidu.carlife.view.HomeCardMusicMelodyView;
import com.baidu.carlife.view.RadioPlayerCircleProgressView;
import com.baidu.carlife.view.a.b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Random;

public class RadioPlayerFragment
  extends ContentFragment
{
  private static final String a = "CarLifeRadio";
  private ImageButton b;
  private CommonTipView c;
  private RadioPlayerCircleProgressView d;
  private ImageButton e;
  private ImageButton f;
  private ImageButton g;
  private ImageButton h;
  private ImageButton i;
  private TextView j;
  private TextView k;
  private LinearLayout l;
  private SimpleDraweeView m;
  private HomeCardMusicMelodyView n;
  private com.baidu.carlife.logic.music.h o = null;
  private MusicSongModel p;
  private int q = 0;
  private boolean r = false;
  private b.c s = new b.c()
  {
    public void a()
    {
      RadioPlayerFragment.a(RadioPlayerFragment.this);
    }
    
    public void a(int paramAnonymousInt)
    {
      RadioPlayerFragment.a(RadioPlayerFragment.this, paramAnonymousInt);
    }
    
    public void a(String paramAnonymousString)
    {
      c();
      RadioPlayerFragment.a(RadioPlayerFragment.this, com.baidu.carlife.logic.a.j.a().c().p());
      if (RadioPlayerFragment.b(RadioPlayerFragment.this)) {
        RadioPlayerFragment.d(RadioPlayerFragment.this).e(RadioPlayerFragment.c(RadioPlayerFragment.this));
      }
      RadioPlayerFragment.e(RadioPlayerFragment.this);
    }
    
    public void b()
    {
      RadioPlayerFragment.f(RadioPlayerFragment.this);
    }
    
    public void c()
    {
      RadioPlayerFragment.g(RadioPlayerFragment.this);
    }
    
    public void d() {}
    
    public void e()
    {
      RadioPlayerFragment.h(RadioPlayerFragment.this);
    }
  };
  private View.OnClickListener t = new com.baidu.carlife.logic.a.a()
  {
    protected void a(View paramAnonymousView)
    {
      if (com.baidu.carlife.logic.k.a().c() != 0)
      {
        w.a(2131296842, 1);
        return;
      }
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131624258: 
        RadioPlayerFragment.k(RadioPlayerFragment.this);
        return;
      case 2131625096: 
        m.a().b();
        StatisticManager.onEvent("CONTENT_CONTROl_0001");
        if (!RadioPlayerFragment.d(RadioPlayerFragment.this).q()) {
          RadioPlayerFragment.i(RadioPlayerFragment.this);
        }
        RadioPlayerFragment.d(RadioPlayerFragment.this).a(false, true);
        return;
      case 2131625098: 
        m.a().b();
        if (RadioPlayerFragment.j(RadioPlayerFragment.this))
        {
          RadioPlayerFragment.d(RadioPlayerFragment.this).y();
          return;
        }
        RadioPlayerFragment.i(RadioPlayerFragment.this);
        return;
      case 2131625100: 
        m.a().b();
        StatisticManager.onEvent("CONTENT_CONTROl_0002");
        if (!RadioPlayerFragment.d(RadioPlayerFragment.this).q()) {
          RadioPlayerFragment.i(RadioPlayerFragment.this);
        }
        RadioPlayerFragment.d(RadioPlayerFragment.this).a(true, true);
        return;
      case 2131625095: 
        if (!RadioPlayerFragment.d(RadioPlayerFragment.this).I())
        {
          RadioPlayerFragment.d(RadioPlayerFragment.this).y();
          return;
        }
        RadioPlayerFragment.l(RadioPlayerFragment.this);
        return;
      }
      if (!RadioPlayerFragment.d(RadioPlayerFragment.this).I())
      {
        RadioPlayerFragment.d(RadioPlayerFragment.this).y();
        return;
      }
      RadioPlayerFragment.m(RadioPlayerFragment.this);
    }
  };
  private com.baidu.carlife.core.j u = new com.baidu.carlife.core.j()
  {
    public void careAbout()
    {
      addMsg(307);
      addMsg(226);
      addMsg(225);
      addMsg(227);
      addMsg(218);
      addMsg(249);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (com.baidu.carlife.logic.a.j.a().c() == null) {
        sendMessageDelayed(Message.obtain(paramAnonymousMessage), 1000L);
      }
      switch (paramAnonymousMessage.what)
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
                    return;
                  } while (paramAnonymousMessage.arg1 != com.baidu.carlife.logic.a.j.a().c().s());
                  com.baidu.carlife.logic.a.j.a().c().a((Pair)paramAnonymousMessage.obj);
                  return;
                } while (paramAnonymousMessage.arg1 != com.baidu.carlife.logic.a.j.a().c().s());
                RadioPlayerFragment.g(RadioPlayerFragment.this);
              } while ((paramAnonymousMessage.arg1 < 3) || (paramAnonymousMessage.arg2 == -1));
              w.a(RadioPlayerFragment.this.getString(2131296619), 1);
              return;
            } while (paramAnonymousMessage.arg1 != com.baidu.carlife.logic.a.j.a().c().s());
            RadioPlayerFragment.d(RadioPlayerFragment.this).a(RadioPlayerFragment.c(RadioPlayerFragment.this));
            com.baidu.carlife.logic.a.j.a().c().i(3);
            return;
          } while (paramAnonymousMessage.arg1 != com.baidu.carlife.logic.a.j.a().c().s());
          removeMessages(307);
          com.baidu.carlife.logic.a.j.a().c().i(2);
          if (RadioPlayerFragment.d(RadioPlayerFragment.this).q()) {
            RadioPlayerFragment.a(RadioPlayerFragment.this, com.baidu.carlife.logic.music.h.b().i());
          }
          RadioPlayerFragment.e(RadioPlayerFragment.this);
          return;
          if (RadioPlayerFragment.j(RadioPlayerFragment.this))
          {
            RadioPlayerFragment.d(RadioPlayerFragment.this).y();
            RadioPlayerFragment.d(RadioPlayerFragment.this).f(true);
            com.baidu.carlife.core.k.a(307);
            return;
          }
        } while ((RadioPlayerFragment.n(RadioPlayerFragment.this) == null) || (paramAnonymousMessage.arg2 != com.baidu.carlife.logic.a.j.a().c().s()) || ((paramAnonymousMessage.arg1 >= 3) && (paramAnonymousMessage.arg1 % 3 != 0)));
        RadioPlayerFragment.n(RadioPlayerFragment.this).setProgress(paramAnonymousMessage.arg1);
        return;
      } while ((paramAnonymousMessage.arg1 != com.baidu.carlife.logic.a.j.a().c().s()) || (RadioPlayerFragment.o(RadioPlayerFragment.this) == null));
      if ((RadioPlayerFragment.c(RadioPlayerFragment.this) != null) && (RadioPlayerFragment.c(RadioPlayerFragment.this).k))
      {
        RadioPlayerFragment.o(RadioPlayerFragment.this).setImageDrawable(com.baidu.carlife.util.r.b(2130839334));
        RadioPlayerFragment.p(RadioPlayerFragment.this);
        return;
      }
      RadioPlayerFragment.o(RadioPlayerFragment.this).setImageDrawable(com.baidu.carlife.util.r.b(2130839335));
      RadioPlayerFragment.q(RadioPlayerFragment.this);
    }
  };
  private Runnable v = new Runnable()
  {
    public void run()
    {
      RadioPlayerFragment.r(RadioPlayerFragment.this).setStartIndex(new Random().nextInt(20));
      RadioPlayerFragment.r(RadioPlayerFragment.this).invalidate();
      if (RadioPlayerFragment.s(RadioPlayerFragment.this) != null) {
        RadioPlayerFragment.s(RadioPlayerFragment.this).postDelayed(RadioPlayerFragment.t(RadioPlayerFragment.this), 150L);
      }
    }
  };
  private com.baidu.carlife.f.g w;
  private com.baidu.carlife.f.g x;
  
  private void a()
  {
    a(com.baidu.carlife.logic.a.j.a().c().p());
    if (this.p == null)
    {
      this.o.f(true);
      q();
      com.baidu.carlife.logic.a.j.a().c().f();
      return;
    }
    if ((this.o.g(com.baidu.carlife.logic.a.j.a().c().s())) && (this.p.j > 0))
    {
      b();
      this.o.e(true);
      this.o.H();
      return;
    }
    this.o.f(true);
    this.o.e(this.p);
  }
  
  private void a(int paramInt)
  {
    if (com.baidu.carlife.logic.a.j.a().c().s() == 101)
    {
      this.b.setVisibility(0);
      this.c.a(2131296598, 2131296600);
      this.c.a(true);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      onInitFocusAreas();
      return;
      this.l.setVisibility(0);
      this.c.setVisibility(8);
      continue;
      this.l.setVisibility(8);
      this.c.setVisibility(0);
      continue;
      this.o.a(com.baidu.carlife.logic.a.j.a().c().q());
      this.c.a(2131296614, 2131296600);
      this.c.a(true);
      this.l.setVisibility(8);
      this.c.setVisibility(0);
    }
  }
  
  private void a(MusicSongModel paramMusicSongModel)
  {
    this.p = paramMusicSongModel;
  }
  
  private void b()
  {
    if (this.p == null)
    {
      c();
      return;
    }
    this.r = false;
    try
    {
      this.q = (Integer.parseInt(this.p.i) / 1000);
      this.d.setMax(this.q);
      this.d.setProgress(this.p.j);
      if (this.p.k)
      {
        this.g.setImageDrawable(com.baidu.carlife.util.r.b(2130839334));
        this.j.setText(this.p.b);
        this.k.setText(this.p.f);
        if (this.p.g != null)
        {
          com.facebook.drawee.c.a locala = com.baidu.carlife.g.a.a(this.m, this.p.g, 200, 200);
          this.m.setController(locala);
        }
        if (this.p.s != 1) {
          break label194;
        }
        this.e.setImageResource(2130839332);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.q = 1;
        continue;
        this.g.setImageDrawable(com.baidu.carlife.util.r.b(2130839335));
      }
      label194:
      this.e.setImageResource(2130839331);
    }
  }
  
  private void c()
  {
    this.d.setMax(1);
    this.d.setProgress(0);
    this.k.setText("");
    this.j.setText("");
    this.m.setImageURI("");
    this.e.setImageResource(2130839331);
  }
  
  private void d()
  {
    if (this.p == null) {
      return;
    }
    if (this.p.l)
    {
      w.a("正在缓冲", 0);
      return;
    }
    e();
  }
  
  private void e()
  {
    if (!this.o.q())
    {
      this.o.t();
      this.o.u();
      this.o.e(this.p);
      return;
    }
    if (this.p.k)
    {
      p.a().c();
      this.o.f(true);
      return;
    }
    p.a().d();
    this.o.e(true);
  }
  
  private void f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_player", true);
    com.baidu.carlife.core.screen.presentation.h.a().back(localBundle);
  }
  
  private void g()
  {
    if (this.p != null)
    {
      if (this.p.s != 1) {
        break label46;
      }
      this.p.s = 0;
      this.e.setImageResource(2130839331);
    }
    label46:
    do
    {
      c.a().a(this.p);
      return;
      StatisticManager.onEvent("CONTENT_LIKE_0001");
      this.p.s = 1;
      this.e.setImageResource(2130839332);
    } while (this.p.r != 999);
  }
  
  private void h()
  {
    if (this.p == null) {}
    do
    {
      return;
      StatisticManager.onEvent("CONTENT_LIKE_0002");
      if ((this.o.q()) && (this.p.k)) {
        this.o.f(true);
      }
      this.p.s = 2;
      c.a().a(this.p);
    } while (this.p.r == 999);
    this.r = true;
    com.baidu.carlife.logic.a.j.a().e();
  }
  
  private void i()
  {
    this.o.B();
  }
  
  private void j()
  {
    this.o.A();
  }
  
  private void k()
  {
    com.baidu.carlife.view.g.e().f();
  }
  
  private boolean l()
  {
    return (!this.o.I()) && (this.p != null) && ((this.p.n < this.p.o) || (this.p.n < 0L) || (this.p.o <= 0L));
  }
  
  private void m()
  {
    com.baidu.carlife.logic.a.j.a().c().a(this.s);
    com.baidu.carlife.logic.a.j.a().c().a(getArguments());
    this.p = com.baidu.carlife.logic.a.j.a().c().p();
  }
  
  private void n()
  {
    this.b = ((ImageButton)this.mContentView.findViewById(2131624258));
    this.b.setBackground(b.b(getContext()));
    this.j = ((TextView)this.mContentView.findViewById(2131625092));
    this.k = ((TextView)this.mContentView.findViewById(2131625093));
    this.e = ((ImageButton)this.mContentView.findViewById(2131625095));
    this.f = ((ImageButton)this.mContentView.findViewById(2131625096));
    this.g = ((ImageButton)this.mContentView.findViewById(2131625098));
    this.h = ((ImageButton)this.mContentView.findViewById(2131625100));
    this.i = ((ImageButton)this.mContentView.findViewById(2131625101));
    this.d = ((RadioPlayerCircleProgressView)this.mContentView.findViewById(2131625099));
    this.m = ((SimpleDraweeView)this.mContentView.findViewById(2131625097));
    this.c = ((CommonTipView)this.mContentView.findViewById(2131623981));
    this.c.setCommonTipCallBack(new CommonTipView.a()
    {
      public void a()
      {
        if (com.baidu.carlife.logic.k.a().c() != 0) {
          w.a(2131296842, 1);
        }
      }
    });
    this.l = ((LinearLayout)this.mContentView.findViewById(2131625094));
    this.f.setOnClickListener(this.t);
    this.g.setOnClickListener(this.t);
    this.h.setOnClickListener(this.t);
    this.e.setOnClickListener(this.t);
    this.i.setOnClickListener(this.t);
    this.b.setOnClickListener(this.t);
    this.n = ((HomeCardMusicMelodyView)this.mContentView.findViewById(2131625090));
    this.n.setVisibility(4);
  }
  
  private void o() {}
  
  private void p()
  {
    this.n.setVisibility(4);
    if (this.u != null) {
      this.u.removeCallbacks(this.v);
    }
  }
  
  private void q()
  {
    if (this.d != null) {
      this.d.post(new Runnable()
      {
        public void run()
        {
          RadioPlayerFragment.o(RadioPlayerFragment.this).setImageDrawable(com.baidu.carlife.util.r.b(2130839335));
          RadioPlayerFragment.n(RadioPlayerFragment.this).setProgress(0);
        }
      });
    }
  }
  
  public boolean onBackPressed()
  {
    f();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = com.baidu.carlife.logic.music.h.b();
    com.baidu.carlife.core.k.a(this.u);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968797, null);
    n();
    return this.mContentView;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    dismissDialog();
    k();
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    this.u.removeMessages(307);
    com.baidu.carlife.core.k.b(this.u);
    this.u = null;
    com.baidu.carlife.logic.a.j.a().c().a(null);
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    i.b("CarLifeRadio");
    if (paramBoolean)
    {
      k();
      p();
    }
    do
    {
      do
      {
        return;
      } while (this.p == null);
      if (this.p.l) {
        i();
      }
    } while (!this.p.j());
    o();
  }
  
  public void onInitFocusAreas()
  {
    if (this.w == null)
    {
      this.w = new com.baidu.carlife.f.g(this.mContentView, 2, true);
      this.w.d(this.b);
    }
    if (this.x == null)
    {
      this.x = new com.baidu.carlife.f.g(this.mContentView, 4, true);
      this.x.d(this.e).d(this.f).d(this.g).d(this.h).d(this.i);
      this.x.b(this.g);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.w, this.x });
    d.a().h(this.x);
  }
  
  @Deprecated
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    p();
  }
  
  public void onResume()
  {
    if ((this.p != null) && (this.p.l)) {
      i();
    }
    b();
    com.baidu.carlife.core.k.b(4023);
    super.onResume();
    onInitFocusAreas();
    if ((this.p != null) && (this.p.j()))
    {
      o();
      return;
    }
    p();
  }
  
  public void onStart()
  {
    m();
    super.onStart();
    i.b("CarLifeRadio", "------onStart()------");
  }
  
  @Deprecated
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin() {}
  
  @Deprecated
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/player/RadioPlayerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */