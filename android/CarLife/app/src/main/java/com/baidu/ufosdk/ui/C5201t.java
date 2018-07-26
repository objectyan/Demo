package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.baidu.ufosdk.util.C5228u;

/* compiled from: FeedbackFacePageActivity */
/* renamed from: com.baidu.ufosdk.ui.t */
final class C5201t implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ FeedbackFacePageActivity f21678a;

    C5201t(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f21678a = feedbackFacePageActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        String editable2 = this.f21678a.f21402A.getText().toString();
        if (editable2.length() > 10) {
            editable2 = editable2.substring(0, 10);
            this.f21678a.f21402A.setText(editable2.substring(0, 10));
            this.f21678a.f21402A.setSelection(editable2.length());
            Toast makeText = Toast.makeText(this.f21678a, C5228u.m17794a("32"), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (this.f21678a.f21433x != null && this.f21678a.f21433x.size() != 0) {
            this.f21678a.f21435z.post(this.f21678a.f21410a);
        }
    }
}
