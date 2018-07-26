package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SensorData;

public interface IBNavigatorListener {
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

    void notifyGPSStatusData(int i);

    void notifyLoacteData(LocData locData);

    void notifyNmeaData(String str);

    void notifyOtherAction(int i, int i2, int i3, Object obj);

    void notifySensorData(SensorData sensorData);

    void notifyStartNav();

    void notifyViewModeChanged(int i);

    void onPageJump(int i, Object obj);

    void onYawingRequestStart();

    void onYawingRequestSuccess();
}
