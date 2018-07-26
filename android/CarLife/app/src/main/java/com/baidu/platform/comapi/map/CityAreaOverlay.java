package com.baidu.platform.comapi.map;

import com.baidu.entity.pb.CityResult;
import com.baidu.entity.pb.CityResult.Content;
import com.baidu.entity.pb.CityResult.Content.Sgeo.GeoElements;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityAreaOverlay extends InnerOverlay {
    private static final int AREA_STYLE_SCOLOR = -1595814730;
    private static final int GEO_TYPE_AREA = 3;
    private static final int GEO_TYPE_LINE = 2;
    private static final int LEVEL_FOUR_COLOR = 14798006;
    private static final int LEVEL_ONE_COLOR = 1507970230;
    private static final int LEVEL_THREE_COLOR = 652332214;
    private static final int LEVEL_TWO_COLOR = 1071762614;
    private static final int LINE_STYLE = 140;
    private static final int MAX_LEVEL = 20;
    private static final int MIN_LEVEL = 3;
    private static final int NORMAL_OFFSET = 15;
    private static final int ONE_LEVEL_DIFF = 1;
    private static final int THREE_LEVEL_DIFF = 3;
    private static final int TWO_LEVEL_DIFF = 2;

    public CityAreaOverlay() {
        super(33);
    }

    public CityAreaOverlay(AppBaseMap baseMap) {
        super(33, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(0, 0, MapController.CITY_AREA_TAG);
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public String getData() {
        ResultCache$Item item = ResultCache.getInstance().get(this.strJsonData);
        if (item == null || !(item.messageLite instanceof CityResult)) {
            return "";
        }
        return generateChildJson((CityResult) item.messageLite);
    }

    private String generateChildJson(CityResult cityResult) {
        JSONObject result = new JSONObject();
        JSONArray childArray = new JSONArray();
        Content content = null;
        if (cityResult.hasContent()) {
            content = cityResult.getContent();
        }
        if (content == null) {
            return "";
        }
        try {
            addChildGeoArray(content, childArray);
            result.put("dataset", childArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private void addChildGeoArray(Content content, JSONArray childArray) throws JSONException {
        if (content.hasSgeo()) {
            childArray.put(buildChildAreaJson(content, 0));
            childArray.put(buildChildLineJson(content, 1));
        }
    }

    private JSONObject buildChildLineJson(Content content, int id) throws JSONException {
        JSONObject lineJson = new JSONObject();
        lineJson.put("ud", content.getUid());
        lineJson.put("ty", 32);
        lineJson.put("nst", LINE_STYLE);
        lineJson.put("fst", LINE_STYLE);
        lineJson.put("of", 15);
        lineJson.put("in", id);
        lineJson.put("tx", content.getCname());
        lineJson.put(OVERLAY_KEY.SGEO, buildSgeoJson(content, 2));
        return lineJson;
    }

    private JSONObject buildChildAreaJson(Content content, int id) throws JSONException {
        JSONObject areaJson = new JSONObject();
        areaJson.put("ud", content.getUid());
        areaJson.put("ty", 33);
        areaJson.put("of", 15);
        areaJson.put("in", id);
        areaJson.put("tx", content.getCname());
        areaJson.put(OVERLAY_KEY.SGEO, buildSgeoJson(content, 3));
        JSONObject style = new JSONObject();
        style.put(OVERLAY_KEY.SGEO_LEVEL_COLOR, AREA_STYLE_SCOLOR);
        areaJson.put(OVERLAY_KEY.AREA_STYLE, style);
        areaJson.put(OVERLAY_KEY.SGEO_DIFF_LEVEL, buildDifflevel(content.getLevel()));
        return areaJson;
    }

    private JSONObject buildSgeoJson(Content content, int type) throws JSONException {
        int i;
        JSONObject sgeo = new JSONObject();
        if (content.getSgeo().getBoundList() != null) {
            JSONArray bound = new JSONArray();
            for (i = 0; i < content.getSgeo().getBoundList().size(); i++) {
                bound.put(Double.valueOf(content.getSgeo().getBound(i)));
            }
            sgeo.put(OVERLAY_KEY.SGEO_BOUND, bound);
        }
        sgeo.put("type", type);
        if (content.getSgeo().getGeoElementsList() != null) {
            JSONArray geoElements = new JSONArray();
            List<GeoElements> geos = content.getSgeo().getGeoElementsList();
            for (i = 0; i < geos.size(); i++) {
                if (((GeoElements) geos.get(i)).getPointList() != null) {
                    JSONArray points = new JSONArray();
                    for (int j = 0; j < ((GeoElements) geos.get(i)).getPointCount(); j++) {
                        points.put(Double.valueOf(((GeoElements) geos.get(i)).getPoint(j)));
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

    private JSONArray buildDifflevel(int level) throws JSONException {
        JSONArray difflevel = new JSONArray();
        JSONObject part1 = new JSONObject();
        part1.put("maxl", level);
        part1.put("minl", 3);
        part1.put(OVERLAY_KEY.SGEO_LEVEL_COLOR, LEVEL_ONE_COLOR);
        difflevel.put(part1);
        JSONObject part2 = new JSONObject();
        part2.put("maxl", level + 1);
        part2.put("minl", level + 1);
        part2.put(OVERLAY_KEY.SGEO_LEVEL_COLOR, LEVEL_TWO_COLOR);
        difflevel.put(part2);
        JSONObject part3 = new JSONObject();
        part3.put("maxl", level + 2);
        part3.put("minl", level + 2);
        part3.put(OVERLAY_KEY.SGEO_LEVEL_COLOR, LEVEL_THREE_COLOR);
        difflevel.put(part3);
        JSONObject part4 = new JSONObject();
        part4.put("maxl", 20);
        part4.put("minl", level + 3);
        part4.put(OVERLAY_KEY.SGEO_LEVEL_COLOR, LEVEL_FOUR_COLOR);
        difflevel.put(part4);
        return difflevel;
    }
}
