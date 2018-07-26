package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.u */
final class C5202u implements OnFocusChangeListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21679a;

    C5202u(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21679a = feedbackFacePageActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            new Thread(new C5203v(this)).start();
        }
    }
}
