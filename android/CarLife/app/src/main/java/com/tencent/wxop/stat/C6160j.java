package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p290a.C6120a;
import com.tencent.wxop.stat.p290a.C6122c;
import com.tencent.wxop.stat.p290a.C6127i;
import com.tencent.wxop.stat.p290a.C6130l;
import com.tencent.wxop.stat.p291b.C6132a;
import com.tencent.wxop.stat.p291b.C6133b;
import com.tencent.wxop.stat.p291b.C6135d;
import com.tencent.wxop.stat.p291b.C6138g;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6149r;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.j */
public class C6160j {
    /* renamed from: a */
    static volatile int f25088a = 0;
    /* renamed from: b */
    static volatile long f25089b = 0;
    /* renamed from: c */
    static volatile long f25090c = 0;
    /* renamed from: d */
    private static C6138g f25091d;
    /* renamed from: e */
    private static volatile Map<C6122c, Long> f25092e = new ConcurrentHashMap();
    /* renamed from: f */
    private static volatile Map<String, Properties> f25093f = new ConcurrentHashMap();
    /* renamed from: g */
    private static volatile Map<Integer, Integer> f25094g = new ConcurrentHashMap(10);
    /* renamed from: h */
    private static volatile long f25095h = 0;
    /* renamed from: i */
    private static volatile long f25096i = 0;
    /* renamed from: j */
    private static volatile long f25097j = 0;
    /* renamed from: k */
    private static String f25098k = "";
    /* renamed from: l */
    private static volatile int f25099l = 0;
    /* renamed from: m */
    private static volatile String f25100m = "";
    /* renamed from: n */
    private static volatile String f25101n = "";
    /* renamed from: o */
    private static Map<String, Long> f25102o = new ConcurrentHashMap();
    /* renamed from: p */
    private static Map<String, Long> f25103p = new ConcurrentHashMap();
    /* renamed from: q */
    private static C6133b f25104q = C6144m.m21872b();
    /* renamed from: r */
    private static UncaughtExceptionHandler f25105r = null;
    /* renamed from: s */
    private static volatile boolean f25106s = true;
    /* renamed from: t */
    private static Context f25107t = null;

    /* renamed from: a */
    static int m22090a(Context context, boolean z, C6161k c6161k) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - f25096i < ((long) C6156f.m22004d())) {
            boolean z2 = false;
        } else {
            int i2 = 1;
        }
        f25096i = currentTimeMillis;
        if (f25097j == 0) {
            f25097j = C6144m.m21874c();
        }
        if (currentTimeMillis >= f25097j) {
            f25097j = C6144m.m21874c();
            if (ag.m21760a(context).m21793b(context).m21839d() != 1) {
                ag.m21760a(context).m21793b(context).m21836a(1);
            }
            C6156f.m22033l(0);
            f25088a = 0;
            f25098k = C6144m.m21863a(0);
            i2 = 1;
        }
        Object obj = f25098k;
        if (C6144m.m21869a(c6161k)) {
            obj = c6161k.m22156c() + f25098k;
        }
        if (f25103p.containsKey(obj)) {
            i = i2;
        }
        if (i != 0) {
            if (C6144m.m21869a(c6161k)) {
                C6160j.m22099a(context, c6161k);
            } else if (C6156f.m22047w() < C6156f.m22045u()) {
                C6144m.m21902x(context);
                C6160j.m22099a(context, null);
            } else {
                f25104q.m21832h("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            f25103p.put(obj, Long.valueOf(1));
        }
        if (f25106s) {
            C6160j.m22141h(context);
            f25106s = false;
        }
        return f25099l;
    }

    /* renamed from: a */
    public static Context m22092a(Context context) {
        return context != null ? context : f25107t;
    }

    /* renamed from: a */
    public static void m22094a(Context context, int i) {
        if (C6156f.m22003c()) {
            if (C6156f.m21997b()) {
                f25104q.m21825b("commitEvents, maxNumber=" + i);
            }
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.commitEvents() can not be null!");
            } else if (i < -1 || i == 0) {
                f25104q.m21831g("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            } else if (C6162l.m22161a(f25107t).m22173f() && C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6166p(a, i));
            }
        }
    }

    /* renamed from: a */
    public static void m22095a(Context context, int i, String str, String... strArr) {
        if (!C6156f.m22003c()) {
            return;
        }
        if (i <= 0) {
            f25104q.m21831g("The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!");
            return;
        }
        Context a = C6160j.m22092a(context);
        if (a == null) {
            f25104q.m21831g("The Context of StatService.trackCustomTimeIntervalEvent() can not be null!");
        } else if (C6160j.m22133e(a) != null) {
            f25091d.m21844a(new C6164n());
        }
    }

    /* renamed from: a */
    public static void m22096a(Context context, C6154d c6154d, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21832h("context is null in reportAccount.");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6174x(c6154d, a, c6161k));
            }
        }
    }

    /* renamed from: a */
    public static void m22097a(Context context, C6155e c6155e, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.reportAppMonitorStat() can not be null!");
            } else if (c6155e == null) {
                f25104q.m21831g("The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
            } else if (c6155e.m21951a() == null) {
                f25104q.m21831g("The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
            } else {
                C6155e h = c6155e.m21965h();
                if (C6160j.m22133e(a) != null) {
                    f25091d.m21844a(new C6163m(a, c6161k, h));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m22098a(Context context, C6157g c6157g, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.reportGameUser() can not be null!");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6175y(c6157g, a, c6161k));
            }
        }
    }

    /* renamed from: a */
    static void m22099a(Context context, C6161k c6161k) {
        if (C6160j.m22133e(context) != null) {
            if (C6156f.m21997b()) {
                f25104q.m21834j("start new session.");
            }
            if (c6161k == null || f25099l == 0) {
                f25099l = C6144m.m21860a();
            }
            C6156f.m22029j(0);
            C6156f.m22046v();
            new ac(new C6130l(context, f25099l, C6160j.m22113b(), c6161k)).m21751a();
        }
    }

    /* renamed from: a */
    public static void m22100a(Context context, String str, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null || str == null || str.length() == 0) {
                f25104q.m21831g("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bk(str2, a, c6161k));
            }
        }
    }

    /* renamed from: a */
    public static void m22101a(Context context, String str, C6161k c6161k, String... strArr) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (C6160j.m22111a(str)) {
                f25104q.m21831g("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                C6122c c6122c = new C6122c(str, strArr, null);
                if (C6160j.m22133e(a) != null) {
                    f25091d.m21844a(new bg(a, c6161k, c6122c));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m22102a(Context context, String str, Properties properties, int i, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomEndEvent() can not be null!");
            } else if (C6160j.m22111a(str)) {
                f25104q.m21831g("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
            } else {
                C6122c c6122c = new C6122c(str, null, properties);
                if (C6160j.m22133e(a) != null) {
                    f25091d.m21844a(new C6165o(a, c6161k, c6122c, i));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m22103a(Context context, String str, Properties properties, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (C6160j.m22111a(str)) {
                f25104q.m21831g("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                C6122c c6122c = new C6122c(str, null, properties);
                if (C6160j.m22133e(a) != null) {
                    f25091d.m21844a(new bi(a, c6161k, c6122c));
                }
            }
        }
    }

    /* renamed from: a */
    static void m22104a(Context context, Throwable th) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new be(a, th));
            }
        }
    }

    /* renamed from: a */
    public static void m22105a(Context context, Throwable th, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.reportException() can not be null!");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bf(th, a, c6161k));
            }
        }
    }

    /* renamed from: a */
    public static void m22106a(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f25104q.m21831g("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            C6135d.m21841a(context, (Map) map);
        } catch (Throwable e) {
            f25104q.m21826b(e);
        }
    }

    /* renamed from: a */
    public static void m22107a(Context context, Map<String, Integer> map, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.testSpeed() can not be null!");
            } else if (map == null || map.size() == 0) {
                f25104q.m21831g("The domainMap of StatService.testSpeed() can not be null or empty!");
            } else {
                Map hashMap = new HashMap(map);
                if (C6160j.m22133e(a) != null) {
                    f25091d.m21844a(new C6168r(a, hashMap, c6161k));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m22108a(String str, Properties properties) {
        if (!C6144m.m21876c(str)) {
            f25104q.m21832h("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f25093f.remove(str);
        } else {
            f25093f.put(str, (Properties) properties.clone());
        }
    }

    /* renamed from: a */
    static boolean m22109a() {
        if (f25088a < 2) {
            return false;
        }
        f25089b = System.currentTimeMillis();
        return true;
    }

    /* renamed from: a */
    public static boolean m22110a(Context context, String str, String str2, C6161k c6161k) {
        try {
            if (C6156f.m22003c()) {
                String str3 = C6132a.f24873a;
                if (C6156f.m21997b()) {
                    f25104q.m21834j("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null || str2 == null) {
                    f25104q.m21831g("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    C6156f.m21996b(false);
                    return false;
                } else if (C6144m.m21871b(str3) < C6144m.m21871b(str2)) {
                    f25104q.m21831g(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    C6156f.m21996b(false);
                    return false;
                } else {
                    str3 = C6156f.m21998c(context);
                    if (str3 == null || str3.length() == 0) {
                        C6156f.m22001c("-");
                    }
                    if (str != null) {
                        C6156f.m21992b(context, str);
                    }
                    if (C6160j.m22133e(context) != null) {
                        f25091d.m21844a(new C6176z(context, c6161k));
                    }
                    return true;
                }
            }
            f25104q.m21831g("MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            f25104q.m21826b(th);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m22111a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static Properties m22112b(String str) {
        return (Properties) f25093f.get(str);
    }

    /* renamed from: b */
    static JSONObject m22113b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (C6156f.f25051b.f24860d != 0) {
                jSONObject2.put("v", C6156f.f25051b.f24860d);
            }
            jSONObject.put(Integer.toString(C6156f.f25051b.f24857a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (C6156f.f25050a.f24860d != 0) {
                jSONObject2.put("v", C6156f.f25050a.f24860d);
            }
            jSONObject.put(Integer.toString(C6156f.f25050a.f24857a), jSONObject2);
        } catch (Throwable e) {
            f25104q.m21826b(e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    public static void m22114b(Context context) {
        if (context != null) {
            f25107t = context.getApplicationContext();
        }
    }

    /* renamed from: b */
    public static void m22116b(Context context, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.startNewSession() can not be null!");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6171u(a, c6161k));
            }
        }
    }

    /* renamed from: b */
    public static void m22117b(Context context, String str, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null || str == null || str.length() == 0) {
                f25104q.m21831g("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6170t(a, str2, c6161k));
            }
        }
    }

    /* renamed from: b */
    public static void m22118b(Context context, String str, C6161k c6161k, String... strArr) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C6122c c6122c = new C6122c(str, strArr, null);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bj(str, c6122c, a));
            }
        }
    }

    /* renamed from: b */
    public static void m22119b(Context context, String str, Properties properties, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C6122c c6122c = new C6122c(str, null, properties);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bm(str, c6122c, a));
            }
        }
    }

    /* renamed from: c */
    public static void m22121c() {
        f25096i = 0;
    }

    /* renamed from: c */
    static synchronized void m22122c(Context context) {
        synchronized (C6160j.class) {
            if (context != null) {
                if (f25091d == null && C6160j.m22132d(context)) {
                    Context applicationContext = context.getApplicationContext();
                    f25107t = applicationContext;
                    f25091d = new C6138g();
                    f25098k = C6144m.m21863a(0);
                    f25095h = System.currentTimeMillis() + C6156f.f25058i;
                    f25091d.m21844a(new az(applicationContext));
                }
            }
        }
    }

    /* renamed from: c */
    private static void m22123c(Context context, C6154d c6154d, C6161k c6161k) {
        try {
            new ac(new C6120a(context, C6160j.m22090a(context, false, c6161k), c6154d, c6161k)).m21751a();
        } catch (Throwable th) {
            f25104q.m21826b(th);
            C6160j.m22104a(context, th);
        }
    }

    /* renamed from: c */
    public static void m22124c(Context context, C6161k c6161k) {
        if (C6156f.m22003c() && C6160j.m22133e(context) != null) {
            f25091d.m21844a(new C6172v(context, c6161k));
        }
    }

    /* renamed from: c */
    public static void m22125c(Context context, String str, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("context is null in reportQQ()");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6173w(str, a, c6161k));
            }
        }
    }

    /* renamed from: c */
    public static void m22126c(Context context, String str, C6161k c6161k, String... strArr) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C6122c c6122c = new C6122c(str, strArr, null);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bl(str, c6122c, a, c6161k));
            }
        }
    }

    /* renamed from: c */
    public static void m22127c(Context context, String str, Properties properties, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C6122c c6122c = new C6122c(str, null, properties);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bn(str, c6122c, a, c6161k));
            }
        }
    }

    /* renamed from: d */
    static void m22129d() {
        f25088a = 0;
        f25089b = 0;
    }

    /* renamed from: d */
    public static void m22130d(Context context, C6161k c6161k) {
        if (C6156f.m22003c() && C6160j.m22133e(context) != null) {
            f25091d.m21844a(new ba(context, c6161k));
        }
    }

    /* renamed from: d */
    public static void m22131d(Context context, String str, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.reportError() can not be null!");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bd(str, a, c6161k));
            }
        }
    }

    /* renamed from: d */
    static boolean m22132d(Context context) {
        boolean z = false;
        long a = C6149r.m21911a(context, C6156f.f25052c, 0);
        long b = C6144m.m21871b(C6132a.f24873a);
        boolean z2 = true;
        if (b <= a) {
            f25104q.m21831g("MTA is disable for current version:" + b + ",wakeup version:" + a);
            z2 = false;
        }
        a = C6149r.m21911a(context, C6156f.f25053d, 0);
        if (a > System.currentTimeMillis()) {
            f25104q.m21831g("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a);
        } else {
            z = z2;
        }
        C6156f.m21996b(z);
        return z;
    }

    /* renamed from: e */
    static C6138g m22133e(Context context) {
        if (f25091d == null) {
            synchronized (C6160j.class) {
                if (f25091d == null) {
                    try {
                        C6160j.m22122c(context);
                    } catch (Throwable th) {
                        f25104q.m21821a(th);
                        C6156f.m21996b(false);
                    }
                }
            }
        }
        return f25091d;
    }

    /* renamed from: e */
    static void m22134e() {
        f25088a++;
        f25089b = System.currentTimeMillis();
        C6160j.m22143i(f25107t);
    }

    /* renamed from: e */
    public static void m22135e(Context context, C6161k c6161k) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new bb(a));
            }
        }
    }

    /* renamed from: f */
    public static void m22137f(Context context) {
        if (C6156f.m22003c() && C6160j.m22133e(C6160j.m22092a(context)) != null) {
            f25091d.m21844a(new bc(context));
        }
    }

    /* renamed from: g */
    static void m22139g(Context context) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                aw.m21813b(a).m21814a(new C6127i(a), new bh());
            } catch (Throwable th) {
                f25104q.m21826b(th);
            }
        }
    }

    /* renamed from: h */
    public static void m22141h(Context context) {
        if (C6156f.m22003c()) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.testSpeed() can not be null!");
            } else if (C6160j.m22133e(a) != null) {
                f25091d.m21844a(new C6167q(a));
            }
        }
    }

    /* renamed from: i */
    public static void m22143i(Context context) {
        if (C6156f.m22003c() && C6156f.f25063n > 0) {
            Context a = C6160j.m22092a(context);
            if (a == null) {
                f25104q.m21831g("The Context of StatService.testSpeed() can not be null!");
            } else {
                ag.m21760a(a).m21794c();
            }
        }
    }

    /* renamed from: j */
    static void m22145j(Context context) {
        f25090c = System.currentTimeMillis() + ((long) (60000 * C6156f.m22034m()));
        C6149r.m21915b(context, "last_period_ts", f25090c);
        C6160j.m22094a(context, -1);
    }
}
