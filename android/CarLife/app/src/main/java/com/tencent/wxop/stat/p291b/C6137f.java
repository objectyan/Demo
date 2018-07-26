package com.tencent.wxop.stat.p291b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.mobstat.Config;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.C6162l;
import com.tencent.wxop.stat.ag;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.b.f */
class C6137f {
    /* renamed from: a */
    String f24902a;
    /* renamed from: b */
    String f24903b;
    /* renamed from: c */
    DisplayMetrics f24904c;
    /* renamed from: d */
    int f24905d;
    /* renamed from: e */
    String f24906e;
    /* renamed from: f */
    String f24907f;
    /* renamed from: g */
    String f24908g;
    /* renamed from: h */
    String f24909h;
    /* renamed from: i */
    String f24910i;
    /* renamed from: j */
    String f24911j;
    /* renamed from: k */
    String f24912k;
    /* renamed from: l */
    int f24913l;
    /* renamed from: m */
    String f24914m;
    /* renamed from: n */
    String f24915n;
    /* renamed from: o */
    Context f24916o;
    /* renamed from: p */
    private String f24917p;
    /* renamed from: q */
    private String f24918q;
    /* renamed from: r */
    private String f24919r;
    /* renamed from: s */
    private String f24920s;

    private C6137f(Context context) {
        this.f24903b = C6132a.f24873a;
        this.f24905d = VERSION.SDK_INT;
        this.f24906e = Build.MODEL;
        this.f24907f = Build.MANUFACTURER;
        this.f24908g = Locale.getDefault().getLanguage();
        this.f24913l = 0;
        this.f24914m = null;
        this.f24915n = null;
        this.f24916o = null;
        this.f24917p = null;
        this.f24918q = null;
        this.f24919r = null;
        this.f24920s = null;
        this.f24916o = context.getApplicationContext();
        this.f24904c = C6144m.m21877d(this.f24916o);
        this.f24902a = C6144m.m21888j(this.f24916o);
        this.f24909h = C6156f.m21998c(this.f24916o);
        this.f24910i = C6144m.m21887i(this.f24916o);
        this.f24911j = TimeZone.getDefault().getID();
        this.f24913l = C6144m.m21893o(this.f24916o);
        this.f24912k = C6144m.m21894p(this.f24916o);
        this.f24914m = this.f24916o.getPackageName();
        if (this.f24905d >= 14) {
            this.f24917p = C6144m.m21900v(this.f24916o);
        }
        this.f24918q = C6144m.m21899u(this.f24916o).toString();
        this.f24919r = C6144m.m21898t(this.f24916o);
        this.f24920s = C6144m.m21878d();
        this.f24915n = C6144m.m21858C(this.f24916o);
    }

    /* renamed from: a */
    void m21843a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.f24904c != null) {
                jSONObject.put("sr", this.f24904c.widthPixels + "*" + this.f24904c.heightPixels);
                jSONObject.put("dpi", this.f24904c.xdpi + "*" + this.f24904c.ydpi);
            }
            if (C6162l.m22161a(this.f24916o).m22172e()) {
                JSONObject jSONObject2 = new JSONObject();
                C6150s.m21920a(jSONObject2, "bs", C6150s.m21925d(this.f24916o));
                C6150s.m21920a(jSONObject2, "ss", C6150s.m21926e(this.f24916o));
                if (jSONObject2.length() > 0) {
                    C6150s.m21920a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray a = C6150s.m21919a(this.f24916o, 10);
            if (a != null && a.length() > 0) {
                C6150s.m21920a(jSONObject, "wflist", a.toString());
            }
            C6150s.m21920a(jSONObject, "sen", this.f24917p);
        } else {
            C6150s.m21920a(jSONObject, "thn", thread.getName());
            C6150s.m21920a(jSONObject, "qq", C6156f.m22005d(this.f24916o));
            C6150s.m21920a(jSONObject, "cui", C6156f.m22011e(this.f24916o));
            if (C6144m.m21876c(this.f24919r) && this.f24919r.split("/").length == 2) {
                C6150s.m21920a(jSONObject, "fram", this.f24919r.split("/")[0]);
            }
            if (C6144m.m21876c(this.f24920s) && this.f24920s.split("/").length == 2) {
                C6150s.m21920a(jSONObject, PlatformConstants.CONNECT_EXTRA_KEY, this.f24920s.split("/")[0]);
            }
            if (ag.m21760a(this.f24916o).m21793b(this.f24916o) != null) {
                jSONObject.put("ui", ag.m21760a(this.f24916o).m21793b(this.f24916o).m21837b());
            }
            C6150s.m21920a(jSONObject, "mid", C6156f.m22021g(this.f24916o));
        }
        C6150s.m21920a(jSONObject, "pcn", C6144m.m21895q(this.f24916o));
        C6150s.m21920a(jSONObject, "osn", VERSION.RELEASE);
        C6150s.m21920a(jSONObject, "av", this.f24902a);
        C6150s.m21920a(jSONObject, "ch", this.f24909h);
        C6150s.m21920a(jSONObject, "mf", this.f24907f);
        C6150s.m21920a(jSONObject, "sv", this.f24903b);
        C6150s.m21920a(jSONObject, "osd", Build.DISPLAY);
        C6150s.m21920a(jSONObject, "prod", Build.PRODUCT);
        C6150s.m21920a(jSONObject, "tags", Build.TAGS);
        C6150s.m21920a(jSONObject, "id", Build.ID);
        C6150s.m21920a(jSONObject, "fng", Build.FINGERPRINT);
        C6150s.m21920a(jSONObject, "lch", this.f24915n);
        C6150s.m21920a(jSONObject, "ov", Integer.toString(this.f24905d));
        jSONObject.put("os", 1);
        C6150s.m21920a(jSONObject, Config.OPERATOR, this.f24910i);
        C6150s.m21920a(jSONObject, "lg", this.f24908g);
        C6150s.m21920a(jSONObject, "md", this.f24906e);
        C6150s.m21920a(jSONObject, "tz", this.f24911j);
        if (this.f24913l != 0) {
            jSONObject.put("jb", this.f24913l);
        }
        C6150s.m21920a(jSONObject, "sd", this.f24912k);
        C6150s.m21920a(jSONObject, "apn", this.f24914m);
        C6150s.m21920a(jSONObject, "cpu", this.f24918q);
        C6150s.m21920a(jSONObject, "abi", Build.CPU_ABI);
        C6150s.m21920a(jSONObject, "abi2", Build.CPU_ABI2);
        C6150s.m21920a(jSONObject, "ram", this.f24919r);
        C6150s.m21920a(jSONObject, Config.ROM, this.f24920s);
    }
}
