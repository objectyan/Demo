package com.baidu.mobstat;

import android.system.Os;

/* renamed from: com.baidu.mobstat.k */
class C3597k {
    /* renamed from: a */
    static boolean m15750a(String str, int i) {
        try {
            Os.chmod(str, i);
            return true;
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return false;
        }
    }
}
