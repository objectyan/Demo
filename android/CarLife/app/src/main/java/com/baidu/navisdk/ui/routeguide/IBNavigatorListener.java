package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SensorData;

public abstract interface IBNavigatorListener
{
  public static final int Action_Type_Park_Close_Detail = 104;
  public static final int Action_Type_Park_Open_Detail = 103;
  public static final int Action_Type_Show_Navi_Route_Search_Dialog = 106;
  public static final int Action_Type_Show_Navi_Setting_Dialog = 105;
  public static final int Action_Type_Switch_DayNight_Mode = 100;
  public static final int Action_Type_VomitSlot_Dialog_Mode = 101;
  public static final int Action_Type_VomitSlot_GET_INTEGRAL = 102;
  public static final int PAGE_JUMP_WHEN_CLOUD_CONFIG_RECOMMEND_VOICE = 9;
  public static final int PAGE_JUMP_WHEN_GUIDE_END = 1;
  public static final int PAGE_JUMP_WHEN_NAVI_TO_STREEET_VIEW = 6;
  public static final int PAGE_JUMP_WHEN_NAVI_TO_SWITCH_IPO = 8;
  public static final int PAGE_JUMP_WHEN_NAVI_TO_VOICE_SETTING = 7;
  public static final int PAGE_JUMP_WHEN_QUIT_NAVI_TO_USERCENTER = 5;
  public static final int PAGE_JUMP_WHEN_ROUTE_DETAIL_REQUEST = 4;
  public static final int PAGE_JUMP_WHEN_ROUTE_PLAN_FAIL = 2;
  public static final int PAGE_JUMP_WHEN_ROUTE_PLAN_REQUEST = 3;
  
  public abstract void notifyGPSStatusData(int paramInt);
  
  public abstract void notifyLoacteData(LocData paramLocData);
  
  public abstract void notifyNmeaData(String paramString);
  
  public abstract void notifyOtherAction(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract void notifySensorData(SensorData paramSensorData);
  
  public abstract void notifyStartNav();
  
  public abstract void notifyViewModeChanged(int paramInt);
  
  public abstract void onPageJump(int paramInt, Object paramObject);
  
  public abstract void onYawingRequestStart();
  
  public abstract void onYawingRequestSuccess();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/IBNavigatorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */