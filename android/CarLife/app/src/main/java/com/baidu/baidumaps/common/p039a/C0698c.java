package com.baidu.baidumaps.common.p039a;

import com.baidu.mapframework.common.beans.BaseEvent;

/* compiled from: ReGeoCurrentCityInfo */
/* renamed from: com.baidu.baidumaps.common.a.c */
public class C0698c extends BaseEvent {
    /* renamed from: a */
    private int f2252a;
    /* renamed from: b */
    private String f2253b;

    public C0698c(int mCityCode, String mCityName) {
        this.f2252a = mCityCode;
        this.f2253b = mCityName;
    }

    /* renamed from: a */
    public int m2949a() {
        return this.f2252a;
    }

    /* renamed from: b */
    public String m2950b() {
        return this.f2253b;
    }
}
