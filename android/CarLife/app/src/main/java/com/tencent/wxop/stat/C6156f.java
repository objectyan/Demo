package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.platform.comapi.util.C4820d;
import com.tencent.p280a.p281a.p282a.p283a.C6084g;
import com.tencent.wxop.stat.p291b.C6132a;
import com.tencent.wxop.stat.p291b.C6133b;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6149r;
import com.tencent.wxop.stat.p291b.C6150s;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.f */
public class C6156f {
    /* renamed from: A */
    private static int f25030A = 1;
    /* renamed from: B */
    private static String f25031B = null;
    /* renamed from: C */
    private static String f25032C;
    /* renamed from: D */
    private static String f25033D;
    /* renamed from: E */
    private static String f25034E = "mta_channel";
    /* renamed from: F */
    private static int f25035F = C4820d.f19955a;
    /* renamed from: G */
    private static int f25036G = 1024;
    /* renamed from: H */
    private static long f25037H = 0;
    /* renamed from: I */
    private static long f25038I = 300000;
    /* renamed from: J */
    private static volatile String f25039J = C6132a.f24878f;
    /* renamed from: K */
    private static int f25040K = 0;
    /* renamed from: L */
    private static volatile int f25041L = 0;
    /* renamed from: M */
    private static int f25042M = 20;
    /* renamed from: N */
    private static int f25043N = 0;
    /* renamed from: O */
    private static boolean f25044O = false;
    /* renamed from: P */
    private static int f25045P = 4096;
    /* renamed from: Q */
    private static boolean f25046Q = false;
    /* renamed from: R */
    private static String f25047R = null;
    /* renamed from: S */
    private static boolean f25048S = false;
    /* renamed from: T */
    private static au f25049T = null;
    /* renamed from: a */
    static at f25050a = new at(2);
    /* renamed from: b */
    static at f25051b = new at(1);
    /* renamed from: c */
    static String f25052c = "__HIBERNATE__";
    /* renamed from: d */
    static String f25053d = "__HIBERNATE__TIME";
    /* renamed from: e */
    static String f25054e = "__MTA_KILL__";
    /* renamed from: f */
    static String f25055f = "";
    /* renamed from: g */
    static boolean f25056g = false;
    /* renamed from: h */
    static int f25057h = 100;
    /* renamed from: i */
    static long f25058i = BNOffScreenParams.MIN_ENTER_INTERVAL;
    /* renamed from: j */
    static boolean f25059j = true;
    /* renamed from: k */
    public static boolean f25060k = true;
    /* renamed from: l */
    static volatile String f25061l = C6132a.f24876d;
    /* renamed from: m */
    static boolean f25062m = true;
    /* renamed from: n */
    static int f25063n = 0;
    /* renamed from: o */
    static long f25064o = BNOffScreenParams.MIN_ENTER_INTERVAL;
    /* renamed from: p */
    static int f25065p = 512;
    /* renamed from: q */
    private static C6133b f25066q = C6144m.m21872b();
    /* renamed from: r */
    private static C6158h f25067r = C6158h.APP_LAUNCH;
    /* renamed from: s */
    private static boolean f25068s = false;
    /* renamed from: t */
    private static boolean f25069t = true;
    /* renamed from: u */
    private static int f25070u = 30000;
    /* renamed from: v */
    private static int f25071v = 100000;
    /* renamed from: w */
    private static int f25072w = 30;
    /* renamed from: x */
    private static int f25073x = 10;
    /* renamed from: y */
    private static int f25074y = 100;
    /* renamed from: z */
    private static int f25075z = 30;

    /* renamed from: A */
    public static au m21966A() {
        return f25049T;
    }

    /* renamed from: B */
    public static boolean m21967B() {
        return f25062m;
    }

    /* renamed from: C */
    public static int m21968C() {
        return f25063n;
    }

    /* renamed from: D */
    public static long m21969D() {
        return f25064o;
    }

    /* renamed from: E */
    public static int m21970E() {
        return f25065p;
    }

    /* renamed from: a */
    public static C6158h m21971a() {
        return f25067r;
    }

    /* renamed from: a */
    static String m21972a(Context context) {
        return C6150s.m21918a(C6149r.m21913a(context, "_mta_ky_tag_", null));
    }

