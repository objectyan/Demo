package com.baidu.navisdk.ui.routedetails;

public abstract interface IBNRouteDetailsListener
{
  public static final int MAP_ROUTE_FOCUS = 4;
  public static final int PAGE_JUMP_TO_BACK = 1;
  public static final int PAGE_JUMP_TO_HOME = 2;
  public static final int ROUTE_PLAN_SUCCESS = 2;
  public static final int SWITCH_OTHER_ROUTE_RESULT_FAILED = 1;
  public static final int SWITCH_OTHER_ROUTE_RESULT_SUCCESS = 0;
  public static final int UI_UPDATE_GET_CAR_NO = 5;
  public static final int UI_UPDATE_GET_CAR_TYPE = 6;
  public static final int UI_UPDATE_OPEN_WEBVIEW = 7;
  public static final int UI_UPDATE_REFRESH = 3;
  
  public abstract void onHideSidePanel();
  
  public abstract void onNotifySwitchResult(int paramInt);
  
  public abstract void onPageJump(int paramInt, Object paramObject);
  
  public abstract void onResetMapCtrlPanel();
  
  public abstract void onShowSidePanel();
  
  public abstract void onStartNavi(boolean paramBoolean);
  
  public abstract void onStartRealNavi();
  
  public abstract void onSwitchOtherRoute(int paramInt);
  
  public abstract void onUpdate(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract void onYawingBackGuiding();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routedetails/IBNRouteDetailsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */