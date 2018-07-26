package com.baidu.carlife.wechat.p110e;

/* compiled from: CommonUrl */
/* renamed from: com.baidu.carlife.wechat.e.a */
public class C2418a {
    /* renamed from: a */
    private static final String f7971a = "http://api.map.baidu.com/geocoder/v2/?output=json&coordtype=gcj02ll&pois=0&ak=A3d07d115c18359fe9545517a5321727&location={location}";

    /* renamed from: a */
    public static final String m9251a(String lat, String lng) {
        return f7971a.replace("{location}", lat + "," + lng);
    }
}
