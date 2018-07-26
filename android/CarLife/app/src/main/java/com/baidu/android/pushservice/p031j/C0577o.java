package com.baidu.android.pushservice.p031j;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0554h;
import com.baidu.android.pushservice.C0560i;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p032k.C0583c;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.facebook.common.p262l.C5361b;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.j.o */
public class C0577o {
    /* renamed from: a */
    public static void m2483a(Context context) {
        C0527a.m2216a("ServiceUtils", "--- Start Service from " + context.getPackageName(), context.getApplicationContext());
        if (C0430a.m1859b(context)) {
            C0577o.m2487b(context);
            C0430a.m1855a(context, false);
            return;
        }
        C0577o.m2490d(context);
    }

    /* renamed from: a */
    public static void m2484a(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = C0577o.m2489c(context);
        }
        if (C0448d.m1945g(context)) {
            C0560i.m2390a(context).m2415a(intent);
        } else {
            C0577o.m2485a(context, intent, C0578p.m2603v(context));
        }
    }

    /* renamed from: a */
    private static void m2485a(Context context, Intent intent, String str) {
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        C0527a.m2216a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setClassName(str, "com.baidu.android.pushservice.PushService");
                context.startService(intent);
                C0527a.m2216a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                return;
            }
        } catch (Exception e) {
            C0527a.m2218b("ServiceUtils", "START SERVICE E: " + e, context.getApplicationContext());
        }
        if (!C0578p.m2503G(context) && C0578p.m2577i(context, str)) {
            try {
                Object c = C0578p.m2554c(context, str, intent.getAction());
                if (!TextUtils.isEmpty(c)) {
                    intent.setClassName(str, c);
                    context.sendBroadcast(intent);
                    C0527a.m2216a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                    return;
                }
            } catch (Exception e2) {
                C0527a.m2218b("ServiceUtils", "START SERVICE E-2: " + e2, context.getApplicationContext());
            }
            context.sendBroadcast(intent);
            C0527a.m2216a("ServiceUtils", "startPushService by sendBroadcast all", context.getApplicationContext());
        }
    }

    /* renamed from: a */
    public static void m2486a(Context context, String str) {
        Intent c = C0577o.m2489c(context);
        if (C0578p.m2502F(context)) {
            c.putExtra("method", "pushservice_restart_v3");
            if (!TextUtils.isEmpty(str) && str.equals(context.getPackageName())) {
                c.putExtra("priority3", C5361b.f21945a);
            }
        } else {
            c.putExtra("method", "pushservice_restart_v2");
            if (!TextUtils.isEmpty(str) && str.equals(context.getPackageName())) {
                c.putExtra("priority2", C5361b.f21945a);
            }
        }
        C0577o.m2485a(context, c, str);
    }

    /* renamed from: b */
    public static void m2487b(Context context) {
        if (context != null) {
            String u = C0578p.m2600u(context);
            long g = C0578p.m2572g(context, u);
            if (!TextUtils.isEmpty(u) && !u.equals(context.getPackageName()) && ((C0448d.m1932a(context).m1952b() != 4 && g < C0578p.m2574h(context)) || C0448d.m1932a(context).m1952b() == 3)) {
                C0577o.m2486a(context, u);
            } else if (TextUtils.isEmpty(u) || u.equals(context.getPackageName())) {
                List<String> r = C0578p.m2595r(context);
                if (!r.isEmpty()) {
                    for (String u2 : r) {
                        if (!context.getPackageName().equals(u2) && ((C0578p.m2502F(context) && C0578p.m2611z(context, u2)) || !(C0578p.m2502F(context) || C0578p.m2611z(context, u2)))) {
                            C0577o.m2486a(context, u2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m2488b(Context context, Intent intent) {
        C0577o.m2485a(context, intent, context.getPackageName());
    }

    /* renamed from: c */
    public static Intent m2489c(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.addFlags(32);
        try {
            intent.putExtra(PushConstants.PACKAGE_NAME, context.getPackageName());
            intent.putExtra("method_version", "V2");
            if (C0578p.m2502F(context)) {
                intent.putExtra("priority3", C0578p.m2574h(context));
            } else {
                intent.putExtra("priority2", C0578p.m2574h(context));
            }
        } catch (Exception e) {
        }
        return intent;
    }

    /* renamed from: d */
    public static void m2490d(Context context) {
        C0448d.m1932a(context).m1955e();
        if (!C0448d.m1945g(context)) {
            String u = C0578p.m2600u(context);
            final String v = C0578p.m2603v(context);
            if (TextUtils.isEmpty(u) || !u.equals(v)) {
                C0577o.m2486a(context, u);
            }
            final Context applicationContext = context.getApplicationContext();
            C0559d.m2387a().m2388a(new C0420c("checkAndStartPushService", (short) 98) {
                /* renamed from: a */
                public void mo1272a() {
                    Exception e;
                    boolean z = false;
                    try {
                        List<RunningServiceInfo> runningServices = ((ActivityManager) applicationContext.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningServices(1000);
                        boolean z2;
                        if (C0578p.m2502F(applicationContext)) {
                            if (C0578p.m2595r(applicationContext).contains(v)) {
                                for (String str : C0583c.m2632a("netstat -ant", null)) {
                                    if (str.toUpperCase().contains("ESTABLISHED") && str.contains(String.valueOf(C0554h.f1825b))) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            z2 = false;
                            z = z2;
                        } else if (!(TextUtils.isEmpty(v) || runningServices == null || runningServices.isEmpty())) {
                            for (RunningServiceInfo runningServiceInfo : runningServices) {
                                String packageName = runningServiceInfo.service.getPackageName();
                                if (runningServiceInfo.service.getClassName().equals("com.baidu.android.pushservice.PushService") && v.equals(packageName)) {
                                    boolean z3 = false;
                                    for (String str2 : C0583c.m2632a("netstat -ant", null)) {
                                        try {
                                            if (z3) {
                                                break;
                                            }
                                            if (str2.toUpperCase().contains("ESTABLISHED")) {
                                                if (str2.contains(String.valueOf(C0554h.f1824a))) {
                                                    z3 = true;
                                                    break;
                                                }
                                                for (CharSequence contains : C0554h.f1826c) {
                                                    if (str2.contains(contains)) {
                                                        z2 = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            z2 = z3;
                                            z3 = z2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            z = z3;
                                        }
                                    }
                                    z = z3;
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        C0527a.m2218b("ServiceUtils", e.getMessage(), applicationContext);
                        C0527a.m2216a("ServiceUtils", "checkAndStartPushService, running is " + z, applicationContext.getApplicationContext());
                        if (!z) {
                            C0577o.m2484a(applicationContext, new Intent());
                        }
                        C0577o.m2491e(applicationContext);
                    }
                    C0527a.m2216a("ServiceUtils", "checkAndStartPushService, running is " + z, applicationContext.getApplicationContext());
                    if (z) {
                        C0577o.m2484a(applicationContext, new Intent());
                    }
                    C0577o.m2491e(applicationContext);
                }
            });
        }
    }

    /* renamed from: e */
    public static void m2491e(Context context) {
        try {
            if (C0578p.m2502F(context)) {
                Object obj;
                List r = C0578p.m2595r(context);
                List<ResolveInfo> n = C0578p.m2587n(context.getApplicationContext());
                for (ResolveInfo resolveInfo : n) {
                    if (r.contains(resolveInfo.activityInfo.packageName)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    for (ResolveInfo resolveInfo2 : n) {
                        C0577o.m2485a(context, new Intent(), resolveInfo2.activityInfo.packageName);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
