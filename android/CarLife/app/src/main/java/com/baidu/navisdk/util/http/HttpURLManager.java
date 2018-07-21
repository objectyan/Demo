package com.baidu.navisdk.util.http;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageBean;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpURLManager
{
  public static final String URL_H5_HTTPS_OFFLINE = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111";
  private static volatile HttpURLManager mInstance;
  public List<DebugModeMessageBean> mGuideMsg = null;
  private Map<String, String> mURLOnlineMap = null;
  private Map<String, String> mURLUseredMap = null;
  
  public static HttpURLManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new HttpURLManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public boolean containKey(String paramString)
  {
    return this.mURLUseredMap.containsKey(paramString);
  }
  
  public String getOnlineUrl(String paramString)
  {
    if (this.mURLOnlineMap != null) {
      return (String)this.mURLOnlineMap.get(paramString);
    }
    return null;
  }
  
  public String getScheme()
  {
    if (CloudlConfigDataModel.getInstance().mCommonConfig.httpsControl) {
      return "https://";
    }
    return "http://";
  }
  
  public String getUsedUrl(String paramString)
  {
    if (this.mURLUseredMap != null)
    {
      String str = (String)this.mURLUseredMap.get(paramString);
      LogUtil.e("wangyang", "getUsedUrl : key=" + paramString + ";value=" + str);
      return str;
    }
    return null;
  }
  
  public void initUrlData()
  {
    String str2;
    Map localMap;
    String str3;
    if (this.mURLOnlineMap == null)
    {
      this.mURLOnlineMap = new HashMap();
      str2 = getScheme();
      this.mURLOnlineMap.put(ULRParam.URL_NAVI_STAT, str2 + "appnavi.baidu.com/statistics/send");
      this.mURLOnlineMap.put(ULRParam.URL_FELLOW_VOICE_UPLOAD, "http://naviim.baidu.com/naviim/index.php?action=uploadvoice");
      this.mURLOnlineMap.put(ULRParam.URL_FELLOW_AUTH, "http://naviim.baidu.com/naviim/index.php?action=entryauth");
      this.mURLOnlineMap.put(ULRParam.URL_ROAD_CONDITION_CITY_UPDATE, str2 + "its.map.baidu.com/its.php");
      this.mURLOnlineMap.put(ULRParam.URL_ALA, "http://opendata.baidu.com");
      this.mURLOnlineMap.put(ULRParam.URL_IPO_GET_GUIDE_MSG, str2 + "appnavi.baidu.com/mop/getmsglist");
      this.mURLOnlineMap.put(ULRParam.URL_DEBUG_MODE_GET_URL, str2 + "navimon.baidu.com/hunter/emode/get");
      this.mURLOnlineMap.put(ULRParam.URL_BUSINESS_GET_ACT, str2 + "appnavi.baidu.com/mop/getacts");
      this.mURLOnlineMap.put(ULRParam.URL_BUSINESS_UPLOAD, str2 + "appnavi.baidu.com/mop/naviend/upload");
      this.mURLOnlineMap.put(ULRParam.URL_NAV_END_SHARE, str2 + "appnavi.baidu.com/mop/naviend/share");
      this.mURLOnlineMap.put(ULRParam.URL_CRUISE_QA, str2 + "appnavi.baidu.com/mop/naviend/upload");
      this.mURLOnlineMap.put(ULRParam.URL_MARK_FAVOURITE, str2 + "appnavi.baidu.com/mop/naviend/markfavourite");
      this.mURLOnlineMap.put(ULRParam.URL_COMMENT_ROUTE, str2 + "navi.map.baidu.com/npb");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_ROUTE_LOCK_OR_ROUTEBAD, str2 + "i.map.baidu.com/api/page/road/roadobstructedorbad");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_TRAFIC_LAG_ERROR, str2 + "i.map.baidu.com/api/page/road/trafficsignswrong");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_ROUTE_ADDED, str2 + "i.map.baidu.com/api/page/road/addroad");
      localMap = this.mURLOnlineMap;
      str3 = ULRParam.URL_VOICE_SQUARE;
      if (!BNSettingManager.isUseHttpsOfflineURL()) {
        break label1242;
      }
      str1 = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_list_v2/";
      label503:
      localMap.put(str3, str1);
      localMap = this.mURLOnlineMap;
      str3 = ULRParam.URL_VOICE_DETAIL;
      if (!BNSettingManager.isUseHttpsOfflineURL()) {
        break label1266;
      }
      str1 = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_details_v2/";
      label532:
      localMap.put(str3, str1);
      this.mURLOnlineMap.put(ULRParam.URL_VOICE_TOPIC, "http://webpage.navi.baidu.com/static/webpage/voice_market_topic/clasic/");
      localMap = this.mURLOnlineMap;
      str3 = ULRParam.URL_VOICE_SQUARE_NAVING;
      if (!BNSettingManager.isUseHttpsOfflineURL()) {
        break label1290;
      }
      str1 = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_navingvoice/navingvoice/";
      label576:
      localMap.put(str3, str1);
      this.mURLOnlineMap.put(ULRParam.URL_NATIVE_CRASH_UPLOAD_PROTOCAL, str2 + "client.map.baidu.com/imap/ulog/open");
      this.mURLOnlineMap.put(ULRParam.URL_NATIVE_CRASH_UPLOAD_LOG, str2 + "client.map.baidu.com/imap/ulog/upc");
      this.mURLOnlineMap.put(ULRParam.URL_NATIVE_CRASH_UPLOAD_LOG_NAVI, str2 + "navimon.baidu.com/hunter/log/post");
      this.mURLOnlineMap.put(ULRParam.URL_DATA_CHECK_NAVI_URL, str2 + "appnavi.baidu.com/statistics/sendCheck");
      this.mURLOnlineMap.put(ULRParam.URL_STREET_SCAPE_REPORT_ERROR, str2 + "client.map.baidu.com/streetscape/report.html");
      this.mURLOnlineMap.put(ULRParam.URL_NAV_USER_BEHAVIOUR, str2 + "client.map.baidu.com/navigation?resid=01");
      localMap = this.mURLOnlineMap;
      str3 = ULRParam.URL_INIT_CLOUD_CONFIG;
      if (!BNSettingManager.getInitCloudCfg()) {
        break label1314;
      }
      str1 = "http://cq02-map-naviapp00.cq02.baidu.com:8320/mop/naviinit";
      label797:
      localMap.put(str3, str1);
      this.mURLOnlineMap.put(ULRParam.URL_UGC_RCEVENT_COUNTS, str2 + "appnavi.baidu.com/mop/ugc/geteventcount");
      localMap = this.mURLOnlineMap;
      str3 = ULRParam.URL_UGC_RCEVENT_LIST_SHOW;
      if (!BNSettingManager.isUseHttpsOfflineURL()) {
        break label1338;
      }
    }
    label1242:
    label1266:
    label1290:
    label1314:
    label1338:
    for (String str1 = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/report/index.html";; str1 = str2 + "webpagenavi.baidu.com/static/webpage/report/index.html")
    {
      localMap.put(str3, str1);
      this.mURLOnlineMap.put(ULRParam.URL_ROUTE_REPORT_UPLOAD, str2 + "appnavi.baidu.com/mop/mop/navireport/addintelligence");
      this.mURLOnlineMap.put(ULRParam.URL_LONG_DIS_WEATHER, str2 + "appnavi.baidu.com/mop/long/getweather");
      this.mURLOnlineMap.put(ULRParam.URL_SAFETY_SHARE, str2 + "appnavi.baidu.com/mop/tuanyuan/client");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_GET_EVENT_DETAIL, str2 + "appnavi.baidu.com/mop/ugc/geteventdetail");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_EVENT_FEEDBACK, str2 + "appnavi.baidu.com/mop/ugc/eventfeedback");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_GET_COMMENTS, str2 + "appnavi.baidu.com/mop/ugc/secondarydetail");
      this.mURLOnlineMap.put(ULRParam.URL_UGC_OPER_INFO_REPORT, str2 + "appnavi.baidu.com/mop/navireport/addintelligence");
      this.mURLOnlineMap.put(ULRParam.URL_RUBPOINT_ADSORB, str2 + "appnavi.baidu.com/mop/navireport/coordadsorb");
      this.mURLOnlineMap.put(ULRParam.URL_SKYEYE_USER_STATUS, str2 + "appnavi.baidu.com/naviServerAdmin/skyeye/user");
      this.mURLOnlineMap.put(ULRParam.URL_SKYEYE_POST_LOG, str2 + "appnavi.baidu.com/naviServerAdmin/skyeye/addlog");
      this.mURLUseredMap = new HashMap(this.mURLOnlineMap);
      this.mURLUseredMap = new HashMap(this.mURLOnlineMap);
      return;
      this.mURLOnlineMap.clear();
      break;
      str1 = str2 + "webpagenavi.baidu.com/static/webpage/voice_market_list_v2/";
      break label503;
      str1 = str2 + "webpagenavi.baidu.com/static/webpage/voice_market_details_v2/";
      break label532;
      str1 = str2 + "webpagenavi.baidu.com/static/webpage/voice_market_navingvoice/navingvoice/";
      break label576;
      str1 = str2 + "appnavi.baidu.com/mop/naviinit";
      break label797;
    }
  }
  
  public void putUrl(String paramString1, String paramString2)
  {
    if (this.mURLUseredMap != null)
    {
      this.mURLUseredMap.put(paramString1, paramString2);
      return;
    }
    LogUtil.e("wangyang", "HttpURLManager SoftReference is null");
  }
  
  public static class ULRParam
  {
    public static String URL_ALA;
    public static String URL_BUSINESS_GET_ACT;
    public static String URL_BUSINESS_UPLOAD;
    public static String URL_COMMENT_ROUTE;
    public static String URL_CRUISE_QA;
    public static String URL_DATA_CHECK_NAVI_URL;
    public static String URL_DEBUG_MODE_GET_URL;
    public static String URL_FELLOW_AUTH;
    public static String URL_FELLOW_VOICE_UPLOAD;
    public static String URL_INIT_CLOUD_CONFIG;
    public static String URL_IPO_GET_GUIDE_MSG;
    public static String URL_LONG_DIS_WEATHER;
    public static String URL_MARK_FAVOURITE;
    public static String URL_NATIVE_CRASH_UPLOAD_LOG;
    public static String URL_NATIVE_CRASH_UPLOAD_LOG_NAVI;
    public static String URL_NATIVE_CRASH_UPLOAD_PROTOCAL;
    public static String URL_NAVI_STAT = "NaviStat";
    public static String URL_NAV_END_SHARE;
    public static String URL_NAV_USER_BEHAVIOUR;
    public static String URL_ROAD_CONDITION_CITY_UPDATE;
    public static String URL_ROUTE_REPORT_UPLOAD;
    public static String URL_RUBPOINT_ADSORB;
    public static String URL_SAFETY_SHARE;
    public static String URL_SKYEYE_POST_LOG = "SkyEyePostLog";
    public static String URL_SKYEYE_USER_STATUS;
    public static String URL_STREET_SCAPE_REPORT_ERROR;
    public static String URL_UGC_EVENT_FEEDBACK;
    public static String URL_UGC_GET_COMMENTS;
    public static String URL_UGC_GET_EVENT_DETAIL;
    public static String URL_UGC_OPER_INFO_REPORT;
    public static String URL_UGC_RCEVENT_COUNTS;
    public static String URL_UGC_RCEVENT_LIST_SHOW;
    public static String URL_UGC_ROUTE_ADDED;
    public static String URL_UGC_ROUTE_LOCK_OR_ROUTEBAD;
    public static String URL_UGC_TRAFIC_LAG_ERROR;
    public static String URL_VOICE_DETAIL;
    public static String URL_VOICE_SQUARE;
    public static String URL_VOICE_SQUARE_NAVING;
    public static String URL_VOICE_TOPIC;
    
    static
    {
      URL_FELLOW_VOICE_UPLOAD = "FellowVoiceUpload";
      URL_FELLOW_AUTH = "FellowAuth";
      URL_IPO_GET_GUIDE_MSG = "IPOGetGuideMsg";
      URL_DEBUG_MODE_GET_URL = "DebugModeGetURL";
      URL_ROAD_CONDITION_CITY_UPDATE = "RoadConditionCityUpdate";
      URL_ALA = "ALA";
      URL_CRUISE_QA = "CruiseQA";
      URL_MARK_FAVOURITE = "MarkFavourite";
      URL_COMMENT_ROUTE = "CommentRoute";
      URL_BUSINESS_GET_ACT = "BusinessGetAct";
      URL_BUSINESS_UPLOAD = "BusinessUpload";
      URL_NAV_END_SHARE = "FinishPageShare";
      URL_UGC_ROUTE_LOCK_OR_ROUTEBAD = "UGCRouteLockOrRouteBad";
      URL_UGC_TRAFIC_LAG_ERROR = "UGCTraficLagerror";
      URL_UGC_ROUTE_ADDED = "UGCRouteAdded";
      URL_VOICE_SQUARE = "VoiceSquare";
      URL_VOICE_DETAIL = "VoiceDetail";
      URL_VOICE_TOPIC = "VoiceTopic";
      URL_VOICE_SQUARE_NAVING = "VoiceSquareNaving";
      URL_NATIVE_CRASH_UPLOAD_PROTOCAL = "NativeCrashUploadProtocal";
      URL_NATIVE_CRASH_UPLOAD_LOG = "NativeCrashUploadLog";
      URL_NATIVE_CRASH_UPLOAD_LOG_NAVI = "NativeCrashUploadLogNavi";
      URL_DATA_CHECK_NAVI_URL = "DataCheckNaviUrl";
      URL_STREET_SCAPE_REPORT_ERROR = "StreetScapeReportError";
      URL_NAV_USER_BEHAVIOUR = "NavUserBehaviour";
      URL_UGC_GET_EVENT_DETAIL = "UgcGetEventDetail";
      URL_UGC_EVENT_FEEDBACK = "UgcEventFeedback";
      URL_UGC_GET_COMMENTS = "UgcGetComments";
      URL_INIT_CLOUD_CONFIG = "InitCloudConfig";
      URL_UGC_OPER_INFO_REPORT = "UGCEventUpload";
      URL_UGC_RCEVENT_LIST_SHOW = "ugcRcEventListShow";
      URL_UGC_RCEVENT_COUNTS = "ugcRcEventCounts";
      URL_ROUTE_REPORT_UPLOAD = "UGCReport";
      URL_LONG_DIS_WEATHER = "GetWeather";
      URL_SAFETY_SHARE = "tuanyuan";
      URL_RUBPOINT_ADSORB = "rubPointAdsorb";
      URL_SKYEYE_USER_STATUS = "SkyEyeUser";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/HttpURLManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */