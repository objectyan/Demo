package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.commandparser.CmdDebugModeGetURL;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageBean;
import com.baidu.navisdk.logic.commandparser.DebugModeMessageSerBean;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
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
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.List;

public class RGMMMenuView extends BNBaseView {
    private static final long K_INTERNEL_CLICK = 1000;
    private static final long K_MAX_CLICK = 7;
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
    private int[] hDivider = new int[]{C4048R.id.bnav_rg_menu_h_divider_1, C4048R.id.bnav_rg_menu_h_divider_2, C4048R.id.bnav_rg_menu_h_divider_3, C4048R.id.bnav_rg_menu_h_divider_4, C4048R.id.bnav_rg_menu_h_divider_5, C4048R.id.bnav_rg_menu_h_divider_6, C4048R.id.bnav_rg_menu_h_divider_7, C4048R.id.bnav_rg_menu_h_divider_8, C4048R.id.bnav_rg_menu_h_divider_9, C4048R.id.bnav_rg_menu_h_divider_10, C4048R.id.bnav_rg_menu_h_divider_12, C4048R.id.bnav_rg_menu_h_divider_13, C4048R.id.bnav_rg_menu_h_divider_14, C4048R.id.bnav_rg_menu_h_divider_15, C4048R.id.bnav_rg_menu_h_divider_16, C4048R.id.bnav_rg_menu_h_divider_17, C4048R.id.bnav_rg_menu_h_divider_18, C4048R.id.bnav_rg_menu_h_divider_19, C4048R.id.bnav_rg_menu_h_divider_20, C4048R.id.bnav_rg_menu_h_divider_21, C4048R.id.bnav_rg_menu_h_divider_22, C4048R.id.bnav_rg_menu_h_divider_24, C4048R.id.bnav_rg_menu_h_divider_25, C4048R.id.bnav_rg_menu_h_divider_26, C4048R.id.bnav_rg_menu_h_divider_27, C4048R.id.bnav_rg_menu_h_divider_28, C4048R.id.bnav_rg_menu_h_divider_29};
    private View mBankView = null;
    private View mBrowserRouteItemView = null;
    private TextView mBuildTimeTv = null;
    private View mBuildView = null;
    private View mCar3DView = null;
    private int[] mCatalogTextViewId = new int[]{C4048R.id.bnav_rg_menu_north2d_tv, C4048R.id.bnav_rg_menu_car3d_tv, C4048R.id.bnav_rg_menu_view_tv, C4048R.id.bnav_rg_menu_rp_prefer_view_tv, C4048R.id.bnav_rg_menu_voice_view_tv, C4048R.id.bnav_rg_menu_route_search_title};
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
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (CommandConst.K_MSG_GENERAL_HTTP_DEBUG_MODE_GET_URL_EXEC == msg.what && msg.arg1 == 0 && NavSDKDebug.sSDKFactoryMode) {
                RGMMMenuView.this.mGuideMsg = CmdDebugModeGetURL.mGuideMsg;
                if (RGMMMenuView.this.mGuideMsg != null && RGMMMenuView.this.mGuideMsg.size() > 0) {
                    RGMMMenuView.this.mELUrlDebugView.setAdapter(new DebugUrlAdapter());
                    RGMMMenuView.this.mRLUrlDebugExpandView.setVisibility(0);
                }
            }
            super.handleMessage(msg);
        }
    };
    private StatusButton mJavaLogBtn = null;
    private View mJavaLogView = null;
    private long mLastClickTime;
    private int[] mMap2DOr3DStatusImageId = new int[]{C4048R.id.bnav_rg_menu_view_north2d, C4048R.id.bnav_rg_menu_view_car3d};
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
    private OnClickListener mOnClickListener = null;
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
    private int[] mRouteSearchDrawableId = new int[]{C4048R.drawable.nsdk_drawable_rg_route_search_gas_station, C4048R.drawable.nsdk_drawable_rg_route_search_bank, C4048R.drawable.nsdk_drawable_rg_route_search_toilet, C4048R.drawable.nsdk_drawable_rg_route_search_spots};
    private View mRouteSearchHeadArrowView = null;
    private View mRouteSearchHeadView = null;
    private int[] mRouteSearchImageId = new int[]{C4048R.id.bnav_rg_menu_as_iv_gas_station, C4048R.id.bnav_rg_menu_as_iv_bank, C4048R.id.bnav_rg_menu_as_iv_toilet, C4048R.id.bnav_rs_spots_iv};
    private ViewGroup mRouteSearchInnerPanel = null;
    private int[] mRouteSearchTVId = new int[]{C4048R.id.bnav_rg_menu_as_tv_gas_station, C4048R.id.bnav_rg_menu_as_tv_bank, C4048R.id.bnav_rg_menu_as_tv_toilet, C4048R.id.bnav_rs_spots_tv};
    private View mRouteSearchView = null;
    private StatusButton mSBGPSDebugView;
    private View mSpotView = null;
    private onStatusButtonClickListener mStatusButtonClickListener = null;
    private TextView mTVGPSDebugView;
    private TextView mTVUrlDebugColseView;
    private TextView mTVUrlDebugView;
    private int[] mTextViewId = new int[]{C4048R.id.bnav_rg_menu_real_road_condition_tv, C4048R.id.bnav_rg_menu_browser_route_item_tv, C4048R.id.bnav_rg_menu_reset_route_tv, C4048R.id.bnav_rg_menu_cuid_item_tv, C4048R.id.bnav_rg_menu_build_item_tv, C4048R.id.bnav_rg_menu_java_log_tv, C4048R.id.bnav_rg_menu_native_log_tv, C4048R.id.bnav_rg_menu_gps_debug_tv, C4048R.id.bnav_rg_menu_monkey_tv, C4048R.id.bnav_rg_menu_close_tv, C4048R.id.bnav_rg_menu_more_setting_tv, C4048R.id.bnav_rg_menu_factory_debug_url_tv};
    private View mToiletView = null;
    private int[] mViewCategory = new int[]{C4048R.id.bnav_rg_menu_view_category, C4048R.id.bnav_rg_menu_rp_prefer_view_category, C4048R.id.bnav_rg_menu_voice_view_category};
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
    private int[] mdivideViewId = new int[]{C4048R.id.bnav_rg_menu_set_category, C4048R.id.bnav_rg_menu_route_category, C4048R.id.bnav_rg_menu_prefer_category};

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$1 */
    class C43861 implements OnClickListener {
        C43861() {
        }

        public void onClick(View v) {
            if (RGMMMenuView.this.checkClick()) {
                new BNDebugModelDialog(RGMMMenuView.this.mContext).show();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$2 */
    class C43872 implements OnClickListener {
        C43872() {
        }

        public void onClick(View v) {
            CmdDebugModeGetURL.requestDebugModeUrl(RGMMMenuView.this.mHandler);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$3 */
    class C43883 implements OnClickListener {
        C43883() {
        }

        public void onClick(View v) {
            RGMMMenuView.this.mRLUrlDebugExpandView.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$4 */
    class C43894 implements OnTouchListener {
        C43894() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$5 */
    class C43905 implements OnTouchListener {
        C43905() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$6 */
    class C43916 implements OnTouchListener {
        C43916() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    LogUtil.m15791e("RGMMMenuView", "onTouch ACTION_DOWN");
                    break;
                case 1:
                    LogUtil.m15791e("RGMMMenuView", "onTouch ACTION_UP");
                    break;
                case 2:
                    LogUtil.m15791e("RGMMMenuView", "onTouch ACTION_MOVE");
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$7 */
    class C43927 implements OnClickListener {
        C43927() {
        }

        public void onClick(View view) {
            boolean z = true;
            if ((RGMMMenuView.this.mCloseView == null || RGMMMenuView.this.mCloseView != view) && (RGMMMenuView.this.mMenuTransTop == null || RGMMMenuView.this.mMenuTransTop != view)) {
                if (RGMMMenuView.this.mBrowserRouteItemView != null && RGMMMenuView.this.mBrowserRouteItemView == view) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_MORE_VIEWSEGMENT, NaviStatConstants.NAVIGATION_MORE_VIEWSEGMENT);
                    if (RouteGuideFSM.getInstance().getTopState() == null || !RouteGuideFSM.getInstance().getTopState().equals(FsmState.RouteItem)) {
                        RouteGuideFSM.getInstance().run(FsmEvent.MENU_CLICK_ROUTE_ITEM);
                    }
                } else if (RGMMMenuView.this.mResetRouteView != null && RGMMMenuView.this.mResetRouteView == view) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_MORE_RESETROUTE, NaviStatConstants.NAVIGATION_MORE_RESETROUTE);
                    RouteGuideFSM.getInstance().run(FsmEvent.MENU_CLICK_ROUTE_PLAN);
                } else if (RGMMMenuView.this.mOtherRouteView == null || RGMMMenuView.this.mOtherRouteView != view) {
                    if (RGMMMenuView.this.mGasStationView != null && RGMMMenuView.this.mGasStationView == view) {
                        RGControlPanelModel.mIsRouteSearchVisible = false;
                        RGMMMenuView.this.hide();
                        RGControlPanelModel.mIsMenuVisible = false;
                        if (RGMMMenuView.this.mSubViewListener != null && !RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)) {
                            RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Gas_Station);
                        }
                    } else if (RGMMMenuView.this.mBankView != null && RGMMMenuView.this.mBankView == view) {
                        RGControlPanelModel.mIsRouteSearchVisible = false;
                        RGMMMenuView.this.hide();
                        RGControlPanelModel.mIsMenuVisible = false;
                        if (RGMMMenuView.this.mSubViewListener != null && !RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)) {
                            RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Bank);
                        }
                    } else if (RGMMMenuView.this.mToiletView != null && RGMMMenuView.this.mToiletView == view) {
                        RGControlPanelModel.mIsRouteSearchVisible = false;
                        RGMMMenuView.this.hide();
                        RGControlPanelModel.mIsMenuVisible = false;
                        if (RGMMMenuView.this.mSubViewListener != null && !RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)) {
                            RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Toilet);
                        }
                    } else if (RGMMMenuView.this.mSpotView != null && RGMMMenuView.this.mSpotView == view) {
                        RGControlPanelModel.mIsRouteSearchVisible = false;
                        RGMMMenuView.this.hide();
                        RGControlPanelModel.mIsMenuVisible = false;
                        if (RGMMMenuView.this.mSubViewListener != null && !RightHandResourcesProvider.isInternationalWithToast(RGMMMenuView.this.mContext)) {
                            RGMMMenuView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Spots);
                        }
                    } else if (RGMMMenuView.this.mRouteSearchHeadView != null && RGMMMenuView.this.mRouteSearchHeadView == view) {
                        RGMMMenuView.this.hide();
                        RGControlPanelModel.mIsMenuVisible = false;
                        if (RGMMMenuView.this.mSubViewListener != null) {
                            RGMMMenuView.this.mSubViewListener.onMoreRouteSearchAction();
                        }
                    } else if (RGMMMenuView.this.mNorth2DView != null && RGMMMenuView.this.mNorth2DView == view) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_1, null, "", "2");
                        RouteGuideFSM.getInstance().cacheBackMapState(FsmState.North2D);
                        RGMMMenuView.this.updateMapStatusView();
                        BNavigator.getInstance().enterNavState();
                        BNSettingManager.setMapMode(2);
                    } else if (RGMMMenuView.this.mCar3DView != null && RGMMMenuView.this.mCar3DView == view) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_1, "", null, "2");
                        RouteGuideFSM.getInstance().cacheBackMapState(FsmState.Car3D);
                        RGMMMenuView.this.updateMapStatusView();
                        BNavigator.getInstance().enterNavState();
                        BNSettingManager.setMapMode(1);
                    } else if (RGMMMenuView.this.mHUDModeView != null && RGMMMenuView.this.mHUDModeView == view) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_4);
                        RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_HUD_ENTER);
                    } else if (RGMMMenuView.this.mVoiceItemView != null && RGMMMenuView.this.mVoiceItemView == view) {
                        BNSettingManager.setFirstVoiceGuide(true);
                        if (RGMMMenuView.this.mVoiceRedGuide != null) {
                            RGMMMenuView.this.mVoiceRedGuide.setVisibility(8);
                        }
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_6);
                        RGMMMenuView.this.hide();
                        if (RGMMMenuView.this.mSubViewListener != null) {
                            RGMMMenuView.this.mSubViewListener.onOtherAction(5, 3, 0, null);
                        }
                    } else if (RGMMMenuView.this.mMenuMoreView != null && RGMMMenuView.this.mMenuMoreView == view) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_e);
                        if (RGMMMenuView.this.mSubViewListener != null) {
                            RGMMMenuView.this.mSubViewListener.onMenuMoreAction();
                        }
                    } else if (RGMMMenuView.this.mVoiceDetailView != null && RGMMMenuView.this.mVoiceDetailView == view) {
                        BNSettingManager.resetVoiceModeParams(0);
                        RGMMMenuView.this.setVoiceSpeakSetting(0, 0);
                        BNSettingManager.setLastVoiceMode(0);
                        RGMMMenuView.this.updateVoiceModeView(0);
                    } else if (RGMMMenuView.this.mVoiceSimpleView != null && RGMMMenuView.this.mVoiceSimpleView == view) {
                        BNSettingManager.resetVoiceModeParams(1);
                        RGMMMenuView.this.setVoiceSpeakSetting(0, 1);
                        BNSettingManager.setLastVoiceMode(1);
                        RGMMMenuView.this.updateVoiceModeView(1);
                    } else if (RGMMMenuView.this.mVoiceQuietView != null && RGMMMenuView.this.mVoiceQuietView == view) {
                        BNSettingManager.resetVoiceModeParams(2);
                        RGMMMenuView.this.setVoiceSpeakSetting(0, 2);
                        RGMMMenuView.this.updateVoiceModeView(2);
                    } else if (RGMMMenuView.this.mPreferViews[0] != null && RGMMMenuView.this.mPreferViews[0] == view) {
                        r2 = RGCarPreferSettingController.getInstance();
                        if (RGCarPreferSettingController.getInstance().isOpenPrefer(16)) {
                            z = false;
                        }
                        r2.updatePreferValue(16, z);
                        RGMMMenuView.this.updatePreferView();
                    } else if (RGMMMenuView.this.mPreferViews[1] != null && RGMMMenuView.this.mPreferViews[1] == view) {
                        r2 = RGCarPreferSettingController.getInstance();
                        if (RGCarPreferSettingController.getInstance().isOpenPrefer(2)) {
                            z = false;
                        }
                        r2.updatePreferValue(2, z);
                        RGCarPreferSettingController.getInstance().updatePreferValue(4, false);
                        RGCarPreferSettingController.getInstance().updatePreferValue(8, false);
                        RGMMMenuView.this.updatePreferView();
                    } else if (RGMMMenuView.this.mPreferViews[2] != null && RGMMMenuView.this.mPreferViews[2] == view) {
                        r2 = RGCarPreferSettingController.getInstance();
                        if (RGCarPreferSettingController.getInstance().isOpenPrefer(4)) {
                            z = false;
                        }
                        r2.updatePreferValue(4, z);
                        RGCarPreferSettingController.getInstance().updatePreferValue(2, false);
                        RGMMMenuView.this.updatePreferView();
                    } else if (RGMMMenuView.this.mPreferViews[3] != null && RGMMMenuView.this.mPreferViews[3] == view) {
                        r2 = RGCarPreferSettingController.getInstance();
                        if (RGCarPreferSettingController.getInstance().isOpenPrefer(8)) {
                            z = false;
                        }
                        r2.updatePreferValue(8, z);
                        RGCarPreferSettingController.getInstance().updatePreferValue(2, false);
                        RGMMMenuView.this.updatePreferView();
                    }
                } else if (RGMMMenuView.this.mSubViewListener != null) {
                    RGMMMenuView.this.mSubViewListener.onOtherAction(5, 1, 0, null);
                }
            } else if (RGMMMenuView.this.mSubViewListener != null) {
                RGMMMenuView.this.mSubViewListener.onMoreMenuAction();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuView$8 */
    class C43938 implements onStatusButtonClickListener {
        C43938() {
        }

        public void onClick(StatusButton sButton, StatusButtonChild child) {
            if (sButton != RGMMMenuView.this.mRealRoadConditionBtn || RGMMMenuView.this.mRealRoadConditionBtn == null) {
                if (sButton != RGMMMenuView.this.mJavaLogBtn || RGMMMenuView.this.mJavaLogBtn == null) {
                    if (sButton != RGMMMenuView.this.mNativeLogBtn || RGMMMenuView.this.mNativeLogBtn == null) {
                        if (sButton != RGMMMenuView.this.mMonkeyBtn || RGMMMenuView.this.mMonkeyBtn == null) {
                            if (sButton == RGMMMenuView.this.mSBGPSDebugView && RGMMMenuView.this.mSBGPSDebugView != null && RGMMMenuView.this.mSubViewListener != null) {
                                switch (child) {
                                    case LEFT:
                                        BNSettingManager.setGPSDebug(true);
                                        return;
                                    case RIGHT:
                                        BNSettingManager.setGPSDebug(false);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        } else if (RGMMMenuView.this.mSubViewListener != null) {
                            switch (child) {
                                case LEFT:
                                    BNSettingManager.setMonkey(true);
                                    return;
                                case RIGHT:
                                    BNSettingManager.setMonkey(false);
                                    return;
                                default:
                                    return;
                            }
                        }
                    } else if (RGMMMenuView.this.mSubViewListener != null) {
                        switch (child) {
                            case LEFT:
                                BNSettingManager.setShowNativeLog(true);
                                return;
                            case RIGHT:
                                BNSettingManager.setShowNativeLog(false);
                                return;
                            default:
                                return;
                        }
                    }
                } else if (RGMMMenuView.this.mSubViewListener != null) {
                    switch (child) {
                        case LEFT:
                            BNSettingManager.setShowJavaLog(true);
                            return;
                        case RIGHT:
                            BNSettingManager.setShowJavaLog(false);
                            return;
                        default:
                            return;
                    }
                }
            } else if (RGMMMenuView.this.mSubViewListener != null) {
                switch (child) {
                    case LEFT:
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_2, "", null, null);
                        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                            RGMMMenuView.this.mSubViewListener.onITSAction(true);
                            return;
                        }
                        RGMMMenuView.this.mRealRoadConditionBtn.setRightBtnChecked();
                        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_offline));
                        return;
                    case RIGHT:
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_2, null, "", null);
                        RGMMMenuView.this.mSubViewListener.onITSAction(false);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    class DebugUrlAdapter extends BaseExpandableListAdapter {
        DebugUrlAdapter() {
        }

        public Object getChild(int groupPosition, int childPosition) {
            return ((DebugModeMessageBean) RGMMMenuView.this.mGuideMsg.get(groupPosition)).serList.get(childPosition);
        }

        public long getChildId(int groupPosition, int childPosition) {
            return (long) childPosition;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            List<DebugModeMessageSerBean> serBean = ((DebugModeMessageBean) RGMMMenuView.this.mGuideMsg.get(groupPosition)).serList;
            if (convertView == null) {
                convertView = JarUtils.inflate((Activity) RGMMMenuView.this.mContext, C4048R.layout.nsdk_layout_debug_url_children, null);
            }
            TextView tv = (TextView) convertView.findViewById(C4048R.id.second_textview);
            tv.setText(((DebugModeMessageSerBean) serBean.get(childPosition)).key + Config.TRACE_TODAY_VISIT_SPLIT + ((DebugModeMessageSerBean) serBean.get(childPosition)).value);
            return tv;
        }

        public int getChildrenCount(int groupPosition) {
            return ((DebugModeMessageBean) RGMMMenuView.this.mGuideMsg.get(groupPosition)).serList.size();
        }

        public Object getGroup(int groupPosition) {
            return RGMMMenuView.this.mGuideMsg.get(groupPosition);
        }

        public int getGroupCount() {
            return RGMMMenuView.this.mGuideMsg.size();
        }

        public long getGroupId(int groupPosition) {
            return (long) groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = JarUtils.inflate((Activity) RGMMMenuView.this.mContext, C4048R.layout.nsdk_layout_debug_url_parent, null);
            }
            TextView tv = (TextView) convertView.findViewById(C4048R.id.parent_textview);
            tv.setText(((DebugModeMessageBean) RGMMMenuView.this.mGuideMsg.get(groupPosition)).mSceneName);
            return tv;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    class SpinnerSelectedListener implements OnItemSelectedListener {
        SpinnerSelectedListener() {
        }

        public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
        }

        public void onNothingSelected(AdapterView arg0) {
        }
    }

    class SpinnerURLSelectedListener implements OnItemSelectedListener {
        SpinnerURLSelectedListener() {
        }

        public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
        }

        public void onNothingSelected(AdapterView arg0) {
        }
    }

    public RGMMMenuView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        updateDataByLastest();
        initListener();
    }

    public void onOrientationChange() {
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            this.mMenuViewPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_panel);
            this.mMenuViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_container);
            if (this.mMenuViewContainer != null) {
                this.mMenuViewContainer.removeAllViews();
                if (1 == RGViewController.getInstance().getOrientation()) {
                    this.mCurOrientation = 1;
                    this.mMenuView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_menu, null);
                } else {
                    this.mCurOrientation = 2;
                    this.mMenuView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_menu_land, null);
                }
                if (this.mMenuViewContainer != null && this.mMenuView != null) {
                    this.mMenuViewContainer.addView(this.mMenuView, new LayoutParams(-1, -1));
                    this.mMenuTransTop = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_trans_top);
                    this.mMenuContentPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_content_panel);
                    this.mMenuBottomPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bottom_content_panel);
                    this.mMenuScroll = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_scroll);
                    this.mPreferViews[0] = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_prefer_avoid_layout);
                    this.mPreferViews[1] = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_prefer_highway_layout);
                    this.mPreferViews[2] = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_prefer_no_highway_layout);
                    this.mPreferViews[3] = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_prefer_no_charge_layout);
                    this.mPreferTVs[0] = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_avoid_tv);
                    this.mPreferTVs[1] = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_highway_tv);
                    this.mPreferTVs[2] = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_no_highway_tv);
                    this.mPreferTVs[3] = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_no_charge_tv);
                    this.mRealRoadConditionBtn = (StatusButton) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_real_roadcondition_checkbox);
                    this.mBrowserRouteItemView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_browser_route_item);
                    this.mResetRouteView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_reset_route);
                    if (this.mResetRouteView != null) {
                        this.mResetRouteView.setVisibility(8);
                    }
                    this.mRouteSearchView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_search);
                    this.mRouteSearchHeadView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_search_head_view);
                    this.mRouteSearchHeadArrowView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_search_more_arrow_iv);
                    this.mGasStationView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_as_gas_station);
                    this.mBankView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_as_bank);
                    this.mToiletView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_as_toilet);
                    this.mSpotView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rs_spots);
                    this.mRouteSearchInnerPanel = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_search_inner_panel);
                    this.mCloseView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bottom_content_close_view);
                    this.mMenuMoreView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_bottom_content_more_setting_view);
                    this.mRouteSearchCategory = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_search_category);
                    this.mRouteCategory = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_category);
                    this.mNorth2DView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_view_north2d);
                    this.mCar3DView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_view_car3d);
                    this.mVoiceDetailView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_detail_layout);
                    this.mVoiceSimpleView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_simple_layout);
                    this.mVoiceQuietView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_quiet_layout);
                    this.mVoiceDetailTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_detail_tv);
                    this.mVoiceSimpleTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_simple_tv);
                    this.mVoiceQuietTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_quiet_tv);
                    this.mHUDModeView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_view_hud);
                    this.mHUDModeTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_hud_tv);
                    this.mVoiceItemView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_main_layout);
                    this.mVoiceTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_main_tv);
                    this.mVoiceItemHeadArrowView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_main_arrow_iv);
                    this.mVoiceRedGuide = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_voice_red_guide);
                    this.mMoreMenuRedGuide = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_more_menu_red_guide);
                    if (!(this.mVoiceRedGuide == null || BNSettingManager.getFirstVoiceGuide())) {
                        this.mVoiceRedGuide.setVisibility(0);
                    }
                    this.mdebugOpen = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_view_tv);
                    this.mdebugOpen.setOnClickListener(new C43861());
                    if (NavSDKDebug.sSDKFactoryMode) {
                        this.mFactoryCategory = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_category);
                        this.mCuidView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_cuid_item);
                        this.mBuildView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_build_item);
                        this.mJavaLogView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_java_log);
                        this.mNativeLogView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_native_log);
                        this.mMonkeyView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_monkey);
                        this.mCuidTv = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_cuid_item_tv);
                        this.mBuildTimeTv = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_build_item_tv);
                        this.mJavaLogBtn = (StatusButton) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_java_log_checkbox);
                        this.mNativeLogBtn = (StatusButton) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_native_log_checkbox);
                        this.mMonkeyBtn = (StatusButton) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_monkey_checkbox);
                        this.mRLGPSDebugView = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_gps_debug);
                        this.mTVGPSDebugView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_gps_debug_tv);
                        this.mSBGPSDebugView = (StatusButton) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_gps_checkbox);
                        this.mRLUrlDebugView = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_debug_url);
                        this.mTVUrlDebugView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_factory_debug_url_tv);
                        this.mRLUrlDebugExpandView = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rl_expandable_debug_url);
                        this.mELUrlDebugView = (ExpandableListView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_expandable_debug_url);
                        this.mTVUrlDebugColseView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_expandable_close_tv);
                        if (!(this.mRLUrlDebugView == null || this.mTVUrlDebugView == null)) {
                            this.mRLUrlDebugView.setVisibility(0);
                            this.mTVUrlDebugView.setOnClickListener(new C43872());
                            this.mTVUrlDebugColseView.setOnClickListener(new C43883());
                        }
                        if (this.mFactoryCategory != null) {
                            this.mFactoryCategory.setVisibility(0);
                        }
                        if (!(this.mCuidView == null || this.mCuidTv == null)) {
                            this.mCuidView.setVisibility(0);
                            this.mCuidTv.setText("CUID:" + PackageUtil.getCuid());
                        }
                        if (!(this.mBuildView == null || this.mBuildTimeTv == null)) {
                            this.mBuildView.setVisibility(0);
                            this.mBuildTimeTv.setText("BuildTime:(" + PackageUtil.getBuildNo() + ")");
                        }
                        if (!(this.mJavaLogView == null || this.mJavaLogBtn == null)) {
                            this.mJavaLogView.setVisibility(0);
                            this.mJavaLogBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
                            this.mJavaLogBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
                            this.mJavaLogBtn.setMidBtnGone(true);
                        }
                        if (!(this.mNativeLogView == null || this.mNativeLogBtn == null)) {
                            this.mNativeLogView.setVisibility(0);
                            this.mNativeLogBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
                            this.mNativeLogBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
                            this.mNativeLogBtn.setMidBtnGone(true);
                        }
                        if (!(this.mMonkeyView == null || this.mMonkeyBtn == null)) {
                            this.mMonkeyView.setVisibility(0);
                            this.mMonkeyBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
                            this.mMonkeyBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
                            this.mMonkeyBtn.setMidBtnGone(true);
                        }
                        if (!(this.mRLGPSDebugView == null || this.mSBGPSDebugView == null)) {
                            this.mRLGPSDebugView.setVisibility(0);
                            this.mSBGPSDebugView.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
                            this.mSBGPSDebugView.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
                            this.mSBGPSDebugView.setMidBtnGone(true);
                        }
                        View divider25 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_25);
                        if (divider25 != null) {
                            divider25.setVisibility(0);
                        }
                        View divider24 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_24);
                        if (divider24 != null) {
                            divider24.setVisibility(0);
                        }
                        View divider22 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_22);
                        if (divider22 != null) {
                            divider22.setVisibility(0);
                        }
                        View divider21 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_21);
                        if (divider21 != null) {
                            divider21.setVisibility(0);
                        }
                        View divider20 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_20);
                        if (divider20 != null) {
                            divider20.setVisibility(0);
                        }
                        View divider19 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_19);
                        if (divider19 != null) {
                            divider19.setVisibility(0);
                        }
                        View divider18 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_18);
                        if (divider18 != null) {
                            divider18.setVisibility(0);
                        }
                        View divider17 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_17);
                        if (divider17 != null) {
                            divider17.setVisibility(0);
                        }
                        View divider16 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_16);
                        if (divider16 != null) {
                            divider16.setVisibility(0);
                        }
                        View divider15 = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_15);
                        if (divider15 != null) {
                            divider15.setVisibility(0);
                        }
                    }
                    if (this.mRealRoadConditionBtn != null) {
                        this.mRealRoadConditionBtn.setLeftButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_open));
                        this.mRealRoadConditionBtn.setRightButtonText(BNStyleManager.getString(C4048R.string.nsdk_string_close));
                        this.mRealRoadConditionBtn.setMidBtnGone(true);
                    }
                }
            }
        }
    }

    private void initListener() {
        initOnClickListener();
        initStatusButtonClickListener();
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setOnTouchListener(new C43894());
        } else if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setOnTouchListener(new C43905());
        }
        if (this.mMenuScroll != null) {
            this.mMenuScroll.setOnTouchListener(new C43916());
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
        for (int i = 0; i < 4; i++) {
            if (this.mPreferViews[i] != null) {
                this.mPreferViews[i].setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private void initOnClickListener() {
        this.mOnClickListener = new C43927();
    }

    private void initStatusButtonClickListener() {
        this.mStatusButtonClickListener = new C43938();
    }

    public void updateData(Bundle b) {
    }

    public void updateDataByLastest() {
        if (this.mRealRoadConditionBtn != null) {
            if (PreferenceHelper.getInstance(this.mContext).getBoolean("NAVI_ROADCOND_ON_OFF", false)) {
                this.mRealRoadConditionBtn.setLeftBtnChecked();
            } else {
                this.mRealRoadConditionBtn.setRightBtnChecked();
            }
        }
        if (NavSDKDebug.sSDKFactoryMode) {
            if (this.mJavaLogBtn != null) {
                if (BNSettingManager.isShowJavaLog()) {
                    this.mJavaLogBtn.setLeftBtnChecked();
                } else {
                    this.mJavaLogBtn.setRightBtnChecked();
                }
            }
            if (this.mNativeLogBtn != null) {
                if (BNSettingManager.isShowNativeLog()) {
                    this.mNativeLogBtn.setLeftBtnChecked();
                } else {
                    this.mNativeLogBtn.setRightBtnChecked();
                }
            }
            if (this.mMonkeyBtn != null) {
                if (BNSettingManager.isMonkey()) {
                    this.mMonkeyBtn.setLeftBtnChecked();
                } else {
                    this.mMonkeyBtn.setRightBtnChecked();
                }
            }
            if (this.mSBGPSDebugView == null) {
                return;
            }
            if (BNSettingManager.isGPSDebug()) {
                this.mSBGPSDebugView.setLeftBtnChecked();
            } else {
                this.mSBGPSDebugView.setRightBtnChecked();
            }
        }
    }

    private void setVoiceSpeakSetting(int settingType, int value) {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(6, settingType, value, null);
        }
    }

    public void show() {
        super.show();
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(0);
        }
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.startAnimation(AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_IN, 0, 300));
            this.mMenuViewContainer.setVisibility(0);
        }
        if (!(this.mRouteSearchView == null || this.mRootViewGroup == null)) {
            int netMode = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
            if (netMode == 1 || netMode == 3) {
                this.mRouteSearchView.setVisibility(0);
                this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_26).setVisibility(0);
                this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_category).setVisibility(0);
                this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_14).setVisibility(0);
            } else {
                this.mRouteSearchView.setVisibility(8);
                this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_26).setVisibility(8);
                this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_category).setVisibility(8);
                this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_h_divider_14).setVisibility(8);
            }
        }
        initRoutePrefer();
        updateMapStatusView();
        initVoiceModeView();
        refreshRedGuide();
        updateVoiceName();
    }

    private void updateMapStatusView() {
        try {
            String map2DOr3DState = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
            if (!(map2DOr3DState == null || this.mRootViewGroup == null)) {
                LinearLayout imageNorth2D;
                LinearLayout imageCar3D;
                TextView textNorth2D;
                TextView textCar3D;
                if (map2DOr3DState == FsmState.North2D) {
                    imageNorth2D = (LinearLayout) this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[0]);
                    imageCar3D = (LinearLayout) this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[1]);
                    textNorth2D = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_north2d_tv);
                    textCar3D = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_car3d_tv);
                    if (!(imageNorth2D == null || imageCar3D == null)) {
                        imageNorth2D.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                        imageCar3D.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                        textNorth2D.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
                        if (BNStyleManager.getDayStyle()) {
                            textCar3D.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                        } else {
                            textCar3D.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                        }
                    }
                } else if (map2DOr3DState == FsmState.Car3D) {
                    imageCar3D = (LinearLayout) this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[1]);
                    imageNorth2D = (LinearLayout) this.mRootViewGroup.findViewById(this.mMap2DOr3DStatusImageId[0]);
                    textNorth2D = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_north2d_tv);
                    textCar3D = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_car3d_tv);
                    if (!(imageNorth2D == null || imageCar3D == null)) {
                        imageNorth2D.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                        imageCar3D.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                        if (BNStyleManager.getDayStyle()) {
                            textNorth2D.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                        } else {
                            textNorth2D.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                        }
                        textCar3D.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
                    }
                }
            }
            if (this.mHUDModeView != null) {
                this.mHUDModeView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
            }
        } catch (Exception e) {
        }
    }

    private void updateVoiceModeView(int type) {
        if (this.mVoiceDetailView != null && this.mVoiceSimpleView != null && this.mVoiceQuietView != null && this.mVoiceDetailTV != null && this.mVoiceSimpleTV != null && this.mVoiceQuietTV != null) {
            switch (type) {
                case 0:
                    this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                    this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                    this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                    if (BNStyleManager.getDayStyle()) {
                        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                    } else {
                        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                    }
                    this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
                    return;
                case 1:
                    this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                    this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                    this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                    if (BNStyleManager.getDayStyle()) {
                        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                    } else {
                        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                        this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                    }
                    this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
                    return;
                case 2:
                    this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                    this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                    this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_unselected));
                    if (BNStyleManager.getDayStyle()) {
                        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                    } else {
                        this.mVoiceDetailTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                        this.mVoiceSimpleTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                    }
                    this.mVoiceQuietTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
                    return;
                default:
                    return;
            }
        }
    }

    public void initVoiceModeView() {
        int mode = BNSettingManager.getVoiceMode();
        if (mode == 0) {
            updateVoiceModeView(0);
        } else if (mode == 1) {
            updateVoiceModeView(1);
        } else if (mode == 2) {
            updateVoiceModeView(2);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mMenuContentPanel != null) {
            this.mMenuContentPanel.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mMenuBottomPanel != null) {
            this.mMenuBottomPanel.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mCloseView != null) {
            this.mCloseView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
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
            this.mBrowserRouteItemView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mOtherRouteView != null) {
            this.mOtherRouteView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mResetRouteView != null) {
            this.mResetRouteView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        int i = 0;
        while (this.mRootViewGroup != null && i < this.hDivider.length) {
            View v = this.mRootViewGroup.findViewById(this.hDivider[i]);
            if (v != null) {
                v.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
            }
            i++;
        }
        if (this.mRootViewGroup != null) {
            TextView text;
            if (day) {
                for (int findViewById : this.mTextViewId) {
                    text = (TextView) this.mRootViewGroup.findViewById(findViewById);
                    if (text != null) {
                        text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                    }
                }
                for (int findViewById2 : this.mRouteSearchTVId) {
                    text = (TextView) this.mRootViewGroup.findViewById(findViewById2);
                    if (text != null) {
                        text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
                    }
                }
                for (int findViewById22 : this.mCatalogTextViewId) {
                    text = (TextView) this.mRootViewGroup.findViewById(findViewById22);
                    if (text != null) {
                        text.setTextColor(Color.parseColor("#000000"));
                    }
                }
            } else {
                for (int findViewById222 : this.mTextViewId) {
                    text = (TextView) this.mRootViewGroup.findViewById(findViewById222);
                    if (text != null) {
                        text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a_night));
                    }
                }
                for (int findViewById2222 : this.mRouteSearchTVId) {
                    text = (TextView) this.mRootViewGroup.findViewById(findViewById2222);
                    if (text != null) {
                        text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                    }
                }
                for (int findViewById22222 : this.mCatalogTextViewId) {
                    text = (TextView) this.mRootViewGroup.findViewById(findViewById22222);
                    if (text != null) {
                        text.setTextColor(Color.parseColor("#999999"));
                    }
                }
            }
            for (i = 0; i < this.mRouteSearchImageId.length; i++) {
                ImageView image = (ImageView) this.mRootViewGroup.findViewById(this.mRouteSearchImageId[i]);
                if (image != null) {
                    image.setImageDrawable(BNStyleManager.getDrawable(this.mRouteSearchDrawableId[i]));
                }
            }
            for (int findViewById222222 : this.mdivideViewId) {
                View text2 = this.mRootViewGroup.findViewById(findViewById222222);
                if (text2 != null) {
                    text2.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_c));
                }
            }
            for (int findViewById2222222 : this.mViewCategory) {
                View category = this.mRootViewGroup.findViewById(findViewById2222222);
                if (category != null) {
                    category.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
                }
            }
        }
        if (this.mGasStationView != null) {
            this.mGasStationView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mBankView != null) {
            this.mBankView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mToiletView != null) {
            this.mToiletView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mSpotView != null) {
            this.mSpotView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mCar3DView != null) {
            this.mCar3DView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mNorth2DView != null) {
            this.mNorth2DView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mRouteSearchCategory != null) {
            this.mRouteSearchCategory.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mFactoryCategory != null) {
            this.mFactoryCategory.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mNorth2DView != null) {
            this.mNorth2DView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mCar3DView != null) {
            this.mCar3DView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mHUDModeView != null) {
            this.mHUDModeView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mVoiceItemView != null) {
            this.mVoiceItemView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mVoiceItemHeadArrowView != null) {
            if (day) {
                this.mVoiceItemHeadArrowView.setAlpha(1.0f);
            } else {
                this.mVoiceItemHeadArrowView.setAlpha(0.3f);
            }
        }
        if (this.mRouteSearchHeadArrowView != null) {
            if (day) {
                this.mRouteSearchHeadArrowView.setAlpha(1.0f);
            } else {
                this.mRouteSearchHeadArrowView.setAlpha(0.3f);
            }
        }
        if (this.mVoiceDetailView != null) {
            this.mVoiceDetailView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mVoiceSimpleView != null) {
            this.mVoiceSimpleView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mVoiceQuietView != null) {
            this.mVoiceQuietView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mHUDModeTV != null) {
            if (day) {
                this.mHUDModeTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
            } else {
                this.mHUDModeTV.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
            }
        }
        updateMapStatusView();
        initVoiceModeView();
        initPreferView();
    }

    public void hide() {
        super.hide();
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setVisibility(8);
        }
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(8);
        }
    }

    private boolean checkClick() {
        long now = System.currentTimeMillis();
        if (now - this.mLastClickTime < K_INTERNEL_CLICK) {
            this.mClickNum++;
        } else {
            this.mClickNum = 0;
        }
        this.mLastClickTime = now;
        if (((long) this.mClickNum) > 3) {
            TipTool.onCreateToastDialog(this.mContext, "连击:" + this.mClickNum);
        }
        if (((long) this.mClickNum) < K_MAX_CLICK) {
            return false;
        }
        this.mClickNum = 0;
        return true;
    }

    private void initRoutePrefer() {
        initPreferSettings();
    }

    private void initPreferSettings() {
        initPreferView();
    }

    private void initPreferView() {
        if (this.mPreferViews[0] != null && this.mPreferTVs[0] != null && this.mPreferViews[2] != null && this.mPreferTVs[2] != null) {
            int netMode = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
            if (netMode == 2 || netMode == 0) {
                this.mPreferViews[0].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_not_selected_disable));
                this.mPreferTVs[0].setTextColor(Color.parseColor("#999999"));
                this.mPreferViews[0].setClickable(false);
            } else {
                this.mPreferViews[0].setClickable(true);
            }
            updatePreferView();
        }
    }

    private void updatePreferView() {
        if (this.mPreferViews.length <= 4 && this.mPreferTVs.length <= 4 && this.mPreferViews[0] != null && this.mPreferTVs[0] != null && this.mPreferViews[1] != null && this.mPreferTVs[1] != null && this.mPreferViews[2] != null && this.mPreferTVs[2] != null && this.mPreferViews[3] != null && this.mPreferTVs[3] != null) {
            int lastPreferValue = BNaviModuleManager.getLastPreferValue();
            if (this.mPreferViews[0].isClickable()) {
                if ((lastPreferValue & 16) != 0) {
                    this.mPreferViews[0].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                    this.mPreferTVs[0].setTextColor(Color.parseColor("#3385ff"));
                } else {
                    this.mPreferViews[0].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_not_selected));
                    this.mPreferTVs[0].setTextColor(Color.parseColor("#999999"));
                }
            }
            if (this.mPreferViews[1].isClickable()) {
                if ((lastPreferValue & 2) != 0) {
                    this.mPreferViews[1].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                    this.mPreferTVs[1].setTextColor(Color.parseColor("#3385ff"));
                } else {
                    this.mPreferViews[1].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_not_selected));
                    this.mPreferTVs[1].setTextColor(Color.parseColor("#999999"));
                }
            }
            if (this.mPreferViews[2].isClickable()) {
                if ((lastPreferValue & 4) != 0) {
                    this.mPreferViews[2].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                    this.mPreferTVs[2].setTextColor(Color.parseColor("#3385ff"));
                } else {
                    this.mPreferViews[2].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_not_selected));
                    this.mPreferTVs[2].setTextColor(Color.parseColor("#999999"));
                }
            }
            if (!this.mPreferViews[3].isClickable()) {
                return;
            }
            if ((lastPreferValue & 8) != 0) {
                this.mPreferViews[3].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_selected));
                this.mPreferTVs[3].setTextColor(Color.parseColor("#3385ff"));
                return;
            }
            this.mPreferViews[3].setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_view_not_selected));
            this.mPreferTVs[3].setTextColor(Color.parseColor("#999999"));
        }
    }

    public void refreshRedGuide() {
        if (this.mMoreMenuRedGuide == null) {
            return;
        }
        if (BNSettingManager.getFirsCarLogoGuide() && BNSettingManager.getFristBlueToothChannelGuide()) {
            this.mMoreMenuRedGuide.setVisibility(8);
            BNSettingManager.setFirstMoreMenuGuide(true);
            return;
        }
        this.mMoreMenuRedGuide.setVisibility(0);
    }

    private void updateVoiceName() {
        if (this.mVoiceTV != null) {
            String ttsId = VoiceHelper.getInstance().getCurrentUsedTTSId();
            if (ttsId == null) {
                this.mVoiceTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_voice_normal));
                return;
            }
            VoiceInfo info = VoiceHelper.getInstance().getVoiceInfo(ttsId);
            if (info != null) {
                this.mVoiceTV.setText(info.name);
            }
        }
    }
}
