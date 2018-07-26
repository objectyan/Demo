package com.baidu.location.p187a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.C3377f;
import com.baidu.location.p195g.C3379a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.baidu.location.a.i */
public class C3202i implements SensorEventListener {
    /* renamed from: d */
    private static C3202i f17414d;
    /* renamed from: a */
    private float[] f17415a;
    /* renamed from: b */
    private float[] f17416b;
    /* renamed from: c */
    private SensorManager f17417c;
    /* renamed from: e */
    private float f17418e;
    /* renamed from: f */
    private double f17419f = Double.MIN_VALUE;
    /* renamed from: g */
    private boolean f17420g = false;
    /* renamed from: h */
    private boolean f17421h = false;
    /* renamed from: i */
    private boolean f17422i = false;
    /* renamed from: j */
    private boolean f17423j = false;
    /* renamed from: k */
    private float f17424k = 0.0f;
    /* renamed from: l */
    private long f17425l = 0;
    /* renamed from: m */
    private Map<Integer, List<Float>> f17426m = new ConcurrentHashMap();
    /* renamed from: n */
    private boolean f17427n = false;
    /* renamed from: o */
    private long f17428o = 0;
    /* renamed from: p */
    private boolean f17429p = false;

    /* renamed from: com.baidu.location.a.i$1 */
    class C32011 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3202i f17413a;

        C32011(C3202i c3202i) {
            this.f17413a = c3202i;
        }

        public void run() {
            if (this.f17413a.f17417c != null && !this.f17413a.f17421h) {
                this.f17413a.f17417c.unregisterListener(C3202i.f17414d, this.f17413a.f17417c.getDefaultSensor(6));
                this.f17413a.f17429p = false;
            }
        }
    }

    private C3202i() {
        try {
            if (this.f17417c == null) {
                this.f17417c = (SensorManager) C3377f.getServiceContext().getSystemService("sensor");
            }
            if (this.f17417c.getDefaultSensor(6) != null) {
                this.f17423j = true;
            }
        } catch (Exception e) {
            this.f17423j = false;
        }
    }

    /* renamed from: a */
    public static synchronized C3202i m13395a() {
        C3202i c3202i;
        synchronized (C3202i.class) {
            if (f17414d == null) {
                f17414d = new C3202i();
            }
            c3202i = f17414d;
        }
        return c3202i;
    }

    /* renamed from: l */
    private void m13399l() {
        if (this.f17417c != null) {
            Sensor defaultSensor = this.f17417c.getDefaultSensor(6);
            if (!(defaultSensor == null || this.f17429p)) {
                this.f17417c.registerListener(f17414d, defaultSensor, 3);
                this.f17429p = true;
            }
            if (!this.f17421h) {
                C3379a.m14386a().postDelayed(new C32011(this), 2000);
            }
        }
    }

    /* renamed from: a */
    public void m13400a(boolean z) {
        this.f17420g = z;
    }

    /* renamed from: b */
    public synchronized void m13401b() {
        if (!this.f17427n) {
            if (this.f17420g || this.f17422i) {
                if (this.f17417c == null) {
                    this.f17417c = (SensorManager) C3377f.getServiceContext().getSystemService("sensor");
                }
                if (this.f17417c != null) {
                    Sensor defaultSensor = this.f17417c.getDefaultSensor(11);
                    if (defaultSensor != null && this.f17420g) {
                        this.f17417c.registerListener(this, defaultSensor, 3);
                    }
                    defaultSensor = this.f17417c.getDefaultSensor(6);
                    if (defaultSensor != null && this.f17422i) {
                        this.f17417c.registerListener(this, defaultSensor, 3);
                        this.f17429p = true;
                    }
                }
                this.f17427n = true;
            }
        }
    }

    /* renamed from: b */
    public void m13402b(boolean z) {
    }

    /* renamed from: c */
    public synchronized void m13403c() {
        if (this.f17427n) {
            if (this.f17417c != null) {
                this.f17417c.unregisterListener(this);
                this.f17417c = null;
                this.f17429p = false;
            }
            this.f17427n = false;
            this.f17424k = 0.0f;
            this.f17426m.clear();
        }
    }

    /* renamed from: c */
    public void m13404c(boolean z) {
        this.f17421h = z;
        if (!z) {
            if (this.f17417c != null) {
                this.f17417c.unregisterListener(f17414d, this.f17417c.getDefaultSensor(6));
                this.f17429p = false;
            }
            this.f17426m.clear();
        }
    }

    /* renamed from: d */
    public void m13405d() {
        if (!this.f17422i && this.f17423j) {
            if (this.f17421h || System.currentTimeMillis() - this.f17428o > 60000) {
                this.f17428o = System.currentTimeMillis();
                m13399l();
            }
        }
    }

    /* renamed from: e */
    public float m13406e() {
        return (!this.f17423j || this.f17425l <= 0) ? 0.0f : this.f17421h ? m13407f() : this.f17424k > 0.0f ? this.f17424k : 0.0f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public float m13407f() {
        /*
        r7 = this;
        r2 = 0;
        monitor-enter(r7);	 Catch:{ Exception -> 0x007f }
        r0 = r7.f17423j;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0089;
    L_0x0006:
        r0 = r7.f17425l;	 Catch:{ all -> 0x0078 }
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0089;
    L_0x000e:
        r0 = r7.f17426m;	 Catch:{ all -> 0x0078 }
        r0 = r0.size();	 Catch:{ all -> 0x0078 }
        if (r0 <= 0) goto L_0x0089;
    L_0x0016:
        r1 = 0;
        r0 = r7.f17426m;	 Catch:{ all -> 0x0078 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0078 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0078 }
    L_0x0021:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0039;
    L_0x0027:
        r0 = r3.next();	 Catch:{ all -> 0x0078 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0078 }
        r4 = r0.intValue();	 Catch:{ all -> 0x0078 }
        if (r4 <= r1) goto L_0x008b;
    L_0x0033:
        r0 = r0.intValue();	 Catch:{ all -> 0x0078 }
    L_0x0037:
        r1 = r0;
        goto L_0x0021;
    L_0x0039:
        r0 = r7.f17426m;	 Catch:{ all -> 0x0078 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0078 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0089;
    L_0x0045:
        r0 = r7.f17426m;	 Catch:{ all -> 0x0078 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0078 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0078 }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x0078 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0078 }
        r3 = r2;
    L_0x0056:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0078 }
        if (r1 == 0) goto L_0x0069;
    L_0x005c:
        r1 = r4.next();	 Catch:{ all -> 0x0078 }
        r1 = (java.lang.Float) r1;	 Catch:{ all -> 0x0078 }
        r1 = r1.floatValue();	 Catch:{ all -> 0x0078 }
        r1 = r1 + r3;
        r3 = r1;
        goto L_0x0056;
    L_0x0069:
        r0 = r0.size();	 Catch:{ all -> 0x0078 }
        r0 = (float) r0;
        r2 = r3 / r0;
        r0 = r2;
    L_0x0071:
        r1 = r7.f17426m;	 Catch:{ all -> 0x0082 }
        r1.clear();	 Catch:{ all -> 0x0082 }
        monitor-exit(r7);	 Catch:{ all -> 0x0082 }
    L_0x0077:
        return r0;
    L_0x0078:
        r0 = move-exception;
        r1 = r2;
    L_0x007a:
        monitor-exit(r7);	 Catch:{ all -> 0x0087 }
        throw r0;	 Catch:{ Exception -> 0x007c }
    L_0x007c:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0077;
    L_0x007f:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0077;
    L_0x0082:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x007a;
    L_0x0087:
        r0 = move-exception;
        goto L_0x007a;
    L_0x0089:
        r0 = r2;
        goto L_0x0071;
    L_0x008b:
        r0 = r1;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.i.f():float");
    }

    /* renamed from: g */
    public boolean m13408g() {
        return this.f17420g;
    }

    /* renamed from: h */
    public boolean m13409h() {
        return this.f17422i;
    }

    /* renamed from: i */
    public float m13410i() {
        return this.f17418e;
    }

    /* renamed from: j */
    public double m13411j() {
        return this.f17419f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 6:
                try {
                    this.f17416b = (float[]) sensorEvent.values.clone();
                    this.f17424k = this.f17416b[0];
                    this.f17425l = System.currentTimeMillis();
                    if (this.f17421h) {
                        int i = (int) (this.f17425l / 1000);
                        if (this.f17426m.get(Integer.valueOf(i)) == null) {
                            this.f17426m.put(Integer.valueOf(i), new ArrayList());
                        }
                        ((List) this.f17426m.get(Integer.valueOf(i))).add(Float.valueOf(this.f17424k));
                    }
                    this.f17419f = (double) SensorManager.getAltitude(1013.25f, this.f17416b[0]);
                    return;
                } catch (Exception e) {
                    return;
                }
            case 11:
                this.f17415a = (float[]) sensorEvent.values.clone();
                if (this.f17415a != null) {
                    float[] fArr = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr, this.f17415a);
                        float[] fArr2 = new float[3];
                        SensorManager.getOrientation(fArr, fArr2);
                        this.f17418e = (float) Math.toDegrees((double) fArr2[0]);
                        this.f17418e = (float) Math.floor(this.f17418e >= 0.0f ? (double) this.f17418e : (double) (this.f17418e + 360.0f));
                        return;
                    } catch (Exception e2) {
                        this.f17418e = 0.0f;
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
