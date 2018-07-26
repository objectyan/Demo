package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.geolocate.ISensorDataChangeListener;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.SensorData;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SensorAlgoFilter;
import java.util.ArrayList;

public class BNSysSensorManager extends BNLogicController {
    public static final int SENSORFINGER_TYPE_ACCELEROMETER = 1;
    public static final int SENSORFINGER_TYPE_GRAVITY = 2;
    public static final int SENSORFINGER_TYPE_GYROSCOPE = 3;
    public static final int SENSORFINGER_TYPE_INVALID = 0;
    public static final int SENSORFINGER_TYPE_MAGNETOMETER = 5;
    public static final int SENSORFINGER_TYPE_ORIENTATION = 4;
    private static final String TAG = "Location";
    private static volatile BNSysSensorManager mInstance = null;
    private float[] accelerometerValues = new float[3];
    private boolean isSensorFingerInitialized = false;
    private boolean isSensorInitialized = false;
    private SensorData mCurSensor = new SensorData();
    private ArrayList<ISensorDataChangeListener> mSensorDataObservers = new ArrayList();
    private SensorEventListener mSensorEventListener = new C47111();
    private SensorAlgoFilter mSensorFilter = new SensorAlgoFilter();
    private SensorEventListener mSensorFingerEventListener = new C47122();
    private SensorManager mSensorManager = null;
    private ArrayList<ISensorChangeListener> mSensorObservers = new ArrayList();
    private SensorData mTmpSensor = new SensorData();

    /* renamed from: com.baidu.navisdk.util.logic.BNSysSensorManager$1 */
    class C47111 implements SensorEventListener {
        C47111() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSensorChanged(android.hardware.SensorEvent r11) {
            /*
            r10 = this;
            r9 = 1;
            r8 = 0;
            r4 = r11.values;
            r0 = r4.clone();
            r0 = (float[]) r0;
            r4 = r11.sensor;
            r3 = r4.getType();
            r4 = 3;
            if (r3 != r4) goto L_0x00dc;
        L_0x0013:
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;
            r5 = r4.mTmpSensor;
            monitor-enter(r5);
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.accelerometerValues;	 Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x0024;
        L_0x0022:
            monitor-exit(r5);	 Catch:{ all -> 0x00af }
        L_0x0023:
            return;
        L_0x0024:
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r6 = r6.accelerometerValues;	 Catch:{ all -> 0x00af }
            r7 = 0;
            r6 = r6[r7];	 Catch:{ all -> 0x00af }
            r6 = (double) r6;	 Catch:{ all -> 0x00af }
            r4.accx = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r6 = r6.accelerometerValues;	 Catch:{ all -> 0x00af }
            r7 = 1;
            r6 = r6[r7];	 Catch:{ all -> 0x00af }
            r6 = (double) r6;	 Catch:{ all -> 0x00af }
            r4.accy = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r6 = r6.accelerometerValues;	 Catch:{ all -> 0x00af }
            r7 = 2;
            r6 = r6[r7];	 Catch:{ all -> 0x00af }
            r6 = (double) r6;	 Catch:{ all -> 0x00af }
            r4.accz = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = 0;
            r6 = r0[r6];	 Catch:{ all -> 0x00af }
            r6 = (double) r6;	 Catch:{ all -> 0x00af }
            r4.heading = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = 2;
            r6 = r0[r6];	 Catch:{ all -> 0x00af }
            r6 = -r6;
            r6 = (double) r6;	 Catch:{ all -> 0x00af }
            r4.pitch = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = 1;
            r6 = r0[r6];	 Catch:{ all -> 0x00af }
            r6 = -r6;
            r6 = (double) r6;	 Catch:{ all -> 0x00af }
            r4.roll = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r6 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r6 = r6.mTmpSensor;	 Catch:{ all -> 0x00af }
            r6 = r6.clone();	 Catch:{ all -> 0x00af }
            r4.mCurSensor = r6;	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r4 = r4.mSensorDataObservers;	 Catch:{ all -> 0x00af }
            r4 = r4.iterator();	 Catch:{ all -> 0x00af }
        L_0x0099:
            r6 = r4.hasNext();	 Catch:{ all -> 0x00af }
            if (r6 == 0) goto L_0x00b2;
        L_0x009f:
            r2 = r4.next();	 Catch:{ all -> 0x00af }
            r2 = (com.baidu.navisdk.comapi.geolocate.ISensorDataChangeListener) r2;	 Catch:{ all -> 0x00af }
            r6 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;	 Catch:{ all -> 0x00af }
            r6 = r6.mCurSensor;	 Catch:{ all -> 0x00af }
            r2.onSensorDataChange(r6);	 Catch:{ all -> 0x00af }
            goto L_0x0099;
        L_0x00af:
            r4 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x00af }
            throw r4;
        L_0x00b2:
            monitor-exit(r5);	 Catch:{ all -> 0x00af }
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;
            r4 = r4.mSensorFilter;
            r5 = r11.values;
            r5 = r5[r8];
            r4 = r4.execute(r5);
            r1 = (int) r4;
            r4 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;
            r4 = r4.mSensorObservers;
            r4 = r4.iterator();
        L_0x00cc:
            r5 = r4.hasNext();
            if (r5 == 0) goto L_0x00dc;
        L_0x00d2:
            r2 = r4.next();
            r2 = (com.baidu.navisdk.comapi.geolocate.ISensorChangeListener) r2;
            r2.onSensorChange(r1);
            goto L_0x00cc;
        L_0x00dc:
            if (r3 != r9) goto L_0x0023;
        L_0x00de:
            r5 = com.baidu.navisdk.util.logic.BNSysSensorManager.this;
            r4 = r0.clone();
            r4 = (float[]) r4;
            r5.accelerometerValues = r4;
            goto L_0x0023;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.logic.BNSysSensorManager.1.onSensorChanged(android.hardware.SensorEvent):void");
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    /* renamed from: com.baidu.navisdk.util.logic.BNSysSensorManager$2 */
    class C47122 implements SensorEventListener {
        C47122() {
        }

        public void onSensorChanged(SensorEvent event) {
            float[] data = (float[]) event.values.clone();
            int sensorFingerType = 0;
            switch (event.sensor.getType()) {
                case 1:
                    sensorFingerType = 1;
                    break;
                case 2:
                    sensorFingerType = 5;
                    break;
                case 3:
                    sensorFingerType = 4;
                    break;
                case 4:
                    sensorFingerType = 3;
                    break;
                case 6:
                    BNRoutePlaner.getInstance().triggerPressureChange(data[0]);
                    sensorFingerType = 0;
                    break;
                case 9:
                    sensorFingerType = 2;
                    break;
            }
            if (sensorFingerType != 0) {
                BNRouteGuider.getInstance().triggerRecordSensorData(data[0], data[1], data[2], sensorFingerType);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    private BNSysSensorManager() {
    }

    public static BNSysSensorManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNSysSensorManager();
        }
        return mInstance;
    }

    public static void destory() {
        if (mInstance != null) {
            mInstance.uninitSensor();
        }
        mInstance = null;
    }

    public void initSensor(Context context) {
        try {
            if (this.mSensorManager == null) {
                this.mSensorManager = (SensorManager) context.getSystemService("sensor");
            }
            if (!this.isSensorInitialized) {
                LogUtil.m15791e("Location", "[system] initSensor");
                this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensorManager.getDefaultSensor(1), 3);
                this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensorManager.getDefaultSensor(3), 3);
                this.isSensorInitialized = true;
            }
        } catch (Exception e) {
        }
    }

