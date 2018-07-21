package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.j;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.LoadMoreFooter;
import com.baidu.carlife.view.a.b;
import com.baidu.carlife.view.dialog.f;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.NaviAccountUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeDiscoverFoodFragment
  extends ContentFragment
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String c = HomeDiscoverFoodFragment.class.getSimpleName();
  private static final int d = 0;
  private static final int e = 1;
  private ListView f;
  private LoadMoreFooter g;
  private f h;
  private CommonTipView i;
  private ImageButton j;
  private boolean k;
  private j l;
  private com.baidu.carlife.k.h m;
  private List<com.baidu.carlife.model.e> n;
  private List<com.baidu.carlife.model.e> o;
  private com.baidu.carlife.adpter.c p;
  private int q = 0;
  private g r;
  private com.baidu.carlife.f.c s;
  private int t = 0;
  private e.a u = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      if (!HomeDiscoverFoodFragment.this.isAdded()) {}
      do
      {
        return;
        if (paramAnonymousInt == 0)
        {
          List localList = HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this).a();
          if ((localList != null) && (localList.size() > 0))
          {
            HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).a(HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this).a());
            HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).notifyDataSetChanged();
            HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, 0);
            HomeDiscoverFoodFragment.this.onInitFocusAreas();
          }
        }
      } while (!HomeDiscoverFoodFragment.c(HomeDiscoverFoodFragment.this));
      HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, false);
      HomeDiscoverFoodFragment.d(HomeDiscoverFoodFragment.this).toPostRequest();
    }
  };
  private e.a v = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      if (HomeDiscoverFoodFragment.d(HomeDiscoverFoodFragment.this).b() == 0)
      {
        HomeDiscoverFoodFragment.e(HomeDiscoverFoodFragment.this).setFooterDividersEnabled(false);
        HomeDiscoverFoodFragment.f(HomeDiscoverFoodFragment.this).setStatus(0);
        switch (paramAnonymousInt)
        {
        }
      }
      do
      {
        return;
        HomeDiscoverFoodFragment.e(HomeDiscoverFoodFragment.this).setFooterDividersEnabled(true);
        HomeDiscoverFoodFragment.f(HomeDiscoverFoodFragment.this).setStatus(1);
        break;
        if (HomeDiscoverFoodFragment.g(HomeDiscoverFoodFragment.this) == null) {
          HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, new ArrayList());
        }
        HomeDiscoverFoodFragment.h(HomeDiscoverFoodFragment.this).setVisibility(0);
        HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, HomeDiscoverFoodFragment.g(HomeDiscoverFoodFragment.this).size());
        HomeDiscoverFoodFragment.g(HomeDiscoverFoodFragment.this).addAll(HomeDiscoverFoodFragment.d(HomeDiscoverFoodFragment.this).a());
        if (HomeDiscoverFoodFragment.i(HomeDiscoverFoodFragment.this) == 0)
        {
          HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).b(HomeDiscoverFoodFragment.g(HomeDiscoverFoodFragment.this));
          HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).notifyDataSetChanged();
          HomeDiscoverFoodFragment.this.onInitFocusAreas();
          return;
        }
        HomeDiscoverFoodFragment.j(HomeDiscoverFoodFragment.this);
        return;
        if (HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).isEmpty())
        {
          HomeDiscoverFoodFragment.k(HomeDiscoverFoodFragment.this).a(1);
          HomeDiscoverFoodFragment.e(HomeDiscoverFoodFragment.this).setEmptyView(HomeDiscoverFoodFragment.k(HomeDiscoverFoodFragment.this));
          HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, 0);
          HomeDiscoverFoodFragment.this.onInitFocusAreas();
          return;
        }
        w.a(2131296385, 0);
        return;
      } while (!HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).isEmpty());
      HomeDiscoverFoodFragment.k(HomeDiscoverFoodFragment.this).a(0);
      HomeDiscoverFoodFragment.e(HomeDiscoverFoodFragment.this).setEmptyView(HomeDiscoverFoodFragment.k(HomeDiscoverFoodFragment.this));
      HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, 0);
      HomeDiscoverFoodFragment.this.onInitFocusAreas();
    }
  };
  private Comparator<com.baidu.carlife.model.e> w = new Comparator()
  {
    public int a(com.baidu.carlife.model.e paramAnonymouse1, com.baidu.carlife.model.e paramAnonymouse2)
    {
      if (paramAnonymouse2.B.compareTo(paramAnonymouse1.B) != 0) {
        return paramAnonymouse2.B.compareTo(paramAnonymouse1.B);
      }
      return paramAnonymouse1.n.compareTo(paramAnonymouse2.n);
    }
  };
  private AdapterView.OnItemClickListener x = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (paramAnonymousLong < 0L) {
        if ((HomeDiscoverFoodFragment.f(HomeDiscoverFoodFragment.this).a()) && (HomeDiscoverFoodFragment.d(HomeDiscoverFoodFragment.this) != null)) {
          HomeDiscoverFoodFragment.d(HomeDiscoverFoodFragment.this).toPostRequest();
        }
      }
      do
      {
        return;
        paramAnonymousAdapterView = paramAnonymousAdapterView.getItemAtPosition((int)paramAnonymousLong);
      } while (paramAnonymousAdapterView == null);
      paramAnonymousView = new Bundle();
      paramAnonymousView.putSerializable("model", (Serializable)paramAnonymousAdapterView);
      HomeDiscoverFoodFragment.this.showFragment(560, paramAnonymousView);
    }
  };
  
  private void a()
  {
    if (this.o == null) {
      this.o = new ArrayList();
    }
    if (this.n != null)
    {
      this.o.clear();
      this.o.addAll(this.n);
      Collections.sort(this.o, this.w);
      this.p.b(this.o);
      this.p.notifyDataSetChanged();
      this.t = 0;
      onInitFocusAreas();
    }
  }
  
  private void b()
  {
    if ((this.h != null) && (this.h.isShown())) {
      this.h.d();
    }
  }
  
  public void driving()
  {
    i.b("yftech", "HomeDiscoverFoodFragment driving");
    com.baidu.carlife.core.screen.presentation.a.e.a().c();
    b();
    back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968765, null);
    setCommonTitleBar(paramLayoutInflater, getResources().getStringArray(2131230725)[2]);
    ((TextView)paramLayoutInflater.findViewById(2131624262)).setText(2131296513);
    Object localObject = getResources().getStringArray(2131230726);
    localObject = new com.baidu.carlife.adpter.r(getContext(), (String[])localObject);
    this.h = new f(getContext(), 2131296378, (BaseAdapter)localObject, new a(null));
    this.h.setSelected(0);
    this.j = ((ImageButton)paramLayoutInflater.findViewById(2131624264));
    this.j.setVisibility(8);
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HomeDiscoverFoodFragment.this.showDialog(HomeDiscoverFoodFragment.l(HomeDiscoverFoodFragment.this), BaseDialog.a.b);
      }
    });
    this.i = ((CommonTipView)paramLayoutInflater.findViewById(2131623981));
    this.i.b(2131296457);
    this.f = ((ListView)paramLayoutInflater.findViewById(2131624353));
    this.f.setOverScrollMode(2);
    this.f.setFooterDividersEnabled(false);
    this.g = new LoadMoreFooter(getContext());
    this.f.addFooterView(this.g);
    this.p = new com.baidu.carlife.adpter.c(getContext(), this);
    this.f.setAdapter(this.p);
    this.f.setOnItemClickListener(this.x);
    com.baidu.carlife.core.screen.presentation.a.e.a().b(getString(2131296859));
    this.k = true;
    this.l = new j();
    this.l.registerResponseListener(this.u);
    this.m = new com.baidu.carlife.k.h();
    this.m.registerResponseListener(this.v);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.baidu.carlife.logic.h.b = false;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.l != null) {
      this.l.cancel();
    }
    if (this.m != null) {
      this.m.cancel();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      setBottomBarStatus(false);
    }
    super.onHiddenChanged(paramBoolean);
    if ((NaviAccountUtils.getInstance().isLogin()) && (!paramBoolean))
    {
      i.b(c, "onHiddenChanged NetWork UserQueueRequest");
      this.l.toPostRequest();
    }
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.r == null)
    {
      this.r = new g(this.mContentView.findViewById(2131623980), 2);
      this.r.d(this.mContentView.findViewById(2131624258)).d(this.j);
    }
    if (this.s == null) {
      this.s = new com.baidu.carlife.f.c(this.f, 6);
    }
    if (this.p.isEmpty())
    {
      d.a().b(new com.baidu.carlife.f.a[] { this.r });
      d.a().h(this.r);
      return;
    }
    this.f.setSelection(this.t);
    d.a().b(new com.baidu.carlife.f.a[] { this.r, this.s });
    d.a().h(this.s);
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    if (NaviAccountUtils.getInstance().isLogin())
    {
      i.b(c, "onResume NetWork UserQueueRequest");
      this.l.toPostRequest();
    }
    for (;;)
    {
      if (com.baidu.carlife.logic.h.c) {
        this.f.setSelection(0);
      }
      com.baidu.carlife.logic.h.c = false;
      return;
      if (this.k)
      {
        this.k = false;
        this.m.toPostRequest();
      }
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
    this.j.setBackground(b.a(mActivity));
    this.j.setImageDrawable(com.baidu.carlife.util.r.b(2130838320));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving()
  {
    i.b("yftech", "HomeDiscoverFoodFragment stopDriving");
  }
  
  private class a
    implements AdapterView.OnItemClickListener
  {
    private a() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      HomeDiscoverFoodFragment.this.dismissDialog(HomeDiscoverFoodFragment.l(HomeDiscoverFoodFragment.this));
      HomeDiscoverFoodFragment.l(HomeDiscoverFoodFragment.this).setSelected(paramInt);
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        if (HomeDiscoverFoodFragment.i(HomeDiscoverFoodFragment.this) != 0)
        {
          HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).b(HomeDiscoverFoodFragment.g(HomeDiscoverFoodFragment.this));
          HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this).notifyDataSetChanged();
          HomeDiscoverFoodFragment.a(HomeDiscoverFoodFragment.this, 0);
          HomeDiscoverFoodFragment.this.onInitFocusAreas();
        }
        HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this, 0);
        return;
      }
      if (HomeDiscoverFoodFragment.i(HomeDiscoverFoodFragment.this) != 1) {
        HomeDiscoverFoodFragment.j(HomeDiscoverFoodFragment.this);
      }
      HomeDiscoverFoodFragment.b(HomeDiscoverFoodFragment.this, 1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeDiscoverFoodFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */