package com.baidu.baidunavis.ui;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.BNRouteGuideDialogManager;
import com.baidu.baidunavis.control.NavAoiRender;
import com.baidu.baidunavis.control.NavComponentController;
import com.baidu.baidunavis.control.NavDayNightController;
import com.baidu.baidunavis.control.NavDayNightController.OnDayNightChangedListener;
import com.baidu.baidunavis.control.NavItemizedOverlayUtil;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.voice.m;
import com.baidu.carlife.view.dialog.f;
import com.baidu.navi.adapter.NaviRouteSearchAdapter;
import com.baidu.navi.adapter.NaviSettingDialogAdapter;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNObserver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.datastruct.SensorData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator.OnNaviBeginListener;
import com.baidu.navisdk.ui.routeguide.IBNavigatorListener;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController.VolumeChangeListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationShowFocusListener;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SystemAuth.IOnRequestAuthrityListener;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.List;

public class BNRouteGuideFragment
  extends CarNaviMapPage
{
  protected static final long WATCH_EXIT_TIME = 1500L;
  protected static boolean isStopedByWatch = false;
  protected static long sWatchEixtTime = 0L;
  private Object mArg = null;
  private IBNavigatorListener mBNavigatorListener = new IBNavigatorListener()
  {
    public void notifyGPSStatusData(int paramAnonymousInt) {}
    
    public void notifyLoacteData(LocData paramAnonymousLocData) {}
    
    public void notifyNmeaData(String paramAnonymousString) {}
    
    public void notifyOtherAction(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
    {
      LogUtil.e("RoutePlan", "notifyOtherAction arg0: " + paramAnonymousInt1 + " arg1: " + paramAnonymousInt2 + " arg3: ");
      if (105 == paramAnonymousInt1) {
        BNRouteGuideFragment.this.showNaviSettingDialog();
      }
      while (106 != paramAnonymousInt1) {
        return;
      }
      StatisticManager.onEvent("NAVI_0021");
      BNRouteGuideFragment.this.showNaviRouteSearchDialog();
    }
    
    public void notifySensorData(SensorData paramAnonymousSensorData) {}
    
    public void notifyStartNav()
    {
      NavRouteGuideController.getInstance().dismissWaitProgressDialog();
      LogUtil.e("RoutePlan", "notifyStartNav");
      BNRouteGuideFragment.this.delayInitModule();
      NavAoiRender.INSTANCE.renderAoiByStartBid();
      com.baidu.carlife.core.k.a(505, 3000);
      com.baidu.carlife.j.a.a().a(true);
    }
    
    public void notifyViewModeChanged(int paramAnonymousInt) {}
    
    public void onPageJump(int paramAnonymousInt, Object paramAnonymousObject)
    {
      if ((1 == paramAnonymousInt) || (2 == paramAnonymousInt))
      {
        if (BNRouteGuideFragment.this.mJumpTiming == -1)
        {
          com.baidu.carlife.j.a.a().a(false);
          com.baidu.carlife.logic.k.a().a(2, 0);
          com.baidu.carlife.core.k.b(506);
          long l = System.currentTimeMillis() - BNRouteGuideFragment.this.mNaviStartTime;
          StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "NAVI_0017", "导航使用时长", (int)l);
          if (!NavTrajectoryController.hasConnected) {
            StatisticManager.onEventDuration(com.baidu.carlife.core.a.a(), "NAVI_0031", "导航使用时长", (int)l);
          }
          if (l >= 18000000L) {
            StatisticManager.onEvent("NAVI_0018", "NAVI_0018");
          }
        }
        if (BNRouteGuideFragment.this.isCarlifeFragment(BNRouteGuideFragment.this.getCurrentFragmentType()))
        {
          BNRouteGuideFragment.access$102(BNRouteGuideFragment.this, paramAnonymousInt);
          BNRouteGuideFragment.access$302(BNRouteGuideFragment.this, paramAnonymousObject);
          NavRouteGuideController.getInstance().setBNavigatorListener(null);
        }
      }
      while (7 == paramAnonymousInt) {
        return;
      }
      Object localObject1;
      Object localObject2;
      int i;
      if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Bundle)))
      {
        localObject1 = (Bundle)paramAnonymousObject;
        localObject2 = NavRoutePlanModel.getInstance().getEndRouteNode();
        if (localObject2 != null)
        {
          if (!((Bundle)localObject1).getBoolean("is_wanda", false)) {
            break label402;
          }
          i = 1;
          ((RouteNode)localObject2).mBusinessPoi = i;
          NavRoutePlanModel.getInstance().setEndRouteNode((RouteNode)localObject2);
        }
      }
      if ((1 == paramAnonymousInt) || (2 == paramAnonymousInt))
      {
        localObject2 = RGHighwayModel.getInstance().getCurRoadName();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() != 0) {}
        }
        else
        {
          localObject1 = "未知点";
        }
        if (NavTrajectoryController.getInstance().endRecord((String)localObject1, true, 1) != 0) {
          break label407;
        }
        i = 1;
        label263:
        if (i == 0) {
          break label412;
        }
        NavLogUtils.e("RouteGuideActivityWrapper", "end record ok 2.");
        BusinessActivityManager.getInstance().uploadData(null, 1501);
      }
      for (;;)
      {
        BaiduNaviManager.getInstance().mLastestQuitNaviTime = System.currentTimeMillis();
        BNavigator.getInstance().setOnNaviBeginListener(null);
        BNavigator.getInstance().setRequestAuthrityListener(null);
        BNRouteGuideFragment.this.exit();
        if (-1 == BNRouteGuideFragment.this.mJumpTiming) {
          NavRouteGuideController.getInstance().onPageJump(paramAnonymousInt, paramAnonymousObject);
        }
        if (BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
          BNLightNaviSwitchManager.getInstance().unInit();
        }
        NavTrajectoryController.getInstance().setEndNaviByOpenApi(false);
        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
          BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3040).sendToTarget();
        }
        NavCommonFuncModel.sIsAnologNavi = false;
        BNRouteGuideFragment.access$102(BNRouteGuideFragment.this, -1);
        BNRouteGuideFragment.access$302(BNRouteGuideFragment.this, null);
        return;
        label402:
        i = 0;
        break;
        label407:
        i = 0;
        break label263;
        label412:
        NavLogUtils.e("RouteGuideActivityWrapper", "failed to end record 2.");
      }
    }
    
    public void onYawingRequestStart()
    {
      m.a().b();
    }
    
    public void onYawingRequestSuccess()
    {
      NavAoiRender.INSTANCE.renderAoiByStartBid();
    }
  };
  private View mBridgeView;
  private BNRouteGuideDialogManager mDialogManager;
  private long mExitTime = 0L;
  private g mFocusAreaLeft;
  private g mFocusAreaUp;
  private final Handler mHandler = new Handler();
  private boolean mIsNaviBegin = false;
  private int mJumpTiming = -1;
  private View mMAView;
  private View mMapControllView;
  private NaviRouteSearchAdapter mNaviRouteSearchAdapter = null;
  private f mNaviRouteSearchDialog = null;
  private f mNaviSettingDialog = null;
  private NaviSettingDialogAdapter mNaviSettingDialogAdapter = null;
  private long mNaviStartTime;
  private boolean mNotificationShow;
  private RGMMOperableNotificationView.NotificationShowFocusListener mNotificationShowFocusListener = new RGMMOperableNotificationView.NotificationShowFocusListener()
  {
    public void hide()
    {
      BNRouteGuideFragment.access$002(BNRouteGuideFragment.this, false);
      BNRouteGuideFragment.this.onInitFocus();
    }
    
    public void show()
    {
      BNRouteGuideFragment.access$002(BNRouteGuideFragment.this, true);
      BNRouteGuideFragment.this.onInitFocus();
    }
  };
  private NavDayNightController.OnDayNightChangedListener mOnDayNightChangedListener = new NavDayNightController.OnDayNightChangedListener()
  {
    public void onDayNightChanged(boolean paramAnonymousBoolean)
    {
      BNMapController localBNMapController = BNMapController.getInstance();
      if (!paramAnonymousBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localBNMapController.setNightMode(bool);
        BNavigator.getInstance().onUpdateStyle(paramAnonymousBoolean);
        return;
      }
    }
  };
  private BNavigator.OnNaviBeginListener mOnNaviBeginListener = new BNavigator.OnNaviBeginListener()
  {
    public void onArriveDest() {}
    
    public void onNaviBegin(String paramAnonymousString)
    {
      BaiduNaviManager.getInstance().notifyNaviBeginChanged(paramAnonymousString);
      if ("0".equals(paramAnonymousString)) {}
    }
    
    public void onRoadInfoUpdate(String paramAnonymousString)
    {
      NavMapAdapter.getInstance().setUgcInfo(paramAnonymousString);
    }
  };
  private View.OnKeyListener mPickPointOnKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0)) {
        switch (paramAnonymousInt)
        {
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
              return false;
            } while ((BNRouteGuideFragment.this.mContentView == null) || (BNRouteGuideFragment.this.mViewCancel == null));
            paramAnonymousView = BNRouteGuideFragment.this.mContentView.findFocus();
          } while ((paramAnonymousView == null) || (!paramAnonymousView.equals(BNRouteGuideFragment.this.mViewCancel)));
          BNRouteGuideFragment.this.handleBkgClick(RGRouteSearchModel.getInstance().getLastBkgItemId() - 1);
          return true;
        } while ((BNRouteGuideFragment.this.mContentView == null) || (BNRouteGuideFragment.this.mViewConfirm == null));
        paramAnonymousView = BNRouteGuideFragment.this.mContentView.findFocus();
      } while ((paramAnonymousView == null) || (!paramAnonymousView.equals(BNRouteGuideFragment.this.mViewConfirm)));
      BNRouteGuideFragment.this.handleBkgClick(RGRouteSearchModel.getInstance().getLastBkgItemId() + 1);
      return true;
    }
  };
  private View mQuitLoading;
  private View mRefresh;
  private View mSetViaView;
  private View mViewCancel;
  private View mViewChange;
  private View mViewClear;
  private View mViewConfirm;
  private View mViewContinue;
  private View mViewContinue2;
  private View mViewExit;
  private View mViewMap;
  private View mViewSetting;
  private RGMapModeViewController.VolumeChangeListener mVolumeChangeListener = new RGMapModeViewController.VolumeChangeListener()
  {
    public int onVolumeDownKeyDown(AudioManager paramAnonymousAudioManager, int paramAnonymousInt)
    {
      return BNRouteGuideFragment.this.adjustVolumeDownKeyDown(paramAnonymousAudioManager, paramAnonymousInt);
    }
    
    public int onVolumeUpKeyDown(AudioManager paramAnonymousAudioManager, int paramAnonymousInt)
    {
      return BNRouteGuideFragment.this.adjustVolumeUpKeyDown(paramAnonymousAudioManager, paramAnonymousInt);
    }
  };
  private View mZoomIn;
  private View mZoomOut;
  private int poiListSize = -1;
  
  private void delayInitModule()
  {
    NavDayNightController.getInstance().registerDayNightListener(this.mOnDayNightChangedListener);
    if (getArguments().containsKey("is_ipo_switch")) {
      return;
    }
    RoutePlanModel localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localRoutePlanModel != null)
    {
      localObject1 = localObject2;
      if (localRoutePlanModel.getStartNode() != null)
      {
        localObject1 = localRoutePlanModel.getStartNode().getName();
        localObject2 = localRoutePlanModel.getStartNode().mGeoPoint;
      }
    }
    if ((localRoutePlanModel == null) || (localObject1 != null))
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      localObject2 = localRoutePlanModel.getStartName(NavMapAdapter.getInstance().getContext(), true);
    }
    NavTrajectoryController.getInstance().startRecord("", (String)localObject2, 2, true, true);
    UserOPController.getInstance().add("8.2.1", "1", null, null);
    NavTrajectoryController.getInstance().startRecordForNaviResult(1);
  }
  
  private void handleBkgClick(int paramInt)
  {
    if ((this.poiListSize != -1) && ((paramInt < 0) || (paramInt >= this.poiListSize))) {}
    label20:
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            break label20;
            break label20;
            do
            {
              return;
            } while (!RGRouteSearchModel.getInstance().isRouteSearchMode());
            if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1)
            {
              BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
              BNMapController.getInstance().updateLayer(4);
              RGRouteSearchModel.getInstance().resetLastBkgItemId();
            }
            localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList();
          } while ((localObject == null) || (((List)localObject).size() <= 0));
          localObject = (SearchPoiPager)((List)localObject).get(0);
        } while (localObject == null);
        localObject = ((SearchPoiPager)localObject).getPoiList();
      } while ((localObject == null) || (paramInt < 0) || (paramInt >= ((List)localObject).size()));
      this.poiListSize = ((List)localObject).size();
      localObject = (SearchPoi)((List)localObject).get(paramInt);
    } while ((((SearchPoi)localObject).mViewPoint == null) || (!((SearchPoi)localObject).mViewPoint.isValid()));
    d.a().f();
    BNMapController.getInstance().focusItem(4, paramInt, true);
    RGPickPointModel.getInstance().updatePickPoint(((SearchPoi)localObject).mViewPoint);
    RGPickPointModel.getInstance().updateAntiSearchPoi((SearchPoi)localObject);
    RGMapModeViewController.getInstance().showControlManualOperatePanel(false);
    RGViewController.getInstance().updatePickPointView();
    RGViewController.getInstance().showPickPointWithType();
    RGPickPointModel.getInstance().setPickPointShow(true);
    RGRouteSearchModel.getInstance().setLastBkgItemId(paramInt);
  }
  
  private void handleCruiseVoiceChanged(boolean paramBoolean1, boolean paramBoolean2)
  {
    BaseTTSPlayer.getInstance().setNaviMuteState(paramBoolean2);
    if (paramBoolean1)
    {
      if (!BaseTTSPlayer.getInstance().isNaviMuteState()) {
        TipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), 2131296691);
      }
    }
    else {
      return;
    }
    TipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), 2131296690);
  }
  
  private void hideSystemVolume(AudioManager paramAudioManager)
  {
    paramAudioManager.adjustStreamVolume(3, 0, 0);
  }
  
  private void onNaviSettingListViewItemClick(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      BNavigator.getInstance().onLocationAction(1);
    }
    for (;;)
    {
      if (this.mNaviSettingDialogAdapter != null) {
        this.mNaviSettingDialogAdapter.updateView(paramInt);
      }
      return;
      if (paramInt == 1)
      {
        BNavigator.getInstance().onLocationAction(2);
      }
      else
      {
        if (paramInt == 2)
        {
          StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
          if (!BNSettingManager.isRoadCondOnOrOff()) {
            StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
          }
          BNavigator localBNavigator = BNavigator.getInstance();
          if (!BNSettingManager.isRoadCondOnOrOff()) {}
          for (;;)
          {
            localBNavigator.onITSAction(bool);
            break;
            bool = false;
          }
        }
        if (paramInt == 3) {
          handleCruiseVoiceChanged(true, true);
        }
      }
    }
  }
  
  private void onRouteSearchListViewItemClick(int paramInt)
  {
    dismissDialog(this.mNaviRouteSearchDialog);
    String str = this.mNaviRouteSearchAdapter.getSearchKey(paramInt);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      routeSearchKeywordMTJ(str);
      RGRouteSearchModel.getInstance().setmLastKey(str);
    } while (!BNavigator.getInstance().routeSearchKeywords(str, new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1005)
        {
          e.a().c();
          BNavigator.getInstance().handleRouteSearch(paramAnonymousMessage);
          BNRouteGuideFragment.access$802(BNRouteGuideFragment.this, -1);
          if (NavMapAdapter.getInstance().isFocusUIEnable()) {
            BNRouteGuideFragment.this.handleBkgClick(0);
          }
        }
      }
    }));
    e.a().b(getResources().getString(2131296861));
  }
  
  private void routeSearchKeywordMTJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      String str = "";
      if ("加油站".equals(paramString)) {
        str = "NAVI_0022";
      }
      while (str.length() > 0)
      {
        StatisticManager.onEvent(str);
        return;
        if ("停车场".equals(paramString)) {
          str = "NAVI_0023";
        } else if ("厕所".equals(paramString)) {
          str = "NAVI_0024";
        } else if ("餐饮".equals(paramString)) {
          str = "NAVI_0025";
        } else if ("酒店".equals(paramString)) {
          str = "NAVI_0026";
        } else if ("银行".equals(paramString)) {
          str = "NAVI_0027";
        }
      }
    }
  }
  
  private void showNaviRouteSearchDialog()
  {
    if (this.mNaviRouteSearchAdapter == null) {
      this.mNaviRouteSearchAdapter = new NaviRouteSearchAdapter(com.baidu.carlife.core.a.a());
    }
    if (this.mNaviRouteSearchDialog == null)
    {
      this.mNaviRouteSearchDialog = new f(com.baidu.carlife.core.a.a(), this.mNaviRouteSearchAdapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          BNRouteGuideFragment.this.onRouteSearchListViewItemClick(paramAnonymousInt);
        }
      });
      this.mNaviRouteSearchDialog.setDialogShowHideListener(new com.baidu.carlife.view.dialog.k()
      {
        public void onDismiss()
        {
          BottomTabDisplayController.getInstance().panelHide();
        }
        
        public void onShow()
        {
          BottomTabDisplayController.getInstance().panelShow();
        }
      });
      this.mNaviRouteSearchDialog.j();
    }
    for (;;)
    {
      showDialog(this.mNaviRouteSearchDialog, BaseDialog.a.b);
      return;
      dismissDialog(this.mNaviRouteSearchDialog);
    }
  }
  
  private void showNaviSettingDialog()
  {
    if (this.mNaviSettingDialogAdapter == null) {
      this.mNaviSettingDialogAdapter = new NaviSettingDialogAdapter(NavCommonFuncModel.getInstance().getActivity());
    }
    if (this.mNaviSettingDialog == null)
    {
      this.mNaviSettingDialog = new f(com.baidu.carlife.core.a.a(), 2131296695, this.mNaviSettingDialogAdapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          BNRouteGuideFragment.this.onNaviSettingListViewItemClick(paramAnonymousInt);
        }
      });
      this.mNaviSettingDialog.setDialogShowHideListener(new com.baidu.carlife.view.dialog.k()
      {
        public void onDismiss()
        {
          BottomTabDisplayController.getInstance().panelHide();
        }
        
        public void onShow()
        {
          BottomTabDisplayController.getInstance().panelShow();
        }
      });
      this.mNaviSettingDialog.j();
    }
    for (;;)
    {
      showDialog(this.mNaviSettingDialog, BaseDialog.a.b);
      return;
      dismissDialog(this.mNaviSettingDialog);
    }
  }
  
  public int adjustVolumeDownKeyDown(AudioManager paramAudioManager, int paramInt)
  {
    hideSystemVolume(paramAudioManager);
    paramAudioManager.adjustStreamVolume(3, -1, 8);
    int i = paramAudioManager.getStreamVolume(3);
    RGMapModeViewController.getInstance().showVolume(i, paramInt, BaseTTSPlayer.getInstance().getCurrentVolume(), false);
    NavLogUtils.e("adjustVolume Down", "volume = " + BaseTTSPlayer.getInstance().getCurrentVolume());
    return i;
  }
  
  public int adjustVolumeUpKeyDown(AudioManager paramAudioManager, int paramInt)
  {
    hideSystemVolume(paramAudioManager);
    paramAudioManager.getStreamVolume(3);
    NavLogUtils.e("adjustVolume Up", "volume = " + BaseTTSPlayer.getInstance().getCurrentVolume());
    paramAudioManager.adjustStreamVolume(3, 1, 8);
    int i = paramAudioManager.getStreamVolume(3);
    int j = BaseTTSPlayer.getInstance().getCurrentVolume();
    if (j > 8) {
      UserOPController.getInstance().add("3.k", null, null, j + "");
    }
    RGMapModeViewController.getInstance().showVolume(i, paramInt, BaseTTSPlayer.getInstance().getCurrentVolume(), true);
    return i;
  }
  
  public void exit()
  {
    NavLogUtils.e("BNRouteGuideFragment", "exit (187):  --> ");
    BNRoutePlaner.getInstance().setObserver(null);
    Bundle localBundle = new Bundle();
    if (!NavCommonFuncModel.sIsAnologNavi) {
      localBundle.putBoolean("back_from_nav", true);
    }
    backTo(17, null);
  }
  
  public boolean forbidsConfigurationChange()
  {
    return false;
  }
  
  public String getPageClsName()
  {
    return BNRouteGuideFragment.class.getName();
  }
  
  public int getPageType()
  {
    return 1;
  }
  
  public boolean is3DGestureEnable()
  {
    return true;
  }
  
  public boolean isMapPage()
  {
    return true;
  }
  
  public boolean onBackPressed()
  {
    if (RGViewController.getInstance().ismIsFellowTipsShow())
    {
      RGViewController.getInstance().hideFellowTips();
      return true;
    }
    if ((!RGViewController.getInstance().isMenuVisible()) && (RGViewController.getInstance().getFellowStatus()))
    {
      if (System.currentTimeMillis() - this.mExitTime > 2000L)
      {
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711670237));
        this.mExitTime = System.currentTimeMillis();
        return true;
      }
      RGViewController.getInstance().closeFellow();
      return true;
    }
    e.a().c();
    if ((RGRouteSearchModel.getInstance().isRouteSearchMode()) && (NavMapAdapter.getInstance().isFocusUIEnable()))
    {
      RGViewController.getInstance().onEmptyPoiAction();
      onInitFocusAreas();
      return true;
    }
    BNavigator.getInstance().onBackPressed();
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    BNavigator.getInstance().onConfigurationChanged(paramConfiguration, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (PerformStatItem.sUserTest)
    {
      PerformStatItem.sPoiToNaviTime11 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("11", "导航界面生命周期开始v2", "NaviSDK", PerformStatItem.sPoiToNaviTime10, PerformStatItem.sPoiToNaviTime11);
      PerformStatItem.sRoutePageToNaviTime5 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("5", "页面周期开始函数", "NaviSDK", PerformStatItem.sRoutePageToNaviTime4, PerformStatItem.sRoutePageToNaviTime5);
    }
  }
  
  public View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    boolean bool2 = false;
    BaseTTSPlayer.getInstance().setEnableTimeOut(true);
    BaseTTSPlayer.getInstance().setTTSVocoderParam();
    paramLayoutInflater = new StringBuilder().append("updateAccountInfoWhenLoginSuccess()  updateUserInfo, bduss=").append(NavMapAdapter.getInstance().getBduss()).append(", uid=").append(NavMapAdapter.getInstance().getUid()).append(", islogin=");
    int i;
    if (NavMapAdapter.getInstance().isLogin())
    {
      i = 1;
      NavLogUtils.e("BNRouteGuideActivityWrapper", i);
    }
    try
    {
      paramLayoutInflater = JNITrajectoryControl.sInstance;
      localObject = NavMapAdapter.getInstance().getBduss();
      String str = NavMapAdapter.getInstance().getUid();
      if (!NavMapAdapter.getInstance().isLogin()) {
        break label313;
      }
      i = 1;
      label116:
      paramLayoutInflater.updateUserInfo((String)localObject, str, i);
    }
    catch (Throwable paramLayoutInflater)
    {
      Object localObject;
      boolean bool1;
      for (;;) {}
    }
    localObject = this.mShowBundle;
    if ((localObject != null) && (((Bundle)localObject).containsKey("locate_mode")))
    {
      i = ((Bundle)localObject).getInt("locate_mode", 2);
      if (i != 2) {
        break label318;
      }
    }
    label313:
    label318:
    for (bool1 = true;; bool1 = false)
    {
      NavCommonFuncModel.sIsAnologNavi = bool1;
      if ((com.baidu.carlife.l.a.a().N()) && (i == 1) && (com.baidu.carlife.i.a.a().b()) && (com.baidu.carlife.i.a.a().d()) && (com.baidu.carlife.i.a.a().c()))
      {
        ((Bundle)localObject).putInt("locate_mode", 5);
        NavRouteGuideController.getInstance().setLocateMode(5);
      }
      NavRouteGuideController.getInstance().setNavUserBehaviourCallback();
      paramLayoutInflater = (LayoutInflater)localObject;
      if (localObject == null) {
        paramLayoutInflater = new Bundle();
      }
      paramLayoutInflater.putInt("routeguide_view_mode", 1);
      this.mDialogManager = new BNRouteGuideDialogManager(NavMapAdapter.getInstance().getContext(), this);
      RGViewController.getInstance().setRouteGuideDialogManagerInterface(this.mDialogManager.getRouteGuideDialogManagerInterface());
      paramLayoutInflater = BNavigator.getInstance().init(mActivity, paramLayoutInflater, null);
      if (paramLayoutInflater != null) {
        break label323;
      }
      super.goBack();
      return null;
      i = 0;
      break;
      i = 0;
      break label116;
    }
    label323:
    RGNotificationController.getInstance().setNotificationShowFocusListener(this.mNotificationShowFocusListener);
    if (!com.baidu.carlife.l.a.a().N()) {
      TrackCarDataSolveModel.setCarlifeStatisticsInfo(null);
    }
    BNLightNaviManager.getInstance().setSwitching(false);
    localObject = new RoutePlanObserver(new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BNavigator.getInstance().quitNav(false);
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    BNRoutePlaner.getInstance().setObserver((BNObserver)localObject);
    BNavigator.getInstance().setListener(this.mBNavigatorListener);
    BNavigator.getInstance().setOnNaviBeginListener(this.mOnNaviBeginListener);
    localObject = new Bundle();
    ((Bundle)localObject).putString("clbduss", NavMapAdapter.getInstance().getBduss());
    bool1 = bool2;
    if (BNSettingManager.getVoicePersonality() == 0) {
      bool1 = true;
    }
    ((Bundle)localObject).putBoolean("bNormol", bool1);
    NavMapAdapter.getInstance().setIsSelectPlate();
    BNavigator.getInstance().startNav((Bundle)localObject);
    this.mIsNaviBegin = true;
    BNavigator.getInstance().setRequestAuthrityListener(new SystemAuth.IOnRequestAuthrityListener()
    {
      @SuppressLint({"NewApi"})
      public boolean onRequestAuthrity(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return false;
      }
    });
    BNRoutePlaner.getInstance().EnableRoadCondition(true);
    BNRoutePlaner.getInstance().setComeFrom(4);
    this.mOnDayNightChangedListener.onDayNightChanged(NavDayNightController.getInstance().isDay());
    RGMapModeViewController.getInstance().setVolumeChangeListener(this.mVolumeChangeListener);
    com.baidu.carlife.logic.k.a().a(2, 1);
    StatisticManager.onEvent("NAVI_0002", "NAVI_0002");
    this.mNaviStartTime = System.currentTimeMillis();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    NavItemizedOverlayUtil.getInstance().unInitWrapper();
    BaseTTSPlayer.getInstance().setEnableTimeOut(false);
    NavDayNightController.getInstance().unregisterDayNightListener(this.mOnDayNightChangedListener);
    BNavigator.getInstance().setOnNaviBeginListener(null);
    BaiduNaviManager.getInstance().notifyNaviBeginChanged("0");
    BNavigator.getInstance().setListener(null);
    BNavigator.getInstance().setRequestAuthrityListener(null);
    NavRouteGuideController.getInstance().UnSetNavUserBehaviourCallback();
    BNavigator.destory();
    NavAoiRender.INSTANCE.clear();
    NavMapAdapter.getInstance().restoreMapData();
    NavComponentController.getInstance().addColladaUserOP();
    BottomTabDisplayController.getInstance().onNaviRGFragmentInvisiable();
    BNRouteGuider.getInstance().setRotateMode(0);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    i.b("BNRouteGuideFragment");
    if (paramBoolean)
    {
      dismissDialog(this.mNaviSettingDialog);
      dismissDialog(this.mNaviRouteSearchDialog);
      BottomTabDisplayController.getInstance().onNaviRGFragmentInvisiable();
      return;
    }
    BottomTabDisplayController.getInstance().onNaviRGFragmentVisiable();
  }
  
  public void onInitFocus()
  {
    if (this.mContentView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.mSetViaView = this.mContentView.findViewById(1711866568);
          this.mZoomIn = this.mContentView.findViewById(1711866592);
          this.mZoomOut = this.mContentView.findViewById(1711866594);
          this.mMAView = this.mContentView.findViewById(1711866573);
          this.mBridgeView = this.mContentView.findViewById(1711866577);
          this.mRefresh = this.mContentView.findViewById(1711866581);
          this.mViewExit = this.mContentView.findViewById(1711866661);
          this.mViewContinue = this.mContentView.findViewById(1711866669);
          this.mViewSetting = this.mContentView.findViewById(1711866671);
          this.mViewContinue2 = this.mContentView.findViewById(1711866676);
          this.mViewChange = this.mContentView.findViewById(1711866678);
          this.mViewClear = this.mContentView.findViewById(1711866679);
          this.mViewMap = this.mContentView.findViewById(1711866615);
          this.mMapControllView = this.mContentView.findViewById(1711866585);
          this.mViewCancel = this.mContentView.findViewById(1711866900);
          this.mViewConfirm = this.mContentView.findViewById(1711866903);
          this.mQuitLoading = this.mContentView.findViewById(1711866947);
          if ((!RGRouteSearchModel.getInstance().isRouteSearchMode()) || (!NavMapAdapter.getInstance().isFocusUIEnable())) {
            break;
          }
        } while ((this.mViewCancel == null) || (this.mViewConfirm == null));
        this.mFocusAreaLeft = new g(this.mContentView, 4);
        this.mFocusAreaLeft.d(this.mViewCancel).d(this.mViewConfirm);
        this.mFocusAreaLeft.a(this.mPickPointOnKeyListener);
        this.mFocusAreaLeft.b(this.mViewConfirm);
        d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaLeft });
        d.a().h(this.mFocusAreaLeft);
        return;
        if (!this.mNotificationShow) {
          break;
        }
      } while ((this.mViewCancel == null) || (this.mViewConfirm == null));
      this.mFocusAreaLeft = new g(this.mContentView, 4);
      this.mFocusAreaLeft.d(this.mViewCancel).d(this.mViewConfirm);
      this.mFocusAreaLeft.a(this.mPickPointOnKeyListener);
      this.mFocusAreaLeft.b(this.mViewConfirm);
      d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaLeft });
      d.a().h(this.mFocusAreaLeft);
      return;
    } while ((this.mRefresh == null) || (this.mZoomIn == null) || (this.mZoomOut == null) || (this.mSetViaView == null) || (this.mMAView == null) || (this.mBridgeView == null) || (this.mViewExit == null) || (this.mViewContinue == null) || (this.mViewContinue2 == null) || (this.mViewChange == null) || (this.mViewClear == null) || (this.mViewSetting == null) || (this.mViewMap == null) || (this.mMapControllView == null) || (this.mQuitLoading == null));
    this.mFocusAreaUp = new g(this.mContentView, 2, true);
    this.mFocusAreaUp.d(this.mSetViaView).d(this.mZoomIn).d(this.mZoomOut).d(this.mViewMap).d(this.mViewSetting).d(this.mQuitLoading).d(this.mViewClear).d(this.mViewChange).d(this.mViewContinue2).d(this.mViewContinue).d(this.mViewExit).d(this.mMapControllView).d(this.mRefresh).d(this.mBridgeView).d(this.mMAView);
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaUp });
    d.a().h(this.mFocusAreaUp);
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    if (!isDialogShown()) {
      onInitFocus();
    }
  }
  
  protected void onInitView()
  {
    if ((this.mJumpTiming != -1) && (this.mBNavigatorListener != null)) {
      this.mBNavigatorListener.onPageJump(this.mJumpTiming, this.mArg);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    BNavigator.getInstance().pause();
  }
  
  public void onResume()
  {
    super.onResume();
    LogUtil.e("", "resume:  zzt  ");
    BNavigator.getInstance().resume();
    if (PerformStatItem.sUserTest)
    {
      PerformStatItem.sPoiToNaviTime12 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("12", "导航界面生命周期显示v2", "NaviSDK", PerformStatItem.sPoiToNaviTime11, PerformStatItem.sPoiToNaviTime12);
      PerformStatItem.sRoutePageToNaviTime6 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("6", "页面周期显示函数", "NaviSDK", PerformStatItem.sRoutePageToNaviTime5, PerformStatItem.sRoutePageToNaviTime6);
    }
    if ((NavCommonFuncModel.sNaviTimeType == 1) && (NaviStatItem.getInstance() != null))
    {
      NaviStatItem.getInstance().intimeType = 1;
      NaviStatItem.getInstance().intime = (System.currentTimeMillis() - NavCommonFuncModel.sRoutePageToNaviTime1);
      NavCommonFuncModel.sNaviTimeType = -1;
      if ((this.mJumpTiming != -1) && (this.mBNavigatorListener != null)) {
        this.mBNavigatorListener.onPageJump(this.mJumpTiming, this.mArg);
      }
      if (!com.baidu.carlife.l.a.a().N()) {
        break label247;
      }
      BaseTTSPlayer.getInstance().setCarLifeConnected(true);
    }
    for (;;)
    {
      i.b("BNRouteGuideFragment");
      BottomTabDisplayController.getInstance().onNaviRGFragmentVisiable();
      return;
      if ((NavCommonFuncModel.sNaviTimeType == 2) && (NaviStatItem.getInstance() != null))
      {
        NaviStatItem.getInstance().intimeType = 2;
        NaviStatItem.getInstance().intime = (System.currentTimeMillis() - NavCommonFuncModel.sPoiToNaviTime1);
        NavCommonFuncModel.sNaviTimeType = -1;
        break;
      }
      if (NaviStatItem.getInstance() == null) {
        break;
      }
      NaviStatItem.getInstance().intimeType = -1;
      NaviStatItem.getInstance().intime = -1L;
      NavCommonFuncModel.sNaviTimeType = -1;
      break;
      label247:
      BaseTTSPlayer.getInstance().setCarLifeConnected(false);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.mIsNaviBegin) {
      BNavigator.getInstance().start();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mIsNaviBegin) {
      BNavigator.getInstance().stop();
    }
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if (paramInt1 == 2) {}
    switch (paramInt2)
    {
    default: 
      return false;
    case 2: 
      BNMapController.getInstance().zoomOut();
      replyVoiceCommand(paramInt1, 1, paramBoolean);
      return true;
    case 3: 
      BNMapController.getInstance().zoomIn();
      replyVoiceCommand(paramInt1, 1, paramBoolean);
      return true;
    case 29: 
    case 53: 
      BNavigator.getInstance().onLocationAction(2);
      updateSettingDialog();
      return true;
    case 30: 
      BNavigator.getInstance().onLocationAction(1);
      updateSettingDialog();
      return true;
    case 8: 
      VoiceCommandHelper.onITSChanged(false);
      updateSettingDialog();
      return true;
    }
    VoiceCommandHelper.onITSChanged(true);
    updateSettingDialog();
    return true;
  }
  
  public void updateSettingDialog()
  {
    if (this.mNaviSettingDialogAdapter != null) {
      this.mNaviSettingDialogAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/BNRouteGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */