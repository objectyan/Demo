package me.objectyan.screensharing.core.screen.presentation.view;

import me.objectyan.screensharing.core.screen.BaseDialog;
import me.objectyan.screensharing.core.screen.BaseDialog.C1265a;
import me.objectyan.screensharing.core.screen.OnDialogListener;


public class CarlifeViewContainer implements OnDialogListener {

    private static CarlifeViewContainer sCarlifeViewContainer = new CarlifeViewContainer();

    private CarlifeView mCarlifeView;


    public static CarlifeViewContainer newInstance() {
        return sCarlifeViewContainer;
    }

    private CarlifeViewContainer() {
    }


    public CarlifeView getCarlifeView() {
        return this.mCarlifeView;
    }


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
