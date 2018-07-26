package com.baidu.mapframework.common.mapview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.mapframework.common.beans.map.MapAnimationFinishEvent;
import com.baidu.mapframework.common.beans.map.NetworkStatusEvent;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay.OnTapListener;
import com.baidu.mapframework.util.acd.Stateful;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.EngineMsgListener;
import com.baidu.platform.comapi.map.IndoorMapInfo;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.ItsMapObj;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.OnLongPressListener;
import com.baidu.platform.comapi.map.Overlay;
import com.baidu.platform.comapi.util.BMEventBus;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapViewListener implements OnTapListener, Stateful, EngineMsgListener, MapViewListener, OnLongPressListener {
    protected boolean isCreated;
    protected boolean isDestroyed;
    protected Context mContext;
    protected MapController mMapController;
    protected MapGLSurfaceView mMapView;

    protected abstract void onCompassClick(MapObj mapObj);

    protected abstract void onFavouritePoiClick(MapObj mapObj);

    protected abstract void onLocationPointClick(MapObj mapObj);

    protected abstract void onPoiMarkerClick(MapObj mapObj);

    protected BaseMapViewListener() {
        this.mContext = C2907c.f();
    }

    protected BaseMapViewListener(Context context) {
        this();
        this.mContext = context;
    }

    public final void onClickedMapObj(List<MapObj> mapObjs) {
        if (mapObjs != null && mapObjs.size() != 0) {
            MapObj obj = (MapObj) mapObjs.get(0);
            Log.d("BaseMapViewListener", "onClickedMapObj " + mapObjs.toString());
            if (obj.nType != 17 || !TextUtils.isEmpty(obj.strText)) {
                switch (obj.nType) {
                    case 6:
                        onFavouritePoiClick(obj);
                        return;
                    case 18:
                        onLocationPointClick(obj);
                        return;
                    case 19:
                        onCompassClick(obj);
                        return;
                    default:
                        onPoiMarkerClick(obj);
                        return;
                }
            }
        }
    }

    public void onClickedPoiObj(List<MapObj> list) {
    }

    public void onClickedRouteObj(List<MapObj> list) {
    }

    public void onClickedItsMapObj(List<ItsMapObj> list) {
    }

    public void onMapAnimationFinish() {
        BMEventBus.getInstance().post(new MapAnimationFinishEvent());
    }

    public void onClickedItem(int index, GeoPoint geoPoint, int layerID) {
        if (this.mMapView == null) {
            this.mMapView = MapViewFactory.getInstance().getMapView();
        }
        List<Overlay> overlays = new ArrayList(this.mMapView.getOverlays());
        if (overlays != null && !overlays.isEmpty()) {
            for (Overlay overlay : overlays) {
                if (overlay.mType == 27 && geoPoint != null && (overlay instanceof ItemizedOverlay) && !((ItemizedOverlay) overlay).onTap(geoPoint, this.mMapView) && index != -1 && layerID == overlay.mLayerID) {
                    ((ItemizedOverlay) overlay).onTap(index);
                }
            }
        }
    }

    public void onClickedItem(int index, int clickIndex, GeoPoint geoPoint, int layerID) {
        if (this.mMapView == null) {
            this.mMapView = MapViewFactory.getInstance().getMapView();
        }
        List<Overlay> overlays = new ArrayList(this.mMapView.getOverlays());
        if (overlays != null && !overlays.isEmpty()) {
            for (Overlay overlay : overlays) {
                if (!(overlay.mType != 27 || geoPoint == null || !(overlay instanceof ItemizedOverlay) || ((ItemizedOverlay) overlay).onTap(geoPoint, this.mMapView) || index == -1 || clickIndex == -1 || layerID != overlay.mLayerID)) {
                    ((ItemizedOverlay) overlay).onTap(index, clickIndex, geoPoint);
                }
            }
        }
    }

    public void onClickedPopup(int i) {
    }

    public void onClickedStreetPopup(String s) {
    }

    public void onClickedBackground(int i, int i2) {
    }

    public void onClickedStreetIndoorPoi(MapObj mapObj) {
    }

    public void onClickStreetArrow(MapObj mapObj) {
    }

    public void onClickStreetSurface(MapObj mapObj) {
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onTap(int index) {
        return false;
    }

    public boolean onTap(GeoPoint p, MapGLSurfaceView mapView) {
        return false;
    }

    public boolean onTap(int index, int clickIndex, GeoPoint geoPoint) {
        return false;
    }

    public void onStateCreate() {
        if (!this.isCreated) {
            this.isCreated = true;
            this.isDestroyed = false;
            this.mMapView = MapViewFactory.getInstance().getMapView();
            if (this.mMapController == null && this.mMapView != null) {
                this.mMapController = this.mMapView.getController();
            }
            if (this.mMapController != null) {
                this.mMapController.setMapViewListener(this);
                this.mMapController.setEngineMsgListener(this);
                this.mMapController.setDoubleClickZoom(true);
                this.mMapController.setMapClickEnable(true);
                this.mMapView.setOnLongPressListener(this);
            }
        }
    }

    public void onStateDestroy() {
        if (this.isCreated && !this.isDestroyed) {
            this.isCreated = false;
            this.isDestroyed = true;
            if (this.mMapController != null && this.mMapController.getMapViewListener() == this) {
                this.mMapController.setMapViewListener(null);
            }
            if (this.mMapView.getOnLongPressListener() == this) {
                this.mMapView.setOnLongPressListener(null);
            }
        }
    }

    public void onClickedRouteLabelObj(List<MapObj> list) {
    }

    public void onEnterIndoorMapMode(IndoorMapInfo indoorMapInfo) {
    }

    public void onExitIndoorMapMode() {
    }

    public void onClickedOPPoiEventMapObj(MapObj mapObj) {
    }

    public void onLongLinkConnect() {
        BMEventBus.getInstance().post(new NetworkStatusEvent());
    }

    public void onLongLinkDisConnect() {
        BMEventBus.getInstance().post(new NetworkStatusEvent());
    }

    public void onClickedParticleEventMapObj(List<MapObj> list) {
    }

    public void onClickedTrafficUgcEventMapObj(MapObj mapObj, boolean bchecked) {
    }
}
