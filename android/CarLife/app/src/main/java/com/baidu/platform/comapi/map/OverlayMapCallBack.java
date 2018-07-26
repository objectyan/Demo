package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.map.basemap.C4785a;

public final class OverlayMapCallBack implements C4785a {
    static final boolean DEBUG = false;
    static final String LAYERDATA_KEY = "jsondata";
    static final String LAYERDATA_PARAM = "param";
    static final String TAG = OverlayMapCallBack.class.getName();
    AppBaseMap mBaseMap = null;
    SparseArray<InnerOverlay> overlayMap = new SparseArray();

    public OverlayMapCallBack(AppBaseMap baseMap) {
        this.mBaseMap = baseMap;
    }

    public int getOverlaySize() {
        return this.overlayMap.size();
    }

    public int mapLayerDataReq(Bundle b, int layerID, int lDataVer) {
        long time = 0;
        if (MapTrace.enableTrace) {
            time = System.currentTimeMillis();
        }
        InnerOverlay ov = (InnerOverlay) this.overlayMap.get(layerID);
        if (ov == null) {
            return 0;
        }
        String strJson = ov.getData();
        if (this.mBaseMap.LayersIsShow(layerID)) {
            b.putString(LAYERDATA_KEY, strJson);
            Bundle param = ov.getParam();
            if (param != null) {
                b.putBundle(LAYERDATA_PARAM, param);
            }
        } else {
            b.putString(LAYERDATA_KEY, null);
        }
        if (MapTrace.enableTrace) {
            MapTrace.trace(TAG, "MapLayerDataReq:" + layerID + " tag:" + ov.getLayerTag() + " [" + (System.currentTimeMillis() - time) + "ms] LayerData:" + strJson);
        }
        return ov.getType();
    }

    public boolean hasLayer(int layerId) {
        return this.overlayMap.indexOfKey(layerId) >= 0;
    }

    public void addOverlay(InnerOverlay overlay) {
        this.overlayMap.put(overlay.mLayerID, overlay);
        overlay.SetMapParam(overlay.mLayerID, this.mBaseMap);
    }

    public InnerOverlay getOverlay(int layerID) {
        return (InnerOverlay) this.overlayMap.get(layerID);
    }

    public void remove(Overlay overlay) {
        this.overlayMap.remove(overlay.mLayerID);
    }

    public void clear() {
        if (this.mBaseMap != null) {
            int size = this.overlayMap.size();
            for (int i = 0; i < size; i++) {
                int layerId = this.overlayMap.keyAt(i);
                if (layerId > 0) {
                    this.mBaseMap.ClearLayer(layerId);
                    this.mBaseMap.RemoveLayer(layerId);
                }
            }
        }
        this.overlayMap.clear();
    }
}
