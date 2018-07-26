package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class RgcOverlay extends InnerOverlay {
    public static final int RGC_OVERLAY_TYPE_POIMARK = 3;
    public static final int RGC_OVERLAY_TYPE_POIRGCSHARE = 2;
    public static final int RGC_OVERLAY_TYPE_POISHARE = 1;
    public static final int RGC_OVERLAY_TYPE_REGEO = 0;
    static RgcOverlay rgcOverlay = null;
    int rgcIndex = 0;
    int rgcType = 0;

    public RgcOverlay() {
        super(18);
    }

    public RgcOverlay(AppBaseMap baseMap) {
        super(18, baseMap);
    }

    public void setRgcPoiIndex(int index) {
        this.rgcIndex = index;
    }

    public void setRgcType(int type) {
        this.rgcType = type;
    }

    public Bundle getParam() {
        Bundle param = new Bundle();
        param.putInt("rgcIndex", this.rgcIndex);
        param.putInt("rgcType", this.rgcType);
        return param;
    }
}
