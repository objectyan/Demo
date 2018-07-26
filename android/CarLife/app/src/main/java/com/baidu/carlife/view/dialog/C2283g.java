package com.baidu.carlife.view.dialog;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;

/* compiled from: EmptyDialog */
/* renamed from: com.baidu.carlife.view.dialog.g */
public class C2283g extends C1953c {
    public C2283g(Context context) {
        super(context);
    }

    /* renamed from: f */
    public void mo1530f() {
        C1443g mFocusDialogDown = new C1443g(findViewById(C0965R.id.bottom_bar), 11);
        mFocusDialogDown.m5300d(getmFirstBtn()).m5300d(getmSecondBtn());
        mFocusDialogDown.m5244a(true);
        mFocusDialogDown.m5298b(true);
        mFocusDialogDown.m5297b(getmFirstBtn());
        C1440d.m5251a().m5253a(mFocusDialogDown);
    }
}
