package com.baidu.navisdk.hudsdk;

import com.baidu.navisdk.util.http.HttpURLManager;

public class BNRemoteConstants
{
  public static final String AUTHORIZE_FAILED_MSG = "The user is not authorized";
  public static final String AUTHORIZE_SUCCESS_MSG = "BaiduNavi_LOVE_U";
  public static final int CLIENT_COUNT = 5;
  public static final String END_COMMUNICATION = "End_Communication";
  public static final int ERROR_CODE_AUTH_FAILED = 1;
  public static final int ERROR_CODE_DEFAULT = 0;
  public static final String ERROR_DEFAULT_STR = "ok";
  public static final int HUDSDK_CLOSE = 0;
  public static final int HUDSDK_OPEN = 1;
  public static final String HUDSDK_SWITCH_URL_OFFLINE = "http://cp01-rdqa-dev168.cp01.baidu.com:8180/navisdk/hud/check";
  public static final String HUDSDK_SWITCH_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/navisdk/hud/check";
  public static final String IPADDR = "localhost";
  public static final int[] MAP_PORTS_POOL;
  public static final String MODULE_TAG = "BNRemote";
  public static final int[] NAVI_PORTS_POOL = { 9394, 54321, 54322, 54323, 54324, 54325 };
  public static final int PACKET_HEAD_BYTES = 4;
  public static final int PACKET_SPLIT_BYTES = 2;
  public static final int SERVER_BIND_MODE = 1;
  public static final int SOCKET_CONNECT_FAILED = 1;
  public static final int SOCKET_CONNECT_SUCCESS = 0;
  public static final int SOCKET_SERVER_HEART_CHECK_INTER = 90000;
  public static final int SOCKET_SERVER_OPEN_FAILED = 1;
  public static final int SOCKET_SERVER_OPEN_SUCCESS = 0;
  
  static
  {
    MAP_PORTS_POOL = new int[] { 9293, 54326, 54327, 54328, 54329, 54330 };
  }
  
  public static class AssistantType
  {
    public static final int ACCIDENT = 7;
    public static final int BLIND_BEND = 4;
    public static final int BLIND_SLOPE = 5;
    public static final int BRIDGE = 2;
    public static final int CHILDREN = 12;
    public static final int HONK = 18;
    public static final int INTERVAL_CAMERA = 11;
    public static final int JOINT = 0;
    public static final int NARROW = 14;
    public static final int OVER_TAKE_FORBIDEN = 17;
    public static final int PECCANRY_CAMERA = 10;
    public static final int RAILWAY = 3;
    public static final int ROCKFALL = 6;
    public static final int SLIP = 16;
    public static final int SPEED_CAMERA = 8;
    public static final int TRAFFIC_LIGHT_CAMERA = 9;
    public static final int TUNNEL = 1;
    public static final int UNEVEN = 13;
    public static final int VILLAGE = 15;
  }
  
  public static class ClientBindMode
  {
    public static final int BAIDU_MAP_ONLY = 2;
    public static final int BAIDU_NAVI_ONLY = 1;
    public static final int DEFAULT = 0;
  }
  
  public static class HUDDataType
  {
    public static final int HUD_DATA_TYPE_AR = 256;
    public static final int HUD_DATA_TYPE_AssistantMap = 16;
    public static final int HUD_DATA_TYPE_Camera = 8;
    public static final int HUD_DATA_TYPE_CameraAroundCar = 1024;
    public static final int HUD_DATA_TYPE_CarCondition = 4096;
    public static final int HUD_DATA_TYPE_ExpandMap = 32;
    public static final int HUD_DATA_TYPE_HighwayGuide = 4;
    public static final int HUD_DATA_TYPE_Lane = 128;
    public static final int HUD_DATA_TYPE_RoadCondition = 2048;
    public static final int HUD_DATA_TYPE_RouteRemain = 1;
    public static final int HUD_DATA_TYPE_SimpleMap = 2;
    public static final int HUD_DATA_TYPE_TimeLine = 512;
    public static final int HUD_DATA_TYPE_VectorMap = 64;
  }
  
  public static class MessageType
  {
    public static final int BNMessageTypeAssistant = 102;
    public static final int BNMessageTypeAuthorizeRequest = 11;
    public static final int BNMessageTypeAuthorizeRespone = 12;
    public static final int BNMessageTypeCarFreeStatus = 117;
    public static final int BNMessageTypeCarPointInfo = 116;
    public static final int BNMessageTypeCruiseEnd = 111;
    public static final int BNMessageTypeCruiseStart = 110;
    public static final int BNMessageTypeCurrentRoad = 104;
    public static final int BNMessageTypeDefault = -1;
    public static final int BNMessageTypeDestInfo = 115;
    public static final int BNMessageTypeEndCommunication = 13;
    public static final int BNMessageTypeEnlargeRoad = 114;
    public static final int BNMessageTypeGPSLost = 106;
    public static final int BNMessageTypeGPSNormal = 107;
    public static final int BNMessageTypeHeartAlive = 10;
    public static final int BNMessageTypeHeartAliveResponse = 14;
    public static final int BNMessageTypeManeuver = 100;
    public static final int BNMessageTypeNaviEnd = 109;
    public static final int BNMessageTypeNaviStart = 108;
    public static final int BNMessageTypeNearbyCamera = 121;
    public static final int BNMessageTypeNextRoad = 105;
    public static final int BNMessageTypeRemainInfo = 103;
    public static final int BNMessageTypeRouteInfo = 120;
    public static final int BNMessageTypeRoutePlanComplete = 113;
    public static final int BNMessageTypeRoutePlanYawing = 112;
    public static final int BNMessageTypeServiceArea = 101;
    public static final int BNMessageTypeShapeIndexUpdate = 119;
    public static final int BNMessageTypeTunnelUpdate = 118;
  }
  
