package me.objectyan.screensharing.core.screen.presentation.view;

import me.objectyan.screensharing.core.screen.OnBtnClickListener;
import me.objectyan.screensharing.core.screen.OnDialogCancelListener;
import me.objectyan.screensharing.core.screen.OnProgressDialogListener;


public class CarlifeProgressDialogContainer implements OnProgressDialogListener {

    private static CarlifeProgressDialogContainer sCarlifeProgressDialogContainer = new CarlifeProgressDialogContainer();

    private OnProgressDialogListener mOnProgressDialogListener = null;


    public static CarlifeProgressDialogContainer newInstance() {
        return sCarlifeProgressDialogContainer;
    }

    private CarlifeProgressDialogContainer() {
    }


    public void initOnProgressDialogListener(OnProgressDialogListener listener) {
        this.mOnProgressDialogListener = listener;
    }


    public void mo1468c() {
        this.mOnProgressDialogListener.mo1468c();
    }


    public void mo1467b(String msg) {
        this.mOnProgressDialogListener.mo1467b(msg);
    }


    public void mo1465a(String msg, OnBtnClickListener cancelListener) {
        this.mOnProgressDialogListener.mo1465a(msg, cancelListener);
    }


    public void mo1466a(String msg, OnBtnClickListener cancelListener, OnDialogCancelListener listener) {
        this.mOnProgressDialogListener.mo1466a(msg, cancelListener, listener);
    }


    public boolean mo1469d() {
        return this.mOnProgressDialogListener.mo1469d();
    }
}
