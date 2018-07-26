package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackListActivity */
final class cu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21633a;

    cu(FeedbackListActivity feedbackListActivity) {
        this.f21633a = feedbackListActivity;
    }

    public final void run() {
        Context applicationContext = this.f21633a.getApplicationContext();
        String str = UfoSDK.clientid;
        C5180a.m17572b(applicationContext);
    }
}
