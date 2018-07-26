package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackInputActivity */
final class ap implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ao f21553a;

    ap(ao aoVar) {
        this.f21553a = aoVar;
    }

    public final void run() {
        try {
            C5180a.m17571a(this.f21553a.f21552a.f21469M, "1");
            this.f21553a.f21552a.ak.obtainMessage(7).sendToTarget();
        } catch (Exception e) {
        }
    }
}
