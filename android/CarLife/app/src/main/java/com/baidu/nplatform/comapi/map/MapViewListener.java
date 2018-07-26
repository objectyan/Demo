package com.baidu.nplatform.comapi.map;

import com.baidu.nplatform.comapi.MapItem;

public interface MapViewListener {
    void onClickedBackground(int i, int i2);

    void onClickedBaseLayer();

    void onClickedBasePOILayer(MapItem mapItem);

    void onClickedCompassLayer();

    void onClickedCustomLayer(MapItem mapItem, int i, int i2);

    void onClickedEndLayer(MapItem mapItem, int i, int i2);

    void onClickedFavPoiLayer(MapItem mapItem);

    void onClickedPOIBkgLayer(MapItem mapItem);

    void onClickedPOILayer(MapItem mapItem);

    void onClickedPopupLayer();

    void onClickedRoute(MapItem mapItem);

    void onClickedRouteSpecLayer(MapItem mapItem);

    void onClickedRouteUgcItem(MapItem mapItem);

    void onClickedStartLayer(MapItem mapItem, int i, int i2);

    void onClickedStreetIndoorPoi(MapObj mapObj);

    void onClickedStreetPopup(String str);

    void onClickedThroughNodeLayer(MapItem mapItem, int i, int i2);

    void onClickedUgcItem(MapItem mapItem);

    void onDoubleFingerRotate();

    void onDoubleFingerZoom();

    void onMapAnimationFinish();

    void onMapNetworkingChanged(boolean z);

    void onMapObviousMove();
}
