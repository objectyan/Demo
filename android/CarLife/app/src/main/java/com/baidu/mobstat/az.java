package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

public class az {
    /* renamed from: a */
    private static az f19411a;
    /* renamed from: b */
    private Context f19412b;
    /* renamed from: c */
    private JSONObject f19413c = new JSONObject();
    /* renamed from: d */
    private long f19414d = 24;
    /* renamed from: e */
    private long f19415e = 0;
    /* renamed from: f */
    private long f19416f = 0;
    /* renamed from: g */
    private long f19417g = 0;
    /* renamed from: h */
    private long f19418h = 5;
    /* renamed from: i */
    private long f19419i = 24;
    /* renamed from: j */
    private long f19420j = 15;
    /* renamed from: k */
    private long f19421k = 15;
    /* renamed from: l */
    private long f19422l = 30;
    /* renamed from: m */
    private long f19423m = 12;
    /* renamed from: n */
    private long f19424n = 1;
    /* renamed from: o */
    private long f19425o = 24;
    /* renamed from: p */
    private String f19426p = "";
    /* renamed from: q */
    private String f19427q = "";

    /* renamed from: a */
    public static az m15388a(Context context) {
        if (f19411a == null) {
            synchronized (az.class) {
                if (f19411a == null) {
                    f19411a = new az(context);
                }
            }
        }
        return f19411a;
    }

    private az(Context context) {
        this.f19412b = context;
        m15390m();
        m15406j();
        m15407k();
    }

