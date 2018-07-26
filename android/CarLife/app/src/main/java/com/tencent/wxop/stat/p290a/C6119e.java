package com.tencent.wxop.stat.p290a;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.tencent.p280a.p281a.p282a.p283a.C6085h;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.C6161k;
import com.tencent.wxop.stat.ag;
import com.tencent.wxop.stat.p291b.C6134c;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.e */
public abstract class C6119e {
    /* renamed from: j */
    protected static String f24752j = null;
    /* renamed from: a */
    private C6161k f24753a = null;
    /* renamed from: b */
    protected String f24754b = null;
    /* renamed from: c */
    protected long f24755c;
    /* renamed from: d */
    protected int f24756d;
    /* renamed from: e */
    protected C6134c f24757e = null;
    /* renamed from: f */
    protected int f24758f;
    /* renamed from: g */
    protected String f24759g = null;
    /* renamed from: h */
    protected String f24760h = null;
    /* renamed from: i */
    protected String f24761i = null;
    /* renamed from: k */
    protected boolean f24762k = false;
    /* renamed from: l */
    protected Context f24763l;

    C6119e(Context context, int i, C6161k c6161k) {
        this.f24763l = context;
        this.f24755c = System.currentTimeMillis() / 1000;
        this.f24756d = i;
        this.f24760h = C6156f.m21998c(context);
        this.f24761i = C6144m.m21888j(context);
        this.f24754b = C6156f.m21988b(context);
        if (c6161k != null) {
            this.f24753a = c6161k;
            if (C6144m.m21876c(c6161k.m22156c())) {
                this.f24754b = c6161k.m22156c();
            }
            if (C6144m.m21876c(c6161k.m22158d())) {
                this.f24760h = c6161k.m22158d();
            }
            if (C6144m.m21876c(c6161k.m22153b())) {
                this.f24761i = c6161k.m22153b();
            }
            this.f24762k = c6161k.m22159e();
        }
        this.f24759g = C6156f.m22011e(context);
        this.f24757e = ag.m21760a(context).m21793b(context);
        if (mo5015a() != C6124f.NETWORK_DETECTOR) {
            this.f24758f = C6144m.m21897s(context).intValue();
        } else {
            this.f24758f = -C6124f.NETWORK_DETECTOR.m21728a();
        }
        if (!C6085h.m21668b(f24752j)) {
            String g = C6156f.m22021g(context);
            f24752j = g;
            if (!C6144m.m21876c(g)) {
                f24752j = "0";
            }
        }
    }

    /* renamed from: a */
    public abstract C6124f mo5015a();

    /* renamed from: a */
    public abstract boolean mo5016a(JSONObject jSONObject);

    /* renamed from: b */
    public boolean m21712b(JSONObject jSONObject) {
        boolean z = false;
        try {
            C6150s.m21920a(jSONObject, "ky", this.f24754b);
            jSONObject.put("et", mo5015a().m21728a());
            if (this.f24757e != null) {
                jSONObject.put("ui", this.f24757e.m21837b());
                C6150s.m21920a(jSONObject, Config.DEVICE_MAC_ID, this.f24757e.m21838c());
                int d = this.f24757e.m21839d();
                jSONObject.put("ut", d);
                if (d == 0 && C6144m.m21901w(this.f24763l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            C6150s.m21920a(jSONObject, "cui", this.f24759g);
            if (mo5015a() != C6124f.SESSION_ENV) {
                C6150s.m21920a(jSONObject, "av", this.f24761i);
                C6150s.m21920a(jSONObject, "ch", this.f24760h);
            }
            if (this.f24762k) {
                jSONObject.put("impt", 1);
            }
            C6150s.m21920a(jSONObject, "mid", f24752j);
            jSONObject.put("idx", this.f24758f);
            jSONObject.put("si", this.f24756d);
            jSONObject.put(MapObjKey.OBJ_SL_TIME, this.f24755c);
            jSONObject.put("dts", C6144m.m21861a(this.f24763l, false));
            z = mo5016a(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    /* renamed from: c */
    public long m21713c() {
        return this.f24755c;
    }

    /* renamed from: d */
    public C6161k m21714d() {
        return this.f24753a;
    }

    /* renamed from: e */
    public Context m21715e() {
        return this.f24763l;
    }

    /* renamed from: f */
    public boolean m21716f() {
        return this.f24762k;
    }

    /* renamed from: g */
    public String m21717g() {
        try {
            JSONObject jSONObject = new JSONObject();
            m21712b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
