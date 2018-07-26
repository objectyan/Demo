package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackInputActivity */
final class as implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21556a;

    as(FeedbackInputActivity feedbackInputActivity) {
        this.f21556a = feedbackInputActivity;
    }

    public final void run() {
        String e = C5180a.m17577e(this.f21556a.getApplicationContext(), this.f21556a.f21468L);
        if (e != null && e.length() != 0) {
            this.f21556a.ak.obtainMessage(5, e).sendToTarget();
        }
    }
}
