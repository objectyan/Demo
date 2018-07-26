package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.mobstat.Config;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

/* renamed from: com.baidu.android.pushservice.h */
public final class C0554h {
    /* renamed from: a */
    public static int f1824a = 5287;
    /* renamed from: b */
    public static int f1825b = 5288;
    /* renamed from: c */
    public static String[] f1826c = new String[]{"202.108.23.105", "180.149.132.107", "111.13.12.162", "180.149.131.209", "111.13.12.110", "111.13.100.86", " 111.13.100.85", " 61.135.185.18", "220.181.163.183", "220.181.163.182", " 115.239.210.219", "115.239.210.246"};
    /* renamed from: d */
    public static String f1827d = "http://m.baidu.com";
    /* renamed from: e */
    public static final String f1828e = f1836m;
    /* renamed from: f */
    public static final String f1829f = (f1828e + "/searchbox?action=publicsrv&type=issuedcode");
    /* renamed from: g */
    private static String f1830g = "api.tuisong.baidu.com";
    /* renamed from: h */
    private static String[] f1831h = new String[]{"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
    /* renamed from: i */
    private static String f1832i = "sa.tuisong.baidu.com";
    /* renamed from: j */
    private static String[] f1833j = new String[]{"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};
    /* renamed from: k */
    private static final String[] f1834k = new String[]{"202.108.23.109", "180.149.132.103", "111.13.12.174", "111.13.12.61"};
    /* renamed from: l */
    private static boolean f1835l = true;
    /* renamed from: m */
    private static String f1836m = "http://m.baidu.com";
    /* renamed from: n */
    private static ArrayList<String> f1837n = null;
    /* renamed from: o */
    private static ArrayList<String> f1838o = null;
    /* renamed from: p */
    private static boolean f1839p = false;

    /* renamed from: a */
    public static int m2369a(Context context) {
        return C0578p.m2502F(context) ? f1825b : f1824a;
    }

    /* renamed from: a */
    public static String m2370a() {
        return "http://" + f1830g;
    }

    /* renamed from: a */
    public static String m2371a(Context context, boolean z) {
        if (f1838o == null || f1838o.isEmpty() || f1835l) {
            f1838o = C0554h.m2372a(context, ".baidu.push.sa");
        }
        if (f1838o != null && f1838o.size() > 0) {
            if (!z) {
                f1838o.remove(0);
            }
            if (f1838o.size() > 0) {
                return (String) f1838o.get(0);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static ArrayList<String> m2372a(Context context, String str) {
        int i = 0;
        ArrayList<String> b = C0554h.m2376b(context, str);
        if (b.size() <= 0) {
            String[] strArr;
            int length;
            if (str.equals(".baidu.push.http")) {
                strArr = f1834k;
                length = strArr.length;
                while (i < length) {
                    b.add(strArr[i]);
                    i++;
                }
            } else {
                strArr = f1826c;
                length = strArr.length;
                while (i < length) {
                    b.add(strArr[i]);
                    i++;
                }
            }
            f1835l = true;
            C0554h.m2380c(context);
        } else {
            f1835l = false;
        }
        return b;
    }

    /* renamed from: b */
    public static String m2374b() {
        return "https://" + f1830g;
    }

    /* renamed from: b */
    public static String m2375b(Context context, boolean z) {
        if (f1837n == null || f1837n.isEmpty()) {
            f1837n = C0554h.m2372a(context, ".baidu.push.http");
        }
        if (f1837n != null && f1837n.size() > 0) {
            if (!z) {
                f1837n.remove(0);
            }
            if (f1837n.size() > 0) {
                return (String) f1837n.get(0);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static ArrayList<String> m2376b(Context context, String str) {
        int i = 0;
        ArrayList<String> arrayList = new ArrayList();
        Object string = context.getSharedPreferences("pst", 0).getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (split != null && split.length > 0) {
                while (i < split.length) {
                    arrayList.add(split[i]);
                    i++;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m2377b(Context context) {
        Closeable closeable;
        Throwable th;
        File file = new File(Environment.getExternalStorageDirectory(), "pushservice.cfg");
        if (file.exists()) {
            Properties properties = new Properties();
            Closeable closeable2 = null;
            try {
                InputStream fileInputStream;
                Object obj;
                if (C0578p.m2601u(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream);
                    } catch (Exception e) {
                        C0521b.m2169a(closeable);
                        return;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        obj = fileInputStream;
                        th = th3;
                        C0521b.m2169a(closeable2);
                        throw th;
                    }
                }
                properties.put("http_server", "http://10.95.41.15:8080");
                if (C0578p.m2502F(context)) {
                    properties.put("socket_server_port_v3", "8006");
                } else {
                    properties.put("socket_server_port", "8005");
                }
                properties.put("socket_server", "10.95.41.15");
                fileInputStream = null;
                String property = properties.getProperty("http_server");
                if (!TextUtils.isEmpty(property)) {
                    if (property.startsWith("http://")) {
                        property = property.replace("http://", "");
                    }
                    f1830g = property;
                }
                obj = properties.getProperty("socket_server");
                if (!TextUtils.isEmpty(obj)) {
                    f1832i = obj;
                }
                if (C0578p.m2502F(context)) {
                    obj = properties.getProperty("socket_server_port_v3");
                    if (!TextUtils.isEmpty(obj)) {
                        f1825b = Integer.parseInt(obj);
                    }
                } else {
                    obj = properties.getProperty("socket_server_port");
                    if (!TextUtils.isEmpty(obj)) {
                        f1824a = Integer.parseInt(obj);
                    }
                }
                property = properties.getProperty("config_server");
                if (!TextUtils.isEmpty(property)) {
                    f1836m = property;
                }
                if (!TextUtils.isEmpty(properties.getProperty("lightapp_server"))) {
                    f1827d = property;
                }
                if (C0522f.f1689a == 0) {
                    obj = properties.getProperty("api_key");
                    if (TextUtils.equals(properties.getProperty(PushConstants.PACKAGE_NAME), context.getPackageName()) && !TextUtils.isEmpty(obj)) {
                        C0522f.f1690b = obj;
                    }
                }
                f1839p = true;
                C0521b.m2169a(fileInputStream);
                return;
            } catch (Exception e2) {
                closeable = null;
                C0521b.m2169a(closeable);
                return;
            } catch (Throwable th4) {
                th = th4;
                C0521b.m2169a(closeable2);
                throw th;
            }
        }
        String a = PushSettings.m1816a(context);
        if (!TextUtils.isEmpty(a) && a.length() > 0) {
            try {
                int parseInt = Integer.parseInt(a.substring(a.length() - 1));
                f1830g = f1831h[parseInt % 10];
                f1832i = f1833j[parseInt % 10];
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: b */
    private static boolean m2378b(Context context, String str, String str2) {
        try {
            if (str.startsWith("http://")) {
                str = str.replace("http://", "");
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (!(context == null || allByName == null || allByName.length <= 0)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
                String str3 = "";
                for (InetAddress hostAddress : allByName) {
                    str3 = str3 + Config.TRACE_TODAY_VISIT_SPLIT + hostAddress.getHostAddress();
                }
                if (str3.length() > 1) {
                    String substring = str3.substring(1);
                    Editor edit = sharedPreferences.edit();
                    edit.putString(str2, substring);
                    edit.commit();
                    return true;
                }
            }
        } catch (Throwable e) {
            C0553q.m2362a(context, e);
        }
        return false;
    }

    /* renamed from: c */
    public static String m2379c() {
        return f1832i;
    }

    /* renamed from: c */
    public static void m2380c(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        if (System.currentTimeMillis() - sharedPreferences.getLong(".baidu.push.dns.refresh", 0) > 86400000) {
            C0559d.m2387a().m2388a(new C0420c("updateBackupIp", (short) 95) {
                /* renamed from: a */
                public void mo1272a() {
                    boolean a = C0554h.m2378b(context.getApplicationContext(), C0554h.f1832i, ".baidu.push.sa");
                    boolean a2 = C0554h.m2378b(context.getApplicationContext(), C0554h.f1830g, ".baidu.push.http");
                    if (a && a2) {
                        Editor edit = sharedPreferences.edit();
                        edit.putLong(".baidu.push.dns.refresh", System.currentTimeMillis());
                        edit.commit();
                    }
                }
            });
        }
    }

    /* renamed from: d */
    public static String m2381d() {
        return f1839p ? C0554h.m2370a() + "/rest/2.0/channel/channel" : C0554h.m2374b() + "/rest/2.0/channel/channel";
    }

    /* renamed from: e */
    public static String m2382e() {
        return f1839p ? C0554h.m2370a() + "/rest/2.0/channel/" : C0554h.m2374b() + "/rest/2.0/channel/";
    }

    /* renamed from: f */
    public static boolean m2383f() {
        return f1839p;
    }
}
