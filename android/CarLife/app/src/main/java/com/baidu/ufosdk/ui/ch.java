package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FeedbackListActivity */
final class ch implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackListActivity f21616a;
    /* renamed from: b */
    private final /* synthetic */ Context f21617b;
    /* renamed from: c */
    private final /* synthetic */ String f21618c;

    ch(FeedbackListActivity feedbackListActivity, Context context, String str) {
        this.f21616a = feedbackListActivity;
        this.f21617b = context;
        this.f21618c = str;
    }

    public final void onClick(View view) {
        this.f21616a.f21534x.setVisibility(0);
        new Thread(new ci(this, this.f21617b, this.f21618c)).start();
        if (this.f21616a.f21508A.isShowing()) {
            this.f21616a.f21508A.dismiss();
        }
    }
}