    /* renamed from: m */
    private void m15390m() {
        Object b = cu.m15633b("backups/system/.timestamp");
        try {
            if (!TextUtils.isEmpty(b)) {
                this.f19413c = new JSONObject(b);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public boolean m15394a() {
        return this.f19415e != 0;
    }

    /* renamed from: b */
    public boolean m15397b() {
        return this.f19416f != 0;
    }

    /* renamed from: c */
    public long m15398c() {
        return ((this.f19414d * 60) * 60) * 1000;
    }

    /* renamed from: d */
    public long m15400d() {
        return ((this.f19425o * 60) * 60) * 1000;
    }

    /* renamed from: e */
    public long m15401e() {
        return (this.f19418h * 60) * 1000;
    }

    /* renamed from: f */
    public long m15402f() {
        return ((this.f19419i * 60) * 60) * 1000;
    }

    /* renamed from: g */
    public long m15403g() {
        return (((this.f19420j * 24) * 60) * 60) * 1000;
    }

    /* renamed from: h */
    public long m15404h() {
        return (((this.f19421k * 24) * 60) * 60) * 1000;
    }

    /* renamed from: i */
    public long m15405i() {
        return ((this.f19423m * 60) * 60) * 1000;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    public void m15406j() {
        /*
        r4 = this;
        r0 = r4.f19412b;
        r1 = ".config2";
        r0 = com.baidu.mobstat.cu.m15628a(r0, r1);
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x009d }
        r2 = 0;
        r3 = com.baidu.mobstat.cw.m15643a();	 Catch:{ Exception -> 0x009d }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x009d }
        r0 = com.baidu.mobstat.cv.m15640a(r0);	 Catch:{ Exception -> 0x009d }
        r0 = com.baidu.mobstat.dc.m15670b(r2, r3, r0);	 Catch:{ Exception -> 0x009d }
        r1.<init>(r0);	 Catch:{ Exception -> 0x009d }
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x009d }
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        return;
    L_0x0026:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x009d }
        r2.<init>(r1);	 Catch:{ Exception -> 0x009d }
        r0 = "c";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00a2 }
        r4.f19415e = r0;	 Catch:{ JSONException -> 0x00a2 }
    L_0x0034:
        r0 = "d";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00a7 }
        r4.f19418h = r0;	 Catch:{ JSONException -> 0x00a7 }
    L_0x003d:
        r0 = "e";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00ac }
        r4.f19419i = r0;	 Catch:{ JSONException -> 0x00ac }
    L_0x0046:
        r0 = "i";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00b1 }
        r4.f19420j = r0;	 Catch:{ JSONException -> 0x00b1 }
    L_0x004f:
        r0 = "f";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00b6 }
        r4.f19414d = r0;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0058:
        r0 = "s";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00bb }
        r4.f19425o = r0;	 Catch:{ JSONException -> 0x00bb }
    L_0x0061:
        r0 = "pk";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00c0 }
        r4.f19421k = r0;	 Catch:{ JSONException -> 0x00c0 }
    L_0x006a:
        r0 = "at";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00c5 }
        r4.f19422l = r0;	 Catch:{ JSONException -> 0x00c5 }
    L_0x0073:
        r0 = "as";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00ca }
        r4.f19423m = r0;	 Catch:{ JSONException -> 0x00ca }
    L_0x007c:
        r0 = "ac";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00cf }
        r4.f19424n = r0;	 Catch:{ JSONException -> 0x00cf }
    L_0x0085:
        r0 = "mc";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x00d4 }
        r4.f19416f = r0;	 Catch:{ JSONException -> 0x00d4 }
    L_0x008e:
        r0 = "lsc";
        r0 = r2.getLong(r0);	 Catch:{ JSONException -> 0x0098 }
        r4.f19417g = r0;	 Catch:{ JSONException -> 0x0098 }
        goto L_0x0025;
    L_0x0098:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0025;
    L_0x009d:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);
        goto L_0x0025;
    L_0x00a2:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0034;
    L_0x00a7:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x003d;
    L_0x00ac:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0046;
    L_0x00b1:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x004f;
    L_0x00b6:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0058;
    L_0x00bb:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0061;
    L_0x00c0:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x006a;
    L_0x00c5:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0073;
    L_0x00ca:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x007c;
    L_0x00cf:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x0085;
    L_0x00d4:
        r0 = move-exception;
        com.baidu.mobstat.bd.m15432b(r0);	 Catch:{ Exception -> 0x009d }
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.az.j():void");
    }

    /* renamed from: k */
    public void m15407k() {
        try {
            Object str = new String(dc.m15670b(false, cw.m15643a(), cv.m15640a(cu.m15628a(this.f19412b, ".sign").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.f19427q = jSONObject.getString("sign");
                } catch (Throwable e) {
                    bd.m15432b(e);
                }
                try {
                    this.f19426p = jSONObject.getString("ver");
                } catch (Throwable e2) {
                    bd.m15432b(e2);
                }
            }
        } catch (Throwable e22) {
            bd.m15432b(e22);
        }
    }

    /* renamed from: a */
    public void m15393a(String str) {
        cu.m15630a(this.f19412b, ".config2", str, false);
        m15406j();
    }

    /* renamed from: b */
    public void m15396b(String str) {
        cu.m15630a(this.f19412b, ".sign", str, false);
        m15407k();
    }

    /* renamed from: c */
    public String m15399c(String str) {
        if (TextUtils.isEmpty(this.f19426p) || !this.f19426p.equals(str) || TextUtils.isEmpty(this.f19427q)) {
            return "";
        }
        return this.f19427q;
    }

    /* renamed from: a */
    public long m15391a(C3606u c3606u) {
        long j = c3606u.f19671j;
        try {
            String c3606u2 = c3606u.toString();
            if (this.f19413c.has(c3606u2)) {
                j = this.f19413c.getLong(c3606u2);
            }
        } catch (Throwable e) {
            bd.m15429a(e);
        }
        return m15389b(j);
    }

    /* renamed from: a */
    public void m15392a(C3606u c3606u, long j) {
        c3606u.f19671j = j;
        try {
            this.f19413c.put(c3606u.toString(), j);
        } catch (Throwable e) {
            bd.m15429a(e);
        }
        try {
            cu.m15631a("backups/system/.timestamp", this.f19413c.toString(), false);
        } catch (Throwable e2) {
            bd.m15429a(e2);
        }
    }

    /* renamed from: l */
    public boolean m15408l() {
        long currentTimeMillis = System.currentTimeMillis();
        long a = m15391a(C3606u.LAST_SEND);
        long d = m15400d();
        bd.m15428a("canSend now=" + currentTimeMillis + ";lastSendTime=" + a + ";sendLogTimeInterval=" + d);
        return currentTimeMillis - a > d || !m15395a(a);
    }

    /* renamed from: a */
    public boolean m15395a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }

    /* renamed from: b */
    private long m15389b(long j) {
        return j - System.currentTimeMillis() > 0 ? 0 : j;
    }
}
