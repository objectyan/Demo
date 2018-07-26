package com.baidu.android.pushservice.p024c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0554h;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p026e.C0486b;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0561a;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.android.pushservice.p032k.C0592h;
import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.SearchByTypeDataStruct;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.coloros.mcssdk.PushManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.c.d */
public class C0448d extends C0443b {
    /* renamed from: f */
    private static int f1402f = 259200000;
    /* renamed from: g */
    private static boolean f1403g = false;
    /* renamed from: h */
    private static C0448d f1404h;
    /* renamed from: n */
    private static String[] f1405n = new String[]{"/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop"};
    /* renamed from: d */
    public HashMap<String, C0445c> f1406d;
    /* renamed from: e */
    private String f1407e;
    /* renamed from: i */
    private int f1408i;
    /* renamed from: j */
    private C0445c f1409j;
    /* renamed from: k */
    private int f1410k;
    /* renamed from: l */
    private int f1411l;
    /* renamed from: m */
    private String f1412m;

    /* renamed from: com.baidu.android.pushservice.c.d$a */
    public interface C0447a {
        /* renamed from: a */
        void mo1288a();
    }

    protected C0448d(Context context) {
        super(context);
        this.f1407e = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
        this.f1410k = 0;
        this.f1411l = C0430a.m1854a();
        this.f1412m = null;
        this.c = "/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json";
        m1956f();
    }

    /* renamed from: a */
    public static C0448d m1932a(Context context) {
        if (f1404h != null) {
            return f1404h;
        }
        f1404h = new C0448d(context);
        return f1404h;
    }

    /* renamed from: a */
    private String m1934a(HashMap<String, String> hashMap) {
        int i;
        String a = C0554h.m2383f() ? C0554h.m2370a() : C0554h.m2374b();
        if ((C0578p.m2531a() && PushSettings.m1837m(this.a)) || ((C0578p.m2556c() && PushSettings.m1840p(this.a)) || ((C0578p.m2547b() && PushSettings.m1838n(this.a)) || (C0578p.m2563d() && PushSettings.m1839o(this.a))))) {
            this.f1407e = a + "/rest/3.0/clientfile/updateconf";
            i = 2;
        } else {
            this.f1407e = a + "/rest/3.0/clientfile/updatesdkconfig";
            i = 2;
        }
        do {
            C0520a a2 = C0521b.m2164a(this.f1407e, "POST", hashMap, "BCCS_SDK/3.0");
            if (a2 != null) {
                int b = a2.m2162b();
                String a3 = C0532b.m2252a(a2.m2159a());
                if (b == 200) {
                    return a3;
                }
            }
            i--;
        } while (i > 0);
        return null;
    }

