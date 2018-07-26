package com.baidu.navisdk.naviresult;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel.NaviEndPrivilege;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.naviresult.BNNaviResultController.DataDownloadState;
import com.baidu.navisdk.naviresult.BNNaviResultController.DataDownloadType;
import com.baidu.navisdk.naviresult.TrackStatisticBar.IBarClickListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import java.util.ArrayList;
import org.json.JSONObject;

public class BNNaviResultView {
    private static final int MSG_SHARE_DATA = 291;
    private static final String TAG = BNNaviResultView.class.getSimpleName();
    public static boolean theLastBannerShowTime = false;
    private View achievementsCardZone;
    private TextView achievementsGoalTv;
    private View achievementsRightsEnterIc;
    private TextView achievementsRightsTv;
    private View assuranceView;
    private TextView averageSpeedTv;
    private View back;
    private boolean findViewsFinished = false;
    private ImageView guideIv1;
    private ImageView guideIv2;
    private View guideView1;
    private View guideView2;
    private View historyView;
    private boolean isActivityLogoBitmap = false;
    private boolean isNavigateBack;
    private Activity mActivity;
    private BNMapObserver mBNMapObserver = new BNMapObserver() {
        public void update(BNSubject o, int type, int event, Object arg) {
            if (type == 1 && event == 256) {
                BNNaviResultView.this.updateMapViewVisibleArea();
            }
        }
    };
    private BNDialog mCompleteReportDialog;
    private Context mContext;
    public boolean mIsMapstart = false;
    private RelativeLayout mMapParentView;
    private MapGLSurfaceView mNMapView;
    private Handler mShareHandler = new C42486();
    private TrackStatisticBar mTrackStatisticBar;
    private View mapviewCover;
    private TextView maxSpeedTv;
    private BNNaviResultModel model = BNNaviResultModel.getInstance();
    private View naviResultRootView = null;
    private PrivilegeView privilegeView1;
    private PrivilegeView privilegeView2;
    private LinearLayout privilegesArea;
    private RightsProgressAnimateBar progressArea;
    private View reportView;
    private TextView savedTimeIv;
    private TextView savedTimeTv;
    private TextView savedTimeTypeTv;
    private View savedTimeView;
    private boolean setupViewOnTxtDataArrivedFinish = false;
    private View share;
    private View titleContainer;
    private TextView totalTimeTv;
    private TextView walkNaviTv;
    private View walkNaviView;
    private LinearLayout yellowBannerContainer;
    private LinearLayout yellowBannerContainer_bak;

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$1 */
    class C42431 implements OnClickListener {
        C42431() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                if (BNNaviResultView.this.mShareHandler != null) {
                    BNNaviResultController.getInstance().markFavouriteTrajectory(BNNaviResultView.this.mShareHandler, 2);
                }
                if (BNNaviResultView.this.getYellowBanner() != null) {
                    BNNaviResultView.this.getYellowBanner().setClickable(false);
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$2 */
    class C42442 implements OnClickListener {
        C42442() {
        }

        public void onClick(View v) {
            if (BNNaviResultView.this.isActivityLogoBitmap && BNNaviResultView.this.getYellowBanner() != null) {
                BNNaviResultView.this.getYellowBanner().setVisibility(0);
            }
            BNNaviResultView.this.hideGuideView1();
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$3 */
    class C42453 implements OnClickListener {
        C42453() {
        }

        public void onClick(View v) {
            BNNaviResultView.this.hideGuideView2();
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$4 */
    class C42464 implements OnClickListener {
        C42464() {
        }

        public void onClick(View v) {
            BNNaviResultView.this.hideGuideView2();
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$5 */
    class C42475 implements IBarClickListener {
        C42475() {
        }

        public void onSpeed() {
            BNMapController.getInstance().mapClickEvent(4);
        }

        public void onBrake() {
            BNMapController.getInstance().mapClickEvent(2);
        }

        public void onTurn() {
            BNMapController.getInstance().mapClickEvent(3);
        }

        public void onAccelerate() {
            BNMapController.getInstance().mapClickEvent(1);
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$6 */
    class C42486 extends Handler {
        C42486() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 291:
                    if (BusinessActivityManager.getInstance().getModel().shareRespErrNo != 0 || TextUtils.isEmpty(BusinessActivityManager.getInstance().getModel().shareContentLink)) {
                        TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "数据错误，分享失败");
                        LogUtil.m15791e(BNNaviResultView.TAG, "mShareHandler: 服务端返回 -->> errno: " + BusinessActivityManager.getInstance().getModel().shareRespErrNo + ", errmsg: " + BusinessActivityManager.getInstance().getModel().shareRespMsg);
                        return;
                    }
                    BNNaviResultController.getInstance().shareNavi(BusinessActivityManager.getInstance().getModel().shareContentLink, BusinessActivityManager.getInstance().getModel().sharePicLink, BusinessActivityManager.getInstance().getModel().shareTitle, BusinessActivityManager.getInstance().getModel().shareDesc);
                    return;
                case BusinessActivityManager.MSG_NAV_END_MARK_TRAJECTORY_RET /*1504*/:
                    boolean ret;
                    if (BNNaviResultView.this.getYellowBanner() != null) {
                        BNNaviResultView.this.getYellowBanner().setClickable(true);
                    }
                    if (msg.arg1 == 0) {
                        ret = true;
                    } else {
                        ret = false;
                    }
                    RspData rspData = msg.obj;
                    if (rspData != null) {
                        boolean errno = true;
                        try {
                            if (((JSONObject) rspData.mData) == null || ((JSONObject) rspData.mData).getInt(C2125n.f6745M) != 0) {
                                errno = false;
                            } else {
                                errno = true;
                            }
                        } catch (Exception e) {
                        }
                        Bundle bd = null;
                        if (rspData.mReq != null) {
                            bd = (Bundle) rspData.mReq.getObj();
                        }
                        int from = 1;
                        if (bd != null) {
                            from = bd.getInt("FROM");
                        }
                        LogUtil.m15791e(BNNaviResultView.TAG, "   MSG_NAV_END_MARK_TRAJECTORY_RET  msg.arg1: " + ret + "  from: " + from + "  errno: " + errno);
                        switch (from) {
                            case 2:
                                if (BNNaviResultView.this.isActivityLogoBitmap && BNNaviResultView.this.getYellowBanner() != null) {
                                    BNNaviResultView.this.getYellowBanner().setVisibility(0);
                                }
                                BNNaviResultView.this.hideGuideView1();
                                break;
                        }
                        if (ret && errno) {
                            TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "已保存");
                            BNNaviResultController.getInstance().isMarkFavourite = true;
                            if (BNNaviResultView.this.getYellowBanner() != null) {
                                BNNaviResultView.this.getYellowBanner().setVisibility(8);
                            }
                            if (BNSettingManager.isNavEndYellowBannerFirstClick()) {
                                BNSettingManager.setNavEndYellowBannerFirstClick(false);
                                BNNaviResultView.this.showGuideView2();
                                return;
                            }
                            return;
                        }
                        TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "网络异常，请检查网络并重试");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$7 */
    class C42497 implements OnClickListener {
        C42497() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.COMMON_1_5, "2", null, null);
            BNNaviResultController.getInstance().onBackPressedTitleBar();
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$8 */
    class C42508 implements OnClickListener {
        C42508() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_4);
            if (NetworkUtils.isNetworkAvailable(BNNaviResultView.this.mContext)) {
                TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "数据整理中");
                if (BNNaviResultView.this.mShareHandler != null) {
                    BNNaviResultController.getInstance().getShareData(BNNaviResultView.this.mShareHandler, 291);
                    return;
                } else {
                    TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "数据错误，分享失败");
                    return;
                }
            }
            TipTool.onCreateToastDialog(BNNaviResultView.this.mContext, "网络未连接");
        }
    }

    /* renamed from: com.baidu.navisdk.naviresult.BNNaviResultView$9 */
    class C42519 implements OnClickListener {
        C42519() {
        }

        public void onClick(View v) {
            if (!RightHandResourcesProvider.isInternationalWithToast(BNNaviResultView.this.mContext)) {
                UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_6);
                BNNaviResultController.getInstance().jumpToHistoryPage();
            }
        }
    }

    public void creatView(Activity activity, MapGLSurfaceView nmapView, boolean isNavigateBack) {
        if (activity != null) {
            this.mActivity = activity;
            this.mContext = this.mActivity.getApplicationContext();
            this.mNMapView = nmapView;
            this.isNavigateBack = isNavigateBack;
            LogUtil.m15791e(TAG, "time: BNNaviResultView inflate -->> start ");
            preloadView(this.mActivity);
            LogUtil.m15791e(TAG, "time: BNNaviResultView inflate -->> end ");
            if (this.naviResultRootView != null) {
                LogUtil.m15791e(TAG, "BNNaviResultView: NaviResultModel -->> " + this.model.toString());
                BNNaviResultController.getInstance().setNaviResultShowing(true);
                UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_1);
                setFindViewsFinished(false);
                this.setupViewOnTxtDataArrivedFinish = false;
                addMapView();
                findViews();
                initViews();
                initListeners();
                LogUtil.m15791e(TAG, "BNNaviResultView: isNavigateBack --> " + isNavigateBack);
                boolean hasContainUgcDynamicMark = UgcNaviDynamicMarkRespository.getInstance().hasContainUgcDynamicMark();
                LogUtil.m15791e(TAG, "BNNaviResultView: hasContainUgcDynamicMark --> " + hasContainUgcDynamicMark);
                if (!isNavigateBack && hasContainUgcDynamicMark) {
                    showCompleteReportDialog();
                }
            }
        }
    }

    public boolean hasPreloaded() {
        return this.naviResultRootView != null;
    }

    public boolean preloadView(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (this.naviResultRootView != null) {
            return true;
        }
        LogUtil.m15791e(TAG, "time: preloadView inflate -->> start ");
        try {
            this.naviResultRootView = (ViewGroup) JarUtils.inflate(activity, C4048R.layout.nsdk_layout_navi_result, null);
            LogUtil.m15791e(TAG, "time: preloadView inflate -->> end ");
            if (this.naviResultRootView == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            this.naviResultRootView = null;
            return false;
        }
    }

    private void findViews() {
        this.walkNaviView = this.naviResultRootView.findViewById(C4048R.id.walk_navi_container);
        this.walkNaviTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.walk_navi_tv);
        this.mTrackStatisticBar = (TrackStatisticBar) this.naviResultRootView.findViewById(C4048R.id.track_statistic_bar);
        this.titleContainer = this.naviResultRootView.findViewById(C4048R.id.title_container);
        this.back = this.naviResultRootView.findViewById(C4048R.id.back_container);
        this.share = this.naviResultRootView.findViewById(C4048R.id.info_container);
        this.yellowBannerContainer = (LinearLayout) this.naviResultRootView.findViewById(C4048R.id.yellow_banner_container);
        this.yellowBannerContainer_bak = (LinearLayout) this.naviResultRootView.findViewById(C4048R.id.yellow_banner_container_bak);
        this.achievementsCardZone = this.naviResultRootView.findViewById(C4048R.id.achievements_card_zone);
        this.progressArea = (RightsProgressAnimateBar) this.naviResultRootView.findViewById(C4048R.id.progress_area);
        this.achievementsGoalTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.goal_tv);
        this.achievementsRightsTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.rights_tv);
        this.achievementsRightsEnterIc = this.naviResultRootView.findViewById(C4048R.id.enter_right_ic);
        this.privilegesArea = (LinearLayout) this.naviResultRootView.findViewById(C4048R.id.privileges_area);
        this.savedTimeView = this.naviResultRootView.findViewById(C4048R.id.saved_time_view);
        this.savedTimeIv = (TextView) this.naviResultRootView.findViewById(C4048R.id.saved_time_icon);
        this.savedTimeTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.saved_time);
        this.savedTimeTypeTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.saved_time_type);
        this.totalTimeTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.total_time);
        this.maxSpeedTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.max_speed);
        this.averageSpeedTv = (TextView) this.naviResultRootView.findViewById(C4048R.id.average_speed);
        this.historyView = this.naviResultRootView.findViewById(C4048R.id.history_view);
        this.assuranceView = this.naviResultRootView.findViewById(C4048R.id.assurance_view);
        this.reportView = this.naviResultRootView.findViewById(C4048R.id.report_view);
        setFindViewsFinished(true);
    }

    private void showGuideView1() {
        if (this.guideView1 == null) {
            this.guideView1 = ((ViewStub) this.naviResultRootView.findViewById(C4048R.id.bnav_navi_end_guide_viewstub_1)).inflate();
            this.guideIv1 = (ImageView) this.naviResultRootView.findViewById(C4048R.id.bnav_navi_end_guide_1_iv);
            if (this.guideIv1 != null) {
                this.guideIv1.setOnClickListener(new C42431());
            }
            if (this.guideView1 != null) {
                this.guideView1.setOnClickListener(new C42442());
            }
        }
        this.guideView1.setVisibility(0);
    }

    private void showGuideView2() {
        if (this.guideView2 == null) {
            this.guideView2 = ((ViewStub) this.naviResultRootView.findViewById(C4048R.id.bnav_navi_end_guide_viewstub_2)).inflate();
            this.guideIv2 = (ImageView) this.naviResultRootView.findViewById(C4048R.id.bnav_navi_end_guide_2_iv);
            if (this.guideIv2 != null) {
                this.guideIv2.setOnClickListener(new C42453());
            }
            if (this.guideView2 != null) {
                this.guideView2.setOnClickListener(new C42464());
            }
        }
        this.guideView2.setVisibility(0);
    }

    private void hideGuideView1() {
        if (this.guideView1 != null) {
            this.guideView1.setVisibility(8);
        }
    }

    private void hideGuideView2() {
        if (this.guideView2 != null) {
            this.guideView2.setVisibility(8);
        }
    }

    private void initViews() {
        if (this.yellowBannerContainer != null) {
            ((TextView) this.yellowBannerContainer.getChildAt(0)).setText(Html.fromHtml("<font color=\"#703a04\">保存轨迹用于再次导航? </font><font color=\"#3385ff\">点击保存</font>"));
        }
        if (this.yellowBannerContainer_bak != null) {
            ((TextView) this.yellowBannerContainer_bak.getChildAt(0)).setText(Html.fromHtml("<font color=\"#703a04\">保存轨迹用于再次导航? </font><font color=\"#3385ff\">点击保存</font>"));
        }
        updateAssuranceView();
        updatePushingMarketingAreaView();
        showWalkNaviView(this.model.isShowWalkNavi(), this.model.getWalkNaviRemainDist());
        if (this.share != null) {
            this.share.setVisibility(BNaviModuleManager.isGooglePlayChannel() ? 8 : 0);
        }
        if (!(this.savedTimeView == null || this.savedTimeIv == null || this.savedTimeTv == null || this.savedTimeTypeTv == null)) {
            if (BNNaviResultController.getInstance().setSavedTime(this.savedTimeIv, this.savedTimeTv, this.savedTimeTypeTv)) {
                this.savedTimeView.setVisibility(0);
            } else {
                this.savedTimeView.setVisibility(8);
            }
        }
        if (this.totalTimeTv != null) {
            this.totalTimeTv.setText(this.model.getTotalTimeFormatedStr());
        }
        if (this.maxSpeedTv != null) {
            this.maxSpeedTv.setText(((int) this.model.getMaxSpeed()) + "km/h");
        }
        if (this.averageSpeedTv != null) {
            this.averageSpeedTv.setText(((int) this.model.getAverageSpeed()) + "km/h");
        }
        if (this.progressArea != null) {
            this.progressArea.init();
        }
        initNetworkDataView();
        initTrackStatisticsBar();
    }

    private void initNetworkDataView() {
        LogUtil.m15791e(TAG, "initNetworkDataView: textDataState -->> " + BNNaviResultController.getInstance().getTextDataState());
        if (BNNaviResultController.getInstance().getTextDataState() == DataDownloadState.DOWNLOAD_FINISH) {
            setupViewAfterDownloadFinish();
        } else {
            initViewBeforeDownloadFinish();
        }
        LogUtil.m15791e(TAG, "initNetworkDataView: imgDataState -->> " + BNNaviResultController.getInstance().getImgDataState());
        if (BNNaviResultController.getInstance().getImgDataState() == DataDownloadState.DOWNLOAD_FINISH) {
            updateViewOnRightsLabelIconDataArrived();
        } else if (BNNaviResultController.getInstance().getImgDataState() == DataDownloadState.DOWNLOAD_CANCEL) {
            BNNaviResultController.getInstance().notifyServerDataDownloadState(DataDownloadType.IMG_DATA, DataDownloadState.DOWNLOADING);
            BusinessActivityManager.getInstance().requestBitmap(BusinessActivityManager.MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END);
        }
    }

    private void initTrackStatisticsBar() {
        if (this.mTrackStatisticBar != null) {
            this.mTrackStatisticBar.setBarClickListener(new C42475());
            this.mTrackStatisticBar.init(this.model.getSpeedNum(), this.model.getBrakeNum(), this.model.getTurnNum(), this.model.getAccelerateNum());
        }
    }

    private void initYellowBanner() {
        LogUtil.m15791e(TAG, "initYellowBanner: yellowBanner -->> " + BusinessActivityManager.getInstance().getModel().yellowBanner);
        if (!(getYellowBanner() == null || BNNaviResultController.getInstance().isMarkFavourite)) {
            getYellowBanner().setVisibility(BusinessActivityManager.getInstance().getModel().yellowBanner == 1 ? 0 : 8);
        }
        if (BNSettingManager.isNavEndYellowBannerFirstShow() && BusinessActivityManager.getInstance().getModel().yellowBanner == 1) {
            BNSettingManager.setNavEndYellowBannerFirstShow(false);
            if (this.isActivityLogoBitmap && getYellowBanner() != null) {
                getYellowBanner().setVisibility(8);
            }
            showGuideView1();
        }
    }

    private void initListeners() {
        if (this.back != null) {
            this.back.setOnClickListener(new C42497());
        }
        if (this.share != null) {
            this.share.setOnClickListener(new C42508());
        }
        if (this.historyView != null) {
            this.historyView.setOnClickListener(new C42519());
        }
        if (this.reportView != null) {
            this.reportView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!RightHandResourcesProvider.isInternationalWithToast(BNNaviResultView.this.mContext)) {
                        UserOPController.getInstance().add(UserOPParams.ROUTE_2_e, "2", null, null);
                        BNNaviResultController.getInstance().jumpToReportFragment();
                    }
                }
            });
        }
        if (this.yellowBannerContainer != null) {
            this.yellowBannerContainer.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                        if (BNNaviResultView.this.mShareHandler != null) {
                            BNNaviResultController.getInstance().markFavouriteTrajectory(BNNaviResultView.this.mShareHandler, 1);
                        }
                        if (BNNaviResultView.this.yellowBannerContainer != null) {
                            BNNaviResultView.this.yellowBannerContainer.setClickable(false);
                        }
                    }
                }
            });
        }
        if (this.yellowBannerContainer_bak != null) {
            this.yellowBannerContainer_bak.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                        if (BNNaviResultView.this.mShareHandler != null) {
                            BNNaviResultController.getInstance().markFavouriteTrajectory(BNNaviResultView.this.mShareHandler, 1);
                        }
                        if (BNNaviResultView.this.yellowBannerContainer_bak != null) {
                            BNNaviResultView.this.yellowBannerContainer_bak.setClickable(false);
                        }
                    }
                }
            });
        }
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
    }

    private void showAchievementsCardZone(boolean show, boolean animate) {
        if (this.achievementsCardZone != null) {
            if (animate) {
                TranslateAnimation mShowAction = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                mShowAction.setDuration(500);
                this.achievementsCardZone.startAnimation(mShowAction);
            }
            this.achievementsCardZone.setVisibility(show ? 0 : 4);
        }
    }

    private void showWalkNaviView(boolean show, int remainDist) {
        if (this.walkNaviView != null && this.walkNaviTv != null) {
            if (!show || remainDist <= 0 || this.isActivityLogoBitmap) {
                this.walkNaviView.setVisibility(8);
                return;
            }
            UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_2);
            this.walkNaviTv.setText("步行" + remainDist + "米，跟我走");
            this.walkNaviView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_3);
                    BNNaviResultController.getInstance().startWalkNavi();
                }
            });
            this.walkNaviView.setVisibility(0);
        }
    }

    private void showProgressingDialog() {
        BNNaviResultController.getInstance().onLoadingStart();
    }

    private void dismissProgressingDialog() {
        BNNaviResultController.getInstance().onLoadingEnd();
    }

    private void initViewBeforeDownloadFinish() {
        LogUtil.m15791e(TAG, "initViewBeforeDownloadFinish: -->> ");
        if (BNNaviResultController.getInstance().getTextDataState() == DataDownloadState.DOWNLOADING) {
            showProgressingDialog();
        }
        updateMapViewVisibleArea();
    }

    public synchronized void setupViewAfterDownloadFinish() {
        boolean z = true;
        synchronized (this) {
            LogUtil.m15791e(TAG, "setupViewAfterDownloadFinish: setupViewOnTxtDataArrivedFinish -->> " + this.setupViewOnTxtDataArrivedFinish);
            dismissProgressingDialog();
            if (!this.setupViewOnTxtDataArrivedFinish) {
                this.setupViewOnTxtDataArrivedFinish = true;
                initYellowBanner();
                if (BusinessActivityManager.getInstance().getModel().uploadRespErrNo == 0) {
                    LogUtil.m15791e(TAG, "setupViewAfterDownloadFinish: download -->> success");
                    showAchievementsCardZone(true, !this.isNavigateBack);
                    LogUtil.m15791e(TAG, "setupViewAfterDownloadFinish: showProgressBar -->> progressArea: " + (this.progressArea == null ? "null" : "not null") + ", from: " + BusinessActivityManager.getInstance().getModel().userRightUpgradeFrom + ", to: " + BusinessActivityManager.getInstance().getModel().userRightUpgradeTo);
                    if (this.progressArea != null && BusinessActivityManager.getInstance().getModel().userRightUpgradeFrom >= 0 && BusinessActivityManager.getInstance().getModel().userRightUpgradeTo >= 0) {
                        RightsProgressAnimateBar rightsProgressAnimateBar = this.progressArea;
                        int i = BusinessActivityManager.getInstance().getModel().userRightUpgradeFrom;
                        int i2 = BusinessActivityManager.getInstance().getModel().userRightUpgradeTo;
                        if (this.isNavigateBack) {
                            z = false;
                        }
                        rightsProgressAnimateBar.updateProgress(i, i2, z, false);
                    }
                    updateRightInfoView();
                    setUpPrivilegesView();
                } else {
                    LogUtil.m15791e(TAG, "setupViewAfterDownloadFinish: download -->> fail (errono: " + BusinessActivityManager.getInstance().getModel().uploadRespErrNo + ", errmsg: " + BusinessActivityManager.getInstance().getModel().uploadRespMsg + ")");
                }
                updateMapViewVisibleArea();
            }
        }
    }

    private void updateAssuranceView() {
        if (this.assuranceView != null && BusinessActivityManager.getInstance().getModel().compensationTitle != null && BusinessActivityManager.getInstance().getModel().compensationLink != null) {
            this.assuranceView.setVisibility(0);
            this.assuranceView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (!RightHandResourcesProvider.isInternationalWithToast(BNNaviResultView.this.mContext)) {
                        UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_a);
                        BNNaviResultController.getInstance().openWithOpenAPI(BusinessActivityManager.getInstance().getModel().compensationLink);
                    }
                }
            });
        }
    }

    private void updatePushingMarketingAreaView() {
        if (this.titleContainer == null) {
            return;
        }
        if (BusinessActivityManager.getInstance().getModel().operationActivityId > 0) {
            int newId = BusinessActivityManager.getInstance().getModel().operationActivityId;
            if (BNNaviResultController.getInstance().getLocalMarketingDialogId(this.mActivity) != newId) {
                BNNaviResultController.getInstance().setLocalMarketingDialogId(this.mContext, newId);
                BNNaviResultController.getInstance().resetLocalMarketingDialogShowedTimes(this.mContext);
            }
            int localShowedTimes = BNNaviResultController.getInstance().getLocalMarketingDialogShowedTimes(this.mContext);
            int allocatedShowTimes = BusinessActivityManager.getInstance().getModel().operationActivityTime;
            if (!theLastBannerShowTime) {
                boolean z = this.isNavigateBack && localShowedTimes == allocatedShowTimes;
                theLastBannerShowTime = z;
            }
            LogUtil.m15791e(TAG, "updatePushingMarketingAreaView: --> localShowedTimes: " + localShowedTimes + ", allocatedShowTimes: " + allocatedShowTimes + ", isNavigateBack: " + this.isNavigateBack + ", theLastBannerShowTime: " + theLastBannerShowTime);
            if (localShowedTimes < allocatedShowTimes || theLastBannerShowTime) {
                Bitmap bitmap = BusinessActivityManager.getInstance().getModel().operationActivityLogoBitmap;
                Drawable img = BNNaviResultController.getInstance().getDrawableFromBitmap(bitmap);
                if (bitmap != null && img != null && !bitmap.isRecycled()) {
                    this.isActivityLogoBitmap = true;
                    this.titleContainer.setBackgroundDrawable(img);
                    this.titleContainer.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_b);
                            BNNaviResultController.getInstance().openWithOpenAPI(BusinessActivityManager.getInstance().getModel().operationActivityLink);
                        }
                    });
                    double htow = 0.22916666666666666d;
                    float height = (float) bitmap.getHeight();
                    float width = (float) bitmap.getWidth();
                    if (width != 0.0f) {
                        htow = (double) (height / width);
                    }
                    LayoutParams params = (LayoutParams) this.titleContainer.getLayoutParams();
                    if (params == null) {
                        params = new LayoutParams(-1, -2);
                    }
                    params.width = -1;
                    params.height = (int) (((double) ScreenUtil.getInstance().getWindowWidthPixels()) * htow);
                    this.titleContainer.setLayoutParams(params);
                    if (!this.isNavigateBack) {
                        BNNaviResultController.getInstance().setLocalMarketingDialogShowedTimes(this.mContext, localShowedTimes + 1);
                        return;
                    } else if (theLastBannerShowTime) {
                        BNNaviResultController.getInstance().setLocalMarketingDialogShowedTimes(this.mContext, allocatedShowTimes + 1000);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            return;
        }
        BNNaviResultController.getInstance().resetLocalMarketingData(this.mContext);
    }

    private void updateRightInfoView() {
        if (this.mContext != null && this.achievementsGoalTv != null && this.achievementsRightsTv != null && this.achievementsRightsEnterIc != null) {
            if (BusinessActivityManager.getInstance().getModel().userRightTipsEnd != null) {
                CharSequence charSequence = Html.fromHtml(BusinessActivityManager.getInstance().getModel().userRightTipsEnd);
                if (charSequence != null) {
                    this.achievementsGoalTv.setText(charSequence);
                }
            }
            String checkRightTips = BusinessActivityManager.getInstance().getModel().userRightEnterTips;
            if (checkRightTips != null) {
                this.achievementsRightsTv.setText(checkRightTips);
                this.achievementsRightsTv.setVisibility(0);
                this.achievementsRightsEnterIc.setVisibility(0);
            } else {
                this.achievementsRightsTv.setVisibility(8);
                this.achievementsRightsEnterIc.setVisibility(8);
            }
            this.achievementsRightsTv.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    BNNaviResultView.this.onCheckRightsClick();
                }
            });
            this.achievementsRightsEnterIc.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    BNNaviResultView.this.onCheckRightsClick();
                }
            });
        }
    }

    private void onCheckRightsClick() {
        UserOPController.getInstance().add(UserOPParams.NAVI_RESULT_6_7);
        if (BNNaviResultController.getInstance().isLoggedIn()) {
            BNNaviResultController.getInstance().openWithOpenAPINoTitleBar(BusinessActivityManager.getInstance().getModel().userRightEnterLink);
        } else {
            BNNaviResultController.getInstance().jumpToLoginPage(true);
        }
    }

    public void updateViewOnRightsLabelIconDataArrived() {
        if (this.progressArea != null) {
            this.progressArea.updateRightsLabelIc();
        } else {
            LogUtil.m15791e(TAG, "updateViewOnRightsLabelIconDataArrived: progressArea -->> null");
        }
    }

    private int convertStringToColor(String colorStr) {
        int color = -16777216;
        try {
            if (!TextUtils.isEmpty(colorStr)) {
                color = Color.parseColor(colorStr);
            }
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "convertStringToColor: colorStr -->> " + colorStr);
        }
        return color;
    }

    private void setUpPrivilegesView() {
        if (this.privilegesArea != null) {
            ArrayList<NaviEndPrivilege> dataList = BusinessActivityManager.getInstance().getModel().naviEndPrivilegesList;
            if (dataList == null || dataList.size() < 2) {
                this.privilegesArea.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams params;
            this.privilegesArea.setVisibility(0);
            this.privilegeView1 = new PrivilegeView(this.mActivity, (NaviEndPrivilege) dataList.get(0));
            LinearLayout view1 = this.privilegeView1.getView();
            if (view1 != null) {
                params = new LinearLayout.LayoutParams(0, -2);
                params.height = ScreenUtil.getInstance().dip2px(102);
                params.weight = 1.0f;
                this.privilegesArea.addView(view1, params);
            }
            this.privilegeView2 = new PrivilegeView(this.mActivity, (NaviEndPrivilege) dataList.get(1));
            LinearLayout view2 = this.privilegeView2.getView();
            if (view2 != null) {
                params = new LinearLayout.LayoutParams(0, -2);
                params.height = ScreenUtil.getInstance().dip2px(102);
                params.weight = 1.0f;
                params.leftMargin = ScreenUtil.getInstance().dip2px(12);
                this.privilegesArea.addView(view2, params);
            }
        }
    }

    private void addMapView() {
        this.mMapParentView = (RelativeLayout) this.naviResultRootView.findViewById(C4048R.id.mapview_frame);
        this.mapviewCover = this.naviResultRootView.findViewById(C4048R.id.mapview_cover);
        if (this.mMapParentView != null && this.mapviewCover != null) {
            this.mapviewCover.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
            this.mMapParentView.removeAllViews();
            if (BNNaviResultController.pRGViewMode != 0) {
                BNNaviResultController.pRGViewMode = 1;
            } else if (this.mNMapView != null) {
                try {
                    ViewGroup parent = (ViewGroup) this.mNMapView.getParent();
                    if (parent != null) {
                        parent.removeAllViews();
                    }
                } catch (Exception e) {
                }
                this.mMapParentView.addView(this.mNMapView, new LinearLayout.LayoutParams(-1, -1));
                this.mMapParentView.requestLayout();
            } else {
                return;
            }
            BNMapController.getInstance().showTrafficMap(false);
            BNMapController.getInstance().setNightMode(false);
        }
    }

    private int getTopHeight() {
        int topHeight = ScreenUtil.getInstance().dip2px(59) + 35;
        if (this.walkNaviView.getVisibility() == 0) {
            return topHeight + ScreenUtil.getInstance().dip2px(42);
        }
        return topHeight;
    }

    private int getBottomHeight() {
        int bottomHeight = ScreenUtil.getInstance().dip2px(72) + ScreenUtil.getInstance().dip2px(49);
        if (this.achievementsCardZone == null || this.achievementsCardZone.getVisibility() != 0) {
            return bottomHeight;
        }
        return bottomHeight + ScreenUtil.getInstance().dip2px(225);
    }

    private int getRight() {
        if (((this.model.getAccelerateNum() + this.model.getBrakeNum()) + this.model.getTurnNum()) + this.model.getSpeedNum() > 0) {
            return 0 + ScreenUtil.getInstance().dip2px(48);
        }
        return 0;
    }

    private synchronized void updateMapViewVisibleArea() {
        Bundle bundle = new Bundle();
        int topHeight = getTopHeight();
        int bottomHeight = getBottomHeight();
        int unRightHeight = getRight();
        bundle.putInt("widthP", BNMapController.getInstance().getScreenWidth());
        bundle.putInt("heightP", BNMapController.getInstance().getScreenHeight());
        bundle.putInt("unTopHeight", topHeight);
        bundle.putInt("unBottomHeight", bottomHeight);
        bundle.putInt("unLeftHeight", 0);
        bundle.putInt("unRightHeight", unRightHeight);
        BNMapController.getInstance().sendCommandToMapEngine(1, bundle);
        LogUtil.m15791e(TAG, "updateMapViewVisibleArea: sendCommandToMapEngine --> " + bundle.toString());
    }

    private void onMapResume() {
        if (!this.mIsMapstart) {
            BNMapController.getInstance().onResume();
            this.mIsMapstart = true;
        }
    }

    private void onMapPause() {
        if (this.mIsMapstart) {
            BNMapController.getInstance().onPause();
            this.mIsMapstart = false;
        }
    }

    public void onResume() {
        onMapResume();
        BNMapController.getInstance().setNightMode(false);
    }

    public void onPause() {
        onMapPause();
    }

    public void onDestroy() {
        this.isActivityLogoBitmap = false;
        BNNaviResultController.getInstance().setNaviResultShowing(false);
        if (this.mShareHandler != null) {
            this.mShareHandler.removeCallbacksAndMessages(null);
            this.mShareHandler = null;
        }
        if (this.progressArea != null) {
            this.progressArea.destroy();
        }
        if (this.privilegeView1 != null) {
            this.privilegeView1.clearImgData();
        }
        if (this.privilegeView2 != null) {
            this.privilegeView2.clearImgData();
        }
        if (this.titleContainer != null) {
            this.titleContainer.setBackgroundResource(17170445);
            this.titleContainer.setBackgroundDrawable(null);
        }
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    }

    public boolean onBackPressed() {
        if (this.guideView1 != null && this.guideView1.getVisibility() == 0) {
            if (this.isActivityLogoBitmap && getYellowBanner() != null) {
                getYellowBanner().setVisibility(0);
            }
            hideGuideView1();
            return true;
        } else if (this.guideView2 == null || this.guideView2.getVisibility() != 0) {
            UserOPController.getInstance().add(UserOPParams.COMMON_1_5, "1", null, null);
            dismissProgressingDialog();
            return false;
        } else {
            hideGuideView2();
            return true;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public View getRootView() {
        return this.naviResultRootView;
    }

    public boolean isFindViewsFinished() {
        return this.findViewsFinished;
    }

    public void setFindViewsFinished(boolean findViewsFinished) {
        this.findViewsFinished = findViewsFinished;
    }

    private LinearLayout getYellowBanner() {
        if (this.isActivityLogoBitmap) {
            if (this.yellowBannerContainer_bak != null) {
                return this.yellowBannerContainer_bak;
            }
        } else if (this.yellowBannerContainer != null) {
            return this.yellowBannerContainer;
        }
        return null;
    }

    public synchronized void showCompleteReportDialog() {
        if (!(this.mActivity == null || this.mActivity.isFinishing())) {
            if (this.mCompleteReportDialog == null) {
                this.mCompleteReportDialog = new BNDialog(this.mActivity).setTitleText(null).setContentMessage("您有上报的道路问题\n是否现在补充?").setContentCenter().setFirstBtnText(Html.fromHtml("<font color=\"#333333\">取消</font>")).setOnFirstBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        BNNaviResultView.this.dismissCompleteReportDialog();
                        UgcNaviDynamicMarkRespository.getInstance().clear();
                    }
                }).setSecondBtnText(Html.fromHtml("<font color=\"#3385ff\">去补充</font>")).setOnSecondBtnClickListener(new OnNaviClickListener() {
                    public void onClick() {
                        BNNaviResultView.this.dismissCompleteReportDialog();
                        BNNaviResultController.getInstance().goToUgcCompletePage();
                    }
                });
            }
            this.mCompleteReportDialog.show();
        }
    }

    public synchronized void dismissCompleteReportDialog() {
        if (this.mCompleteReportDialog == null || this.mActivity == null || this.mActivity.isFinishing()) {
            this.mCompleteReportDialog = null;
        } else {
            if (this.mCompleteReportDialog.isShowing()) {
                this.mCompleteReportDialog.dismiss();
            }
            this.mCompleteReportDialog = null;
        }
    }
}
