package com.tencent.wxop.stat.p291b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.util.common.SystemAuth;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.b.s */
public class C6150s {
    /* renamed from: a */
    private static String f24966a = "";

    /* renamed from: a */
    public static String m21917a(Context context) {
        try {
            if (C6150s.m21921a(context, SystemAuth.READ_PHONE_STATE_AUTH)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            Log.e(C6132a.f24885m, "Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "get device id error", th);
        }
        return null;
    }

    /* renamed from: a */
    public static String m21918a(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C6139h.m21848b(C6140i.m21850a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "decode error", th);
            return str;
        }
    }

    /* renamed from: a */
    public static JSONArray m21919a(Context context, int i) {
        try {
            if (C6150s.m21921a(context, "android.permission.INTERNET") && C6150s.m21921a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(C1981b.f6365e);
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new C6151t());
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        while (i2 < scanResults.size() && i2 < i) {
                            ScanResult scanResult = (ScanResult) scanResults.get(i2);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bs", scanResult.BSSID);
                            jSONObject.put("ss", scanResult.SSID);
                            jSONArray.put(jSONObject);
                            i2++;
                        }
                        return jSONArray;
                    }
                }
                return null;
            }
            Log.e(C6132a.f24885m, "can not get the permisson of android.permission.INTERNET");
            return null;
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "isWifiNet error", th);
        }
    }

    /* renamed from: a */
    public static void m21920a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e(C6132a.f24885m, "jsonPut error", th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m21921a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "checkPermission error", th);
            return false;
        }
    }

    /* renamed from: b */
    public static String m21922b(Context context) {
        if (C6150s.m21921a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService(C1981b.f6365e);
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Throwable e) {
                Log.e(C6132a.f24885m, "get wifi address error", e);
                return "";
            }
        }
        Log.e(C6132a.f24885m, "Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    /* renamed from: b */
    public static String m21923b(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C6140i.m21852b(C6139h.m21846a(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "encode error", th);
            return str;
        }
    }

    /* renamed from: c */
    public static WifiInfo m21924c(Context context) {
        if (C6150s.m21921a(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(C1981b.f6365e);
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m21925d(Context context) {
        try {
            WifiInfo c = C6150s.m21924c(context);
            if (c != null) {
                return c.getBSSID();
            }
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "encode error", th);
        }
        return null;
    }

    /* renamed from: e */
    public static String m21926e(Context context) {
        try {
            WifiInfo c = C6150s.m21924c(context);
            if (c != null) {
                return c.getSSID();
            }
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "encode error", th);
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m21927f(Context context) {
        try {
            if (C6150s.m21921a(context, "android.permission.INTERNET") && C6150s.m21921a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        return true;
                    }
                    Log.w(C6132a.f24885m, "Network error");
                    return false;
                }
                return false;
            }
            Log.e(C6132a.f24885m, "can not get the permisson of android.permission.INTERNET");
            return false;
        } catch (Throwable th) {
            Log.e(C6132a.f24885m, "isNetworkAvailable error", th);
        }
    }
}
