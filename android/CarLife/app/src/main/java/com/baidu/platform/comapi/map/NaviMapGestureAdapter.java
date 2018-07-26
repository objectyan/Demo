package com.baidu.platform.comapi.map;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class NaviMapGestureAdapter extends SimpleOnGestureListener {
    private MapController mMapController;

    public void setMapController(MapController mapController) {
        this.mMapController = mapController;
    }

    public void onLongPress(MotionEvent e) {
        if (!(!this.mMapController.isNaviMode() || this.mMapController.naviMapViewListener == null || this.mMapController.isEnableDMoveZoom())) {
            this.mMapController.naviMapViewListener.onAction(517, e);
        }
        super.onLongPress(e);
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (this.mMapController.isNaviMode() && this.mMapController.naviMapViewListener != null) {
            this.mMapController.naviMapViewListener.onAction(518, null);
        }
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (this.mMapController.isNaviMode() && this.mMapController.naviMapViewListener != null) {
            this.mMapController.naviMapViewListener.onAction(516, null);
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public boolean onDown(MotionEvent e) {
        if (!this.mMapController.isNaviMode() || this.mMapController.naviMapViewListener == null) {
            return super.onDown(e);
        }
        this.mMapController.naviMapViewListener.onAction(515, e);
        return false;
    }

    public boolean onDoubleTap(MotionEvent e) {
        if (!this.mMapController.isNaviMode() || this.mMapController.naviMapViewListener == null) {
            return super.onDoubleTap(e);
        }
        this.mMapController.naviMapViewListener.onAction(520, e);
        return false;
    }
}
