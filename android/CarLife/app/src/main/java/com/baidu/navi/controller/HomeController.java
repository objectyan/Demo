package com.baidu.navi.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager.DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviCurRoutePoiModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class HomeController
{
  private DBManager.DBOperateResultCallback callback = new DBManager.DBOperateResultCallback()
  {
    public void onAddOrDeleteSuccess() {}
    
    public void onQuerySuccess()
    {
      ArrayList localArrayList = NaviCurRoutePoiModel.getInstance().getLastNaviNodesList();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        RoutePlanNode localRoutePlanNode1 = BNLocationManagerProxy.getInstance().getCurLocationNode();
        if (localRoutePlanNode1 != null)
        {
          RoutePlanNode localRoutePlanNode2 = (RoutePlanNode)localArrayList.get(localArrayList.size() - 1);
          if (HomeController.this.calcTwoPointsDistance(localRoutePlanNode1.mGeoPoint, localRoutePlanNode2.mGeoPoint) > 200)
          {
            localArrayList.add(0, localRoutePlanNode1);
            HomeController.this.showContinueLastNaviDialog(localArrayList);
          }
        }
        DBManager.clearLastnaviPoints();
      }
    }
  };
  private Context mContext;
  private c mContinueDownloadDataInWifiDialog;
  private c mContinueLastNaviDialog;
  private c mDataInfoDialog;
  private h mFragmentManager;
  private c mGPSSettingDialog;
  private IHomeControllerListener mListener;
  private e mOnDialogListener;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4: 
        if (HomeController.this.mFragmentManager != null) {
          HomeController.this.mFragmentManager.showFragment(52, null);
        }
        BNRoutePlaner.getInstance().removeRouteResultHandler(HomeController.this.mRPHandler);
        return;
      case 7: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(HomeController.this.mRPHandler);
        return;
      }
      BNRoutePlaner.getInstance().removeRouteResultHandler(HomeController.this.mRPHandler);
    }
  };
  
  public HomeController(Context paramContext, e parame)
  {
    this.mContext = paramContext;
    this.mOnDialogListener = parame;
    this.mFragmentManager = h.a();
  }
  
  public int calcTwoPointsDistance(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if ((paramGeoPoint1 == null) || (!paramGeoPoint1.isValid()) || (paramGeoPoint2 == null) || (!paramGeoPoint2.isValid())) {
      return 0;
    }
    double d1 = paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6();
    double d2 = paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6();
    return (int)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public void checkNewVerDataAndUpgrade()
  {
    new HomeCheckNewController(this.mContext, this.mOnDialogListener).startCheckNewThread();
  }
  
  public void checkValidOfflineData()
  {
    checkValidOfflineData(BNOfflineDataManager.getInstance().haveValidData());
  }
  
  public void checkValidOfflineData(boolean paramBoolean)
  {
    if (!PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_SHOW_ONLINE_USE", true)) {}
    String str;
    do
    {
      return;
      str = null;
      if (!paramBoolean) {
        str = this.mContext.getString(2131296283);
      }
      if (BNOfflineDataManager.getInstance().isProvinceDownloadCommonNotDownload()) {
        str = this.mContext.getString(2131296263);
      }
    } while (str == null);
    showNoOfflineDataDialog(str);
  }
  
  public void dismissGPSSettingDialog()
  {
    if (this.mOnDialogListener.isDialogShown()) {
      this.mOnDialogListener.dismissDialog(this.mGPSSettingDialog);
    }
    this.mGPSSettingDialog = null;
  }
  
  public boolean isContinueLastNaviDialogShowing()
  {
    return (this.mContinueLastNaviDialog != null) && (this.mOnDialogListener.isDialogShown());
  }
  
  public boolean isOnlineUseDialogShowing()
  {
    return (this.mDataInfoDialog != null) && (this.mOnDialogListener.isDialogShown());
  }
  
  public void showContinueLastNaviDialog(ArrayList<RoutePlanNode> paramArrayList)
  {
    if (this.mContinueLastNaviDialog == null)
    {
      this.mContinueLastNaviDialog = new c(this.mContext).b(2131296284).a(2131296266).c(2131296400).q().d(2131296399);
      this.mContinueLastNaviDialog.a(new b()
      {
        public void onClick()
        {
          BNRoutePlaner.getInstance().addRouteResultHandler(HomeController.this.mRPHandler);
        }
      });
    }
    if (!this.mOnDialogListener.isDialogShown()) {
      this.mOnDialogListener.showDialog(this.mContinueLastNaviDialog, BaseDialog.a.a);
    }
  }
  
  public void showGPSSettingDialog()
  {
    if (this.mOnDialogListener.isDialogShown()) {
      return;
    }
    if (this.mGPSSettingDialog == null)
    {
      this.mGPSSettingDialog = new c(this.mContext).b(2131296443).a(2131296277).c(2131296278).q().d(2131296280);
      this.mGPSSettingDialog.a(new b()
      {
        public void onClick()
        {
          try
          {
            Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            localIntent.addFlags(268435456);
            HomeController.this.mContext.startActivity(localIntent);
            return;
          }
          catch (Exception localException)
          {
            String str = HomeController.this.mContext.getString(2131296708);
            TipTool.onCreateToastDialog(HomeController.this.mContext, str);
          }
        }
      });
    }
    this.mOnDialogListener.showDialog(this.mGPSSettingDialog, BaseDialog.a.a);
  }
  
  public void showNoOfflineDataDialog(String paramString)
  {
    if (this.mDataInfoDialog == null)
    {
      this.mDataInfoDialog = new c(this.mContext).b(paramString).c(2131296276).q().d(2131296285);
      this.mDataInfoDialog.a(new b()
      {
        public void onClick()
        {
          PreferenceHelper.getInstance(HomeController.this.mContext).putBoolean("NAVI_SHOW_ONLINE_USE", false);
          if (HomeController.this.mOnDialogListener != null) {
            HomeController.this.mOnDialogListener.dismissDialog(HomeController.this.mDataInfoDialog);
          }
          HomeController.this.mFragmentManager.showFragment(554, null);
          if (HomeController.this.mListener != null) {
            HomeController.this.mListener.onShowOfflineDataPage();
          }
        }
      });
      this.mDataInfoDialog.b(new b()
      {
        public void onClick()
        {
          PreferenceHelper.getInstance(HomeController.this.mContext).putBoolean("NAVI_SHOW_ONLINE_USE", false);
          if (HomeController.this.mOnDialogListener != null) {
            HomeController.this.mOnDialogListener.dismissDialog(HomeController.this.mDataInfoDialog);
          }
        }
      });
    }
    if (this.mOnDialogListener != null) {
      this.mOnDialogListener.showDialog(this.mDataInfoDialog, BaseDialog.a.a);
    }
  }
  
  public static abstract interface IHomeControllerListener
  {
    public abstract void onShowOfflineDataPage();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/HomeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */