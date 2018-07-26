package com.baidu.ufosdk.ui;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.a */
final class C5182a implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21536a;

    C5182a(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21536a = feedbackFacePageActivity;
    }

    public final void run() {
        String editable = this.f21536a.f21402A.getText().toString();
        this.f21536a.f21434y.clear();
        FeedbackFacePageActivity.m17580a(this.f21536a, this.f21536a.f21434y, editable);
        this.f21536a.f21432w.notifyDataSetChanged();
        if (this.f21536a.f21434y.size() == 0) {
            this.f21536a.f21404C.setVisibility(0);
            this.f21536a.f21425p.setVisibility(8);
            editable = "未检索到 “" + editable + "” 相关问题信息\n请重新搜索或向我们直接反馈\n\n\n\n";
            CharSequence spannableStringBuilder = new SpannableStringBuilder(editable);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-11821318), editable.length() - 8, editable.length() - 4, 33);
            this.f21536a.f21404C.setText(spannableStringBuilder);
            this.f21536a.f21404C.bringToFront();
            return;
        }
        this.f21536a.f21404C.setVisibility(8);
        this.f21536a.f21425p.setVisibility(0);
    }
}
