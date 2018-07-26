package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

public class RGDialogBuilder extends Builder {
    boolean mCanceledOnTouchOutside;
    OnKeyListener onKeyListener;

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.widget.RGDialogBuilder$1 */
    class C44671 implements OnKeyListener {
        C44671() {
        }

        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == 84) {
                return true;
            }
            if (RGDialogBuilder.this.onKeyListener != null) {
                return RGDialogBuilder.this.onKeyListener.onKey(dialog, keyCode, event);
            }
            return false;
        }
    }

    public RGDialogBuilder(Context arg0) {
        super(arg0);
        setCancelable(false);
    }

    public void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.mCanceledOnTouchOutside = canceledOnTouchOutside;
    }

    public Builder setOnKeyListener(OnKeyListener _onKeyListener) {
        this.onKeyListener = _onKeyListener;
        return this;
    }

    public AlertDialog create() {
        AlertDialog dialog = super.create();
        dialog.setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        dialog.setOnKeyListener(new C44671());
        return dialog;
    }
}
