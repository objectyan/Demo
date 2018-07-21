package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.f.c;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.q.a;
import com.baidu.carlife.logic.q.b;
import com.baidu.carlife.logic.q.d;
import com.baidu.carlife.logic.q.g;
import com.baidu.carlife.model.n;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.CommonTipView.a;
import com.baidu.carlife.view.dialog.s;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.List;

public class PhoneFragment
  extends ContentFragment
  implements View.OnClickListener, View.OnTouchListener, q.b, q.d, q.g
{
  public static final String a = PhoneFragment.class.getSimpleName();
  private CommonTipView A;
  private View B;
  private View C;
  private View D;
  private View E;
  private ListView F;
  private ListView G;
  private com.baidu.carlife.adpter.a H;
  private com.baidu.carlife.adpter.m I;
  private PopupWindow J;
  private TextView K;
  private ImageButton L;
  private s M;
  private s N;
  private boolean O;
  private boolean P;
  private int Q;
  private q R;
  private boolean S;
  private com.baidu.carlife.f.d T;
  private com.baidu.carlife.f.g U;
  private a V;
  private String W = "";
  private CommonTipView.a X = new CommonTipView.a()
  {
    public void a()
    {
      e.a().b(PhoneFragment.this.getString(2131296859));
      PhoneFragment.d(PhoneFragment.this).i();
    }
  };
  private CommonTipView.a Y = new CommonTipView.a()
  {
    public void a()
    {
      e.a().b(PhoneFragment.this.getString(2131296859));
      PhoneFragment.d(PhoneFragment.this).h();
    }
  };
  private AdapterView.OnItemClickListener Z = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      PhoneFragment.i(PhoneFragment.this);
      paramAnonymousAdapterView = paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
      if ((paramAnonymousAdapterView instanceof com.baidu.carlife.model.m))
      {
        paramAnonymousAdapterView = (com.baidu.carlife.model.m)paramAnonymousAdapterView;
        StatisticManager.onEvent("1020", "1020");
        PhoneFragment.d(PhoneFragment.this).a(PhoneFragment.this.getContext(), paramAnonymousAdapterView.b);
      }
      while (!(paramAnonymousAdapterView instanceof n)) {
        return;
      }
      paramAnonymousAdapterView = (n)paramAnonymousAdapterView;
      StatisticManager.onEvent("1019", "1019");
      PhoneFragment.d(PhoneFragment.this).a(PhoneFragment.this.getContext(), paramAnonymousAdapterView.b);
    }
  };
  private AbsListView.OnScrollListener aa = new AbsListView.OnScrollListener()
  {
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (paramAnonymousAbsListView.equals(PhoneFragment.n(PhoneFragment.this))) {
        PhoneFragment.a(PhoneFragment.this, paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (!PhoneFragment.l(PhoneFragment.this)) && (PhoneFragment.g(PhoneFragment.this).isSelected()))
      {
        paramAnonymousAbsListView = (n)paramAnonymousAbsListView.getItemAtPosition(PhoneFragment.m(PhoneFragment.this));
        PhoneFragment.a(PhoneFragment.this, String.valueOf(paramAnonymousAbsListView.d));
        return;
      }
      PhoneFragment.i(PhoneFragment.this);
    }
  };
  private AbsListView.OnScrollListener ab = new AbsListView.OnScrollListener()
  {
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (paramAnonymousAbsListView.equals(PhoneFragment.n(PhoneFragment.this))) {
        PhoneFragment.a(PhoneFragment.this, paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
  };
  private q.a ac = new q.a()
  {
    public void a() {}
    
    public void a(int paramAnonymousInt) {}
    
    public void b()
    {
      PhoneFragment.o(PhoneFragment.this).setSelected(true);
    }
    
    public void c()
    {
      PhoneFragment.o(PhoneFragment.this).setSelected(false);
    }
  };
  private List<n> b;
  private List<com.baidu.carlife.model.m> c;
  private CommonTipView d;
  private RelativeLayout e;
  private RelativeLayout f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private ImageButton m;
  private ImageButton n;
  private ViewGroup o;
  private View p;
  private AbsListView q;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private boolean x = true;
  private boolean y = true;
  private View z;
  
  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView.getChildAt(0) == null) {}
    do
    {
      return;
      if ((this.r != 0) && (this.t != 0) && (this.w == paramInt3)) {
        break;
      }
      this.w = paramInt3;
      this.t = paramAbsListView.getHeight();
      this.v = paramAbsListView.getChildAt(0).getHeight();
      this.u = (this.v * this.w - 10);
      this.r = this.o.getHeight();
    } while (this.r == 0);
    ViewGroup.LayoutParams localLayoutParams = this.p.getLayoutParams();
    this.s = (this.t * this.r / this.w / this.v);
    paramInt2 = com.baidu.carlife.core.d.a().c(12);
    if (this.s < paramInt2)
    {
      this.r -= paramInt2 - this.s;
      this.s = paramInt2;
    }
    localLayoutParams.height = this.s;
    this.p.setLayoutParams(localLayoutParams);
    paramInt2 = -(this.v * paramInt1 - paramAbsListView.getChildAt(0).getTop()) * this.r / this.u;
    if (paramInt2 == 0)
    {
      if (this.x)
      {
        this.x = false;
        this.m.setImageResource(2130838314);
        this.m.setEnabled(false);
      }
      if (this.y) {
        if (-(this.r - this.s - 2) >= 0)
        {
          this.y = false;
          this.n.setImageResource(2130838306);
          this.n.setEnabled(false);
        }
      }
    }
    for (;;)
    {
      this.Q = paramInt1;
      this.o.scrollTo(0, paramInt2);
      return;
      if (-(this.r - this.s - 2) < 0)
      {
        this.y = true;
        this.n.setImageResource(2130838305);
        this.n.setEnabled(true);
        continue;
        if (paramInt2 <= -(this.r - this.s - 2))
        {
          if (this.y)
          {
            this.y = false;
            this.n.setImageResource(2130838306);
            this.n.setEnabled(false);
          }
          if ((paramInt2 != 0) && (!this.x))
          {
            this.x = true;
            this.m.setImageResource(2130838313);
            this.m.setEnabled(true);
          }
        }
        else
        {
          if (!this.x)
          {
            this.x = true;
            this.m.setImageResource(2130838313);
            this.m.setEnabled(true);
          }
          if (!this.y)
          {
            this.y = true;
            this.n.setImageResource(2130838305);
            this.n.setEnabled(true);
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.J == null)
    {
      this.K = new TextView(getContext());
      this.K.setBackground(r.b(2130839270));
      this.K.setTextColor(r.a(2131558701));
      this.K.setTextSize(40.0F);
      this.K.setGravity(17);
      int i1 = getResources().getDimensionPixelSize(2131361814);
      this.J = new PopupWindow(this.K, i1, i1, false);
      this.J.setOutsideTouchable(true);
    }
    this.K.setText(paramString);
    if (this.J.isShowing()) {
      this.J.update();
    }
    for (;;)
    {
      this.V.removeMessages(2028);
      this.V.sendEmptyMessageDelayed(2028, 1500L);
      return;
      this.J.showAtLocation(this.mContentView, 17, 0, 0);
    }
  }
  
  private void d()
  {
    if (this.M == null) {
      this.M = new s(com.baidu.carlife.core.a.a(), false);
    }
    showDialog(this.M, BaseDialog.a.b);
  }
  
  private void e()
  {
    if (this.N == null) {
      this.N = new s(com.baidu.carlife.core.a.a(), true);
    }
    showDialog(this.N, BaseDialog.a.b);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.l != null) {
        this.l.setVisibility(0);
      }
    }
    while (this.l == null) {
      return;
    }
    this.l.setVisibility(4);
  }
  
  private void f()
  {
    if (isDialogShown()) {
      dismissDialog(this.M);
    }
  }
  
  private void g()
  {
    if (isDialogShown()) {
      dismissDialog(this.N);
    }
  }
  
  private void h()
  {
    if ((this.J != null) && (this.J.isShowing())) {
      this.J.dismiss();
    }
  }
  
  private void i()
  {
    c localc;
    if (this.D.isSelected())
    {
      localc = new c(this.F, 4);
      if (this.A.getVisibility() != 0) {
        break label107;
      }
      com.baidu.carlife.f.g localg = new com.baidu.carlife.f.g(this.A, 4);
      localg.d(this.A.getFocusView());
      this.T.b(new com.baidu.carlife.f.a[] { this.U, localg });
    }
    for (;;)
    {
      if (!com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) {
        break label133;
      }
      return;
      localc = new c(this.G, 4);
      break;
      label107:
      this.T.b(new com.baidu.carlife.f.a[] { this.U, localc });
    }
    label133:
    if (this.A.getVisibility() == 0)
    {
      this.T.h(this.U);
      return;
    }
    this.T.h(localc);
    localc.e();
  }
  
  public void a()
  {
    Chronometer localChronometer = (Chronometer)this.mContentView.findViewById(2131625076);
    localChronometer.setVisibility(0);
    localChronometer.setBase(SystemClock.elapsedRealtime());
    localChronometer.start();
    this.mContentView.findViewById(2131625075).setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    this.z.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    Chronometer localChronometer = (Chronometer)this.mContentView.findViewById(2131625076);
    localChronometer.setVisibility(8);
    localChronometer.stop();
    this.W = "";
    this.mContentView.findViewById(2131625080).setVisibility(8);
    this.mContentView.findViewById(2131625075).setVisibility(8);
    f();
    g();
    onInitFocusAreas();
  }
  
  public void b()
  {
    if (!this.D.isSelected()) {
      return;
    }
    h();
    dismissDialog();
    if ((this.R.e() != null) && (!this.R.e().isEmpty())) {}
    try
    {
      this.c.clear();
      this.c.addAll(this.R.e());
      if (this.c.isEmpty())
      {
        this.A.setVisibility(0);
        this.A.b(2131296827);
        this.A.a(true);
        this.A.setCommonTipCallBack(this.X);
        this.F.setEmptyView(this.A);
        this.H.notifyDataSetChanged();
        onInitFocusAreas();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.A.setVisibility(8);
        this.H.a(this.c);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.z.setVisibility(8);
    if (paramBoolean)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      ((TextView)this.mContentView.findViewById(2131625069)).setText(this.R.a());
    }
    for (;;)
    {
      f();
      g();
      onInitFocusAreas();
      return;
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.d.a();
      this.mContentView.findViewById(2131625080).setVisibility(8);
    }
  }
  
  public void c()
  {
    if (!this.E.isSelected()) {
      return;
    }
    h();
    dismissDialog(this.N);
    dismissDialog(this.M);
    e.a().c();
    if ((this.R.d() != null) && (!this.R.d().isEmpty()))
    {
      this.b.clear();
      this.b.addAll(this.R.d());
    }
    if (this.b.isEmpty())
    {
      this.A.setVisibility(0);
      this.A.b(2131296829);
      this.A.a(true);
      this.A.setCommonTipCallBack(this.Y);
      this.G.setEmptyView(this.A);
    }
    for (;;)
    {
      this.I.notifyDataSetChanged();
      onInitFocusAreas();
      return;
      this.A.setVisibility(8);
      this.I.a(this.b);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.z.setVisibility(8);
    String str;
    if (paramBoolean)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      TextView localTextView = (TextView)this.mContentView.findViewById(2131625074);
      if (TextUtils.isEmpty(this.W))
      {
        str = this.R.a();
        this.W = str;
        localTextView.setText(this.W);
        this.j.setSelected(false);
        if ((this.R.j()) || (this.mContentView.findViewById(2131625076).isShown())) {
          break label153;
        }
        this.mContentView.findViewById(2131625075).setVisibility(0);
      }
    }
    for (;;)
    {
      f();
      g();
      onInitFocusAreas();
      return;
      str = this.W;
      break;
      label153:
      this.mContentView.findViewById(2131625075).setVisibility(8);
      continue;
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.d.a();
      this.mContentView.findViewById(2131625080).setVisibility(8);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.mContentView.findViewById(2131625080);
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      return;
    }
  }
  
  public void driving()
  {
    if (com.baidu.carlife.custom.b.a().b()) {
      e(true);
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
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        if (!this.O)
        {
          this.B.setBackgroundResource(2130838409);
          this.C.setBackground(com.baidu.carlife.view.a.b.d(mActivity));
        }
        this.F.setVisibility(0);
        this.G.setVisibility(8);
        paramView = this.E;
        this.P = false;
        paramView.setSelected(false);
        paramView = this.D;
        this.O = true;
        paramView.setSelected(true);
        this.q = this.F;
        this.F.scrollBy(0, 1);
        this.F.scrollBy(0, -1);
        this.mContentView.findViewById(2131625063).setVisibility(0);
        this.mContentView.findViewById(2131625060).setVisibility(8);
        b();
        return;
        if (!this.P)
        {
          this.B.setBackground(com.baidu.carlife.view.a.b.d(mActivity));
          this.C.setBackgroundResource(2130838409);
        }
        this.F.setVisibility(8);
        this.G.setVisibility(0);
        paramView = this.D;
        this.O = false;
        paramView.setSelected(false);
        this.q = this.G;
        this.G.scrollBy(0, 1);
        this.G.scrollBy(0, -1);
        paramView = this.E;
        this.P = true;
        paramView.setSelected(true);
        this.mContentView.findViewById(2131625063).setVisibility(8);
        this.mContentView.findViewById(2131625060).setVisibility(0);
        c();
        return;
        d();
        return;
        this.R.a(getContext());
        return;
        this.R.m();
        return;
        this.R.l();
        return;
        e();
        return;
      } while (this.v == 0);
      i1 = this.t / this.v;
      this.q.smoothScrollToPositionFromTop(this.Q - i1, -1);
      return;
    } while (this.v == 0);
    int i1 = this.t / this.v;
    this.q.smoothScrollToPositionFromTop(this.Q + i1, -1);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968792, null);
    this.c = new ArrayList();
    this.b = new ArrayList();
    this.R = q.f();
    this.R.a(this);
    this.R.a(this);
    this.R.a(this);
    this.R.a(this.ac);
    this.z = this.mContentView.findViewById(2131625057);
    this.A = ((CommonTipView)this.mContentView.findViewById(2131623981));
    this.B = this.mContentView.findViewById(2131625061);
    this.B.setOnClickListener(this);
    this.B.setBackground(com.baidu.carlife.view.a.b.d(mActivity));
    this.D = this.mContentView.findViewById(2131625062);
    paramLayoutInflater = this.D;
    this.O = true;
    paramLayoutInflater.setSelected(true);
    this.F = ((ListView)this.mContentView.findViewById(2131625065));
    this.F.setOverScrollMode(2);
    this.H = new com.baidu.carlife.adpter.a(getContext());
    this.F.setOnItemClickListener(this.Z);
    this.F.setOnScrollListener(this.ab);
    this.F.setOnTouchListener(this);
    this.F.setAdapter(this.H);
    this.F.setVisibility(0);
    this.C = this.mContentView.findViewById(2131625058);
    this.C.setOnClickListener(this);
    this.C.setBackgroundResource(2130838409);
    this.E = this.mContentView.findViewById(2131625059);
    paramLayoutInflater = this.E;
    this.P = false;
    paramLayoutInflater.setSelected(false);
    this.G = ((ListView)this.mContentView.findViewById(2131625066));
    this.G.setVisibility(8);
    this.G.setOverScrollMode(2);
    this.G.setOnItemClickListener(this.Z);
    this.G.setOnScrollListener(this.aa);
    this.G.setOnTouchListener(this);
    this.q = this.G;
    this.I = new com.baidu.carlife.adpter.m(getContext());
    this.G.setAdapter(this.I);
    this.G.setVisibility(8);
    this.l = this.mContentView.findViewById(2131624054);
    if (com.baidu.carlife.custom.a.a().b()) {
      this.l.setVisibility(0);
    }
    if (com.baidu.carlife.custom.b.a().b()) {
      e(h.a().getNaviFragmentManager().isDriving());
    }
    this.o = ((ViewGroup)this.mContentView.findViewById(2131624056));
    this.p = this.mContentView.findViewById(2131624057);
    this.m = ((ImageButton)this.mContentView.findViewById(2131624055));
    this.n = ((ImageButton)this.mContentView.findViewById(2131624058));
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.L = ((ImageButton)this.mContentView.findViewById(2131625064));
    this.L.setOnClickListener(this);
    this.L.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.d = ((CommonTipView)this.mContentView.findViewById(2131625067));
    this.d.a(2131296841, 2130838260);
    this.e = ((RelativeLayout)this.mContentView.findViewById(2131625068));
    this.f = ((RelativeLayout)this.mContentView.findViewById(2131625073));
    this.g = this.mContentView.findViewById(2131625072);
    this.g.setOnClickListener(this);
    this.h = this.mContentView.findViewById(2131625077);
    this.h.setOnClickListener(this);
    this.i = this.mContentView.findViewById(2131625071);
    this.i.setOnClickListener(this);
    this.j = this.mContentView.findViewById(2131625078);
    this.j.setOnClickListener(this);
    this.k = this.mContentView.findViewById(2131625079);
    this.k.setOnClickListener(this);
    b();
    switch (this.R.c())
    {
    default: 
      a(this.R.b());
    }
    for (;;)
    {
      this.V = new a(null);
      k.a(this.V);
      return this.mContentView;
      b(this.R.b());
      continue;
      c(this.R.b());
      a();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    i.b(a);
    this.S = paramBoolean;
    if (paramBoolean) {
      h();
    }
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.T == null) {
      this.T = com.baidu.carlife.f.d.a();
    }
    if (this.U == null)
    {
      this.U = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624634), 2);
      this.U.d(this.B).d(this.C).d(this.L);
      this.U.b(this.B);
    }
    if (this.R.b())
    {
      switch (this.R.c())
      {
      default: 
        i();
        return;
      case 1: 
        localg = new com.baidu.carlife.f.g(this.e, 4);
        localg.d(this.i).d(this.g);
        localg.b(this.i);
        this.T.b(new com.baidu.carlife.f.a[] { this.U, localg });
        this.T.h(localg);
        return;
      }
      com.baidu.carlife.f.g localg = new com.baidu.carlife.f.g(this.f, 4);
      localg.d(this.j).d(this.h).d(this.k);
      localg.b(this.h);
      this.T.b(new com.baidu.carlife.f.a[] { this.U, localg });
      this.T.h(localg);
      return;
    }
    i();
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    i.b(a);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((com.baidu.carlife.custom.a.a().b()) || (com.baidu.carlife.custom.b.a().b())) && (paramMotionEvent.getAction() == 2) && (h.a().getNaviFragmentManager().isDriving())) {
      paramMotionEvent.setAction(0);
    }
    return false;
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    i.b(a, "Voice CMD: [" + paramString1 + "][" + paramString2 + "]");
    if (paramString2.equals("contacts"))
    {
      onClick(this.C);
      return true;
    }
    if (paramString2.equals("通话记录"))
    {
      onClick(this.B);
      return true;
    }
    return false;
  }
  
  public void stopDriving()
  {
    if (com.baidu.carlife.custom.b.a().b()) {
      e(false);
    }
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(4001);
      addMsg(4004);
      addMsg(4003);
      addMsg(2026);
      addMsg(2027);
      addMsg(16875523);
      addMsg(1040);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      try
      {
        switch (paramMessage.what)
        {
        case 4001: 
        case 4003: 
        case 4004: 
          PhoneFragment.a(PhoneFragment.this);
          PhoneFragment.b(PhoneFragment.this);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        i.e(PhoneFragment.a, "handler in phonefragment get exception");
        paramMessage.printStackTrace();
        return;
      }
      if (PhoneFragment.c(PhoneFragment.this) != null)
      {
        if ((PhoneFragment.c(PhoneFragment.this) == null) || (!PhoneFragment.this.isDialogShown())) {
          break label591;
        }
        paramMessage = PhoneFragment.c(PhoneFragment.this).getInputString();
        if (TextUtils.isEmpty(paramMessage)) {
          break label591;
        }
        PhoneFragment.d(PhoneFragment.this).a(PhoneFragment.this.getContext(), paramMessage);
        PhoneFragment.a(PhoneFragment.this);
      }
      switch (PhoneFragment.d(PhoneFragment.this).c())
      {
      case 0: 
        i.b(PhoneFragment.a, "current status is CALL_STATE_IDLE");
        if ((PhoneFragment.e(PhoneFragment.this).isSelected()) && (PhoneFragment.f(PhoneFragment.this).hasFocus()))
        {
          paramMessage = (com.baidu.carlife.model.m)PhoneFragment.f(PhoneFragment.this).getSelectedItem();
          PhoneFragment.d(PhoneFragment.this).a(PhoneFragment.this.getContext(), paramMessage.b);
          return;
        }
        if ((PhoneFragment.g(PhoneFragment.this).isSelected()) && (PhoneFragment.h(PhoneFragment.this).hasFocus()))
        {
          paramMessage = (n)PhoneFragment.h(PhoneFragment.this).getSelectedItem();
          PhoneFragment.d(PhoneFragment.this).a(PhoneFragment.this.getContext(), paramMessage.b);
          return;
        }
      case 1: 
        i.b(PhoneFragment.a, "current status is CALL_STATE_RINGING");
        PhoneFragment.d(PhoneFragment.this).m();
        return;
      case 2: 
        i.b(PhoneFragment.a, "current status is CALL_STATE_OFFHOOK");
        return;
        PhoneFragment.d(PhoneFragment.this).a(BaseFragment.mActivity);
        return;
        PhoneFragment.i(PhoneFragment.this);
        return;
        if ((String)paramMessage.obj == null)
        {
          if (PhoneFragment.j(PhoneFragment.this) != null) {
            PhoneFragment.j(PhoneFragment.this).setVisibility(4);
          }
        }
        else if (com.baidu.carlife.custom.a.a().b())
        {
          if (PhoneFragment.j(PhoneFragment.this) != null) {
            PhoneFragment.j(PhoneFragment.this).setVisibility(0);
          }
        }
        else if (com.baidu.carlife.custom.b.a().b())
        {
          boolean bool = h.a().getNaviFragmentManager().isDriving();
          PhoneFragment.a(PhoneFragment.this, bool);
          return;
          if (PhoneFragment.c(PhoneFragment.this) != null) {
            PhoneFragment.c(PhoneFragment.this).a(true);
          }
          if (PhoneFragment.k(PhoneFragment.this) != null)
          {
            PhoneFragment.k(PhoneFragment.this).a(true);
            return;
            if (PhoneFragment.c(PhoneFragment.this) != null) {
              PhoneFragment.c(PhoneFragment.this).a(false);
            }
            if (PhoneFragment.k(PhoneFragment.this) != null)
            {
              PhoneFragment.k(PhoneFragment.this).a(false);
              return;
            }
          }
        }
        label591:
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/PhoneFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */