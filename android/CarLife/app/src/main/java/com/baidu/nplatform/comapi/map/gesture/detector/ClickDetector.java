package com.baidu.nplatform.comapi.map.gesture.detector;

import android.view.MotionEvent;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;

public class ClickDetector {
    public static final int MIN_FINGER_RANGE = 20;
    public static final int MIN_TOUCH_TIME = 200;
    private long beginTime = 0;
    private Line last;
    private Listener listener;
    private boolean twoPoint = false;

    public interface Listener {
        boolean onTwoTouchClick(ClickDetector clickDetector);
    }

    public ClickDetector(Listener listener) {
        this.listener = listener;
    }

    public void onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                this.beginTime = System.currentTimeMillis();
                return;
            case 5:
            case 261:
                start(event);
                return;
            case 6:
            case 262:
                check(event);
                stop();
                return;
            default:
                return;
        }
    }

    private void check(MotionEvent event) {
        if (event.getPointerCount() == 2 && this.last != null) {
            boolean near;
            Line cur = Line.make(event);
            Line line1 = new Line(this.last.f19731a, cur.f19731a);
            Line line2 = new Line(this.last.f19732b, cur.f19732b);
            if (Math.abs(line1.length()) >= 20.0d || Math.abs(line2.length()) >= 20.0d) {
                near = false;
            } else {
                near = true;
            }
            boolean quick;
            if (System.currentTimeMillis() - this.beginTime < 200) {
                quick = true;
            } else {
                quick = false;
            }
            if (near && quick && this.twoPoint) {
                this.listener.onTwoTouchClick(this);
            }
        }
    }

    private void start(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            this.last = Line.make(event);
            this.twoPoint = true;
        }
    }

    private void stop() {
        this.twoPoint = false;
        this.last = null;
        this.beginTime = 0;
    }
}
