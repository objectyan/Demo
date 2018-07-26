package com.baidu.location.p191d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.baidu.location.d.e */
public class C3296e {
    /* renamed from: b */
    private static C3296e f17883b = null;
    /* renamed from: a */
    SharedPreferences f17884a = null;
    /* renamed from: c */
    private boolean f17885c = true;
    /* renamed from: d */
    private int f17886d = 14400000;
    /* renamed from: e */
    private int f17887e = 10;
    /* renamed from: f */
    private Map<String, Long> f17888f = null;
    /* renamed from: g */
    private int f17889g = 0;
    /* renamed from: h */
    private String f17890h = C3391g.m14445c();

    /* renamed from: com.baidu.location.d.e$a */
    private class C3295a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3296e f17881a;
        /* renamed from: b */
        private String f17882b;

        public C3295a(C3296e c3296e, String str) {
            this.f17881a = c3296e;
            this.f17882b = str;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            this.k.put(OfflineMapKey.OFFLINE_UPDATE, this.f17882b);
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j == null) {
                this.k.clear();
            } else {
                this.k.clear();
            }
        }

        /* renamed from: b */
        public void mo2500b() {
            m13299c(C3391g.f18379f);
        }
    }

    private C3296e() {
        if (this.f17884a == null) {
            this.f17884a = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0);
            if (this.f17884a != null) {
                this.f17885c = this.f17884a.getBoolean("ipLocInfoUpload", true);
                this.f17886d = this.f17884a.getInt("ipValidTime", 14400000);
                this.f17887e = this.f17884a.getInt("ipLocInfoUploadTimesPerDay", 10);
                this.f17889g = this.f17884a.getInt("ipLocInfoUploadTimesPerDayNum", 0);
                this.f17890h = this.f17884a.getString("lastDay", C3391g.m14445c());
            }
        }
    }

    /* renamed from: a */
    public static synchronized C3296e m13839a() {
        C3296e c3296e;
        synchronized (C3296e.class) {
            if (f17883b == null) {
                f17883b = new C3296e();
            }
            c3296e = f17883b;
        }
        return c3296e;
    }

    /* renamed from: a */
    private String m13840a(C3362a c3362a, C3372e c3372e, Location location, String str) {
        return Jni.encodeTp4(C3391g.m14432a(c3362a, c3372e, location, str));
    }

    /* renamed from: c */
    private void m13841c(String str) {
        new C3295a(this, str).mo2500b();
    }

    /* renamed from: a */
    public void m13842a(String str) {
        if (this.f17885c && str != null && str.length() == 12) {
            if (this.f17888f == null) {
                this.f17888f = new HashMap();
            }
            this.f17888f.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: b */
    public void m13843b(String str) {
        if (this.f17885c && str != null && str.length() == 12 && C3376f.m14363j()) {
            Editor edit;
            if (!C3391g.m14445c().equals(this.f17890h)) {
                this.f17889g = 0;
                this.f17890h = C3391g.m14445c();
                if (this.f17884a != null) {
                    edit = this.f17884a.edit();
                    edit.putInt("ipLocInfoUploadTimesPerDayNum", this.f17889g);
                    edit.putString("lastDay", this.f17890h);
                    edit.commit();
                }
            }
            if (this.f17889g < this.f17887e) {
                int i;
                if (this.f17888f == null) {
                    this.f17888f = new HashMap();
                    this.f17888f.put(str, Long.valueOf(System.currentTimeMillis()));
                    i = 1;
                } else if (!this.f17888f.containsKey(str)) {
                    this.f17888f.put(str, Long.valueOf(System.currentTimeMillis()));
                    i = 1;
                } else if (Math.abs(((Long) this.f17888f.get(str)).longValue() - System.currentTimeMillis()) <= ((long) this.f17886d)) {
                    i = 0;
                } else {
                    this.f17888f.put(str, Long.valueOf(System.currentTimeMillis()));
                    i = 1;
                }
                if (i != 0) {
                    String str2;
                    this.f17889g++;
                    if (this.f17884a != null) {
                        edit = this.f17884a.edit();
                        edit.putInt("ipLocInfoUploadTimesPerDayNum", this.f17889g);
                        edit.putString("lastDay", this.f17890h);
                        edit.commit();
                    }
                    String str3 = C3181a.m13265a().m13283f() + "&ipload=1";
                    if (C3376f.m14363j()) {
                        str2 = "&cn=32";
                    } else {
                        str2 = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(C3364b.m14262a().m14279e())});
                    }
                    m13841c(m13840a(C3364b.m14262a().m14280f(), C3376f.m14355a().m14380p(), null, str2 + str3));
                }
            }
        }
    }
}
