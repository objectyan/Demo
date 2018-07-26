package com.baidu.navisdk.ui.routeguide.subview;

import com.baidu.navisdk.ui.cruise.view.BCruiserR;

public class AssistantMapTypeConstDefine {
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

    public static int getResourceIdByType(int nAssistType, int nSpeed) {
        if (nAssistType == 0) {
            return BNavR.JointTypeIResID[nSpeed];
        }
        if (nAssistType == 4) {
            return BNavR.BlindBendTypeIResID[nSpeed];
        }
        if (nAssistType == 5) {
            return BNavR.SlopTypeIResID[nSpeed];
        }
        if (nAssistType == 6) {
            return BNavR.RockFallTypeIResID[nSpeed];
        }
        if (nAssistType == 14) {
            return BNavR.NarrowTypeIResID[nSpeed];
        }
        if (nAssistType == 3) {
            return BNavR.RailwayTypeIResID[nSpeed];
        }
        return BNavR.ASSIST_ICON_ID[nAssistType];
    }

    public static int getResourceIdByTypeForCruiser(int nAssistType, int nSpeed) {
        if (nAssistType == 0) {
            return BCruiserR.JointTypeIResID[nSpeed];
        }
        if (nAssistType == 4) {
            return BCruiserR.BlindBendTypeIResID[nSpeed];
        }
        if (nAssistType == 5) {
            return BCruiserR.SlopTypeIResID[nSpeed];
        }
        if (nAssistType == 6) {
            return BCruiserR.RockFallTypeIResID[nSpeed];
        }
        if (nAssistType == 14) {
            return BCruiserR.NarrowTypeIResID[nSpeed];
        }
        if (nAssistType == 3) {
            return BCruiserR.RailwayTypeIResID[nSpeed];
        }
        return BCruiserR.CAMERA_ICON_ID[nAssistType];
    }
}
