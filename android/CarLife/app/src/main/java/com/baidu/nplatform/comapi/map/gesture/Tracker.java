package com.baidu.nplatform.comapi.map.gesture;

import android.os.Build.VERSION;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.nplatform.comapi.map.gesture.Base.Vector;

public class Tracker {
    public final int MAX_FLING_VELOCITY;
    public final int MIN_FLING_VELOCITY;
    private VelocityTracker velocityTracker;

    public Tracker() {
        ViewConfiguration viewConfig = null;
        if (BNaviModuleManager.getContext() != null) {
            try {
                viewConfig = ViewConfiguration.get(BNaviModuleManager.getContext());
            } catch (Exception e) {
                viewConfig = null;
            }
        }
        if (viewConfig == null) {
            this.MIN_FLING_VELOCITY = ViewConfiguration.getMinimumFlingVelocity();
            this.MAX_FLING_VELOCITY = ViewConfiguration.getMaximumFlingVelocity();
            return;
        }
        this.MIN_FLING_VELOCITY = viewConfig.getScaledMinimumFlingVelocity();
        this.MAX_FLING_VELOCITY = viewConfig.getScaledMaximumFlingVelocity();
    }

    public void init() {
        this.velocityTracker = VelocityTracker.obtain();
    }

    public void finish() {
        if (this.velocityTracker != null) {
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    public Pair<Vector, Vector> velocity() {
        if (this.velocityTracker == null) {
            return new Pair(new Vector(0.0d, 0.0d), new Vector(0.0d, 0.0d));
        }
        float x1;
        float y1;
        float x2;
        float y2;
        this.velocityTracker.computeCurrentVelocity(1000, (float) this.MAX_FLING_VELOCITY);
        if (VERSION.SDK_INT < 8) {
            x1 = this.velocityTracker.getXVelocity();
            y1 = this.velocityTracker.getYVelocity();
            x2 = this.velocityTracker.getXVelocity();
            y2 = this.velocityTracker.getYVelocity();
        } else {
            x1 = this.velocityTracker.getXVelocity(0);
            y1 = this.velocityTracker.getYVelocity(0);
            x2 = this.velocityTracker.getXVelocity(1);
            y2 = this.velocityTracker.getYVelocity(1);
        }
        return new Pair(new Vector((double) x1, (double) y1), new Vector((double) x2, (double) y2));
    }

    public void addMovement(MotionEvent event) {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        } else {
            this.velocityTracker.addMovement(event);
        }
    }

    public Vector getVelocity() {
        if (this.velocityTracker == null) {
            return new Vector(0.0d, 0.0d);
        }
        this.velocityTracker.computeCurrentVelocity(1000, (float) this.MAX_FLING_VELOCITY);
        return new Vector((double) this.velocityTracker.getXVelocity(), (double) this.velocityTracker.getYVelocity());
    }
}
