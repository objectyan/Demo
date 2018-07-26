package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.location.indoor.h */
public class C3447h {
    /* renamed from: A */
    private double f18643A;
    /* renamed from: B */
    private double f18644B;
    /* renamed from: C */
    private double f18645C;
    /* renamed from: D */
    private double f18646D;
    /* renamed from: E */
    private double f18647E;
    /* renamed from: F */
    private double f18648F;
    /* renamed from: G */
    private double f18649G;
    /* renamed from: H */
    private int f18650H;
    /* renamed from: I */
    private float f18651I;
    /* renamed from: J */
    private int f18652J;
    /* renamed from: K */
    private int f18653K;
    /* renamed from: L */
    private double[] f18654L;
    /* renamed from: M */
    private boolean f18655M;
    /* renamed from: a */
    Timer f18656a;
    /* renamed from: b */
    public SensorEventListener f18657b;
    /* renamed from: c */
    private C3426a f18658c;
    /* renamed from: d */
    private SensorManager f18659d;
    /* renamed from: e */
    private boolean f18660e;
    /* renamed from: f */
    private int f18661f;
    /* renamed from: g */
    private Sensor f18662g;
    /* renamed from: h */
    private Sensor f18663h;
    /* renamed from: i */
    private final long f18664i;
    /* renamed from: j */
    private volatile int f18665j;
    /* renamed from: k */
    private int f18666k;
    /* renamed from: l */
    private float[] f18667l;
    /* renamed from: m */
    private float[] f18668m;
    /* renamed from: n */
    private double[] f18669n;
    /* renamed from: o */
    private int f18670o;
    /* renamed from: p */
    private double[] f18671p;
    /* renamed from: q */
    private int f18672q;
    /* renamed from: r */
    private int f18673r;
    /* renamed from: s */
    private int f18674s;
    /* renamed from: t */
    private double[] f18675t;
    /* renamed from: u */
    private int f18676u;
    /* renamed from: v */
    private double f18677v;
    /* renamed from: w */
    private int f18678w;
    /* renamed from: x */
    private long f18679x;
    /* renamed from: y */
    private int f18680y;
    /* renamed from: z */
    private int f18681z;

    /* renamed from: com.baidu.location.indoor.h$a */
    public interface C3426a {
        /* renamed from: a */
        void mo2519a(double d, double d2);
    }

    /* renamed from: com.baidu.location.indoor.h$1 */
    class C34451 implements SensorEventListener {
        /* renamed from: a */
        final /* synthetic */ C3447h f18641a;

