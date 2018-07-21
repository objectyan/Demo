package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.logic.commandparser.CmdDebugModeGetURL;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageBean;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageSerBean;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.ui.widget.BNDebugModelDialog;
import com.baidu.navisdk.ui.widget.StatusButton;
import com.baidu.navisdk.ui.widget.StatusButton.StatusButtonChild;
import com.baidu.navisdk.ui.widget.StatusButton.onStatusButtonClickListener;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.List;

public class RGMMMenuView
  extends BNBaseView
{
  private static final long K_INTERNEL_CLICK = 1000L;
  private static final long K_MAX_CLICK = 7L;
  private final int CAR_3D_ARR_ID = 1;
  private final int INNER_INDEX_AVOID = 0;
  private final int INNER_INDEX_HIGHWAY = 1;
  private final int INNER_INDEX_NO_CHARGE = 3;
  private final int INNER_INDEX_NO_HIGHWAY = 2;
  private final int NORTH_2D_ARR_ID = 0;
  private final int PREFER_ITEM_CNT = 4;
  private final int VOICE_DETAIL_INDEX = 0;
  private final int VOICE_QUIET_INDEX = 2;
  private final int VOICE_SIMPLE_INDEX = 1;
  private ArrayAdapter<String> adapter;
  private int[] hDivider = { 1711866002, 1711866006, 1711866010, 1711866014, 1711866018, 1711866022, 1711866030, 1711866048, 1711866064, 1711866026, 1711866037, 1711866041, 1711866742, 1711866767, 1711866770, 1711866771, 1711866772, 1711866773, 1711866068, 1711866774, 1711866775, 1711866776, 1711866777, 1711866740, 1711866732, 1711866779, 1711866782 };
  private View mBankView = null;
  private View mBrowserRouteItemView = null;
  private TextView mBuildTimeTv = null;
  private View mBuildView = null;
  private View mCar3DView = null;
  private int[] mCatalogTextViewId = { 1711866719, 1711866716, 1711866712, 1711866699, 1711866728, 1711866746 };
  private int mClickNum;
  private View mCloseView = null;
  private TextView mCuidTv = null;
  private View mCuidView = null;
  private ExpandableListView mELUrlDebugView;
  private View mFactoryCategory = null;
  private View mGasStationView = null;
  private List<DebugModeMessageBean> mGuideMsg;
  private TextView mHUDModeTV = null;
  private View mHUDModeView = null;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((1405 == paramAnonymousMessage.what) && (paramAnonymousMessage.arg1 == 0) && (NavSDKDebug.sSDKFactoryMode))
      {
        RGMMMenuView.access$6202(RGMMMenuView.this, CmdDebugModeGetURL.mGuideMsg);
        if ((RGMMMenuView.this.mGuideMsg != null) && (RGMMMenuView.this.mGuideMsg.size() > 0))
        {
          RGMMMenuView.DebugUrlAdapter localDebugUrlAdapter = new RGMMMenuView.DebugUrlAdapter(RGMMMenuView.this);
          RGMMMenuView.this.mELUrlDebugView.setAdapter(localDebugUrlAdapter);
          RGMMMenuView.this.mRLUrlDebugExpandView.setVisibility(0);
        }
      }
      super.handleMessage(paramAnonymousMessage);
    }
  };
  private StatusButton mJavaLogBtn = null;
  private View mJavaLogView = null;
  private long mLastClickTime;
  private int[] mMap2DOr3DStatusImageId = { 1711866717, 1711866714 };
  private View mMenuBottomPanel = null;
  private View mMenuContentPanel = null;
  private View mMenuMoreView = null;
  private View mMenuScroll = null;
  private View mMenuTransTop = null;
  private View mMenuView = null;
  private ViewGroup mMenuViewContainer = null;
  private View mMenuViewPanel = null;
  private StatusButton mMonkeyBtn = null;
  private View mMonkeyView = null;
  private ImageView mMoreMenuRedGuide = null;
  private StatusButton mNativeLogBtn = null;
  private View mNativeLogView = null;
  private View mNorth2DView = null;
  private View.OnClickListener mOnClickListener = null;
  private View mOtherRouteView = null;
  private TextView[] mPreferTVs = new TextView[4];
  private View[] mPreferViews = new View[4];
  private RelativeLayout mRLGPSDebugView;
  private RelativeLayout mRLUrlDebugExpandView;
  private RelativeLayout mRLUrlDebugView;
  private StatusButton mRealRoadConditionBtn = null;
  private View mResetRouteView = null;
  private View mRouteCategory = null;
  private View mRouteSearchCategory = null;
  private int[] mRouteSearchDrawableId = { 1711407785, 1711407783, 1711407797, 1711407793 };
  private View mRouteSearchHeadArrowView = null;
  private View mRouteSearchHeadView = null;
  private int[] mRouteSearchImageId = { 1711866751, 1711866754, 1711866757, 1711866760 };
  private ViewGroup mRouteSearchInnerPanel = null;
  private int[] mRouteSearchTVId = { 1711866752, 1711866755, 1711866758, 1711866761 };
  private View mRouteSearchView = null;
  private StatusButton mSBGPSDebugView;
  private View mSpotView = null;
  private StatusButton.onStatusButtonClickListener mStatusButtonClickListener = null;
  private TextView mTVGPSDebugView;
  private TextView mTVUrlDebugColseView;
  private TextView mTVUrlDebugView;
  private int[] mTextViewId = { 1711866723, 1711866763, 1711866765, 1711866769, 1711866001, 1711866004, 1711866008, 1711866024, 1711866012, 1711866781, 1711866692, 1711866047 };
  private View mToiletView = null;
  private int[] mViewCategory = { 1711866711, 1711866698, 1711866727 };
  private TextView mVoiceDetailTV = null;
  private View mVoiceDetailView = null;
  private View mVoiceItemHeadArrowView = null;
  private View mVoiceItemView = null;
  private TextView mVoiceQuietTV = null;
  private View mVoiceQuietView = null;
  private ImageView mVoiceRedGuide = null;
  private TextView mVoiceSimpleTV = null;
  private View mVoiceSimpleView = null;
  private TextView mVoiceTV = null;
  private TextView mdebugOpen = null;
  private int[] mdivideViewId = { 1711866722, 1711866741, 1711866710 };
  
  public RGMMMenuView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    updateDataByLastest();
    initListener();
  }
  
  private boolean checkClick()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if (l - this.mLastClickTime < 1000L) {}
    for (this.mClickNum += 1;; this.mClickNum = 0)
    {
      this.mLastClickTime = l;
      if (this.mClickNum > 3L) {
        TipTool.onCreateToastDialog(this.mContext, "连击:" + this.mClickNum);
      }
      if (this.mClickNum >= 7L)
      {
        this.mClickNum = 0;
        bool = true;
      }
      return bool;
    }
  }
  
  private void initListener()
  {
    initOnClickListener();
    initStatusButtonClickListener();
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
    for (;;)
    {
      if (this.mMenuScroll != null) {
        this.mMenuScroll.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            switch (paramAnonymousMotionEvent.getAction() & 0xFF)
            {
            }
            for (;;)
            {
              return false;
              LogUtil.e("RGMMMenuView", "onTouch ACTION_UP");
              continue;
              LogUtil.e("RGMMMenuView", "onTouch ACTION_DOWN");
              continue;
              LogUtil.e("RGMMMenuView", "onTouch ACTION_MOVE");
            }
          }
        });
      }
      if (this.mBrowserRouteItemView != null) {
        this.mBrowserRouteItemView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mCloseView != null) {
        this.mCloseView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mMenuMoreView != null) {
        this.mMenuMoreView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mMenuTransTop != null) {
        this.mMenuTransTop.setOnClickListener(this.mOnClickListener);
      }
      if (this.mResetRouteView != null) {
        this.mResetRouteView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mOtherRouteView != null) {
        this.mOtherRouteView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mRealRoadConditionBtn != null) {
        this.mRealRoadConditionBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
      }
      if (this.mJavaLogBtn != null) {
        this.mJavaLogBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
      }
      if (this.mNativeLogBtn != null) {
        this.mNativeLogBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
      }
      if (this.mMonkeyBtn != null) {
        this.mMonkeyBtn.setAllBtnClickListener(this.mStatusButtonClickListener);
      }
      if (this.mSBGPSDebugView != null) {
        this.mSBGPSDebugView.setAllBtnClickListener(this.mStatusButtonClickListener);
      }
      if (this.mGasStationView != null) {
        this.mGasStationView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mBankView != null) {
        this.mBankView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mToiletView != null) {
        this.mToiletView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mSpotView != null) {
        this.mSpotView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mRouteSearchHeadView != null) {
        this.mRouteSearchHeadView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mNorth2DView != null) {
        this.mNorth2DView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mCar3DView != null) {
        this.mCar3DView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mHUDModeView != null) {
        this.mHUDModeView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mVoiceItemView != null) {
        this.mVoiceItemView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mVoiceDetailView != null) {
        this.mVoiceDetailView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mVoiceSimpleView != null) {
        this.mVoiceSimpleView.setOnClickListener(this.mOnClickListener);
      }
      if (this.mVoiceQuietView != null) {
        this.mVoiceQuietView.setOnClickListener(this.mOnClickListener);
      }
      int i = 0;
      while (i < 4)
      {
        if (this.mPreferViews[i] != null) {
          this.mPreferViews[i].setOnClickListener(this.mOnClickListener);
        }
        i += 1;
      }
      if (this.mMenuViewContainer != null) {
        this.mMenuViewContainer.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
      }
    }
  }
  
  private void initOnClickListener()
  {
    this.mOnClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        boolean bool3 = true;
        boolean bool4 = true;
        boolean bool1 = true;
        if (((RGMMMenuView.this.mCloseView != null) && (RGMMMenuView.this.mCloseView == paramAnonymousView)) || ((RGMMMenuView.this.mMenuTransTop != null) && (RGMMMenuView.this.mMenuTransTop == paramAnonymousView))) {
          if (RGMMMenuView.this.mSubViewListener != null) {
            RGMMMenuView.this.mSubViewListener.onMoreMenuAction();
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
                            if ((RGMMMenuView.this.mBrowserRouteItemView == null) || (RGMMMenuView.this.mBrowserRouteItemView != paramAnonymousView)) {
                              break;
                            }
                            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410280", "410280");
                          } while ((RouteGuideFSM.getInstance().getTopState() != null) && (RouteGuideFSM.getInstance().getTopState().equals("RouteItem")));
                          RouteGuideFSM.getInstance().run("更多菜单[分段浏览]点击");
                          return;
                          if ((RGMMMenuView.this.mResetRouteView != null) && (RGMMMenuView.this.mResetRouteView == paramAnonymousView))
                          {
                            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410282", "410282");
                            RouteGuideFSM.getInstance().run("更多菜单[路线规划]点击");
                            return;
                          }
                          if ((RGMMMenuView.this.mOtherRouteView == null) || (RGMMMenuView.this.mOtherRouteView != paramAnonymousView)) {
                            break;
                          }
                        } while (RGMMMenuView.this.mSubViewListener == null);
                        RGMMMenuView.this.mSubViewListener.onOtherAction(5, 1, 0, null);
                        return;
                        if ((RGMMMenuView.this.mGasStationView == null) || (RGMMMenuView.this.mGasStationView != paramAnonymousView)) {
                          break;
                        }
                        com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsRouteSearchVisible = false;
                        RGMMMenuView.this.hide();
                        com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsMenuVisible = false;
                      } while ((RGMMMenuView.this.mSubViewListener == null) || (RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)));
                      RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, "加油站");
                      return;
                      if ((RGMMMenuView.this.mBankView == null) || (RGMMMenuView.this.mBankView != paramAnonymousView)) {
                        break;
                      }
                      com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsRouteSearchVisible = false;
                      RGMMMenuView.this.hide();
                      com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsMenuVisible = false;
                    } while ((RGMMMenuView.this.mSubViewListener == null) || (RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)));
                    RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, "银行");
                    return;
                    if ((RGMMMenuView.this.mToiletView == null) || (RGMMMenuView.this.mToiletView != paramAnonymousView)) {
                      break;
                    }
                    com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsRouteSearchVisible = false;
                    RGMMMenuView.this.hide();
                    com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsMenuVisible = false;
                  } while ((RGMMMenuView.this.mSubViewListener == null) || (RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)));
                  RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, "厕所");
                  return;
                  if ((RGMMMenuView.this.mSpotView == null) || (RGMMMenuView.this.mSpotView != paramAnonymousView)) {
                    break;
                  }
                  com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsRouteSearchVisible = false;
                  RGMMMenuView.this.hide();
                  com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsMenuVisible = false;
                } while ((RGMMMenuView.this.mSubViewListener == null) || (RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)));
                RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, "景点");
                return;
                if ((RGMMMenuView.this.mRouteSearchHeadView == null) || (RGMMMenuView.this.mRouteSearchHeadView != paramAnonymousView)) {
                  break;
                }
                RGMMMenuView.this.hide();
                com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsMenuVisible = false;
              } while (RGMMMenuView.this.mSubViewListener == null);
              RGMMMenuView.this.mSubViewListener.onMoreRouteSearchAction();
              return;
              if ((RGMMMenuView.this.mNorth2DView != null) && (RGMMMenuView.this.mNorth2DView == paramAnonymousView))
              {
                UserOPController.getInstance().add("3.5.1", null, "", "2");
                RouteGuideFSM.getInstance().cacheBackMapState("North2D");
                RGMMMenuView.this.updateMapStatusView();
                BNavigator.getInstance().enterNavState();
                BNSettingManager.setMapMode(2);
                return;
              }
              if ((RGMMMenuView.this.mCar3DView != null) && (RGMMMenuView.this.mCar3DView == paramAnonymousView))
              {
                UserOPController.getInstance().add("3.5.1", "", null, "2");
                RouteGuideFSM.getInstance().cacheBackMapState("Car3D");
                RGMMMenuView.this.updateMapStatusView();
                BNavigator.getInstance().enterNavState();
                BNSettingManager.setMapMode(1);
                return;
              }
              if ((RGMMMenuView.this.mHUDModeView != null) && (RGMMMenuView.this.mHUDModeView == paramAnonymousView))
              {
                UserOPController.getInstance().add("3.5.4");
                RouteGuideFSM.getInstance().run("[HUD]按钮点击");
                return;
              }
              if ((RGMMMenuView.this.mVoiceItemView == null) || (RGMMMenuView.this.mVoiceItemView != paramAnonymousView)) {
                break;
              }
              BNSettingManager.setFirstVoiceGuide(true);
              if (RGMMMenuView.this.mVoiceRedGuide != null) {
                RGMMMenuView.this.mVoiceRedGuide.setVisibility(8);
              }
              UserOPController.getInstance().add("3.5.6");
              RGMMMenuView.this.hide();
            } while (RGMMMenuView.this.mSubViewListener == null);
            RGMMMenuView.this.mSubViewListener.onOtherAction(5, 3, 0, null);
            return;
            if ((RGMMMenuView.this.mMenuMoreView == null) || (RGMMMenuView.this.mMenuMoreView != paramAnonymousView)) {
              break;
            }
            UserOPController.getInstance().add("3.5.e");
          } while (RGMMMenuView.this.mSubViewListener == null);
          RGMMMenuView.this.mSubViewListener.onMenuMoreAction();
          return;
          if ((RGMMMenuView.this.mVoiceDetailView != null) && (RGMMMenuView.this.mVoiceDetailView == paramAnonymousView))
          {
            BNSettingManager.resetVoiceModeParams(0);
            RGMMMenuView.this.setVoiceSpeakSetting(0, 0);
            BNSettingManager.setLastVoiceMode(0);
            RGMMMenuView.this.updateVoiceModeView(0);
            return;
          }
          if ((RGMMMenuView.this.mVoiceSimpleView != null) && (RGMMMenuView.this.mVoiceSimpleView == paramAnonymousView))
          {
            BNSettingManager.resetVoiceModeParams(1);
            RGMMMenuView.this.setVoiceSpeakSetting(0, 1);
            BNSettingManager.setLastVoiceMode(1);
            RGMMMenuView.this.updateVoiceModeView(1);
            return;
          }
          if ((RGMMMenuView.this.mVoiceQuietView != null) && (RGMMMenuView.this.mVoiceQuietView == paramAnonymousView))
          {
            BNSettingManager.resetVoiceModeParams(2);
            RGMMMenuView.this.setVoiceSpeakSetting(0, 2);
            RGMMMenuView.this.updateVoiceModeView(2);
            return;
          }
          if ((RGMMMenuView.this.mPreferViews[0] != null) && (RGMMMenuView.this.mPreferViews[0] == paramAnonymousView))
          {
            paramAnonymousView = RGCarPreferSettingController.getInstance();
            if (!RGCarPreferSettingController.getInstance().isOpenPrefer(16)) {}
            for (;;)
            {
              paramAnonymousView.updatePreferValue(16, bool1);
              RGMMMenuView.this.updatePreferView();
              return;
              bool1 = false;
            }
          }
          if ((RGMMMenuView.this.mPreferViews[1] != null) && (RGMMMenuView.this.mPreferViews[1] == paramAnonymousView))
          {
            paramAnonymousView = RGCarPreferSettingController.getInstance();
            if (!RGCarPreferSettingController.getInstance().isOpenPrefer(2)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymousView.updatePreferValue(2, bool1);
              RGCarPreferSettingController.getInstance().updatePreferValue(4, false);
              RGCarPreferSettingController.getInstance().updatePreferValue(8, false);
              RGMMMenuView.this.updatePreferView();
              return;
            }
          }
          if ((RGMMMenuView.this.mPreferViews[2] != null) && (RGMMMenuView.this.mPreferViews[2] == paramAnonymousView))
          {
            paramAnonymousView = RGCarPreferSettingController.getInstance();
            if (!RGCarPreferSettingController.getInstance().isOpenPrefer(4)) {}
            for (bool1 = bool3;; bool1 = false)
            {
              paramAnonymousView.updatePreferValue(4, bool1);
              RGCarPreferSettingController.getInstance().updatePreferValue(2, false);
              RGMMMenuView.this.updatePreferView();
              return;
            }
          }
        } while ((RGMMMenuView.this.mPreferViews[3] == null) || (RGMMMenuView.this.mPreferViews[3] != paramAnonymousView));
        paramAnonymousView = RGCarPreferSettingController.getInstance();
        if (!RGCarPreferSettingController.getInstance().isOpenPrefer(8)) {}
        for (bool1 = bool4;; bool1 = false)
        {
          paramAnonymousView.updatePreferValue(8, bool1);
          RGCarPreferSettingController.getInstance().updatePreferValue(2, false);
          RGMMMenuView.this.updatePreferView();
          return;
        }
      }
    };
  }
  
  private void initPreferSettings()
  {
    initPreferView();
  }
  
  private void initPreferView()
  {
    if ((this.mPreferViews[0] == null) || (this.mPreferTVs[0] == null) || (this.mPreferViews[2] == null) || (this.mPreferTVs[2] == null)) {
      return;
    }
    int i = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
    if ((i == 2) || (i == 0))
    {
      this.mPreferViews[0].setBackgroundDrawable(BNStyleManager.getDrawable(1711407814));
      this.mPreferTVs[0].setTextColor(Color.parseColor("#999999"));
      this.mPreferViews[0].setClickable(false);
    }
    for (;;)
    {
      updatePreferView();
      return;
      this.mPreferViews[0].setClickable(true);
    }
  }
  
  private void initRoutePrefer()
  {
    initPreferSettings();
  }
  
  private void initStatusButtonClickListener()
  {
    this.mStatusButtonClickListener = new StatusButton.onStatusButtonClickListener()
    {
      public void onClick(StatusButton paramAnonymousStatusButton, StatusButton.StatusButtonChild paramAnonymousStatusButtonChild)
      {
        if ((paramAnonymousStatusButton == RGMMMenuView.this.mRealRoadConditionBtn) && (RGMMMenuView.this.mRealRoadConditionBtn != null)) {
          if (RGMMMenuView.this.mSubViewListener != null) {}
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
                switch (RGMMMenuView.10.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
                {
                default: 
                  return;
                case 1: 
                  UserOPController.getInstance().add("3.5.2", "", null, null);
                  if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
                  {
                    RGMMMenuView.this.mSubViewListener.onITSAction(true);
                    return;
                  }
                  RGMMMenuView.this.mRealRoadConditionBtn.setRightBtnChecked();
                  TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(1711669387));
                  return;
                }
                UserOPController.getInstance().add("3.5.2", null, "", null);
                RGMMMenuView.this.mSubViewListener.onITSAction(false);
                return;
                if ((paramAnonymousStatusButton != RGMMMenuView.this.mJavaLogBtn) || (RGMMMenuView.this.mJavaLogBtn == null)) {
                  break;
                }
              } while (RGMMMenuView.this.mSubViewListener == null);
              switch (RGMMMenuView.10.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
              {
              default: 
                return;
              case 1: 
                BNSettingManager.setShowJavaLog(true);
                return;
              }
              BNSettingManager.setShowJavaLog(false);
              return;
              if ((paramAnonymousStatusButton != RGMMMenuView.this.mNativeLogBtn) || (RGMMMenuView.this.mNativeLogBtn == null)) {
                break;
              }
            } while (RGMMMenuView.this.mSubViewListener == null);
            switch (RGMMMenuView.10.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
            {
            default: 
              return;
            case 1: 
              BNSettingManager.setShowNativeLog(true);
              return;
            }
            BNSettingManager.setShowNativeLog(false);
            return;
            if ((paramAnonymousStatusButton != RGMMMenuView.this.mMonkeyBtn) || (RGMMMenuView.this.mMonkeyBtn == null)) {
              break;
            }
          } while (RGMMMenuView.this.mSubViewListener == null);
          switch (RGMMMenuView.10.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
          {
          default: 
            return;
          case 1: 
            BNSettingManager.setMonkey(true);
            return;
          }
          BNSettingManager.setMonkey(false);
          return;
        } while ((paramAnonymousStatusButton != RGMMMenuView.this.mSBGPSDebugView) || (RGMMMenuView.this.mSBGPSDebugView == null) || (RGMMMenuView.this.mSubViewListener == null));
        switch (RGMMMenuView.10.$SwitchMap$com$baidu$navisdk$ui$widget$StatusButton$StatusButtonChild[paramAnonymousStatusButtonChild.ordinal()])
        {
        default: 
          return;
        case 1: 
          BNSettingManager.setGPSDebug(true);
          return;
        }
        BNSettingManager.setGPSDebug(false);
      }
    };
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    label1815:
    for (;;)
    {
      return;
      this.mMenuViewPanel = this.mRootViewGroup.findViewById(1711866532);
      this.mMenuViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866533));
      if (this.mMenuViewContainer != null)
      {
        this.mMenuViewContainer.removeAllViews();
        if (1 == RGViewController.getInstance().getOrientation()) {
          this.mCurOrientation = 1;
        }
        for (this.mMenuView = JarUtils.inflate((Activity)this.mContext, 1711472727, null);; this.mMenuView = JarUtils.inflate((Activity)this.mContext, 1711472728, null))
        {
          if ((this.mMenuViewContainer == null) || (this.mMenuView == null)) {
            break label1815;
          }
          Object localObject = new FrameLayout.LayoutParams(-1, -1);
          this.mMenuViewContainer.addView(this.mMenuView, (ViewGroup.LayoutParams)localObject);
          this.mMenuTransTop = this.mRootViewGroup.findViewById(1711866558);
          this.mMenuContentPanel = this.mRootViewGroup.findViewById(1711866696);
          this.mMenuBottomPanel = this.mRootViewGroup.findViewById(1711866778);
          this.mMenuScroll = this.mRootViewGroup.findViewById(1711865996);
          this.mPreferViews[0] = this.mRootViewGroup.findViewById(1711866701);
          this.mPreferViews[1] = this.mRootViewGroup.findViewById(1711866703);
          this.mPreferViews[2] = this.mRootViewGroup.findViewById(1711866705);
          this.mPreferViews[3] = this.mRootViewGroup.findViewById(1711866707);
          this.mPreferTVs[0] = ((TextView)this.mRootViewGroup.findViewById(1711866702));
          this.mPreferTVs[1] = ((TextView)this.mRootViewGroup.findViewById(1711866704));
          this.mPreferTVs[2] = ((TextView)this.mRootViewGroup.findViewById(1711866706));
          this.mPreferTVs[3] = ((TextView)this.mRootViewGroup.findViewById(1711866708));
          this.mRealRoadConditionBtn = ((StatusButton)this.mRootViewGroup.findViewById(1711866724));
          this.mBrowserRouteItemView = this.mRootViewGroup.findViewById(1711866762);
          this.mResetRouteView = this.mRootViewGroup.findViewById(1711866764);
          if (this.mResetRouteView != null) {
            this.mResetRouteView.setVisibility(8);
          }
          this.mRouteSearchView = this.mRootViewGroup.findViewById(1711866743);
          this.mRouteSearchHeadView = this.mRootViewGroup.findViewById(1711866744);
          this.mRouteSearchHeadArrowView = this.mRootViewGroup.findViewById(1711866748);
          this.mGasStationView = this.mRootViewGroup.findViewById(1711866750);
          this.mBankView = this.mRootViewGroup.findViewById(1711866753);
          this.mToiletView = this.mRootViewGroup.findViewById(1711866756);
          this.mSpotView = this.mRootViewGroup.findViewById(1711866759);
          this.mRouteSearchInnerPanel = ((ViewGroup)this.mRootViewGroup.findViewById(1711866749));
          this.mCloseView = this.mRootViewGroup.findViewById(1711866780);
          this.mMenuMoreView = this.mRootViewGroup.findViewById(1711866783);
          this.mRouteSearchCategory = this.mRootViewGroup.findViewById(1711866745);
          this.mRouteCategory = this.mRootViewGroup.findViewById(1711866741);
          this.mNorth2DView = this.mRootViewGroup.findViewById(1711866717);
          this.mCar3DView = this.mRootViewGroup.findViewById(1711866714);
          this.mVoiceDetailView = this.mRootViewGroup.findViewById(1711866734);
          this.mVoiceSimpleView = this.mRootViewGroup.findViewById(1711866736);
          this.mVoiceQuietView = this.mRootViewGroup.findViewById(1711866738);
          this.mVoiceDetailTV = ((TextView)this.mRootViewGroup.findViewById(1711866735));
          this.mVoiceSimpleTV = ((TextView)this.mRootViewGroup.findViewById(1711866737));
          this.mVoiceQuietTV = ((TextView)this.mRootViewGroup.findViewById(1711866739));
          this.mHUDModeView = this.mRootViewGroup.findViewById(1711866720);
          this.mHUDModeTV = ((TextView)this.mRootViewGroup.findViewById(1711866721));
          this.mVoiceItemView = this.mRootViewGroup.findViewById(1711866726);
          this.mVoiceTV = ((TextView)this.mRootViewGroup.findViewById(1711866730));
          this.mVoiceItemHeadArrowView = this.mRootViewGroup.findViewById(1711866731);
          this.mVoiceRedGuide = ((ImageView)this.mRootViewGroup.findViewById(1711866729));
          this.mMoreMenuRedGuide = ((ImageView)this.mRootViewGroup.findViewById(1711866784));
          if ((this.mVoiceRedGuide != null) && (!BNSettingManager.getFirstVoiceGuide())) {
            this.mVoiceRedGuide.setVisibility(0);
          }
          this.mdebugOpen = ((TextView)this.mRootViewGroup.findViewById(1711866712));
          this.mdebugOpen.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              if (RGMMMenuView.this.checkClick()) {
                new BNDebugModelDialog(RGMMMenuView.this.mContext).show();
              }
            }
          });
          if (NavSDKDebug.sSDKFactoryMode)
          {
            this.mFactoryCategory = this.mRootViewGroup.findViewById(1711866766);
            this.mCuidView = this.mRootViewGroup.findViewById(1711866768);
            this.mBuildView = this.mRootViewGroup.findViewById(1711865999);
            this.mJavaLogView = this.mRootViewGroup.findViewById(1711866003);
            this.mNativeLogView = this.mRootViewGroup.findViewById(1711866007);
            this.mMonkeyView = this.mRootViewGroup.findViewById(1711866011);
            this.mCuidTv = ((TextView)this.mRootViewGroup.findViewById(1711866769));
            this.mBuildTimeTv = ((TextView)this.mRootViewGroup.findViewById(1711866001));
            this.mJavaLogBtn = ((StatusButton)this.mRootViewGroup.findViewById(1711866005));
            this.mNativeLogBtn = ((StatusButton)this.mRootViewGroup.findViewById(1711866009));
            this.mMonkeyBtn = ((StatusButton)this.mRootViewGroup.findViewById(1711866013));
            this.mRLGPSDebugView = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866023));
            this.mTVGPSDebugView = ((TextView)this.mRootViewGroup.findViewById(1711866024));
            this.mSBGPSDebugView = ((StatusButton)this.mRootViewGroup.findViewById(1711866025));
            this.mRLUrlDebugView = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866046));
            this.mTVUrlDebugView = ((TextView)this.mRootViewGroup.findViewById(1711866047));
            this.mRLUrlDebugExpandView = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866074));
            this.mELUrlDebugView = ((ExpandableListView)this.mRootViewGroup.findViewById(1711866076));
            this.mTVUrlDebugColseView = ((TextView)this.mRootViewGroup.findViewById(1711866075));
            if ((this.mRLUrlDebugView != null) && (this.mTVUrlDebugView != null))
            {
              this.mRLUrlDebugView.setVisibility(0);
              this.mTVUrlDebugView.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  CmdDebugModeGetURL.requestDebugModeUrl(RGMMMenuView.this.mHandler);
                }
              });
              this.mTVUrlDebugColseView.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  RGMMMenuView.this.mRLUrlDebugExpandView.setVisibility(8);
                }
              });
            }
            if (this.mFactoryCategory != null) {
              this.mFactoryCategory.setVisibility(0);
            }
            if ((this.mCuidView != null) && (this.mCuidTv != null))
            {
              this.mCuidView.setVisibility(0);
              this.mCuidTv.setText("CUID:" + PackageUtil.getCuid());
            }
            if ((this.mBuildView != null) && (this.mBuildTimeTv != null))
            {
              this.mBuildView.setVisibility(0);
              this.mBuildTimeTv.setText("BuildTime:(" + PackageUtil.getBuildNo() + ")");
            }
            if ((this.mJavaLogView != null) && (this.mJavaLogBtn != null))
            {
              this.mJavaLogView.setVisibility(0);
              this.mJavaLogBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
              this.mJavaLogBtn.setRightButtonText(BNStyleManager.getString(1711669887));
              this.mJavaLogBtn.setMidBtnGone(true);
            }
            if ((this.mNativeLogView != null) && (this.mNativeLogBtn != null))
            {
              this.mNativeLogView.setVisibility(0);
              this.mNativeLogBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
              this.mNativeLogBtn.setRightButtonText(BNStyleManager.getString(1711669887));
              this.mNativeLogBtn.setMidBtnGone(true);
            }
            if ((this.mMonkeyView != null) && (this.mMonkeyBtn != null))
            {
              this.mMonkeyView.setVisibility(0);
              this.mMonkeyBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
              this.mMonkeyBtn.setRightButtonText(BNStyleManager.getString(1711669887));
              this.mMonkeyBtn.setMidBtnGone(true);
            }
            if ((this.mRLGPSDebugView != null) && (this.mSBGPSDebugView != null))
            {
              this.mRLGPSDebugView.setVisibility(0);
              this.mSBGPSDebugView.setLeftButtonText(BNStyleManager.getString(1711669886));
              this.mSBGPSDebugView.setRightButtonText(BNStyleManager.getString(1711669887));
              this.mSBGPSDebugView.setMidBtnGone(true);
            }
            localObject = this.mRootViewGroup.findViewById(1711866777);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866776);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866775);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866774);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866068);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866773);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866772);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866771);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866770);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = this.mRootViewGroup.findViewById(1711866767);
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
          }
          if (this.mRealRoadConditionBtn == null) {
            break;
          }
          this.mRealRoadConditionBtn.setLeftButtonText(BNStyleManager.getString(1711669886));
          this.mRealRoadConditionBtn.setRightButtonText(BNStyleManager.getString(1711669887));
          this.mRealRoadConditionBtn.setMidBtnGone(true);
          return;
          this.mCurOrientation = 2;
        }
      }
    }
  }
  
  private void setVoiceSpeakSetting(int paramInt1, int paramInt2)
  {
    if (this.mSubViewListener != null) {
      this.mSubViewListener.onOtherAction(6, paramInt1, paramInt2, null);
    }
  }
  
  private void updateMapStatusView()
  {
    try
    {
      Object localObject = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
      LinearLayout localLinearLayout;
      TextView localTextView1;
      TextView localTextView2;
      if ((localObject != null) && (this.mRootViewGroup != null))
      {
        if (localObject != "North2D") {
          break label178;
        }
        localObject = (LinearLayout)this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[0]);
        localLinearLayout = (LinearLayout)this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[1]);
        localTextView1 = (TextView)this.mRootViewGroup.findViewById(1711866719);
        localTextView2 = (TextView)this.mRootViewGroup.findViewById(1711866716);
        if ((localObject != null) && (localLinearLayout != null))
        {
          ((LinearLayout)localObject).setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
          localLinearLayout.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
          localTextView1.setTextColor(BNStyleManager.getColor(1711800698));
          if (!BNStyleManager.getDayStyle()) {
            break label164;
          }
          localTextView2.setTextColor(BNStyleManager.getColor(1711800676));
        }
      }
      while (this.mHUDModeView != null)
      {
        this.mHUDModeView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
        return;
        label164:
        localTextView2.setTextColor(BNStyleManager.getColor(1711800674));
        continue;
        label178:
        if (localObject == "Car3D")
        {
          localObject = (LinearLayout)this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[1]);
          localLinearLayout = (LinearLayout)this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[0]);
          localTextView1 = (TextView)this.mRootViewGroup.findViewById(1711866719);
          localTextView2 = (TextView)this.mRootViewGroup.findViewById(1711866716);
          if ((localLinearLayout != null) && (localObject != null))
          {
            localLinearLayout.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
            ((LinearLayout)localObject).setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
            if (BNStyleManager.getDayStyle()) {
              localTextView1.setTextColor(BNStyleManager.getColor(1711800676));
            }
            for (;;)
            {
              localTextView2.setTextColor(BNStyleManager.getColor(1711800698));
              break;
              localTextView1.setTextColor(BNStyleManager.getColor(1711800674));
            }
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void updatePreferView()
  {
    if ((this.mPreferViews.length > 4) || (this.mPreferTVs.length > 4)) {}
    label192:
    label323:
    label356:
    label387:
    for (;;)
    {
      return;
      if ((this.mPreferViews[0] != null) && (this.mPreferTVs[0] != null) && (this.mPreferViews[1] != null) && (this.mPreferTVs[1] != null) && (this.mPreferViews[2] != null) && (this.mPreferTVs[2] != null) && (this.mPreferViews[3] != null) && (this.mPreferTVs[3] != null))
      {
        int i = BNaviModuleManager.getLastPreferValue();
        if (this.mPreferViews[0].isClickable())
        {
          if ((i & 0x10) != 0)
          {
            this.mPreferViews[0].setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
            this.mPreferTVs[0].setTextColor(Color.parseColor("#3385ff"));
          }
        }
        else
        {
          if (this.mPreferViews[1].isClickable())
          {
            if ((i & 0x2) == 0) {
              break label323;
            }
            this.mPreferViews[1].setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
            this.mPreferTVs[1].setTextColor(Color.parseColor("#3385ff"));
          }
          if (this.mPreferViews[2].isClickable())
          {
            if ((i & 0x4) == 0) {
              break label356;
            }
            this.mPreferViews[2].setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
            this.mPreferTVs[2].setTextColor(Color.parseColor("#3385ff"));
          }
        }
        for (;;)
        {
          if (!this.mPreferViews[3].isClickable()) {
            break label387;
          }
          if ((i & 0x8) == 0) {
            break label389;
          }
          this.mPreferViews[3].setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
          this.mPreferTVs[3].setTextColor(Color.parseColor("#3385ff"));
          return;
          this.mPreferViews[0].setBackgroundDrawable(BNStyleManager.getDrawable(1711407813));
          this.mPreferTVs[0].setTextColor(Color.parseColor("#999999"));
          break;
          this.mPreferViews[1].setBackgroundDrawable(BNStyleManager.getDrawable(1711407813));
          this.mPreferTVs[1].setTextColor(Color.parseColor("#999999"));
          break label192;
          this.mPreferViews[2].setBackgroundDrawable(BNStyleManager.getDrawable(1711407813));
          this.mPreferTVs[2].setTextColor(Color.parseColor("#999999"));
        }
      }
    }
    label389:
    this.mPreferViews[3].setBackgroundDrawable(BNStyleManager.getDrawable(1711407813));
    this.mPreferTVs[3].setTextColor(Color.parseColor("#999999"));
  }
  
  private void updateVoiceModeView(int paramInt)
  {
    if ((this.mVoiceDetailView == null) || (this.mVoiceSimpleView == null) || (this.mVoiceQuietView == null) || (this.mVoiceDetailTV == null) || (this.mVoiceSimpleTV == null) || (this.mVoiceQuietTV == null)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
      this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
      this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
      if (BNStyleManager.getDayStyle())
      {
        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(1711800676));
        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(1711800676));
      }
      for (;;)
      {
        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(1711800698));
        return;
        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(1711800674));
        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(1711800674));
      }
    case 1: 
      this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
      this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
      this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
      if (BNStyleManager.getDayStyle())
      {
        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(1711800676));
        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(1711800676));
      }
      for (;;)
      {
        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(1711800698));
        return;
        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(1711800674));
        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(1711800674));
      }
    }
    this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407817));
    this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
    this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407819));
    if (BNStyleManager.getDayStyle())
    {
      this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(1711800676));
      this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(1711800676));
    }
    for (;;)
    {
      this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(1711800698));
      return;
      this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(1711800674));
      this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(1711800674));
    }
  }
  
  private void updateVoiceName()
  {
    Object localObject;
    if (this.mVoiceTV != null)
    {
      localObject = VoiceHelper.getInstance().getCurrentUsedTTSId();
      if (localObject != null) {
        break label35;
      }
      this.mVoiceTV.setText(JarUtils.getResources().getString(1711670105));
    }
    label35:
    do
    {
      return;
      localObject = VoiceHelper.getInstance().getVoiceInfo((String)localObject);
    } while (localObject == null);
    this.mVoiceTV.setText(((VoiceInfo)localObject).name);
  }
  
  public void hide()
  {
    super.hide();
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.setVisibility(8);
    }
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(8);
    }
  }
  
  public void initVoiceModeView()
  {
    int i = BNSettingManager.getVoiceMode();
    if (i == 0) {
      updateVoiceModeView(0);
    }
    do
    {
      return;
      if (i == 1)
      {
        updateVoiceModeView(1);
        return;
      }
    } while (i != 2);
    updateVoiceModeView(2);
  }
  
  public void onOrientationChange() {}
  
  public void refreshRedGuide()
  {
    if (this.mMoreMenuRedGuide != null)
    {
      if ((!BNSettingManager.getFirsCarLogoGuide()) || (!BNSettingManager.getFristBlueToothChannelGuide())) {
        this.mMoreMenuRedGuide.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mMoreMenuRedGuide.setVisibility(8);
    BNSettingManager.setFirstMoreMenuGuide(true);
  }
  
  public void show()
  {
    super.show();
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(0);
    }
    if (this.mMenuViewContainer != null)
    {
      Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_IN, 0L, 300L);
      this.mMenuViewContainer.startAnimation(localAnimation);
      this.mMenuViewContainer.setVisibility(0);
    }
    if ((this.mRouteSearchView != null) && (this.mRootViewGroup != null))
    {
      int i = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
      if ((i != 1) && (i != 3)) {
        break label153;
      }
      this.mRouteSearchView.setVisibility(0);
      this.mRootViewGroup.findViewById(1711866740).setVisibility(0);
      this.mRootViewGroup.findViewById(1711866741).setVisibility(0);
      this.mRootViewGroup.findViewById(1711866742).setVisibility(0);
    }
    for (;;)
    {
      initRoutePrefer();
      updateMapStatusView();
      initVoiceModeView();
      refreshRedGuide();
      updateVoiceName();
      return;
      label153:
      this.mRouteSearchView.setVisibility(8);
      this.mRootViewGroup.findViewById(1711866740).setVisibility(8);
      this.mRootViewGroup.findViewById(1711866741).setVisibility(8);
      this.mRootViewGroup.findViewById(1711866742).setVisibility(8);
    }
  }
  
  public void updateData(Bundle paramBundle) {}
  
  public void updateDataByLastest()
  {
    if (this.mRealRoadConditionBtn != null)
    {
      if (PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_ROADCOND_ON_OFF", false)) {
        this.mRealRoadConditionBtn.setLeftBtnChecked();
      }
    }
    else if (NavSDKDebug.sSDKFactoryMode)
    {
      if (this.mJavaLogBtn != null)
      {
        if (!BNSettingManager.isShowJavaLog()) {
          break label134;
        }
        this.mJavaLogBtn.setLeftBtnChecked();
      }
      label59:
      if (this.mNativeLogBtn != null)
      {
        if (!BNSettingManager.isShowNativeLog()) {
          break label145;
        }
        this.mNativeLogBtn.setLeftBtnChecked();
      }
      label80:
      if (this.mMonkeyBtn != null)
      {
        if (!BNSettingManager.isMonkey()) {
          break label156;
        }
        this.mMonkeyBtn.setLeftBtnChecked();
      }
    }
    for (;;)
    {
      if (this.mSBGPSDebugView != null)
      {
        if (!BNSettingManager.isGPSDebug()) {
          break label167;
        }
        this.mSBGPSDebugView.setLeftBtnChecked();
      }
      return;
      this.mRealRoadConditionBtn.setRightBtnChecked();
      break;
      label134:
      this.mJavaLogBtn.setRightBtnChecked();
      break label59;
      label145:
      this.mNativeLogBtn.setRightBtnChecked();
      break label80;
      label156:
      this.mMonkeyBtn.setRightBtnChecked();
    }
    label167:
    this.mSBGPSDebugView.setRightBtnChecked();
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.mMenuContentPanel != null) {
      this.mMenuContentPanel.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mMenuBottomPanel != null) {
      this.mMenuBottomPanel.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mCloseView != null) {
      this.mCloseView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mRealRoadConditionBtn != null) {
      this.mRealRoadConditionBtn.updateDayStyle();
    }
    if (this.mJavaLogBtn != null) {
      this.mJavaLogBtn.updateDayStyle();
    }
    if (this.mNativeLogBtn != null) {
      this.mNativeLogBtn.updateDayStyle();
    }
    if (this.mMonkeyBtn != null) {
      this.mMonkeyBtn.updateDayStyle();
    }
    if (this.mSBGPSDebugView != null) {
      this.mSBGPSDebugView.updateDayStyle();
    }
    if (this.mBrowserRouteItemView != null) {
      this.mBrowserRouteItemView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mOtherRouteView != null) {
      this.mOtherRouteView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mResetRouteView != null) {
      this.mResetRouteView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    int i = 0;
    Object localObject;
    while ((this.mRootViewGroup != null) && (i < this.hDivider.length))
    {
      localObject = this.mRootViewGroup.findViewById(this.hDivider[i]);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(BNStyleManager.getColor(1711800690));
      }
      i += 1;
    }
    if (this.mRootViewGroup != null)
    {
      if (paramBoolean)
      {
        i = 0;
        while (i < this.mTextViewId.length)
        {
          localObject = (TextView)this.mRootViewGroup.findViewById(this.mTextViewId[i]);
          if (localObject != null) {
            ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800674));
          }
          i += 1;
        }
        i = 0;
        while (i < this.mRouteSearchTVId.length)
        {
          localObject = (TextView)this.mRootViewGroup.findViewById(this.mRouteSearchTVId[i]);
          if (localObject != null) {
            ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800676));
          }
          i += 1;
        }
        i = 0;
        while (i < this.mCatalogTextViewId.length)
        {
          localObject = (TextView)this.mRootViewGroup.findViewById(this.mCatalogTextViewId[i]);
          if (localObject != null) {
            ((TextView)localObject).setTextColor(Color.parseColor("#000000"));
          }
          i += 1;
        }
      }
      i = 0;
      while (i < this.mTextViewId.length)
      {
        localObject = (TextView)this.mRootViewGroup.findViewById(this.mTextViewId[i]);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800675));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mRouteSearchTVId.length)
      {
        localObject = (TextView)this.mRootViewGroup.findViewById(this.mRouteSearchTVId[i]);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800674));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mCatalogTextViewId.length)
      {
        localObject = (TextView)this.mRootViewGroup.findViewById(this.mCatalogTextViewId[i]);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(Color.parseColor("#999999"));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mRouteSearchImageId.length)
      {
        localObject = (ImageView)this.mRootViewGroup.findViewById(this.mRouteSearchImageId[i]);
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(BNStyleManager.getDrawable(this.mRouteSearchDrawableId[i]));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mdivideViewId.length)
      {
        localObject = this.mRootViewGroup.findViewById(this.mdivideViewId[i]);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(BNStyleManager.getColor(1711800692));
        }
        i += 1;
      }
      i = 0;
      while (i < this.mViewCategory.length)
      {
        localObject = this.mRootViewGroup.findViewById(this.mViewCategory[i]);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(BNStyleManager.getColor(1711800694));
        }
        i += 1;
      }
    }
    if (this.mGasStationView != null) {
      this.mGasStationView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mBankView != null) {
      this.mBankView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mToiletView != null) {
      this.mToiletView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mSpotView != null) {
      this.mSpotView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mCar3DView != null) {
      this.mCar3DView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mNorth2DView != null) {
      this.mNorth2DView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mRouteSearchCategory != null) {
      this.mRouteSearchCategory.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mFactoryCategory != null) {
      this.mFactoryCategory.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.mNorth2DView != null) {
      this.mNorth2DView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mCar3DView != null) {
      this.mCar3DView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mHUDModeView != null) {
      this.mHUDModeView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mVoiceItemView != null) {
      this.mVoiceItemView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
    }
    if (this.mVoiceItemHeadArrowView != null)
    {
      if (paramBoolean) {
        this.mVoiceItemHeadArrowView.setAlpha(1.0F);
      }
    }
    else
    {
      if (this.mRouteSearchHeadArrowView != null)
      {
        if (!paramBoolean) {
          break label1085;
        }
        this.mRouteSearchHeadArrowView.setAlpha(1.0F);
      }
      label975:
      if (this.mVoiceDetailView != null) {
        this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
      }
      if (this.mVoiceSimpleView != null) {
        this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
      }
      if (this.mVoiceQuietView != null) {
        this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407444));
      }
      if (this.mHUDModeTV != null)
      {
        if (!paramBoolean) {
          break label1098;
        }
        this.mHUDModeTV.setTextColor(BNStyleManager.getColor(1711800676));
      }
    }
    for (;;)
    {
      updateMapStatusView();
      initVoiceModeView();
      initPreferView();
      return;
      this.mVoiceItemHeadArrowView.setAlpha(0.3F);
      break;
      label1085:
      this.mRouteSearchHeadArrowView.setAlpha(0.3F);
      break label975;
      label1098:
      this.mHUDModeTV.setTextColor(BNStyleManager.getColor(1711800674));
    }
  }
  
  class DebugUrlAdapter
    extends BaseExpandableListAdapter
  {
    DebugUrlAdapter() {}
    
    public Object getChild(int paramInt1, int paramInt2)
    {
      return ((DebugModeMessageBean)RGMMMenuView.this.mGuideMsg.get(paramInt1)).serList.get(paramInt2);
    }
    
    public long getChildId(int paramInt1, int paramInt2)
    {
      return paramInt2;
    }
    
    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      List localList = ((DebugModeMessageBean)RGMMMenuView.this.mGuideMsg.get(paramInt1)).serList;
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = JarUtils.inflate((Activity)RGMMMenuView.this.mContext, 1711472667, null);
      }
      paramView = (TextView)paramViewGroup.findViewById(1711866077);
      paramView.setText(((DebugModeMessageSerBean)localList.get(paramInt2)).key + ":" + ((DebugModeMessageSerBean)localList.get(paramInt2)).value);
      return paramView;
    }
    
    public int getChildrenCount(int paramInt)
    {
      return ((DebugModeMessageBean)RGMMMenuView.this.mGuideMsg.get(paramInt)).serList.size();
    }
    
    public Object getGroup(int paramInt)
    {
      return RGMMMenuView.this.mGuideMsg.get(paramInt);
    }
    
    public int getGroupCount()
    {
      return RGMMMenuView.this.mGuideMsg.size();
    }
    
    public long getGroupId(int paramInt)
    {
      return paramInt;
    }
    
    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = JarUtils.inflate((Activity)RGMMMenuView.this.mContext, 1711472668, null);
      }
      paramView = (TextView)paramViewGroup.findViewById(1711866079);
      paramView.setText(((DebugModeMessageBean)RGMMMenuView.this.mGuideMsg.get(paramInt)).mSceneName);
      return paramView;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
    
    public boolean isChildSelectable(int paramInt1, int paramInt2)
    {
      return true;
    }
  }
  
  class SpinnerSelectedListener
    implements AdapterView.OnItemSelectedListener
  {
    SpinnerSelectedListener() {}
    
    public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
    
    public void onNothingSelected(AdapterView paramAdapterView) {}
  }
  
  class SpinnerURLSelectedListener
    implements AdapterView.OnItemSelectedListener
  {
    SpinnerURLSelectedListener() {}
    
    public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
    
    public void onNothingSelected(AdapterView paramAdapterView) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */