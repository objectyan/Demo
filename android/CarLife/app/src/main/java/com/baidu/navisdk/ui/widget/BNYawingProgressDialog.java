package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNYawingProgressDialog extends BNVolumeKeyDownDialog {
    private Activity mActivity;
    private Animation mAnim;
    private ImageView mCloseIV;
    private TextView mLoadingTipTV;
    private OnCancelListener mOnCancelListener = null;
    private ImageView mProgress;

    /* renamed from: com.baidu.navisdk.ui.widget.BNYawingProgressDialog$1 */
    class C45991 implements OnClickListener {
        C45991() {
        }

        public void onClick(View v) {
            if (BNYawingProgressDialog.this.mOnCancelListener != null) {
                BNYawingProgressDialog.this.mOnCancelListener.onCancel(BNYawingProgressDialog.this);
            }
            BNYawingProgressDialog.this.dismiss();
        }
    }

    public BNYawingProgressDialog(Activity activity) {
        View view;
        super(activity);
        this.mActivity = activity;
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
            view = JarUtils.inflate(activity, C4048R.layout.nsdk_layout_yawing_progress_dialog_animation, null);
        } catch (Exception e) {
            view = null;
        }
        if (view != null) {
            setContentView(view);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            this.mLoadingTipTV = (TextView) findViewById(C4048R.id.progress_tip_text);
            this.mCloseIV = (ImageView) findViewById(C4048R.id.iv_dialog_close);
            this.mProgress = (ImageView) findViewById(C4048R.id.progress_cycle_normal);
            this.mCloseIV.setOnClickListener(new C45991());
        }
    }

    public void startProgressAnim() {
        this.mAnim = BNStyleManager.loadAnimation(this.mActivity, C4048R.anim.nsdk_anim_yawing_progress_wait);
        LinearInterpolator lin = new LinearInterpolator();
        this.mAnim.setInterpolator(lin);
        if (this.mAnim != null && lin != null) {
            this.mProgress.startAnimation(this.mAnim);
        }
    }

    public BNYawingProgressDialog setMessage(String string) {
        this.mLoadingTipTV.setText(string);
        return this;
    }

    public void setOnCancelListener(OnCancelListener listener) {
        this.mOnCancelListener = listener;
        super.setOnCancelListener(listener);
    }
}
