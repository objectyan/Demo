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

public class LightNaviDialogHelper
{
  private static volatile LightNaviDialogHelper mInstance;
  private Activity mActivity;
  private BNCommonProgressDialog mShareProgress;
  private BNCommonProgressDialog mSwitchWaitProgress;
  private BNYawingProgressDialog mYawingDialog;
  
  private LightNaviDialogHelper(Context paramContext)
  {
    this.mActivity = ((Activity)paramContext);
  }
  
  public static LightNaviDialogHelper getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new LightNaviDialogHelper(paramContext);
    }
    return mInstance;
  }
  
  public void dismissSafetyShareDialog()
  {
    try
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.mShareProgress != null) && (this.mShareProgress.isShowing())) {
        this.mShareProgress.dismiss();
      }
      this.mShareProgress = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("wangyang", localException.toString());
      }
    }
  }
  
  public boolean dismissSwitchProgressDialog()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.mSwitchWaitProgress != null) && (this.mSwitchWaitProgress.isShowing())) {}
    try
    {
      this.mSwitchWaitProgress.dismiss();
      this.mSwitchWaitProgress = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("wangyang", localException.toString());
      }
    }
  }
  
  public void dismissYawingLoading()
  {
    try
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.mYawingDialog != null) && (this.mYawingDialog.isShowing())) {
        this.mYawingDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      this.mYawingDialog = null;
    }
  }
  
  public void setCloseGone()
  {
    if (this.mSwitchWaitProgress != null) {
      this.mSwitchWaitProgress.setCloseGone();
    }
  }
  
  public void setCloseVisible()
  {
    if (this.mSwitchWaitProgress != null) {
      this.mSwitchWaitProgress.setCloseVisible();
    }
  }
  
  public BNCommonProgressDialog showSafetyShareDialog()
  {
    if (this.mActivity == null) {
      return null;
    }
    try
    {
      dismissSwitchProgressDialog();
      if (this.mShareProgress == null) {
        this.mShareProgress = new BNCommonProgressDialog(this.mActivity);
      }
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.mShareProgress != null))
      {
        this.mShareProgress.setMessage("分享请求中...");
        this.mShareProgress.show();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("wangyang", localException.toString());
      }
    }
    return this.mShareProgress;
  }
  
  public void showSwitchProgressDialog()
  {
    dismissSwitchProgressDialog();
    try
    {
      if (this.mSwitchWaitProgress == null) {
        this.mSwitchWaitProgress = new BNCommonProgressDialog(this.mActivity);
      }
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.mSwitchWaitProgress != null))
      {
        this.mSwitchWaitProgress.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
            BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
            LightNaviDialogHelper.this.dismissSwitchProgressDialog();
          }
        });
        this.mSwitchWaitProgress.setMessage("正在切换专业模式...");
        this.mSwitchWaitProgress.show();
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("wangyang", localException.toString());
    }
  }
  
  public BNYawingProgressDialog showYawingLoading(String paramString)
  {
    if (this.mActivity == null) {
      return null;
    }
    try
    {
      if ((this.mYawingDialog == null) && (this.mActivity != null)) {
        this.mYawingDialog = new BNYawingProgressDialog(this.mActivity);
      }
      if (this.mYawingDialog != null)
      {
        this.mYawingDialog.setMessage(paramString).setCancelable(true);
        this.mYawingDialog.startProgressAnim();
        this.mYawingDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            BNLightNaviManager.getInstance().quitLightNavi();
          }
        });
      }
      LogUtil.e("wangyang", "Show Yawing Loading");
      if ((!this.mYawingDialog.isShowing()) && (this.mActivity != null) && (!this.mActivity.isFinishing())) {
        this.mYawingDialog.show();
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return this.mYawingDialog;
  }
  
  public void unInit()
  {
    mInstance = null;
    RGAvoidTrafficModel.getInstance().setmCanAvoidTrafficShow(false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/viewhelp/LightNaviDialogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */