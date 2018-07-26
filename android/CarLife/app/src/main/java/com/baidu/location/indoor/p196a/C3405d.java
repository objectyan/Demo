package com.baidu.location.indoor.p196a;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.IARegion.Listener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.baidu.location.indoor.a.d */
class C3405d implements IALocationListener, Listener {
    /* renamed from: a */
    private C3404c f18448a;
    /* renamed from: b */
    private String f18449b = null;

    C3405d(C3404c c3404c) {
        this.f18448a = c3404c;
    }

    public void onEnterRegion(IARegion iARegion) {
        if (iARegion != null && iARegion.getType() == 1) {
            this.f18449b = iARegion.getName().toLowerCase(Locale.US);
        }
    }

    public void onExitRegion(IARegion iARegion) {
    }

    public void onLocationChanged(IALocation iALocation) {
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLocType(161);
        bDLocation.setNetworkLocationType("ml");
        bDLocation.setBuildingID(this.f18448a.m14509f());
        bDLocation.setFloor(this.f18448a.m14510g());
        if (!(this.f18449b == null || this.f18448a.m14510g() == null || this.f18449b.equals(this.f18448a.m14510g()))) {
            bDLocation.setFloor(this.f18449b);
        }
        bDLocation.setLongitude(iALocation.getLongitude());
        bDLocation.setLatitude(iALocation.getLatitude());
        bDLocation.setRadius(iALocation.getAccuracy());
        bDLocation.setIndoorLocMode(true);
        bDLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
        this.f18448a.m14503a(bDLocation);
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        switch (i) {
            case 2:
                this.f18449b = null;
                return;
            case 11:
                String str2 = "unknown";
                switch (bundle.getInt("quality")) {
                    case 0:
                        str2 = "Poor";
                        return;
                    case 1:
                        str2 = "Good";
                        return;
                    case 2:
                        str2 = "Excellent";
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }
}
