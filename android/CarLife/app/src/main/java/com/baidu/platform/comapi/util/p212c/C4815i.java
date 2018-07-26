package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import android.location.LocationManager;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.platform.comapi.C2907c;

/* compiled from: LocationInfo */
/* renamed from: com.baidu.platform.comapi.util.c.i */
public class C4815i implements C4800g {
    /* renamed from: a */
    private int f19942a = -1;
    /* renamed from: b */
    private int f19943b = -1;

    /* renamed from: a */
    public void mo3723a(Context context) {
        int i = 1;
        try {
            int i2;
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager.isProviderEnabled("gps")) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f19942a = i2;
            if (!locationManager.isProviderEnabled(C1981b.f6367g)) {
                i = 0;
            }
            this.f19943b = i;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public int m15980a() {
        if (this.f19942a == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19942a;
    }

    /* renamed from: b */
    public int m15982b() {
        if (this.f19943b == -1) {
            mo3723a(C2907c.f());
        }
        return this.f19943b;
    }
}
