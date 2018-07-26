package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.DynamicHeaderMessage;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class BMBarDynamicMapOverlay extends InnerOverlay {
    public static final int PB_LENGTH_SIGN = 32;
    private byte[] extData;
    private boolean isAccShow = false;
    private boolean isAddContent = false;
    private float level;
    private PoiResult poiResult;
    private String qid = null;
    private int scene;
    private boolean shouldDel = false;
    private boolean showAd;
    private String uid = null;
    /* renamed from: x */
    private double f19848x;
    /* renamed from: y */
    private double f19849y;

    public BMBarDynamicMapOverlay() {
        super(37);
    }

    public BMBarDynamicMapOverlay(AppBaseMap baseMap) {
        super(37, baseMap);
    }

    public void setPoiUid(String uid) {
        this.uid = uid;
    }

    public void setShouldDel(boolean del) {
        this.shouldDel = del;
    }

    public void setPoiResult(PoiResult poiResult) {
        this.poiResult = poiResult;
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
        this.f19848x = xx;
    }

    public void setY(double yy) {
        this.f19849y = yy;
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(0, 0, MapController.DYNAMIC_MAP_LAYER_TAG);
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
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
        if ((this.extData == null || this.poiResult == null) && this.shouldDel) {
            this.shouldDel = false;
            return generateDelJson();
        } else if ((this.poiResult == null || this.poiResult.getContentsCount() <= 0) && (this.extData == null || this.extData.length <= 0)) {
            return "";
        } else {
            return generateJson();
        }
    }

    public Bundle getParam() {
        Bundle bundle = new Bundle();
        Bundle data;
        if (this.poiResult != null && this.poiResult.getContentsCount() > 0) {
            ArrayList<Bundle> values = new ArrayList();
            data = new Bundle();
            if (this.poiResult.hasImgeExt()) {
                try {
                    byte[] extData = getExtData(DynamicHeaderMessage.parseFrom(this.poiResult.getImgeExt().toByteArray()).getDynamicPbRes().toByteArray());
                    if (extData != null) {
                        data.putByteArray("data", extData);
                        data.putInt(OVERLAY_KEY.IMG_EXT_LEN, extData.length);
                        values.add(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Bundle[] midpar = new Bundle[values.size()];
            for (int j = 0; j < values.size(); j++) {
                midpar[j] = (Bundle) values.get(j);
            }
            bundle.putParcelableArray(OVERLAY_KEY.IMG_EXT, midpar);
            this.poiResult = null;
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
            int i2;
            result.put("ud", this.uid);
            result.put(OVERLAY_KEY.DYNAMIC_SCENE, this.scene);
            result.put(OVERLAY_KEY.DYNAMIC_SHOW_AD, this.showAd ? 1 : 0);
            result.put("qid", this.qid);
            result.put("level", (double) this.level);
            result.put("x", this.f19848x);
            result.put("y", this.f19849y);
            String str = "rs_add";
            if (this.isAddContent) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            result.put(str, i2);
            String str2 = "show_force";
            if (!this.isAccShow) {
                i = 0;
            }
            result.put(str2, i);
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
