package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MyMapOverlay extends InnerOverlay {
    public static final int PB_LENGTH_SIGN = 32;
    private int deleteFlag = 0;
    private byte[] extData;
    private boolean isAddContent = false;
    private float level;
    private String qid = null;
    private int scene;
    private String uid = null;
    /* renamed from: x */
    private double f19850x;
    /* renamed from: y */
    private double f19851y;

    public MyMapOverlay() {
        super(37);
    }

    public MyMapOverlay(AppBaseMap baseMap) {
        super(37, baseMap);
    }

    public void setExtData(byte[] extData) {
        this.extData = getExtData(extData);
    }

    public void setDeleteFlag(int flag) {
        this.deleteFlag = flag;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLayerTag() {
        return MapController.DYNAMIC_MAP_LAYER_TAG;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public void setScene(int s) {
        this.scene = s;
    }

    public void setLevel(float l) {
        this.level = l;
    }

    public void setX(double xx) {
        this.f19850x = xx;
    }

    public void setY(double yy) {
        this.f19851y = yy;
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

    public void setData(String s) {
        super.setData(s);
    }

    public void resetDeleteFlag() {
        this.deleteFlag = 0;
    }

    public Bundle getParam() {
        Bundle bundle = new Bundle();
        if (this.extData != null && this.extData.length > 1) {
            Bundle data = new Bundle();
            data.putByteArray("data", this.extData);
            data.putInt(OVERLAY_KEY.IMG_EXT_LEN, this.extData.length);
            bundle.putParcelableArray(OVERLAY_KEY.IMG_EXT, new Bundle[]{data});
            this.extData = null;
        }
        return bundle;
    }

    private String generateRevJson() {
        JSONObject result = new JSONObject();
        try {
            result.put("ud", this.uid);
            result.put(OVERLAY_KEY.DYNAMIC_SCENE, this.scene);
            result.put("rs_rev", this.deleteFlag);
        } catch (JSONException e) {
            C2911f.b(e.getMessage());
        }
        return result.toString();
    }

    private String generateAddJson() {
        JSONObject result = new JSONObject();
        try {
            result.put("ud", this.uid);
            result.put(OVERLAY_KEY.DYNAMIC_SCENE, this.scene);
            result.put("rs_add", this.isAddContent ? 1 : 0);
        } catch (JSONException e) {
            C2911f.b(e.getMessage());
        }
        return result.toString();
    }

    public void clear() {
        super.clear();
    }

    public void setIsAddContent(boolean isAddContent) {
        this.isAddContent = isAddContent;
    }
}
