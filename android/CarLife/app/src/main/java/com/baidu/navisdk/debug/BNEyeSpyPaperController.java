package com.baidu.navisdk.debug;

import android.app.Activity;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.widget.BNUserKeyLogDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class BNEyeSpyPaperController
{
  private static final String TAG = "BNUserKeyLogController";
  private static volatile BNEyeSpyPaperController mInstance = null;
  private boolean isCloudEnd = false;
  private boolean isFloatButtonShow = false;
  private BNEyeSpyPaperFloatButton mLogButton = null;
  private BNEyeSpyPaperModel mModel = null;
  private BNWorkerNormalTask mNavInitMonitor = new BNWorkerNormalTask("execute-mNavInitMonitor", null)
  {
    protected String execute()
    {
      LogUtil.e(TAG, "mNavInitMonitor run");
      BNEyeSpyPaperController.this.mModel.mUploadSource = 3;
      BNEyeSpyPaperController.this.navInitResult(false, "导航初始化1分钟超时");
      return null;
    }
  };
  private BNWorkerNormalTask mNavRoutePlanMonitor = new BNWorkerNormalTask("execute-mNavRoutePlanMonitor", null)
  {
    protected String execute()
    {
      LogUtil.e(TAG, "mNavRoutePlanMonitor run");
      BNEyeSpyPaperController.this.mModel.mDespText = "算路时间超过1分钟";
      BNEyeSpyPaperController.this.mModel.mUploadSource = 5;
      BNEyeSpyPaperController.this.uploadLog();
      return null;
    }
  };
  private BNUserKeyLogDialog mUserKeyLogDialog;
  
  public static BNEyeSpyPaperController getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNEyeSpyPaperController();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void navInitResult(boolean paramBoolean, String paramString)
  {
    BNWorkerCenter.getInstance().cancelTask(this.mNavInitMonitor, false);
    if (!paramBoolean) {
      uploadLog();
    }
  }
  
  public void addToTestPlaner(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mModel.addToTestPlaner();
      showButton();
      return;
    }
    this.mModel.removeFormTestPlaner();
    hideButton();
  }
  
  public void cloudConfigInitEnd()
  {
    this.isCloudEnd = true;
    this.mModel.initParmsAfterCloud();
    if (this.isFloatButtonShow) {
      showButton();
    }
  }
  
  public void endInitMonitor(boolean paramBoolean)
  {
    LogUtil.e("BNUserKeyLogController", "endInitMonitor :" + paramBoolean);
    if (!paramBoolean) {
      this.mModel.mUploadSource = 4;
    }
    if (paramBoolean) {}
    for (String str = "";; str = "导航初始化失败")
    {
      navInitResult(paramBoolean, str);
      return;
    }
  }
  
  public void endRoutePlanMonitor()
  {
    LogUtil.e("BNUserKeyLogController", "endRoutePlanMonitor :");
    BNWorkerCenter.getInstance().cancelTask(this.mNavRoutePlanMonitor, false);
  }
  
  public BNEyeSpyPaperModel getModel()
  {
    return this.mModel;
  }
  
  public void hideButton()
  {
    this.isFloatButtonShow = false;
    if (this.mLogButton != null) {
      this.mLogButton.hide();
    }
  }
  
  public void onUserKeyLogDialogDismiss()
  {
    this.mUserKeyLogDialog = null;
  }
  
  public void showButton()
  {
    this.isFloatButtonShow = true;
    if (!this.isCloudEnd)
    {
      LogUtil.e("BNUserKeyLogController", "showButton return isCloudEnd not");
      return;
    }
    if (!this.mModel.isInTestPlaner())
    {
      LogUtil.e("BNUserKeyLogController", "showButton return isInTestPlaner false");
      return;
    }
    if (this.mLogButton == null) {
      this.mLogButton = new BNEyeSpyPaperFloatButton();
    }
    this.mLogButton.show();
  }
  
  public void showUserKeyLogDialog()
  {
    Activity localActivity = BNaviModuleManager.getActivity();
    if (this.mUserKeyLogDialog == null) {
      this.mUserKeyLogDialog = new BNUserKeyLogDialog(localActivity);
    }
    if ((this.mUserKeyLogDialog.isShowing()) || (localActivity.isFinishing())) {
      return;
    }
    this.mUserKeyLogDialog.show();
  }
  
  public void startInitMonitor()
  {
    LogUtil.e("BNUserKeyLogController", "startInitMonitor");
    BNWorkerCenter.getInstance().cancelTask(this.mNavInitMonitor, false);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mNavInitMonitor, new BNWorkerConfig(2, 0), 60000L);
  }
  
  public void startRoutePlanMonitor()
  {
    LogUtil.e("BNUserKeyLogController", "startRoutePlanMonitor");
    BNWorkerCenter.getInstance().cancelTask(this.mNavRoutePlanMonitor, false);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mNavRoutePlanMonitor, new BNWorkerConfig(2, 0), 7000L);
  }
  
  public void uploadLog()
  {
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-" + getClass().getSimpleName() + "2", null)new BNWorkerConfig
    {
      protected String execute()
      {
        BNEyeSpyPaperController.this.mModel.uploadLogFile();
        return null;
      }
    }, new BNWorkerConfig(101, 0));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/BNEyeSpyPaperController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */