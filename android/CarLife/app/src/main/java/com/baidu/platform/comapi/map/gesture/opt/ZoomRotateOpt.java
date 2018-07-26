package com.baidu.platform.comapi.map.gesture.opt;

import android.util.Pair;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapController.MapControlMode;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.event.CancelCompassEvent;
import com.baidu.platform.comapi.map.event.MapZoomEvent;
import com.baidu.platform.comapi.map.gesture.Base.Line;
import com.baidu.platform.comapi.map.gesture.Base.Point;
import com.baidu.platform.comapi.map.gesture.Base.Translation;
import com.baidu.platform.comapi.map.gesture.Base.Vector;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.util.LinkedList;
import java.util.Queue;

public class ZoomRotateOpt extends Opt {
    private static final int MAX_ZOOM_LEVEL = 2;
    private static final int MIN_ROTATE = 10;
    private static final int ROTATE_ANGLE = 60;
    private MoveDetector detector;
    private GeoPoint initialCenter;
    private float initialLScale;
    private int initialRotate;
    private Translation initialTranslation;
    private boolean isCompassDone = false;
    private boolean isScale = false;
    private double lastScale = 0.0d;
    private Translation lastTranslation;
    private Queue<Translation> mLastTrans = new LinkedList();
    private boolean rotateMode = false;

    public ZoomRotateOpt(MapController controller) {
        super(controller);
    }

    public void init(MoveDetector detector) {
        MapViewInterface mapView = this.controller.getMapView();
        if (mapView != null) {
            MapStatus mapStatus = this.controller.getMapStatus();
            Point startCenterPoint = detector.initialPosition.center();
            this.initialCenter = mapView.getProjection().fromPixels((int) startCenterPoint.f19858x, (int) startCenterPoint.f19859y);
            this.initialLScale = this.controller.getZoomLevel();
            this.initialRotate = mapStatus.rotation;
            this.lastScale = 0.0d;
        }
    }

    public void perform(MoveDetector detector) {
        this.detector = detector;
        this.initialTranslation = new Translation(detector.initialPosition, detector.currentPosition);
        this.lastTranslation = new Translation(detector.lastPosition, detector.currentPosition);
        MapStatus mapStatus = this.controller.getMapStatus();
        updateScale(mapStatus);
        if (this.controller.is3DGestureEnable() && this.controller.getMapControlMode() != MapControlMode.STREET) {
            updateMapCenter(mapStatus);
            updateRotate(mapStatus);
        }
        this.controller.setMapStatus(mapStatus);
        if (this.controller.isNaviMode() && this.controller.getNaviMapViewListener() != null) {
            this.controller.getNaviMapViewListener().onAction(520, null);
        }
        if (this.mLastTrans.size() >= 10) {
            this.mLastTrans.poll();
        }
        this.mLastTrans.offer(this.lastTranslation);
        BMEventBus.getInstance().post(new MapZoomEvent());
    }

    private void updateScale(MapStatus mapStatus) {
        float f = 4.0f;
        mapStatus.level = this.initialLScale + ((float) (Math.log(this.initialTranslation.scale) / Math.log(2.0d)));
        if (mapStatus.level >= 4.0f) {
            f = mapStatus.level;
        }
        mapStatus.level = f;
    }

