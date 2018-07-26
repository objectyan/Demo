package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.concurrent.Executors;

/* compiled from: FeedbackInputActivity */
final class av implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21559a;

    av(FeedbackInputActivity feedbackInputActivity) {
        this.f21559a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        try {
            this.f21559a.f21461E.setVisibility(8);
            this.f21559a.f21474R.setVisibility(0);
            if (this.f21559a.f21468L != null && this.f21559a.f21468L.length() > 0) {
                this.f21559a.f21475S = Executors.newSingleThreadExecutor();
                this.f21559a.f21475S.execute(new aw(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
