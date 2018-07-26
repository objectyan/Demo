package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.i */
final class C5190i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5188g f21667a;

    C5190i(C5188g c5188g) {
        this.f21667a = c5188g;
    }

    public final void run() {
        Context applicationContext = this.f21667a.f21665a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21667a.f21665a.f21435z.obtainMessage(0, c).sendToTarget();
        }
    }
}
