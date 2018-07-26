package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class CompassOverlay extends InnerOverlay {
    public CompassOverlay() {
        super(20);
    }

    public CompassOverlay(AppBaseMap baseMap) {
        super(20, baseMap);
    }

    public void setData(String strJson) {
        super.setData(strJson);
    }

    public String getLayerTag() {
        return "compass";
    }

    public boolean getDefaultShowStatus() {
        return true;
    }
}
