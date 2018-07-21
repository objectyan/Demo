package com.baidu.navisdk.ui.routeguide.control;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator.VoiceSearchCallback;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationShowFocusListener;
import com.baidu.navisdk.ui.routeguide.model.RGCommonNotificationModel;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGJamReportModel;
import com.baidu.navisdk.ui.routeguide.model.RGOperableNotificationModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions.Builder;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RGNotificationController
{
  private static final String TAG = RGNotificationController.class.getSimpleName();
  private static RGNotificationController sInstance = null;
  private ArrayList<RGCommonNotificationModel> mCommonModelList = new ArrayList();
  private int mCommonRandomInt = -1;
  private ArrayList<RGMMCommonNotificationView> mCommonViewList = new ArrayList();
  public boolean mIsClickQuietBtn = false;
  private RGMMOperableNotificationView.NotificationShowFocusListener mNotificationShowFocusListener;
  private ArrayList<RGOperableNotificationModel> mOperableModelList = new ArrayList();
  private int mOperableRandomInt = -1;
  private ArrayList<RGMMOperableNotificationView> mOperableViewList = new ArrayList();
  
  private void commonModelListToString()
  {
    if ((this.mCommonModelList == null) || (this.mCommonModelList.isEmpty()))
    {
      LogUtil.e(TAG, "mCommonModelList = " + this.mCommonModelList);
      return;
    }
    int i = 0;
    label48:
    if (i < this.mCommonModelList.size())
    {
      if (this.mCommonModelList.get(i) != null) {
        break label107;
      }
      LogUtil.e(TAG, "mCommonModelList (" + i + ") is null");
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label107:
      LogUtil.e(TAG, i + "mCommonModelList mID = " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mID + " mPriority = " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mPriority + ", mMainTitleText = " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mMainTitleText + ", mSubTitleText = " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mSubTitleText + ", mThirdTitleText + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mThirdTitleText + ", mMainTitleColor + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mMainTitleColor + ", mSubTitleColor + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mSubTitleColor + ", mThirdTitleColor + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mThirdTitleColor + ", mNotificationColor + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mNotificationColor + ", mAutoHideTime + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mAutoHideTime + ", mNotificationIcon + " + ((RGCommonNotificationModel)this.mCommonModelList.get(i)).mNotificationIcon);
    }
  }
  
  private void commonViewListToString()
  {
    if ((this.mCommonViewList == null) || (this.mCommonViewList.isEmpty()))
    {
      LogUtil.e(TAG, "mCommonViewList = " + this.mCommonViewList);
      return;
    }
    int i = 0;
    label48:
    if (i < this.mCommonViewList.size())
    {
      if (this.mCommonModelList.get(i) != null) {
        break label107;
      }
      LogUtil.e(TAG, "mCommonViewList (" + i + ") is null");
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label107:
      LogUtil.e(TAG, i + "mCommonViewList hashCode = " + ((RGMMCommonNotificationView)this.mCommonViewList.get(i)).hashCode());
    }
  }
  
  public static RGNotificationController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new RGNotificationController();
      }
      return sInstance;
    }
    finally {}
  }
  
  private String getLocalRouteInfo()
  {
    Bundle localBundle = new Bundle();
    boolean bool = JNIGuidanceControl.getInstance().GetLocalRouteInfo(localBundle);
    if ((localBundle == null) || (!bool)) {
      return "";
    }
    return Html.fromHtml(localBundle.getString("info")).toString();
  }
  
  private SearchParkPoi getNearestParkPoi()
  {
    ArrayList localArrayList = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchParkPoi();
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    int j;
    do
    {
      return null;
      int m = 10000;
      j = 0;
      localArrayList = new ArrayList(localArrayList);
      int i = 0;
      while (i < localArrayList.size())
      {
        SearchParkPoi localSearchParkPoi = (SearchParkPoi)localArrayList.get(i);
        int n = m;
        int k = j;
        if (localSearchParkPoi != null)
        {
          n = m;
          k = j;
          if (localSearchParkPoi.mDistance < m)
          {
            n = localSearchParkPoi.mDistance;
            k = i;
          }
        }
        i += 1;
        m = n;
        j = k;
      }
    } while (j >= localArrayList.size());
    return (SearchParkPoi)localArrayList.get(j);
  }
  
  private String getRPPreferTipsText()
  {
    String str1 = "";
    String str2 = RGRouteSortController.getInstance().getCurrentRouteSortName();
    if (!TextUtils.isEmpty(str2)) {
      str1 = JarUtils.getResources().getString(1711670325, new Object[] { str2 });
    }
    return str1;
  }
  
  private void handleClickVoiceDownloadBtn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    VoiceInfo localVoiceInfo = new VoiceInfo();
    localVoiceInfo.status = 4;
    localVoiceInfo.voiceUrl = paramString;
    paramString = new Bundle();
    paramString.putInt("root_page_type", 2);
    paramString.putBundle("VOICEINFO", localVoiceInfo.toBundle());
    BNVoice.getInstance().setInternalCall(paramString);
    BNavigator.getInstance().jumpToRecommendVoicePage(paramString);
  }
  
  private void hideCommonViewInner(int paramInt)
  {
    if (this.mCommonModelList == null) {}
    do
    {
      RGCommonNotificationModel localRGCommonNotificationModel;
      do
      {
        int i;
        do
        {
          return;
          i = this.mCommonModelList.size();
        } while (i == 0);
        localRGCommonNotificationModel = (RGCommonNotificationModel)this.mCommonModelList.get(i - 1);
      } while ((localRGCommonNotificationModel == null) || (localRGCommonNotificationModel.mNotificationType != paramInt));
      if (localRGCommonNotificationModel.mView != null) {
        localRGCommonNotificationModel.mView.hideWithoutRemoveModel();
      }
      localRGCommonNotificationModel.reset();
    } while (this.mCommonModelList.isEmpty());
    this.mCommonModelList.remove(this.mCommonModelList.size() - 1);
  }
  
  private void hideOperableViewInner(int paramInt)
  {
    if (this.mOperableModelList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mOperableModelList.iterator();
      while (localIterator.hasNext())
      {
        RGOperableNotificationModel localRGOperableNotificationModel = (RGOperableNotificationModel)localIterator.next();
        if ((localRGOperableNotificationModel != null) && (localRGOperableNotificationModel.mNotificationType == paramInt) && (localRGOperableNotificationModel.mView != null))
        {
          localRGOperableNotificationModel.mView.hideWithoutRemoveModel();
          localRGOperableNotificationModel.reset();
          localIterator.remove();
        }
      }
    }
  }
  
  private boolean isOnLineNetMode()
  {
    int i = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
    return (i == 3) || (i == 1);
  }
  
  private void operableModelListToString()
  {
    if ((this.mOperableModelList == null) || (this.mOperableModelList.isEmpty()))
    {
      LogUtil.e(TAG, "mOperableModelList = " + this.mOperableModelList);
      return;
    }
    int i = 0;
    label49:
    if (i < this.mOperableModelList.size())
    {
      if (this.mOperableModelList.get(i) != null) {
        break label109;
      }
      LogUtil.e(TAG, "mOperableModelList (" + i + ") is null");
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label109:
      LogUtil.e(TAG, i + "mOperableModelList mID = " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mID + " mPriority = " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mPriority + ", mMainTitleText = " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mMainTitleText + ", mSubTitleText = " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mSubTitleText + ", mMainTitleColor + " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mMainTitleColor + ", mSubTitleColor + " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mSubTitleColor + ", mNotificationColor + " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mNotificationColor + ", mAutoHideTime + " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mAutoHideTime + ", mNotificationIcon + " + ((RGOperableNotificationModel)this.mOperableModelList.get(i)).mNotificationIcon);
    }
  }
  
  private void operableViewListToString()
  {
    if ((this.mOperableViewList == null) || (this.mOperableViewList.isEmpty()))
    {
      LogUtil.e(TAG, "mOperableViewList = " + this.mOperableViewList);
      return;
    }
    int i = 0;
    label49:
    if (i < this.mOperableViewList.size())
    {
      if (this.mOperableViewList.get(i) != null) {
        break label109;
      }
      LogUtil.e(TAG, "mOperableViewList (" + i + ") is null");
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label109:
      LogUtil.e(TAG, i + "mOperableViewList hashCode = " + ((RGMMOperableNotificationView)this.mOperableViewList.get(i)).hashCode());
    }
  }
  
  private void updateCommonRandomInt()
  {
    this.mCommonRandomInt = new Random().nextInt(9);
    LogUtil.e(TAG, "mCommonRandomInt = " + this.mCommonRandomInt);
  }
  
  private void updateOperableRandomInt()
  {
    this.mOperableRandomInt = new Random().nextInt(4);
    LogUtil.e(TAG, "mOperableRandomInt = " + this.mOperableRandomInt);
  }
  
  public void addCommonModel(RGCommonNotificationModel paramRGCommonNotificationModel)
  {
    if ((this.mCommonModelList == null) || (paramRGCommonNotificationModel == null)) {}
    while (this.mCommonModelList.contains(paramRGCommonNotificationModel)) {
      return;
    }
    this.mCommonModelList.add(paramRGCommonNotificationModel);
  }
  
  public void addCommonView(RGMMCommonNotificationView paramRGMMCommonNotificationView)
  {
    if ((this.mCommonViewList == null) || (paramRGMMCommonNotificationView == null)) {}
    while (this.mCommonViewList.contains(paramRGMMCommonNotificationView)) {
      return;
    }
    this.mCommonViewList.add(paramRGMMCommonNotificationView);
  }
  
  public void addOperableModel(RGOperableNotificationModel paramRGOperableNotificationModel)
  {
    if ((this.mOperableModelList == null) || (paramRGOperableNotificationModel == null)) {}
    while (this.mOperableModelList.contains(paramRGOperableNotificationModel)) {
      return;
    }
    this.mOperableModelList.add(paramRGOperableNotificationModel);
  }
  
  public void addOperableView(RGMMOperableNotificationView paramRGMMOperableNotificationView)
  {
    if ((this.mOperableViewList == null) || (paramRGMMOperableNotificationView == null)) {}
    while (this.mOperableViewList.contains(paramRGMMOperableNotificationView)) {
      return;
    }
    this.mOperableViewList.add(paramRGMMOperableNotificationView);
  }
  
  public boolean allowNotificationShow(boolean paramBoolean, int paramInt)
  {
    boolean bool4 = "NAV_STATE_OPERATE".equals(RGControlPanelModel.getInstance().getNavState());
    ViewGroup localViewGroup1 = RGViewController.getInstance().getSafetyViewContails();
    ViewGroup localViewGroup2 = RGViewController.getInstance().getModuleContails();
    boolean bool1;
    boolean bool2;
    if (localViewGroup1 == null)
    {
      bool1 = false;
      if (localViewGroup2 != null) {
        break label353;
      }
      bool2 = false;
    }
    boolean bool6;
    boolean bool7;
    boolean bool8;
    boolean bool9;
    boolean bool10;
    boolean bool11;
    boolean bool12;
    boolean bool13;
    boolean bool5;
    for (;;)
    {
      bool6 = RGViewController.getInstance().isBlueToothUSBGuideVisible();
      bool7 = RGViewController.getInstance().isMenuMoreVisible();
      bool8 = RGViewController.getInstance().isRouteSearchVisible();
      bool9 = RGViewController.getInstance().isUGCPanelVisible();
      bool10 = RGViewController.getInstance().isCommomViewShow();
      bool11 = RGViewController.getInstance().isEnlargeOrColladaShow();
      bool12 = RGMapModeViewController.getInstance().getHudShowStatus();
      bool13 = RGMapModeViewController.getInstance().isRouteSortViewVisible();
      bool5 = RGMapModeViewController.getInstance().isToolboxOpened();
      LogUtil.e(TAG, "allowNotificationShow isNavOperate = " + bool4 + ", isSafetyVisible = " + bool1 + ", isModuleVisible = " + bool2 + ", isBlueToothUSBGuideVisible = " + bool6 + ", isMenuMoreVisible = " + bool7 + ", isRouteSearchVisible = " + bool8 + ", isUGCPanelVisible = " + bool9 + ", isCommomViewShow = " + bool10 + ", isEnlargeOrColladaShow = " + bool11 + ", isHUDStatus = " + bool12 + ", isRouteSortViewVisible = " + bool13 + ", isToolboxOpened = " + bool5);
      if ((!paramBoolean) || ((paramInt != 103) && (paramInt != 107) && (paramInt != 108) && (paramInt != 102)) || (bool7) || (bool12) || (bool11)) {
        break label373;
      }
      LogUtil.e(TAG, "allowNotificationShow return true type = " + paramInt);
      return true;
      if (localViewGroup1.getVisibility() == 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label353:
      if (localViewGroup2.getVisibility() == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    label373:
    boolean bool3;
    if ((!paramBoolean) || (paramInt != 106))
    {
      bool3 = bool4;
      if (!paramBoolean)
      {
        bool3 = bool4;
        if (paramInt != 112) {}
      }
    }
    else
    {
      bool3 = false;
    }
    bool4 = bool5;
    if (paramBoolean) {
      if ((paramInt != 100) && (paramInt != 105) && (paramInt != 104))
      {
        bool4 = bool5;
        if (paramInt != 101) {}
      }
      else
      {
        bool4 = false;
      }
    }
    return (!bool3) && (!bool1) && (!bool2) && (!bool6) && (!bool7) && (!bool8) && (!bool9) && (!bool10) && (!bool11) && (!bool12) && (!bool13) && (!bool4);
  }
  
  public void comfirmPickPoint()
  {
    RGPickPointModel.getInstance().setPickPointShow(false);
    BNRoutePlaner.getInstance().setGuideEndType(1);
    if (RGRouteSearchModel.getInstance().isRouteSearchMode())
    {
      RGRouteSearchModel.getInstance().setRouteSearchMode(false);
      BNPoiSearcher.getInstance().clearBkgCache();
      BNMapController.getInstance().updateLayer(4);
      BNMapController.getInstance().showLayer(4, false);
      BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410310", "410310");
    }
    RGSimpleGuideModel.getInstance();
    RGSimpleGuideModel.mCalcRouteType = 1;
    RGEngineControl localRGEngineControl = RGEngineControl.getInstance();
    GeoPoint localGeoPoint = RGPickPointModel.getInstance().getPickPoint();
    if (RGPickPointModel.getInstance().getAntiSearchPoi() != null) {}
    for (String str = RGPickPointModel.getInstance().getAntiSearchPoi().mName;; str = "")
    {
      localRGEngineControl.addViaPtToCalcRoute(localGeoPoint, str);
      if (BNavigator.getInstance().getmVoiceSearchCallBack() != null) {
        BNavigator.getInstance().getmVoiceSearchCallBack().comfirmSuccess(RGPickPointModel.getInstance().getAntiSearchPoi().mName);
      }
      return;
    }
  }
  
  public void debugCommonNotification(boolean paramBoolean)
  {
    if (paramBoolean) {
      updateCommonRandomInt();
    }
    switch (this.mCommonRandomInt)
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
                  return;
                } while (!paramBoolean);
                showCancelRouteRecommend();
                return;
                if (paramBoolean)
                {
                  RGViewController.getInstance().newCommonNotification(109).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(1711408000)).setMainTitleText("假数据：UGC交警").setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
                  {
                    public void onHideWithAnim()
                    {
                      RGSimpleGuideModel.mIsUgcOfficialEvent = false;
                    }
                    
                    public void onHideWithOutAnim()
                    {
                      RGSimpleGuideModel.mIsUgcOfficialEvent = false;
                    }
                    
                    public void onShowWithAnim() {}
                    
                    public void onShowWithOutAnim() {}
                  }).show();
                  return;
                }
                hideCommonView(109);
                return;
              } while (!paramBoolean);
              showFloatWindowSuccess();
              return;
            } while (!paramBoolean);
            showSwitchRouteFail();
            return;
          } while (!paramBoolean);
          showSwitchRouteSuccess();
          return;
          if (paramBoolean)
          {
            RGViewController.getInstance().newCommonNotification(111).setPriority(200).setNotificationIcon(BNStyleManager.getDrawable(1711407996)).setMainTitleText(BNStyleManager.getString(1711669392)).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
            {
              public void onHideWithAnim()
              {
                RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
              }
              
              public void onHideWithOutAnim()
              {
                RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
              }
              
              public void onShowWithAnim() {}
              
              public void onShowWithOutAnim() {}
            }).show();
            return;
          }
          hideCommonView(111);
          return;
        } while (!paramBoolean);
        RGViewController.getInstance().newCommonNotification(103).setPriority(300).setNotificationIcon(BNStyleManager.getDrawable(1711407999)).setMainTitleText("起点在深圳限行区域，合理安排出行避免违章").show();
        return;
      } while (!paramBoolean);
      RGViewController.getInstance().newCommonNotification(104).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407993)).setMainTitleText(BNStyleManager.getString(1711670315)).setSubTitleText(BNStyleManager.getString(1711670317)).show();
      return;
    } while (!paramBoolean);
    RGViewController.getInstance().newCommonNotification(105).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407992)).setMainTitleText(BNStyleManager.getString(1711670318)).show();
  }
  
  public void debugOperableNotification(boolean paramBoolean)
  {
    if (paramBoolean) {
      updateOperableRandomInt();
    }
    switch (this.mOperableRandomInt)
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
            final SearchParkPoi localSearchParkPoi;
            do
            {
              return;
              if (!paramBoolean) {
                break;
              }
              localSearchParkPoi = getNearestParkPoi();
            } while (localSearchParkPoi == null);
            if (localSearchParkPoi.mLeftCnt > 0) {
              String.format("%1$d个空车位，距离终点%2$d米", new Object[] { Integer.valueOf(localSearchParkPoi.mLeftCnt), Integer.valueOf(localSearchParkPoi.mDistance) });
            }
            for (;;)
            {
              RGViewController.getInstance().newOperableNotification(102).setPriority(100).setAutoHideTime(20000).setNotificationIcon(BNStyleManager.getDrawable(1711407991)).setMainTitleText("假数据：目的地停车场主标题").setConfirmText(BNStyleManager.getString(1711670326)).setCancelText(BNStyleManager.getString(1711670327)).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
              {
                public void onAutoHideWithoutClick()
                {
                  BNavigator.getInstance().setmCanParkShow(false);
                  RGViewController.getInstance().hideParkPointView();
                  RGParkPointModel.getInstance().setmIsParkPointShow(false);
                  BNMapController.getInstance().showLayer(4, false);
                }
                
                public void onCancelBtnClick()
                {
                  BNavigator.getInstance().setmCanParkShow(false);
                  RGViewController.getInstance().hideParkPointView();
                  RGParkPointModel.getInstance().setmIsParkPointShow(false);
                  BNMapController.getInstance().showLayer(4, false);
                }
                
                public void onConfirmBtnClick()
                {
                  BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410298", "410298");
                  BNavigator.getInstance().setmCanParkShow(false);
                  BNRoutePlaner.getInstance().setGuideSceneType(4);
                  BNRouteGuider.getInstance().stopRouteGuide();
                  if (localSearchParkPoi != null)
                  {
                    GeoPoint localGeoPoint = localSearchParkPoi.mGuidePoint;
                    RGSimpleGuideModel.getInstance();
                    RGSimpleGuideModel.mCalcRouteType = 4;
                    RGEngineControl.getInstance().setEndPtToCalcRoute(localGeoPoint);
                  }
                }
              }).show();
              return;
              String.format("停车场距终点%1$d米", new Object[] { Integer.valueOf(localSearchParkPoi.mDistance) });
            }
            hideOperableView(102);
            return;
          } while (!paramBoolean);
          showBlueTooth();
          return;
          if (!paramBoolean) {
            break;
          }
        } while ((BNavigator.getInstance().isBackgroundNavi()) || (RGViewController.getInstance().isEnlargeOrColladaShow()) || (RGViewController.getInstance().isUGCFBackMenuVisible()) || (RouteGuideFSM.getInstance().getLastestGlassState() == null) || (RouteGuideFSM.getInstance().getLastestGlassState().equals("BrowseMap")));
        if (RGMapModeViewController.getInstance().getHudShowStatus())
        {
          LogUtil.e(TAG, "showRouteRecommend hud is showing");
          return;
        }
        RGRouteRecommendModel.getInstance().isViewCanShow = true;
        JNIGuidanceControl.getInstance().setShowRouteChoose(1);
        RouteGuideFSM.getInstance().run("[一键全览]按钮点击");
        RGViewController.getInstance().updateZoomViewState();
        BNMapController.getInstance().setHighLightAvoidTrafficRoute(RGRouteRecommendModel.getInstance().getmRouteId());
      } while (!RGRouteRecommendModel.getInstance().isViewCanShow);
      if ((RGRouteRecommendModel.getInstance().getmContent() != null) || (RGRouteRecommendModel.getInstance().getmSubContent() == null)) {}
      RGViewController.getInstance().newOperableNotification(103).setPriority(100).setAutoHideTime(RGRouteRecommendModel.getInstance().getAutoHideTime()).setNotificationIcon(BNStyleManager.getDrawable(1711407997)).setMainTitleText("假数据：更快路线推荐主标题").setSubTitleText("假数据：更快路线推荐副标题").setConfirmText(BNStyleManager.getString(1711670303)).setCancelText(BNStyleManager.getString(1711670304)).setShowMasking(true).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
      {
        public void onAutoHideWithoutClick()
        {
          RGRouteRecommendModel.getInstance().isViewCanShow = false;
          BNavigator.getInstance().actionRouteRecommendClick(false, false);
        }
        
        public void onCancelBtnClick()
        {
          RGRouteRecommendModel.getInstance().isViewCanShow = false;
          BNavigator.getInstance().actionRouteRecommendClick(false, false);
        }
        
        public void onConfirmBtnClick()
        {
          RGRouteRecommendModel.getInstance().isViewCanShow = false;
          BNavigator.getInstance().actionRouteRecommendClick(true, false);
        }
      }).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
      {
        public void onHideWithAnim()
        {
          if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
            RGViewController.getInstance().showHighWayServiceView();
          }
        }
        
        public void onHideWithOutAnim() {}
        
        public void onShowWithAnim()
        {
          RGViewController.getInstance().hideHighWayServiceView();
        }
        
        public void onShowWithOutAnim()
        {
          RGViewController.getInstance().hideHighWayServiceView();
        }
      }).show();
      JNIGuidanceControl.getInstance().setShowRouteChoose(0);
      return;
      RGRouteRecommendModel.getInstance().isViewCanShow = false;
      BNavigator.getInstance().enterNavState();
      JNIGuidanceControl.getInstance().setShowRouteChoose(2);
      hideOperableView(103);
      BNMapController.getInstance().recoveryHighLightRoute();
      return;
    } while (!paramBoolean);
    showWaitRPResult(0);
  }
  
  public void dispose()
  {
    if ((this.mCommonViewList == null) || (this.mOperableViewList == null)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        if (!this.mCommonViewList.isEmpty())
        {
          localObject1 = new ArrayList(this.mCommonViewList);
          this.mCommonViewList.clear();
          localObject2 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((RGMMCommonNotificationView)((Iterator)localObject2).next()).dispose();
          }
          ((ArrayList)localObject1).clear();
        }
        if (!this.mOperableViewList.isEmpty())
        {
          localObject1 = new ArrayList(this.mOperableViewList);
          this.mCommonViewList.clear();
          localObject2 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((RGMMOperableNotificationView)((Iterator)localObject2).next()).dispose();
          }
          ((ArrayList)localObject1).clear();
        }
        localObject2 = RGViewController.getInstance().getView();
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = (ViewGroup)localObject2;
        }
      } while (localObject1 == null);
      localObject2 = RGViewController.getInstance().getViewContails(1711866551);
      ViewGroup localViewGroup = RGViewController.getInstance().getViewContails(1711866552);
      if (localViewGroup != null)
      {
        ((ViewGroup)localObject1).removeView(localViewGroup);
        localViewGroup.setVisibility(8);
      }
    } while (localObject2 == null);
    ((ViewGroup)localObject1).removeView((View)localObject2);
    ((View)localObject2).setVisibility(8);
  }
  
  public ArrayList<RGCommonNotificationModel> getCommonModelList()
  {
    return this.mCommonModelList;
  }
  
  public ArrayList<RGMMCommonNotificationView> getCommonViewList()
  {
    return this.mCommonViewList;
  }
  
  public int getLocalRouteType()
  {
    Bundle localBundle = new Bundle();
    boolean bool = JNIGuidanceControl.getInstance().GetLocalRouteInfo(localBundle);
    if ((localBundle == null) || (!bool)) {}
    while (TextUtils.isEmpty(Html.fromHtml(localBundle.getString("info")).toString())) {
      return -1;
    }
    return localBundle.getInt("type");
  }
  
  public RGMMOperableNotificationView.NotificationShowFocusListener getNotificationShowFocusListener()
  {
    return this.mNotificationShowFocusListener;
  }
  
  public ArrayList<RGOperableNotificationModel> getOperableModelList()
  {
    return this.mOperableModelList;
  }
  
  public ArrayList<RGMMOperableNotificationView> getOperableViewList()
  {
    return this.mOperableViewList;
  }
  
  public RGMMOperableNotificationView getRepeatedOperableView(int paramInt)
  {
    Object localObject2 = null;
    if (this.mOperableModelList == null) {
      return null;
    }
    Iterator localIterator = this.mOperableModelList.iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (RGOperableNotificationModel)localIterator.next();
    } while ((localObject1 == null) || (((RGOperableNotificationModel)localObject1).mNotificationType != paramInt) || (((RGOperableNotificationModel)localObject1).mView == null));
    Object localObject1 = ((RGOperableNotificationModel)localObject1).mView;
    return (RGMMOperableNotificationView)localObject1;
  }
  
  public boolean hasOperableNotification()
  {
    return (this.mOperableModelList != null) && (!this.mOperableModelList.isEmpty());
  }
  
  public boolean hasOtherOperableModelShowMasking(RGOperableNotificationModel paramRGOperableNotificationModel)
  {
    if ((this.mOperableModelList == null) || (paramRGOperableNotificationModel == null)) {}
    RGOperableNotificationModel localRGOperableNotificationModel;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = this.mOperableModelList.iterator();
      }
      localRGOperableNotificationModel = (RGOperableNotificationModel)localIterator.next();
    } while ((localRGOperableNotificationModel == null) || (localRGOperableNotificationModel.equals(paramRGOperableNotificationModel)) || (!localRGOperableNotificationModel.mIsShowMasking));
    return true;
  }
  
  public void hideAllCommonView()
  {
    if (this.mCommonModelList == null) {
      return;
    }
    Iterator localIterator = this.mCommonModelList.iterator();
    label16:
    RGCommonNotificationModel localRGCommonNotificationModel;
    while (localIterator.hasNext())
    {
      localRGCommonNotificationModel = (RGCommonNotificationModel)localIterator.next();
      if ((localRGCommonNotificationModel != null) && (localRGCommonNotificationModel.mView != null) && (localRGCommonNotificationModel.mView.mInAnimation != null))
      {
        if (!localRGCommonNotificationModel.mView.mInAnimation.hasEnded()) {
          break label89;
        }
        localRGCommonNotificationModel.mView.hideWithoutRemoveModel();
      }
    }
    for (;;)
    {
      localRGCommonNotificationModel.reset();
      localIterator.remove();
      break label16;
      break;
      label89:
      localRGCommonNotificationModel.mView.hideWithoutAnim();
    }
  }
  
  public void hideAllOperableView()
  {
    if (this.mOperableModelList == null) {
      return;
    }
    Iterator localIterator = this.mOperableModelList.iterator();
    label16:
    RGOperableNotificationModel localRGOperableNotificationModel;
    while (localIterator.hasNext())
    {
      localRGOperableNotificationModel = (RGOperableNotificationModel)localIterator.next();
      if ((localRGOperableNotificationModel != null) && (localRGOperableNotificationModel.mView != null) && (localRGOperableNotificationModel.mView.mInAnimation != null))
      {
        if (!localRGOperableNotificationModel.mView.mInAnimation.hasEnded()) {
          break label89;
        }
        localRGOperableNotificationModel.mView.hideWithoutRemoveModel();
      }
    }
    for (;;)
    {
      localRGOperableNotificationModel.reset();
      localIterator.remove();
      break label16;
      break;
      label89:
      localRGOperableNotificationModel.mView.hideWithoutAnim();
    }
  }
  
  public void hideAllView(boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtil.e(TAG, "hideAllView isCommonViewRecoverable = " + paramBoolean1 + ", isOperableViewRecoverable = " + paramBoolean2);
    if ((this.mCommonModelList == null) || (this.mOperableModelList == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mCommonModelList.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (RGCommonNotificationModel)localIterator.next();
        if ((localObject != null) && (((RGCommonNotificationModel)localObject).mView != null))
        {
          ((RGCommonNotificationModel)localObject).mView.hideWithoutAnim();
          if (!paramBoolean1)
          {
            ((RGCommonNotificationModel)localObject).reset();
            localIterator.remove();
          }
        }
      }
      localIterator = this.mOperableModelList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (RGOperableNotificationModel)localIterator.next();
        if ((localObject != null) && (((RGOperableNotificationModel)localObject).mView != null))
        {
          ((RGOperableNotificationModel)localObject).mView.hideWithoutAnim();
          if (!paramBoolean2)
          {
            ((RGOperableNotificationModel)localObject).mView.dispose();
            ((RGOperableNotificationModel)localObject).reset();
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public void hideCommonView(int paramInt)
  {
    LogUtil.e(TAG, "hideCommonView type = " + paramInt);
    hideCommonViewInner(paramInt);
    switch (paramInt)
    {
    }
  }
  
  public void hideCommonViewByHandler(RGMMCommonNotificationView paramRGMMCommonNotificationView)
  {
    paramRGMMCommonNotificationView.hide();
  }
  
  public void hideOperableView(int paramInt)
  {
    LogUtil.e(TAG, "hideOperableView type = " + paramInt);
    hideOperableViewInner(paramInt);
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!RGHighwayModel.getInstance().isSimpleBoardCanShow());
    RGViewController.getInstance().showHighWayServiceView();
  }
  
  public void hideOperableViewByHandler(RGMMOperableNotificationView paramRGMMOperableNotificationView)
  {
    paramRGMMOperableNotificationView.autoHideWithoutClick();
    paramRGMMOperableNotificationView.hide();
  }
  
  public void hideOtherCommonViewBeforeThis(RGCommonNotificationModel paramRGCommonNotificationModel)
  {
    if ((this.mCommonModelList == null) || (paramRGCommonNotificationModel == null)) {
      LogUtil.e(TAG, "mCommonModelList = " + this.mCommonModelList + ", model = " + paramRGCommonNotificationModel);
    }
    RGCommonNotificationModel localRGCommonNotificationModel;
    label137:
    do
    {
      return;
      for (;;)
      {
        if (!this.mCommonModelList.contains(paramRGCommonNotificationModel))
        {
          LogUtil.e(TAG, "mode is not in the list");
          return;
        }
        Iterator localIterator = this.mCommonModelList.iterator();
        while (localIterator.hasNext())
        {
          localRGCommonNotificationModel = (RGCommonNotificationModel)localIterator.next();
          if ((localRGCommonNotificationModel == null) || (localRGCommonNotificationModel.equals(paramRGCommonNotificationModel))) {
            break label137;
          }
          if (localRGCommonNotificationModel.mView != null)
          {
            localRGCommonNotificationModel.mView.hideWithoutAnim();
            localRGCommonNotificationModel.reset();
            localIterator.remove();
          }
        }
      }
    } while ((localRGCommonNotificationModel == null) || (!localRGCommonNotificationModel.equals(paramRGCommonNotificationModel)));
  }
  
  public void hidePickPoint()
  {
    hideOperableView(106);
  }
  
  public void hideRepeatedOperableView(int paramInt)
  {
    if (this.mOperableModelList == null) {}
    Iterator localIterator;
    RGOperableNotificationModel localRGOperableNotificationModel;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = this.mOperableModelList.iterator();
      }
      localRGOperableNotificationModel = (RGOperableNotificationModel)localIterator.next();
    } while ((localRGOperableNotificationModel == null) || (localRGOperableNotificationModel.mNotificationType != paramInt) || (localRGOperableNotificationModel.mView == null));
    localRGOperableNotificationModel.mView.hideWithoutRemoveModel();
    localRGOperableNotificationModel.reset();
    localIterator.remove();
  }
  
  public void hideRouteRecommend()
  {
    LogUtil.e(TAG, "hideRouteRecommend");
    if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
      RGViewController.getInstance().showHighWayServiceView();
    }
  }
  
  public boolean isContainsCommonModel(RGCommonNotificationModel paramRGCommonNotificationModel)
  {
    if ((this.mCommonModelList == null) || (this.mCommonModelList.isEmpty()) || (paramRGCommonNotificationModel == null)) {
      return false;
    }
    return this.mCommonModelList.contains(paramRGCommonNotificationModel);
  }
  
  public boolean isContainsCommonView(RGMMCommonNotificationView paramRGMMCommonNotificationView)
  {
    if ((this.mCommonViewList == null) || (this.mCommonViewList.isEmpty()) || (paramRGMMCommonNotificationView == null)) {
      return false;
    }
    return this.mCommonViewList.contains(paramRGMMCommonNotificationView);
  }
  
  public boolean isContainsOperableModel(RGOperableNotificationModel paramRGOperableNotificationModel)
  {
    if ((this.mOperableModelList == null) || (this.mOperableModelList.isEmpty()) || (paramRGOperableNotificationModel == null)) {
      return false;
    }
    return this.mOperableModelList.contains(paramRGOperableNotificationModel);
  }
  
  public boolean isContainsOperableType(int paramInt)
  {
    if ((this.mOperableModelList == null) || (this.mOperableModelList.isEmpty())) {
      return false;
    }
    int i = 0;
    label21:
    RGOperableNotificationModel localRGOperableNotificationModel;
    if (i < this.mOperableModelList.size())
    {
      localRGOperableNotificationModel = (RGOperableNotificationModel)this.mOperableModelList.get(i);
      if (localRGOperableNotificationModel != null) {
        break label55;
      }
    }
    label55:
    while (localRGOperableNotificationModel.mNotificationType != paramInt)
    {
      i += 1;
      break label21;
      break;
    }
    return true;
  }
  
  public boolean isContainsOperableView(RGMMOperableNotificationView paramRGMMOperableNotificationView)
  {
    if ((this.mOperableViewList == null) || (this.mOperableViewList.isEmpty()) || (paramRGMMOperableNotificationView == null)) {
      return false;
    }
    return this.mOperableViewList.contains(paramRGMMOperableNotificationView);
  }
  
  public void onConfigurationChanged()
  {
    if ((this.mCommonModelList == null) || (this.mOperableModelList == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator;
      Object localObject;
      if (!this.mOperableModelList.isEmpty())
      {
        localIterator = this.mOperableModelList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (RGOperableNotificationModel)localIterator.next();
          if (localObject != null)
          {
            LogUtil.e(TAG, "recoveryOperableView NotificationType:" + ((RGOperableNotificationModel)localObject).mNotificationType);
            ((RGOperableNotificationModel)localObject).mView = RGMapModeViewController.getInstance().newOperableNotification(((RGOperableNotificationModel)localObject).mNotificationType);
            if (((RGOperableNotificationModel)localObject).mView != null)
            {
              ((RGOperableNotificationModel)localObject).mID = String.valueOf(((RGOperableNotificationModel)localObject).mView.hashCode());
              if ((((RGOperableNotificationModel)localObject).mPriority == 100) || (((RGOperableNotificationModel)localObject).mPriority == 200) || (((RGOperableNotificationModel)localObject).mPriority == 300)) {
                ((RGOperableNotificationModel)localObject).mView.setModel((RGOperableNotificationModel)localObject).setPriority(((RGOperableNotificationModel)localObject).mPriority).setMainTitleText(((RGOperableNotificationModel)localObject).mMainTitleText).setSubTitleText(((RGOperableNotificationModel)localObject).mSubTitleText).setNotificationIcon(((RGOperableNotificationModel)localObject).mNotificationIcon).setNotificationIcon(((RGOperableNotificationModel)localObject).mIconUrl, ((RGOperableNotificationModel)localObject).mIconOptions, ((RGOperableNotificationModel)localObject).mIconListener).setConfirmText(((RGOperableNotificationModel)localObject).mConfirmText).setCancelText(((RGOperableNotificationModel)localObject).mCancelText).setOnClick(((RGOperableNotificationModel)localObject).mOnBtnClickListener).setDisplayListener(((RGOperableNotificationModel)localObject).mDisplayListener).setShowMasking(((RGOperableNotificationModel)localObject).mIsShowMasking).recoveryView();
              } else {
                ((RGOperableNotificationModel)localObject).mView.setModel((RGOperableNotificationModel)localObject).setMainTitleText(((RGOperableNotificationModel)localObject).mMainTitleText).setSubTitleText(((RGOperableNotificationModel)localObject).mSubTitleText).setMainTitleColor(((RGOperableNotificationModel)localObject).mMainTitleColor).setSubTitleColor(((RGOperableNotificationModel)localObject).mSubTitleColor).setConfirmText(((RGOperableNotificationModel)localObject).mConfirmText).setCancelText(((RGOperableNotificationModel)localObject).mCancelText).setConfirmTextColor(((RGOperableNotificationModel)localObject).mConfirmColor).setCancelTextColor(((RGOperableNotificationModel)localObject).mCancelColor).setNotificationIcon(((RGOperableNotificationModel)localObject).mNotificationIcon).setNotificationIcon(((RGOperableNotificationModel)localObject).mIconUrl, ((RGOperableNotificationModel)localObject).mIconOptions, ((RGOperableNotificationModel)localObject).mIconListener).setNotificationColor(((RGOperableNotificationModel)localObject).mNotificationColor).setConfirmBackground(((RGOperableNotificationModel)localObject).mConfirmBackground).setCancelBackground(((RGOperableNotificationModel)localObject).mCancelBackground).setOnClick(((RGOperableNotificationModel)localObject).mOnBtnClickListener).setDisplayListener(((RGOperableNotificationModel)localObject).mDisplayListener).setShowMasking(((RGOperableNotificationModel)localObject).mIsShowMasking).recoveryView();
              }
            }
          }
        }
      }
      else
      {
        localIterator = this.mCommonModelList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (RGCommonNotificationModel)localIterator.next();
          if (localObject != null) {
            if (localIterator.hasNext())
            {
              ((RGCommonNotificationModel)localObject).reset();
              localIterator.remove();
            }
            else
            {
              LogUtil.e(TAG, "recoveryCommonView NotificationType:" + ((RGCommonNotificationModel)localObject).mNotificationType);
              ((RGCommonNotificationModel)localObject).mView = RGMapModeViewController.getInstance().newCommonNotification(((RGCommonNotificationModel)localObject).mNotificationType);
              if (((RGCommonNotificationModel)localObject).mView != null)
              {
                ((RGCommonNotificationModel)localObject).mID = String.valueOf(((RGCommonNotificationModel)localObject).mView.hashCode());
                if ((((RGCommonNotificationModel)localObject).mPriority == 100) || (((RGCommonNotificationModel)localObject).mPriority == 200) || (((RGCommonNotificationModel)localObject).mPriority == 300)) {
                  ((RGCommonNotificationModel)localObject).mView.setModel((RGCommonNotificationModel)localObject).setPriority(((RGCommonNotificationModel)localObject).mPriority).setMainTitleText(((RGCommonNotificationModel)localObject).mMainTitleText).setSubTitleText(((RGCommonNotificationModel)localObject).mSubTitleText).setThirdTitleText(((RGCommonNotificationModel)localObject).mThirdTitleText).setNotificationIcon(((RGCommonNotificationModel)localObject).mNotificationIcon).setNotificationIcon(((RGCommonNotificationModel)localObject).mIconUrl, ((RGCommonNotificationModel)localObject).mIconOptions, ((RGCommonNotificationModel)localObject).mIconListener).setDisplayListener(((RGCommonNotificationModel)localObject).mDisplayListener).recoveryView();
                } else {
                  ((RGCommonNotificationModel)localObject).mView.setModel((RGCommonNotificationModel)localObject).setMainTitleText(((RGCommonNotificationModel)localObject).mMainTitleText).setSubTitleText(((RGCommonNotificationModel)localObject).mSubTitleText).setThirdTitleText(((RGCommonNotificationModel)localObject).mThirdTitleText).setMainTitleColor(((RGCommonNotificationModel)localObject).mMainTitleColor).setSubTitleColor(((RGCommonNotificationModel)localObject).mSubTitleColor).setThirdTitleColor(((RGCommonNotificationModel)localObject).mThirdTitleColor).setNotificationColor(((RGCommonNotificationModel)localObject).mNotificationColor).setNotificationIcon(((RGCommonNotificationModel)localObject).mNotificationIcon).setNotificationIcon(((RGCommonNotificationModel)localObject).mIconUrl, ((RGCommonNotificationModel)localObject).mIconOptions, ((RGCommonNotificationModel)localObject).mIconListener).setDisplayListener(((RGCommonNotificationModel)localObject).mDisplayListener).recoveryView();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void recoveryOperableNotification()
  {
    if (this.mOperableModelList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mOperableModelList.iterator();
      while (localIterator.hasNext())
      {
        RGOperableNotificationModel localRGOperableNotificationModel = (RGOperableNotificationModel)localIterator.next();
        if ((localRGOperableNotificationModel != null) && (localRGOperableNotificationModel.mView != null)) {
          localRGOperableNotificationModel.mView.recoveryView();
        }
      }
    }
  }
  
  public void removeCommonModel(RGCommonNotificationModel paramRGCommonNotificationModel)
  {
    if ((this.mCommonModelList == null) || (paramRGCommonNotificationModel == null)) {}
    Iterator localIterator;
    RGCommonNotificationModel localRGCommonNotificationModel;
    do
    {
      do
      {
        return;
        while (!this.mCommonModelList.contains(paramRGCommonNotificationModel)) {}
        localIterator = this.mCommonModelList.iterator();
      } while (!localIterator.hasNext());
      localRGCommonNotificationModel = (RGCommonNotificationModel)localIterator.next();
    } while ((localRGCommonNotificationModel == null) || (!localRGCommonNotificationModel.equals(paramRGCommonNotificationModel)));
    localRGCommonNotificationModel.reset();
    localIterator.remove();
  }
  
  public void removeCommonView(RGMMCommonNotificationView paramRGMMCommonNotificationView)
  {
    if ((this.mCommonViewList == null) || (paramRGMMCommonNotificationView == null)) {}
    Iterator localIterator;
    RGMMCommonNotificationView localRGMMCommonNotificationView;
    do
    {
      do
      {
        return;
        while (!this.mCommonViewList.contains(paramRGMMCommonNotificationView)) {}
        localIterator = this.mCommonViewList.iterator();
      } while (!localIterator.hasNext());
      localRGMMCommonNotificationView = (RGMMCommonNotificationView)localIterator.next();
    } while ((localRGMMCommonNotificationView == null) || (!localRGMMCommonNotificationView.equals(paramRGMMCommonNotificationView)));
    localIterator.remove();
  }
  
  public void removeOperableModel(RGOperableNotificationModel paramRGOperableNotificationModel)
  {
    if ((this.mOperableModelList == null) || (paramRGOperableNotificationModel == null)) {}
    Iterator localIterator;
    RGOperableNotificationModel localRGOperableNotificationModel;
    do
    {
      do
      {
        return;
        while (!this.mOperableModelList.contains(paramRGOperableNotificationModel)) {}
        LogUtil.e(TAG, "removeOperableModel mNotificationType:" + paramRGOperableNotificationModel.mNotificationType);
        localIterator = this.mOperableModelList.iterator();
      } while (!localIterator.hasNext());
      localRGOperableNotificationModel = (RGOperableNotificationModel)localIterator.next();
    } while ((localRGOperableNotificationModel == null) || (!localRGOperableNotificationModel.equals(paramRGOperableNotificationModel)));
    localRGOperableNotificationModel.reset();
    localIterator.remove();
  }
  
  public void removeOperableView(RGMMOperableNotificationView paramRGMMOperableNotificationView)
  {
    if ((this.mOperableViewList == null) || (paramRGMMOperableNotificationView == null)) {}
    Iterator localIterator;
    RGMMOperableNotificationView localRGMMOperableNotificationView;
    do
    {
      do
      {
        return;
        while (!this.mOperableViewList.contains(paramRGMMOperableNotificationView)) {}
        localIterator = this.mOperableViewList.iterator();
      } while (!localIterator.hasNext());
      localRGMMOperableNotificationView = (RGMMOperableNotificationView)localIterator.next();
    } while ((localRGMMOperableNotificationView == null) || (!localRGMMOperableNotificationView.equals(paramRGMMOperableNotificationView)));
    localIterator.remove();
  }
  
  public void setNotificationShowFocusListener(RGMMOperableNotificationView.NotificationShowFocusListener paramNotificationShowFocusListener)
  {
    this.mNotificationShowFocusListener = paramNotificationShowFocusListener;
  }
  
  public void showBlueTooth()
  {
    LogUtil.e(TAG, "showBlueTooth");
    if (isContainsOperableType(104))
    {
      LogUtil.e(TAG, "domestic clould config voice recommend operable notification is showing");
      return;
    }
    if (isContainsOperableType(105))
    {
      LogUtil.e(TAG, "international clould config voice recommend operable notification is showing");
      return;
    }
    RGViewController.getInstance().newOperableNotification(100).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(1711407986)).setMainTitleText(BNStyleManager.getString(1711670328)).setSubTitleText(BNStyleManager.getString(1711670329)).setConfirmText(BNStyleManager.getString(1711670330)).setCancelText(BNStyleManager.getString(1711670331)).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
    {
      public void onAutoHideWithoutClick() {}
      
      public void onCancelBtnClick() {}
      
      public void onConfirmBtnClick()
      {
        RGViewController.getInstance().showMenuMoreView();
      }
    }).show();
  }
  
  public void showBusinessVoiceRecommend()
  {
    LogUtil.e(TAG, "showBusinessVoiceRecommend");
    if (!BNavigator.getInstance().hasCalcRouteOk()) {}
    final Object localObject;
    String str1;
    String str2;
    String str3;
    final String str4;
    do
    {
      do
      {
        do
        {
          return;
        } while ((!BusinessActivityManager.getInstance().getModel().mIsShowVoiceNotificaiton) || (BNSettingManager.getHasVoiceRecommendClicked()));
        localObject = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
      } while (((localObject != null) && (((RoutePlanModel)localObject).getEnNaviType() != 0)) || (BNSettingManager.getVoiceRecommendNotificationShowCnt() >= BusinessActivityManager.getInstance().getModel().mVoiceShowTime));
      localObject = BusinessActivityManager.getInstance().getModel().mVoiceDetailURL;
      str1 = BusinessActivityManager.getInstance().getModel().mVoiceIconURL;
      str2 = BusinessActivityManager.getInstance().getModel().mVoiceMainTitle;
      str3 = BusinessActivityManager.getInstance().getModel().mVoiceSubTitle;
      str4 = BusinessActivityManager.getInstance().getModel().mVoiceTaskId;
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (VoiceHelper.getInstance().isTaskDownloadFinish(str4)));
    BNDisplayImageOptions localBNDisplayImageOptions = new BNDisplayImageOptions.Builder().showImageOnLoading(1711407987).build();
    RGViewController.getInstance().newOperableNotification(104).setPriority(100).setAutoHideTime(BusinessActivityManager.getInstance().getModel().mVoiceAutoHideTime * 1000).setNotificationIcon(str1, localBNDisplayImageOptions, null).setMainTitleText(str2).setSubTitleText(str3).setConfirmText(BNStyleManager.getString(1711670337)).setCancelText(BNStyleManager.getString(1711670338)).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
    {
      public void onAutoHideWithoutClick() {}
      
      public void onCancelBtnClick()
      {
        UserOPController.getInstance().add("5.4.1", "3", null, null);
        BNSettingManager.setHasVoiceRecommendClicked(true);
      }
      
      public void onConfirmBtnClick()
      {
        UserOPController.getInstance().add("5.4.1", "2", null, null);
        if (VoiceHelper.getInstance().isTaskDownloadFinish(str4)) {}
        for (String str = localObject + "&isload=1";; str = localObject + "&isload=0")
        {
          RGNotificationController.this.handleClickVoiceDownloadBtn(str);
          BNSettingManager.setHasVoiceRecommendClicked(true);
          return;
        }
      }
    }).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
    {
      public void onHideWithAnim() {}
      
      public void onHideWithOutAnim() {}
      
      public void onShowWithAnim()
      {
        BNSettingManager.setVoiceRecommendNotificationShowCnt(BNSettingManager.getVoiceRecommendNotificationShowCnt() + 1);
        UserOPController.getInstance().add("5.4.1", "1", null, null);
      }
      
      public void onShowWithOutAnim() {}
    }).show();
  }
  
  public void showCancelRouteRecommend()
  {
    LogUtil.e(TAG, "showCancelRouteRecommend");
    RGViewController.getInstance().newCommonNotification(100).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407988)).setMainTitleText(BNStyleManager.getString(1711670320)).show();
  }
  
  public void showCommonResultMsg(String paramString, boolean paramBoolean)
  {
    RGMMCommonNotificationView localRGMMCommonNotificationView = RGViewController.getInstance().newCommonNotification(112).setPriority(100);
    if (paramBoolean) {}
    for (Drawable localDrawable = BNStyleManager.getDrawable(1711407998);; localDrawable = BNStyleManager.getDrawable(1711407988))
    {
      localRGMMCommonNotificationView.setNotificationIcon(localDrawable).setMainTitleText(paramString).show();
      return;
    }
  }
  
  public void showFirstVoiceGuide()
  {
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask(getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        LogUtil.e("XDVoice", "showFirstVoiceGuide()");
        RGViewController.getInstance().newCommonNotification(113).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(1711407345)).setMainTitleText("呼叫'小度小度'开启语音控制").show();
        BNSettingManager.setFirstVoiceNotifyGuide(false);
        return null;
      }
    }, new BNWorkerConfig(100, 0), 5000L);
  }
  
  public void showFloatWindowSuccess()
  {
    RGViewController.getInstance().newCommonNotification(101).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407998)).setMainTitleText(BNStyleManager.getString(1711670314)).show();
  }
  
  public void showGPSWeak()
  {
    if (!RGSimpleGuideModel.mIsSatellite) {
      return;
    }
    RGViewController.getInstance().newCommonNotification(102).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407990)).setMainTitleText(BNStyleManager.getString(1711670322)).show();
  }
  
  public void showJamReport()
  {
    LogUtil.e(TAG, "showJamReport: --> " + RGJamReportModel.getInstance().isViewCanShow);
    if (!RGJamReportModel.getInstance().isViewCanShow) {
      return;
    }
    RGViewController.getInstance().closeToolbox();
    RGViewController.getInstance().hideRouteSearchView();
    RGViewController.getInstance().hideRouteSortView();
    RGViewController.getInstance().hideMenuMoreView();
    RGViewController.getInstance().onUgcDestroy();
    RGJamReportModel.getInstance().getNotificationView().show();
    UserOPController.getInstance().add("3.u.6", null, null, null);
    RGJamReportModel.getInstance().setHasJamReportShown(true);
  }
  
  public void showLocalRoute(boolean paramBoolean)
  {
    int i = getLocalRouteType();
    String str = getLocalRouteInfo();
    if (i == 1) {
      RGViewController.getInstance().newCommonNotification(103).setPriority(300).setNotificationIcon(BNStyleManager.getDrawable(1711407999)).setMainTitleText(str).show();
    }
    while ((i != 0) || (!paramBoolean)) {
      return;
    }
    RGViewController.getInstance().newCommonNotification(103).setPriority(300).setNotificationIcon(BNStyleManager.getDrawable(1711407999)).setMainTitleText(BNStyleManager.getString(1711670323)).setSubTitleText(BNStyleManager.getString(1711670324)).show();
  }
  
  public void showPark()
  {
    if (!BNavigator.getInstance().getCanParkShow()) {}
    final SearchParkPoi localSearchParkPoi;
    do
    {
      return;
      localSearchParkPoi = getNearestParkPoi();
    } while (localSearchParkPoi == null);
    if (localSearchParkPoi.mLeftCnt > 0) {}
    for (String str = String.format("%1$d个空车位，距离终点%2$d米", new Object[] { Integer.valueOf(localSearchParkPoi.mLeftCnt), Integer.valueOf(localSearchParkPoi.mDistance) });; str = String.format("停车场距终点%1$d米", new Object[] { Integer.valueOf(localSearchParkPoi.mDistance) }))
    {
      RGViewController.getInstance().closeToolbox();
      RGViewController.getInstance().hideRouteSearchView();
      RGViewController.getInstance().hideRouteSortView();
      RGViewController.getInstance().hideMenuMoreView();
      RGViewController.getInstance().onUgcDestroy();
      RGViewController.getInstance().newOperableNotification(102).setPriority(100).setAutoHideTime(20000).setNotificationIcon(BNStyleManager.getDrawable(1711407991)).setMainTitleText(str).setConfirmText(BNStyleManager.getString(1711670326)).setCancelText(BNStyleManager.getString(1711670327)).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
      {
        public void onAutoHideWithoutClick()
        {
          BNavigator.getInstance().setmCanParkShow(false);
          RGViewController.getInstance().hideParkPointView();
          RGParkPointModel.getInstance().setmIsParkPointShow(false);
          BNMapController.getInstance().showLayer(4, false);
        }
        
        public void onCancelBtnClick()
        {
          BNavigator.getInstance().setmCanParkShow(false);
          RGViewController.getInstance().hideParkPointView();
          RGParkPointModel.getInstance().setmIsParkPointShow(false);
          BNMapController.getInstance().showLayer(4, false);
        }
        
        public void onConfirmBtnClick()
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410298", "410298");
          BNavigator.getInstance().setmCanParkShow(false);
          BNRoutePlaner.getInstance().setGuideSceneType(4);
          if (localSearchParkPoi != null)
          {
            GeoPoint localGeoPoint = localSearchParkPoi.mGuidePoint;
            RGSimpleGuideModel.getInstance();
            RGSimpleGuideModel.mCalcRouteType = 4;
            RGEngineControl.getInstance().setEndPtToCalcRoute(localGeoPoint);
          }
        }
      }).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
      {
        public void onHideWithAnim()
        {
          LogUtil.e("XDVoice", "showPark onHideWithAnim, xdEnable(true)");
          TTSPlayerControl.stopVoiceTTSOutput();
          XDVoiceInstructManager.getInstance().setWakeupEnable(true);
          XDVoiceInstructManager.getInstance().resetLastInstrut();
          XDVoiceInstructManager.getInstance().onStop();
          if (BNavigator.getInstance().getContext() != null) {
            AudioUtils.releaseAudioFocus(BNavigator.getInstance().getContext());
          }
        }
        
        public void onHideWithOutAnim()
        {
          LogUtil.e("XDVoice", "showPark onHideWithOutAnim");
        }
        
        public void onShowWithAnim()
        {
          LogUtil.e("XDVoice", "showPark onShowWithAnim");
          if (BNavigator.getInstance().getContext() != null) {
            AudioUtils.requestAudioFocus(BNavigator.getInstance().getContext());
          }
          XDVoiceInstructManager.getInstance().onStart();
        }
        
        public void onShowWithOutAnim()
        {
          LogUtil.e("XDVoice", "showPark onShowWithOutAnim");
        }
      }).show();
      return;
    }
  }
  
  public void showPickPoint()
  {
    LogUtil.e(TAG, "showPickPoint");
    SearchPoi localSearchPoi = RGPickPointModel.getInstance().getAntiSearchPoi();
    RGViewController.getInstance().newOperableNotification(106).setPriority(100).setAutoHideTime(-1).setSubTitleText(localSearchPoi.mAddress).setConfirmText(BNStyleManager.getString(1711670370)).setCancelText(BNStyleManager.getString(1711670304)).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
    {
      public void onAutoHideWithoutClick()
      {
        RGPickPointModel.getInstance().setPickPointShow(false);
      }
      
      public void onCancelBtnClick()
      {
        RGPickPointModel.getInstance().setPickPointShow(false);
      }
      
      public void onConfirmBtnClick()
      {
        RGNotificationController.this.comfirmPickPoint();
      }
    }).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
    {
      public void onHideWithAnim()
      {
        RGPickPointModel.getInstance().setPickPointShow(false);
        BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
        RGViewController.getInstance().moveContrilBottomButton(false);
      }
      
      public void onHideWithOutAnim()
      {
        RGPickPointModel.getInstance().setPickPointShow(false);
        BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
        RGViewController.getInstance().moveContrilBottomButton(false);
      }
      
      public void onShowWithAnim()
      {
        RGViewController.getInstance().moveContrilBottomButton(true);
      }
      
      public void onShowWithOutAnim()
      {
        RGViewController.getInstance().moveContrilBottomButton(true);
      }
    }).setNotificationIcon(BNStyleManager.getDrawable(1711408001)).setMainTitleText(localSearchPoi.mName).show();
  }
  
  public void showPickPointWithType()
  {
    RGMMOperableNotificationView localRGMMOperableNotificationView = getRepeatedOperableView(106);
    if (localRGMMOperableNotificationView != null)
    {
      SearchPoi localSearchPoi = RGPickPointModel.getInstance().getAntiSearchPoi();
      localRGMMOperableNotificationView.setSubTitleText(localSearchPoi.mAddress).setMainTitleText(localSearchPoi.mName);
      return;
    }
    showPickPoint();
  }
  
  public void showQuietMode()
  {
    LogUtil.e(TAG, "showQuietMode");
    if (RGControlPanelModel.getInstance().ismIsConfigChange()) {}
    while (!this.mIsClickQuietBtn) {
      return;
    }
    this.mIsClickQuietBtn = false;
    if (BNSettingManager.getVoiceMode() == 2)
    {
      RGViewController.getInstance().newCommonNotification(104).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407993)).setMainTitleText(BNStyleManager.getString(1711670315)).setSubTitleText(BNStyleManager.getString(1711670317)).show();
      return;
    }
    RGViewController.getInstance().newCommonNotification(105).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407992)).setMainTitleText(BNStyleManager.getString(1711670318)).show();
  }
  
  public void showRPPrefer()
  {
    if (!RGSimpleGuideModel.mIsRPPrefer) {}
    String str;
    do
    {
      return;
      str = getRPPreferTipsText();
    } while (TextUtils.isEmpty(str));
    RGViewController.getInstance().newCommonNotification(106).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407998)).setMainTitleText(str).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
    {
      public void onHideWithAnim()
      {
        RGSimpleGuideModel.mIsRPPrefer = false;
      }
      
      public void onHideWithOutAnim()
      {
        RGSimpleGuideModel.mIsRPPrefer = false;
      }
      
      public void onShowWithAnim() {}
      
      public void onShowWithOutAnim() {}
    }).show();
  }
  
  public void showRouteRecommend()
  {
    LogUtil.e(TAG, "showRouteRecommend");
    if (!RGRouteRecommendModel.getInstance().isViewCanShow) {}
    RGMMOperableNotificationView localRGMMOperableNotificationView;
    do
    {
      return;
      RGViewController.getInstance().closeToolbox();
      RGViewController.getInstance().hideRouteSearchView();
      RGViewController.getInstance().hideRouteSortView();
      RGViewController.getInstance().hideMenuMoreView();
      RGViewController.getInstance().onUgcDestroy();
      localRGMMOperableNotificationView = RGRouteRecommendModel.getInstance().getNotificationView();
    } while (localRGMMOperableNotificationView == null);
    localRGMMOperableNotificationView.show();
  }
  
  public void showSwitchRouteFail()
  {
    RGViewController.getInstance().newCommonNotification(107).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407988)).setMainTitleText(BNStyleManager.getString(1711670264)).show();
  }
  
  public void showSwitchRouteSuccess()
  {
    RGViewController.getInstance().newCommonNotification(108).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407998)).setMainTitleText(BNStyleManager.getString(1711670263)).show();
  }
  
  public void showUgcOfficialEvent()
  {
    LogUtil.e(TAG, "showUgcOfficialEvent");
    if (!RGSimpleGuideModel.mIsUgcOfficialEvent) {
      return;
    }
    String str = JNIGuidanceControl.getInstance().GetRoadEventText();
    if (TextUtils.isEmpty(str))
    {
      LogUtil.e(TAG, "title is null or empty");
      return;
    }
    RGViewController.getInstance().newCommonNotification(109).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(1711408000)).setMainTitleText(str).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
    {
      public void onHideWithAnim()
      {
        RGSimpleGuideModel.mIsUgcOfficialEvent = false;
      }
      
      public void onHideWithOutAnim()
      {
        RGSimpleGuideModel.mIsUgcOfficialEvent = false;
      }
      
      public void onShowWithAnim() {}
      
      public void onShowWithOutAnim() {}
    }).show();
  }
  
  public void showUgcReportSuccess(String paramString)
  {
    RGViewController.getInstance().newCommonNotification(110).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(1711407998)).setMainTitleText(BNStyleManager.getString(1711670321)).setSubTitleText(paramString).show();
  }
  
  public void showUpdateRCFail()
  {
    if (!RGUpdateRCFailModel.getInstance().isRCUpdateFialCanShow()) {
      return;
    }
    RGViewController.getInstance().newCommonNotification(111).setPriority(200).setNotificationIcon(BNStyleManager.getDrawable(1711407996)).setMainTitleText(BNStyleManager.getString(1711669392)).setDisplayListener(new RGMMNotificationBaseView.NotificationDisplayListener()
    {
      public void onHideWithAnim()
      {
        RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
      }
      
      public void onHideWithOutAnim()
      {
        RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
      }
      
      public void onShowWithAnim() {}
      
      public void onShowWithOutAnim() {}
    }).show();
  }
  
  public void showWaitRPResult(int paramInt)
  {
    LogUtil.e(TAG, "showWaitRPResult");
    RGViewController.getInstance().newOperableNotification(101).setPriority(100).setAutoHideTime(-1).setNotificationIcon(BNStyleManager.getDrawable(1711407988)).setMainTitleText(BNStyleManager.getString(1711670333)).setSubTitleText(BNStyleManager.getString(1711670334)).setConfirmText(BNStyleManager.getString(1711670335)).setCancelText(BNStyleManager.getString(1711670336)).setOnClick(new RGMMOperableNotificationView.NotificationClickListener()
    {
      public void onAutoHideWithoutClick() {}
      
      public void onCancelBtnClick()
      {
        BNavigator.getInstance().jumpWhenRoutePlanFail();
      }
      
      public void onConfirmBtnClick()
      {
        RGSimpleGuideModel.getInstance().isCalcRouteFail = false;
        RGViewController.getInstance().showRGSimpleGuideSuitableView();
        RGEngineControl.getInstance().reCalcRouteWhenFail();
      }
    }).show();
  }
  
  public void uninit()
  {
    if ((this.mCommonModelList == null) || (this.mCommonViewList == null) || (this.mOperableModelList == null) || (this.mOperableViewList == null)) {
      return;
    }
    Iterator localIterator;
    Object localObject;
    if (!this.mCommonModelList.isEmpty())
    {
      localIterator = this.mCommonModelList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (RGCommonNotificationModel)localIterator.next();
        if (localObject != null) {
          ((RGCommonNotificationModel)localObject).reset();
        }
        localIterator.remove();
      }
    }
    if (!this.mOperableModelList.isEmpty())
    {
      localIterator = this.mOperableModelList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (RGOperableNotificationModel)localIterator.next();
        if (localObject != null) {
          ((RGOperableNotificationModel)localObject).reset();
        }
        localIterator.remove();
      }
    }
    this.mIsClickQuietBtn = false;
  }
  
  public void updateOperableViewCountingByHandler(RGMMOperableNotificationView paramRGMMOperableNotificationView)
  {
    if (paramRGMMOperableNotificationView != null) {
      paramRGMMOperableNotificationView.updateCancelTextCounting();
    }
  }
  
  public void updatePickPoint() {}
  
  public void updateVoiceNotificationStatus(final int paramInt)
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("updateVoiceNotificationStatus-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        Object localObject2;
        Object localObject1;
        int i;
        if ((RGNotificationController.this.mOperableModelList != null) && (RGNotificationController.this.mOperableModelList.size() > 0))
        {
          localObject2 = RGNotificationController.this.mOperableModelList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (RGOperableNotificationModel)((Iterator)localObject2).next();
            if ((((RGOperableNotificationModel)localObject1).mNotificationType == 103) || (((RGOperableNotificationModel)localObject1).mNotificationType == 102)) {
              if ((((RGOperableNotificationModel)localObject1).mView != null) && (((RGOperableNotificationModel)localObject1).mView.isVisibility())) {
                switch (paramInt)
                {
                case 3: 
                default: 
                  i = 1711407997;
                }
              }
            }
          }
        }
        for (;;)
        {
          ((RGOperableNotificationModel)localObject1).mView.setNotificationBackground(BNStyleManager.getDrawable(1711408006));
          ((RGOperableNotificationModel)localObject1).mView.setNotificationIcon(BNStyleManager.getDrawable(i));
          ((RGOperableNotificationModel)localObject1).mView.getNotificationIcon().setTag(Integer.valueOf(i));
          localObject1 = ((RGOperableNotificationModel)localObject1).mView.getIconDrawable();
          if ((localObject1 instanceof AnimationDrawable)) {
            ((AnimationDrawable)localObject1).start();
          }
          do
          {
            return null;
            localObject2 = ((RGOperableNotificationModel)localObject1).mView.getNotificationIcon().getTag();
          } while ((localObject2 != null) && (((Integer)localObject2).intValue() == 1711408004));
          i = 1711408002;
          continue;
          i = 1711408003;
          continue;
          i = 1711408005;
          continue;
          i = 1711408004;
        }
      }
    }, new BNWorkerConfig(2, 0));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/control/RGNotificationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */