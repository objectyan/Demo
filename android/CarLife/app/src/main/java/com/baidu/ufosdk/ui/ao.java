package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.concurrent.Executors;

/* compiled from: FeedbackInputActivity */
final class ao implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21552a;

    ao(FeedbackInputActivity feedbackInputActivity) {
        this.f21552a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        this.f21552a.as.setVisibility(8);
        this.f21552a.ag = true;
        this.f21552a.af = false;
        this.f21552a.f21475S = Executors.newSingleThreadExecutor();
        this.f21552a.f21475S.execute(new ap(this));
    }
}
