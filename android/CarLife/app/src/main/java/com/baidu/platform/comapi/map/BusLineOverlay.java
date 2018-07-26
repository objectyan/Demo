package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class BusLineOverlay extends InnerOverlay {
    private Bundle poiDetailBusLineBundle = null;

    public BusLineOverlay() {
        super(17);
    }

    public BusLineOverlay(AppBaseMap baseMap) {
        super(17, baseMap);
    }

    public Bundle getParam() {
        if (this.poiDetailBusLineBundle != null) {
            return this.poiDetailBusLineBundle;
        }
        return super.getParam();
    }

    public void setPoiDetailBusLineBundle(Bundle poiDetailBusLineBundle) {
        this.poiDetailBusLineBundle = poiDetailBusLineBundle;
    }
}
