package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.d;
import com.baidu.carlife.util.p;
import com.baidu.carlife.view.DiscoverCardView;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;

public class HomeDiscoverFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private boolean f = false;
  private DiscoverCardView g;
  private DiscoverCardView h;
  private DiscoverCardView i;
  private DiscoverCardView j;
  private com.baidu.carlife.f.g k;
  private com.baidu.carlife.f.g l;
  private j m = new j()
  {
    public void careAbout()
    {
      addMsg(1007);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1007: 
        i.b("Framework", "handleMessage=MSG_CONNECT_STATUS_FEATURE_CONFIG_SUCCESS   HomeDiscoverFragment.");
        HomeDiscoverFragment.a(HomeDiscoverFragment.this);
        return;
      }
      i.b("Framework", "handleMessage=MSG_CONNECT_STATUS_DISCONNECTED   HomeDiscoverFragment.");
      HomeDiscoverFragment.a(HomeDiscoverFragment.this);
    }
  };
  
  private void a()
  {
    if ((this.g == null) || (this.h == null) || (this.i == null) || (this.j == null))
    {
      i.b("yftech", "HomeDiscoverFragment --updateAdapter Card is null");
      return;
    }
    this.f = b();
    if (this.f)
    {
      this.g.a(2130838608);
      this.i.a(2130838584);
      this.h.a(2130838583);
      this.j.a(2130838621);
      this.g.a(getStringUtil(2131296510));
      this.i.a(getStringUtil(2131296507));
      this.h.a(getStringUtil(2131296511));
      this.j.a(getStringUtil(2131296504));
      this.g.b(getStringUtil(2131296506));
      this.i.b(getStringUtil(2131296501));
      this.h.b(getStringUtil(2131296502));
      this.j.b(getStringUtil(2131296509));
      this.g.setTagInt(1);
      this.i.setTagInt(5);
      this.h.setTagInt(4);
      this.j.setTagInt(3);
      this.g.setBackgroundResource(2131558793);
      this.h.setBackgroundResource(2131558793);
      this.i.setBackgroundResource(2131558793);
      this.j.setBackgroundResource(2131558793);
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      if (!h.a().getNaviFragmentManager().isDriving()) {
        break label542;
      }
      this.g.setEnabled(false);
      this.h.setEnabled(false);
      this.i.setEnabled(false);
      this.j.setEnabled(false);
    }
    for (;;)
    {
      i.b("yftech", "HomeDiscoverFragment --updateAdapter ");
      return;
      this.g.a(2130838608);
      this.i.a(2130838584);
      this.h.a(2130838583);
      this.j.a(2130838621);
      this.g.a(getStringUtil(2131296510));
      this.i.a(getStringUtil(2131296508));
      this.h.a(getStringUtil(2131296511));
      this.j.a(getStringUtil(2131296504));
      this.g.b(getStringUtil(2131296506));
      this.i.b(getStringUtil(2131296503));
      this.h.b(getStringUtil(2131296502));
      this.j.b(getStringUtil(2131296509));
      this.g.setTagInt(1);
      this.i.setTagInt(2);
      this.h.setTagInt(4);
      this.j.setTagInt(3);
      break;
      label542:
      this.g.setEnabled(true);
      this.h.setEnabled(true);
      this.i.setEnabled(true);
      this.j.setEnabled(true);
    }
  }
  
  private boolean b()
  {
    return (com.baidu.carlife.logic.g.a().a("ENGINE_TYPE") == com.baidu.carlife.logic.g.u) || (c());
  }
  
  private boolean c()
  {
    return "20272111".equals(p.a().a("carlifevehicle_channel", ""));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      StatisticManager.onEvent("DISCOVER_ZCW_0001", "DISCOVER_ZCW_0001");
      showFragment(546, null);
      return;
      StatisticManager.onEvent("DISCOVER_QJY_0001", "DISCOVER_QJY_0001");
      innerNameSearch(getStringUtil(2131297515));
      return;
      StatisticManager.onEvent("DISCOVER_HJY_0001");
      showFragment(550, null);
      return;
      StatisticManager.onEvent("DISCOVER_ZMS_0001", "DISCOVER_ZMS_0001");
      showFragment(553, null);
      return;
    } while (!this.f);
    innerNameSearch(getStringUtil(2131297514));
  }
  
  public void driving()
  {
    i.b("yftech", "HomeDiscoverFragment driving");
    a();
    dismissDialog();
  }
  
  public void onClick(View paramView)
  {
    int i1 = -1;
    int n = i1;
    if (paramView != null)
    {
      n = i1;
      if ((paramView instanceof DiscoverCardView)) {
        n = ((DiscoverCardView)paramView).getTagInt();
      }
    }
    a(n);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    k.a(this.m);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968764, null);
    setCommonTitleBar(paramLayoutInflater, getStringUtil(2131296493));
    this.g = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625359));
    this.h = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625360));
    this.i = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625361));
    this.j = ((DiscoverCardView)paramLayoutInflater.findViewById(2131625362));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    a();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k.b(this.m);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    i.b("Framework", "--onHiddenChanged- hidden=" + paramBoolean);
    a();
  }
  
  public void onInitFocusAreas()
  {
    if (this.k == null)
    {
      this.k = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624259), 2);
      this.k.d(this.mContentView.findViewById(2131624258));
    }
    if (this.l == null)
    {
      this.l = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131625358), 4);
      this.l.d(this.g).d(this.h).d(this.i).d(this.j);
    }
    d.a().b(new a[] { this.k, this.l });
    d.a().h(this.l);
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    i.b("Framework", "HomeDiscoverFragment --onResume ");
    setBottomBarStatus(true);
    a();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    i.b("Framework", "HomeDiscoverFragment VOICE Command: [" + paramString1 + "] [" + paramString2 + "]");
    if ((this.g != null) && (this.g.getCardName().contains(paramString2)))
    {
      onClick(this.g);
      return true;
    }
    if ((this.h != null) && (this.h.getCardName().contains(paramString2)))
    {
      onClick(this.h);
      return true;
    }
    if ((this.i != null) && (this.i.getCardName().contains(paramString2)))
    {
      onClick(this.i);
      return true;
    }
    if ((this.j != null) && (this.j.getCardName().contains(paramString2)))
    {
      onClick(this.j);
      return true;
    }
    return false;
  }
  
  public void stopDriving()
  {
    i.b("yftech", "HomeDiscoverFragment stopDriving");
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeDiscoverFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */