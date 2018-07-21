package com.baidu.carlife.core.screen.presentation.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.l;
import com.baidu.carlife.logic.t;
import com.baidu.carlife.logic.t.b;
import com.baidu.carlife.logic.voice.LightVoiceMicView;
import com.baidu.carlife.logic.voice.m;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.v;
import com.baidu.carlife.util.w;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.ui.util.TipTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class h
  extends f
  implements View.OnClickListener, t.b
{
  public static String c = "CarlifeActivity#CarlifeViewWrapper";
  private d d = new d(this);
  private FrameLayout e = null;
  private LinearLayout f = null;
  private ImageButton g = null;
  private ImageButton h = null;
  private ImageButton i = null;
  private ImageButton j = null;
  private LightVoiceMicView k = null;
  private View l = null;
  private View m = null;
  private View n;
  private RelativeLayout o;
  private TextView p;
  private RelativeLayout q;
  private RelativeLayout r;
  private TextView s;
  private View t;
  private com.baidu.carlife.f.g u;
  private com.baidu.carlife.view.dialog.e v;
  private List<BaseDialog> w = new ArrayList();
  
  public h(Context paramContext)
  {
    super(paramContext, 2130968581);
    g.a().a(this);
    e.a().a(this);
    p();
    s();
  }
  
  private void a(BaseDialog paramBaseDialog, boolean paramBoolean)
  {
    if (paramBaseDialog == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!isDialogShown());
      i.b("Dialog", "dismissDialog childView=" + paramBaseDialog);
      bool = this.w.remove(paramBaseDialog);
      this.o.removeView(paramBaseDialog);
      if (this.w.isEmpty()) {
        this.o.setVisibility(8);
      }
      i.b("Dialog", "CarlifeView's dismissDialog mHistories.isEmpty=" + this.w.isEmpty() + ",remove Result=" + bool);
    } while ((!bool) || (paramBaseDialog.h()));
    i.b(c, "onCancel child");
    if (paramBoolean)
    {
      paramBaseDialog.d();
      return;
    }
    paramBaseDialog.c();
  }
  
  private void b(int paramInt)
  {
    this.g.setNextFocusUpId(-1);
    switch (paramInt)
    {
    default: 
      return;
    case 4001: 
      this.g.setSelected(true);
      this.i.setSelected(false);
      this.j.setSelected(false);
      this.h.setSelected(false);
      return;
    case 4002: 
      this.g.setSelected(false);
      this.i.setSelected(true);
      this.j.setSelected(false);
      this.h.setSelected(false);
      return;
    case 4003: 
      this.g.setSelected(false);
      this.i.setSelected(false);
      this.j.setSelected(true);
      this.h.setSelected(false);
      return;
    }
    this.g.setSelected(false);
    this.i.setSelected(false);
    this.j.setSelected(false);
    this.h.setSelected(true);
  }
  
  private void p()
  {
    this.g = ((ImageButton)this.a.findViewById(2131623991));
    this.g.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          BottomTabDisplayController.getInstance().delayHide();
        }
      }
    });
    this.h = ((ImageButton)this.a.findViewById(2131623995));
    this.h.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          BottomTabDisplayController.getInstance().delayHide();
        }
      }
    });
    this.i = ((ImageButton)this.a.findViewById(2131623992));
    this.i.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          BottomTabDisplayController.getInstance().delayHide();
        }
      }
    });
    this.j = ((ImageButton)this.a.findViewById(2131623994));
    this.j.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          BottomTabDisplayController.getInstance().delayHide();
        }
      }
    });
    this.m = this.a.findViewById(2131623993);
    this.l = this.a.findViewById(2131623996);
    this.k = ((LightVoiceMicView)this.a.findViewById(2131623997));
    this.m.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          BottomTabDisplayController.getInstance().delayHide();
        }
      }
    });
    this.f = ((LinearLayout)this.a.findViewById(2131623990));
    this.n = this.a.findViewById(2131623985);
    this.p = ((TextView)this.a.findViewById(2131624002));
    this.p.setVisibility(0);
    this.p.setAlpha(0.0F);
    w.a().a(this.p);
    this.t = ((ViewStub)this.a.findViewById(2131623998)).inflate();
    this.t.setBackgroundResource(2130839424);
    this.t.setVisibility(8);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.e = ((FrameLayout)this.a.findViewById(2131623987));
    if (this.e != null) {
      this.e.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
      });
    }
    this.o = ((RelativeLayout)this.a.findViewById(2131624000));
    this.o.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = h.a(h.this);
        if ((paramAnonymousView != null) && (!paramAnonymousView.e())) {
          return;
        }
        h.this.cancelDialog();
      }
    });
    this.q = ((RelativeLayout)this.a.findViewById(2131624001));
    this.s = ((TextView)this.a.findViewById(2131623999));
  }
  
  private boolean q()
  {
    return (!n.a().m()) && (n.a().d());
  }
  
  private BaseDialog r()
  {
    int i1 = this.w.size();
    if (i1 > 0) {
      return (BaseDialog)this.w.get(i1 - 1);
    }
    return null;
  }
  
  private void s()
  {
    t();
    u();
    com.baidu.carlife.view.g.e().a(this);
    com.baidu.carlife.view.g.e().a(this.t);
    TipTool.setToastinInterface(new v());
    t.a().a(this);
    com.baidu.carlife.core.screen.a.a.b().a(this);
  }
  
  private void t()
  {
    l locall = new l();
    locall.toGetRequest();
    locall.registerResponseListener(new e.a()
    {
      public void onNetWorkResponse(int paramAnonymousInt)
      {
        if (com.baidu.carlife.core.f.jr)
        {
          h.b(h.this).setVisibility(0);
          return;
        }
        h.b(h.this).setVisibility(8);
      }
    });
  }
  
  private void u()
  {
    this.g.setOnKeyListener(new com.baidu.carlife.core.screen.b.d(this.i, null));
    this.i.setOnKeyListener(new com.baidu.carlife.core.screen.b.d(this.m, this.g));
    this.m.setOnKeyListener(new com.baidu.carlife.core.screen.b.d(this.j, this.i));
    this.j.setOnKeyListener(new com.baidu.carlife.core.screen.b.d(this.h, this.m));
    this.h.setOnKeyListener(new com.baidu.carlife.core.screen.b.d(null, this.j));
  }
  
  private void v()
  {
    if (com.baidu.carlife.core.b.a.a()) {
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi")) {}
    for (localLayoutParams.type = 2005;; localLayoutParams.type = 2006)
    {
      localLayoutParams.format = -2;
      localLayoutParams.gravity = 112;
      localLayoutParams.systemUiVisibility = 5;
      localLayoutParams.verticalMargin = 0.0F;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.flags = 24;
      localWindowManager.addView(this.r, localLayoutParams);
      return;
    }
  }
  
  private com.baidu.carlife.view.dialog.e w()
  {
    if (this.v == null) {
      this.v = new com.baidu.carlife.view.dialog.e(com.baidu.carlife.core.a.a());
    }
    return this.v;
  }
  
  public void a()
  {
    if (this.s != null) {
      this.s.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a != null) {
      this.a.setBackgroundResource(paramInt);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.d.a(paramInt, paramBundle);
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.a != null) {
      this.a.setBackground(paramDrawable);
    }
  }
  
  public void a(Window paramWindow)
  {
    paramWindow = com.baidu.carlife.f.d.a();
    paramWindow.a(this.a);
    if (this.u == null)
    {
      this.u = new com.baidu.carlife.f.g(this.a, 1);
      this.u.d(this.g).d(this.i).d(this.m).d(this.j).d(this.h);
    }
    paramWindow.a(this.u);
  }
  
  public void a(String paramString)
  {
    this.s.setText(paramString);
    this.s.setVisibility(0);
  }
  
  public void a(String paramString, b paramb)
  {
    a(paramString, paramb, null);
  }
  
  public void a(String paramString, b paramb, com.baidu.carlife.core.screen.d paramd)
  {
    if ((this.v != null) && (isDialogShown()))
    {
      dismissDialog(this.v);
      this.v = null;
    }
    this.v = w();
    this.v.setOnDialogCancelListener(null);
    this.v.setOnCancelListener(null);
    if (!TextUtils.isEmpty(paramString)) {
      this.v.b(paramString);
    }
    if (paramb != null) {
      this.v.setOnCancelListener(paramb);
    }
    if (paramd != null) {
      this.v.setOnDialogCancelListener(paramd);
    }
    showDialog(this.v);
  }
  
  public void a(boolean paramBoolean)
  {
    if (com.baidu.carlife.core.b.a.a()) {}
    while ((this.r == null) || (this.r.getParent() == null)) {
      return;
    }
    ((WindowManager)this.b.getSystemService("window")).removeView(this.r);
    this.r = null;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(false);
      if (paramBoolean2) {
        com.baidu.carlife.core.screen.a.a.b().l();
      }
    }
  }
  
  public void b()
  {
    if (!com.baidu.carlife.core.c.a().h()) {}
    do
    {
      return;
      if (this.r != null)
      {
        this.r.setVisibility(0);
        return;
      }
      this.r = new RelativeLayout(this.b);
      this.r.setBackgroundColor(-16777216);
      ImageView localImageView = new ImageView(this.b);
      localImageView.setImageResource(2130838261);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.r.addView(localImageView, localLayoutParams);
      localImageView = new ImageView(this.b);
      localImageView.setImageResource(2130838282);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, 0, 0, com.baidu.carlife.core.d.a().c(20));
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      this.r.addView(localImageView, localLayoutParams);
    } while ((this.r == null) || (this.r.getParent() != null));
    v();
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
  }
  
  public void c()
  {
    dismissDialog(this.v);
  }
  
  public void c(boolean paramBoolean)
  {
    this.d.b(paramBoolean);
  }
  
  public void cancelDialog()
  {
    BaseDialog localBaseDialog = r();
    if (localBaseDialog != null) {
      cancelDialog(localBaseDialog);
    }
  }
  
  public void cancelDialog(BaseDialog paramBaseDialog)
  {
    a(paramBaseDialog, false);
  }
  
  public boolean d()
  {
    return (this.v != null) && (isDialogShown());
  }
  
  public void dismissDialog()
  {
    BaseDialog localBaseDialog = r();
    if (localBaseDialog != null) {
      dismissDialog(localBaseDialog);
    }
  }
  
  public void dismissDialog(BaseDialog paramBaseDialog)
  {
    a(paramBaseDialog, true);
  }
  
  public Context e()
  {
    return this.b;
  }
  
  public void f()
  {
    if (this.n == null) {
      return;
    }
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.b.getResources().getDrawable(2130837523);
    this.n.setBackground(localAnimationDrawable);
    localAnimationDrawable.start();
  }
  
  public void h()
  {
    this.d.j();
  }
  
  public void hideMapFragment()
  {
    this.d.f();
  }
  
  public void hideWindowView()
  {
    this.q.setVisibility(8);
    this.q.removeAllViews();
  }
  
  public void innerNameSearch(String paramString)
  {
    this.d.a(paramString);
  }
  
  public boolean isDialogShown()
  {
    return (this.o.isShown()) || (!this.w.isEmpty());
  }
  
  public boolean isWindowViewShown()
  {
    return this.q.isShown();
  }
  
  public boolean j()
  {
    if ((this.g == null) || (this.i == null) || (this.j == null) || (this.h == null) || (this.m == null)) {}
    while ((!this.g.hasFocus()) && (!this.i.hasFocus()) && (!this.j.hasFocus()) && (!this.h.hasFocus()) && (!this.m.hasFocus())) {
      return false;
    }
    return true;
  }
  
  public void k()
  {
    if (q())
    {
      i.b(c, "onVoiceClick: Idle");
      n.a().f();
      n.a().b(false);
      return;
    }
    n.a().e();
    if (n.a().c())
    {
      i.b(c, "onVoiceClick: Listening");
      n.a().k();
      return;
    }
    if (n.a().b())
    {
      i.b(c, "onVoiceClick: Processing");
      m.a().b();
      return;
    }
    if (n.a().m())
    {
      i.b(c, "onVoiceClick: Speeching");
      m.a().b();
      return;
    }
    i.b(c, "onVoiceClick: stopVoice");
    m.a().b();
  }
  
  public void l()
  {
    updateMainDisplayStatus(this.d.i());
  }
  
  public boolean m()
  {
    return (this.r != null) && (this.r.getParent() != null) && (this.r.getVisibility() == 0);
  }
  
  public void n()
  {
    if (com.baidu.carlife.core.screen.a.a.b().g())
    {
      com.baidu.carlife.core.screen.a.a.b().j();
      if (com.baidu.carlife.core.c.a().i()) {
        b();
      }
      while (!com.baidu.carlife.core.c.a().h()) {
        return;
      }
      com.baidu.carlife.core.screen.a.a.b().l();
      return;
    }
    com.baidu.carlife.core.screen.a.a.b().a(com.baidu.carlife.core.screen.a.a.b().h());
  }
  
  public void o()
  {
    if (this.r != null)
    {
      if (this.r.getVisibility() != 0) {
        break label40;
      }
      com.baidu.carlife.core.c.a().f(true);
    }
    for (;;)
    {
      this.r.setVisibility(8);
      com.baidu.carlife.core.screen.a.a.b().k();
      return;
      label40:
      com.baidu.carlife.core.c.a().f(false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131623996: 
    default: 
      return;
    case 2131623991: 
      performOpenHome();
      return;
    case 2131623992: 
      this.d.b();
      StatisticManager.onEvent("HOME_MENU_0001");
      return;
    case 2131623994: 
      this.d.d();
      StatisticManager.onEvent("HOME_MENU_0002");
      return;
    case 2131623995: 
      this.d.c();
      StatisticManager.onEvent("HOME_MENU_0003");
      return;
    }
    i.b(c, "click voic recognition btn");
    k();
  }
  
  public void openNavi()
  {
    this.d.e();
  }
  
  public void openNavi(Bundle paramBundle)
  {
    this.d.a(paramBundle);
  }
  
  public void openNaviFromOutSide(int paramInt, Bundle paramBundle)
  {
    this.d.b(paramInt, paramBundle);
  }
  
  public void performOpenHome()
  {
    this.d.a();
  }
  
  public void setBottomBarBackgroud(Drawable paramDrawable)
  {
    if (this.f != null) {
      this.f.setBackground(paramDrawable);
    }
  }
  
  public void setBottomBarStatus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.f != null) && (this.f.getVisibility() == 8)) {
        this.f.setVisibility(0);
      }
      if (this.l != null) {
        this.l.setVisibility(0);
      }
      if (this.k != null) {
        this.k.setVisibility(0);
      }
    }
    do
    {
      return;
      if ((this.f != null) && (this.f.getVisibility() == 0)) {
        this.f.setVisibility(8);
      }
      if (this.l != null) {
        this.l.setVisibility(8);
      }
    } while (this.k == null);
    this.k.setVisibility(8);
  }
  
  public boolean showConnectForbidDialog()
  {
    if (com.baidu.carlife.l.a.a().N())
    {
      com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(this.b).f(1);
      localc.q();
      localc.a(2131296531);
      localc.c(2131296264);
      showDialog(localc, BaseDialog.a.a);
      return true;
    }
    return false;
  }
  
  public void showDialog(BaseDialog paramBaseDialog)
  {
    showDialog(paramBaseDialog, BaseDialog.a.a);
  }
  
  public void showDialog(BaseDialog paramBaseDialog, BaseDialog.a parama)
  {
    if (paramBaseDialog == null) {
      return;
    }
    i.b("CarlifeViewWrapper", "showDialog=" + isDialogShown());
    if (this.w.contains(paramBaseDialog))
    {
      i.d(c, "showDialog childView is already exists.");
      return;
    }
    this.w.add(paramBaseDialog);
    i.b("Dialog", "Carlife's showDialog childView=" + paramBaseDialog + ", size=" + this.w.size());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (parama == BaseDialog.a.a) {
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      this.o.addView(paramBaseDialog, localLayoutParams);
      this.o.setVisibility(0);
      paramBaseDialog.a(this);
      return;
      if (parama == BaseDialog.a.c)
      {
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(15);
      }
      else if (parama == BaseDialog.a.d)
      {
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(15);
      }
      else
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(15);
      }
    }
  }
  
  public void showMapFragment()
  {
    this.d.g();
  }
  
  public void showWindowView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    i.b("CarlifeActivity", "showWindowView");
    this.q.removeAllViews();
    this.q.addView(paramView, paramLayoutParams);
    this.q.setVisibility(0);
  }
  
  public void startCalcRoute(com.baidu.carlife.core.screen.a parama)
  {
    this.d.b(parama);
  }
  
  public void updateGaussianBlurBackground()
  {
    if (com.baidu.carlife.core.screen.presentation.h.a().b()) {
      return;
    }
    a(2130838204);
  }
  
  public void updateMainDisplayStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4001: 
    case 4003: 
      b(paramInt);
      return;
    case 4002: 
      b(paramInt);
      return;
    }
    b(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */