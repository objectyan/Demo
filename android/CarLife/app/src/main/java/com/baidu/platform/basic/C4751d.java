package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.C2911f;

/* compiled from: SafeRunnable */
/* renamed from: com.baidu.platform.basic.d */
public abstract class C4751d implements Runnable {
    /* renamed from: a */
    public abstract void m15813a();

    public void run() {
        try {
            m15813a();
        } catch (Throwable e) {
            C2911f.c("SafeRunnable", "SafeRunnable run exception", e);
        }
    }
}
