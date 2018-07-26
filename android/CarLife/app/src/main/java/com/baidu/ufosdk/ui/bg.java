package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackInputActivity */
final class bg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21573a;

    bg(FeedbackInputActivity feedbackInputActivity) {
        this.f21573a = feedbackInputActivity;
    }

    public final void run() {
        C5180a.m17569a(this.f21573a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            this.f21573a.ak.obtainMessage(1, null).sendToTarget();
        } else {
            this.f21573a.ak.obtainMessage(4, null).sendToTarget();
        }
        Context applicationContext = this.f21573a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21573a.ak.obtainMessage(0, c).sendToTarget();
        }
    }
}
