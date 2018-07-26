package com.baidu.platform.comapi.map;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnKeyListener;
import com.baidu.platform.basic.BMExecutorsManager;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapRenderer.CaptureMapViewListener;
import com.baidu.platform.comapi.map.MapRenderer.ResourceRecycler;
import com.baidu.platform.comapi.map.MapStatus.GeoBound;
import com.baidu.platform.comapi.map.MapStatus.WinRound;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.util.C4821e;
import com.baidu.platform.comapi.util.C4824h;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class MapGLSurfaceView extends BaiduGLSurfaceView implements OnKeyListener, MapRenderModeChangeListener, ResourceRecycler, MapViewInterface {
    private static final boolean DEBUG = false;
    public static final int FLAG_OVERLAY_BMBAR_DYNAMCI_MAP = 3145728;
    public static final int FLAG_OVERLAY_BUSLINE = 2;
    public static final int FLAG_OVERLAY_BUS_STATION_LABEL = 16384;
    public static final int FLAG_OVERLAY_CALDIS = 8;
    public static final int FLAG_OVERLAY_CITY_AREA = 262144;
    public static final int FLAG_OVERLAY_COMPASS = 1024;
    private static final int FLAG_OVERLAY_DEFAULT = 24964847;
    public static final int FLAG_OVERLAY_FAV = 16;
    public static final int FLAG_OVERLAY_HEATMAP_CHILD_ITEM = 65536;
    public static final int FLAG_OVERLAY_ITSROUTE = 64;
    public static final int FLAG_OVERLAY_LOCATION = 1;
    public static final int FLAG_OVERLAY_MY_MAP = 18874368;
    public static final int FLAG_OVERLAY_POI = 512;
    public static final int FLAG_OVERLAY_POIBKG = 128;
    public static final int FLAG_OVERLAY_POI_CHILD_ITEM = 32768;
    public static final int FLAG_OVERLAY_POI_CHILD_POINT_ITEM = 524288;
    public static final int FLAG_OVERLAY_POI_DYNAMCI_MAP = 2097152;
    public static final int FLAG_OVERLAY_POI_ICON_ITEM = 1048576;
    public static final int FLAG_OVERLAY_POPUP = 2048;
    public static final int FLAG_OVERLAY_RGC = 32;
    public static final int FLAG_OVERLAY_ROUTE = 4;
    public static final int FLAG_OVERLAY_ROUTE_LABEL = 8192;
    public static final int FLAG_OVERLAY_ROUTE_POI_MAP = 4194304;
    public static final int FLAG_OVERLAY_STREET_POPUP = 4096;
    public static final int FLAG_OVERLAY_STREET_ROUTE = 131072;
    public static final int FLAG_OVERLAY_TA_DYNAMCI_MAP = 5242880;
    public static final int FLAG_OVERLAY_TRACK_REGION = 16777216;
    public static final int FLAG_OVERLAY_WALK_SEARCH_MAP = 8388608;
    private static final String TAG = "GLSurfaceView";
    private static int mRef = 0;
    private static final ExecutorService singleThreadPool = BMExecutorsManager.newSingleThreadExecutor(new C4824h("MapLayerThread"));
    private List<Overlay> innerOverlayList = new ArrayList();
    private volatile boolean isInited = false;
    private LocationOverlay mDefaultLocationLay;
    private boolean mDettachedFlag = true;
    private GestureDetector mGestureDetector;
    private int mHeight = 0;
    private volatile boolean mIsSatelliteOn = false;
    private volatile boolean mIsStreetRoadOn = false;
    private volatile boolean mIsTrafficOn = false;
    MapController mMapController = null;
    private HashSet<MapViewStateListener> mMapViewStateListeners = new HashSet();
    private int mNMin = 0;
    private int mNWeek = 0;
    private int mNhour = 0;
    InternalProjection mProjection = null;
    MapRenderer mRenderer;
    private int mWidth = 0;
    public MapCardMode mapCardMode;
    private int overlayFlags = FLAG_OVERLAY_DEFAULT;
    OverlayMapCallBack overlayMapCallBack = null;
    private SimpleGestureAdapter simpleGestureAdapter;
    public int state;

    /* renamed from: com.baidu.platform.comapi.map.MapGLSurfaceView$1 */
    class C47801 implements Runnable {
        C47801() {
        }

        public void run() {
            if (MapGLSurfaceView.this.mMapController != null) {
                AppBaseMap baseMap = MapGLSurfaceView.this.mMapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.ShowSatelliteMap(MapGLSurfaceView.this.mIsSatelliteOn);
                }
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.map.MapGLSurfaceView$2 */
    class C47812 implements Runnable {
        C47812() {
        }

        public void run() {
            if (MapGLSurfaceView.this.mMapController != null) {
                AppBaseMap baseMap = MapGLSurfaceView.this.mMapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.ShowTrafficMap(MapGLSurfaceView.this.mIsTrafficOn);
                }
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.map.MapGLSurfaceView$3 */
    class C47823 implements Runnable {
        C47823() {
        }

        public void run() {
            if (MapGLSurfaceView.this.mMapController != null) {
                AppBaseMap baseMap = MapGLSurfaceView.this.mMapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.ShowTrafficMap(MapGLSurfaceView.this.mIsTrafficOn);
                }
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.map.MapGLSurfaceView$4 */
    class C47834 implements Runnable {
        C47834() {
        }

        public void run() {
            if (MapGLSurfaceView.this.mMapController != null) {
                AppBaseMap baseMap = MapGLSurfaceView.this.mMapController.getBaseMap();
                if (baseMap != null) {
                    baseMap.ShowStreetRoadMap(MapGLSurfaceView.this.mIsStreetRoadOn);
                }
            }
        }
    }

    public enum MapCardMode {
        NONE,
        INDOORDETAIL(OVERLAY_KEY.INDOOR),
        POIDETAIL("poi"),
        NOMAL;
        
        private String mode;

        private MapCardMode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return this.mode;
        }
    }

    public void setOverlayFlags(int flags) {
        this.overlayFlags = flags;
    }

    public MapGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        this.simpleGestureAdapter = new SimpleGestureAdapter();
        this.mGestureDetector = new GestureDetector(context, this.simpleGestureAdapter);
        this.mRenderer = new MapRenderer(new WeakReference(this), (ResourceRecycler) this);
        try {
            if (C4821e.m16003a(8, 8, 8, 0, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 0, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException e) {
            setEGLConfigChooser(true);
        }
        setRenderer(this.mRenderer);
        setRenderMode(1);
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int width, int height) {
        this.mRenderer.doCaptureMapView(captureMapViewListener, width, height);
    }

    public void setPixelFormatTransparent(boolean bTransparent) {
        if (bTransparent) {
            getHolder().setFormat(-3);
        } else {
            getHolder().setFormat(-1);
        }
    }

    public ExecutorService getSingleThreadPool() {
        return singleThreadPool;
    }

    public void setMapController(MapController mapController) {
        if (this.mMapController == null) {
            this.mMapController = mapController;
            this.mRenderer.setBaseMapId(this.mMapController.getMapId());
            this.mRenderer.setMapResInitOk(true);
            this.overlayMapCallBack = new OverlayMapCallBack(this.mMapController.getBaseMap());
            this.mMapController.setOverlayMapCallBack(this.overlayMapCallBack);
            this.mMapController.setMapViewInterface(this);
            initInnerOverlays();
            this.mMapController.setMapRenderModeChangeListener(this);
            this.isInited = true;
            this.mProjection = new InternalProjection(this.mMapController);
            this.simpleGestureAdapter.setMapController(this.mMapController);
        }
    }

    public void initMapGesture() {
        if (this.simpleGestureAdapter == null) {
            this.simpleGestureAdapter = new SimpleGestureAdapter();
            this.mGestureDetector = new GestureDetector(getContext(), this.simpleGestureAdapter);
        }
        setOnKeyListener(this);
        setLongClickable(true);
    }

    private void clearInnerOverlays() {
        if (this.mMapController != null && this.mMapController.getBaseMap() != null && this.overlayMapCallBack != null) {
            this.innerOverlayList.clear();
            this.overlayMapCallBack.clear();
        }
    }

    private void initInnerOverlays() {
        if (this.mMapController != null) {
            AppBaseMap baseMap = this.mMapController.getBaseMap();
            if (baseMap != null) {
                clearInnerOverlays();
                if ((this.overlayFlags & 128) != 0) {
                    addOverlay(new PoiBkgOverlay(baseMap));
                }
                if ((this.overlayFlags & 2) != 0) {
                    addOverlay(new BusLineOverlay(baseMap));
                }
                if ((this.overlayFlags & 4) != 0) {
                    addOverlay(new RouteOverlay(baseMap));
                }
                if ((this.overlayFlags & 8) != 0) {
                    addOverlay(new CalDisOverlay(baseMap));
                }
                if ((this.overlayFlags & 32) != 0) {
                    addOverlay(new RgcOverlay(baseMap));
                }
                if ((this.overlayFlags & 16777216) != 0) {
                    addOverlay(new TrackRegionItemOverlay(baseMap));
                }
                if ((this.overlayFlags & 2097152) != 0) {
                    addOverlay(new MyMapOverlay(baseMap));
                }
                if ((this.overlayFlags & FLAG_OVERLAY_TA_DYNAMCI_MAP) != 0) {
                    addOverlay(new TravelAssistantMapOverlay(baseMap));
                }
                if ((this.overlayFlags & FLAG_OVERLAY_BMBAR_DYNAMCI_MAP) != 0) {
                    addOverlay(new BMBarDynamicMapOverlay(baseMap));
                }
                if ((this.overlayFlags & 2097152) != 0) {
                    addOverlay(new PoiDynamicMapOverlay(baseMap));
                }
                if ((this.overlayFlags & 64) != 0) {
                    addOverlay(new ITSRouteOverlay(baseMap));
                    addOverlay(new ITSRouteOverlay(baseMap));
                    addOverlay(new ITSRouteOverlay(baseMap));
                }
                if ((this.overlayFlags & 8192) != 0) {
                    addOverlay(new RouteLabelOverlay(baseMap));
                }
                if ((this.overlayFlags & 16384) != 0) {
                    addOverlay(new BusStationLabelOverlay(baseMap));
                }
                if ((this.overlayFlags & 1) != 0) {
                    this.mDefaultLocationLay = new LocationOverlay(baseMap);
                    addOverlay(this.mDefaultLocationLay);
                }
                if ((this.overlayFlags & 32768) != 0) {
                    addOverlay(new PoiChildItemOverlay(baseMap));
                }
                if ((this.overlayFlags & 262144) != 0) {
                    addOverlay(new CityAreaOverlay(baseMap));
                }
                if ((this.overlayFlags & 65536) != 0) {
                    addOverlay(new HeatMapChildItemOverlay(baseMap));
                }
                if ((this.overlayFlags & 512) != 0) {
                    addOverlay(new PoiOverlay(baseMap));
                }
                if ((this.overlayFlags & 1024) != 0) {
                    addOverlay(new CompassOverlay(baseMap));
                }
                if ((this.overlayFlags & 4096) != 0) {
                    addOverlay(new StreetPopupOverlay(baseMap));
                }
                if ((this.overlayFlags & 131072) != 0) {
                    addOverlay(new StreetRouteOverlay(baseMap));
                }
                if ((this.overlayFlags & 4194304) != 0) {
                    addOverlay(new RoutePoiOverlay(baseMap));
                }
                if ((this.overlayFlags & 4194304) != 0) {
                    addOverlay(new WalkSearchOverlay(baseMap));
                }
            }
        }
    }

    public synchronized boolean addOverlay(Overlay overlay) {
        boolean z;
        if (overlay != null) {
            if (this.mMapController != null) {
                AppBaseMap baseMap = this.mMapController.getBaseMap();
                if (baseMap == null) {
                    z = false;
                } else if (overlay instanceof StreetPopupOverlay) {
                    z = ((InnerOverlay) overlay).addedToMapView();
                } else if (overlay instanceof InnerOverlay) {
                    if (((InnerOverlay) overlay).mBaseMap == null) {
                        ((InnerOverlay) overlay).mBaseMap = getController().getBaseMap();
                    }
                    if (((InnerOverlay) overlay).addedToMapView()) {
                        this.innerOverlayList.add(overlay);
                        this.overlayMapCallBack.addOverlay((InnerOverlay) overlay);
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (overlay instanceof ItemizedOverlay) {
                    overlay.mLayerID = baseMap.AddLayer(((ItemizedOverlay) overlay).getUpdateType(), 0, "item");
                    if (overlay.mLayerID == 0) {
                        z = false;
                    } else {
                        this.innerOverlayList.add(overlay);
                        ((ItemizedOverlay) overlay).reAddAll();
                        baseMap.SetLayersClickable(overlay.mLayerID, true);
                        baseMap.ShowLayers(overlay.mLayerID, true);
                        baseMap.UpdateLayers(overlay.mLayerID);
                        z = true;
                    }
                } else {
                    if (overlay instanceof RtPopupOverlay) {
                        ((RtPopupOverlay) overlay).initLayer();
                        if (overlay.mLayerID == 0) {
                            z = false;
                        } else {
                            this.innerOverlayList.add(overlay);
                            ((RtPopupOverlay) overlay).reAddAll();
                            baseMap.SetLayersClickable(overlay.mLayerID, false);
                            baseMap.ShowLayers(overlay.mLayerID, true);
                        }
                    }
                    z = false;
                }
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean insertOverlay(Overlay overlay, int pos) {
        boolean z;
        if (!(overlay instanceof InnerOverlay) || this.mMapController == null) {
            z = false;
        } else {
            if (((InnerOverlay) overlay).mBaseMap == null) {
                ((InnerOverlay) overlay).mBaseMap = this.mMapController.getBaseMap();
            }
            if (((InnerOverlay) overlay).insertToMapView(pos)) {
                this.innerOverlayList.add(overlay);
                this.overlayMapCallBack.addOverlay((InnerOverlay) overlay);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public int getLayerPos(int layerId) {
        if (this.mMapController == null) {
            return -1;
        }
        AppBaseMap baseMap = this.mMapController.getBaseMap();
        if (baseMap != null) {
            return baseMap.GetLayerPos(layerId);
        }
        return -1;
    }

    public synchronized boolean removeOverlay(Overlay overlay) {
        boolean z = false;
        synchronized (this) {
            if (overlay != null) {
                if (this.mMapController != null) {
                    AppBaseMap baseMap = this.mMapController.getBaseMap();
                    if (baseMap != null) {
                        baseMap.ClearLayer(overlay.mLayerID);
                        baseMap.ShowLayers(overlay.mLayerID, false);
                        baseMap.UpdateLayers(overlay.mLayerID);
                        baseMap.RemoveLayer(overlay.mLayerID);
                        if (overlay instanceof ItemizedOverlay) {
                            this.innerOverlayList.remove(overlay);
                        } else if (overlay instanceof InnerOverlay) {
                            this.innerOverlayList.remove(overlay);
                            this.overlayMapCallBack.remove(overlay);
                        }
                        overlay.mLayerID = 0;
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public void unInit() {
        mRef--;
        if (mRef == 0) {
            this.mMapController.unInit();
            this.mMapController = null;
            this.overlayMapCallBack.clear();
            this.overlayMapCallBack = null;
            this.mProjection = null;
        }
        this.mRenderer = null;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);
        if (holder != null && !holder.getSurface().isValid()) {
            surfaceDestroyed(holder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (this != v || event.getAction() != 0) {
            return false;
        }
        switch (keyCode) {
            case 19:
                this.mMapController.scrollBy(0, -50);
                break;
            case 20:
                this.mMapController.scrollBy(0, 50);
                break;
            case 21:
                this.mMapController.scrollBy(-50, 0);
                break;
            case 22:
                this.mMapController.scrollBy(50, 0);
                break;
            default:
                return false;
        }
        return true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (VERSION.SDK_INT < 14) {
            this.mDettachedFlag = true;
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        if (this.mRenderer != null) {
            this.mRenderer.w_old = w;
            this.mRenderer.h_old = h;
            this.mRenderer.resize_tries = 0;
        }
        this.mWidth = w;
        this.mHeight = h;
        super.surfaceChanged(holder, format, w, h);
        if (this.mMapController != null) {
            MapStatus st = getMapStatus();
            if (st != null) {
                st.winRound.left = 0;
                st.winRound.top = 0;
                st.winRound.bottom = h;
                st.winRound.right = w;
                setMapStatus(st);
            }
            this.mMapController.setScreenSize(this.mWidth, this.mHeight);
            if (this.mMapController.isNaviMode() && this.mMapController.getNaviMapViewListener() != null) {
                this.mMapController.getNaviMapViewListener().resizeScreen(w, h);
            }
        }
    }

    public void onResume() {
        if (this.isInited) {
            if (this.mMapController != null) {
                this.mMapController.onResume();
            }
            Iterator it = this.mMapViewStateListeners.iterator();
            while (it.hasNext()) {
                ((MapViewStateListener) it.next()).onMapViewResume(this);
            }
            setRenderMode(1);
            super.onResume();
        }
    }

    public void onPause() {
        if (this.mMapController != null) {
            this.mMapController.onPause();
        }
        Iterator it = this.mMapViewStateListeners.iterator();
        while (it.hasNext()) {
            ((MapViewStateListener) it.next()).onMapViewPause(this);
        }
        super.onPause();
    }

    public void addSimpleOnGestureListener(SimpleOnGestureListener listener) {
        this.simpleGestureAdapter.addSimpleOnGestureListener(listener);
    }

    public void removeSimpleOnGestureListener(SimpleOnGestureListener listener) {
        this.simpleGestureAdapter.removeSimpleOnGestureListener(listener);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.mGestureDetector != null && this.mGestureDetector.onTouchEvent(event)) {
            return true;
        }
        if (this.mMapController == null || !this.mMapController.handleTouchEvent(event)) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    public MapController getController() {
        return this.mMapController;
    }

    public int getLatitudeSpan() {
        InternalProjection p = (InternalProjection) getProjection();
        return (int) Math.abs(p.fromPixels(0, 0).getLatitude() - p.fromPixels(this.mWidth - 1, this.mHeight - 1).getLatitude());
    }

    public int getLongitudeSpan() {
        InternalProjection p = (InternalProjection) getProjection();
        return (int) Math.abs(p.fromPixels(this.mWidth - 1, this.mHeight - 1).getLongitude() - p.fromPixels(0, 0).getLongitude());
    }

    public List<Overlay> getOverlays() {
        return this.innerOverlayList;
    }

    public synchronized Overlay getOverlay(int layerType) {
        Overlay overlay;
        if (layerType == 21) {
            overlay = null;
        } else {
            for (Overlay overlay2 : this.innerOverlayList) {
                if (overlay2.mType == layerType) {
                    break;
                }
            }
            overlay2 = null;
        }
        return overlay2;
    }

    public synchronized Overlay getOverlay(Class<?> overlayClass) {
        Overlay layer;
        for (Overlay layer2 : this.innerOverlayList) {
            if (layer2.getClass() == overlayClass) {
                break;
            }
        }
        layer2 = null;
        return layer2;
    }

    public synchronized List<ITSRouteOverlay> getITSRouteOverlays() {
        Throwable th;
        try {
            List<ITSRouteOverlay> overlays = null;
            for (Overlay layer : this.innerOverlayList) {
                List<ITSRouteOverlay> overlays2;
                try {
                    if (layer.getClass() == ITSRouteOverlay.class) {
                        if (overlays == null) {
                            overlays2 = new ArrayList();
                        } else {
                            overlays2 = overlays;
                        }
                        overlays2.add((ITSRouteOverlay) layer);
                    } else {
                        overlays2 = overlays;
                    }
                    overlays = overlays2;
                } catch (Throwable th2) {
                    th = th2;
                    overlays2 = overlays;
                }
            }
            return overlays;
        } catch (Throwable th3) {
            th = th3;
        }
        throw th;
    }

    public Projection getProjection() {
        return this.mProjection;
    }

    public boolean enable3D() {
        return true;
    }

    public boolean isSatellite() {
        return this.mIsSatelliteOn;
    }

    public boolean isTraffic() {
        return this.mIsTrafficOn;
    }

    public void setSatellite(boolean on) {
        if (this.mMapController != null) {
            this.mIsSatelliteOn = on;
        }
        singleThreadPool.submit(new C47801());
    }

    public void forceSetTraffic(boolean on) {
        if (this.mMapController != null) {
            this.mIsTrafficOn = on;
        }
        singleThreadPool.submit(new C47812());
    }

    public void setTraffic(boolean on) {
        if (this.mIsTrafficOn != on) {
            if (this.mMapController != null) {
                this.mIsTrafficOn = on;
            }
            singleThreadPool.submit(new C47823());
        }
    }

    public boolean setItsPreTime(int nweek, int nhour, int nMin) {
        if (this.mNWeek == nweek && this.mNhour == nhour && this.mNMin == nMin) {
            return true;
        }
        if (this.mMapController != null) {
            AppBaseMap baseMap = this.mMapController.getBaseMap();
            if (baseMap != null) {
                this.mNWeek = nweek;
                this.mNhour = nhour;
                this.mNMin = nMin;
                return baseMap.SetItsPreTime(nweek, nhour, nMin);
            }
        }
        return false;
    }

    public boolean isPredictTraffic() {
        if (this.mNWeek > 0 || this.mNhour > 0 || this.mNMin > 0) {
            return true;
        }
        return false;
    }

    public void setMapTo2D(boolean on) {
    }

    public MapViewListener getMapViewListener() {
        return this.mMapController != null ? this.mMapController.getMapViewListener() : null;
    }

    public void animateTo(MapStatus st, int animTime) {
        if (this.mMapController != null) {
            this.mMapController.setMapStatusWithAnimation(st, animTime);
        }
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> list) {
        this.mDefaultLocationLay.setLocationLayerData(list);
    }

    public void clearDefaultLocationLayerData(Bundle bundle) {
        this.mDefaultLocationLay.clearLocationLayerData(bundle);
    }

    void scrollByPixel(int x, int y) {
        if (this.mMapController != null) {
            this.mMapController.moveMapToScrPoint((this.mWidth / 2) + x, (this.mHeight / 2) + y);
        }
    }

    double getZoomUnitsInMeter() {
        return this.mMapController != null ? this.mMapController.getZoomUnitsInMeter() : 0.0d;
    }

    public void setMapCenter(GeoPoint geoPoint) {
        if (this.mMapController != null) {
            MapStatus mapStatus = this.mMapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    public GeoPoint getMapCenter() {
        if (this.mMapController == null) {
            return null;
        }
        MapStatus mapStatus = this.mMapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    public void setZoomLevel(float zoomLevel) {
        if (this.mMapController != null) {
            float iLevel = zoomLevel;
            int maxZoomLevel = 21;
            if (getController().getFocusedBaseIndoorMapInfo() != null) {
                maxZoomLevel = 22;
            }
            if (iLevel < 4.0f) {
                iLevel = 4.0f;
            } else if (iLevel > ((float) maxZoomLevel)) {
                iLevel = (float) maxZoomLevel;
            }
            MapStatus st = getMapStatus();
            if (st != null) {
                st.level = iLevel;
                animateTo(st, 400);
            }
        }
    }

    public void setZoomLevel(int zoomLevel) {
        setZoomLevel((float) zoomLevel);
    }

    public float getZoomLevel() {
        return this.mMapController != null ? this.mMapController.getZoomLevel() : 0.0f;
    }

    public void setRotation(int rotation) {
        if (this.mMapController != null) {
            MapStatus mapStatus = this.mMapController.getMapStatus();
            mapStatus.rotation = rotation;
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    public int getMapRotation() {
        if (this.mMapController == null) {
            return 0;
        }
        return this.mMapController.getMapStatus().rotation;
    }

    public void setOverlooking(int overlooking) {
        if (this.mMapController != null) {
            MapStatus mapStatus = this.mMapController.getMapStatus();
            mapStatus.overlooking = overlooking;
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    public int getOverlooking() {
        if (this.mMapController == null) {
            return 0;
        }
        return this.mMapController.getMapStatus().overlooking;
    }

    public void setWinRound(WinRound winRound) {
        if (this.mMapController != null) {
            MapStatus mapStatus = this.mMapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    public WinRound getWinRound() {
        if (this.mMapController == null) {
            return null;
        }
        return this.mMapController.getMapStatus().winRound;
    }

    public void setGeoRound(GeoBound geoRound) {
    }

    public GeoBound getGeoRound() {
        if (this.mMapController == null) {
            return null;
        }
        return this.mMapController.getMapStatus().geoRound;
    }

    public void setMapStatus(MapStatus mapStatus) {
        if (this.mMapController != null) {
            this.mMapController.setMapStatus(mapStatus);
        }
    }

    public MapStatus getMapStatus() {
        return this.mMapController != null ? this.mMapController.getMapStatus() : null;
    }

    public void saveScreenToLocal(String strPath) {
        if (this.mMapController != null) {
            this.mMapController.saveScreenToLocal(strPath);
        }
    }

    public float getZoomToBound(MapBound bound) {
        SysOSAPIv2 instance = SysOSAPIv2.getInstance();
        return getZoomToBound(bound, instance.getScreenWidth(), instance.getScreenHeight());
    }

    public float getZoomToBoundF(MapBound bound, int width, int height) {
        if (this.mMapController == null) {
            return 0.0f;
        }
        Bundle bd = new Bundle();
        bd.putInt("left", bound.leftBottomPt.getIntX());
        bd.putInt("bottom", bound.leftBottomPt.getIntY());
        bd.putInt("right", bound.rightTopPt.getIntX());
        bd.putInt("top", bound.rightTopPt.getIntY());
        return this.mMapController.getZoomToBoundF(bd);
    }

    public float GetFZoomToBoundF(MapBound bound, MapBound screenBound) {
        if (this.mMapController == null) {
            return 0.0f;
        }
        Bundle bd = new Bundle();
        bd.putInt("left", bound.leftBottomPt.getIntX());
        bd.putInt("bottom", bound.leftBottomPt.getIntY());
        bd.putInt("right", bound.rightTopPt.getIntX());
        bd.putInt("top", bound.rightTopPt.getIntY());
        Bundle screenBd = new Bundle();
        screenBd.putInt("left", screenBound.leftBottomPt.getIntX());
        screenBd.putInt("bottom", screenBound.leftBottomPt.getIntY());
        screenBd.putInt("right", screenBound.rightTopPt.getIntX());
        screenBd.putInt("top", screenBound.rightTopPt.getIntY());
        return this.mMapController.GetFZoomToBoundF(bd, screenBd);
    }

    public float getZoomToBoundF(MapBound bound) {
        SysOSAPIv2 instance = SysOSAPIv2.getInstance();
        return getZoomToBoundF(bound, instance.getScreenWidth(), instance.getScreenHeight());
    }

    public void setStreetRoad(boolean on) {
        if (this.mMapController != null) {
            this.mIsStreetRoadOn = on;
        }
        singleThreadPool.submit(new C47834());
    }

    public boolean isStreetRoad() {
        return this.mIsStreetRoadOn;
    }

    public float getZoomToBound(MapBound bound, int width, int height) {
        if (this.mMapController == null) {
            return 0.0f;
        }
        Bundle bd = new Bundle();
        bd.putInt("left", bound.leftBottomPt.getIntX());
        bd.putInt("bottom", bound.leftBottomPt.getIntY());
        bd.putInt("right", bound.rightTopPt.getIntX());
        bd.putInt("top", bound.rightTopPt.getIntY());
        return this.mMapController.getZoomToBound(bd, width, height);
    }

    public void onRecycle() {
        if (this.mMapController != null && this.mMapController.getBaseMap() != null) {
            this.mMapController.getBaseMap().ResetImageRes();
        }
    }

    public void refresh(Overlay overlay) {
        if (overlay != null && this.mMapController != null) {
            if ((overlay instanceof ItemizedOverlay) && ((ItemizedOverlay) overlay).getUpdateInfo()) {
                if (((ItemizedOverlay) overlay).getAllItem().size() <= 0) {
                    this.mMapController.getBaseMap().ClearLayer(overlay.mLayerID);
                    this.mMapController.getBaseMap().ShowLayers(overlay.mLayerID, false);
                    this.mMapController.getBaseMap().UpdateLayers(overlay.mLayerID);
                } else {
                    this.mMapController.getBaseMap().ShowLayers(overlay.mLayerID, true);
                    this.mMapController.getBaseMap().UpdateLayers(overlay.mLayerID);
                }
                ((ItemizedOverlay) overlay).setUpdateInfo(false);
            }
            if (this.mMapController != null && this.mMapController.getBaseMap() != null) {
                this.mMapController.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
        }
    }

    public void addStateListener(MapViewStateListener listener) {
        if (listener != null) {
            this.mMapViewStateListeners.add(listener);
        }
    }

    public void removeStateListener(MapViewStateListener listener) {
        if (listener != null) {
            this.mMapViewStateListeners.remove(listener);
        }
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.simpleGestureAdapter.getOnLongPressListener();
    }

    public void setOnLongPressListener(OnLongPressListener mOnLongPressListener) {
        this.simpleGestureAdapter.setOnLongPressListener(mOnLongPressListener);
    }

    public void onMapRenderModeChange(int arg) {
        if (arg == 1) {
            requestRender();
        } else if (arg == 0 && getRenderMode() != 0) {
            setRenderMode(0);
        }
    }

    public void onRequestRender() {
        requestRender();
    }

    public void onBackground() {
        if (this.mMapController != null && this.mMapController.getBaseMap() != null) {
            this.mMapController.getBaseMap().OnBackground();
        }
    }

    public void onForeground() {
        if (this.mMapController != null && this.mMapController.getBaseMap() != null) {
            this.mMapController.getBaseMap().OnForeground();
        }
    }
}
