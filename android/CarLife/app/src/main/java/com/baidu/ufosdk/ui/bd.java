package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.C5223p;

/* compiled from: FeedbackInputActivity */
final class bd implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21570a;

    bd(FeedbackInputActivity feedbackInputActivity) {
        this.f21570a = feedbackInputActivity;
    }

    public final void onClick(View view) {
        if (!this.f21570a.ao) {
            this.f21570a.f21481Y.remove(((Integer) view.getTag()).intValue());
            if (this.f21570a.f21481Y.size() == 1) {
                Object a = C5223p.m17782a(this.f21570a.getApplicationContext());
                if (a != null) {
                    this.f21570a.f21481Y.set(0, a);
                } else {
                    return;
                }
            }
            this.f21570a.m17653b();
        }
    }
}
