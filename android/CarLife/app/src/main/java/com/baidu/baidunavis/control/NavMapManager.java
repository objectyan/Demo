package com.baidu.baidunavis.control;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidumaps.p042f.p046b.C0710a;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.BaseMapViewListener;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.nplatform.comapi.map.BNMapManager;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.CaptureMapListener;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapController.HeatMapType;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.NaviMapGestureAdapter;
import com.baidu.platform.comapi.map.NaviMapViewListener;

public class NavMapManager {
    private static final String TAG = NavMapManager.class.getSimpleName();
    private boolean isChangedMapMode;
    private boolean mBaseMapListenerModified;
    private MapViewListener mBaseMapViewListener;
    private boolean mInited;
    private MapController mMapController;
    private int[] mMapOverlays2BClosedInNavi;
    private int[] mMapOverlays2BClosedInRoute;
    private SparseArray<Boolean> mMapOverlaysChangeLog;
    private MapGLSurfaceView mMapView;
    private int mNaviMapMode;
    private NaviMapViewListener mNaviMapViewListener;
    private Object mSyncObj;
    private NaviMapGestureAdapter naviMapGestureAdapter;

    /* renamed from: com.baidu.baidunavis.control.NavMapManager$1 */
    class C08041 implements NaviMapViewListener {
        C08041() {
        }

        public void onAction(int eventGesture, Object arg) {
            BNMapManager.getInstance().onAction(eventGesture, arg);
        }

        public Point onTapInterception(Point point) {
            if (point == null) {
                return null;
            }
            com.baidu.nplatform.comapi.basestruct.Point pt = BNMapManager.getInstance().onTapInterception(new com.baidu.nplatform.comapi.basestruct.Point(point.getIntX(), point.getIntY()));
            if (pt == null) {
                return point;
            }
            point.setIntX(pt.getmPtx());
            point.setIntY(pt.getmPty());
            return point;
        }

        public boolean onItemClick(String mapObjJson, int clickedX, int clickedY) {
            NavLogUtils.m3003e(NavMapManager.TAG, "onItemClick: mapObjJson --> " + mapObjJson);
            return BNMapManager.getInstance().onItemClick(mapObjJson, clickedX, clickedY);
        }

        public void onMapAnimationFinish() {
            BNMapManager.getInstance().onMapAnimationFinish();
        }

        public void onMapRenderModeChange(int value) {
            BNMapManager.getInstance().onMapRenderModeChange(value);
        }

        public void resizeScreen(int width, int height) {
            BNMapController.getInstance().resizeScreen(width, height);
        }
    }

    static class Holder {
        private static NavMapManager sInstance = new NavMapManager();

        Holder() {
        }
    }

    private NavMapManager() {
        this.mSyncObj = new Object();
        this.mMapView = null;
        this.mMapController = null;
        this.mBaseMapViewListener = null;
        this.mInited = false;
        this.mBaseMapListenerModified = false;
        this.mNaviMapMode = 0;
        this.isChangedMapMode = false;
        this.mMapOverlays2BClosedInNavi = new int[]{7, 20, 12};
        this.mMapOverlays2BClosedInRoute = new int[]{20};
        this.mMapOverlaysChangeLog = new SparseArray();
        this.mNaviMapViewListener = new C08041();
        this.naviMapGestureAdapter = null;
    }

