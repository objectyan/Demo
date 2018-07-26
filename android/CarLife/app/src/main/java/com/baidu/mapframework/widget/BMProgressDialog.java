package com.baidu.mapframework.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.baidu.carlife.C0965R;
import com.baidu.platform.comapi.util.C2911f;

public class BMProgressDialog extends DialogFragment {
    /* renamed from: a */
    private static final String f19331a = "title";
    /* renamed from: b */
    private static final String f19332b = "message";
    /* renamed from: c */
    private static final String f19333c = "layout_resid";
    /* renamed from: d */
    private static OnCancelListener f19334d;
    /* renamed from: e */
    private boolean f19335e = false;

    /* renamed from: com.baidu.mapframework.widget.BMProgressDialog$a */
    public class C3579a extends Dialog {
        /* renamed from: a */
        final /* synthetic */ BMProgressDialog f19328a;
        /* renamed from: b */
        private final int f19329b = C0965R.layout.common_progress_dialog_animation;
        /* renamed from: c */
        private int f19330c = C0965R.layout.common_progress_dialog_animation;

        public C3579a(BMProgressDialog this$0, Context context, int layoutResId) {
            this.f19328a = this$0;
            super(context, C0965R.style.theme_comm_progressdlg);
            if (layoutResId != 0) {
                this.f19330c = layoutResId;
            }
            setContentView(this.f19330c);
            getWindow().getAttributes().gravity = 17;
        }

        public void show() {
            try {
                if (this.f19328a.f19335e) {
                    this.f19328a.dismissAllowingStateLoss();
                } else {
                    super.show();
                }
            } catch (Exception ex) {
                C2911f.a(BMProgressDialog.class.getSimpleName(), "exception", ex);
            }
        }
    }

    /* renamed from: a */
    public static BMProgressDialog m15257a(String title, String message) {
        return m15258a(title, message, 0, null);
    }

    /* renamed from: a */
    public static BMProgressDialog m15259a(String title, String message, OnCancelListener cancelListener) {
        return m15258a(title, message, 0, cancelListener);
    }

    /* renamed from: a */
    public static BMProgressDialog m15256a(int layoutResId, OnCancelListener cancelListener) {
        return m15258a(null, null, layoutResId, cancelListener);
    }

    /* renamed from: a */
    private static BMProgressDialog m15258a(String title, String message, int layoutResId, OnCancelListener cancelListener) {
        f19334d = cancelListener;
        BMProgressDialog frag = new BMProgressDialog();
        Bundle bundle = new Bundle();
        if (title != null) {
            bundle.putString("title", title);
        }
        if (message != null) {
            bundle.putString("message", message);
        }
        bundle.putInt(f19333c, layoutResId);
        frag.setArguments(bundle);
        return frag;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new C3579a(this, getActivity(), getArguments().getInt(f19333c));
    }

    public void onCancel(DialogInterface dialog) {
        if (f19334d != null) {
            f19334d.onCancel(dialog);
        }
        f19334d = null;
    }

    public void dismiss() {
        this.f19335e = true;
        if (getActivity() != null) {
            try {
                dismissAllowingStateLoss();
            } catch (Exception ex) {
                C2911f.a(BMProgressDialog.class.getSimpleName(), "exception", ex);
            }
        }
        f19334d = null;
    }
}
