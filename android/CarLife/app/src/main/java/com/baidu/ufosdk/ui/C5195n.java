package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.baidu.ufosdk.util.C5215h;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.n */
final class C5195n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21672a;

    C5195n(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21672a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        if (!C5215h.m17755a()) {
            this.f21672a.f21403B.setVisibility(0);
            this.f21672a.f21403B.bringToFront();
            this.f21672a.f21406E.setVisibility(8);
            this.f21672a.f21409H.setVisibility(0);
            this.f21672a.f21402A.setFocusable(true);
            this.f21672a.f21402A.setFocusableInTouchMode(true);
            this.f21672a.f21402A.requestFocus();
            this.f21672a.f21402A.findFocus();
            ((InputMethodManager) this.f21672a.f21402A.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }
}
