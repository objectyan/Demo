package com.baidu.baidumaps.p041e;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.platform.comapi.util.SysOSAPIv2;

/* compiled from: PromoteParamType */
/* renamed from: com.baidu.baidumaps.e.a */
public class C0703a {
    /* renamed from: a */
    public static final int f2265a = 0;
    /* renamed from: b */
    public static final String f2266b = " baidumap_ANDR";

    /* renamed from: a */
    public static int m2951a() {
        if (LocationManager.getInstance().isLocationValid()) {
            return (int) LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09).longitude;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m2952b() {
        if (LocationManager.getInstance().isLocationValid()) {
            return (int) LocationManager.getInstance().getCurLocation(CoordType.CoordType_BD09).latitude;
        }
        return 0;
    }

    /* renamed from: c */
    public static int m2953c() {
        int i = NavMapAdapter.getInstance().getCurrentLocalCityId();
        if (i == 1) {
            return 0;
        }
        return i;
    }

    /* renamed from: d */
    public static String m2954d() {
        return SysOSAPIv2.getInstance().getOSVersion();
    }

    /* renamed from: e */
    public static String m2955e() {
        return SysOSAPIv2.getInstance().getPhoneType();
    }

    /* renamed from: f */
    public static String m2956f() {
        return SysOSAPIv2.getInstance().getOSVersion();
    }

    /* renamed from: g */
    public static String m2957g() {
        return SysOSAPIv2.getInstance().getVersionName();
    }

    /* renamed from: h */
    public static String m2958h() {
        return String.valueOf(SysOSAPIv2.getInstance().getXDpi());
    }

    /* renamed from: i */
    public static String m2959i() {
        return String.valueOf(SysOSAPIv2.getInstance().getYDpi());
    }

    /* renamed from: j */
    public static String m2960j() {
        return SysOSAPIv2.getInstance().getNetType();
    }

    /* renamed from: k */
    public static String m2961k() {
        return f2266b;
    }
}
