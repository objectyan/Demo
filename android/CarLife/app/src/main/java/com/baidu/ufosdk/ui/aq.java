package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.concurrent.Executors;

/* compiled from: FeedbackInputActivity */
final class aq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21554a;

    aq(FeedbackInputActivity feedbackInputActivity) {
        this.f21554a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        this.f21554a.as.setVisibility(8);
        this.f21554a.ag = true;
        this.f21554a.af = false;
        this.f21554a.f21475S = Executors.newSingleThreadExecutor();
        this.f21554a.f21475S.execute(new ar(this));
        this.f21554a.ak.obtainMessage(8).sendToTarget();
    }
}
