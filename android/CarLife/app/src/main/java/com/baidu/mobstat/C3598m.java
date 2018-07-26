package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.baidu.mobstat.m */
class C3598m {
    /* renamed from: a */
    static C3598m f19648a = new C3598m();

    C3598m() {
    }

    /* renamed from: a */
    public synchronized void m15751a(Context context) {
        String l = de.m15701l(context);
        if (!TextUtils.isEmpty(l)) {
            C3585y.AP_LIST.m15290a(System.currentTimeMillis(), l);
        }
    }
}
