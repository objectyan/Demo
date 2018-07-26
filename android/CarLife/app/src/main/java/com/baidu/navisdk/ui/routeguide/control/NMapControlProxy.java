package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.comapi.base.BNObserver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class NMapControlProxy {
    private static volatile NMapControlProxy mInstance;

    private NMapControlProxy() {
    }

    public void addMapObserver(BNObserver observer) {
        BNMapController.getInstance().addObserver(observer);
    }

    public void deleteMapObserver(BNObserver observer) {
        BNMapController.getInstance().deleteObserver(observer);
    }

    public void deleteAllObserver() {
        BNMapController.getInstance().deleteAllObserver();
    }

    public static NMapControlProxy getInstance() {
        if (mInstance == null) {
            synchronized (NMapControlProxy.class) {
                if (mInstance == null) {
                    mInstance = new NMapControlProxy();
                }
            }
        }
        return mInstance;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (NMapControlProxy.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                }
            }
        }
        mInstance = null;
    }

    private void dispose() {
    }

    public int getLayerMode() {
        return BNMapController.getInstance().getLayerMode();
    }

    public void setLayerMode(int mode) {
        BNMapController.getInstance().setLayerMode(mode);
    }

    public void setDrawHouse(boolean bDrawHouse, boolean bUseLock) {
        BNMapController.getInstance().setDrawHouse(bDrawHouse, bUseLock);
    }

    public void setLevel(float level) {
        BNMapController.getInstance().setLevel(level);
    }

    public int getZoomLevel() {
        return BNMapController.getInstance().getZoomLevel();
    }

    public boolean zoomIn() {
        return BNMapController.getInstance().zoomIn();
    }

    public boolean zoomOut() {
        return BNMapController.getInstance().zoomOut();
    }

    public int getScreenWidth() {
        return BNMapController.getInstance().getScreenWidth();
    }

    public static int getScaleDis(int nLevel) {
        return MapController.getScaleDis(nLevel);
    }

    public double getZoomUnitsInMeter() {
        return BNMapController.getInstance().getZoomUnitsInMeter();
    }

    public boolean updateLayer(int layerType) {
        return BNMapController.getInstance().updateLayer(layerType);
    }

    public boolean UpdataBaseLayers() {
        return BNMapController.getInstance().UpdataBaseLayers();
    }

    public MapStatus getMapStatus() {
        return BNMapController.getInstance().getMapStatus();
    }

    public void enableTouchEventLookover(boolean b) {
        BNMapController.getInstance().enableTouchEventLookover(b);
    }

    public void setMapStatus(MapStatus st, AnimationType animationType) {
        BNMapController.getInstance().setMapStatus(st, animationType);
    }

    public void setMapStatus(MapStatus st, AnimationType animationType, int duration) {
        BNMapController.getInstance().setMapStatus(st, animationType, duration);
    }

    public boolean showLayer(int layerType, boolean show) {
        return BNMapController.getInstance().showLayer(layerType, show);
    }

    public GeoPoint getGeoPosByScreenPos(int inX, int inY) {
        return BNMapController.getInstance().getGeoPosByScreenPos(inX, inY);
    }

    public Point getScreenPosByGeoPos(GeoPoint geoPoint) {
        return BNMapController.getInstance().getScreenPosByGeoPos(geoPoint);
    }

    public void showTrafficMap(boolean bShow) {
        BNMapController.getInstance().showTrafficMap(bShow);
    }

    public void switchITSMode(boolean itsMode) {
        BNMapController.getInstance().switchITSMode(itsMode);
    }

    public void setNaviCarPos() {
        MapController mapController = BNMapController.getInstance().getMapController();
        if (mapController != null) {
            mapController.setNaviCarPos();
        }
    }
}
