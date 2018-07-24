package com.baidu.carlife.core.screen.presentation.view;

import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.OnDialogCancelListener;
import com.baidu.carlife.core.screen.OnProgressDialogListener;

/* compiled from: CarlifeProgressDialogContainer */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.e */
public class CarlifeProgressDialogContainer implements OnProgressDialogListener {
    /* renamed from: b */
    private static CarlifeProgressDialogContainer f3765b = new CarlifeProgressDialogContainer();
    /* renamed from: a */
    private OnProgressDialogListener f3766a = null;

    /* renamed from: a */
    public static CarlifeProgressDialogContainer m4686a() {
        return f3765b;
    }

    private CarlifeProgressDialogContainer() {
    }

    /* renamed from: a */
    public void m4687a(OnProgressDialogListener listener) {
        this.f3766a = listener;
    }

    /* renamed from: c */
    public void mo1468c() {
        this.f3766a.mo1468c();
    }

    /* renamed from: b */
    public void mo1467b(String msg) {
        this.f3766a.mo1467b(msg);
    }

    /* renamed from: a */
    public void mo1465a(String msg, OnBtnClickListener cancelListener) {
        this.f3766a.mo1465a(msg, cancelListener);
    }

    /* renamed from: a */
    public void mo1466a(String msg, OnBtnClickListener cancelListener, OnDialogCancelListener listener) {
        this.f3766a.mo1466a(msg, cancelListener, listener);
    }

    /* renamed from: d */
    public boolean mo1469d() {
        return this.f3766a.mo1469d();
    }
}
