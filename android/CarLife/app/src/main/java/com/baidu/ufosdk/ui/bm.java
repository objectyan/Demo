package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.ufosdk.C5167a;
import com.baidu.ufosdk.util.C5211d;
import com.baidu.ufosdk.util.C5216i;

/* compiled from: FeedbackInputActivity */
final class bm implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ FeedbackInputActivity f21581a;

    bm(FeedbackInputActivity feedbackInputActivity) {
        this.f21581a = feedbackInputActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f21581a.ap.getText().toString().trim().length() <= 0) {
            this.f21581a.f21486f = 0;
        } else {
            this.f21581a.f21486f = 1;
        }
    }

    public final void afterTextChanged(Editable editable) {
        if (!this.f21581a.ai) {
            C5211d c5211d = new C5211d(this.f21581a);
            c5211d.m17742b(c5211d.m17741b() + 1);
            this.f21581a.ai = true;
        }
        switch (this.f21581a.f21486f) {
            case 0:
                if (this.f21581a.ap.getText().toString().trim().length() > 0) {
                    this.f21581a.av.setTextColor(C5216i.m17759a(C5167a.f21377w, C5167a.f21378x, C5167a.f21377w, C5167a.f21377w));
                    return;
                }
                return;
            case 1:
                if (this.f21581a.ap.getText().toString().trim().length() <= 0) {
                    this.f21581a.av.setTextColor(C5167a.f21378x);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
