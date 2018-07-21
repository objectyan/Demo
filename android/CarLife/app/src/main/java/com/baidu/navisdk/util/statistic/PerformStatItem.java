package com.baidu.navisdk.util.statistic;

import java.util.HashMap;
import java.util.Map;

public class PerformStatItem
{
  public static final String CALC_ROUTE_PREPARE_STEP_INDEX = "3";
  public static final String CALC_ROUTE_PREPARE_STEP_NAME = "CalcRoutePrepare";
  public static final String DATA_ACTION_TAG = "CarRoutePlanData";
  public static final String DATA_HANDLE_AFTER_LIGHT_STEP_INDEX = "12";
  public static final String DATA_HANDLE_AFTER_LIGHT_STEP_NAME = "DataHandleAfterLight";
  public static final String DATA_SIZE_HANDLE_AFTER_ENGINE_ANALYZE_STEP_INDEX = "15";
  public static final String DATA_SIZE_HANDLE_AFTER_ENGINE_ANALYZE_STEP_NAME = "DataSizeHandleAfterEngineAnalysis";
  public static final String DATA_SIZE_NETWORK_REQUEST_STEP_INDEX = "9";
  public static final String DATA_SIZE_NETWORK_REQUEST_STEP_NAME = "DataSizeNetworkRequest";
  public static final String DATA_SIZE_ROUTE_PLAN_WITH_MULTI_NAVI = "StartRoutePlanBeginWithMultiNavi";
  public static final String DATA_SIZE_ROUTE_PLAN_WITH_MULTI_NAVI_INDEX = "14";
  public static final String ENGINE_DATA_ANALYSIS_ORGANIZATION_STEP_INDEX = "15";
  public static final String ENGINE_DATA_ANALYSIS_ORGANIZATION_STEP_NAME = "EngineDataAnalysisAndOrganization";
  public static final String GET_ENGINE_CALC_DATA_STEP_INDEX = "16";
  public static final String GET_ENGINE_CALC_DATA_STEP_NAME = "GetEngineCalcData";
  public static final int LOG_LEVEL_LOW = 1;
  public static final int LOG_TYPE_MONITOR_UI_PAGE = 2110;
  public static final String MAP_ENGINE_MODULE_NAME = "MapEngine";
  public static final String MAP_MODULE_NAME = "MapBaseLine";
  public static final String NAVI_ENGINE_MODULE_NAME = "NaviEngine";
  public static final String NAVI_MODULE_NAME = "NaviSDK";
  public static final String NETWORK_REQUEST_STEP_INDEX = "9";
  public static final String NETWORK_REQUEST_STEP_NAME = "NetworkRequest";
  public static final String POICARNAVITIME_ACTION_TAG = "PoiCarNaviTime";
  public static final boolean[] P_LOGGABLE;
  public static final String PoiToNaviStep10 = "发起跳转导航界面v2";
  public static final String PoiToNaviStep11 = "导航界面生命周期开始v2";
  public static final String PoiToNaviStep12 = "导航界面生命周期显示v2";
  public static final String PoiToNaviStep2 = "基线到适配层v2";
  public static final String PoiToNaviStep3 = "适配层到SDKv2";
  public static final String PoiToNaviStep4 = "SDK到引擎v2";
  public static final String PoiToNaviStep8 = "引擎算路到SDK收到消息v2";
  public static final String PoiToNaviStep9 = "SDK到适配层v2";
  public static final String REQUEST_MAP_LIGHT_SERVICE_STEP_INDEX = "7";
  public static final String REQUEST_MAP_LIGHT_SERVICE_STEP_NAME = "RequestMapLightService";
  public static final String ROUTEPAGECARNAVITIME_ACTION_TAG = "CarNaviTime";
  public static final String ROUTE_PLAN_BEGIN_WITH_NODE = "RoutePlanBeginWithRouteNode";
  public static final String ROUTE_PLAN_BEGIN_WITH_NODE_INDEX = "5";
  public static final String ROUTE_PLAN_WITH_MULTI_NAVI = "StartRoutePlanBeginWithMultiNavi";
  public static final String ROUTE_PLAN_WITH_MULTI_NAVI_INDEX = "14";
  public static final String RP_SUCCESS_NORMAL_STEP_FIRST_INDEX = "17.1";
  public static final String RP_SUCCESS_NORMAL_STEP_FIRST_NAME = "GetRoutePlanResultMapProtoBuf";
  public static final String RP_SUCCESS_NORMAL_STEP_INDEX = "17";
  public static final String RP_SUCCESS_NORMAL_STEP_NAME = "RoutePlanSuccess";
  public static final String RoutePageToNaviStep2 = "基线到适配层";
  public static final String RoutePageToNaviStep3 = "适配层到SDK";
  public static final String RoutePageToNaviStep4 = "创建导航页面UI前的操作";
  public static final String RoutePageToNaviStep5 = "页面周期开始函数";
  public static final String RoutePageToNaviStep6 = "页面周期显示函数";
  public static final String TIME_ACTION_TAG = "CarRoutePlanTime";
  public static final int TYPE_BASE = 0;
  public static final int TYPE_NAVI_INIT = 3;
  public static final int TYPE_NAVI_RESULT = 8;
  public static final int TYPE_NORMAL_TO_ROUTEPAGE = 6;
  public static final int TYPE_OPENAPI_TO_NAVI = 4;
  public static final int TYPE_OPENAPI_TO_ROUTEPAGE = 5;
  public static final int TYPE_POI_TO_NAVI = 1;
  public static final int TYPE_QUIT_NAVI = 7;
  public static final int TYPE_ROUTEPAGE_TO_NAVI = 2;
  public static boolean sBatchTestNetworkAndServerTime;
  public static long sCalcRoutePrepareStart;
  public static long sDataHandleAfterLightStart;
  public static boolean sEnableTestData;
  public static long sGetEngineCalcDataStart;
  public static boolean sIsSatelliteFlashForPerform;
  public static long sNetWorkRequestStart;
  public static long sPoiToNaviTime1;
  public static long sPoiToNaviTime10 = 0L;
  public static long sPoiToNaviTime11 = 0L;
  public static long sPoiToNaviTime12 = 0L;
  public static long sPoiToNaviTime2;
  public static long sPoiToNaviTime3;
  public static long sPoiToNaviTime4;
  public static long sPoiToNaviTime8;
  public static long sPoiToNaviTime9;
  public static long sRequestMapLightServiceStart;
  public static long sRoutePageToNaviTime1 = 0L;
  public static long sRoutePageToNaviTime2 = 0L;
  public static long sRoutePageToNaviTime3 = 0L;
  public static long sRoutePageToNaviTime4 = 0L;
  public static long sRoutePageToNaviTime5 = 0L;
  public static long sRoutePageToNaviTime6 = 0L;
  public static long sRoutePlanBeginWithRouteNodeStart;
  public static long sRoutePlanSuccessNormalFirstStart;
  public static long sRoutePlanSuccessNormalStart;
  public static long sRoutePlanWithMultiNaviStart;
  public static Map<String, Long> sTimeMap;
  public static boolean sUserTest = false;
  
  static
  {
    sEnableTestData = false;
    sBatchTestNetworkAndServerTime = sUserTest & false;
    P_LOGGABLE = new boolean[] { sUserTest & true, sUserTest & true, sUserTest & true, sUserTest & true, sUserTest & false, sUserTest & false, sUserTest & false, sUserTest & true, sUserTest & true };
    sTimeMap = new HashMap();
    sIsSatelliteFlashForPerform = true;
    sCalcRoutePrepareStart = 0L;
    sDataHandleAfterLightStart = 0L;
    sRequestMapLightServiceStart = 0L;
    sNetWorkRequestStart = 0L;
    sGetEngineCalcDataStart = 0L;
    sRoutePlanSuccessNormalStart = 0L;
    sRoutePlanSuccessNormalFirstStart = 0L;
    sRoutePlanWithMultiNaviStart = 0L;
    sRoutePlanBeginWithRouteNodeStart = 0L;
    sPoiToNaviTime1 = 0L;
    sPoiToNaviTime2 = 0L;
    sPoiToNaviTime3 = 0L;
    sPoiToNaviTime4 = 0L;
    sPoiToNaviTime8 = 0L;
    sPoiToNaviTime9 = 0L;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/PerformStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */