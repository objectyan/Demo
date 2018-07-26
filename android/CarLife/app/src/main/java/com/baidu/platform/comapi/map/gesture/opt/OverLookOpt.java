package com.baidu.platform.comapi.map.gesture.opt;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.gesture.Base.Line;
import com.baidu.platform.comapi.map.gesture.Base.Vector;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;

public class OverLookOpt extends Opt {
    private static final double DOWN_SPEED = 2.0d;
    public static final int MAX_OVER_LOOK = 0;
    private static final int UP_SPEED = 4;
    private boolean isFirst = true;

    public OverLookOpt(MapController controller) {
        super(controller);
    }

    public void perform(MoveDetector detector) {
        Line last = detector.lastPosition;
        Line current = detector.currentPosition;
        MapStatus mapStatus = this.controller.getMapStatus();
        double a = current.f19856a.f19859y - last.f19856a.f19859y;
        double b = current.f19857b.f19859y - last.f19857b.f19859y;
        if (a * b > 0.0d) {
            rotateOverlook(a, mapStatus);
        } else if (a * b == 0.0d) {
            if (a != 0.0d) {
                rotateOverlook(a, mapStatus);
            } else if (b != 0.0d) {
                rotateOverlook(b, mapStatus);
            }
        } else if (Math.abs(a) > Math.abs(b)) {
            rotateOverlook(a, mapStatus);
        } else {
            rotateOverlook(b, mapStatus);
        }
        this.controller.setMapStatus(mapStatus);
        if (this.isFirst) {
            this.isFirst = false;
            this.controller.getGestureMonitor().handleMoveOverlook();
        }
    }

    public void finish(MoveDetector detector, Pair<Vector, Vector> pair) {
        MapStatus mapStatus = this.controller.getMapStatus();
        if (mapStatus.bOverlookSpringback) {
            if (mapStatus.overlooking > 0) {
                mapStatus.overlooking = 0;
            } else {
                mapStatus.overlooking = mapStatus.minOverlooking;
            }
            this.controller.setMapStatusWithAnimation(mapStatus, 200);
        }
    }

    private void rotateOverlook(double move, MapStatus mapStatus) {
        if (move > 0.0d) {
            mapStatus.overlooking -= 4;
        } else {
            mapStatus.overlooking = (int) (((double) mapStatus.overlooking) + DOWN_SPEED);
        }
    }
}
