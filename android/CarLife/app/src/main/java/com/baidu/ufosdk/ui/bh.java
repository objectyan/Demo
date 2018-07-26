package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackInputActivity */
final class bh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21574a;

    bh(FeedbackInputActivity feedbackInputActivity) {
        this.f21574a = feedbackInputActivity;
    }

    public final void run() {
        Context applicationContext = this.f21574a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21574a.ak.obtainMessage(0, c).sendToTarget();
        }
    }
}
