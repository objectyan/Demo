package com.baidu.navisdk.ui.routeguide.subview;

public abstract interface OnRGSubViewListener
{
  public abstract void onAnologControlAction(boolean paramBoolean);
  
  public abstract void onBridgeSwitchGetFocus();
  
  public abstract void onCancelLoading();
  
  public abstract void onCarLogoAction();
  
  public abstract void onDayNightModeSettingChange(int paramInt);
  
  public abstract void onEmptyPoiAction();
  
  public abstract void onEmptyPoiGetFocus();
  
  public abstract void onEnlargeRoadMapHideEnd();
  
  public abstract void onEnlargeRoadMapHideStart();
  
  public abstract void onEnlargeRoadMapImgTouch();
  
  public abstract void onEnlargeRoadMapShowEnd();
  
  public abstract void onEnlargeRoadMapShowStart();
  
  public abstract void onEnlargeRoadMapViewHide();
  
  public abstract void onEnlargeRoadMapViewShow();
  
  public abstract void onFocusMoreMenu();
  
  public abstract void onFocusMoreMenuGetFocus();
  
  public abstract void onFullOrResumeGetFocus();
  
  public abstract void onFullviewAction();
  
  public abstract void onITSAction(boolean paramBoolean);
  
  public abstract void onJudgePreferWithMenuHide();
  
  public abstract void onLocationAction();
  
  public abstract void onLocationGetFocus();
  
  public abstract void onMASwitchGetFocus();
  
  public abstract void onMainAuxiliaryHide();
  
  public abstract void onMainAuxiliaryShow();
  
  public abstract void onMainAuxiliarySwitch();
  
  public abstract void onMenuMoreAction();
  
  public abstract void onMenuSelectedRouteDetail();
  
  public abstract void onMenuSelectedRoutePlan();
  
  public abstract void onMoreMenuAction();
  
  public abstract void onMoreRouteSearchAction();
  
  public abstract void onMultiRouteSwitchAction();
  
  public abstract void onNaviLeftPanelTouch();
  
  public abstract void onOnlineMainAuxiliarySwitch(int paramInt);
  
