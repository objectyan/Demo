package com.baidu.location.p191d.p192a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.location.C3377f;
import com.baidu.location.p194f.C3376f;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import java.io.File;

/* renamed from: com.baidu.location.d.a.e */
public class C3268e implements SensorEventListener {
    /* renamed from: a */
    public boolean f17736a;
    /* renamed from: b */
    public long f17737b;
    /* renamed from: c */
    long f17738c;
    /* renamed from: d */
    private SensorManager f17739d;
    /* renamed from: e */
    private C3266a f17740e;
    /* renamed from: f */
    private C3266a f17741f;
    /* renamed from: g */
    private C3266a f17742g;
    /* renamed from: h */
    private C3266a f17743h;
    /* renamed from: i */
    private C3266a f17744i;
    /* renamed from: j */
    private Handler f17745j;
    /* renamed from: k */
    private HandlerThread f17746k;
    /* renamed from: l */
    private StringBuffer f17747l;
    /* renamed from: m */
    private Runnable f17748m;
    /* renamed from: n */
    private boolean f17749n;
    /* renamed from: o */
    private int f17750o;

    /* renamed from: com.baidu.location.d.a.e$1 */
    class C32651 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3268e f17728a;

        C32651(C3268e c3268e) {
            this.f17728a = c3268e;
        }

        public void run() {
            C3256a.m13618a().m13637d();
            this.f17728a.m13686b();
        }
    }

    /* renamed from: com.baidu.location.d.a.e$a */
    class C3266a {
        /* renamed from: a */
        public boolean f17729a = false;
        /* renamed from: b */
        Sensor f17730b;
        /* renamed from: c */
        StringBuffer f17731c = null;
        /* renamed from: d */
        int f17732d = 0;
        /* renamed from: e */
        long f17733e = 0;
        /* renamed from: f */
        final /* synthetic */ C3268e f17734f;

        public C3266a(C3268e c3268e, int i) {
            this.f17734f = c3268e;
            try {
                this.f17730b = c3268e.f17739d.getDefaultSensor(i);
            } catch (Exception e) {
                this.f17730b = null;
            }
            if (this.f17730b != null) {
                return;
            }
            if (i == 1 || i == 2 || i == 9) {
                C3256a.f17674a = false;
            }
        }

        /* renamed from: a */
        public void m13678a() {
            if (this.f17734f.f17739d != null && this.f17730b != null && !this.f17729a) {
                try {
                    this.f17734f.f17739d.registerListener(this.f17734f, this.f17730b, this.f17734f.f17750o, this.f17734f.f17745j);
                    this.f17729a = true;
                    this.f17732d = 0;
                    this.f17733e = 0;
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: b */
        public void m13679b() {
            if (this.f17729a) {
                try {
                    this.f17734f.f17739d.unregisterListener(this.f17734f);
                    this.f17729a = false;
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.e$b */
    private static class C3267b {
        /* renamed from: a */
        public static final C3268e f17735a = new C3268e();
    }

    private C3268e() {
        this.f17747l = null;
        this.f17748m = null;
        this.f17749n = false;
        this.f17750o = 1;
        this.f17736a = false;
        this.f17737b = 0;
        this.f17738c = 0;
        try {
            this.f17739d = (SensorManager) C3377f.getServiceContext().getSystemService("sensor");
            this.f17740e = new C3266a(this, 1);
            this.f17741f = new C3266a(this, 2);
            this.f17743h = new C3266a(this, 4);
            this.f17744i = new C3266a(this, 6);
            this.f17742g = new C3266a(this, 9);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static C3268e m13681a() {
        return C3267b.f17735a;
    }

    /* renamed from: a */
    public void m13684a(long j) {
        if (!this.f17736a && C3264d.m13671a(2)) {
            if (this.f17746k == null) {
                this.f17746k = new HandlerThread("map-slam-collector");
                this.f17746k.start();
            }
            if (this.f17745j == null) {
                this.f17745j = new Handler(this.f17746k.getLooper());
            }
            this.f17736a = true;
            this.f17737b = System.currentTimeMillis();
            this.f17747l = new StringBuffer(8192);
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("Tc");
            stringBuffer.append("\t");
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append("\n");
            m13687b(stringBuffer);
            C3376f.m14355a().m14383s();
            this.f17740e.m13678a();
            this.f17741f.m13678a();
            this.f17742g.m13678a();
            this.f17743h.m13678a();
            this.f17744i.m13678a();
            this.f17748m = new C32651(this);
            this.f17745j.postDelayed(this.f17748m, j);
        }
    }

    /* renamed from: a */
    public void m13685a(StringBuffer stringBuffer) {
        m13687b(stringBuffer);
        this.f17738c = System.currentTimeMillis();
    }

    /* renamed from: b */
    public void m13686b() {
        if (this.f17736a) {
            this.f17745j.removeCallbacks(this.f17748m);
            this.f17740e.m13679b();
            this.f17741f.m13679b();
            this.f17742g.m13679b();
            this.f17743h.m13679b();
            this.f17744i.m13679b();
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("Te");
            stringBuffer.append("\t");
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append("\n");
            m13687b(stringBuffer);
            if ((this.f17747l != null && this.f17747l.length() > 200) || this.f17749n) {
                C3264d.m13669a(this.f17747l, new File(C3264d.m13676c(2)));
                this.f17749n = false;
            }
            this.f17747l = null;
            this.f17736a = false;
            try {
                if (this.f17745j != null) {
                    this.f17745j.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
            }
            this.f17745j = null;
            try {
                if (this.f17746k != null) {
                    this.f17746k.quit();
                    this.f17746k.interrupt();
                }
            } catch (Exception e2) {
            }
            this.f17746k = null;
        }
    }

    /* renamed from: b */
    public synchronized void m13687b(StringBuffer stringBuffer) {
        if (this.f17736a && this.f17747l != null) {
            C3264d.m13670a(this.f17747l, stringBuffer, C3264d.m13676c(2));
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        StringBuffer stringBuffer = new StringBuffer(256);
        if (type == 1) {
            C3266a c3266a = this.f17740e;
            c3266a.f17732d++;
            stringBuffer.append("A");
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[1]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[2]);
            if (this.f17740e.f17732d == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
                this.f17740e.f17733e = sensorEvent.timestamp;
            } else {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp - this.f17740e.f17733e);
            }
            if (this.f17740e.f17732d > 13) {
                this.f17740e.f17732d = 0;
            }
            stringBuffer.append("\n");
            m13687b(stringBuffer);
        }
        if (type == 2) {
            c3266a = this.f17741f;
            c3266a.f17732d++;
            stringBuffer.append("M");
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[1]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[2]);
            if (this.f17741f.f17732d == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
                this.f17741f.f17733e = sensorEvent.timestamp;
            } else {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp - this.f17741f.f17733e);
            }
            if (this.f17741f.f17732d > 13) {
                this.f17741f.f17732d = 0;
            }
            stringBuffer.append("\n");
            m13687b(stringBuffer);
        }
        if (type == 9) {
            c3266a = this.f17742g;
            c3266a.f17732d++;
            stringBuffer.append("G");
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[1]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[2]);
            if (this.f17742g.f17732d == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
                this.f17742g.f17733e = sensorEvent.timestamp;
            } else {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp - this.f17742g.f17733e);
            }
            if (this.f17742g.f17732d > 13) {
                this.f17742g.f17732d = 0;
            }
            stringBuffer.append("\n");
            m13687b(stringBuffer);
        }
        if (type == 4) {
            c3266a = this.f17743h;
            c3266a.f17732d++;
            stringBuffer.append(RoutePlanDataStruct.KEY_X);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[1]);
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[2]);
            if (this.f17743h.f17732d == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
                this.f17743h.f17733e = sensorEvent.timestamp;
            } else {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp - this.f17743h.f17733e);
            }
            if (this.f17743h.f17732d > 13) {
                this.f17743h.f17732d = 0;
            }
            stringBuffer.append("\n");
            m13687b(stringBuffer);
        }
        if (type == 6) {
            C3266a c3266a2 = this.f17744i;
            c3266a2.f17732d++;
            stringBuffer.append("P");
            stringBuffer.append("\t");
            stringBuffer.append(sensorEvent.values[0]);
            if (this.f17744i.f17732d == 1) {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp);
                this.f17744i.f17733e = sensorEvent.timestamp;
            } else {
                stringBuffer.append("\t");
                stringBuffer.append(sensorEvent.timestamp - this.f17744i.f17733e);
            }
            if (this.f17744i.f17732d > 13) {
                this.f17744i.f17732d = 0;
            }
            stringBuffer.append("\n");
            m13687b(stringBuffer);
        }
    }
}
