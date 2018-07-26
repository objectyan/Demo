package com.baidu.carlife.logic;

import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.util.C2186p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OperatingActivitiesManager */
/* renamed from: com.baidu.carlife.logic.o */
public class C1856o {
    /* renamed from: a */
    private static final String f5729a = "https://vehicle.baidu.com/carlife/api/getnewestactivity";
    /* renamed from: b */
    private static final String f5730b = "newest";
    /* renamed from: c */
    private static final String f5731c = "key_newest_no";
    /* renamed from: d */
    private static final String f5732d = "key_read_no";
    /* renamed from: e */
    private static final String f5733e = "key_has_news";
    /* renamed from: h */
    private static C1856o f5734h;
    /* renamed from: f */
    private C1626e f5735f = new C1855a();
    /* renamed from: g */
    private boolean f5736g = C2186p.m8304a().m8312a(f5733e, false);

    /* compiled from: OperatingActivitiesManager */
    /* renamed from: com.baidu.carlife.logic.o$a */
    private class C1855a extends C1626e {
        /* renamed from: a */
        final /* synthetic */ C1856o f5728a;

        private C1855a(C1856o c1856o) {
            this.f5728a = c1856o;
        }

        protected String getUrl() {
            return C1856o.f5729a;
        }

        protected int responseSuccessCallBack(String data) {
            try {
                this.f5728a.m7043a(new JSONObject(data).optLong(C1856o.f5730b));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    private C1856o() {
    }

    /* renamed from: a */
    public static C1856o m7042a() {
        if (f5734h == null) {
            f5734h = new C1856o();
        }
        return f5734h;
    }

    /* renamed from: b */
    public boolean m7045b() {
        return this.f5736g;
    }

    /* renamed from: c */
    public void m7046c() {
        if (this.f5735f != null) {
            this.f5735f.cancel();
            this.f5735f.toGetRequest();
        }
    }

    /* renamed from: d */
    public void m7047d() {
        C2186p.m8304a().m8323c(f5733e, false);
        C2186p.m8304a().m8318b(f5732d, C2186p.m8304a().m8308a(f5731c, 0));
        this.f5736g = false;
    }

    /* renamed from: a */
    private void m7043a(long newest) {
        this.f5736g = C2186p.m8304a().m8312a(f5733e, false);
        long readNo = C2186p.m8304a().m8308a(f5732d, 0);
        if (this.f5736g) {
            if (newest > readNo) {
                C2186p.m8304a().m8318b(f5731c, newest);
            } else {
                C2186p.m8304a().m8323c(f5733e, false);
                C2186p.m8304a().m8318b(f5731c, newest);
                this.f5736g = false;
            }
        } else if (newest > readNo) {
            C2186p.m8304a().m8318b(f5731c, newest);
            C2186p.m8304a().m8323c(f5733e, true);
            this.f5736g = true;
        }
        C1261k.m4461b((int) C1253f.gi);
    }
}
