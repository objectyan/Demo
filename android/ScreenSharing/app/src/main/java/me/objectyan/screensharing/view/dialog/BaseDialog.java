package com.baidu.carlife.view.dialog;

import android.content.Context;
import android.util.AttributeSet;

import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.p078f.C1440d;

public abstract class BaseDialog extends com.baidu.carlife.core.screen.BaseDialog {
    /* renamed from: e */
    private C0770k f3941e;

    /* renamed from: com.baidu.carlife.view.dialog.BaseDialog$1 */
    class C22571 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BaseDialog f7369a;

        C22571(BaseDialog this$0) {
            this.f7369a = this$0;
        }

        public void run() {
            if (!this.f7369a.d) {
                C1440d.m5251a().m5267g();
                this.f7369a.mo1530f();
            }
        }
    }

    public BaseDialog(Context context) {
        this(context, null);
    }

    public BaseDialog(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDialogShowHideListener(C0770k listener) {
        this.f3941e = listener;
    }

    /* renamed from: a */
    public void mo1525a(OnDialogListener listener) {
        super.mo1525a(listener);
        C1440d.m5251a().m5265f();
        this.b.postDelayed(new C22571(this), 100);
        if (this.f3941e != null) {
            this.f3941e.onShow();
        }
    }

    /* renamed from: d */
    public void mo1526d() {
        super.mo1526d();
        C1440d.m5251a().m5271j();
        if (this.f3941e != null) {
            this.f3941e.onDismiss();
        }
    }

    /* renamed from: g */
    public void mo1527g() {
        super.mo1527g();
        C1440d.m5251a().m5263e();
    }

    /* renamed from: a */
    public boolean mo1802a(String strCommand) {
        return false;
    }
}
