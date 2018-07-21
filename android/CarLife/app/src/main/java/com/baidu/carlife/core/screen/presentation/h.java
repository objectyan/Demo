package com.baidu.carlife.core.screen.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.OnFragmentListener;
import android.util.AndroidRuntimeException;
import com.baidu.carlife.core.screen.f;
import com.baidu.carlife.core.screen.l;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public class h
  implements f
{
  private static h a;
  private NaviFragmentManager b;
  
  private h(NaviFragmentManager paramNaviFragmentManager)
  {
    this.b = paramNaviFragmentManager;
  }
  
  public static h a()
  {
    if (a == null) {
      throw new AndroidRuntimeException("Please call init method first.");
    }
    return a;
  }
  
  public static void a(NaviFragmentManager paramNaviFragmentManager)
  {
    a = new h(paramNaviFragmentManager);
  }
  
  public void a(Bundle paramBundle)
  {
    this.b.backToNavi(paramBundle);
  }
  
  public void a(Fragment paramFragment)
  {
    this.b.removePluginFragment(paramFragment);
  }
  
  public void a(OnFragmentListener paramOnFragmentListener)
  {
    this.b.setFragmentManager(paramOnFragmentListener);
  }
  
  public void a(l paraml)
  {
    this.b.setUIListener(paraml);
  }
  
  public boolean a(int paramInt)
  {
    return this.b.isCarlifeRadioMusicFragment(paramInt);
  }
  
  public boolean b()
  {
    return getCurrentFragmentType() == 737;
  }
  
  public boolean b(int paramInt)
  {
    return this.b.isCarlifeMusicFragment(paramInt);
  }
  
  public void back()
  {
    back(null);
  }
  
  public void back(Bundle paramBundle)
  {
    this.b.back(paramBundle);
  }
  
  public void backTo(int paramInt, Bundle paramBundle)
  {
    this.b.backTo(paramInt, paramBundle);
  }
  
  public ContentFragment c(int paramInt)
  {
    return this.b.getLatestFragment(paramInt);
  }
  
  public String c()
  {
    return this.b.getCurFragmentModule();
  }
  
  public ContentFragment createFragment(int paramInt)
  {
    return this.b.createFragment(paramInt);
  }
  
  public int d()
  {
    return this.b.getCurFragmentModuleType();
  }
  
  public boolean d(int paramInt)
  {
    return this.b.isCarlifeHomeFragment(paramInt);
  }
  
  public int e()
  {
    int i = d();
    if (i == 4001) {
      return 1;
    }
    if (i == 4004) {
      return 4;
    }
    if (i == 4002) {
      return 2;
    }
    return 3;
  }
  
  public boolean e(int paramInt)
  {
    return this.b.isCarlifeTelephoneFragment(paramInt);
  }
  
  public int f(int paramInt)
  {
    return this.b.findFragmentIndexInStack(paramInt);
  }
  
  public boolean f()
  {
    return this.b.isNaviStart();
  }
  
  public BaseFragment g()
  {
    return this.b.getLatestMusicFragment();
  }
  
  public boolean g(int paramInt)
  {
    return this.b.isNeedHideTabFragment(paramInt);
  }
  
  public ContentFragment getCurrentFragment()
  {
    return this.b.getCurrentFragment();
  }
  
  public int getCurrentFragmentType()
  {
    return this.b.getCurrentFragmentType();
  }
  
  public NaviFragmentManager getNaviFragmentManager()
  {
    return this.b;
  }
  
  public int getNextFragmentType()
  {
    return this.b.mLastFragmentType;
  }
  
  public int h()
  {
    return this.b.getFragmentStackSize();
  }
  
  public void i()
  {
    this.b.hideAllFragments();
  }
  
  public boolean isCarlifeFragment(int paramInt)
  {
    return this.b.isCarlifeFragment(paramInt);
  }
  
  public boolean isNaviMapFragment()
  {
    return this.b.isMapViewFragment(this.b.mLastFragmentType);
  }
  
  public Fragment j()
  {
    return this.b.getLatestNaviFragment();
  }
  
  public void k()
  {
    this.b.showFirstHomeFragment();
  }
  
  public void push(ContentFragment paramContentFragment)
  {
    this.b.push(paramContentFragment);
  }
  
  public void removeAllFragmentByType(int paramInt)
  {
    this.b.removeAllFragmentByType(paramInt);
  }
  
  public void removeFragmentTo(int paramInt)
  {
    this.b.removeFragmentTo(paramInt);
  }
  
  public void removeWeChatFragmentFromStack()
  {
    this.b.removeWeChatFragmentFromStack();
  }
  
  public void showFragment(int paramInt, Bundle paramBundle)
  {
    this.b.showFragment(paramInt, paramBundle);
  }
  
  public void showLatestHomeFragment()
  {
    this.b.showLatestHomeFragment();
  }
  
  public void showLatestMusicFragment()
  {
    this.b.showLatestMusicFragment();
  }
  
  public void showLatestNaviFragment()
  {
    this.b.backToNavi(null);
  }
  
  public void showLatestPhoneFragment()
  {
    this.b.showLatestPhoneFragment();
  }
  
  public void showPluginFrament(Fragment paramFragment)
  {
    this.b.showPluginFrament(paramFragment);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */