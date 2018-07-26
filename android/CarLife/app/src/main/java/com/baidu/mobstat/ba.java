package com.baidu.mobstat;

import android.content.Context;
import com.baidu.carlife.core.audio.C1163a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ba {
    /* renamed from: a */
    public static final ba f19429a = new ba();

    /* renamed from: a */
    public void m15422a(Context context, JSONObject jSONObject) {
        bd.m15428a("startDataAnynalyzed start");
        m15412a(jSONObject);
        az a = az.m15388a(context);
        boolean a2 = a.m15394a();
        bd.m15428a("is data collect closed:" + a2);
        if (!a2) {
            if (!C3585y.AP_LIST.m15295b(10000)) {
                m15415c(context);
            }
            if (!C3585y.APP_LIST.m15295b(10000)) {
                m15416d(context);
            }
            if (!C3585y.APP_TRACE.m15295b(10000)) {
                m15417e(context);
            }
            if (bc.f19437e && !C3585y.APP_APK.m15295b(10000)) {
                m15418f(context);
            }
            a2 = de.m15703n(context);
            if (a2 && a.m15408l()) {
                bd.m15428a("sendLog");
                m15419g(context);
            } else if (a2) {
                bd.m15428a("can not sendLog due to time stratergy");
            } else {
                bd.m15428a("isWifiAvailable = false, will not sendLog");
            }
        }
        bd.m15428a("startDataAnynalyzed finished");
    }

    /* renamed from: a */
    private void m15412a(JSONObject jSONObject) {
        be beVar = new be(jSONObject);
        bc.f19434b = beVar.f19439a;
        bc.f19435c = beVar.f19440b;
        bc.f19436d = beVar.f19441c;
    }

    /* renamed from: c */
    private void m15415c(Context context) {
        bd.m15428a("collectAPWithStretegy 1");
        az a = az.m15388a(context);
        long a2 = a.m15391a(C3606u.AP_LIST);
        long currentTimeMillis = System.currentTimeMillis();
        long e = a.m15401e();
        bd.m15428a("now time: " + currentTimeMillis + ": last time: " + a2 + "; time interval: " + e);
        if (a2 == 0 || currentTimeMillis - a2 > e) {
            bd.m15428a("collectAPWithStretegy 2");
            C3599n.m15752a(context);
        }
    }

    /* renamed from: d */
    private void m15416d(Context context) {
        bd.m15428a("collectAPPListWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        az a = az.m15388a(context);
        long a2 = a.m15391a(C3606u.APP_USER_LIST);
        long f = a.m15402f();
        bd.m15428a("now time: " + currentTimeMillis + ": last time: " + a2 + "; userInterval : " + f);
        if (a2 == 0 || currentTimeMillis - a2 > f || !a.m15395a(a2)) {
            bd.m15428a("collectUserAPPListWithStretegy 2");
            C3599n.m15754a(context, false);
        }
        a2 = a.m15391a(C3606u.APP_SYS_LIST);
        long g = a.m15403g();
        bd.m15428a("now time: " + currentTimeMillis + ": last time: " + a2 + "; sysInterval : " + g);
        if (a2 == 0 || currentTimeMillis - a2 > g) {
            bd.m15428a("collectSysAPPListWithStretegy 2");
            C3599n.m15754a(context, true);
        }
    }

    /* renamed from: e */
    private void m15417e(Context context) {
        bd.m15428a("collectAPPTraceWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        az a = az.m15388a(context);
        long a2 = a.m15391a(C3606u.APP_TRACE_HIS);
        long i = a.m15405i();
        bd.m15428a("now time: " + currentTimeMillis + ": last time: " + a2 + "; time interval: " + i);
        if (a2 == 0 || currentTimeMillis - a2 > i) {
            bd.m15428a("collectAPPTraceWithStretegy 2");
            C3599n.m15756b(context, false);
        }
    }

    /* renamed from: f */
    private void m15418f(Context context) {
        bd.m15428a("collectAPKWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        az a = az.m15388a(context);
        long a2 = a.m15391a(C3606u.APP_APK);
        long h = a.m15404h();
        bd.m15428a("now time: " + currentTimeMillis + ": last time: " + a2 + "; interval : " + h);
        if (a2 == 0 || currentTimeMillis - a2 > h) {
            bd.m15428a("collectAPKWithStretegy 2");
            C3599n.m15755b(context);
        }
    }

    /* renamed from: a */
    public void m15421a(Context context, String str) {
        az.m15388a(context).m15393a(str);
    }

    /* renamed from: b */
    public void m15424b(Context context, String str) {
        az.m15388a(context).m15396b(str);
    }

    /* renamed from: a */
    public void m15420a(Context context, long j) {
        az.m15388a(context).m15392a(C3606u.LAST_UPDATE, j);
    }

    /* renamed from: g */
    private void m15419g(Context context) {
        az.m15388a(context).m15392a(C3606u.LAST_SEND, System.currentTimeMillis());
        JSONObject a = C3607v.m15780a(context);
        bd.m15428a("header: " + a);
        int i = 0;
        while (m15413a()) {
            int i2 = i + 1;
            if (i > 0) {
                C3607v.m15783c(a);
            }
            m15414b(context, a);
            i = i2;
        }
    }

    /* renamed from: a */
    private boolean m15413a() {
        if (C3585y.AP_LIST.m15294b() && C3585y.APP_LIST.m15294b() && C3585y.APP_TRACE.m15294b() && C3585y.APP_CHANGE.m15294b() && C3585y.APP_APK.m15294b()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m15414b(Context context, JSONObject jSONObject) {
        JSONArray jSONArray;
        int length;
        List<String> a;
        JSONArray jSONArray2;
        JSONObject jSONObject2;
        int i = 0;
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(Config.HEADER_PART, jSONObject);
            i = 0 + jSONObject.toString().length();
        } catch (Throwable e) {
            bd.m15429a(e);
        }
        bd.m15428a("APP_MEM");
        if (!az.m15388a(context).m15397b()) {
            String t = de.m15709t(context);
            jSONArray = new JSONArray();
            bd.m15428a(t);
            jSONArray.put(t);
            if (jSONArray.length() > 0) {
                try {
                    jSONObject3.put("app_mem3", jSONArray);
                    length = i + jSONArray.toString().length();
                } catch (Throwable e2) {
                    bd.m15429a(e2);
                }
                bd.m15428a("APP_APK");
                a = C3585y.APP_APK.m15293a((int) C1163a.f3005i);
                jSONArray = new JSONArray();
                for (String str : a) {
                    bd.m15428a(str);
                    jSONArray.put(str);
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject3.put("app_apk3", jSONArray);
                        length += jSONArray.toString().length();
                    } catch (Throwable e3) {
                        bd.m15429a(e3);
                    }
                }
                bd.m15428a("APP_CHANGE");
                a = C3585y.APP_CHANGE.m15293a(10240);
                jSONArray = new JSONArray();
                for (String str2 : a) {
                    bd.m15428a(str2);
                    jSONArray.put(str2);
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject3.put("app_change3", jSONArray);
                        length += jSONArray.toString().length();
                    } catch (Throwable e32) {
                        bd.m15429a(e32);
                    }
                }
                bd.m15428a("APP_TRACE");
                a = C3585y.APP_TRACE.m15293a(15360);
                jSONArray = new JSONArray();
                for (String str22 : a) {
                    bd.m15428a(str22);
                    jSONArray.put(str22);
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject3.put("app_trace3", jSONArray);
                        length += jSONArray.toString().length();
                    } catch (Throwable e322) {
                        bd.m15429a(e322);
                    }
                }
                bd.m15428a("APP_LIST");
                a = C3585y.APP_LIST.m15293a(46080);
                jSONArray = new JSONArray();
                for (String str222 : a) {
                    bd.m15428a(str222);
                    jSONArray.put(str222);
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject3.put("app_list3", jSONArray);
                        length += jSONArray.toString().length();
                    } catch (Throwable e3222) {
                        bd.m15429a(e3222);
                    }
                }
                bd.m15428a("AP_LIST");
                a = C3585y.AP_LIST.m15293a(184320 - length);
                jSONArray = new JSONArray();
                for (String str2222 : a) {
                    bd.m15428a(str2222);
                    jSONArray.put(str2222);
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject3.put("ap_list3", jSONArray);
                        length += jSONArray.toString().length();
                    } catch (Throwable e32222) {
                        bd.m15429a(e32222);
                    }
                }
                bd.m15428a("log in bytes is almost :" + length);
                jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject3);
                jSONObject2 = new JSONObject();
                jSONObject2.put("payload", jSONArray2);
                al.m15336a().m15345a(context, jSONObject2.toString());
            }
        }
        length = i;
        bd.m15428a("APP_APK");
        a = C3585y.APP_APK.m15293a((int) C1163a.f3005i);
        jSONArray = new JSONArray();
        for (String str22222 : a) {
            bd.m15428a(str22222);
            jSONArray.put(str22222);
        }
        if (jSONArray.length() > 0) {
            jSONObject3.put("app_apk3", jSONArray);
            length += jSONArray.toString().length();
        }
        bd.m15428a("APP_CHANGE");
        a = C3585y.APP_CHANGE.m15293a(10240);
        jSONArray = new JSONArray();
        for (String str222222 : a) {
            bd.m15428a(str222222);
            jSONArray.put(str222222);
        }
        if (jSONArray.length() > 0) {
            jSONObject3.put("app_change3", jSONArray);
            length += jSONArray.toString().length();
        }
        bd.m15428a("APP_TRACE");
        a = C3585y.APP_TRACE.m15293a(15360);
        jSONArray = new JSONArray();
        for (String str2222222 : a) {
            bd.m15428a(str2222222);
            jSONArray.put(str2222222);
        }
        if (jSONArray.length() > 0) {
            jSONObject3.put("app_trace3", jSONArray);
            length += jSONArray.toString().length();
        }
        bd.m15428a("APP_LIST");
        a = C3585y.APP_LIST.m15293a(46080);
        jSONArray = new JSONArray();
        for (String str22222222 : a) {
            bd.m15428a(str22222222);
            jSONArray.put(str22222222);
        }
        if (jSONArray.length() > 0) {
            jSONObject3.put("app_list3", jSONArray);
            length += jSONArray.toString().length();
        }
        bd.m15428a("AP_LIST");
        a = C3585y.AP_LIST.m15293a(184320 - length);
        jSONArray = new JSONArray();
        for (String str222222222 : a) {
            bd.m15428a(str222222222);
            jSONArray.put(str222222222);
        }
        if (jSONArray.length() > 0) {
            jSONObject3.put("ap_list3", jSONArray);
            length += jSONArray.toString().length();
        }
        bd.m15428a("log in bytes is almost :" + length);
        jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("payload", jSONArray2);
            al.m15336a().m15345a(context, jSONObject2.toString());
        } catch (Throwable e322222) {
            bd.m15429a(e322222);
        }
    }

    /* renamed from: a */
    public boolean m15423a(Context context) {
        az a = az.m15388a(context);
        long a2 = a.m15391a(C3606u.LAST_UPDATE);
        long c = a.m15398c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a2 > c) {
            bd.m15428a("need to update, checkWithLastUpdateTime lastUpdateTime =" + a2 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
            return true;
        }
        bd.m15428a("no need to update, checkWithLastUpdateTime lastUpdateTime =" + a2 + "nowTime=" + currentTimeMillis + ";timeInteveral=" + c);
        return false;
    }

    /* renamed from: b */
    public boolean m15425b(Context context) {
        return !az.m15388a(context).m15394a() || m15423a(context);
    }
}
