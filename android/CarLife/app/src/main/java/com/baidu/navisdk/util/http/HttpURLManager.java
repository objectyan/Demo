package com.baidu.navisdk.util.http;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageBean;
import com.baidu.navisdk.model.params.TrafficParams.Const;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpURLManager {
    public static final String URL_H5_HTTPS_OFFLINE = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111";
    private static volatile HttpURLManager mInstance;
    public List<DebugModeMessageBean> mGuideMsg = null;
    private Map<String, String> mURLOnlineMap = null;
    private Map<String, String> mURLUseredMap = null;

    public static class ULRParam {
        public static String URL_ALA = "ALA";
        public static String URL_BUSINESS_GET_ACT = "BusinessGetAct";
        public static String URL_BUSINESS_UPLOAD = "BusinessUpload";
        public static String URL_COMMENT_ROUTE = "CommentRoute";
        public static String URL_CRUISE_QA = "CruiseQA";
        public static String URL_DATA_CHECK_NAVI_URL = "DataCheckNaviUrl";
        public static String URL_DEBUG_MODE_GET_URL = "DebugModeGetURL";
        public static String URL_FELLOW_AUTH = "FellowAuth";
        public static String URL_FELLOW_VOICE_UPLOAD = "FellowVoiceUpload";
        public static String URL_INIT_CLOUD_CONFIG = "InitCloudConfig";
        public static String URL_IPO_GET_GUIDE_MSG = "IPOGetGuideMsg";
        public static String URL_LONG_DIS_WEATHER = "GetWeather";
        public static String URL_MARK_FAVOURITE = "MarkFavourite";
        public static String URL_NATIVE_CRASH_UPLOAD_LOG = "NativeCrashUploadLog";
        public static String URL_NATIVE_CRASH_UPLOAD_LOG_NAVI = "NativeCrashUploadLogNavi";
        public static String URL_NATIVE_CRASH_UPLOAD_PROTOCAL = "NativeCrashUploadProtocal";
        public static String URL_NAVI_STAT = "NaviStat";
        public static String URL_NAV_END_SHARE = "FinishPageShare";
        public static String URL_NAV_USER_BEHAVIOUR = "NavUserBehaviour";
        public static String URL_ROAD_CONDITION_CITY_UPDATE = "RoadConditionCityUpdate";
        public static String URL_ROUTE_REPORT_UPLOAD = "UGCReport";
        public static String URL_RUBPOINT_ADSORB = "rubPointAdsorb";
        public static String URL_SAFETY_SHARE = "tuanyuan";
        public static String URL_SKYEYE_POST_LOG = "SkyEyePostLog";
        public static String URL_SKYEYE_USER_STATUS = "SkyEyeUser";
        public static String URL_STREET_SCAPE_REPORT_ERROR = "StreetScapeReportError";
        public static String URL_UGC_EVENT_FEEDBACK = "UgcEventFeedback";
        public static String URL_UGC_GET_COMMENTS = "UgcGetComments";
        public static String URL_UGC_GET_EVENT_DETAIL = "UgcGetEventDetail";
        public static String URL_UGC_OPER_INFO_REPORT = "UGCEventUpload";
        public static String URL_UGC_RCEVENT_COUNTS = "ugcRcEventCounts";
        public static String URL_UGC_RCEVENT_LIST_SHOW = "ugcRcEventListShow";
        public static String URL_UGC_ROUTE_ADDED = "UGCRouteAdded";
        public static String URL_UGC_ROUTE_LOCK_OR_ROUTEBAD = "UGCRouteLockOrRouteBad";
        public static String URL_UGC_TRAFIC_LAG_ERROR = "UGCTraficLagerror";
        public static String URL_VOICE_DETAIL = "VoiceDetail";
        public static String URL_VOICE_SQUARE = "VoiceSquare";
        public static String URL_VOICE_SQUARE_NAVING = "VoiceSquareNaving";
        public static String URL_VOICE_TOPIC = "VoiceTopic";
    }

    private HttpURLManager() {
    }

    public void initUrlData() {
        Object obj;
        if (this.mURLOnlineMap == null) {
            this.mURLOnlineMap = new HashMap();
        } else {
            this.mURLOnlineMap.clear();
        }
        String scheme = getScheme();
        this.mURLOnlineMap.put(ULRParam.URL_NAVI_STAT, scheme + "appnavi.baidu.com/statistics/send");
        this.mURLOnlineMap.put(ULRParam.URL_FELLOW_VOICE_UPLOAD, "http://naviim.baidu.com/naviim/index.php?action=uploadvoice");
        this.mURLOnlineMap.put(ULRParam.URL_FELLOW_AUTH, "http://naviim.baidu.com/naviim/index.php?action=entryauth");
        this.mURLOnlineMap.put(ULRParam.URL_ROAD_CONDITION_CITY_UPDATE, scheme + "its.map.baidu.com/its.php");
        this.mURLOnlineMap.put(ULRParam.URL_ALA, Const.ALA_API_URL);
        this.mURLOnlineMap.put(ULRParam.URL_IPO_GET_GUIDE_MSG, scheme + "appnavi.baidu.com/mop/getmsglist");
        this.mURLOnlineMap.put(ULRParam.URL_DEBUG_MODE_GET_URL, scheme + "navimon.baidu.com/hunter/emode/get");
        this.mURLOnlineMap.put(ULRParam.URL_BUSINESS_GET_ACT, scheme + "appnavi.baidu.com/mop/getacts");
        this.mURLOnlineMap.put(ULRParam.URL_BUSINESS_UPLOAD, scheme + "appnavi.baidu.com/mop/naviend/upload");
        this.mURLOnlineMap.put(ULRParam.URL_NAV_END_SHARE, scheme + "appnavi.baidu.com/mop/naviend/share");
        this.mURLOnlineMap.put(ULRParam.URL_CRUISE_QA, scheme + "appnavi.baidu.com/mop/naviend/upload");
        this.mURLOnlineMap.put(ULRParam.URL_MARK_FAVOURITE, scheme + "appnavi.baidu.com/mop/naviend/markfavourite");
        this.mURLOnlineMap.put(ULRParam.URL_COMMENT_ROUTE, scheme + "navi.map.baidu.com/npb");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_ROUTE_LOCK_OR_ROUTEBAD, scheme + "i.map.baidu.com/api/page/road/roadobstructedorbad");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_TRAFIC_LAG_ERROR, scheme + "i.map.baidu.com/api/page/road/trafficsignswrong");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_ROUTE_ADDED, scheme + "i.map.baidu.com/api/page/road/addroad");
        this.mURLOnlineMap.put(ULRParam.URL_VOICE_SQUARE, BNSettingManager.isUseHttpsOfflineURL() ? "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_list_v2/" : scheme + "webpagenavi.baidu.com/static/webpage/voice_market_list_v2/");
        this.mURLOnlineMap.put(ULRParam.URL_VOICE_DETAIL, BNSettingManager.isUseHttpsOfflineURL() ? "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_details_v2/" : scheme + "webpagenavi.baidu.com/static/webpage/voice_market_details_v2/");
        this.mURLOnlineMap.put(ULRParam.URL_VOICE_TOPIC, BNVoiceParams.VOICE_TOPIC_URL);
        Map map = this.mURLOnlineMap;
        String str = ULRParam.URL_VOICE_SQUARE_NAVING;
        if (BNSettingManager.isUseHttpsOfflineURL()) {
            obj = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/voice_market_navingvoice/navingvoice/";
        } else {
            obj = scheme + "webpagenavi.baidu.com/static/webpage/voice_market_navingvoice/navingvoice/";
        }
        map.put(str, obj);
        this.mURLOnlineMap.put(ULRParam.URL_NATIVE_CRASH_UPLOAD_PROTOCAL, scheme + "client.map.baidu.com/imap/ulog/open");
        this.mURLOnlineMap.put(ULRParam.URL_NATIVE_CRASH_UPLOAD_LOG, scheme + "client.map.baidu.com/imap/ulog/upc");
        this.mURLOnlineMap.put(ULRParam.URL_NATIVE_CRASH_UPLOAD_LOG_NAVI, scheme + "navimon.baidu.com/hunter/log/post");
        this.mURLOnlineMap.put(ULRParam.URL_DATA_CHECK_NAVI_URL, scheme + "appnavi.baidu.com/statistics/sendCheck");
        this.mURLOnlineMap.put(ULRParam.URL_STREET_SCAPE_REPORT_ERROR, scheme + "client.map.baidu.com/streetscape/report.html");
        this.mURLOnlineMap.put(ULRParam.URL_NAV_USER_BEHAVIOUR, scheme + "client.map.baidu.com/navigation?resid=01");
        this.mURLOnlineMap.put(ULRParam.URL_INIT_CLOUD_CONFIG, BNSettingManager.getInitCloudCfg() ? "http://cq02-map-naviapp00.cq02.baidu.com:8320/mop/naviinit" : scheme + "appnavi.baidu.com/mop/naviinit");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_RCEVENT_COUNTS, scheme + "appnavi.baidu.com/mop/ugc/geteventcount");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_RCEVENT_LIST_SHOW, BNSettingManager.isUseHttpsOfflineURL() ? "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/report/index.html" : scheme + "webpagenavi.baidu.com/static/webpage/report/index.html");
        this.mURLOnlineMap.put(ULRParam.URL_ROUTE_REPORT_UPLOAD, scheme + "appnavi.baidu.com/mop/mop/navireport/addintelligence");
        this.mURLOnlineMap.put(ULRParam.URL_LONG_DIS_WEATHER, scheme + "appnavi.baidu.com/mop/long/getweather");
        this.mURLOnlineMap.put(ULRParam.URL_SAFETY_SHARE, scheme + "appnavi.baidu.com/mop/tuanyuan/client");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_GET_EVENT_DETAIL, scheme + "appnavi.baidu.com/mop/ugc/geteventdetail");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_EVENT_FEEDBACK, scheme + "appnavi.baidu.com/mop/ugc/eventfeedback");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_GET_COMMENTS, scheme + "appnavi.baidu.com/mop/ugc/secondarydetail");
        this.mURLOnlineMap.put(ULRParam.URL_UGC_OPER_INFO_REPORT, scheme + "appnavi.baidu.com/mop/navireport/addintelligence");
        this.mURLOnlineMap.put(ULRParam.URL_RUBPOINT_ADSORB, scheme + "appnavi.baidu.com/mop/navireport/coordadsorb");
        this.mURLOnlineMap.put(ULRParam.URL_SKYEYE_USER_STATUS, scheme + "appnavi.baidu.com/naviServerAdmin/skyeye/user");
        this.mURLOnlineMap.put(ULRParam.URL_SKYEYE_POST_LOG, scheme + "appnavi.baidu.com/naviServerAdmin/skyeye/addlog");
        this.mURLUseredMap = new HashMap(this.mURLOnlineMap);
        this.mURLUseredMap = new HashMap(this.mURLOnlineMap);
    }

    public String getUsedUrl(String key) {
        if (this.mURLUseredMap == null) {
            return null;
        }
        String url = (String) this.mURLUseredMap.get(key);
        LogUtil.m15791e("wangyang", "getUsedUrl : key=" + key + ";value=" + url);
        return url;
    }

    public String getOnlineUrl(String key) {
        if (this.mURLOnlineMap != null) {
            return (String) this.mURLOnlineMap.get(key);
        }
        return null;
    }

    public void putUrl(String key, String value) {
        if (this.mURLUseredMap != null) {
            this.mURLUseredMap.put(key, value);
        } else {
            LogUtil.m15791e("wangyang", "HttpURLManager SoftReference is null");
        }
    }

    public boolean containKey(String key) {
        return this.mURLUseredMap.containsKey(key);
    }

    public static HttpURLManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpURLManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpURLManager();
                }
            }
        }
        return mInstance;
    }

    public String getScheme() {
        if (CloudlConfigDataModel.getInstance().mCommonConfig.httpsControl) {
            return "https://";
        }
        return "http://";
    }
}
