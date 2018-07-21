package com.baidu.carlife.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.q.g;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.wechat.b.d.a;
import com.baidu.carlife.wechat.f.b;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSMListener;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.HashMap;

public class g
  implements View.OnClickListener, OnRGInfoListener
{
  private static final String a = "TipsView";
  private static volatile g b = null;
  private static final String d = "米后";
  private static final String e = "公里后";
  private static int f = 0;
  private static final int g = 25;
  private static final int h = com.baidu.carlife.core.d.a().h();
  private TextView A;
  private ImageView B = null;
  private HashMap<String, Integer> C = new HashMap();
  private HashMap<String, String> D = new HashMap();
  private com.baidu.carlife.f.g E;
  private com.baidu.carlife.f.g F;
  private boolean G = true;
  private View H;
  private View I;
  private com.baidu.carlife.f.g J;
  private com.baidu.carlife.f.g K;
  private ImageButton L;
  private ImageButton M;
  private ImageButton N;
  private q O;
  private boolean P;
  private boolean Q;
  private RouteGuideFSMListener R = new RouteGuideFSMListener()
  {
    public void run(String paramAnonymousString)
    {
      if ("收到放大图显示消息".equals(paramAnonymousString)) {
        g.a(g.this, false);
      }
      do
      {
        return;
        if ("收到放大图隐藏消息".equals(paramAnonymousString))
        {
          g.a(g.this, true);
          return;
        }
      } while ((!"拖动地图".equals(paramAnonymousString)) && (!"触碰地图".equals(paramAnonymousString)));
      BottomTabDisplayController.getInstance().showThenDelayDismiss();
    }
  };
  private q.g S = new q.g()
  {
    public void a()
    {
      Chronometer localChronometer = (Chronometer)g.a(g.this).findViewById(2131626102);
      localChronometer.setBase(SystemClock.elapsedRealtime());
      localChronometer.start();
      g.c(g.this, true);
    }
    
    public void a(boolean paramAnonymousBoolean)
    {
      g.this.c();
      ((Chronometer)g.a(g.this).findViewById(2131626102)).stop();
      int i = com.baidu.carlife.core.screen.presentation.h.a().d();
      if ((paramAnonymousBoolean) && (4002 != i) && (g.b(g.this)))
      {
        g.c(g.this);
        g.d(g.this).sendEmptyMessageDelayed(4024, 10000L);
      }
      g.b(g.this, false);
      g.c(g.this, false);
    }
    
    public void b(boolean paramAnonymousBoolean)
    {
      int i = com.baidu.carlife.core.screen.presentation.h.a().d();
      if ((paramAnonymousBoolean) && (4002 != i)) {
        g.e(g.this);
      }
      for (;;)
      {
        g.b(g.this, true);
        return;
        g.this.c();
      }
    }
    
    public void c(boolean paramAnonymousBoolean)
    {
      g.this.c();
      g.b(g.this, true);
    }
    
    public void d(boolean paramAnonymousBoolean) {}
  };
  private a c = null;
  private int i = 0;
  private String j = "";
  private boolean k = false;
  private View l = null;
  private LinearLayout m = null;
  private LinearLayout n = null;
  private LinearLayout o = null;
  private View p = null;
  private ProgressBar q = null;
  private MusicSongModel r = null;
  private ImageView s = null;
  private MarqueeTextView t = null;
  private MarqueeTextView u = null;
  private MarqueeTextView v = null;
  private MarqueeTextView w = null;
  private ImageView x;
  private ImageView y;
  private TextView z;
  
  public g()
  {
    k.a(this.c);
    p();
  }
  
  private Bundle a(Message paramMessage)
  {
    if ((paramMessage != null) && ((paramMessage.obj instanceof Bundle))) {
      return (Bundle)paramMessage.obj;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.p != null)
    {
      this.p.setVisibility(0);
      if (paramInt2 > 0) {
        ((TextView)this.p.findViewById(2131624648)).setText(paramInt2);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.p != null)
    {
      this.p.setVisibility(0);
      if (!TextUtils.isEmpty(paramString)) {
        ((TextView)this.p.findViewById(2131624648)).setText(paramString);
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (j()) {
      return;
    }
    d();
    m();
    g();
    if (this.o.getVisibility() == 8)
    {
      this.o.setVisibility(0);
      this.o.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          g.i(g.this);
        }
      });
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.leftMargin = paramInt;
      this.o.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.c.sendEmptyMessageDelayed(4022, 10000L);
      if (this.F == null)
      {
        this.F = new com.baidu.carlife.f.g(this.m, 0);
        this.F.d(this.o.findViewById(2131626096));
      }
      com.baidu.carlife.f.d.a().b(this.F);
      return;
      this.c.removeMessages(4022);
    }
  }
  
  private void c(int paramInt)
  {
    i.b("ouyang", "----------xPos:" + paramInt);
    if (j()) {}
    for (;;)
    {
      return;
      if (this.G)
      {
        if (com.baidu.carlife.logic.music.h.b().q()) {}
        for (this.r = com.baidu.carlife.logic.music.h.b().i(); (this.r != null) && (!TextUtils.isEmpty(this.r.b)); this.r = com.baidu.carlife.logic.music.h.b().h())
        {
          d();
          l();
          g();
          this.t.setText(this.r.b);
          this.u.setText(this.r.f);
          if (this.m.getVisibility() != 0) {
            break label220;
          }
          this.c.removeMessages(4022);
          this.c.sendEmptyMessageDelayed(4022, 10000L);
          if (this.E == null)
          {
            this.E = new com.baidu.carlife.f.g(this.m, 0);
            this.E.d(this.m.findViewById(2131626096));
          }
          com.baidu.carlife.f.d.a().b(this.E);
          return;
        }
      }
    }
    label220:
    this.m.setVisibility(0);
    int i1 = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType();
    if ((i1 == 113) || (i1 == 114)) {
      this.s.setVisibility(8);
    }
    for (;;)
    {
      this.m.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          g.j(g.this);
        }
      });
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.leftMargin = paramInt;
      this.m.setLayoutParams(localLayoutParams);
      break;
      this.s.setVisibility(0);
    }
  }
  
  public static g e()
  {
    if (b == null) {
      b = new g();
    }
    return b;
  }
  
  private void h()
  {
    k();
    this.H.setVisibility(0);
    ((TextView)this.l.findViewById(2131624714)).setText(this.O.a());
    if (this.J == null)
    {
      this.J = new com.baidu.carlife.f.g(this.H, 0);
      this.J.d(this.L).d(this.M);
    }
    com.baidu.carlife.f.d.a().b(this.J);
  }
  
  private void i()
  {
    k();
    this.I.setVisibility(0);
    View localView = this.l.findViewById(2131626102);
    if (this.Q) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      if (this.K == null)
      {
        this.K = new com.baidu.carlife.f.g(this.I, 0);
        this.K.d(this.N);
      }
      com.baidu.carlife.f.d.a().b(this.K);
      return;
    }
  }
  
  private boolean j()
  {
    if (this.H == null) {
      return false;
    }
    return this.H.isShown();
  }
  
  private void k()
  {
    m();
    l();
    d();
    g();
  }
  
  private void l()
  {
    this.c.removeMessages(4022);
    if (this.o != null)
    {
      this.o.setVisibility(8);
      this.k = true;
      this.c.sendEmptyMessageDelayed(4026, 10000L);
    }
    if (j()) {
      com.baidu.carlife.f.d.a().b(null);
    }
  }
  
  private void m()
  {
    this.c.removeMessages(4022);
    if (this.m != null) {
      this.m.setVisibility(8);
    }
    if (!j())
    {
      com.baidu.carlife.f.d.a().b(null);
      ContentFragment localContentFragment = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragment();
      if ((localContentFragment != null) && (localContentFragment.isDisplayed) && ((localContentFragment instanceof BNRouteGuideFragment))) {
        localContentFragment.onInitFocusAreas();
      }
    }
  }
  
  private int n()
  {
    int i1 = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType();
    if ((i1 == 113) || (i1 == 114)) {
      return com.baidu.carlife.core.d.a().h() / 3;
    }
    return 0;
  }
  
  private int o()
  {
    int i1 = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType();
    if (com.baidu.carlife.core.screen.presentation.h.a().b(i1)) {}
    while ((com.baidu.carlife.core.screen.presentation.h.a().isCarlifeFragment(i1)) || (i1 == 17)) {
      return 0;
    }
    if (i1 == 113) {
      return com.baidu.carlife.core.d.a().h() / 3;
    }
    if (i1 == 114) {
      return com.baidu.carlife.core.d.a().h() / 3;
    }
    return ScreenUtil.getInstance().dip2px(80);
  }
  
  private void p()
  {
    int i2 = RouteGuideParams.gTurnIconName.length;
    int i1 = 0;
    while (i1 < i2)
    {
      this.C.put(RouteGuideParams.gTurnIconName[i1], Integer.valueOf(com.baidu.navisdk.ui.routeguide.subview.BNavR.gTurnIconID[i1]));
      this.D.put(RouteGuideParams.gTurnIconName[i1], RouteGuideParams.gTurnTypeDesc[i1]);
      i1 += 1;
    }
  }
  
  public void a()
  {
    BNRouteGuider.getInstance().addRGInfoListeners(this);
    RouteGuideFSM.getInstance().setRGMListener(this.R);
  }
  
  public void a(final int paramInt)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        g.a(g.this, 0, paramInt);
      }
    });
  }
  
  public void a(View paramView)
  {
    this.p = paramView;
  }
  
  public void a(com.baidu.carlife.core.screen.presentation.a.h paramh)
  {
    this.l = paramh.g();
    f = a.a().getResources().getDimensionPixelSize(2131362134);
    this.m = ((LinearLayout)this.l.findViewById(2131626094));
    this.n = ((LinearLayout)this.l.findViewById(2131626119));
    this.o = ((LinearLayout)this.l.findViewById(2131626097));
    this.n.setOnClickListener(null);
    this.x = ((ImageView)this.n.findViewById(2131626120));
    this.x.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        b.d().f();
        switch (g.6.a[((d.a)g.f(g.this).getTag()).ordinal()])
        {
        default: 
          g.this.g();
          b.d().c();
          return;
        case 1: 
        case 2: 
          com.baidu.carlife.wechat.f.d.a();
          b.d().a();
          return;
        }
        com.baidu.carlife.wechat.f.d.a();
        b.d().g();
      }
    });
    this.y = ((ImageView)this.n.findViewById(2131626123));
    this.y.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.baidu.carlife.wechat.f.d.a();
        b.d().f();
        g.this.g();
        b.d().c();
      }
    });
    this.z = ((TextView)this.n.findViewById(2131626121));
    this.A = ((TextView)this.n.findViewById(2131626122));
    this.s = ((ImageView)this.m.findViewById(2131626095));
    this.t = ((MarqueeTextView)this.m.findViewById(2131625665));
    this.u = ((MarqueeTextView)this.m.findViewById(2131625666));
    paramh = (ImageButton)this.m.findViewById(2131626096);
    paramh.requestFocusFromTouch();
    paramh.setOnClickListener(this);
    this.v = ((MarqueeTextView)this.o.findViewById(2131626099));
    this.w = ((MarqueeTextView)this.o.findViewById(2131626100));
    this.B = ((ImageView)this.o.findViewById(2131626098));
    paramh = (ImageButton)this.o.findViewById(2131626096);
    paramh.requestFocusFromTouch();
    paramh.setOnClickListener(this);
    this.q = ((ProgressBar)LayoutInflater.from(a.a()).inflate(2130968631, null));
  }
  
  public void a(d.a parama)
  {
    this.x.setTag(parama);
    switch (6.a[parama.ordinal()])
    {
    default: 
      this.x.setImageResource(2130903052);
      return;
    case 1: 
      this.x.setImageResource(2130903052);
      return;
    case 3: 
      this.x.setImageResource(2130903053);
      return;
    }
    this.x.setImageResource(2130903051);
  }
  
  public void a(final String paramString)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        g.a(g.this, 0, paramString);
      }
    });
  }
  
  public void a(String paramString1, String paramString2, d.a parama)
  {
    if (j()) {}
    while (!this.G) {
      return;
    }
    d();
    l();
    m();
    this.x.setTag(parama);
    switch (6.a[parama.ordinal()])
    {
    default: 
      this.x.setImageResource(2130903052);
    }
    for (;;)
    {
      this.z.setText(paramString1);
      this.A.setText(paramString2);
      if (this.n.getVisibility() != 0) {
        break;
      }
      this.c.removeMessages(4022);
      return;
      this.x.setImageResource(2130903052);
      continue;
      this.x.setImageResource(2130903053);
      continue;
      this.x.setImageResource(2130903051);
    }
    this.n.setVisibility(0);
    paramString1 = new RelativeLayout.LayoutParams(-1, -2);
    paramString1.leftMargin = n();
    this.n.setLayoutParams(paramString1);
  }
  
  public void b()
  {
    if (this.l == null) {
      return;
    }
    this.H = this.l.findViewById(2131623989);
    this.I = this.l.findViewById(2131623988);
    this.L = ((ImageButton)this.l.findViewById(2131626104));
    this.L.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.this.c();
        g.g(g.this).m();
        StatisticManager.onEvent("1060", "接听按钮接听");
      }
    });
    this.M = ((ImageButton)this.l.findViewById(2131626105));
    this.M.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.this.c();
        g.g(g.this).a(a.a());
        StatisticManager.onEvent("1060", "接听按钮拒绝或挂断");
      }
    });
    this.I.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.this.d();
      }
    });
    this.N = ((ImageButton)this.l.findViewById(2131626103));
    this.N.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.this.d();
      }
    });
    this.O = q.f();
    this.O.a(this.S);
  }
  
  public void c()
  {
    if (this.H == null) {
      return;
    }
    this.H.setVisibility(8);
    com.baidu.carlife.f.d.a().b(null);
  }
  
  public void d()
  {
    if (this.I == null) {}
    do
    {
      return;
      this.I.setVisibility(8);
      this.l.findViewById(2131626102).setVisibility(8);
    } while (!j());
    com.baidu.carlife.f.d.a().b(null);
  }
  
  public void f()
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        if (g.h(g.this) != null) {
          g.h(g.this).setVisibility(8);
        }
      }
    });
  }
  
  public void g()
  {
    this.c.removeMessages(4022);
    if (this.n != null) {
      this.n.setVisibility(8);
    }
  }
  
  public void onAssistInfoHide(Message paramMessage) {}
  
  public void onAssistInfoShow(Message paramMessage) {}
  
  public void onAssistInfoUpdate(Message paramMessage) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    k();
  }
  
  public void onCurRoadNameUpdate(Message paramMessage) {}
  
  public void onDestStreetViewDownloadSuccess(Message paramMessage) {}
  
  public void onDestStreetViewHide(Message paramMessage) {}
  
  public void onDestStreetViewShow(Message paramMessage) {}
  
  public void onDestStreetViewStartDownload(Message paramMessage) {}
  
  public void onDestStreetViewUpdate(Message paramMessage) {}
  
  public void onDirectBoardHide(Message paramMessage) {}
  
  public void onDirectBoardShow(Message paramMessage) {}
  
  public void onDirectBoardUpdate(Message paramMessage) {}
  
  public void onGPSWeak(Message paramMessage) {}
  
  public void onHUDUpdate(Message paramMessage) {}
  
  public void onHighwayInfoHide(Message paramMessage) {}
  
  public void onHighwayInfoShow(Message paramMessage) {}
  
  public void onHighwayInfoUpdate(Message paramMessage) {}
  
  public void onOtherRGInfo(Message paramMessage) {}
  
  public void onRGSyncOperation(Message paramMessage) {}
  
  public void onRasterExpandMapHide(Message paramMessage) {}
  
  public void onRasterExpandMapShow(Message paramMessage) {}
  
  public void onRasterExpandMapUpdate(Message paramMessage) {}
  
  public void onSimpleBoardHide(Message paramMessage) {}
  
  public void onSimpleBoardShow(Message paramMessage) {}
  
  public void onSimpleBoardUpdate(Message paramMessage) {}
  
  public void onSimpleGuideInfoHide(Message paramMessage) {}
  
  public void onSimpleGuideInfoShow(Message paramMessage) {}
  
  public void onSimpleGuideInfoUpdate(Message paramMessage)
  {
    Object localObject = a(paramMessage);
    if (localObject == null) {
      return;
    }
    int i3 = ((Bundle)localObject).getInt("remain_dist");
    paramMessage = ((Bundle)localObject).getString("road_name");
    localObject = ((Bundle)localObject).getString("icon_name");
    if (((i3 <= 0) && ("目的地".equals(this.j)) && (TextUtils.isEmpty(paramMessage))) || (!BNavigator.getInstance().isNaviBegin()))
    {
      this.v.setText("导航结束");
      this.w.setText("目的地");
      this.j = "";
      l();
      return;
    }
    this.j = paramMessage;
    int i2 = ((Integer)this.C.get(RouteGuideParams.gTurnIconName[0])).intValue();
    int i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (this.C.containsKey(localObject)) {
        i1 = ((Integer)this.C.get(localObject)).intValue();
      }
    }
    if (i3 >= 1000)
    {
      i2 = i3 / 1000;
      i3 = i3 % 1000 / 100;
      this.v.setText(i2 + "." + i3 + "公里后");
    }
    for (;;)
    {
      this.w.setText(paramMessage);
      this.B.setImageDrawable(JarUtils.getResources().getDrawable(i1));
      i1 = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType();
      if ((!com.baidu.carlife.core.screen.presentation.h.a().isCarlifeFragment(i1)) || (this.k)) {
        break;
      }
      b(o());
      return;
      this.v.setText(i3 + "米后");
    }
  }
  
  public void onTotalRemainDistTimeUpdate(Message paramMessage) {}
  
  public void onUGCEventTipsHide() {}
  
  public void onUGCEventTipsShow() {}
  
  public void onVectorExpandMapHide(Message paramMessage) {}
  
  public void onVectorExpandMapShow(Message paramMessage)
  {
    if (com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType() == 113) {
      m();
    }
  }
  
  public void onVectorExpandMapUpdate(Message paramMessage)
  {
    if (com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType() == 113) {
      m();
    }
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(310);
      addMsg(219);
      addMsg(4023);
      addMsg(4022);
      addMsg(4024);
      addMsg(505);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 505: 
      case 310: 
        int i;
        for (;;)
        {
          return;
          RouteGuideFSM.getInstance().setRGMListener(g.k(g.this));
          return;
          if (paramMessage.arg1 == 43985) {}
          try
          {
            g.l(g.this).setImageResource(2130838954);
            i = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragmentType();
            if (com.baidu.carlife.logic.music.h.b().q())
            {
              if (com.baidu.carlife.core.screen.presentation.h.a().a(i)) {
                continue;
              }
              g.a(g.this, g.m(g.this));
              g.b(g.this, 0);
            }
          }
          catch (NullPointerException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
        if (!com.baidu.carlife.core.screen.presentation.h.a().b(i))
        {
          g.a(g.this, g.m(g.this));
          g.b(g.this, 0);
          return;
        }
        removeMessages(310);
        if (g.n(g.this) < 25)
        {
          sendEmptyMessageDelayed(310, 500L);
          return;
        }
        g.b(g.this, 0);
        return;
      case 219: 
        paramMessage = (Bitmap)paramMessage.obj;
        if (paramMessage == null)
        {
          g.l(g.this).setImageResource(2130838954);
          return;
        }
        g.l(g.this).setImageBitmap(paramMessage);
        return;
      case 4022: 
        g.o(g.this);
        return;
      case 4023: 
        g.j(g.this);
        return;
      case 4026: 
        g.d(g.this, false);
        return;
      }
      g.this.d();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */