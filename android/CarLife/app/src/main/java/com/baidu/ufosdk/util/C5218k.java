package com.baidu.ufosdk.util;

import android.widget.Toast;

/* compiled from: CommonUtil */
/* renamed from: com.baidu.ufosdk.util.k */
final class C5218k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5217j f21709a;
    /* renamed from: b */
    private final /* synthetic */ Toast f21710b;

    C5218k(C5217j c5217j, Toast toast) {
        this.f21709a = c5217j;
        this.f21710b = toast;
    }

    public final void run() {
        this.f21710b.cancel();
    }
}
