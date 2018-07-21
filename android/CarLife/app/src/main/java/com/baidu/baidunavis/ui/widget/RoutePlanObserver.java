package com.baidu.baidunavis.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.routedetails.proxy.RGRouteDetailsViewController;
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
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RoutePlanObserver
  implements BNRoutePlanObserver
{
  private static BNNetworkingDialog mRoutePlanAvoidTrafficJamDialog;
  private static c mRoutePlanFirstCalcDialog = null;
  private static c mRoutePlanNetworkingDialog = null;
  private static c mRoutePlanNoNetNoDataDialog;
  private static c mRoutePlanOvertimeDialog;
  private IJumpToDownloadListener mIIJumpToDownloadListener = null;
  private c mNaviMessageDialog = null;
  private e mOnDialogListener;
  
  static
  {
    mRoutePlanAvoidTrafficJamDialog = null;
    mRoutePlanOvertimeDialog = null;
    mRoutePlanNoNetNoDataDialog = null;
  }
  
  public RoutePlanObserver(IJumpToDownloadListener paramIJumpToDownloadListener)
  {
    this(paramIJumpToDownloadListener, g.a().b());
  }
  
  public RoutePlanObserver(IJumpToDownloadListener paramIJumpToDownloadListener, e parame)
  {
    this.mIIJumpToDownloadListener = paramIJumpToDownloadListener;
    this.mOnDialogListener = parame;
  }
  
  private void cancleCalcRoute()
  {
    LogUtil.e("RoutePlan", "WaitProgress onCancel!");
    if (BNavigator.getInstance().isNaviBegin())
    {
      RGViewController.getInstance().showReCalRouteQuitDialog();
      return;
    }
    BNRoutePlaner.getInstance().cancleCalcRouteRequest();
    BNRoutePlaner.getInstance().clearRouteInfoHandler();
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
    this.mOnDialogListener.dismissDialog(this.mNaviMessageDialog);
    return true;
  }
  
  public boolean dismissRoutePlanAvoidTrafficJamDialog()
  {
    if ((mRoutePlanAvoidTrafficJamDialog != null) && (mRoutePlanAvoidTrafficJamDialog.isShowing())) {}
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
    this.mOnDialogListener.showDialog(mRoutePlanFirstCalcDialog);
    return true;
  }
  
  public boolean dismissRoutePlanNetworkingDialog()
  {
    this.mOnDialogListener.showDialog(mRoutePlanNetworkingDialog);
    return true;
  }
  
  public boolean dismissRoutePlanNoNetNoDataDialog()
  {
    this.mOnDialogListener.dismissDialog(mRoutePlanNoNetNoDataDialog);
    return true;
  }
  
  public boolean dismissRoutePlanOvertimeDialog()
  {
    this.mOnDialogListener.dismissDialog(mRoutePlanOvertimeDialog);
    return true;
  }
  
  public boolean dismissWaitProgressDialog()
  {
    NavMapAdapter.getInstance().dismissWaitProgressDialog();
    return true;
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
      TipTool.onCreateToastDialog(a.a(), paramFailArg.mFailText + getDebugToastMessage(paramFailArg));
      return;
    case 420: 
      str = a.a().getString(2131296729);
      TipTool.onCreateToastDialog(a.a(), str + getDebugToastMessage(paramFailArg));
      return;
    }
    String str = a.a().getString(2131296712);
    TipTool.onCreateToastDialog(a.a(), str + getDebugToastMessage(paramFailArg));
  }
  
  public void onRouterPlanTipShow(BNRoutePlanObserver.FailArg paramFailArg)
  {
    TipTool.onCreateToastDialog(a.a(), paramFailArg.mFailText + getDebugToastMessage(paramFailArg));
  }
  
  public void showMessageDialog(Context paramContext, String paramString)
  {
    dismissMessageDialog();
    if ((this.mNaviMessageDialog == null) && (paramContext != null)) {
      this.mNaviMessageDialog = new c(paramContext).b(paramString).c(JarUtils.getResources().getString(1711669600)).a(true).d(JarUtils.getResources().getString(1711669607));
    }
    this.mOnDialogListener.showDialog(this.mNaviMessageDialog);
  }
  
  public void showRoutePlanAvoidTrafficJamDialog(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    dismissRoutePlanAvoidTrafficJamDialog();
    if (mRoutePlanAvoidTrafficJamDialog == null) {
      mRoutePlanAvoidTrafficJamDialog = new BNNetworkingDialog((Activity)paramContext).setNetworkingContentMessage(paramString1).setConfirmNetworkMessage(paramString2).setConfirmNetworkingListener(paramOnClickListener1).setCancleListener(paramOnClickListener2).setTwoButtonMode(true);
    }
    if (mRoutePlanAvoidTrafficJamDialog != null) {}
    try
    {
      mRoutePlanAvoidTrafficJamDialog.show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void showRoutePlanFirstCalcDialog(Context paramContext, final BNBaseDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    dismissRoutePlanFirstCalcDialog();
    if (mRoutePlanFirstCalcDialog == null) {
      mRoutePlanFirstCalcDialog = new c(a.a()).c(JarUtils.getResources().getString(1711669600)).b(JarUtils.getResources().getString(1711669619)).b(false).d(JarUtils.getResources().getString(1711669607)).a(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener != null) {
            paramOnNaviClickListener.onClick();
          }
        }
      });
    }
    this.mOnDialogListener.showDialog(mRoutePlanFirstCalcDialog);
  }
  
  public void showRoutePlanNetworkingDialog(Context paramContext, String paramString1, String paramString2, final BNBaseDialog.OnNaviClickListener paramOnNaviClickListener1, final BNBaseDialog.OnNaviClickListener paramOnNaviClickListener2)
  {
    dismissRoutePlanNetworkingDialog();
    if (mRoutePlanNetworkingDialog == null) {
      mRoutePlanNetworkingDialog = new c(paramContext).c(JarUtils.getResources().getString(1711669600)).b(paramString1).d(JarUtils.getResources().getString(1711669617)).e(JarUtils.getResources().getString(1711669618)).a(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener2 != null) {
            paramOnNaviClickListener2.onClick();
          }
        }
      }).b(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener1 != null) {
            paramOnNaviClickListener1.onClick();
          }
        }
      });
    }
    this.mOnDialogListener.showDialog(mRoutePlanNetworkingDialog);
  }
  
  public void showRoutePlanNoNetNoDataDialog(final Context paramContext, String paramString)
  {
    dismissRoutePlanNoNetNoDataDialog();
    if (mRoutePlanNoNetNoDataDialog == null) {
      mRoutePlanNoNetNoDataDialog = new c(paramContext).c(JarUtils.getResources().getString(1711669600)).b(JarUtils.getResources().getString(1711669615) + "\n缺失以下数据：" + paramString).d(JarUtils.getResources().getString(1711669617)).e(JarUtils.getResources().getString(1711669616)).a(new b()
      {
        public void onClick()
        {
          RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
          if (RoutePlanObserver.this.mIIJumpToDownloadListener != null) {
            RoutePlanObserver.this.mIIJumpToDownloadListener.onJumpToDownloadOfflineData();
          }
        }
      }).b(new b()
      {
        public void onClick()
        {
          RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
          Intent localIntent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
          localIntent.addFlags(268435456);
          paramContext.startActivity(localIntent);
        }
      });
    }
    this.mOnDialogListener.showDialog(mRoutePlanNoNetNoDataDialog);
  }
  
  public void showRoutePlanOvertimeDialog(Context paramContext, final BNBaseDialog.OnNaviClickListener paramOnNaviClickListener1, final BNBaseDialog.OnNaviClickListener paramOnNaviClickListener2)
  {
    dismissRoutePlanOvertimeDialog();
    if (mRoutePlanOvertimeDialog == null) {
      mRoutePlanOvertimeDialog = new c(paramContext).c(JarUtils.getResources().getString(1711669600)).b(JarUtils.getResources().getString(1711669614)).d(JarUtils.getResources().getString(1711669612)).e(JarUtils.getResources().getString(1711669613)).a(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener2 != null) {
            paramOnNaviClickListener2.onClick();
          }
        }
      }).b(new b()
      {
        public void onClick()
        {
          if (paramOnNaviClickListener1 != null) {
            paramOnNaviClickListener1.onClick();
          }
        }
      });
    }
    this.mOnDialogListener.showDialog(mRoutePlanOvertimeDialog);
  }
  
  public void showWaitProgressDialog(Context paramContext)
  {
    dismissWaitProgressDialog();
    try
    {
      NavMapAdapter.getInstance().showProgressDialog(getRoutePlanTipsMsg(), new b()new d
      {
        public void onClick()
        {
          RoutePlanObserver.this.cancleCalcRoute();
        }
      }, new d()
      {
        public void onCancel()
        {
          RoutePlanObserver.this.cancleCalcRoute();
        }
      });
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
                    } while ((!RGRouteDetailsViewController.getInstance().isRouteDetail()) && (!BNavigator.getInstance().isNaviBegin()));
                    showWaitProgressDialog(a.a());
                    return;
                  } while ((!RGRouteDetailsViewController.getInstance().isRouteDetail()) && (!BNavigator.getInstance().isNaviBegin()));
                  dismissWaitProgressDialog();
                  return;
                  TipTool.onCreateToastDialog(a.a(), 2131296921);
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
                    showMessageDialog(a.a(), JarUtils.getResources().getString(1711669603, new Object[] { paramBNSubject.mLackDataText }));
                    return;
                  }
                } while (9 != paramInt2);
                dismissMessageDialog();
                return;
                if (8 == paramInt2)
                {
                  paramBNSubject = (BNRoutePlanObserver.ConfirmArg)paramObject;
                  showRoutePlanAvoidTrafficJamDialog(a.a(), JarUtils.getResources().getString(1711669605), JarUtils.getResources().getString(1711669606), paramBNSubject.mConfirmListener, new View.OnClickListener()
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
                showRoutePlanNetworkingDialog(a.a(), (String)paramObject, JarUtils.getResources().getString(1711669604), paramBNSubject.mConfirmListener, new BNBaseDialog.OnNaviClickListener()
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
            showRoutePlanOvertimeDialog(a.a(), paramBNSubject.mConfirmListener, new BNBaseDialog.OnNaviClickListener()
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
          showRoutePlanNoNetNoDataDialog(a.a(), (String)paramObject);
          return;
        }
      } while (19 != paramInt2);
      dismissRoutePlanNoNetNoDataDialog();
      return;
      if (8 == paramInt2)
      {
        paramBNSubject = (BNRoutePlanObserver.ConfirmOTArg)paramObject;
        showRoutePlanFirstCalcDialog(a.a(), paramBNSubject.mConfirmListener);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/widget/RoutePlanObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */