package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FeedbackInputActivity */
final class bo implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21583a;

    bo(FeedbackInputActivity feedbackInputActivity) {
        this.f21583a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        if (!this.f21583a.ao) {
            if (this.f21583a.f21480X.getVisibility() == 0) {
                this.f21583a.f21480X.setVisibility(8);
                this.f21583a.am.setVisibility(8);
                return;
            }
            this.f21583a.f21480X.setVisibility(0);
            this.f21583a.am.setVisibility(0);
        }
    }
}
