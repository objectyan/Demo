package me.objectyan.screensharing.core.screen;


import me.objectyan.screensharing.core.screen.BaseDialog.C1265a;


public interface OnDialogListener  {
    void cancelDialog();

    void cancelDialog(BaseDialog baseDialog);

    void dismissDialog();

    void dismissDialog(BaseDialog baseDialog);

    boolean isDialogShown();

    void showDialog(BaseDialog baseDialog);

    void showDialog(BaseDialog baseDialog, C1265a c1265a);
}