    public void uninitSensor() {
        try {
            if (this.mSensorManager != null && this.isSensorInitialized) {
                LogUtil.m15791e("Location", "[system] uninitSensor");
                this.mSensorManager.unregisterListener(this.mSensorEventListener);
                this.isSensorInitialized = false;
            }
        } catch (Exception e) {
        }
    }

    public void addSensorDataChangeListener(ISensorDataChangeListener listener) {
        this.mSensorDataObservers.add(listener);
    }

    public void removeSensorDataChangeListener(ISensorDataChangeListener listener) {
        this.mSensorDataObservers.remove(listener);
    }

    public void addSensorChangeListener(ISensorChangeListener listener) {
        synchronized (this.mSensorObservers) {
            if (!this.mSensorObservers.contains(listener)) {
                this.mSensorObservers.add(listener);
            }
        }
    }

    public void removeSensorChangeListener(ISensorChangeListener listener) {
        synchronized (this.mSensorObservers) {
            this.mSensorObservers.remove(listener);
        }
    }

    public void initSensorFinger(Context context) {
        try {
            if (this.mSensorManager == null) {
                this.mSensorManager = (SensorManager) context.getSystemService("sensor");
            }
            if (!this.isSensorFingerInitialized) {
                LogUtil.m15791e("Location", "[SensorFinger] initSensorFinger");
                this.mSensorManager.registerListener(this.mSensorFingerEventListener, this.mSensorManager.getDefaultSensor(1), 3);
                this.mSensorManager.registerListener(this.mSensorFingerEventListener, this.mSensorManager.getDefaultSensor(9), 3);
                this.mSensorManager.registerListener(this.mSensorFingerEventListener, this.mSensorManager.getDefaultSensor(4), 3);
                this.mSensorManager.registerListener(this.mSensorFingerEventListener, this.mSensorManager.getDefaultSensor(3), 3);
                this.mSensorManager.registerListener(this.mSensorFingerEventListener, this.mSensorManager.getDefaultSensor(2), 3);
                Sensor preSensor = this.mSensorManager.getDefaultSensor(6);
                if (preSensor != null) {
                    this.mSensorManager.registerListener(this.mSensorFingerEventListener, preSensor, 3);
                }
                this.isSensorFingerInitialized = true;
            }
        } catch (Exception e) {
        }
    }

    public void uninitSensorFinger() {
        try {
            if (this.mSensorManager != null && this.isSensorFingerInitialized) {
                LogUtil.m15791e("Location", "[SensorFinger] uninitSensorFinger");
                this.mSensorManager.unregisterListener(this.mSensorFingerEventListener);
                this.isSensorFingerInitialized = false;
            }
        } catch (Exception e) {
        }
    }
}
