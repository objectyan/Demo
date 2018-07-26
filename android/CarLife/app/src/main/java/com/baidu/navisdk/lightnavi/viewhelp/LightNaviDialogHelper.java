package com.baidu.navisdk.lightnavi.viewhelp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.ui.routeguide.model.RGAvoidTrafficModel;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNYawingProgressDialog;
import com.baidu.navisdk.util.common.LogUtil;

public class LightNaviDialogHelper {
    private static volatile LightNaviDialogHelper mInstance;
    private Activity mActivity;
    private BNCommonProgressDialog mShareProgress;
    private BNCommonProgressDialog mSwitchWaitProgress;
    private BNYawingProgressDialog mYawingDialog;

    /* renamed from: com.baidu.navisdk.lightnavi.viewhelp.LightNaviDialogHelper$1 */
    class C41221 implements OnCancelListener {
        C41221() {
        }

        public void onCancel(DialogInterface dialog) {
            BNLightNaviManager.getInstance().quitLightNavi();
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.viewhelp.LightNaviDialogHelper$2 */
    class C41232 implements OnCancelListener {
        C41232() {
        }

        public void onCancel(DialogInterface dialog) {
            BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
            BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
            LightNaviDialogHelper.this.dismissSwitchProgressDialog();
        }
    }

    private LightNaviDialogHelper(Context context) {
        this.mActivity = (Activity) context;
    }

    public static LightNaviDialogHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new LightNaviDialogHelper(context);
        }
        return mInstance;
    }

    public BNYawingProgressDialog showYawingLoading(String strTip) {
        if (this.mActivity == null) {
            return null;
        }
        try {
            if (this.mYawingDialog == null && this.mActivity != null) {
                this.mYawingDialog = new BNYawingProgressDialog(this.mActivity);
            }
            if (this.mYawingDialog != null) {
                this.mYawingDialog.setMessage(strTip).setCancelable(true);
                this.mYawingDialog.startProgressAnim();
                this.mYawingDialog.setOnCancelListener(new C41221());
            }
            LogUtil.m15791e("wangyang", "Show Yawing Loading");
            if (!(this.mYawingDialog.isShowing() || this.mActivity == null || this.mActivity.isFinishing())) {
                this.mYawingDialog.show();
            }
        } catch (Exception e) {
        }
        return this.mYawingDialog;
    }

    public void dismissYawingLoading() {
        try {
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mYawingDialog != null && this.mYawingDialog.isShowing()) {
                this.mYawingDialog.dismiss();
            }
        } catch (Exception e) {
            this.mYawingDialog = null;
        }
    }

    public void unInit() {
        mInstance = null;
        RGAvoidTrafficModel.getInstance().setmCanAvoidTrafficShow(false);
    }

    public void showSwitchProgressDialog() {
        dismissSwitchProgressDialog();
        try {
            if (this.mSwitchWaitProgress == null) {
                this.mSwitchWaitProgress = new BNCommonProgressDialog(this.mActivity);
            }
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mSwitchWaitProgress != null) {
                this.mSwitchWaitProgress.setOnCancelListener(new C41232());
                this.mSwitchWaitProgress.setMessage("正在切换专业模式...");
                this.mSwitchWaitProgress.show();
            }
        } catch (Exception e) {
            LogUtil.m15791e("wangyang", e.toString());
        }
    }

    public boolean dismissSwitchProgressDialog() {
        if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mSwitchWaitProgress == null || !this.mSwitchWaitProgress.isShowing())) {
            try {
                this.mSwitchWaitProgress.dismiss();
            } catch (Exception e) {
                LogUtil.m15791e("wangyang", e.toString());
            }
        }
        this.mSwitchWaitProgress = null;
        return true;
    }

    public void setCloseGone() {
        if (this.mSwitchWaitProgress != null) {
            this.mSwitchWaitProgress.setCloseGone();
        }
    }

    public void setCloseVisible() {
        if (this.mSwitchWaitProgress != null) {
            this.mSwitchWaitProgress.setCloseVisible();
        }
    }

    public BNCommonProgressDialog showSafetyShareDialog() {
        if (this.mActivity == null) {
            return null;
        }
        try {
            dismissSwitchProgressDialog();
            if (this.mShareProgress == null) {
                this.mShareProgress = new BNCommonProgressDialog(this.mActivity);
            }
            if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mShareProgress == null)) {
                this.mShareProgress.setMessage("分享请求中...");
                this.mShareProgress.show();
            }
        } catch (Exception e) {
            LogUtil.m15791e("wangyang", e.toString());
        }
        return this.mShareProgress;
    }

    public void dismissSafetyShareDialog() {
        try {
            if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mShareProgress == null || !this.mShareProgress.isShowing())) {
                this.mShareProgress.dismiss();
            }
        } catch (Exception e) {
            LogUtil.m15791e("wangyang", e.toString());
        }
        this.mShareProgress = null;
    }
}
