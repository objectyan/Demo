package com.baidu.carlife.fragment;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.custom.elhyf.b;
import com.baidu.carlife.f.g;
import com.baidu.carlife.n.e;
import com.baidu.carlife.view.DiscoverCardView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;

@SuppressLint({"ValidFragment"})
public class HomeMoreFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private static final String a = "HomeMoreFragment";
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private DiscoverCardView g;
  private DiscoverCardView h;
  private DiscoverCardView i;
  private DiscoverCardView j;
  private a k;
  private g l;
  private g m;
  private b n;
  private boolean o = false;
  
  private void a()
  {
    i.b("HomeMoreFragment", "setupView");
    int i1;
    label273:
    int i2;
    if (com.baidu.carlife.l.a.a().N()) {
      if (this.o) {
        if (com.baidu.carlife.core.b.a.c())
        {
          this.g.a(2130838618);
          this.h.a(2130838620);
          this.i.a(2130838634);
          this.j.a(2130838630);
          this.g.a(getStringUtil(2131296521));
          this.h.a(getStringUtil(2131296525));
          this.i.a(getStringUtil(2131296528));
          this.j.a(getStringUtil(2131296518));
          this.g.b(getStringUtil(2131296524));
          this.h.b(getStringUtil(2131296526));
          this.i.b(getStringUtil(2131296529));
          this.j.b(getStringUtil(2131296520));
          this.g.setTagInt(3);
          this.h.setTagInt(4);
          this.i.setTagInt(1);
          this.j.setTagInt(5);
          this.n = new b()
          {
            public void a()
            {
              HomeMoreFragment.a(HomeMoreFragment.this);
            }
          };
          e.a().a(this.n);
          b();
          i1 = 4;
          if ((f.jx != f.a.k) && (f.jx != f.a.l)) {
            break label626;
          }
          this.g.a(getStringUtil(2131296522));
          i2 = i1;
          if (com.baidu.carlife.core.d.m())
          {
            this.g.a(2130838567);
            this.g.a(getStringUtil(2131296515));
            this.g.b(getStringUtil(2131296516));
            this.g.setTagInt(2);
            this.g.setEnabled(false);
            i2 = i1;
          }
          label337:
          if (i2 != 4) {
            break label703;
          }
          this.g.setVisibility(0);
          this.h.setVisibility(0);
          this.i.setVisibility(0);
          this.j.setVisibility(0);
        }
      }
    }
    label626:
    label703:
    do
    {
      return;
      this.g.a(2130838618);
      this.h.a(2130838620);
      this.g.a(getStringUtil(2131296521));
      this.h.a(getStringUtil(2131296525));
      this.g.b(getStringUtil(2131296524));
      this.h.b(getStringUtil(2131296526));
      this.g.setTagInt(3);
      this.h.setTagInt(4);
      i1 = 2;
      break;
      if (com.baidu.carlife.core.b.a.c())
      {
        this.g.a(2130838618);
        this.h.a(2130838634);
        this.g.a(getStringUtil(2131296521));
        this.h.a(getStringUtil(2131296528));
        this.g.b(getStringUtil(2131296524));
        this.h.b(getStringUtil(2131296529));
        this.g.setTagInt(3);
        this.h.setTagInt(1);
        i1 = 2;
        break;
      }
      this.g.a(2130838618);
      this.g.a(getStringUtil(2131296521));
      this.g.b(getStringUtil(2131296524));
      this.g.setTagInt(3);
      i1 = 1;
      break;
      if (f.jx != f.a.m) {
        break label273;
      }
      this.g.a(getStringUtil(2131296523));
      break label273;
      this.g.a(2130838567);
      this.g.a(getStringUtil(2131296515));
      this.g.b(getStringUtil(2131296516));
      this.g.setTagInt(2);
      i2 = 1;
      break label337;
      if (i2 == 3)
      {
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(4);
        return;
      }
      if (i2 == 2)
      {
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(4);
        this.j.setVisibility(4);
        return;
      }
    } while (i2 != 1);
    this.g.setVisibility(0);
    this.h.setVisibility(4);
    this.i.setVisibility(4);
    this.j.setVisibility(4);
  }
  
  private void b()
  {
    if (e.a().b())
    {
      this.j.setRedPointVisibility(0);
      return;
    }
    this.j.setRedPointVisibility(8);
  }
  
  private void c()
  {
    Object localObject = new c(true);
    ((c)localObject).c(65569);
    localObject = Message.obtain(null, ((c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.l.a.a().a((Message)localObject);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if ((paramString.equals(f.a.ab.a())) || (paramString.equals(f.a.aa.a()))) {
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      i1 = i2;
      if ((paramView instanceof DiscoverCardView)) {
        i1 = ((DiscoverCardView)paramView).getTagInt();
      }
    }
    switch (i1)
    {
    default: 
      return;
    case 1: 
      StatisticManager.onEvent("HOME_CARLIFE_003");
      showFragment(584, null);
      return;
    case 2: 
      StatisticManager.onEvent("HOME_CARLIFE_001");
      openWebView(3, 564, "活动专区", "http://carlife.baidu.com/carlife/act");
      return;
    case 3: 
      c();
      return;
    case 4: 
      showFragment(579, null);
      return;
    }
    if (com.baidu.carlife.core.b.a.c())
    {
      b.a().d();
      return;
    }
    e.a().c();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968768, null);
    setCommonTitleBar(paramLayoutInflater, "CarLife");
    this.g = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625359));
    this.h = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625360));
    this.i = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625361));
    this.j = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625362));
    this.g.setBackgroundResource(2131558793);
    this.h.setBackgroundResource(2131558793);
    this.i.setBackgroundResource(2131558793);
    this.j.setBackgroundResource(2131558793);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    if ((f.jx == f.a.ab) || (f.jx == f.a.aa)) {
      this.o = true;
    }
    this.k = new a(Looper.getMainLooper());
    k.a(this.k);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    e.a().a(null);
  }
  
  public void onInitFocusAreas()
  {
    if (getCurrentFragmentType() != 545) {
      return;
    }
    if (this.l == null)
    {
      this.l = new g(this.mContentView.findViewById(2131624259), 2);
      this.l.d(this.mContentView.findViewById(2131624258));
    }
    if (this.m == null)
    {
      this.m = new g(this.mContentView.findViewById(2131625358), 4);
      this.m.d(this.g).d(this.h).d(this.i).d(this.j);
    }
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.l, this.m });
    com.baidu.carlife.f.d.a().h(this.m);
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    setBottomBarStatus(true);
    a();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  private class a
    extends j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(3008);
      addMsg(16875523);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        if (HomeMoreFragment.this.isAdded())
        {
          HomeMoreFragment.b(HomeMoreFragment.this);
          return;
          paramMessage = (String)paramMessage.obj;
          if (paramMessage == null) {
            HomeMoreFragment.a(HomeMoreFragment.this, false);
          }
          while (HomeMoreFragment.this.isAdded())
          {
            HomeMoreFragment.b(HomeMoreFragment.this);
            return;
            if (HomeMoreFragment.this.a(paramMessage))
            {
              i.b("HomeMoreFragment", "is yuanfeng ELH");
              HomeMoreFragment.a(HomeMoreFragment.this, true);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeMoreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */