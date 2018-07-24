package com.baidu.carlife.core.screen.presentation.view;

import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.OnDialogListener;

/* compiled from: CarlifeViewContainer */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.g */
public class CarlifeViewContainer implements OnDialogListener {
    /* renamed from: b */
    private static CarlifeViewContainer f3769b = new CarlifeViewContainer();
    /* renamed from: a */
    private CarlifeView f3770a;

    /* renamed from: a */
    public static CarlifeViewContainer m4699a() {
        return f3769b;
    }

    private CarlifeViewContainer() {
    }

    /* renamed from: b */
    public CarlifeView m4701b() {
        return this.f3770a;
    }

    /* renamed from: a */
    public void m4700a(CarlifeView view) {
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