    public static NavMapManager getInstance() {
        return Holder.sInstance;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init() {
        /*
        r7 = this;
        r6 = 0;
        r2 = r7.mInited;
        if (r2 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r3 = r7.mSyncObj;	 Catch:{ Throwable -> 0x0012 }
        monitor-enter(r3);	 Catch:{ Throwable -> 0x0012 }
        r2 = r7.mInited;	 Catch:{ all -> 0x000f }
        if (r2 == 0) goto L_0x0033;
    L_0x000d:
        monitor-exit(r3);	 Catch:{ all -> 0x000f }
        goto L_0x0005;
    L_0x000f:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x000f }
        throw r2;	 Catch:{ Throwable -> 0x0012 }
    L_0x0012:
        r1 = move-exception;
        r7.mInited = r6;
        r2 = TAG;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "init: Exception --> ";
        r3 = r3.append(r4);
        r4 = r1.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r2, r3);
        goto L_0x0005;
    L_0x0033:
        r2 = 1;
        r7.mInited = r2;	 Catch:{ all -> 0x000f }
        r2 = r7.mMapView;	 Catch:{ all -> 0x000f }
        if (r2 != 0) goto L_0x0044;
    L_0x003a:
        r2 = com.baidu.mapframework.common.mapview.MapViewFactory.getInstance();	 Catch:{ all -> 0x000f }
        r2 = r2.getMapView();	 Catch:{ all -> 0x000f }
        r7.mMapView = r2;	 Catch:{ all -> 0x000f }
    L_0x0044:
        r2 = r7.mMapView;	 Catch:{ all -> 0x000f }
        r2 = r2.getController();	 Catch:{ all -> 0x000f }
        r7.mMapController = r2;	 Catch:{ all -> 0x000f }
        r0 = new android.os.Bundle;	 Catch:{ all -> 0x000f }
        r0.<init>();	 Catch:{ all -> 0x000f }
        r2 = "screen_width";
        r4 = r7.mMapView;	 Catch:{ all -> 0x000f }
        r4 = r4.getWidth();	 Catch:{ all -> 0x000f }
        r0.putInt(r2, r4);	 Catch:{ all -> 0x000f }
        r2 = "screen_height";
        r4 = r7.mMapView;	 Catch:{ all -> 0x000f }
        r4 = r4.getHeight();	 Catch:{ all -> 0x000f }
        r0.putInt(r2, r4);	 Catch:{ all -> 0x000f }
        r2 = com.baidu.nplatform.comapi.map.BNMapManager.getInstance();	 Catch:{ all -> 0x000f }
        r4 = com.baidu.baidunavis.model.NavCommonFuncModel.getInstance();	 Catch:{ all -> 0x000f }
        r4 = r4.getContext();	 Catch:{ all -> 0x000f }
        r2.init(r4, r0);	 Catch:{ all -> 0x000f }
        r2 = com.baidu.navisdk.comapi.mapcontrol.BNMapController.getInstance();	 Catch:{ all -> 0x000f }
        r4 = 9;
        r5 = 0;
        r2.showLayer(r4, r5);	 Catch:{ all -> 0x000f }
        r2 = com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper.getInstance();	 Catch:{ all -> 0x000f }
        r2.updateDayNightMode();	 Catch:{ all -> 0x000f }
        r2 = r7.mMapController;	 Catch:{ all -> 0x000f }
        r2 = r2.getMapClickEnable();	 Catch:{ all -> 0x000f }
        if (r2 != 0) goto L_0x0097;
    L_0x0091:
        r2 = r7.mMapController;	 Catch:{ all -> 0x000f }
        r4 = 1;
        r2.setMapClickEnable(r4);	 Catch:{ all -> 0x000f }
    L_0x0097:
        monitor-exit(r3);	 Catch:{ all -> 0x000f }
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.control.NavMapManager.init():void");
    }

    public void unInit() {
        try {
            synchronized (this.mSyncObj) {
                NavLogUtils.m3003e(TAG, "unInit: --> ");
                BNMapManager.getInstance().unInit();
                if (this.mMapController != null) {
                    int tmpScene = isMapConfigTrafficOn() ? 5 : 0;
                    PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
                    this.mMapController.setMapThemeScene(1, tmpScene, new Bundle());
                    PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
                    this.mMapController.setOverlookGestureEnable(true);
                }
                set3DGestureEnable(GlobalConfig.getInstance().isOpen3D());
                resetMapOverlays();
                this.mInited = false;
            }
        } catch (Throwable e) {
            this.mInited = false;
            NavLogUtils.m3003e(TAG, "unInit: Exception --> " + e.getMessage());
        }
    }

    public void addNaviMapListener() {
        NavLogUtils.m3003e(TAG, "addNaviMapListener: --> ");
        init();
        if (this.mMapController != null && this.mMapView != null) {
            this.mMapController.setNaviMapViewListener(this.mNaviMapViewListener);
            if (this.naviMapGestureAdapter != null) {
                this.mMapView.removeSimpleOnGestureListener(this.naviMapGestureAdapter);
            } else {
                this.naviMapGestureAdapter = new NaviMapGestureAdapter();
                this.naviMapGestureAdapter.setMapController(this.mMapController);
            }
            this.mMapView.addSimpleOnGestureListener(this.naviMapGestureAdapter);
        }
    }

    public void removeNaviMapListener() {
        NavLogUtils.m3003e(TAG, "removeNaviMapListener: --> ");
        if (this.mMapController != null && this.mMapView != null) {
            this.mMapController.setNaviMapViewListener(null);
            if (this.naviMapGestureAdapter != null) {
                this.mMapView.removeSimpleOnGestureListener(this.naviMapGestureAdapter);
            }
        }
    }

    public void setBaseMapViewListener(BaseMapViewListener baseMapViewListener) {
        if (this.mMapController != null) {
            this.mBaseMapListenerModified = true;
            this.mBaseMapViewListener = this.mMapController.getMapViewListener();
            this.mMapController.setMapViewListener(baseMapViewListener);
        }
    }

    public void resetBaseMapViewListener() {
        if (this.mMapController != null && this.mBaseMapListenerModified) {
            NavLogUtils.m3003e(TAG, "resetBaseMapViewListener: --> ");
            this.mBaseMapListenerModified = false;
            this.mMapController.setMapViewListener(this.mBaseMapViewListener);
        }
    }

    public void addMapObserver(BNMapObserver bnMapObserver) {
        if (bnMapObserver != null) {
            BNMapManager.getInstance().addMapObserver(bnMapObserver);
        }
    }

    public void deleteMapObserver(BNMapObserver bnMapObserver) {
        if (bnMapObserver != null) {
            BNMapManager.getInstance().deleteMapObserver(bnMapObserver);
        }
    }

    public void getMapScreenshot(final String cachePath, final Handler handler, final int msgId) {
        if (this.mMapController != null && cachePath != null && handler != null) {
            try {
                this.mMapController.setCaptureMapListener(new CaptureMapListener() {
                    public void onGetCaptureMap(boolean isCapOk) {
                        NavLogUtils.m3003e(NavMapManager.TAG, "onGetCaptureMap: isCapOk --> " + isCapOk);
                        Message msg = handler.obtainMessage(msgId);
                        if (isCapOk) {
                            msg.obj = BitmapFactory.decodeFile(cachePath);
                        } else {
                            msg.obj = null;
                        }
                        handler.sendMessage(msg);
                    }
                });
                this.mMapController.saveScreenToLocal(cachePath);
            } catch (Exception e) {
            }
        }
    }

    public int getNaviMapMode(int pageType) {
        switch (pageType) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 100;
            case 6:
                return 100;
            default:
                return 0;
        }
    }

    public void handleMapThemeAndScene(int pageType) {
        PerformStatisticsController.peByType(0, "map_handleMapThemeAndScene_start", System.currentTimeMillis());
        int naviMapMode = getNaviMapMode(pageType);
        initNaviSO();
        if (naviMapMode == 1 || naviMapMode == 2 || naviMapMode == 3) {
            closeSatellite();
            closeHotMap();
        }
        boolean mapToNav = false;
        if (naviMapMode == 1 || naviMapMode == 2 || naviMapMode == 3 || naviMapMode == 4 || naviMapMode == 5) {
            mapToNav = true;
        }
        NavLogUtils.m3003e(TAG, "handleMapThemeAndScene: --> pageType: " + pageType + ", naviMapMode: " + naviMapMode + ", mapToNav: " + mapToNav);
        if (mapToNav) {
            if (!C0705a.m2962a().m2978c(C0705a.f2270a)) {
                C0705a.m2962a().m2969a(C0705a.f2270a);
            }
            handleMapOverlays(naviMapMode);
            if (naviMapMode == 3 || naviMapMode == 1) {
                C0710a.m2996a().m2998a(7, false);
            }
            setNaviMapMode(naviMapMode);
        } else {
            setNaviMapMode(naviMapMode);
            C0705a.m2962a().m2974b(C0705a.f2270a);
            handleMapOverlays(naviMapMode);
        }
        PerformStatisticsController.peByType(0, "map_handleMapThemeAndScene_end", System.currentTimeMillis());
    }

    public void showCarResultLayer(boolean show) {
        NavLogUtils.m3003e(TAG, "showCarResultLayer show: " + show);
        BNMapController.getInstance().showLayer(10, show);
        if (!show) {
            BNMapController.getInstance().clearLayer(10);
        }
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().showLayer(8, show);
        if (!show) {
            BNMapController.getInstance().clearLayer(8);
        }
        BNMapController.getInstance().updateLayer(8);
        BNMapController.getInstance().showLayer(27, show);
        if (!show) {
            BNMapController.getInstance().clearLayer(27);
        }
        BNMapController.getInstance().updateLayer(27);
    }

    public int getNaviMapMode() {
        return this.mNaviMapMode;
    }

    public boolean isChangedMapMode() {
        return this.isChangedMapMode;
    }

    public void setNaviMapMode(int naviMapMode) {
        NavLogUtils.m3003e(TAG, "setNaviMapMode: naviMapMode --> " + naviMapMode);
        if (naviMapMode >= 100) {
            BNMapController.getInstance().setNaviMapMode(0);
            this.mNaviMapMode = 0;
        } else {
            BNMapController.getInstance().setNaviMapMode(naviMapMode);
            this.mNaviMapMode = naviMapMode;
        }
        if (this.mNaviMapMode != 0) {
            this.isChangedMapMode = true;
        }
    }

    public void initNaviSO() {
        if (!BaiduNaviManager.sIsNaviSoLoadSuccess) {
            NavLogUtils.m3003e(TAG, "handleMapSceneAndOverlays sIsNaviSoLoadSuccess false");
            NavInitController.getInstance().loadNaviSO();
        }
    }

    public void handleRoadCondition(int naviMapMode) {
        if (naviMapMode == 0 || naviMapMode >= 100) {
            BNRoutePlaner.getInstance().EnableRoadCondition(false);
        } else {
            BNRoutePlaner.getInstance().EnableRoadCondition(true);
        }
    }

    private void logChangeLog() {
        if (NavLogUtils.LOGGABLE) {
            for (int i = 0; i < this.mMapOverlaysChangeLog.size(); i++) {
                int key = this.mMapOverlaysChangeLog.keyAt(i);
                NavLogUtils.m3003e(TAG, "logChangeLog: --> key: " + key + ", value: " + ((Boolean) this.mMapOverlaysChangeLog.get(key)).booleanValue());
            }
        }
    }

    public void handleMapOverlays(int naviMapMode) {
        NavLogUtils.m3003e(TAG, "handleMapOverlays: naviMapMode --> " + naviMapMode);
        if (naviMapMode == 0) {
            resetMapOverlays();
        } else if (naviMapMode == 100) {
            for (int mapOverlayId : this.mMapOverlays2BClosedInRoute) {
                if (C0710a.m2996a().m3000a(mapOverlayId)) {
                    this.mMapOverlaysChangeLog.put(mapOverlayId, Boolean.TRUE);
                    C0710a.m2996a().m2998a(mapOverlayId, false);
                }
            }
            logChangeLog();
        } else {
            for (int mapOverlayId2 : this.mMapOverlays2BClosedInNavi) {
                if (C0710a.m2996a().m3000a(mapOverlayId2)) {
                    this.mMapOverlaysChangeLog.put(mapOverlayId2, Boolean.TRUE);
                    C0710a.m2996a().m2998a(mapOverlayId2, false);
                }
            }
            logChangeLog();
        }
    }

    public void resetMapOverlays() {
        NavLogUtils.m3003e(TAG, "resetMapOverlays: --> ");
        for (int mapOverlayId : this.mMapOverlays2BClosedInNavi) {
            if (((Boolean) this.mMapOverlaysChangeLog.get(mapOverlayId, Boolean.FALSE)).booleanValue()) {
                this.mMapOverlaysChangeLog.put(mapOverlayId, Boolean.FALSE);
                C0710a.m2996a().m2998a(mapOverlayId, true);
            }
        }
        if (this.mMapView != null) {
            MapStatus mapStatus = this.mMapView.getMapStatus();
            if (mapStatus != null) {
                mapStatus.overlooking = 0;
                mapStatus.rotation = 0;
                mapStatus.xOffset = 0.0f;
                mapStatus.yOffset = 0.0f;
                this.mMapView.setMapStatus(mapStatus);
            }
        }
        logChangeLog();
        NavLogUtils.m3003e(TAG, "resetMapOverlays: --> end");
    }

    public void set3DGestureEnable(boolean enable) {
        if (this.mMapController != null) {
            NavLogUtils.m3003e(TAG, "set3DGestureEnable: enable --> " + enable);
            this.mMapController.set3DGestureEnable(enable);
        }
    }

    public void setScreenShow(int top, int bottom, int left, int right) {
        BNMapController.getInstance().setScreenShow(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight(), ScreenUtil.getInstance().dip2px(top), ScreenUtil.getInstance().dip2px(bottom), ScreenUtil.getInstance().dip2px(left), ScreenUtil.getInstance().dip2px(right));
    }

    public void fullviewForCarResult(int top, int bottom, int left, int right) {
        setScreenShow(top, bottom, left, right);
        BNMapController.getInstance().resetRouteDetailIndex();
    }

    public boolean isMapConfigTrafficOn() {
        return MapViewConfig.getInstance().isTraffic();
    }

    public void syncMapTraffic() {
        if (this.mMapView != null) {
            boolean isMapConfigTrafficOn = isMapConfigTrafficOn();
            NavLogUtils.m3003e(TAG, "syncMapTraffic: isMapConfigTrafficOn --> " + isMapConfigTrafficOn);
            this.mMapView.forceSetTraffic(isMapConfigTrafficOn);
        }
    }

    public void closeSatellite() {
        if (this.mMapView != null) {
            MapViewConfig.getInstance().setMapMode(MapMode._2D);
            this.mMapView.setSatellite(false);
        }
    }

    public void closeHotMap() {
        MapViewFactory.getInstance().getMapView().getController().getBaseMap().ShowHotMap(false, HeatMapType.CITY.getId());
        GlobalConfig.getInstance().setHotMapLayerOnOff(false);
    }

    public void clearLocationIcon() {
        NavLogUtils.m3003e(TAG, "NMM.clearLocationIcon()");
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().clearDefaultLocationLayerData(new Bundle());
        }
    }

    public MapController getBaseMapController() {
        return this.mMapController;
    }

    public boolean releaseSharedMapData() {
        return BNMapController.getInstance().releaseSharedMapData();
    }

    public boolean updateShareMapData() {
        return BNMapController.getInstance().updateShareMapData();
    }
}