    /* renamed from: a */
    public static String m21973a(String str) {
        try {
            return f25050a.f24858b.getString(str);
        } catch (Throwable th) {
            f25066q.m21826b(th);
            return null;
        }
    }

    /* renamed from: a */
    public static String m21974a(String str, String str2) {
        try {
            String string = f25050a.f24858b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f25066q.m21826b(th);
            return str2;
        }
    }

    /* renamed from: a */
    public static void m21975a(int i) {
        if (C6156f.m21986a(i, 1000, 86400000)) {
            f25070u = i;
        } else {
            f25066q.m21831g("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    /* renamed from: a */
    public static void m21976a(int i, long j) {
        f25057h = i;
        if (j >= 1000) {
            f25058i = j;
        }
    }

    /* renamed from: a */
    static void m21977a(long j) {
        C6149r.m21915b(aw.m21810a(), f25052c, j);
        C6156f.m21996b(false);
        f25066q.m21829e("MTA is disable for current SDK version");
    }

    /* renamed from: a */
    static void m21978a(Context context, at atVar) {
        if (atVar.f24857a == f25051b.f24857a) {
            f25051b = atVar;
            C6156f.m21984a(atVar.f24858b);
            if (!f25051b.f24858b.isNull("iplist")) {
                C6162l.m22161a(context).m22168a(f25051b.f24858b.getString("iplist"));
            }
        } else if (atVar.f24857a == f25050a.f24857a) {
            f25050a = atVar;
        }
    }

    /* renamed from: a */
    static void m21979a(Context context, at atVar, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    Object obj2 = atVar.f24860d != i ? 1 : obj;
                    atVar.f24860d = i;
                    obj = obj2;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        atVar.f24858b = new JSONObject(str);
                    }
                } else if (str.equalsIgnoreCase(Config.MODEL)) {
                    atVar.f24859c = jSONObject.getString(Config.MODEL);
                }
            }
            if (obj == 1) {
                ag a = ag.m21760a(aw.m21810a());
                if (a != null) {
                    a.m21790a(atVar);
                }
                if (atVar.f24857a == f25051b.f24857a) {
                    C6156f.m21984a(atVar.f24858b);
                    C6156f.m21995b(atVar.f24858b);
                }
            }
            C6156f.m21978a(context, atVar);
        } catch (Throwable e) {
            f25066q.m21826b(e);
        } catch (Throwable e2) {
            f25066q.m21826b(e2);
        }
    }

    /* renamed from: a */
    static void m21980a(Context context, String str) {
        if (str != null) {
            C6149r.m21916b(context, "_mta_ky_tag_", C6150s.m21923b(str));
        }
    }

    /* renamed from: a */
    static void m21981a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f25051b.f24857a))) {
                    C6156f.m21979a(context, f25051b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(f25050a.f24857a))) {
                    C6156f.m21979a(context, f25050a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    C6158h a = C6158h.m22058a(jSONObject.getInt(str));
                    if (a != null) {
                        f25067r = a;
                        if (C6156f.m21997b()) {
                            f25066q.m21834j("Change to ReportStrategy:" + a.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            f25066q.m21826b(e);
        }
    }

    /* renamed from: a */
    public static void m21982a(au auVar) {
        f25049T = auVar;
    }

    /* renamed from: a */
    public static void m21983a(C6158h c6158h) {
        f25067r = c6158h;
        if (c6158h != C6158h.PERIOD) {
            C6160j.f25090c = 0;
        }
        if (C6156f.m21997b()) {
            f25066q.m21834j("Change to statSendStrategy: " + c6158h);
        }
    }

    /* renamed from: a */
    static void m21984a(JSONObject jSONObject) {
        try {
            C6158h a = C6158h.m22058a(jSONObject.getInt("rs"));
            if (a != null) {
                C6156f.m21983a(a);
            }
        } catch (JSONException e) {
            if (C6156f.m21997b()) {
                f25066q.m21825b((Object) "rs not found.");
            }
        }
    }

    /* renamed from: a */
    public static void m21985a(boolean z) {
        f25068s = z;
        C6144m.m21872b().m21822a(z);
    }

    /* renamed from: a */
    static boolean m21986a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    /* renamed from: a */
    static boolean m21987a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (C6144m.m21876c(str2) && C6144m.m21876c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static synchronized String m21988b(Context context) {
        String str;
        synchronized (C6156f.class) {
            if (f25032C != null) {
                str = f25032C;
            } else {
                if (context != null) {
                    if (f25032C == null) {
                        f25032C = C6144m.m21882f(context);
                    }
                }
                if (f25032C == null || f25032C.trim().length() == 0) {
                    f25066q.m21831g("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = f25032C;
            }
        }
        return str;
    }

    /* renamed from: b */
    static String m21989b(String str, String str2) {
        try {
            String string = f25051b.f24858b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f25066q.m21830f("can't find custom key:" + str);
            return str2;
        }
    }

    /* renamed from: b */
    public static void m21990b(int i) {
        if (i > 100) {
            f25074y = i;
        }
    }

    /* renamed from: b */
    public static void m21991b(long j) {
        if (j > 0) {
            f25064o = j;
        }
    }

    /* renamed from: b */
    public static void m21992b(Context context, String str) {
        if (context == null) {
            f25066q.m21831g("ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            f25066q.m21831g("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (f25032C == null) {
                f25032C = C6156f.m21972a(context);
            }
            if ((C6156f.m22015e(str) | C6156f.m22015e(C6144m.m21882f(context))) != 0) {
                C6156f.m21980a(context, f25032C);
            }
        }
    }

    /* renamed from: b */
    static void m21993b(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(f25054e);
            if (C6144m.m21876c(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    Object obj;
                    if (!jSONObject2.isNull("sm")) {
                        obj = jSONObject2.get("sm");
                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                        if (intValue > 0) {
                            if (C6156f.m21997b()) {
                                f25066q.m21825b("match sleepTime:" + intValue + " minutes");
                            }
                            C6149r.m21915b(context, f25053d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                            C6156f.m21996b(false);
                            f25066q.m21829e("MTA is disable for current SDK version");
                        }
                    }
                    if (C6156f.m21987a(jSONObject2, "sv", C6132a.f24873a)) {
                        f25066q.m21825b((Object) "match sdk version:2.0.3");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (C6156f.m21987a(jSONObject2, "md", Build.MODEL)) {
                        f25066q.m21825b("match MODEL:" + Build.MODEL);
                        obj = 1;
                    }
                    if (C6156f.m21987a(jSONObject2, "av", C6144m.m21888j(context))) {
                        f25066q.m21825b("match app version:" + C6144m.m21888j(context));
                        obj = 1;
                    }
                    if (C6156f.m21987a(jSONObject2, "mf", Build.MANUFACTURER)) {
                        f25066q.m21825b("match MANUFACTURER:" + Build.MANUFACTURER);
                        obj = 1;
                    }
                    if (C6156f.m21987a(jSONObject2, "osv", VERSION.SDK_INT)) {
                        f25066q.m21825b("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (C6156f.m21987a(jSONObject2, "ov", VERSION.SDK_INT)) {
                        f25066q.m21825b("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (C6156f.m21987a(jSONObject2, "ui", ag.m21760a(context).m21793b(context).m21837b())) {
                        f25066q.m21825b("match imei:" + ag.m21760a(context).m21793b(context).m21837b());
                        obj = 1;
                    }
                    if (C6156f.m21987a(jSONObject2, "mid", C6156f.m22021g(context))) {
                        f25066q.m21825b("match mid:" + C6156f.m22021g(context));
                        obj = 1;
                    }
                    if (obj != null) {
                        C6156f.m21977a(C6144m.m21871b(C6132a.f24873a));
                    }
                }
            }
        } catch (Throwable e) {
            f25066q.m21826b(e);
        }
    }

    /* renamed from: b */
    public static void m21994b(String str) {
        if (str == null) {
            f25066q.m21831g("appkey in StatConfig.setAppKey() is null");
        } else if (str.length() > 256) {
            f25066q.m21831g("The length of appkey cann't exceed 256 bytes.");
        } else {
            f25032C = str;
        }
    }

    /* renamed from: b */
    static void m21995b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                C6156f.m21993b(aw.m21810a(), jSONObject);
                String string = jSONObject.getString(f25052c);
                if (C6156f.m21997b()) {
                    f25066q.m21834j("hibernateVer:" + string + ", current version:2.0.3");
                }
                long b = C6144m.m21871b(string);
                if (C6144m.m21871b(C6132a.f24873a) <= b) {
                    C6156f.m21977a(b);
                }
            } catch (JSONException e) {
                f25066q.m21834j("__HIBERNATE__ not found.");
            }
        }
    }

    /* renamed from: b */
    public static void m21996b(boolean z) {
        f25069t = z;
        if (!z) {
            f25066q.m21829e("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    /* renamed from: b */
    public static boolean m21997b() {
        return f25068s;
    }

    /* renamed from: c */
    public static synchronized String m21998c(Context context) {
        String str;
        synchronized (C6156f.class) {
            if (f25033D != null) {
                str = f25033D;
            } else {
                str = C6149r.m21913a(context, f25034E, "");
                f25033D = str;
                if (str == null || f25033D.trim().length() == 0) {
                    f25033D = C6144m.m21883g(context);
                }
                if (f25033D == null || f25033D.trim().length() == 0) {
                    f25066q.m21830f("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = f25033D;
            }
        }
        return str;
    }

    /* renamed from: c */
    public static void m21999c(int i) {
        if (C6156f.m21986a(i, 2, 1000)) {
            f25075z = i;
        } else {
            f25066q.m21831g("setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    /* renamed from: c */
    public static void m22000c(Context context, String str) {
        if (str.length() > 128) {
            f25066q.m21831g("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        f25033D = str;
        C6149r.m21916b(context, f25034E, str);
    }

    /* renamed from: c */
    public static void m22001c(String str) {
        if (str.length() > 128) {
            f25066q.m21831g("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f25033D = str;
        }
    }

    /* renamed from: c */
    public static void m22002c(boolean z) {
        f25059j = z;
    }

    /* renamed from: c */
    public static boolean m22003c() {
        return f25069t;
    }

    /* renamed from: d */
    public static int m22004d() {
        return f25070u;
    }

    /* renamed from: d */
    public static String m22005d(Context context) {
        return C6149r.m21913a(context, "mta.acc.qq", f25055f);
    }

    /* renamed from: d */
    public static void m22006d(int i) {
        if (C6156f.m21986a(i, 1, 1000)) {
            f25073x = i;
        } else {
            f25066q.m21831g("setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    /* renamed from: d */
    public static void m22007d(Context context, String str) {
        C6149r.m21916b(context, "mta.acc.qq", str);
        f25055f = str;
    }

    /* renamed from: d */
    public static void m22008d(String str) {
        if (str == null || str.length() == 0) {
            f25066q.m21831g("statReportUrl cannot be null or empty.");
            return;
        }
        f25039J = str;
        try {
            f25061l = new URI(f25039J).getHost();
        } catch (Exception e) {
            f25066q.m21830f(e);
        }
        if (C6156f.m21997b()) {
            f25066q.m21825b("url:" + f25039J + ", domain:" + f25061l);
        }
    }

    /* renamed from: d */
    public static void m22009d(boolean z) {
        f25060k = z;
    }

    /* renamed from: e */
    public static int m22010e() {
        return f25074y;
    }

    /* renamed from: e */
    public static String m22011e(Context context) {
        if (context == null) {
            f25066q.m21831g("Context for getCustomUid is null.");
            return null;
        }
        if (f25047R == null) {
            f25047R = C6149r.m21913a(context, "MTA_CUSTOM_UID", "");
        }
        return f25047R;
    }

    /* renamed from: e */
    public static void m22012e(int i) {
        if (i > 0) {
            f25030A = i;
        }
    }

    /* renamed from: e */
    public static void m22013e(Context context, String str) {
        if (context == null) {
            f25066q.m21831g("Context for setCustomUid is null.");
            return;
        }
        C6149r.m21916b(context, "MTA_CUSTOM_UID", str);
        f25047R = str;
    }

    /* renamed from: e */
    public static void m22014e(boolean z) {
        f25046Q = z;
    }

    /* renamed from: e */
    private static boolean m22015e(String str) {
        if (str == null) {
            return false;
        }
        if (f25032C == null) {
            f25032C = str;
            return true;
        } else if (f25032C.contains(str)) {
            return false;
        } else {
            f25032C += "|" + str;
            return true;
        }
    }

    /* renamed from: f */
    public static int m22016f() {
        return f25075z;
    }

    /* renamed from: f */
    public static String m22017f(Context context) {
        return C6156f.m22021g(context);
    }

    /* renamed from: f */
    public static void m22018f(int i) {
        if (C6156f.m21986a(i, 0, 500000)) {
            f25071v = i;
        } else {
            f25066q.m21831g("setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    /* renamed from: f */
    public static void m22019f(boolean z) {
        f25048S = z;
    }

    /* renamed from: g */
    public static int m22020g() {
        return f25073x;
    }

    /* renamed from: g */
    public static String m22021g(Context context) {
        return context != null ? C6084g.m21659a(context).m21660a().m21651a() : "0";
    }

    /* renamed from: g */
    public static void m22022g(int i) {
        if (C6156f.m21986a(i, 1, 10080)) {
            f25035F = i;
        } else {
            f25066q.m21831g("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    /* renamed from: g */
    public static void m22023g(boolean z) {
        f25062m = z;
    }

    /* renamed from: h */
    public static int m22024h() {
        return f25030A;
    }

    /* renamed from: h */
    public static void m22025h(int i) {
        if (C6156f.m21986a(i, 1, 4096)) {
            f25036G = i;
        } else {
            f25066q.m21831g("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    /* renamed from: i */
    static int m22026i() {
        return f25072w;
    }

    /* renamed from: i */
    public static void m22027i(int i) {
        if (i < 0) {
            f25066q.m21831g("maxSessionStatReportCount cannot be less than 0.");
        } else {
            f25040K = i;
        }
    }

    /* renamed from: j */
    public static int m22028j() {
        return f25071v;
    }

    /* renamed from: j */
    static synchronized void m22029j(int i) {
        synchronized (C6156f.class) {
            f25041L = i;
        }
    }

    /* renamed from: k */
    public static int m22030k() {
        return f25057h;
    }

    /* renamed from: k */
    public static void m22031k(int i) {
        if (i <= 0) {
            f25066q.m21832h("maxDaySessionNumbers must be greater than 0.");
        } else {
            f25042M = i;
        }
    }

    /* renamed from: l */
    public static long m22032l() {
        return f25058i;
    }

    /* renamed from: l */
    static void m22033l(int i) {
        if (i >= 0) {
            f25043N = i;
        }
    }

    /* renamed from: m */
    public static int m22034m() {
        return f25035F;
    }

    /* renamed from: m */
    public static void m22035m(int i) {
        if (i <= 0) {
            f25066q.m21831g("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            f25045P = i;
        }
    }

    /* renamed from: n */
    public static int m22036n() {
        return f25036G;
    }

    /* renamed from: n */
    public static void m22037n(int i) {
        if (i >= 0) {
            f25063n = i;
        }
    }

    /* renamed from: o */
    public static void m22038o(int i) {
        if (i > 0) {
            f25065p = i;
        }
    }

    /* renamed from: o */
    public static boolean m22039o() {
        return f25059j;
    }

    /* renamed from: p */
    public static boolean m22040p() {
        return f25060k;
    }

    /* renamed from: q */
    public static String m22041q() {
        return f25039J;
    }

    /* renamed from: r */
    public static String m22042r() {
        return f25061l;
    }

    /* renamed from: s */
    public static int m22043s() {
        return f25040K;
    }

    /* renamed from: t */
    public static int m22044t() {
        return f25041L;
    }

    /* renamed from: u */
    public static int m22045u() {
        return f25042M;
    }

    /* renamed from: v */
    static void m22046v() {
        f25043N++;
    }

    /* renamed from: w */
    static int m22047w() {
        return f25043N;
    }

    /* renamed from: x */
    public static int m22048x() {
        return f25045P;
    }

    /* renamed from: y */
    public static boolean m22049y() {
        return f25046Q;
    }

    /* renamed from: z */
    public static boolean m22050z() {
        return f25048S;
    }
}
