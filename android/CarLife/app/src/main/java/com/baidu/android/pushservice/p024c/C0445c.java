package com.baidu.android.pushservice.p024c;

import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.c.c */
public class C0445c {
    /* renamed from: a */
    private String f1391a;
    /* renamed from: b */
    private String f1392b;
    /* renamed from: c */
    private int f1393c;
    /* renamed from: d */
    private ArrayList<C0449e> f1394d;
    /* renamed from: e */
    private ArrayList<C0450f> f1395e;
    /* renamed from: f */
    private String f1396f;
    /* renamed from: g */
    private String f1397g;
    /* renamed from: h */
    private C0444a f1398h;

    /* renamed from: com.baidu.android.pushservice.c.c$a */
    public class C0444a {
        /* renamed from: a */
        public int f1388a;
        /* renamed from: b */
        public int f1389b;
        /* renamed from: c */
        final /* synthetic */ C0445c f1390c;

        public C0444a(C0445c c0445c) {
            this.f1390c = c0445c;
        }
    }

    public C0445c(String str) {
        this.f1391a = str;
        m1914d(str);
    }

    /* renamed from: d */
    private void m1914d(String str) {
        int i = 0;
        try {
            JSONArray jSONArray;
            JSONObject jSONObject;
            JSONObject jSONObject2 = new JSONObject(str);
            m1918a(jSONObject2.getString("manufacturer"));
            String string = jSONObject2.getString(NaviStatConstants.K_NSC_KEY_MODE_TYPE);
            if ("I".equalsIgnoreCase(string)) {
                m1916a(1);
            } else if ("I_HW".equalsIgnoreCase(string)) {
                m1916a(5);
            } else if ("I_XM".equalsIgnoreCase(string)) {
                m1916a(6);
            } else if ("I_MZ".equalsIgnoreCase(string)) {
                m1916a(7);
            } else if ("I_OP".equalsIgnoreCase(string)) {
                m1916a(8);
            } else if ("C".equalsIgnoreCase(string)) {
                m1916a(2);
            } else {
                m1916a(0);
            }
            ArrayList arrayList = new ArrayList();
            if (jSONObject2.has("osversion")) {
                jSONArray = jSONObject2.getJSONArray("osversion");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    jSONObject = jSONArray.getJSONObject(i2);
                    C0449e c0449e = new C0449e();
                    c0449e.m1959a(jSONObject.getString("key"));
                    c0449e.m1961b(jSONObject.getString("value"));
                    String string2 = jSONObject.getString("match");
                    if (string2.equalsIgnoreCase("above")) {
                        c0449e.m1958a(0);
                    } else if (string2.equalsIgnoreCase("equal")) {
                        c0449e.m1958a(1);
                    } else if (string2.equalsIgnoreCase("regular")) {
                        c0449e.m1958a(2);
                    }
                    arrayList.add(c0449e);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (jSONObject2.has("systemprop")) {
                jSONArray = jSONObject2.getJSONArray("systemprop");
                while (i < jSONArray.length()) {
                    jSONObject = jSONArray.getJSONObject(i);
                    C0450f c0450f = new C0450f();
                    c0450f.m1965a(jSONObject.getString("key"));
                    c0450f.m1967b(jSONObject.getString("value"));
                    String string3 = jSONObject.getString("match");
                    if (string3.equalsIgnoreCase("above")) {
                        c0450f.m1964a(0);
                    } else if (string3.equalsIgnoreCase("equal")) {
                        c0450f.m1964a(1);
                    }
                    c0450f.m1969c(jSONObject.getString("regular"));
                    arrayList2.add(c0450f);
                    i++;
                }
            }
            if (jSONObject2.has("apkname")) {
                m1921b(jSONObject2.getString("apkname"));
            }
            if (jSONObject2.has("apksign")) {
                m1924c(jSONObject2.getString("apksign"));
            }
            if (jSONObject2.has("apkversion")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("apkversion");
                m1917a(jSONObject3.optInt(PlatformConstants.CONNECT_EXTRA_KEY), jSONObject3.optInt("to"));
            }
            if (arrayList.size() > 0) {
                m1919a(arrayList);
            }
            if (arrayList2.size() > 0) {
                m1922b(arrayList2);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public C0444a m1915a() {
        return this.f1398h;
    }

    /* renamed from: a */
    public void m1916a(int i) {
        this.f1393c = i;
    }

    /* renamed from: a */
    public void m1917a(int i, int i2) {
        this.f1398h = new C0444a(this);
        this.f1398h.f1388a = i;
        this.f1398h.f1389b = i2;
    }

    /* renamed from: a */
    public void m1918a(String str) {
        this.f1392b = str;
    }

    /* renamed from: a */
    public void m1919a(ArrayList<C0449e> arrayList) {
        this.f1394d = arrayList;
    }

    /* renamed from: b */
    public String m1920b() {
        return this.f1392b;
    }

    /* renamed from: b */
    public void m1921b(String str) {
        this.f1396f = str;
    }

    /* renamed from: b */
    public void m1922b(ArrayList<C0450f> arrayList) {
        this.f1395e = arrayList;
    }

    /* renamed from: c */
    public int m1923c() {
        return this.f1393c;
    }

    /* renamed from: c */
    public void m1924c(String str) {
        this.f1397g = str;
    }

    /* renamed from: d */
    public ArrayList<C0449e> m1925d() {
        return this.f1394d;
    }

    /* renamed from: e */
    public ArrayList<C0450f> m1926e() {
        return this.f1395e;
    }

    /* renamed from: f */
    public String m1927f() {
        return this.f1396f;
    }

    /* renamed from: g */
    public String m1928g() {
        return this.f1397g;
    }

    public String toString() {
        return this.f1391a;
    }
}
