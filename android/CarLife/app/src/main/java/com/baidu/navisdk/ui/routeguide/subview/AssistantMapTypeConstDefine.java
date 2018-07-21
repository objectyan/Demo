package com.baidu.navisdk.ui.routeguide.subview;

public class AssistantMapTypeConstDefine
{
  public static final int NE_AssistantMap_Type_Accident = 7;
  public static final int NE_AssistantMap_Type_BlindBend = 4;
  public static final int NE_AssistantMap_Type_BlindSlope = 5;
  public static final int NE_AssistantMap_Type_Bridge = 2;
  public static final int NE_AssistantMap_Type_Children = 12;
  public static final int NE_AssistantMap_Type_Honk = 18;
  public static final int NE_AssistantMap_Type_IntervalCamera = 11;
  public static final int NE_AssistantMap_Type_Joint = 0;
  public static final int NE_AssistantMap_Type_Narrow = 14;
  public static final int NE_AssistantMap_Type_OverTakeForbidden = 17;
  public static final int NE_AssistantMap_Type_PeccanryCamera = 10;
  public static final int NE_AssistantMap_Type_Railway = 3;
  public static final int NE_AssistantMap_Type_Rockfall = 6;
  public static final int NE_AssistantMap_Type_Slip = 16;
  public static final int NE_AssistantMap_Type_SpeedCamera = 8;
  public static final int NE_AssistantMap_Type_TrafficLightCamera = 9;
  public static final int NE_AssistantMap_Type_Tunnel = 1;
  public static final int NE_AssistantMap_Type_Uneven = 13;
  public static final int NE_AssistantMap_Type_Viliage = 15;
  public static final int NE_AssistantMap_Type_crossWind = 21;
  public static final int NE_AssistantMap_Type_hillSideDangerous = 19;
  public static final int NE_AssistantMap_Type_lowSpeed = 23;
  public static final int NE_AssistantMap_Type_narrowBridge = 20;
  public static final int NE_AssistantMap_Type_underWater = 22;
  
  public static int getResourceIdByType(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return BNavR.JointTypeIResID[paramInt2];
    }
    if (paramInt1 == 4) {
      return BNavR.BlindBendTypeIResID[paramInt2];
    }
    if (paramInt1 == 5) {
      return BNavR.SlopTypeIResID[paramInt2];
    }
    if (paramInt1 == 6) {
      return BNavR.RockFallTypeIResID[paramInt2];
    }
    if (paramInt1 == 14) {
      return BNavR.NarrowTypeIResID[paramInt2];
    }
    if (paramInt1 == 3) {
      return BNavR.RailwayTypeIResID[paramInt2];
    }
    return BNavR.ASSIST_ICON_ID[paramInt1];
  }
  
  public static int getResourceIdByTypeForCruiser(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return com.baidu.navisdk.ui.cruise.view.BCruiserR.JointTypeIResID[paramInt2];
    }
    if (paramInt1 == 4) {
      return com.baidu.navisdk.ui.cruise.view.BCruiserR.BlindBendTypeIResID[paramInt2];
    }
    if (paramInt1 == 5) {
      return com.baidu.navisdk.ui.cruise.view.BCruiserR.SlopTypeIResID[paramInt2];
    }
    if (paramInt1 == 6) {
      return com.baidu.navisdk.ui.cruise.view.BCruiserR.RockFallTypeIResID[paramInt2];
    }
    if (paramInt1 == 14) {
      return com.baidu.navisdk.ui.cruise.view.BCruiserR.NarrowTypeIResID[paramInt2];
    }
    if (paramInt1 == 3) {
      return com.baidu.navisdk.ui.cruise.view.BCruiserR.RailwayTypeIResID[paramInt2];
    }
    return com.baidu.navisdk.ui.cruise.view.BCruiserR.CAMERA_ICON_ID[paramInt1];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/AssistantMapTypeConstDefine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */