package com.baidu.carlife.util;

import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* compiled from: NaviUtil */
/* renamed from: com.baidu.carlife.util.m */
public class C2183m {
    /* renamed from: a */
    public static final double f6976a = 100000.0d;
    /* renamed from: b */
    private static C2183m f6977b;

    /* compiled from: NaviUtil */
    /* renamed from: com.baidu.carlife.util.m$a */
    public class C2182a {
        /* renamed from: a */
        final /* synthetic */ C2183m f6973a;
        /* renamed from: b */
        private double f6974b;
        /* renamed from: c */
        private double f6975c;

        public C2182a(C2183m this$0, double longitude, double latitude) {
            this.f6973a = this$0;
            this.f6974b = longitude;
            this.f6975c = latitude;
        }

        /* renamed from: a */
        public void m8290a(double longitude) {
            this.f6974b = longitude;
        }

        /* renamed from: a */
        public double m8289a() {
            return this.f6974b;
        }

        /* renamed from: b */
        public void m8292b(double latitude) {
            this.f6975c = latitude;
        }

        /* renamed from: b */
        public double m8291b() {
            return this.f6975c;
        }
    }

    private C2183m() {
    }

    /* renamed from: a */
    public static C2183m m8293a() {
        if (f6977b == null) {
            f6977b = new C2183m();
        }
        return f6977b;
    }

    /* renamed from: b */
    public C2182a m8294b() {
        LocData currentPoint = BNLocationManagerProxy.getInstance().getCurLocation();
        if (currentPoint == null) {
            return null;
        }
        GeoPoint geoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(currentPoint.longitude, currentPoint.latitude);
        return new C2182a(this, ((double) geoPoint.getLongitudeE6()) / 100000.0d, ((double) geoPoint.getLatitudeE6()) / 100000.0d);
    }
}
