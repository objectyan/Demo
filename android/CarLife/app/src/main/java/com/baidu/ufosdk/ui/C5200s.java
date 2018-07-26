package com.baidu.ufosdk.ui;

import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.s */
final class C5200s implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21677a;

    C5200s(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21677a = feedbackFacePageActivity;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        try {
            if (this.f21677a.getCurrentFocus() != null && this.f21677a.getCurrentFocus().getWindowToken() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f21677a.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f21677a.getCurrentFocus().getWindowToken(), 2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
