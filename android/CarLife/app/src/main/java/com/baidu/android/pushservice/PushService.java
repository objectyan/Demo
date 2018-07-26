package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.p021a.C0417a.C0418a;
import com.baidu.android.pushservice.p021a.C0427b;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p031j.C0564d;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import org.json.JSONObject;

public class PushService extends Service {
    /* renamed from: a */
    private boolean f1314a = false;
    /* renamed from: b */
    private Handler f1315b = new Handler();
    /* renamed from: c */
    private SDcardRemovedReceiver f1316c;
    /* renamed from: d */
    private boolean f1317d = false;
    /* renamed from: e */
    private Runnable f1318e = new C04161(this);
    /* renamed from: f */
    private int f1319f = 0;
    /* renamed from: g */
    private final C0418a f1320g = new C04192(this);

    /* renamed from: com.baidu.android.pushservice.PushService$1 */
    class C04161 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ PushService f1312a;

        C04161(PushService pushService) {
            this.f1312a = pushService;
        }

        public void run() {
            int i = 1;
            this.f1312a.stopSelf();
            C0528g.m2223b();
            int i2 = this.f1312a.f1319f > 0 ? 1 : 0;
            if (this.f1312a.getPackageName().equals(C0578p.m2603v(this.f1312a.getApplicationContext()))) {
                i = 0;
            }
            if ((i2 & i) != 0) {
                this.f1312a.onDestroy();
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.PushService$2 */
    class C04192 extends C0418a {
        /* renamed from: a */
        final /* synthetic */ PushService f1313a;

        C04192(PushService pushService) {
            this.f1313a = pushService;
        }

        /* renamed from: a */
        public int mo1250a(String str, int i) throws RemoteException {
            return 0;
        }

        /* renamed from: a */
        public String mo1251a() throws RemoteException {
            return null;
        }

        /* renamed from: a */
        public String mo1252a(String str) throws RemoteException {
            return null;
        }

        /* renamed from: a */
        public String mo1253a(String str, int i, boolean z, int i2, int i3) throws RemoteException {
            return null;
        }

        /* renamed from: a */
        public void mo1254a(String str, String str2, C0427b c0427b) throws RemoteException {
            c0427b.mo1279b(30602, this.f1313a.m1790a(str, null));
        }

        /* renamed from: a */
        public void mo1255a(String str, String str2, boolean z, C0427b c0427b) throws RemoteException {
            c0427b.mo1278a(30602, this.f1313a.m1790a(str, null));
        }

        /* renamed from: a */
        public void mo1256a(String str, String str2, boolean z, String str3, C0427b c0427b) throws RemoteException {
            c0427b.mo1278a(30602, this.f1313a.m1790a(str, str));
        }

        /* renamed from: a */
        public boolean mo1257a(String str, String str2) throws RemoteException {
            return true;
        }

        /* renamed from: a */
        public boolean mo1258a(String str, String str2, int i) throws RemoteException {
            return true;
        }

        /* renamed from: a */
        public boolean mo1259a(String str, String str2, String str3, String str4) throws RemoteException {
            return true;
        }

        /* renamed from: a */
        public boolean mo1260a(String str, boolean z) {
            return true;
        }

        /* renamed from: b */
        public int mo1261b(String str) throws RemoteException {
            return 0;
        }

        /* renamed from: b */
        public int mo1262b(String str, int i) throws RemoteException {
            return 0;
        }

        /* renamed from: b */
        public String mo1263b() throws RemoteException {
            return null;
        }

        /* renamed from: b */
        public void mo1264b(String str, String str2, C0427b c0427b) throws RemoteException {
            c0427b.mo1280c(30602, this.f1313a.m1790a(str, null));
        }

        /* renamed from: b */
        public boolean mo1265b(String str, String str2) throws RemoteException {
            return true;
        }

        /* renamed from: c */
        public int mo1266c() throws RemoteException {
            return C0430a.m1854a();
        }

        /* renamed from: c */
        public int mo1267c(String str) throws RemoteException {
            return 0;
        }

        /* renamed from: c */
        public int mo1268c(String str, int i) throws RemoteException {
            return 0;
        }

        /* renamed from: d */
        public int mo1269d(String str) throws RemoteException {
            return 0;
        }

        /* renamed from: e */
        public boolean mo1270e(String str) throws RemoteException {
            return true;
        }

        /* renamed from: f */
        public String mo1271f(String str) throws RemoteException {
            return null;
        }
    }

    /* renamed from: a */
    private String m1790a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamKey.KEY_MSG_ERRORS, 30602);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("api_key", str2);
            }
            jSONObject.put(PushConstants.EXTRA_ERROR_CODE, "NOT SUPPORTED ANYMORE");
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m1791a(boolean z, boolean z2) {
        this.f1314a = z;
        C0527a.m2216a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.f1318e.run();
            return;
        }
        this.f1315b.removeCallbacks(this.f1318e);
        this.f1315b.postDelayed(this.f1318e, 3000);
    }

    public IBinder onBind(Intent intent) {
        this.f1319f++;
        return this.f1317d ? this.f1320g : null;
    }

    public void onCreate() {
        super.onCreate();
        C0527a.m2216a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
        C0578p.m2546b("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        this.f1317d = C0528g.m2222a((Context) this).m2244a();
        if (this.f1317d) {
            try {
                this.f1316c = new SDcardRemovedReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
                intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
                registerReceiver(this.f1316c, intentFilter);
                return;
            } catch (Exception e) {
                return;
            }
        }
        m1791a(true, false);
    }

    public void onDestroy() {
        super.onDestroy();
        C0472c.m2031b(getApplicationContext(), null);
        C0527a.m2216a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        C0578p.m2546b("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        if (this.f1316c != null) {
            try {
                unregisterReceiver(this.f1316c);
            } catch (Exception e) {
            }
        }
        C0528g.m2223b();
        if (this.f1314a) {
            Process.killProcess(Process.myPid());
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            intent = new Intent();
            C0527a.m2219c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                C0578p.m2546b("PushService onStartCommand from " + getPackageName() + " Intent " + intent.toUri(0) + " at Time " + System.currentTimeMillis(), getApplicationContext());
            } catch (Exception e) {
            }
        }
        this.f1315b.removeCallbacks(this.f1318e);
        if ("com.baidu.android.pushservice.action.CROSS_REQUEST".equals(intent.getAction())) {
            if (C0430a.m1857b() > 0) {
                intent.putExtra("bd.message.rate.BACK", System.currentTimeMillis());
            }
            C0564d.m2427a(getApplicationContext(), intent);
        }
        try {
            this.f1317d = C0528g.m2222a((Context) this).m2245a(intent);
            if (this.f1317d) {
                return 1;
            }
            m1791a(true, false);
            return 2;
        } catch (Exception e2) {
            m1791a(true, false);
            return 2;
        }
    }

    public boolean onUnbind(Intent intent) {
        this.f1319f--;
        return super.onUnbind(intent);
    }
}
