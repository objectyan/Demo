package com.baidu.android.pushservice.p026e;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.w */
public class C0507w extends C0487c {
    /* renamed from: d */
    protected String f1630d;

    public C0507w(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1630d = str;
    }

    /* renamed from: a */
    protected void mo1285a(Intent intent) {
        super.mo1285a(intent);
        if (intent != null) {
            intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, -1);
        }
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "settags");
        hashMap.put("tags", this.f1630d);
    }

    /* renamed from: b */
    protected String mo1284b(String str) {
        return super.mo1284b(str);
    }
}
