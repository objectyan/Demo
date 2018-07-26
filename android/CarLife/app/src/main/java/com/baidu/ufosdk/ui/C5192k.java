package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.k */
final class C5192k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21669a;

    C5192k(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21669a = feedbackFacePageActivity;
    }

    public final void run() {
        Context applicationContext = this.f21669a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21669a.f21435z.obtainMessage(0, c).sendToTarget();
        }
    }
}
