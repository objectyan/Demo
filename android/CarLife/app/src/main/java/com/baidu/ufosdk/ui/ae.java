package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackHotActivity */
final class ae implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackHotActivity f21541a;

    ae(FeedbackHotActivity feedbackHotActivity) {
        this.f21541a = feedbackHotActivity;
    }

    public final void run() {
        C5180a.m17569a(this.f21541a.getApplicationContext());
        Context applicationContext = this.f21541a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21541a.f21452q.obtainMessage(0, c).sendToTarget();
        }
        this.f21541a.m17612a();
    }
}
