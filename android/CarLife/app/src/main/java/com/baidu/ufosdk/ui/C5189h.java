package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.h */
final class C5189h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5188g f21666a;

    C5189h(C5188g c5188g) {
        this.f21666a = c5188g;
    }

    public final void run() {
        C5180a.m17569a(this.f21666a.f21665a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            this.f21666a.f21665a.f21435z.obtainMessage(1, null).sendToTarget();
        } else {
            this.f21666a.f21665a.f21435z.obtainMessage(4, null).sendToTarget();
        }
        Context applicationContext = this.f21666a.f21665a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = C5180a.m17574c(applicationContext);
        if (c != null) {
            this.f21666a.f21665a.f21435z.obtainMessage(0, c).sendToTarget();
        }
    }
}
