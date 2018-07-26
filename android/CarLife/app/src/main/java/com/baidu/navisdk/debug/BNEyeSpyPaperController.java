package com.baidu.navisdk.debug;

import android.app.Activity;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.widget.BNUserKeyLogDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class BNEyeSpyPaperController {
    private static final String TAG = "BNUserKeyLogController";
    private static volatile BNEyeSpyPaperController mInstance = null;
    private boolean isCloudEnd;
    private boolean isFloatButtonShow;
    private BNEyeSpyPaperFloatButton mLogButton;
    private BNEyeSpyPaperModel mModel;
    private BNWorkerNormalTask mNavInitMonitor;
    private BNWorkerNormalTask mNavRoutePlanMonitor;
    private BNUserKeyLogDialog mUserKeyLogDialog;

    private BNEyeSpyPaperController() {
        this.mModel = null;
        this.mLogButton = null;
        this.isFloatButtonShow = false;
        this.isCloudEnd = false;
        this.mNavInitMonitor = new BNWorkerNormalTask<String, String>("execute-mNavInitMonitor", null) {
            protected String execute() {
                LogUtil.m15791e(TAG, "mNavInitMonitor run");
                BNEyeSpyPaperController.this.mModel.mUploadSource = 3;
                BNEyeSpyPaperController.this.navInitResult(false, "导航初始化1分钟超时");
                return null;
            }
        };
        this.mNavRoutePlanMonitor = new BNWorkerNormalTask<String, String>("execute-mNavRoutePlanMonitor", null) {
            protected String execute() {
                LogUtil.m15791e(TAG, "mNavRoutePlanMonitor run");
                BNEyeSpyPaperController.this.mModel.mDespText = "算路时间超过1分钟";
                BNEyeSpyPaperController.this.mModel.mUploadSource = 5;
                BNEyeSpyPaperController.this.uploadLog();
                return null;
            }
        };
        this.mModel = new BNEyeSpyPaperModel();
    }

    public static BNEyeSpyPaperController getInstance() {
        if (mInstance == null) {
            synchronized (BNEyeSpyPaperController.class) {
                if (mInstance == null) {
                    mInstance = new BNEyeSpyPaperController();
                }
            }
        }
        return mInstance;
    }

    public BNEyeSpyPaperModel getModel() {
        return this.mModel;
    }

    public void cloudConfigInitEnd() {
        this.isCloudEnd = true;
        this.mModel.initParmsAfterCloud();
        if (this.isFloatButtonShow) {
            showButton();
        }
    }

    public void showButton() {
        this.isFloatButtonShow = true;
        if (!this.isCloudEnd) {
            LogUtil.m15791e(TAG, "showButton return isCloudEnd not");
        } else if (this.mModel.isInTestPlaner()) {
            if (this.mLogButton == null) {
                this.mLogButton = new BNEyeSpyPaperFloatButton();
            }
            this.mLogButton.show();
        } else {
            LogUtil.m15791e(TAG, "showButton return isInTestPlaner false");
        }
    }

    public void hideButton() {
        this.isFloatButtonShow = false;
        if (this.mLogButton != null) {
            this.mLogButton.hide();
        }
    }

    public void showUserKeyLogDialog() {
        Activity activity = BNaviModuleManager.getActivity();
        if (this.mUserKeyLogDialog == null) {
            this.mUserKeyLogDialog = new BNUserKeyLogDialog(activity);
        }
        if (!this.mUserKeyLogDialog.isShowing() && !activity.isFinishing()) {
            this.mUserKeyLogDialog.show();
        }
    }

    public void onUserKeyLogDialogDismiss() {
        this.mUserKeyLogDialog = null;
    }

    public void addToTestPlaner(boolean add) {
        if (add) {
            this.mModel.addToTestPlaner();
            showButton();
            return;
        }
        this.mModel.removeFormTestPlaner();
        hideButton();
    }

    public void uploadLog() {
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-" + getClass().getSimpleName() + "2", null) {
            protected String execute() {
                BNEyeSpyPaperController.this.mModel.uploadLogFile();
                return null;
            }
        }, new BNWorkerConfig(101, 0));
    }

    public void startInitMonitor() {
        LogUtil.m15791e(TAG, "startInitMonitor");
        BNWorkerCenter.getInstance().cancelTask(this.mNavInitMonitor, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mNavInitMonitor, new BNWorkerConfig(2, 0), 60000);
    }

    public void endInitMonitor(boolean success) {
        LogUtil.m15791e(TAG, "endInitMonitor :" + success);
        if (!success) {
            this.mModel.mUploadSource = 4;
        }
        navInitResult(success, success ? "" : "导航初始化失败");
    }

    private void navInitResult(boolean success, String desp) {
        BNWorkerCenter.getInstance().cancelTask(this.mNavInitMonitor, false);
        if (!success) {
            uploadLog();
        }
    }

    public void startRoutePlanMonitor() {
        LogUtil.m15791e(TAG, "startRoutePlanMonitor");
        BNWorkerCenter.getInstance().cancelTask(this.mNavRoutePlanMonitor, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mNavRoutePlanMonitor, new BNWorkerConfig(2, 0), 7000);
    }

    public void endRoutePlanMonitor() {
        LogUtil.m15791e(TAG, "endRoutePlanMonitor :");
        BNWorkerCenter.getInstance().cancelTask(this.mNavRoutePlanMonitor, false);
    }
}