    private void updateMapCenter(MapStatus mapStatus) {
        if (this.initialCenter == null) {
            return;
        }
        if (Math.abs(this.lastTranslation.move.f19860x) > 0.0d || Math.abs(this.lastTranslation.move.f19861y) > 0.0d) {
            Point last = this.detector.initialPosition.center();
            Point current = this.detector.currentPosition.center();
            double distance = Math.sqrt(((current.f19858x - last.f19858x) * (current.f19858x - last.f19858x)) + ((current.f19859y - last.f19859y) * (current.f19859y - last.f19859y)));
            if (MapController.isCompass && distance < 100.0d) {
                return;
            }
            if (MapController.isCompass || this.isCompassDone) {
                this.isCompassDone = false;
                BMEventBus.getInstance().post(new CancelCompassEvent());
                MapViewInterface mapView = this.controller.getMapView();
                if (mapView != null) {
                    Point startCenterPoint = this.detector.currentPosition.center();
                    this.initialCenter = mapView.getProjection().fromPixels((int) startCenterPoint.f19858x, (int) startCenterPoint.f19859y);
                    return;
                }
                return;
            }
            mapStatus.centerPtX = this.initialCenter.getLongitude();
            mapStatus.centerPtY = this.initialCenter.getLatitude();
            Point currentCenter = this.detector.currentPosition.center();
            mapStatus.xOffset = (float) (currentCenter.f19858x - ((double) (this.controller.getScreenWidth() / 2)));
            mapStatus.yOffset = -1.0f * ((float) (currentCenter.f19859y - ((double) (this.controller.getScreenHeight() / 2))));
        }
    }

    private void updateRotate(MapStatus mapStatus) {
        double ar = Math.abs(new Translation(new Line(this.detector.lastPosition.f19856a, this.detector.currentPosition.f19856a), this.detector.lastPosition).rotate);
        double br = Math.abs(new Translation(new Line(this.detector.lastPosition.f19857b, this.detector.currentPosition.f19857b), this.detector.lastPosition).rotate);
        boolean reverse = this.lastScale != 0.0d && this.lastScale * this.lastTranslation.scale < 0.0d;
        if (!reverse) {
            if (this.rotateMode) {
                mapStatus.rotation = (int) ((((double) this.initialRotate) + this.initialTranslation.rotate) % 360.0d);
            } else {
                boolean aMoved = (this.lastTranslation.scale < 1.0d && ar > 60.0d) || (this.lastTranslation.scale > 1.0d && Math.abs(ar - 180.0d) > 60.0d);
                boolean bMoved = (this.lastTranslation.scale > 1.0d && br > 60.0d) || (this.lastTranslation.scale < 1.0d && Math.abs(br - 180.0d) > 60.0d);
                if (aMoved || bMoved) {
                    if (Math.abs(this.initialTranslation.rotate) > ((double) (MapController.isCompass ? 30 : 10))) {
                        this.rotateMode = true;
                        this.controller.getGestureMonitor().handleRotate();
                        this.initialRotate = (int) (((double) this.initialRotate) - this.initialTranslation.rotate);
                        if (MapController.isCompass) {
                            this.isCompassDone = true;
                            BMEventBus.getInstance().post(new CancelCompassEvent());
                        }
                    }
                }
            }
            this.lastScale = this.lastTranslation.scale;
        }
    }

    public void finish(MoveDetector detector, Pair<Vector, Vector> vector) {
        this.rotateMode = false;
        MapViewInterface mapView = this.controller.getMapView();
        if (mapView != null) {
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
            GeoPoint point = mapView.getProjection().fromPixels(this.controller.getScreenWidth() / 2, this.controller.getScreenHeight() / 2);
            if (point != null) {
                tCenterX = point.getLongitude();
                tCenterY = point.getLatitude();
            }
            this.controller.MapMsgProc(5, 1, (y << 16) | x, 0, 0, tCenterX, tCenterY, 0.0d, 0.0d);
            this.controller.getGestureMonitor().handleZoomChange(this.controller.getZoomLevel());
            ZoomAnimation(this.controller.getMapStatus(), detector, vector);
        }
    }

