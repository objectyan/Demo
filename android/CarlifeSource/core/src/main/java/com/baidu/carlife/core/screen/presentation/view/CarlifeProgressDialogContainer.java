package com.baidu.carlife.core.screen.presentation.view;

import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.OnDialogCancelListener;
import com.baidu.carlife.core.screen.OnProgressDialogListener;

/* compiled from: CarlifeProgressDialogContainer */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.e */
public class CarlifeProgressDialogContainer implements OnProgressDialogListener {
    /* renamed from: b */
    private static CarlifeProgressDialogContainer sCarlifeProgressDialogContainer = new CarlifeProgressDialogContainer();
    /* renamed from: a */
    private OnProgressDialogListener mOnProgressDialogListener = null;

    /* renamed from: a */
    public static CarlifeProgressDialogContainer newInstance() {
        return sCarlifeProgressDialogContainer;
    }

    private CarlifeProgressDialogContainer() {
    }

    /* renamed from: a */
    public void initOnProgressDialogListener(OnProgressDialogListener listener) {
        this.mOnProgressDialogListener = listener;
    }

    /* renamed from: c */
    public void mo1468c() {
        this.mOnProgressDialogListener.mo1468c();
    }

    /* renamed from: b */
    public void mo1467b(String msg) {
        this.mOnProgressDialogListener.mo1467b(msg);
    }

    /* renamed from: a */
    public void mo1465a(String msg, OnBtnClickListener cancelListener) {
        this.mOnProgressDialogListener.mo1465a(msg, cancelListener);
    }

    /* renamed from: a */
    public void mo1466a(String msg, OnBtnClickListener cancelListener, OnDialogCancelListener listener) {
        this.mOnProgressDialogListener.mo1466a(msg, cancelListener, listener);
    }

    /* renamed from: d */
    public boolean mo1469d() {
        return this.mOnProgressDialogListener.mo1469d();
    }
}
