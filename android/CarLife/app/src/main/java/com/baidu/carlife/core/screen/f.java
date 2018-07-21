package com.baidu.carlife.core.screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public abstract interface f
{
  public abstract void back();
  
  public abstract void back(Bundle paramBundle);
  
  public abstract void backTo(int paramInt, Bundle paramBundle);
  
  public abstract ContentFragment createFragment(int paramInt);
  
  public abstract ContentFragment getCurrentFragment();
  
  public abstract int getCurrentFragmentType();
  
  public abstract NaviFragmentManager getNaviFragmentManager();
  
  public abstract int getNextFragmentType();
  
  public abstract boolean isCarlifeFragment(int paramInt);
  
  public abstract boolean isNaviMapFragment();
  
  public abstract void push(ContentFragment paramContentFragment);
  
  public abstract void removeAllFragmentByType(int paramInt);
  
  public abstract void removeFragmentTo(int paramInt);
  
  public abstract void removeWeChatFragmentFromStack();
  
  public abstract void showFragment(int paramInt, Bundle paramBundle);
  
  public abstract void showLatestHomeFragment();
  
  public abstract void showLatestMusicFragment();
  
  public abstract void showLatestNaviFragment();
  
  public abstract void showLatestPhoneFragment();
  
  public abstract void showPluginFrament(Fragment paramFragment);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */