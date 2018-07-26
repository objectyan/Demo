package com.baidu.platform.comapi.map;

import com.baidu.entity.pb.Inf;
import com.baidu.entity.pb.Inf.Content;
import com.baidu.entity.pb.Inf.Content.HeatMap;
import com.baidu.entity.pb.Inf.Content.HeatMap.Points.GeoElements;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HeatMapChildItemOverlay extends InnerOverlay {
    private static final int AREA_STYLE = 61;
    private static final int GEO_TYPE_AREA = 4;
    private static final int GEO_TYPE_LINE = 2;
    private static final int LINE_STYLE = 128;
    private static final int NORMAL_OFFSET = 15;

    public HeatMapChildItemOverlay() {
        super(34);
    }

    public HeatMapChildItemOverlay(AppBaseMap baseMap) {
        super(34, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(0, 0, MapController.HEATMAP_LAYER_TAG);
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public String getData() {
        ResultCache$Item item = ResultCache.getInstance().get(this.strJsonData);
        if (item == null || !(item.messageLite instanceof Inf)) {
            return "";
        }
        return generateChildJson((Inf) item.messageLite);
    }

    private String generateChildJson(Inf inf) {
        JSONObject result = new JSONObject();
        JSONArray childArray = new JSONArray();
        try {
            if (inf.hasContent()) {
                Content content = inf.getContent();
                if (content.hasHeatMap()) {
                    addChildGeoArray(content, childArray);
                }
            }
            result.put("dataset", childArray);
            return result.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private void addChildGeoArray(Content content, JSONArray childArray) throws JSONException {
        if (content.getHeatMap().hasPoints()) {
            switch (content.getHeatMap().getPoints().getType()) {
                case 2:
                    childArray.put(buildChildLineJson(content, 0));
                    return;
                case 4:
                    childArray.put(buildChildAreaJson(content, 0));
                    return;
                default:
                    return;
            }
        }
    }

    private JSONObject buildChildLineJson(Content content, int id) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ty", 32);
        poiJson.put("nst", 128);
        poiJson.put("fst", 0);
        poiJson.put("of", 15);
        poiJson.put("in", id);
        poiJson.put(OVERLAY_KEY.SGEO, buildSgeoJson(content));
        return poiJson;
    }

    private JSONObject buildChildAreaJson(Content content, int id) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ty", 33);
        poiJson.put("nst", 61);
        poiJson.put("fst", 0);
        poiJson.put("of", 15);
        poiJson.put("in", id);
        poiJson.put(OVERLAY_KEY.SGEO, buildSgeoJson(content));
        return poiJson;
    }

    private JSONObject buildSgeoJson(Content content) throws JSONException {
        int i;
        JSONObject sgeo = new JSONObject();
        HeatMap heatMap = content.getHeatMap();
        if (heatMap.getPoints().getBoundList() != null) {
            JSONArray bound = new JSONArray();
            for (i = 0; i < heatMap.getPoints().getBoundList().size(); i++) {
                bound.put(content.getHeatMap().getPoints().getBound(i));
            }
            sgeo.put(OVERLAY_KEY.SGEO_BOUND, bound);
        }
        if (heatMap.getPoints().getType() == 4) {
            sgeo.put("type", 3);
        } else {
            sgeo.put("type", heatMap.getPoints().getType());
        }
        if (heatMap.getPoints().getGeoElementsList() != null) {
            JSONArray geoElements = new JSONArray();
            List<GeoElements> geos = heatMap.getPoints().getGeoElementsList();
            for (i = 0; i < geos.size(); i++) {
                if (((GeoElements) geos.get(i)).getPointList() != null) {
                    JSONArray points = new JSONArray();
                    for (int j = 0; j < ((GeoElements) geos.get(i)).getPointCount(); j++) {
                        points.put(((GeoElements) geos.get(i)).getPoint(j));
                    }
                    JSONObject pointObj = new JSONObject();
                    pointObj.put(OVERLAY_KEY.SGEO_ELEMENTS_POINTS, points);
                    geoElements.put(pointObj);
                }
            }
            sgeo.put(OVERLAY_KEY.SGEO_ELEMENTS, geoElements);
        }
        return sgeo;
    }
}
