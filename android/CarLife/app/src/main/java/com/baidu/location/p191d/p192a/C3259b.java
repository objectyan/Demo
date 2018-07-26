package com.baidu.location.p191d.p192a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.baidu.location.d.a.b */
public class C3259b {
    /* renamed from: b */
    private static C3259b f17688b = null;
    /* renamed from: c */
    private static Context f17689c = null;
    /* renamed from: d */
    private static C3258a f17690d = null;
    /* renamed from: e */
    private static SensorManager f17691e;
    /* renamed from: f */
    private static Sensor f17692f;
    /* renamed from: g */
    private static List<Float> f17693g = new ArrayList();
    /* renamed from: h */
    private static List<Long> f17694h = new ArrayList();
    /* renamed from: i */
    private static int f17695i = -1;
    /* renamed from: a */
    SensorEventListener f17696a = new C32571(this);

    /* renamed from: com.baidu.location.d.a.b$1 */
    class C32571 implements SensorEventListener {
        /* renamed from: a */
        final /* synthetic */ C3259b f17687a;

        C32571(C3259b c3259b) {
            this.f17687a = c3259b;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 6) {
                C3259b.f17693g.add(Float.valueOf(sensorEvent.values[0]));
                C3259b.f17694h.add(Long.valueOf(sensorEvent.timestamp));
                int longValue = (int) ((((Long) C3259b.f17694h.get(C3259b.f17694h.size() - 1)).longValue() - ((Long) C3259b.f17694h.get(0)).longValue()) / 1000000000);
                if (C3259b.m13645e() >= 1) {
                    C3259b.f17693g.remove(0);
                    C3259b.f17694h.remove(0);
                }
                if (longValue >= 6 && C3259b.f17695i <= 0) {
                    if (((double) Math.abs(this.f17687a.m13640a(C3259b.f17693g, 0, C3259b.f17693g.size() / 2) - this.f17687a.m13640a(C3259b.f17693g, C3259b.f17693g.size() / 2, C3259b.f17693g.size() - 1))) > 0.04d) {
                        C3259b.f17690d.mo2502a(100);
                    } else {
                        C3259b.f17690d.mo2502a(111);
                    }
                    C3259b.f17695i = 50;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.b$a */
    public interface C3258a {
        /* renamed from: a */
        void mo2502a(int i);
    }

    /* renamed from: a */
    private float m13640a(List<Float> list, int i, int i2) {
        List arrayList = new ArrayList();
        while (i <= i2) {
            arrayList.add(list.get(i));
            i++;
        }
        Collections.sort(arrayList);
        return ((Float) arrayList.get(arrayList.size() / 2)).floatValue();
    }

    /* renamed from: a */
    public static C3259b m13642a(Context context, C3258a c3258a) {
        if (f17688b == null) {
            f17688b = new C3259b();
            f17689c = context;
            if (f17691e == null) {
                f17691e = (SensorManager) f17689c.getSystemService("sensor");
            }
            if (f17692f == null) {
                f17692f = f17691e.getDefaultSensor(6);
            }
            f17695i = -1;
            f17690d = c3258a;
        }
        return f17688b;
    }

    /* renamed from: e */
    static /* synthetic */ int m13645e() {
        int i = f17695i;
        f17695i = i - 1;
        return i;
    }

    /* renamed from: a */
    public void m13648a() {
        try {
            f17691e.registerListener(this.f17696a, f17692f, 1);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public void m13649b() {
        try {
            f17691e.unregisterListener(this.f17696a, f17692f);
        } catch (Exception e) {
        }
        f17693g.clear();
        f17694h.clear();
    }
}
