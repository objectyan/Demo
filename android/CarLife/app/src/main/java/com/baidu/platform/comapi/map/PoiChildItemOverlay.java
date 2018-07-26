package com.baidu.platform.comapi.map;

import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult$Contents$Sgeo.GeoElements;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiChildItemOverlay extends InnerOverlay {
    private static final int AREA_STYLE = 60;
    private static final int GEO_TYPE_AREA = 4;
    private static final int GEO_TYPE_LINE = 2;
    private static final int LINE_STYLE = 128;
    private static final int NORMAL_OFFSET = 15;
    private int poiIndex = 0;
    private boolean showSpecialChild;

    public boolean isShowSpecialChild() {
        return this.showSpecialChild;
    }

    public void setShowSpecialChild(boolean showSpecialChild) {
        this.showSpecialChild = showSpecialChild;
    }

    public PoiChildItemOverlay() {
        super(33);
    }

    public PoiChildItemOverlay(AppBaseMap baseMap) {
        super(33, baseMap);
    }

    public void setPoiIndex(int index) {
        this.poiIndex = index;
    }

    public String getLayerTag() {
        return MapController.POISON_LAYER_TAG;
    }

    public String getData() {
        ResultCache$Item item = ResultCache.getInstance().get(this.strJsonData);
        if (item == null || !(item.messageLite instanceof PoiResult)) {
            return "";
        }
        return generateChildJson((PoiResult) item.messageLite);
    }

    private String generateChildJson(PoiResult poiResult) {
        JSONObject result = new JSONObject();
        JSONArray childArray = new JSONArray();
        try {
            if (this.poiIndex >= 0 && this.poiIndex < poiResult.getContentsList().size()) {
                addChildGeoArray(poiResult.getContents(this.poiIndex), childArray);
            }
            result.put("dataset", childArray);
            return result.toString();
        } catch (Exception e) {
            C2911f.a("Cary", "getRenderData error", e);
            return "";
        }
    }

    private void addChildGeoArray(Contents content, JSONArray childArray) throws JSONException {
        if (content.hasSgeo()) {
            switch (content.getSgeo().getType()) {
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

    private JSONObject buildChildLineJson(Contents poiContent, int id) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ud", poiContent.getUid());
        poiJson.put("ty", 32);
        poiJson.put("nst", 128);
        poiJson.put("fst", 0);
        poiJson.put("of", 15);
        poiJson.put("in", id);
        poiJson.put("tx", poiContent.getName());
        poiJson.put(OVERLAY_KEY.SGEO, buildSgeoJson(poiContent));
        return poiJson;
    }

    private JSONObject buildChildAreaJson(Contents poiContent, int id) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ud", poiContent.getUid());
        poiJson.put("ty", 33);
        poiJson.put("nst", 60);
        poiJson.put("fst", 0);
        poiJson.put("of", 15);
        poiJson.put("in", id);
        poiJson.put("tx", poiContent.getName());
        poiJson.put(OVERLAY_KEY.SGEO, buildSgeoJson(poiContent));
        return poiJson;
    }

    private JSONObject buildSgeoJson(Contents poiContent) throws JSONException {
        int i;
        JSONObject sgeo = new JSONObject();
        if (poiContent.getSgeo().getBoundList() != null) {
            JSONArray bound = new JSONArray();
            for (i = 0; i < poiContent.getSgeo().getBoundList().size(); i++) {
                bound.put(poiContent.getSgeo().getBound(i));
            }
            sgeo.put(OVERLAY_KEY.SGEO_BOUND, bound);
        }
        if (poiContent.getSgeo().getType() == 4) {
            sgeo.put("type", 3);
        } else {
            sgeo.put("type", poiContent.getSgeo().getType());
        }
        if (poiContent.getSgeo().getGeoElementsList() != null) {
            JSONArray geoElements = new JSONArray();
            List<GeoElements> geos = poiContent.getSgeo().getGeoElementsList();
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
