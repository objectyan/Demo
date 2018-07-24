package com.baidu.carlife.core.screen.operation;

import android.os.SystemClock;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.carlife.core.screen.OnTouchListener;

/* compiled from: CarlifeInstrumentation */
/* renamed from: com.baidu.carlife.core.screen.b.e */
public class CarlifeInstrumentation {
    /* renamed from: a */
    private static final float f3669a = 1.0f;
    /* renamed from: b */
    private static final int f3670b = 0;
    /* renamed from: c */
    private static final float f3671c = 1.0f;
    /* renamed from: d */
    private static final float f3672d = 1.0f;
    /* renamed from: e */
    private static final int f3673e = 0;
    /* renamed from: f */
    private static final int f3674f = 0;
    /* renamed from: g */
    private OnTouchListener f3675g;

    /* renamed from: a */
    public void m4513a(OnTouchListener touchListener) {
        this.f3675g = touchListener;
    }

    /* renamed from: a */
    public void m4512a(MotionEvent event) {
        if ((event.getSource() & 2) == 0) {
            event.setSource(4098);
        }
        if (this.f3675g != null) {
            this.f3675g.mo1451a(event, true);
        }
    }

    /* renamed from: a */
    public void m4510a(int key) {
        if (key == 4) {
            m4511a(new KeyEvent(0, key), true);
            m4511a(new KeyEvent(1, key), true);
            return;
        }
        m4511a(new KeyEvent(0, key), false);
        m4511a(new KeyEvent(1, key), false);
    }

    /* renamed from: a */
    public void m4511a(KeyEvent event, boolean inTouchMode) {
        long downTime = event.getDownTime();
        long eventTime = event.getEventTime();
        int action = event.getAction();
        int code = event.getKeyCode();
        int repeatCount = event.getRepeatCount();
        int metaState = event.getMetaState();
        int deviceId = event.getDeviceId();
        int scancode = event.getScanCode();
        int source = event.getSource();
        int flags = event.getFlags();
        if (source == 0) {
            source = 257;
        }
        if (eventTime == 0) {
            eventTime = SystemClock.uptimeMillis();
        }
        if (downTime == 0) {
            downTime = eventTime;
        }
        KeyEvent newEvent = new KeyEvent(downTime, eventTime, action, code, repeatCount, metaState, deviceId, scancode, flags | 8, source);
        if (this.f3675g != null) {
            this.f3675g.mo1451a(newEvent, inTouchMode);
        }
    }

    /* renamed from: a */
    public void m4509a(float x1, float y1) {
        float x2 = x1;
        float y2 = y1;
        long now = SystemClock.uptimeMillis();
        m4508a(4098, 0, now, x1, y1, 1.0f);
        long startTime = now;
        long endTime = startTime + ((long) 700);
        while (now < endTime) {
            float alpha = ((float) (now - startTime)) / ((float) 700);
            m4508a(4098, 2, now, CarlifeInstrumentation.m4507a(x1, x2, alpha), CarlifeInstrumentation.m4507a(y1, y2, alpha), 1.0f);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            now = SystemClock.uptimeMillis();
        }
        m4508a(4098, 1, now, x2, y2, 0.0f);
    }

    /* renamed from: a */
    private void m4508a(int inputSource, int action, long when, float x, float y, float pressure) {
        InputEvent event = MotionEvent.obtain(when, when, action, x, y, pressure, 1.0f, 0, 1.0f, 1.0f, 0, 0);
        event.setSource(inputSource);
        if (this.f3675g != null) {
            this.f3675g.mo1451a(event, true);
        }
    }

    /* renamed from: a */
    private static final float m4507a(float a, float b, float alpha) {
        return ((b - a) * alpha) + a;
    }
}
