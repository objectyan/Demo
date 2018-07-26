package com.baidu.platform.comapi.map.provider;

import com.baidu.carlife.core.C1253f;
import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RoutePoiListProvider implements RenderProvider {
    private PoiResult mPoiResult;

    public RoutePoiListProvider(PoiResult poiResult) {
        this.mPoiResult = poiResult;
    }

    public String getRenderData() {
        JSONObject result = new JSONObject();
        try {
            result.put("dataset", generateRoutePoiResultData());
            return result.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private JSONArray generateRoutePoiResultData() throws JSONException {
        JSONArray poiJsonArray = new JSONArray();
        for (int i = 0; i < this.mPoiResult.getContentsList().size(); i++) {
            Contents poiContent = this.mPoiResult.getContents(i);
            if (isLegalPoiType(poiContent.getPoiType())) {
                poiJsonArray.put(buildRoutePoiContentJson(poiContent, poiJsonArray.length(), i));
            }
        }
        return poiJsonArray;
    }

    private JSONObject buildRoutePoiContentJson(Contents poiContent, int id, int index) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ud", poiContent.getUid());
        poiJson.put(OVERLAY_KEY.ALIGN, 2);
        poiJson.put("ty", 3);
        poiJson.put("nst", C1253f.dP);
        poiJson.put("fst", C1253f.dQ);
        poiJson.put("of", 15);
        poiJson.put("in", index);
        poiJson.put("tx", poiContent.getName());
        poiJson.put("geo", poiContent.getGeo());
        return poiJson;
    }

    private boolean isLegalPoiType(int poiType) {
        return (poiType == 2 || poiType == 4) ? false : true;
    }
}
