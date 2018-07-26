package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackHotActivity */
final class ab extends Handler {
    /* renamed from: a */
    final /* synthetic */ FeedbackHotActivity f21538a;

    ab(FeedbackHotActivity feedbackHotActivity) {
        this.f21538a = feedbackHotActivity;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 3 && this.f21538a.f21444i.getProgress() < 100) {
            this.f21538a.f21444i.stopLoading();
            this.f21538a.f21446k.setVisibility(8);
            C5216i.m17762a(this.f21538a.getApplicationContext(), this.f21538a.f21447l);
            this.f21538a.f21442g.setVisibility(0);
            this.f21538a.f21444i.setVisibility(8);
        }
    }
}
