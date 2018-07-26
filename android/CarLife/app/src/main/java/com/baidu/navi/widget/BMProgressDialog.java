package com.baidu.navi.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.baidu.carlife.C0965R;

public class BMProgressDialog extends DialogFragment {
    private static final String LAYOUT_RESID = "layout_resid";
    private static final String MESSAGE = "message";
    private static final String TITLE = "title";
    private static OnCancelListener mCancelListener;
    private boolean isDestroyed = false;

    public class INProgressDialog extends Dialog {
        private static final int COMMON_RESID = 2130968714;
        private int mLayoutResId = C0965R.layout.common_progress_dialog_animation;

        public INProgressDialog(Context context, int layoutResId) {
            super(context, C0965R.style.theme_comm_progressdlg);
            if (layoutResId != 0) {
                this.mLayoutResId = layoutResId;
            }
            setContentView(this.mLayoutResId);
            getWindow().getAttributes().gravity = 17;
        }

        public void show() {
            try {
                if (BMProgressDialog.this.isDestroyed) {
                    BMProgressDialog.this.dismissAllowingStateLoss();
                } else {
                    super.show();
                }
            } catch (Exception e) {
            }
        }
    }

    public static BMProgressDialog newInstance(String title, String message) {
        return create(title, message, 0, null);
    }

    public static BMProgressDialog newInstance(String title, String message, OnCancelListener cancelListener) {
        return create(title, message, 0, cancelListener);
    }

    public static BMProgressDialog newInstance(int layoutResId, OnCancelListener cancelListener) {
        return create(null, null, layoutResId, cancelListener);
    }

    private static BMProgressDialog create(String title, String message, int layoutResId, OnCancelListener cancelListener) {
        mCancelListener = cancelListener;
        BMProgressDialog frag = new BMProgressDialog();
        Bundle bundle = new Bundle();
        if (title != null) {
            bundle.putString("title", title);
        }
        if (message != null) {
            bundle.putString("message", message);
        }
        bundle.putInt(LAYOUT_RESID, layoutResId);
        frag.setArguments(bundle);
        return frag;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new INProgressDialog(getActivity(), getArguments().getInt(LAYOUT_RESID));
    }

    public void onCancel(DialogInterface dialog) {
        if (mCancelListener != null) {
            mCancelListener.onCancel(dialog);
        }
        mCancelListener = null;
    }

    public void dismiss() {
        this.isDestroyed = true;
        if (getActivity() != null) {
            try {
                dismissAllowingStateLoss();
            } catch (Exception e) {
            }
        }
    }
}
