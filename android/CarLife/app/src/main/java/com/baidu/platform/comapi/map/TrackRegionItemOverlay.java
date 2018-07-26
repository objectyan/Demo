package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.map.provider.TrackRegionData;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackRegionItemOverlay extends InnerOverlay {
    private static final int AREA_NEW_FLAG_COLOR = -939489287;
    private static final int GEO_TYPE_AREA = 3;
    private static final int NORMAL_OFFSET = 15;
    private ArrayList<TrackRegionData> mTrackRegionDatas;

    public TrackRegionItemOverlay() {
        super(33);
    }

    public TrackRegionItemOverlay(AppBaseMap baseMap) {
        super(33, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(2, 0, MapController.TRACK_REGION_TAG);
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public void setData(ArrayList<TrackRegionData> trackRegionDatas) {
        this.mTrackRegionDatas = trackRegionDatas;
    }

    public String getData() {
        return generateChildJson(this.mTrackRegionDatas);
    }

    private String generateChildJson(ArrayList<TrackRegionData> trackRegionDatas) {
        JSONObject result = new JSONObject();
        JSONArray childArray = new JSONArray();
        int i = 0;
        while (i < trackRegionDatas.size()) {
            try {
                childArray.put(buildChildJson((TrackRegionData) trackRegionDatas.get(i), 0));
                i++;
            } catch (Exception e) {
                C2911f.a("Cary", "getRenderData error", e);
                return "";
            }
        }
        result.put("dataset", childArray);
        return result.toString();
    }

    private JSONObject buildChildJson(TrackRegionData trackRegionData, int id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ud", trackRegionData.uid);
        jsonObject.put("ty", 32);
        jsonObject.put("of", 15);
        jsonObject.put("in", id);
        jsonObject.put("tx", trackRegionData.name);
        jsonObject.put(OVERLAY_KEY.SGEO, buildSgeoJson(trackRegionData, 3));
        JSONObject style = new JSONObject();
        int scolor = getProvAreaColorForNum(trackRegionData.trackNum);
        int color = getNewRegionLineColor(trackRegionData.isNewFlag);
        if (trackRegionData.isNewFlag) {
            scolor = AREA_NEW_FLAG_COLOR;
        }
        style.put(OVERLAY_KEY.SGEO_LEVEL_COLOR, scolor);
        style.put(OVERLAY_KEY.SGEO_LEVEL_COLOR_LINE, color);
        style.put("width", 4);
        jsonObject.put(OVERLAY_KEY.AREA_STYLE, style);
        return jsonObject;
    }

    private JSONObject buildSgeoJson(TrackRegionData trackRegionData, int type) throws JSONException {
        JSONObject sgeo = new JSONObject();
        sgeo.put("type", type);
        if (!(trackRegionData == null || trackRegionData.region.isEmpty())) {
            JSONArray geoElements = new JSONArray();
            JSONArray points = new JSONArray();
            for (int i = 0; i < trackRegionData.region.size(); i++) {
                points.put(trackRegionData.region.get(i));
            }
            JSONObject pointObj = new JSONObject();
            pointObj.put(OVERLAY_KEY.SGEO_ELEMENTS_POINTS, points);
            geoElements.put(pointObj);
            sgeo.put(OVERLAY_KEY.SGEO_ELEMENTS, geoElements);
        }
        return sgeo;
    }

    private int getNewRegionLineColor(boolean isNewFlag) {
        if (isNewFlag) {
            return -16757816;
        }
        return -3641826;
    }

    private int getProvAreaColorForNum(int num) {
        if (num >= 0 && num < 10) {
            return -923081024;
        }
        if (num < 20) {
            return -923411280;
        }
        if (num < 30) {
            return -923741018;
        }
        if (num < 40) {
            return -923547501;
        }
        if (num < 60) {
            return -923877759;
        }
        if (num < 100) {
            return -924405906;
        }
        if (num < 200) {
            return -924935335;
        }
        if (num < 400) {
            return -926644400;
        }
        return -928091325;
    }
}
