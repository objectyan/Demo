package com.baidu.location.p188h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.p020a.C0402a;
import com.baidu.android.bbalbs.common.p020a.C0407c;
import com.baidu.location.C3377f;
import com.baidu.location.p187a.C3202i;
import com.baidu.mobstat.Config;
import java.util.Locale;

/* renamed from: com.baidu.location.h.b */
public class C3381b {
    /* renamed from: d */
    public static String f18311d = null;
    /* renamed from: e */
    public static String f18312e = null;
    /* renamed from: f */
    public static String f18313f = null;
    /* renamed from: g */
    public static String f18314g = null;
    /* renamed from: h */
    private static C3381b f18315h = null;
    /* renamed from: a */
    public String f18316a = null;
    /* renamed from: b */
    public String f18317b = null;
    /* renamed from: c */
    public String f18318c = null;
    /* renamed from: i */
    private boolean f18319i = false;

    private C3381b() {
        if (C3377f.getServiceContext() != null) {
            m14401a(C3377f.getServiceContext());
        }
    }

    /* renamed from: a */
    public static C3381b m14398a() {
        if (f18315h == null) {
            f18315h = new C3381b();
        }
        return f18315h;
    }

    /* renamed from: a */
    public String m14399a(boolean z) {
        return m14400a(z, null);
    }

    /* renamed from: a */
    public String m14400a(boolean z, String str) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.32f);
        if (z) {
            if (C3391g.f18380g.equals("all")) {
                stringBuffer.append("&addr=allj");
            }
            if (C3391g.f18381h || C3391g.f18383j || C3391g.f18384k || C3391g.f18382i) {
                stringBuffer.append("&sema=");
                if (C3391g.f18381h) {
                    stringBuffer.append("aptag|");
                }
                if (C3391g.f18382i) {
                    stringBuffer.append("aptagd|");
                }
                if (C3391g.f18383j) {
                    stringBuffer.append("poiregion|");
                }
                if (C3391g.f18384k) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z) {
            if (str == null) {
                stringBuffer.append("&coor=gcj02");
            } else {
                stringBuffer.append("&coor=");
                stringBuffer.append(str);
            }
        }
        if (this.f18317b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.f18316a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f18317b);
            if (!(this.f18316a == null || this.f18316a.equals("NULL") || this.f18317b.contains(new StringBuffer(this.f18316a).reverse().toString()))) {
                stringBuffer.append("&Aim=");
                stringBuffer.append(this.f18316a);
            }
        }
        if (this.f18318c != null) {
            stringBuffer.append("&Aid=");
            stringBuffer.append(this.f18318c);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(C3377f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        String d = C3391g.m14446d();
        if (d != null) {
            stringBuffer.append("&laip=");
            stringBuffer.append(d);
        }
        if (C3202i.m13395a().m13406e() != 0.0f) {
            stringBuffer.append("&altv=");
            stringBuffer.append(String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(r0)}));
        }
        stringBuffer.append("&resid=");
        stringBuffer.append("13");
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        if (z) {
            stringBuffer.append("&sv=");
            d = VERSION.RELEASE;
            if (d != null && d.length() > 6) {
                d = d.substring(0, 6);
            }
            stringBuffer.append(d);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void m14401a(Context context) {
        if (context != null && !this.f18319i) {
            try {
                this.f18316a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e) {
                this.f18316a = "NULL";
            }
            try {
                this.f18317b = C0402a.a(context);
            } catch (Exception e2) {
                this.f18317b = null;
            }
            try {
                this.f18318c = C0407c.b(context);
            } catch (Exception e3) {
                this.f18318c = null;
            }
            try {
                f18311d = context.getPackageName();
            } catch (Exception e4) {
                f18311d = null;
            }
            C3391g.f18387n = "" + this.f18317b;
            this.f18319i = true;
        }
    }

    /* renamed from: a */
    public void m14402a(String str, String str2) {
        f18312e = str;
        f18311d = str2;
    }

    /* renamed from: b */
    public String m14403b() {
        return this.f18317b;
    }

    /* renamed from: c */
    public String m14404c() {
        return this.f18317b != null ? "v7.32|" + this.f18317b + "|" + Build.MODEL : "v7.32|" + this.f18316a + "|" + Build.MODEL;
    }

    /* renamed from: d */
    public String m14405d() {
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.f18317b != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f18317b);
        } else {
            stringBuffer.append("&im=");
            stringBuffer.append(this.f18316a);
        }
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception e) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(f18311d);
        } catch (Exception e2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.32f);
        return stringBuffer.toString();
    }

    /* renamed from: e */
    public String m14406e() {
        return "&sdk=7.32" + m14405d();
    }

    /* renamed from: f */
    public String m14407f() {
        return f18311d != null ? m14404c() + "|" + f18311d : m14404c();
    }

    /* renamed from: g */
    public String m14408g() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f18317b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.f18316a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f18317b);
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.32f);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        stringBuffer.append("&prod=");
        stringBuffer.append(f18312e + Config.TRACE_TODAY_VISIT_SPLIT + f18311d);
        stringBuffer.append(C3391g.m14449e(C3377f.getServiceContext()));
        stringBuffer.append("&resid=");
        stringBuffer.append("13");
        return stringBuffer.toString();
    }
}
