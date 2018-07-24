package com.baidu.carlife.view.dialog;

import android.app.Dialog;
import android.content.Context;
import com.baidu.carlife.R;

/* compiled from: FixSoftInputDialog */
/* renamed from: com.baidu.carlife.view.dialog.i */
public class C2289i extends Dialog {
    public C2289i(Context context) {
        super(context, R.style.Translucent_NoTitle);
        setContentView(R.layout.dialog_empty_view);
    }

    public void show() {
        super.show();
        dismiss();
    }
}
