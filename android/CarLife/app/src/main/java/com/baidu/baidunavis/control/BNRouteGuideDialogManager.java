package com.baidu.baidunavis.control;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.dialog.k;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController.RouteGuideDialogManagerInterface;
import com.baidu.navisdk.ui.routeguide.model.RGNaviQuitModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class BNRouteGuideDialogManager
{
  private static final String TAG = "RouteGuide";
  private Context mActivity;
  private com.baidu.carlife.view.dialog.c mExitDialog;
  private com.baidu.carlife.view.dialog.c mGPSSettingDialog;
  private boolean mIsDebugLogOn = false;
  private com.baidu.carlife.view.dialog.c mNaviQuitDialog;
  private com.baidu.carlife.core.screen.e mOnDialogListener;
  private com.baidu.carlife.view.dialog.c mReCalcExitDialog;
  private RGMapModeViewController.RouteGuideDialogManagerInterface mRouteGuideDialogManagerInterface = new RGMapModeViewController.RouteGuideDialogManagerInterface()
  {
    public void dismissGPSSettingDialog()
    {
      BNRouteGuideDialogManager.this.dismissGPSSettingDialogCarlife();
    }
    
    public void dismissLoading()
    {
      BNRouteGuideDialogManager.this.dismissLoadingCarLife();
    }
    
    public void dismissQuitDialog()
    {
      BNRouteGuideDialogManager.this.dismissQuitDialogCarlife();
    }
    
    public void dismissYawingLoading()
    {
      BNRouteGuideDialogManager.this.dismissYawingLoadingCarlife();
    }
    
    public void hideAllDialogs()
    {
      BNRouteGuideDialogManager.this.hideAllDialogsCarlife();
    }
    
    public void hideViaComfirmDialog()
    {
      BNRouteGuideDialogManager.this.hideViaComfirmDialogCarlife();
    }
    
    public void releaseAllDialogs()
    {
      BNRouteGuideDialogManager.this.releaseAllDialogsCarlife();
    }
    
    public void showGPSSettingDialog()
    {
      BNRouteGuideDialogManager.this.showGPSSettingDialogCarlife();
    }
    
    public void showLoading(String paramAnonymousString, DialogInterface.OnCancelListener paramAnonymousOnCancelListener)
    {
      BNRouteGuideDialogManager.this.showLoadingCarLife(paramAnonymousString, paramAnonymousOnCancelListener);
    }
    
    public void showQuitDialog(boolean paramAnonymousBoolean)
    {
      BNRouteGuideDialogManager.this.showQuitDialogCarlife(paramAnonymousBoolean);
    }
    
    public void showReCalRouteQuitDialog()
    {
      BNRouteGuideDialogManager.this.showReCalRouteQuitDialogCarLife();
    }
    
    public void showViaComfirmDialog()
    {
      BNRouteGuideDialogManager.this.showViaComfirmDialogCarlife();
    }
    
    public void showYawingLoading(String paramAnonymousString)
    {
      BNRouteGuideDialogManager.this.showYawingLoadingCarlife(paramAnonymousString);
    }
    
    public void showYawingQuitDialog()
    {
      BNRouteGuideDialogManager.this.showYawingQuitDialogCarlife();
    }
  };
  private com.baidu.carlife.view.dialog.c mViaComfirmDialog;
  
  public BNRouteGuideDialogManager(Context paramContext, com.baidu.carlife.core.screen.e parame)
  {
    this.mActivity = paramContext;
    this.mOnDialogListener = parame;
  }
  
  public void dismissGPSSettingDialogCarlife()
  {
    try
    {
      this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
      return;
    }
    catch (Exception localException)
    {
      this.mGPSSettingDialog = null;
    }
  }
  
  public void dismissLoadingCarLife()
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().c();
  }
  
  public void dismissQuitDialogCarlife()
  {
    try
    {
      this.mOnDialogListener.dismissDialog(this.mNaviQuitDialog);
      return;
    }
    catch (Exception localException)
    {
      this.mNaviQuitDialog = null;
    }
  }
  
  public void dismissYawingLoadingCarlife()
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().c();
  }
  
  public RGMapModeViewController.RouteGuideDialogManagerInterface getRouteGuideDialogManagerInterface()
  {
    return this.mRouteGuideDialogManagerInterface;
  }
  
  public void hideAllDialogsCarlife()
  {
    try
    {
      this.mOnDialogListener.dismissDialog(this.mExitDialog);
      return;
    }
    catch (Exception localException)
    {
      this.mExitDialog = null;
    }
  }
  
  public void hideViaComfirmDialogCarlife()
  {
    try
    {
      this.mOnDialogListener.dismissDialog(this.mViaComfirmDialog);
      return;
    }
    catch (Exception localException)
    {
      this.mViaComfirmDialog = null;
    }
  }
  
  public void releaseAllDialogsCarlife()
  {
    this.mNaviQuitDialog = null;
    this.mGPSSettingDialog = null;
    hideAllDialogsCarlife();
  }
  
  public void showGPSSettingDialogCarlife()
  {
    try
    {
      if (this.mGPSSettingDialog == null) {
        this.mGPSSettingDialog = new com.baidu.carlife.view.dialog.c(this.mActivity).c(JarUtils.getResources().getString(1711669372)).b(JarUtils.getResources().getString(1711669402)).d(JarUtils.getResources().getString(1711669403)).q().a(new b()
        {
          public void onClick()
          {
            try
            {
              Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
              localIntent.addFlags(268435456);
              BNRouteGuideDialogManager.this.mActivity.startActivity(localIntent);
              return;
            }
            catch (Exception localException)
            {
              LogUtil.e("", localException.toString());
              TipTool.onCreateToastDialog(BNRouteGuideDialogManager.this.mActivity, JarUtils.getResources().getString(1711669421));
            }
          }
        }).e(JarUtils.getResources().getString(1711669373)).b(new b()
        {
          public void onClick()
          {
            TipTool.onCreateToastDialog(BNRouteGuideDialogManager.this.mActivity, JarUtils.getResources().getString(1711669415));
          }
        });
      }
      this.mOnDialogListener.showDialog(this.mGPSSettingDialog);
      return;
    }
    catch (Exception localException)
    {
      this.mGPSSettingDialog = null;
    }
  }
  
  public void showLoadingCarLife(String paramString, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    try
    {
      com.baidu.carlife.core.screen.presentation.a.e.a().a(paramString, new b()
      {
        public void onClick()
        {
          if (paramOnCancelListener != null) {
            paramOnCancelListener.onCancel(null);
          }
        }
      });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void showQuitDialogCarlife(boolean paramBoolean)
  {
    dismissQuitDialogCarlife();
    try
    {
      this.mNaviQuitDialog = new com.baidu.carlife.view.dialog.c(this.mActivity).a(2131296785).c(2131296788).a(new b()
      {
        public void onClick()
        {
          UgcNaviDynamicMarkRespository.getInstance().clear();
          RGNaviQuitModel.getInstance().setCountDown(false);
          RGViewController.getInstance().quitNavWhenConfirm();
        }
      });
      this.mNaviQuitDialog.setDialogShowHideListener(new k()
      {
        public void onDismiss()
        {
          if (BNRouteGuideDialogManager.this.mIsDebugLogOn) {
            w.a("dialog dismiss", 0);
          }
          BottomTabDisplayController.getInstance().panelHide();
        }
        
        public void onShow()
        {
          if (BNRouteGuideDialogManager.this.mIsDebugLogOn) {
            w.a("dialog show", 0);
          }
          BottomTabDisplayController.getInstance().panelShow();
        }
      });
      if (!BNNaviResultModel.getInstance().isDestArrived())
      {
        this.mNaviQuitDialog.a(2131296787);
        this.mNaviQuitDialog.d(2131296786);
      }
      if (paramBoolean)
      {
        this.mNaviQuitDialog.a(1, 10);
        this.mNaviQuitDialog.a(new com.baidu.carlife.core.screen.c()
        {
          public void onCountDown(int paramAnonymousInt)
          {
            if (paramAnonymousInt <= 0)
            {
              RGViewController.getInstance().quitNavWhenConfirm();
              BNRouteGuideDialogManager.this.mOnDialogListener.dismissDialog(BNRouteGuideDialogManager.this.mNaviQuitDialog);
            }
          }
        });
      }
      if (paramBoolean) {
        this.mOnDialogListener.dismissDialog(this.mNaviQuitDialog);
      }
      this.mOnDialogListener.showDialog(this.mNaviQuitDialog);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void showReCalRouteQuitDialogCarLife()
  {
    if (this.mActivity == null)
    {
      LogUtil.e("RouteGuide", "showReCalRouteQuitDialog mActivity == null");
      BNRoutePlaner.getInstance().cancleCalcRouteRequest();
      BNRoutePlaner.getInstance().clearRouteInfoHandler();
      return;
    }
    dismissQuitDialogCarlife();
    try
    {
      com.baidu.carlife.view.dialog.c localc = new com.baidu.carlife.view.dialog.c(this.mActivity).c(BNStyleManager.getString(1711669372));
      if (BNavConfig.pRGLocateMode == 2) {}
      for (String str = BNStyleManager.getString(1711669370);; str = BNStyleManager.getString(1711669424))
      {
        this.mReCalcExitDialog = localc.b(str).e(BNStyleManager.getString(1711669373)).r().b(new b()
        {
          public void onClick()
          {
            BNRoutePlaner.getInstance().showReCalRouteProgressDialog();
          }
        }).d(BNStyleManager.getString(1711669367)).q().a(new b()
        {
          public void onClick()
          {
            BNRoutePlaner.getInstance().cancleCalcRouteRequest();
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
          }
        });
        this.mOnDialogListener.showDialog(this.mReCalcExitDialog);
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void showViaComfirmDialogCarlife()
  {
    if (this.mActivity == null) {
      return;
    }
    hideViaComfirmDialogCarlife();
    try
    {
      this.mViaComfirmDialog = new com.baidu.carlife.view.dialog.c(this.mActivity).c(BNStyleManager.getString(1711669372)).b(BNStyleManager.getString(1711670029)).g(17).e(BNStyleManager.getString(1711669367)).r().b(new b()
      {
        public void onClick()
        {
          if (RGRouteSearchModel.getInstance().isRouteSearchMode())
          {
            RGRouteSearchModel.getInstance().setRouteSearchMode(false);
            BNPoiSearcher.getInstance().clearBkgCache();
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().showLayer(4, false);
          }
          RGEngineControl localRGEngineControl = RGEngineControl.getInstance();
          GeoPoint localGeoPoint = RGPickPointModel.getInstance().getPickPoint();
          if (RGPickPointModel.getInstance().getAntiSearchPoi() != null) {}
          for (String str = RGPickPointModel.getInstance().getAntiSearchPoi().mName;; str = "")
          {
            localRGEngineControl.addViaPtToCalcRoute(localGeoPoint, str);
            return;
          }
        }
      }).d(BNStyleManager.getString(1711669373));
      this.mOnDialogListener.showDialog(this.mViaComfirmDialog);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void showYawingLoadingCarlife(String paramString)
  {
    try
    {
      NavMapAdapter.getInstance().closeCarLifeVR();
      com.baidu.carlife.core.screen.presentation.a.e.a().a(paramString, new b()new d
      {
        public void onClick()
        {
          BNRouteGuideDialogManager.this.showYawingQuitDialogCarlife();
        }
      }, new d()
      {
        public void onCancel()
        {
          BNRouteGuideDialogManager.this.showYawingQuitDialogCarlife();
        }
      });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void showYawingQuitDialogCarlife()
  {
    if (this.mActivity == null) {
      return;
    }
    dismissQuitDialogCarlife();
    try
    {
      this.mExitDialog = new com.baidu.carlife.view.dialog.c(this.mActivity).c(BNStyleManager.getString(1711669372)).b(BNStyleManager.getString(1711669424)).e(BNStyleManager.getString(1711669373)).r().b(new b()
      {
        public void onClick()
        {
          BNRouteGuideDialogManager.this.showYawingLoadingCarlife(BNStyleManager.getString(1711669422));
        }
      }).d(BNStyleManager.getString(1711669367)).q().a(new b()
      {
        public void onClick()
        {
          RGViewController.getInstance().dismissHUDDialog();
          RGViewController.getInstance().quitNavWhenConfirm();
        }
      });
      this.mOnDialogListener.showDialog(this.mExitDialog);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/BNRouteGuideDialogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */