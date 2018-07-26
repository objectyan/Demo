package com.baidu.platform.comapi.map.provider;

import com.baidu.carlife.core.C1253f;
import com.baidu.entity.pb.WalkSearch;
import com.baidu.entity.pb.WalkSearch.Content;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WalkSearchProvider implements RenderProvider {
    private WalkSearch walkSearch;

    public WalkSearchProvider(WalkSearch search) {
        this.walkSearch = search;
    }

    public String getRenderData() {
        JSONObject result = new JSONObject();
        try {
            result.put("dataset", generateWalkSearchJson());
            return result.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private JSONArray generateWalkSearchJson() throws JSONException {
        JSONArray walkJsonArray = new JSONArray();
        for (int i = 0; i < this.walkSearch.getContentList().size(); i++) {
            walkJsonArray.put(buildContentJson(this.walkSearch.getContent(i), walkJsonArray.length(), i));
        }
        return walkJsonArray;
    }

    private JSONObject buildContentJson(Content content, int id, int index) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ud", content.getUid());
        poiJson.put(OVERLAY_KEY.ALIGN, 2);
        poiJson.put("ty", 3);
        poiJson.put("nst", C1253f.dP);
        poiJson.put("fst", C1253f.dQ);
        poiJson.put("of", 15);
        poiJson.put("in", index);
        poiJson.put("tx", content.getName());
        poiJson.put("geo", CoordinateUtil.pointToGeoString(new Point((double) content.getX(), (double) content.getY())));
        return poiJson;
    }
}
