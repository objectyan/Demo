package com.baidu.carlife.core.screen.presentation.p071a;

import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C1277e;

/* compiled from: CarlifeViewContainer */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.g */
public class C1309g implements C1277e {
    /* renamed from: b */
    private static C1309g f3769b = new C1309g();
    /* renamed from: a */
    private C1308f f3770a;

    /* renamed from: a */
    public static C1309g m4699a() {
        return f3769b;
    }

    private C1309g() {
    }

    /* renamed from: b */
    public C1308f m4701b() {
        return this.f3770a;
    }

    /* renamed from: a */
    public void m4700a(C1308f view) {
        this.f3770a = view;
    }

    public void showDialog(BaseDialog chldView) {
        this.f3770a.showDialog(chldView);
    }

    public void showDialog(BaseDialog chldView, C1265a gravity) {
        this.f3770a.showDialog(chldView, gravity);
    }

    public void dismissDialog() {
        this.f3770a.dismissDialog();
    }

    public void dismissDialog(BaseDialog childView) {
        this.f3770a.dismissDialog(childView);
    }

    public void cancelDialog() {
        this.f3770a.cancelDialog();
    }

    public void cancelDialog(BaseDialog childView) {
        this.f3770a.cancelDialog(childView);
    }

    public boolean isDialogShown() {
        return this.f3770a.isDialogShown();
    }
}
