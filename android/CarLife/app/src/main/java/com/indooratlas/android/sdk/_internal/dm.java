package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class dm implements db {
    /* renamed from: a */
    static final /* synthetic */ boolean f23419a = (!dm.class.desiredAssertionStatus());
    /* renamed from: b */
    private SensorManager f23420b;
    /* renamed from: c */
    private final HashMap<cy, C5850a> f23421c;

    /* renamed from: com.indooratlas.android.sdk._internal.dm$a */
    static class C5850a {
        /* renamed from: a */
        SensorEventListener f23415a;
        /* renamed from: b */
        ArrayList<cw> f23416b = new ArrayList();

        C5850a() {
        }

        public final String toString() {
            return "ListenerEntry{listener=" + this.f23415a + ", sensors=" + this.f23416b + '}';
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.dm$b */
    static class C5851b implements SensorEventListener {
        /* renamed from: a */
        cy f23417a;
        /* renamed from: b */
        cw f23418b;

        C5851b(cy cyVar, cw cwVar) {
            this.f23417a = cyVar;
            this.f23418b = cwVar;
        }

        public final void onSensorChanged(SensorEvent event) {
            if (event == null) {
                ee.m20409a(cz.f23362a, "received null hardware sensor event", new Object[0]);
            } else {
                this.f23417a.mo4657a(dm.m20334a(event));
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public dm(Context context) {
        this((SensorManager) context.getSystemService("sensor"));
    }

    private dm(SensorManager sensorManager) {
        this.f23421c = new HashMap();
        this.f23420b = sensorManager;
    }

    /* renamed from: a */
    public final void mo4665a(cy cyVar, cw cwVar, da daVar) {
        if (!f23419a && cyVar == null) {
            throw new AssertionError("listener must be non null");
        } else if (f23419a || cwVar != null) {
            synchronized (this.f23421c) {
                C5850a b = m20336b(cyVar, cwVar);
                if (b != null) {
                    Sensor sensor = ((dn) cwVar).f23422a;
                    int i = daVar.f23374c;
                    String str;
                    Object[] objArr;
                    if (daVar.f23372a != null) {
                        str = cz.f23362a;
                        objArr = new Object[]{Integer.valueOf(sensor.getType()), Integer.valueOf(i)};
                        this.f23420b.registerListener(b.f23415a, sensor, i, daVar.f23372a);
                    } else {
                        str = cz.f23362a;
                        objArr = new Object[]{Integer.valueOf(sensor.getType()), Integer.valueOf(i)};
                        this.f23420b.registerListener(b.f23415a, sensor, i);
                    }
                }
            }
        } else {
            throw new AssertionError("sensor must be non null");
        }
    }

    /* renamed from: a */
    public final void mo4663a(cy cyVar) {
        synchronized (this.f23421c) {
            C5850a c5850a = (C5850a) this.f23421c.remove(cyVar);
            if (c5850a != null) {
                String str = cz.f23362a;
                new Object[1][0] = cyVar;
                this.f23420b.unregisterListener(c5850a.f23415a);
            } else {
                String str2 = cz.f23362a;
                new Object[1][0] = cyVar;
            }
        }
    }

    /* renamed from: a */
    public final void mo4664a(cy cyVar, cw cwVar) {
        synchronized (this.f23421c) {
            C5850a c5850a = (C5850a) this.f23421c.get(cyVar);
            if (c5850a != null) {
                Iterator it = c5850a.f23416b.iterator();
                while (it.hasNext()) {
                    if (cwVar.mo4658a() == ((cw) it.next()).mo4658a()) {
                        Sensor sensor = ((dn) cwVar).f23422a;
                        String str = cz.f23362a;
                        Object[] objArr = new Object[]{cyVar, sensor};
                        this.f23420b.unregisterListener(c5850a.f23415a, sensor);
                        it.remove();
                    }
                }
                if (c5850a.f23416b.isEmpty()) {
                    this.f23421c.remove(cyVar);
                }
            }
        }
    }

    /* renamed from: a */
    public final cw mo4660a(int i) {
        Sensor defaultSensor = this.f23420b.getDefaultSensor(m20337c(i));
        return defaultSensor != null ? dn.m20344a(defaultSensor) : null;
    }

    /* renamed from: a */
    public final List<cw> mo4661a() {
        List<Sensor> sensorList = this.f23420b.getSensorList(m20337c(-1));
        List arrayList = new ArrayList(sensorList.size());
        for (Sensor sensor : sensorList) {
            if (m20335b(sensor.getType()) != 0) {
                arrayList.add(new dn(sensor));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final List<cx> mo4662a(cw cwVar) {
        return null;
    }

    @TargetApi(14)
    /* renamed from: c */
    private static int m20337c(int i) {
        switch (i) {
            case -1:
                return -1;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return VERSION.SDK_INT >= 14 ? 12 : 0;
            case 13:
                return VERSION.SDK_INT >= 14 ? 13 : 0;
            case 14:
                if (VERSION.SDK_INT < 18) {
                    return 0;
                }
                return 14;
            case 15:
                return VERSION.SDK_INT >= 18 ? 15 : 0;
            case 16:
                return VERSION.SDK_INT >= 18 ? 16 : 0;
            case 17:
                return VERSION.SDK_INT >= 18 ? 17 : 0;
            case 18:
                return VERSION.SDK_INT >= 19 ? 18 : 0;
            case 19:
                return VERSION.SDK_INT >= 19 ? 19 : 0;
            case 20:
                return VERSION.SDK_INT >= 19 ? 20 : 0;
            case 21:
                return VERSION.SDK_INT >= 20 ? 21 : 0;
            case 22:
                return 22;
            case 23:
                return 23;
            case 24:
                return 24;
            case 25:
                return 25;
            case 26:
                return 26;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static int m20335b(int i) {
        switch (i) {
            case -1:
                return -1;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 22:
                return 22;
            case 23:
                return 23;
            case 24:
                return 24;
            case 25:
                return 25;
            case 26:
                return 26;
            default:
                if (VERSION.SDK_INT >= 14) {
                    switch (i) {
                        case 12:
                            return 12;
                        case 13:
                            return 13;
                    }
                }
                if (VERSION.SDK_INT >= 18) {
                    switch (i) {
                        case 14:
                            return 14;
                        case 15:
                            return 15;
                        case 16:
                            return 16;
                        case 17:
                            return 17;
                    }
                }
                if (VERSION.SDK_INT >= 19) {
                    switch (i) {
                        case 18:
                            return 18;
                        case 19:
                            return 19;
                        case 20:
                            return 20;
                    }
                }
                if (VERSION.SDK_INT >= 20) {
                    switch (i) {
                        case 21:
                            return 21;
                    }
                }
                return 0;
        }
    }

    /* renamed from: b */
    private C5850a m20336b(cy cyVar, cw cwVar) {
        C5850a c5850a = (C5850a) this.f23421c.get(cyVar);
        if (c5850a != null) {
            Iterator it = c5850a.f23416b.iterator();
            while (it.hasNext()) {
                if (cwVar.equals((cw) it.next())) {
                    Log.i(cz.f23362a, "already registered listener: " + cyVar + " for sensor: " + cwVar);
                    return null;
                }
            }
        }
        c5850a = new C5850a();
        c5850a.f23415a = new C5851b(cyVar, cwVar);
        this.f23421c.put(cyVar, c5850a);
        c5850a.f23416b.add(cwVar);
        return c5850a;
    }

    /* renamed from: a */
    public static cx m20334a(SensorEvent sensorEvent) {
        cx cxVar = new cx();
        cxVar.f23361d = SystemClock.elapsedRealtime();
        cxVar.f23359b = sensorEvent.timestamp;
        cxVar.f23358a = dn.m20344a(sensorEvent.sensor);
        C5852do c5852do = new C5852do();
        c5852do.f23423a = sensorEvent.accuracy;
        c5852do.f23424b = sensorEvent.sensor.getType();
        c5852do.f23425c = sensorEvent.timestamp;
        c5852do.f23426d = new float[sensorEvent.values.length];
        System.arraycopy(sensorEvent.values, 0, c5852do.f23426d, 0, sensorEvent.values.length);
        cxVar.f23360c = c5852do;
        return cxVar;
    }
}
