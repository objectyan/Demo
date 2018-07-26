package com.indooratlas.android.sdk._internal;

import android.location.Location;
import android.os.Bundle;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navi.protocol.model.UpdateLocationDataStruct;

public final class dq {
    /* renamed from: a */
    public int f23432a;
    /* renamed from: b */
    public String f23433b;
    /* renamed from: c */
    public double f23434c;
    /* renamed from: d */
    public double f23435d;
    /* renamed from: e */
    public float f23436e;
    /* renamed from: f */
    public double f23437f;
    /* renamed from: g */
    public float f23438g;
    /* renamed from: h */
    public float f23439h;
    /* renamed from: i */
    public long f23440i;
    /* renamed from: j */
    public Integer f23441j = null;

    /* renamed from: a */
    public static dq m20349a(Location location) {
        int i = 0;
        String provider = location.getProvider();
        if (provider.equals("gps")) {
            i = -300;
        }
        if (provider.equals(C1981b.f6367g)) {
            i = -301;
        }
        dq dqVar = new dq();
        dqVar.f23432a = i;
        dqVar.f23433b = location.getProvider();
        dqVar.f23434c = location.getLatitude();
        dqVar.f23435d = location.getLongitude();
        dqVar.f23436e = location.getAccuracy();
        dqVar.f23437f = location.getAltitude();
        dqVar.f23438g = location.getBearing();
        dqVar.f23439h = location.getSpeed();
        dqVar.f23440i = location.getTime();
        Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey(UpdateLocationDataStruct.KEY_SATELLITES) && (extras.get(UpdateLocationDataStruct.KEY_SATELLITES) instanceof Integer)) {
            dqVar.f23441j = Integer.valueOf(extras.getInt(UpdateLocationDataStruct.KEY_SATELLITES));
        }
        return dqVar;
    }
}
