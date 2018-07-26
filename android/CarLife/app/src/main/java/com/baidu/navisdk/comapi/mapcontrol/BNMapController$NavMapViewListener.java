package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Bundle;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.map.MapObj;
import com.baidu.nplatform.comapi.map.MapViewListener;

public class BNMapController$NavMapViewListener implements MapViewListener {
    final /* synthetic */ BNMapController this$0;

    public BNMapController$NavMapViewListener(BNMapController this$0) {
        this.this$0 = this$0;
    }

    public void onMapAnimationFinish() {
        LogUtil.m15791e(ModuleName.MAP, "onMapAnimationFinish");
        BNMapController.getInstance().notifyMapObservers(1, 257, null);
        if (BNMapController.access$000(this.this$0) != null) {
            BNMapController.access$000(this.this$0).updateLayer(10);
            BNMapController.access$000(this.this$0).UpdataBaseLayers();
        }
    }

    public void onMapNetworkingChanged(boolean bRequest) {
        LogUtil.m15791e(ModuleName.MAP, "onMapNetworkingChanged");
        if (bRequest) {
            BNMapController.getInstance().notifyMapObservers(1, 258, null);
        }
    }

    public void onMapObviousMove() {
        LogUtil.m15791e(ModuleName.MAP, "onMapObviousMove");
        BNMapController.getInstance().notifyMapObservers(2, 519, null);
    }

    public void onClickedBaseLayer() {
        LogUtil.m15791e(ModuleName.MAP, "onClickedBaseLayer");
        BNMapController.getInstance().notifyMapObservers(1, 261, null);
    }

    public void onClickedCompassLayer() {
        LogUtil.m15791e(ModuleName.MAP, "onClickedCompassLayer");
        BNMapController.getInstance().notifyMapObservers(1, 262, null);
    }

    public void onClickedPopupLayer() {
        LogUtil.m15791e(ModuleName.MAP, "onClickedPopupLayer");
        BNMapController.getInstance().notifyMapObservers(1, 263, null);
    }

    public void onClickedBasePOILayer(MapItem item) {
        LogUtil.m15791e(ModuleName.MAP, "onClickedBasePOILayer");
        BNMapController.getInstance().notifyMapObservers(1, 264, item);
    }

    public void onClickedFavPoiLayer(MapItem item) {
        LogUtil.m15791e(ModuleName.MAP, "onClickedFavPoiLayer");
        BNMapController.getInstance().notifyMapObservers(1, 276, item);
    }

    public void onClickedPOIBkgLayer(MapItem item) {
        LogUtil.m15791e(ModuleName.MAP, "onClickedPOIBkgLayer");
        BNMapController.getInstance().notifyMapObservers(1, 265, item);
    }

    public void onClickedStreetPopup(String b) {
    }

    public void onClickedBackground(int x, int y) {
        BNMapController.getInstance().notifyMapObservers(1, 272, null);
    }

    public void onClickedStreetIndoorPoi(MapObj mapObj) {
    }

    public void onDoubleFingerZoom() {
        LogUtil.m15791e(ModuleName.MAP, "onDoubleFingerZoom");
        BNMapController.getInstance().notifyMapObservers(2, 520, null);
    }

    public void onDoubleFingerRotate() {
        BNMapController.getInstance().notifyMapObservers(2, 521, null);
    }

    public void onClickedPOILayer(MapItem item) {
        LogUtil.m15791e(ModuleName.MAP, "onClickedPOILayer");
        BNMapController.getInstance().notifyMapObservers(1, 277, item);
    }

    public void onClickedRouteSpecLayer(MapItem item) {
        BNMapController.getInstance().notifyMapObservers(1, 278, item);
    }

    public void onClickedCustomLayer(MapItem item, int clickedX, int clickedY) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        bundle.putInt("clickedX", clickedX);
        bundle.putInt("clickedY", clickedY);
        BNMapController.getInstance().notifyMapObservers(1, 512, bundle);
    }

    public void onClickedStartLayer(MapItem item, int clickedX, int clickedY) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        bundle.putInt("clickedX", clickedX);
        bundle.putInt("clickedY", clickedY);
        BNMapController.getInstance().notifyMapObservers(1, 516, bundle);
    }

    public void onClickedThroughNodeLayer(MapItem item, int clickedX, int clickedY) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        bundle.putInt("clickedX", clickedX);
        bundle.putInt("clickedY", clickedY);
        BNMapController.getInstance().notifyMapObservers(1, 517, bundle);
    }

    public void onClickedEndLayer(MapItem item, int clickedX, int clickedY) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        bundle.putInt("clickedX", clickedX);
        bundle.putInt("clickedY", clickedY);
        BNMapController.getInstance().notifyMapObservers(1, 513, bundle);
    }

    public void onClickedRoute(MapItem item) {
        BNMapController.getInstance().notifyMapObservers(1, 514, item);
    }

    public void onClickedUgcItem(MapItem item) {
        BNMapController.getInstance().notifyMapObservers(1, 515, item);
    }

    public void onClickedRouteUgcItem(MapItem item) {
        BNMapController.getInstance().notifyMapObservers(1, 515, item);
    }
}
