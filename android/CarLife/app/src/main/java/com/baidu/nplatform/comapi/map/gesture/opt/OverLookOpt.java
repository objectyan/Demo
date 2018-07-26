package com.baidu.nplatform.comapi.map.gesture.opt;

import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;

public class OverLookOpt extends Opt {
    private static final double DOWN_SPEED = 2.0d;
    public static final int MAX_OVER_LOOK = 0;
    public static final int MIN_OVER_LOOK = -45;
    private static final int UP_SPEED = 4;
    private int initialOverlook;

    public OverLookOpt(MapController controller) {
        super(controller);
    }

    public void init(MoveDetector detector) {
        this.initialOverlook = this.controller.getMapStatus()._Overlooking;
    }

    public void perform(MoveDetector detector) {
        Line last = detector.lastPosition;
        Line current = detector.currentPosition;
        MapStatus mapStatus = this.controller.getMapStatus();
        double a = current.f19731a.f19734y - last.f19731a.f19734y;
        double b = current.f19732b.f19734y - last.f19732b.f19734y;
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
        if (mapStatus._Overlooking > 0) {
            mapStatus._Overlooking = 0;
        } else if (mapStatus._Overlooking < -45) {
            mapStatus._Overlooking = -45;
        }
        this.controller.setMapStatus(mapStatus, AnimationType.eAnimationNone);
    }

    private void rotateOverlook(double move, MapStatus mapStatus) {
        if (move > 0.0d) {
            mapStatus._Overlooking -= 4;
        } else {
            mapStatus._Overlooking = (int) (((double) mapStatus._Overlooking) + DOWN_SPEED);
        }
    }

    public void finish(MoveDetector detector) {
        MapStatus mapStatus = this.controller.getMapStatus();
        if (mapStatus._Overlooking > this.initialOverlook) {
            LogUtil.m15791e("MapGesture", "OverLookOpt: finish event UP");
            BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_TWOFLIPUP);
        } else if (mapStatus._Overlooking < this.initialOverlook) {
            LogUtil.m15791e("MapGesture", "OverLookOpt: finish event DOWN");
            BNStatisticsManager.getInstance().onGestureEvent(NaviStatConstants.K_NSC_KEY_MAPGESTURE_TWOFLIPDOWN);
        }
    }
}
