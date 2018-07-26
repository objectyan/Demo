package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;

public interface MapLayerDataInterface {
    boolean hasLayer(int i);

    int mapLayerDataReq(Bundle bundle, int i, int i2);
}
