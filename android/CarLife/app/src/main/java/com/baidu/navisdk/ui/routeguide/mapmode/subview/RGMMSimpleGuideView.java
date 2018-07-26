package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMSimpleGuideView extends BNBaseView {
    private static final String TAG = "guide_info";
    private TextView mAfterLabelInfoTV = null;
    private TextView mAfterMetersInfoTV = null;
    private View mAlongRoadView = null;
    private Animation mAnim = null;
    private ImageView mConsecutiveIcon = null;
    private View mConsecutivePointTV = null;
    private TextView mCurRoadNameTV = null;
    private TextView mCurRoadRemainDistTV = null;
    private TextView mCurRoadRemainDistWordTV = null;
    private TextView mFullviewOrNaviView = null;
    private RelativeLayout mFuzzyLayout = null;
    private TextView mFuzzyTV = null;
    private TextView mGoWhereInfoTV = null;
    private RelativeLayout mGuideInfoLayout = null;
    private boolean mHasRemoveCurVia = false;
    private RelativeLayout mLandspaceLeftPanel = null;
    private TextView mLinkInfoTV = null;
    private TextView mLocationInfoTV = null;
    private View mPortraitTopPanel = null;
    private ImageView mProgress = null;
    private RelativeLayout mProgressLayout = null;
    private int mRemainDist = 0;
    private TextView mSatelliteInfoTV = null;
    private TextView mSatelliteInfoTV2 = null;
    private View mSimpleGuideView = null;
    private LinearLayout mStatusBar = null;
    private ImageView mTurnIcon = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMSimpleGuideView$1 */
    class C44321 implements OnTouchListener {
        C44321() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMSimpleGuideView$2 */
    class C44332 implements OnClickListener {
        C44332() {
        }

        public void onClick(View arg0) {
            if (2 != BNavConfig.pRGLocateMode) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_8);
            }
        }
    }

    public RGMMSimpleGuideView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateDataByLastest();
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        initViews();
        updateDataByLastest();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            this.mSimpleGuideView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_simpleguide_open);
            this.mGuideInfoLayout = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.nav_guide_info_layout);
            this.mProgressLayout = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_simpleguide_inner_progress);
            this.mFuzzyLayout = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.fuzzy_panel);
            this.mTurnIcon = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_turn_icon);
            this.mAfterMetersInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_after_meters_info);
            this.mAfterLabelInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_after_label_info);
            this.mLinkInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_link_info);
            this.mGoWhereInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_go_where_info);
            if (RGViewController.getInstance().getOrientation() == 2) {
                LayoutParams params = this.mGoWhereInfoTV.getLayoutParams();
                params.width = ScreenUtil.getInstance().getGuidePanelWidth();
                this.mGoWhereInfoTV.setLayoutParams(params);
                this.mGoWhereInfoTV.setGravity(1);
            }
            this.mAlongRoadView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_along_road);
            this.mCurRoadNameTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_cur_road_name_tv);
            this.mCurRoadRemainDistTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_cur_road_remain_dist_tv);
            this.mCurRoadRemainDistWordTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_cur_road_remain_dist_word);
            this.mStatusBar = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_top_status_panel);
            this.mLocationInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_location_info);
            this.mSatelliteInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_satellite_info);
            this.mSatelliteInfoTV2 = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_satellite_info_other);
            this.mConsecutivePointTV = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_consecutive_point);
            this.mConsecutiveIcon = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_consecutive_point_icon);
            this.mProgress = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.progress_cycle);
            this.mFuzzyTV = (TextView) this.mFuzzyLayout.findViewById(C4048R.id.fuzzy_tv);
            if (RGViewController.getInstance().getOrientation() == 2) {
                this.mLandspaceLeftPanel = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_left_panel);
                this.mPortraitTopPanel = null;
            } else {
                this.mPortraitTopPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_top_panel);
                this.mLandspaceLeftPanel = null;
            }
            if (this.mSimpleGuideView != null) {
                this.mSimpleGuideView.setOnTouchListener(new C44321());
            }
            if (this.mTurnIcon != null) {
                this.mTurnIcon.setOnClickListener(new C44332());
            }
        }
    }

    public void updateData(Bundle b) {
        LogUtil.m15791e("guide_info", "updateData = " + b.toString());
        if (b == null) {
            LogUtil.m15791e("guide_info", "updateData --> bundle==null");
        } else if (RGSimpleGuideModel.getInstance().isYawing()) {
            LogUtil.m15791e("guide_info", "Yawing now! cannot updateData!");
            showYawingProgressView(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_route_plan_yawing_text));
        } else {
            int updateType = b.getInt("updatetype");
            if (updateType == 1) {
                if (b.getBoolean(RGMapModeViewController.KEY_IS_FIRST_GUIDE) && RGSimpleGuideModel.getInstance().isFirstGuideFuzzy()) {
                    showFuzzyGuide(true);
                    return;
                } else if (RGMapModeViewController.getInstance().isFuzzyMode()) {
                    this.mFuzzyTV.setText(RGSimpleGuideModel.getInstance().getFuzzyTV());
                    showFuzzyGuide(true);
                    return;
                } else {
                    int resId = b.getInt("resid", 0);
                    int startDist = b.getInt(SimpleGuideInfo.StartDist, 1);
                    int remainDist = b.getInt(SimpleGuideInfo.RemainDist, 0);
                    this.mRemainDist = remainDist;
                    String nextRoad = b.getString("road_name");
                    LogUtil.m15791e("guide_info", "updateData! --> nextRoadName = " + nextRoad);
                    if (nextRoad == null || nextRoad.length() == 0) {
                        nextRoad = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_no_name_road);
                    }
                    BNEventManager.getInstance().onRoadNameUpdate(nextRoad);
                    if (resId != 0) {
                        try {
                            updateTurnIconAnim(resId);
                            if (RightHandResourcesProvider.getEnNaviType() == 0) {
                                this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(resId));
                            } else {
                                this.mTurnIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(resId));
                            }
                            BNEventManager.getInstance().onRoadTurnInfoIconUpdate(JarUtils.getResources().getDrawable(resId));
                        } catch (OutOfMemoryError e) {
                        }
                    }
                    String frontInfo = RGSimpleGuideModel.getInstance().getFormatAfterMeters(remainDist);
                    String start = RGSimpleGuideModel.getInstance().getDistStart(frontInfo);
                    String end = RGSimpleGuideModel.getInstance().getDistEnd(frontInfo);
                    if (!(this.mAfterMetersInfoTV == null || this.mAfterLabelInfoTV == null || start == null || end == null)) {
                        if (remainDist > 10) {
                            this.mAfterMetersInfoTV.setTextSize(1, 34.0f);
                            this.mAfterMetersInfoTV.setText(start);
                            this.mAfterLabelInfoTV.setText(end + "后");
                        } else {
                            this.mAfterMetersInfoTV.setTextSize(1, 30.0f);
                            this.mAfterMetersInfoTV.setText("现在");
                            this.mAfterLabelInfoTV.setText("");
                        }
                    }
                    BNEventManager.getInstance().onRoadTurnInfoDistanceUpdate(frontInfo);
                    String nextRoadInfo = RGSimpleGuideModel.getInstance().getFormatGoNextRoad(nextRoad);
                    if (!(nextRoadInfo == null || this.mGoWhereInfoTV == null || this.mGoWhereInfoTV.getText().equals(nextRoadInfo))) {
                        this.mGoWhereInfoTV.setText(nextRoadInfo);
                        LogUtil.m15791e("guide_info", "mGoWhereInfoTV.setText --> " + nextRoadInfo);
                    }
                    if (this.mLinkInfoTV != null) {
                        if (RoutePlanParams.TURN_TYPE_ID_END.equals(nextRoad)) {
                            this.mLinkInfoTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_arrive));
                        } else {
                            this.mLinkInfoTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_enter));
                        }
                    }
                    if (this.mConsecutiveIcon != null) {
                        if (RGSimpleGuideModel.getInstance().isShowFollowInfo()) {
                            int iconId = RGSimpleGuideModel.getInstance().getFollowIcon();
                            if (iconId != -1) {
                                if (RightHandResourcesProvider.getEnNaviType() == 0) {
                                    this.mConsecutiveIcon.setImageDrawable(JarUtils.getResources().getDrawable(iconId));
                                } else {
                                    this.mConsecutiveIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(iconId));
                                }
                            }
                            RGViewController.getInstance().requestShowExpendView(7, true, 1);
                            LogUtil.m15791e(RGLaneInfoModel.TAG, "simpleguide true");
                        } else {
                            RGViewController.getInstance().requestShowExpendView(7, false, 1);
                            LogUtil.m15791e(RGLaneInfoModel.TAG, "simpleguide false");
                        }
                    }
                    String curRoadName = b.getString(SimpleGuideInfo.CurRoadName);
                    if (!(this.mCurRoadNameTV == null || curRoadName == null || curRoadName.equals(this.mCurRoadNameTV.getText()))) {
                        this.mCurRoadNameTV.setText(curRoadName);
                    }
                    if (!(this.mCurRoadRemainDistTV == null || start == null)) {
                        this.mCurRoadRemainDistTV.setText(start);
                    }
                    if (!(this.mCurRoadRemainDistWordTV == null || end == null)) {
                        this.mCurRoadRemainDistWordTV.setText(end);
                    }
                    if (RoutePlanModel.sNavNodeList.size() < 3) {
                        this.mHasRemoveCurVia = false;
                    } else if ((resId != 1711407751 && resId != 1711407752) || remainDist >= 120 || remainDist < 0) {
                        this.mHasRemoveCurVia = false;
                    } else if (!this.mHasRemoveCurVia) {
                        this.mHasRemoveCurVia = true;
                        this.mSubViewListener.onOtherAction(10, 0, 0, (RoutePlanNode) RoutePlanModel.sNavNodeList.remove(1));
                    }
                }
            } else if (updateType == 2) {
                Drawable remDistIcon = JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_rem_dist);
                Drawable remTimeIcon = JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_rem_time);
                BNEventManager.getInstance().onRemainDistanceUpdate(RGSimpleGuideModel.getInstance().getTotalRemainDistString(), remDistIcon);
                BNEventManager.getInstance().onRemainTimeUpdate(RGSimpleGuideModel.getInstance().getArriveTimeString(), remTimeIcon);
            }
            showSuitableView();
        }
    }

    private void updateTurnIconAnim(int resId) {
        if (this.mGuideInfoLayout != null) {
            Object res = this.mTurnIcon.getTag();
            if (!(res == null || ((Integer) res).intValue() == resId)) {
                TranslateAnimation mUpdateTurnIconAnim;
                if (RGMapModeViewController.getInstance().getOrientation() == 2) {
                    mUpdateTurnIconAnim = new TranslateAnimation(0.0f, 0.0f, (float) (-ScreenUtil.getInstance().dip2px(50)), 0.0f);
                } else {
                    mUpdateTurnIconAnim = new TranslateAnimation((float) (ScreenUtil.getInstance().getWidthPixels() / 3), 0.0f, 0.0f, 0.0f);
                }
                mUpdateTurnIconAnim.setDuration(400);
                this.mGuideInfoLayout.startAnimation(mUpdateTurnIconAnim);
            }
            this.mTurnIcon.setTag(Integer.valueOf(resId));
        }
    }

    public void updateCurRoadName() {
    }

    public void updateDataByLastest() {
        updateData(RGSimpleGuideModel.getInstance().getNextGuideInfo());
        updateData(RGSimpleGuideModel.getInstance().getTotalInfo());
        updateCurRoadName();
        showSuitableView();
    }

    private void updateConsecutivePointInfo() {
    }

    private void justSetNormalSGInfoVisible(boolean show) {
        int showValue = show ? 0 : 8;
        if (this.mAfterMetersInfoTV != null) {
            this.mAfterMetersInfoTV.setVisibility(showValue);
        }
        if (this.mAfterLabelInfoTV != null) {
            this.mAfterLabelInfoTV.setVisibility(showValue);
        }
        if (this.mLinkInfoTV != null) {
            this.mLinkInfoTV.setVisibility(showValue);
        }
        if (!(this.mGoWhereInfoTV == null || (this.mGoWhereInfoTV.getVisibility() == 0 && showValue == 0))) {
            this.mGoWhereInfoTV.setVisibility(showValue);
        }
        if (this.mTurnIcon != null) {
            this.mTurnIcon.setVisibility(showValue);
        }
    }

    private void justSetAlongRoadInfoVisible(boolean show) {
        int showValue = show ? 0 : 8;
        if (this.mAlongRoadView != null) {
            this.mAlongRoadView.setVisibility(showValue);
        }
        if (this.mTurnIcon != null) {
            this.mTurnIcon.setVisibility(showValue);
        }
    }

    private void justSetGPSLocationInfoVisible(boolean show) {
        int showValue = show ? 0 : 8;
        if (this.mLocationInfoTV != null) {
            this.mLocationInfoTV.setVisibility(showValue);
        }
        if (this.mSatelliteInfoTV != null && this.mSatelliteInfoTV2 != null) {
            this.mSatelliteInfoTV.setVisibility(showValue);
            this.mSatelliteInfoTV2.setVisibility(showValue);
        }
    }

    private void justSetConsecutivePointInfoVisible(boolean show) {
    }

    public void showSuitableView() {
        try {
            if (!BNavigator.getInstance().hasCalcRouteOk() && !RGSimpleGuideModel.getInstance().isFirstDataOk) {
                showWaitCalRouteFinish();
                showSatelliteProgressView();
                LogUtil.m15791e("guide_info", "hasCalcRouteOk -- > false ,  cannot updateData!");
            } else if (RGSimpleGuideModel.getInstance().isYawing()) {
                LogUtil.m15791e("guide_info", "Yawing now! cannot updateData!");
                showYawingProgressView(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_route_plan_yawing_text));
            } else {
                if (BNavConfig.pRGLocateMode == 1 || BNavConfig.pRGLocateMode == 5) {
                    if (!RGSimpleGuideModel.getInstance().isGPSOpened()) {
                        LogUtil.m15791e("guide_info", "showGPSSettingView!");
                        hideSatelliteProgressView();
                        showGPSSettingView();
                        return;
                    } else if (RGSimpleGuideModel.getInstance().isCarlogoFree()) {
                        LogUtil.m15791e("guide_info", "not data route, showCarlogoFreeView!");
                        hideSatelliteProgressView();
                        showCarlogoFreeView();
                        return;
                    }
                }
                hideSatelliteProgressView();
                if (RGSimpleGuideModel.getInstance().isStraight() && this.mTurnIcon != null) {
                    try {
                        this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_turn_along));
                    } catch (Throwable th) {
                    }
                }
                showNormalSGInfoView();
            }
        } catch (Throwable th2) {
        }
    }

    private void showNormalSGInfoView() {
        justSetAlongRoadInfoVisible(false);
        justSetGPSLocationInfoVisible(false);
        justSetNormalSGInfoVisible(true);
        justSetConsecutivePointInfoVisible(false);
    }

    private void showAlongRoadInfoView() {
        justSetGPSLocationInfoVisible(false);
        justSetNormalSGInfoVisible(false);
        justSetAlongRoadInfoVisible(true);
        justSetConsecutivePointInfoVisible(false);
    }

    private void showLocatingView() {
        justSetNormalSGInfoVisible(false);
        justSetAlongRoadInfoVisible(false);
        justSetConsecutivePointInfoVisible(false);
        if (this.mLocationInfoTV != null) {
            this.mLocationInfoTV.setVisibility(8);
        }
    }

    private void showGPSSettingView() {
        justSetNormalSGInfoVisible(false);
        justSetAlongRoadInfoVisible(false);
        justSetConsecutivePointInfoVisible(false);
        if (!(this.mSatelliteInfoTV == null || this.mSatelliteInfoTV2 == null)) {
            this.mSatelliteInfoTV.setVisibility(8);
            this.mSatelliteInfoTV2.setVisibility(8);
        }
        if (this.mLocationInfoTV != null) {
            this.mProgressLayout.setVisibility(0);
            this.mLocationInfoTV.setVisibility(0);
            this.mLocationInfoTV.setText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_sg_open_gps));
        }
    }

    private void showCarlogoFreeView() {
        justSetNormalSGInfoVisible(false);
        justSetAlongRoadInfoVisible(false);
        justSetConsecutivePointInfoVisible(false);
        if (!(this.mSatelliteInfoTV == null || this.mSatelliteInfoTV2 == null)) {
            this.mSatelliteInfoTV.setVisibility(8);
            this.mSatelliteInfoTV2.setVisibility(8);
        }
        if (this.mLocationInfoTV != null) {
            this.mProgressLayout.setVisibility(0);
            this.mLocationInfoTV.setVisibility(0);
            this.mLocationInfoTV.setText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_carlogo_free));
        }
    }

    private void showWaitCalRouteFinish() {
        justSetNormalSGInfoVisible(false);
        justSetAlongRoadInfoVisible(false);
        justSetConsecutivePointInfoVisible(false);
        if (!(this.mSatelliteInfoTV == null || this.mSatelliteInfoTV2 == null)) {
            this.mSatelliteInfoTV.setVisibility(8);
            this.mSatelliteInfoTV2.setVisibility(8);
        }
        if (this.mLocationInfoTV != null) {
            this.mProgressLayout.setVisibility(0);
            this.mLocationInfoTV.setVisibility(0);
            if (RGSimpleGuideModel.getInstance().isCalcRouteFail) {
                this.mLocationInfoTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_is_wait_recalc_route));
            } else {
                this.mLocationInfoTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_is_preparing_nav));
            }
        }
    }

    public int getSPViewHeight() {
        if (this.mSimpleGuideView != null) {
            return this.mSimpleGuideView.getHeight();
        }
        return 0;
    }

    public int getSBViewHeight() {
        if (this.mStatusBar != null) {
            return this.mStatusBar.getHeight();
        }
        return 0;
    }

    public void show() {
        super.show();
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.setVisibility(0);
            if (!RGViewController.getInstance().isDeviceStateViewShowing()) {
                RGViewController.getInstance().showDeviceStateView();
            }
        }
    }

    public void hide() {
        super.hide();
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.setVisibility(8);
        }
        if (this.mConsecutivePointTV != null) {
            this.mConsecutivePointTV.setVisibility(8);
        }
    }

    public void showLandspaceLeftPanel() {
        if (this.mLandspaceLeftPanel != null) {
            this.mLandspaceLeftPanel.setVisibility(0);
        }
    }

    public void hideLandspaceLeftPanel() {
        if (this.mLandspaceLeftPanel != null) {
            this.mLandspaceLeftPanel.setVisibility(4);
        }
    }

    public void dispose() {
        super.dispose();
        UIUtils.releaseImageView(this.mTurnIcon);
    }

    public String debugViewState() {
        String viewState = "";
        if (this.mTurnIcon != null) {
            viewState = viewState + " icon: " + this.mTurnIcon.getVisibility();
        }
        if (this.mAfterMetersInfoTV != null) {
            viewState = viewState + " AfterM: " + this.mAfterMetersInfoTV.getVisibility();
        }
        if (this.mGoWhereInfoTV != null) {
            viewState = viewState + " GoWhere: " + this.mGoWhereInfoTV.getVisibility();
        }
        if (this.mAlongRoadView != null) {
            viewState = viewState + " AlongR: " + this.mAlongRoadView.getVisibility();
        }
        if (this.mLocationInfoTV != null) {
            viewState = viewState + " Location: " + this.mLocationInfoTV.getVisibility();
        }
        if (this.mSatelliteInfoTV != null) {
            viewState = viewState + " Satellite: " + this.mSatelliteInfoTV.getVisibility();
        }
        if (this.mSatelliteInfoTV2 != null) {
            return viewState + " Satellite2: " + this.mSatelliteInfoTV2.getVisibility();
        }
        return viewState;
    }

    public void showSatelliteProgressView() {
        LogUtil.m15791e("guide_info", "showSatelliteProgressView -- ");
        if (this.mProgress != null) {
            this.mProgressLayout.setVisibility(0);
            this.mProgress.setVisibility(0);
            if (this.mAnim == null) {
                this.mAnim = BNStyleManager.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_satellite_progress_wait);
            }
            LinearInterpolator lin = new LinearInterpolator();
            if (lin != null) {
                this.mAnim.setInterpolator(lin);
            }
            if (this.mAnim != null) {
                this.mProgress.startAnimation(this.mAnim);
            }
        }
    }

    public void hideSatelliteProgressView() {
        if (this.mProgress != null && this.mProgress.getVisibility() == 0) {
            this.mProgressLayout.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.mProgress.clearAnimation();
        }
    }

    public void showYawingProgressView(String text) {
        LogUtil.m15791e("guide_info", "showYawingProgressView()");
        justSetNormalSGInfoVisible(false);
        justSetAlongRoadInfoVisible(false);
        justSetConsecutivePointInfoVisible(false);
        if (!(this.mSatelliteInfoTV == null || this.mSatelliteInfoTV2 == null)) {
            this.mSatelliteInfoTV.setVisibility(8);
            this.mSatelliteInfoTV2.setVisibility(8);
        }
        if (this.mLocationInfoTV != null) {
            this.mProgressLayout.setVisibility(0);
            this.mLocationInfoTV.setVisibility(0);
            this.mLocationInfoTV.setText(text);
            showSatelliteProgressView();
        }
    }

    public View getRootView() {
        if (this.mPortraitTopPanel != null) {
            return this.mPortraitTopPanel;
        }
        if (this.mLandspaceLeftPanel != null) {
            return this.mLandspaceLeftPanel;
        }
        return null;
    }

    public void showFuzzyGuide(boolean fuzzy) {
        if (fuzzy) {
            this.mFuzzyLayout.setVisibility(0);
            this.mGuideInfoLayout.setVisibility(8);
            this.mConsecutivePointTV.setVisibility(8);
            this.mProgressLayout.setVisibility(8);
            this.mFuzzyTV.setText(RGSimpleGuideModel.getInstance().getFuzzyTV());
        } else {
            this.mFuzzyLayout.setVisibility(8);
            this.mProgressLayout.setVisibility(0);
            this.mGuideInfoLayout.setVisibility(0);
            this.mConsecutivePointTV.setVisibility(0);
        }
        RGViewController.getInstance().setMapDrawScreenRect();
    }
}
