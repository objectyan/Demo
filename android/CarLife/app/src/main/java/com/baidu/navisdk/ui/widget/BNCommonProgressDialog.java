package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNCommonProgressDialog extends Dialog {
    protected ImageView mCloseIV;
    protected TextView mLoadingTipTV;
    protected OnCancelListener mOnCancelListener = null;

    /* renamed from: com.baidu.navisdk.ui.widget.BNCommonProgressDialog$1 */
    class C45651 implements OnClickListener {
        C45651() {
        }

        public void onClick(View v) {
            if (BNCommonProgressDialog.this.mOnCancelListener != null) {
                BNCommonProgressDialog.this.mOnCancelListener.onCancel(BNCommonProgressDialog.this);
            }
            BNCommonProgressDialog.this.dismiss();
        }
    }

    public BNCommonProgressDialog(Activity activity) {
        View view;
        super(activity);
        if (VERSION.SDK_INT < 21) {
            Theme theme = JarUtils.getResources().newTheme();
            theme.applyStyle(C4048R.style.theme_comm_progressdlg, true);
            JarUtils.setDialogThemeField(this, theme);
        } else {
            Window win = getWindow();
            requestWindowFeature(1);
            win.setBackgroundDrawableResource(17170445);
            win.getAttributes().gravity = 17;
        }
        try {
            view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_common_progress_dialog_animation, null);
        } catch (Exception e) {
            view = null;
        }
        if (view != null) {
            setContentView(view);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            getWindow().getAttributes().gravity = 17;
            this.mLoadingTipTV = (TextView) findViewById(C4048R.id.progress_tip_text);
            this.mCloseIV = (ImageView) findViewById(C4048R.id.iv_dialog_close);
            setCloseIVListener();
        }
    }

    public BNCommonProgressDialog setDimAmount(float amount) {
        if (VERSION.SDK_INT >= 14) {
            getWindow().setDimAmount(0.0f);
        }
        return this;
    }

    public void setCloseIVListener() {
        this.mCloseIV.setOnClickListener(new C45651());
    }

    public BNCommonProgressDialog setYawingStyleGrivity(boolean isYawing) {
        Theme theme;
        if (isYawing) {
            theme = JarUtils.getResources().newTheme();
            theme.applyStyle(C4048R.style.theme_yaw_progressdlg, true);
            JarUtils.setDialogThemeField(this, theme);
            getWindow().getAttributes().gravity = 51;
        } else {
            theme = JarUtils.getResources().newTheme();
            theme.applyStyle(C4048R.style.theme_comm_progressdlg, true);
            JarUtils.setDialogThemeField(this, theme);
            getWindow().getAttributes().gravity = 17;
        }
        return this;
    }

    public BNCommonProgressDialog setMessage(String string) {
        this.mLoadingTipTV.setText(string);
        return this;
    }

    public void setOnCancelListener(OnCancelListener listener) {
        this.mOnCancelListener = listener;
        super.setOnCancelListener(listener);
    }

    public void setCloseGone() {
        this.mCloseIV.setVisibility(8);
    }

    public void setCloseVisible() {
        this.mCloseIV.setVisibility(0);
    }
}