  public abstract void onOtherAction(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract void onParkSearchAction();
  
  public abstract void onQuitGetFocus();
  
  public abstract void onQuitNaviGuide(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onRefreshRoadAction();
  
  public abstract void onResumeNavigatorGetFocus();
  
  public abstract void onRouteDescWindowHide();
  
  public abstract void onRouteDescWindowShow();
  
  public abstract void onRouteRecommendSwitchCancel();
  
  public abstract void onRouteRecommendSwitchOk();
  
  public abstract void onRouteSortAction();
  
  public abstract void onRouteSwitchGetFocus();
  
  public abstract void onSetingGetFocus();
  
  public abstract void onShowQuitNaviView();
  
  public abstract void onUGCMenuAction();
  
  public abstract void onUgcChangeRoadAction();
  
  public abstract void onViaPointGetFocus();
  
  public abstract void onZoomInGetFocus();
  
  public abstract void onZoomOutGetFocus();
  
  public abstract void onZoominAction();
  
  public abstract void onZoomoutAction();
  
  public static abstract interface ActionStatusCommentNaviParams
  {
    public static final int Fail = 1;
    public static final int Success = 0;
  }
  
  public static abstract interface ActionStatusUgcRoadParams
  {
    public static final int UGC_Item_Link_Type_DestError = 262144;
    public static final int UGC_Item_Link_Type_Forbid = 4;
    public static final int UGC_Item_Link_Type_GuideError = 131072;
    public static final int UGC_Item_Link_Type_Invalid = 0;
    public static final int UGC_Item_Link_Type_InvalidRoad = 1;
    public static final int UGC_Item_Link_Type_Jam = 65536;
    public static final int UGC_Item_Link_Type_NarrowRoad = 2;
    public static final int UGC_Item_Link_Type_Other = Integer.MIN_VALUE;
    public static final int UGC_Item_Link_Type_ShortAvoid = 4096;
  }
  
  public static abstract interface ActionType
  {
    public static final int Comment_Navi = 0;
    public static final int Comment_Route = 1;
    public static final int Continue_Navi = 3;
    public static final int Hide_Comment_Dialog = 8;
    public static final int Page_Jump = 5;
    public static final int Remove_via_point = 10;
    public static final int Route_Search = 9;
    public static final int Show_Comment_Dialog = 7;
    public static final int Show_Comment_Route_View = 2;
    public static final int Show_Navi_Route_Search_Dialog = 14;
    public static final int Show_Navi_Setting_Dialog = 13;
    public static final int Show_Total_Road_Condition_Bar = 4;
    public static final int Street_view = 11;
    public static final int UGC_Feedback_View = 12;
    public static final int Voice_Speak_Setting = 6;
  }
  
  public static abstract interface ActionTypeAvoidTrafficRouteParams
  {
    public static final int Avoid_Traffic_Invalid = -1;
    public static final int Avoid_Traffic_NetTimeOut = 4;
    public static final int Avoid_Traffic_NewRoute = 2;
    public static final int Avoid_Traffic_NoNewRoute = 3;
    public static final int Avoid_Traffic_Switch_Failed = 1;
    public static final int Avoid_Traffic_Switch_Success = 0;
  }
  
  public static abstract interface ActionTypeCheckOtherRouteParams
  {
    public static final int CHECK_OTHER_ROUTE_FORCE_SWITCH_SUCESS = 6;
    public static final int CHECK_OTHER_ROUTE_HAVE_NEW_ROUTE = 5;
    public static final int CHECK_OTHER_ROUTE_INVALID = -1;
    public static final int CHECK_OTHER_ROUTE_NET_TIMEOUT = 4;
    public static final int CHECK_OTHER_ROUTE_NO_NEW_ROUTE = 3;
    public static final int CHECK_OTHER_ROUTE_STATUS_AVOID_FAIL_NO_ROUTE = 14;
    public static final int CHECK_OTHER_ROUTE_STATUS_AVOID_UGC = 13;
    public static final int CHECK_OTHER_ROUTE_STATUS_MAINROUTESWITCH = 9;
    public static final int CHECK_OTHER_ROUTE_STATUS_SROUTESWITCH = 10;
    public static final int CHECK_OTHER_ROUTE_STATUS_STRATEGYROUTE = 8;
    public static final int CHECK_OTHER_ROUTE_STATUS_offline_to_online_fal = 12;
    public static final int CHECK_OTHER_ROUTE_STATUS_offline_to_online_suc = 11;
    public static final int CHECK_OTHER_ROUTE_SWITCH_FAILED = 1;
    public static final int CHECK_OTHER_ROUTE_SWITCH_SUCCESS = 0;
    public static final int CHECK_OTHER_ROUTE_USER_SWITCH = 7;
  }
  
  public static abstract interface ActionTypeCommentNaviParams
  {
    public static final int Just_So_So = 1;
    public static final int Praise = 0;
    public static final int Vomit_Slot = 2;
  }
  
  public static abstract interface ActionTypeCommonParams
  {
    public static final int Hide = 0;
    public static final int Show = 1;
  }
  
  public static abstract interface ActionTypeFlagCommentNaviParams
  {
    public static final int Bad_traffic = 5;
    public static final int Broad_content_wrong = 13;
    public static final int Broad_not_understand = 12;
    public static final int Broad_time_not_good = 11;
    public static final int Detour = 4;
    public static final int Good = 0;
    public static final int Noneed_highway = 7;
    public static final int Normal = 1;
    public static final int Nothing = 2;
    public static final int Route_complex = 9;
    public static final int To_many_badroad = 8;
    public static final int To_many_lights = 6;
    public static final int Too_frequent = 14;
    public static final int Voice_bad = 15;
    public static final int VomitSlot = 3;
    public static final int Wrong_data = 10;
  }
  
  public static abstract interface ActionTypePageJump
  {
    public static final int Other_Route = 1;
    public static final int Reset_Route = 0;
    public static final int User_center = 2;
    public static final int Voice_setting = 3;
  }
  
  public static abstract interface ActionTypeSceneCommentNaviParams
  {
    public static final String Off_navi = "3";
    public static final String On_Navi = "2";
    public static final String Overview = "1";
  }
  
  public static abstract interface ActionTypeSearchParams
  {
    public static final String Bank = "银行";
    public static final String Gas_Station = "加油站";
    public static final String Hotel = "酒店";
    public static final String Park = "停车场";
    public static final String Restaurant = "餐饮";
    public static final String Service = "服务区";
    public static final String Spots = "景点";
    public static final String Toilet = "厕所";
  }
  
  public static abstract interface ActionTypeUGCParams
  {
    public static final int routeAdded = 3;
    public static final int routeBad = 2;
    public static final int routeBlock = 0;
    public static final int traficFlagError = 1;
  }
  
  public static abstract interface ActionTypeVoiceSpeakSetting
  {
    public static final int ElecCamera = 1;
    public static final int RoadCondition = 4;
    public static final int SaftyDrive = 3;
    public static final int SpeedCamera = 2;
    public static final int StraightDirect = 5;
    public static final int Voice_Mode = 0;
  }
  
  public static abstract interface RouteTypeParams
  {
    public static final int ROUTE_TYPE_AVOID_TRAFFIC = 0;
    public static final int ROUTE_TYPE_INVALID = -1;
    public static final int ROUTE_TYPE_OTHER_ROUTE = 1;
    public static final int ROUTE_TYPE_offline_to_online = 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/OnRGSubViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */