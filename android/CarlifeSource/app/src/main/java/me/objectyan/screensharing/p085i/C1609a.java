package com.baidu.carlife.p085i;

import android.os.Bundle;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.location.LocationManager;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;

/* compiled from: ExtGPSLocationManager */
/* renamed from: com.baidu.carlife.i.a */
public class C1609a {
    /* renamed from: a */
    public static int f4915a = 1;
    /* renamed from: b */
    private static C1609a f4916b = null;
    /* renamed from: c */
    private boolean f4917c = false;

    /* compiled from: ExtGPSLocationManager */
    /* renamed from: com.baidu.carlife.i.a$a */
    public static class C1608a {
        /* renamed from: a */
        public int f4907a;
        /* renamed from: b */
        public int f4908b;
        /* renamed from: c */
        public int f4909c;
        /* renamed from: d */
        public int f4910d;
        /* renamed from: e */
        public int f4911e;
        /* renamed from: f */
        public int f4912f;
        /* renamed from: g */
        public long f4913g;
        /* renamed from: h */
        public float f4914h;

        public String toString() {
            return super.toString() + "---latitudeE6 = " + this.f4907a + ",longitudeE6 = " + this.f4908b + ",speedE2 = " + this.f4909c + ",accuracy = " + this.f4914h + ",directionE1 = " + this.f4910d + ",altitudeE1 = " + this.f4911e;
        }
    }

    private C1609a() {
    }

    /* renamed from: a */
    public static synchronized C1609a m5871a() {
        C1609a c1609a;
        synchronized (C1609a.class) {
            if (f4916b == null) {
                f4916b = new C1609a();
            }
            c1609a = f4916b;
        }
        return c1609a;
    }

    /* renamed from: b */
    public boolean m5880b() {
        return this.f4917c && CarlifeCoreSDK.m5979a().m5993N();
    }

    /* renamed from: a */
    public void m5878a(boolean useExtGPS) {
        this.f4917c = useExtGPS;
    }

    /* renamed from: c */
    public boolean m5881c() {
        return BNExtGPSLocationManager.getInstance().isGpsEnabled();
    }

    /* renamed from: d */
    public boolean m5882d() {
        return BNExtGPSLocationManager.getInstance().isGpsAvailable();
    }

    /* renamed from: a */
    public static void m5873a(C1608a location) {
        if (f4915a == 2) {
            C1609a.m5876b(location);
        } else {
            C1609a.m5877c(location);
        }
    }

