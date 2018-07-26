package com.baidu.navisdk.ui.widget;

public class BNDialogListenerMang {
    private static BNDialogListenerMang mInstance;
    private BNDialogListener bnDialogListener;

    public interface BNDialogListener {
        void onDismiss(String str);

        void onShow(String str, String str2, BNDialog bNDialog);
    }

    private BNDialogListenerMang() {
    }

    public static BNDialogListenerMang getInstance() {
        if (mInstance == null) {
            mInstance = new BNDialogListenerMang();
        }
        return mInstance;
    }

    public void setBNDialogListener(BNDialogListener bnDialogListener) {
        this.bnDialogListener = bnDialogListener;
    }

    public BNDialogListener getBNDialogListener() {
        return this.bnDialogListener;
    }
}
