package com.baidu.navisdk.adapter.impl;

public final class BNRouteGuideManager
{
  public static abstract interface OnNavigationListener
  {
    public abstract void notifyOtherAction(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void onNaviGuideEnd();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/adapter/impl/BNRouteGuideManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */