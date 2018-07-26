package com.baidu.location.p191d.p192a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.location.d.a.c */
public class C3263c {
    /* renamed from: A */
    private static boolean f17699A = false;
    /* renamed from: e */
    private static C3262a f17700e = null;
    /* renamed from: z */
    private static int f17701z = 0;
    /* renamed from: a */
    Timer f17702a;
    /* renamed from: b */
    public SensorEventListener f17703b;
    /* renamed from: c */
    int f17704c;
    /* renamed from: d */
    long f17705d;
    /* renamed from: f */
    private SensorManager f17706f;
    /* renamed from: g */
    private boolean f17707g;
    /* renamed from: h */
    private int f17708h;
    /* renamed from: i */
    private Sensor f17709i;
    /* renamed from: j */
    private final long f17710j;
    /* renamed from: k */
    private volatile int f17711k;
    /* renamed from: l */
    private int f17712l;
    /* renamed from: m */
    private float[] f17713m;
    /* renamed from: n */
    private float[] f17714n;
    /* renamed from: o */
    private int f17715o;
    /* renamed from: p */
    private double[] f17716p;
    /* renamed from: q */
    private int f17717q;
    /* renamed from: r */
    private int f17718r;
    /* renamed from: s */
    private double[] f17719s;
    /* renamed from: t */
    private int f17720t;
    /* renamed from: u */
    private double f17721u;
    /* renamed from: v */
    private int f17722v;
    /* renamed from: w */
    private long f17723w;
    /* renamed from: x */
    private int f17724x;
    /* renamed from: y */
    private int f17725y;

    /* renamed from: com.baidu.location.d.a.c$1 */
    class C32601 implements SensorEventListener {
        /* renamed from: a */
        final /* synthetic */ C3263c f17697a;

        C32601(C3263c c3263c) {
            this.f17697a = c3263c;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            switch (sensorEvent.sensor.getType()) {
                case 1:
                    if (this.f17697a.f17704c < 65536) {
                        C3263c c3263c = this.f17697a;
                        c3263c.f17704c++;
                    }
                    float[] fArr = (float[]) sensorEvent.values.clone();
                    this.f17697a.f17714n = (float[]) fArr.clone();
                    fArr = this.f17697a.m13655a(fArr[0], fArr[1], fArr[2]);
                    if (C3263c.m13652a(this.f17697a) >= 20) {
                        double d = (double) ((fArr[2] * fArr[2]) + ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])));
                        if (this.f17697a.f17711k == 0) {
                            if (d > 4.0d) {
                                this.f17697a.f17711k = 1;
                                return;
                            }
                            return;
                        } else if (d < 0.009999999776482582d) {
                            this.f17697a.f17711k = 0;
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.c$2 */
    class C32612 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ C3263c f17698a;

        C32612(C3263c c3263c) {
            this.f17698a = c3263c;
        }

        public void run() {
            this.f17698a.m13662e();
        }
    }

    /* renamed from: com.baidu.location.d.a.c$a */
    public interface C3262a {
        /* renamed from: a */
        void mo2503a(int i);
    }

    private C3263c(Context context, int i, C3262a c3262a) {
        this.f17710j = 30;
        this.f17711k = 0;
        this.f17712l = 1;
        this.f17713m = new float[3];
        this.f17714n = new float[]{0.0f, 0.0f, 0.0f};
        this.f17715o = 31;
        this.f17716p = new double[this.f17715o];
        this.f17717q = 0;
        this.f17719s = new double[6];
        this.f17720t = 0;
        this.f17723w = 0;
        this.f17724x = 0;
        this.f17703b = new C32601(this);
        this.f17704c = 0;
        this.f17705d = 0;
        this.f17725y = BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT;
        this.f17721u = 1.6d;
        this.f17722v = 440;
        f17700e = c3262a;
        try {
            this.f17706f = (SensorManager) context.getSystemService("sensor");
            this.f17708h = i;
            this.f17709i = this.f17706f.getDefaultSensor(1);
        } catch (Exception e) {
        }
    }

    public C3263c(Context context, C3262a c3262a) {
        this(context, 0, c3262a);
    }

    /* renamed from: a */
    private double m13651a(double[] dArr) {
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
    static /* synthetic */ int m13652a(C3263c c3263c) {
        int i = c3263c.f17718r + 1;
        c3263c.f17718r = i;
        return i;
    }

    /* renamed from: a */
    private void m13654a(double d) {
        this.f17719s[this.f17720t % 6] = d;
        this.f17720t++;
        this.f17720t %= 6;
    }

    /* renamed from: a */
    private float[] m13655a(float f, float f2, float f3) {
        float[] fArr = new float[]{(this.f17713m[0] * 0.8f) + (0.19999999f * f), (this.f17713m[1] * 0.8f) + (0.19999999f * f2), (this.f17713m[2] * 0.8f) + (0.19999999f * f3)};
        fArr[0] = f - this.f17713m[0];
        fArr[1] = f2 - this.f17713m[1];
        fArr[2] = f3 - this.f17713m[2];
        return fArr;
    }

    /* renamed from: b */
    private synchronized void m13659b(int i) {
        this.f17712l |= i;
    }

    /* renamed from: b */
    private boolean m13660b(double d) {
        for (int i = 1; i <= 5; i++) {
            if (this.f17719s[((((this.f17720t - 1) - i) + 6) + 6) % 6] - this.f17719s[((this.f17720t - 1) + 6) % 6] > d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private void m13662e() {
        int i = 0;
        f17701z++;
        if (f17699A && f17701z >= this.f17725y) {
            f17700e.mo2503a(999);
        } else if (!f17699A && f17701z == 120) {
            f17700e.mo2503a(888);
        } else if (this.f17718r >= 20) {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = new float[3];
            System.arraycopy(this.f17714n, 0, obj, 0, 3);
            double sqrt = Math.sqrt((double) ((obj[2] * obj[2]) + ((obj[0] * obj[0]) + (obj[1] * obj[1]))));
            this.f17716p[this.f17717q] = sqrt;
            m13654a(sqrt);
            this.f17717q++;
            if (this.f17717q == this.f17715o) {
                this.f17717q = 0;
                sqrt = m13651a(this.f17716p);
                if (this.f17711k != 0 || sqrt >= 0.3d) {
                    m13659b(1);
                    this.f17711k = 1;
                } else {
                    m13659b(0);
                    this.f17711k = 0;
                }
                f17700e.mo2503a(this.f17711k);
                i = 1;
            }
            if (currentTimeMillis - this.f17723w > ((long) this.f17722v) && m13660b(this.f17721u) && f17701z < 120) {
                if (i == 0) {
                    m13659b(1);
                    this.f17711k = 1;
                    f17700e.mo2503a(this.f17711k);
                }
                this.f17724x++;
                this.f17723w = currentTimeMillis;
                f17700e.mo2503a(this.f17724x * 1000);
            }
        }
    }

    /* renamed from: a */
    public void m13663a() {
        m13664a(this.f17725y);
    }

    /* renamed from: a */
    public void m13664a(int i) {
        this.f17725y = i;
        if (!this.f17707g) {
            this.f17704c = 0;
            this.f17705d = System.currentTimeMillis();
            f17701z = 0;
            f17699A = false;
            if (this.f17709i != null) {
                try {
                    this.f17706f.registerListener(this.f17703b, this.f17709i, this.f17708h);
                } catch (Exception e) {
                }
                this.f17702a = new Timer("UpdateData", false);
                this.f17702a.schedule(new C32612(this), 500, 30);
                this.f17707g = true;
            }
        }
    }

    /* renamed from: b */
    public void m13665b() {
        if (this.f17707g) {
            try {
                this.f17706f.unregisterListener(this.f17703b);
            } catch (Exception e) {
            }
            this.f17702a.cancel();
            this.f17702a.purge();
            this.f17702a = null;
            this.f17707g = false;
            f17701z = 0;
            f17699A = false;
            if (this.f17704c < 14) {
                C3256a.f17674a = false;
            }
            this.f17704c = 0;
        }
    }

    /* renamed from: c */
    public boolean m13666c() {
        return this.f17707g;
    }

    /* renamed from: d */
    public void m13667d() {
        f17699A = true;
        f17701z = 0;
    }
}
