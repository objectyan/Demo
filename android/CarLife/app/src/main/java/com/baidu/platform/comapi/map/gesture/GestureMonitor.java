package com.baidu.platform.comapi.map.gesture;

import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;

public class GestureMonitor {
    private StringBuffer actionSerial = new StringBuffer();
    private MapController controller;
    private float lastMapLevel;
    private StringBuffer moveSerial = new StringBuffer();

    enum ActionSearialType {
        ZOOM_OUT,
        ZOOM_IN,
        FLING,
        MOVE,
        ROTATE,
        DOUBLE_CLICK_ZOOM_IN,
        TWO_CLICK_ZOOM_OUT,
        MOVE_OVERLOOK
    }

    public GestureMonitor(MapController controller) {
        this.controller = controller;
    }

    private void setLastMapLevel(float lastMapLevel) {
        this.lastMapLevel = lastMapLevel;
    }

    public void start(float lastMapLevel) {
        cleanSerial();
        setLastMapLevel(lastMapLevel);
    }

    public String stop(boolean isDiagnose) {
        if (this.actionSerial == null || this.moveSerial == null) {
            return "";
        }
        String stringBuffer = isDiagnose ? this.actionSerial.toString() : this.moveSerial.toString();
        cleanSerial();
        return stringBuffer;
    }

    private void cleanSerial() {
        this.actionSerial = null;
        this.actionSerial = new StringBuffer();
        this.moveSerial = null;
        this.moveSerial = new StringBuffer();
    }

    public void handleFling() {
        addAction(ActionSearialType.FLING);
    }

    public void handleZoomChange(float mapLevel) {
        if (zoomOut(mapLevel)) {
            addAction(ActionSearialType.ZOOM_OUT);
        }
        if (zoomIn(mapLevel)) {
            addAction(ActionSearialType.ZOOM_IN);
        }
        setLastMapLevel(mapLevel);
    }

    public void handleDoubleClick(float mapLevel) {
        addAction(ActionSearialType.DOUBLE_CLICK_ZOOM_IN);
        setLastMapLevel(mapLevel);
    }

    public void handleTwoClick(float mapLevel) {
        addAction(ActionSearialType.TWO_CLICK_ZOOM_OUT);
        setLastMapLevel(mapLevel);
    }

    public void handleTouchMove() {
        addAction(ActionSearialType.MOVE);
    }

    public void handleRotate() {
        addAction(ActionSearialType.ROTATE);
    }

    public void handleMoveOverlook() {
        addAction(ActionSearialType.MOVE_OVERLOOK);
    }

    private boolean zoomOut(float mapLevel) {
        return mapLevel > this.lastMapLevel;
    }

    private boolean zoomIn(float mapLevel) {
        return mapLevel < this.lastMapLevel;
    }

    private void addAction(ActionSearialType type) {
        if (this.controller != null) {
            MapViewInterface mapView = this.controller.getMapView();
            if (mapView != null) {
                String log;
                GeoPoint point = mapView.getMapCenter();
                try {
                    log = String.format("(%s,%d,%d,%d,%d)", new Object[]{getString(type), Integer.valueOf(point.getLongitudeE6()), Integer.valueOf(point.getLatitudeE6()), Integer.valueOf((int) mapView.getZoomLevel()), Long.valueOf(System.currentTimeMillis())});
                } catch (IllegalFormatException e) {
                    log = getString(type);
                }
                if (this.actionSerial != null) {
                    this.actionSerial.append(log);
                    if (this.moveSerial != null) {
                        this.moveSerial.append(getString(type));
                    }
                }
            }
        }
    }

    private String getString(ActionSearialType type) {
        String rtn = "";
        switch (type) {
            case MOVE:
            case FLING:
                return "0";
            case ZOOM_OUT:
                return "1";
            case ZOOM_IN:
                return "2";
            case ROTATE:
                return "3";
            case DOUBLE_CLICK_ZOOM_IN:
                return "4";
            case TWO_CLICK_ZOOM_OUT:
                return "5";
            case MOVE_OVERLOOK:
                return C2578b.f8568g;
            default:
                return rtn;
        }
    }
}
