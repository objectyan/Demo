package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CooperService implements ICooperService {
    /* renamed from: a */
    private static CooperService f19351a;
    /* renamed from: b */
    private bu f19352b = new bu();

    /* renamed from: a */
    static synchronized CooperService m15264a() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (f19351a == null) {
                f19351a = new CooperService();
            }
            cooperService = f19351a;
        }
        return cooperService;
    }

    public bu getHeadObject() {
        return this.f19352b;
    }

    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    public void installHeader(Context context, JSONObject jSONObject) {
        this.f19352b.m15507a(context, jSONObject);
    }

    public JSONObject getHeaderExt(Context context) {
        Object l = bj.m15464a().m15488l(context);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(l)) {
            return jSONObject;
        }
        try {
            return new JSONObject(l);
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.f19352b.m15508a(jSONObject);
        bj.m15464a().m15482f(context, jSONObject.toString());
    }

    /* renamed from: a */
    private static String m15265a(Context context) {
        String j = de.m15699j(context);
        if (TextUtils.isEmpty(j)) {
            return j;
        }
        return j.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
    }

    /* renamed from: b */
    private static String m15267b(Context context) {
        String i = de.m15698i(context);
        if (TextUtils.isEmpty(i)) {
            return i;
        }
        return i.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
    }

    /* renamed from: c */
    private static String m15268c(Context context) {
        String k = de.m15700k(context);
        if (TextUtils.isEmpty(k)) {
            return k;
        }
        return k.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
    }

    public String getMacAddress(Context context, boolean z) {
        String replace = Config.DEF_MAC_ID.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
        if (!z && VERSION.SDK_INT >= 23) {
            return getSecretValue(replace);
        }
        if (!TextUtils.isEmpty(this.f19352b.f19521t)) {
            return this.f19352b.f19521t;
        }
        Object i = bj.m15464a().m15485i(context);
        if (TextUtils.isEmpty(i)) {
            i = m15266a(context, z);
            if (TextUtils.isEmpty(i) || replace.equals(i)) {
                this.f19352b.f19521t = "";
                return this.f19352b.f19521t;
            }
            this.f19352b.f19521t = getSecretValue(i);
            bj.m15464a().m15476d(context, this.f19352b.f19521t);
            return this.f19352b.f19521t;
        }
        this.f19352b.f19521t = i;
        return this.f19352b.f19521t;
    }

    /* renamed from: a */
    private String m15266a(Context context, boolean z) {
        String b;
        if (z) {
            b = m15267b(context);
        } else {
            b = m15265a(context);
        }
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        return b;
    }

    public String getMacIdForTv(Context context) {
        if (!TextUtils.isEmpty(this.f19352b.f19522u)) {
            return this.f19352b.f19522u;
        }
        Object k = bj.m15464a().m15487k(context);
        if (TextUtils.isEmpty(k)) {
            String c = de.m15686c(1, context);
            if (TextUtils.isEmpty(c)) {
                this.f19352b.f19522u = "";
                return this.f19352b.f19522u;
            }
            this.f19352b.f19522u = c;
            bj.m15464a().m15480e(context, c);
            return this.f19352b.f19522u;
        }
        this.f19352b.f19522u = k;
        return this.f19352b.f19522u;
    }

    public String getCUID(Context context, boolean z) {
        if (this.f19352b.f19508g == null) {
            this.f19352b.f19508g = bj.m15464a().m15481f(context);
            if (this.f19352b.f19508g == null || "".equalsIgnoreCase(this.f19352b.f19508g)) {
                try {
                    this.f19352b.f19508g = dg.m15714a(context);
                    Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f19352b.f19508g);
                    this.f19352b.f19508g = matcher.replaceAll("");
                    this.f19352b.f19508g = getSecretValue(this.f19352b.f19508g);
                    bj.m15464a().m15471b(context, this.f19352b.f19508g);
                } catch (Exception e) {
                    db.m15663c(e.getMessage());
                }
            }
        }
        if (z) {
            return this.f19352b.f19508g;
        }
        try {
            Object obj = this.f19352b.f19508g;
            if (!TextUtils.isEmpty(obj)) {
                return new String(ct.m15623b(1, cv.m15640a(obj.getBytes())));
            }
        } catch (Throwable e2) {
            db.m15659a(e2);
        }
        return null;
    }

    public int getTagValue() {
        return 1;
    }

    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        String str = this.f19352b.f19511j;
        if (!TextUtils.isEmpty(str)) {
            return this.f19352b.f19511j;
        }
        if (bj.m15464a().m15486j(context)) {
            this.f19352b.f19511j = getMacIdForTv(context);
            return this.f19352b.f19511j;
        } else if (telephonyManager == null) {
            return this.f19352b.f19511j;
        } else {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            try {
                CharSequence deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    str = compile.matcher(deviceId).replaceAll("");
                }
            } catch (Throwable e) {
                db.m15659a(e);
            }
            if (str == null || str.equals(Config.NULL_DEVICE_ID)) {
                str = m15265a(context);
            }
            if (de.m15708s(context) && (TextUtils.isEmpty(r0) || r0.equals(Config.NULL_DEVICE_ID))) {
                try {
                    str = m15268c(context);
                } catch (Throwable e2) {
                    db.m15659a(e2);
                }
            }
            if (TextUtils.isEmpty(str) || str.equals(Config.NULL_DEVICE_ID)) {
                str = bj.m15464a().m15479e(context);
            }
            if (TextUtils.isEmpty(str) || str.equals(Config.NULL_DEVICE_ID)) {
                str = "hol" + (new Date().getTime() + "").hashCode() + "mes";
                bj.m15464a().m15467a(context, str);
            }
            this.f19352b.f19511j = str;
            this.f19352b.f19511j = getSecretValue(this.f19352b.f19511j);
            return this.f19352b.f19511j;
        }
    }

    public String getAppChannel(Context context) {
        return m15269d(context);
    }

    /* renamed from: d */
    private String m15269d(Context context) {
        try {
            if (this.f19352b.f19514m == null || this.f19352b.f19514m.equals("")) {
                boolean h = bj.m15464a().m15484h(context);
                if (h) {
                    this.f19352b.f19514m = bj.m15464a().m15483g(context);
                }
                if (!h || this.f19352b.f19514m == null || this.f19352b.f19514m.equals("")) {
                    this.f19352b.f19514m = de.m15678a(context, Config.CHANNEL_META_NAME);
                }
            }
        } catch (Throwable e) {
            db.m15659a(e);
        }
        return this.f19352b.f19514m;
    }

    public String getAppKey(Context context) {
        if (this.f19352b.f19507f == null) {
            this.f19352b.f19507f = de.m15678a(context, Config.APPKEY_META_NAME);
        }
        return this.f19352b.f19507f;
    }

    public String getMTJSDKVersion() {
        return "3.7.6.1";
    }

    public int getAppVersionCode(Context context) {
        if (this.f19352b.f19509h == -1) {
            this.f19352b.f19509h = de.m15690e(context);
        }
        return this.f19352b.f19509h;
    }

    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.f19352b.f19510i)) {
            this.f19352b.f19510i = de.m15693f(context);
        }
        return this.f19352b.f19510i;
    }

    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.f19352b.f19515n)) {
            this.f19352b.f19515n = telephonyManager.getNetworkOperator();
        }
        return this.f19352b.f19515n;
    }

    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.f19352b.f19520s)) {
            this.f19352b.f19520s = de.m15704o(context);
        }
        return this.f19352b.f19520s;
    }

    public String getOSVersion() {
        if (TextUtils.isEmpty(this.f19352b.f19504c)) {
            this.f19352b.f19504c = Integer.toString(VERSION.SDK_INT);
        }
        return this.f19352b.f19504c;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.f19352b.f19505d)) {
            this.f19352b.f19505d = VERSION.RELEASE;
        }
        return this.f19352b.f19505d;
    }

    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.f19352b.f19516o)) {
            this.f19352b.f19516o = Build.MODEL;
        }
        return this.f19352b.f19516o;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.f19352b.f19517p)) {
            this.f19352b.f19517p = Build.MANUFACTURER;
        }
        return this.f19352b.f19517p;
    }

    public boolean checkWifiLocationSetting(Context context) {
        return "true".equalsIgnoreCase(de.m15678a(context, Config.GET_WIFI_LOCATION));
    }

    public boolean checkGPSLocationSetting(Context context) {
        return "true".equals(de.m15678a(context, Config.GET_GPS_LOCATION));
    }

    public boolean checkCellLocationSetting(Context context) {
        return "true".equalsIgnoreCase(de.m15678a(context, Config.GET_CELL_LOCATION));
    }

    public String getSecretValue(String str) {
        return ct.m15624c(1, str.getBytes());
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void resetHeadSign() {
        this.f19352b.f19526y = m15264a().getUUID();
    }

    public void enableDeviceMac(Context context, boolean z) {
        bj.m15464a().m15477d(context, z);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return bj.m15464a().m15489m(context);
    }
}
