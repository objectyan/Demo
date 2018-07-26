package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackListActivity */
final class ck implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cj f21623a;

    ck(cj cjVar) {
        this.f21623a = cjVar;
    }

    public final void run() {
        Context applicationContext = this.f21623a.f21622a.getApplicationContext();
        String str = UfoSDK.clientid;
        C5180a.m17572b(applicationContext);
    }
}
