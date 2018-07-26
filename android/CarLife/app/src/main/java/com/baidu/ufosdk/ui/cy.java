package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: InputContactDialog */
final class cy implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ cx f21653a;

    cy(cx cxVar) {
        this.f21653a = cxVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        String editable2 = this.f21653a.f21651j.getText().toString();
        if (editable2.length() > 200) {
            editable2 = editable2.substring(0, 200);
            this.f21653a.f21651j.setText(editable2.substring(0, 200));
            this.f21653a.f21651j.setSelection(editable2.length());
        }
    }
}
