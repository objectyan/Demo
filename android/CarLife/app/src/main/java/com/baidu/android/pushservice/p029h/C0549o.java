package com.baidu.android.pushservice.p029h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.p022i.C0420c;
import com.baidu.android.pushservice.p022i.C0559d;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p027f.C0520a;
import com.baidu.android.pushservice.p027f.C0521b;
import com.baidu.android.pushservice.p029h.p030a.C0530a;
import com.baidu.android.pushservice.p029h.p030a.C0532b;
import com.baidu.android.pushservice.p031j.C0572k;
import com.baidu.android.pushservice.p032k.C0582b;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.navi.track.sync.SyncChannelConstant.Key;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.o */
public final class C0549o {
    /* renamed from: a */
    public static String f1810a = "";
    /* renamed from: b */
    private Context f1811b = null;
    /* renamed from: c */
    private C0550p f1812c = null;
    /* renamed from: d */
    private boolean f1813d;

    public C0549o(Context context) {
        this.f1811b = context.getApplicationContext();
        this.f1812c = C0550p.m2348a(context);
        this.f1813d = false;
    }

    /* renamed from: a */
    private boolean m2338a(String str, String str2, String str3) {
        Throwable th;
        Closeable closeable;
        Throwable th2;
        if (!C0572k.m2457a(this.f1811b)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("stats", str2);
        hashMap.put("pbVer", str3);
        hashMap.put("os", "android");
        InputStream inputStream = null;
        long j = 1000;
        int i = 0;
        while (i < 2) {
            try {
                C0520a a = C0521b.m2163a(str, "POST", hashMap);
                int b = a.m2162b();
                inputStream = a.m2159a();
                String a2 = C0532b.m2252a(inputStream);
                if (b == 200) {
                    C0521b.m2169a(inputStream);
                    return true;
                } else if (b == 201) {
                    m2343a(a2);
                    break;
                } else if (b == 403) {
                    m2345b(a2);
                    break;
                } else {
                    j += (long) (i * 300);
                    Thread.sleep(j);
                    i++;
                }
            } catch (Throwable e) {
                th = e;
                closeable = inputStream;
                C0553q.m2362a(this.f1811b, th);
                C0521b.m2169a(closeable);
                return false;
            } catch (Throwable th3) {
                th2 = th3;
            }
        }
        C0521b.m2169a(inputStream);
        return false;
        C0521b.m2169a(closeable);
        throw th2;
    }

    /* renamed from: d */
    private boolean m2340d() {
        long j = 259200000;
        if (!C0532b.m2257c(this.f1811b) || this.f1813d || PushSettings.m1830f(this.f1811b)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long d = PushSettings.m1828d(this.f1811b);
        long j2 = currentTimeMillis - d;
        if (j2 > 259200000) {
            j2 = currentTimeMillis - 259200000;
            PushSettings.m1818a(this.f1811b, j2);
        } else {
            j = j2;
            j2 = d;
        }
        if (C0572k.m2458b(this.f1811b)) {
            if (j < 21600000) {
                return false;
            }
        } else if (j < PushSettings.m1829e(this.f1811b)) {
            return false;
        }
        return C0463a.m2006b(this.f1811b, currentTimeMillis, j2);
    }

    /* renamed from: a */
    public String m2341a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("user_device", C0532b.m2261e(this.f1811b));
            jSONObject.put("user_network", C0532b.m2259d(this.f1811b));
            jSONObject2.put("channel_id", PushSettings.m1816a(this.f1811b));
            jSONObject2.put("push_running_version", C0430a.m1854a());
            jSONObject.put("push_channel", jSONObject2);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public String m2342a(long j, long j2, int i) {
        byte[] a;
        String str = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "1.0");
            Object a2 = m2341a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("common", new JSONObject(a2));
            }
            a2 = this.f1812c.m2349a(j, j2, i);
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("application_info", new JSONArray(a2));
            }
        } catch (JSONException e) {
        }
        try {
            a = C0530a.m2249a(jSONObject.toString());
            a[0] = (byte) 117;
            a[1] = (byte) 123;
        } catch (IOException e2) {
            a = str;
        }
        if (a != null) {
            try {
                str = C0582b.m2629a(a, "utf-8");
            } catch (UnsupportedEncodingException e3) {
            }
        }
        return str;
    }

    /* renamed from: a */
    public void m2343a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("config_type");
                int i2 = jSONObject.getInt(Key.INTERVAL);
                if (i == 0) {
                    if (i2 > 0) {
                        PushSettings.m1823b(this.f1811b, (long) (i2 * 1000));
                    }
                } else if (i == 1) {
                    this.f1813d = true;
                } else if (i == 2) {
                    if (i2 > 0) {
                        PushSettings.m1817a(this.f1811b, 1);
                        Intent intent = new Intent(PushConstants.ACTION_METHOD);
                        intent.putExtra("method", "com.baidu.android.pushservice.action.ENBALE_APPSTAT");
                        intent.setClass(this.f1811b, PushService.class);
                        PendingIntent service = PendingIntent.getService(this.f1811b.getApplicationContext(), 0, intent, RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
                        long elapsedRealtime = SystemClock.elapsedRealtime() + ((long) i2);
                        AlarmManager alarmManager = (AlarmManager) this.f1811b.getSystemService("alarm");
                        alarmManager.cancel(service);
                        alarmManager.set(1, elapsedRealtime, service);
                    }
                } else if (i == 10) {
                    PushSettings.m1834j(this.f1811b);
                } else if (i == 11) {
                    PushSettings.m1835k(this.f1811b);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: b */
    public void m2344b() {
        C0559d.m2387a().m2388a(new C0420c(this, "checkSendStatisticData", (short) 90) {
            /* renamed from: a */
            final /* synthetic */ C0549o f1809a;

            /* renamed from: a */
            public void mo1272a() {
                if (this.f1809a.m2340d()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = (int) ((currentTimeMillis / 60000) % 5);
                    int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                    if (i == 0 && i2 < 15) {
                        try {
                            Thread.sleep((long) ((Math.random() * 60.0d) * 1000.0d));
                        } catch (InterruptedException e) {
                        }
                        if (!C0532b.m2257c(this.f1809a.f1811b)) {
                            return;
                        }
                    }
                    this.f1809a.m2347c();
                }
            }
        });
    }

    /* renamed from: b */
    public void m2345b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("error_code");
                jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
                if (i == NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_EDOG) {
                    PushSettings.m1817a(this.f1811b, 1);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: b */
    public boolean m2346b(long j, long j2, int i) {
        String a = m2342a(j, j2, i);
        String str = "https://statsonline.pushct.baidu.com/pushlog_special";
        try {
            if (!TextUtils.isEmpty(a)) {
                return m2338a(str, a, "1.0");
            }
        } catch (OutOfMemoryError e) {
        }
        return false;
    }

    /* renamed from: c */
    public synchronized void m2347c() {
        long currentTimeMillis = System.currentTimeMillis();
        long d = PushSettings.m1828d(this.f1811b);
        boolean z = true;
        if (C0463a.m1984a(this.f1811b, currentTimeMillis, d) > 0) {
            z = m2346b(currentTimeMillis, d, 1000);
        }
        if (z) {
            PushSettings.m1818a(this.f1811b, System.currentTimeMillis());
            try {
                C0463a.m2010d(this.f1811b);
            } catch (Exception e) {
            }
        }
    }
}
