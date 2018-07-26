package com.baidu.location.p190c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3192e;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3380a;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p191d.C3299f;
import com.baidu.location.p191d.C3301g;
import com.baidu.location.p193e.C3349d;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.baidu.location.c.b */
public class C3243b {
    /* renamed from: i */
    private static Object f17622i = new Object();
    /* renamed from: j */
    private static C3243b f17623j = null;
    /* renamed from: a */
    ConcurrentHashMap<String, C3239c> f17624a = new ConcurrentHashMap();
    /* renamed from: b */
    ConcurrentHashMap<String, C3239c> f17625b = new ConcurrentHashMap();
    /* renamed from: c */
    ConcurrentHashMap<String, C3239c> f17626c = new ConcurrentHashMap();
    /* renamed from: d */
    ConcurrentHashMap<String, C3239c> f17627d = new ConcurrentHashMap();
    /* renamed from: e */
    C3240d f17628e = new C3240d(this);
    /* renamed from: f */
    C3242f f17629f = new C3242f(this);
    /* renamed from: g */
    C3241e f17630g = new C3241e(this);
    /* renamed from: h */
    private String f17631h = "http://ofloc.map.baidu.com/offline_loc";
    /* renamed from: k */
    private final SQLiteDatabase f17632k;
    /* renamed from: l */
    private String f17633l = null;
    /* renamed from: m */
    private int f17634m = 0;
    /* renamed from: n */
    private Handler f17635n = null;
    /* renamed from: o */
    private boolean f17636o = false;
    /* renamed from: p */
    private C3238b f17637p = null;
    /* renamed from: q */
    private BDLocation f17638q = null;

    /* renamed from: com.baidu.location.c.b$1 */
    class C32331 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3243b f17578a;

        C32331(C3243b c3243b) {
            this.f17578a = c3243b;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (C3192e.m13329a().m13341d() == 0 && this.f17578a.f17633l != null) {
                        this.f17578a.m13586c();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.c.b$2 */
    class C32342 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3243b f17579a;

        C32342(C3243b c3243b) {
            this.f17579a = c3243b;
        }

        public void run() {
            if (C3192e.m13329a().m13341d() == 0 && this.f17579a.f17633l != null && this.f17579a.f17630g != null) {
                this.f17579a.f17630g.mo2500b();
            }
        }
    }

    /* renamed from: com.baidu.location.c.b$a */
    private static final class C3237a {
        /* renamed from: a */
        double f17586a;
        /* renamed from: b */
        double f17587b;
        /* renamed from: c */
        double f17588c;

        private C3237a(double d, double d2, double d3) {
            this.f17586a = d;
            this.f17587b = d2;
            this.f17588c = d3;
        }
    }

    /* renamed from: com.baidu.location.c.b$b */
    private class C3238b {
        /* renamed from: a */
        public BDLocation f17589a;
        /* renamed from: b */
        public String f17590b;
        /* renamed from: c */
        public int f17591c;
        /* renamed from: d */
        final /* synthetic */ C3243b f17592d;

        C3238b(C3243b c3243b, BDLocation bDLocation, String str, int i) {
            this.f17592d = c3243b;
            this.f17589a = bDLocation;
            this.f17590b = str;
            this.f17591c = i;
        }
    }

    /* renamed from: com.baidu.location.c.b$c */
    private class C3239c {
        /* renamed from: a */
        public int f17593a = 0;
        /* renamed from: b */
        public int f17594b = 0;
        /* renamed from: c */
        public String f17595c = null;
        /* renamed from: d */
        public final int f17596d;
        /* renamed from: e */
        public final int f17597e;
        /* renamed from: f */
        public final int f17598f;
        /* renamed from: g */
        public final int f17599g;
        /* renamed from: h */
        final /* synthetic */ C3243b f17600h;

        C3239c(C3243b c3243b, String str, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f17600h = c3243b;
            this.f17595c = str;
            this.f17593a = i;
            this.f17594b = i2;
            this.f17596d = i3;
            this.f17597e = i4;
            this.f17598f = i5;
            this.f17599g = i6;
        }

        /* renamed from: a */
        public Location m13566a(int i) {
            Location location = new Location("temp");
            int i2 = this.f17594b * this.f17597e;
            int i3 = this.f17593a * this.f17597e;
            double d = ((double) ((((i & 65535) * this.f17597e) / 65535) + i3)) / 100000.0d;
            location.setLatitude(((double) (((((i >> 16) & 65535) * this.f17597e) / 65535) + i2)) / 100000.0d);
            location.setLongitude(d);
            return location;
        }
    }

    /* renamed from: com.baidu.location.c.b$d */
    private final class C3240d extends C3186e {
        /* renamed from: a */
        public boolean f17601a;
        /* renamed from: b */
        final /* synthetic */ C3243b f17602b;
        /* renamed from: c */
        private int f17603c;
        /* renamed from: d */
        private int f17604d;
        /* renamed from: e */
        private int f17605e;
        /* renamed from: f */
        private int f17606f;
        /* renamed from: p */
        private double f17607p;
        /* renamed from: q */
        private double f17608q;
        /* renamed from: r */
        private int f17609r;
        /* renamed from: s */
        private boolean f17610s;

        public C3240d(C3243b c3243b) {
            this.f17602b = c3243b;
            this.f17601a = false;
            this.f17603c = 0;
            this.f17604d = 0;
            this.f17605e = 0;
            this.f17606f = 0;
            this.f17607p = 0.0d;
            this.f17608q = 0.0d;
            this.f17609r = 0;
            this.f17610s = false;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = this.f17602b.f17631h;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("&qt=grid");
            if (this.f17605e == 1) {
                stringBuffer.append("&tp=gdg");
                stringBuffer.append("&clg=");
                stringBuffer.append(String.format(Locale.US, "%d|%d", new Object[]{Integer.valueOf(this.f17603c), Integer.valueOf(this.f17604d)}));
            } else {
                stringBuffer.append("&tp=gdl");
                stringBuffer.append("&datp=c");
                stringBuffer.append("&loc=");
                stringBuffer.append(String.format(Locale.US, "%.6f|%.6f", new Object[]{Double.valueOf(this.f17608q), Double.valueOf(this.f17607p)}));
            }
            stringBuffer.append("&ct=");
            stringBuffer.append(this.f17602b.f17633l);
            stringBuffer.append(C3381b.m14398a().m14408g());
            stringBuffer.append("&vkey=0");
            String stringBuffer2 = stringBuffer.toString();
            this.k.put("qt", "grid");
            this.k.put("req", Jni.encode(stringBuffer2));
        }

        /* renamed from: a */
        public void m13568a(double d, double d2, int i, int i2, int i3, int i4) {
            if (this.f17602b.f17633l != null && !this.f17601a && !this.f17610s) {
                this.f17601a = true;
                this.f17607p = d;
                this.f17608q = d2;
                this.f17603c = i2;
                this.f17604d = i3;
                this.f17605e = i;
                this.f17609r = i4;
                m13298a(false, "ofloc.map.baidu.com");
            }
        }

        /* renamed from: a */
        public void m13569a(int i, int i2, int i3, int i4) {
            if (this.f17602b.f17633l != null && !this.f17601a && !this.f17610s) {
                this.f17601a = true;
                this.f17603c = i;
                this.f17604d = i2;
                this.f17605e = i3;
                this.f17609r = i4;
                m13298a(false, "ofloc.map.baidu.com");
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo2495a(boolean r20) {
            /*
            r19 = this;
            r3 = 0;
            r5 = 0;
            r4 = 0;
            r11 = 0;
            r7 = 0;
            if (r20 == 0) goto L_0x03c6;
        L_0x0007:
            r0 = r19;
            r2 = r0.j;
            if (r2 == 0) goto L_0x03c6;
        L_0x000d:
            r0 = r19;
            r6 = r0.j;
            r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01ac }
            r2.<init>(r6);	 Catch:{ JSONException -> 0x01ac }
        L_0x0016:
            if (r2 == 0) goto L_0x01b7;
        L_0x0018:
            r5 = "model";
            r5 = r2.has(r5);
            if (r5 == 0) goto L_0x01b7;
        L_0x0021:
            r5 = "model";
            r2 = r2.getJSONObject(r5);	 Catch:{ JSONException -> 0x01b3 }
            r6 = r2;
        L_0x0029:
            if (r4 != 0) goto L_0x004d;
        L_0x002b:
            r2 = java.util.Locale.US;
            r3 = "CL_%d_%d";
            r4 = 2;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r0 = r19;
            r8 = r0.f17603c;
            r8 = java.lang.Integer.valueOf(r8);
            r4[r5] = r8;
            r5 = 1;
            r0 = r19;
            r8 = r0.f17604d;
            r8 = java.lang.Integer.valueOf(r8);
            r4[r5] = r8;
            r4 = java.lang.String.format(r2, r3, r4);
        L_0x004d:
            r0 = r19;
            r2 = r0.f17602b;	 Catch:{ Exception -> 0x03c0, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x03c0, all -> 0x0385 }
            r2.beginTransaction();	 Catch:{ Exception -> 0x03c0, all -> 0x0385 }
        L_0x0058:
            if (r6 == 0) goto L_0x006a;
        L_0x005a:
            r2 = "ver";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 == 0) goto L_0x006a;
        L_0x0063:
            r2 = "ver";
            r7 = r6.getInt(r2);	 Catch:{ Exception -> 0x03bd, all -> 0x0385 }
        L_0x006a:
            r8 = 0;
            if (r6 == 0) goto L_0x007d;
        L_0x006d:
            r2 = "cell_len";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 == 0) goto L_0x007d;
        L_0x0076:
            r2 = "cell_len";
            r8 = r6.getInt(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
        L_0x007d:
            if (r8 == 0) goto L_0x008a;
        L_0x007f:
            r0 = r19;
            r2 = r0.f17609r;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r8 == r2) goto L_0x008a;
        L_0x0085:
            r2 = 1;
            r0 = r19;
            r0.f17610s = r2;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
        L_0x008a:
            if (r8 <= 0) goto L_0x031b;
        L_0x008c:
            r0 = r19;
            r2 = r0.f17610s;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 != 0) goto L_0x031b;
        L_0x0092:
            if (r6 == 0) goto L_0x031b;
        L_0x0094:
            r2 = "cell";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 == 0) goto L_0x031b;
        L_0x009d:
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "CREATE TABLE IF NOT EXISTS ";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = " (id LONG PRIMARY KEY,x INT);";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = "DELETE FROM ";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = ";";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r5 = r0.f17602b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r5 == 0) goto L_0x00f3;
        L_0x00dd:
            r0 = r19;
            r5 = r0.f17602b;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r5.execSQL(r2);	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r0 = r19;
            r2 = r0.f17602b;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
        L_0x00f3:
            r2 = "cell";
            r2 = r6.getString(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = ";";
            r9 = r2.split(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r10 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r10.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = 1;
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "INSERT OR REPLACE INTO ";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = " (id,x) VALUES %s;";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r12 = r2.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = 0;
            r13 = r9.length;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = 0;
            r18 = r2;
            r2 = r3;
            r3 = r5;
            r5 = r18;
        L_0x012b:
            if (r5 >= r13) goto L_0x0236;
        L_0x012d:
            r14 = r9[r5];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = "|";
            r15 = r14.contains(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r15 == 0) goto L_0x01a9;
        L_0x0138:
            r15 = "\\|";
            r14 = r14.split(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = r14.length;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 2;
            r0 = r16;
            if (r15 != r0) goto L_0x01a9;
        L_0x0146:
            r15 = 0;
            r15 = r14[r15];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 1;
            r14 = r14[r16];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r3 == 0) goto L_0x01ba;
        L_0x014f:
            r3 = 0;
        L_0x0150:
            r16 = 40;
            r0 = r16;
            r16 = r10.append(r0);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r16;
            r15 = r0.append(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 44;
            r15 = r15.append(r16);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r17 = "";
            r16 = r16.append(r17);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r16;
            r14 = r0.append(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = r15.append(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = 41;
            r14.append(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2 + 1;
            r14 = 100;
            if (r2 < r14) goto L_0x01a9;
        L_0x0189:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = 1;
            r14 = new java.lang.Object[r14];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = 0;
            r16 = r10.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14[r15] = r16;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = java.lang.String.format(r12, r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3.execSQL(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = 1;
            r14 = 0;
            r10.setLength(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2 + -100;
        L_0x01a9:
            r5 = r5 + 1;
            goto L_0x012b;
        L_0x01ac:
            r2 = move-exception;
            r2.printStackTrace();
            r2 = r5;
            goto L_0x0016;
        L_0x01b3:
            r2 = move-exception;
            r2.printStackTrace();
        L_0x01b7:
            r6 = r3;
            goto L_0x0029;
        L_0x01ba:
            r16 = 44;
            r0 = r16;
            r10.append(r0);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            goto L_0x0150;
        L_0x01c2:
            r2 = move-exception;
            r2 = r11;
        L_0x01c4:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b1 }
            if (r3 == 0) goto L_0x01e7;
        L_0x01ce:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x03b1 }
            if (r3 == 0) goto L_0x01e7;
        L_0x01dc:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b1 }
            r3.endTransaction();	 Catch:{ Exception -> 0x03b1 }
        L_0x01e7:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
        L_0x01ec:
            r0 = r19;
            r3 = r0.f17606f;
            r3 = r3 + 1;
            r0 = r19;
            r0.f17606f = r3;
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            r0 = r19;
            r3 = r0.k;
            r3.clear();
            r0 = r19;
            r3 = r0.f17606f;
            r3 = r3 % 3;
            r4 = 1;
            if (r3 != r4) goto L_0x020e;
        L_0x020b:
            java.lang.System.gc();
        L_0x020e:
            r3 = 0;
            r0 = r19;
            r0.f17601a = r3;
            if (r2 == 0) goto L_0x0235;
        L_0x0215:
            r0 = r19;
            r2 = r0.f17602b;
            r2 = r2.f17635n;
            if (r2 == 0) goto L_0x0235;
        L_0x021f:
            r2 = com.baidu.location.p187a.C3181a.m13265a();
            r2 = r2.m13278c();
            if (r2 == 0) goto L_0x0235;
        L_0x0229:
            r0 = r19;
            r2 = r0.f17602b;
            r2 = r2.f17635n;
            r3 = 1;
            r2.sendEmptyMessage(r3);
        L_0x0235:
            return;
        L_0x0236:
            if (r2 <= 0) goto L_0x0251;
        L_0x0238:
            r0 = r19;
            r2 = r0.f17602b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = 0;
            r9 = r10.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3[r5] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = java.lang.String.format(r12, r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
        L_0x0251:
            r0 = r19;
            r2 = r0.f17610s;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 != 0) goto L_0x03c3;
        L_0x0257:
            if (r6 == 0) goto L_0x03c3;
        L_0x0259:
            r2 = java.util.Locale.US;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "INSERT OR REPLACE INTO CL VALUES (\"%s\",%d,%d,%d,%d,%d,%d);";
            r5 = 7;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 0;
            r5[r6] = r4;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 1;
            r0 = r19;
            r9 = r0.f17603c;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 2;
            r0 = r19;
            r9 = r0.f17604d;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 3;
            r9 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 4;
            r9 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 5;
            r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r12 = r12 / r14;
            r9 = (int) r12;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 6;
            r0 = r19;
            r9 = r0.f17605e;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r12 = java.lang.String.format(r2, r3, r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = new com.baidu.location.c.b$c;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r5 = r0.f17603c;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r6 = r0.f17604d;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r14 = r14 / r16;
            r9 = (int) r14;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r10 = r0.f17605e;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3.execSQL(r12);	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3 = r3.f17625b;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r4 = r2.f17595c;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3.put(r4, r2);	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r11 = 1;
            r2 = r11;
        L_0x02dc:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            if (r3 == 0) goto L_0x02f1;
        L_0x02e6:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            r3.setTransactionSuccessful();	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
        L_0x02f1:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b7 }
            if (r3 == 0) goto L_0x0314;
        L_0x02fb:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x03b7 }
            if (r3 == 0) goto L_0x0314;
        L_0x0309:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b7 }
            r3.endTransaction();	 Catch:{ Exception -> 0x03b7 }
        L_0x0314:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            goto L_0x01ec;
        L_0x031b:
            if (r6 == 0) goto L_0x0251;
        L_0x031d:
            r2 = "cell";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 != 0) goto L_0x0251;
        L_0x0326:
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "CREATE TABLE IF NOT EXISTS ";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = " (id LONG PRIMARY KEY,x INT);";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = "DELETE FROM ";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = ";";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r5 = r0.f17602b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r5 == 0) goto L_0x0251;
        L_0x0366:
            r0 = r19;
            r5 = r0.f17602b;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r5.execSQL(r2);	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r0 = r19;
            r2 = r0.f17602b;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            goto L_0x0251;
        L_0x037e:
            r2 = move-exception;
            goto L_0x0251;
        L_0x0381:
            r2 = move-exception;
            r2 = r11;
            goto L_0x02dc;
        L_0x0385:
            r2 = move-exception;
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03af }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03af }
            if (r3 == 0) goto L_0x03a9;
        L_0x0390:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03af }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03af }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x03af }
            if (r3 == 0) goto L_0x03a9;
        L_0x039e:
            r0 = r19;
            r3 = r0.f17602b;	 Catch:{ Exception -> 0x03af }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03af }
            r3.endTransaction();	 Catch:{ Exception -> 0x03af }
        L_0x03a9:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            throw r2;
        L_0x03af:
            r3 = move-exception;
            goto L_0x03a9;
        L_0x03b1:
            r3 = move-exception;
            goto L_0x01e7;
        L_0x03b4:
            r3 = move-exception;
            goto L_0x01c4;
        L_0x03b7:
            r3 = move-exception;
            goto L_0x0314;
        L_0x03ba:
            r2 = move-exception;
            goto L_0x00f3;
        L_0x03bd:
            r2 = move-exception;
            goto L_0x006a;
        L_0x03c0:
            r2 = move-exception;
            goto L_0x0058;
        L_0x03c3:
            r2 = r11;
            goto L_0x02dc;
        L_0x03c6:
            r2 = r11;
            goto L_0x01ec;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.b.d.a(boolean):void");
        }
    }

    /* renamed from: com.baidu.location.c.b$e */
    private final class C3241e extends C3186e {
        /* renamed from: a */
        public boolean f17611a;
        /* renamed from: b */
        final /* synthetic */ C3243b f17612b;
        /* renamed from: c */
        private int f17613c;

        public C3241e(C3243b c3243b) {
            this.f17612b = c3243b;
            this.f17611a = false;
            this.f17613c = 0;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = this.f17612b.f17631h;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("&qt=grid");
            stringBuffer.append("&tp=gi");
            stringBuffer.append("&ct=");
            stringBuffer.append(this.f17612b.f17633l);
            stringBuffer.append(C3381b.m14398a().m14408g());
            stringBuffer.append("&vkey=0");
            String stringBuffer2 = stringBuffer.toString();
            this.k.put("qt", "grid");
            this.k.put("req", Jni.encode(stringBuffer2));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo2495a(boolean r20) {
            /*
            r19 = this;
            r5 = 0;
            r6 = 0;
            r4 = 0;
            r3 = 0;
            if (r20 == 0) goto L_0x0635;
        L_0x0006:
            r0 = r19;
            r2 = r0.j;
            if (r2 == 0) goto L_0x0635;
        L_0x000c:
            r0 = r19;
            r7 = r0.j;
            r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0201 }
            r2.<init>(r7);	 Catch:{ JSONException -> 0x0201 }
        L_0x0015:
            if (r2 == 0) goto L_0x020c;
        L_0x0017:
            r6 = "grids";
            r6 = r2.has(r6);
            if (r6 == 0) goto L_0x020c;
        L_0x0020:
            r6 = "grids";
            r2 = r2.getJSONObject(r6);	 Catch:{ JSONException -> 0x0208 }
            r8 = r2;
        L_0x0028:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x0623, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x0623, all -> 0x0466 }
            r2.beginTransaction();	 Catch:{ Exception -> 0x0623, all -> 0x0466 }
        L_0x0033:
            if (r8 == 0) goto L_0x0632;
        L_0x0035:
            r2 = "ver";
            r2 = r8.has(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x0632;
        L_0x003e:
            r2 = "ver";
            r2 = r8.getString(r2);	 Catch:{ Exception -> 0x020f, all -> 0x0466 }
            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x020f, all -> 0x0466 }
            r2 = r2.intValue();	 Catch:{ Exception -> 0x020f, all -> 0x0466 }
            r7 = r2;
        L_0x004e:
            r2 = 0;
            if (r8 == 0) goto L_0x062f;
        L_0x0051:
            r3 = "ap";
            r3 = r8.has(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r3 == 0) goto L_0x062f;
        L_0x005a:
            r3 = "ap";
            r3 = r8.getJSONObject(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r5 = "len";
            r3 = r3.has(r5);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r3 == 0) goto L_0x062f;
        L_0x006a:
            r2 = "ap";
            r2 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "len";
            r2 = r2.getInt(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r6 = r2;
        L_0x0079:
            if (r6 <= 0) goto L_0x02ac;
        L_0x007b:
            if (r8 == 0) goto L_0x02ac;
        L_0x007d:
            r2 = "ap";
            r2 = r8.has(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x02ac;
        L_0x0086:
            r2 = "ap";
            r2 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "g";
            r2 = r2.has(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x02ac;
        L_0x0096:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x00ae;
        L_0x00a0:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x0620, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x0620, all -> 0x0466 }
            r3 = "DELETE FROM UPAP;";
            r2.execSQL(r3);	 Catch:{ Exception -> 0x0620, all -> 0x0466 }
        L_0x00ae:
            r2 = "ap";
            r2 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "g";
            r9 = r2.getJSONArray(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r10 = r9.length();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r5 = 1;
            r3 = 0;
            r2 = 0;
            r18 = r2;
            r2 = r3;
            r3 = r5;
            r5 = r18;
        L_0x00ce:
            if (r5 >= r10) goto L_0x028e;
        L_0x00d0:
            r12 = r9.getString(r5);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = "\\|";
            r12 = r12.split(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 0;
            r13 = r12[r13];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.intValue();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = 1;
            r12 = r12[r14];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.intValue();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r3 == 0) goto L_0x0213;
        L_0x00f3:
            r3 = 0;
        L_0x00f4:
            r14 = 40;
            r14 = r11.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r16 = "\"AP_";
            r15 = r15.append(r16);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = r15.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r16 = "_";
            r15 = r15.append(r16);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = r15.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r16 = "\"";
            r15 = r15.append(r16);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = r15.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = 44;
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r16 = "";
            r15 = r15.append(r16);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r15.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r14.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = 44;
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = "";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r14.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r13.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 44;
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = "";
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.append(r7);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 44;
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = "";
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.append(r6);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 44;
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = "";
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r14 = r14 / r16;
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 44;
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = "1";
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 41;
            r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2 + 1;
            r12 = 10;
            if (r2 < r12) goto L_0x01fd;
        L_0x01da:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = "INSERT OR REPLACE INTO UPAP (id,x,y,v,d,t,c) VALUES %s;";
            r13 = 1;
            r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = 0;
            r15 = r11.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13[r14] = r15;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = java.lang.String.format(r12, r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3.execSQL(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = 1;
            r12 = 0;
            r11.setLength(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2 + -10;
        L_0x01fd:
            r5 = r5 + 1;
            goto L_0x00ce;
        L_0x0201:
            r2 = move-exception;
            r2.printStackTrace();
            r2 = r6;
            goto L_0x0015;
        L_0x0208:
            r2 = move-exception;
            r2.printStackTrace();
        L_0x020c:
            r8 = r5;
            goto L_0x0028;
        L_0x020f:
            r2 = move-exception;
            r7 = r3;
            goto L_0x004e;
        L_0x0213:
            r14 = 44;
            r11.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            goto L_0x00f4;
        L_0x021a:
            r2 = move-exception;
            r2 = r4;
        L_0x021c:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05f8 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05f8 }
            if (r3 == 0) goto L_0x023f;
        L_0x0226:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05f8 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05f8 }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x05f8 }
            if (r3 == 0) goto L_0x023f;
        L_0x0234:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05f8 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05f8 }
            r3.endTransaction();	 Catch:{ Exception -> 0x05f8 }
        L_0x023f:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
        L_0x0244:
            r0 = r19;
            r3 = r0.f17613c;
            r3 = r3 + 1;
            r0 = r19;
            r0.f17613c = r3;
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            r0 = r19;
            r3 = r0.k;
            r3.clear();
            r0 = r19;
            r3 = r0.f17613c;
            r3 = r3 % 3;
            r4 = 1;
            if (r3 != r4) goto L_0x0266;
        L_0x0263:
            java.lang.System.gc();
        L_0x0266:
            r3 = 0;
            r0 = r19;
            r0.f17611a = r3;
            if (r2 == 0) goto L_0x028d;
        L_0x026d:
            r0 = r19;
            r2 = r0.f17612b;
            r2 = r2.f17635n;
            if (r2 == 0) goto L_0x028d;
        L_0x0277:
            r2 = com.baidu.location.p187a.C3181a.m13265a();
            r2 = r2.m13278c();
            if (r2 == 0) goto L_0x028d;
        L_0x0281:
            r0 = r19;
            r2 = r0.f17612b;
            r2 = r2.f17635n;
            r3 = 1;
            r2.sendEmptyMessage(r3);
        L_0x028d:
            return;
        L_0x028e:
            if (r2 <= 0) goto L_0x02ac;
        L_0x0290:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "INSERT OR REPLACE INTO UPAP (id,x,y,v,d,t,c) VALUES %s;";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r6 = 0;
            r9 = r11.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = java.lang.String.format(r3, r5);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
        L_0x02ac:
            r2 = 0;
            if (r8 == 0) goto L_0x062c;
        L_0x02af:
            r3 = "cell";
            r3 = r8.has(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r3 == 0) goto L_0x062c;
        L_0x02b8:
            r3 = "cell";
            r3 = r8.getJSONObject(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r5 = "len";
            r3 = r3.has(r5);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r3 == 0) goto L_0x062c;
        L_0x02c8:
            r2 = "cell";
            r2 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "len";
            r2 = r2.getInt(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r6 = r2;
        L_0x02d7:
            if (r6 <= 0) goto L_0x04ae;
        L_0x02d9:
            if (r8 == 0) goto L_0x04ae;
        L_0x02db:
            r2 = "cell";
            r2 = r8.has(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x04ae;
        L_0x02e4:
            r2 = "cell";
            r2 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "g";
            r2 = r2.has(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x04ae;
        L_0x02f4:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x030c;
        L_0x02fe:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x061d, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x061d, all -> 0x0466 }
            r3 = "DELETE FROM UPCL;";
            r2.execSQL(r3);	 Catch:{ Exception -> 0x061d, all -> 0x0466 }
        L_0x030c:
            r2 = "cell";
            r2 = r8.getJSONObject(r2);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "g";
            r8 = r2.getJSONArray(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r9 = r8.length();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r10 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r10.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r5 = 1;
            r3 = 0;
            r2 = 0;
            r18 = r2;
            r2 = r3;
            r3 = r5;
            r5 = r18;
        L_0x032c:
            if (r5 >= r9) goto L_0x0490;
        L_0x032e:
            r11 = r8.getString(r5);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = "\\|";
            r11 = r11.split(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = 0;
            r12 = r11[r12];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.intValue();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 1;
            r11 = r11[r13];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r11.intValue();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r3 == 0) goto L_0x045f;
        L_0x0351:
            r3 = 0;
        L_0x0352:
            r13 = 40;
            r13 = r10.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = "\"CL_";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = r14.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = "_";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = r14.append(r11);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = "\"";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = 44;
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r15 = "";
            r14 = r14.append(r15);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r14.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r13.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 44;
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = "";
            r13 = r13.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r13.append(r11);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r11.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r12.append(r11);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = 44;
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = "";
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.append(r7);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = 44;
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = "";
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.append(r6);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = 44;
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12.<init>();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = "";
            r12 = r12.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r14 = r14 / r16;
            r12 = r12.append(r14);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = r12.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = 44;
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = "1";
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12 = 41;
            r11.append(r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2 + 1;
            r11 = 10;
            if (r2 < r11) goto L_0x045b;
        L_0x0438:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = "INSERT OR REPLACE INTO UPCL (id,x,y,v,d,t,c) VALUES %s;";
            r12 = 1;
            r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r13 = 0;
            r14 = r10.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r12[r13] = r14;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r11 = java.lang.String.format(r11, r12);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3.execSQL(r11);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = 1;
            r11 = 0;
            r10.setLength(r11);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2 + -10;
        L_0x045b:
            r5 = r5 + 1;
            goto L_0x032c;
        L_0x045f:
            r13 = 44;
            r10.append(r13);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            goto L_0x0352;
        L_0x0466:
            r2 = move-exception;
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05f5 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05f5 }
            if (r3 == 0) goto L_0x048a;
        L_0x0471:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05f5 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05f5 }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x05f5 }
            if (r3 == 0) goto L_0x048a;
        L_0x047f:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05f5 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05f5 }
            r3.endTransaction();	 Catch:{ Exception -> 0x05f5 }
        L_0x048a:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            throw r2;
        L_0x0490:
            if (r2 <= 0) goto L_0x04ae;
        L_0x0492:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = "INSERT OR REPLACE INTO UPCL (id,x,y,v,d,t,c) VALUES %s;";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r6 = 0;
            r7 = r10.toString();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r5[r6] = r7;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = java.lang.String.format(r3, r5);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
        L_0x04ae:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            if (r2 == 0) goto L_0x04c3;
        L_0x04b8:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
        L_0x04c3:
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17626c;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2.clear();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r0 = r19;
            r2 = r0.f17612b;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = r2.f17627d;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2.clear();	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = 2;
            r14 = new java.lang.String[r2];	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = 0;
            r3 = "SELECT * FROM UPAP;";
            r14[r2] = r3;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = 1;
            r3 = "SELECT * FROM UPCL;";
            r14[r2] = r3;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r3 = 0;
            r15 = r14.length;	 Catch:{ Exception -> 0x021a, all -> 0x0466 }
            r2 = 0;
            r13 = r2;
            r2 = r4;
            r4 = r3;
        L_0x04ea:
            if (r13 >= r15) goto L_0x05cb;
        L_0x04ec:
            r16 = r14[r13];	 Catch:{ Exception -> 0x05fb, all -> 0x0466 }
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x0614, all -> 0x0609 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x0614, all -> 0x0609 }
            if (r3 == 0) goto L_0x0626;
        L_0x04f8:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x0614, all -> 0x0609 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x0614, all -> 0x0609 }
            r5 = 0;
            r0 = r16;
            r11 = r3.rawQuery(r0, r5);	 Catch:{ Exception -> 0x0614, all -> 0x0609 }
            if (r11 == 0) goto L_0x05b0;
        L_0x0509:
            r3 = r11.moveToFirst();	 Catch:{ Exception -> 0x060e, all -> 0x0600 }
            if (r3 == 0) goto L_0x05b0;
        L_0x050f:
            r12 = 1;
        L_0x0510:
            r2 = r11.isAfterLast();	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            if (r2 != 0) goto L_0x0629;
        L_0x0516:
            r2 = "id";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r4 = r11.getString(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = "x";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r5 = r11.getInt(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = "y";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r6 = r11.getInt(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = "v";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r7 = r11.getInt(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = "d";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r8 = r11.getInt(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = "t";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r9 = r11.getInt(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = "c";
            r2 = r11.getColumnIndex(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r10 = r11.getInt(r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2 = new com.baidu.location.c.b$c;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r3 = "SELECT * FROM UPAP;";
            r0 = r16;
            r3 = r0.equals(r3);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            if (r3 == 0) goto L_0x0599;
        L_0x0577:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r3 = r3.f17626c;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r4 = r2.f17595c;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r3.put(r4, r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
        L_0x0582:
            r11.moveToNext();	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            goto L_0x0510;
        L_0x0586:
            r2 = move-exception;
            r4 = r2;
            r3 = r12;
            r2 = r11;
        L_0x058a:
            r4.printStackTrace();	 Catch:{ all -> 0x0604 }
            if (r2 == 0) goto L_0x0592;
        L_0x058f:
            r2.close();	 Catch:{ Exception -> 0x05c1, all -> 0x0466 }
        L_0x0592:
            r4 = r13 + 1;
            r13 = r4;
            r4 = r2;
            r2 = r3;
            goto L_0x04ea;
        L_0x0599:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r3 = r3.f17627d;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r4 = r2.f17595c;	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            r3.put(r4, r2);	 Catch:{ Exception -> 0x0586, all -> 0x05a5 }
            goto L_0x0582;
        L_0x05a5:
            r2 = move-exception;
        L_0x05a6:
            if (r11 == 0) goto L_0x05ab;
        L_0x05a8:
            r11.close();	 Catch:{ Exception -> 0x05c6, all -> 0x0466 }
        L_0x05ab:
            throw r2;	 Catch:{ Exception -> 0x05ac, all -> 0x0466 }
        L_0x05ac:
            r2 = move-exception;
            r2 = r12;
            goto L_0x021c;
        L_0x05b0:
            r3 = r2;
            r2 = r11;
        L_0x05b2:
            if (r2 == 0) goto L_0x0592;
        L_0x05b4:
            r2.close();	 Catch:{ Exception -> 0x05b8, all -> 0x0466 }
            goto L_0x0592;
        L_0x05b8:
            r4 = move-exception;
            r4.printStackTrace();	 Catch:{ Exception -> 0x05bd, all -> 0x0466 }
            goto L_0x0592;
        L_0x05bd:
            r2 = move-exception;
            r2 = r3;
            goto L_0x021c;
        L_0x05c1:
            r4 = move-exception;
            r4.printStackTrace();	 Catch:{ Exception -> 0x05bd, all -> 0x0466 }
            goto L_0x0592;
        L_0x05c6:
            r3 = move-exception;
            r3.printStackTrace();	 Catch:{ Exception -> 0x05ac, all -> 0x0466 }
            goto L_0x05ab;
        L_0x05cb:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05fe }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05fe }
            if (r3 == 0) goto L_0x05ee;
        L_0x05d5:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05fe }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05fe }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x05fe }
            if (r3 == 0) goto L_0x05ee;
        L_0x05e3:
            r0 = r19;
            r3 = r0.f17612b;	 Catch:{ Exception -> 0x05fe }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x05fe }
            r3.endTransaction();	 Catch:{ Exception -> 0x05fe }
        L_0x05ee:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            goto L_0x0244;
        L_0x05f5:
            r3 = move-exception;
            goto L_0x048a;
        L_0x05f8:
            r3 = move-exception;
            goto L_0x023f;
        L_0x05fb:
            r3 = move-exception;
            goto L_0x021c;
        L_0x05fe:
            r3 = move-exception;
            goto L_0x05ee;
        L_0x0600:
            r3 = move-exception;
            r12 = r2;
            r2 = r3;
            goto L_0x05a6;
        L_0x0604:
            r4 = move-exception;
            r11 = r2;
            r12 = r3;
            r2 = r4;
            goto L_0x05a6;
        L_0x0609:
            r3 = move-exception;
            r11 = r4;
            r12 = r2;
            r2 = r3;
            goto L_0x05a6;
        L_0x060e:
            r3 = move-exception;
            r4 = r3;
            r3 = r2;
            r2 = r11;
            goto L_0x058a;
        L_0x0614:
            r3 = move-exception;
            r18 = r3;
            r3 = r2;
            r2 = r4;
            r4 = r18;
            goto L_0x058a;
        L_0x061d:
            r2 = move-exception;
            goto L_0x030c;
        L_0x0620:
            r2 = move-exception;
            goto L_0x00ae;
        L_0x0623:
            r2 = move-exception;
            goto L_0x0033;
        L_0x0626:
            r3 = r2;
            r2 = r4;
            goto L_0x05b2;
        L_0x0629:
            r2 = r11;
            r3 = r12;
            goto L_0x05b2;
        L_0x062c:
            r6 = r2;
            goto L_0x02d7;
        L_0x062f:
            r6 = r2;
            goto L_0x0079;
        L_0x0632:
            r7 = r3;
            goto L_0x004e;
        L_0x0635:
            r2 = r4;
            goto L_0x0244;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.b.e.a(boolean):void");
        }

        /* renamed from: b */
        public void mo2500b() {
            if (this.f17612b.f17633l != null && !this.f17611a) {
                this.f17611a = true;
                m13298a(false, "ofloc.map.baidu.com");
            }
        }
    }

    /* renamed from: com.baidu.location.c.b$f */
    private final class C3242f extends C3186e {
        /* renamed from: a */
        public boolean f17614a;
        /* renamed from: b */
        final /* synthetic */ C3243b f17615b;
        /* renamed from: c */
        private int f17616c;
        /* renamed from: d */
        private int f17617d;
        /* renamed from: e */
        private int f17618e;
        /* renamed from: f */
        private int f17619f;
        /* renamed from: p */
        private int f17620p;
        /* renamed from: q */
        private boolean f17621q;

        public C3242f(C3243b c3243b) {
            this.f17615b = c3243b;
            this.f17614a = false;
            this.f17616c = 0;
            this.f17617d = 0;
            this.f17618e = 0;
            this.f17619f = 0;
            this.f17620p = 0;
            this.f17621q = false;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = this.f17615b.f17631h;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("&qt=grid");
            stringBuffer.append("&tp=gdg");
            stringBuffer.append("&ct=");
            stringBuffer.append(this.f17615b.f17633l);
            stringBuffer.append(C3381b.m14398a().m14408g());
            stringBuffer.append("&apg=");
            stringBuffer.append(String.format(Locale.US, "%d|%d", new Object[]{Integer.valueOf(this.f17616c), Integer.valueOf(this.f17617d)}));
            stringBuffer.append("&vkey=0");
            String stringBuffer2 = stringBuffer.toString();
            this.k.put("qt", "grid");
            this.k.put("req", Jni.encode(stringBuffer2));
        }

        /* renamed from: a */
        public void m13575a(int i, int i2, int i3, int i4) {
            if (this.f17615b.f17633l != null && !this.f17614a && !this.f17621q) {
                this.f17614a = true;
                this.f17616c = i;
                this.f17617d = i2;
                this.f17618e = i3;
                this.f17620p = i4;
                m13298a(false, "ofloc.map.baidu.com");
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo2495a(boolean r20) {
            /*
            r19 = this;
            r3 = 0;
            r5 = 0;
            r4 = 0;
            r11 = 0;
            r7 = 0;
            if (r20 == 0) goto L_0x03c6;
        L_0x0007:
            r0 = r19;
            r2 = r0.j;
            if (r2 == 0) goto L_0x03c6;
        L_0x000d:
            r0 = r19;
            r6 = r0.j;
            r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01ac }
            r2.<init>(r6);	 Catch:{ JSONException -> 0x01ac }
        L_0x0016:
            if (r2 == 0) goto L_0x01b7;
        L_0x0018:
            r5 = "model";
            r5 = r2.has(r5);
            if (r5 == 0) goto L_0x01b7;
        L_0x0021:
            r5 = "model";
            r2 = r2.getJSONObject(r5);	 Catch:{ JSONException -> 0x01b3 }
            r6 = r2;
        L_0x0029:
            if (r4 != 0) goto L_0x004d;
        L_0x002b:
            r2 = java.util.Locale.US;
            r3 = "AP_%d_%d";
            r4 = 2;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r0 = r19;
            r8 = r0.f17616c;
            r8 = java.lang.Integer.valueOf(r8);
            r4[r5] = r8;
            r5 = 1;
            r0 = r19;
            r8 = r0.f17617d;
            r8 = java.lang.Integer.valueOf(r8);
            r4[r5] = r8;
            r4 = java.lang.String.format(r2, r3, r4);
        L_0x004d:
            r0 = r19;
            r2 = r0.f17615b;	 Catch:{ Exception -> 0x03c0, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x03c0, all -> 0x0385 }
            r2.beginTransaction();	 Catch:{ Exception -> 0x03c0, all -> 0x0385 }
        L_0x0058:
            if (r6 == 0) goto L_0x006a;
        L_0x005a:
            r2 = "ver";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 == 0) goto L_0x006a;
        L_0x0063:
            r2 = "ver";
            r7 = r6.getInt(r2);	 Catch:{ Exception -> 0x03bd, all -> 0x0385 }
        L_0x006a:
            r8 = 0;
            if (r6 == 0) goto L_0x007d;
        L_0x006d:
            r2 = "ap_len";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 == 0) goto L_0x007d;
        L_0x0076:
            r2 = "ap_len";
            r8 = r6.getInt(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
        L_0x007d:
            if (r8 == 0) goto L_0x008a;
        L_0x007f:
            r0 = r19;
            r2 = r0.f17620p;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r8 == r2) goto L_0x008a;
        L_0x0085:
            r2 = 1;
            r0 = r19;
            r0.f17621q = r2;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
        L_0x008a:
            if (r8 <= 0) goto L_0x031b;
        L_0x008c:
            r0 = r19;
            r2 = r0.f17621q;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 != 0) goto L_0x031b;
        L_0x0092:
            if (r6 == 0) goto L_0x031b;
        L_0x0094:
            r2 = "ap";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 == 0) goto L_0x031b;
        L_0x009d:
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "CREATE TABLE IF NOT EXISTS ";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = " (id LONG PRIMARY KEY,x INT);";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = "DELETE FROM ";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = ";";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r5 = r0.f17615b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r5 == 0) goto L_0x00f3;
        L_0x00dd:
            r0 = r19;
            r5 = r0.f17615b;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r5.execSQL(r2);	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r0 = r19;
            r2 = r0.f17615b;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x03ba, all -> 0x0385 }
        L_0x00f3:
            r2 = "ap";
            r2 = r6.getString(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = ";";
            r9 = r2.split(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r10 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r10.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = 1;
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "INSERT OR REPLACE INTO ";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = " (id,x) VALUES %s;";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r12 = r2.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = 0;
            r13 = r9.length;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = 0;
            r18 = r2;
            r2 = r3;
            r3 = r5;
            r5 = r18;
        L_0x012b:
            if (r5 >= r13) goto L_0x0236;
        L_0x012d:
            r14 = r9[r5];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = "|";
            r15 = r14.contains(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r15 == 0) goto L_0x01a9;
        L_0x0138:
            r15 = "\\|";
            r14 = r14.split(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = r14.length;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 2;
            r0 = r16;
            if (r15 != r0) goto L_0x01a9;
        L_0x0146:
            r15 = 0;
            r15 = r14[r15];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 1;
            r14 = r14[r16];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r3 == 0) goto L_0x01ba;
        L_0x014f:
            r3 = 0;
        L_0x0150:
            r16 = 40;
            r0 = r16;
            r16 = r10.append(r0);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r16;
            r15 = r0.append(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 44;
            r15 = r15.append(r16);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r17 = "";
            r16 = r16.append(r17);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r16;
            r14 = r0.append(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = r14.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = r15.append(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = 41;
            r14.append(r15);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2 + 1;
            r14 = 100;
            if (r2 < r14) goto L_0x01a9;
        L_0x0189:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = 1;
            r14 = new java.lang.Object[r14];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r15 = 0;
            r16 = r10.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14[r15] = r16;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = java.lang.String.format(r12, r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3.execSQL(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = 1;
            r14 = 0;
            r10.setLength(r14);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2 + -100;
        L_0x01a9:
            r5 = r5 + 1;
            goto L_0x012b;
        L_0x01ac:
            r2 = move-exception;
            r2.printStackTrace();
            r2 = r5;
            goto L_0x0016;
        L_0x01b3:
            r2 = move-exception;
            r2.printStackTrace();
        L_0x01b7:
            r6 = r3;
            goto L_0x0029;
        L_0x01ba:
            r16 = 44;
            r0 = r16;
            r10.append(r0);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            goto L_0x0150;
        L_0x01c2:
            r2 = move-exception;
            r2 = r11;
        L_0x01c4:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b1 }
            if (r3 == 0) goto L_0x01e7;
        L_0x01ce:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x03b1 }
            if (r3 == 0) goto L_0x01e7;
        L_0x01dc:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b1 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b1 }
            r3.endTransaction();	 Catch:{ Exception -> 0x03b1 }
        L_0x01e7:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
        L_0x01ec:
            r0 = r19;
            r3 = r0.f17619f;
            r3 = r3 + 1;
            r0 = r19;
            r0.f17619f = r3;
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            r0 = r19;
            r3 = r0.k;
            r3.clear();
            r0 = r19;
            r3 = r0.f17619f;
            r3 = r3 % 3;
            r4 = 1;
            if (r3 != r4) goto L_0x020e;
        L_0x020b:
            java.lang.System.gc();
        L_0x020e:
            r3 = 0;
            r0 = r19;
            r0.f17614a = r3;
            if (r2 == 0) goto L_0x0235;
        L_0x0215:
            r0 = r19;
            r2 = r0.f17615b;
            r2 = r2.f17635n;
            if (r2 == 0) goto L_0x0235;
        L_0x021f:
            r2 = com.baidu.location.p187a.C3181a.m13265a();
            r2 = r2.m13278c();
            if (r2 == 0) goto L_0x0235;
        L_0x0229:
            r0 = r19;
            r2 = r0.f17615b;
            r2 = r2.f17635n;
            r3 = 1;
            r2.sendEmptyMessage(r3);
        L_0x0235:
            return;
        L_0x0236:
            if (r2 <= 0) goto L_0x0251;
        L_0x0238:
            r0 = r19;
            r2 = r0.f17615b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = 0;
            r9 = r10.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3[r5] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = java.lang.String.format(r12, r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
        L_0x0251:
            r0 = r19;
            r2 = r0.f17621q;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 != 0) goto L_0x03c3;
        L_0x0257:
            if (r6 == 0) goto L_0x03c3;
        L_0x0259:
            r2 = java.util.Locale.US;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "INSERT OR REPLACE INTO AP VALUES (\"%s\",%d,%d,%d,%d,%d,%d);";
            r5 = 7;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 0;
            r5[r6] = r4;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 1;
            r0 = r19;
            r9 = r0.f17616c;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 2;
            r0 = r19;
            r9 = r0.f17617d;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 3;
            r9 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 4;
            r9 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 5;
            r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r12 = r12 / r14;
            r9 = (int) r12;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r6 = 6;
            r0 = r19;
            r9 = r0.f17618e;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5[r6] = r9;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r12 = java.lang.String.format(r2, r3, r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = new com.baidu.location.c.b$c;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r5 = r0.f17616c;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r6 = r0.f17617d;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r14 = r14 / r16;
            r9 = (int) r14;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r10 = r0.f17618e;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3.execSQL(r12);	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3 = r3.f17624a;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r4 = r2.f17595c;	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r3.put(r4, r2);	 Catch:{ Exception -> 0x0381, all -> 0x0385 }
            r11 = 1;
            r2 = r11;
        L_0x02dc:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            if (r3 == 0) goto L_0x02f1;
        L_0x02e6:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
            r3.setTransactionSuccessful();	 Catch:{ Exception -> 0x03b4, all -> 0x0385 }
        L_0x02f1:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b7 }
            if (r3 == 0) goto L_0x0314;
        L_0x02fb:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x03b7 }
            if (r3 == 0) goto L_0x0314;
        L_0x0309:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03b7 }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03b7 }
            r3.endTransaction();	 Catch:{ Exception -> 0x03b7 }
        L_0x0314:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            goto L_0x01ec;
        L_0x031b:
            if (r6 == 0) goto L_0x0251;
        L_0x031d:
            r2 = "ap";
            r2 = r6.has(r2);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r2 != 0) goto L_0x0251;
        L_0x0326:
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = "CREATE TABLE IF NOT EXISTS ";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = " (id LONG PRIMARY KEY,x INT);";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3.<init>();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = "DELETE FROM ";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = ";";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r0 = r19;
            r5 = r0.f17615b;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x01c2, all -> 0x0385 }
            if (r5 == 0) goto L_0x0251;
        L_0x0366:
            r0 = r19;
            r5 = r0.f17615b;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r5 = r5.f17632k;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r5.execSQL(r2);	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r0 = r19;
            r2 = r0.f17615b;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r2 = r2.f17632k;	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            r2.execSQL(r3);	 Catch:{ Exception -> 0x037e, all -> 0x0385 }
            goto L_0x0251;
        L_0x037e:
            r2 = move-exception;
            goto L_0x0251;
        L_0x0381:
            r2 = move-exception;
            r2 = r11;
            goto L_0x02dc;
        L_0x0385:
            r2 = move-exception;
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03af }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03af }
            if (r3 == 0) goto L_0x03a9;
        L_0x0390:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03af }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03af }
            r3 = r3.isOpen();	 Catch:{ Exception -> 0x03af }
            if (r3 == 0) goto L_0x03a9;
        L_0x039e:
            r0 = r19;
            r3 = r0.f17615b;	 Catch:{ Exception -> 0x03af }
            r3 = r3.f17632k;	 Catch:{ Exception -> 0x03af }
            r3.endTransaction();	 Catch:{ Exception -> 0x03af }
        L_0x03a9:
            r3 = 0;
            r0 = r19;
            r0.j = r3;
            throw r2;
        L_0x03af:
            r3 = move-exception;
            goto L_0x03a9;
        L_0x03b1:
            r3 = move-exception;
            goto L_0x01e7;
        L_0x03b4:
            r3 = move-exception;
            goto L_0x01c4;
        L_0x03b7:
            r3 = move-exception;
            goto L_0x0314;
        L_0x03ba:
            r2 = move-exception;
            goto L_0x00f3;
        L_0x03bd:
            r2 = move-exception;
            goto L_0x006a;
        L_0x03c0:
            r2 = move-exception;
            goto L_0x0058;
        L_0x03c3:
            r2 = r11;
            goto L_0x02dc;
        L_0x03c6:
            r2 = r11;
            goto L_0x01ec;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.b.f.a(boolean):void");
        }
    }

    public C3243b() {
        File file;
        SQLiteDatabase openOrCreateDatabase;
        Cursor rawQuery;
        Exception exception;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            file = new File(C3377f.getServiceContext().getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            file = null;
        }
        try {
            File file2 = new File(file, "ofl_location_v2.db");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, null);
        } catch (Exception e3) {
            openOrCreateDatabase = null;
        }
        this.f17632k = openOrCreateDatabase;
        if (this.f17632k != null) {
            try {
                this.f17632k.execSQL("CREATE TABLE IF NOT EXISTS AP (id VARCHAR(40) PRIMARY KEY,x INT,y INT,v INT,d INT,t INT,c INT);");
                this.f17632k.execSQL("CREATE TABLE IF NOT EXISTS CL (id VARCHAR(40) PRIMARY KEY,x INT,y INT,v INT,d INT,t INT,c INT);");
                this.f17632k.execSQL("CREATE TABLE IF NOT EXISTS UPAP (id VARCHAR(40) PRIMARY KEY,x INT,y INT,v INT,d INT,t INT,c INT);");
                this.f17632k.execSQL("CREATE TABLE IF NOT EXISTS UPCL (id VARCHAR(40) PRIMARY KEY,x INT,y INT,v INT,d INT,t INT,c INT);");
            } catch (Exception e4) {
            }
        }
        String[] strArr = new String[]{"SELECT * FROM AP;", "SELECT * FROM CL;", "SELECT * FROM UPAP;", "SELECT * FROM UPCL;"};
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                if (this.f17632k != null) {
                    rawQuery = this.f17632k.rawQuery(str, null);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            while (!rawQuery.isAfterLast()) {
                                String string = rawQuery.getString(rawQuery.getColumnIndex("id"));
                                int i2 = rawQuery.getInt(rawQuery.getColumnIndex("x"));
                                int i3 = rawQuery.getInt(rawQuery.getColumnIndex("y"));
                                int i4 = rawQuery.getInt(rawQuery.getColumnIndex("v"));
                                int i5 = rawQuery.getInt(rawQuery.getColumnIndex("d"));
                                int i6 = rawQuery.getInt(rawQuery.getColumnIndex("t"));
                                C3239c c3239c = new C3239c(this, string, i2, i3, i4, i5, i6, rawQuery.getInt(rawQuery.getColumnIndex("c")));
                                if (str.equals("SELECT * FROM AP;")) {
                                    this.f17624a.put(string, c3239c);
                                } else if (str.equals("SELECT * FROM CL;")) {
                                    this.f17625b.put(string, c3239c);
                                } else {
                                    try {
                                        if (str.equals("SELECT * FROM UPAP;")) {
                                            this.f17626c.put(string, c3239c);
                                        } else {
                                            this.f17627d.put(string, c3239c);
                                            if (this.f17634m == 0) {
                                                this.f17634m = i6;
                                            }
                                        }
                                    } catch (Exception e5) {
                                        exception = e5;
                                        cursor = rawQuery;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                rawQuery.moveToNext();
                            }
                        }
                    }
                    cursor = rawQuery;
                } else {
                    cursor = cursor2;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception exception2) {
                        exception2.printStackTrace();
                    }
                }
            } catch (Exception e52) {
                Exception exception3 = e52;
                cursor = cursor2;
                exception2 = exception3;
                try {
                    exception2.printStackTrace();
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception exception22) {
                            exception22.printStackTrace();
                        }
                    }
                    i++;
                    cursor2 = cursor;
                } catch (Throwable th3) {
                    rawQuery = cursor;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                rawQuery = cursor2;
            }
            i++;
            cursor2 = cursor;
        }
        return;
        throw th;
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception exception222) {
                exception222.printStackTrace();
            }
        }
        throw th;
    }

    /* renamed from: a */
    private double m13577a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double toRadians = Math.toRadians(d);
        Math.toRadians(d2);
        double toRadians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d5 = Math.toRadians(d5);
        d6 = Math.toRadians(d6);
        d5 = (Math.sin(d5 / 2.0d) * ((Math.cos(toRadians) * Math.cos(toRadians2)) * Math.sin(d5 / 2.0d))) + (Math.sin(d6 / 2.0d) * Math.sin(d6 / 2.0d));
        return (Math.atan2(Math.sqrt(d5), Math.sqrt(1.0d - d5)) * 2.0d) * 6378137.0d;
    }

    /* renamed from: a */
    private int m13578a(ArrayList<C3237a> arrayList, double d) {
        if (arrayList.size() == 0) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2;
            int i3;
            if (arrayList.size() >= 3) {
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    d2 += ((C3237a) arrayList.get(i2)).f17586a;
                    d3 += ((C3237a) arrayList.get(i2)).f17587b;
                }
                d2 /= (double) arrayList.size();
                d3 /= (double) arrayList.size();
                int i4 = 0;
                int i5 = -1;
                double d4 = -1.0d;
                while (i4 < arrayList.size()) {
                    double a = m13577a(d3, d2, ((C3237a) arrayList.get(i4)).f17587b, ((C3237a) arrayList.get(i4)).f17586a);
                    if (a > d4) {
                        i2 = i4;
                    } else {
                        i2 = i5;
                        a = d4;
                    }
                    i4++;
                    i5 = i2;
                    d4 = a;
                }
                if (d4 > d && i5 >= 0 && i5 < arrayList.size()) {
                    i++;
                    arrayList.remove(i5);
                    i2 = 1;
                    i3 = i;
                    if (i2 == 1) {
                        return i3;
                    }
                    i = i3;
                }
            }
            i2 = 0;
            i3 = i;
            if (i2 == 1) {
                return i3;
            }
            i = i3;
        }
    }

    /* renamed from: a */
    private BDLocation m13579a(Long l, BDLocation bDLocation, Location location) {
        Object obj;
        double d;
        int i;
        double d2;
        List<C3239c> arrayList = new ArrayList();
        arrayList.addAll(this.f17625b.values());
        int i2 = ((C3239c) arrayList.get(0)).f17597e;
        if (location != null) {
            int latitude = ((int) (location.getLatitude() * 100000.0d)) / i2;
            if (!this.f17625b.containsKey("CL_" + (((int) (location.getLongitude() * 100000.0d)) / i2) + JNISearchConst.LAYER_ID_DIVIDER + latitude)) {
                return null;
            }
            if (bDLocation == null) {
                bDLocation = new BDLocation();
            }
            bDLocation.setLatitude(location.getLatitude());
            bDLocation.setLongitude(location.getLongitude());
        }
        if (bDLocation != null) {
            final int longitude = ((int) (bDLocation.getLongitude() * 100000.0d)) / i2;
            i2 = ((int) (bDLocation.getLatitude() * 100000.0d)) / i2;
            Collections.sort(arrayList, new Comparator<C3239c>(this) {
                /* renamed from: c */
                final /* synthetic */ C3243b f17582c;

                /* renamed from: a */
                public int m13564a(C3239c c3239c, C3239c c3239c2) {
                    int abs = Math.abs(longitude - c3239c.f17593a) + Math.abs(i2 - c3239c.f17594b);
                    int abs2 = Math.abs(longitude - c3239c2.f17593a) + Math.abs(i2 - c3239c2.f17594b);
                    return abs > abs2 ? 1 : abs < abs2 ? -1 : c3239c.f17595c.compareTo(c3239c2.f17595c);
                }

                public /* synthetic */ int compare(Object obj, Object obj2) {
                    return m13564a((C3239c) obj, (C3239c) obj2);
                }
            });
        }
        Cursor cursor = null;
        Object obj2 = null;
        int i3 = 0;
        double d3 = 0.0d;
        double d4 = 0.0d;
        for (C3239c c3239c : arrayList) {
            Cursor cursor2;
            try {
                cursor = this.f17632k.rawQuery(String.format(Locale.US, "SELECT * FROM %s WHERE id = %d;", new Object[]{c3239c.f17595c, l}), null);
                if (cursor != null && cursor.moveToFirst()) {
                    Location a = c3239c.m13566a(cursor.getInt(cursor.getColumnIndex("x")));
                    d3 = a.getLongitude();
                    d4 = a.getLatitude();
                    i3 = 500;
                    obj2 = 1;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                        cursor2 = cursor;
                        obj = obj2;
                        d = d4;
                        d4 = d3;
                        i = i3;
                        d2 = d;
                    } catch (Exception e) {
                        e.printStackTrace();
                        cursor2 = cursor;
                        obj = obj2;
                        d = d4;
                        d4 = d3;
                        i = i3;
                        d2 = d;
                    }
                    if (obj != null) {
                        break;
                    }
                    Object obj3 = obj;
                    cursor = cursor2;
                    double d5 = d2;
                    obj2 = obj3;
                    i3 = i;
                    d3 = d4;
                    d4 = d5;
                }
            } catch (Exception e2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                        cursor2 = cursor;
                        obj = obj2;
                        d = d4;
                        d4 = d3;
                        i = i3;
                        d2 = d;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        cursor2 = cursor;
                        obj = obj2;
                        d = d4;
                        d4 = d3;
                        i = i3;
                        d2 = d;
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            cursor2 = cursor;
            obj = obj2;
            d = d4;
            d4 = d3;
            i = i3;
            d2 = d;
            if (obj != null) {
                break;
            }
            Object obj32 = obj;
            cursor = cursor2;
            double d52 = d2;
            obj2 = obj32;
            i3 = i;
            d3 = d4;
            d4 = d52;
        }
        obj = obj2;
        d = d4;
        d4 = d3;
        i = i3;
        d2 = d;
        if (obj == null) {
            return null;
        }
        BDLocation bDLocation2 = new BDLocation();
        bDLocation2.setRadius((float) i);
        bDLocation2.setLatitude(d2);
        bDLocation2.setLongitude(d4);
        bDLocation2.setNetworkLocationType("cl");
        bDLocation2.setLocType(66);
        return bDLocation2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private com.baidu.location.BDLocation m13580a(java.util.LinkedHashMap<java.lang.String, java.lang.Integer> r34, com.baidu.location.BDLocation r35, com.baidu.location.BDLocation r36, int r37, android.location.Location r38) {
        /*
        r33 = this;
        r8 = new java.util.ArrayList;
        r8.<init>();
        r0 = r33;
        r2 = r0.f17624a;
        r2 = r2.values();
        r8.addAll(r2);
        r2 = 0;
        r2 = r8.get(r2);
        r2 = (com.baidu.location.p190c.C3243b.C3239c) r2;
        r9 = r2.f17597e;
        if (r38 == 0) goto L_0x0077;
    L_0x001b:
        r2 = r38.getLongitude();
        r4 = 4681608360884174848; // 0x40f86a0000000000 float:0.0 double:100000.0;
        r2 = r2 * r4;
        r2 = (int) r2;
        r2 = r2 / r9;
        r4 = r38.getLatitude();
        r6 = 4681608360884174848; // 0x40f86a0000000000 float:0.0 double:100000.0;
        r4 = r4 * r6;
        r3 = (int) r4;
        r3 = r3 / r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "AP_";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = "_";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0 = r33;
        r3 = r0.f17624a;
        r2 = r3.containsKey(r2);
        if (r2 != 0) goto L_0x005e;
    L_0x005c:
        r2 = 0;
    L_0x005d:
        return r2;
    L_0x005e:
        if (r36 != 0) goto L_0x0065;
    L_0x0060:
        r36 = new com.baidu.location.BDLocation;
        r36.<init>();
    L_0x0065:
        r2 = r38.getLatitude();
        r0 = r36;
        r0.setLatitude(r2);
        r2 = r38.getLongitude();
        r0 = r36;
        r0.setLongitude(r2);
    L_0x0077:
        r2 = 0;
        r28 = new java.util.HashMap;
        r28.<init>();
        r6 = 0;
        r4 = 0;
        r3 = 0;
        if (r35 == 0) goto L_0x0172;
    L_0x0084:
        r3 = 1;
        r4 = r35.getLatitude();
        r6 = r35.getLongitude();
        r10 = 4681608360884174848; // 0x40f86a0000000000 float:0.0 double:100000.0;
        r10 = r10 * r6;
        r8 = (int) r10;
        r10 = r8 / r9;
        r12 = 4681608360884174848; // 0x40f86a0000000000 float:0.0 double:100000.0;
        r12 = r12 * r4;
        r8 = (int) r12;
        r11 = r8 / r9;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "AP_";
        r8 = r8.append(r9);
        r8 = r8.append(r10);
        r9 = "_";
        r8 = r8.append(r9);
        r8 = r8.append(r11);
        r8 = r8.toString();
        r0 = r33;
        r9 = r0.f17624a;
        r9 = r9.containsKey(r8);
        if (r9 == 0) goto L_0x0124;
    L_0x00c8:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r0 = r33;
        r9 = r0.f17624a;
        r8 = r9.get(r8);
        r2.add(r8);
        r8 = -1;
        r9 = r8;
    L_0x00da:
        r8 = 1;
        if (r9 > r8) goto L_0x0124;
    L_0x00dd:
        r8 = -1;
    L_0x00de:
        r12 = 1;
        if (r8 > r12) goto L_0x0120;
    L_0x00e1:
        if (r9 != 0) goto L_0x00e5;
    L_0x00e3:
        if (r8 == 0) goto L_0x011d;
    L_0x00e5:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = "AP_";
        r12 = r12.append(r13);
        r13 = r10 + r9;
        r12 = r12.append(r13);
        r13 = "_";
        r12 = r12.append(r13);
        r13 = r11 + r8;
        r12 = r12.append(r13);
        r12 = r12.toString();
        r0 = r33;
        r13 = r0.f17624a;
        r13 = r13.containsKey(r12);
        if (r13 == 0) goto L_0x011d;
    L_0x0112:
        r0 = r33;
        r13 = r0.f17624a;
        r12 = r13.get(r12);
        r2.add(r12);
    L_0x011d:
        r8 = r8 + 1;
        goto L_0x00de;
    L_0x0120:
        r8 = r9 + 1;
        r9 = r8;
        goto L_0x00da;
    L_0x0124:
        r21 = r3;
        r8 = r2;
    L_0x0127:
        r16 = 0;
        r14 = 0;
        r12 = 0;
        r11 = 0;
        r29 = new java.lang.StringBuffer;
        r29.<init>();
        r3 = 1;
        r2 = r34.entrySet();
        r17 = r2.iterator();
        r2 = 0;
        r9 = r2;
        r10 = r3;
    L_0x013f:
        r2 = r34.size();
        if (r9 >= r2) goto L_0x01b6;
    L_0x0145:
        r2 = r17.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r2 = r2.getValue();
        r2 = (java.lang.Integer) r2;
        r18 = r2.intValue();
        if (r18 >= 0) goto L_0x0166;
    L_0x015d:
        r2 = r2.intValue();
        r2 = -r2;
        r2 = java.lang.Integer.valueOf(r2);
    L_0x0166:
        r3 = com.baidu.location.Jni.encode3(r3);
        if (r3 != 0) goto L_0x019d;
    L_0x016c:
        r3 = r10;
    L_0x016d:
        r2 = r9 + 1;
        r9 = r2;
        r10 = r3;
        goto L_0x013f;
    L_0x0172:
        if (r36 == 0) goto L_0x019a;
    L_0x0174:
        r10 = r36.getLongitude();
        r12 = 4681608360884174848; // 0x40f86a0000000000 float:0.0 double:100000.0;
        r10 = r10 * r12;
        r2 = (int) r10;
        r2 = r2 / r9;
        r10 = r36.getLatitude();
        r12 = 4681608360884174848; // 0x40f86a0000000000 float:0.0 double:100000.0;
        r10 = r10 * r12;
        r10 = (int) r10;
        r9 = r10 / r9;
        r10 = new com.baidu.location.c.b$4;
        r0 = r33;
        r10.<init>(r0, r2, r9);
        java.util.Collections.sort(r8, r10);
        r21 = r3;
        goto L_0x0127;
    L_0x019a:
        r21 = r3;
        goto L_0x0127;
    L_0x019d:
        if (r10 == 0) goto L_0x01ac;
    L_0x019f:
        r10 = 0;
    L_0x01a0:
        r0 = r28;
        r0.put(r3, r2);
        r0 = r29;
        r0.append(r3);
        r3 = r10;
        goto L_0x016d;
    L_0x01ac:
        r18 = 44;
        r0 = r29;
        r1 = r18;
        r0.append(r1);
        goto L_0x01a0;
    L_0x01b6:
        if (r8 == 0) goto L_0x045b;
    L_0x01b8:
        r30 = r8.iterator();
        r22 = r12;
        r24 = r14;
        r26 = r16;
        r12 = r11;
    L_0x01c3:
        r2 = r30.hasNext();
        if (r2 == 0) goto L_0x0455;
    L_0x01c9:
        r2 = r30.next();
        r2 = (com.baidu.location.p190c.C3243b.C3239c) r2;
        r3 = java.util.Locale.US;
        r8 = "SELECT * FROM %s WHERE id IN (%s);";
        r9 = 2;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = r2.f17595c;
        r9[r10] = r11;
        r10 = 1;
        r9[r10] = r29;
        r8 = java.lang.String.format(r3, r8, r9);
        r3 = 0;
        r0 = r33;
        r9 = r0.f17632k;	 Catch:{ Exception -> 0x042b, all -> 0x0426 }
        r10 = 0;
        r27 = r9.rawQuery(r8, r10);	 Catch:{ Exception -> 0x042b, all -> 0x0426 }
        if (r27 == 0) goto L_0x03f5;
    L_0x01ef:
        r3 = r27.moveToFirst();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        if (r3 == 0) goto L_0x03f5;
    L_0x01f5:
        r31 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r31.<init>();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
    L_0x01fa:
        r3 = r27.isAfterLast();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        if (r3 != 0) goto L_0x02d4;
    L_0x0200:
        r3 = 0;
        r0 = r27;
        r8 = r0.getLong(r3);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r13 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r3 = "x";
        r0 = r27;
        r3 = r0.getColumnIndex(r3);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r0 = r27;
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r3 = r2.m13566a(r3);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r10 = r3.getLongitude();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r8 = r3.getLatitude();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r14 = 0;
        r3 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x0232;
    L_0x022c:
        r14 = 0;
        r3 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r3 > 0) goto L_0x024e;
    L_0x0232:
        r27.moveToNext();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        goto L_0x01fa;
    L_0x0236:
        r2 = move-exception;
        r2 = r27;
    L_0x0239:
        if (r2 == 0) goto L_0x0442;
    L_0x023b:
        r2.close();	 Catch:{ Exception -> 0x0410 }
        r2 = r12;
        r8 = r22;
        r10 = r24;
        r3 = r26;
    L_0x0245:
        r12 = r2;
        r22 = r8;
        r24 = r10;
        r26 = r3;
        goto L_0x01c3;
    L_0x024e:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x026d;
    L_0x0253:
        r3 = r33;
        r14 = r3.m13577a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r16 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 <= 0) goto L_0x026d;
    L_0x0262:
        r27.moveToNext();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        goto L_0x01fa;
    L_0x0266:
        r2 = move-exception;
    L_0x0267:
        if (r27 == 0) goto L_0x026c;
    L_0x0269:
        r27.close();	 Catch:{ Exception -> 0x041d }
    L_0x026c:
        throw r2;
    L_0x026d:
        r0 = r28;
        r3 = r0.get(r13);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r13 = 30;
        r3 = java.lang.Math.max(r13, r3);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r13 = 100;
        r3 = java.lang.Math.min(r13, r3);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r13 = 70;
        if (r3 <= r13) goto L_0x02c8;
    L_0x028b:
        r3 = r3 + -70;
        r0 = (double) r3;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r16 = r0;
        r18 = 4629137466983448576; // 0x403e000000000000 float:0.0 double:30.0;
        r16 = r16 / r18;
        r14 = r14 + r16;
    L_0x0296:
        r16 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r18 = 4633641066610819072; // 0x404e000000000000 float:0.0 double:60.0;
        r16 = java.lang.Math.max(r16, r18);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r18 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r16 = java.lang.Math.pow(r16, r18);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r18 = -4634023872579145564; // 0xbfb0a3d70a3d70a4 float:9.121204E-33 double:-0.065;
        r16 = r16 * r18;
        r14 = r14 * r16;
        r18 = java.lang.Math.exp(r14);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r13 = new com.baidu.location.c.b$a;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r20 = 0;
        r14 = r10;
        r16 = r8;
        r13.<init>(r14, r16, r18);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r0 = r31;
        r0.add(r13);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r27.moveToNext();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        goto L_0x01fa;
    L_0x02c8:
        r3 = r3 + -70;
        r0 = (double) r3;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r16 = r0;
        r18 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r16 = r16 / r18;
        r14 = r14 + r16;
        goto L_0x0296;
    L_0x02d4:
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r33;
        r1 = r31;
        r0.m13578a(r1, r2);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r10 = 0;
        r14 = 0;
        r8 = 0;
        r2 = 0;
        r13 = r2;
    L_0x02e8:
        r2 = r31.size();	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        if (r13 >= r2) goto L_0x0323;
    L_0x02ee:
        r0 = r31;
        r2 = r0.get(r13);	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r2 = (com.baidu.location.p190c.C3243b.C3237a) r2;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r0 = r2.f17588c;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r16 = r0;
        r18 = 0;
        r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r3 > 0) goto L_0x0307;
    L_0x0300:
        r2 = r8;
        r8 = r14;
    L_0x0302:
        r13 = r13 + 1;
        r14 = r8;
        r8 = r2;
        goto L_0x02e8;
    L_0x0307:
        r0 = r2.f17586a;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r16 = r0;
        r0 = r2.f17588c;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r18 = r0;
        r16 = r16 * r18;
        r16 = r16 + r10;
        r10 = r2.f17587b;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r0 = r2.f17588c;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r18 = r0;
        r10 = r10 * r18;
        r10 = r10 + r14;
        r2 = r2.f17588c;	 Catch:{ Exception -> 0x0236, all -> 0x0266 }
        r2 = r2 + r8;
        r8 = r10;
        r10 = r16;
        goto L_0x0302;
    L_0x0323:
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x044f;
    L_0x0329:
        r2 = 0;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x044f;
    L_0x032f:
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x044f;
    L_0x0335:
        r10 = r10 / r8;
        r12 = r14 / r8;
        r3 = 1;
        r8 = 0;
        r2 = 0;
        r32 = r2;
        r2 = r8;
        r8 = r32;
    L_0x0340:
        r9 = r31.size();	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        if (r8 >= r9) goto L_0x036d;
    L_0x0346:
        r0 = (double) r2;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r18 = r0;
        r0 = r31;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r2 = (com.baidu.location.p190c.C3243b.C3237a) r2;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r14 = r2.f17586a;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r0 = r31;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r2 = (com.baidu.location.p190c.C3243b.C3237a) r2;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r0 = r2.f17587b;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r16 = r0;
        r9 = r33;
        r14 = r9.m13577a(r10, r12, r14, r16);	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r14 = r14 + r18;
        r9 = (float) r14;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r2 = r8 + 1;
        r8 = r2;
        r2 = r9;
        goto L_0x0340;
    L_0x036d:
        r8 = r31.size();	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r8 = (float) r8;	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r2 = r2 / r8;
        r26 = java.lang.Math.round(r2);	 Catch:{ Exception -> 0x042f, all -> 0x0266 }
        r2 = 30;
        r0 = r26;
        if (r0 >= r2) goto L_0x03e5;
    L_0x037d:
        r26 = 30;
        r8 = r12;
        r12 = r3;
    L_0x0381:
        if (r21 != 0) goto L_0x038b;
    L_0x0383:
        r2 = r31.size();	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r3 = 1;
        if (r2 > r3) goto L_0x038b;
    L_0x038a:
        r12 = 0;
    L_0x038b:
        r2 = r31.size();	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r0 = r37;
        if (r2 >= r0) goto L_0x03a8;
    L_0x0393:
        r2 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r13 = r31.size();	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r14 = (double) r13;	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r2 = r2 * r14;
        r13 = r34.size();	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r14 = (double) r13;	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r2 = r2 / r14;
        r14 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 >= 0) goto L_0x03a8;
    L_0x03a7:
        r12 = 0;
    L_0x03a8:
        r2 = 1;
        r0 = r21;
        if (r0 != r2) goto L_0x03c0;
    L_0x03ad:
        r2 = 1;
        if (r12 != r2) goto L_0x03c0;
    L_0x03b0:
        r3 = r33;
        r2 = r3.m13577a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x0439, all -> 0x0266 }
        r4 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x03c0;
    L_0x03bf:
        r12 = 0;
    L_0x03c0:
        if (r27 == 0) goto L_0x03c5;
    L_0x03c2:
        r27.close();	 Catch:{ Exception -> 0x03f0 }
    L_0x03c5:
        if (r12 == 0) goto L_0x0423;
    L_0x03c7:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r0 = r26;
        r3 = (float) r0;
        r2.setRadius(r3);
        r2.setLatitude(r8);
        r2.setLongitude(r10);
        r3 = "wf";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
        goto L_0x005d;
    L_0x03e5:
        r2 = 100;
        r0 = r26;
        if (r2 >= r0) goto L_0x044b;
    L_0x03eb:
        r26 = 100;
        r8 = r12;
        r12 = r3;
        goto L_0x0381;
    L_0x03f0:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x03c5;
    L_0x03f5:
        if (r27 == 0) goto L_0x0442;
    L_0x03f7:
        r27.close();	 Catch:{ Exception -> 0x0403 }
        r2 = r12;
        r8 = r22;
        r10 = r24;
        r3 = r26;
        goto L_0x0245;
    L_0x0403:
        r2 = move-exception;
        r2.printStackTrace();
        r2 = r12;
        r8 = r22;
        r10 = r24;
        r3 = r26;
        goto L_0x0245;
    L_0x0410:
        r2 = move-exception;
        r2.printStackTrace();
        r2 = r12;
        r8 = r22;
        r10 = r24;
        r3 = r26;
        goto L_0x0245;
    L_0x041d:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x026c;
    L_0x0423:
        r2 = 0;
        goto L_0x005d;
    L_0x0426:
        r2 = move-exception;
        r27 = r3;
        goto L_0x0267;
    L_0x042b:
        r2 = move-exception;
        r2 = r3;
        goto L_0x0239;
    L_0x042f:
        r2 = move-exception;
        r2 = r27;
        r22 = r12;
        r24 = r10;
        r12 = r3;
        goto L_0x0239;
    L_0x0439:
        r2 = move-exception;
        r2 = r27;
        r22 = r8;
        r24 = r10;
        goto L_0x0239;
    L_0x0442:
        r2 = r12;
        r8 = r22;
        r10 = r24;
        r3 = r26;
        goto L_0x0245;
    L_0x044b:
        r8 = r12;
        r12 = r3;
        goto L_0x0381;
    L_0x044f:
        r8 = r22;
        r10 = r24;
        goto L_0x0381;
    L_0x0455:
        r8 = r22;
        r10 = r24;
        goto L_0x03c5;
    L_0x045b:
        r8 = r12;
        r26 = r16;
        r12 = r11;
        r10 = r14;
        goto L_0x03c5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.b.a(java.util.LinkedHashMap, com.baidu.location.BDLocation, com.baidu.location.BDLocation, int, android.location.Location):com.baidu.location.BDLocation");
    }

    /* renamed from: a */
    public static C3243b m13581a() {
        C3243b c3243b;
        synchronized (f17622i) {
            if (f17623j == null) {
                f17623j = new C3243b();
            }
            c3243b = f17623j;
        }
        return c3243b;
    }

    /* renamed from: a */
    private String m13583a(C3362a c3362a, C3372e c3372e, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3) {
        int i = (bDLocation == null && bDLocation2 == null) ? 0 : (bDLocation != null || bDLocation2 == null) ? (bDLocation == null || bDLocation2 != null) ? 4 : 1 : 2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&uptype=oflv2");
        if (c3362a != null && c3362a.m14251e()) {
            stringBuffer.append(c3362a.m14255i());
        }
        if (c3372e != null && c3372e.m14330a() > 0) {
            stringBuffer.append(c3372e.m14338c());
        }
        if (bDLocation == null || bDLocation.getLocType() != 66) {
            stringBuffer.append("&ofcl=0");
        } else {
            stringBuffer.append(String.format(Locale.US, "&ofcl=1|%f|%f|%d", new Object[]{Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())}));
        }
        if (bDLocation2 == null || bDLocation2.getLocType() != 66) {
            stringBuffer.append("&ofwf=0");
        } else {
            stringBuffer.append(String.format(Locale.US, "&ofwf=1|%f|%f|%d", new Object[]{Double.valueOf(bDLocation2.getLongitude()), Double.valueOf(bDLocation2.getLatitude()), Integer.valueOf((int) bDLocation2.getRadius())}));
        }
        if (bDLocation3 == null || bDLocation3.getLocType() != 66) {
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%s|%d", new Object[]{"1", Integer.valueOf(i)}));
        } else {
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[]{"1", Integer.valueOf(i), Double.valueOf(bDLocation3.getLongitude()), Double.valueOf(bDLocation3.getLatitude()), Integer.valueOf((int) bDLocation3.getRadius())}));
        }
        stringBuffer.append(C3381b.m14398a().m14408g());
        String stringBuffer2 = stringBuffer.toString();
        C3299f.m13848a().m13868a(stringBuffer2);
        C3301g.m13880a(C3301g.f17908a, Jni.encode(stringBuffer2));
        return stringBuffer2;
    }

    /* renamed from: c */
    private void m13586c() {
        if (C3349d.m14171a().m14187e() && !this.f17630g.f17611a && !this.f17628e.f17601a && !this.f17629f.f17614a) {
            if (!this.f17626c.isEmpty() || !this.f17627d.isEmpty()) {
                List arrayList;
                Object obj;
                List list = null;
                Object obj2 = null;
                int i = 0;
                int i2 = 0;
                for (String str : this.f17625b.keySet()) {
                    int currentTimeMillis;
                    int i3;
                    List list2;
                    if (((C3239c) this.f17625b.get(str)).f17599g != 1 || this.f17627d.containsKey(str)) {
                        if (((C3239c) this.f17625b.get(str)).f17599g == 0) {
                            currentTimeMillis = ((int) (System.currentTimeMillis() / 1000)) - ((C3239c) this.f17625b.get(str)).f17598f;
                            i2++;
                            if (currentTimeMillis > i) {
                                i = currentTimeMillis;
                                obj2 = str;
                            }
                            if (currentTimeMillis > 2592000) {
                                arrayList = list == null ? new ArrayList() : list;
                                arrayList.add(str);
                                i3 = i2;
                                obj = obj2;
                                list2 = arrayList;
                                currentTimeMillis = i;
                            }
                        }
                        i3 = i2;
                        currentTimeMillis = i;
                        list2 = list;
                        obj = obj2;
                    } else {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(str);
                        i3 = i2;
                        currentTimeMillis = i;
                        list2 = list;
                        obj = obj2;
                    }
                    i = currentTimeMillis;
                    obj2 = obj;
                    list = list2;
                    i2 = i3;
                }
                if (i2 > 9 && obj2 != null) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    if (!list.contains(obj2)) {
                        list.add(obj2);
                    }
                }
                List<String> list3 = list;
                String str2;
                String str3;
                if (list3 != null) {
                    for (String str4 : list3) {
                        try {
                            str2 = "DROP TABLE " + str4 + ";";
                            str3 = "DELETE FROM CL WHERE id = \"" + str4 + "\";";
                            if (this.f17632k != null) {
                                this.f17632k.execSQL(str2);
                                this.f17632k.execSQL(str3);
                                this.f17625b.remove(str4);
                            }
                        } catch (Throwable e) {
                            Log.w(C3380a.f18302a, "OfflineLocationV2Manager delete table error!", e);
                        }
                    }
                    if (this.f17635n != null) {
                        this.f17635n.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                arrayList = list3;
                for (String str42 : this.f17624a.keySet()) {
                    if (!this.f17626c.containsKey(str42)) {
                        if (r1 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(str42);
                    }
                    arrayList = arrayList;
                }
                if (r1 != null) {
                    for (String str422 : r1) {
                        try {
                            str2 = "DROP TABLE " + str422 + ";";
                            str3 = "DELETE FROM AP WHERE id = \"" + str422 + "\";";
                            if (this.f17632k != null) {
                                this.f17632k.execSQL(str2);
                                this.f17632k.execSQL(str3);
                                this.f17624a.remove(str422);
                            }
                        } catch (Throwable e2) {
                            Log.w(C3380a.f18302a, "OfflineLocationV2Manager delete table error!", e2);
                        }
                    }
                    if (this.f17635n != null) {
                        this.f17635n.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                obj = null;
                if (!this.f17627d.isEmpty()) {
                    for (String str4222 : this.f17627d.keySet()) {
                        if (this.f17625b.containsKey(str4222)) {
                            if (((C3239c) this.f17625b.get(str4222)).f17596d != 0 && ((C3239c) this.f17625b.get(str4222)).f17596d < ((C3239c) this.f17627d.get(str4222)).f17596d) {
                                str2 = str4222;
                                break;
                            }
                        } else {
                            obj = str4222;
                            break;
                        }
                    }
                }
                if (obj != null) {
                    this.f17628e.m13569a(((C3239c) this.f17627d.get(obj)).f17593a, ((C3239c) this.f17627d.get(obj)).f17594b, 1, ((C3239c) this.f17627d.get(obj)).f17597e);
                    return;
                }
                Object obj3;
                if (!this.f17626c.isEmpty()) {
                    for (String str42222 : this.f17626c.keySet()) {
                        if (this.f17624a.containsKey(str42222)) {
                            if (((C3239c) this.f17624a.get(str42222)).f17596d != 0 && ((C3239c) this.f17624a.get(str42222)).f17596d < ((C3239c) this.f17626c.get(str42222)).f17596d) {
                                String str5 = str42222;
                                break;
                            }
                        } else {
                            obj3 = str42222;
                            break;
                        }
                    }
                }
                obj3 = obj;
                if (obj3 != null) {
                    this.f17629f.m13575a(((C3239c) this.f17626c.get(obj3)).f17593a, ((C3239c) this.f17626c.get(obj3)).f17594b, 1, ((C3239c) this.f17626c.get(obj3)).f17597e);
                } else if (this.f17627d != null && !this.f17627d.isEmpty()) {
                    List arrayList2 = new ArrayList();
                    arrayList2.addAll(this.f17627d.values());
                    int i4 = ((C3239c) arrayList2.get(0)).f17597e;
                    C3239c c3239c = null;
                    double[] dArr = new double[]{0.0d, 0.0d};
                    int i5 = 0;
                    int i6 = 0;
                    if (this.f17638q != null) {
                        BDLocation bDLocation = new BDLocation(this.f17638q);
                        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                        i2 = ((int) (coorEncrypt[0] * 100000.0d)) / i4;
                        i = ((int) (coorEncrypt[1] * 100000.0d)) / i4;
                        i6 = i;
                        i5 = i2;
                        c3239c = new C3239c(this, "CL_" + i2 + JNISearchConst.LAYER_ID_DIVIDER + i, i2, i, 0, 0, 0, 0);
                        dArr = coorEncrypt;
                    }
                    if (c3239c != null && !this.f17625b.containsKey(c3239c.f17595c) && !this.f17627d.containsKey(c3239c.f17595c)) {
                        this.f17628e.m13568a(dArr[1], dArr[0], 0, i5, i6, i4);
                    }
                }
            } else if (this.f17634m > 0) {
                m13590a(86400);
            } else {
                m13590a(604800);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized com.baidu.location.BDLocation m13589a(com.baidu.location.p194f.C3362a r11, com.baidu.location.p194f.C3372e r12, boolean r13, android.location.Location r14) {
        /*
        r10 = this;
        r8 = 0;
        r9 = 66;
        monitor-enter(r10);
        r0 = com.baidu.location.p193e.C3349d.m14171a();	 Catch:{ all -> 0x014d }
        r0 = r0.m14187e();	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r10);
        return r8;
    L_0x0010:
        if (r11 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r11.m14251e();	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x0020;
    L_0x0018:
        if (r12 == 0) goto L_0x000e;
    L_0x001a:
        r0 = r12.m14330a();	 Catch:{ all -> 0x014d }
        if (r0 == 0) goto L_0x000e;
    L_0x0020:
        r0 = r10.f17625b;	 Catch:{ all -> 0x014d }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x014d }
        if (r0 == 0) goto L_0x0030;
    L_0x0028:
        r0 = r10.f17624a;	 Catch:{ all -> 0x014d }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x000e;
    L_0x0030:
        r0 = r10.f17630g;	 Catch:{ all -> 0x014d }
        r0 = r0.f17611a;	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x000e;
    L_0x0036:
        r0 = r10.f17628e;	 Catch:{ all -> 0x014d }
        r0 = r0.f17601a;	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x000e;
    L_0x003c:
        r0 = r10.f17629f;	 Catch:{ all -> 0x014d }
        r0 = r0.f17614a;	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x000e;
    L_0x0042:
        r0 = r10.f17636o;	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x000e;
    L_0x0046:
        r0 = 1;
        r10.f17636o = r0;	 Catch:{ all -> 0x014d }
        r0 = r10.f17638q;	 Catch:{ all -> 0x014d }
        if (r0 == 0) goto L_0x0166;
    L_0x004d:
        r3 = new com.baidu.location.BDLocation;	 Catch:{ all -> 0x014d }
        r0 = r10.f17638q;	 Catch:{ all -> 0x014d }
        r3.<init>(r0);	 Catch:{ all -> 0x014d }
        r0 = r3.getLongitude();	 Catch:{ all -> 0x014d }
        r4 = r3.getLatitude();	 Catch:{ all -> 0x014d }
        r2 = "gcj2wgs";
        r0 = com.baidu.location.Jni.coorEncrypt(r0, r4, r2);	 Catch:{ all -> 0x014d }
        r1 = 1;
        r4 = r0[r1];	 Catch:{ all -> 0x014d }
        r3.setLatitude(r4);	 Catch:{ all -> 0x014d }
        r1 = 0;
        r0 = r0[r1];	 Catch:{ all -> 0x014d }
        r3.setLongitude(r0);	 Catch:{ all -> 0x014d }
    L_0x006f:
        r0 = r10.f17625b;	 Catch:{ all -> 0x014d }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x0163;
    L_0x0077:
        if (r11 == 0) goto L_0x0163;
    L_0x0079:
        r0 = r11.m14251e();	 Catch:{ all -> 0x014d }
        if (r0 == 0) goto L_0x0163;
    L_0x007f:
        r0 = r11.m14254h();	 Catch:{ all -> 0x014d }
        r1 = r10.f17637p;	 Catch:{ all -> 0x014d }
        if (r1 == 0) goto L_0x0160;
    L_0x0087:
        r1 = r10.f17637p;	 Catch:{ all -> 0x014d }
        r1 = r1.f17590b;	 Catch:{ all -> 0x014d }
        r1 = r1.equals(r0);	 Catch:{ all -> 0x014d }
        if (r1 == 0) goto L_0x0160;
    L_0x0091:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x014d }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r1 = (int) r4;	 Catch:{ all -> 0x014d }
        r2 = r10.f17637p;	 Catch:{ all -> 0x014d }
        r2 = r2.f17591c;	 Catch:{ all -> 0x014d }
        r1 = r1 - r2;
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r1 >= r2) goto L_0x0160;
    L_0x00a2:
        r1 = r10.f17637p;	 Catch:{ all -> 0x014d }
        r2 = r1.f17589a;	 Catch:{ all -> 0x014d }
    L_0x00a6:
        if (r2 == 0) goto L_0x00ae;
    L_0x00a8:
        r1 = r2.getLocType();	 Catch:{ all -> 0x014d }
        if (r1 == r9) goto L_0x00d4;
    L_0x00ae:
        r1 = r11.m14254h();	 Catch:{ all -> 0x014d }
        r1 = com.baidu.location.Jni.encode3(r1);	 Catch:{ all -> 0x014d }
        r2 = r10.m13579a(r1, r3, r14);	 Catch:{ all -> 0x014d }
        if (r2 == 0) goto L_0x00d4;
    L_0x00bc:
        r1 = r2.getLocType();	 Catch:{ all -> 0x014d }
        if (r1 != r9) goto L_0x00d4;
    L_0x00c2:
        r1 = 0;
        r10.f17637p = r1;	 Catch:{ all -> 0x014d }
        r1 = new com.baidu.location.c.b$b;	 Catch:{ all -> 0x014d }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x014d }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r4 = (int) r4;	 Catch:{ all -> 0x014d }
        r1.<init>(r10, r2, r0, r4);	 Catch:{ all -> 0x014d }
        r10.f17637p = r1;	 Catch:{ all -> 0x014d }
    L_0x00d4:
        r0 = r10.f17624a;	 Catch:{ all -> 0x014d }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x014d }
        if (r0 != 0) goto L_0x015e;
    L_0x00dc:
        if (r12 == 0) goto L_0x015e;
    L_0x00de:
        r0 = r12.m14330a();	 Catch:{ all -> 0x014d }
        if (r0 <= 0) goto L_0x015e;
    L_0x00e4:
        r1 = r12.m14349i();	 Catch:{ all -> 0x014d }
        r4 = 2;
        r0 = r10;
        r5 = r14;
        r7 = r0.m13580a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x014d }
    L_0x00ef:
        if (r7 == 0) goto L_0x0150;
    L_0x00f1:
        r0 = r7.getLocType();	 Catch:{ all -> 0x014d }
        if (r0 != r9) goto L_0x0150;
    L_0x00f7:
        r8 = new com.baidu.location.BDLocation;	 Catch:{ all -> 0x014d }
        r8.<init>(r7);	 Catch:{ all -> 0x014d }
    L_0x00fc:
        if (r13 == 0) goto L_0x0105;
    L_0x00fe:
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r6 = r2;
        r3.m13583a(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x014d }
    L_0x0105:
        if (r8 == 0) goto L_0x0148;
    L_0x0107:
        r0 = r8.getLocType();	 Catch:{ all -> 0x014d }
        if (r0 != r9) goto L_0x0148;
    L_0x010d:
        r0 = r8.getLongitude();	 Catch:{ all -> 0x014d }
        r2 = r8.getLatitude();	 Catch:{ all -> 0x014d }
        r4 = "gps2gcj";
        r0 = com.baidu.location.Jni.coorEncrypt(r0, r2, r4);	 Catch:{ all -> 0x014d }
        r1 = 0;
        r2 = r0[r1];	 Catch:{ all -> 0x014d }
        r8.setLongitude(r2);	 Catch:{ all -> 0x014d }
        r1 = 1;
        r0 = r0[r1];	 Catch:{ all -> 0x014d }
        r8.setLatitude(r0);	 Catch:{ all -> 0x014d }
        r0 = "gcj02";
        r8.setCoorType(r0);	 Catch:{ all -> 0x014d }
        r0 = new java.text.SimpleDateFormat;	 Catch:{ all -> 0x014d }
        r1 = "yyyy-MM-dd HH:mm:ss";
        r2 = java.util.Locale.US;	 Catch:{ all -> 0x014d }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x014d }
        r1 = new java.util.Date;	 Catch:{ all -> 0x014d }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x014d }
        r1.<init>(r2);	 Catch:{ all -> 0x014d }
        r0 = r0.format(r1);	 Catch:{ all -> 0x014d }
        r8.setTime(r0);	 Catch:{ all -> 0x014d }
    L_0x0148:
        r0 = 0;
        r10.f17636o = r0;	 Catch:{ all -> 0x014d }
        goto L_0x000e;
    L_0x014d:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0150:
        if (r2 == 0) goto L_0x00fc;
    L_0x0152:
        r0 = r2.getLocType();	 Catch:{ all -> 0x014d }
        if (r0 != r9) goto L_0x00fc;
    L_0x0158:
        r8 = new com.baidu.location.BDLocation;	 Catch:{ all -> 0x014d }
        r8.<init>(r2);	 Catch:{ all -> 0x014d }
        goto L_0x00fc;
    L_0x015e:
        r7 = r8;
        goto L_0x00ef;
    L_0x0160:
        r2 = r8;
        goto L_0x00a6;
    L_0x0163:
        r2 = r8;
        goto L_0x00d4;
    L_0x0166:
        r3 = r8;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.b.a(com.baidu.location.f.a, com.baidu.location.f.e, boolean, android.location.Location):com.baidu.location.BDLocation");
    }

    /* renamed from: a */
    public void m13590a(int i) {
        if (this.f17635n == null) {
            this.f17635n = new C32331(this);
        }
        if (C3349d.m14171a().m14187e() && ((int) (System.currentTimeMillis() / 1000)) - this.f17634m > i) {
            this.f17634m = (int) (System.currentTimeMillis() / 1000);
            if (C3376f.m14363j()) {
                this.f17635n.postDelayed(new C32342(this), (long) 20000);
            }
        }
    }

    /* renamed from: a */
    public void m13591a(BDLocation bDLocation) {
        if (bDLocation == null) {
            return;
        }
        if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
            this.f17638q = new BDLocation(bDLocation);
        }
    }

    /* renamed from: a */
    public void m13592a(String str) {
        if (str != null) {
            this.f17633l = str;
        }
    }

    /* renamed from: b */
    public void m13593b() {
        if (this.f17635n != null) {
            this.f17635n.sendEmptyMessage(1);
        }
    }
}
