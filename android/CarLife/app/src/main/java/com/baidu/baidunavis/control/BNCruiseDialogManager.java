package com.baidu.baidunavis.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navisdk.ui.cruise.control.CruiseDialogManager.CruiseDialogManagerInterface;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BNCruiseDialogManager
{
  private static final String TAG = "Cruise";
  private Activity mActivity;
  private CruiseDialogManager.CruiseDialogManagerInterface mCruiseDialogManagerInterface = new CruiseDialogManager.CruiseDialogManagerInterface()
  {
    public void dismissGPSSettingDialog()
    {
      BNCruiseDialogManager.this.dismissGPSSettingDialogAtCarlife();
    }
    
    public void dismissQuitDialog()
    {
      BNCruiseDialogManager.this.dismissQuitDialogAtCarlife();
    }
    
    public void hideCruiseUnavailableDialog()
    {
      BNCruiseDialogManager.this.hideCruiseUnavailableDialogAtCarlife();
    }
    
    public void popDialogAndShow()
    {
      BNCruiseDialogManager.this.popDialogAndShowAtCarlife();
    }
    
    public void putDialogInQueue(Dialog paramAnonymousDialog)
    {
      BNCruiseDialogManager.this.putDialogInQueueAtCarlife(paramAnonymousDialog);
    }
    
    public void showCruiseNotLocDialog(BNDialog.OnNaviClickListener paramAnonymousOnNaviClickListener)
    {
      BNCruiseDialogManager.this.showCruiseNotLocDialogAtCarlife(paramAnonymousOnNaviClickListener);
    }
    
    public void showCruiseUnavailableDialog(BNDialog.OnNaviClickListener paramAnonymousOnNaviClickListener)
    {
      BNCruiseDialogManager.this.showCruiseUnavailableDialogAtCarlife(paramAnonymousOnNaviClickListener);
    }
    
    public void showGPSSettingDialog()
    {
      BNCruiseDialogManager.this.showGPSSettingDialogAtCarlife();
    }
    
    public void showQuitDialog(BNDialog.OnNaviClickListener paramAnonymousOnNaviClickListener)
    {
      BNCruiseDialogManager.this.showQuitDialogAtCarlife(paramAnonymousOnNaviClickListener);
    }
  };
  private List<Dialog> mDialogList = new LinkedList();
  private c mExitDialog;
  private c mGPSSettingDialog;
  private c mNotLocatedDialog;
  private e mOnDialogListener;
  private c mUnavailableDialog;
  
  public BNCruiseDialogManager(Activity paramActivity, e parame)
  {
    this.mActivity = paramActivity;
    this.mOnDialogListener = parame;
  }
  
  private void openSysNetworkSetting(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Intent localIntent = new Intent("android.settings.WIFI_SETTINGS");; localIntent = new Intent("android.settings.WIRELESS_SETTINGS")) {
      try
      {
        if (this.mActivity != null) {
          this.mActivity.startActivity(localIntent);
        }
        return;
      }
      catch (Exception localException)
      {
        LogUtil.e("Cruise", localException.toString());
      }
    }
  }
  
  public void dismissGPSSettingDialogAtCarlife()
  {
    try
    {
      this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
      this.mGPSSettingDialog = null;
      return;
    }
    catch (Exception localException)
    {
      this.mGPSSettingDialog = null;
    }
  }
  
  public void dismissQuitDialogAtCarlife()
  {
    this.mOnDialogListener.dismissDialog(this.mExitDialog);
    this.mExitDialog = null;
  }
  
  public CruiseDialogManager.CruiseDialogManagerInterface getCruiseDialogManagerInterface()
  {
    return this.mCruiseDialogManagerInterface;
  }
  
  public void hideCruiseUnavailableDialogAtCarlife()
  {
    try
    {
      this.mOnDialogListener.dismissDialog(this.mUnavailableDialog);
      this.mUnavailableDialog = null;
      return;
    }
    catch (Exception localException)
    {
      this.mUnavailableDialog = null;
    }
  }
  
  public void popDialogAndShowAtCarlife()
  {
    Dialog localDialog;
    if ((this.mDialogList != null) && (!this.mDialogList.isEmpty()))
    {
      localDialog = (Dialog)this.mDialogList.remove(0);
      if ((localDialog == null) || (localDialog.isShowing()) || (this.mActivity.isFinishing())) {}
    }
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void putDialogInQueueAtCarlife(Dialog paramDialog)
  {
    Iterator localIterator;
    if ((this.mDialogList != null) && (paramDialog != null)) {
      localIterator = this.mDialogList.iterator();
    }
    while (localIterator.hasNext()) {
      if (paramDialog == (Dialog)localIterator.next()) {
        return;
      }
    }
    this.mDialogList.add(paramDialog);
  }
  
  public void showCruiseNotLocDialogAtCarlife(BNDialog.OnNaviClickListener paramOnNaviClickListener) {}
  
  public void showCruiseUnavailableDialogAtCarlife(final BNDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    if ((this.mUnavailableDialog != null) || (this.mExitDialog != null) || (this.mGPSSettingDialog != null) || (this.mOnDialogListener.isDialogShown())) {
      return;
    }
    hideCruiseUnavailableDialogAtCarlife();
    try
    {
      if (this.mActivity != null)
      {
        Resources localResources = JarUtils.getResources();
        this.mUnavailableDialog = new c(this.mActivity).c(localResources.getString(1711669372)).b(localResources.getString(1711669731)).g(17).d(localResources.getString(1711669732)).a(new b()
        {
          public void onClick()
          {
            BNCruiseDialogManager.this.openSysNetworkSetting(true);
            BNCruiseDialogManager.this.mOnDialogListener.dismissDialog(BNCruiseDialogManager.this.mUnavailableDialog);
          }
        }).e(localResources.getString(1711669759)).b(new b()
        {
          public void onClick()
          {
            if (paramOnNaviClickListener != null) {
              paramOnNaviClickListener.onClick();
            }
          }
        });
        this.mUnavailableDialog.setOnDialogCancelListener(new d()
        {
          public void onCancel()
          {
            BNCruiseDialogManager.access$402(BNCruiseDialogManager.this, null);
          }
        });
      }
      this.mOnDialogListener.showDialog(this.mUnavailableDialog);
      return;
    }
    catch (Exception paramOnNaviClickListener)
    {
      this.mUnavailableDialog = null;
    }
  }
  
  public void showGPSSettingDialogAtCarlife()
  {
    if ((this.mGPSSettingDialog != null) || (this.mExitDialog != null) || (this.mUnavailableDialog != null) || (this.mOnDialogListener.isDialogShown())) {
      return;
    }
    try
    {
      if (this.mActivity != null)
      {
        Resources localResources = JarUtils.getResources();
        this.mGPSSettingDialog = new c(this.mActivity).c(localResources.getString(1711669372)).b(localResources.getString(1711669746)).g(17).d(localResources.getString(1711669747)).q().a(new b()
        {
          public void onClick()
          {
            try
            {
              Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
              BNCruiseDialogManager.this.mActivity.startActivity(localIntent);
              return;
            }
            catch (Exception localException)
            {
              LogUtil.e("", localException.toString());
              TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, JarUtils.getResources().getString(1711669421));
            }
          }
        }).e(localResources.getString(1711669373)).b(new b()
        {
          public void onClick()
          {
            if ((BNCruiseDialogManager.this.mActivity != null) && (BNCruiseDialogManager.this.mActivity != null) && (!BNCruiseDialogManager.this.mActivity.isFinishing())) {
              TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, JarUtils.getResources().getString(1711669415));
            }
          }
        });
        this.mGPSSettingDialog.setOnDialogCancelListener(new d()
        {
          public void onCancel()
          {
            BNCruiseDialogManager.access$102(BNCruiseDialogManager.this, null);
          }
        });
      }
      this.mOnDialogListener.showDialog(this.mGPSSettingDialog);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("Cruise", "dialog show failed because activity is NOT running!");
      this.mGPSSettingDialog = null;
    }
  }
  
  public void showQuitDialogAtCarlife(final BNDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    if (this.mActivity == null) {
      return;
    }
    dismissQuitDialogAtCarlife();
    try
    {
      this.mExitDialog = new c(this.mActivity).c(JarUtils.getResources().getString(1711669372)).b(JarUtils.getResources().getString(1711669745)).g(17).d(JarUtils.getResources().getString(1711669611)).q().a(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener != null) {
            paramOnNaviClickListener.onClick();
          }
        }
      }).e(JarUtils.getResources().getString(1711669612));
      this.mExitDialog.setOnDialogCancelListener(new d()
      {
        public void onCancel()
        {
          BNCruiseDialogManager.access$202(BNCruiseDialogManager.this, null);
        }
      });
      this.mOnDialogListener.showDialog(this.mExitDialog);
      return;
    }
    catch (Exception paramOnNaviClickListener)
    {
      this.mExitDialog = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/BNCruiseDialogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */