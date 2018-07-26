package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackListActivity */
final class cm implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21625a;

    cm(FeedbackListActivity feedbackListActivity) {
        this.f21625a = feedbackListActivity;
    }

    public final void onClick(View view) {
        this.f21625a.finish();
        try {
            this.f21625a.overridePendingTransition(C5216i.m17758a(this.f21625a.getApplicationContext(), "ufo_slide_in_from_left"), C5216i.m17758a(this.f21625a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
        }
    }
}
