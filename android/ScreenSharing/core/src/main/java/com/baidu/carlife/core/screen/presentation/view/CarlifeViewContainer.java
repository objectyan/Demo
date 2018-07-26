package com.baidu.carlife.core.screen.presentation.view;

import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.OnDialogListener;

/* compiled from: CarlifeViewContainer */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.g */
public class CarlifeViewContainer implements OnDialogListener {
    /* renamed from: b */
    private static CarlifeViewContainer sCarlifeViewContainer = new CarlifeViewContainer();
    /* renamed from: a */
    private CarlifeView mCarlifeView;

    /* renamed from: a */
    public static CarlifeViewContainer newInstance() {
        return sCarlifeViewContainer;
    }

    private CarlifeViewContainer() {
    }

    /* renamed from: b */
    public CarlifeView getCarlifeView() {
        return this.mCarlifeView;
    }

    /* renamed from: a */
    public void setCarlifeView(CarlifeView view) {
        this.mCarlifeView = view;
    }

    public void showDialog(BaseDialog chldView) {
        this.mCarlifeView.showDialog(chldView);
    }

    public void showDialog(BaseDialog chldView, C1265a gravity) {
        this.mCarlifeView.showDialog(chldView, gravity);
    }

    public void dismissDialog() {
        this.mCarlifeView.dismissDialog();
    }

    public void dismissDialog(BaseDialog childView) {
        this.mCarlifeView.dismissDialog(childView);
    }

    public void cancelDialog() {
        this.mCarlifeView.cancelDialog();
    }

    public void cancelDialog(BaseDialog childView) {
        this.mCarlifeView.cancelDialog(childView);
    }

    public boolean isDialogShown() {
        return this.mCarlifeView.isDialogShown();
    }
}