    /* renamed from: a */
    private static String m1935a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte toHexString : bArr) {
            String toHexString2 = Integer.toHexString(toHexString);
            int length = toHexString2.length();
            if (length == 1) {
                toHexString2 = "0" + toHexString2;
            }
            if (length > 2) {
                toHexString2 = toHexString2.substring(length - 2, length);
            }
            stringBuffer.append(toHexString2.toUpperCase(Locale.ENGLISH));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m1936a(C0445c c0445c) {
        String str = "CONFIG_MANUFACTURER_DEFAULT";
        if (c0445c != null) {
            str = c0445c.toString();
        }
        C0574m.m2470a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", str);
        C0574m.m2466a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.f1408i);
        m1950k();
    }

    /* renamed from: a */
    private boolean m1937a(C0445c c0445c, String str) {
        int i;
        if (!(c0445c == null || c0445c.m1925d() == null || c0445c.m1925d().size() <= 0)) {
            int i2 = 0;
            while (i2 < c0445c.m1925d().size()) {
                C0449e c0449e = (C0449e) c0445c.m1925d().get(i2);
                try {
                    CharSequence a = C0561a.m2417a().m2418a(c0449e.m1957a(), "");
                    String b = c0449e.m1960b();
                    if (c0449e.m1962c() == 0) {
                        if (!(TextUtils.isEmpty(b) || TextUtils.isEmpty(a))) {
                            double d = 0.0d;
                            double d2 = 0.0d;
                            try {
                                d = Double.parseDouble(b);
                                d2 = d;
                                d = Double.parseDouble(a);
                            } catch (NumberFormatException e) {
                                double d3 = d2;
                                d2 = d;
                                d = d3;
                            }
                            if (d >= d2) {
                                return true;
                            }
                            C0527a.m2216a("ModeConfig", "manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        }
                        i2++;
                    } else {
                        if (c0449e.m1962c() == 1) {
                            if (!(TextUtils.isEmpty(b) || TextUtils.isEmpty(a))) {
                                int i3 = 0;
                                i = 0;
                                try {
                                    i3 = Integer.parseInt(b);
                                    i = i3;
                                    i3 = Integer.parseInt(a);
                                } catch (NumberFormatException e2) {
                                    int i4 = i;
                                    i = i3;
                                    i3 = i4;
                                }
                                if (i3 == i) {
                                    return true;
                                }
                                C0527a.m2216a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
                            }
                        } else if (c0449e.m1962c() != 2) {
                            continue;
                        } else if (Pattern.matches(b, a)) {
                            return true;
                        } else {
                            C0527a.m2216a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
                        }
                        i2++;
                    }
                } catch (Exception e3) {
                }
            }
        }
        if (c0445c.m1926e() != null && c0445c.m1926e().size() > 0) {
            for (i = 0; i < c0445c.m1926e().size(); i++) {
                C0450f c0450f = (C0450f) c0445c.m1926e().get(i);
                try {
                    String str2 = "";
                    Class cls = Class.forName("android.os.SystemProperties");
                    CharSequence charSequence = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{c0450f.m1963a()});
                    Object toLowerCase = Build.MODEL.toLowerCase();
                    Object obj = null;
                    if (!TextUtils.isEmpty(toLowerCase) && toLowerCase.contains("nexus")) {
                        obj = 1;
                        C0527a.m2216a("ModeConfig", "manufaturer  is Nexus ", this.a);
                    }
                    if (str.equalsIgnoreCase("HUAWEI") && r3 == null && !charSequence.matches("\\d+\\.\\d+$") && VERSION.SDK_INT >= 21 && PushSettings.m1840p(this.a)) {
                        charSequence = UserOPParams.GUIDE_3_1;
                    }
                    if (str.equalsIgnoreCase("OPPO") && PushSettings.m1839o(this.a) && !C0448d.m1947h(this.a)) {
                        charSequence = "V1.0";
                    }
                    Matcher matcher = Pattern.compile(c0450f.m1968c()).matcher(charSequence);
                    if (matcher.find()) {
                        Double valueOf = Double.valueOf(str.equalsIgnoreCase("OPPO") ? matcher.group(1) : matcher.group());
                        Double valueOf2 = Double.valueOf(c0450f.m1966b());
                        if (c0450f.m1970d() == 0) {
                            if (valueOf.doubleValue() >= valueOf2.doubleValue()) {
                                return true;
                            }
                            C0527a.m2216a("ModeConfig", "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
                        } else if (c0450f.m1970d() != 1) {
                            continue;
                        } else if (valueOf == valueOf2) {
                            return true;
                        } else {
                            C0527a.m2216a("ModeConfig", "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e4) {
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private C0445c m1938b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String toUpperCase = str.toUpperCase();
        if (Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown") && this.f1406d != null) {
            for (Entry key : this.f1406d.entrySet()) {
                String str2 = (String) key.getKey();
                if (m1937a((C0445c) this.f1406d.get(str2), str2)) {
                    return (C0445c) this.f1406d.get(str2);
                }
            }
        } else if (this.f1406d != null && this.f1406d.containsKey(toUpperCase) && m1937a((C0445c) this.f1406d.get(toUpperCase), toUpperCase)) {
            return (C0445c) this.f1406d.get(toUpperCase);
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m1939b(Context context) {
        try {
            Class.forName("com.meizu.cloud.pushsdk.PushManager");
            return C0448d.m1932a(context).m1952b() == 7 && PushSettings.m1838n(context);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m1940c(Context context) {
        try {
            Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            return C0448d.m1932a(context).m1952b() == 6 && PushSettings.m1837m(context);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m1941d(Context context) {
        return C0448d.m1932a(context).m1952b() == 5 && PushSettings.m1840p(context);
    }

    /* renamed from: e */
    public static boolean m1942e(Context context) {
        try {
            Class.forName("com.coloros.mcssdk.PushManager");
            return C0448d.m1932a(context).m1952b() == 8 && PushSettings.m1839o(context);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m1943f(Context context) {
        return C0578p.m2563d() && C0448d.m1947h(context);
    }

    /* renamed from: g */
    public static boolean m1945g(Context context) {
        return C0448d.m1941d(context) || C0448d.m1940c(context) || C0448d.m1939b(context) || C0448d.m1942e(context);
    }

    /* renamed from: h */
    private boolean m1946h() {
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            this.f1408i = jSONObject.getInt("version");
            this.f1406d = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("modeconfig");
            for (int i = 0; i < jSONArray.length(); i++) {
                C0445c c0445c = new C0445c(jSONArray.getString(i));
                this.f1406d.put(c0445c.m1920b(), c0445c);
            }
            this.f1409j = m1938b(Build.MANUFACTURER.toUpperCase());
            m1936a(this.f1409j);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    /* renamed from: h */
    private static boolean m1947h(Context context) {
        try {
            return PushManager.isSupportPush(context);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: i */
    private boolean m1948i() {
        this.f1408i = C0574m.m2471b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
        if (this.f1408i == -1) {
            return false;
        }
        String a = C0574m.m2465a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        if (!a.equals("CONFIG_MANUFACTURER_DEFAULT")) {
            this.f1409j = new C0445c(a);
        }
        return true;
    }

    /* renamed from: j */
    private boolean m1949j() {
        long j = 0;
        if (System.currentTimeMillis() - C0574m.m2474c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE") > Config.MAX_LOG_DATA_EXSIT_TIME) {
            return true;
        }
        long c = C0574m.m2474c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
        File file = new File(this.c);
        if (!file.exists()) {
            return true;
        }
        if (c <= 0 || c != file.lastModified()) {
            return true;
        }
        long c2 = C0574m.m2474c(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
        for (String file2 : f1405n) {
            File file3 = new File(file2);
            if (file3.exists()) {
                j += file3.lastModified() / 10;
            }
        }
        return c2 != j;
    }

    /* renamed from: k */
    private void m1950k() {
        File file = new File(this.c);
        if (file.exists()) {
            C0574m.m2467a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", file.lastModified());
            long j = 0;
            for (String file2 : f1405n) {
                File file3 = new File(file2);
                if (file3.exists()) {
                    j += file3.lastModified() / 10;
                }
            }
            C0574m.m2467a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", j);
            C0574m.m2467a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    public synchronized void m1951a(C0447a c0447a) {
        f1403g = false;
        Object D;
        if (C0578p.m2531a() && PushSettings.m1837m(this.a) && !C0448d.m1940c(this.a)) {
            try {
                D = C0578p.m2498D(this.a);
                if (!TextUtils.isEmpty(D) && ((double) Float.parseFloat(D)) >= 4.0d) {
                    f1402f = 0;
                }
            } catch (Exception e) {
            }
        } else if (C0578p.m2556c() && PushSettings.m1840p(this.a) && !C0448d.m1941d(this.a)) {
            try {
                D = C0578p.m2498D(this.a);
                if (!TextUtils.isEmpty(D) && ((double) Float.parseFloat(D)) >= 3.1d) {
                    f1402f = 0;
                }
            } catch (Exception e2) {
            }
        } else if (C0578p.m2547b() && PushSettings.m1838n(this.a) && !C0448d.m1939b(this.a)) {
            try {
                D = C0578p.m2498D(this.a);
                if (!TextUtils.isEmpty(D) && ((double) Float.parseFloat(D)) >= 5.0d) {
                    f1402f = 0;
                }
            } catch (Exception e3) {
            }
        } else if (C0578p.m2563d() && PushSettings.m1839o(this.a) && !C0448d.m1942e(this.a)) {
            try {
                D = C0578p.m2498D(this.a);
                if (!TextUtils.isEmpty(D) && ((double) Float.parseFloat(D)) >= 3.0d) {
                    f1402f = 0;
                }
            } catch (Exception e4) {
            }
        } else {
            f1402f = 259200000;
            if (c0447a != null) {
                f1403g = true;
                c0447a.mo1288a();
            }
        }
        long c = C0574m.m2474c(this.a, "last_update_config_time");
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - c > ((long) f1402f)) {
            final C0447a c0447a2 = c0447a;
            C0559d.m2387a().m2388a(new C0420c(this, "ModeConfig-updateConfig", (short) 100) {
                /* renamed from: c */
                final /* synthetic */ C0448d f1401c;

                /* renamed from: a */
                public void mo1272a() {
                    try {
                        HashMap hashMap = new HashMap();
                        C0486b.m2078a(hashMap);
                        hashMap.put("version", this.f1401c.f1408i + "");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("osSdkInt", VERSION.SDK_INT + "");
                        if ((C0578p.m2531a() && PushSettings.m1837m(this.f1401c.a)) || ((C0578p.m2556c() && PushSettings.m1840p(this.f1401c.a)) || ((C0578p.m2547b() && PushSettings.m1838n(this.f1401c.a)) || (C0578p.m2563d() && PushSettings.m1839o(this.f1401c.a))))) {
                            hashMap.put("manufacture", Build.MANUFACTURER);
                            hashMap.put("sdk_version", C0430a.m1854a() + "");
                            hashMap.put("cuid", C0589e.m2639a(this.f1401c.a));
                            hashMap.put("channelid", PushSettings.m1816a(this.f1401c.a));
                            hashMap.put("package_name", this.f1401c.a.getPackageName());
                            hashMap.put("pkg_sign", C0578p.m2594r(this.f1401c.a, this.f1401c.a.getPackageName()));
                            hashMap.put("rom_version", C0578p.m2498D(this.f1401c.a));
                        } else {
                            hashMap.put("manufacturer", Build.MANUFACTURER);
                            hashMap.put("pushSdkInt", C0430a.m1854a() + "");
                        }
                        Object a = this.f1401c.m1934a(hashMap);
                        if (!TextUtils.isEmpty(a)) {
                            JSONObject jSONObject = (JSONObject) new JSONObject(a).get("response_params");
                            if (jSONObject != null && jSONObject.getInt("status") == 1) {
                                a = jSONObject.getString("sdkconfig");
                                if (!TextUtils.isEmpty(a) && this.f1401c.m1913a(a)) {
                                    this.f1401c.m1956f();
                                    C0574m.m2467a(this.f1401c.a, "last_update_config_time", currentTimeMillis);
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                    if (c0447a2 != null && !C0448d.f1403g) {
                        c0447a2.mo1288a();
                    }
                }
            });
        } else if (!(c0447a == null || f1403g)) {
            c0447a.mo1288a();
        }
    }

    /* renamed from: b */
    public int m1952b() {
        return this.f1410k;
    }

    /* renamed from: c */
    public String m1953c() {
        return this.f1412m;
    }

    /* renamed from: d */
    public int m1954d() {
        return this.f1411l;
    }

    /* renamed from: e */
    public boolean m1955e() {
        byte[] bArr = null;
        if (this.f1409j == null) {
            return true;
        }
        if (this.f1409j.m1923c() == 5) {
            this.f1410k = 5;
            return true;
        } else if (this.f1409j.m1923c() == 6) {
            this.f1410k = 6;
            return true;
        } else if (this.f1409j.m1923c() == 7) {
            this.f1410k = 7;
            return true;
        } else if (this.f1409j.m1923c() == 8) {
            this.f1410k = 8;
            return true;
        } else {
            if (this.f1409j.m1923c() == 2 && !TextUtils.isEmpty(this.f1409j.m1927f())) {
                try {
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f1409j.m1927f(), SearchByTypeDataStruct.TYPE_BANK);
                    if (packageInfo != null) {
                        int i;
                        int i2 = packageInfo.versionCode;
                        if (this.f1409j.m1915a() == null) {
                            i = 0;
                        } else if (this.f1409j.m1915a().f1389b == -1) {
                            i = i2 >= this.f1409j.m1915a().f1388a ? 1 : 0;
                        } else {
                            i = (i2 >= this.f1409j.m1915a().f1388a ? 1 : 0) & (i2 <= this.f1409j.m1915a().f1389b ? 1 : 0);
                        }
                        if (i != 0) {
                            CertificateFactory instance;
                            X509Certificate x509Certificate;
                            InputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                instance = CertificateFactory.getInstance("X509");
                            } catch (CertificateException e) {
                                instance = bArr;
                            }
                            try {
                                x509Certificate = (X509Certificate) instance.generateCertificate(byteArrayInputStream);
                            } catch (CertificateException e2) {
                                x509Certificate = bArr;
                            }
                            String str = "";
                            try {
                                bArr = C0592h.m2675a(x509Certificate.getEncoded());
                            } catch (Exception e3) {
                            }
                            if (C0448d.m1935a(bArr).equalsIgnoreCase(this.f1409j.m1928g())) {
                                this.f1412m = this.f1409j.m1927f();
                                this.f1411l = C0578p.m2584m(this.a, this.f1412m);
                                if (this.a.getPackageName().equalsIgnoreCase(this.f1409j.m1927f())) {
                                    this.f1410k = 3;
                                    return true;
                                }
                                this.f1410k = 4;
                                return true;
                            }
                        }
                    }
                } catch (NameNotFoundException e4) {
                    return false;
                }
            }
            C0527a.m2216a("ModeConfig", " Current Mode = " + this.f1410k, this.a);
            return false;
        }
    }

    /* renamed from: f */
    public void m1956f() {
        boolean j = m1949j();
        boolean i = m1948i();
        if ((j || !i) && m1912a()) {
            m1946h();
        }
        if (this.f1409j != null) {
            m1955e();
        } else {
            C0527a.m2216a("ModeConfig", "Config File Not Matched", this.a);
        }
    }
}
