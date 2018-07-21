package com.baidu.navisdk.lightnavi.controller;

import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;

public class BNLightNaviSwitchManager
{
  private static volatile BNLightNaviSwitchManager mInstance;
  private int handlerID;
  private volatile boolean mHaveSwitched = false;
  private volatile boolean mIsRefreashRoute = false;
  private volatile boolean mIsSwitching = false;
  private NormalNaviSwitchSlightListener mNormalNaviSwitchSlightListener = null;
  
  public static BNLightNaviSwitchManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNLightNaviSwitchManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public void cancleRoutePlan()
  {
    if (this.handlerID > 0) {
      BNRouteGuider.getInstance().cancelCalcRoute(this.handlerID);
    }
  }
  
  public boolean getHaveSwitched()
  {
    return this.mHaveSwitched;
  }
  
  public boolean isCurDriveRouteOnline()
  {
    return BNRouteGuider.getInstance().isCurDriveRouteOnline();
  }
  
  public boolean isRefreashRoute()
  {
    return this.mIsRefreashRoute;
  }
  
  public boolean isSwitching()
  {
    return this.mIsSwitching;
  }
  
  public void naviSwitchingCalcRoute(int paramInt)
  {
    this.handlerID = BNRouteGuider.getInstance().naviSwitchingCalcRoute(paramInt);
    setIsSwitching(true);
  }
  
  public void onSwitchNormalNaviToSLight(Message paramMessage)
  {
    if (this.mNormalNaviSwitchSlightListener != null) {
      this.mNormalNaviSwitchSlightListener.onSwitchNormalNaviToSLight(paramMessage);
    }
  }
  
  public void setHaveSwitched(boolean paramBoolean)
  {
    this.mHaveSwitched = paramBoolean;
  }
  
  public void setIsRefreashRoute(boolean paramBoolean)
  {
    this.mIsRefreashRoute = paramBoolean;
  }
  
  public void setIsSwitching(boolean paramBoolean)
  {
    this.mIsSwitching = paramBoolean;
  }
  
  public void setNormalNaviSwitchSlightListener(NormalNaviSwitchSlightListener paramNormalNaviSwitchSlightListener)
  {
    this.mNormalNaviSwitchSlightListener = paramNormalNaviSwitchSlightListener;
  }
  
  public boolean switch2AlternativeRoute(int paramInt)
  {
    if (BNRouteGuider.getInstance().switch2AlternativeRoute(paramInt))
    {
      setIsRefreashRoute(true);
      return true;
    }
    return false;
  }
  
  public void unInit()
  {
    this.mHaveSwitched = false;
    mInstance = null;
  }
  
  public static abstract interface NormalNaviSwitchSlightListener
  {
    public abstract void onSwitchNormalNaviToSLight(Message paramMessage);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/controller/BNLightNaviSwitchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */