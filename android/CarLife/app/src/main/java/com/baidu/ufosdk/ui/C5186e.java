package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.baidu.ufosdk.UfoSDK;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.e */
final class C5186e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21663a;

    C5186e(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21663a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        this.f21663a.f21429t = true;
        if (!this.f21663a.f21430u) {
            this.f21663a.m17588c();
        } else if (UfoSDK.clientid.length() != 0) {
            this.f21663a.f21403B.setVisibility(8);
            this.f21663a.f21409H.setVisibility(8);
            this.f21663a.f21406E.setVisibility(0);
            this.f21663a.f21402A.setFocusable(false);
            this.f21663a.f21402A.setFocusableInTouchMode(false);
            if (!(this.f21663a.getCurrentFocus() == null || this.f21663a.getCurrentFocus().getWindowToken() == null)) {
                ((InputMethodManager) this.f21663a.getSystemService("input_method")).hideSoftInputFromWindow(this.f21663a.getCurrentFocus().getWindowToken(), 2);
            }
            this.f21663a.f21435z.obtainMessage(2, null).sendToTarget();
            this.f21663a.f21407F.setVisibility(0);
            this.f21663a.f21408G.setText("常用问题");
        }
    }
}
