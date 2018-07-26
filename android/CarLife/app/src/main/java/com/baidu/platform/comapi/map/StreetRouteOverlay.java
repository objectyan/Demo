package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.provider.StreetscapeWalkRouteProvider;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class StreetRouteOverlay extends InnerOverlay {
    public static final int PAGE_FROM_BASELINE = 0;
    public static final int PAGE_FROM_WALK_NAVI = 1;
    private WalkNaviUpdateListener mListeners;
    private int mPageFrom;
    private StreetscapeWalkRouteProvider mProvider;

    public interface WalkNaviUpdateListener {
        boolean onWNStreetRouteLayerUpdate();
    }

    public StreetRouteOverlay() {
        super(35);
    }

    public StreetRouteOverlay(AppBaseMap baseMap) {
        super(35, baseMap);
    }

    public void addListener(WalkNaviUpdateListener listener) {
        this.mListeners = listener;
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(1, 0, MapController.STREETROUTE_LAYER_TAG);
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, false);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public void show(boolean isShow) {
        if (this.mLayerID != 0) {
            this.mBaseMap.ShowLayers(this.mLayerID, isShow);
        }
    }

    public String getData() {
        if (this.mListeners != null) {
            this.mListeners.onWNStreetRouteLayerUpdate();
        }
        if (this.mProvider == null || this.mProvider.getWalkPosBundle().getInt("unNodeCnt") == 0) {
            return "";
        }
        return this.mProvider.getRenderData();
    }

    public boolean updateData(Bundle bundle) {
        if (bundle.getInt("unNodeCnt") == 0) {
            return false;
        }
        if (this.mProvider == null) {
            this.mProvider = new StreetscapeWalkRouteProvider(bundle);
            return true;
        }
        this.mProvider.setWalkPosBundle(bundle);
        return true;
    }
}
