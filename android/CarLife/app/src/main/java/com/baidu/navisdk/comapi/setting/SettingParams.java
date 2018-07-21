package com.baidu.navisdk.comapi.setting;

public class SettingParams
{
  public class Action
  {
    public static final int DAY_NIGHT_MODE_AUTO = 1;
    public static final int DAY_NIGHT_MODE_DAY = 2;
    public static final int DAY_NIGHT_MODE_NIGHT = 3;
    public static final boolean ROUTE_STATE_MODE_HISTORY = false;
    public static final boolean ROUTE_STATE_MODE_REAL = true;
    public static final int ROUTE_VOMITSLOT_Dialog_MODE_HIDE = 5;
    public static final int ROUTE_VOMITSLOT_Dialog_MODE_SHOW = 4;
    public static final int TTS_PLAY_MODE_VOL_DOWN = 0;
    public static final int TTS_PLAY_MODE_VOL_STOP = 1;
    
    public Action() {}
  }
  
  public class Key
  {
    public static final String ADDRESS_LAST_UPLOAD_TIME = "ADDRESS_LAST_UPLOAD_TIME";
    public static final String ASR_FIRST_USE = "ASR_FIRST_USE";
    public static final String CARLIFE_NAVI_MODE_DAY_AND_NIGHT = "CARLIFE_NAVI_MODE_DAY_AND_NIGHT";
    public static final String COLLADA_SWITCH = "COLLADA_SWITCH";
    public static final String FELLOW_DEBUG_CITY_NAME = "FELLOW_DEBUG_CITY_NAME";
    public static final String FELLOW_IS_BUTTON_CLICK = "FELLOW_IS_BUTTON_CLICK";
    public static final String FELLOW_PREFER_TIPS_TTS_COUNT = "fellow_prefer_tips_tts_count";
    public static final String FELLOW_PREFER_TIPS_TTS_KEY = "fellow_prefer_tips_tts_key";
    public static final String FELLOW_SUPPORT = "fellow_support";
    public static final String FELLOW_SWITCH = "fellow_switch";
    public static final String FELLOW_TIPS_SHOW = "FELLOW_TIPS_SHOW";
    public static final String FIRST_ITS_ON = "FIRST_ITS_ON";
    public static final String FIRST_RC_STYLE_GUIDE_SHOW = "first_rc_style_guide_show";
    public static final String FIRST_ROUTE_PLAN = "first_rout_plan";
    public static final String FIRST_VOICE_NOTIFY_GUIDE = "FIRST_VOICE_NOTIFY_GUIDE";
    public static final String GAS_STATION_PREFERENCE = "gas_station_preference";
    public static final String HAS_UPLOAD_ADDRESS = "asr_has_upload_address";
    public static final String HIGHWAY_SIMPLE_BOARD = "highway_simple_board";
    public static final String HOLIDAY_RED_GIFT = "HOLIDAY_RED_GIFT";
    public static final String HUD_MIRRO_SHOW = "IS_SHOW_HUD_MIRRO";
    public static final String HUD_SDK_SWITCH = "hudsdk_switch";
    public static final String IPO_GUIDE_SHOW_TIME = "IPO_GUIDE_SHOW_TIME";
    public static final String IPO_NAVI_LOCK_GUIDE = "ipo_navi_lock_guide";
    public static final String IS_IPO_GUIDE_FIRST_SHOW = "IS_IPO_GUIDE_FIRST_SHOW";
    public static final String KEY_CHECK_NEW_DATA = "CHECK_NEW_DATA";
    public static final String LAST_TIME_CHECK_BUDSS = "last_time_check_budss";
    public static final String NAVI_ALWAYS_BRIGHT = "NAVI_ALWAYS_BRIGHT";
    public static final String NAVI_ANTI_CHEAT = "NAVI_ANTI_CHEAT";
    public static final String NAVI_ASR_SHOW = "NAVI_ASR_SHOW";
    public static final String NAVI_ASR_WAKUP_ON_OFF = "NAVI_ASR_ON_OFF";
    public static final String NAVI_AUTO_CHECK_NEW_DATA = "NAVI_AUTO_CHECK_NEW_DATA";
    public static final String NAVI_AUTO_ENTER_LIGHT_NAVI = "NAVI_AUTO_ENTER_LIGHT_NAVI";
    public static final String NAVI_AUTO_LEVEL = "NAVI_AUTO_LEVEL";
    public static final String NAVI_AUTO_UPDATE_NEW_DATA = "NAVI_AUTO_UPDATE_NEW_DATA";
    public static final String NAVI_BLUE_TOOTH_NAME = "NAVI_BLUE_TOOTH_NAME";
    public static final String NAVI_BLUE_TOOTH_PHONE_CHANNEL = "NAVI_BLUE_TOOTH_PHONE_CHANNEL";
    public static final String NAVI_DEFAULT_LAUNCH_MODE = "NAVI_DEFAULT_LAUNCH_MODE";
    public static final String NAVI_DEFAULT_ROUTE_SORT = "NAVI_DEFAULT_SORT_VALUE";
    public static final String NAVI_FELLOW_DEBUG = "NAVI_FELLOW_DEBUG";
    public static final String NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE = "NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE";
    public static final String NAVI_FIRST_CAR_LOGO_GUIDE = "NAVI_FIRST_CAR_LOGO_GUIDE";
    public static final String NAVI_FIRST_MENU_GUIDE = "NAVI_FIRST_MENU_GUIDE";
    public static final String NAVI_FIRST_MORE_MENU_GUIDE = "NAVI_FIRST_MORE_MENU_GUIDE";
    public static final String NAVI_FIRST_VOICE_GUIDE = "NAVI_FIRST_VOICE_GUIDE";
    public static final String NAVI_FLOAT_SWITCH = "NAVI_FLOAT_SWITCH";
    public static final String NAVI_GPS_DEBUG = "NAVI_GPS_DEBUG";
    public static final String NAVI_GPS_HOT_STAST = "NAVI_GPS_HOT_STAST";
    public static final String NAVI_GUIDE_END = "NAVI_GUIDE_END";
    public static final String NAVI_GUIDE_VIEW_MODE = "NAVI_GUIDE_VIEW_MODE";
    public static final String NAVI_HAS_SHOW_ROUTE_SORT_DEFAULT_SETTING_GUIDE = "NAVI_HAS_SHOW_ROUTE_SORT_DEFAULT_SETTING_GUIDE";
    public static final String NAVI_INIT_CLOUD_CFG = "NAVI_INIT_CLOUD_CFG";
    public static final String NAVI_IPO_ROADCOND_ON_OFF = "NAVI_IPO_ROADCOND_ON_OFF";
    public static final String NAVI_ITS_ON_OFF = "NAVI_ROADCOND_ON_OFF";
    public static final String NAVI_LAST_VOICE_MODE = "NAVI_LAST_VOICE_MODE";
    public static final String NAVI_MAP_MODE = "navi_map_mode";
    public static final String NAVI_MODE_DAY_AND_NIGHT = "NAVI_MODE_DAY_AND_NIGHT";
    public static final String NAVI_MONKEY = "NAVI_MONKEY";
    public static final String NAVI_PARK_SEARCH = "NAVI_PARK_SEARCH";
    public static final String NAVI_PLAY_BACKGROUND_SPEAK = "NAVI_PLAY_BACKGROUND_SPEAK";
    public static final String NAVI_PLUGIN_MD5 = "navi_plugin_md5";
    public static final String NAVI_POWER_SAVE_MODE = "NAVI_POWER_SAVE_MODE";
    public static final String NAVI_PUSH_SERVICE = "NAVI_PUSH_SERVICE";
    public static final String NAVI_REAL_HISTORY_ITS = "NAVI_REAL_HISTORY_ITS";
    public static final String NAVI_REMEMBER_LAUNCH_MODE = "NAVI_REMEMBER_LAUNCH_MODE";
    public static final String NAVI_ROADCOND_ON_OFF = "NAVI_ROADCOND_ON_OFF";
    public static final String NAVI_ROOT_SCREEN = "ROOT_SCREEN_OPEN";
    public static final String NAVI_ROUTEPLAN_RESULT_PREF = "NAVI_ROUTEPLAN_RESULT_PREF";
    public static final String NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE = "NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE";
    public static final String NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE = "NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE";
    public static final String NAVI_RP_NET_MODE = "NAVI_RP_NET_MODE";
    public static final String NAVI_RP_NET_MODE_SET = "NAVI_RP_NET_MODE_SET";
    public static final String NAVI_SEARCH_NET_MODE = "NAVI_SEARCH_NET_MODE";
    public static final String NAVI_SEARCH_RESULT_SORT_PREF = "NAVI_SEARCH_RESULT_SORT_PREF";
    public static final String NAVI_SELECTED_ROUTE_SORT_COUNT = "NAVI_SELECTED_ROUTE_SORT_COUNT";
    public static final String NAVI_SELECTED_ROUTE_SORT_VALUE = "NAVI_SELECTED_ROUTE_SORT_VALUE";
    public static final String NAVI_SHOWLOCATION_ONOFF = "NAVI_LOCATION_SHOULD_SHOW";
    public static final String NAVI_SHOW_CAR_LOGO_TO_END = "SHOW_CAR_LOGO_TO_END";
    public static final String NAVI_SHOW_DISCLAIMER = "NAVI_SHOW_DISCLAIMER";
    public static final String NAVI_SHOW_JAVA_LOG = "NAVI_SHOW_JAVALOG";
    public static final String NAVI_SHOW_MAP_SWITCH = "NAVI_SHOW_MAP_SWITCH";
    public static final String NAVI_SHOW_NATIVE_LOG = "NAVI_SHOW_NATIVE_LOG";
    public static final String NAVI_SHOW_NOTIFICATION_DEBUG = "NAVI_SHOW_NOTIFICATION_DEBUG";
    public static final String NAVI_SHOW_ONLINE_USE = "NAVI_SHOW_ONLINE_USE";
    public static final String NAVI_TRACK_RECORD_ONOFF = "NAVI_TRACK_RECORD";
    public static final String NAVI_TTS_PLAY_MODE = "NAVI_TTS_PLAY_MODE";
    public static final String NAVI_TTS_SPEED = "NAVI_TTS_SPEED";
    public static final String NAVI_TTS_VOCODER = "NAVI_TTS_VOCODER";
    public static final String NAVI_UGC_SHOW = "NAVI_UGC_SHOW";
    public static final String NAVI_UPDATE_APK_NOT_ALERT = "NAVI_UPDATE_APK_NOT_ALERT";
    public static final String NAVI_UPDATE_APK_VERSION = "NAVI_UPDATE_APK_VERSION";
    public static final String NAVI_USE_HTTPS_OFFLINE_URL = "NAVI_USE_HTTPS_OFFLINE_URL";
    public static final String NAVI_VOICE_JINSHA_AUTO_DOWNLOAD = "NAVI_VOICE_JINSHA_AUTO_DOWNLOAD";
    public static final String NAVI_VOICE_JINSHA_AUTO_SWITCH = "NAVI_VOICE_JINSHA_AUTO_SWITCH";
    public static final String NAVI_VOICE_JINSHA_HAS_DOWNLOAD = "NAVI_VOICE_JINSHA_HAS_DOWNLOAD";
    public static final String NAVI_VOICE_MAIDOU_GUIDE = "NAVI_VOICE_MAIDOU_Guide";
    public static final String NAVI_VOICE_MODE = "NAVI_VOICE_MODE";
    public static final String NAVI_VOICE_PERSONALITY = "NAVI_VOICE_PERSONNALITY";
    public static final String NAVI_VOICE_RECOMMEN_HAS_CLICKED = "NAVI_VOICE_RECOMMEN_HAS_CLICKED";
    public static final String NAVI_VOICE_RECOMMEN_SHOW_COUNT = "NAVI_VOICE_RECOMMEN_SHOW_COUNT";
    public static final String NAVI_VOICE_TASK_ID = "NAVI_VOICE_TASK_ID";
    public static final String NAVI_VOICE_TTS_DATA_PATH = "NAVI_VOICE_TTS_DATA_PATH";
    public static final String NAV_END_YELLOW_BANNER_CLICK = "NAV_END_YELLOW_BANNER_CLICK";
    public static final String NAV_END_YELLOW_BANNER_SHOW = "NAV_END_YELLOW_BANNER_SHOW";
    public static final String Navi_ElecCamera_Speak = "Navi_ElecCamera_Speak";
    public static final String Navi_RoadCondition_Speak = "Navi_RoadCondition_Speak";
    public static final String Navi_SaftyDrive_Speak = "Navi_SaftyDrive_Speak";
    public static final String Navi_SpeedCamera_Speak = "Navi_SpeedCamera_Speak";
    public static final String Navi_StraightDirect_Speak = "Navi_StraightDirect_Speak";
    public static final String OFFLINEDATA_DOWNLOAD_ITEM_SET = "offlinedata_download_item_set";
    public static final String OWNER_CAR_PLATE = "owner_car_plate";
    public static final String POI_SORT_RULE_TYPE = "POI_SORT_RULE_TYPE";
    public static final String PREF_NAVI_FIRST_USE = "PREF_NAVI_FIRST_USE";
    public static final String QUIT_FOR_EXCEPTION_IN_NAVIMODE = "quit_for_exception_in_navimode";
    public static final String RG_FLOAT_CLOSE_MSG = "rg_float_close_msg";
    public static final String RG_FLOAT_OPEN_GUIDE_SHOW = "rg_float_show_open_guide";
    public static final String ROUTE_DETAIL_GUIDE_SHOW_TIME = "route_detail_guide_show_time";
    public static final String SEARCH_DISTRICT_ID = "search_district_id";
    public static final String SEARCH_DISTRICT_NAME = "search_district_name";
    public static final String SP_ACCOUNT_ONLINE = "sp_account_online";
    public static final String SP_ROUTEPLAN_SHOW_AVOID_TRAFFICJAM_DIALOG = "routeplan_show_avoid_trafficjam_dialog";
    public static final String SP_ROUTEPLAN_SHOW_FISRT_CALC = "routeplan_show_first_calc";
    public static final String SP_ROUTEPLAN_SHOW_ONLINE_DIALOG = "routeplan_show_online_dialog";
    public static final String SP_SHOW_NAVING_REAL_ENLARGEMENT = "sp_show_naving_real_enlargement";
    public static final String SP_Show_Naving_Total_Road_Condition_Bar = "SP_Show_Naving_Total_Road_Condition_Bar";
    public static final String SP_TRACK_LOCATE_GUIDE = "track_locate_guide";
    public static final String SP_USING_MODE = "SP_USING_MODE";
    public static final String USER_GUIDE_STATE = "navi_user_guide_state";
    public static final String XMLY_DOWNLOADED_PAGE_INDEX = "xmly_download_page_index";
    public static final String XMLY_FIRST_DATA_ID = "xmly_first_data_id";
    public static final String XMLY_OPEN_STATE = "xmly_open_state";
    public static final String XMLY_SWITCH_TIPS = "xmly_switch_tips";
    public static final String XMLY_WIFI_DOWNLOAD_STATE = "xmly_wifi_download_state";
    
    public Key() {}
  }
  
  public static abstract interface MapMode
  {
    public static final int CAR_3D = 1;
    public static final int NORTH_2D = 2;
  }
  
  public static class PowerSaveMode
  {
    public static final int AUTO_MODE = 0;
    public static final int DISABLE_MODE = 2;
    public static final int ENABLE_MODE = 1;
  }
  
  public static class UsingMode
  {
    public static final int CAR_MODE = 2;
    public static final int MAP_MODE = 1;
    public static final int UNKNOWN_MODE = 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/setting/SettingParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */