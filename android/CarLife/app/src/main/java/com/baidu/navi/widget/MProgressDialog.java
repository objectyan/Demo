package com.baidu.navi.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;

public class MProgressDialog {
    static final int RUNNING_TASK_SIZE = 1;
    static BMProgressDialog mBMProgressDialog;

    /* renamed from: com.baidu.navi.widget.MProgressDialog$1 */
    static class C40471 implements OnCancelListener {
        C40471() {
        }

        public void onCancel(DialogInterface dialog) {
        }
    }

    private static void showDialog(FragmentActivity fragActivity, int layoutResId, String title, String message, OnCancelListener cancelListener) {
        dismiss();
        if (isActivityRunning(fragActivity) && fragActivity.getSupportFragmentManager() != null) {
            try {
                mBMProgressDialog = BMProgressDialog.newInstance(layoutResId, cancelListener);
                mBMProgressDialog.show(fragActivity.getSupportFragmentManager(), "BMProgressDialog");
            } catch (Exception e) {
            }
        }
    }

    public static void show(FragmentActivity fragActivity, String title, String message, OnCancelListener cancelListener) {
        showDialog(fragActivity, 0, title, message, cancelListener);
    }

    public static void show(FragmentActivity fragActivity, String title, String message) {
        showDialog(fragActivity, 0, title, message, new C40471());
    }

    public static void show(FragmentActivity fragActivity, int layoutResId, OnCancelListener cancelListener) {
        showDialog(fragActivity, layoutResId, null, null, cancelListener);
    }

    public static void show(FragmentActivity fragActivity, OnCancelListener cancelListener) {
        showDialog(fragActivity, 0, null, null, cancelListener);
    }

    public static void dismiss() {
        if (!(mBMProgressDialog == null || mBMProgressDialog.getFragmentManager() == null)) {
            mBMProgressDialog.dismiss();
        }
        mBMProgressDialog = null;
    }

    private static boolean isActivityRunning(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return true;
    }
}
