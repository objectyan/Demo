package com.baidu.navisdk.lightnavi.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.lightnavi.listener.LightGuideRGListener;
import com.baidu.navisdk.lightnavi.model.LightNaviGuideBean;
import com.baidu.navisdk.lightnavi.model.YellowBarMessage;
import com.baidu.navisdk.lightnavi.utils.CmdLightNaviGetGuideInfo;
import com.baidu.navisdk.lightnavi.utils.LightNaviLockScreenReceiver;
import com.baidu.navisdk.lightnavi.utils.LightNaviPageJumpHelper;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviDialogHelper;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviMapHelper;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviScreenHelper;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter.CallBackListener;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator.OnNaviBeginListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGUserRightView;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.ugc.view.BNRCEventDetailsView.UgcRCEventCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.drawable.UrlDrawableContainForNav;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import java.util.List;

public class LightNaviGuideView
  extends RelativeLayout
{
  private static final String TAG = LightNaviGuideView.class.getSimpleName();
  private Activity mActivity;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (2 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      for (;;)
      {
        if (1 == paramAnonymousInt1) {}
        switch (paramAnonymousInt2)
        {
        default: 
          return;
          LightNaviGuideView.this.mMapHelper.handleScrollGesture();
          LightNaviGuideView.this.mJniBaseMap.setDragMapStatus(true);
          continue;
          LightNaviGuideView.this.mMapHelper.handleSingleTouchGesture();
        }
      }
      LightNaviGuideView.this.mMapHelper.updateView();
      return;
      LogUtil.e("wangyang", "MapObserver update: EVENT_MAP_ZOOM_UPDATE");
      LightNaviGuideView.this.mMapHelper.updateView();
      return;
      paramAnonymousBNSubject = (MapItem)paramAnonymousObject;
      paramAnonymousInt1 = paramAnonymousBNSubject.mItemID;
      if (paramAnonymousBNSubject.mClickType == 1) {
        UserOPController.getInstance().add("4.8", "", null, null);
      }
      for (;;)
      {
        paramAnonymousBNSubject = BNNaviResultModel.getInstance();
        paramAnonymousBNSubject.instantNum += 1;
        BNRoutePlaner.getInstance().selectRoute(paramAnonymousInt1);
        paramAnonymousBNSubject = new Bundle();
        BNLightNaviManager.getInstance().getRemianDisAndTime(paramAnonymousBNSubject);
        paramAnonymousInt1 = paramAnonymousBNSubject.getInt("remainDis");
        paramAnonymousInt2 = paramAnonymousBNSubject.getInt("remainTime");
        if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
          LightNaviGuideView.this.mRGSlightSimpleGuideView.showBrightRemainTimeAndDis(paramAnonymousInt1, paramAnonymousInt2);
        }
        if (LightNaviGuideView.this.mRGSlightYellowBannerView == null) {
          break;
        }
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
        return;
        UserOPController.getInstance().add("4.8", null, "", null);
      }
    }
  };
  private TextView mBtnUnLock;
  private BNWorkerNormalTask<String, String> mCancelSwitchTask = new BNWorkerNormalTask("mCancelSwitchTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      if (BNLightNaviSwitchManager.getInstance().isSwitching())
      {
        LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
        BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
        BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
      }
      return null;
    }
  };
  private Context mContext;
  private LightNaviDialogHelper mDialogHelper;
  private BNWorkerNormalTask<String, String> mDismissScreenShotProgressTask = new BNWorkerNormalTask("mDismissScreenShotProgressTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      LightNaviGuideView.this.mRLProgress.setVisibility(8);
      if (!LightNaviGuideView.this.isScreenShotSuccess())
      {
        LightNaviGuideView.this.mActivity.getWindow().clearFlags(525440);
        LightNaviLockScreenReceiver.mIsLock = false;
        TipTool.onCreateToastDialog(LightNaviGuideView.this.mActivity, "网络异常,自动切换到亮屏");
        BNMapController.getInstance().setNightMode(false);
        BNLightNaviManager.getInstance().startUnLockScreen();
      }
      return null;
    }
  };
  private ContentObserver mGPSOpenCloseStateObs = null;
  private BNDialog mGPSSettingDialog;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (1000 == paramAnonymousMessage.what) {
        if ((BNLightNaviManager.getInstance().getType() == 1) && (BNLightNaviManager.getInstance().isNaving())) {
          LightNaviGuideView.this.getScreenShot();
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (1001 != paramAnonymousMessage.what) {
                break;
              }
              if (TTSPlayerControl.getMapTTSPlayStatus())
              {
                LightNaviGuideView.this.mHandler.sendEmptyMessageDelayed(1001, 500L);
                return;
              }
              LightNaviGuideView.this.mHandler.removeMessages(1001);
              TTSPlayerControl.playTTS(LightNaviGuideView.this.mOperationGuideContent, 1);
            } while (LightNaviGuideView.this.mRGSlightYellowBannerView == null);
            LightNaviGuideView.this.mRGSlightYellowBannerView.showOnlyBrightCondition();
            return;
            if (3001 == paramAnonymousMessage.what)
            {
              LogUtil.e(LightNaviGuideView.TAG, "wywy--MSG_TYPE_REMOVE_YELLOW_GUIDE");
              BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mHideYellowBarSwitchTask, false);
              BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mHideYellowBarGuideTask, false);
              return;
            }
            if (3002 == paramAnonymousMessage.what)
            {
              LogUtil.e(LightNaviGuideView.TAG, "wywy--MSG_TYPE_REMOVE_YELLOW_SWITCH");
              BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mHideYellowBarSwitchTask, false);
              return;
            }
          } while ((1404 != paramAnonymousMessage.what) || (paramAnonymousMessage.arg1 != 0));
          LogUtil.e(LightNaviGuideView.TAG, "wy--SLIGHT_GUIDE");
          paramAnonymousMessage = CmdLightNaviGetGuideInfo.mGuideMsg;
        } while ((paramAnonymousMessage == null) || (paramAnonymousMessage.size() < 1));
        paramAnonymousMessage = (LightNaviGuideBean)paramAnonymousMessage.get(0);
        LightNaviGuideView.access$102(LightNaviGuideView.this, paramAnonymousMessage.content);
      } while (LightNaviGuideView.this.mOperationGuideContent == null);
      LogUtil.e(LightNaviGuideView.TAG, "wy--SLIGHT_GUIDE SHow");
      LightNaviGuideView.this.showMessasg(4, LightNaviGuideView.this.mOperationGuideContent, 30000, -1);
    }
  };
  private volatile boolean mHasScreenShotSuccess = false;
  private BNWorkerNormalTask<String, String> mHideYellowBarGuideTask = new BNWorkerNormalTask("mHideYellowBarGuideTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(4);
      }
      return null;
    }
  };
  private BNWorkerNormalTask<String, String> mHideYellowBarSwitchTask = new BNWorkerNormalTask("mHideYellowBarSwitchTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
      }
      return null;
    }
  };
  private LightGuideRGListener mIPORGListener = new LightGuideRGListener()
  {
    public void avoidTrafficJam(Message paramAnonymousMessage) {}
    
    public void calcOtherRoute()
    {
      BNRouteGuider.getInstance().calcOtherRoute(1, 0);
    }
    
    public void hideAvoidTrafficJamView() {}
    
    public void isYellowBarHide(Message paramAnonymousMessage)
    {
      if (((paramAnonymousMessage.arg2 >> paramAnonymousMessage.arg1 & 0x1) == 1) && (LightNaviGuideView.this.mRGSlightYellowBannerView != null)) {
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
      }
    }
    
    public void onArriveDest(Message paramAnonymousMessage)
    {
      if (BNavigator.getInstance().getOnNaviBeginListener() != null) {
        BNavigator.getInstance().getOnNaviBeginListener().onArriveDest();
      }
      UserOPController.getInstance().add("4.g", "0", null, "1");
      BNNaviResultModel.getInstance().setDestArrived(true);
      LightNaviGuideView.this.onQuit(false);
      BNLightNaviManager.getInstance().setIsNaving(false);
      if (BNLightNaviManager.getInstance().getType() == 2)
      {
        TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "您已到达目的地，即将退出路线雷达");
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(LightNaviGuideView.this.mQuitNaviTask, new BNWorkerConfig(9, 0), 2000L);
      }
    }
    
    public void onAutoRefresh(int paramAnonymousInt)
    {
      LogUtil.e("wangyang", "onAutoRefresh type =" + paramAnonymousInt);
    }
    
    public void onGpsStatusChange(boolean paramAnonymousBoolean)
    {
      LightNaviGuideView.this.showGpsYellowBannerMsg(true, paramAnonymousBoolean);
    }
    
    public void onIPOAddressScreen(Message paramAnonymousMessage)
    {
      if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
        LightNaviGuideView.this.mRGSlightLockImageView.updateLockImage();
      }
    }
    
    public void onIPOLockScreen(Message paramAnonymousMessage)
    {
      if (BNLightNaviManager.getInstance().getType() == 1)
      {
        LightNaviGuideView.this.mHandler.sendEmptyMessageDelayed(1000, 20000L);
        LightNaviGuideView.this.setScreenShotSuccess(true);
        BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mDismissScreenShotProgressTask, false);
        if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
          LightNaviGuideView.this.mRGSlightLockImageView.updateLockImage();
        }
        LightNaviGuideView.this.mRLProgress.setVisibility(8);
      }
      if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
        LightNaviGuideView.this.mRGSlightLockImageView.isMapstatusNeedBack();
      }
    }
    
    public void onIPORoadConditionHide(Message paramAnonymousMessage)
    {
      if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(1);
      }
    }
    
    public void onIPORoadConditionUpdate(Message paramAnonymousMessage)
    {
      if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
        LightNaviGuideView.this.mRGSlightYellowBannerView.onRoadConditionUpdate();
      }
      if (BNLightNaviManager.getInstance().getType() == 1)
      {
        int i = paramAnonymousMessage.arg2;
        int j = paramAnonymousMessage.arg1;
        if ((LightNaviGuideView.this.mRGSlightLockImageView != null) && (LightNaviGuideView.this.mRGSlightLockImageView.checkNeedShowLockImage(j)) && (i == 1))
        {
          LightNaviGuideView.this.getScreenShot();
          LightNaviGuideView.this.lightScreen();
        }
      }
    }
    
    public void onOtherRoute(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.arg1;
      int j = paramAnonymousMessage.arg2;
      LogUtil.e(LightNaviGuideView.TAG, "wywy-onOtherRoute type : " + i);
      switch (i)
      {
      case 1: 
      case 2: 
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        if (BNLightNaviManager.getInstance().getType() == 2) {
          TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "抱歉，小度没有找到其他替代路线");
        }
        break;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (LightNaviGuideView.this.mRGSlightYellowBannerView == null);
            LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
            return;
          } while (BNLightNaviManager.getInstance().getType() != 2);
          TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "网络不佳，请稍后重试!");
          return;
          LogUtil.e(LightNaviGuideView.TAG, "wy--STATUS_STRATEGYROUTE");
          paramAnonymousMessage = new Bundle();
          BNRouteGuider.getInstance().getRouteInfoInUniform(1, paramAnonymousMessage);
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.getString("usYellowTipTextInfo");
            LogUtil.e(LightNaviGuideView.TAG, "wy--STATUS_STRATEGYROUTE - show ");
            LightNaviGuideView.this.showMessasg(3, paramAnonymousMessage, 10000, j);
          }
          if (BNLightNaviManager.getInstance().getType() == 2)
          {
            zoomToFullView();
            return;
          }
          LightNaviGuideView.this.getScreenShot();
          LightNaviGuideView.this.lightScreen();
          return;
        } while (BNLightNaviManager.getInstance().getType() != 2);
        TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "发现更快的躲避拥堵路线");
        zoomToFullView();
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
        return;
      } while (BNLightNaviManager.getInstance().getType() != 2);
      if (BNLightNaviManager.getInstance().getAutoRefresh() > -1) {
        UserOPController.getInstance().add("4.m");
      }
      for (;;)
      {
        zoomToFullView();
        return;
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "已为您找到其他替代路线");
        BNLightNaviManager.getInstance().setAutoRefresh(0);
      }
    }
    
    public void onQuitNavi()
    {
      LightNaviGuideView.this.quitLightNavi(false);
    }
    
    public void onRemainInfoUpdate(Message paramAnonymousMessage)
    {
      LogUtil.e("wangyang", "onRemainInfoUpdate  time = " + paramAnonymousMessage.arg2 + "dist=" + paramAnonymousMessage.arg1);
      if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
        LightNaviGuideView.this.mRGSlightSimpleGuideView.showRemainTimeAndDis(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
      }
      LightNaviGuideView.this.mNavIPOStatItem.mDistToDest = paramAnonymousMessage.arg1;
      if (LightNaviGuideView.this.mUserRightView != null) {
        LightNaviGuideView.this.mUserRightView.updateCurMileaInfo();
      }
    }
    
    public void onSwithSLightToNavi(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.arg1;
      LogUtil.e("wangyang", "onSwithSLightToNavi type = " + i);
      if (i == 2)
      {
        BNLightNaviManager.getInstance().switch2AlternativeRoute(1);
        BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mCancelSwitchTask, false);
        LightNaviGuideView.this.mDialogHelper.setCloseGone();
      }
      do
      {
        return;
        if (i == 3)
        {
          LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
          TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(1711670253));
          return;
        }
        if (i == 4)
        {
          LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
          TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(1711670253));
          return;
        }
        if (i == 0)
        {
          BNaviModuleManager.removeIPO();
          LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
          BNLightNaviSwitchManager.getInstance().setHaveSwitched(true);
          LightNaviGuideView.this.quitLightNavi(true);
          paramAnonymousMessage = LightNaviGuideView.this.initGuideBundle();
          if (paramAnonymousMessage == null)
          {
            TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(1711670253));
            return;
          }
          LightNaviPageJumpHelper.getInstance().onPageJump(3, paramAnonymousMessage);
          return;
        }
      } while (i != 1);
      BNaviModuleManager.removeIPO();
      LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
      TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(1711670253));
    }
    
    public void onUpdateSimpleGuide(Message paramAnonymousMessage)
    {
      if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
        LightNaviGuideView.this.mRGSlightSimpleGuideView.onUpdateSimpleGuide(paramAnonymousMessage, LightNaviGuideView.this.mYawing);
      }
    }
    
    public void onUpdateSpeed(boolean paramAnonymousBoolean, Message paramAnonymousMessage)
    {
      if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
        LightNaviGuideView.this.mRGSlightSimpleGuideView.onUpdateSpeed(paramAnonymousBoolean, paramAnonymousMessage);
      }
    }
    
    public void onYawingRPFail()
    {
      LightNaviGuideView.access$1702(LightNaviGuideView.this, false);
      if (BNLightNaviManager.getInstance().getType() == 2)
      {
        LightNaviGuideView.this.quitLightNavi(false);
        return;
      }
      BNLightNaviManager.getInstance().setIsNaving(false);
      LightNaviGuideView.this.onQuit(false);
    }
    
    public void onYawingRerouteSuccess(Message paramAnonymousMessage)
    {
      LightNaviGuideView.access$1702(LightNaviGuideView.this, false);
      if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
      }
      if (BNLightNaviManager.getInstance().getType() == 2)
      {
        TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "偏航路线规划成功");
        if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
          LightNaviGuideView.this.mRGSlightLockImageView.zoomToSlightNaviFullView(LightNaviGuideView.this.mRGSlightYellowBannerView, LightNaviGuideView.this.mViewHeight);
        }
      }
      for (;;)
      {
        BNNaviResultModel.getInstance().setYawNum();
        return;
        LightNaviGuideView.this.getScreenShot();
        LightNaviGuideView.this.lightScreen();
      }
    }
    
    public void onYawingRerouting(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = LightNaviGuideView.this.mNavIPOStatItem;
      paramAnonymousMessage.mYawingCount += 1;
      UserOPController.getInstance().add("4.h");
      LightNaviGuideView.access$1702(LightNaviGuideView.this, true);
      TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "您已偏离路线,正在重新规划路线....");
      if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
        LightNaviGuideView.this.mRGSlightSimpleGuideView.showOverSpeed(false);
      }
    }
    
    public void refreshScreenShot()
    {
      LightNaviGuideView.this.getScreenShot();
    }
    
    public void showSafetyGuide(boolean paramAnonymousBoolean)
    {
      View localView;
      if (LightNaviGuideView.this.mSafeGuideView != null)
      {
        localView = LightNaviGuideView.this.mSafeGuideView;
        if (!paramAnonymousBoolean) {
          break label30;
        }
      }
      label30:
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        return;
      }
    }
    
    public void switchScrennType()
    {
      LightNaviGuideView.this.screenTypeSwitch();
    }
    
    public void zoomToFullView()
    {
      if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
        LightNaviGuideView.this.mRGSlightLockImageView.zoomToSlightNaviFullView(LightNaviGuideView.this.mRGSlightYellowBannerView, LightNaviGuideView.this.mViewHeight);
      }
    }
  };
  private View mIpoLine;
  private View mIpoLineVertical;
  private boolean mIsDay;
  public boolean mIsForground = false;
  private LinearLayout mItsParent;
  private JNIBaseMap mJniBaseMap = new JNIBaseMap();
  private LinearLayout mLLLockControl;
  private LinearLayout mLLLockScreenControl;
  private LinearLayout mLLQuit;
  private LinearLayout mLLSwitchToNavi;
  private BNMapControlPanel.ILocationBtnClickListener mLocationBtnClickListener = new BNMapControlPanel.ILocationBtnClickListener()
  {
    public void onClick(int paramAnonymousInt)
    {
      UserOPController.getInstance().add("4.5");
      if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
        LightNaviGuideView.this.mRGSlightLockImageView.zoomToSlightNaviFullView(LightNaviGuideView.this.mRGSlightYellowBannerView, LightNaviGuideView.this.mViewHeight);
      }
      LightNaviGuideView.this.mJniBaseMap.setDragMapStatus(false);
    }
  };
  private LightNaviMapHelper mMapHelper;
  private ViewGroup mMenuViewContainer;
  public NaviIPOStatItem mNavIPOStatItem;
  private String mOperationGuideContent;
  private String mPackageName = null;
  private UgcReportNaviMainPresenter mPrensenter;
  private ImageView mQuit;
  private BNWorkerNormalTask<String, String> mQuitNaviTask = new BNWorkerNormalTask("mQuitNaviTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      LightNaviGuideView.this.quitLightNavi(false);
      return null;
    }
  };
  private View mRCEventDetailsView = null;
  private RGSlightGuideView mRGSlightGuideView;
  private RGSlightLockImageView mRGSlightLockImageView;
  private RGSlightSimpleGuideView mRGSlightSimpleGuideView;
  private RGSlightYellowBannerView mRGSlightYellowBannerView;
  private RelativeLayout mRLBrightScreen;
  private LightNaviUpSlideRelativeLayout mRLLockUpSlideRelativeLayou;
  private RelativeLayout mRLProgress;
  private LinearLayout mRLReplan;
  private RelativeLayout mRLRouteInfo;
  private BNWorkerNormalTask<String, String> mReleaseScrennTask = new BNWorkerNormalTask("mReleaseScrennTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      LightNaviGuideView.this.releaseScreen();
      return null;
    }
  };
  private Runnable mRestoreMapStatusRunable = new Runnable()
  {
    public void run()
    {
      LightNaviGuideView.this.mJniBaseMap.setDragMapStatus(false);
    }
  };
  private ViewGroup mRootView = null;
  private View mSafeGuideView;
  private LinearLayout mSafeParent;
  private ImageView mSafeParentIv;
  private LightNaviScreenHelper mScreenHelper;
  private LightNaviUpSlideRelativeLayout.SlideListerner mSlideListerner = new LightNaviUpSlideRelativeLayout.SlideListerner()
  {
    public void onDeblocking()
    {
      LightNaviGuideView.this.mActivity.getWindow().clearFlags(525440);
      LightNaviLockScreenReceiver.mIsLock = false;
      BNLightNaviManager.getInstance().startUnLockScreen();
    }
  };
  private TextView mSwitchNavi;
  private BNRCEventDetailsView.UgcRCEventCallback mUgcRCEventCallback = new BNRCEventDetailsView.UgcRCEventCallback()
  {
    public void onFinish()
    {
      LightNaviGuideView.access$3102(LightNaviGuideView.this, null);
      if (LightNaviGuideView.this.mMenuViewContainer != null)
      {
        LightNaviGuideView.this.mMenuViewContainer.removeAllViews();
        LightNaviGuideView.this.mMenuViewContainer.setVisibility(8);
      }
    }
    
    public void onShowUserINfo(String paramAnonymousString) {}
  };
  private ImageView mUgcReportIv;
  private UgcReportNaviMainView mUgcReportMapMainView;
  private ViewGroup mUgcReportVG = null;
  private UgcReportNaviMainPresenter.CallBackListener mUgcResportCallback = new UgcReportNaviMainPresenter.CallBackListener()
  {
    public void onUgcFinish()
    {
      if (LightNaviGuideView.this.mMenuViewContainer != null)
      {
        LightNaviGuideView.this.mMenuViewContainer.removeAllViews();
        LightNaviGuideView.this.mMenuViewContainer.setVisibility(8);
      }
      LightNaviGuideView.access$2602(LightNaviGuideView.this, null);
      LightNaviGuideView.access$2702(LightNaviGuideView.this, null);
    }
  };
  private RGUserRightView mUserRightView = null;
  private int mViewHeight = 0;
  private LightNaviWrapperCallback mWrapperCallback;
  private boolean mYawing;
  
  public LightNaviGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public LightNaviGuideView(Context paramContext, MapGLSurfaceView paramMapGLSurfaceView, String paramString)
  {
    super(paramContext);
    BNRouteGuider.getInstance().setNaviMode(2);
    this.mContext = paramContext;
    this.mPackageName = paramString;
    this.mNavIPOStatItem = NaviIPOStatItem.getInstance();
    this.mNavIPOStatItem.onIPONaviStart();
    BNLightNaviManager.getInstance().init(this.mIPORGListener, (Activity)paramContext);
    BNavigator.getInstance().initLightNavi((Activity)paramContext);
    this.mScreenHelper = LightNaviScreenHelper.getInstance(paramContext);
    this.mMapHelper = LightNaviMapHelper.getInstance(paramContext);
    this.mDialogHelper = LightNaviDialogHelper.getInstance(paramContext);
    this.mScreenHelper.initScreenAlwaysOn();
    setupView((Activity)paramContext);
    onUpdateStyle(BNStyleManager.getDayStyle());
    LightNaviLockScreenReceiver.initLockScreenReceiver(paramContext.getApplicationContext(), this.mActivity);
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    BNLightNaviManager.getInstance().setIsLightNaviView(true);
    if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
      RGParkPointModel.getInstance().setCanParkPoiShow(true);
    }
    LightNaviParams.mGpsStatus = 0;
    checkAndShowGPSSettingDialog();
    initGPSOpenCloseStateListener();
  }
  
  private void checkAndShowGPSSettingDialog()
  {
    dismissGPSSettingDialog();
    if (BNavConfig.pRGLocateMode == 6)
    {
      BNSysLocationManager localBNSysLocationManager = BNSysLocationManager.getInstance();
      if ((localBNSysLocationManager != null) && (!localBNSysLocationManager.isGpsEnabled()))
      {
        showGPSSettingDialog();
        showGpsYellowBannerMsg(false, false);
      }
    }
    else
    {
      return;
    }
    showGpsYellowBannerMsg(false, true);
  }
  
  private void initGPSOpenCloseStateListener()
  {
    if (BNavConfig.pRGLocateMode != 6) {}
    Uri localUri;
    do
    {
      do
      {
        return;
      } while (this.mActivity == null);
      if (this.mGPSOpenCloseStateObs == null) {
        this.mGPSOpenCloseStateObs = new ContentObserver(new Handler() {})
        {
          public void onChange(boolean paramAnonymousBoolean)
          {
            LogUtil.e(LightNaviGuideView.TAG, "onChange: --> ");
            LightNaviGuideView.this.checkAndShowGPSSettingDialog();
          }
        };
      }
      localUri = Settings.Secure.getUriFor("location_providers_allowed");
    } while ((localUri == null) || (this.mActivity.getContentResolver() == null));
    try
    {
      this.mActivity.getContentResolver().registerContentObserver(localUri, false, this.mGPSOpenCloseStateObs);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "registerContentObserver Exception");
    }
  }
  
  private void lightScreen()
  {
    if (!this.mIsForground)
    {
      BNWorkerCenter.getInstance().cancelTask(this.mReleaseScrennTask, false);
      this.mScreenHelper.lightScreen();
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mReleaseScrennTask, new BNWorkerConfig(9, 0), 3000L);
    }
  }
  
  private void mapSetting()
  {
    this.mMapHelper.mapSetting();
    if (this.mRGSlightLockImageView != null) {
      this.mRGSlightLockImageView.zoomToSlightNaviFullView(this.mRGSlightYellowBannerView, this.mViewHeight);
    }
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    if (localMapStatus != null)
    {
      localMapStatus._WinRound.left = 0;
      localMapStatus._WinRound.top = 0;
      localMapStatus._WinRound.bottom = BNMapController.getInstance().getScreenHeight();
      localMapStatus._WinRound.right = BNMapController.getInstance().getScreenWidth();
      localMapStatus._Level = -1.0F;
      BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
    }
  }
  
  private void onQuit(boolean paramBoolean)
  {
    uninitGPSOpenCloseStateListener();
    dismissGPSSettingDialog();
    this.mNavIPOStatItem.onIPONaviEnd();
    this.mNavIPOStatItem.setIPONaviNetworkType(NetworkUtils.getActiveNetworkSubtype());
    this.mNavIPOStatItem.mTotalDistance = BNRouteGuider.getInstance().getCurrentRouteDrvieDistance();
    if (BNLightNaviManager.getInstance().isNaving()) {
      BNavigator.getInstance().quitIPONavi(paramBoolean);
    }
  }
  
  private void quitLightNavi(boolean paramBoolean)
  {
    LogUtil.e(TAG, "quitLightNavi: switchFlag --> " + paramBoolean);
    try
    {
      this.mRGSlightYellowBannerView.hideGuideText(5);
      if (this.mRGSlightGuideView != null) {
        this.mRGSlightGuideView.quit();
      }
      this.mHandler.removeCallbacks(this.mRestoreMapStatusRunable);
      this.mHandler.removeMessages(1000);
      this.mHandler.removeMessages(1001);
      BNWorkerCenter.getInstance().cancelTask(this.mQuitNaviTask, false);
      BNWorkerCenter.getInstance().cancelTask(this.mReleaseScrennTask, false);
      BNWorkerCenter.getInstance().cancelTask(this.mCancelSwitchTask, false);
      BNWorkerCenter.getInstance().cancelTask(this.mDismissScreenShotProgressTask, false);
      BNWorkerCenter.getInstance().cancelTask(this.mHideYellowBarSwitchTask, false);
      BNWorkerCenter.getInstance().cancelTask(this.mHideYellowBarGuideTask, false);
      if (this.mRLLockUpSlideRelativeLayou != null) {
        this.mRLLockUpSlideRelativeLayou.onDestory();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Bundle localBundle;
        LogUtil.e("wangyang", localException.toString());
      }
    }
    this.mMapHelper.unInit();
    if (!paramBoolean) {
      this.mDialogHelper.dismissSwitchProgressDialog();
    }
    this.mDialogHelper.unInit();
    onQuit(paramBoolean);
    this.mJniBaseMap.setDragMapStatus(false);
    this.mScreenHelper.restoreScreenAlwaysOn();
    releaseScreen();
    this.mScreenHelper.unInit();
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    BNRouteGuider.getInstance().setBrowseStatus(false);
    LightNaviLockScreenReceiver.uninitLockScreenReceiver();
    BNLightNaviManager.getInstance().uninit();
    BNRouteGuider.getInstance().setNaviMode(1);
    BNLightNaviManager.getInstance().setSwitching(paramBoolean);
    localBundle = new Bundle();
    localBundle.putBoolean("switch", paramBoolean);
    LightNaviPageJumpHelper.getInstance().onPageJump(4, localBundle);
    if (!paramBoolean)
    {
      LightNaviPageJumpHelper.getInstance().onPageJump(1, null);
      BNLightNaviSwitchManager.getInstance().unInit();
      UserOPController.getInstance().end();
      CommonHandlerThread.getInstance().sendMessage(250);
    }
    if (BNMapController.getInstance().getMapController() != null) {
      BNMapController.getInstance().getMapController().set3DGestureEnable(true);
    }
    BNLightNaviManager.getInstance().setIsLightNaviView(false);
  }
  
  private void releaseScreen()
  {
    this.mScreenHelper.releaseScreen();
  }
  
  private void screenTypeSwitch()
  {
    LogUtil.e("wangyang", "LightNaviUp screenTypeSwitch type =" + BNLightNaviManager.getInstance().getType());
    if (BNLightNaviManager.getInstance().getType() == 2)
    {
      BNMapController.getInstance().setNightMode(false);
      this.mJniBaseMap.setSlightScreenStatus(2);
      this.mHandler.removeMessages(1000);
      releaseScreen();
      this.mMapHelper.openRoadCond();
      this.mMapHelper.onResume();
      this.mScreenHelper.initScreenAlwaysOn();
      if (this.mRGSlightYellowBannerView != null) {
        this.mRGSlightYellowBannerView.focusBright();
      }
      this.mNavIPOStatItem.onLightScreen();
      this.mRLLockUpSlideRelativeLayou.setVisibility(8);
      BNWorkerCenter.getInstance().cancelTask(this.mDismissScreenShotProgressTask, false);
      return;
    }
    LogUtil.e("wangyang", "mRLBrightScreen = visible" + this.mRLBrightScreen.getVisibility());
    this.mJniBaseMap.setSlightScreenStatus(1);
    if (this.mRGSlightYellowBannerView != null) {
      this.mRGSlightYellowBannerView.focusLock();
    }
    this.mMapHelper.colsedRoadCond();
    this.mScreenHelper.restoreScreenAlwaysOn();
    this.mRLLockUpSlideRelativeLayou.setVisibility(0);
    BNMapController.getInstance().setNightMode(true);
    getScreenShot();
    this.mNavIPOStatItem.onLockScreen();
  }
  
  private void setupView(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mRootView = ((ViewGroup)JarUtils.inflate(paramActivity, 1711472681, this));
    if (this.mRootView == null) {}
    int i;
    do
    {
      return;
      this.mRootView.requestLayout();
      this.mRGSlightGuideView = new RGSlightGuideView(this.mActivity, this.mRootView);
      this.mRGSlightYellowBannerView = new RGSlightYellowBannerView(this.mActivity, this.mRootView, this.mHandler);
      this.mRGSlightSimpleGuideView = new RGSlightSimpleGuideView(this.mActivity, this.mRootView);
      this.mRGSlightLockImageView = new RGSlightLockImageView(this.mActivity, this.mRootView);
      LightNaviParams.mGpsInfoHasBeenClosed = false;
      findView();
      if (this.mRGSlightGuideView != null) {
        this.mRGSlightGuideView.showNotify();
      }
      mapSetting();
      setupListener();
      this.mMapHelper.loadMapCtrlPanel(this.mRootView, true, true, this.mLocationBtnClickListener);
      i = BNSettingManager.getIPOGuideShowTime();
    } while ((i <= 0) || (LightNaviParams.isGuideHasBeanClose));
    CmdLightNaviGetGuideInfo.requestLightNaviInfo(this.mHandler);
    BNSettingManager.setIPOGuideShowTime(i - 1);
  }
  
  private void showGpsYellowBannerMsg(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    LogUtil.e(TAG, "showGpsYellowBannerMsg: --> msgFromEngine: " + paramBoolean1 + " gpsFixed: " + paramBoolean2 + ", mGpsInfoHasBeenClosed: " + LightNaviParams.mGpsInfoHasBeenClosed);
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        LightNaviParams.mGpsStatus = i;
        if ((paramBoolean2) || (LightNaviParams.mGpsInfoHasBeenClosed)) {
          break label88;
        }
        showMessasg(2, "当前GPS信号弱，位置更新可能有延迟！", 0, -1);
      }
    }
    label88:
    do
    {
      do
      {
        return;
        i = 2;
        break;
      } while (this.mRGSlightYellowBannerView == null);
      this.mRGSlightYellowBannerView.hideGuideText(2);
      return;
      if ((!paramBoolean2) && (!LightNaviParams.mGpsInfoHasBeenClosed))
      {
        showMessasg(2, "未开启GPS，请到设置中打开！", 0, -1);
        return;
      }
      if (LightNaviParams.mGpsStatus == 2)
      {
        showGpsYellowBannerMsg(true, false);
        return;
      }
    } while (this.mRGSlightYellowBannerView == null);
    this.mRGSlightYellowBannerView.hideGuideText(2);
  }
  
  private void showMessasg(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if ((this.mRGSlightYellowBannerView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (paramInt1 == 3)
      {
        LogUtil.e(TAG, "wywy remove runnable mHideYellowBarSwitch");
        BNWorkerCenter.getInstance().cancelTask(this.mHideYellowBarSwitchTask, false);
      }
      for (;;)
      {
        YellowBarMessage localYellowBarMessage = new YellowBarMessage();
        localYellowBarMessage.mPriority = paramInt1;
        localYellowBarMessage.mMsgContent = paramString;
        localYellowBarMessage.mRouteIndex = paramInt3;
        this.mRGSlightYellowBannerView.showGuideText(localYellowBarMessage);
        if (paramInt1 != 3) {
          break;
        }
        LogUtil.e(TAG, "wywy runnable mHideYellowBarSwitch");
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mHideYellowBarSwitchTask, new BNWorkerConfig(9, 0), paramInt2);
        return;
        if (paramInt1 == 4)
        {
          LogUtil.e(TAG, "wywy remove runnable mHideYellowBarGuide");
          BNWorkerCenter.getInstance().cancelTask(this.mHideYellowBarGuideTask, false);
        }
      }
    } while (paramInt1 != 4);
    LogUtil.e(TAG, "wywy runnable mHideYellowBarGuide");
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mHideYellowBarGuideTask, new BNWorkerConfig(9, 0), paramInt2);
  }
  
  private void showScreenShotProgress()
  {
    BNWorkerCenter.getInstance().cancelTask(this.mDismissScreenShotProgressTask, false);
    this.mRLProgress.setVisibility(0);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mDismissScreenShotProgressTask, new BNWorkerConfig(9, 0), 30000L);
  }
  
  private void uninitGPSOpenCloseStateListener()
  {
    if (BNavConfig.pRGLocateMode != 6) {}
    while ((this.mActivity == null) || (this.mGPSOpenCloseStateObs == null)) {
      return;
    }
    this.mActivity.getContentResolver().unregisterContentObserver(this.mGPSOpenCloseStateObs);
  }
  
  /* Error */
  public void dismissGPSSettingDialog()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 953	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mGPSSettingDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   6: ifnull +45 -> 51
    //   9: aload_0
    //   10: getfield 370	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mActivity	Landroid/app/Activity;
    //   13: ifnull +38 -> 51
    //   16: aload_0
    //   17: getfield 370	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mActivity	Landroid/app/Activity;
    //   20: invokevirtual 956	android/app/Activity:isFinishing	()Z
    //   23: ifne +28 -> 51
    //   26: aload_0
    //   27: getfield 953	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mGPSSettingDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   30: invokevirtual 961	com/baidu/navisdk/ui/widget/BNDialog:isShowing	()Z
    //   33: ifeq +10 -> 43
    //   36: aload_0
    //   37: getfield 953	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mGPSSettingDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   40: invokevirtual 964	com/baidu/navisdk/ui/widget/BNDialog:dismiss	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 953	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mGPSSettingDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 953	com/baidu/navisdk/lightnavi/view/LightNaviGuideView:mGPSSettingDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   56: goto -8 -> 48
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	LightNaviGuideView
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	59	finally
    //   43	48	59	finally
    //   51	56	59	finally
  }
  
  public void findView()
  {
    this.mRLRouteInfo = ((RelativeLayout)findViewById(1711866141));
    this.mQuit = ((ImageView)findViewById(1711866176));
    this.mLLQuit = ((LinearLayout)findViewById(1711866175));
    this.mSwitchNavi = ((TextView)findViewById(1711866192));
    this.mLLLockControl = ((LinearLayout)findViewById(1711866182));
    this.mLLSwitchToNavi = ((LinearLayout)findViewById(1711866191));
    this.mLLLockScreenControl = ((LinearLayout)findViewById(1711866179));
    this.mIpoLine = findViewById(1711866140);
    this.mIpoLineVertical = findViewById(1711866190);
    this.mBtnUnLock = ((TextView)findViewById(1711866204));
    this.mRLBrightScreen = ((RelativeLayout)findViewById(1711866138));
    this.mRLLockUpSlideRelativeLayou = ((LightNaviUpSlideRelativeLayout)findViewById(1711866196));
    this.mRLLockUpSlideRelativeLayou.setSlideListerner(this.mSlideListerner);
    this.mRLReplan = ((LinearLayout)findViewById(1711866167));
    this.mItsParent = ((LinearLayout)findViewById(1711866165));
    this.mSafeParent = ((LinearLayout)findViewById(1711866152));
    this.mSafeParentIv = ((ImageView)findViewById(1711866153));
    if (CloudlConfigDataModel.getInstance().mCommonConfig.safetyShow) {
      this.mSafeParent.setVisibility(0);
    }
    for (;;)
    {
      UrlDrawableContainForNav.getSrcDrawable(CloudlConfigDataModel.getInstance().mCommonConfig.safetyIpoIcon, 1711407524, this.mSafeParentIv, null);
      this.mUgcReportIv = ((ImageView)findViewById(1711866151));
      this.mSafeGuideView = findViewById(1711866209);
      this.mRLProgress = ((RelativeLayout)findViewById(1711866208));
      this.mUgcReportVG = ((ViewGroup)findViewById(1711866150));
      this.mMenuViewContainer = ((ViewGroup)findViewById(1711866195));
      Bundle localBundle = new Bundle();
      BNLightNaviManager.getInstance().getRemianDisAndTime(localBundle);
      int i = localBundle.getInt("remainDis");
      int j = localBundle.getInt("remainTime");
      this.mNavIPOStatItem.mNaviRoutePlanDist = i;
      this.mNavIPOStatItem.mNaviRoutePlanTime = j;
      if (this.mRGSlightSimpleGuideView != null) {
        this.mRGSlightSimpleGuideView.showRemainTimeAndDis(i, j);
      }
      this.mUserRightView = new RGUserRightView(this.mActivity, this.mRootView, null);
      this.mRLBrightScreen.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          LightNaviGuideView.this.mRLBrightScreen.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          LightNaviGuideView.access$1902(LightNaviGuideView.this, LightNaviGuideView.this.mRLBrightScreen.getHeight());
        }
      });
      if ((this.mUgcReportVG != null) && (this.mUgcReportIv != null)) {
        new UgcImageLoaderUtils().updateUgcViewOnLine(4096, this.mUgcReportIv, new BNImageLoadingListener()
        {
          public void onLoadingComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, int paramAnonymousInt)
          {
            LightNaviGuideView.this.mUgcReportVG.setVisibility(0);
          }
          
          public void onLoadingFailed(String paramAnonymousString1, View paramAnonymousView, String paramAnonymousString2)
          {
            LightNaviGuideView.this.mUgcReportVG.setVisibility(0);
          }
          
          public void onLoadingStarted(String paramAnonymousString, View paramAnonymousView) {}
        });
      }
      return;
      this.mSafeParent.setVisibility(8);
    }
  }
  
  public void getScreenShot()
  {
    showScreenShotProgress();
    this.mHandler.removeMessages(1000);
    if (this.mRGSlightLockImageView != null) {
      this.mRGSlightLockImageView.getScreenShot(this.mRGSlightYellowBannerView, this.mViewHeight);
    }
  }
  
  public Bundle initGuideBundle()
  {
    RoutePlanModel localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    RoutePlanNode localRoutePlanNode1 = localRoutePlanModel.getStartNode();
    RoutePlanNode localRoutePlanNode2 = localRoutePlanModel.getEndNode();
    GeoPoint localGeoPoint = BNSysLocationManager.getInstance().getLastValidLocation();
    if (((localRoutePlanNode1 == null) && (localGeoPoint == null)) || (localRoutePlanNode2 == null)) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("routeguide_view_mode", 1);
    localBundle.putInt("calroute_done", 0);
    if ((localRoutePlanNode1 != null) && (localGeoPoint == null))
    {
      localBundle.putInt("start_x", localRoutePlanNode1.getLongitudeE6());
      localBundle.putInt("start_y", localRoutePlanNode1.getLatitudeE6());
      localBundle.putString("start_name", localRoutePlanModel.getStartName(this.mActivity, false));
    }
    if (localGeoPoint != null)
    {
      localBundle.putInt("start_x", localGeoPoint.getLongitudeE6());
      localBundle.putInt("start_y", localGeoPoint.getLatitudeE6());
      localBundle.putString("start_name", JarUtils.getResources().getString(1711669559));
    }
    localBundle.putInt("end_x", localRoutePlanNode2.getLongitudeE6());
    localBundle.putInt("end_y", localRoutePlanNode2.getLatitudeE6());
    localBundle.putString("end_name", localRoutePlanModel.getEndName(this.mActivity, false));
    localBundle.putInt("menu_type", 0);
    localBundle.putInt("locate_mode", 1);
    localBundle.putBoolean("is_ipo_switch", true);
    return localBundle;
  }
  
  public boolean isScreenShotSuccess()
  {
    try
    {
      boolean bool = this.mHasScreenShotSuccess;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mPrensenter != null) {
      this.mPrensenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.mPrensenter != null) && (this.mMenuViewContainer != null) && (this.mMenuViewContainer.getVisibility() == 0)) {
      if ((!this.mPrensenter.onBackPress()) && (this.mUgcResportCallback != null)) {
        this.mUgcResportCallback.onUgcFinish();
      }
    }
    do
    {
      return true;
      if ((this.mRCEventDetailsView != null) && (this.mMenuViewContainer != null) && (this.mMenuViewContainer.getVisibility() == 0))
      {
        BNRCEventDetailsViewController.getInstance().onBackPressed();
        return true;
      }
    } while ((BNLightNaviManager.getInstance().getType() == 1) || ((this.mRGSlightGuideView != null) && (this.mRGSlightGuideView.quitGuide())));
    quitLightNavi(false);
    return false;
  }
  
  public void onDestory()
  {
    if (BNLightNaviManager.getInstance().isNaving()) {
      quitLightNavi(false);
    }
    this.mActivity.getWindow().clearFlags(525312);
    LightNaviLockScreenReceiver.mIsLock = false;
    onDestroyView();
    if (this.mPrensenter != null)
    {
      this.mPrensenter.onDestroy();
      this.mPrensenter = null;
      this.mUgcReportMapMainView = null;
    }
    if (this.mWrapperCallback != null) {
      this.mWrapperCallback.unRegisterLoadingProxy();
    }
    if (this.mRCEventDetailsView != null)
    {
      BNRCEventDetailsViewController.getInstance().onDestroy();
      this.mRCEventDetailsView = null;
    }
  }
  
  public void onDestroyView()
  {
    if (this.mSafeParentIv != null) {
      UIUtils.releaseImageView(this.mSafeParentIv);
    }
    if (this.mRootView != null) {
      this.mRootView.removeAllViews();
    }
    this.mRootView = null;
  }
  
  public void onPause()
  {
    this.mMapHelper.onPause();
    if (this.mRGSlightLockImageView != null) {
      this.mRGSlightLockImageView.onMapPause();
    }
    this.mIsForground = false;
  }
  
  public void onResume()
  {
    this.mMapHelper.checkITSRoad();
    this.mMapHelper.onResume();
    if (this.mRGSlightLockImageView != null) {
      this.mRGSlightLockImageView.onMapResume();
    }
    this.mIsForground = true;
    if (this.mUserRightView != null) {
      this.mUserRightView.show();
    }
  }
  
  public void onStart()
  {
    if (this.mNavIPOStatItem != null) {
      this.mNavIPOStatItem.onForground();
    }
    if (BNLightNaviManager.getInstance().getType() == 2)
    {
      this.mNavIPOStatItem.onLightScreen();
      return;
    }
    this.mNavIPOStatItem.onLockScreen();
  }
  
  public void onStop()
  {
    if (this.mNavIPOStatItem != null) {
      this.mNavIPOStatItem.onBackground();
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean) {}
  
  public void oncreate()
  {
    BNSettingManager.setQuitForExceptionInNaviMode(true);
  }
  
  public void setScreenShotSuccess(boolean paramBoolean)
  {
    try
    {
      this.mHasScreenShotSuccess = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setWrapperCallback(LightNaviWrapperCallback paramLightNaviWrapperCallback)
  {
    this.mWrapperCallback = paramLightNaviWrapperCallback;
  }
  
  public void setupListener()
  {
    this.mLLQuit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("4.g", "0", null, "2");
        LightNaviGuideView.this.quitLightNavi(false);
      }
    });
    this.mLLLockScreenControl.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserOPController.getInstance().add("4.6", null, "", null);
        if (!BNLightNaviSwitchManager.getInstance().isSwitching()) {
          BNLightNaviManager.getInstance().setType(1);
        }
      }
    });
    this.mLLSwitchToNavi.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LogUtil.e("wangyang", "mLLSwitchToNavi");
        UserOPController.getInstance().add("4.j");
        BNLightNaviManager.getInstance().naviSwitchingCalcRoute(1);
        LightNaviGuideView.this.mDialogHelper.showSwitchProgressDialog();
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(LightNaviGuideView.this.mCancelSwitchTask, new BNWorkerConfig(9, 0), 30000L);
      }
    });
    this.mRLReplan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (LightNaviGuideView.this.mYawing)
        {
          TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "抱歉,小度没有找到其他替代路线");
          return;
        }
        UserOPController.getInstance().add("4.9");
        BNLightNaviManager.getInstance().setAutoRefresh(-1);
        BNRouteGuider.getInstance().calcOtherRoute(1, 0);
      }
    });
    this.mSafeParent.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return;
        }
        UserOPController.getInstance().add("3.y.1", "2", null, null);
        BusinessActivityManager.getInstance().safetyUpload(0, false);
      }
    });
    if (this.mUgcReportVG != null) {
      this.mUgcReportVG.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          LightNaviGuideView.access$2602(LightNaviGuideView.this, new UgcReportNaviMainView(LightNaviGuideView.this.mContext, 1));
          LightNaviGuideView.access$2702(LightNaviGuideView.this, new UgcReportNaviMainPresenter(LightNaviGuideView.this.mUgcReportMapMainView, UgcDataProvider.obtainUgcNaviLayout(), LightNaviGuideView.this.mUgcResportCallback));
          LightNaviGuideView.this.mUgcReportMapMainView.setPresenter(LightNaviGuideView.this.mPrensenter);
          paramAnonymousView = LightNaviGuideView.this.mUgcReportMapMainView.getParentView();
          if ((LightNaviGuideView.this.mMenuViewContainer != null) && (paramAnonymousView != null))
          {
            LightNaviGuideView.this.mMenuViewContainer.removeAllViews();
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            LightNaviGuideView.this.mMenuViewContainer.addView(paramAnonymousView, localLayoutParams);
            LightNaviGuideView.this.mMenuViewContainer.setVisibility(0);
            LightNaviGuideView.this.mPrensenter.setIsIpoNavi(true);
            LightNaviGuideView.this.mPrensenter.start();
            UserOPController.getInstance().add("3.u", "3", null, null);
          }
        }
      });
    }
  }
  
  public void showGPSSettingDialog()
  {
    try
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.mGPSSettingDialog == null) {
          this.mGPSSettingDialog = new BNDialog(this.mActivity).setTitleText("提示").setContentMessage("GPS未开启，是否马上设置？").setFirstBtnText("设置").setFirstBtnTextColorHighLight().setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
          {
            public void onClick()
            {
              try
              {
                Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                LightNaviGuideView.this.mActivity.startActivity(localIntent);
                return;
              }
              catch (Exception localException)
              {
                LogUtil.e("", localException.toString());
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mActivity, "打开GPS设置失败，请确认你的手机是否支持GPS定位功能。");
              }
            }
          }).setSecondBtnText("取消").setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
          {
            public void onClick()
            {
              TipTool.onCreateToastDialog(LightNaviGuideView.this.mActivity, "只有在开启GPS后才可以正常导航，请开启GPS!");
            }
          });
        }
        this.mGPSSettingDialog.show();
      }
      return;
    }
    finally {}
  }
  
  public void showUgcDetailView(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.mContext != null) {
        TipTool.onCreateToastDialog(this.mContext, "感谢您的反馈，我们将尽快处理");
      }
    }
    do
    {
      return;
      if (this.mWrapperCallback != null) {
        this.mWrapperCallback.registerLoadingProxy();
      }
      BNRCEventDetailsViewController.getInstance().setSource(2);
      this.mRCEventDetailsView = BNRCEventDetailsViewController.getInstance().getView(this.mContext, paramString, BNaviModuleManager.getBduss(), this.mUgcRCEventCallback, 1);
      UserOPController.getInstance().add("3.u.2", "3", null, null);
    } while ((this.mMenuViewContainer == null) || (this.mRCEventDetailsView == null));
    paramString = new FrameLayout.LayoutParams(-1, -1);
    this.mMenuViewContainer.removeAllViews();
    this.mMenuViewContainer.addView(this.mRCEventDetailsView, paramString);
    this.mMenuViewContainer.setVisibility(0);
  }
  
  public void showUserRightView()
  {
    if (this.mUserRightView != null) {
      this.mUserRightView.show();
    }
  }
  
  public static abstract interface LightNaviWrapperCallback
  {
    public abstract void registerLoadingProxy();
    
    public abstract void unRegisterLoadingProxy();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/LightNaviGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */