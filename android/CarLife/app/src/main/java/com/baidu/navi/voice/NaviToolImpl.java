package com.baidu.navi.voice;

import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.util.C2201w;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2607m;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviToolImpl implements C2607m {
    private static final String TAG = NaviToolImpl.class.getSimpleName();

    public void onNaviCommand(String func, String params) {
        C1260i.b(TAG, "func:" + func + " parsms:" + params);
        if (TextUtils.isEmpty(func)) {
            C1260i.b(TAG, "func is null");
        } else if (TextUtils.isEmpty(params) && NaviCmdConstants.FUN_NAVI_START_TASK.equals(func)) {
            MapVoiceCommandController.getInstance().openNavi();
            if (!naviStartTask(null)) {
                handleError();
            }
        } else {
            try {
                JSONObject jsonObject = new JSONObject(params);
                boolean hasAnswer = false;
                if (NaviCmdConstants.FUN_NAVI_MAP_CONTROL.equals(func)) {
                    hasAnswer = naviMapControl(jsonObject);
                } else if (NaviCmdConstants.FUN_NAVI_START_TASK.equals(func)) {
                    naviStartTask(jsonObject);
                    hasAnswer = true;
                } else if (NaviCmdConstants.FUN_NAVI_NAVI_SET.equals(func)) {
                    naviNaviSet(jsonObject);
                    hasAnswer = true;
                } else if (NaviCmdConstants.FUN_NAVI_APP_CONTROL.equals(func)) {
                    hasAnswer = naviAppControl(jsonObject);
                }
                if (!hasAnswer) {
                    handleError();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                C1260i.b(TAG, "create JSONObject fail!");
                C1260i.e(TAG, e.toString());
            }
        }
    }

    private boolean naviStartTask(JSONObject jsonObject) {
        C1260i.b(TAG, "naviStartTask");
        if (jsonObject != null) {
            JSONObject destObject = jsonObject.optJSONObject(NaviCmdConstants.KEY_NAVI_CMD_DEST);
            if (destObject == null) {
                return false;
            }
            int lng = destObject.optInt(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG);
            int lat = destObject.optInt("lat");
            String destName = destObject.optString(NaviCmdConstants.KEY_NAVI_CMD_DEST_NAME);
            C1260i.b(TAG, "destName:" + destName + ", lng:" + lng + ", lat:" + lat + ", preference:" + destObject.optInt(NaviCmdConstants.KEY_NAVI_CMD_DEST_PREFERENCE));
            JSONArray passPointArray = destObject.optJSONArray(NaviCmdConstants.KEY_NAVI_CMD_DEST_PASS_POINT);
            if (passPointArray != null) {
                ArrayList<GeoPoint> passPointList = new ArrayList();
                for (int i = 0; i < passPointArray.length(); i++) {
                    JSONObject pointObject = passPointArray.optJSONObject(i);
                    if (pointObject != null) {
                        GeoPoint geoPoint = new GeoPoint();
                        geoPoint.setLatitudeE6(pointObject.optInt("lat"));
                        geoPoint.setLongitudeE6(pointObject.optInt(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG));
                        passPointList.add(geoPoint);
                        C1260i.b(TAG, "passPoint:lng:" + lng + ", lat:" + lat);
                    }
                }
            }
            MapVoiceCommandController.getInstance().startCalcRoute(((double) lng) / 100000.0d, ((double) lat) / 100000.0d);
            return true;
        } else if (!MapVoiceCommandController.getInstance().isRouteDetailFragment()) {
            return false;
        } else {
            MapVoiceCommandController.getInstance().startNavi();
            return true;
        }
    }

    private boolean naviMapControl(JSONObject jsonObject) {
        if (jsonObject == null) {
            return true;
        }
        MapVoiceCommandController.getInstance().openNavi();
        int order = jsonObject.optInt(NaviCmdConstants.KEY_NAVI_CMD_ORDER);
        if (!(MapVoiceCommandController.getInstance().isMapContentFragment() || order == 216 || order == 217)) {
            C1328h.a().backTo(17, null);
        }
        switch (order) {
            case 202:
                MapVoiceCommandController.getInstance().mapZoomOut();
                return true;
            case 203:
                MapVoiceCommandController.getInstance().mapZoomIn();
                return true;
            case 207:
                MapVoiceCommandController.getInstance().switchRoadCondition(true);
                return true;
            case 208:
                MapVoiceCommandController.getInstance().switchRoadCondition(false);
                return true;
            case 216:
                MapVoiceCommandController.getInstance().naviFullView();
                return true;
            case 217:
                MapVoiceCommandController.getInstance().naviContinue();
                return true;
            case NaviCmdConstants.ACTION_TYPE_NAVI_MOVE_RIGHT /*220*/:
                MapVoiceCommandController.getInstance().mapMoveRight();
                return true;
            case 221:
                MapVoiceCommandController.getInstance().mapMoveLeft();
                return true;
            case 222:
                MapVoiceCommandController.getInstance().mapMoveUp();
                return true;
            case 223:
                MapVoiceCommandController.getInstance().mapMoveDown();
                return true;
            case 229:
                MapVoiceCommandController.getInstance().mapNorthForward();
                return true;
            case 230:
                MapVoiceCommandController.getInstance().mapCarForward();
                return true;
            case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_NIGHT /*231*/:
                MapVoiceCommandController.getInstance().switchDayNightMode(false);
                return true;
            case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                MapVoiceCommandController.getInstance().switchDayNightMode(true);
                return true;
            case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_NEWER /*233*/:
                MapVoiceCommandController.getInstance().switchNaviVoiceMode(true);
                return true;
            case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                MapVoiceCommandController.getInstance().switchNaviVoiceMode(false);
                return true;
            default:
                return false;
        }
    }

    private void naviNaviSet(JSONObject jsonObject) {
        if (jsonObject != null) {
            String order = jsonObject.optString(NaviCmdConstants.KEY_NAVI_CMD_ORDER);
            if (!order.equals("")) {
                JSONObject data = jsonObject.optJSONObject("data");
                if (data != null) {
                    String type = data.optString("type");
                    String name = data.optString("name");
                    String address = data.optString(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS);
                    int lng = data.optInt(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG);
                    int lat = data.optInt("lat");
                    if (!type.equals("") && !name.equals("") && lng > 0 && lat > 0) {
                        GeoPoint geoPoint = new GeoPoint(lng, lat);
                        if (!geoPoint.isValid()) {
                            return;
                        }
                        if (NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_COMPANY_ADDRESS.equals(order) && type.equals(NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY)) {
                            MapVoiceCommandController.getInstance().setCompanyAddress(new RoutePlanNode(geoPoint, 5, name, address));
                        } else if (NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_HOME_ADDRESS.equals(order) && type.equals("home")) {
                            MapVoiceCommandController.getInstance().setHomeAddress(new RoutePlanNode(geoPoint, 4, name, address));
                        }
                    }
                }
            }
        }
    }

    private boolean naviAppControl(JSONObject jsonObject) {
        if (jsonObject == null) {
            return true;
        }
        MapVoiceCommandController.getInstance().openNavi();
        String order = jsonObject.optString(NaviCmdConstants.KEY_NAVI_CMD_ORDER);
        if (order.equals("")) {
            return true;
        }
        if (!order.equals(NaviCmdConstants.ACTION_TYPE_NAVI_EXIT_NAVI) && !order.equals(NaviCmdConstants.ACTION_TYPE_NAVI_EXIT_APP)) {
            return true;
        }
        if (!BNavigator.getInstance().isNaviBegin()) {
            return false;
        }
        MapVoiceCommandController.getInstance().exitNavi();
        return true;
    }

    private void handleError() {
        C1915a.a().b("当前页面不支持", 0);
        C2201w.a("当前页面不支持");
    }

    public boolean isLocationReady() {
        return BNLocationManagerProxy.getInstance().isLocationValid();
    }

    public String getCity() {
        return GeoLocateModel.getInstance().getCurCityName();
    }

    public double getLatitude() {
        if (BNLocationManagerProxy.getInstance().getCurLocation() != null) {
            return BNLocationManagerProxy.getInstance().getCurLocation().latitude;
        }
        return 39.912733d;
    }

    public double getLongitude() {
        if (BNLocationManagerProxy.getInstance().getCurLocation() != null) {
            return BNLocationManagerProxy.getInstance().getCurLocation().longitude;
        }
        return 116.403963d;
    }

    public double calculateDistance(double lat, double lng) {
        return getDistance2CurrentPoint(CoordinateTransformUtil.transferBD09ToGCJ02(lng, lat));
    }

    public double getLatitudeBd09ll() {
        LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
        return ((double) CoordinateTransformUtil.transferGCJ02ToBD09(locData.longitude, locData.latitude).getLatitudeE6()) / 100000.0d;
    }

    public double getLongitudeBd09ll() {
        LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
        return ((double) CoordinateTransformUtil.transferGCJ02ToBD09(locData.longitude, locData.latitude).getLongitudeE6()) / 100000.0d;
    }

    public double getLatitudeBd09mc() {
        LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
        return ((double) CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude).getInt("MCy")) * 1.0d;
    }

    public double getLongitudeBd09mc() {
        LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
        return ((double) CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude).getInt("MCx")) * 1.0d;
    }

    public double getDistance2CurrentPoint(GeoPoint point) {
        if (point == null || !point.isValid()) {
            return 0.0d;
        }
        GeoPoint center = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (center == null || !center.isValid()) {
            return 0.0d;
        }
        double dx = (double) (point.getLongitudeE6() - center.getLongitudeE6());
        double dy = (double) (point.getLatitudeE6() - center.getLatitudeE6());
        return Math.sqrt((dx * dx) + (dy * dy));
    }
}
