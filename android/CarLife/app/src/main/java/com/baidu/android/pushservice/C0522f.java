package com.baidu.android.pushservice;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.baidu.android.pushservice.PushManager.SyncCallback;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p024c.C0448d.C0447a;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p025d.C0472c.C0466a;
import com.baidu.android.pushservice.p025d.C0473d;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p029h.C0542h;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0573l;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0575n;
import com.baidu.android.pushservice.p031j.C0577o;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.android.pushservice.p032k.C0590f;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.mobstat.Config;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.speech.utils.AsrError;
import com.coloros.mcssdk.callback.PushCallback;
import com.coloros.mcssdk.mode.SubscribeResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.f */
public class C0522f {
    /* renamed from: a */
    public static int f1689a = -1;
    /* renamed from: b */
    public static String f1690b = null;
    /* renamed from: c */
    public static String f1691c = null;
    /* renamed from: d */
    public static String f1692d = null;
    /* renamed from: e */
    public static String f1693e = null;
    /* renamed from: f */
    public static String f1694f = null;
    /* renamed from: g */
    public static String f1695g = null;
    /* renamed from: h */
    public static String f1696h = null;
    /* renamed from: i */
    public static String f1697i = null;
    /* renamed from: j */
    public static Handler f1698j = null;
    /* renamed from: k */
    private static final ConcurrentLinkedQueue<Runnable> f1699k = new ConcurrentLinkedQueue();
    /* renamed from: l */
    private static boolean f1700l;

    /* renamed from: com.baidu.android.pushservice.f$a */
    private static class C0518a extends Handler {
        public C0518a(Context context) {
            super(context.getMainLooper());
        }

        public void handleMessage(Message message) {
            if (message.what == 65553 && C0522f.f1698j != null && C0522f.f1699k != null && !C0522f.f1699k.isEmpty()) {
                C0522f.f1698j.removeCallbacks((C0519b) C0522f.f1699k.poll());
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.f$b */
    private static class C0519b implements Runnable {
        /* renamed from: a */
        private Context f1686a;

        public C0519b(Context context) {
            this.f1686a = context;
        }

        public void run() {
            CharSequence charSequence = null;
            if (C0448d.m1940c(this.f1686a)) {
                charSequence = C0575n.m2480b(this.f1686a);
            } else if (C0448d.m1941d(this.f1686a)) {
                charSequence = C0575n.m2477a(this.f1686a);
            } else if (C0448d.m1939b(this.f1686a)) {
                charSequence = C0575n.m2481c(this.f1686a);
            }
            if (TextUtils.isEmpty(charSequence)) {
                C0522f.m2209p(this.f1686a);
                if (!C0522f.f1699k.isEmpty()) {
                    C0522f.f1699k.poll();
                }
            }
        }
    }

    /* renamed from: a */
    public static Intent m2174a(Context context) {
        if (C0522f.m2205l(context)) {
            return null;
        }
        int b = f1689a != -1 ? f1689a : C0574m.m2471b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        Object a = !TextUtils.isEmpty(f1690b) ? f1690b : C0574m.m2465a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(a)) {
            C0527a.m2218b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
            C0522f.m2204k(context);
            return null;
        }
        Intent c = C0577o.m2489c(context);
        if (b != 0) {
            return null;
        }
        c.putExtra("secret_key", a);
        return c;
    }

    /* renamed from: a */
    public static Intent m2175a(Context context, int i) {
        Intent a = C0522f.m2174a(context);
        if (a == null) {
            return null;
        }
        a.putExtra("method", PushConstants.METHOD_BIND);
        a.putExtra("bind_status", i);
        a.putExtra("push_sdk_version", C0430a.m1854a());
        a.setFlags(a.getFlags() | 32);
        if (VERSION.SDK_INT < 19) {
            return a;
        }
        a.putExtra("bind_notify_status", C0573l.m2463a(context) + "");
        return a;
    }

    /* renamed from: a */
    public static String m2176a(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SpeechConstant.APP_ID, str2);
        jSONObject.put("channel_id", str3);
        jSONObject.put("user_id", str4);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("request_id", str);
        jSONObject2.put("response_params", jSONObject);
        return jSONObject2.toString();
    }

    /* renamed from: a */
    public static void m2178a(final Context context, int i, String str, boolean z) {
        if (!C0522f.m2205l(context)) {
            boolean g = C0448d.m1945g(context);
            boolean b = C0522f.m2190b(context);
            C0430a.m1858b(context, true);
            C0578p.m2528a(context, true, true);
            if (!g) {
                C0559d.m2387a().m2388a(new C0420c() {
                    /* renamed from: a */
                    public void mo1272a() {
                        C0473d.m2044a(context);
                    }
                });
            }
            C0522f.m2210q(context);
            C0578p.m2546b("startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
            if (z) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
                boolean z2 = sharedPreferences.getBoolean("bind_status", false);
                String string = sharedPreferences.getString("request_id", "");
                String string2 = sharedPreferences.getString(SpeechConstant.APP_ID, "");
                String string3 = sharedPreferences.getString("channel_id", "");
                String string4 = sharedPreferences.getString("user_id", "");
                String str2 = null;
                try {
                    str2 = C0522f.m2176a(string, string2, string3, string4);
                } catch (JSONException e) {
                    C0527a.m2218b("PushManagerHandler", "error " + e.getMessage(), context.getApplicationContext());
                }
                boolean a = C0522f.m2183a(context, i, str);
                if (z2 && a && str2 != null && !b) {
                    Intent intent = new Intent();
                    intent.putExtra("method", PushConstants.METHOD_BIND);
                    intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
                    intent.putExtra("content", str2.getBytes());
                    intent.putExtra("bind_status", 0);
                    C0527a.m2216a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:" + PushConstants.METHOD_BIND + " ,errorCode : " + 0 + " ,content : " + new String(str2), context.getApplicationContext());
                    C0578p.m2545b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
                    if (C0430a.m1857b() > 0) {
                        C0553q.m2357a(context, "039901", 1, str2);
                    }
                    C0522f.m2211r(context);
                    return;
                }
            }
            C0522f.m2188b(context, i, str);
            C0522f.m2211r(context);
        }
    }

    /* renamed from: a */
    public static void m2179a(Context context, String str) {
        Object obj = 1;
        try {
            if (f1698j != null && !f1699k.isEmpty()) {
                f1698j.sendEmptyMessage(65553);
            } else if (!C0448d.m1942e(context)) {
                return;
            }
            Intent a = C0522f.m2175a(context, 0);
            if (a != null) {
                int b = C0448d.m1932a(context).m1952b();
                if (TextUtils.isEmpty(str)) {
                    C0522f.m2209p(context);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (b == 5) {
                    jSONObject2.put("platform", 0);
                } else if (b == 6) {
                    jSONObject2.put("platform", 1);
                } else if (b == 7) {
                    jSONObject2.put("platform", 3);
                } else if (b == 8) {
                    jSONObject2.put("platform", 4);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    jSONObject2.put("token", str);
                    jSONObject.put("info", jSONObject2);
                    C0575n.m2478a(context, b, str);
                }
                a.putExtra("push_proxy", jSONObject.toString());
                C0522f.m2184a(context, a);
            }
        } catch (Exception e) {
            C0522f.m2209p(context);
        }
    }

    /* renamed from: a */
    static void m2180a(Context context, String str, boolean z, int i, long j) {
        Editor edit = context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit();
        edit.putString("base_url", str);
        edit.putBoolean("switch_enable", z);
        edit.putInt("sync_type", i);
        edit.putLong("target_time", j);
        edit.apply();
    }

    /* renamed from: a */
    static void m2181a(Context context, String str, boolean z, int i, SyncCallback syncCallback) {
        final Object s = C0522f.m2212s(context);
        if (!TextUtils.isEmpty(s)) {
            final boolean z2 = z;
            final int i2 = i;
            final Context context2 = context;
            final String str2 = str;
            final SyncCallback syncCallback2 = syncCallback;
            C0559d.m2387a().m2388a(new C0420c("uploadPushEnabledStatus", (short) 100) {
                /* renamed from: a */
                public void mo1272a() {
                    int i = 1;
                    try {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("setting_type", 1);
                        String str = "msg_setting";
                        if (!z2) {
                            i = 0;
                        }
                        jSONObject.put(str, i);
                        jSONObject.put("sys_default_setting", i2);
                        jSONArray.put(jSONObject);
                        HashMap hashMap = new HashMap();
                        hashMap.put("uid", C0589e.m2639a(context2));
                        hashMap.put("bccs_apikey", s);
                        hashMap.put("data", jSONArray.toString());
                        C0520a a = C0521b.m2163a(str2 + "/boxmessage?type=message&action=setting", "POST", hashMap);
                        if (a.m2162b() == 200) {
                            i = new JSONObject(C0532b.m2252a(a.m2159a())).getInt(C2125n.f6745M);
                            if (syncCallback2 != null) {
                                syncCallback2.onSyncResult(i);
                            }
                            if (i == 0) {
                                C0522f.m2213t(context2);
                            }
                        } else if (syncCallback2 != null) {
                            syncCallback2.onSyncResult(-1);
                        }
                    } catch (Exception e) {
                        if (syncCallback2 != null) {
                            syncCallback2.onSyncResult(-1);
                        }
                    }
                }
            });
        } else if (syncCallback != null) {
            syncCallback.onSyncResult(-1);
        }
    }

    /* renamed from: a */
    public static void m2182a(Context context, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f1696h)) {
            f1696h = C0574m.m2465a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f1697i)) {
            f1697i = C0574m.m2465a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
        }
        if (!TextUtils.isEmpty(f1696h) && !TextUtils.isEmpty(f1697i)) {
            C0578p.m2527a(applicationContext, f1696h, f1697i, new PushCallback() {
                public void onGetAliases(int i, List<SubscribeResult> list) {
                }

                public void onGetNotificationStatus(int i, int i2) {
                }

                public void onGetPushStatus(int i, int i2) {
                }

                public void onGetTags(int i, List<SubscribeResult> list) {
                }

                public void onGetUserAccounts(int i, List<SubscribeResult> list) {
                }

                public void onRegister(int i, String str) {
                    if (!z) {
                        return;
                    }
                    if (i != 0) {
                        C0522f.m2209p(applicationContext);
                    } else if (!C0448d.m1942e(applicationContext)) {
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            C0522f.m2209p(applicationContext);
                        } else {
                            C0522f.m2179a(applicationContext, str);
                        }
                    }
                }

                public void onSetAliases(int i, List<SubscribeResult> list) {
                }

                public void onSetPushTime(int i, String str) {
                }

                public void onSetTags(int i, List<SubscribeResult> list) {
                }

                public void onSetUserAccounts(int i, List<SubscribeResult> list) {
                }

                public void onUnRegister(int i) {
                }

                public void onUnsetAliases(int i, List<SubscribeResult> list) {
                }

                public void onUnsetTags(int i, List<SubscribeResult> list) {
                }

                public void onUnsetUserAccounts(int i, List<SubscribeResult> list) {
                }
            });
        } else if (z) {
            C0522f.m2204k(applicationContext);
        }
    }

    /* renamed from: a */
    public static boolean m2183a(Context context, int i, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        Long valueOf = Long.valueOf(sharedPreferences.getLong("currbindtime", 0));
        String string = sharedPreferences.getString("access_token", "");
        String string2 = sharedPreferences.getString("secret_key", "");
        Long valueOf2 = Long.valueOf(sharedPreferences.getLong("version_code", 0));
        if (Long.valueOf(System.currentTimeMillis()).longValue() - valueOf.longValue() > 43200000) {
            sharedPreferences.edit().clear().commit();
            return false;
        }
        if (i == 1) {
            if (!str.equals(string)) {
                return false;
            }
        } else if (i == 0 && !str.equals(string2)) {
            return false;
        }
        return ((long) C0578p.m2559d(context, context.getPackageName())) == valueOf2.longValue();
    }

    /* renamed from: a */
    public static boolean m2184a(Context context, Intent intent) {
        return C0560i.m2390a(context).m2415a(intent);
    }

    /* renamed from: a */
    public static boolean m2185a(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || str2 == null) {
                return false;
            }
            Object a = C0590f.m2669a(C0578p.m2543a(C0578p.m2494B(context, context.getPackageName()).getBytes(), str2.getBytes()), false);
            byte[] a2 = C0590f.m2670a(str);
            if (a2 == null) {
                return false;
            }
            CharSequence a3 = C0590f.m2668a(BaiduAppSSOJni.decryptR(a2, 0), "", false);
            return (TextUtils.isEmpty(a3) || TextUtils.isEmpty(a) || !a.equals(a3)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m2187b(Context context, int i) {
        Intent a = C0522f.m2175a(context, i);
        if (a != null) {
            C0527a.m2216a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
            C0522f.m2184a(context, a);
            C0578p.m2546b("Bind by selfEventHandler", context);
        }
    }

    /* renamed from: b */
    public static void m2188b(final Context context, final int i, final String str) {
        C0448d.m1932a(context.getApplicationContext()).m1951a(new C0447a() {
            /* renamed from: a */
            public void mo1288a() {
                if (i == 0) {
                    C0574m.m2466a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                    C0574m.m2470a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
                }
                if (C0448d.m1941d(context)) {
                    C0430a.m1858b(context, false);
                    C0578p.m2528a(context, true, false);
                    C0522f.m2198e(context);
                } else if (C0448d.m1940c(context)) {
                    C0430a.m1858b(context, false);
                    C0578p.m2528a(context, true, false);
                    C0522f.m2193c(context);
                } else if (C0448d.m1939b(context)) {
                    C0430a.m1858b(context, false);
                    C0578p.m2528a(context, true, false);
                    C0522f.m2196d(context);
                } else if (C0448d.m1942e(context) && C0448d.m1943f(context)) {
                    C0430a.m1858b(context, false);
                    C0578p.m2528a(context, true, false);
                    C0522f.m2182a(context, true);
                } else {
                    C0527a.m2216a("PushManagerHandler", "login type = " + i, context.getApplicationContext());
                    if (i == 0) {
                        if (C0430a.m1857b() > 0) {
                            C0553q.m2357a(context, "039901", 2, str);
                        }
                        C0522f.m2194c(context, i, str);
                        return;
                    }
                    C0527a.m2218b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                    if (C0430a.m1857b() > 0) {
                        C0553q.m2357a(context, "039901", -1, "");
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public static void m2189b(Context context, Intent intent) {
        if (!C0522f.m2184a(context, intent)) {
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: b */
    public static boolean m2190b(Context context) {
        try {
            short s;
            if (C0578p.m2501E(context)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5);
                sharedPreferences.edit();
                s = sharedPreferences.getInt("version2", 0);
            } else {
                s = (short) -1;
            }
            if (s == (short) -1) {
                s = C0472c.m2032c(context);
            }
            return s != C0430a.m1854a();
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m2191b(Context context, String str, String str2) {
        boolean z = false;
        try {
            if (!(TextUtils.isEmpty(str) || str2 == null)) {
                Object a = C0590f.m2669a(C0578p.m2543a(C0578p.m2494B(context, context.getPackageName()).getBytes(), str2.getBytes()), false);
                if (!TextUtils.isEmpty(a)) {
                    z = BaiduAppSSOJni.verify(a.getBytes(), str, 0);
                }
            }
        } catch (Exception e) {
        }
        return z;
    }

    /* renamed from: c */
    public static String m2192c(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            Uri data = intent.getData();
            String stringExtra = intent.getStringExtra("bdpush_hwsigninfo");
            if (!TextUtils.isEmpty(stringExtra) || data == null) {
                return stringExtra;
            }
            Object fragment = data.getFragment();
            if (TextUtils.isEmpty(fragment)) {
                return stringExtra;
            }
            String[] split = fragment.split(";");
            if (split == null || split.length <= 0) {
                return stringExtra;
            }
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains("S.bdpush_hwsigninfo")) {
                    String[] split2 = split[i].split("=");
                    if (split2 != null && 1 < split2.length) {
                        return split2[1];
                    }
                }
            }
            return stringExtra;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    public static void m2193c(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f1692d)) {
            f1692d = C0574m.m2465a(applicationContext, "BD_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(f1693e)) {
            f1693e = C0574m.m2465a(applicationContext, "BD_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f1692d) || TextUtils.isEmpty(f1693e)) {
            C0522f.m2204k(applicationContext);
            return;
        }
        C0578p.m2562d(applicationContext, f1692d, f1693e);
        C0522f.m2208o(applicationContext);
    }

    /* renamed from: c */
    public static void m2194c(Context context, int i, String str) {
        C0578p.m2546b("startWork at time of " + System.currentTimeMillis(), context);
        C0577o.m2483a(context);
        C0522f.m2187b(context, 0);
    }

    /* renamed from: d */
    public static String m2195d(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            Uri data = intent.getData();
            CharSequence stringExtra = intent.getStringExtra("bdpush_hwsigninfo");
            String stringExtra2 = intent.getStringExtra("bdpush_hwmsgid");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                return data != null ? stringExtra2 + data.toString() : null;
            } else {
                if (data == null) {
                    return null;
                }
                Object fragment = data.getFragment();
                if (!TextUtils.isEmpty(fragment)) {
                    String[] split = fragment.split(";");
                    if (split != null && split.length > 0) {
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].contains("S.bdpush_hwmsgid")) {
                                String[] split2 = split[i].split("=");
                                if (split2 != null && 1 < split2.length) {
                                    stringExtra2 = split2[1];
                                    break;
                                }
                            }
                        }
                    }
                }
                String uri = data.toString();
                if (TextUtils.isEmpty(uri) || !uri.contains("#Intent;")) {
                    return null;
                }
                int c = C0578p.m2553c(uri);
                return c > 0 ? stringExtra2 + uri.substring(0, c) : null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public static void m2196d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(f1694f)) {
            f1694f = C0574m.m2465a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
        }
        if (TextUtils.isEmpty(f1695g)) {
            f1695g = C0574m.m2465a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
        }
        if (TextUtils.isEmpty(f1694f) || TextUtils.isEmpty(f1695g)) {
            C0522f.m2204k(applicationContext);
            return;
        }
        C0578p.m2566e(applicationContext, f1694f, f1695g);
        C0522f.m2208o(applicationContext);
    }

    /* renamed from: d */
    public static void m2197d(Context context, int i, String str) {
        String str2 = "errorCode:" + i + ",errorMsg:" + str;
        C0527a.m2218b("PushManagerHandler", str2, context.getApplicationContext());
        if (context != null) {
            Editor edit;
            C0472c.m2023a(context, 0);
            if (C0578p.m2501E(context)) {
                edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 5).edit();
                edit.putLong("priority2", 0);
                edit.commit();
            }
            edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            edit.putBoolean("bind_status", false);
            edit.commit();
        }
        Intent intent = new Intent();
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra("content", str2.getBytes());
        intent.putExtra("bind_status", 0);
        C0578p.m2545b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
    }

    /* renamed from: e */
    public static void m2198e(Context context) {
        Context applicationContext = context.getApplicationContext();
        C0578p.m2610z(applicationContext);
        C0522f.m2208o(applicationContext);
    }

    /* renamed from: f */
    public static void m2199f(Context context) {
        Intent a = C0522f.m2174a(context);
        if (a != null) {
            a.putExtra("method", "method_unbind");
            C0522f.m2189b(context, a);
        }
    }

    /* renamed from: g */
    public static void m2200g(Context context) {
        Intent a = C0522f.m2174a(context);
        if (a != null) {
            a.putExtra("method", "method_unbind");
            a.putExtra("should_notify_user", false);
            C0522f.m2189b(context, a);
        }
    }

    /* renamed from: h */
    public static void m2201h(Context context) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_RECEIVE);
        intent.putExtra("method", "method_unbind");
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
        intent.putExtra("content", PushConstants.m1741a(0).getBytes());
        intent.setFlags(32);
        intent.setPackage(context.getPackageName());
        C0578p.m2545b(context, intent, intent.getAction(), context.getPackageName());
    }

    /* renamed from: i */
    public static void m2202i(Context context) {
        if (f1698j != null && !f1699k.isEmpty()) {
            f1698j.sendEmptyMessage(65553);
            C0522f.m2204k(context);
        }
    }

    /* renamed from: j */
    public static void m2203j(Context context) {
        C0522f.m2202i(context);
    }

    /* renamed from: k */
    public static void m2204k(Context context) {
        Intent intent = new Intent();
        String a = PushConstants.m1741a(30602);
        intent.setAction(PushConstants.ACTION_RECEIVE);
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, 30602);
        intent.putExtra("content", a.getBytes());
        intent.setFlags(32);
        C0578p.m2545b(context, intent, intent.getAction(), context.getPackageName());
    }

    /* renamed from: l */
    public static boolean m2205l(Context context) {
        return context == null;
    }

    /* renamed from: o */
    private static void m2208o(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (f1699k.size() <= 100) {
            Runnable c0519b = new C0519b(applicationContext);
            f1699k.add(c0519b);
            if (f1698j == null) {
                f1698j = new C0518a(applicationContext);
            }
            f1698j.postDelayed(c0519b, 9000);
        }
    }

    /* renamed from: p */
    private static void m2209p(Context context) {
        try {
            String str = "errorCode:10011";
            C0527a.m2218b("PushManagerHandler", str, context.getApplicationContext());
            Intent intent = new Intent();
            intent.putExtra("method", PushConstants.METHOD_BIND);
            intent.putExtra(PushConstants.EXTRA_ERROR_CODE, AsrError.ERROR_OFFLINE_ENGINE_NOT_SUPPORT);
            intent.putExtra("content", str.getBytes());
            intent.putExtra("bind_status", 0);
            C0578p.m2545b(context, intent, PushConstants.ACTION_RECEIVE, context.getPackageName());
        } catch (Throwable th) {
        }
    }

    /* renamed from: q */
    private static void m2210q(final Context context) {
        if (!f1700l) {
            C0559d.m2387a().m2388a(new C0420c("checkAppStatus", (short) 90) {
                /* renamed from: a */
                public void mo1272a() {
                    Cursor query;
                    Throwable th;
                    C0522f.f1700l = true;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.app_stat", 0);
                    long j = sharedPreferences.getLong("last_save", -1);
                    if (j == -1) {
                        C0574m.m2469a(context, C0578p.m2585m(context));
                        return;
                    } else if (DateUtils.isToday(86400000 + j)) {
                        List<String> m = C0578p.m2585m(context);
                        if (m != null && m.size() <= 20) {
                            Object string;
                            List arrayList;
                            List<String> arrayList2;
                            Collection<String> arrayList3;
                            Object string2;
                            String[] split;
                            Object string3;
                            String[] split2;
                            for (String str : m) {
                                Cursor cursor = null;
                                try {
                                    ContentResolver contentResolver = context.getContentResolver();
                                    if (contentResolver != null) {
                                        Uri parse = Uri.parse("content://" + str + ".bdpush" + "/" + "appstatus");
                                        String name = C0466a.timeStamp.name();
                                        query = contentResolver.query(parse, null, null, null, name + " DESC");
                                        if (query != null) {
                                            try {
                                                if (query.moveToFirst()) {
                                                    long j2 = query.getLong(query.getColumnIndex(name));
                                                    if (query != null) {
                                                        try {
                                                            query.close();
                                                        } catch (Exception e) {
                                                            j = j2;
                                                        }
                                                    }
                                                    j = j2;
                                                    if (j == -1 || !DateUtils.isToday(j)) {
                                                        string = sharedPreferences.getString("pkg_list", "");
                                                        if (!TextUtils.isEmpty(string)) {
                                                            arrayList = new ArrayList();
                                                            arrayList2 = new ArrayList(Arrays.asList(string.split(Config.TRACE_TODAY_VISIT_SPLIT)));
                                                            arrayList3 = new ArrayList(arrayList2);
                                                            arrayList3.retainAll(m);
                                                            for (String str2 : arrayList3) {
                                                                string2 = sharedPreferences.getString(str2, "");
                                                                if (!TextUtils.isEmpty(string2)) {
                                                                    split = string2.split(Config.TRACE_TODAY_VISIT_SPLIT);
                                                                    arrayList.add(new C0542h(str2, Integer.valueOf(split[0]).intValue(), split[1], 1000));
                                                                }
                                                            }
                                                            arrayList2.removeAll(arrayList3);
                                                            for (String str22 : arrayList2) {
                                                                if (!m.contains(str22)) {
                                                                    string3 = sharedPreferences.getString(str22, "");
                                                                    if (!TextUtils.isEmpty(string3)) {
                                                                        split2 = string3.split(Config.TRACE_TODAY_VISIT_SPLIT);
                                                                        arrayList.add(new C0542h(str22, Integer.valueOf(split2[0]).intValue(), split2[1], 1001));
                                                                    }
                                                                }
                                                            }
                                                            C0472c.m2026a(context, arrayList);
                                                        }
                                                    }
                                                    C0574m.m2469a(context, (List) m);
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                cursor = query;
                                                th = th2;
                                            }
                                        }
                                    } else {
                                        query = null;
                                    }
                                    if (query != null) {
                                        try {
                                            query.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            j = -1;
                            string = sharedPreferences.getString("pkg_list", "");
                            if (TextUtils.isEmpty(string)) {
                                arrayList = new ArrayList();
                                arrayList2 = new ArrayList(Arrays.asList(string.split(Config.TRACE_TODAY_VISIT_SPLIT)));
                                arrayList3 = new ArrayList(arrayList2);
                                arrayList3.retainAll(m);
                                for (String str222 : arrayList3) {
                                    string2 = sharedPreferences.getString(str222, "");
                                    if (!TextUtils.isEmpty(string2)) {
                                        split = string2.split(Config.TRACE_TODAY_VISIT_SPLIT);
                                        arrayList.add(new C0542h(str222, Integer.valueOf(split[0]).intValue(), split[1], 1000));
                                    }
                                }
                                arrayList2.removeAll(arrayList3);
                                for (String str2222 : arrayList2) {
                                    if (!m.contains(str2222)) {
                                        string3 = sharedPreferences.getString(str2222, "");
                                        if (!TextUtils.isEmpty(string3)) {
                                            split2 = string3.split(Config.TRACE_TODAY_VISIT_SPLIT);
                                            arrayList.add(new C0542h(str2222, Integer.valueOf(split2[0]).intValue(), split2[1], 1001));
                                        }
                                    }
                                }
                                C0472c.m2026a(context, arrayList);
                            }
                            C0574m.m2469a(context, (List) m);
                            return;
                        }
                        return;
                    } else if (!DateUtils.isToday(j)) {
                        C0574m.m2469a(context, C0578p.m2585m(context));
                        return;
                    } else {
                        return;
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                    throw th;
                }
            });
        }
    }

    /* renamed from: r */
    private static void m2211r(Context context) {
        if (context.getPackageName().startsWith("com.baidu")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0);
            String string = sharedPreferences.getString("base_url", "");
            boolean z = sharedPreferences.getBoolean("switch_enable", true);
            int i = sharedPreferences.getInt("sync_type", 1);
            long j = sharedPreferences.getLong("target_time", 0);
            if (!TextUtils.isEmpty(string) && j != 0 && System.currentTimeMillis() >= j) {
                C0522f.m2181a(context, string, z, i, null);
            }
        }
    }

    /* renamed from: s */
    private static String m2212s(Context context) {
        return TextUtils.isEmpty(f1690b) ? C0574m.m2465a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE") : f1690b;
    }

    /* renamed from: t */
    private static void m2213t(Context context) {
        context.getSharedPreferences("com.baidu.pushservice.switch_sync", 0).edit().clear().apply();
    }
}