        C34451(C3447h c3447h) {
            this.f18641a = c3447h;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr;
            switch (sensorEvent.sensor.getType()) {
                case 1:
                    fArr = (float[]) sensorEvent.values.clone();
                    this.f18641a.f18668m = (float[]) fArr.clone();
                    fArr = this.f18641a.m14771a(fArr[0], fArr[1], fArr[2]);
                    if (C3447h.m14766a(this.f18641a) >= 20) {
                        double d = (double) ((fArr[2] * fArr[2]) + ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])));
                        if (this.f18641a.f18665j == 0) {
                            if (d > 4.0d) {
                                this.f18641a.f18665j = 1;
                                return;
                            }
                            return;
                        } else if (d < 0.009999999776482582d) {
                            this.f18641a.f18665j = 0;
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 3:
                    fArr = (float[]) sensorEvent.values.clone();
                    this.f18641a.f18654L[this.f18641a.f18653K] = (double) fArr[0];
                    this.f18641a.f18653K = this.f18641a.f18653K + 1;
                    if (this.f18641a.f18653K == this.f18641a.f18652J) {
                        this.f18641a.f18653K = 0;
                    }
                    if (C3447h.m14782g(this.f18641a) >= 20) {
                        this.f18641a.f18655M = this.f18641a.m14781f();
                        if (!this.f18641a.f18655M) {
                            this.f18641a.f18659d.unregisterListener(this.f18641a.f18657b, this.f18641a.f18663h);
                        }
                        this.f18641a.f18669n[0] = this.f18641a.m14763a(this.f18641a.f18669n[0], (double) fArr[0], 0.7d);
                        this.f18641a.f18669n[1] = (double) fArr[1];
                        this.f18641a.f18669n[2] = (double) fArr[2];
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.indoor.h$2 */
    class C34462 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ C3447h f18642a;

        C34462(C3447h c3447h) {
            this.f18642a = c3447h;
        }

        public void run() {
            try {
                this.f18642a.m14783g();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private C3447h(Context context, int i) {
        this.f18664i = 30;
        this.f18665j = 1;
        this.f18666k = 1;
        this.f18667l = new float[3];
        this.f18668m = new float[]{0.0f, 0.0f, 0.0f};
        this.f18669n = new double[]{0.0d, 0.0d, 0.0d};
        this.f18670o = 31;
        this.f18671p = new double[this.f18670o];
        this.f18672q = 0;
        this.f18675t = new double[6];
        this.f18676u = 0;
        this.f18679x = 0;
        this.f18680y = 0;
        this.f18681z = 0;
        this.f18643A = 0.0d;
        this.f18644B = 0.0d;
        this.f18645C = 100.0d;
        this.f18646D = 0.5d;
        this.f18647E = this.f18646D;
        this.f18648F = 0.85d;
        this.f18649G = 0.42d;
        this.f18650H = -1;
        this.f18651I = 0.0f;
        this.f18652J = 20;
        this.f18653K = 0;
        this.f18654L = new double[this.f18652J];
        this.f18655M = false;
        this.f18657b = new C34451(this);
        this.f18677v = 1.6d;
        this.f18678w = 440;
        try {
            this.f18659d = (SensorManager) context.getSystemService("sensor");
            this.f18661f = i;
            this.f18662g = this.f18659d.getDefaultSensor(1);
            this.f18663h = this.f18659d.getDefaultSensor(3);
        } catch (Exception e) {
        }
    }

    public C3447h(Context context, C3426a c3426a) {
        this(context, 1);
        this.f18658c = c3426a;
    }

    /* renamed from: a */
    private double m14763a(double d, double d2, double d3) {
        double d4 = d2 - d;
        if (d4 < -180.0d) {
            d4 += 360.0d;
        } else if (d4 > 180.0d) {
            d4 -= 360.0d;
        }
        return (d4 * d3) + d;
    }

    /* renamed from: a */
    private double m14765a(double[] dArr) {
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        d2 /= (double) r6;
        while (i < r6) {
            d += (dArr[i] - d2) * (dArr[i] - d2);
            i++;
        }
        return d / ((double) (r6 - 1));
    }

    /* renamed from: a */
    static /* synthetic */ int m14766a(C3447h c3447h) {
        int i = c3447h.f18673r + 1;
        c3447h.f18673r = i;
        return i;
    }

    /* renamed from: a */
    private void m14768a(double d) {
        this.f18675t[this.f18676u % 6] = d;
        this.f18676u++;
        this.f18676u %= 6;
    }

    /* renamed from: a */
    private synchronized void m14769a(int i) {
        this.f18666k |= i;
    }

    /* renamed from: a */
    private float[] m14771a(float f, float f2, float f3) {
        float[] fArr = new float[]{(this.f18667l[0] * 0.8f) + (0.19999999f * f), (this.f18667l[1] * 0.8f) + (0.19999999f * f2), (this.f18667l[2] * 0.8f) + (0.19999999f * f3)};
        fArr[0] = f - this.f18667l[0];
        fArr[1] = f2 - this.f18667l[1];
        fArr[2] = f3 - this.f18667l[2];
        return fArr;
    }

    /* renamed from: b */
    private boolean m14776b(double d) {
        for (int i = 1; i <= 5; i++) {
            if (this.f18675t[((((this.f18676u - 1) - i) + 6) + 6) % 6] - this.f18675t[((this.f18676u - 1) + 6) % 6] > d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private boolean m14781f() {
        for (int i = 0; i < this.f18652J; i++) {
            if (this.f18654L[i] > 1.0E-7d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    static /* synthetic */ int m14782g(C3447h c3447h) {
        int i = c3447h.f18674s + 1;
        c3447h.f18674s = i;
        return i;
    }

    /* renamed from: g */
    private void m14783g() {
        if (this.f18673r >= 20) {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = new float[3];
            System.arraycopy(this.f18668m, 0, obj, 0, 3);
            Object obj2 = new double[3];
            System.arraycopy(this.f18669n, 0, obj2, 0, 3);
            double sqrt = Math.sqrt((double) ((obj[2] * obj[2]) + ((obj[0] * obj[0]) + (obj[1] * obj[1]))));
            this.f18671p[this.f18672q] = sqrt;
            m14768a(sqrt);
            this.f18681z++;
            if (sqrt > this.f18644B) {
                this.f18644B = sqrt;
            } else if (sqrt < this.f18645C) {
                this.f18645C = sqrt;
            }
            this.f18672q++;
            if (this.f18672q == this.f18670o) {
                this.f18672q = 0;
                double a = m14765a(this.f18671p);
                if (this.f18665j != 0 || a >= 0.3d) {
                    m14769a(1);
                    this.f18665j = 1;
                } else {
                    m14769a(0);
                    this.f18665j = 0;
                }
            }
            if (currentTimeMillis - this.f18679x > ((long) this.f18678w) && m14776b(this.f18677v)) {
                this.f18680y++;
                this.f18679x = currentTimeMillis;
                double d = obj2[0];
                if (this.f18681z >= 40 || this.f18681z <= 0) {
                    this.f18647E = this.f18646D;
                } else {
                    this.f18647E = Math.sqrt(Math.sqrt(this.f18644B - this.f18645C)) * this.f18649G;
                    if (this.f18647E > this.f18648F) {
                        this.f18647E = this.f18648F;
                    } else if (this.f18647E < this.f18646D) {
                        this.f18647E = this.f18646D;
                    }
                }
                d += (double) this.f18651I;
                if (d > 360.0d) {
                    d -= 360.0d;
                }
                if (d < 0.0d) {
                    d += 360.0d;
                }
                this.f18681z = 1;
                this.f18644B = sqrt;
                this.f18645C = sqrt;
                if (this.f18655M) {
                    this.f18658c.mo2519a(this.f18647E, d);
                }
            }
        }
    }

    /* renamed from: a */
    public void m14790a() {
        if (!this.f18660e) {
            if (this.f18662g != null) {
                try {
                    this.f18659d.registerListener(this.f18657b, this.f18662g, this.f18661f);
                } catch (Exception e) {
                }
                this.f18656a = new Timer("UpdateData", false);
                this.f18656a.schedule(new C34462(this), 500, 30);
                this.f18660e = true;
            }
            if (this.f18663h != null) {
                try {
                    this.f18659d.registerListener(this.f18657b, this.f18663h, this.f18661f);
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: b */
    public void m14791b() {
        if (this.f18660e) {
            try {
                this.f18659d.unregisterListener(this.f18657b);
            } catch (Exception e) {
            }
            this.f18656a.cancel();
            this.f18656a.purge();
            this.f18656a = null;
            this.f18660e = false;
        }
    }

    /* renamed from: c */
    public synchronized int m14792c() {
        return this.f18673r < 20 ? 1 : this.f18666k;
    }

    /* renamed from: d */
    public synchronized int m14793d() {
        return this.f18673r < 20 ? -1 : this.f18680y;
    }

    /* renamed from: e */
    public synchronized void m14794e() {
        this.f18666k = 0;
    }
}