  public static class ParamKey
  {
    public static final String KEY_AR_ROUTE_LIST = "arRoutList";
    public static final String KEY_ASSISTANT_DISTANCE = "distance";
    public static final String KEY_ASSISTANT_LIMITED_SPEED = "limitedSpeed";
    public static final String KEY_ASSISTANT_TYPE = "assistantType";
    public static final String KEY_ASSISTANT_UPDATE_TYPE = "assistUpdateType";
    public static final String KEY_AUTH_APP_NAME = "packageName";
    public static final String KEY_AUTH_APP_VERSION = "appVersion";
    public static final String KEY_AUTH_HUD_SDK_VERSION = "hudSdkVersion";
    public static final String KEY_AUTH_RES_MSG = "repMsg";
    public static final String KEY_AUTH_SERVER_TYPE = "serverType";
    public static final String KEY_AUTH_SERVER_VERSION = "serverVersion";
    public static final String KEY_CAMEAR_TYPE = "cameraType";
    public static final String KEY_CAMERA_LIST = "cameraList";
    public static final String KEY_CAR_DIRECTION = "angle";
    public static final String KEY_CAR_FREE = "isCarFree";
    public static final String KEY_CAR_LOCATION_INDEX = "shapeIndex";
    public static final String KEY_CAR_POS_ROTATE = "carPosRotate";
    public static final String KEY_CAR_POS_X = "carPosX";
    public static final String KEY_CAR_POS_Y = "carPosY";
    public static final String KEY_CAR_SPEED = "speed";
    public static final String KEY_CAR_TUNNEL = "isInTunnel";
    public static final String KEY_CUR_ROAD_NAME = "currentRoadName";
    public static final String KEY_DEST_ICON = "destIcon";
    public static final String KEY_DEST_TOTAL_DIST = "destTotalDist";
    public static final String KEY_DISTANCE = "distance";
    public static final String KEY_END_MSG = "msg";
    public static final String KEY_ENLARGE_RAOD_DATA_ARROW = "enlargeArrowImage";
    public static final String KEY_ENLARGE_RAOD_DATA_BASIC = "enlargeBasicImage";
    public static final String KEY_ENLARGE_RAOD_SHOW_STATE = "enlargeShowState";
    public static final String KEY_ENLARGE_RAOD_TYPE = "enlargeType";
    public static final String KEY_ENLARGE_ROAD_REMAIN_DIST = "enlargeRemainDist";
    public static final String KEY_ENLARGE_ROAD_TOTAL_DIST = "enlargeTotalDist";
    public static final String KEY_FROM_END_POINT_DIST = "fromEndPointDistance";
    public static final String KEY_FROM_START_DIST = "fromStartDist";
    public static final String KEY_FROM_START_POINT_DIST = "fromStartPointDistance";
    public static final String KEY_LANE_ADD_TYPE_ARRAY = "laneAdditionTypeArray";
    public static final String KEY_LANE_COUNT = "laneCount";
    public static final String KEY_LANE_INFO_LIST = "laneInfoList";
    public static final String KEY_LANE_SIGN_TYPE_ARRAY = "laneSignTypeArray";
    public static final String KEY_LAST_CAR_POS_ROTATE = "lastCarPosRotate";
    public static final String KEY_LAST_CAR_POS_X = "lastCarPosX";
    public static final String KEY_LAST_CAR_POS_Y = "lastCarPosY";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGTITUDE = "longitude";
    public static final String KEY_MANEUVER_DISTANCE = "distance";
    public static final String KEY_MANEUVER_ID = "maneuverId";
    public static final String KEY_MANEUVER_NAME = "maneuverName";
    public static final String KEY_MANEUVER_STRAIGHT = "straight";
    public static final String KEY_MANEUVER_TIPS = "maneuverTips";
    public static final String KEY_MSG_DATA = "data";
    public static final String KEY_MSG_ERRORS = "error";
    public static final String KEY_MSG_ERROR_CODE = "errorCode";
    public static final String KEY_MSG_ERROR_STR = "errorMessage";
    public static final String KEY_MSG_OBJ = "messageData";
    public static final String KEY_MSG_TYPE = "messageType";
    public static final String KEY_NEXT_ROAD_NAME = "nextRoadName";
    public static final String KEY_REMAIN_DISTANCE = "remainDistance";
    public static final String KEY_REMAIN_TIME = "remainTime";
    public static final String KEY_RESTRIT_INFO_LIST = "restritInfoList";
    public static final String KEY_RESTRIT_TYPE = "restrictType";
    public static final String KEY_RING_FLAG = "ringFlag";
    public static final String KEY_ROUTE_ID = "routeID";
    public static final String KEY_ROUTE_TYPE = "routeType";
    public static final String KEY_SERVICE_AREA_DISTANCE = "distance";
    public static final String KEY_SERVICE_AREA_NAME = "serviceArea";
    public static final String KEY_TIME_LINE_LIST = "timeLineList";
    public static final String KEY_TOTAL_LANE_ADD_TYPE = "laneTotalAddType";
  }
  
  public static class ParamValue
  {
    public static final int AR_ROUTE_TYPE_COUNTY_ROAD = 4;
    public static final int AR_ROUTE_TYPE_HIGH_SPEED = 0;
    public static final int AR_ROUTE_TYPE_NATIONAL_ROAD = 2;
    public static final int AR_ROUTE_TYPE_OTHER = 5;
    public static final int AR_ROUTE_TYPE_PROVINCIAL_ROAD = 3;
    public static final int AR_ROUTE_TYPE_QUICK_ROAD = 1;
    public static final int ASSIST_UPDATE_TYPE_HIDE = 2;
    public static final int ASSIST_UPDATE_TYPE_PROCESS_UPDATE = 3;
    public static final int ASSIST_UPDATE_TYPE_SHOW = 0;
    public static final int ASSIST_UPDATE_TYPE_UPDATE = 1;
    public static final int CAMERA_TYPE_LIMIT_SPEED = 1;
    public static final int CAMERA_TYPE_PECCANCY = 3;
    public static final int CAMERA_TYPE_TRAFFIC_LIGHT = 2;
    public static final int CAR_CUR_IN_TUNNEL = 1;
    public static final int CAR_CUR_NOT_IN_TUNNEL = 0;
    public static final int EXPAND_MAP_DEST_STREET_VIEW = 3;
    public static final int EXPAND_MAP_DIRECT_BOARD = 2;
    public static final int EXPAND_MAP_RASTER = 0;
    public static final int EXPAND_MAP_STATE_HIDE = 2;
    public static final int EXPAND_MAP_STATE_SHOW = 0;
    public static final int EXPAND_MAP_STATE_UPDATE = 1;
    public static final int EXPAND_MAP_VECTOR = 1;
    public static final int LANE_BOTH_INCREASING = 3;
    public static final int LANE_LEFT_INCREASING = 1;
    public static final int LANE_NON_INCREASING = 0;
    public static final int LANE_RIGHT_INCREASING = 2;
    public static final int RING_ENTRANCE = 1;
    public static final int RING_EXIT = 2;
    public static final int RING_NON_RING = 0;
  }
  
  public static class PictureType
  {
    public static final int BNPictureTypeJpeg = 1;
    public static final int BNPictureTypePng = 2;
  }
  
  public static class RestrictType
  {
    public static final int RESTRICT_TYPECurveRight = 2;
    public static final int RESTRICT_TYPE_AccidentProne = 28;
    public static final int RESTRICT_TYPE_BidirectionalTraffic = 11;
    public static final int RESTRICT_TYPE_ByPassBoth = 29;
    public static final int RESTRICT_TYPE_ByPassLeft = 30;
    public static final int RESTRICT_TYPE_ByPassRight = 31;
    public static final int RESTRICT_TYPE_Caution = 32;
    public static final int RESTRICT_TYPE_CautionSign = 37;
    public static final int RESTRICT_TYPE_Children = 12;
    public static final int RESTRICT_TYPE_ContinuousDown = 36;
    public static final int RESTRICT_TYPE_CrossWind = 16;
    public static final int RESTRICT_TYPE_CurveContinuous = 4;
    public static final int RESTRICT_TYPE_CurveLeft = 1;
    public static final int RESTRICT_TYPE_CurveReverse = 3;
    public static final int RESTRICT_TYPE_HillsideDangerousLeft = 18;
    public static final int RESTRICT_TYPE_HillsideDangerousRight = 19;
    public static final int RESTRICT_TYPE_Honk = 35;
    public static final int RESTRICT_TYPE_Hump = 45;
    public static final int RESTRICT_TYPE_HumpBridge = 23;
    public static final int RESTRICT_TYPE_Invalid = -1;
    public static final int RESTRICT_TYPE_JointCar = 41;
    public static final int RESTRICT_TYPE_JointLeft = 38;
    public static final int RESTRICT_TYPE_JointRight = 39;
    public static final int RESTRICT_TYPE_LiveStock = 13;
    public static final int RESTRICT_TYPE_LowSpeed = 42;
    public static final int RESTRICT_TYPE_ManagedRailwayCross = 26;
    public static final int RESTRICT_TYPE_NarrowBoth = 7;
    public static final int RESTRICT_TYPE_NarrowBridge = 10;
    public static final int RESTRICT_TYPE_NarrowLeft = 9;
    public static final int RESTRICT_TYPE_NarrowRight = 8;
    public static final int RESTRICT_TYPE_OnDamLeft = 20;
    public static final int RESTRICT_TYPE_OnDamRight = 21;
    public static final int RESTRICT_TYPE_OverTakeForbidden = 33;
    public static final int RESTRICT_TYPE_OverTakeForbiddenRemove = 34;
    public static final int RESTRICT_TYPE_RockfallLeft = 14;
    public static final int RESTRICT_TYPE_RockfallRight = 15;
    public static final int RESTRICT_TYPE_Sinks = 46;
    public static final int RESTRICT_TYPE_Slip = 17;
    public static final int RESTRICT_TYPE_SlopeDown = 6;
    public static final int RESTRICT_TYPE_SlopeUp = 5;
    public static final int RESTRICT_TYPE_StopCar = 40;
    public static final int RESTRICT_TYPE_Tunnel = 43;
    public static final int RESTRICT_TYPE_UnManagedRailwayCross = 27;
    public static final int RESTRICT_TYPE_UnderWater = 25;
    public static final int RESTRICT_TYPE_Uneven = 24;
    public static final int RESTRICT_TYPE_Viliage = 22;
    public static final int RESTRICT_TYPE_WaterRoad = 44;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/BNRemoteConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */