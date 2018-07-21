package com.baidu.navisdk.lightnavi.listener;

import android.os.Message;

public abstract interface LightGuideRGListener
{
  public abstract void avoidTrafficJam(Message paramMessage);
  
  public abstract void calcOtherRoute();
  
  public abstract void hideAvoidTrafficJamView();
  
  public abstract void isYellowBarHide(Message paramMessage);
  
  public abstract void onArriveDest(Message paramMessage);
  
  public abstract void onAutoRefresh(int paramInt);
  
  public abstract void onGpsStatusChange(boolean paramBoolean);
  
  public abstract void onIPOAddressScreen(Message paramMessage);
  
  public abstract void onIPOLockScreen(Message paramMessage);
  
  public abstract void onIPORoadConditionHide(Message paramMessage);
  
  public abstract void onIPORoadConditionUpdate(Message paramMessage);
  
  public abstract void onOtherRoute(Message paramMessage);
  
  public abstract void onQuitNavi();
  
  public abstract void onRemainInfoUpdate(Message paramMessage);
  
  public abstract void onSwithSLightToNavi(Message paramMessage);
  
  public abstract void onUpdateSimpleGuide(Message paramMessage);
  
  public abstract void onUpdateSpeed(boolean paramBoolean, Message paramMessage);
  
  public abstract void onYawingRPFail();
  
  public abstract void onYawingRerouteSuccess(Message paramMessage);
  
  public abstract void onYawingRerouting(Message paramMessage);
  
  public abstract void refreshScreenShot();
  
  public abstract void showSafetyGuide(boolean paramBoolean);
  
  public abstract void switchScrennType();
  
  public abstract void zoomToFullView();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/listener/LightGuideRGListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */