package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class BusStationLabelOverlay extends InnerOverlay {
    public BusStationLabelOverlay() {
        super(32);
    }

    public BusStationLabelOverlay(AppBaseMap baseMap) {
        super(32, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(0, 0, "rtpopup");
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public int getType() {
        return -1;
    }
}
