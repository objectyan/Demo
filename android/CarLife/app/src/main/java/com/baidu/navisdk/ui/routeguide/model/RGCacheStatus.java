package com.baidu.navisdk.ui.routeguide.model;

public class RGCacheStatus
{
  public static boolean hasClosedFoatView = false;
  public static boolean hasRecordFloatViewShow = false;
  public static boolean isStarNavAnimation;
  public static boolean sDayNightTimerStart;
  public static int sHeight;
  public static int sLayerMode;
  public static boolean sMapIsLastFullViewState = false;
  public static boolean sMockGpsGuide;
  public static int sOrientation;
  public static int sPickPointType;
  public static int sWidth;
  
  static
  {
    sLayerMode = 3;
    sDayNightTimerStart = false;
    sPickPointType = -1;
    sMockGpsGuide = false;
    isStarNavAnimation = false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGCacheStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */