package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.util.common.SystemAuth;
import org.json.JSONException;
import org.json.JSONObject;

class bu {
    /* renamed from: a */
    static String f19502a = C1253f.jb;
    /* renamed from: b */
    boolean f19503b = false;
    /* renamed from: c */
    String f19504c;
    /* renamed from: d */
    String f19505d;
    /* renamed from: e */
    String f19506e = "0";
    /* renamed from: f */
    String f19507f = null;
    /* renamed from: g */
    String f19508g = null;
    /* renamed from: h */
    int f19509h = -1;
    /* renamed from: i */
    String f19510i;
    /* renamed from: j */
    String f19511j;
    /* renamed from: k */
    int f19512k;
    /* renamed from: l */
    int f19513l;
    /* renamed from: m */
    String f19514m = null;
    /* renamed from: n */
    String f19515n;
    /* renamed from: o */
    String f19516o;
    /* renamed from: p */
    String f19517p;
    /* renamed from: q */
    String f19518q;
    /* renamed from: r */
    String f19519r;
    /* renamed from: s */
    String f19520s;
    /* renamed from: t */
    String f19521t;
    /* renamed from: u */
    String f19522u;
    /* renamed from: v */
    String f19523v;
    /* renamed from: w */
    String f19524w;
    /* renamed from: x */
    String f19525x;
    /* renamed from: y */
    String f19526y;
    /* renamed from: z */
    JSONObject f19527z;

    bu() {
    }

    /* renamed from: a */
    public synchronized void m15507a(Context context, JSONObject jSONObject) {
        m15506a(context);
        if (jSONObject.length() > 10) {
            db.m15657a("header has been installed; header is:" + jSONObject);
        } else {
            m15509b(context, jSONObject);
        }
    }

    /* renamed from: a */
    public synchronized void m15506a(Context context) {
        if (!this.f19503b) {
            cu.m15638e(context, SystemAuth.READ_PHONE_STATE_AUTH);
            cu.m15638e(context, "android.permission.INTERNET");
            cu.m15638e(context, "android.permission.ACCESS_NETWORK_STATE");
            cu.m15638e(context, "android.permission.WRITE_SETTINGS");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            this.f19504c = CooperService.m15264a().getOSVersion();
            this.f19505d = CooperService.m15264a().getOSSysVersion();
            this.f19516o = CooperService.m15264a().getPhoneModel();
            this.f19517p = CooperService.m15264a().getManufacturer();
            this.f19526y = CooperService.m15264a().getUUID();
            this.f19527z = CooperService.m15264a().getHeaderExt(context);
            this.f19511j = CooperService.m15264a().getDeviceId(telephonyManager, context);
            this.f19506e = bj.m15464a().m15486j(context) ? "1" : "0";
            if (de.m15708s(context)) {
                this.f19506e = "2";
            }
            this.f19506e += "-0";
            try {
                this.f19521t = CooperService.m15264a().getMacAddress(context, CooperService.m15264a().isDeviceMacEnabled(context));
            } catch (Throwable e) {
                db.m15659a(e);
            }
            try {
                this.f19523v = de.m15692f(1, context);
            } catch (Throwable e2) {
                db.m15659a(e2);
            }
            try {
                this.f19524w = de.m15677a(context, 1);
            } catch (Throwable e22) {
                db.m15659a(e22);
            }
            this.f19508g = CooperService.m15264a().getCUID(context, true);
            try {
                this.f19515n = CooperService.m15264a().getOperator(telephonyManager);
            } catch (Throwable e3) {
                db.m15659a(e3);
            }
            try {
                this.f19512k = de.m15680b(context);
                this.f19513l = de.m15684c(context);
                if (context.getResources().getConfiguration().orientation == 2) {
                    this.f19512k ^= this.f19513l;
                    this.f19513l = this.f19512k ^ this.f19513l;
                    this.f19512k ^= this.f19513l;
                }
            } catch (Throwable e32) {
                db.m15659a(e32);
            }
            this.f19514m = CooperService.m15264a().getAppChannel(context);
            this.f19507f = CooperService.m15264a().getAppKey(context);
            try {
                this.f19509h = CooperService.m15264a().getAppVersionCode(context);
                this.f19510i = CooperService.m15264a().getAppVersionName(context);
            } catch (Throwable e322) {
                db.m15659a(e322);
            }
            try {
                if (CooperService.m15264a().checkCellLocationSetting(context)) {
                    this.f19518q = de.m15695g(context);
                } else {
                    this.f19518q = "0_0_0";
                }
            } catch (Throwable e3222) {
                db.m15659a(e3222);
            }
            try {
                if (CooperService.m15264a().checkGPSLocationSetting(context)) {
                    this.f19519r = de.m15697h(context);
                } else {
                    this.f19519r = "";
                }
            } catch (Throwable e32222) {
                db.m15659a(e32222);
            }
            try {
                this.f19520s = CooperService.m15264a().getLinkedWay(context);
            } catch (Throwable e322222) {
                db.m15659a(e322222);
            }
            this.f19525x = de.m15681b();
            this.f19503b = true;
        }
    }

    /* renamed from: b */
    public synchronized void m15509b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(Config.OS, f19502a == null ? "" : f19502a);
            jSONObject.put("st", 0);
            jSONObject.put("s", this.f19504c == null ? "" : this.f19504c);
            jSONObject.put("sv", this.f19505d == null ? "" : this.f19505d);
            jSONObject.put(Config.APP_KEY, this.f19507f == null ? "" : this.f19507f);
            jSONObject.put("pt", this.f19506e == null ? "0" : this.f19506e);
            jSONObject.put("i", "");
            jSONObject.put("v", "3.7.6.1");
            jSONObject.put("sc", 0);
            jSONObject.put(Config.APP_VERSION_CODE, this.f19509h);
            jSONObject.put("n", this.f19510i == null ? "" : this.f19510i);
            jSONObject.put("d", "");
            jSONObject.put(Config.DEVICE_MAC_ID, this.f19521t == null ? "" : this.f19521t);
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, this.f19523v == null ? "" : this.f19523v);
            jSONObject.put("dd", this.f19511j == null ? "" : this.f19511j);
            jSONObject.put(Config.CUID_SEC, this.f19508g == null ? "" : this.f19508g);
            jSONObject.put(Config.SDK_TAG, 1);
            jSONObject.put(Config.DEVICE_WIDTH, this.f19512k);
            jSONObject.put("h", this.f19513l);
            jSONObject.put(Config.DEVICE_NAME, this.f19524w == null ? "" : this.f19524w);
            jSONObject.put("c", this.f19514m == null ? "" : this.f19514m);
            jSONObject.put(Config.OPERATOR, this.f19515n == null ? "" : this.f19515n);
            jSONObject.put(Config.MODEL, this.f19516o == null ? "" : this.f19516o);
            jSONObject.put("ma", this.f19517p == null ? "" : this.f19517p);
            jSONObject.put("cl", this.f19518q);
            jSONObject.put(Config.GPS_LOCATION, this.f19519r == null ? "" : this.f19519r);
            jSONObject.put("l", this.f19520s == null ? "" : this.f19520s);
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put("pn", de.m15696h(1, context));
            jSONObject.put(Config.ROM, this.f19525x == null ? "" : this.f19525x);
            CharSequence q = de.m15706q(context);
            jSONObject.put("pl", q);
            Object obj = null;
            if (!TextUtils.isEmpty(q)) {
                obj = de.m15707r(context);
            }
            String str = Config.PROCESS_CLASS;
            if (obj == null) {
                obj = "";
            }
            jSONObject.put(str, obj);
            jSONObject.put("sign", this.f19526y == null ? "" : this.f19526y);
            if (!(this.f19527z == null || this.f19527z.length() == 0)) {
                jSONObject.put("ext", this.f19527z);
            }
            db.m15657a("header is: " + jSONObject.toString() + "; len: " + jSONObject.length());
        } catch (JSONException e) {
            db.m15657a("header ini error");
        }
    }

    /* renamed from: a */
    public void m15508a(JSONObject jSONObject) {
        this.f19527z = jSONObject;
    }
}
