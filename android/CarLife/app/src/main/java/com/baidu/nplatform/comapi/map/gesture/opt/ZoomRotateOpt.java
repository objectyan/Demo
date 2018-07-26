package com.baidu.nplatform.comapi.map.gesture.opt;

import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapController.MapControlMode;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Point;
import com.baidu.nplatform.comapi.map.gesture.Base.Translation;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;

public class ZoomRotateOpt extends Opt {
    private static final int MIN_ROTATE = 10;
    private static final int ROTATE_ANGLE = 60;
    public static boolean isRotateOpt = false;
    private MoveDetector detector;
    private int endRotate;
    private float endScale;
    private GeoPoint initialCenter;
    private float initialLScale;
    private int initialRotate;
    private Translation initialTranslation;
    private double lastScale = 0.0d;
    private Translation lastTranslation;
    private boolean rotateMode = false;

    public ZoomRotateOpt(MapController controller) {
        super(controller);
    }

    public void init(MoveDetector detector) {
        if (this.controller.getMapView() != null) {
            MapStatus mapStatus = this.controller.getMapStatus();
            if (mapStatus != null) {
                Point startCenterPoint = detector.initialPosition.center();
                this.initialCenter = this.controller.scrPtToGeoPoint((int) startCenterPoint.f19733x, (int) startCenterPoint.f19734y);
                this.initialLScale = this.controller.getLevel();
                this.initialRotate = mapStatus._Rotation;
                this.endScale = this.initialLScale;
                this.endRotate = this.initialRotate;
                this.lastScale = 0.0d;
            }
        }
    }

    public void perform(MoveDetector detector) {
        this.detector = detector;
        this.initialTranslation = new Translation(detector.initialPosition, detector.currentPosition);
        this.lastTranslation = new Translation(detector.lastPosition, detector.currentPosition);
        MapStatus mapStatus = this.controller.getMapStatus();
        if (mapStatus != null) {
            updateScale(mapStatus);
            if (this.controller.get3DGestureEnable() && this.controller.getMapControlMode() != MapControlMode.STREET) {
                updateMapCenter(mapStatus);
                updateRotate(mapStatus);
            }
            LogUtil.m15791e("dingbbinpage", "zoomrotateopt perform level is " + mapStatus._Level);
            LogUtil.m15791e("mytestmapStatus", mapStatus._Level + "");
            this.controller.setMapStatus(mapStatus, AnimationType.eAnimationNone);
            isRotateOpt = true;
            this.controller.onDoubleFingerZoom();
            isRotateOpt = false;
        }
    }

    private void updateScale(MapStatus mapStatus) {
        double d = Math.log(2.0d);
        if (d > 1.0E-7d || d < -1.0E-7d) {
            mapStatus._Level = this.initialLScale + ((float) (Math.log(this.initialTranslation.scale) / d));
            this.endScale = mapStatus._Level;
        }
    }

    private void updateMapCenter(MapStatus mapStatus) {
        if (mapStatus != null && this.initialCenter != null) {
            if (Math.abs(this.lastTranslation.move.f19735x) > 0.0d || Math.abs(this.lastTranslation.move.f19736y) > 0.0d) {
                mapStatus._CenterPtX = this.initialCenter.getLongitudeE6();
                mapStatus._CenterPtY = this.initialCenter.getLatitudeE6();
                Point currentCenter = this.detector.currentPosition.center();
                int viewHeight = this.controller.getMapStatus()._WinRound.bottom - this.controller.getMapStatus()._WinRound.top;
                mapStatus._Xoffset = (long) (currentCenter.f19733x - ((double) ((this.controller.getMapStatus()._WinRound.right - this.controller.getMapStatus()._WinRound.left) / 2)));
                mapStatus._Yoffset = -1 * ((long) (currentCenter.f19734y - ((double) (viewHeight / 2))));
            }
        }
    }

    private void updateRotate(MapStatus mapStatus) {
        if (mapStatus != null) {
            double ar = Math.abs(new Translation(new Line(this.detector.lastPosition.f19731a, this.detector.currentPosition.f19731a), this.detector.lastPosition).rotate);
            double br = Math.abs(new Translation(new Line(this.detector.lastPosition.f19732b, this.detector.currentPosition.f19732b), this.detector.lastPosition).rotate);
            boolean reverse = this.lastScale != 0.0d && this.lastScale * this.lastTranslation.scale < 0.0d;
            if (!reverse) {
                if (this.rotateMode) {
                    mapStatus._Rotation = (int) ((((double) this.initialRotate) + this.initialTranslation.rotate) % 360.0d);
                    this.endRotate = mapStatus._Rotation;
                    UserOPController.getInstance().addMapOP(2, 521);
                } else {
                    boolean aMoved = (this.lastTranslation.scale < 1.0d && ar > 60.0d) || (this.lastTranslation.scale > 1.0d && Math.abs(ar - 180.0d) > 60.0d);
                    boolean bMoved = (this.lastTranslation.scale > 1.0d && br > 60.0d) || (this.lastTranslation.scale < 1.0d && Math.abs(br - 180.0d) > 60.0d);
                    if ((aMoved || bMoved) && Math.abs(this.initialTranslation.rotate) > 10.0d) {
                        this.rotateMode = true;
                        this.initialRotate = (int) (((double) this.initialRotate) - this.initialTranslation.rotate);
                    }
                }
                this.lastScale = this.lastTranslation.scale;
            }
        }
    }

    public void finish(MoveDetector detector) {
        this.rotateMode = false;
        if (this.controller.getMapView() != null && this.controller.getMapStatus() != null) {
            double tCenterX = 0.0d;
            double tCenterY = 0.0d;
            int x = (int) detector.event.getX();
            int y = (int) detector.event.getY();
            if (x < 0) {
                x = 0;
            }
            if (y < 0) {
                y = 0;
            }
            GeoPoint point = this.controller.scrPtToGeoPoint((this.controller.getMapStatus()._WinRound.right - this.controller.getMapStatus()._WinRound.left) / 2, (this.controller.getMapStatus()._WinRound.bottom - this.controller.getMapStatus()._WinRound.top) / 2);
            if (point != null) {
                tCenterX = (double) point.getLongitudeE6();
                tCenterY = (double) point.getLatitudeE6();
            }
            this.controller.MapMsgProc(5, 1, (y << 16) | x, 0, 0, tCenterX, tCenterY, 0.0d, 0.0d);
            if (this.endRotate != this.initialRotate) {
                BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_TWOROTATE);
            }
            if (((double) (this.endScale - this.initialLScale)) > 0.5d) {
                BNStatisticsManager.getInstance().onMapScaleSet((int) this.endScale);
                BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_ZOOMIN);
            } else if (((double) (this.initialLScale - this.endScale)) > 0.5d) {
                BNStatisticsManager.getInstance().onMapScaleSet((int) this.endScale);
                BNStatisticsManager.getInstance().onGestureEvent("gs");
            }
        }
    }
}
