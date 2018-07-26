package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.baidu.navisdk.util.common.LogUtil;

public class BNMapGestureDetector extends GestureDetector {
    private boolean hasLongPressEvent = false;
    private boolean hasTriggerDoubleTapEvent = false;
    private OnGestureListener mListener = null;

    public BNMapGestureDetector(OnGestureListener listener) {
        super(listener, new Handler(Looper.getMainLooper()));
        this.mListener = listener;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        LogUtil.m15791e("BNMapGestureDetector", "onTouchEvent()");
        boolean ret = super.onTouchEvent(ev);
        int action = ev.getAction();
        LogUtil.m15791e("BNMapGestureDetector", (action & 255) + "" + this.hasTriggerDoubleTapEvent + this.hasLongPressEvent + (this.mListener instanceof OnDoubleTapListener));
        if ((action & 255) == 2) {
            if (!this.hasTriggerDoubleTapEvent || !this.hasLongPressEvent) {
                return ret;
            }
            LogUtil.m15791e("BNMapGestureDetector", "onDoubleTapEvent()");
            if (this.mListener == null || !(this.mListener instanceof OnDoubleTapListener)) {
                return ret;
            }
            return ((OnDoubleTapListener) this.mListener).onDoubleTapEvent(ev);
        } else if ((action & 255) != 1) {
            return ret;
        } else {
            this.hasTriggerDoubleTapEvent = false;
            this.hasLongPressEvent = false;
            return ret;
        }
    }

    public void setHasTriggerDoubleTapEvent(boolean flag) {
        this.hasTriggerDoubleTapEvent = flag;
    }

    public void setHasLongPressEvent(boolean flag) {
        this.hasLongPressEvent = flag;
    }
}
