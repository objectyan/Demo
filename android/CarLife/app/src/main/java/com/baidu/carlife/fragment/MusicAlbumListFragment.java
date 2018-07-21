package com.baidu.carlife.fragment;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.logic.music.b.b;
import com.baidu.carlife.logic.music.j.a;
import com.baidu.carlife.logic.music.q;
import com.baidu.carlife.logic.music.t;
import com.baidu.carlife.logic.music.views.ViewContainer;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.a;
import com.baidu.carlife.view.MultiImageView;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import java.util.HashMap;

public class MusicAlbumListFragment
  extends ContentFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final String f = "CarLifeMusic";
  private View A;
  private com.baidu.carlife.logic.music.b.a B;
  private com.baidu.carlife.logic.music.b.a C = new com.baidu.carlife.logic.music.b.a()
  {
    public void a()
    {
      MusicAlbumListFragment.b(MusicAlbumListFragment.this);
    }
    
    public void a(int paramAnonymousInt)
    {
      MusicAlbumListFragment.a(MusicAlbumListFragment.this, paramAnonymousInt);
    }
    
    public void a(String paramAnonymousString)
    {
      String str = MusicAlbumListFragment.d(MusicAlbumListFragment.this).a(paramAnonymousString);
      if (!TextUtils.isEmpty(str)) {
        w.a(str + "断开连接了", 0);
      }
      b();
      paramAnonymousString = MusicAlbumListFragment.d(MusicAlbumListFragment.this).b(paramAnonymousString);
      if ((paramAnonymousString != null) && (MusicAlbumListFragment.d(MusicAlbumListFragment.this).g(paramAnonymousString.s())))
      {
        MusicAlbumListFragment.d(MusicAlbumListFragment.this).f(true);
        com.baidu.carlife.core.k.a(310);
        MusicAlbumListFragment.d(MusicAlbumListFragment.this).f(-1);
        if (paramAnonymousString.s() == 1) {
          c();
        }
      }
    }
    
    public void b()
    {
      MusicAlbumListFragment.c(MusicAlbumListFragment.this);
    }
    
    public void b(int paramAnonymousInt)
    {
      MusicAlbumListFragment.b(MusicAlbumListFragment.this, paramAnonymousInt);
    }
    
    public void c()
    {
      if (MusicAlbumListFragment.e(MusicAlbumListFragment.this) != null) {
        MusicAlbumListFragment.e(MusicAlbumListFragment.this).post(new Runnable()
        {
          public void run()
          {
            MusicAlbumListFragment.f(MusicAlbumListFragment.this);
          }
        });
      }
    }
  };
  private j.a D = new j.a()
  {
    public void a()
    {
      MusicAlbumListFragment.this.dismissDialog(MusicAlbumListFragment.g(MusicAlbumListFragment.this));
    }
  };
  private com.baidu.carlife.core.j E = new com.baidu.carlife.core.j()
  {
    public void careAbout()
    {
      addMsg(206);
      addMsg(248);
      addMsg(1040);
      addMsg(1002);
      addMsg(3013);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.baidu.carlife.logic.music.b localb;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 206: 
        do
        {
          return;
          localb = MusicAlbumListFragment.d(MusicAlbumListFragment.this).h(paramAnonymousMessage.arg2);
          if ((localb != null) && (localb.i()))
          {
            localb.a(false);
            com.baidu.carlife.core.i.e("CarLifeMusic", "MSG_MUSIC_UPDATE_ALBUMLIST-1-");
            return;
          }
          localb.j(2);
          MusicAlbumListFragment.c(MusicAlbumListFragment.this);
        } while (MusicAlbumListFragment.d(MusicAlbumListFragment.this).g() != paramAnonymousMessage.arg2);
        MusicAlbumListFragment.a(MusicAlbumListFragment.this, paramAnonymousMessage.arg1);
        return;
      case 248: 
        localb = MusicAlbumListFragment.d(MusicAlbumListFragment.this).h(paramAnonymousMessage.arg1);
        if (localb != null)
        {
          localb.a(true);
          localb.j(3);
          if (paramAnonymousMessage.arg2 == -2) {
            switch (paramAnonymousMessage.arg1)
            {
            }
          }
        }
        for (;;)
        {
          paramAnonymousMessage.arg2 = -1;
          if (MusicAlbumListFragment.d(MusicAlbumListFragment.this).g() != paramAnonymousMessage.arg1) {
            break;
          }
          MusicAlbumListFragment.c(MusicAlbumListFragment.this);
          return;
          StatisticManager.onEvent("MUSIC_QQ_0014", "同步超时");
          continue;
          StatisticManager.onEvent("MUSIC_XMLY_0010", "同步超时");
          continue;
          StatisticManager.onEvent("MUSIC_KAOLA_0010", "同步超时");
          continue;
          StatisticManager.onEvent("MUSIC_CYB_0010", "同步超时");
        }
      case 1040: 
        MusicAlbumListFragment.a(MusicAlbumListFragment.this, true);
        return;
      case 1002: 
        MusicAlbumListFragment.a(MusicAlbumListFragment.this, false);
        return;
      }
      MusicAlbumListFragment.h(MusicAlbumListFragment.this);
    }
  };
  protected com.baidu.carlife.f.b a;
  protected com.baidu.carlife.f.g b = null;
  protected com.baidu.carlife.f.g c = null;
  protected com.baidu.carlife.f.g d;
  Runnable e = new Runnable()
  {
    public void run()
    {
      MusicAlbumListFragment.h(MusicAlbumListFragment.this);
    }
  };
  private com.baidu.carlife.logic.music.h g;
  private com.baidu.carlife.logic.music.b h;
  private com.baidu.carlife.adpter.i i;
  private boolean j;
  private View k;
  private View l;
  private View m;
  private View n;
  private View o;
  private GridView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private RelativeLayout t;
  private MultiImageView u;
  private ImageView v;
  private com.baidu.carlife.view.dialog.f w;
  private AnimationDrawable x;
  private CommonTipView y;
  private ViewContainer z;
  
  private void a()
  {
    this.z = ((ViewContainer)this.mContentView.findViewById(2131624990));
    this.k = this.mContentView.findViewById(2131624997);
    this.l = this.mContentView.findViewById(2131624993);
    this.m = this.mContentView.findViewById(2131624999);
    this.n = this.mContentView.findViewById(2131624995);
    this.o = this.mContentView.findViewById(2131624992);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.t = ((RelativeLayout)this.mContentView.findViewById(2131625675));
    this.u = ((MultiImageView)this.mContentView.findViewById(2131625676));
    this.v = ((ImageView)this.mContentView.findViewById(2131625674));
    this.v.setImageResource(2131034112);
    this.x = ((AnimationDrawable)this.v.getDrawable());
    this.t.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.q = ((TextView)this.mContentView.findViewById(2131624991));
    this.r = ((TextView)this.mContentView.findViewById(2131624998));
    this.s = ((TextView)this.mContentView.findViewById(2131624994));
    this.p = ((GridView)this.mContentView.findViewById(2131625000));
    this.p.setAdapter(this.i);
    this.p.setOnItemClickListener(this);
    this.w = new com.baidu.carlife.view.dialog.f(mActivity, 2131296613, this.g.E(), this.g.F());
    this.w.j();
    this.y = ((CommonTipView)this.mContentView.findViewById(2131623981));
    this.y.setCommonTipCallBack(new CommonTipView.a()
    {
      public void a()
      {
        if (com.baidu.carlife.logic.k.a().c() != 0)
        {
          w.a(2131296842, 1);
          return;
        }
        MusicAlbumListFragment.a(MusicAlbumListFragment.this).b(true);
      }
    });
    if (com.baidu.carlife.custom.b.a().b()) {
      if (com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().isDriving()) {
        break label374;
      }
    }
    label374:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      b(com.baidu.carlife.l.a.a().N());
      return;
    }
  }
  
  private void a(int paramInt)
  {
    dismissDialog(this.w);
    com.baidu.carlife.model.j localj = this.g.m(paramInt);
    if (localj == null) {
      return;
    }
    if (localj.c >= 3)
    {
      this.u.setDefaultDrawable(r.b(2130838958));
      this.u.setImageUrl(localj.j);
    }
    for (;;)
    {
      a(localj.m);
      return;
      this.u.setDefaultDrawableResId(localj.b);
      this.u.setImageUrl(null);
    }
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
  
  private void a(boolean paramBoolean)
  {
    View localView = this.y.getFocusView();
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.2F)
    {
      localView.setAlpha(f1);
      this.y.getFocusView().setEnabled(paramBoolean);
      return;
    }
  }
  
  private void b()
  {
    int i1 = this.g.g();
    this.w.a(i1);
    a(i1);
    d();
    c();
  }
  
  private void b(int paramInt)
  {
    this.i.a(this.h.g(paramInt));
    c(paramInt);
    this.p.smoothScrollToPosition(0);
    this.h.j(2);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (com.baidu.carlife.core.d.m()))
    {
      this.p.setNumColumns(6);
      this.p.requestLayout();
      this.mContentView.requestLayout();
      com.baidu.carlife.core.i.b("CarLifeMusic", "Update Gv Columns:6");
      return;
    }
    this.p.setNumColumns(4);
    this.p.requestLayout();
    this.mContentView.requestLayout();
    com.baidu.carlife.core.i.b("CarLifeMusic", "Update Gv Columns:4");
  }
  
  private void c()
  {
    if (this.g.n() == -1) {
      this.v.setVisibility(4);
    }
    do
    {
      return;
      if (this.g.p())
      {
        this.v.setVisibility(0);
        this.v.setImageResource(2131034112);
        this.x = ((AnimationDrawable)this.v.getDrawable());
        this.x.start();
        return;
      }
      this.v.setVisibility(0);
      this.v.setImageDrawable(r.b(2130838988));
    } while (this.x == null);
    this.x.stop();
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 2)
    {
      this.m.setVisibility(0);
      this.n.setVisibility(4);
      this.s.setTextColor(r.a(2131558693));
      this.r.setTextColor(r.a(2131559221));
      this.k.setBackgroundResource(2130838365);
      this.l.setBackground(com.baidu.carlife.view.a.b.d(mActivity));
    }
    while (paramInt != 1) {
      return;
    }
    this.m.setVisibility(4);
    this.n.setVisibility(0);
    this.s.setTextColor(r.a(2131559221));
    this.r.setTextColor(r.a(2131558693));
    this.k.setBackground(com.baidu.carlife.view.a.b.d(mActivity));
    this.l.setBackgroundResource(2130838365);
  }
  
  private void d()
  {
    ((com.baidu.carlife.logic.music.j)this.g.F()).a(this.D);
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.h.s() == 1)
      {
        this.q.setText(2131296626);
        this.q.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      c(this.h.w());
      return;
      this.q.setVisibility(8);
      this.l.setVisibility(4);
      this.k.setVisibility(4);
      this.mContentView.findViewById(2131624996).setVisibility(4);
      continue;
      if (this.h.s() == 2)
      {
        this.l.setVisibility(0);
        this.k.setVisibility(0);
        this.mContentView.findViewById(2131624996).setVisibility(0);
      }
      else
      {
        this.q.setText(2131296623);
        this.q.setVisibility(0);
      }
    }
  }
  
  private void e()
  {
    this.j = true;
    com.baidu.carlife.view.g.e().a(2131296859);
    if (this.E != null) {
      this.E.sendMessageDelayed(Message.obtain(this.E, 248, this.h.s(), -2), 15000L);
    }
  }
  
  private void e(int paramInt)
  {
    d(paramInt);
    this.z.setVisibility(8);
    switch (paramInt)
    {
    }
    for (;;)
    {
      onInitFocusAreas();
      return;
      if (this.h.s() == 1)
      {
        h();
      }
      else
      {
        this.p.setVisibility(0);
        this.z.setVisibility(8);
        this.y.setVisibility(8);
        continue;
        this.p.setVisibility(4);
        if (this.h.s() == 1) {
          str = getString(2131296636);
        }
        for (;;)
        {
          this.y.setVisibility(0);
          this.y.a(str, 2131296620);
          this.y.a(true);
          break;
          str = this.g.a(this.h.q());
          if (!TextUtils.isEmpty(str)) {
            str = String.format(getString(2131296618), new Object[] { str });
          } else {
            str = String.format(getString(2131296618), new Object[] { "第三方" });
          }
        }
        this.p.setVisibility(4);
        if (this.h.s() == 1) {
          str = getString(2131296632);
        }
        for (;;)
        {
          this.y.setVisibility(0);
          this.y.a(str, 2131296620);
          this.y.a(true);
          break;
          str = this.g.a(this.h.q());
          if (!TextUtils.isEmpty(str)) {
            str = String.format(getString(2131296618), new Object[] { str });
          } else {
            str = String.format(getString(2131296618), new Object[] { "第三方" });
          }
        }
        this.p.setVisibility(4);
        String str = this.g.a(this.h.q());
        if (!TextUtils.isEmpty(str)) {}
        for (str = String.format(getContext().getString(2131296617), new Object[] { str });; str = String.format(getContext().getString(2131296617), new Object[] { "第三方" }))
        {
          this.y.setVisibility(0);
          this.y.a(str, 2131296615);
          if (!"1012961a".equals(com.baidu.carlife.core.f.jt)) {
            break label482;
          }
          this.y.a();
          break;
        }
        label482:
        this.y.a(true);
        continue;
        this.p.setVisibility(4);
        this.y.setVisibility(0);
        this.y.a(2131296599, 2131296600);
        this.y.a(true);
      }
    }
  }
  
  private void f()
  {
    this.j = false;
    if (this.E != null) {
      this.E.removeMessages(248);
    }
    com.baidu.carlife.view.g.e().f();
  }
  
  private void g()
  {
    this.h = this.g.r();
    this.h.a(this.C);
    b();
    this.h.b(getArguments());
    if (this.h.s() == 2)
    {
      this.o.setVisibility(0);
      this.q.setVisibility(8);
      return;
    }
    this.o.setVisibility(8);
    this.q.setVisibility(0);
  }
  
  private void h()
  {
    l();
    i();
  }
  
  private void i()
  {
    this.B = new com.baidu.carlife.logic.music.b.a(this.h);
    this.B.a(k());
    this.z.a(this.B);
    this.z.a();
    this.B.a(this.e, 1500L);
  }
  
  private void j()
  {
    if ((this.h.s() == 1) && (this.B != null)) {
      ((q)this.h).a(new b.b()
      {
        public void a(final String paramAnonymousString, final int paramAnonymousInt)
        {
          if (MusicAlbumListFragment.i(MusicAlbumListFragment.this) != null)
          {
            ((q)MusicAlbumListFragment.a(MusicAlbumListFragment.this)).Z.put(paramAnonymousString, Integer.valueOf(paramAnonymousInt));
            BaseFragment.getNaviActivity().runOnUiThread(new Runnable()
            {
              public void run()
              {
                MusicAlbumListFragment.i(MusicAlbumListFragment.this).a(paramAnonymousString, paramAnonymousInt);
              }
            });
          }
        }
      });
    }
  }
  
  @NonNull
  private com.baidu.carlife.c.b.a k()
  {
    this.A = getActivity().getLayoutInflater().inflate(2130968864, this.z, false);
    return new com.baidu.carlife.c.b.a(this.A, 0);
  }
  
  private void l()
  {
    this.y.setVisibility(8);
    this.p.setVisibility(8);
    this.z.setVisibility(0);
  }
  
  private void m()
  {
    if ((this.h.x() != 3) && (this.h.x() != 0) && (this.h.x() != 1)) {
      return;
    }
    this.y.b();
  }
  
  private com.baidu.carlife.f.g n()
  {
    if (this.b == null) {
      this.b = new com.baidu.carlife.f.g(this.mContentView, 4);
    }
    this.b.i();
    this.b.d(this.l).d(this.k).d(this.v).d(this.t).d(this.y.getFocusView());
    this.b.b(this.y.getFocusView());
    return this.b;
  }
  
  private com.baidu.carlife.f.b o()
  {
    if (this.a == null) {
      this.a = new com.baidu.carlife.f.b(this.p, 6);
    }
    return this.a;
  }
  
  private com.baidu.carlife.f.g p()
  {
    if (this.c == null) {
      this.c = new com.baidu.carlife.f.g(this.mContentView, 4);
    }
    this.c.i();
    this.c.d(this.v).d(this.t).d(this.y.getFocusView());
    this.c.b(this.y.getFocusView());
    return this.c;
  }
  
  private com.baidu.carlife.f.g q()
  {
    if (this.A == null) {
      return null;
    }
    if (this.d == null) {
      this.d = new com.baidu.carlife.f.g(this.A, 6);
    }
    this.d.i();
    this.d.d(this.A.findViewById(2131625359)).d(this.A.findViewById(2131625360)).d(this.A.findViewById(2131625361)).d(this.A.findViewById(2131625362));
    return this.d;
  }
  
  public void driving()
  {
    com.baidu.carlife.core.i.b("yftech", "MusicAlbumListFragment driving");
    if (com.baidu.carlife.custom.b.a().b()) {
      a(false);
    }
  }
  
  public boolean onBackPressed()
  {
    if (mActivity != null) {
      mActivity.d();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (this.h == null) {
      g();
    }
    do
    {
      ContentFragment localContentFragment;
      do
      {
        do
        {
          do
          {
            return;
            switch (paramView.getId())
            {
            default: 
              return;
            }
          } while (this.h.w() == 1);
          this.p.setVisibility(4);
          c(1);
          this.h.k(1);
          return;
          this.g.l(this.g.f());
        } while (this.g.n() < 0);
        paramView = new Bundle();
        paramView.putBoolean("music_playing_icon", true);
        localContentFragment = getCurrentFragment();
      } while (localContentFragment == null);
      if (localContentFragment.getType() == 737)
      {
        localContentFragment.getArguments().putBundle("show_bundle", paramView);
        localContentFragment.onStart();
        return;
      }
      showFragment(737, paramView);
      return;
      showDialog(this.w, BaseDialog.a.b);
      return;
    } while (this.h.w() == 2);
    this.p.setVisibility(4);
    c(2);
    this.h.k(2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = com.baidu.carlife.logic.music.h.b();
    com.baidu.carlife.core.k.a(this.E);
    this.i = new com.baidu.carlife.adpter.i();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968783, null);
    a();
    d();
    return this.mContentView;
  }
  
  public void onDestroyView()
  {
    dismissDialog(this.w);
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    com.baidu.carlife.core.i.b("CarLifeMusic");
    if (paramBoolean) {
      com.baidu.carlife.view.g.e().f();
    }
    while (!this.j) {
      return;
    }
    com.baidu.carlife.view.g.e().a(2131296859);
  }
  
  public void onInitFocusAreas()
  {
    if ((this.g == null) || (this.h == null) || (getCurrentFragmentType() != 745)) {}
    com.baidu.carlife.f.d locald;
    do
    {
      do
      {
        return;
      } while (isDialogShown());
      locald = com.baidu.carlife.f.d.a();
      locald.g();
      switch (this.h.x())
      {
      default: 
        return;
      case 0: 
      case 1: 
        locald.b(new com.baidu.carlife.f.a[] { p() });
        locald.h(p());
        com.baidu.carlife.core.i.e("musicalbum", "DISPLAY_STATUS_UNDOWNLOADED");
        return;
      case 2: 
        if (this.h.s() != 1) {
          break label161;
        }
      }
    } while (this.A == null);
    locald.b(new com.baidu.carlife.f.a[] { n(), q() });
    locald.h(this.d);
    return;
    label161:
    locald.b(new com.baidu.carlife.f.a[] { n(), o() });
    locald.h(o());
    com.baidu.carlife.core.i.e("musicalbum", "DISPLAY_STATUS_NORMAL");
    return;
    locald.b(new com.baidu.carlife.f.a[] { n() });
    locald.h(n());
    com.baidu.carlife.core.i.e("musicalbum", "DISPLAY_STATUS_LOAD_FAIL");
  }
  
  protected void onInitView() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.h.h(paramInt);
  }
  
  public void onPause()
  {
    super.onPause();
    com.baidu.carlife.view.g.e().f();
  }
  
  public void onResume()
  {
    super.onResume();
    com.baidu.carlife.core.i.b("CarLifeMusic");
    if (this.j) {
      com.baidu.carlife.view.g.e().a(2131296859);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    com.baidu.carlife.core.i.b("CarLifeMusic", "-----MusicAlbumListFragment--onStart()---");
    g();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
    this.t.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.v.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    com.baidu.carlife.core.i.b("CarLifeMusic", "Voice Command: [" + paramString1 + "][" + paramString2 + "]");
    if ((paramString2.equals("download")) || (paramString2.equals("sync")))
    {
      m();
      return true;
    }
    int i1 = t.a().a(paramString2);
    if (i1 != -1)
    {
      this.g.F().onItemClick(null, null, i1, 0L);
      return true;
    }
    return false;
  }
  
  public void stopDriving()
  {
    com.baidu.carlife.core.i.b("yftech", "MusicAlbumListFragment stopDriving");
    if (com.baidu.carlife.custom.b.a().b()) {
      a(true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/MusicAlbumListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */