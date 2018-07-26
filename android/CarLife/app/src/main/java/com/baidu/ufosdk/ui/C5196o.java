package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.baidu.ufosdk.util.C5215h;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.o */
final class C5196o implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21673a;

    C5196o(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21673a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        if (!C5215h.m17755a()) {
            this.f21673a.f21403B.setVisibility(8);
            this.f21673a.f21404C.setVisibility(8);
            this.f21673a.f21425p.setVisibility(0);
            this.f21673a.f21409H.setVisibility(8);
            this.f21673a.f21406E.setVisibility(0);
            this.f21673a.f21406E.bringToFront();
            this.f21673a.f21402A.setFocusable(false);
            this.f21673a.f21402A.setFocusableInTouchMode(false);
            try {
                this.f21673a.f21433x.clear();
                this.f21673a.f21434y.clear();
                this.f21673a.f21432w.notifyDataSetChanged();
            } catch (Exception e) {
            }
            if (this.f21673a.getCurrentFocus() != null && this.f21673a.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) this.f21673a.getSystemService("input_method")).hideSoftInputFromWindow(this.f21673a.getCurrentFocus().getWindowToken(), 2);
            }
        }
    }
}
