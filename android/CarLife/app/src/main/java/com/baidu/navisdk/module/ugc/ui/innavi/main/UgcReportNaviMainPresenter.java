package com.baidu.navisdk.module.ugc.ui.innavi.main;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils.ScreenShotCallBack;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract.View;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailView;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.IOException;
import org.json.JSONObject;

public class UgcReportNaviMainPresenter
  implements UgcReportNaviMainContract.Presenter
{
  private static final int MAX_TIME_COUNT = 10;
  private static final int MSG_TIMES_COUNT_WAHT = 1;
  public static UgcReportInfoUploadPackage statusPackage = null;
  private Handler coutTimesHandler;
  private UgcImageLoaderUtils imageLoaderUtils = null;
  public boolean isIpoNavi = false;
  private boolean isTipsDynamic;
  private CallBackListener mListener;
  private ViewGroup mMenuViewContainer;
  private UgcReportNaviMainContract.View mRootView = null;
  private UgcReportNaviSubDetailPresenter mSubPrensenter = null;
  private UgcDataProvider.UgcLayout mUgcLayout;
  private int pageStatus = 0;
  private int parPosition;
  private UgcReportInfoUploadPackage reportInfoPackage = null;
  private int tipsPosition;
  
  public UgcReportNaviMainPresenter(UgcReportNaviMainContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout, CallBackListener paramCallBackListener)
  {
    initVariable(paramView, paramCallBackListener, paramUgcLayout);
  }
  
  private ViewGroup getRootViewContainer()
  {
    return this.mMenuViewContainer;
  }
  
  private void initVariable(UgcReportNaviMainContract.View paramView, CallBackListener paramCallBackListener, UgcDataProvider.UgcLayout paramUgcLayout)
  {
    this.mRootView = paramView;
    this.mListener = paramCallBackListener;
    this.mUgcLayout = paramUgcLayout;
    this.pageStatus = 0;
    this.imageLoaderUtils = new UgcImageLoaderUtils();
    this.reportInfoPackage = new UgcReportInfoUploadPackage();
    paramView.setPresenter(this);
  }
  
  private void showUploadView(int paramInt, boolean paramBoolean)
  {
    statusPackage.isInSubView = true;
    this.tipsPosition = paramInt;
    this.isTipsDynamic = paramBoolean;
    this.pageStatus = 1;
    if (this.mRootView != null) {
      this.mRootView.initUploadView();
    }
    if (paramBoolean) {
      this.mRootView.hideTipItemIv();
    }
    if ((this.reportInfoPackage != null) && (this.mUgcLayout != null))
    {
      if (!paramBoolean) {
        break label132;
      }
      this.reportInfoPackage.parentType = this.mUgcLayout.getDynamicItemsType(this.tipsPosition);
      this.reportInfoPackage.mark = 1;
    }
    for (;;)
    {
      statusPackage.parentType = this.reportInfoPackage.parentType;
      statusPackage.mark = this.reportInfoPackage.mark;
      statusPackage.mainPosition = this.tipsPosition;
      return;
      label132:
      this.reportInfoPackage.parentType = this.mUgcLayout.getMainItemsType(this.tipsPosition);
    }
  }
  
  private void startTimesCounts()
  {
    if (this.coutTimesHandler == null) {
      this.coutTimesHandler = new Handler(Looper.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (UgcReportNaviMainPresenter.this.coutTimesHandler == null) {
            return;
          }
          UgcReportNaviMainPresenter.this.coutTimesHandler.removeMessages(1);
          int i = paramAnonymousMessage.arg1 - 1;
          if (i <= 0)
          {
            UgcReportNaviMainPresenter.this.mRootView.showCurTimes(i);
            UgcReportNaviMainPresenter.this.simpleUpload();
            return;
          }
          UgcReportNaviMainPresenter.this.mRootView.showCurTimes(i);
          UgcReportNaviMainPresenter.this.coutTimesHandler.sendMessageDelayed(UgcReportNaviMainPresenter.this.coutTimesHandler.obtainMessage(1, i, 0), 1000L);
        }
      };
    }
    this.mRootView.showCurTimes(10);
    this.coutTimesHandler.sendMessageDelayed(this.coutTimesHandler.obtainMessage(1, 10, 0), 1000L);
  }
  
  private void stopTimesCounts()
  {
    if (this.coutTimesHandler != null)
    {
      this.coutTimesHandler.removeMessages(1);
      this.coutTimesHandler = null;
    }
  }
  
  public boolean checkBaseRequire()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670288));
      return false;
    }
    if (this.reportInfoPackage == null) {
      this.reportInfoPackage = new UgcReportInfoUploadPackage();
    }
    this.reportInfoPackage.userPoint = getCurrentLocationPoint();
    if (TextUtils.isEmpty(this.reportInfoPackage.userPoint))
    {
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "请开启卫星定位");
      return false;
    }
    statusPackage.userPoint = this.reportInfoPackage.userPoint;
    Bundle localBundle = new Bundle();
    BNRouteGuider.getInstance().getVehicleInfo(localBundle);
    if (localBundle != null) {}
    try
    {
      localBundle = CoordinateTransformUtil.LL2MC(localBundle.getDouble("vehicle_stPosX"), localBundle.getDouble("vehicle_stPosY"));
      if (localBundle != null)
      {
        this.reportInfoPackage.point = (localBundle.getInt("MCx") + "," + localBundle.getInt("MCy"));
        statusPackage.point = this.reportInfoPackage.point;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return true;
  }
  
  public void finish()
  {
    if (this.mListener != null) {
      this.mListener.onUgcFinish();
    }
  }
  
  public String getCurrentLocationPoint()
  {
    Object localObject2 = BNSysLocationManager.getInstance().getCurLocation();
    String str = "";
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = ((LocData)localObject2).toGeoPoint();
      if (this.reportInfoPackage == null) {
        this.reportInfoPackage = new UgcReportInfoUploadPackage();
      }
      if (statusPackage == null) {
        statusPackage = new UgcReportInfoUploadPackage();
      }
      this.reportInfoPackage.mGeoPoint = ((GeoPoint)localObject1);
      statusPackage.mGeoPoint = ((GeoPoint)localObject1);
      localObject2 = CoordinateTransformUtil.LL2MC(((LocData)localObject2).longitude, ((LocData)localObject2).latitude);
      localObject1 = str;
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getInt("MCx") + "," + ((Bundle)localObject2).getInt("MCy");
      }
    }
    return (String)localObject1;
  }
  
  public int getDynamicItemsSize()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getDynamicItemsSize();
    }
    return 0;
  }
  
  public String getDynamicItemsTextTitle(int paramInt)
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getDynamicItemsTitle(paramInt);
    }
    return null;
  }
  
  public boolean getIsIpoNavi()
  {
    return this.isIpoNavi;
  }
  
  public boolean getIsTipsDynamic()
  {
    return this.isTipsDynamic;
  }
  
  public String getParentItemsGvTextTile(int paramInt)
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getMainItemsTitle(paramInt);
    }
    return null;
  }
  
  public String getUploadTipsTextTitle()
  {
    if (this.isTipsDynamic) {
      return getDynamicItemsTextTitle(this.tipsPosition);
    }
    return getParentItemsGvTextTile(this.tipsPosition);
  }
  
  public void gotoNaviSubDetailView(boolean paramBoolean)
  {
    this.pageStatus = 2;
    stopTimesCounts();
    if (statusPackage == null) {
      statusPackage = new UgcReportInfoUploadPackage();
    }
    statusPackage.isInSubView = false;
    Object localObject = new UgcReportNaviSubDetailView(this.mRootView.getContext(), this.mRootView.getOrientation());
    UgcDataProvider.UgcLayout localUgcLayout;
    if (this.isTipsDynamic)
    {
      localUgcLayout = UgcDataProvider.obtainDynamicUgcNaviSubLayout(this.tipsPosition);
      if ((paramBoolean) && (this.mSubPrensenter != null)) {
        break label200;
      }
      this.mSubPrensenter = new UgcReportNaviSubDetailPresenter(this.mRootView.getContext(), localUgcLayout, (UgcReportNaviSubDetailContract.View)localObject, this, this.reportInfoPackage);
    }
    for (;;)
    {
      ((UgcReportNaviSubDetailView)localObject).setPresenter(this.mSubPrensenter);
      localObject = ((UgcReportNaviSubDetailView)localObject).getParentView();
      this.mMenuViewContainer = this.mRootView.getParentContainer();
      if ((this.mMenuViewContainer != null) && (localObject != null))
      {
        this.mMenuViewContainer.removeAllViews();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mMenuViewContainer.addView((View)localObject, localLayoutParams);
        if (!paramBoolean) {
          break label211;
        }
        this.mSubPrensenter.onConfigurationChanged(null);
      }
      return;
      localUgcLayout = UgcDataProvider.obtainUgcNaviSubLayout(this.tipsPosition);
      break;
      label200:
      this.mSubPrensenter.setRootView((UgcReportNaviSubDetailContract.View)localObject);
    }
    label211:
    if (this.isIpoNavi)
    {
      UserOPController.getInstance().add("3.u.2", "3", null, null);
      UserOPController.getInstance().add("3.u.5", "3", localUgcLayout.getSubType() + "", null);
    }
    for (;;)
    {
      this.mSubPrensenter.start();
      return;
      UserOPController.getInstance().add("3.u.2", "2", null, null);
      UserOPController.getInstance().add("3.u.5", "2", localUgcLayout.getSubType() + "", null);
    }
  }
  
  public void gotoUploadView(int paramInt, boolean paramBoolean)
  {
    if (!checkBaseRequire()) {
      return;
    }
    if (this.isIpoNavi) {
      UserOPController.getInstance().add("3.u.4", "3", this.reportInfoPackage.parentType + "", null);
    }
    for (;;)
    {
      statusPackage.mainPosition = paramInt;
      showUploadView(paramInt, paramBoolean);
      startTimesCounts();
      return;
      UserOPController.getInstance().add("3.u.4", "2", this.reportInfoPackage.parentType + "", null);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mSubPrensenter != null) {
      this.mSubPrensenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    if (this.pageStatus == 1) {
      simpleUpload();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.mSubPrensenter != null) {
      this.mSubPrensenter.onDestroy();
    }
    stopTimesCounts();
    statusPackage = null;
  }
  
  public void orientationChanged(int paramInt)
  {
    boolean bool = true;
    if ((statusPackage == null) || (statusPackage.parentType == -1))
    {
      start();
      return;
    }
    if ((statusPackage.mainPosition != -1) && (statusPackage.isInSubView))
    {
      paramInt = statusPackage.mainPosition;
      if (statusPackage.mark == 1) {}
      for (;;)
      {
        showUploadView(paramInt, bool);
        this.reportInfoPackage.mGeoPoint = statusPackage.mGeoPoint;
        this.reportInfoPackage.userPoint = statusPackage.userPoint;
        this.reportInfoPackage.point = statusPackage.point;
        return;
        bool = false;
      }
    }
    gotoNaviSubDetailView(true);
  }
  
  public void parentDynamicItemsGvImageLoader(int paramInt, ImageView paramImageView)
  {
    if ((paramImageView != null) && (this.imageLoaderUtils != null) && (this.mUgcLayout != null)) {
      this.imageLoaderUtils.updateUgcViewOnLine(this.mUgcLayout.getDynamicItemsType(paramInt), paramImageView);
    }
  }
  
  public void parentItemsGvImageLoader(int paramInt, ImageView paramImageView)
  {
    if ((paramImageView != null) && (this.imageLoaderUtils != null) && (this.mUgcLayout != null)) {
      this.imageLoaderUtils.updateUgcViewOnLine(this.mUgcLayout.getMainItemsType(paramInt), paramImageView);
    }
  }
  
  public int parentItemsGvSize()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getMainItemsSize();
    }
    return 0;
  }
  
  public void parentTipsItemsGvImageLoader(ImageView paramImageView)
  {
    if (this.isTipsDynamic)
    {
      parentDynamicItemsGvImageLoader(this.tipsPosition, paramImageView);
      return;
    }
    parentItemsGvImageLoader(this.tipsPosition, paramImageView);
  }
  
  public void realSimpleUpload()
  {
    if (this.isIpoNavi) {
      UserOPController.getInstance().add("3.u.1", "3", this.reportInfoPackage.parentType + "", null);
    }
    for (;;)
    {
      new UgcHttps().ugcReportInfoUpLoad(this.reportInfoPackage, new UgcHttps.UgcHttpsResultCallBack()
      {
        public void onUgcInfoReportUpLoadFail(String paramAnonymousString)
        {
          if (paramAnonymousString != null) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), paramAnonymousString);
          }
          for (;;)
          {
            try
            {
              if (UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath != null) {
                FileUtils.del(UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath);
              }
              return;
            }
            catch (IOException paramAnonymousString)
            {
              paramAnonymousString.printStackTrace();
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670287));
          }
        }
        
        public void onUgcInfoReportUpLoadSuccess(JSONObject paramAnonymousJSONObject)
        {
          int j = -1;
          String str2 = null;
          String str1 = null;
          int i = j;
          if (paramAnonymousJSONObject != null) {
            str1 = str2;
          }
          try
          {
            str2 = paramAnonymousJSONObject.getString("tips");
            str1 = str2;
            i = paramAnonymousJSONObject.getInt("id");
            str1 = str2;
          }
          catch (Exception paramAnonymousJSONObject)
          {
            for (;;)
            {
              try
              {
                if (UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath != null) {
                  FileUtils.del(UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath);
                }
                return;
              }
              catch (IOException paramAnonymousJSONObject)
              {
                paramAnonymousJSONObject.printStackTrace();
              }
              paramAnonymousJSONObject = paramAnonymousJSONObject;
              paramAnonymousJSONObject.printStackTrace();
              i = j;
              continue;
              RGNotificationController.getInstance().showUgcReportSuccess("上报成功！");
              continue;
              if (!TextUtils.isEmpty(str1)) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
              } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
              }
            }
          }
          if (!UgcReportNaviMainPresenter.this.isIpoNavi)
          {
            RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getEventToLastestMapState());
            if (!TextUtils.isEmpty(str1))
            {
              RGNotificationController.getInstance().showUgcReportSuccess(str1);
              if (UgcReportNaviMainPresenter.this.isTipsDynamic)
              {
                UgcReportNaviMainPresenter.this.reportInfoPackage.id = i;
                UgcNaviDynamicMarkRespository.getInstance().addUgcReportInfoUploadPackage(UgcReportNaviMainPresenter.this.reportInfoPackage);
              }
            }
          }
        }
      });
      return;
      UserOPController.getInstance().add("3.u.1", "2", this.reportInfoPackage.parentType + "", null);
    }
  }
  
  public void setIsIpoNavi(boolean paramBoolean)
  {
    this.isIpoNavi = paramBoolean;
  }
  
  public void setRootView(UgcReportNaviMainView paramUgcReportNaviMainView)
  {
    this.mRootView = paramUgcReportNaviMainView;
  }
  
  public void simpleUpload()
  {
    stopTimesCounts();
    new UgcHttpsUtils().addNaviInfoToPackage(this.reportInfoPackage, this.isTipsDynamic);
    if (this.reportInfoPackage.mark != 1) {
      realSimpleUpload();
    }
    for (;;)
    {
      finish();
      return;
      new UgcHttpsUtils().setScreenShotParam(this.mRootView.getOrientation(), new UgcHttpsUtils.ScreenShotCallBack()
      {
        public void onScreenShotCompleted(String paramAnonymousString)
        {
          UgcReportNaviMainPresenter.this.reportInfoPackage.screenshotPicPath = paramAnonymousString;
          UgcReportNaviMainPresenter.this.realSimpleUpload();
        }
      });
    }
  }
  
  public void start()
  {
    if (this.mRootView != null) {
      this.mRootView.initPresenterView();
    }
    statusPackage = new UgcReportInfoUploadPackage();
    if ((this.isIpoNavi) && (this.mRootView != null)) {
      this.mRootView.showIpoView();
    }
  }
  
  public static abstract interface CallBackListener
  {
    public abstract void onUgcFinish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/innavi/main/UgcReportNaviMainPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */