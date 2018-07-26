package com.baidu.baidunavis.ui.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

public class BNDialogBuilder extends Builder {
    boolean mCanceledOnTouchOutside;
    OnKeyListener onKeyListener;

    /* renamed from: com.baidu.baidunavis.ui.widget.BNDialogBuilder$1 */
    class C09001 implements OnKeyListener {
        C09001() {
        }

        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == 84) {
                return true;
            }
            if (BNDialogBuilder.this.onKeyListener != null) {
                return BNDialogBuilder.this.onKeyListener.onKey(dialog, keyCode, event);
            }
            return false;
        }
    }

    public BNDialogBuilder(Context arg0) {
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
        dialog.setOnKeyListener(new C09001());
        return dialog;
    }
}
