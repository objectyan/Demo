package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.baidu.navisdk.util.common.EglConfigUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.MapStatus.GeoBound;
import com.baidu.nplatform.comapi.basestruct.MapStatus.WinRound;
import java.lang.ref.WeakReference;

public class MapGLSurfaceView extends GLSurfaceView implements MapViewInterface {
    private static final String TAG = "Map";
    private MapController mMapController = null;
    MapViewListener mMapViewListener = null;
    public MapRenderer mRenderer;

    public MapGLSurfaceView(Context context) {
        super(context);
        LogUtil.m15791e("Map", "MapGLSurfaceView constructor");
        try {
            if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 16, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            } else if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 8, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 8, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 0, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 0, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 24, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 24, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 16, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 16, 0);
            } else if (EglConfigUtils.isSupportConfig(5, 6, 5, 0, 8, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 8, 0);
            } else {
                setEGLConfigChooser(8, 8, 8, 0, 0, 0);
            }
        } catch (IllegalArgumentException e) {
            LogUtil.m15791e("mapglsurfaceview", "no such eglconfigure");
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void Init(Context context, Bundle b) {
        LogUtil.m15791e("Map", "MapGLSurfaceView Init");
        if (this.mMapController == null) {
            this.mMapController = new MapController(context, this);
            this.mMapController.initBaseMap(b);
            InitOverlays();
        }
        if (this.mMapController != null) {
            this.mRenderer = new MapRenderer(new WeakReference(this));
            setRenderer(this.mRenderer);
            setRenderMode(0);
        }
        setLongClickable(true);
    }

    private void InitOverlays() {
    }

    public void unInit() {
        this.mMapController.unInit();
        this.mMapController = null;
        this.mRenderer = null;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        LogUtil.m15791e("Map", "surfaceCreated ");
        super.surfaceCreated(holder);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        LogUtil.m15791e("Map", "surfaceChanged w:" + w + " h:" + h);
        MapRenderer.w_old = w;
        MapRenderer.h_old = h;
        MapRenderer.resize_tries = 0;
        this.mMapController.resizeSecreen(w, h);
        super.surfaceChanged(holder, format, w, h);
    }

    public void onResume() {
        LogUtil.m15791e("Map", "surface onResume");
        if (this.mMapController != null) {
            this.mMapController.onResume();
        }
        setRenderMode(1);
        try {
            super.onResume();
        } catch (Exception e) {
        }
    }

    public void onPause() {
        LogUtil.m15791e("Map", "surface onPause");
        if (this.mMapController != null) {
            this.mMapController.onPause();
        }
        super.onPause();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
        LogUtil.m15791e("Map", "surfaceDestroyed");
    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (this.mMapController != null) {
            return this.mMapController.handleTouchEvent(event);
        }
        return false;
    }

    public MapController getController() {
        if (this.mMapController == null) {
            this.mMapController = new MapController(getContext(), this);
        }
        return this.mMapController;
    }

    public int getLatitudeSpan() {
        return 0;
    }

    public int getLongitudeSpan() {
        return 0;
    }

    public void setMapCenter(GeoPoint geoPoint) {
    }

    public GeoPoint getMapCenter() {
        return null;
    }

    public void setZoomLevel(int zoomLevel) {
    }

    public float getZoomLevel() {
        return 0.0f;
    }

    public void setRotation(int rotation) {
    }

    public int getMapRotation() {
        return 0;
    }

    public void setOverlooking(int overlooking) {
    }

    public int getOverlooking() {
        return 0;
    }

    public void setWinRound(WinRound winRound) {
    }

    public WinRound getWinRound() {
        return null;
    }

    public void setGeoRound(GeoBound geoRound) {
    }

    public GeoBound getGeoRound() {
        return null;
    }

    public void setMapStatus(MapStatus mapStatus) {
    }

    public MapStatus getMapStatus() {
        return null;
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
    }

    public void setMapTo2D(boolean on) {
    }

    public void saveScreenToLocal(String strPath) {
    }

    public void setMapViewListener(MapViewListener mapListener) {
        this.mMapViewListener = mapListener;
    }

    public MapViewListener getMapViewListener() {
        return this.mMapViewListener;
    }
}
