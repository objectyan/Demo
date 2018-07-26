package com.baidu.android.pushservice.p029h;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.message.p033a.C0612l;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0567f;
import com.baidu.android.pushservice.p031j.C0568g;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.h.q */
public class C0553q {
    /* renamed from: a */
    private final Context f1821a;
    /* renamed from: b */
    private C0541g f1822b;
    /* renamed from: c */
    private final C0549o f1823c;

    public C0553q(Context context) {
        this.f1821a = context;
        this.f1823c = new C0549o(context);
        this.f1822b = C0541g.m2318a(context);
    }

    /* renamed from: a */
    public static long m2352a(Context context, C0536b c0536b) {
        return C0463a.m1990a(context, c0536b);
    }

    /* renamed from: a */
    public static long m2353a(Context context, C0539f c0539f) {
        return C0463a.m1991a(context, c0539f);
    }

    /* renamed from: a */
    public static long m2354a(Context context, C0543i c0543i) {
        return C0463a.m1992a(context, c0543i);
    }

    /* renamed from: a */
    public static long m2355a(Context context, C0544j c0544j) {
        return C0463a.m1993a(context, c0544j);
    }

    /* renamed from: a */
    public static long m2356a(Context context, C0545k c0545k) {
        return C0463a.m1994a(context, c0545k);
    }

    /* renamed from: a */
    public static long m2357a(Context context, String str, int i, String str2) {
        C0543i c0543i = new C0543i();
        c0543i.e = System.currentTimeMillis();
        c0543i.f = C0532b.m2255b(context);
        c0543i.g = i;
        c0543i.i = str2;
        c0543i.d = str;
        return C0553q.m2354a(context, c0543i);
    }

    /* renamed from: a */
    public static long m2358a(Context context, String str, String str2, int i, String str3) {
        C0536b c0536b = new C0536b();
        c0536b.d = str;
        c0536b.j = str2;
        c0536b.g = i;
        c0536b.f1755a = str3;
        c0536b.e = System.currentTimeMillis();
        c0536b.f = C0532b.m2255b(context);
        return C0553q.m2352a(context, c0536b);
    }

    /* renamed from: a */
    public static String m2359a(Context context) {
        String str = "";
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static void m2360a(final Context context, final String str) {
        C0559d.m2387a().m2388a(new C0420c("insertNetworkInfo", (short) 95) {
            /* renamed from: a */
            public void mo1272a() {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
                if (System.currentTimeMillis() - sharedPreferences.getLong(str, 0) >= 1800000) {
                    C0553q.m2357a(context, str, 0, str.equals("039912") ? C0578p.m2604w(context) : C0578p.m2606x(context));
                    Editor edit = sharedPreferences.edit();
                    edit.putLong(str, System.currentTimeMillis());
                    edit.commit();
                }
            }
        });
    }

    /* renamed from: a */
    public static void m2361a(Context context, String str, String str2) {
        final String str3 = str2;
        final String str4 = str;
        final Context context2 = context;
        C0559d.m2387a().m2388a(new C0420c("insertNotificationAction", (short) 90) {
            /* renamed from: a */
            public void mo1272a() {
                C0545k c0545k = new C0545k();
                c0545k.d = str3;
                c0545k.f1803a = str4;
                c0545k.e = System.currentTimeMillis();
                c0545k.f = C0532b.m2255b(context2);
                c0545k.f1805c = C0612l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.m2706a();
                c0545k.h = PushSettings.m1821b(context2);
                c0545k.j = context2.getPackageName();
                C0553q.m2356a(context2, c0545k);
            }
        });
    }

    /* renamed from: a */
    public static void m2362a(Context context, Throwable th) {
        C0539f c0539f = new C0539f();
        c0539f.d = "040102";
        c0539f.e = System.currentTimeMillis();
        c0539f.f = C0532b.m2255b(context);
        c0539f.f1783a = C0553q.m2364b(context, th);
        C0553q.m2353a(context, c0539f);
    }

    /* renamed from: b */
    public static long m2363b(Context context, C0543i c0543i) {
        return C0463a.m2004b(context, c0543i);
    }

    /* renamed from: b */
    public static String m2364b(Context context, Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        Object a = C0553q.m2359a(context);
        if (!TextUtils.isEmpty(a)) {
            obj = a + "\n" + obj;
        }
        printWriter.close();
        return obj;
    }

    /* renamed from: b */
    public static void m2365b(Context context, String str) {
        C0539f c0539f = new C0539f();
        c0539f.d = "040101";
        c0539f.e = System.currentTimeMillis();
        c0539f.f = C0532b.m2255b(context);
        c0539f.f1783a = str;
        C0553q.m2353a(context, c0539f);
    }

    /* renamed from: b */
    private boolean m2366b() {
        if (PushSettings.m1833i(this.f1821a) || this.f1822b.m2316c()) {
            return false;
        }
        return System.currentTimeMillis() - C0568g.m2442b(this.f1821a) > (PushSettings.m1832h(this.f1821a) ? (long) PushSettings.m1831g(this.f1821a) : 43200000);
    }

    /* renamed from: a */
    public void m2367a() {
        if (this.f1823c != null) {
            this.f1823c.m2344b();
        }
    }

    /* renamed from: a */
    public void m2368a(boolean z, C0567f c0567f) {
        if (this.f1822b == null) {
            this.f1822b = C0541g.m2318a(this.f1821a);
        }
        this.f1822b.m2320a(c0567f);
        if (z || m2366b()) {
            this.f1822b.m2313b(z);
        }
    }
}