    /* renamed from: b */
    private static void m5876b(C1608a location) {
        try {
            GeoPoint geopt = C1609a.m5872a(((double) location.f4908b) / 1000000.0d, ((double) location.f4907a) / 1000000.0d);
            if (geopt.isValid()) {
                if (BaiduNaviSDKManager.getInstance().isCruiseBegin() || BaiduNaviSDKManager.getInstance().isNaviBegin() || BCruiser.getInstance().isCruiseBegin()) {
                    LocData locData = new LocData();
                    locData.locType = 0;
                    locData.latitude = ((double) geopt.getLatitudeE6()) / 100000.0d;
                    locData.longitude = ((double) geopt.getLongitudeE6()) / 100000.0d;
                    locData.speed = ((float) location.f4909c) / 100.0f;
                    locData.accuracy = Math.min(2000.0f, location.f4914h);
                    locData.direction = ((float) location.f4910d) / 10.0f;
                    if (location.f4912f == 0) {
                        locData.satellitesNum = 5;
                    } else {
                        locData.satellitesNum = location.f4912f;
                    }
                    locData.altitude = (double) (((float) location.f4911e) / 10.0f);
                    locData.time = location.f4913g;
                    LocData gcj02Data = locData.clone();
                    gcj02Data.latitude = ((double) location.f4907a) / 1000000.0d;
                    gcj02Data.longitude = ((double) location.f4908b) / 1000000.0d;
                    C1609a.m5875a(locData, gcj02Data);
                }
                LocationManager.LocData locData2 = new LocationManager.LocData();
                locData2.type = 61;
                locData2.latitude = ((double) location.f4907a) / 1000000.0d;
                locData2.longitude = ((double) location.f4908b) / 1000000.0d;
                locData2.speed = ((float) location.f4909c) / 100.0f;
                locData2.accuracy = Math.min(2000.0f, location.f4914h);
                locData2.direction = ((float) location.f4910d) / 10.0f;
                if (location.f4912f == 0) {
                    locData2.satellitesNum = 5;
                } else {
                    locData2.satellitesNum = location.f4912f;
                }
                locData2.altitude = (double) (((float) location.f4911e) / 10.0f);
                C1609a.m5874a(locData2);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private static void m5877c(C1608a location) {
        try {
            GeoPoint geopt = CoordinateTransformUtil.transferWGS84ToGCJ02(((double) location.f4908b) / 1000000.0d, ((double) location.f4907a) / 1000000.0d);
            if (geopt.isValid()) {
                if (BaiduNaviSDKManager.getInstance().isCruiseBegin() || BaiduNaviSDKManager.getInstance().isNaviBegin() || BCruiser.getInstance().isCruiseBegin()) {
                    LocData locData = new LocData();
                    locData.locType = 0;
                    locData.latitude = ((double) geopt.getLatitudeE6()) / 100000.0d;
                    locData.longitude = ((double) geopt.getLongitudeE6()) / 100000.0d;
                    locData.speed = ((float) location.f4909c) / 100.0f;
                    locData.accuracy = Math.min(2000.0f, location.f4914h);
                    locData.direction = ((float) location.f4910d) / 10.0f;
                    if (location.f4912f == 0) {
                        locData.satellitesNum = 5;
                    } else {
                        locData.satellitesNum = location.f4912f;
                    }
                    locData.altitude = (double) (((float) location.f4911e) / 10.0f);
                    locData.time = location.f4913g;
                    LocData wgs84Data = locData.clone();
                    wgs84Data.latitude = ((double) location.f4907a) / 1000000.0d;
                    wgs84Data.longitude = ((double) location.f4908b) / 1000000.0d;
                    C1609a.m5875a(wgs84Data, locData);
                }
                LocationManager.LocData locData2 = new LocationManager.LocData();
                locData2.type = 61;
                locData2.latitude = ((double) geopt.getLatitudeE6()) / 100000.0d;
                locData2.longitude = ((double) geopt.getLongitudeE6()) / 100000.0d;
                locData2.speed = ((float) location.f4909c) / 100.0f;
                locData2.accuracy = Math.min(2000.0f, location.f4914h);
                locData2.direction = ((float) location.f4910d) / 10.0f;
                if (location.f4912f == 0) {
                    locData2.satellitesNum = 5;
                } else {
                    locData2.satellitesNum = location.f4912f;
                }
                locData2.altitude = (double) (((float) location.f4911e) / 10.0f);
                C1609a.m5874a(locData2);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m5875a(LocData wgsLocData, LocData gcjLocData) {
        BaiduNaviSDKManager.getInstance().updateWGS84Location(wgsLocData, gcjLocData);
    }

    /* renamed from: a */
    public static void m5874a(LocationManager.LocData locData) {
        LocationManager.getInstance().notifiyLocation(locData);
    }

    /* renamed from: b */
    public void m5879b(boolean enabled) {
        BNExtGPSLocationManager.getInstance().updateGpsStatus(enabled);
    }

    /* renamed from: a */
    public static GeoPoint m5872a(double longtitude, double latitude) {
        GeoPoint point = new GeoPoint();
        Bundle bundle = JNITools.GCJ2WGS(longtitude, latitude);
        if (bundle != null) {
            int longtitudeE6 = (int) (bundle.getDouble("LLx") * 100000.0d);
            point.setLatitudeE6((int) (bundle.getDouble("LLy") * 100000.0d));
            point.setLongitudeE6(longtitudeE6);
        }
        return point;
    }
}
