package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: FeedbackInputActivity */
final class bl implements OnEditorActionListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21580a;

    bl(FeedbackInputActivity feedbackInputActivity) {
        this.f21580a = feedbackInputActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            FeedbackInputActivity.m17630J(this.f21580a);
        }
        return false;
    }
}
