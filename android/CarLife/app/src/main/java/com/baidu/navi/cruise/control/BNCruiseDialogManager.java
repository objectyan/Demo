package com.baidu.navi.cruise.control;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BNCruiseDialogManager
{
  private static final String TAG = "Cruise";
  private Context mActivity;
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
  
  public BNCruiseDialogManager(Context paramContext, e parame)
  {
    this.mActivity = paramContext;
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
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dismissQuitDialogAtCarlife()
  {
    this.mOnDialogListener.dismissDialog(this.mExitDialog);
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
      if ((localDialog == null) || (localDialog.isShowing())) {}
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
  
  public void showCruiseNotLocDialogAtCarlife(final BNDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    try
    {
      if (this.mNotLocatedDialog == null)
      {
        Resources localResources = this.mActivity.getResources();
        this.mNotLocatedDialog = new c(this.mActivity).c(localResources.getString(2131296783)).b(localResources.getString(2131297811)).g(17).d(localResources.getString(2131296781)).a(new b()
        {
          public void onClick()
          {
            if (paramOnNaviClickListener != null) {
              paramOnNaviClickListener.onClick();
            }
          }
        });
      }
      this.mOnDialogListener.showDialog(this.mNotLocatedDialog);
      return;
    }
    catch (Exception paramOnNaviClickListener) {}
  }
  
  public void showCruiseUnavailableDialogAtCarlife(final BNDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    hideCruiseUnavailableDialogAtCarlife();
    if (((this.mGPSSettingDialog != null) && (this.mOnDialogListener.isDialogShown())) || ((this.mExitDialog != null) && (this.mOnDialogListener.isDialogShown()))) {
      return;
    }
    try
    {
      if ((this.mUnavailableDialog == null) && (this.mActivity != null))
      {
        Resources localResources = this.mActivity.getResources();
        this.mUnavailableDialog = new c(this.mActivity).c(localResources.getString(2131296783)).b(localResources.getString(2131297817)).g(17).d(localResources.getString(2131297814)).a(new b()
        {
          public void onClick()
          {
            BNCruiseDialogManager.this.openSysNetworkSetting(true);
            BNCruiseDialogManager.this.mOnDialogListener.dismissDialog(BNCruiseDialogManager.this.mUnavailableDialog);
          }
        }).e(localResources.getString(2131296734)).b(new b()
        {
          public void onClick()
          {
            if (paramOnNaviClickListener != null) {
              paramOnNaviClickListener.onClick();
            }
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
    if (((this.mUnavailableDialog != null) && (this.mOnDialogListener.isDialogShown())) || ((this.mExitDialog != null) && (this.mOnDialogListener.isDialogShown()))) {
      return;
    }
    try
    {
      if (this.mGPSSettingDialog == null)
      {
        Resources localResources = this.mActivity.getResources();
        this.mGPSSettingDialog = new c(this.mActivity).c(localResources.getString(2131296783)).b(localResources.getString(2131297792)).g(17).d(localResources.getString(2131297793)).q().a(new b()
        {
          public void onClick()
          {
            try
            {
              Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
              localIntent.addFlags(268435456);
              BNCruiseDialogManager.this.mActivity.startActivity(localIntent);
              return;
            }
            catch (Exception localException)
            {
              LogUtil.e("", localException.toString());
              TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, BNCruiseDialogManager.this.mActivity.getResources().getString(2131296789));
            }
          }
        }).e(localResources.getString(2131296781)).b(new b()
        {
          public void onClick()
          {
            TipTool.onCreateToastDialog(BNCruiseDialogManager.this.mActivity, BNCruiseDialogManager.this.mActivity.getResources().getString(2131296790));
          }
        });
      }
      this.mOnDialogListener.showDialog(this.mGPSSettingDialog);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("Cruise", "dialog show failed because activity is NOT running!");
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
      this.mExitDialog = new c(this.mActivity).c(this.mActivity.getResources().getString(2131296783)).b(this.mActivity.getResources().getString(2131296739)).g(17).d(this.mActivity.getResources().getString(2131296737)).q().a(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener != null) {
            paramOnNaviClickListener.onClick();
          }
        }
      }).e(this.mActivity.getResources().getString(2131296755));
      this.mOnDialogListener.showDialog(this.mExitDialog);
      return;
    }
    catch (Exception paramOnNaviClickListener) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/cruise/control/BNCruiseDialogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */