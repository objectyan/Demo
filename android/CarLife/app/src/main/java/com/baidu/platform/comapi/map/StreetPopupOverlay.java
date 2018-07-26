package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class StreetPopupOverlay extends InnerOverlay {
    public StreetPopupOverlay() {
        super(30);
    }

    public StreetPopupOverlay(AppBaseMap baseMap) {
        super(30, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(2, 0, "streetpopup");
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }
}