    public void ZoomAnimation(MapStatus mapStatus, MoveDetector detector, Pair<Vector, Vector> vector) {
        if (vector != null) {
            if (((Vector) vector.second).f19860x * ((Vector) vector.first).f19860x > 0.0d) {
                if (((Vector) vector.second).f19861y * ((Vector) vector.first).f19861y > 0.0d) {
                    return;
                }
            }
            if (Math.abs(((Vector) vector.first).f19860x - ((Vector) vector.second).f19860x) >= 1.0d && Math.abs(((Vector) vector.first).f19861y - ((Vector) vector.second).f19861y) >= 1.0d) {
                double ar = Math.abs(new Translation(new Line(detector.lastPosition.f19856a, detector.currentPosition.f19856a), detector.lastPosition).rotate);
                double br = Math.abs(new Translation(new Line(detector.lastPosition.f19857b, detector.currentPosition.f19857b), detector.lastPosition).rotate);
                boolean reverse = this.lastScale != 0.0d && this.lastScale * this.lastTranslation.scale < 0.0d;
                if (!reverse) {
                    float speed = (float) Math.sqrt(((((Vector) vector.first).f19861y - ((Vector) vector.second).f19861y) * (((Vector) vector.first).f19861y - ((Vector) vector.second).f19861y)) + ((((Vector) vector.first).f19860x - ((Vector) vector.second).f19860x) * (((Vector) vector.first).f19860x - ((Vector) vector.second).f19860x)));
                    C2911f.b("zoom_speed:", String.valueOf(speed));
                    if (speed > ((float) ((SysOSAPIv2.getInstance().getDensityDpi() * 100) / NaviFragmentManager.TYPE_VOICE_MAIN))) {
                        Translation rightscale;
                        mapStatus.hasAnimation = 1;
                        mapStatus.animationTime = 600;
                        Translation big = null;
                        Translation small = null;
                        int bigCount = 0;
                        int smallCount = 0;
                        for (int i = 0; i < this.mLastTrans.size(); i++) {
                            Translation translation = (Translation) this.mLastTrans.poll();
                            if (translation != null) {
                                C2911f.b("zoom_scale" + i, translation.scale + "");
                                if (this.mLastTrans.isEmpty() && Math.abs(translation.scale - 1.0d) < 0.01d) {
                                    return;
                                }
                                if (translation.scale > 1.0d) {
                                    bigCount++;
                                    big = translation;
                                } else {
                                    smallCount++;
                                    small = translation;
                                }
                            }
                        }
                        if (bigCount >= smallCount) {
                            rightscale = big;
                        } else {
                            rightscale = small;
                        }
                        if (rightscale == null || Math.abs(rightscale.scale - 1.0d) >= 0.01d) {
                            boolean aMoved = (rightscale.scale < 1.0d && ar > 60.0d) || (rightscale.scale > 1.0d && Math.abs(ar - 180.0d) > 60.0d);
                            if (aMoved) {
                                C2911f.b("zoom_ratote", "aMoved");
                            }
                            boolean bMoved = (rightscale.scale > 1.0d && br > 60.0d) || (rightscale.scale < 1.0d && Math.abs(br - 180.0d) > 60.0d);
                            if (bMoved) {
                                C2911f.b("zoom_ratote", "bMoved");
                            }
                            C2911f.b("zoom_ratote", String.valueOf(this.initialTranslation.rotate));
                            if (aMoved || bMoved) {
                                if (Math.abs(this.initialTranslation.rotate) > ((double) (MapController.isCompass ? 30 : 15))) {
                                    return;
                                }
                            }
                            C2911f.b("zoom_scale", String.valueOf(rightscale.scale));
                            this.isScale = rightscale.scale > 1.0d;
                            float ret = speed / ((float) (800000 / SysOSAPIv2.getInstance().getDensityDpi()));
                            if (ret > 2.0f) {
                                ret = 2.0f;
                            }
                            if (this.isScale) {
                                mapStatus.level += ret;
                            } else {
                                mapStatus.level -= ret;
                            }
                            mapStatus.level = mapStatus.level < 4.0f ? 4.0f : mapStatus.level;
                            C2911f.b("zoom_level:", String.valueOf(mapStatus.level));
                            this.controller.setMapStatus(mapStatus);
                        }
                    }
                }
            }
        }
    }
}
