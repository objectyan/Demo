package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.UfoSDK;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.b */
final class C5183b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21565a;

    C5183b(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21565a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        if (UfoSDK.clientid.length() != 0) {
            this.f21565a.f21435z.obtainMessage(5, null).sendToTarget();
            this.f21565a.f21407F.setVisibility(8);
            this.f21565a.f21408G.setText("全部问题");
        }
    }
}
