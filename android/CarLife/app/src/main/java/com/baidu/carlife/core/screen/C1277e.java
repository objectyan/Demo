package com.baidu.carlife.core.screen;

import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;

/* compiled from: OnDialogListener */
/* renamed from: com.baidu.carlife.core.screen.e */
public interface C1277e extends C0689h {
    void cancelDialog();

    void cancelDialog(BaseDialog baseDialog);

    void dismissDialog();

    void dismissDialog(BaseDialog baseDialog);

    boolean isDialogShown();

    void showDialog(BaseDialog baseDialog);

    void showDialog(BaseDialog baseDialog, C1265a c1265a);
}
