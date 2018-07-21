package com.baidu.navi.protocol.util;

public class BNaviProtocolDef
{
  public static final String COMMAND_ADD_FAVORITE_BY_FILE = "addFavoriteByFile";
  public static final String COMMAND_GET_FAVORITE = "getFavorite";
  public static final String COMMAND_GET_FAVORITE_AS_FILE = "getFavoriteAsFile";
  public static final String COMMAND_GET_HOME_AND_COMPANY = "getHomeAndCompany";
  public static final String COMMAND_GET_MAP_IMAGE = "getMapImage";
  public static final String COMMAND_GET_MAP_SCALE = "getMapScale";
  public static final String COMMAND_GET_PLUGIN_INFO = "getPluginInfo";
  public static final String COMMAND_GET_STATUS = "getStatus";
  public static final String COMMAND_KEYWORD_SUGGEST = "keywordSuggest";
  public static final String COMMAND_MAP_ZOOM_IN = "mapZoomIn";
  public static final String COMMAND_MAP_ZOOM_OUT = "mapZoomOut";
  public static final String COMMAND_NOTIFY_GUIDE_INFO = "notifyGuideNodeInfo";
  public static final String COMMAND_NOTIFY_MAP_UPDATE = "notifyMapImageUpdate";
  public static final String COMMAND_REROUTE = "reRoute";
  public static final String COMMAND_RESULT = "result";
  public static final String COMMAND_ROUTE_GUIDE_BACKGROUND_NOTIFY = "routeGuideBackgroundNotify";
  public static final String COMMAND_ROUTE_GUIDE_FINIS_NOTIFY = "routeGuideFinishNotify";
  public static final String COMMAND_ROUTE_GUIDE_FOREGROUND_NOTIFY = "routeGuideForegroundNotify";
  public static final String COMMAND_ROUTE_PLAN = "route";
  public static final String COMMAND_SEARCH_BY_KEYWORD = "searchByKeyword";
  public static final String COMMAND_SEARCH_BY_TYPE = "searchByType";
  public static final String COMMAND_SET_IMAGE_SIZE = "setImageSize";
  public static final String COMMAND_START_NAVI = "startNavi";
  public static final String COMMAND_STOP_NAVI = "stopNavi";
  public static final String COMMAND_UPDATE_DEVICE_STATUS = "updateDeviceStatus";
  public static final String COMMAND_UPDATE_LOCATION = "updateLocation";
  public static final String COMMAND_VOICE_RECOGNISE = "voiceRecognise";
  public static final int DEFAULT_IMAGE_HEIGHT = 480;
  public static final int DEFAULT_IMAGE_WIDTH = 400;
  public static final int ERROR_CODE_FAIL = 1;
  public static final int ERROR_CODE_LACK_DATA = 2;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final String KEY_COMMAND_DATA = "data";
  public static final String KEY_COMMAND_ERROR_CODE = "errorCode";
  public static final int VERSION = 2;
  public static String moduleName = "common";
  
  public static String getModuleName()
  {
    return moduleName;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/util/BNaviProtocolDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */