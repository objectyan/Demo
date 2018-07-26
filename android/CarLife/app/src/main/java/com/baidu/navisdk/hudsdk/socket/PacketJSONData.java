package com.baidu.navisdk.hudsdk.socket;

import android.os.Bundle;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.ExpandMap;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.MessageType;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.hudsdk.BitmapUtils;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PacketJSONData {
    public static JSONObject packetJSONData(int type, Bundle arg) throws JSONException {
        JSONObject msgDataJson;
        JSONObject msgJson = new JSONObject();
        JSONObject msgErrorJson = new JSONObject();
        switch (type) {
            case 100:
                msgDataJson = packetManeuver();
                break;
            case 101:
                msgDataJson = packetServiceArea();
                break;
            case 102:
                msgDataJson = packetAssistant();
                break;
            case 103:
                msgDataJson = packetDestRemainInfo();
                break;
            case 104:
                msgDataJson = packetCurrentRoad();
                break;
            case 105:
                msgDataJson = packetNextRoad();
                break;
            case 115:
                msgDataJson = packetDestInfo(arg);
                break;
            case 116:
                msgDataJson = packetCarPointInfo(arg);
                break;
            case MessageType.BNMessageTypeCarFreeStatus /*117*/:
                msgDataJson = packetCarFreeStatus();
                break;
            case MessageType.BNMessageTypeTunnelUpdate /*118*/:
                msgDataJson = packetCarTunnelInfo(arg);
                break;
            case 119:
                msgDataJson = packetShapeIndexUpdate(arg);
                break;
            case 120:
                msgDataJson = packetRouteInfo(arg);
                break;
            case 121:
                msgDataJson = packetNearByCamera();
                break;
            default:
                msgDataJson = new JSONObject();
                JSONObject msgObjJson = new JSONObject();
                msgDataJson.put(ParamKey.KEY_MSG_TYPE, type);
                msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
                break;
        }
        msgErrorJson.put("errorCode", 0);
        msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.ERROR_DEFAULT_STR);
        msgJson.put("data", msgDataJson);
        msgJson.put(ParamKey.KEY_MSG_ERRORS, msgErrorJson);
        return msgJson;
    }

    public static JSONObject packetAuthRes(boolean isSuccess) throws JSONException {
        JSONObject msgJson = new JSONObject();
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgErrorJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 12);
        if (isSuccess) {
            msgObjJson.put(ParamKey.KEY_AUTH_SERVER_TYPE, 1);
            msgObjJson.put(ParamKey.KEY_AUTH_SERVER_VERSION, PackageUtil.getVersionName());
            msgObjJson.put(ParamKey.KEY_AUTH_RES_MSG, "AUTHORIZE_SUCCESS_MSG");
            msgErrorJson.put("errorCode", 0);
            msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.ERROR_DEFAULT_STR);
        } else {
            msgErrorJson.put("errorCode", 1);
            msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.AUTHORIZE_FAILED_MSG);
        }
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        msgJson.put("data", msgDataJson);
        msgJson.put(ParamKey.KEY_MSG_ERRORS, msgErrorJson);
        return msgJson;
    }

    public static JSONObject packetPong() throws JSONException {
        JSONObject msgJson = new JSONObject();
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgErrorJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 14);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        msgErrorJson.put("errorCode", 0);
        msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.ERROR_DEFAULT_STR);
        msgJson.put("data", msgDataJson);
        msgJson.put(ParamKey.KEY_MSG_ERRORS, msgErrorJson);
        return msgJson;
    }

    public static JSONObject packetServerExit() throws JSONException {
        JSONObject msgJson = new JSONObject();
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgErrorJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 13);
        msgObjJson.put("msg", BNRemoteConstants.END_COMMUNICATION);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        msgErrorJson.put("errorCode", 0);
        msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.ERROR_DEFAULT_STR);
        msgJson.put("data", msgDataJson);
        msgJson.put(ParamKey.KEY_MSG_ERRORS, msgErrorJson);
        return msgJson;
    }

    private static JSONObject packetManeuver() throws JSONException {
        ArrayList<Integer> collectionArray;
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        int remainDist = -1;
        boolean isStraight = false;
        String nextRoadName = "";
        String curRoadName = "";
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 100);
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.RoadID)) {
            msgObjJson.put(ParamKey.KEY_MANEUVER_ID, RGSimpleGuideModel.sSimpleGuideBundle.getInt(SimpleGuideInfo.RoadID));
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("icon_name")) {
            String turnIconName = RGSimpleGuideModel.sSimpleGuideBundle.getString("icon_name");
            if (turnIconName != null) {
                msgObjJson.put(ParamKey.KEY_MANEUVER_NAME, turnIconName.replace(BNDrivingToolParams.RESOURCE_PICTURE_SUFFIX, "").toLowerCase());
            } else {
                msgObjJson.put(ParamKey.KEY_MANEUVER_NAME, "");
            }
        } else {
            msgObjJson.put(ParamKey.KEY_MANEUVER_NAME, "");
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("straight")) {
            isStraight = RGSimpleGuideModel.sSimpleGuideBundle.getInt("straight", 0) > 0;
            msgObjJson.put("straight", isStraight);
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.RemainDist)) {
            remainDist = RGSimpleGuideModel.sSimpleGuideBundle.getInt(SimpleGuideInfo.RemainDist);
            msgObjJson.put("distance", remainDist);
        } else {
            msgObjJson.put("distance", 0);
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("road_name")) {
            nextRoadName = RGSimpleGuideModel.sSimpleGuideBundle.getString("road_name");
            msgObjJson.put(ParamKey.KEY_NEXT_ROAD_NAME, nextRoadName);
        } else {
            msgObjJson.put(ParamKey.KEY_NEXT_ROAD_NAME, nextRoadName);
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.CurRoadName)) {
            curRoadName = RGSimpleGuideModel.sSimpleGuideBundle.getString(SimpleGuideInfo.CurRoadName);
        }
        String simpleRGTips = "";
        int resId = -1;
        String goLable = "";
        String frontInfo = RGSimpleGuideModel.getInstance().getFormatAfterMeters(remainDist);
        Bundle simpleBundle = RGSimpleGuideModel.getInstance().getNextGuideInfo();
        if (simpleBundle != null) {
            resId = simpleBundle.getInt("resid");
        }
        if (resId == 0 || !(resId == 1711407751 || resId == 1711407752 || resId == 1711407704 || resId == 1711407705)) {
            goLable = BNStyleManager.getString(C4048R.string.nsdk_string_rg_come_in);
        } else {
            goLable = BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_word);
        }
        if (isStraight) {
            simpleRGTips = "沿" + curRoadName + "行驶" + frontInfo;
        } else {
            simpleRGTips = frontInfo + "后" + goLable + nextRoadName;
        }
        msgObjJson.put(ParamKey.KEY_MANEUVER_TIPS, simpleRGTips);
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.RoadPosX)) {
            msgObjJson.put("longitude", RGSimpleGuideModel.sSimpleGuideBundle.getDouble(SimpleGuideInfo.RoadPosX));
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.RoadPoxY)) {
            msgObjJson.put("latitude", RGSimpleGuideModel.sSimpleGuideBundle.getDouble(SimpleGuideInfo.RoadPoxY));
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("ringFlag")) {
            msgObjJson.put("ringFlag", RGSimpleGuideModel.sSimpleGuideBundle.getInt("ringFlag"));
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("laneCount")) {
            msgObjJson.put("laneCount", RGSimpleGuideModel.sSimpleGuideBundle.getInt("laneCount"));
        } else {
            msgObjJson.put("laneCount", 0);
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.LaneAddType)) {
            try {
                msgObjJson.put(ParamKey.KEY_TOTAL_LANE_ADD_TYPE, RGSimpleGuideModel.sSimpleGuideBundle.getInt(SimpleGuideInfo.LaneAddType));
            } catch (JSONException e) {
            }
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.LaneAddTypeArray)) {
            int[] laneAddTypeArray = RGSimpleGuideModel.sSimpleGuideBundle.getIntArray(SimpleGuideInfo.LaneAddTypeArray);
            if (laneAddTypeArray != null && laneAddTypeArray.length > 0) {
                collectionArray = new ArrayList();
                for (int valueOf : laneAddTypeArray) {
                    collectionArray.add(Integer.valueOf(valueOf));
                }
                msgObjJson.put(ParamKey.KEY_LANE_ADD_TYPE_ARRAY, new JSONArray(collectionArray));
            }
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.LaneSignArray)) {
            int[] laneSignArray = RGSimpleGuideModel.sSimpleGuideBundle.getIntArray(SimpleGuideInfo.LaneSignArray);
            if (laneSignArray != null && laneSignArray.length > 0) {
                collectionArray = new ArrayList();
                for (int valueOf2 : laneSignArray) {
                    collectionArray.add(Integer.valueOf(valueOf2));
                }
                msgObjJson.put(ParamKey.KEY_LANE_SIGN_TYPE_ARRAY, new JSONArray(collectionArray));
            }
        }
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetServiceArea() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 101);
        msgObjJson.put(ParamKey.KEY_SERVICE_AREA_NAME, RGHighwayModel.getInstance().getServiceName());
        msgObjJson.put("distance", RGHighwayModel.getInstance().getServiceRemainDist());
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetAssistant() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        int assistType = RGAssistGuideModel.getInstance().getLastestData().getInt("assisttype");
        int assistUpdateType = RGAssistGuideModel.getInstance().getLastestData().getInt("updatetype");
        int assistSpeed = RGAssistGuideModel.getInstance().getLastestData().getInt("speed");
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 102);
        msgObjJson.put(ParamKey.KEY_ASSISTANT_TYPE, assistType);
        msgObjJson.put(ParamKey.KEY_ASSISTANT_UPDATE_TYPE, assistUpdateType);
        if ((assistType == 8 || assistType == 11) && assistUpdateType != 3) {
            assistSpeed /= 1000;
        }
        msgObjJson.put(ParamKey.KEY_ASSISTANT_LIMITED_SPEED, assistSpeed);
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey(SimpleGuideInfo.RemainDist)) {
            msgObjJson.put("distance", RGSimpleGuideModel.sSimpleGuideBundle.getInt(SimpleGuideInfo.RemainDist));
        } else {
            msgObjJson.put("distance", 0);
        }
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    public static JSONObject packetDestRemainInfo(int totalDistance, int totalTime) throws JSONException {
        JSONObject msgJson = new JSONObject();
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgErrorJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 103);
        msgObjJson.put("remainDistance", totalDistance);
        msgObjJson.put("remainTime", totalTime);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        msgErrorJson.put("errorCode", 0);
        msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.ERROR_DEFAULT_STR);
        msgJson.put("data", msgDataJson);
        msgJson.put(ParamKey.KEY_MSG_ERRORS, msgErrorJson);
        return msgJson;
    }

    private static JSONObject packetDestRemainInfo() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 103);
        if (RGSimpleGuideModel.getInstance().getTotalInfo().containsKey(SimpleGuideInfo.TotalDist)) {
            msgObjJson.put("remainDistance", RGSimpleGuideModel.getInstance().getTotalInfo().getInt(SimpleGuideInfo.TotalDist));
        } else {
            msgObjJson.put("remainDistance", 0);
        }
        if (RGSimpleGuideModel.getInstance().getTotalInfo().containsKey(SimpleGuideInfo.TotalTime)) {
            msgObjJson.put("remainTime", RGSimpleGuideModel.getInstance().getTotalInfo().getInt(SimpleGuideInfo.TotalTime));
        } else {
            msgObjJson.put("remainTime", 0);
        }
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetCurrentRoad() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 104);
        msgObjJson.put(ParamKey.KEY_CUR_ROAD_NAME, RGSimpleGuideModel.getInstance().getCurRoadName());
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetNextRoad() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 105);
        msgObjJson.put(ParamKey.KEY_NEXT_ROAD_NAME, RGSimpleGuideModel.sSimpleGuideBundle.getString("road_name"));
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    public static JSONObject packetEnlargeRoad(int enlargeType, int enlargeState) throws JSONException {
        JSONObject msgJson = new JSONObject();
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgErrorJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 114);
        msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_TYPE, enlargeType);
        msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_SHOW_STATE, enlargeState);
        Bundle bundle = RGEnlargeRoadMapModel.getInstance().getLastestData();
        if (bundle == null) {
            throw new JSONException("");
        }
        if (enlargeState == 0 || enlargeState == 1) {
            if (enlargeState == 0) {
                byte[] bgBitmapBytes = BitmapUtils.bitmap2Bytes(RGEnlargeRoadMapModel.getInstance().getBGBitmap());
                if (bgBitmapBytes == null) {
                    return null;
                }
                msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_DATA_BASIC, BitmapUtils.encodeToBase64Str(bgBitmapBytes));
                byte[] arrowBitmapBytes = BitmapUtils.bitmap2Bytes(RGEnlargeRoadMapModel.getInstance().getArrowBitmap());
                if (arrowBitmapBytes != null) {
                    msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_DATA_ARROW, BitmapUtils.encodeToBase64Str(arrowBitmapBytes));
                } else {
                    msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_DATA_ARROW, "");
                }
            } else {
                msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_DATA_BASIC, "");
                msgObjJson.put(ParamKey.KEY_ENLARGE_RAOD_DATA_ARROW, "");
            }
            msgObjJson.put(ParamKey.KEY_NEXT_ROAD_NAME, bundle.getString("road_name"));
            msgObjJson.put(ParamKey.KEY_ENLARGE_ROAD_TOTAL_DIST, bundle.getInt(ExpandMap.TotalDist));
            msgObjJson.put(ParamKey.KEY_ENLARGE_ROAD_REMAIN_DIST, bundle.getInt(ExpandMap.RemainDist));
            if (enlargeType == 1) {
                msgObjJson.put(ParamKey.KEY_CAR_POS_X, bundle.getInt(ExpandMap.CarPosX));
                msgObjJson.put(ParamKey.KEY_CAR_POS_Y, bundle.getInt(ExpandMap.CarPosY));
                msgObjJson.put(ParamKey.KEY_CAR_POS_ROTATE, bundle.getInt(ExpandMap.CarRotate));
                if (enlargeState == 0) {
                    msgObjJson.put(ParamKey.KEY_LAST_CAR_POS_X, 0);
                    msgObjJson.put(ParamKey.KEY_LAST_CAR_POS_Y, 0);
                    msgObjJson.put(ParamKey.KEY_LAST_CAR_POS_ROTATE, 0);
                } else {
                    msgObjJson.put(ParamKey.KEY_LAST_CAR_POS_X, bundle.getInt(ExpandMap.LastCarPosX));
                    msgObjJson.put(ParamKey.KEY_LAST_CAR_POS_Y, bundle.getInt(ExpandMap.LastCarPosY));
                    msgObjJson.put(ParamKey.KEY_LAST_CAR_POS_ROTATE, bundle.getInt(ExpandMap.LastCarRotate));
                }
            }
        }
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        msgErrorJson.put("errorCode", 0);
        msgErrorJson.put(ParamKey.KEY_MSG_ERROR_STR, BNRemoteConstants.ERROR_DEFAULT_STR);
        msgJson.put("data", msgDataJson);
        msgJson.put(ParamKey.KEY_MSG_ERRORS, msgErrorJson);
        return msgJson;
    }

    private static JSONObject packetDestInfo(Bundle bundle) throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        int totalDist = bundle.getInt("totalDist");
        double longitude = bundle.getDouble("longitude");
        double latitude = bundle.getDouble("latitude");
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 115);
        msgObjJson.put(ParamKey.KEY_DEST_TOTAL_DIST, totalDist);
        msgObjJson.put("longitude", longitude);
        msgObjJson.put("latitude", latitude);
        msgObjJson.put(ParamKey.KEY_DEST_ICON, 0);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetCarPointInfo(Bundle bundle) throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        double direction = bundle.getDouble("direction");
        double longitude = bundle.getDouble("longitude");
        double latitude = bundle.getDouble("latitude");
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 116);
        msgObjJson.put(ParamKey.KEY_CAR_DIRECTION, direction);
        msgObjJson.put("longitude", longitude);
        msgObjJson.put("latitude", latitude);
        msgObjJson.put("speed", RGAssistGuideModel.getInstance().getCurCarSpeedInt());
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetCarFreeStatus() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        boolean isCarFree = RGSimpleGuideModel.getInstance().isCarlogoFree();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, MessageType.BNMessageTypeCarFreeStatus);
        msgObjJson.put(ParamKey.KEY_CAR_FREE, isCarFree);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetCarTunnelInfo(Bundle bundle) throws JSONException {
        boolean bIsTunnel;
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        if (bundle.getInt("isTunnel") == 1) {
            bIsTunnel = true;
        } else {
            bIsTunnel = false;
        }
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, MessageType.BNMessageTypeTunnelUpdate);
        msgObjJson.put(ParamKey.KEY_CAR_TUNNEL, bIsTunnel);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetShapeIndexUpdate(Bundle bundle) throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        int shapeIndex = bundle.getInt("curLocIndex");
        int fromStartDist = bundle.getInt(ParamKey.KEY_FROM_START_DIST);
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 119);
        msgObjJson.put(ParamKey.KEY_CAR_LOCATION_INDEX, shapeIndex);
        msgObjJson.put("distance", fromStartDist);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetRouteInfo(Bundle bundle) throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        int routeId = bundle.getInt("routeId");
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 120);
        msgObjJson.put(ParamKey.KEY_ROUTE_ID, routeId);
        JSONArray arRouteArray = new JSONArray();
        JSONArray timeLineArray = new JSONArray();
        JSONArray restrictArray = new JSONArray();
        ArrayList<Bundle> arRouteInfoList = new ArrayList();
        ArrayList<Bundle> timeLineList = new ArrayList();
        ArrayList<Bundle> restrictList = new ArrayList();
        if (JNIGuidanceControl.getInstance().GetHUDSDKRouteInfo(arRouteInfoList, timeLineList, restrictList) == 1) {
            int index;
            int arRouteListSize = arRouteInfoList.size();
            for (index = 0; index < arRouteListSize; index++) {
                Bundle arShapeInfoBundle = (Bundle) arRouteInfoList.get(index);
                if (arShapeInfoBundle != null) {
                    JSONObject asShapeJsonObj = new JSONObject();
                    asShapeJsonObj.put("longitude", arShapeInfoBundle.getDouble("longitude"));
                    asShapeJsonObj.put("latitude", arShapeInfoBundle.getDouble("latitude"));
                    asShapeJsonObj.put(ParamKey.KEY_ROUTE_TYPE, arShapeInfoBundle.getInt("roadType"));
                    asShapeJsonObj.put(ParamKey.KEY_FROM_START_DIST, arShapeInfoBundle.getInt(ParamKey.KEY_FROM_START_DIST));
                    arRouteArray.put(asShapeJsonObj);
                }
            }
            int timelineListSize = timeLineList.size();
            for (index = 0; index < timelineListSize; index++) {
                Bundle timeLineBundle = (Bundle) timeLineList.get(index);
                if (timeLineBundle != null) {
                    JSONObject timeLineJsonObj = new JSONObject();
                    timeLineJsonObj.put(ParamKey.KEY_FROM_START_POINT_DIST, timeLineBundle.getInt("startPointFromStartDist"));
                    timeLineJsonObj.put(ParamKey.KEY_FROM_END_POINT_DIST, timeLineBundle.getInt("endPointFromStartDist"));
                    timeLineJsonObj.put(ParamKey.KEY_ROUTE_TYPE, timeLineBundle.getInt("roadType"));
                    timeLineArray.put(timeLineJsonObj);
                }
            }
            int restrictListSize = restrictList.size();
            for (index = 0; index < restrictListSize; index++) {
                Bundle restrictBundle = (Bundle) restrictList.get(index);
                if (restrictBundle != null) {
                    JSONObject restrictJsonObj = new JSONObject();
                    restrictJsonObj.put("longitude", restrictBundle.getDouble("longitude"));
                    restrictJsonObj.put("latitude", restrictBundle.getDouble("latitude"));
                    restrictJsonObj.put("latitude", restrictBundle.getDouble("latitude"));
                    restrictJsonObj.put(ParamKey.KEY_RESTRIT_TYPE, restrictBundle.getInt(ParamKey.KEY_RESTRIT_TYPE));
                    restrictJsonObj.put("distance", restrictBundle.getInt(ParamKey.KEY_FROM_START_DIST));
                    restrictArray.put(restrictJsonObj);
                }
            }
        }
        msgObjJson.put(ParamKey.KEY_AR_ROUTE_LIST, arRouteArray);
        msgObjJson.put(ParamKey.KEY_TIME_LINE_LIST, timeLineArray);
        msgObjJson.put(ParamKey.KEY_RESTRIT_INFO_LIST, restrictArray);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }

    private static JSONObject packetNearByCamera() throws JSONException {
        JSONObject msgDataJson = new JSONObject();
        JSONObject msgObjJson = new JSONObject();
        msgDataJson.put(ParamKey.KEY_MSG_TYPE, 121);
        JSONArray cameraArray = new JSONArray();
        ArrayList<Bundle> cameraInfoList = new ArrayList();
        if (JNIGuidanceControl.getInstance().GetHUDSDKCameraInfo(cameraInfoList) == 1) {
            int cameraListSize = cameraInfoList.size();
            for (int index = 0; index < cameraListSize; index++) {
                Bundle cameraInfoBundle = (Bundle) cameraInfoList.get(index);
                if (cameraInfoBundle != null) {
                    JSONObject cameraInfoJsonObj = new JSONObject();
                    cameraInfoJsonObj.put("longitude", cameraInfoBundle.getDouble("longitude"));
                    cameraInfoJsonObj.put("latitude", cameraInfoBundle.getDouble("latitude"));
                    cameraInfoJsonObj.put(ParamKey.KEY_CAMEAR_TYPE, cameraInfoBundle.getInt(ParamKey.KEY_CAMEAR_TYPE));
                    cameraInfoJsonObj.put("distance", cameraInfoBundle.getInt(ParamKey.KEY_FROM_START_DIST));
                    cameraArray.put(cameraInfoJsonObj);
                }
            }
        }
        msgObjJson.put(ParamKey.KEY_CAMERA_LIST, cameraArray);
        msgDataJson.put(ParamKey.KEY_MSG_OBJ, msgObjJson);
        return msgDataJson;
    }
}
