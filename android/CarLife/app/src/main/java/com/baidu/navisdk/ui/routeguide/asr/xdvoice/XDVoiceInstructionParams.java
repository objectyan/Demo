package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

public interface XDVoiceInstructionParams {
    public static final String CALL_PHONE_AUTH = "android.permission.CALL_PHONE";
    public static final String CALL_PHONE_MSG = "没有打电话权限，请打开后重试";
    public static final int MAX_ROUTE_POI_SEARCH_NUMBER = 20;
    public static final String READ_CONTACTS_AUTH = "android.permission.READ_CONTACTS";
    public static final String READ_CONTACTS_MSG = "没有读取通讯录权限，请打开后重试";
    public static final String RECORD_AUDIO_AUTH = "android.permission.RECORD_AUDIO";
    public static final String RECORD_AUDIO_MSG = "没有麦克风权限，请打开后重试";

    public interface RoundInstructType {
        public static final String DEST_PARK = "ask_dest_park";
        public static final String ROUTE_RECOMMEND = "ask_route_recommend";
    }

    public interface VoiceContent {
        public static final String ChangeDestination = "正在为您重新导航";
        public static final String ExitNav = "正在为您退出导航";
        public static final String ROUTE_RECOMMEND_TIPS_SWITCH = "滴声后回答确定可切换路线";
        public static final String TIPS_AVOID_TRAFFIC = "请问是否躲避拥堵，请在滴声后回答确定或取消";
        public static final String TIPS_DEST_PARK = "是否直接导航到停车场，滴声后回答确定可导航到停车场";
    }

    public interface VoiceInstructionType {
        public static final String AVOID_CONGESTION = "avoid_congestion";
        public static final String CHANGE_FASTER_ROUTE = "more_fast";
        public static final String EXIT_NAVIGATION = "exit_navigation";
        public static final String REMAINING_DISTANCE = "remaining_distance";
        public static final String REMAINING_DISTANCE_AND_TIME = "remaining_distance_and_time";
        public static final String REMAINING_TIME = "remaining_time";
        public static final String TRAFFIC_INFO = "traffic_info";
    }

    public interface VoiceStatus {
        public static final int BEGIN_SPEECH = 1;
        public static final int DEFALUT = -1;
        public static final int END_SPEECH = 2;
        public static final int FINISH_RECOGNITION = 3;
        public static final int REDAY = 0;
        public static final int TTS_PLAY = 4;
    }

    public interface VoiceTopType {
        public static final int GUIDANCE_QUERY = 4;
        public static final int INVALID = 0;
        public static final int NAV_OPERATION = 6;
        public static final int None = 1;
        public static final int PAGE = 3;
        public static final int SEARCH = 5;
        public static final int UI = 2;
    }
}
