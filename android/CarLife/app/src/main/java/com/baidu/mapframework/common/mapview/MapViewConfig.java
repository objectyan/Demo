package com.baidu.mapframework.common.mapview;

import android.text.TextUtils;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.config.Preferences;
import com.baidu.platform.comapi.util.C2911f;
import org.json.JSONObject;

public final class MapViewConfig {
    /* renamed from: b */
    private static boolean f18776b = false;
    /* renamed from: a */
    private Preferences f18777a;
    /* renamed from: c */
    private PositionStatus f18778c;
    /* renamed from: d */
    private String f18779d;

    private static class Holder {
        /* renamed from: a */
        static final MapViewConfig f18773a = new MapViewConfig();

        private Holder() {
        }
    }

    public enum MapMode {
        SATELLITE,
        _2D,
        _3D
    }

    public enum PositionStatus {
        NORMAL,
        FOLLOWING,
        COMPASS,
        LOCATING,
        TRACKING
    }

    private MapViewConfig() {
        this.f18779d = "";
        this.f18777a = Preferences.build(C2907c.f(), "mapview_conf");
    }

    public static MapViewConfig getInstance() {
        return Holder.f18773a;
    }

    public PositionStatus getPositionStatus() {
        if (f18776b && this.f18778c != null) {
            return this.f18778c;
        }
        setPositionStatus(PositionStatus.NORMAL);
        return PositionStatus.NORMAL;
    }

    public void setPositionStatus(PositionStatus positionStatus) {
        boolean z = true;
        f18776b = true;
        if (positionStatus != PositionStatus.COMPASS) {
            z = false;
        }
        MapController.isCompass = z;
        this.f18778c = positionStatus;
    }

    public boolean isTraffic() {
        return this.f18777a.getBoolean("is_traffic", false);
    }

    public void initTraffic(int cityId) {
        if (!this.f18777a.contains("is_traffic") || shouldTurnOnTraffic()) {
            setShouldTurnOnTraffic(false);
            try {
                if (new JSONObject(MapViewFactory.getInstance().getMapView().getController().getBaseMap().GetCityInfoByID(cityId)).getInt("its") == 1) {
                    setTraffic(true);
                }
            } catch (Exception e) {
                C2911f.a(getClass().getName(), e.getMessage(), e);
            }
        }
    }

    public void setTraffic(boolean mIsTraffic) {
        this.f18777a.putBoolean("is_traffic", mIsTraffic);
    }

    public void setPredictType(int type) {
        this.f18777a.putInt("predict_type", type);
    }

    public int getPredictType() {
        return this.f18777a.getInt("predict_type", 0);
    }

    public void setTrafficOpenWhenForeground(boolean open) {
        this.f18777a.putBoolean("is_traffic_fgd", open);
    }

    public boolean getTrafficOpenWhenForeground() {
        return this.f18777a.getBoolean("is_traffic_fgd", false);
    }

    public void setPredictTrafficGuideOpen(boolean open) {
        this.f18777a.putBoolean("predict_traffic_guide_open", open);
    }

    public boolean getPredictTrafficGuideOpen() {
        return this.f18777a.getBoolean("predict_traffic_guide_open", false);
    }

    public void setPredictTrafficTipOpen(boolean open) {
        this.f18777a.putBoolean("predict_traffic_tip_open", open);
    }

    public boolean getPredictTrafficTipOpen() {
        return this.f18777a.getBoolean("predict_traffic_tip_open", false);
    }

    public void setPredictTrafficUserOpen(boolean open) {
        this.f18777a.putBoolean("predict_traffic_user_open", open);
    }

    public boolean getPredictTrafficUserOpen() {
        return this.f18777a.getBoolean("predict_traffic_user_open", false);
    }

    public void setPredictCitys(String citys) {
        this.f18779d = citys;
    }

    public boolean isSupportPredict() {
        return isPredictCity(String.valueOf(GlobalConfig.getInstance().getLastLocationCityCode()));
    }

    public boolean isPredictCity(String city) {
        String citys = this.f18779d;
        if (TextUtils.isEmpty(citys)) {
            return false;
        }
        String[] cityArr = citys.split(",");
        for (String equals : cityArr) {
            if (equals.equals(city)) {
                return true;
            }
        }
        return false;
    }

    public MapMode getMapMode() {
        return MapMode.valueOf(this.f18777a.getString("map_mode", MapMode._2D.name()));
    }

    public void setMapMode(MapMode newMode) {
        this.f18777a.putString("map_mode", newMode.name());
    }

    public float getLevel() {
        return this.f18777a.getFloat(SearchParamKey.MAP_LEVEL, 12.0f);
    }

    public void setLevel(float level) {
        this.f18777a.putFloat(SearchParamKey.MAP_LEVEL, level);
    }

    public float getRotation() {
        return this.f18777a.getFloat("map_rotation", 0.0f);
    }

    public void setRotation(float rotation) {
        this.f18777a.putFloat("map_rotation", rotation);
    }

    public float getOverlook() {
        return this.f18777a.getFloat("map_overlook", 0.0f);
    }

    public void setOverlook(float overlook) {
        this.f18777a.putFloat("map_overlook", overlook);
    }

    public int getCenterPtX() {
        return this.f18777a.getInt("map_centerptx", 12958162);
    }

    public void setCenterPtX(int x) {
        this.f18777a.putInt("map_centerptx", x);
    }

    public int getCenterPtY() {
        return this.f18777a.getInt("map_centerpty", 4825907);
    }

    public void setCenterPtY(int y) {
        this.f18777a.putInt("map_centerpty", y);
    }

    public int getCenterPtZ() {
        return this.f18777a.getInt("map_centerptz", 0);
    }

    public void setCenterPtZ(int z) {
        this.f18777a.putInt("map_centerptz", z);
    }

    public void saveMapStatus(MapStatus mapStatus) {
        if (mapStatus != null) {
            this.f18777a.putFloat(SearchParamKey.MAP_LEVEL, mapStatus.level);
            this.f18777a.putFloat("map_rotation", (float) mapStatus.rotation);
            this.f18777a.putFloat("map_overlook", (float) mapStatus.overlooking);
            this.f18777a.putInt("map_centerptx", (int) mapStatus.centerPtX);
            this.f18777a.putInt("map_centerpty", (int) mapStatus.centerPtY);
            this.f18777a.putInt("map_centerptz", (int) mapStatus.centerPtZ);
        }
    }

    public void saveGestureStartTime(long time) {
        this.f18777a.putLong("gesture_start_time", time);
    }

    public long getGestureStartTime() {
        return this.f18777a.getLong("gesture_start_time", 0).longValue();
    }

    public void saveGestureIntervalTime(int time) {
        this.f18777a.putInt("gesture_interval_time", time);
    }

    public int getGestureIntervalTime() {
        return this.f18777a.getInt("gesture_interval_time", 0);
    }

    public boolean shouldTurnOnTraffic() {
        return this.f18777a.getBoolean("should_open_traffic", false);
    }

    public void setShouldTurnOnTraffic(boolean should) {
        this.f18777a.putBoolean("should_open_traffic", should);
    }

    public void setIndoorSharePre(String key, boolean should) {
        this.f18777a.putBoolean(key, should);
    }

    public boolean getIndoorSharePre(String key) {
        return this.f18777a.getBoolean(key, false);
    }
}
