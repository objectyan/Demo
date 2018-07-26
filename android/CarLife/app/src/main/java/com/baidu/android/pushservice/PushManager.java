package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import java.util.List;
import java.util.Random;

@SuppressLint({"WorldReadableFiles"})
public class PushManager {
    private static final String TAG = "PushManager";

    public interface SyncCallback {
        void onSyncResult(int i);
    }

    public static void delTags(Context context, List<String> list) {
        if (list != null && list.size() != 0) {
            Intent a = C0522f.m2174a(context);
            if (a != null) {
                String str = "[";
                for (String str2 : list) {
                    str = ((str + "\"") + str2) + "\",";
                }
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                String str22 = str + "]";
                a.putExtra("method", "method_del_tags");
                a.putExtra("tags", str22);
                C0527a.m2216a(TAG, "a delTags intent send", context.getApplicationContext());
                C0522f.m2189b(context, a);
            }
        }
    }

    public static void disableLbs(Context context) {
        if (!C0522f.m2205l(context)) {
            PushSettings.m1820a(context, false);
        }
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        if (z) {
            C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 1);
        } else {
            C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 0);
        }
    }

    public static void enableLbs(Context context) {
        if (!C0522f.m2205l(context)) {
            PushSettings.m1820a(context, true);
        }
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C0522f.f1694f = str;
            C0574m.m2470a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
            C0522f.f1695g = str2;
            C0574m.m2470a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
            if (z) {
                C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 1);
            } else {
                C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 0);
            }
        }
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C0522f.f1696h = str;
            C0574m.m2470a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
            C0522f.f1697i = str2;
            C0574m.m2470a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
            C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
        }
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            C0522f.f1692d = str;
            C0574m.m2470a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            C0522f.f1693e = str2;
            C0574m.m2470a(context, "BD_PROXY_APPKEY_KEY", str2);
        }
        if (z) {
            C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 1);
        } else {
            C0574m.m2466a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 0);
        }
    }

    public static int getBindType(Context context) {
        return !context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false) ? 0 : C0448d.m1941d(context) ? 2 : C0448d.m1940c(context) ? 3 : C0448d.m1939b(context) ? 4 : C0448d.m1942e(context) ? 5 : 1;
    }

    public static String getHWNotifyCheckInfo(Context context, Intent intent) {
        String str = null;
        if (intent != null) {
            try {
                str = C0522f.m2195d(context, intent);
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String getHWNotifySignInfo(Context context, Intent intent) {
        String str = null;
        if (intent != null) {
            try {
                str = C0522f.m2192c(context, intent);
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static boolean hwMessageVerify(Context context, String str, String str2) {
        boolean z = false;
        try {
            if (!(TextUtils.isEmpty(str) || str2 == null)) {
                z = C0522f.m2185a(context, str, str2);
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Intent intent = new Intent();
                if (intent != null) {
                    String packageName = C0448d.m1945g(context) ? context.getPackageName() : C0578p.m2603v(context);
                    if (packageName != null) {
                        C0527a.m2216a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
                        intent.putExtra("app_id", str2);
                        intent.putExtra("msg_id", str);
                        intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
                        intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                        context.startService(intent);
                    }
                }
            } catch (Exception e) {
                C0527a.m2218b(TAG, "error " + e.getMessage(), context.getApplicationContext());
            }
        }
    }

    public static void insertPassThroughMessageDelete(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Intent intent = new Intent();
                if (intent != null) {
                    String packageName = C0448d.m1945g(context) ? context.getPackageName() : C0578p.m2603v(context);
                    if (packageName != null) {
                        C0527a.m2216a(TAG, "PassThroughMessageDelete  : " + packageName, context.getApplicationContext());
                        intent.putExtra("app_id", str2);
                        intent.putExtra("msg_id", str);
                        intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.DELETE");
                        intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                        context.startService(intent);
                    }
                }
            } catch (Exception e) {
                C0527a.m2218b(TAG, "error " + e.getMessage(), context.getApplicationContext());
            }
        }
    }

    public static void insertPassThroughMessageNotified(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Intent intent = new Intent();
                String packageName = C0448d.m1945g(context) ? context.getPackageName() : C0578p.m2603v(context);
                if (packageName != null) {
                    C0527a.m2216a(TAG, "PassThroughMessageNotified  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                    if (!packageName.equals(context.getPackageName())) {
                        intent.putExtra("self_insert", true);
                        intent.setClassName(context.getPackageName(), "com.baidu.android.pushservice.CommandService");
                        context.startService(intent);
                    }
                }
            } catch (Exception e) {
                C0527a.m2218b(TAG, "error " + e.getMessage(), context.getApplicationContext());
            }
        }
    }

    public static boolean isPushEnabled(Context context) {
        return (C0522f.m2205l(context) || C0578p.m2557c(context)) ? false : true;
    }

    public static void listTags(Context context) {
        Intent a = C0522f.m2174a(context);
        if (a != null) {
            a.putExtra("method", "method_listtags");
            C0527a.m2216a(TAG, "a listTags intent send", context.getApplicationContext());
            C0522f.m2189b(context, a);
        }
    }

    public static void resumeWork(Context context) {
        if (!C0522f.m2205l(context)) {
            C0430a.m1858b(context, true);
            C0578p.m2528a(context, true, true);
            C0430a.m1855a(context, true);
            C0577o.m2483a(context);
            C0522f.m2187b(context, 0);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (!C0522f.m2205l(context)) {
            C0475d.m2056a(context, pushNotificationBuilder);
        }
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (!C0522f.m2205l(context)) {
            C0475d.m2058b(context, pushNotificationBuilder);
        }
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (!C0522f.m2205l(context)) {
            if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
                C0527a.m2216a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
            } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
                C0527a.m2216a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
            } else {
                String packageName = context.getPackageName();
                C0527a.m2216a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
                C0463a.m1995a(context, packageName, i, i2, i3, i4);
            }
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (!C0522f.m2205l(context)) {
            if (i < 1 || i > 1000) {
                C0527a.m2218b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
            } else {
                C0475d.m2055a(context, i, pushNotificationBuilder);
            }
        }
    }

    public static void setTags(Context context, List<String> list) {
        if (list != null && list.size() != 0) {
            Intent a = C0522f.m2174a(context);
            if (a != null) {
                String str = "[";
                for (String str2 : list) {
                    str = ((str + "\"") + str2) + "\",";
                }
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                String str22 = str + "]";
                a.putExtra("method", "method_set_tags");
                a.putExtra("tags", str22);
                C0527a.m2216a(TAG, "a setTags intent send ", context.getApplicationContext());
                C0522f.m2189b(context, a);
            }
        }
    }

    public static void startWork(Context context, int i, String str) {
        if (!C0522f.m2205l(context)) {
            C0522f.f1689a = i;
            C0522f.f1690b = str;
            C0554h.m2377b(context);
            String l = C0578p.m2583l(context, str);
            C0574m.m2470a(context, "com.baidu.android.pushservice.CHECK_SDK", l);
            C0527a.m2216a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + l, context.getApplicationContext());
            C0578p.m2546b("startWork from " + context.getPackageName() + " checkResult: " + l, context);
            if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", l) || !PushSettings.m1827c(context)) && i == 0) {
                C0522f.m2178a(context, i, C0522f.f1690b, true);
            } else {
                if (i != 0) {
                    Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
                }
                C0522f.m2197d(context, 10101, l);
            }
            C0578p.m2493A(context);
        }
    }

    public static void stopWork(Context context) {
        if (!C0522f.m2205l(context)) {
            C0578p.m2546b("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
            if (C0578p.m2608y(context) || C0448d.m1945g(context)) {
                C0522f.m2199f(context);
                C0430a.m1858b(context, false);
                C0578p.m2528a(context, true, true);
                C0430a.m1855a(context, true);
                C0578p.m2571f(context, context.getPackageName());
                Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                edit.putBoolean("bind_status", false);
                edit.commit();
                return;
            }
            C0522f.m2201h(context);
        }
    }

    public static void syncPushEnabled(Context context, String str, boolean z, int i, SyncCallback syncCallback) {
        if (!C0522f.m2205l(context) && context.getPackageName().startsWith("com.baidu") && !TextUtils.isEmpty(str)) {
            switch (i) {
                case 0:
                    C0522f.m2181a(context, str, z, i, syncCallback);
                    return;
                case 1:
                    C0522f.m2180a(context, str, z, i, System.currentTimeMillis() + ((long) ((((new Random().nextInt(30) + 1) * 24) * 3600) * 1000)));
                    return;
                case 2:
                    if (!C0448d.m1945g(context)) {
                        C0522f.m2180a(context, str, z, i, System.currentTimeMillis() + 21600000);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (syncCallback != null) {
            syncCallback.onSyncResult(-1);
        }
    }
}
