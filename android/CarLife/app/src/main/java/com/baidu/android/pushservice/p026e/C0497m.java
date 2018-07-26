package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.m */
public class C0497m extends C0487c {
    /* renamed from: d */
    int f1616d = 1;
    /* renamed from: e */
    int f1617e = 1;

    public C0497m(C0496l c0496l, Context context, int i, int i2) {
        super(c0496l, context);
        this.f1616d = i;
        this.f1617e = i2;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "fetch");
        hashMap.put("fetch_type", this.f1616d + "");
        hashMap.put("fetch_num", this.f1617e + "");
    }
}
