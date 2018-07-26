package com.baidu.nplatform.comapi.map.gesture.detector;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Vector;
import com.baidu.nplatform.comapi.map.gesture.Tracker;

public class MoveDetector {
    public Line currentPosition;
    public MotionEvent event;
    public Line initialPosition;
    public Line lastPosition;
    private Listener listener;
    private boolean running = false;
    public Tracker tracker = new Tracker();

    public interface Listener {
        boolean onMove(MoveDetector moveDetector);

        boolean onMoveBegin(MoveDetector moveDetector);

        boolean onMoveEnd(MoveDetector moveDetector);
    }

    public MoveDetector(Listener listener) {
        this.listener = listener;
    }

    public void onTouchEvent(MotionEvent event) {
        this.event = event;
        switch (event.getAction()) {
            case 2:
                if (this.running) {
                    handleMoving(event);
                    return;
                } else if (event.getPointerCount() == 2) {
                    start();
                    return;
                } else {
                    return;
                }
            case 5:
            case 261:
                if (!this.running) {
                    start();
                    return;
                }
                return;
            case 6:
            case 262:
                if (this.running) {
                    stop();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void start() {
        this.tracker.init();
        this.initialPosition = null;
        this.lastPosition = null;
        this.currentPosition = null;
        this.running = true;
        this.listener.onMoveBegin(this);
    }

    private void stop() {
        this.tracker.finish();
        this.running = false;
        this.listener.onMoveEnd(this);
    }

    private void handleMoving(MotionEvent event) {
        this.tracker.addMovement(event);
        Pair<Vector, Vector> velocity = this.tracker.velocity();
        if (event.getPointerCount() != 2) {
            return;
        }
        if (Math.abs(((Vector) velocity.first).f19735x) > 0.0d || Math.abs(((Vector) velocity.first).f19736y) > 0.0d || Math.abs(((Vector) velocity.second).f19735x) > 0.0d || Math.abs(((Vector) velocity.second).f19736y) > 0.0d) {
            updatePosition(event);
            this.listener.onMove(this);
        }
    }

    private void updatePosition(MotionEvent event) {
        Line line = Line.make(event);
        this.lastPosition = this.currentPosition != null ? this.currentPosition : line;
        this.currentPosition = line;
        if (this.initialPosition == null) {
            this.initialPosition = line;
        }
    }
}
