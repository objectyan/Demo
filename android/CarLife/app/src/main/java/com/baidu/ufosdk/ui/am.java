package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackInputActivity */
final class am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aj f21550a;

    am(aj ajVar) {
        this.f21550a = ajVar;
    }

    public final void run() {
        try {
            Context a = this.f21550a.f21546a;
            String str = UfoSDK.clientid;
            C5180a.m17575c(a, this.f21550a.f21546a.f21469M);
        } catch (Exception e) {
        }
    }
}
