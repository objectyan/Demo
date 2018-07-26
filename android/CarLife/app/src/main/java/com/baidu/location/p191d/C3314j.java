package com.baidu.location.p191d;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.indoor.p197b.C3416d;
import com.baidu.location.p187a.C3200h;
import com.baidu.location.p187a.C3207j;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3382c;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p194f.C3376f;
import com.baidu.location.p195g.C3379a;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import com.facebook.common.p141m.C2924g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.d.j */
public class C3314j extends C3186e {
    /* renamed from: A */
    private C3312c f17951A;
    /* renamed from: B */
    private int f17952B;
    /* renamed from: C */
    private boolean f17953C;
    /* renamed from: D */
    private long f17954D;
    /* renamed from: E */
    private SQLiteDatabase f17955E;
    /* renamed from: F */
    private C3310b f17956F;
    /* renamed from: a */
    String f17957a;
    /* renamed from: b */
    String f17958b;
    /* renamed from: c */
    String f17959c;
    /* renamed from: d */
    private boolean f17960d;
    /* renamed from: e */
    private boolean f17961e;
    /* renamed from: f */
    private ArrayList<C3309a> f17962f;
    /* renamed from: p */
    private int f17963p;
    /* renamed from: q */
    private String f17964q;
    /* renamed from: r */
    private boolean f17965r;
    /* renamed from: s */
    private boolean f17966s;
    /* renamed from: t */
    private boolean f17967t;
    /* renamed from: u */
    private boolean f17968u;
    /* renamed from: v */
    private int f17969v;
    /* renamed from: w */
    private int f17970w;
    /* renamed from: x */
    private int f17971x;
    /* renamed from: y */
    private int f17972y;
    /* renamed from: z */
    private boolean f17973z;

    /* renamed from: com.baidu.location.d.j$1 */
    class C33051 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3314j f17933a;

        C33051(C3314j c3314j) {
            this.f17933a = c3314j;
        }

        public void run() {
            this.f17933a.m13927m();
        }
    }

    /* renamed from: com.baidu.location.d.j$2 */
    class C33062 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3314j f17934a;

        C33062(C3314j c3314j) {
            this.f17934a = c3314j;
        }

        public void run() {
            int i = 0;
            ArrayList b = this.f17934a.m13937b(C3376f.m14355a().m14380p().f18275a);
            if (b == null || b.size() <= 0) {
                this.f17934a.f17952B = this.f17934a.f17952B + 1;
                return;
            }
            this.f17934a.f17952B = 0;
            Bundle bundle = new Bundle();
            int size = b.size();
            if (size > 3) {
                size = 3;
            }
            int i2 = 0;
            while (i2 < size) {
                int i3;
                byte[] a = C3314j.m13918b((String) b.get(i2));
                if (a == null || a.length != 6) {
                    i3 = i;
                } else {
                    bundle.putByteArray("mac" + i, a);
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
            if (i != 0) {
                Message obtainMessage = C3294d.m13799a().m13835e().obtainMessage(1);
                bundle.putInt("num", i);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* renamed from: com.baidu.location.d.j$3 */
    class C33073 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3314j f17935a;

        C33073(C3314j c3314j) {
            this.f17935a = c3314j;
        }

        public void run() {
            if (C3376f.m14363j()) {
                this.f17935a.m13300h();
                C3382c.m14410a().m14420e(System.currentTimeMillis());
            }
        }
    }

    /* renamed from: com.baidu.location.d.j$4 */
    class C33084 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3314j f17936a;

        C33084(C3314j c3314j) {
            this.f17936a = c3314j;
        }

        public void run() {
            this.f17936a.m13931q();
        }
    }

    /* renamed from: com.baidu.location.d.j$a */
    private class C3309a {
        /* renamed from: a */
        int f17937a;
        /* renamed from: b */
        double f17938b;
        /* renamed from: c */
        double f17939c;
        /* renamed from: d */
        double f17940d;
        /* renamed from: e */
        double f17941e;
        /* renamed from: f */
        boolean f17942f = false;
        /* renamed from: g */
        final /* synthetic */ C3314j f17943g;

        C3309a(C3314j c3314j, Cursor cursor) {
            this.f17943g = c3314j;
            try {
                this.f17937a = cursor.getInt(0);
                this.f17938b = cursor.getDouble(4);
                this.f17939c = cursor.getDouble(3);
                this.f17940d = cursor.getDouble(2);
                this.f17941e = cursor.getDouble(1);
                this.f17942f = true;
            } catch (Exception e) {
                this.f17942f = false;
            }
        }
    }

    /* renamed from: com.baidu.location.d.j$b */
    public enum C3310b {
        NET_FRONT,
        NET_BACK,
        GPS
    }

    /* renamed from: com.baidu.location.d.j$c */
    private class C3312c implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3314j f17949a;

        /* renamed from: com.baidu.location.d.j$c$1 */
        class C33111 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C3312c f17948a;

            C33111(C3312c c3312c) {
                this.f17948a = c3312c;
            }

            public void run() {
                if (this.f17948a.f17949a.m13936a(C3376f.m14355a().m14380p().f18275a)) {
                    C3200h.m13362c().m13389h();
                }
            }
        }

        private C3312c(C3314j c3314j) {
            this.f17949a = c3314j;
        }

        public void run() {
            if (this.f17949a.f17973z) {
                this.f17949a.f17973z = false;
                if (this.f17949a.f17956F == C3310b.NET_BACK) {
                    if (C3376f.m14355a().m14372g()) {
                        C3379a.m14386a().postDelayed(new C33111(this), 3000);
                    }
                    C3379a.m14386a().postDelayed(this.f17949a.f17951A, (long) (this.f17949a.f17970w * 1000));
                    this.f17949a.f17973z = true;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.j$d */
    private static class C3313d {
        /* renamed from: a */
        public static final C3314j f17950a = new C3314j();
    }

    private C3314j() {
        this.f17960d = false;
        this.f17961e = false;
        this.f17962f = null;
        this.f17963p = 0;
        this.f17964q = "0";
        this.f17965r = true;
        this.f17966s = true;
        this.f17967t = true;
        this.f17968u = true;
        this.f17969v = 60;
        this.f17970w = 120;
        this.f17971x = 15;
        this.f17972y = 20;
        this.f17973z = false;
        this.f17951A = null;
        this.f17952B = 0;
        this.f17953C = false;
        this.f17954D = 0;
        this.f17957a = null;
        this.f17958b = null;
        this.f17959c = null;
        this.f17955E = null;
        this.f17956F = C3310b.NET_FRONT;
        try {
            File file = new File(C3391g.m14456l() + File.separator + "bus_mac.db");
            File file2 = new File(C3391g.m14456l() + File.separator + "bus_mac_repll.db");
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                this.f17960d = true;
            } else if (file2.exists()) {
                this.f17960d = true;
            } else {
                this.f17960d = false;
            }
        } catch (Exception e) {
            this.f17960d = false;
        }
    }

    /* renamed from: a */
    private static byte m13911a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: b */
    public static C3314j m13917b() {
        return C3313d.f17950a;
    }

    /* renamed from: b */
    private static byte[] m13918b(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String toUpperCase = str.toUpperCase(Locale.US);
        int length = toUpperCase.length() / 2;
        char[] toCharArray = toUpperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (C3314j.m13911a(toCharArray[i2 + 1]) | (C3314j.m13911a(toCharArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: d */
    private void m13921d(String str) {
        Editor edit = C3377f.getServiceContext().getSharedPreferences("loc_realbus_config", 0).edit();
        edit.putString("config", str);
        edit.commit();
    }

    /* renamed from: k */
    private boolean m13925k() {
        return C3218c.m13487a().m13495f() >= this.f17972y;
    }

    /* renamed from: l */
    private void m13926l() {
        this.f17953C = false;
        this.f17952B = 0;
        this.f17954D = 0;
    }

    /* renamed from: m */
    private void m13927m() {
        if (this.f17953C && this.f17956F == C3310b.GPS) {
            this.f17953C = false;
            if (this.f17965r && this.f17968u) {
                m13928n();
            }
        }
    }

    /* renamed from: n */
    private void m13928n() {
        C3379a.m14386a().post(new C33062(this));
    }

    /* renamed from: o */
    private void m13929o() {
        if (System.currentTimeMillis() - C3382c.m14410a().m14419e() > 86400000) {
            C3379a.m14386a().postDelayed(new C33073(this), 7000);
        }
    }

    /* renamed from: p */
    private void m13930p() {
        Object string = C3377f.getServiceContext().getSharedPreferences("loc_realbus_config", 0).getString("config", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("is_on") && !jSONObject.getString("is_on").equals("on")) {
                    this.f17965r = false;
                }
                if (jSONObject.has("is_net_front_on") && !jSONObject.getString("is_net_front_on").equals("on")) {
                    this.f17966s = false;
                }
                if (jSONObject.has("is_net_back_on") && !jSONObject.getString("is_net_back_on").equals("on")) {
                    this.f17967t = false;
                }
                if (jSONObject.has("is_gps_on") && !jSONObject.getString("is_gps_on").equals("on")) {
                    this.f17968u = false;
                }
                if (jSONObject.has("net_front_threshold")) {
                    this.f17969v = jSONObject.getInt("net_front_threshold");
                }
                if (jSONObject.has("net_back_threshold")) {
                    this.f17970w = jSONObject.getInt("net_back_threshold");
                }
                if (jSONObject.has("gps_threshold")) {
                    this.f17971x = jSONObject.getInt("gps_threshold");
                }
                if (jSONObject.has("battery_threshold")) {
                    this.f17972y = jSONObject.getInt("battery_threshold");
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: q */
    private void m13931q() {
        if (this.f17958b != null && C3376f.m14363j()) {
            try {
                File file = new File(C3391g.m14456l() + File.separator + this.f17958b);
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists() && C3207j.m13416a("http://" + this.f17957a + "/" + this.f17958b, this.f17958b)) {
                    String a = C3391g.m14435a(file, "MD5");
                    if (!(this.f17959c == null || a == null || !this.f17959c.equals(a))) {
                        new C3416d().m14594a(C3391g.m14456l() + File.separator + this.f17958b, C3391g.m14456l() + File.separator);
                    }
                    file.delete();
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void mo2494a() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.32f);
        stringBuffer.append("&fw=");
        stringBuffer.append(C3377f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(1);
        if (C3381b.m14398a().f18317b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(C3381b.m14398a().f18316a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(C3381b.m14398a().f18317b);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str = VERSION.RELEASE;
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        stringBuffer.append(str);
        stringBuffer.append("&pack=");
        stringBuffer.append(C3381b.f18311d);
        stringBuffer.append("&ver=");
        stringBuffer.append("" + this.f17964q);
        this.h = C3391g.m14451g() + "?&it=" + Jni.en1(stringBuffer.toString());
    }

    /* renamed from: a */
    public void m13933a(double d, double d2) {
        if (!this.f17961e) {
            this.f17961e = true;
            if (this.f17960d && this.f17962f != null && this.f17962f.size() > 0) {
                int i = 0;
                while (i < this.f17962f.size()) {
                    C3309a c3309a = (C3309a) this.f17962f.get(i);
                    if (d > c3309a.f17938b || d < c3309a.f17939c || d2 < c3309a.f17941e || d2 > c3309a.f17940d) {
                        i++;
                    } else {
                        this.f17963p = c3309a.f17937a;
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m13934a(C3310b c3310b) {
        this.f17956F = c3310b;
        if (this.f17973z && this.f17951A != null) {
            C3379a.m14386a().removeCallbacks(this.f17951A);
        }
        if (this.f17956F != C3310b.GPS) {
            if (this.f17956F == C3310b.NET_FRONT) {
                m13926l();
                return;
            }
            m13926l();
            if (this.f17965r && this.f17967t && m13925k()) {
                if (this.f17951A == null) {
                    this.f17951A = new C3312c();
                }
                C3379a.m14386a().postDelayed(this.f17951A, (long) (this.f17970w * 1000));
                this.f17973z = true;
            }
        }
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                String string = jSONObject.getString(C2924g.f12892f);
                if (OfflineMapKey.OFFLINE_UPDATE.equals(string)) {
                    this.f17957a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.f17958b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u1_md5")) {
                        this.f17959c = jSONObject.getString("u1_md5");
                    }
                    new C33084(this).start();
                }
                if (!"fail".equals(string)) {
                    m13921d(jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public boolean m13936a(List<ScanResult> list) {
        ArrayList b = m13937b((List) list);
        return b != null && b.size() > 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public java.util.ArrayList<java.lang.String> m13937b(java.util.List<android.net.wifi.ScanResult> r11) {
        /*
        r10 = this;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        java.lang.System.currentTimeMillis();
        r0 = r10.f17963p;
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r10.f17955E;
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r4;
    L_0x000f:
        if (r11 == 0) goto L_0x000e;
    L_0x0011:
        r0 = r11.size();
        if (r0 == 0) goto L_0x000e;
    L_0x0017:
        r5 = new java.util.HashMap;
        r5.<init>();
        r6 = r11.iterator();
        r7 = new java.lang.StringBuffer;
        r7.<init>();
        r1 = r2;
    L_0x0026:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x005e;
    L_0x002c:
        r0 = r6.next();
        r0 = (android.net.wifi.ScanResult) r0;
        r0 = r0.BSSID;
        r8 = android.text.TextUtils.isEmpty(r0);
        if (r8 != 0) goto L_0x005c;
    L_0x003a:
        r8 = ":";
        r9 = "";
        r0 = r0.replace(r8, r9);
        r8 = com.baidu.location.Jni.encode3(r0);
        r5.put(r8, r0);
        if (r1 == 0) goto L_0x0053;
    L_0x004d:
        r7.append(r8);
        r0 = r3;
    L_0x0051:
        r1 = r0;
        goto L_0x0026;
    L_0x0053:
        r0 = ",";
        r7.append(r0);
        r7.append(r8);
    L_0x005c:
        r0 = r1;
        goto L_0x0051;
    L_0x005e:
        r0 = r7.toString();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x00e1;
    L_0x0068:
        r0 = java.util.Locale.US;
        r1 = "select * from bus_mac_data_%d where mac in (%s);";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r8 = r10.f17963p;
        r8 = java.lang.Integer.valueOf(r8);
        r6[r3] = r8;
        r3 = r7.toString();
        r6[r2] = r3;
        r0 = java.lang.String.format(r0, r1, r6);
        r1 = r10.f17955E;	 Catch:{ Exception -> 0x00d8, all -> 0x00ca }
        r2 = 0;
        r1 = r1.rawQuery(r0, r2);	 Catch:{ Exception -> 0x00d8, all -> 0x00ca }
        if (r1 == 0) goto L_0x00df;
    L_0x008b:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00db, all -> 0x00d6 }
        if (r0 == 0) goto L_0x00df;
    L_0x0091:
        if (r4 != 0) goto L_0x0099;
    L_0x0093:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00db, all -> 0x00d6 }
        r0.<init>();	 Catch:{ Exception -> 0x00db, all -> 0x00d6 }
        r4 = r0;
    L_0x0099:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x00b3, all -> 0x00d6 }
        if (r0 != 0) goto L_0x00c1;
    L_0x009f:
        r0 = 0;
        r2 = r1.getLong(r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00d6 }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00b3, all -> 0x00d6 }
        r0 = r5.get(r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00d6 }
        r4.add(r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00d6 }
        r1.moveToNext();	 Catch:{ Exception -> 0x00b3, all -> 0x00d6 }
        goto L_0x0099;
    L_0x00b3:
        r0 = move-exception;
        r0 = r4;
        r4 = r1;
    L_0x00b6:
        if (r4 == 0) goto L_0x00bb;
    L_0x00b8:
        r4.close();	 Catch:{ Exception -> 0x00d2 }
    L_0x00bb:
        java.lang.System.currentTimeMillis();
        r4 = r0;
        goto L_0x000e;
    L_0x00c1:
        r0 = r4;
    L_0x00c2:
        if (r1 == 0) goto L_0x00bb;
    L_0x00c4:
        r1.close();	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00bb;
    L_0x00c8:
        r1 = move-exception;
        goto L_0x00bb;
    L_0x00ca:
        r0 = move-exception;
        r1 = r4;
    L_0x00cc:
        if (r1 == 0) goto L_0x00d1;
    L_0x00ce:
        r1.close();	 Catch:{ Exception -> 0x00d4 }
    L_0x00d1:
        throw r0;
    L_0x00d2:
        r1 = move-exception;
        goto L_0x00bb;
    L_0x00d4:
        r1 = move-exception;
        goto L_0x00d1;
    L_0x00d6:
        r0 = move-exception;
        goto L_0x00cc;
    L_0x00d8:
        r0 = move-exception;
        r0 = r4;
        goto L_0x00b6;
    L_0x00db:
        r0 = move-exception;
        r0 = r4;
        r4 = r1;
        goto L_0x00b6;
    L_0x00df:
        r0 = r4;
        goto L_0x00c2;
    L_0x00e1:
        r0 = r4;
        goto L_0x00bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.j.b(java.util.List):java.util.ArrayList<java.lang.String>");
    }

    /* renamed from: c */
    public void mo2499c() {
        if (this.f17965r && this.f17968u && m13925k()) {
            this.f17953C = false;
            if (this.f17952B > 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.f17954D;
                if (currentTimeMillis <= ((long) ((this.f17952B - 3) * ((this.f17971x * 2) * 1000))) && currentTimeMillis <= 120000) {
                    return;
                }
            }
            C3376f.m14355a().m14372g();
            this.f17953C = true;
            this.f17954D = System.currentTimeMillis();
            C3379a.m14386a().postDelayed(new C33051(this), 3000);
        }
    }

    /* renamed from: d */
    public boolean m13939d() {
        boolean z = this.f17956F == C3310b.NET_FRONT;
        if (!(this.f17965r && this.f17966s)) {
            z = false;
        }
        return !m13925k() ? false : z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public void m13940e() {
        /*
        r6 = this;
        r0 = 0;
        r6.f17955E = r0;
        r1 = r6.f17960d;
        if (r1 == 0) goto L_0x0085;
    L_0x0007:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.baidu.location.p188h.C3391g.m14456l();
        r1 = r1.append(r2);
        r2 = java.io.File.separator;
        r1 = r1.append(r2);
        r2 = "bus_mac_repll.db";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        r1 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r1, r2);	 Catch:{ Exception -> 0x008c }
        r6.f17955E = r1;	 Catch:{ Exception -> 0x008c }
    L_0x002c:
        r1 = r6.f17955E;
        if (r1 == 0) goto L_0x0085;
    L_0x0030:
        r1 = r6.f17955E;	 Catch:{ Exception -> 0x00c3, all -> 0x009d }
        r2 = "select * from bus_mac_version;";
        r3 = 0;
        r1 = r1.rawQuery(r2, r3);	 Catch:{ Exception -> 0x00c3, all -> 0x009d }
        if (r1 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x007a, all -> 0x00b7 }
        if (r2 == 0) goto L_0x0049;
    L_0x0042:
        r2 = 0;
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x007a, all -> 0x00b7 }
        r6.f17964q = r2;	 Catch:{ Exception -> 0x007a, all -> 0x00b7 }
    L_0x0049:
        r2 = r6.f17955E;	 Catch:{ Exception -> 0x007a, all -> 0x00b7 }
        r3 = "select * from bus_mac_city;";
        r4 = 0;
        r0 = r2.rawQuery(r3, r4);	 Catch:{ Exception -> 0x007a, all -> 0x00b7 }
        if (r0 == 0) goto L_0x0090;
    L_0x0055:
        r2 = r0.moveToFirst();	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        if (r2 == 0) goto L_0x0090;
    L_0x005b:
        r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        r2.<init>();	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        r6.f17962f = r2;	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
    L_0x0062:
        r2 = r0.isAfterLast();	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        if (r2 != 0) goto L_0x0090;
    L_0x0068:
        r2 = new com.baidu.location.d.j$a;	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        r2.<init>(r6, r0);	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        r3 = r2.f17942f;	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        if (r3 == 0) goto L_0x0076;
    L_0x0071:
        r3 = r6.f17962f;	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        r3.add(r2);	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
    L_0x0076:
        r0.moveToNext();	 Catch:{ Exception -> 0x007a, all -> 0x00bd }
        goto L_0x0062;
    L_0x007a:
        r2 = move-exception;
    L_0x007b:
        if (r1 == 0) goto L_0x0080;
    L_0x007d:
        r1.close();	 Catch:{ Exception -> 0x00af }
    L_0x0080:
        if (r0 == 0) goto L_0x0085;
    L_0x0082:
        r0.close();	 Catch:{ Exception -> 0x00b1 }
    L_0x0085:
        r6.m13930p();
        r6.m13929o();
        return;
    L_0x008c:
        r1 = move-exception;
        r6.f17955E = r0;
        goto L_0x002c;
    L_0x0090:
        if (r1 == 0) goto L_0x0095;
    L_0x0092:
        r1.close();	 Catch:{ Exception -> 0x00ad }
    L_0x0095:
        if (r0 == 0) goto L_0x0085;
    L_0x0097:
        r0.close();	 Catch:{ Exception -> 0x009b }
        goto L_0x0085;
    L_0x009b:
        r0 = move-exception;
        goto L_0x0085;
    L_0x009d:
        r1 = move-exception;
        r2 = r0;
        r5 = r0;
        r0 = r1;
        r1 = r5;
    L_0x00a2:
        if (r2 == 0) goto L_0x00a7;
    L_0x00a4:
        r2.close();	 Catch:{ Exception -> 0x00b3 }
    L_0x00a7:
        if (r1 == 0) goto L_0x00ac;
    L_0x00a9:
        r1.close();	 Catch:{ Exception -> 0x00b5 }
    L_0x00ac:
        throw r0;
    L_0x00ad:
        r1 = move-exception;
        goto L_0x0095;
    L_0x00af:
        r1 = move-exception;
        goto L_0x0080;
    L_0x00b1:
        r0 = move-exception;
        goto L_0x0085;
    L_0x00b3:
        r2 = move-exception;
        goto L_0x00a7;
    L_0x00b5:
        r1 = move-exception;
        goto L_0x00ac;
    L_0x00b7:
        r2 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x00a2;
    L_0x00bd:
        r2 = move-exception;
        r5 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x00a2;
    L_0x00c3:
        r1 = move-exception;
        r1 = r0;
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.j.e():void");
    }

    /* renamed from: f */
    public void m13941f() {
        if (this.f17955E != null) {
            try {
                this.f17955E.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: g */
    public int m13942g() {
        return this.f17969v;
    }
}
