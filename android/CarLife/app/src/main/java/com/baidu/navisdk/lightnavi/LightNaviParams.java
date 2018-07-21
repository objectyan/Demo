package com.baidu.navisdk.lightnavi;

import com.baidu.navisdk.util.http.HttpURLManager;

public class LightNaviParams
{
  public static final int CONFIG_VIEW_MODE_INFLATE_MAP = 0;
  public static final int CONFIG_VIEW_MODE_NOT_INFLATE_MAP = 1;
  public static final String DEFAULT_PACKAGE_NAME = "com.baidu.BaiduMap";
  public static final String DEFAULT_SLIGHT_ACTION = "android.intent.baidunavi.slight.lock";
  public static final String LIGHT_NAVI_FLAG = "slight";
  public static final int MSG_TING_PHONE_DOWNLOAD_ERROR_TIPS_HIDE = 2001;
  public static final int MSG_TING_PHONE_TITLE_TIPS_HIDE = 2004;
  public static final int MSG_TING_PHONE_WEAK_NETWORK_TIPS_HIDE = 2003;
  public static final int MSG_TING_PHONE_WEAK_NETWORK_TIPS_SHOW = 2002;
  public static final int MSG_TING_PHONE_WIFI_DOWNLOAD_TIPS_HIDE = 2000;
  public static final int MSG_TYPE_GET_SCREEN_SHOT = 1000;
  public static final int MSG_TYPE_PLAY_TTS = 1001;
  public static final int MSG_TYPE_REMOVE_YELLOW_GUIDE = 3001;
  public static final int MSG_TYPE_REMOVE_YELLOW_SWITCH = 3002;
  public static boolean isGuideHasBeanClose = false;
  public static boolean mGpsInfoHasBeenClosed = false;
  public static int mGpsStatus = 0;
  
  public static abstract interface NetParams
  {
    public static final String GET_MSLIGHT_OFFLINE_URL = "http://cq01-rdqa-dev048.cq01.baidu.com:8040/mop/getmsglist";
    public static final String GET_MSLIGHT_ONLINE_URL = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/mop/getmsglist";
  }
  
  public static abstract interface RefreshType
  {
    public static final int REFRESH_AUTO = 0;
    public static final int REFRESH_MANUAL = -1;
  }
  
  public static abstract interface SwitchSlightParams
  {
    public static final int CHECK_SWITCH_FAILED = 1;
    public static final int CHECK_SWITCH_NET_TIMEOUT = 4;
    public static final int CHECK_SWITCH_NEW_ROUTE = 2;
    public static final int CHECK_SWITCH_NO_NEW_ROUTE = 3;
    public static final int CHECK_SWITCH_SUCCESS = 0;
    public static final int CHECK_SWTICH_INVALID = -1;
  }
  
  public static abstract interface SwitchSlightType
  {
    public static final int INVALID_SWITCH_TYPE = 0;
    public static final int SWITCH_TYPE_NORMAL_TO_SLIGHT = 2;
    public static final int SWITCH_TYPE_SLIGHT_TO_NORMAL = 1;
  }
  
  public static abstract interface YellowBarMsgPriority
  {
    public static final int SLIGHT_GPS = 2;
    public static final int SLIGHT_GUIDE = 4;
    public static final int SLIGHT_JAM = 1;
    public static final int SLIGHT_MAX = 5;
    public static final int SLIGHT_SWITCH = 3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/LightNaviParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */