package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.o */
public class C0499o extends C0487c {
    /* renamed from: d */
    protected String f1621d;

    public C0499o(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1621d = str;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "gbind");
        hashMap.put("gid", this.f1621d);
    }
}
