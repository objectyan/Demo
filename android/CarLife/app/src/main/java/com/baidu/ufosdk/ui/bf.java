package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackInputActivity */
final class bf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21572a;

    bf(FeedbackInputActivity feedbackInputActivity) {
        this.f21572a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        if (!this.f21572a.ao) {
            this.f21572a.f21482Z = ((Integer) view.getTag()).intValue();
            if (C5216i.m17756a() >= 23) {
                C5210c.m17736d(" CommonUtil.getAPILevel() >= 23 ");
            }
            FeedbackInputActivity.m17639S(this.f21572a);
        }
    }
}
