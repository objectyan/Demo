package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import java.util.List;

public class VCompass {
    private static final int MSG_INIT_COMPASS = 1;
    private static final int MSG_UNINIT_COMPASS = 2;
    private static final Handler mHandler = new C52341();
    private SensorEventListener mEventListener = new C52352(this);
    private int mJniData = 0;
    private SensorManager mSensorManager = null;
    private float myBarrier = 2.0f;
    private float oldV;

    /* renamed from: com.baidu.vi.VCompass$1 */
    static class C52341 extends Handler {
        C52341() {
        }

        public void handleMessage(Message msg) {
            VCompass compass = msg.obj;
            if (compass != null) {
                switch (msg.what) {
                    case 1:
                        Context context = VIContext.getContext();
                        if (compass.mSensorManager == null) {
                            compass.mSensorManager = (SensorManager) context.getSystemService("sensor");
                        }
                        List<Sensor> sensors = compass.mSensorManager.getSensorList(3);
                        if (sensors.size() > 0) {
                            compass.mSensorManager.registerListener(compass.mEventListener, (Sensor) sensors.get(0), 1);
                            return;
                        }
                        return;
                    case 2:
                        compass.mSensorManager.unregisterListener(compass.mEventListener);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.vi.VCompass$2 */
    class C52352 implements SensorEventListener {
        /* renamed from: a */
        final /* synthetic */ VCompass f21732a;

        C52352(VCompass this$0) {
            this.f21732a = this$0;
        }

        public void onSensorChanged(SensorEvent event) {
            switch (event.sensor.getType()) {
                case 3:
                    this.f21732a.updateCompass((int) this.f21732a.execute(event.values[0]));
                    return;
                default:
                    return;
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    private native void updateCompass(int i);

    private float execute(float v) {
        this.oldV = checkAndCalc(this.oldV, v, this.myBarrier);
        return this.oldV;
    }

    private float checkAndCalc(float oldV, float newV, float barrier) {
        float delta = oldV - newV;
        if (delta > 180.0f || delta < -180.0f) {
            return newV;
        }
        if (delta < (-barrier) || barrier < delta) {
            return (oldV + newV) / 2.0f;
        }
        return oldV;
    }

    private void init() {
        mHandler.removeMessages(1);
        mHandler.sendMessage(mHandler.obtainMessage(1, this));
    }

    private void unInit() {
        mHandler.removeMessages(2);
        mHandler.sendMessage(mHandler.obtainMessage(2, this));
    }
}
