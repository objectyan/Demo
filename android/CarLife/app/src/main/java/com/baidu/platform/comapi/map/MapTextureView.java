package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapRenderer.ResourceRecycler;
import com.baidu.platform.comapi.map.MapStatus.GeoBound;
import com.baidu.platform.comapi.map.MapStatus.WinRound;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;

public class MapTextureView extends GLTextureView implements OnDoubleTapListener, OnGestureListener, MapRenderModeChangeListener, ResourceRecycler, MapViewInterface {
    private List<Overlay> innerOverlayList = new ArrayList();
    int mHeight;
    MapController mMapController = null;
    InternalProjection mProjection = null;
    int mWidth;
    MapRenderer mapRenderer = null;
    OverlayMapCallBack overlayMapCallBack = null;
    private RenderMessageListener renderMessageListener;

    public interface RenderMessageListener {
        void onMessage(int i);
    }

    public MapTextureView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
    }

    public MapTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setEGLContextClientVersion(2);
    }

    public MapTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setEGLContextClientVersion(2);
    }

    public void listenMapRenderMessage(RenderMessageListener listener) {
        this.renderMessageListener = listener;
    }

    public void unListenMapRenderMessage() {
        this.renderMessageListener = null;
    }

    public void attachBaseMapController(MapController mapController) {
        this.mapRenderer = new MapRenderer((GLTextureView) this, (ResourceRecycler) this);
        this.mMapController = mapController;
        this.mapRenderer.setBaseMapId(mapController.getMapId());
        setRenderer(this.mapRenderer);
        setRenderMode(0);
        this.mapRenderer.setMapResInitOk(true);
        this.overlayMapCallBack = new OverlayMapCallBack(this.mMapController.getBaseMap());
        this.mMapController.setOverlayMapCallBack(this.overlayMapCallBack);
        this.mMapController.setMapViewInterface(this);
        initInnerOverlays();
        this.mMapController.setMapRenderModeChangeListener(this);
        this.mProjection = new InternalProjection(this.mMapController);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        super.onSurfaceTextureAvailable(surface, width, height);
        this.mWidth = width;
        this.mHeight = height;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        super.onSurfaceTextureSizeChanged(surface, width, height);
        this.mWidth = width;
        this.mHeight = height;
        this.mapRenderer.w_old = width;
        this.mapRenderer.h_old = height;
        this.mapRenderer.resize_tries = 0;
        if (this.mMapController != null) {
            MapStatus st = getMapStatus();
            st.winRound.left = 0;
            st.winRound.top = 0;
            st.winRound.bottom = height;
            st.winRound.right = width;
            setMapStatus(st);
            this.mMapController.setScreenSize(this.mWidth, this.mHeight);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        super.onSurfaceTextureDestroyed(surface);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        super.onSurfaceTextureUpdated(surface);
    }

    public void onMapRenderModeChange(int arg) {
        if (this.renderMessageListener != null) {
            this.renderMessageListener.onMessage(arg);
        }
        if (arg == 1) {
            requestRender();
        } else if (arg == 0 && getRenderMode() != 0) {
            setRenderMode(0);
        }
    }

    public void onRequestRender() {
    }

    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    public boolean onDown(MotionEvent e) {
        return false;
    }

    public void onShowPress(MotionEvent e) {
    }

    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    public void onLongPress(MotionEvent e) {
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public MapController getController() {
        return this.mMapController;
    }

    public void animateTo(MapStatus st, int animTime) {
        if (this.mMapController != null) {
            this.mMapController.setMapStatusWithAnimation(st, animTime);
        }
    }

    public int getLatitudeSpan() {
        InternalProjection p = (InternalProjection) getProjection();
        return (int) Math.abs(p.fromPixels(0, 0).getLatitude() - p.fromPixels(this.mWidth - 1, this.mHeight - 1).getLatitude());
    }

    public int getLongitudeSpan() {
        InternalProjection p = (InternalProjection) getProjection();
        return (int) Math.abs(p.fromPixels(this.mWidth - 1, this.mHeight - 1).getLongitude() - p.fromPixels(0, 0).getLongitude());
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
                iLevel = 21.0f;
            }
            MapStatus st = getMapStatus();
            if (st != null) {
                st.level = iLevel;
                animateTo(st, 300);
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

    public List<Overlay> getOverlays() {
        return this.innerOverlayList;
    }

    public Overlay getPopupOverlay() {
        return null;
    }

    public synchronized Overlay getOverlay(int layerType) {
        Overlay layer;
        for (Overlay layer2 : this.innerOverlayList) {
            if (layer2.mType == layerType) {
                break;
            }
        }
        layer2 = null;
        return layer2;
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
        return false;
    }

    public boolean isSatellite() {
        return false;
    }

    public boolean isTraffic() {
        return false;
    }

    public boolean isStreetRoad() {
        return false;
    }

    public void setSatellite(boolean on) {
    }

    public void setStreetRoad(boolean on) {
    }

    public void setTraffic(boolean on) {
        if (this.mMapController != null) {
            AppBaseMap baseMap = this.mMapController.getBaseMap();
            if (baseMap != null) {
                baseMap.ShowTrafficMap(on);
            }
        }
    }

    public void setMapTo2D(boolean on) {
    }

    private void initInnerOverlays() {
        if (this.mMapController != null) {
            AppBaseMap baseMap = this.mMapController.getBaseMap();
            if (baseMap != null) {
                clearInnerOverlays();
                addOverlay(new BusLineOverlay(baseMap));
                addOverlay(new RouteOverlay(baseMap));
                addOverlay(new ITSRouteOverlay(baseMap));
                addOverlay(new ITSRouteOverlay(baseMap));
                addOverlay(new ITSRouteOverlay(baseMap));
                addOverlay(new PoiOverlay(baseMap));
                addOverlay(new PoiDynamicMapOverlay(baseMap));
            }
        }
    }

    private void clearInnerOverlays() {
        if (this.mMapController != null && this.mMapController.getBaseMap() != null && this.overlayMapCallBack != null) {
            this.innerOverlayList.clear();
            this.overlayMapCallBack.clear();
        }
    }

    public boolean addOverlay(Overlay overlay) {
        if (overlay == null || this.mMapController == null) {
            return false;
        }
        AppBaseMap baseMap = this.mMapController.getBaseMap();
        if (baseMap == null) {
            return false;
        }
        if (overlay instanceof StreetPopupOverlay) {
            return ((InnerOverlay) overlay).addedToMapView();
        }
        if (overlay instanceof InnerOverlay) {
            if (((InnerOverlay) overlay).mBaseMap == null) {
                ((InnerOverlay) overlay).mBaseMap = getController().getBaseMap();
            }
            if (!((InnerOverlay) overlay).addedToMapView()) {
                return false;
            }
            this.innerOverlayList.add(overlay);
            this.overlayMapCallBack.addOverlay((InnerOverlay) overlay);
            return true;
        } else if (overlay instanceof ItemizedOverlay) {
            overlay.mLayerID = baseMap.AddLayer(((ItemizedOverlay) overlay).getUpdateType(), 0, "item");
            if (overlay.mLayerID == 0) {
                return false;
            }
            this.innerOverlayList.add(overlay);
            ((ItemizedOverlay) overlay).reAddAll();
            baseMap.SetLayersClickable(overlay.mLayerID, true);
            baseMap.ShowLayers(overlay.mLayerID, true);
            baseMap.UpdateLayers(overlay.mLayerID);
            return true;
        } else {
            if (overlay instanceof RtPopupOverlay) {
                ((RtPopupOverlay) overlay).initLayer();
                if (overlay.mLayerID == 0) {
                    return false;
                }
                this.innerOverlayList.add(overlay);
                ((RtPopupOverlay) overlay).reAddAll();
                baseMap.SetLayersClickable(overlay.mLayerID, false);
                baseMap.ShowLayers(overlay.mLayerID, true);
            }
            return false;
        }
    }

    public boolean removeOverlay(Overlay overlay) {
        if (overlay == null || this.mMapController == null) {
            return false;
        }
        AppBaseMap baseMap = this.mMapController.getBaseMap();
        if (baseMap == null) {
            return false;
        }
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
        return true;
    }

    public void saveScreenToLocal(String strPath) {
    }

    public float getZoomToBound(MapBound bound) {
        return getZoomToBound(bound, this.mWidth, this.mHeight);
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

    public float getZoomToBoundF(MapBound bound) {
        return getZoomToBoundF(bound, this.mWidth, this.mHeight);
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

    public void onResume() {
        if (this.mMapController != null) {
            this.mMapController.getBaseMap().OnResume();
        }
        super.onResume();
    }

    public void onPause() {
        if (this.mMapController != null) {
            this.mMapController.getBaseMap().OnPause();
        }
        super.onPause();
    }

    public void onDestroy() {
        this.mMapController.unInit();
        this.mMapController = null;
        this.overlayMapCallBack.clear();
        this.overlayMapCallBack = null;
        this.mProjection = null;
    }

    public void onRecycle() {
        if (this.mMapController != null && this.mMapController.getBaseMap() != null) {
            this.mMapController.getBaseMap().ResetImageRes();
        }
    }
}
