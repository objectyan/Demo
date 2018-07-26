package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.f */
final class C5187f implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21664a;

    C5187f(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21664a = feedbackFacePageActivity;
    }

    public final void onClick(View view) {
        this.f21664a.m17610a();
        try {
            this.f21664a.overridePendingTransition(C5216i.m17758a(this.f21664a.getApplicationContext(), "ufo_slide_in_from_right"), C5216i.m17758a(this.f21664a.getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e) {
        }
    }
}
