package com.baidu.platform.comapi.map.provider;

import com.baidu.carlife.core.C1253f;
import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comjni.tools.AppTools;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiListProvider implements RenderProvider {
    private static final int ARR_FOCUS_ID_OFFSET = 79;
    private static final int ARR_NORMAL_ID_OFFSET = 191;
    private static final int BRAND_ICON_ID_OFFSET = 151;
    private static final int OFFSET_VA = 15;
    private static final int SINGLE_NORMAL_ID_OFFSET = 248;
    private boolean isSinglePoi;
    private Point mCenterPoint;
    private boolean mIsAcc;
    private int pageIndex;
    private List<PoiResult> poiResultList;
    private int singleIndex;
    private List<Contents> uselessData;

    public PoiListProvider(List<PoiResult> protoMessage, boolean isSinglePoi, int singleIndex, int pageIndex) {
        this.poiResultList = protoMessage;
        this.isSinglePoi = isSinglePoi;
        this.singleIndex = singleIndex;
        this.pageIndex = pageIndex;
    }

    public void setAccFlag(boolean accFlag) {
        this.mIsAcc = accFlag;
    }

    public void setCenterPoint(Point centerPoint) {
        this.mCenterPoint = centerPoint;
    }

    public String getRenderData() {
        JSONObject result = new JSONObject();
        try {
            if (isAddressResult()) {
                result.put("dataset", generateAddressResultData());
            } else {
                result.put("dataset", generatePoiResultData());
            }
            return result.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private JSONArray generatePoiResultData() throws JSONException {
        JSONArray poiJsonArray = new JSONArray();
        if (this.isSinglePoi) {
            poiJsonArray.put(buildPoiContentJson(((PoiResult) this.poiResultList.get(this.pageIndex)).getContents(this.singleIndex), this.singleIndex));
        } else {
            int j = 0;
            while (j < this.poiResultList.size() && j < 1) {
                for (int i = 0; i < ((PoiResult) this.poiResultList.get(j)).getContentsList().size(); i++) {
                    Contents poiContent = ((PoiResult) this.poiResultList.get(j)).getContents(i);
                    if (isLegalPoiType(poiContent.getPoiType()) && isMatchAccFlag(poiContent.getAccFlag())) {
                        poiJsonArray.put(buildPoiContentJson(poiContent, i));
                    }
                }
                j++;
            }
        }
        if (this.mCenterPoint != null) {
            poiJsonArray.put(buildCenterPointJson());
        }
        return poiJsonArray;
    }

    private JSONObject buildPoiContentJson(Contents poiContent, int index) throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ud", poiContent.getUid());
        poiJson.put(OVERLAY_KEY.ALIGN, 2);
        poiJson.put("ty", 3);
        poiJson.put("of", 15);
        if (this.isSinglePoi) {
            poiJson.put("nst", 312);
            poiJson.put("fst", C1253f.ea);
        } else {
            poiJson.put("fst", C1253f.ea);
            poiJson.put("nst", 312);
        }
        poiJson.put("in", index - getUseLessDataSize());
        poiJson.put("tx", poiContent.getName());
        poiJson.put("geo", poiContent.getGeo());
        return poiJson;
    }

    private JSONObject buildCenterPointJson() throws JSONException {
        JSONObject poiJson = new JSONObject();
        poiJson.put("ty", 5);
        poiJson.put("nst", 12);
        poiJson.put("fst", 12);
        poiJson.put("of", 15);
        poiJson.put("in", -1);
        poiJson.put("tx", "");
        poiJson.put("geo", AppTools.getStringFromGeoPoint(this.mCenterPoint));
        return poiJson;
    }

    private boolean isAddressResult() {
        if (((PoiResult) this.poiResultList.get(this.pageIndex)).getOption() == null) {
            return false;
        }
        if (!((PoiResult) this.poiResultList.get(this.pageIndex)).getOption().getOpAddr() || ((PoiResult) this.poiResultList.get(this.pageIndex)).getAddrsCount() <= 0) {
            return false;
        }
        return true;
    }

    private boolean isLegalPoiType(int poiType) {
        return (poiType == 2 || poiType == 4) ? false : true;
    }

    private boolean isMatchAccFlag(int poiAccFlay) {
        return !this.mIsAcc || poiAccFlay == 1 || ((PoiResult) this.poiResultList.get(this.pageIndex)).getContentsList().size() == 1;
    }

    private JSONArray generateAddressResultData() throws JSONException {
        JSONArray poiJsonArray = new JSONArray();
        JSONObject poiJson = new JSONObject();
        poiJson.put("ty", 13);
        poiJson.put("nst", 23);
        poiJson.put("fst", 23);
        poiJson.put("of", 15);
        poiJson.put("in", 0);
        poiJson.put("tx", ((PoiResult) this.poiResultList.get(this.pageIndex)).getAddrs(0).getName());
        poiJson.put("geo", ((PoiResult) this.poiResultList.get(this.pageIndex)).getAddrs(0).getGeo());
        poiJsonArray.put(poiJson);
        return poiJsonArray;
    }

    public void setUseLessData(List<Contents> uselessData) {
        this.uselessData = uselessData;
    }

    public int getUseLessDataSize() {
        return this.uselessData == null ? 0 : this.uselessData.size();
    }
}
