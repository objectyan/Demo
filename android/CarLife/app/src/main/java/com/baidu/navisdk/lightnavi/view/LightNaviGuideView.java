package com.baidu.navisdk.lightnavi.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
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
import com.baidu.navisdk.lightnavi.view.LightNaviUpSlideRelativeLayout.SlideListerner;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviDialogHelper;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviMapHelper;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviScreenHelper;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter.CallBackListener;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
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
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.drawable.UrlDrawableContainForNav;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import java.util.List;

public class LightNaviGuideView extends RelativeLayout {
    private static final String TAG = LightNaviGuideView.class.getSimpleName();
    private Activity mActivity;
    private BNMapObserver mBNMapObserver = new BNMapObserver() {
        public void update(BNSubject o, int type, int event, Object arg) {
            if (2 == type) {
                switch (event) {
                    case 514:
                        LightNaviGuideView.this.mMapHelper.handleSingleTouchGesture();
                        break;
                    case 518:
                        LightNaviGuideView.this.mMapHelper.handleScrollGesture();
                        LightNaviGuideView.this.mJniBaseMap.setDragMapStatus(true);
                        break;
                }
            }
            if (1 == type) {
                switch (event) {
                    case 257:
                        LightNaviGuideView.this.mMapHelper.updateView();
                        return;
                    case 274:
                        LogUtil.m15791e("wangyang", "MapObserver update: EVENT_MAP_ZOOM_UPDATE");
                        LightNaviGuideView.this.mMapHelper.updateView();
                        return;
                    case 278:
                        MapItem item = (MapItem) arg;
                        int index = item.mItemID;
                        if (item.mClickType == 1) {
                            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_8, "", null, null);
                        } else {
                            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_8, null, "", null);
                        }
                        BNNaviResultModel instance = BNNaviResultModel.getInstance();
                        instance.instantNum++;
                        BNRoutePlaner.getInstance().selectRoute(index);
                        Bundle remainBundle = new Bundle();
                        BNLightNaviManager.getInstance().getRemianDisAndTime(remainBundle);
                        int remainDis = remainBundle.getInt("remainDis");
                        int remainTime = remainBundle.getInt("remainTime");
                        if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
                            LightNaviGuideView.this.mRGSlightSimpleGuideView.showBrightRemainTimeAndDis(remainDis, remainTime);
                        }
                        if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                            LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private TextView mBtnUnLock;
    private BNWorkerNormalTask<String, String> mCancelSwitchTask = new BNWorkerNormalTask<String, String>("mCancelSwitchTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            if (BNLightNaviSwitchManager.getInstance().isSwitching()) {
                LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
                BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
                BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
            }
            return null;
        }
    };
    private Context mContext;
    private LightNaviDialogHelper mDialogHelper;
    private BNWorkerNormalTask<String, String> mDismissScreenShotProgressTask = new BNWorkerNormalTask<String, String>("mDismissScreenShotProgressTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            LightNaviGuideView.this.mRLProgress.setVisibility(8);
            if (!LightNaviGuideView.this.isScreenShotSuccess()) {
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
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (1000 == msg.what) {
                if (BNLightNaviManager.getInstance().getType() == 1 && BNLightNaviManager.getInstance().isNaving()) {
                    LightNaviGuideView.this.getScreenShot();
                }
            } else if (1001 == msg.what) {
                if (TTSPlayerControl.getMapTTSPlayStatus()) {
                    LightNaviGuideView.this.mHandler.sendEmptyMessageDelayed(1001, 500);
                    return;
                }
                LightNaviGuideView.this.mHandler.removeMessages(1001);
                TTSPlayerControl.playTTS(LightNaviGuideView.this.mOperationGuideContent, 1);
                if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                    LightNaviGuideView.this.mRGSlightYellowBannerView.showOnlyBrightCondition();
                }
            } else if (3001 == msg.what) {
                LogUtil.m15791e(LightNaviGuideView.TAG, "wywy--MSG_TYPE_REMOVE_YELLOW_GUIDE");
                BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mHideYellowBarSwitchTask, false);
                BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mHideYellowBarGuideTask, false);
            } else if (3002 == msg.what) {
                LogUtil.m15791e(LightNaviGuideView.TAG, "wywy--MSG_TYPE_REMOVE_YELLOW_SWITCH");
                BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mHideYellowBarSwitchTask, false);
            } else if (CommandConst.K_MSG_GENERAL_HTTP_IPO_GUIDE_EXEC == msg.what && msg.arg1 == 0) {
                LogUtil.m15791e(LightNaviGuideView.TAG, "wy--SLIGHT_GUIDE");
                List<LightNaviGuideBean> mGuideMsg = CmdLightNaviGetGuideInfo.mGuideMsg;
                if (mGuideMsg != null && mGuideMsg.size() >= 1) {
                    LightNaviGuideView.this.mOperationGuideContent = ((LightNaviGuideBean) mGuideMsg.get(0)).content;
                    if (LightNaviGuideView.this.mOperationGuideContent != null) {
                        LogUtil.m15791e(LightNaviGuideView.TAG, "wy--SLIGHT_GUIDE SHow");
                        LightNaviGuideView.this.showMessasg(4, LightNaviGuideView.this.mOperationGuideContent, 30000, -1);
                    }
                }
            }
        }
    };
    private volatile boolean mHasScreenShotSuccess = false;
    private BNWorkerNormalTask<String, String> mHideYellowBarGuideTask = new BNWorkerNormalTask<String, String>("mHideYellowBarGuideTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(4);
            }
            return null;
        }
    };
    private BNWorkerNormalTask<String, String> mHideYellowBarSwitchTask = new BNWorkerNormalTask<String, String>("mHideYellowBarSwitchTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
            }
            return null;
        }
    };
    private LightGuideRGListener mIPORGListener = new C41092();
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
    private ILocationBtnClickListener mLocationBtnClickListener = new ILocationBtnClickListener() {
        public void onClick(int curLocMode) {
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_5);
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
    private BNWorkerNormalTask<String, String> mQuitNaviTask = new BNWorkerNormalTask<String, String>("mQuitNaviTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
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
    private BNWorkerNormalTask<String, String> mReleaseScrennTask = new BNWorkerNormalTask<String, String>("mReleaseScrennTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            LightNaviGuideView.this.releaseScreen();
            return null;
        }
    };
    private Runnable mRestoreMapStatusRunable = new Runnable() {
        public void run() {
            LightNaviGuideView.this.mJniBaseMap.setDragMapStatus(false);
        }
    };
    private ViewGroup mRootView = null;
    private View mSafeGuideView;
    private LinearLayout mSafeParent;
    private ImageView mSafeParentIv;
    private LightNaviScreenHelper mScreenHelper;
    private SlideListerner mSlideListerner = new SlideListerner() {
        public void onDeblocking() {
            LightNaviGuideView.this.mActivity.getWindow().clearFlags(525440);
            LightNaviLockScreenReceiver.mIsLock = false;
            BNLightNaviManager.getInstance().startUnLockScreen();
        }
    };
    private TextView mSwitchNavi;
    private UgcRCEventCallback mUgcRCEventCallback = new UgcRCEventCallback() {
        public void onFinish() {
            LightNaviGuideView.this.mRCEventDetailsView = null;
            if (LightNaviGuideView.this.mMenuViewContainer != null) {
                LightNaviGuideView.this.mMenuViewContainer.removeAllViews();
                LightNaviGuideView.this.mMenuViewContainer.setVisibility(8);
            }
        }

        public void onShowUserINfo(String url) {
        }
    };
    private ImageView mUgcReportIv;
    private UgcReportNaviMainView mUgcReportMapMainView;
    private ViewGroup mUgcReportVG = null;
    private CallBackListener mUgcResportCallback = new CallBackListener() {
        public void onUgcFinish() {
            if (LightNaviGuideView.this.mMenuViewContainer != null) {
                LightNaviGuideView.this.mMenuViewContainer.removeAllViews();
                LightNaviGuideView.this.mMenuViewContainer.setVisibility(8);
            }
            LightNaviGuideView.this.mUgcReportMapMainView = null;
            LightNaviGuideView.this.mPrensenter = null;
        }
    };
    private RGUserRightView mUserRightView = null;
    private int mViewHeight = 0;
    private LightNaviWrapperCallback mWrapperCallback;
    private boolean mYawing;

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$2 */
    class C41092 implements LightGuideRGListener {
        C41092() {
        }

        public void avoidTrafficJam(Message msg) {
        }

        public void hideAvoidTrafficJamView() {
        }

        public void showSafetyGuide(boolean show) {
            if (LightNaviGuideView.this.mSafeGuideView != null) {
                LightNaviGuideView.this.mSafeGuideView.setVisibility(show ? 0 : 8);
            }
        }

        public void onIPORoadConditionUpdate(Message msg) {
            if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                LightNaviGuideView.this.mRGSlightYellowBannerView.onRoadConditionUpdate();
            }
            if (BNLightNaviManager.getInstance().getType() == 1) {
                int screenshotTag = msg.arg2;
                int screenshotType = msg.arg1;
                if (LightNaviGuideView.this.mRGSlightLockImageView != null && LightNaviGuideView.this.mRGSlightLockImageView.checkNeedShowLockImage(screenshotType) && screenshotTag == 1) {
                    LightNaviGuideView.this.getScreenShot();
                    LightNaviGuideView.this.lightScreen();
                }
            }
        }

        public void onIPORoadConditionHide(Message msg) {
            if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(1);
            }
        }

        public void onIPOLockScreen(Message msg) {
            if (BNLightNaviManager.getInstance().getType() == 1) {
                LightNaviGuideView.this.mHandler.sendEmptyMessageDelayed(1000, 20000);
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

        public void refreshScreenShot() {
            LightNaviGuideView.this.getScreenShot();
        }

        public void onIPOAddressScreen(Message msg) {
            if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
                LightNaviGuideView.this.mRGSlightLockImageView.updateLockImage();
            }
        }

        public void onRemainInfoUpdate(Message msg) {
            LogUtil.m15791e("wangyang", "onRemainInfoUpdate  time = " + msg.arg2 + "dist=" + msg.arg1);
            if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
                LightNaviGuideView.this.mRGSlightSimpleGuideView.showRemainTimeAndDis(msg.arg1, msg.arg2);
            }
            LightNaviGuideView.this.mNavIPOStatItem.mDistToDest = (long) msg.arg1;
            if (LightNaviGuideView.this.mUserRightView != null) {
                LightNaviGuideView.this.mUserRightView.updateCurMileaInfo();
            }
        }

        public void onArriveDest(Message msg) {
            if (BNavigator.getInstance().getOnNaviBeginListener() != null) {
                BNavigator.getInstance().getOnNaviBeginListener().onArriveDest();
            }
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_g, "0", null, "1");
            BNNaviResultModel.getInstance().setDestArrived(true);
            LightNaviGuideView.this.onQuit(false);
            BNLightNaviManager.getInstance().setIsNaving(false);
            if (BNLightNaviManager.getInstance().getType() == 2) {
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "您已到达目的地，即将退出路线雷达");
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(LightNaviGuideView.this.mQuitNaviTask, new BNWorkerConfig(9, 0), 2000);
            }
        }

        public void onYawingRerouting(Message msg) {
            NaviIPOStatItem naviIPOStatItem = LightNaviGuideView.this.mNavIPOStatItem;
            naviIPOStatItem.mYawingCount++;
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_h);
            LightNaviGuideView.this.mYawing = true;
            TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "您已偏离路线,正在重新规划路线....");
            if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
                LightNaviGuideView.this.mRGSlightSimpleGuideView.showOverSpeed(false);
            }
        }

        public void onYawingRPFail() {
            LightNaviGuideView.this.mYawing = false;
            if (BNLightNaviManager.getInstance().getType() == 2) {
                LightNaviGuideView.this.quitLightNavi(false);
                return;
            }
            BNLightNaviManager.getInstance().setIsNaving(false);
            LightNaviGuideView.this.onQuit(false);
        }

        public void onYawingRerouteSuccess(Message msg) {
            LightNaviGuideView.this.mYawing = false;
            if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
            }
            if (BNLightNaviManager.getInstance().getType() == 2) {
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "偏航路线规划成功");
                if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
                    LightNaviGuideView.this.mRGSlightLockImageView.zoomToSlightNaviFullView(LightNaviGuideView.this.mRGSlightYellowBannerView, LightNaviGuideView.this.mViewHeight);
                }
            } else {
                LightNaviGuideView.this.getScreenShot();
                LightNaviGuideView.this.lightScreen();
            }
            BNNaviResultModel.getInstance().setYawNum();
        }

        public void onOtherRoute(Message msg) {
            int subType = msg.arg1;
            int routeIndex = msg.arg2;
            LogUtil.m15791e(LightNaviGuideView.TAG, "wywy-onOtherRoute type : " + subType);
            switch (subType) {
                case 0:
                    if (LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
                        return;
                    }
                    return;
                case 4:
                    if (BNLightNaviManager.getInstance().getType() == 2) {
                        TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "网络不佳，请稍后重试!");
                        return;
                    }
                    return;
                case 8:
                    LogUtil.m15791e(LightNaviGuideView.TAG, "wy--STATUS_STRATEGYROUTE");
                    Bundle bundle = new Bundle();
                    BNRouteGuider.getInstance().getRouteInfoInUniform(1, bundle);
                    if (bundle != null) {
                        String mRouteTips = bundle.getString("usYellowTipTextInfo");
                        LogUtil.m15791e(LightNaviGuideView.TAG, "wy--STATUS_STRATEGYROUTE - show ");
                        LightNaviGuideView.this.showMessasg(3, mRouteTips, 10000, routeIndex);
                    }
                    if (BNLightNaviManager.getInstance().getType() == 2) {
                        zoomToFullView();
                        return;
                    }
                    LightNaviGuideView.this.getScreenShot();
                    LightNaviGuideView.this.lightScreen();
                    return;
                case 9:
                    if (BNLightNaviManager.getInstance().getType() == 2) {
                        TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "发现更快的躲避拥堵路线");
                        zoomToFullView();
                        LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
                        return;
                    }
                    return;
                case 10:
                    if (BNLightNaviManager.getInstance().getType() == 2) {
                        if (BNLightNaviManager.getInstance().getAutoRefresh() > -1) {
                            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_m);
                        } else {
                            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "已为您找到其他替代路线");
                            BNLightNaviManager.getInstance().setAutoRefresh(0);
                        }
                        zoomToFullView();
                        return;
                    }
                    return;
                default:
                    if (BNLightNaviManager.getInstance().getType() == 2) {
                        TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "抱歉，小度没有找到其他替代路线");
                        return;
                    }
                    return;
            }
        }

        public void switchScrennType() {
            LightNaviGuideView.this.screenTypeSwitch();
        }

        public void onQuitNavi() {
            LightNaviGuideView.this.quitLightNavi(false);
        }

        public void calcOtherRoute() {
            BNRouteGuider.getInstance().calcOtherRoute(1, 0);
        }

        public void onSwithSLightToNavi(Message msg) {
            int subType = msg.arg1;
            LogUtil.m15791e("wangyang", "onSwithSLightToNavi type = " + subType);
            if (subType == 2) {
                BNLightNaviManager.getInstance().switch2AlternativeRoute(1);
                BNWorkerCenter.getInstance().cancelTask(LightNaviGuideView.this.mCancelSwitchTask, false);
                LightNaviGuideView.this.mDialogHelper.setCloseGone();
            } else if (subType == 3) {
                LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
            } else if (subType == 4) {
                LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
            } else if (subType == 0) {
                BNaviModuleManager.removeIPO();
                LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
                BNLightNaviSwitchManager.getInstance().setHaveSwitched(true);
                LightNaviGuideView.this.quitLightNavi(true);
                Bundle bundle = LightNaviGuideView.this.initGuideBundle();
                if (bundle == null) {
                    TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
                } else {
                    LightNaviPageJumpHelper.getInstance().onPageJump(3, bundle);
                }
            } else if (subType == 1) {
                BNaviModuleManager.removeIPO();
                LightNaviGuideView.this.mDialogHelper.dismissSwitchProgressDialog();
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
            }
        }

        public void onUpdateSpeed(boolean isShow, Message msg) {
            if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
                LightNaviGuideView.this.mRGSlightSimpleGuideView.onUpdateSpeed(isShow, msg);
            }
        }

        public void onUpdateSimpleGuide(Message msg) {
            if (LightNaviGuideView.this.mRGSlightSimpleGuideView != null) {
                LightNaviGuideView.this.mRGSlightSimpleGuideView.onUpdateSimpleGuide(msg, LightNaviGuideView.this.mYawing);
            }
        }

        public void onAutoRefresh(int type) {
            LogUtil.m15791e("wangyang", "onAutoRefresh type =" + type);
        }

        public void zoomToFullView() {
            if (LightNaviGuideView.this.mRGSlightLockImageView != null) {
                LightNaviGuideView.this.mRGSlightLockImageView.zoomToSlightNaviFullView(LightNaviGuideView.this.mRGSlightYellowBannerView, LightNaviGuideView.this.mViewHeight);
            }
        }

        public void onGpsStatusChange(boolean gpsFixed) {
            LightNaviGuideView.this.showGpsYellowBannerMsg(true, gpsFixed);
        }

        public void isYellowBarHide(Message msg) {
            if (((msg.arg2 >> msg.arg1) & 1) == 1 && LightNaviGuideView.this.mRGSlightYellowBannerView != null) {
                LightNaviGuideView.this.mRGSlightYellowBannerView.hideGuideText(3);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$3 */
    class C41103 implements OnGlobalLayoutListener {
        C41103() {
        }

        public void onGlobalLayout() {
            LightNaviGuideView.this.mRLBrightScreen.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            LightNaviGuideView.this.mViewHeight = LightNaviGuideView.this.mRLBrightScreen.getHeight();
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$4 */
    class C41114 implements BNImageLoadingListener {
        C41114() {
        }

        public void onLoadingStarted(String imageUri, View view) {
        }

        public void onLoadingFailed(String imageUri, View view, String failReason) {
            LightNaviGuideView.this.mUgcReportVG.setVisibility(0);
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage, int from) {
            LightNaviGuideView.this.mUgcReportVG.setVisibility(0);
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$5 */
    class C41125 implements OnClickListener {
        C41125() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_g, "0", null, "2");
            LightNaviGuideView.this.quitLightNavi(false);
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$6 */
    class C41136 implements OnClickListener {
        C41136() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_6, null, "", null);
            if (!BNLightNaviSwitchManager.getInstance().isSwitching()) {
                BNLightNaviManager.getInstance().setType(1);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$7 */
    class C41147 implements OnClickListener {
        C41147() {
        }

        public void onClick(View v) {
            LogUtil.m15791e("wangyang", "mLLSwitchToNavi");
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_j);
            BNLightNaviManager.getInstance().naviSwitchingCalcRoute(1);
            LightNaviGuideView.this.mDialogHelper.showSwitchProgressDialog();
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(LightNaviGuideView.this.mCancelSwitchTask, new BNWorkerConfig(9, 0), HttpsClient.CONN_MGR_TIMEOUT);
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$8 */
    class C41158 implements OnClickListener {
        C41158() {
        }

        public void onClick(View v) {
            if (LightNaviGuideView.this.mYawing) {
                TipTool.onCreateToastDialog(LightNaviGuideView.this.mContext, "抱歉,小度没有找到其他替代路线");
                return;
            }
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_9);
            BNLightNaviManager.getInstance().setAutoRefresh(-1);
            BNRouteGuider.getInstance().calcOtherRoute(1, 0);
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.LightNaviGuideView$9 */
    class C41169 implements OnClickListener {
        C41169() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_y_1, "2", null, null);
                BusinessActivityManager.getInstance().safetyUpload(0, false);
            }
        }
    }

    public interface LightNaviWrapperCallback {
        void registerLoadingProxy();

        void unRegisterLoadingProxy();
    }

    public synchronized boolean isScreenShotSuccess() {
        return this.mHasScreenShotSuccess;
    }

    public synchronized void setScreenShotSuccess(boolean flag) {
        this.mHasScreenShotSuccess = flag;
    }

    public LightNaviGuideView(Context context, MapGLSurfaceView nmapView, String packageName) {
        super(context);
        BNRouteGuider.getInstance().setNaviMode(2);
        this.mContext = context;
        this.mPackageName = packageName;
        this.mNavIPOStatItem = NaviIPOStatItem.getInstance();
        this.mNavIPOStatItem.onIPONaviStart();
        BNLightNaviManager.getInstance().init(this.mIPORGListener, (Activity) context);
        BNavigator.getInstance().initLightNavi((Activity) context);
        this.mScreenHelper = LightNaviScreenHelper.getInstance(context);
        this.mMapHelper = LightNaviMapHelper.getInstance(context);
        this.mDialogHelper = LightNaviDialogHelper.getInstance(context);
        this.mScreenHelper.initScreenAlwaysOn();
        setupView((Activity) context);
        onUpdateStyle(BNStyleManager.getDayStyle());
        LightNaviLockScreenReceiver.initLockScreenReceiver(context.getApplicationContext(), this.mActivity);
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        BNLightNaviManager.getInstance().setIsLightNaviView(true);
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            RGParkPointModel.getInstance().setCanParkPoiShow(true);
        }
        LightNaviParams.mGpsStatus = 0;
        checkAndShowGPSSettingDialog();
        initGPSOpenCloseStateListener();
    }

    public LightNaviGuideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setWrapperCallback(LightNaviWrapperCallback wrapperCallback) {
        this.mWrapperCallback = wrapperCallback;
    }

    private void setupView(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) JarUtils.inflate(activity, C4048R.layout.nsdk_layout_ipo_guide, this);
        if (this.mRootView != null) {
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
            int showTime = BNSettingManager.getIPOGuideShowTime();
            if (showTime > 0 && !LightNaviParams.isGuideHasBeanClose) {
                CmdLightNaviGetGuideInfo.requestLightNaviInfo(this.mHandler);
                BNSettingManager.setIPOGuideShowTime(showTime - 1);
            }
        }
    }

    private void mapSetting() {
        this.mMapHelper.mapSetting();
        if (this.mRGSlightLockImageView != null) {
            this.mRGSlightLockImageView.zoomToSlightNaviFullView(this.mRGSlightYellowBannerView, this.mViewHeight);
        }
        MapStatus st = BNMapController.getInstance().getMapStatus();
        if (st != null) {
            st._WinRound.left = 0;
            st._WinRound.top = 0;
            st._WinRound.bottom = BNMapController.getInstance().getScreenHeight();
            st._WinRound.right = BNMapController.getInstance().getScreenWidth();
            st._Level = -1.0f;
            BNMapController.getInstance().setMapStatus(st, AnimationType.eAnimationNone);
        }
    }

    public void oncreate() {
        BNSettingManager.setQuitForExceptionInNaviMode(true);
    }

    public void onResume() {
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

    public void showUserRightView() {
        if (this.mUserRightView != null) {
            this.mUserRightView.show();
        }
    }

    public void onPause() {
        this.mMapHelper.onPause();
        if (this.mRGSlightLockImageView != null) {
            this.mRGSlightLockImageView.onMapPause();
        }
        this.mIsForground = false;
    }

    private void screenTypeSwitch() {
        LogUtil.m15791e("wangyang", "LightNaviUp screenTypeSwitch type =" + BNLightNaviManager.getInstance().getType());
        if (BNLightNaviManager.getInstance().getType() == 2) {
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
        LogUtil.m15791e("wangyang", "mRLBrightScreen = visible" + this.mRLBrightScreen.getVisibility());
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

    public void findView() {
        this.mRLRouteInfo = (RelativeLayout) findViewById(C4048R.id.bnav_lv_rg_route_info);
        this.mQuit = (ImageView) findViewById(C4048R.id.bnav_lv_rg_quit);
        this.mLLQuit = (LinearLayout) findViewById(C4048R.id.bnav_ll_rg_quit);
        this.mSwitchNavi = (TextView) findViewById(C4048R.id.bnav_lv_rg_switch_to_navi);
        this.mLLLockControl = (LinearLayout) findViewById(C4048R.id.bnav_lv_rg_screen_control);
        this.mLLSwitchToNavi = (LinearLayout) findViewById(C4048R.id.bnav_lv_rg_ll_switch_to_navi);
        this.mLLLockScreenControl = (LinearLayout) findViewById(C4048R.id.bnav_lv_rg_ll_lock_screen);
        this.mIpoLine = findViewById(C4048R.id.light_navi_line);
        this.mIpoLineVertical = findViewById(C4048R.id.light_navi_line_vertical);
        this.mBtnUnLock = (TextView) findViewById(C4048R.id.btn_unlock);
        this.mRLBrightScreen = (RelativeLayout) findViewById(C4048R.id.ipo_bright_screen);
        this.mRLLockUpSlideRelativeLayou = (LightNaviUpSlideRelativeLayout) findViewById(C4048R.id.ipo_lock_screen);
        this.mRLLockUpSlideRelativeLayou.setSlideListerner(this.mSlideListerner);
        this.mRLReplan = (LinearLayout) findViewById(C4048R.id.bnav_rg_cp_replan);
        this.mItsParent = (LinearLayout) findViewById(C4048R.id.layout_ipo_tts_parent);
        this.mSafeParent = (LinearLayout) findViewById(C4048R.id.bnav_rg_cp_safe);
        this.mSafeParentIv = (ImageView) findViewById(C4048R.id.bnav_iv_rg_cp_safe);
        if (CloudlConfigDataModel.getInstance().mCommonConfig.safetyShow) {
            this.mSafeParent.setVisibility(0);
        } else {
            this.mSafeParent.setVisibility(8);
        }
        UrlDrawableContainForNav.getSrcDrawable(CloudlConfigDataModel.getInstance().mCommonConfig.safetyIpoIcon, C4048R.drawable.nsdk_drawable_common_ic_safe_ipo, this.mSafeParentIv, null);
        this.mUgcReportIv = (ImageView) findViewById(C4048R.id.ugc_report_Iv);
        this.mSafeGuideView = findViewById(C4048R.id.navi_rg_safety_guide);
        this.mRLProgress = (RelativeLayout) findViewById(C4048R.id.bnav_lock_progress);
        this.mUgcReportVG = (ViewGroup) findViewById(C4048R.id.ugc_report_layout);
        this.mMenuViewContainer = (ViewGroup) findViewById(C4048R.id.ipo_ugc_container);
        Bundle remainBundle = new Bundle();
        BNLightNaviManager.getInstance().getRemianDisAndTime(remainBundle);
        int remainDis = remainBundle.getInt("remainDis");
        int remainTime = remainBundle.getInt("remainTime");
        this.mNavIPOStatItem.mNaviRoutePlanDist = (long) remainDis;
        this.mNavIPOStatItem.mNaviRoutePlanTime = (long) remainTime;
        if (this.mRGSlightSimpleGuideView != null) {
            this.mRGSlightSimpleGuideView.showRemainTimeAndDis(remainDis, remainTime);
        }
        this.mUserRightView = new RGUserRightView(this.mActivity, this.mRootView, null);
        this.mRLBrightScreen.getViewTreeObserver().addOnGlobalLayoutListener(new C41103());
        if (this.mUgcReportVG != null && this.mUgcReportIv != null) {
            new UgcImageLoaderUtils().updateUgcViewOnLine(4096, this.mUgcReportIv, new C41114());
        }
    }

    public void setupListener() {
        this.mLLQuit.setOnClickListener(new C41125());
        this.mLLLockScreenControl.setOnClickListener(new C41136());
        this.mLLSwitchToNavi.setOnClickListener(new C41147());
        this.mRLReplan.setOnClickListener(new C41158());
        this.mSafeParent.setOnClickListener(new C41169());
        if (this.mUgcReportVG != null) {
            this.mUgcReportVG.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    LightNaviGuideView.this.mUgcReportMapMainView = new UgcReportNaviMainView(LightNaviGuideView.this.mContext, 1);
                    LightNaviGuideView.this.mPrensenter = new UgcReportNaviMainPresenter(LightNaviGuideView.this.mUgcReportMapMainView, UgcDataProvider.obtainUgcNaviLayout(), LightNaviGuideView.this.mUgcResportCallback);
                    LightNaviGuideView.this.mUgcReportMapMainView.setPresenter(LightNaviGuideView.this.mPrensenter);
                    View mMenuView = LightNaviGuideView.this.mUgcReportMapMainView.getParentView();
                    if (LightNaviGuideView.this.mMenuViewContainer != null && mMenuView != null) {
                        LightNaviGuideView.this.mMenuViewContainer.removeAllViews();
                        LightNaviGuideView.this.mMenuViewContainer.addView(mMenuView, new LayoutParams(-1, -1));
                        LightNaviGuideView.this.mMenuViewContainer.setVisibility(0);
                        LightNaviGuideView.this.mPrensenter.setIsIpoNavi(true);
                        LightNaviGuideView.this.mPrensenter.start();
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u, "3", null, null);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (BNLightNaviManager.getInstance().isNaving()) {
            quitLightNavi(false);
        }
        this.mActivity.getWindow().clearFlags(525312);
        LightNaviLockScreenReceiver.mIsLock = false;
        onDestroyView();
        if (this.mPrensenter != null) {
            this.mPrensenter.onDestroy();
            this.mPrensenter = null;
            this.mUgcReportMapMainView = null;
        }
        if (this.mWrapperCallback != null) {
            this.mWrapperCallback.unRegisterLoadingProxy();
        }
        if (this.mRCEventDetailsView != null) {
            BNRCEventDetailsViewController.getInstance().onDestroy();
            this.mRCEventDetailsView = null;
        }
    }

    public void onDestroyView() {
        if (this.mSafeParentIv != null) {
            UIUtils.releaseImageView(this.mSafeParentIv);
        }
        if (this.mRootView != null) {
            this.mRootView.removeAllViews();
        }
        this.mRootView = null;
    }

    public void onUpdateStyle(boolean isDay) {
    }

    public boolean onBackPressed() {
        if (this.mPrensenter == null || this.mMenuViewContainer == null || this.mMenuViewContainer.getVisibility() != 0) {
            if (this.mRCEventDetailsView != null && this.mMenuViewContainer != null && this.mMenuViewContainer.getVisibility() == 0) {
                BNRCEventDetailsViewController.getInstance().onBackPressed();
                return true;
            } else if (BNLightNaviManager.getInstance().getType() == 1) {
                return true;
            } else {
                if (this.mRGSlightGuideView != null && this.mRGSlightGuideView.quitGuide()) {
                    return true;
                }
                quitLightNavi(false);
                return false;
            }
        } else if (this.mPrensenter.onBackPress() || this.mUgcResportCallback == null) {
            return true;
        } else {
            this.mUgcResportCallback.onUgcFinish();
            return true;
        }
    }

    private void lightScreen() {
        if (!this.mIsForground) {
            BNWorkerCenter.getInstance().cancelTask(this.mReleaseScrennTask, false);
            this.mScreenHelper.lightScreen();
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mReleaseScrennTask, new BNWorkerConfig(9, 0), 3000);
        }
    }

    private void releaseScreen() {
        this.mScreenHelper.releaseScreen();
    }

    private void quitLightNavi(boolean switchFlag) {
        LogUtil.m15791e(TAG, "quitLightNavi: switchFlag --> " + switchFlag);
        try {
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
        } catch (Exception e) {
            LogUtil.m15791e("wangyang", e.toString());
        }
        this.mMapHelper.unInit();
        if (!switchFlag) {
            this.mDialogHelper.dismissSwitchProgressDialog();
        }
        this.mDialogHelper.unInit();
        onQuit(switchFlag);
        this.mJniBaseMap.setDragMapStatus(false);
        this.mScreenHelper.restoreScreenAlwaysOn();
        releaseScreen();
        this.mScreenHelper.unInit();
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        LightNaviLockScreenReceiver.uninitLockScreenReceiver();
        BNLightNaviManager.getInstance().uninit();
        BNRouteGuider.getInstance().setNaviMode(1);
        BNLightNaviManager.getInstance().setSwitching(switchFlag);
        Bundle sLightJumpBundle = new Bundle();
        sLightJumpBundle.putBoolean("switch", switchFlag);
        LightNaviPageJumpHelper.getInstance().onPageJump(4, sLightJumpBundle);
        if (!switchFlag) {
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

    private void onQuit(boolean switchFlag) {
        uninitGPSOpenCloseStateListener();
        dismissGPSSettingDialog();
        this.mNavIPOStatItem.onIPONaviEnd();
        this.mNavIPOStatItem.setIPONaviNetworkType(NetworkUtils.getActiveNetworkSubtype());
        this.mNavIPOStatItem.mTotalDistance = BNRouteGuider.getInstance().getCurrentRouteDrvieDistance();
        if (BNLightNaviManager.getInstance().isNaving()) {
            BNavigator.getInstance().quitIPONavi(switchFlag);
        }
    }

    public void onStop() {
        if (this.mNavIPOStatItem != null) {
            this.mNavIPOStatItem.onBackground();
        }
    }

    public void onStart() {
        if (this.mNavIPOStatItem != null) {
            this.mNavIPOStatItem.onForground();
        }
        if (BNLightNaviManager.getInstance().getType() == 2) {
            this.mNavIPOStatItem.onLightScreen();
        } else {
            this.mNavIPOStatItem.onLockScreen();
        }
    }

    private void showScreenShotProgress() {
        BNWorkerCenter.getInstance().cancelTask(this.mDismissScreenShotProgressTask, false);
        this.mRLProgress.setVisibility(0);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mDismissScreenShotProgressTask, new BNWorkerConfig(9, 0), HttpsClient.CONN_MGR_TIMEOUT);
    }

    public void getScreenShot() {
        showScreenShotProgress();
        this.mHandler.removeMessages(1000);
        if (this.mRGSlightLockImageView != null) {
            this.mRGSlightLockImageView.getScreenShot(this.mRGSlightYellowBannerView, this.mViewHeight);
        }
    }

    public Bundle initGuideBundle() {
        RoutePlanModel mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        RoutePlanNode startNode = mRoutePlanModel.getStartNode();
        RoutePlanNode endNode = mRoutePlanModel.getEndNode();
        GeoPoint mypos = BNSysLocationManager.getInstance().getLastValidLocation();
        if ((startNode == null && mypos == null) || endNode == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_VIEW_MODE, 1);
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_CALCROUTE_DONE, 0);
        if (startNode != null && mypos == null) {
            bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_START_X, startNode.getLongitudeE6());
            bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_START_Y, startNode.getLatitudeE6());
            bundle.putString("start_name", mRoutePlanModel.getStartName(this.mActivity, false));
        }
        if (mypos != null) {
            bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_START_X, mypos.getLongitudeE6());
            bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_START_Y, mypos.getLatitudeE6());
            bundle.putString("start_name", JarUtils.getResources().getString(C4048R.string.nsdk_string_route_plan_node_my_pos));
        }
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_END_X, endNode.getLongitudeE6());
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_END_Y, endNode.getLatitudeE6());
        bundle.putString("end_name", mRoutePlanModel.getEndName(this.mActivity, false));
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_MENU_TYPE, 0);
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 1);
        bundle.putBoolean(BNavConfig.KEY_ROUTEGUIDE_IPO_SWITCH, true);
        return bundle;
    }

    private void showMessasg(int priority, String msg, int delayTime, int routeID) {
        if (this.mRGSlightYellowBannerView != null && !TextUtils.isEmpty(msg)) {
            if (priority == 3) {
                LogUtil.m15791e(TAG, "wywy remove runnable mHideYellowBarSwitch");
                BNWorkerCenter.getInstance().cancelTask(this.mHideYellowBarSwitchTask, false);
            } else if (priority == 4) {
                LogUtil.m15791e(TAG, "wywy remove runnable mHideYellowBarGuide");
                BNWorkerCenter.getInstance().cancelTask(this.mHideYellowBarGuideTask, false);
            }
            YellowBarMessage yMsg = new YellowBarMessage();
            yMsg.mPriority = priority;
            yMsg.mMsgContent = msg;
            yMsg.mRouteIndex = routeID;
            this.mRGSlightYellowBannerView.showGuideText(yMsg);
            if (priority == 3) {
                LogUtil.m15791e(TAG, "wywy runnable mHideYellowBarSwitch");
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mHideYellowBarSwitchTask, new BNWorkerConfig(9, 0), (long) delayTime);
            } else if (priority == 4) {
                LogUtil.m15791e(TAG, "wywy runnable mHideYellowBarGuide");
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mHideYellowBarGuideTask, new BNWorkerConfig(9, 0), (long) delayTime);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.mPrensenter != null) {
            this.mPrensenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void showGpsYellowBannerMsg(boolean msgFromEngine, boolean gpsFixed) {
        int i = 1;
        LogUtil.m15791e(TAG, "showGpsYellowBannerMsg: --> msgFromEngine: " + msgFromEngine + " gpsFixed: " + gpsFixed + ", mGpsInfoHasBeenClosed: " + LightNaviParams.mGpsInfoHasBeenClosed);
        if (msgFromEngine) {
            if (!gpsFixed) {
                i = 2;
            }
            LightNaviParams.mGpsStatus = i;
            if (!gpsFixed && !LightNaviParams.mGpsInfoHasBeenClosed) {
                showMessasg(2, "当前GPS信号弱，位置更新可能有延迟！", 0, -1);
            } else if (this.mRGSlightYellowBannerView != null) {
                this.mRGSlightYellowBannerView.hideGuideText(2);
            }
        } else if (!gpsFixed && !LightNaviParams.mGpsInfoHasBeenClosed) {
            showMessasg(2, "未开启GPS，请到设置中打开！", 0, -1);
        } else if (LightNaviParams.mGpsStatus == 2) {
            showGpsYellowBannerMsg(true, false);
        } else if (this.mRGSlightYellowBannerView != null) {
            this.mRGSlightYellowBannerView.hideGuideText(2);
        }
    }

    private void initGPSOpenCloseStateListener() {
        if (BNavConfig.pRGLocateMode == 6 && this.mActivity != null) {
            if (this.mGPSOpenCloseStateObs == null) {
                this.mGPSOpenCloseStateObs = new ContentObserver(new Handler() {
                }) {
                    public void onChange(boolean selfChange) {
                        LogUtil.m15791e(LightNaviGuideView.TAG, "onChange: --> ");
                        LightNaviGuideView.this.checkAndShowGPSSettingDialog();
                    }
                };
            }
            Uri uri = Secure.getUriFor("location_providers_allowed");
            if (uri != null && this.mActivity.getContentResolver() != null) {
                try {
                    this.mActivity.getContentResolver().registerContentObserver(uri, false, this.mGPSOpenCloseStateObs);
                } catch (Exception e) {
                    LogUtil.m15791e(TAG, "registerContentObserver Exception");
                }
            }
        }
    }

    private void uninitGPSOpenCloseStateListener() {
        if (BNavConfig.pRGLocateMode == 6 && this.mActivity != null && this.mGPSOpenCloseStateObs != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.mGPSOpenCloseStateObs);
        }
    }

    private void checkAndShowGPSSettingDialog() {
        dismissGPSSettingDialog();
        if (BNavConfig.pRGLocateMode == 6) {
            BNLocationManager mLocationManager = BNSysLocationManager.getInstance();
            if (mLocationManager == null || mLocationManager.isGpsEnabled()) {
                showGpsYellowBannerMsg(false, true);
                return;
            }
            showGPSSettingDialog();
            showGpsYellowBannerMsg(false, false);
        }
    }

    public synchronized void showGPSSettingDialog() {
        if (!(this.mActivity == null || this.mActivity.isFinishing())) {
            if (this.mGPSSettingDialog == null) {
                this.mGPSSettingDialog = new BNDialog(this.mActivity).setTitleText("提示").setContentMessage("GPS未开启，是否马上设置？").setFirstBtnText("设置").setFirstBtnTextColorHighLight().setOnFirstBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        try {
                            LightNaviGuideView.this.mActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                        } catch (Exception e) {
                            LogUtil.m15791e("", e.toString());
                            TipTool.onCreateToastDialog(LightNaviGuideView.this.mActivity, "打开GPS设置失败，请确认你的手机是否支持GPS定位功能。");
                        }
                    }
                }).setSecondBtnText("取消").setOnSecondBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        TipTool.onCreateToastDialog(LightNaviGuideView.this.mActivity, "只有在开启GPS后才可以正常导航，请开启GPS!");
                    }
                });
            }
            this.mGPSSettingDialog.show();
        }
    }

    public synchronized void dismissGPSSettingDialog() {
        if (this.mGPSSettingDialog == null || this.mActivity == null || this.mActivity.isFinishing()) {
            this.mGPSSettingDialog = null;
        } else {
            if (this.mGPSSettingDialog.isShowing()) {
                this.mGPSSettingDialog.dismiss();
            }
            this.mGPSSettingDialog = null;
        }
    }

    public void showUgcDetailView(String eventId, boolean check) {
        if (check) {
            if (this.mWrapperCallback != null) {
                this.mWrapperCallback.registerLoadingProxy();
            }
            BNRCEventDetailsViewController.getInstance().setSource(2);
            this.mRCEventDetailsView = BNRCEventDetailsViewController.getInstance().getView(this.mContext, eventId, BNaviModuleManager.getBduss(), this.mUgcRCEventCallback, 1);
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_2, "3", null, null);
            if (this.mMenuViewContainer != null && this.mRCEventDetailsView != null) {
                LayoutParams lp = new LayoutParams(-1, -1);
                this.mMenuViewContainer.removeAllViews();
                this.mMenuViewContainer.addView(this.mRCEventDetailsView, lp);
                this.mMenuViewContainer.setVisibility(0);
            }
        } else if (this.mContext != null) {
            TipTool.onCreateToastDialog(this.mContext, "感谢您的反馈，我们将尽快处理");
        }
    }
}
