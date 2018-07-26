package com.baidu.carlife.util;

import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.carlife.core.C1157a;
import com.baidu.navisdk.util.common.PackageUtil;

/* compiled from: CarLifeChannelUtils */
/* renamed from: com.baidu.carlife.util.c */
public class C2172c {
    /* renamed from: a */
    public static final String f6922a = "unknow";
    /* renamed from: b */
    private static C2172c f6923b = new C2172c();

    private C2172c() {
    }

    /* renamed from: a */
    public static C2172c m8222a() {
        return f6923b;
    }

    /* renamed from: b */
    public static String m8223b() {
        String temp = CommonParam.getCUID(C1157a.m3876a());
        return TextUtils.isEmpty(temp) ? "unknow" : temp;
    }

    /* renamed from: c */
    public static String m8224c() {
        String temp = PackageUtil.getChannel();
        return TextUtils.isEmpty(temp) ? "unknow" : temp;
    }
}
