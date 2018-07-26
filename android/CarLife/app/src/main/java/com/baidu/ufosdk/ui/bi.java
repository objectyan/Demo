package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;

/* compiled from: FeedbackInputActivity */
final class bi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21575a;
    /* renamed from: b */
    private final /* synthetic */ View f21576b;
    /* renamed from: c */
    private final /* synthetic */ PopupWindow f21577c;

    bi(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.f21575a = feedbackInputActivity;
        this.f21576b = view;
        this.f21577c = popupWindow;
    }

    public final void onClick(View view) {
        ((ClipboardManager) this.f21575a.getSystemService("clipboard")).setText(((TextView) this.f21576b).getText().toString());
        this.f21577c.dismiss();
    }
}
