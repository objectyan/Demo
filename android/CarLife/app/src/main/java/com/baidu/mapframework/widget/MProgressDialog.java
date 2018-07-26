package com.baidu.mapframework.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;

public class MProgressDialog {
    /* renamed from: a */
    static BMProgressDialog f19336a = null;
    /* renamed from: b */
    static final int f19337b = 1;

    /* renamed from: com.baidu.mapframework.widget.MProgressDialog$1 */
    static class C35801 implements OnCancelListener {
        C35801() {
        }

        public void onCancel(DialogInterface dialog) {
        }
    }

    /* renamed from: a */
    private static void m15261a(FragmentActivity fragActivity, int layoutResId, String title, String message, OnCancelListener cancelListener) {
        dismiss();
        if (m15262a(fragActivity) && fragActivity.getSupportFragmentManager() != null) {
            try {
                f19336a = BMProgressDialog.m15256a(layoutResId, cancelListener);
                f19336a.show(fragActivity.getSupportFragmentManager(), "BMProgressDialog");
            } catch (Exception e) {
            }
        }
    }

    public static void show(FragmentActivity fragActivity, String title, String message, OnCancelListener cancelListener) {
        m15261a(fragActivity, 0, title, message, cancelListener);
    }

    public static void show(FragmentActivity fragActivity, String title, String message) {
        m15261a(fragActivity, 0, title, message, new C35801());
    }

    public static void show(FragmentActivity fragActivity, int layoutResId, OnCancelListener cancelListener) {
        m15261a(fragActivity, layoutResId, null, null, cancelListener);
    }

    public static void show(FragmentActivity fragActivity, OnCancelListener cancelListener) {
        m15261a(fragActivity, 0, null, null, cancelListener);
    }

    public static void dismiss() {
        if (!(f19336a == null || f19336a.getFragmentManager() == null)) {
            f19336a.dismiss();
        }
        f19336a = null;
    }

    /* renamed from: a */
    private static boolean m15262a(Activity activity) {
        return (activity == null || activity.isFinishing()) ? false : true;
    }
}
