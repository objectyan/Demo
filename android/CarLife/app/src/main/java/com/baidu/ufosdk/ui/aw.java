package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.p251e.C5180a;

/* compiled from: FeedbackInputActivity */
final class aw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ av f21560a;

    aw(av avVar) {
        this.f21560a = avVar;
    }

    public final void run() {
        try {
            String e = C5180a.m17577e(this.f21560a.f21559a.getApplicationContext(), this.f21560a.f21559a.f21468L);
            if (e != null && e.length() != 0) {
                this.f21560a.f21559a.ak.obtainMessage(5, e).sendToTarget();
            }
        } catch (Exception e2) {
        }
    }
}
