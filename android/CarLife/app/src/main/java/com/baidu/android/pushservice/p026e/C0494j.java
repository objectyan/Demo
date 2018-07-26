package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.j */
public class C0494j extends C0487c {
    /* renamed from: d */
    protected String f1601d;

    public C0494j(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1601d = str;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "deltags");
        hashMap.put("tags", this.f1601d);
    }
}
