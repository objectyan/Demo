package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class CalDisOverlay extends InnerOverlay {
    public CalDisOverlay() {
        super(19);
    }

    public CalDisOverlay(AppBaseMap baseMap) {
        super(19, baseMap);
    }

    public Bundle getParam() {
        return null;
    }
}
