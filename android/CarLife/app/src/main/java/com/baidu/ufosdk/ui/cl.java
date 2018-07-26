package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackListActivity */
final class cl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cj f21624a;

    cl(cj cjVar) {
        this.f21624a = cjVar;
    }

    public final void run() {
        Context applicationContext = this.f21624a.f21622a.getApplicationContext();
        String str = UfoSDK.clientid;
        C5180a.m17572b(applicationContext);
    }
}
