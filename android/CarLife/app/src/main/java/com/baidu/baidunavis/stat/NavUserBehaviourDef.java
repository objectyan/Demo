package com.baidu.baidunavis.stat;

import com.baidu.navisdk.util.http.HttpURLManager;

public class NavUserBehaviourDef
{
  public static final String BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU = "asr_maidou";
  public static final String BEHAVIOUR_NAVI_ACTION_ASR_NORMAL = "asr_normal";
  public static final String DA_SRC_E_DOG = "toolbox.eDog";
  public static final String DA_SRC_NAVI_TO = "toolbox.naviTo";
  public static final String LOG_DOWNLAOD = "navi_enter_download";
  public static final String LOG_E_DOG = "navi_enter_edog";
  public static final String LOG_NAVI_TO = "navi_enter_offline_navi";
  public static final String LOG_ROUTE_PLAN = "navi_enter_route_plan";
  public static final String LOG_SETTINGS = "navi_enter_settings";
  public static final String LOG_YAW = "navi_enter_yaw";
  public static final String NAVI_MAPPAGE_ENTER_EDOG = "01001";
  public static final String NAVI_MAPPAGE_ENTER_NAVI = "00004";
  public static final String NAVI_MAPPAGE_ENTER_SIMULATE_NAVI = "00009";
  public static final String NAVI_MAPSDK_ENTER_NAVI = "00005";
  public static final String NAVI_MODE_TYPE = "driving";
  public static final String NAVI_SETTINGPAGE_DAYNIGHT_AUTO = "00057";
  public static final String NAVI_SETTINGPAGE_DAYNIGHT_CLICK = "00054";
  public static final String NAVI_SETTINGPAGE_DAYNIGHT_DAY = "00055";
  public static final String NAVI_SETTINGPAGE_DAYNIGHT_NIGHT = "00056";
  public static final String NAVI_SETTINGPAGE_DECLARATION_CLOSE = "00051";
  public static final String NAVI_SETTINGPAGE_DECLARATION_OPEN = "00050";
  public static final String NAVI_SETTINGPAGE_RP_NET_MODE = "01101";
  public static final String NAVI_SETTINGPAGE_RP_OFFLINE = "01102";
  public static final String NAVI_SETTINGPAGE_RP_ONLINE = "01103";
  public static final String NAVI_SETTINGPAGE_SCREEN_CLOSE = "00053";
  public static final String NAVI_SETTINGPAGE_SCREEN_OPEN = "00052";
  public static final String NAVI_SETTING_ELECEYE_VOICE_CLOSE = "00059";
  public static final String NAVI_SETTING_ELECEYE_VOICE_OPEN = "00058";
  public static final String NAVI_SETTING_OVERSPEED_CLOSE = "00061";
  public static final String NAVI_SETTING_OVERSPEED_OPEN = "00060";
  public static final String NAVI_SETTING_STRAIGHT_CLOSE = "00067";
  public static final String NAVI_SETTING_STRAIGHT_OPEN = "00066";
  public static final String NAVI_SETTING_TTS_DOWNLOAD = "00127";
  public static final String NAVI_SPEAK_MODE_CLICK = "00139";
  public static final String NAVI_SPEAK_MODE_QUIET = "00136";
  public static final String NAVI_SPEAK_MODE_SAFE = "00138";
  public static final String NAVI_SPEAK_MODE_SIMPLE = "00137";
  public static final String NAVI_TTS_DOWNLOAD_BACK = "00128";
  public static final String NAVI_TTS_DOWNLOAD_CONTINUE = "00131";
  public static final String NAVI_TTS_DOWNLOAD_ENABLE = "00134";
  public static final String NAVI_TTS_DOWNLOAD_FINISH = "00132";
  public static final String NAVI_TTS_DOWNLOAD_INSTALL = "00133";
  public static final String NAVI_TTS_DOWNLOAD_PAUSE = "00130";
  public static final String NAVI_TTS_DOWNLOAD_RESET = "00135";
  public static final String NAVI_TTS_DOWNLOAD_START = "00129";
  public static final String NAVI_URL = HttpURLManager.getInstance().getScheme() + "client.map.baidu.com/navigation?resid=01";
  
  public class NavUserBehaviourNaviAction
  {
    public static final String BEHAVIOUR_NAVI_ACTION_DOWNLOAD = "download";
    public static final String BEHAVIOUR_NAVI_ACTION_EDOG = "edog";
    public static final String BEHAVIOUR_NAVI_ACTION_IPO = "ipo";
    public static final String BEHAVIOUR_NAVI_ACTION_NAVI = "navi";
    public static final String BEHAVIOUR_NAVI_ACTION_RPLAN = "route_plan";
    public static final String BEHAVIOUR_NAVI_ACTION_SET = "settings";
    public static final String BEHAVIOUR_NAVI_ACTION_YAW = "yaw";
    
    public NavUserBehaviourNaviAction() {}
  }
  
  public class NavUserBehaviourNaviEnter
  {
    public static final String BEHAVIOUR_NAVI_ENTER_MAP_DOWNLOAD = "map_download";
    public static final String BEHAVIOUR_NAVI_ENTER_MAP_EDOG = "map_edog";
    public static final String BEHAVIOUR_NAVI_ENTER_MAP_SET = "map_set";
    public static final String BEHAVIOUR_NAVI_ENTER_NAVING_SET = "naving_set";
    public static final String BEHAVIOUR_NAVI_ENTER_NAV_DOWNLOAD = "nav_download";
    public static final String BEHAVIOUR_NAVI_ENTER_NAV_EDOG = "nav_edog";
    public static final String BEHAVIOUR_NAVI_ENTER_NAV_NAV = "nav_nav";
    public static final String BEHAVIOUR_NAVI_ENTER_NAV_SET = "nav_set";
    public static final String BEHAVIOUR_NAVI_ENTER_ROUTE_NAV = "route_nav";
    
    public NavUserBehaviourNaviEnter() {}
  }
  
  public class NavUserBehaviourNaviNet
  {
    public static final String BEHAVIOUR_NAVI_NET_OFFLINE = "offline";
    public static final String BEHAVIOUR_NAVI_NET_ONLINE = "online";
    
    public NavUserBehaviourNaviNet() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/stat/NavUserBehaviourDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */