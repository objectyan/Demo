package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.LogUtil;

public class BaseMapCallback {
    private static SparseArray<MapLayerDataInterface> mCallbacks = new SparseArray(2);

    public boolean SetMapCallback(MapLayerDataInterface callback) {
        if (callback == null) {
            return false;
        }
        mCallbacks.put(0, callback);
        return true;
    }

    public static int ReqLayerData(Bundle b, int layerID, int lDataVer) {
        LogUtil.m15791e("layer", "ReqLayerData layerID = " + layerID);
        int size = mCallbacks.size();
        if (size == 0) {
            return 0;
        }
        for (int i = 0; i < size; i++) {
            MapLayerDataInterface callback = (MapLayerDataInterface) mCallbacks.valueAt(i);
            if (callback != null && callback.hasLayer(layerID)) {
                return callback.mapLayerDataReq(b, layerID, lDataVer);
            }
        }
        return 0;
    }
}
