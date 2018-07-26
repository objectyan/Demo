package com.indooratlas.android.sdk._internal;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk._internal.ew.C5876a;
import com.indooratlas.android.sdk._internal.ey.C5878a;
import com.indooratlas.android.sdk._internal.ey.C5879b;
import com.indooratlas.android.sdk._internal.fc.C5889a;
import com.indooratlas.android.sdk._internal.fc.C5891c;

public final class cp {
    /* renamed from: a */
    static final /* synthetic */ boolean f23345a = (!cp.class.desiredAssertionStatus());

    private cp() {
    }

    /* renamed from: a */
    public static final String m20238a(int i) {
        switch (i) {
            case 0:
                return "UNKNOWN";
            case 1:
                return "POSITIONING";
            case 2:
                return "REST_OVER_WS";
            case 3:
                return "SYSTEM";
            case 4:
                return "EVENTS";
            default:
                return String.valueOf(i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final java.lang.String m20239a(int r1, int r2) {
        /*
        switch(r1) {
            case 0: goto L_0x0008;
            case 1: goto L_0x0015;
            case 2: goto L_0x000f;
            case 3: goto L_0x000c;
            case 4: goto L_0x0012;
            default: goto L_0x0003;
        };
    L_0x0003:
        r0 = java.lang.String.valueOf(r2);
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = "UNKNOWN";
        goto L_0x0007;
    L_0x000c:
        switch(r2) {
            case 0: goto L_0x0021;
            case 1: goto L_0x001d;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r2) {
            case 0: goto L_0x0031;
            case 1: goto L_0x0029;
            case 2: goto L_0x002d;
            case 3: goto L_0x0025;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r2) {
            case 0: goto L_0x0035;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r2) {
            case 0: goto L_0x0019;
            case 1: goto L_0x0055;
            case 2: goto L_0x0041;
            case 3: goto L_0x0059;
            case 4: goto L_0x0039;
            case 5: goto L_0x0051;
            case 6: goto L_0x003d;
            case 7: goto L_0x004d;
            case 8: goto L_0x0049;
            case 9: goto L_0x0045;
            default: goto L_0x0018;
        };
    L_0x0018:
        goto L_0x0003;
    L_0x0019:
        r0 = "UNKNOWN";
        goto L_0x0007;
    L_0x001d:
        r0 = "COMPONENT_ERROR";
        goto L_0x0007;
    L_0x0021:
        r0 = "UNKNOWN";
        goto L_0x0007;
    L_0x0025:
        r0 = "REST_ERROR";
        goto L_0x0007;
    L_0x0029:
        r0 = "REST_REQUEST";
        goto L_0x0007;
    L_0x002d:
        r0 = "REST_RESPONSE";
        goto L_0x0007;
    L_0x0031:
        r0 = "UNKNOWN";
        goto L_0x0007;
    L_0x0035:
        r0 = "METRICS";
        goto L_0x0007;
    L_0x0039:
        r0 = "ALTER";
        goto L_0x0007;
    L_0x003d:
        r0 = "ERROR";
        goto L_0x0007;
    L_0x0041:
        r0 = "INPUT";
        goto L_0x0007;
    L_0x0045:
        r0 = "INPUT_SERVER_MODE";
        goto L_0x0007;
    L_0x0049:
        r0 = "STATE";
        goto L_0x0007;
    L_0x004d:
        r0 = "STATE_REQUEST";
        goto L_0x0007;
    L_0x0051:
        r0 = "OUTPUT";
        goto L_0x0007;
    L_0x0055:
        r0 = "SETUP";
        goto L_0x0007;
    L_0x0059:
        r0 = "STOP";
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.cp.a(int, int):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m20240a(C5891c c5891c) {
        return (c5891c == null || c5891c.f23625b == null || c5891c.f23625b.f23623b == null) ? false : true;
    }

    /* renamed from: a */
    public static IARegion m20236a(C5889a c5889a, long j) {
        if (c5889a == null) {
            return null;
        }
        if (c5889a.f23622b != null) {
            C5876a c5876a = c5889a.f23622b;
            if (!TextUtils.isEmpty(c5876a.f23569d)) {
                switch (c5876a.f23568b) {
                    case 1:
                        return new IARegion(1, j, c5876a.f23569d, c5876a.f23570e);
                    case 2:
                        return new IARegion(2, j, c5876a.f23569d, c5876a.f23570e);
                    default:
                        Object[] objArr = new Object[]{Integer.valueOf(c5876a.f23568b), c5876a.f23569d};
                        break;
                }
            }
            return IARegion.unknown();
        }
        return IARegion.unknown();
    }

    /* renamed from: a */
    public static C5879b[] m20241a(IALocation... iALocationArr) {
        if (iALocationArr == null) {
            return null;
        }
        C5879b[] c5879bArr = new C5879b[iALocationArr.length];
        for (int i = 0; i < iALocationArr.length; i++) {
            IALocation iALocation = iALocationArr[i];
            C5879b c5879b = new C5879b();
            if (iALocation.hasFloorLevel()) {
                c5879b.f23592k = new C5935h();
                c5879b.f23592k.f24067b = iALocation.getFloorLevel();
            }
            Location toLocation = iALocation.toLocation();
            if (toLocation.hasAccuracy()) {
                c5879b.f23587f = toLocation.getAccuracy();
            }
            if (toLocation.hasAltitude()) {
                c5879b.f23588g = new C5915g();
                c5879b.f23588g.f23832b = (float) toLocation.getAltitude();
            }
            if (toLocation.hasBearing()) {
                c5879b.f23590i = toLocation.getBearing();
            }
            if (toLocation.hasSpeed()) {
                c5879b.f23589h = new C5915g();
                c5879b.f23589h.f23832b = toLocation.getSpeed();
            }
            if (!(toLocation.getLatitude() == 0.0d && toLocation.getLongitude() == 0.0d)) {
                c5879b.f23584b = new C5878a();
                c5879b.f23584b.f23581b = toLocation.getLatitude();
                c5879b.f23584b.f23582d = toLocation.getLongitude();
            }
            c5879b.f23586e = toLocation.getTime();
            Bundle extras = toLocation.getExtras();
            if (extras != null && extras.containsKey("com.indooratlas.android.sdk.intent.extras.clientTime")) {
                c5879b.f23585d = extras.getLong("com.indooratlas.android.sdk.intent.extras.clientTime");
            }
            if (extras != null && extras.containsKey("com.indooratlas.android.sdk.intent.extras.satelliteCount")) {
                c5879b.f23593l = new C5935h();
                c5879b.f23593l.f24067b = extras.getInt("com.indooratlas.android.sdk.intent.extras.satelliteCount");
            }
            String provider = toLocation.getProvider();
            if ("IndoorAtlas".equals(provider)) {
                c5879b.f23591j = 0;
            } else if ("gps".equals(provider)) {
                c5879b.f23591j = 4;
            } else if (C1981b.f6367g.equals(provider)) {
                c5879b.f23591j = 5;
            } else if ("passive".equals(provider)) {
                c5879b.f23591j = 1;
            } else if ("fused".equalsIgnoreCase(provider)) {
                c5879b.f23591j = 1;
            } else if ("com.indooratlas.android.sdk.intent.extras.groundTruth".equals(provider)) {
                c5879b.f23591j = 3;
            } else if ("com.indooratlas.android.sdk.intent.extras.userInput".equals(provider)) {
                c5879b.f23591j = 2;
            } else {
                ee.m20409a("IACore", "Unknown provider in IALocation: " + provider, new Object[0]);
                c5879b.f23591j = 2;
            }
            c5879bArr[i] = c5879b;
        }
        return c5879bArr;
    }

    /* renamed from: a */
    public static C5876a m20237a(IARegion iARegion) {
        if (iARegion == null) {
            return null;
        }
        C5876a c5876a = new C5876a();
        c5876a.f23569d = iARegion.getId();
        switch (iARegion.getType()) {
            case 1:
                c5876a.f23568b = 1;
                break;
            case 2:
                c5876a.f23568b = 2;
                break;
            default:
                return null;
        }
        return c5876a;
    }
}
