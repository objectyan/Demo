package com.baidu.navisdk.ui.cruise.model;

public class CruiseParams {

    public class CruiseInfo {
        public static final String AddDist = "cruise_add_dist";
        public static final String CurRoadName = "road_name";
        public static final String Direction = "cruise_head_angle";
        public static final String GPSLost = "cruise_gps_lost";
        public static final String Speed = "cruise_speed";
    }

    public class Key {
        public static final String SP_CRUISE_MAP_NEWER_GUIDE = "SP_Cruise_Map_Newer_Guide";
        public static final String SP_CRUISE_TEXT_NEWER_GUIDE = "SP_Cruise_Text_Newer_Guide";
        public static final String SP_Close_Break_Rules = "ClosePeccanryCamera";
        public static final String SP_Close_Camera = "CloseCamera";
        public static final String SP_Close_Speed_Camera = "CloseSpeedCamera";
        public static final String SP_Close_Traffic_Camera = "CloseTrafficLightCamera";
        public static final String SP_Close_Traffic_Sign = "CloseTrafficSign";
        public static final String SP_Last_Cruise_Map_Status = "SP_Last_Cruise_Map_Status";
    }

    public class SurveillanceCameraInfo {
        public static final String AssistType = "assisttype";
        public static final String Speed = "speed";
        public static final String UpdateType = "updatetype";
    }
}
