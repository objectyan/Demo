package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.ConfirmArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.ConfirmOTArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.LackDataArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;

public class RoutePlanObserver
  implements BNRoutePlanObserver
{
  private static BNNetworkingDialog mRoutePlanAvoidTrafficJamDialog;
  private static BNMessageDialog mRoutePlanFirstCalcDialog = null;
  private static BNMessageDialog mRoutePlanNetworkingDialog = null;
  private static BNMessageDialog mRoutePlanNoNetNoDataDialog;
  private static BNMessageDialog mRoutePlanOvertimeDialog;
  private static BNCommonProgressDialog mWaitProgress = null;
  private WeakReference<Activity> mActivity = null;
  private IJumpToDownloadListener mIIJumpToDownloadListener = null;
  private BNMessageDialog mNaviMessageDialog = null;
  
  static
  {
    mRoutePlanAvoidTrafficJamDialog = null;
    mRoutePlanOvertimeDialog = null;
    mRoutePlanNoNetNoDataDialog = null;
  }
  
  public RoutePlanObserver(Activity paramActivity, IJumpToDownloadListener paramIJumpToDownloadListener)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.mIIJumpToDownloadListener = paramIJumpToDownloadListener;
  }
  
  private String getDebugToastMessage(BNRoutePlanObserver.FailArg paramFailArg)
  {
    if (LogUtil.LOGGABLE) {
      return "(" + paramFailArg.mFailType + ")";
    }
    return "";
  }
  
  public boolean dismissMessageDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (this.mNaviMessageDialog != null) && (this.mNaviMessageDialog.isShowing())) {}
    try
    {
      this.mNaviMessageDialog.dismiss();
      this.mNaviMessageDialog = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean dismissRoutePlanAvoidTrafficJamDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanAvoidTrafficJamDialog != null) && (mRoutePlanAvoidTrafficJamDialog.isShowing())) {}
    try
    {
      mRoutePlanAvoidTrafficJamDialog.dismiss();
      mRoutePlanAvoidTrafficJamDialog = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean dismissRoutePlanFirstCalcDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanFirstCalcDialog != null) && (mRoutePlanFirstCalcDialog.isShowing())) {}
    try
    {
      mRoutePlanFirstCalcDialog.dismiss();
      mRoutePlanFirstCalcDialog = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean dismissRoutePlanNetworkingDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanNetworkingDialog != null) && (mRoutePlanNetworkingDialog.isShowing())) {}
    try
    {
      mRoutePlanNetworkingDialog.dismiss();
      mRoutePlanNetworkingDialog = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean dismissRoutePlanNoNetNoDataDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanNoNetNoDataDialog != null) && (mRoutePlanNoNetNoDataDialog.isShowing())) {}
    try
    {
      mRoutePlanNoNetNoDataDialog.dismiss();
      mRoutePlanNoNetNoDataDialog = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean dismissRoutePlanOvertimeDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanOvertimeDialog != null) && (mRoutePlanOvertimeDialog.isShowing())) {}
    try
    {
      mRoutePlanOvertimeDialog.dismiss();
      mRoutePlanOvertimeDialog = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean dismissWaitProgressDialog()
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mWaitProgress != null) && (mWaitProgress.isShowing())) {}
    try
    {
      mWaitProgress.dismiss();
      mWaitProgress = null;
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public String getRoutePlanTipsMsg()
  {
    String str;
    switch (BNRoutePlaner.getInstance().getGuideSceneType())
    {
    case 3: 
    default: 
      str = BNStyleManager.getString(1711669442);
    }
    for (;;)
    {
      BNRoutePlaner.getInstance().setGuideSceneType(1);
      return str;
      str = BNStyleManager.getString(1711669442);
      continue;
      str = BNStyleManager.getString(1711669443);
      continue;
      str = BNStyleManager.getString(1711669444);
    }
  }
  
  public void onRouterPlanFailReasonShow(BNRoutePlanObserver.FailArg paramFailArg)
  {
    switch (paramFailArg.mFailType)
    {
    default: 
      if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing())) {
        TipTool.onCreateToastDialog((Context)this.mActivity.get(), paramFailArg.mFailText + getDebugToastMessage(paramFailArg));
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while ((this.mActivity.get() == null) || (((Activity)this.mActivity.get()).isFinishing()));
      TipTool.onCreateToastDialog((Context)this.mActivity.get(), "数据缺失，请检查" + getDebugToastMessage(paramFailArg));
      return;
    } while ((this.mActivity.get() == null) || (((Activity)this.mActivity.get()).isFinishing()));
    TipTool.onCreateToastDialog((Context)this.mActivity.get(), "无网络无数据，请检查" + getDebugToastMessage(paramFailArg));
  }
  
  public void onRouterPlanTipShow(BNRoutePlanObserver.FailArg paramFailArg)
  {
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing())) {
      TipTool.onCreateToastDialog((Context)this.mActivity.get(), paramFailArg.mFailText + getDebugToastMessage(paramFailArg));
    }
  }
  
  public void showMessageDialog(Context paramContext, String paramString)
  {
    dismissMessageDialog();
    if ((this.mNaviMessageDialog == null) && (paramContext != null)) {
      this.mNaviMessageDialog = new BNMessageDialog((Activity)paramContext).setMessage(paramString).setTitleText(JarUtils.getResources().getString(1711669600)).setFirstBtnEnabled(true).setFirstBtnText(JarUtils.getResources().getString(1711669607));
    }
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (this.mNaviMessageDialog != null)) {}
    try
    {
      this.mNaviMessageDialog.show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void showRoutePlanAvoidTrafficJamDialog(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    dismissRoutePlanAvoidTrafficJamDialog();
    if (mRoutePlanAvoidTrafficJamDialog == null) {
      mRoutePlanAvoidTrafficJamDialog = new BNNetworkingDialog((Activity)paramContext).setNetworkingContentMessage(paramString1).setConfirmNetworkMessage(paramString2).setConfirmNetworkingListener(paramOnClickListener1).setCancleListener(paramOnClickListener2).setTwoButtonMode(true);
    }
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanAvoidTrafficJamDialog != null)) {}
    try
    {
      mRoutePlanAvoidTrafficJamDialog.show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void showRoutePlanFirstCalcDialog(Context paramContext, BNBaseDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    dismissRoutePlanFirstCalcDialog();
    if ((mRoutePlanFirstCalcDialog == null) && (this.mActivity.get() != null)) {
      mRoutePlanFirstCalcDialog = new BNMessageDialog((Activity)this.mActivity.get()).setTitleText(JarUtils.getResources().getString(1711669600)).setMessage(JarUtils.getResources().getString(1711669619)).setSecondBtnEnabled(false).setFirstBtnText(JarUtils.getResources().getString(1711669607)).setOnFirstBtnClickListener(paramOnNaviClickListener);
    }
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanFirstCalcDialog != null)) {}
    try
    {
      mRoutePlanFirstCalcDialog.show();
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("wy", paramContext.toString());
    }
  }
  
  public void showRoutePlanNetworkingDialog(Context paramContext, String paramString1, String paramString2, BNBaseDialog.OnNaviClickListener paramOnNaviClickListener1, BNBaseDialog.OnNaviClickListener paramOnNaviClickListener2)
  {
    dismissRoutePlanNetworkingDialog();
    if ((mRoutePlanNetworkingDialog == null) && (this.mActivity.get() != null)) {
      mRoutePlanNetworkingDialog = new BNMessageDialog((Activity)this.mActivity.get()).setTitleText(JarUtils.getResources().getString(1711669600)).setMessage(paramString1).setFirstBtnText(JarUtils.getResources().getString(1711669617)).setSecondBtnText(JarUtils.getResources().getString(1711669618)).setOnFirstBtnClickListener(paramOnNaviClickListener2).setOnSecondBtnClickListener(paramOnNaviClickListener1);
    }
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanNetworkingDialog != null)) {}
    try
    {
      mRoutePlanNetworkingDialog.show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void showRoutePlanNoNetNoDataDialog(Context paramContext, String paramString)
  {
    dismissRoutePlanNoNetNoDataDialog();
    if ((mRoutePlanNoNetNoDataDialog == null) && (this.mActivity.get() != null)) {
      mRoutePlanNoNetNoDataDialog = new BNMessageDialog((Activity)this.mActivity.get()).setTitleText(JarUtils.getResources().getString(1711669600)).setMessage(JarUtils.getResources().getString(1711669615) + "\n缺失以下数据：" + paramString).setFirstBtnText(JarUtils.getResources().getString(1711669617)).setSecondBtnText(JarUtils.getResources().getString(1711669616)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
          if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
            RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
          }
        }
      }).setOnSecondBtnClickListener(new BNBaseDialog.OnNaviClickListener()
      {
        public void onClick()
        {
          RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
          if (RoutePlanObserver.this.mActivity.get() != null)
          {
            Intent localIntent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
            ((Activity)RoutePlanObserver.this.mActivity.get()).startActivity(localIntent);
          }
        }
      });
    }
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanNoNetNoDataDialog != null)) {}
    try
    {
      mRoutePlanNoNetNoDataDialog.show();
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("wy", paramContext.toString());
    }
  }
  
  public void showRoutePlanOvertimeDialog(Context paramContext, BNBaseDialog.OnNaviClickListener paramOnNaviClickListener1, BNBaseDialog.OnNaviClickListener paramOnNaviClickListener2)
  {
    dismissRoutePlanOvertimeDialog();
    if ((mRoutePlanOvertimeDialog == null) && (this.mActivity.get() != null)) {
      mRoutePlanOvertimeDialog = new BNMessageDialog((Activity)this.mActivity.get()).setTitleText(JarUtils.getResources().getString(1711669600)).setMessage(JarUtils.getResources().getString(1711669614)).setFirstBtnText(JarUtils.getResources().getString(1711669612)).setSecondBtnText(JarUtils.getResources().getString(1711669613)).setOnFirstBtnClickListener(paramOnNaviClickListener2).setOnSecondBtnClickListener(paramOnNaviClickListener1);
    }
    if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mRoutePlanOvertimeDialog != null)) {}
    try
    {
      mRoutePlanOvertimeDialog.show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void showWaitProgressDialog(Context paramContext)
  {
    dismissWaitProgressDialog();
    try
    {
      if ((mWaitProgress == null) && (paramContext != null)) {
        mWaitProgress = new BNCommonProgressDialog((Activity)paramContext);
      }
      if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing()) && (mWaitProgress != null))
      {
        mWaitProgress.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            LogUtil.e("RoutePlan", "WaitProgress onCancel!");
            RGViewController.getInstance().showReCalRouteQuitDialog();
          }
        });
        mWaitProgress.setMessage(getRoutePlanTipsMsg());
        mWaitProgress.show();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void update(BNSubject paramBNSubject, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      switch (paramInt2)
                      {
                      case 21: 
                      default: 
                        return;
                      }
                    } while ((BNRoutePlaner.getInstance().getEntry() == 16) || (BNRoutePlaner.getInstance().getEntry() == 7) || (BNavigator.getInstance().isNaviBegin()) || (RGViewController.getInstance().isWaitCalProgressShowing()));
                    showWaitProgressDialog((Context)this.mActivity.get());
                    return;
                    dismissWaitProgressDialog();
                    return;
                  } while (BNavigator.getInstance().isNaviBegin());
                  if ((this.mActivity.get() != null) && (!((Activity)this.mActivity.get()).isFinishing())) {
                    TipTool.onCreateToastDialog((Context)this.mActivity.get(), "抱歉，小度没找到");
                  }
                  dismissWaitProgressDialog();
                  return;
                  onRouterPlanTipShow((BNRoutePlanObserver.FailArg)paramObject);
                  BNRoutePlaner.getInstance().setGuideSceneType(1);
                  BNRoutePlaner.getInstance().setGuideEndType(0);
                  BNRouteGuider.getInstance().setGuideEndType(0);
                  return;
                  dismissWaitProgressDialog();
                  onRouterPlanFailReasonShow((BNRoutePlanObserver.FailArg)paramObject);
                  BNRoutePlaner.getInstance().setGuideSceneType(1);
                  BNRoutePlaner.getInstance().setGuideEndType(0);
                  BNRouteGuider.getInstance().setGuideEndType(0);
                  return;
                  onRouterPlanTipShow((BNRoutePlanObserver.FailArg)paramObject);
                  BNRoutePlaner.getInstance().setGuideSceneType(1);
                  BNRoutePlaner.getInstance().setGuideEndType(0);
                  BNRouteGuider.getInstance().setGuideEndType(0);
                  return;
                  if (8 == paramInt2)
                  {
                    paramBNSubject = (BNRoutePlanObserver.LackDataArg)paramObject;
                    showMessageDialog((Context)this.mActivity.get(), JarUtils.getResources().getString(1711669603, new Object[] { paramBNSubject.mLackDataText }));
                    return;
                  }
                } while (9 != paramInt2);
                dismissMessageDialog();
                return;
                if (8 == paramInt2)
                {
                  paramBNSubject = (BNRoutePlanObserver.ConfirmArg)paramObject;
                  showRoutePlanAvoidTrafficJamDialog((Context)this.mActivity.get(), JarUtils.getResources().getString(1711669605), JarUtils.getResources().getString(1711669606), paramBNSubject.mConfirmListener, new View.OnClickListener()
                  {
                    public void onClick(View paramAnonymousView)
                    {
                      RoutePlanObserver.this.dismissRoutePlanAvoidTrafficJamDialog();
                    }
                  });
                  return;
                }
              } while (9 != paramInt2);
              dismissRoutePlanAvoidTrafficJamDialog();
              return;
              if (8 == paramInt2)
              {
                paramBNSubject = (BNRoutePlanObserver.ConfirmOTArg)paramObject;
                paramObject = paramBNSubject.mTipStr;
                paramObject = "小度需要" + (String)paramObject + "数据，才可以带您去这里，请选择：";
                showRoutePlanNetworkingDialog((Context)this.mActivity.get(), (String)paramObject, JarUtils.getResources().getString(1711669604), paramBNSubject.mConfirmListener, new BNBaseDialog.OnNaviClickListener()
                {
                  public void onClick()
                  {
                    RoutePlanObserver.this.dismissRoutePlanNetworkingDialog();
                    if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
                      RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
                    }
                  }
                });
                return;
              }
            } while (9 != paramInt2);
            dismissRoutePlanNetworkingDialog();
            return;
          } while (BNRoutePlaner.getInstance().isGuideEnd());
          if (16 == paramInt2)
          {
            paramBNSubject = (BNRoutePlanObserver.ConfirmOTArg)paramObject;
            showRoutePlanOvertimeDialog((Context)this.mActivity.get(), paramBNSubject.mConfirmListener, new BNBaseDialog.OnNaviClickListener()
            {
              public void onClick()
              {
                RoutePlanObserver.this.dismissRoutePlanOvertimeDialog();
              }
            });
            return;
          }
        } while (17 != paramInt2);
        dismissRoutePlanOvertimeDialog();
        return;
        if (18 == paramInt2)
        {
          showRoutePlanNoNetNoDataDialog((Context)this.mActivity.get(), (String)paramObject);
          return;
        }
      } while (19 != paramInt2);
      dismissRoutePlanNoNetNoDataDialog();
      return;
      if (8 == paramInt2)
      {
        paramBNSubject = (BNRoutePlanObserver.ConfirmOTArg)paramObject;
        showRoutePlanFirstCalcDialog((Context)this.mActivity.get(), paramBNSubject.mConfirmListener);
        return;
      }
    } while (9 != paramInt2);
    dismissRoutePlanNoNetNoDataDialog();
  }
  
  public static abstract interface IJumpToDownloadListener
  {
    public abstract void onJumpToDownloadOfflineData();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/RoutePlanObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */