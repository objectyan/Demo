package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.i */
public class C0493i extends C0487c {
    /* renamed from: d */
    protected String f1600d;

    public C0493i(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1600d = str;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "gmsgcount");
        hashMap.put("gid", this.f1600d);
    }
}
