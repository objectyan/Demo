package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.p */
public class C0500p extends C0487c {
    /* renamed from: d */
    protected String f1622d;

    public C0500p(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1622d = str;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "ginfo");
        hashMap.put("gid", this.f1622d);
    }
}
