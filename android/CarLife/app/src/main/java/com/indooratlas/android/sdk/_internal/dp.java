package com.indooratlas.android.sdk._internal;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;

public final class dp implements LocationListener {
    /* renamed from: a */
    private final LocationManager f23427a;
    /* renamed from: b */
    private final String f23428b;
    /* renamed from: c */
    private final cw f23429c;
    /* renamed from: d */
    private final dr f23430d;
    /* renamed from: e */
    private boolean f23431e = false;

    public dp(LocationManager locationManager, String str, cw cwVar, dr drVar) {
        this.f23427a = locationManager;
        this.f23428b = str;
        this.f23429c = cwVar;
        this.f23430d = drVar;
    }

    /* renamed from: a */
    public final void m20348a(int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        if (i2 != i) {
            if (i > 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (i2 <= 0) {
                i5 = 0;
            }
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (i4 != 0) {
            try {
                this.f23427a.removeUpdates(this);
                this.f23431e = false;
            } catch (SecurityException e) {
                ee.m20409a(cz.f23362a, "Could not remove updates dues to security exception for " + this.f23428b, new Object[0]);
            }
        }
        if (i5 != 0) {
            try {
                String str = cz.f23362a;
                this.f23427a.requestLocationUpdates(this.f23428b, (long) i3, 0.0f, this);
                this.f23431e = true;
            } catch (SecurityException e2) {
                ee.m20409a(cz.f23362a, "Could not request updates dues to security exception for " + this.f23428b, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public final cx m20347a() {
        try {
            Location lastKnownLocation = this.f23427a.getLastKnownLocation(this.f23428b);
            if (lastKnownLocation == null) {
                return null;
            }
            cx cxVar = new cx();
            cxVar.f23361d = SystemClock.elapsedRealtime();
            cxVar.f23358a = this.f23429c;
            dq a = dq.m20349a(lastKnownLocation);
            cxVar.f23360c = a;
            cxVar.f23359b = a.f23440i;
            return cxVar;
        } catch (SecurityException e) {
            return null;
        }
    }

    public final void onLocationChanged(Location location) {
        if (this.f23431e) {
            dr drVar = this.f23430d;
            cw cwVar = this.f23429c;
            dq a = dq.m20349a(location);
            cx cxVar = new cx();
            cxVar.f23361d = SystemClock.elapsedRealtime();
            cxVar.f23358a = cwVar;
            cxVar.f23359b = a.f23440i;
            cxVar.f23360c = a;
            drVar.f23442a.m20372a(cxVar);
        }
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }
}
