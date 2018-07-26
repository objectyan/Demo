package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.n */
public class C0498n extends C0487c {
    /* renamed from: d */
    int f1618d = 1;
    /* renamed from: e */
    int f1619e = 1;
    /* renamed from: f */
    String f1620f;

    public C0498n(C0496l c0496l, Context context, String str, int i, int i2) {
        super(c0496l, context);
        this.f1620f = str;
        this.f1618d = i;
        this.f1619e = i2;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "fetchgmsg");
        hashMap.put("gid", this.f1620f);
        hashMap.put("fetch_type", this.f1618d + "");
        hashMap.put("fetch_num", this.f1619e + "");
    }
}
