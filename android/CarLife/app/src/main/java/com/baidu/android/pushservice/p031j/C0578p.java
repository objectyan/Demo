package com.baidu.android.pushservice.p031j;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.C0560i;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.C0626k;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.p033a.C0600d;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p025d.C0473d;
import com.baidu.android.pushservice.p025d.C0474e;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0533a;
import com.baidu.android.pushservice.p029h.C0544j;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.android.pushservice.p032k.C0590f;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mapframework.common.p202a.C3473h;
import com.baidu.mobstat.Config;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.callback.PushCallback;
import com.facebook.common.p262l.C5361b;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONObject;

@SuppressLint({"WorldReadableFiles"})
/* renamed from: com.baidu.android.pushservice.j.p */
public final class C0578p {
    /* renamed from: a */
    private static final String[] f1867a = new String[]{"android.permission.INTERNET", SystemAuth.READ_PHONE_STATE_AUTH, "android.permission.ACCESS_NETWORK_STATE"};
    /* renamed from: b */
    private static int f1868b = -1;
    /* renamed from: c */
    private static boolean f1869c = false;

    /* renamed from: A */
    public static int m2492A(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.applicationInfo.targetSdkVersion : 0;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: A */
    public static void m2493A(Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
        C0560i.m2390a(context.getApplicationContext()).m2415a(intent);
    }

    /* renamed from: B */
    public static String m2494B(Context context, String str) {
        if (context == null) {
            return null;
        }
        String g;
        try {
            g = C0472c.m2040g(context);
            if (TextUtils.isEmpty(g) && C0578p.m2501E(context)) {
                g = C0579q.m2612a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            if (!TextUtils.isEmpty(g)) {
                ArrayList e = C0432b.m1875e(C0432b.m1871a(g));
                if (e != null) {
                    Iterator it = e.iterator();
                    while (it.hasNext()) {
                        C0437f c0437f = (C0437f) it.next();
                        if (c0437f.m1867c().equals(str)) {
                            g = c0437f.m1861a();
                            break;
                        }
                    }
                }
            }
            g = null;
        } catch (Exception e2) {
            g = null;
        }
        return g;
    }

    /* renamed from: B */
    public static void m2495B(Context context) {
        C0600d.m2684a(context);
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_LBS");
        C0560i.m2390a(context.getApplicationContext()).m2415a(intent);
    }

    /* renamed from: C */
    public static int m2496C(Context context, String str) {
        try {
            String f = C0472c.m2039f(context);
            if (TextUtils.isEmpty(f) && C0578p.m2501E(context)) {
                f = C0579q.m2612a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            if (!TextUtils.isEmpty(f)) {
                ArrayList e = C0432b.m1875e(C0432b.m1871a(f));
                if (e != null) {
                    Iterator it = e.iterator();
                    while (it.hasNext()) {
                        C0437f c0437f = (C0437f) it.next();
                        if (TextUtils.equals(c0437f.m1867c(), str)) {
                            return c0437f.m1869e();
                        }
                    }
                }
            }
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }

    /* renamed from: C */
    public static String m2497C(Context context) {
        String str = "";
        String str2 = "";
        String toUpperCase = Build.MANUFACTURER.toUpperCase();
        if (toUpperCase.contains("XIAOMI")) {
            str2 = "ro.build.version.incremental";
        } else if (toUpperCase.contains("HUAWEI")) {
            str2 = "ro.build.version.emui";
        } else if (toUpperCase.contains("MEIZU")) {
            return Build.DISPLAY;
        } else {
            if (toUpperCase.contains("OPPO")) {
                str2 = "ro.build.version.opporom";
            }
        }
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str2});
        } catch (Exception e) {
            return (VERSION.SDK_INT < 21 || !toUpperCase.contains("HUAWEI")) ? toUpperCase.contains("XIAOMI") ? "MIUI_notfound" : toUpperCase.contains("OPPO") ? "ColorOS_notfound" : str : "EmotionUI_notfound";
        }
    }

    /* renamed from: D */
    public static String m2498D(Context context) {
        String str = "";
        if (C0578p.m2567e()) {
            String str2 = "";
            String toUpperCase = Build.MANUFACTURER.toUpperCase();
            if (toUpperCase.contains("XIAOMI")) {
                str2 = "ro.miui.ui.version.code";
            } else if (toUpperCase.contains("HUAWEI")) {
                str2 = "ro.build.version.emui";
            } else if (toUpperCase.contains("MEIZU")) {
                str2 = "ro.build.display.id";
            } else if (toUpperCase.contains("OPPO")) {
                str2 = "ro.build.version.opporom";
            }
            try {
                Class cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str2});
                try {
                    if (toUpperCase.contains("HUAWEI") && !TextUtils.isEmpty(str2)) {
                        str = str2.substring(str2.indexOf(JNISearchConst.LAYER_ID_DIVIDER) + 1, str2.length());
                        if (!str.matches("\\d+\\.\\d+$") && VERSION.SDK_INT >= 21) {
                            return UserOPParams.GUIDE_3_1;
                        }
                    } else if (toUpperCase.contains("MEIZU")) {
                        Object obj;
                        if (TextUtils.isEmpty(str2)) {
                            obj = Build.DISPLAY;
                        }
                        r1 = Pattern.compile("\\d+(\\.\\d+)?").matcher(obj);
                        return r1.find() ? r1.group() : obj;
                    } else if (!toUpperCase.contains("OPPO") || TextUtils.isEmpty(str2)) {
                        return str2;
                    } else {
                        r1 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str2);
                        return r1.find() ? r1.group(1) : str2;
                    }
                } catch (Exception e) {
                    return (VERSION.SDK_INT >= 21 || !toUpperCase.contains("HUAWEI")) ? toUpperCase.contains("HUAWEI") ? "1.0" : toUpperCase.contains("XIAOMI") ? "4.0" : toUpperCase.contains("MEIZU") ? "5.0" : toUpperCase.contains("OPPO") ? "3.0" : str2 : UserOPParams.GUIDE_3_1;
                }
            } catch (Exception e2) {
                str2 = str;
                if (VERSION.SDK_INT >= 21) {
                }
                if (toUpperCase.contains("HUAWEI")) {
                }
            }
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: D */
    public static boolean m2499D(android.content.Context r9, java.lang.String r10) {
        /*
        r6 = 1;
        r7 = 0;
        r8 = 0;
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2556c();
        if (r0 != 0) goto L_0x0016;
    L_0x0009:
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2531a();
        if (r0 != 0) goto L_0x0016;
    L_0x000f:
        r0 = com.baidu.android.pushservice.p031j.C0578p.m2547b();
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return r7;
    L_0x0016:
        r0 = r9.getContentResolver();	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        if (r0 == 0) goto L_0x00eb;
    L_0x001c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r1.<init>();	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r2 = "content://";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r2 = ".bdpush";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r2 = "/";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r2 = "pushinfo_v3";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r8 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00f5, all -> 0x0101 }
        if (r8 == 0) goto L_0x0083;
    L_0x0053:
        r0 = r8.moveToFirst();	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        if (r0 == 0) goto L_0x00eb;
    L_0x0059:
        r0 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushVersion;	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r0 = r0.name();	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r0 = r8.getColumnIndex(r0);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r0 = r8.getInt(r0);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushPriority;	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = r1.name();	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = r8.getColumnIndex(r1);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = r8.getInt(r1);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        if (r0 <= 0) goto L_0x0081;
    L_0x0077:
        if (r1 != 0) goto L_0x0081;
    L_0x0079:
        r0 = r6;
    L_0x007a:
        if (r8 == 0) goto L_0x007f;
    L_0x007c:
        r8.close();	 Catch:{ Exception -> 0x0108 }
    L_0x007f:
        r7 = r0;
        goto L_0x0015;
    L_0x0081:
        r0 = r7;
        goto L_0x007a;
    L_0x0083:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1.<init>();	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r2 = "content://";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r2 = ".bdpush";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r2 = "/";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r2 = "pushinfo";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0113, all -> 0x0101 }
        if (r0 == 0) goto L_0x00ea;
    L_0x00ba:
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        if (r1 == 0) goto L_0x00ea;
    L_0x00c0:
        r1 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushVersion;	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r1 = r1.name();	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r1 = r0.getInt(r1);	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r2 = com.baidu.android.pushservice.p025d.C0472c.C0470e.PushPriority;	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r2 = r2.name();	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r2 = r0.getColumnIndex(r2);	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        r2 = r0.getInt(r2);	 Catch:{ Exception -> 0x0116, all -> 0x010f }
        if (r1 <= 0) goto L_0x00e8;
    L_0x00de:
        if (r2 != 0) goto L_0x00e8;
    L_0x00e0:
        if (r0 == 0) goto L_0x00e5;
    L_0x00e2:
        r0.close();	 Catch:{ Exception -> 0x010b }
    L_0x00e5:
        r7 = r6;
        goto L_0x0015;
    L_0x00e8:
        r6 = r7;
        goto L_0x00e0;
    L_0x00ea:
        r8 = r0;
    L_0x00eb:
        if (r8 == 0) goto L_0x0015;
    L_0x00ed:
        r8.close();	 Catch:{ Exception -> 0x00f2 }
        goto L_0x0015;
    L_0x00f2:
        r0 = move-exception;
        goto L_0x0015;
    L_0x00f5:
        r0 = move-exception;
        r0 = r8;
    L_0x00f7:
        if (r0 == 0) goto L_0x0015;
    L_0x00f9:
        r0.close();	 Catch:{ Exception -> 0x00fe }
        goto L_0x0015;
    L_0x00fe:
        r0 = move-exception;
        goto L_0x0015;
    L_0x0101:
        r0 = move-exception;
    L_0x0102:
        if (r8 == 0) goto L_0x0107;
    L_0x0104:
        r8.close();	 Catch:{ Exception -> 0x010d }
    L_0x0107:
        throw r0;
    L_0x0108:
        r1 = move-exception;
        goto L_0x007f;
    L_0x010b:
        r0 = move-exception;
        goto L_0x00e5;
    L_0x010d:
        r1 = move-exception;
        goto L_0x0107;
    L_0x010f:
        r1 = move-exception;
        r8 = r0;
        r0 = r1;
        goto L_0x0102;
    L_0x0113:
        r0 = move-exception;
        r0 = r8;
        goto L_0x00f7;
    L_0x0116:
        r1 = move-exception;
        goto L_0x00f7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.j.p.D(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: E */
    private static int m2500E(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), str));
    }

    /* renamed from: E */
    public static boolean m2501E(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if ((packageInfo != null ? packageInfo.applicationInfo.targetSdkVersion : 0) >= 24 && VERSION.SDK_INT >= 24) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    /* renamed from: F */
    public static boolean m2502F(Context context) {
        return !C0578p.m2501E(context);
    }

    /* renamed from: G */
    public static boolean m2503G(Context context) {
        try {
            if (VERSION.SDK_INT < 26) {
                return false;
            }
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo != null && packageInfo.applicationInfo.targetSdkVersion >= 26;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: H */
    public static boolean m2504H(Context context) {
        return C0448d.m1932a(context).m1952b() == 3 && Build.MANUFACTURER.equalsIgnoreCase("koobee");
    }

    /* renamed from: I */
    private static boolean m2505I(Context context) {
        Intent intent = new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(context.getPackageName());
        String str = "com.meizu.cloud.pushsdk.SystemReceiver";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (str.equals(resolveInfo.activityInfo.name)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            C0527a.m2218b("Utility", "error  " + e.getMessage(), context);
        }
    }

    /* renamed from: J */
    private static String m2506J(Context context) {
        String str;
        if (!C0578p.m2537a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            str = "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
            Log.e("BDPushSDK-Utility", str);
            return str;
        } else if (!C0578p.m2537a(context, NetworkListener.f2257d, "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            str = "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared android.net.conn.CONNECTIVITY_CHANGE";
            Log.e("BDPushSDK-Utility", str);
            return str;
        } else if (C0578p.m2537a(context, PushConstants.ACTION_METHOD, "com.baidu.android.pushservice.RegistrationReceiver", true)) {
            return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
        } else {
            str = "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
            Log.e("BDPushSDK-Utility", str);
            return str;
        }
    }

    /* renamed from: K */
    private static String m2507K(Context context) {
        String str;
        if (C0578p.m2508L(context)) {
            str = "xiaomi service is not found or wrong  declared, please check!";
            Log.e("BDPushSDK-Utility", str);
            return str;
        } else if (C0578p.m2509M(context)) {
            str = "meizu service is not found or wrong  declared, please check!";
            Log.e("BDPushSDK-Utility", str);
            return str;
        } else if (!C0578p.m2510N(context)) {
            return C0578p.m2537a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
        } else {
            str = "oppo service is not found or wrong  declared, please check!";
            Log.e("BDPushSDK-Utility", str);
            return str;
        }
    }

    /* renamed from: L */
    private static boolean m2508L(Context context) {
        try {
            boolean z = C0578p.m2531a() && PushSettings.m1837m(context);
            if (z) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                String str = "com.xiaomi.mipush.sdk.PushMessageHandler";
                String str2 = "com.xiaomi.mipush.sdk.MessageHandleService";
                if (packageInfo.services != null) {
                    z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        int E;
                        if (serviceInfo.name.equals(str)) {
                            E = C0578p.m2500E(context, str);
                            if (serviceInfo.exported && (E == 1 || (E == 0 && serviceInfo.enabled))) {
                                z2 = true;
                            } else {
                                Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                            }
                        }
                        if (serviceInfo.name.equals(str2)) {
                            E = C0578p.m2500E(context, str2);
                            if (E == 1 || (E == 0 && serviceInfo.enabled)) {
                                z = true;
                            } else {
                                Log.e("BDPushSDK-Utility", str2 + " is disable, please check!");
                            }
                        }
                    }
                    if (!z) {
                        return true;
                    }
                    if (!z2) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: M */
    private static boolean m2509M(Context context) {
        try {
            boolean z = C0578p.m2547b() && PushSettings.m1838n(context);
            if (z) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                String str = "com.meizu.cloud.pushsdk.NotificationService";
                if (packageInfo.services != null) {
                    z = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals(str)) {
                            int E = C0578p.m2500E(context, str);
                            if (E == 1 || (E == 0 && serviceInfo.enabled)) {
                                z = true;
                            } else {
                                Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                            }
                        }
                    }
                    if (!z) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: N */
    private static boolean m2510N(Context context) {
        try {
            boolean z = C0578p.m2563d() && PushSettings.m1839o(context);
            if (z) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                String str = "com.coloros.mcssdk.PushService";
                if (packageInfo.services != null) {
                    int E;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals(str)) {
                            E = C0578p.m2500E(context, str);
                            if (!(E == 1 || (E == 0 && serviceInfo.enabled))) {
                                Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: O */
    private static boolean m2511O(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.PushInfoProvider");
            ProviderInfo providerInfo = new ProviderInfo();
            String str = "";
            str = "";
            ProviderInfo providerInfo2 = packageManager.getProviderInfo(componentName, 128);
            CharSequence charSequence = providerInfo2.name;
            Object obj = providerInfo2.authority;
            C0527a.m2219c("Utility", "provider name  = " + charSequence + "  export  = " + providerInfo2.exported + " provider authorities = " + obj, context.getApplicationContext());
            if (TextUtils.isEmpty(charSequence)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider did not declared, please check ! ");
                return false;
            } else if (TextUtils.isEmpty(obj) || !obj.endsWith("bdpush")) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider bdpush authority is required, please check !");
                return false;
            } else {
                if (!providerInfo2.exported) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider exported declared wrong, please check ! ");
                }
                if (TextUtils.isEmpty(providerInfo2.writePermission)) {
                    Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider writePermission did not decleared, please check !");
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: P */
    private static boolean m2512P(Context context) {
        if (f1868b == -1) {
            f1868b = C0578p.m2601u(context, "android.permission.WRITE_EXTERNAL_STORAGE") ? 0 : 1;
        }
        return f1868b == 0;
    }

    /* renamed from: Q */
    private static boolean m2513Q(Context context) {
        try {
            Object obj = Build.DISPLAY;
            if (!TextUtils.isEmpty(obj) && obj.contains("VIBEUI_V3.1_1614_5.294.1_ST_K50-T5")) {
                return true;
            }
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(str) && (str.contains("Lenovo K50-t5") || str.contains("Lenovo_K50-t5") || str.contains("Lenovo X3c50") || str.contains("Lenovo_X3c50"))) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static int m2514a(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        if (C0578p.m2584m(context, str2) >= 50) {
            if (!TextUtils.isEmpty(str)) {
                intent.setAction(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
                intent.setClassName(str2, "com.baidu.android.pushservice.CommandService");
            }
            intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_DELIVER");
            intent.putExtra("bd.cross.request.SOURCE_SERVICE", "com.baidu.android.pushservice.PushService");
            return new C0566e(context, intent).m2434b().m2739a();
        }
        C0578p.m2545b(context, intent, str, str2);
        return 0;
    }

    /* renamed from: a */
    public static Intent m2515a(Context context, Intent intent, String str) {
        if (C0430a.m1854a() >= (short) 32) {
            intent.setFlags(32);
            intent.setAction(str);
            Object packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                intent.setClassName(packageName, "com.baidu.android.pushservice.PushService");
            }
        }
        return intent;
    }

    /* renamed from: a */
    public static PackageInfo m2516a(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                packageInfo = packageManager.getPackageInfo(str, 64);
            }
        } catch (Exception e) {
        }
        return packageInfo;
    }

    /* renamed from: a */
    public static C0544j m2517a(C0544j c0544j, Context context, String str) {
        PackageInfo a = C0578p.m2516a(context, str);
        if (a != null) {
            c0544j.m2271c(a.applicationInfo.loadLabel(context.getPackageManager()).toString());
            c0544j.m2275e(a.versionName);
            c0544j.m2265a(a.versionCode);
            c0544j.m2273d(C0578p.m2586n(context, str));
            c0544j.m2268b(C0578p.m2584m(context, str));
        }
        return c0544j;
    }

    /* renamed from: a */
    public static String m2518a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis() - j;
        long ceil = (long) Math.ceil((((double) currentTimeMillis) * 1.0d) / 1000.0d);
        long ceil2 = (long) Math.ceil((double) (((float) (currentTimeMillis / 60)) / 1000.0f));
        long ceil3 = (long) Math.ceil((double) (((float) ((currentTimeMillis / 60) / 60)) / 1000.0f));
        currentTimeMillis = (long) Math.ceil((double) (((float) (((currentTimeMillis / 24) / 60) / 60)) / 1000.0f));
        if (currentTimeMillis - 1 > 3) {
            stringBuffer.append(new SimpleDateFormat("MM月dd日").format(new Date(j)));
        } else if (currentTimeMillis - 1 > 0) {
            stringBuffer.append(currentTimeMillis + "天前");
        } else if (ceil3 - 1 > 0) {
            if (ceil3 >= 24) {
                stringBuffer.append("1天前");
            } else {
                stringBuffer.append(ceil3 + "小时前");
            }
        } else if (ceil2 - 1 > 0) {
            if (ceil2 == 60) {
                stringBuffer.append("1小时前");
            } else {
                stringBuffer.append(ceil2 + "分钟前");
            }
        } else if (ceil - 1 <= 0) {
            stringBuffer.append("刚刚");
        } else if (ceil == 60) {
            stringBuffer.append("1分钟前");
        } else {
            stringBuffer.append(ceil + "秒前");
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m2519a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            applicationInfo = packageManager.getApplicationInfo(str, 128);
            return (applicationInfo == null || applicationInfo.metaData == null) ? null : applicationInfo.metaData.getString(str2);
        } catch (Exception e) {
            applicationInfo = null;
        }
    }

    /* renamed from: a */
    public static String m2520a(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return "0";
        }
        BigInteger bigInteger = new BigInteger(str);
        try {
            if (bigInteger.and(new BigInteger("0800000000000000", 16)).equals(BigInteger.ZERO)) {
                bigInteger = bigInteger.xor(new BigInteger("282335"));
                bigInteger = bigInteger.and(new BigInteger("00ff0000", 16)).shiftLeft(8).add(bigInteger.and(new BigInteger("000000ff", 16)).shiftLeft(16)).add(bigInteger.and(new BigInteger("ff000000", 16)).shiftRight(16).and(new BigInteger("0000ff00", 16))).add(bigInteger.and(new BigInteger("0000ff00", 16)).shiftRight(8));
            } else {
                System.out.println("encode =  1");
                bigInteger = bigInteger.xor(new BigInteger("22727017042830095"));
                bigInteger = bigInteger.and(new BigInteger("000000ff00000000", 16)).shiftLeft(16).add(bigInteger.and(new BigInteger("000000000000ffff", 16)).shiftLeft(32)).add(bigInteger.and(new BigInteger("00ffff0000000000", 16)).shiftRight(24).and(new BigInteger("00000000ffff0000", 16))).add(bigInteger.and(new BigInteger("00000000ffff0000", 16)).shiftRight(16)).add(bigInteger.and(new BigInteger("ff00000000000000", 16)));
            }
            return bigInteger.toString();
        } catch (Exception e) {
            return "0";
        }
    }

    /* renamed from: a */
    public static String m2521a(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static void m2522a(Context context, long j) {
        Context applicationContext = context.getApplicationContext();
        Intent c = C0577o.m2489c(applicationContext);
        Object packageName = applicationContext.getPackageName();
        Object c2 = C0578p.m2554c(applicationContext, packageName, c.getAction());
        if (!(TextUtils.isEmpty(packageName) || TextUtils.isEmpty(c2))) {
            c.setClassName(packageName, c2);
        }
        C0578p.m2524a(applicationContext, c, j);
    }

    /* renamed from: a */
    public static void m2523a(Context context, Intent intent) {
        try {
            Uri data = intent.getData();
            if (data != null) {
                String f = C0578p.m2570f(data.toString());
                Intent intent2 = new Intent();
                String stringExtra = intent.getStringExtra("bdpush_hwmsgid");
                String stringExtra2 = intent.getStringExtra("hwtitle");
                String stringExtra3 = intent.getStringExtra("hwcontent");
                if (!(TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3))) {
                    intent2.putExtra("notification_title", stringExtra2);
                    intent2.putExtra("notification_content", stringExtra3);
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    intent2.putExtra("msgid", stringExtra);
                }
                intent2.putExtra("extra_extra_custom_content", f);
                C0578p.m2536a(context, stringExtra, "", stringExtra2, stringExtra3, f);
                C0578p.m2545b(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2524a(Context context, Intent intent, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m2525a(Context context, C0626k c0626k, byte[] bArr) {
        int i = 0;
        C0533a c0533a = new C0533a();
        c0533a.f1731a = c0626k.m2769h();
        c0533a.f1732b = c0626k.m2759b();
        c0533a.f1733c = c0626k.m2762c();
        c0533a.f1734d = c0626k.m2764d();
        c0533a.f1735e = 1;
        c0533a.f1736f = 1;
        C0463a.m1989a(context, c0533a);
        try {
            i = Long.valueOf(System.currentTimeMillis()).intValue();
        } catch (Exception e) {
        }
        Intent a = C0578p.m2515a(context, new Intent(), "com.baidu.android.pushservice.action.alarm.message");
        a.putExtra("tinyMessageHead", c0626k);
        a.putExtra("msgBody", bArr);
        PendingIntent service = PendingIntent.getService(context, i, a, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        try {
            if (VERSION.SDK_INT < 19) {
                alarmManager.set(0, c0533a.f1733c, service);
            } else if (VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, c0533a.f1733c, service);
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static void m2526a(Context context, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("r_sync_type", i);
        intent.putExtra("r_sync_rdata_v2", str);
        intent.putExtra("r_sync_from", context.getPackageName());
        intent.setFlags(32);
        List<ResolveInfo> o = C0578p.m2502F(context) ? C0578p.m2588o(context) : C0578p.m2587n(context);
        if (o != null) {
            String str2 = "com.baidu.android.pushservice.action.BIND_SYNC";
            for (ResolveInfo resolveInfo : o) {
                if (C0578p.m2577i(context, resolveInfo.activityInfo.packageName)) {
                    C0578p.m2545b(context, intent, str2, resolveInfo.activityInfo.packageName);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2527a(Context context, String str, String str2, PushCallback pushCallback) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                C0575n.m2478a(applicationContext, 8, "");
                PushManager.getInstance().register(applicationContext, str, str2, pushCallback);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m2528a(Context context, boolean z, boolean z2) {
        C0527a.m2216a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 0);
        int d = C0578p.m2559d(context, context.getPackageName());
        if (sharedPreferences.getInt("pr_app_v", 0) < d || z) {
            if (C0578p.m2557c(context) || C0448d.m1945g(context)) {
                C0472c.m2023a(context, 0);
            } else {
                C0472c.m2023a(context, C0578p.m2569f(context));
            }
            if (C0578p.m2501E(context)) {
                Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
                if (C0578p.m2557c(context) || C0448d.m1945g(context)) {
                    edit.putLong("priority2", 0);
                } else {
                    edit.putLong("priority2", C0578p.m2569f(context));
                }
                edit.putInt("version2", C0430a.m1854a());
                edit.commit();
            }
            C0472c.m2030b(context, (long) C0430a.m1854a());
            Editor edit2 = sharedPreferences.edit();
            edit2.putInt("pr_app_v", d);
            edit2.commit();
        }
        if (z2) {
            C0577o.m2490d(context);
        }
    }

    /* renamed from: a */
    public static void m2529a(Intent intent, Context context) {
        try {
            String packageName = context.getPackageName();
            String c = C0578p.m2554c(context, context.getPackageName(), PushConstants.ACTION_MESSAGE);
            Class cls = Class.forName(c);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            String[] strArr = new String[]{"android.content.Context", "android.content.Intent"};
            Method method = cls.getMethod("onReceive", new Class[]{Context.class, Intent.class});
            intent.setClassName(packageName, c);
            method.invoke(newInstance, new Object[]{context, intent});
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private static synchronized void m2530a(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        synchronized (C0578p.class) {
            FileOutputStream fileOutputStream2 = null;
            try {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                String concat = format.length() > 0 ? format.substring(0, 4).concat(format.substring(5, 7)).concat(format.substring(8, 10)) : null;
                format = format + " " + str2 + "\n\r";
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath, "baidu/pushservice/files");
                if (file.exists()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
                    for (File file2 : file.listFiles()) {
                        if (file2.getName().startsWith(str) && Integer.parseInt(concat) - Integer.parseInt(simpleDateFormat.format(Long.valueOf(file2.lastModified()))) >= 7) {
                            file2.delete();
                        }
                    }
                } else {
                    file.mkdirs();
                }
                File file3 = new File(absolutePath, "baidu/pushservice/files/" + str + concat + C3473h.f18755a);
                if (file3.exists()) {
                    fileOutputStream = new FileOutputStream(file3, true);
                    try {
                        fileOutputStream.write(format.getBytes());
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        throw th;
                    }
                } else {
                    fileOutputStream = null;
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileOutputStream = null;
                th = th4;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return;
    }

    /* renamed from: a */
    public static boolean m2531a() {
        try {
            if (Build.MANUFACTURER.toUpperCase().contains("XIAOMI")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2532a(int i, int i2, int i3, int i4) {
        int i5 = Calendar.getInstance(Locale.CHINA).get(11);
        int i6 = Calendar.getInstance(Locale.CHINA).get(12);
        if (i < i3) {
            if (i < i5 && i5 < i3) {
                return true;
            }
            if (i5 == i && i6 >= i2) {
                return true;
            }
            if (i5 == i3 && i6 <= i4) {
                return true;
            }
        } else if (i > i3) {
            if ((i5 > i && i5 < 24) || i5 < i3) {
                return true;
            }
            if (i5 == i && i6 >= i2) {
                return true;
            }
            if (i5 == i3 && i6 <= i4) {
                return true;
            }
        } else if (i == i5 && i6 >= i2 && i4 >= i6) {
            return true;
        }
        return false;
    }

    @SuppressLint({"SdCardPath"})
    /* renamed from: a */
    public static boolean m2533a(Context context) {
        File file = new File("/data/data/root");
        try {
            file.createNewFile();
            if (!file.exists()) {
                return true;
            }
            file.delete();
            return true;
        } catch (IOException e) {
            return (C0578p.m2516a(context, "com.noshufou.android.su") == null && C0578p.m2516a(context, "com.miui.uac") == null) ? false : true;
        }
    }

    /* renamed from: a */
    private static boolean m2534a(Context context, PackageManager packageManager, String[] strArr) {
        boolean z = C0578p.m2531a() && PushSettings.m1837m(context);
        if (z) {
            try {
                String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
                if (C0578p.m2541a(str, strArr)) {
                    PermissionInfo[] permissionInfoArr = packageManager.getPackageInfo(context.getPackageName(), 4096).permissions;
                    if (permissionInfoArr != null && permissionInfoArr.length > 0) {
                        z = false;
                        for (PermissionInfo permissionInfo : permissionInfoArr) {
                            if (permissionInfo.name.equals(str)) {
                                if (permissionInfo.protectionLevel == 2) {
                                    z = true;
                                } else {
                                    Log.e("BDPushSDK-Utility", "xiaomi proxy permission is not signature,  please check!");
                                }
                            }
                        }
                        if (!z) {
                            return true;
                        }
                    }
                }
                C0527a.m2218b("Utility", "the permission [ " + str + " ] for " + "xiaomi proxy need is not exist, please check!", context);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2535a(Context context, PublicMsg publicMsg) {
        boolean z;
        String str;
        String a = C0590f.m2669a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), true);
        String b = C0574m.m2472b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        if (TextUtils.isEmpty(b)) {
            z = false;
            str = a;
        } else if (b.contains(a)) {
            str = b;
            z = true;
        } else {
            if (b.length() > 3000) {
                b = b.substring(1000);
            }
            str = b + Config.TRACE_TODAY_VISIT_SPLIT + a;
            z = false;
        }
        if (!z) {
            C0574m.m2473b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS", str);
        }
        if (C0448d.m1932a(context).m1952b() == 3) {
            C0472c.m2027a(context, new C0474e(publicMsg.mMsgId, a, publicMsg.mAppId));
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m2536a(Context context, String str, String str2, String str3, String str4, String str5) {
        String b = PushSettings.m1821b(context);
        if (TextUtils.isEmpty(b)) {
            b = str2;
        }
        boolean z = false;
        String a = C0590f.m2669a((b + str + str3 + str4 + str5).getBytes(), true);
        b = C0574m.m2472b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        if (TextUtils.isEmpty(b)) {
            b = a;
        } else if (b.contains(a)) {
            z = true;
        } else {
            if (b.length() > 3000) {
                b = b.substring(1000);
            }
            b = b + Config.TRACE_TODAY_VISIT_SPLIT + a;
        }
        if (!z) {
            C0574m.m2473b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS", b);
        }
        if (C0448d.m1932a(context).m1952b() == 3 && !TextUtils.isEmpty(str)) {
            C0472c.m2027a(context, new C0474e(str, a, str2));
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m2537a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List<ResolveInfo> queryBroadcastReceivers;
            if (z) {
                queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
                if (queryBroadcastReceivers.size() < 1) {
                    Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                    return false;
                }
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (str2.equals(resolveInfo.activityInfo.name)) {
                        return true;
                    }
                }
            }
            queryBroadcastReceivers = packageManager.queryIntentServices(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            if (queryBroadcastReceivers.size() < 1) {
                Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                return false;
            }
            for (ResolveInfo resolveInfo2 : queryBroadcastReceivers) {
                if (str2.equals(resolveInfo2.serviceInfo.name)) {
                    int E = C0578p.m2500E(context, str2);
                    if (!resolveInfo2.serviceInfo.exported) {
                        Log.e("BDPushSDK-Utility", str2 + " exported is false , please check!");
                        return false;
                    } else if (E == 1 || (E == 0 && resolveInfo2.serviceInfo.enabled)) {
                        return true;
                    } else {
                        Log.e("BDPushSDK-Utility", str2 + " is disable, please check!");
                    }
                }
            }
            return false;
        } catch (Exception e) {
            C0527a.m2218b("Utility", "error  " + e.getMessage(), context);
        }
    }

    /* renamed from: a */
    public static boolean m2538a(Context context, byte[] bArr, String str, String str2, byte[] bArr2) {
        if (bArr == null || str2 == null || bArr2 == null) {
            return false;
        }
        try {
            String b = PushSettings.m1821b(context);
            if (TextUtils.isEmpty(b)) {
                C0437f d = C0432b.m1870a(context).m1886d(str);
                if (d != null) {
                    b = d.m1861a();
                }
            }
            if (TextUtils.isEmpty(b) || !b.equals(str)) {
                C0527a.m2216a("Utility", "walnutShellVerify error, appId not equal: " + str + "  stored: " + b, context);
                return false;
            }
            byte[] decryptR = BaiduAppSSOJni.decryptR(bArr, 0);
            String a = C0590f.m2669a(C0578p.m2543a(C0578p.m2543a(str.getBytes(), str2.getBytes()), bArr2), false);
            return a != null && a.equals(new String(decryptR));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m2539a(Context context, String[] strArr) {
        boolean z = C0578p.m2563d() && PushSettings.m1839o(context);
        if (z) {
            try {
                return !C0578p.m2541a("com.coloros.mcs.permission.RECIEVE_MCS_MESSAGE", strArr);
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2540a(String str, Context context) {
        if (!TextUtils.isEmpty(str) && !str.contains(" ")) {
            return true;
        }
        Log.e("BDPushSDK-Utility", "api_key is  incorrect, please check ! ");
        return false;
    }

    /* renamed from: a */
    static boolean m2541a(String str, String[] strArr) {
        for (Object equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m2542a(Context context, String str, byte[] bArr, byte[] bArr2, String str2) {
        int m = C0578p.m2584m(context, str2);
        if (m > 45 && m < 50) {
            try {
                bArr2 = BaiduAppSSOJni.encryptR(C0590f.m2669a(C0578p.m2543a(str.getBytes(), bArr), false).getBytes(), 0);
            } catch (Exception e) {
            }
        }
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m2543a(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
        return obj;
    }

    /* renamed from: b */
    public static int m2544b(String str) {
        int i = 0;
        try {
            return (int) Long.parseLong(str);
        } catch (Exception e) {
            try {
                if (str.length() > 0) {
                    str = str.substring(1);
                }
                return (int) Long.parseLong(str);
            } catch (Exception e2) {
                return i;
            }
        }
    }

    /* renamed from: b */
    public static void m2545b(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        int m = C0578p.m2584m(context, str2);
        if (m >= 32) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    intent.setAction(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                    intent.setClassName(str2, "com.baidu.android.pushservice.CommandService");
                }
                intent.putExtra("command_type", "reflect_receiver");
                if (context.startService(intent) == null) {
                    C0578p.m2546b("sendRedirecctionIntent#intergratedPushVersion=" + m + ", packageName=" + str2 + ", intent=" + intent.toUri(0), context);
                } else {
                    return;
                }
            } catch (Exception e) {
            }
        }
        if (!C0578p.m2503G(context)) {
            if (!TextUtils.isEmpty(str)) {
                intent.setAction(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            Object c = C0578p.m2554c(context, str2, str);
            if (!TextUtils.isEmpty(c)) {
                intent.setClassName(str2, c);
            }
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: b */
    public static synchronized void m2546b(String str, Context context) {
        Throwable th;
        synchronized (C0578p.class) {
            if (C0578p.m2512P(context)) {
                if (C0430a.m1857b() > 0) {
                    C0578p.m2555c(str, context);
                } else if (C0430a.m1856a(context)) {
                    Closeable closeable = null;
                    FileWriter fileWriter;
                    try {
                        String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + str + "\n\r";
                        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                        File file = new File(absolutePath, "baidu/pushservice/files");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                        Date date = new Date();
                        File file2 = new File(absolutePath, "baidu/pushservice/files/msg" + simpleDateFormat.format(date) + C3473h.f18755a);
                        if (!file2.exists()) {
                            for (File file3 : file.listFiles()) {
                                String name = file3.getName();
                                if (name.startsWith("msg") && name.length() > 0 && ((int) Math.abs((simpleDateFormat.parse(name.substring(3, 11)).getTime() - date.getTime()) / 86400000)) >= 7) {
                                    file3.delete();
                                }
                            }
                            file2.createNewFile();
                        }
                        if (file2.exists()) {
                            fileWriter = new FileWriter(file2, true);
                            try {
                                fileWriter.write(str2);
                            } catch (Throwable th2) {
                                th = th2;
                                C0521b.m2169a(fileWriter);
                                throw th;
                            }
                        }
                        fileWriter = null;
                        C0521b.m2169a(fileWriter);
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        fileWriter = null;
                        th = th4;
                        C0521b.m2169a(fileWriter);
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m2547b() {
        try {
            if (Build.MANUFACTURER.toUpperCase().contains("MEIZU")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m2548b(Context context, PublicMsg publicMsg) {
        if (publicMsg == null) {
            return false;
        }
        CharSequence a = C0590f.m2669a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), true);
        Object b = C0574m.m2472b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        boolean z = (TextUtils.isEmpty(b) || TextUtils.isEmpty(a) || !b.contains(a)) ? false : true;
        if (z || TextUtils.isEmpty(a)) {
            return z;
        }
        b = C0472c.m2022a(context, C0448d.m1932a(context).m1952b() == 4 ? C0448d.m1932a(context).m1953c() : C0578p.m2603v(context), publicMsg.mMsgId);
        return !TextUtils.isEmpty(b) && b.equals(a);
    }

    /* renamed from: b */
    public static boolean m2549b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (packageManager.getApplicationInfo(str, 0).flags & 1) == 0) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m2550b(Context context, String str, String str2) {
        ApplicationInfo applicationInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            applicationInfo = packageManager.getApplicationInfo(str, 128);
            return (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str2)) ? false : applicationInfo.metaData.getBoolean(str2);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static boolean m2551b(Context context, String str, String str2, String str3, String str4, String str5) {
        CharSequence b = PushSettings.m1821b(context);
        if (!TextUtils.isEmpty(b)) {
            CharSequence charSequence = b;
        }
        Object obj = str2 + str + str3 + str4 + str5;
        if (TextUtils.isEmpty(obj)) {
            return false;
        }
        Object a = C0590f.m2669a(obj.getBytes(), true);
        obj = C0574m.m2472b(context, "com.baidu.android.pushservice.NOTIFICATION_SHOWED_IDS");
        boolean z = (TextUtils.isEmpty(obj) || TextUtils.isEmpty(a) || !obj.contains(a)) ? false : true;
        if (!(z || TextUtils.isEmpty(a))) {
            String str6 = "";
            obj = C0472c.m2029b(context, C0448d.m1932a(context).m1952b() == 4 ? C0448d.m1932a(context).m1953c() : C0578p.m2603v(context), a);
            z = !TextUtils.isEmpty(obj) && obj.equals(a);
        }
        return z;
    }

    /* renamed from: b */
    public static int[] m2552b(Context context) {
        int[] iArr = new int[2];
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        iArr[0] = displayMetrics.heightPixels;
        iArr[1] = displayMetrics.widthPixels;
        return iArr;
    }

    /* renamed from: c */
    public static int m2553c(String str) {
        int i = 0;
        String str2 = str;
        int indexOf;
        do {
            try {
                indexOf = str2.indexOf("#Intent;");
                if (indexOf != -1) {
                    i += "#Intent;".length() + indexOf;
                    str2 = str2.substring("#Intent;".length() + indexOf);
                    continue;
                }
            } catch (Exception e) {
                return i;
            }
        } while (indexOf != -1);
        return i > 0 ? i - "#Intent;".length() : i;
    }

    /* renamed from: c */
    public static String m2554c(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        List queryBroadcastReceivers;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            return (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) ? null : ((ResolveInfo) queryBroadcastReceivers.get(0)).activityInfo.name;
        } catch (Exception e) {
            queryBroadcastReceivers = null;
        }
    }

    /* renamed from: c */
    private static synchronized void m2555c(String str, Context context) {
        synchronized (C0578p.class) {
            String str2 = "samonitor";
            if (context != null) {
                String str3 = str2 + C0589e.m2651b(context);
                String s = C0578p.m2596s(context);
                int t = C0578p.m2598t(context);
                if (!f1869c) {
                    ArrayList q = C0578p.m2592q(context);
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator it = q.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append(((String) it.next()) + ";");
                    }
                    C0578p.m2530a(str3, "#AllPackagesUsingPush:" + stringBuffer.toString());
                    f1869c = true;
                }
                C0578p.m2530a(str3, "#IMEI:" + null + "#networkType:" + s + "#mobileType:" + t + "#" + str);
            }
        }
    }

    /* renamed from: c */
    public static boolean m2556c() {
        try {
            if (Build.MANUFACTURER.toUpperCase().contains("HUAWEI")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m2557c(Context context) {
        String c = C0430a.m1860c(context);
        return UpdateDeviceStatusDataStruct.KEY_ENABLED.equals(c) ? false : "disabled".equals(c) ? true : C0578p.m2550b(context, context.getPackageName(), "DisableService");
    }

    /* renamed from: c */
    public static boolean m2558c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: d */
    public static int m2559d(Context context, String str) {
        PackageInfo a = C0578p.m2516a(context, str);
        return a != null ? a.versionCode : 0;
    }

    /* renamed from: d */
    private static int m2560d(String str) {
        Process exec;
        Reader inputStreamReader;
        BufferedReader bufferedReader;
        Object obj;
        Process process;
        Closeable closeable;
        Throwable th;
        Throwable th2;
        Closeable closeable2 = null;
        try {
            exec = Runtime.getRuntime().exec("/system/bin/ping -w 1 " + str);
            try {
                inputStreamReader = new InputStreamReader(exec.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String str2 = new String();
                        int i = 0;
                        do {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            i++;
                            if (readLine.contains("64 bytes from " + str)) {
                                C0521b.m2169a(bufferedReader, inputStreamReader);
                                if (exec == null) {
                                    return 0;
                                }
                                exec.destroy();
                                return 0;
                            }
                        } while (i <= 3);
                        C0521b.m2169a(bufferedReader, inputStreamReader);
                        if (exec != null) {
                            exec.destroy();
                        }
                        return -1;
                    } catch (Exception e) {
                        obj = inputStreamReader;
                        Object obj2 = bufferedReader;
                        process = exec;
                        C0521b.m2169a(closeable, closeable2);
                        if (process != null) {
                            process.destroy();
                        }
                        return 1;
                    } catch (Throwable th3) {
                        th = th3;
                        C0521b.m2169a(bufferedReader, inputStreamReader);
                        if (exec != null) {
                            exec.destroy();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    process = exec;
                    obj = inputStreamReader;
                    closeable = null;
                    C0521b.m2169a(closeable, closeable2);
                    if (process != null) {
                        process.destroy();
                    }
                    return 1;
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader = null;
                    th = th2;
                    C0521b.m2169a(bufferedReader, inputStreamReader);
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                closeable = null;
                process = exec;
                C0521b.m2169a(closeable, closeable2);
                if (process != null) {
                    process.destroy();
                }
                return 1;
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
                inputStreamReader = null;
                C0521b.m2169a(bufferedReader, inputStreamReader);
                if (exec != null) {
                    exec.destroy();
                }
                throw th;
            }
        } catch (Exception e4) {
            closeable = null;
            process = null;
            C0521b.m2169a(closeable, closeable2);
            if (process != null) {
                process.destroy();
            }
            return 1;
        } catch (Throwable th52) {
            bufferedReader = null;
            exec = null;
            th2 = th52;
            inputStreamReader = null;
            th = th2;
            C0521b.m2169a(bufferedReader, inputStreamReader);
            if (exec != null) {
                exec.destroy();
            }
            throw th;
        }
    }

    /* renamed from: d */
    static String m2561d(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "pm is null";
            }
            String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            String str;
            if (strArr == null) {
                str = "Permissions Push-SDK need are not exist !";
                Log.e("BDPushSDK-Utility", str);
                return str;
            } else if (C0578p.m2534a(context, packageManager, strArr)) {
                str = "permission Push-SDK for xiaomi proxy need is not exist !";
                Log.e("BDPushSDK-Utility", str);
                return str;
            } else if (C0578p.m2539a(context, strArr)) {
                str = "permission Push-SDK for oppo proxy need is not exist !";
                Log.e("BDPushSDK-Utility", str);
                return str;
            } else {
                String[] strArr2 = f1867a;
                int length = strArr2.length;
                int i = 0;
                while (i < length) {
                    String str2 = strArr2[i];
                    if (C0578p.m2541a(str2, strArr)) {
                        i++;
                    } else {
                        str = str2 + " permission Push-SDK need is not exist !";
                        Log.e("BDPushSDK-Utility", str);
                        return str;
                    }
                }
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            }
        } catch (Exception e) {
            return "checkSDKPermissions exception " + e.getMessage();
        }
    }

    /* renamed from: d */
    public static void m2562d(Context context, String str, String str2) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                C0575n.m2478a(applicationContext, 6, "");
                MiPushClient.registerPush(applicationContext, str, str2);
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: d */
    public static boolean m2563d() {
        try {
            if (Build.MANUFACTURER.toUpperCase().contains("OPPO")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: e */
    private static String m2564e(String str) {
        String str2 = "";
        try {
            if (str.startsWith("http://")) {
                str = str.replace("http://", "");
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length <= 0) {
                return str2;
            }
            int length = allByName.length;
            int i = 0;
            while (i < length) {
                i++;
                str2 = str2 + Config.TRACE_TODAY_VISIT_SPLIT + allByName[i].getHostAddress();
            }
            return str2.length() > 1 ? str2.substring(1) : str2;
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: e */
    public static void m2565e(Context context) {
        C0578p.m2522a(context, 300000);
    }

    /* renamed from: e */
    public static void m2566e(Context context, String str, String str2) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                C0575n.m2478a(applicationContext, 7, "");
                com.meizu.cloud.pushsdk.PushManager.register(applicationContext, str, str2);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: e */
    public static boolean m2567e() {
        return C0578p.m2531a() || C0578p.m2556c() || C0578p.m2547b() || C0578p.m2563d();
    }

    /* renamed from: e */
    public static boolean m2568e(Context context, String str) {
        ApplicationInfo applicationInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            applicationInfo = packageManager.getApplicationInfo(str, 128);
            return (applicationInfo == null || applicationInfo.metaData == null) ? false : applicationInfo.metaData.getBoolean("IsBaiduApp");
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    public static long m2569f(Context context) {
        int i = 5;
        String packageName = context.getPackageName();
        if (C0578p.m2504H(context) && packageName.equalsIgnoreCase("com.baidu.push4manufacture")) {
            return BNOffScreenParams.MIN_ENTER_INTERVAL;
        }
        long a = (long) C0430a.m1854a();
        int b = C0430a.m1857b();
        if (b > 0) {
            if (b <= 5) {
                i = b;
            }
            return ((long) i) + ((a << 4) + 10);
        } else if (context.getPackageName().equals("com.baidu.searchbox")) {
            return (a << 4) + 10;
        } else {
            long j = a << 2;
            if (C0578p.m2568e(context, context.getPackageName())) {
                j++;
            }
            j <<= 1;
            if (C0578p.m2549b(context, context.getPackageName())) {
                j++;
            }
            return (j << 1) + ((long) C0578p.m2582l(context));
        }
    }

    /* renamed from: f */
    private static String m2570f(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                return null;
            }
            if (!str.contains("bdpush_hwsigninfo")) {
                return str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), str.length());
            }
            int c = C0578p.m2553c(str);
            return c > 0 ? str.substring("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=".length(), c) : null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: f */
    public static void m2571f(Context context, String str) {
        if (C0578p.m2577i(context, str)) {
            Intent c = C0577o.m2489c(context);
            if (C0578p.m2502F(context)) {
                c.putExtra("method", "pushservice_restart_v3");
                if (TextUtils.isEmpty(str) || !str.equals(C0578p.m2600u(context))) {
                    c.putExtra("priority3", C0578p.m2574h(context));
                } else {
                    c.putExtra("priority3", C5361b.f21945a);
                }
            } else {
                c.putExtra("method", "pushservice_restart_v2");
                if (TextUtils.isEmpty(str) || !str.equals(C0578p.m2600u(context))) {
                    c.putExtra("priority2", C0578p.m2574h(context));
                } else {
                    c.putExtra("priority2", C5361b.f21945a);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                c.setPackage(str);
                c.setClassName(str, "com.baidu.android.pushservice.CommandService");
            }
            c.putExtra("command_type", "reflect_receiver");
            try {
                if (context.startService(c) != null) {
                    return;
                }
            } catch (Exception e) {
            }
            if (!C0578p.m2503G(context)) {
                if (!TextUtils.isEmpty(str)) {
                    c.setPackage(str);
                }
                Object c2 = C0578p.m2554c(context, str, PushConstants.ACTION_METHOD);
                if (!TextUtils.isEmpty(c2)) {
                    c.setClassName(str, c2);
                }
                context.sendBroadcast(c);
                C0430a.m1855a(context, false);
            }
        }
    }

    /* renamed from: g */
    public static long m2572g(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            long j;
            if (C0578p.m2501E(context)) {
                Context v = C0578p.m2602v(context, str);
                if (v != null) {
                    SharedPreferences sharedPreferences = v.getSharedPreferences(str + ".push_sync", 5);
                    if (sharedPreferences != null) {
                        j = sharedPreferences.getLong("priority2", 0);
                        if (j != -1) {
                            try {
                            } catch (Exception e) {
                                return j;
                            }
                        }
                    }
                }
            }
            j = -1;
            return j != -1 ? j : (long) C0473d.m2046c(context, str);
        } catch (Exception e2) {
            return -1;
        }
    }

    /* renamed from: g */
    public static void m2573g(Context context) {
        C0578p.m2528a(context, false, false);
    }

    /* renamed from: h */
    public static long m2574h(Context context) {
        long j;
        if (context == null) {
            return 0;
        }
        try {
            if (C0578p.m2501E(context)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
                if (sharedPreferences != null) {
                    j = sharedPreferences.getLong("priority2", 0);
                    if (j != -1) {
                        try {
                        } catch (Exception e) {
                            return j;
                        }
                    }
                }
            }
            j = -1;
            return j != -1 ? j : (long) C0472c.m2028b(context);
        } catch (Exception e2) {
            return -1;
        }
    }

    /* renamed from: h */
    public static boolean m2575h(Context context, String str) {
        boolean z;
        int componentEnabledSetting;
        int i;
        int i2 = 2;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        boolean z2;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List queryIntentServices = packageManager.queryIntentServices(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            if (!(queryIntentServices == null || queryIntentServices.isEmpty())) {
                int i3 = 0;
                while (i3 < queryIntentServices.size()) {
                    if ("com.baidu.android.pushservice.PushService".equals(((ResolveInfo) queryIntentServices.get(i3)).serviceInfo.name) && ((ResolveInfo) queryIntentServices.get(i3)).serviceInfo.exported) {
                        z2 = ((ResolveInfo) queryIntentServices.get(i3)).serviceInfo.enabled;
                        break;
                    }
                    i3++;
                }
            }
            z2 = false;
            try {
                z = z2;
                componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.baidu.android.pushservice.PushService"));
            } catch (Exception e) {
                i = i2;
                z = z2;
                componentEnabledSetting = i;
                if (componentEnabledSetting != 1) {
                }
                return z2;
            }
            z2 = componentEnabledSetting != 1 || (componentEnabledSetting == 0 && z);
            return z2;
        } catch (Exception e2) {
            z2 = false;
            i = i2;
            z = z2;
            componentEnabledSetting = i;
            if (componentEnabledSetting != 1) {
            }
            return z2;
        }
    }

    /* renamed from: i */
    static boolean m2576i(Context context) {
        return C0578p.m2579j(context, context.getPackageName());
    }

    /* renamed from: i */
    public static boolean m2577i(Context context, String str) {
        List list = null;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            list = packageManager.queryIntentServices(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            return list != null && list.size() > 0;
        } catch (Exception e) {
        }
    }

    /* renamed from: j */
    static boolean m2578j(Context context) {
        return C0578p.m2581k(context, context.getPackageName());
    }

    /* renamed from: j */
    public static boolean m2579j(Context context, String str) {
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.notification.CLICK");
            intent.setPackage(context.getPackageName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            String str2;
            boolean z;
            Iterator it = queryBroadcastReceivers.iterator();
            if (it.hasNext()) {
                ResolveInfo resolveInfo = (ResolveInfo) it.next();
                str2 = resolveInfo.activityInfo.name;
                z = resolveInfo.activityInfo.enabled;
            } else {
                str2 = null;
                z = false;
            }
            if (C0578p.m2537a(context, PushConstants.ACTION_MESSAGE, str2, true) && C0578p.m2537a(context, PushConstants.ACTION_RECEIVE, str2, true)) {
                if (C0578p.m2556c() && PushSettings.m1840p(context)) {
                    if (!C0578p.m2537a(context, "com.huawei.intent.action.PUSH", str2, true)) {
                        Log.e("BDPushSDK-Utility", str2 + " did not declared " + "com.huawei.intent.action.PUSH");
                        return false;
                    } else if (!C0578p.m2537a(context, "com.huawei.android.push.intent.RECEIVE", str2, true)) {
                        Log.e("BDPushSDK-Utility", str2 + " did not declared " + "com.huawei.android.push.intent.RECEIVE");
                        return false;
                    } else if (!C0578p.m2537a(context, "com.huawei.android.push.intent.REGISTRATION", str2, true)) {
                        Log.e("BDPushSDK-Utility", str2 + " did not declared " + "com.huawei.android.push.intent.REGISTRATION");
                        return false;
                    }
                } else if (C0578p.m2531a() && PushSettings.m1837m(context)) {
                    r5 = "com.baidu.android.pushservice.PushPatchMessageReceiver";
                    if (!C0578p.m2537a(context, "com.xiaomi.mipush.RECEIVE_MESSAGE", r5, true)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.xiaomi.mipush.RECEIVE_MESSAGE");
                        return false;
                    } else if (!C0578p.m2537a(context, "com.xiaomi.mipush.MESSAGE_ARRIVED", r5, true)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.xiaomi.mipush.MESSAGE_ARRIVED");
                        return false;
                    } else if (!C0578p.m2537a(context, "com.xiaomi.mipush.ERROR", r5, true)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.xiaomi.mipush.ERROR");
                        return false;
                    }
                } else if (C0578p.m2547b() && PushSettings.m1838n(context)) {
                    r5 = "com.baidu.android.pushservice.MzPushPatchMessageReceiver";
                    if (!C0578p.m2537a(context, "com.meizu.flyme.push.intent.MESSAGE", r5, true)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.meizu.flyme.push.intent.MESSAGE");
                        return false;
                    } else if (!C0578p.m2537a(context, "com.meizu.flyme.push.intent.REGISTER.FEEDBACK", r5, true)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.meizu.flyme.push.intent.REGISTER.FEEDBACK");
                        return false;
                    } else if (!C0578p.m2537a(context, "com.meizu.flyme.push.intent.UNREGISTER.FEEDBACK", r5, true)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.meizu.flyme.push.intent.UNREGISTER.FEEDBACK");
                        return false;
                    } else if (!C0578p.m2505I(context)) {
                        Log.e("BDPushSDK-Utility", "com.meizu.cloud.pushsdk.SystemReceiver did not declared com.meizu.cloud.pushservice.action.PUSH_SERVICE_START");
                        return false;
                    }
                } else if (C0578p.m2563d() && PushSettings.m1839o(context)) {
                    r5 = "com.coloros.mcssdk.PushService";
                    if (!C0578p.m2537a(context, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", r5, false)) {
                        Log.e("BDPushSDK-Utility", r5 + " did not declared " + "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
                        return false;
                    }
                }
                int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str2));
                z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z);
                if (z) {
                    return z;
                }
                try {
                    Log.e("BDPushSDK-Utility", str2 + " is disable, please check!");
                    return z;
                } catch (Exception e) {
                    return z;
                }
            }
            Log.e("BDPushSDK-Utility", str2 + " did not declared " + PushConstants.ACTION_MESSAGE + " or " + PushConstants.ACTION_RECEIVE);
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: k */
    public static String m2580k(Context context) {
        Object d = C0578p.m2561d(context);
        if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", d)) {
            return d;
        }
        d = C0578p.m2506J(context);
        if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", d)) {
            return d;
        }
        d = C0578p.m2507K(context);
        return !TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", d) ? C0578p.m2513Q(context) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : d : "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
    }

    /* renamed from: k */
    public static boolean m2581k(Context context, String str) {
        try {
            if (C0578p.m2501E(context) && context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).getInt("version2", 0) < 29) {
                return true;
            }
            ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.CommandService");
            PackageManager packageManager = context.getPackageManager();
            ServiceInfo serviceInfo = new ServiceInfo();
            String str2 = "";
            ServiceInfo serviceInfo2 = packageManager.getServiceInfo(componentName, 128);
            if (TextUtils.isEmpty(serviceInfo2.name)) {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService did not declared ");
                return false;
            } else if (serviceInfo2.exported) {
                return true;
            } else {
                Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.CommandService  exported declared wrong");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: l */
    static int m2582l(Context context) {
        int i = 0;
        if (C0578p.m2537a(context, "android.intent.action.USER_PRESENT", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i = 1;
        }
        if (C0578p.m2537a(context, "android.intent.action.MEDIA_MOUNTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i++;
        }
        if (C0578p.m2537a(context, "android.intent.action.ACTION_POWER_CONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            i++;
        }
        return C0578p.m2537a(context, "android.intent.action.ACTION_POWER_DISCONNECTED", "com.baidu.android.pushservice.PushServiceReceiver", true) ? i + 1 : i;
    }

    /* renamed from: l */
    public static String m2583l(Context context, String str) {
        String k;
        if (PushSocket.m2623a(context)) {
            k = C0578p.m2580k(context);
            if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", k)) {
                Log.e("BDPushSDK-Utility", k);
                return k;
            } else if (C0578p.m2540a(str, context)) {
                if (!C0578p.m2576i(context)) {
                    Log.e("BDPushSDK-Utility", "check SelfConfiged Receiver failed");
                }
                if (!C0578p.m2578j(context) && !C0578p.m2513Q(context)) {
                    k = "check CommandService Enable failed";
                    Log.e("BDPushSDK-Utility", k);
                    return k;
                } else if (C0578p.m2511O(context)) {
                    return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
                } else {
                    k = "check CommandService Enable failed";
                    Log.e("BDPushSDK-Utility", k);
                    return k;
                }
            } else {
                k = "check Apikey failed";
                Log.e("BDPushSDK-Utility", k);
                return k;
            }
        }
        k = "check socket library failed";
        Log.e("BDPushSDK-Utility", k);
        return k;
    }

    /* renamed from: m */
    public static int m2584m(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.equals(context.getPackageName())) {
                return C0430a.m1854a();
            }
            int i;
            if (C0578p.m2501E(context)) {
                try {
                    Context v = C0578p.m2602v(context, str);
                    SharedPreferences sharedPreferences = v != null ? v.getSharedPreferences(str + ".push_sync", 5) : null;
                    if (sharedPreferences != null) {
                        i = sharedPreferences.getInt("version2", 0);
                        if (i == -1) {
                            try {
                                i = C0473d.m2047d(context, str);
                            } catch (Exception e) {
                                return i;
                            }
                        }
                        return i != 0 ? 50 : i;
                    }
                } catch (Exception e2) {
                    i = -1;
                }
            }
            i = -1;
            if (i == -1) {
                i = C0473d.m2047d(context, str);
            }
            if (i != 0) {
            }
        } catch (Exception e3) {
            return -1;
        }
    }

    /* renamed from: m */
    public static List<String> m2585m(Context context) {
        List arrayList = new ArrayList();
        Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            arrayList = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            ArrayList arrayList2 = new ArrayList();
            for (ResolveInfo resolveInfo : r0) {
                arrayList2.add(resolveInfo.activityInfo.packageName);
            }
            return arrayList2;
        } catch (Exception e) {
        }
    }

    /* renamed from: n */
    public static String m2586n(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : C0578p.m2519a(context, str, "BaiduPush_CHANNEL");
    }

    /* renamed from: n */
    public static List<ResolveInfo> m2587n(Context context) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            try {
                Collection arrayList2 = new ArrayList();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (C0578p.m2611z(context, resolveInfo.activityInfo.packageName)) {
                        arrayList2.add(resolveInfo);
                    }
                }
                queryBroadcastReceivers.removeAll(arrayList2);
                return queryBroadcastReceivers;
            } catch (Exception e) {
                return queryBroadcastReceivers;
            }
        } catch (Exception e2) {
            return arrayList;
        }
    }

    /* renamed from: o */
    public static List<ResolveInfo> m2588o(Context context) {
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.BIND_SYNC");
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, NaviFragmentManager.TYPE_HOME_DOWNLOAD_PLUGIN);
            try {
                Collection arrayList = new ArrayList();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (!C0578p.m2611z(context, resolveInfo.activityInfo.packageName)) {
                        arrayList.add(resolveInfo);
                    }
                }
                queryBroadcastReceivers.removeAll(arrayList);
                return queryBroadcastReceivers;
            } catch (Exception e) {
                return queryBroadcastReceivers;
            }
        } catch (Exception e2) {
            return new ArrayList();
        }
    }

    /* renamed from: o */
    public static boolean m2589o(Context context, String str) {
        return C0578p.m2516a(context, str) != null;
    }

    /* renamed from: p */
    public static String m2590p(Context context) {
        String b = C0589e.m2651b(context);
        return C0578p.m2502F(context) ? C0590f.m2669a(("com.baidu.pushservice.singelinstancev3" + b).getBytes(), false) : C0590f.m2669a(("com.baidu.pushservice.singelinstancev2" + b).getBytes(), false);
    }

    /* renamed from: p */
    public static String m2591p(Context context, String str) {
        int b = C0448d.m1932a(context).m1952b();
        if (b == 3 || b == 4 || b == 2) {
            CharSequence c = C0448d.m1932a(context).m1953c();
            if (!TextUtils.isEmpty(c)) {
                return c;
            }
        }
        List<ResolveInfo> o = C0578p.m2502F(context) ? C0578p.m2588o(context.getApplicationContext()) : C0578p.m2587n(context.getApplicationContext());
        if (o != null && o.size() <= 1) {
            return context.getPackageName();
        }
        SharedPreferences sharedPreferences;
        long j;
        String u;
        long j2;
        String str2;
        Context v;
        if (C0578p.m2501E(context)) {
            try {
                sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
            } catch (Exception e) {
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("priority2", 0);
                if (j == -1) {
                    j = (long) C0472c.m2028b(context);
                }
                u = C0578p.m2600u(context);
                j2 = j;
                for (ResolveInfo resolveInfo : o) {
                    str2 = resolveInfo.activityInfo.packageName;
                    v = C0578p.m2602v(context, str2);
                    if (C0578p.m2501E(context)) {
                        if (v == null) {
                            try {
                            } catch (Exception e2) {
                                sharedPreferences = null;
                            }
                        }
                        if (sharedPreferences != null) {
                            j = sharedPreferences.getLong("priority2", 0);
                            if (j == -1) {
                                j = str2.equals(context.getPackageName()) ? (long) C0472c.m2028b(context) : (long) C0473d.m2046c(context, str2);
                            }
                            if (j <= j2) {
                                if (C0578p.m2575h(v, str2)) {
                                    str = str2;
                                }
                                j = j2;
                            } else {
                                if (j == j2 && ((str2.equals(u) && C0578p.m2575h(v, str2)) || (str2.equals(context.getPackageName()) && !C0578p.m2501E(context)))) {
                                    str = str2;
                                }
                                j = j2;
                            }
                            j2 = j;
                        }
                    }
                    j = -1;
                    if (j == -1) {
                        if (str2.equals(context.getPackageName())) {
                        }
                    }
                    if (j <= j2) {
                        str = str2;
                    } else {
                        if (C0578p.m2575h(v, str2)) {
                            str = str2;
                        }
                        j = j2;
                    }
                    j2 = j;
                }
                return str;
            }
        }
        j = -1;
        if (j == -1) {
            j = (long) C0472c.m2028b(context);
        }
        u = C0578p.m2600u(context);
        j2 = j;
        while (r9.hasNext()) {
            str2 = resolveInfo.activityInfo.packageName;
            v = C0578p.m2602v(context, str2);
            if (C0578p.m2501E(context)) {
                sharedPreferences = v == null ? null : v.getSharedPreferences(str2 + ".push_sync", 5);
                if (sharedPreferences != null) {
                    j = sharedPreferences.getLong("priority2", 0);
                    if (j == -1) {
                        if (str2.equals(context.getPackageName())) {
                        }
                    }
                    if (j <= j2) {
                        if (C0578p.m2575h(v, str2)) {
                            str = str2;
                        }
                        j = j2;
                    } else {
                        str = str2;
                    }
                    j2 = j;
                }
            }
            j = -1;
            if (j == -1) {
                if (str2.equals(context.getPackageName())) {
                }
            }
            if (j <= j2) {
                str = str2;
            } else {
                if (C0578p.m2575h(v, str2)) {
                    str = str2;
                }
                j = j2;
            }
            j2 = j;
        }
        return str;
    }

    /* renamed from: q */
    public static ArrayList<String> m2592q(Context context) {
        List<ResolveInfo> o = C0578p.m2502F(context) ? C0578p.m2588o(context.getApplicationContext()) : C0578p.m2587n(context.getApplicationContext());
        ArrayList<String> arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : o) {
            if (!arrayList.contains(resolveInfo.activityInfo.packageName)) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        return arrayList;
    }

    /* renamed from: q */
    public static boolean m2593q(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int[] f = C0463a.m2015f(context, str);
        return (f == null || 4 != f.length) ? false : C0578p.m2532a(f[0], f[1], f[2], f[3]);
    }

    /* renamed from: r */
    public static String m2594r(Context context, String str) {
        String str2 = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                str2 = C0590f.m2669a(packageManager.getPackageInfo(str, 64).signatures[0].toByteArray(), false);
            }
        } catch (Exception e) {
        }
        return str2;
    }

    /* renamed from: r */
    public static List<String> m2595r(Context context) {
        List<String> arrayList = new ArrayList();
        try {
            List<RunningServiceInfo> runningServices;
            ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
            if (activityManager == null) {
                runningServices = activityManager.getRunningServices(500);
            } else {
                runningServices = activityManager.getRunningServices(500);
            }
            if (runningServices == null || runningServices.isEmpty()) {
            } else {
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.service.getClassName().contains("com.baidu.android.pushservice.PushService")) {
                    arrayList.add(runningServiceInfo.service.getPackageName());
                }
            }
        } catch (Throwable e) {
            C0578p.m2546b(C0527a.m2215a(e), context);
        }
        return arrayList;
    }

    /* renamed from: s */
    public static String m2596s(Context context) {
        NetworkInfo c = C0572k.m2459c(context);
        if (c == null || !c.isConnected() || c.getState() != State.CONNECTED) {
            return "unknown";
        }
        if (c.getTypeName().equals("WIFI")) {
            return c.getTypeName();
        }
        Object obj = null;
        if (c.getExtraInfo() != null) {
            obj = c.getExtraInfo().toLowerCase();
        }
        return TextUtils.isEmpty(obj) ? "unknown" : obj;
    }

    /* renamed from: s */
    public static boolean m2597s(Context context, String str) {
        Object a = C0574m.m2465a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        return !TextUtils.isEmpty(a) && a.contains(str);
    }

    /* renamed from: t */
    public static int m2598t(Context context) {
        String str = "";
        if (context != null) {
            NetworkInfo c = C0572k.m2459c(context);
            if (c != null && c.isConnectedOrConnecting()) {
                if (!c.getTypeName().toLowerCase().equals(C1981b.f6365e)) {
                    str = "2G";
                    switch (c.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 11:
                            break;
                        case 3:
                            str = "3G";
                            break;
                        case 5:
                            str = "3G";
                            break;
                        case 6:
                            str = "3G";
                            break;
                        case 7:
                            str = "3G";
                            break;
                        case 8:
                            str = "3G";
                            break;
                        case 9:
                            str = "3G";
                            break;
                        case 10:
                            str = "3G";
                            break;
                        case 12:
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                        case 14:
                            str = "3G";
                            break;
                        case 15:
                            str = "3G";
                            break;
                        default:
                            break;
                    }
                }
                str = "WF";
            }
        }
        return str.equals("WF") ? 1 : str.equals("2G") ? 2 : str.equals("3G") ? 3 : str.equals("4G") ? 4 : 0;
    }

    /* renamed from: t */
    public static boolean m2599t(Context context, String str) {
        String a = C0574m.m2465a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        if (!TextUtils.isEmpty(a)) {
            if (a.contains(str)) {
                return true;
            }
            if (a.length() > 1000) {
                a = a.substring(500);
            }
            str = a + Config.TRACE_TODAY_VISIT_SPLIT + str;
        }
        C0574m.m2470a(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED", str);
        return false;
    }

    /* renamed from: u */
    public static String m2600u(Context context) {
        String b;
        if (C0578p.m2502F(context)) {
            List r = C0578p.m2595r(context);
            List<ResolveInfo> o = C0578p.m2588o(context);
            if (!r.isEmpty()) {
                for (ResolveInfo resolveInfo : o) {
                    if (r.contains(resolveInfo.activityInfo.packageName)) {
                        b = C0473d.m2045b(context, resolveInfo.activityInfo.packageName);
                        if (!TextUtils.isEmpty(b) && C0578p.m2589o(context, b) && C0578p.m2575h(context, b)) {
                            return b;
                        }
                    }
                }
            }
        } else {
            b = C0562b.m2419a(context, "com.baidu.push.cur_pkg");
            List<String> r2 = C0578p.m2595r(context);
            if (TextUtils.isEmpty(b) || !r2.contains(b)) {
                if (!r2.isEmpty()) {
                    for (String b2 : r2) {
                        if (!C0578p.m2611z(context, b2)) {
                            b2 = C0473d.m2045b(context, b2);
                            if (!TextUtils.isEmpty(b2) && C0578p.m2589o(context, b2) && C0578p.m2575h(context, b2)) {
                                return b2;
                            }
                        }
                    }
                }
            } else if (C0578p.m2589o(context, b2) && C0578p.m2575h(context, b2)) {
                return b2;
            }
        }
        return null;
    }

    /* renamed from: u */
    public static boolean m2601u(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: v */
    public static Context m2602v(Context context, String str) {
        Context context2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                context2 = context.createPackageContext(str, 4);
            } catch (Throwable e) {
                C0553q.m2362a(context.getApplicationContext(), e);
            }
        }
        return context2;
    }

    /* renamed from: v */
    public static String m2603v(Context context) {
        return C0578p.m2591p(context, context.getPackageName());
    }

    /* renamed from: w */
    public static String m2604w(Context context) {
        int i = 1;
        int i2 = C0572k.m2457a(context) ? 0 : 1;
        NetworkInfo c = C0572k.m2459c(context);
        if (c != null && c.isAvailable()) {
            i = 0;
        }
        int d = C0578p.m2560d("220.181.112.244");
        int d2 = C0578p.m2560d("202.108.23.105");
        int d3 = C0578p.m2560d("202.108.23.109");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("frontia_avail", i2);
            jSONObject.put("network_avail", i);
            jSONObject.put("baidu_avail", d);
            jSONObject.put("sa_avail", d2);
            jSONObject.put("logic_avail", d3);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    /* renamed from: w */
    public static String m2605w(Context context, String str) {
        String str2 = "";
        try {
            PackageInfo a = C0578p.m2516a(context, str);
            if (a != null && a.firstInstallTime > 0) {
                str2 = String.valueOf(a.firstInstallTime);
            }
        } catch (Throwable th) {
        }
        return str2;
    }

    /* renamed from: x */
    public static String m2606x(Context context) {
        String e = C0578p.m2564e("www.baidu.com");
        String e2 = C0578p.m2564e("sa.tuisong.baidu.com");
        String e3 = C0578p.m2564e("api.tuisong.baidu.com");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("baidu_ip", e);
            jSONObject.put("sa_ip", e2);
            jSONObject.put("logic_ip", e3);
        } catch (Exception e4) {
        }
        if (C0430a.m1857b() > 0) {
        }
        return jSONObject.toString();
    }

    /* renamed from: x */
    public static boolean m2607x(Context context, String str) {
        boolean z = false;
        ArrayList arrayList = (ArrayList) C0432b.m1870a(context).f1360a.clone();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.equals(((C0437f) it.next()).m1867c())) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            String f = C0472c.m2039f(context);
            if (TextUtils.isEmpty(f) && C0578p.m2501E(context)) {
                f = C0579q.m2612a(context, context.getPackageName() + ".push_sync", "r_v2");
            }
            f = C0432b.m1871a(f);
            if (!TextUtils.isEmpty(f) && f.contains(str)) {
                f = f.replace(" ", "");
                if (f.charAt(f.indexOf(str) + str.length()) == ',') {
                    return true;
                }
            }
        }
        return z;
    }

    /* renamed from: y */
    public static boolean m2608y(Context context) {
        boolean z = false;
        try {
            z = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false);
        } catch (Exception e) {
        }
        return z;
    }

    /* renamed from: y */
    public static boolean m2609y(Context context, String str) {
        boolean e;
        boolean z;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            e = C0463a.m2013e(context, str);
            try {
                z = e;
                e = C0578p.m2599t(context, str);
            } catch (Exception e2) {
                z = e;
                e = false;
                return !z ? false : false;
            }
            if (!z && r1) {
                return true;
            }
        } catch (Exception e3) {
            e = false;
            z = e;
            e = false;
            if (!z) {
            }
        }
    }

    /* renamed from: z */
    public static void m2610z(Context context) {
        if (context != null) {
            C0575n.m2478a(context, 5, "");
            Context applicationContext = context.getApplicationContext();
            Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
            intent.putExtra(PushConstants.PACKAGE_NAME, applicationContext.getPackageName());
            intent.setFlags(32);
            applicationContext.sendBroadcast(intent);
            C0575n.m2479a(applicationContext, "hasRequestToken", true);
        }
    }

    /* renamed from: z */
    public static boolean m2611z(Context context, String str) {
        try {
            if (C0578p.m2492A(context, str) >= 24 && VERSION.SDK_INT >= 24) {
                if ((str.equals(context.getPackageName()) ? C0430a.m1854a() : C0578p.m2584m(context, str)) >= (short) 55) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
