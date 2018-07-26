package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackListActivity */
final class cp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cn f21628a;

    cp(cn cnVar) {
        this.f21628a = cnVar;
    }

    public final void run() {
        Context applicationContext = this.f21628a.f21626a.getApplicationContext();
        String str = UfoSDK.clientid;
        C5180a.m17572b(applicationContext);
    }
}
