package com.baidu.nplatform.comapi.map;

import android.view.MotionEvent;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Point;
import com.baidu.nplatform.comapi.map.gesture.Base.Translation;
import com.baidu.nplatform.comapi.map.gesture.Tracker;

public class DoubleTapController {
    private MapController controller;
    private int count = 0;
    private Line currentPosition;
    private boolean enableMove = false;
    private float endScale;
    private long endTime;
    private int inicount = 3;
    private float initPositionY;
    private float initialLScale;
    private Point initialPoint;
    private Line initialPosition;
    private Translation initialTranslation;
    public boolean isOnlyDoubleTap = true;
    private Line lastPosition;
    private Translation lastTranslation;
    private boolean running = false;
    private float scaleProportion;
    private long startTime;
    private Tracker tracker = new Tracker();

    public DoubleTapController(MapController controller) {
        this.controller = controller;
    }

    private void initial(MotionEvent event) {
        if (this.controller.getMapView() != null && this.controller.getMapStatus() != null) {
            this.initialLScale = this.controller.getLevel();
            this.endScale = this.initialLScale;
            this.initPositionY = event.getY();
            double d = Math.log(2.0d);
            int height = ScreenUtil.getInstance().getHeightPixels();
            if ((d > 1.0E-7d || d < -1.0E-7d) && height != 0) {
                this.scaleProportion = (float) (((double) (20.0f / ((float) height))) / d);
            }
            this.startTime = System.currentTimeMillis();
        }
    }

    public boolean onDoubleTapEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                if (!this.running) {
                    this.running = true;
                    initial(event);
                    onMoveBegin(event);
                    break;
                }
                break;
            case 1:
                this.endTime = System.currentTimeMillis();
                this.controller.handleTouchUp(event);
                this.controller.onDoubleFingerZoom();
                if (this.running) {
                    onMoveEnd(event);
                    this.running = false;
                }
                if (this.endTime - this.startTime < 100) {
                    BNMapController.getInstance().handleDoubleTouch(event);
                    break;
                }
                break;
            case 2:
                if (this.running) {
                    onMove(event);
                    break;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private void onMoveEnd(MotionEvent event) {
        this.tracker.finish();
    }

    private void onMove(MotionEvent event) {
        handleMoving(event);
    }

    private void onMoveBegin(MotionEvent event) {
        this.initialPosition = null;
        this.lastPosition = null;
        this.currentPosition = null;
    }

    private void handleMoving(MotionEvent event) {
        perform(event);
    }

    public void perform(MotionEvent event) {
        MapStatus mapStatus = this.controller.getMapStatus();
        if (mapStatus != null) {
            float distance_level = this.scaleProportion * (this.initPositionY - event.getY());
            this.initialLScale = mapStatus._Level;
            float end_level = Math.min(Math.max(this.initialLScale + distance_level, 3.0f), 20.0f);
            mapStatus._Level = end_level;
            this.initialLScale = end_level;
            this.initPositionY = event.getY();
            this.controller.setMapStatus(mapStatus, AnimationType.eAnimationNone);
        }
    }

    private void updateScale(MapStatus mapStatus) {
        double d = Math.log(2.0d);
        if (d > 1.0E-7d || d < -1.0E-7d) {
            mapStatus._Level = this.initialLScale + ((float) (Math.log(this.initialTranslation.scale) / d));
            this.endScale = mapStatus._Level;
            LogUtil.m15791e("mytestlevel", this.endScale + "");
        }
    }
}
