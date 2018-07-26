package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p023b.C0437f;
import com.baidu.android.pushservice.p032k.C0589e;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.UpdateLocationDataStruct;
import com.baidu.navisdk.ui.ugc.control.UgcOperationActController.UgcPostHttpConstans;
import com.baidu.p034b.p035a.C0648a;
import com.baidu.speech.asr.SpeechConstant;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.j.g */
public class C0568g {
    /* renamed from: a */
    private static int f1859a = 4;

    /* renamed from: a */
    public static String m2437a() {
        try {
            String str = "";
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String str2;
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        str2 = inetAddress.getHostAddress().toString();
                        break;
                    }
                }
                str2 = str;
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int indexOf = str.indexOf(37);
            return indexOf != -1 ? str.substring(0, indexOf) : str;
        } catch (SocketException e) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m2438a(Context context) {
        Object bssid = ((WifiManager) context.getApplicationContext().getSystemService(C1981b.f6365e)).getConnectionInfo().getBSSID();
        if (!TextUtils.isEmpty(bssid)) {
            return bssid;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
            return gsmCellLocation.getCid() + "" + gsmCellLocation.getLac();
        } else if (!(cellLocation instanceof CdmaCellLocation)) {
            return "";
        } else {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
            int baseStationId = cdmaCellLocation.getBaseStationId();
            int networkId = cdmaCellLocation.getNetworkId();
            return baseStationId + "" + networkId + "" + cdmaCellLocation.getSystemId();
        }
    }

    /* renamed from: a */
    public static String m2439a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject.has(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE)) {
                jSONObject2.put("city_code", jSONObject.optString(UgcPostHttpConstans.UGC_POST_HTTP_PARAM_CITYCODE));
            }
            if (jSONObject.has("location")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("location");
                JSONObject jSONObject4 = new JSONObject();
                if (jSONObject3 != null) {
                    jSONObject4.put("latitude", jSONObject3.getString("lat"));
                    jSONObject4.put("longitude", jSONObject3.getString(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG));
                }
                if (jSONObject.has(UpdateLocationDataStruct.KEY_ACCURACY)) {
                    jSONObject4.put(UpdateLocationDataStruct.KEY_ACCURACY, jSONObject.optString(UpdateLocationDataStruct.KEY_ACCURACY));
                }
                jSONObject2.put("location", jSONObject4);
            }
            C0574m.m2470a(context, "com.baidu.android.pushservice.lbscache", jSONObject2.toString());
            return jSONObject2.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m2440a(Context context, boolean z) {
        CharSequence a = PushSettings.m1816a(context);
        if (!TextUtils.isEmpty(a)) {
            CharSequence c = C0568g.m2443c(context);
            if (!TextUtils.isEmpty(c)) {
                if (!z && !C0568g.m2444d(context)) {
                    return null;
                }
                String a2 = C0568g.m2437a();
                C0432b a3 = C0432b.m1870a(context);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                ArrayList arrayList = (ArrayList) a3.f1360a.clone();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!TextUtils.isEmpty(((C0437f) arrayList.get(i)).m1861a())) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("userid", C0578p.m2520a(((C0437f) arrayList.get(i)).f1375f));
                            jSONObject2.put(SpeechConstant.APP_ID, ((C0437f) arrayList.get(i)).m1861a());
                        } catch (Exception e) {
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                if (jSONArray.length() > 0) {
                    try {
                        jSONObject.put("channelid", a);
                        jSONObject.put("cuid", C0589e.m2639a(context));
                        jSONObject.put("nettype", C0578p.m2598t(context.getApplicationContext()));
                        jSONObject.put("clients", jSONArray);
                        jSONObject.put("apinfo", c);
                        jSONObject.put("cip", a2);
                        jSONObject.put("model", Build.MODEL);
                        jSONObject.put("version", VERSION.RELEASE);
                        jSONObject.put("sdkversion", C0430a.m1854a());
                        if (C0578p.m2502F(context)) {
                            jSONObject.put("connect_version", 3);
                        }
                    } catch (JSONException e2) {
                    }
                    return jSONObject.toString();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m2441a(Context context, long j) {
        C0574m.m2467a(context, "com.baidu.pushservice.clt", j);
    }

    /* renamed from: b */
    public static long m2442b(Context context) {
        return context == null ? 0 : C0574m.m2474c(context, "com.baidu.pushservice.clt");
    }

    /* renamed from: c */
    public static String m2443c(Context context) {
        return new C0648a(context.getApplicationContext()).m2827a(f1859a);
    }

    /* renamed from: d */
    private static boolean m2444d(Context context) {
        if (context == null) {
            return false;
        }
        String a = C0568g.m2438a(context);
        CharSequence a2 = C0574m.m2465a(context, "com.baidu.android.pushservice.lac");
        if (!TextUtils.isEmpty(a)) {
            if (TextUtils.equals(a, a2) && System.currentTimeMillis() - C0568g.m2442b(context) < Config.MAX_LOG_DATA_EXSIT_TIME) {
                return false;
            }
            C0574m.m2470a(context, "com.baidu.android.pushservice.lac", a);
        }
        return true;
    }
}
