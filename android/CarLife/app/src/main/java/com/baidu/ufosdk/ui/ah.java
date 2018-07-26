package com.baidu.ufosdk.ui;

import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackHotActivity */
final class ah implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f21544a;

    ah(ag agVar) {
        this.f21544a = agVar;
    }

    public final void run() {
        this.f21544a.f21543a.finish();
        try {
            this.f21544a.f21543a.overridePendingTransition(C5216i.m17758a(this.f21544a.f21543a.getApplicationContext(), "ufo_slide_in_from_left"), C5216i.m17758a(this.f21544a.f21543a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
        }
    }
}
