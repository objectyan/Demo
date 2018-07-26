package com.baidu.nplatform.comapi.map.gesture.opt;

import android.util.Pair;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.gesture.Base;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Vector;
import com.baidu.nplatform.comapi.map.gesture.Tracker;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector.Listener;
import com.baidu.platform.comapi.util.C4820d;
import java.util.Iterator;
import java.util.LinkedList;

public class OptSelector implements Listener {
    public static final int FACTOR = 3;
    public static final int FINGER_HORIZONTAL_ANGLE = 45;
    public static final int FINGER_VERTICAL_ANGLE = 40;
    private static final int OVERLOOK_CHECK_POINTS = 5;
    private MapController controller;
    private boolean isCheckOverlook = false;
    private int minFling;
    private Opt opt;
    private LinkedList<Line> positionList = new LinkedList();
    private Tracker tracker = new Tracker();

    public OptSelector(MapController controller) {
        this.controller = controller;
        this.minFling = this.tracker.MIN_FLING_VELOCITY / 3;
    }

    public boolean onMoveBegin(MoveDetector detector) {
        this.positionList.clear();
        this.tracker.init();
        this.opt = new ZoomRotateOpt(this.controller);
        this.isCheckOverlook = false;
        return true;
    }

    public boolean onMove(MoveDetector detector) {
        updateOpt(detector);
        if (this.positionList.size() == 1) {
            this.opt.init(detector);
        }
        this.opt.perform(detector);
        return true;
    }

    public boolean onMoveEnd(MoveDetector detector) {
        this.tracker.finish();
        this.opt.finish(detector);
        return true;
    }

    private void updateOpt(MoveDetector detector) {
        if (this.positionList.size() < 5) {
            this.positionList.addLast(detector.currentPosition);
            this.tracker.addMovement(detector.event);
        } else if (!this.isCheckOverlook && this.positionList.size() == 5 && checkOverlook()) {
            switchOverlook(detector);
        }
    }

    private void switchOverlook(MoveDetector detector) {
        this.opt.finish(detector);
        this.opt = new OverLookOpt(this.controller);
        this.opt.init(detector);
    }

    private boolean checkOverlook() {
        this.isCheckOverlook = true;
        Iterator it = this.positionList.iterator();
        while (it.hasNext()) {
            if (Vector.angle(Base.HORIZONTAL.vector(), ((Line) it.next()).vector()) > 45.0d) {
                return false;
            }
        }
        Pair<Vector, Vector> pair = this.tracker.velocity();
        Vector p1 = pair.first;
        Vector p2 = pair.second;
        boolean speedReady = Math.abs(p1.f19736y) > ((double) this.minFling) && Math.abs(p2.f19736y) > ((double) this.minFling);
        Line first = (Line) this.positionList.getFirst();
        Line current = (Line) this.positionList.getLast();
        int angle1 = (int) Vector.angle(new Line(current.f19731a, first.f19731a).vector(), Base.VERTICAL.vector());
        int angle2 = (int) Vector.angle(new Line(current.f19732b, first.f19732b).vector(), Base.VERTICAL.vector());
        if (p1.f19736y > 0.0d && p2.f19736y > 0.0d) {
            angle1 += C4820d.f19955a;
            angle2 += C4820d.f19955a;
        }
        boolean angleReady = Math.abs(angle1) < 40 && Math.abs(angle2) < 40;
        if (speedReady && angleReady) {
            return true;
        }
        return false;
    }
}
