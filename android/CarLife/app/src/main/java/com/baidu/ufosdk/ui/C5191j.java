package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.j */
final class C5191j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21668a;

    C5191j(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21668a = feedbackFacePageActivity;
    }

    public final void run() {
        C5180a.m17569a(this.f21668a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            this.f21668a.f21435z.obtainMessage(1, null).sendToTarget();
        } else {
            this.f21668a.f21435z.obtainMessage(4, null).sendToTarget();
        }
        Context applicationContext = this.f21668a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21668a.f21435z.obtainMessage(0, c).sendToTarget();
        }
    }
}
