package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.DynamicHeaderMessage;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiDynamicMapOverlay extends InnerOverlay {
    public static final int PB_LENGTH_SIGN = 32;
    private byte[] extData;
    private boolean isAccShow = false;
    private boolean isAddContent = false;
    private float level;
    private List<PoiResult> poiResultList;
    private String qid = null;
    private int scene;
    private boolean shouldClear = false;
    private boolean shouldDel = false;
    private boolean showAd;
    private String uid = null;
    /* renamed from: x */
    private double f19852x;
    /* renamed from: y */
    private double f19853y;

    public PoiDynamicMapOverlay() {
        super(37);
    }

    public PoiDynamicMapOverlay(AppBaseMap baseMap) {
        super(37, baseMap);
    }

    public void setPoiUid(String uid) {
        this.uid = uid;
    }

    public void setShouldDel(boolean del) {
        this.shouldDel = del;
    }

    public void setShouldClear(boolean clear) {
        this.shouldClear = clear;
    }

    public void setPoiResultList(List<PoiResult> poiResultList) {
        this.poiResultList = poiResultList;
    }

    public void setRouteExtData(byte[] extData) {
        this.extData = extData;
    }

    public void setExtData(byte[] extData) {
        this.extData = getExtData(extData);
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public void setScene(int s) {
        this.scene = s;
    }

    public void setShowAd(boolean show) {
        this.showAd = show;
    }

    public void setLevel(float l) {
        this.level = l;
    }

    public void setX(double xx) {
        this.f19852x = xx;
    }

    public void setY(double yy) {
        this.f19853y = yy;
    }

    public String getLayerTag() {
        return MapController.DYNAMIC_MAP_LAYER_TAG;
    }

    private byte[] getExtData(byte[] data) {
        byte[] bArr = null;
        if (data != null && data.length >= 32) {
            int sign = ((((data[0] & 255) << 24) | ((data[1] & 255) << 16)) | ((data[2] & 255) << 8)) | (data[3] & 255);
            int len = data.length;
            if (sign == len - 32) {
                bArr = new byte[(len - 32)];
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = data[i + 32];
                }
            }
        }
        return bArr;
    }

    public String getData() {
        if (this.shouldClear) {
            this.shouldClear = false;
            return generateClearJson();
        } else if ((this.extData == null || this.poiResultList == null) && this.shouldDel) {
            this.shouldDel = false;
            return generateDelJson();
        } else if ((this.poiResultList == null || this.poiResultList.size() <= 0) && (this.extData == null || this.extData.length <= 0)) {
            return "";
        } else {
            return generateJson();
        }
    }

    public Bundle getParam() {
        Bundle bundle = new Bundle();
        Bundle data;
        if (this.poiResultList != null && this.poiResultList.size() > 0) {
            ArrayList<Bundle> values = new ArrayList();
            int i = 0;
            while (i < this.poiResultList.size() && i < 1) {
                data = new Bundle();
                if (((PoiResult) this.poiResultList.get(i)).hasImgeExt()) {
                    try {
                        byte[] extData = getExtData(DynamicHeaderMessage.parseFrom(((PoiResult) this.poiResultList.get(i)).getImgeExt().toByteArray()).getDynamicPbRes().toByteArray());
                        if (extData != null) {
                            data.putByteArray("data", extData);
                            data.putInt(OVERLAY_KEY.IMG_EXT_LEN, extData.length);
                            values.add(data);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }
            Bundle[] midpar = new Bundle[values.size()];
            for (int j = 0; j < values.size(); j++) {
                midpar[j] = (Bundle) values.get(j);
            }
            bundle.putParcelableArray(OVERLAY_KEY.IMG_EXT, midpar);
            this.poiResultList = null;
        } else if (this.extData != null && this.extData.length > 1) {
            data = new Bundle();
            data.putByteArray("data", this.extData);
            data.putInt(OVERLAY_KEY.IMG_EXT_LEN, this.extData.length);
            bundle.putParcelableArray(OVERLAY_KEY.IMG_EXT, new Bundle[]{data});
            this.extData = null;
        }
        return bundle;
    }

    private String generateJson() {
        int i = 1;
        JSONObject result = new JSONObject();
        try {
            result.put("ud", this.uid);
            result.put(OVERLAY_KEY.DYNAMIC_SCENE, this.scene);
            result.put(OVERLAY_KEY.DYNAMIC_SHOW_AD, this.showAd ? 1 : 0);
            result.put("qid", this.qid);
            result.put("level", (double) this.level);
            result.put("x", this.f19852x);
            result.put("y", this.f19853y);
            if (this.isAddContent) {
                this.isAddContent = false;
                result.put("rs_add", 1);
            } else {
                result.put("rs_add", 0);
            }
            String str = "show_force";
            if (!this.isAccShow) {
                i = 0;
            }
            result.put(str, i);
        } catch (JSONException e) {
        }
        return result.toString();
    }

    private String generateClearJson() {
        JSONObject result = new JSONObject();
        try {
            result.put(OVERLAY_KEY.DYNAMIC_SCENE, this.scene);
            result.put("rs_add", 0);
        } catch (JSONException e) {
        }
        return result.toString();
    }

    private String generateDelJson() {
        JSONObject result = new JSONObject();
        try {
            result.put("ud", this.uid);
            result.put(OVERLAY_KEY.DYNAMIC_SCENE, this.scene);
            result.put("rs_rev", 1);
        } catch (JSONException e) {
        }
        return result.toString();
    }

    public void clear() {
        super.clear();
    }

    public void setIsAddContent(boolean isAddContent) {
        this.isAddContent = isAddContent;
    }

    public void setIsAccShow(boolean isAccShow) {
        this.isAccShow = isAccShow;
    }
}
