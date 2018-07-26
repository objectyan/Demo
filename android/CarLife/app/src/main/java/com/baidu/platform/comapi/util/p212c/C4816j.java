package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.util.C4794a;
import com.baidu.platform.comapi.util.C4799b;

/* compiled from: MacAddressInfo */
/* renamed from: com.baidu.platform.comapi.util.c.j */
public class C4816j implements C4800g {
    /* renamed from: b */
    static final String f19944b = "macid";
    /* renamed from: c */
    static final String f19945c = "mac";
    /* renamed from: a */
    SharedPreferences f19946a;
    /* renamed from: d */
    private String f19947d;
    /* renamed from: e */
    private byte[] f19948e = new byte[]{(byte) 59, (byte) 76, (byte) 55, (byte) 32, (byte) 126, (byte) 33, (byte) 51, (byte) 30, (byte) 117, (byte) 101, (byte) 124, (byte) 124, (byte) 55, (byte) 123, (byte) 52, (byte) 54};

    /* renamed from: a */
    public void mo3723a(Context context) {
        try {
            WifiManager wifi = (WifiManager) context.getSystemService(C1981b.f6365e);
            if (wifi != null) {
                WifiInfo info = wifi.getConnectionInfo();
                if (info != null) {
                    this.f19947d = info.getMacAddress();
                }
            }
        } catch (Exception e) {
            this.f19947d = "";
        }
        if (this.f19946a == null) {
            this.f19946a = context.getSharedPreferences(f19945c, 0);
        }
    }

    /* renamed from: a */
    public String m15985a() {
        if (TextUtils.isEmpty(this.f19947d)) {
            mo3723a(C2907c.f());
        }
        return this.f19947d;
    }

    /* renamed from: c */
    private String m15984c() {
        String macAddr = m15985a();
        if (TextUtils.isEmpty(macAddr)) {
            return "";
        }
        return macAddr.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "");
    }

    /* renamed from: a */
    private String m15983a(String rawValue) {
        String retVal = null;
        try {
            retVal = C4799b.m15938a(C4794a.m15887a(new String(this.f19948e), rawValue.getBytes()));
        } catch (Exception e) {
        }
        return retVal;
    }

    /* renamed from: b */
    public String m15987b() {
        if (TextUtils.isEmpty(this.f19947d) || this.f19946a == null) {
            mo3723a(C2907c.f());
        }
        String localMacId = this.f19946a.getString(f19944b, "");
        if (TextUtils.isEmpty(localMacId)) {
            localMacId = m15983a(m15984c());
            if (!TextUtils.isEmpty(localMacId)) {
                this.f19946a.edit().putString(f19944b, localMacId).commit();
            }
        }
        return localMacId;
    }
}
