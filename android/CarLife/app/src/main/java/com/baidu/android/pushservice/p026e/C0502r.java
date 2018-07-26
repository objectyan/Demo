package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.r */
public class C0502r extends C0487c {
    /* renamed from: d */
    protected String f1623d;

    public C0502r(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1623d = str;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "gunbind");
        hashMap.put("gid", this.f1623d);
    }
}
