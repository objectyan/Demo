package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class BaseMapCallback {
    private static final ConcurrentHashMap<Long, C4785a> LAYER_CALLBACKS = new ConcurrentHashMap(2);

    public static boolean setMapCallback(long baseMapPtr, C4785a callback) {
        if (callback == null || baseMapPtr == 0) {
            return false;
        }
        LAYER_CALLBACKS.put(Long.valueOf(baseMapPtr), callback);
        return true;
    }

    public static int ReqLayerData(Bundle b, int layerID, int lDataVer) {
        if (LAYER_CALLBACKS.isEmpty()) {
            return 0;
        }
        for (Entry<Long, C4785a> entry : LAYER_CALLBACKS.entrySet()) {
            C4785a callback = (C4785a) entry.getValue();
            if (callback != null && callback.hasLayer(layerID)) {
                return callback.mapLayerDataReq(b, layerID, lDataVer);
            }
        }
        return 0;
    }
}
