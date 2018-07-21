package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;

public class HomeDiscoverParkListFragment
  extends ContentFragment
  implements e.a
{
  private TextView a;
  private TextView b;
  private ListView c;
  private com.baidu.carlife.k.k d;
  private CommonTipView e;
  private com.baidu.carlife.adpter.e f;
  private com.baidu.carlife.f.g g;
  private c h;
  private a i;
  
  private void a()
  {
    if ((com.baidu.carlife.custom.b.a().b()) && (com.baidu.carlife.core.screen.presentation.a.e.a().d())) {
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
    }
  }
  
  private boolean b()
  {
    if (com.baidu.carlife.e.a.a().f())
    {
      String str = com.baidu.carlife.e.a.a().d();
      i.c("Framework", "cities=" + str + ", focusUI=" + com.baidu.carlife.logic.g.a().c());
      DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
      i.c("Framework", "DistrictInfo=" + localDistrictInfo);
      if ((!com.baidu.carlife.logic.g.a().c()) && (str.contains(String.valueOf(localDistrictInfo.mId)))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean c()
  {
    if ((!com.baidu.carlife.l.a.a().N()) && (com.baidu.carlife.e.a.a().g()))
    {
      String str = com.baidu.carlife.e.a.a().e();
      i.c("Framework", "cities=" + str + ", focusUI=" + com.baidu.carlife.logic.g.a().c());
      DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
      i.c("Framework", "DistrictInfo=" + localDistrictInfo);
      if ((!com.baidu.carlife.logic.g.a().c()) && (str.contains(String.valueOf(localDistrictInfo.mId)))) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if ((this.b == null) || (this.a == null)) {
      return;
    }
    if (c()) {
      this.a.setVisibility(0);
    }
    while (com.baidu.carlife.l.a.a().N())
    {
      this.b.setVisibility(8);
      return;
      this.a.setVisibility(8);
    }
    if (b())
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void driving()
  {
    i.b("yftech", "HomeDiscoverFragment driving");
    a();
    back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    setBottomBarStatus(false);
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2130968767, null);
    setCommonTitleBar(paramLayoutInflater, getResources().getStringArray(2131230725)[0]);
    ((TextView)paramLayoutInflater.findViewById(2131624262)).setText("");
    this.c = ((ListView)paramLayoutInflater.findViewById(2131624353));
    this.c.setOverScrollMode(2);
    this.c.setHeaderDividersEnabled(false);
    this.e = ((CommonTipView)paramLayoutInflater.findViewById(2131623981));
    this.e.a(2131296458, 2130838307);
    if (BNLocationManagerProxy.getInstance().getCurLocation() != null)
    {
      com.baidu.carlife.core.screen.presentation.a.e.a().b(getString(2131296859));
      this.d = new com.baidu.carlife.k.k();
      this.d.registerResponseListener(this);
      this.d.toPostRequest();
    }
    for (;;)
    {
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (HomeDiscoverParkListFragment.a(HomeDiscoverParkListFragment.this) != null)
          {
            StatisticManager.onEvent("DISCOVER_ZCW_0002", "DISCOVER_ZCW_0002");
            paramAnonymousAdapterView = HomeDiscoverParkListFragment.a(HomeDiscoverParkListFragment.this).a(paramAnonymousInt);
            if (paramAnonymousAdapterView != null) {
              HomeDiscoverParkListFragment.this.startCalcRoute(paramAnonymousAdapterView);
            }
          }
        }
      });
      this.a = ((TextView)paramLayoutInflater.findViewById(2131624916));
      this.a.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
      this.a.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (HomeDiscoverParkListFragment.b(HomeDiscoverParkListFragment.this))
          {
            HomeDiscoverParkListFragment.this.openWebView(4, 566, HomeDiscoverParkListFragment.this.getStringUtil(2131297509), "http://119.147.84.47:886/baidu/login.html");
            return;
          }
          w.a("当前城市，暂不支持该服务", 0);
        }
      });
      this.b = ((TextView)paramLayoutInflater.findViewById(2131624917));
      this.b.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
      this.b.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (HomeDiscoverParkListFragment.c(HomeDiscoverParkListFragment.this))
          {
            StatisticManager.onEvent("DISCOVER_ETCP_0001");
            HomeDiscoverParkListFragment.this.openWebView(1, 562, HomeDiscoverParkListFragment.this.getStringUtil(2131297511), "http://carlife.etcp.cn/index/index");
            return;
          }
          w.a("当前城市，暂不支持该服务", 0);
        }
      });
      d();
      this.i = new a(null);
      com.baidu.carlife.core.k.a(this.i);
      return paramLayoutInflater;
      this.e.a(2);
      this.c.setEmptyView(this.e);
    }
  }
  
  public void onDestroy()
  {
    com.baidu.carlife.core.k.b(this.i);
    setBottomBarStatus(true);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      setBottomBarStatus(false);
    }
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onInitFocusAreas()
  {
    if (getCurrentFragmentType() != 546) {
      return;
    }
    if (this.g == null)
    {
      this.g = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131623980), 2);
      this.g.d(this.mContentView.findViewById(2131624258));
    }
    if (this.h == null) {
      this.h = new c(this.c, 6);
    }
    if ((this.f != null) && (!this.f.isEmpty()))
    {
      d.a().b(new com.baidu.carlife.f.a[] { this.g, this.h });
      d.a().h(this.h);
      return;
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.g });
    d.a().h(this.g);
  }
  
  protected void onInitView() {}
  
  public void onNetWorkResponse(int paramInt)
  {
    if (!isAdded()) {
      return;
    }
    com.baidu.carlife.core.screen.presentation.a.e.a().c();
    switch (paramInt)
    {
    default: 
      return;
    case -3: 
    case -1: 
      this.e.a(0);
      this.c.setEmptyView(this.e);
      onInitFocusAreas();
      return;
    case 0: 
      this.f = new com.baidu.carlife.adpter.e(getContext());
      this.f.a(this.d.a());
      this.c.setAdapter(this.f);
      onInitFocusAreas();
      return;
    }
    this.e.a(1);
    this.c.setEmptyView(this.e);
    onInitFocusAreas();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.mBackBundle != null) && (this.mBackBundle.getInt("bundle_type", 0) == 1))
    {
      if (BNLocationManagerProxy.getInstance().getCurLocation() == null) {
        break label79;
      }
      com.baidu.carlife.core.screen.presentation.a.e.a().b(getString(2131296859));
      this.d = new com.baidu.carlife.k.k();
      this.d.registerResponseListener(this);
      this.d.toPostRequest();
    }
    for (;;)
    {
      this.mBackBundle = null;
      return;
      label79:
      this.e.a(2);
      this.c.setEmptyView(this.e);
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(int paramInt)
  {
    if (this.f != null)
    {
      com.baidu.carlife.core.screen.a locala = this.f.a(paramInt);
      if (locala != null)
      {
        startCalcRoute(locala);
        return true;
      }
    }
    return false;
  }
  
  public void stopDriving() {}
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(1002);
      addMsg(1004);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 1003: 
      default: 
        return;
      case 1004: 
        HomeDiscoverParkListFragment.d(HomeDiscoverParkListFragment.this);
        return;
      }
      HomeDiscoverParkListFragment.d(HomeDiscoverParkListFragment.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeDiscoverParkListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */