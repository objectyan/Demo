package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class ITSRouteOverlay extends InnerOverlay {
    static ITSRouteOverlay itsRouteOverlay = null;

    public ITSRouteOverlay() {
        super(13);
    }

    public ITSRouteOverlay(AppBaseMap baseMap) {
        super(13, baseMap);
    }

    public int getUpdateType() {
        return 10;
    }

    public int getUpdateTimeInterval() {
        return 180000;
    }

    public String getLayerTag() {
        return "itsroute";
    }

    public boolean switchLayer(int iLayerSrc) {
        return this.mBaseMap.SwitchLayer(iLayerSrc, this.mLayerID);
    }

    public int getType() {
        return -2;
    }
}
