package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public abstract class InnerOverlay extends Overlay {
    static final boolean DEBUG = false;
    private static final String TAG = "InnerOverlay";
    AppBaseMap mBaseMap = null;
    String strJsonData = null;

    public InnerOverlay(int type) {
        setType(type);
    }

    public InnerOverlay(int type, AppBaseMap baseMap) {
        setType(type);
        this.mBaseMap = baseMap;
    }

    public void SetMapParam(int layerID, AppBaseMap baseMap) {
        this.mLayerID = layerID;
        this.mBaseMap = baseMap;
    }

    public void SetOverlayShow(boolean bShow) {
        if (this.mLayerID != 0 && this.mBaseMap != null && this.mBaseMap.GetId() != 0) {
            long time = 0;
            if (MapTrace.enableTrace) {
                time = System.currentTimeMillis();
            }
            this.mBaseMap.ShowLayers(this.mLayerID, bShow);
            if (MapTrace.enableTrace) {
                MapTrace.trace(TAG, "ShowLayer:" + this.mLayerID + Config.TRACE_TODAY_VISIT_SPLIT + bShow + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - time) + "ms]");
            }
        }
    }

    public boolean IsOverlayShow() {
        return (this.mLayerID == 0 || this.mBaseMap == null || this.mBaseMap.GetId() == 0 || !this.mBaseMap.LayersIsShow(this.mLayerID)) ? false : true;
    }

    public void UpdateOverlay() {
        if (this.mLayerID != 0 && this.mBaseMap != null && this.mBaseMap.GetId() != 0) {
            long time = 0;
            if (MapTrace.enableTrace) {
                time = System.currentTimeMillis();
            }
            this.mBaseMap.UpdateLayers(this.mLayerID);
            if (MapTrace.enableTrace) {
                MapTrace.trace(TAG, "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - time) + "ms]");
            }
        }
    }

    public void setData(String strJson) {
        if (strJson != null) {
            this.strJsonData = strJson;
        }
    }

    public String getData() {
        return this.strJsonData;
    }

    public Bundle getParam() {
        return null;
    }

    public void clear() {
        long time = 0;
        if (MapTrace.enableTrace) {
            time = System.currentTimeMillis();
        }
        if (!TextUtils.isEmpty(this.strJsonData)) {
            this.strJsonData = null;
            if (this.mBaseMap != null) {
                this.mBaseMap.ClearLayer(this.mLayerID);
            }
        }
        if (MapTrace.enableTrace) {
            MapTrace.trace(TAG, "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - time) + "ms]");
        }
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getType() {
        return this.mType;
    }

    public int getUpdateType() {
        return 0;
    }

    public int getUpdateTimeInterval() {
        return 0;
    }

    public String getLayerTag() {
        return "default";
    }

    public boolean getDefaultShowStatus() {
        return false;
    }

    public void setFocus(int index, boolean bFocus, String uid) {
        if (this.mBaseMap != null && this.mBaseMap.GetId() != 0) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(uid)) {
                bundle.putString("uid", uid);
            }
            this.mBaseMap.SetFocus(this.mLayerID, index, bFocus, bundle);
        }
    }

    public void setFocus(int index, boolean bFocus) {
        setFocus(index, bFocus, null);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null || this.mBaseMap.GetId() == 0) {
            return false;
        }
        long time = 0;
        if (MapTrace.enableTrace) {
            time = System.currentTimeMillis();
        }
        this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
        if (MapTrace.enableTrace) {
            MapTrace.trace(TAG, "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - time) + "ms]");
        }
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        SetOverlayShow(getDefaultShowStatus());
        return true;
    }

    public boolean insertToMapView(int pos) {
        if (this.mBaseMap == null || this.mBaseMap.GetId() == 0) {
            return false;
        }
        this.mLayerID = this.mBaseMap.InsertLayerAt(pos, getUpdateType(), getUpdateTimeInterval(), getLayerTag());
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        SetOverlayShow(getDefaultShowStatus());
        return true;
    }
}
