package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackHotActivity */
final class ac implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackHotActivity f21539a;

    ac(FeedbackHotActivity feedbackHotActivity) {
        this.f21539a = feedbackHotActivity;
    }

    public final void onClick(View view) {
        this.f21539a.finish();
        try {
            this.f21539a.overridePendingTransition(C5216i.m17758a(this.f21539a.getApplicationContext(), "ufo_slide_in_from_left"), C5216i.m17758a(this.f21539a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
        }
    }
}
