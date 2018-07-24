package com.baidu.carlife.core.screen;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;

/* compiled from: OnDialogListener */
/* renamed from: com.baidu.carlife.core.screen.e */
public interface OnDialogListener extends KeepClass {
    void cancelDialog();

    void cancelDialog(BaseDialog baseDialog);

    void dismissDialog();

    void dismissDialog(BaseDialog baseDialog);

    boolean isDialogShown();

    void showDialog(BaseDialog baseDialog);

    void showDialog(BaseDialog baseDialog, C1265a c1265a);
}
