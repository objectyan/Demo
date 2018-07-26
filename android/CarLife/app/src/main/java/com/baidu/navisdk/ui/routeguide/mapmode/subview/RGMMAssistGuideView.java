package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel.AssistInfo;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.ui.routeguide.subview.widget.RGRoadConditionView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.map.MapSwitchGLSurfaceView;

public class RGMMAssistGuideView extends BNBaseView {
    public static final String TAG = RGMMAssistGuideView.class.getSimpleName();
    private static final int[] mProgressViewID = new int[]{C4048R.id.bnav_rg_assist_top0_progressbar, C4048R.id.bnav_rg_assist_top1_progressbar, C4048R.id.bnav_rg_assist_top2_progressbar};
    private View mAssistPanel = null;
    private CircleProgressImageView[] mAssistProgressView;
    private TextView mCurCarSpeedView = null;
    private View mCurCarSpeedViewRl = null;
    private TextView mCurCarSpeedViewTv = null;
    private Callback mDrawCallback;
    private View mFullViewModeBtn = null;
    private ImageView mFullViewModeIv = null;
    private TextView mFullViewModeText = null;
    private MapSwitchGLSurfaceView mMapSwitchSurfaceView;
    private LinearLayout mMapSwitchlayout = null;
    private View mRoadConditionBarLayout = null;
    private RGRoadConditionView mRoadConditionView = null;
    private View ugcBtnLayout = null;
    private ImageView ugcIcon;
    private TextView ugcTv;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMAssistGuideView$1 */
    class C43531 implements OnClickListener {
        C43531() {
        }

        public void onClick(View v) {
            if (RGControlPanelModel.getInstance().getFullviewState()) {
                if (RGMMAssistGuideView.this.mSubViewListener != null) {
                    RGMMAssistGuideView.this.mSubViewListener.onOtherAction(3, 0, 0, null);
                }
            } else if (RGMMAssistGuideView.this.mSubViewListener != null) {
                RGMMAssistGuideView.this.mSubViewListener.onFullviewAction();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMAssistGuideView$2 */
    class C43542 implements OnClickListener {
        C43542() {
        }

        public void onClick(View v) {
            LogUtil.m15791e(RGMMAssistGuideView.TAG, "mMapSwitchlayout onClick ==");
            UserOPController.getInstance().add("3.3");
            if (RGControlPanelModel.getInstance().getFullviewState()) {
                if (RGMMAssistGuideView.this.mSubViewListener != null) {
                    RGMMAssistGuideView.this.mSubViewListener.onOtherAction(3, 0, 0, null);
                }
            } else if (RGMMAssistGuideView.this.mSubViewListener != null) {
                RGMMAssistGuideView.this.mSubViewListener.onFullviewAction();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMAssistGuideView$3 */
    class C43553 implements OnTouchListener {
        C43553() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == 0 && !ForbidDaulClickUtils.isFastDoubleClick()) {
                RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_u, "5", null, null);
                if (RGMMAssistGuideView.this.mSubViewListener != null) {
                    RGMMAssistGuideView.this.mSubViewListener.onUGCMenuAction();
                }
                RGViewController.getInstance().autoHideControlPanelView(10000);
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMAssistGuideView$4 */
    class C43564 implements OnClickListener {
        C43564() {
        }

        public void onClick(View v) {
        }
    }

    public RGMMAssistGuideView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        updateDataByLastest();
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        updateDataByLastest();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            ViewStub stub = (ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_intervene_ly_stub);
            if (stub != null) {
                stub.inflate();
            }
            this.mAssistPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_assist_panel);
            this.mCurCarSpeedView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_cur_car_speed);
            this.mCurCarSpeedViewRl = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_cur_car_speed_rl);
            this.mCurCarSpeedViewTv = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_cur_car_speed_tv);
            this.ugcBtnLayout = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_ugc_report_innavi);
            this.ugcIcon = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ic_ugc_report_iv_innavi);
            this.ugcTv = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ic_ugc_report_tv_innavi);
            this.mRoadConditionBarLayout = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_roadconditionbar_ly);
            if (this.mRoadConditionView != null) {
                this.mRoadConditionView.recycle();
                this.mRoadConditionView = null;
            }
            this.mRoadConditionView = (RGRoadConditionView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_roadconditionbar);
            this.mFullViewModeIv = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_fullview_mode_iv);
            this.mFullViewModeText = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_fullview_mode_tv);
            this.mFullViewModeBtn = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_fullview_mode_btn);
            this.mFullViewModeBtn.setOnClickListener(new C43531());
            this.mMapSwitchlayout = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_cp_map_switch);
            this.mMapSwitchlayout.setOnClickListener(new C43542());
            if (BNavConfig.pRGLocateMode == 2) {
                if (this.mMapSwitchlayout != null) {
                    this.mMapSwitchlayout.setVisibility(8);
                }
                if (this.mMapSwitchSurfaceView != null) {
                    this.mMapSwitchSurfaceView.setVisibility(8);
                }
                if (this.mRoadConditionBarLayout != null) {
                    this.mRoadConditionBarLayout.setVisibility(8);
                }
            } else {
                showMapSwitchOrRoadBar(true);
            }
            this.mAssistProgressView = new CircleProgressImageView[3];
            for (int i = 0; i < this.mAssistProgressView.length; i++) {
                this.mAssistProgressView[i] = (CircleProgressImageView) this.mRootViewGroup.findViewById(mProgressViewID[i]);
                this.mAssistProgressView[i].setVisibility(8);
            }
            this.ugcBtnLayout.setOnTouchListener(new C43553());
            this.ugcBtnLayout.setOnClickListener(new C43564());
        }
    }

    public void updateData(Bundle data) {
        if (!FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState()) && !FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            int assistIndex = -1;
            if (data != null && data.containsKey(RGAssistGuideModel.KEY_ASSIST_INDEX)) {
                assistIndex = data.getInt(RGAssistGuideModel.KEY_ASSIST_INDEX);
            }
            if (assistIndex < 0 || assistIndex >= this.mAssistProgressView.length) {
                showCameraView(false);
                return;
            }
            AssistInfo ai = RGAssistGuideModel.getInstance().getAssistInfo(assistIndex);
            if (ai != null) {
                updateAssistInfoView(assistIndex, ai);
            }
        }
    }

    private void updateAssistInfoView(int assistIndex, AssistInfo ai) {
        if (assistIndex >= 0 && assistIndex < this.mAssistProgressView.length) {
            switch (ai.mUpdateType) {
                case 1:
                    LogUtil.m15791e(TAG, "AssistantIconUpdate UPDATE_TYPE_SHOW! nAssistType:" + ai.mAssistType + ",nSpeed:" + ai.mSpeedLimit);
                    setAssistView(assistIndex, ai);
                    return;
                case 2:
                    LogUtil.m15791e(TAG, "AssistantIconUpdate UPDATE_TYPE_UPDATE! nAssistType:" + ai.mAssistType + ",nSpeed:" + ai.mSpeedLimit);
                    updateAssistProgress(assistIndex, ai.mAssistType, ai.mProgress);
                    if (NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState())) {
                        this.mAssistProgressView[assistIndex].setVisibility(0);
                        return;
                    } else {
                        this.mAssistProgressView[assistIndex].setVisibility(8);
                        return;
                    }
                case 3:
                    LogUtil.m15791e(TAG, "AssistantIconUpdate UPDATE_TYPE_HIDE! nAssistType:" + ai.mAssistType + ",nSpeed:" + ai.mSpeedLimit);
                    this.mAssistProgressView[assistIndex].setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    public void updateDataByLastest() {
        for (int i = 0; i < 3; i++) {
            AssistInfo ai = RGAssistGuideModel.getInstance().getAssistInfo(i);
            AssistInfo newAI = null;
            if (ai != null) {
                newAI = ai.cloneTo();
            }
            if (newAI != null && (2 == newAI.mUpdateType || 1 == newAI.mUpdateType)) {
                newAI.mUpdateType = 1;
                updateAssistInfoView(i, newAI);
            }
        }
        updateCarProgress();
        updateRoadConditionBar();
        updateCurCarSpeed();
    }

    public void updateCurCarSpeed() {
        if (this.mCurCarSpeedView != null && this.mCurCarSpeedViewRl != null && this.mCurCarSpeedViewTv != null) {
            this.mCurCarSpeedView.setText(RGAssistGuideModel.getInstance().getCurCarSpeed());
            if (RGAssistGuideModel.getInstance().isOverSpeed() && RGAssistGuideModel.getInstance().isCarSpeedRight()) {
                this.mCurCarSpeedView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_b));
                this.mCurCarSpeedViewTv.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_b));
                this.mCurCarSpeedViewRl.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_assist_over_speed));
                return;
            }
            this.mCurCarSpeedView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
            this.mCurCarSpeedViewTv.setTextColor(BNStyleManager.getColor(C4048R.color.cl_link_a));
            this.mCurCarSpeedViewRl.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_assist_normal_speed));
        }
    }

    public void setAssistContainerVisible() {
        if (BNavigator.getInstance().hasCalcRouteOk() && this.mAssistPanel != null) {
            this.mAssistPanel.setVisibility(0);
        }
    }

    public void show() {
        super.show();
        if (BNavigator.getInstance().hasCalcRouteOk()) {
            if (this.mAssistPanel != null) {
                this.mAssistPanel.setVisibility(0);
            }
            if (!(this.mCurCarSpeedViewRl == null || this.ugcBtnLayout == null)) {
                if (BNavConfig.pRGLocateMode == 2) {
                    this.mCurCarSpeedViewRl.setVisibility(8);
                    this.ugcBtnLayout.setVisibility(8);
                } else {
                    this.mCurCarSpeedViewRl.setVisibility(0);
                    if (RGMapModeViewController.getInstance().isShowingUgcBtnLayout) {
                    }
                }
            }
            showMapSwitchOrRoadBar();
        }
    }

    public void showCameraView(boolean show) {
        int showValue = show ? 0 : 8;
        for (CircleProgressImageView visibility : this.mAssistProgressView) {
            visibility.setVisibility(showValue);
        }
        if (show) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_AIDINFOPANNEL, NaviStatConstants.NAVIGATION_AIDINFOPANNEL);
        }
    }

    public void hide() {
        super.hide();
        if (this.mAssistPanel != null) {
            this.mAssistPanel.setVisibility(8);
        }
        if (!(this.mCurCarSpeedViewRl == null || this.ugcBtnLayout == null)) {
            this.mCurCarSpeedViewRl.setVisibility(8);
            this.ugcBtnLayout.setVisibility(8);
        }
        showCameraView(false);
        showMapSwitchOrRoadBar(false);
    }

    public void hideAssistView() {
        if (!(this.mCurCarSpeedViewRl == null || this.ugcBtnLayout == null)) {
            this.mCurCarSpeedViewRl.setVisibility(8);
            this.ugcBtnLayout.setVisibility(8);
        }
        showCameraView(false);
        showMapSwitchOrRoadBar(false);
    }

    private void setAssistView(int assistIndex, AssistInfo ai) {
        if (assistIndex >= 0 && assistIndex < this.mAssistProgressView.length && ai != null && ai.mIconResId > 0) {
            this.mAssistProgressView[assistIndex].setMainProgress(ai.mProgress);
            if (NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState())) {
                this.mAssistProgressView[assistIndex].setVisibility(0);
            } else {
                this.mAssistProgressView[assistIndex].setVisibility(8);
            }
            if (ai.mAssistType == 8) {
                this.mAssistProgressView[assistIndex].setBeamHeight(0);
                this.mAssistProgressView[assistIndex].setText((ai.mSpeedLimit / 1000) + "");
            } else if (ai.mAssistType == 11) {
                this.mAssistProgressView[assistIndex].setBeamHeight(0);
                this.mAssistProgressView[assistIndex].setText((ai.mSpeedLimit / 1000) + "");
            } else {
                this.mAssistProgressView[assistIndex].setBeamHeight(0);
                this.mAssistProgressView[assistIndex].setText("");
            }
            this.mAssistProgressView[assistIndex].setImageDrawable(BNStyleManager.getDrawable(ai.mIconResId));
        }
    }

    private void updateAssistProgress(int assistIndex, int nAssistType, int progress) {
        if (this.mAssistProgressView[assistIndex] != null) {
            this.mAssistProgressView[assistIndex].setMainProgress(progress);
        }
    }

    public void showMapSwitchOrRoadBar() {
        if (BNavConfig.pRGLocateMode == 2) {
            showMapSwitchOrRoadBar(false);
        } else {
            showMapSwitchOrRoadBar(true);
        }
    }

    public void hideMapSwitchOrRoadBar() {
        showMapSwitchOrRoadBar(false);
    }

    private void showMapSwitchOrRoadBar(boolean show) {
        boolean isMapSwitchShow;
        boolean isRoadBarShow = true;
        LogUtil.m15791e(TAG, "showMapSwitchOrRoadBar : " + show);
        if (show && BNSettingManager.getIsShowMapSwitch() == 0) {
            isMapSwitchShow = true;
        } else {
            isMapSwitchShow = false;
        }
        if (!(show && BNSettingManager.getIsShowMapSwitch() == 1)) {
            isRoadBarShow = false;
        }
        if (BNavigator.getInstance().hasCalcRouteOk()) {
            int i;
            if (!(this.mMapSwitchlayout == null || this.mMapSwitchSurfaceView == null)) {
                this.mMapSwitchlayout.setVisibility(isMapSwitchShow ? 0 : 8);
                MapSwitchGLSurfaceView mapSwitchGLSurfaceView = this.mMapSwitchSurfaceView;
                if (isMapSwitchShow) {
                    i = 0;
                } else {
                    i = 8;
                }
                mapSwitchGLSurfaceView.setVisibility(i);
            }
            if (this.mRoadConditionBarLayout != null) {
                View view = this.mRoadConditionBarLayout;
                if (isRoadBarShow) {
                    i = 0;
                } else {
                    i = 8;
                }
                view.setVisibility(i);
                if (isRoadBarShow && RGControlPanelModel.getInstance().getFullviewState()) {
                    RGViewController.getInstance().setRoadConditionBarVisible(8);
                    return;
                } else if (!isRoadBarShow) {
                    this.mRoadConditionView.setVisibility(0);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        if (!(this.mMapSwitchlayout == null || this.mMapSwitchSurfaceView == null)) {
            this.mMapSwitchlayout.setVisibility(8);
            this.mMapSwitchSurfaceView.setVisibility(8);
        }
        if (this.mRoadConditionBarLayout != null) {
            this.mRoadConditionBarLayout.setVisibility(8);
        }
    }

    public void miniRequestRender(boolean forceRender) {
        if (this.mMapSwitchSurfaceView == null) {
            return;
        }
        if (forceRender) {
            this.mMapSwitchSurfaceView.requestRender();
        } else if (this.mMapSwitchlayout != null && this.mMapSwitchlayout.getVisibility() == 0) {
            this.mMapSwitchSurfaceView.requestRender();
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.ugcBtnLayout != null) {
            this.ugcBtnLayout.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.bnav_common_cp_button_selector));
        }
        if (this.ugcIcon != null) {
            this.ugcIcon.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_rg_ic_ugc_report_innavi));
        }
        if (this.ugcTv != null) {
            this.ugcTv.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_ugc_report_txt_color_innavi));
        }
        if (this.mFullViewModeBtn != null) {
            this.mFullViewModeBtn.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_cp_button_selector));
        }
        if (this.mFullViewModeIv != null) {
            this.mFullViewModeIv.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_ic_fullview_mode));
        }
        if (this.mFullViewModeText != null) {
            this.mFullViewModeText.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_h));
        }
    }

    public boolean isShowingUgcBtnLayout() {
        if (this.ugcBtnLayout != null && this.ugcBtnLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void showUgcBtnLayout(boolean show) {
        if (this.ugcBtnLayout != null) {
            LogUtil.m15791e(TAG, "showUgcBtnLayout: show --> " + show);
            if (!show) {
                this.ugcBtnLayout.setVisibility(8);
            }
        }
    }

    public void dispose() {
        if (this.mMapSwitchlayout != null) {
            this.mMapSwitchlayout.removeAllViews();
        }
        if (this.mMapSwitchSurfaceView != null) {
            this.mMapSwitchSurfaceView = null;
        }
        super.dispose();
    }

    public void initMiniMap(MapSwitchGLSurfaceView mapSwitchGLSurfaceView) {
        releaseMiniMap();
        this.mMapSwitchSurfaceView = mapSwitchGLSurfaceView;
        if (this.mMapSwitchSurfaceView.getParent() != null) {
            ((ViewGroup) this.mMapSwitchSurfaceView.getParent()).removeView(this.mMapSwitchSurfaceView);
        }
        LayoutParams lp = new LayoutParams(-1, -1);
        if (this.mMapSwitchlayout != null) {
            this.mMapSwitchlayout.addView(this.mMapSwitchSurfaceView, lp);
            this.mMapSwitchlayout.requestLayout();
        }
        if (BNavConfig.pRGLocateMode == 2) {
            if (this.mMapSwitchlayout != null) {
                this.mMapSwitchlayout.setVisibility(8);
            }
            if (this.mMapSwitchSurfaceView != null) {
                this.mMapSwitchSurfaceView.setVisibility(8);
            }
        }
    }

    public void releaseMiniMap() {
        if (!(this.mMapSwitchlayout == null || this.mMapSwitchSurfaceView == null)) {
            this.mMapSwitchlayout.removeView(this.mMapSwitchSurfaceView);
        }
        if (this.mMapSwitchSurfaceView != null) {
            this.mMapSwitchSurfaceView = null;
        }
    }

    public void resetRoadConditionData() {
        if (this.mRoadConditionView != null) {
            this.mRoadConditionView.resetRoadConditionData();
        }
    }

    public void updateRoadConditionBar() {
        if (this.mRoadConditionView != null) {
            this.mRoadConditionView.updateCarProgress(RGAssistGuideModel.getInstance().getCarProgress());
            this.mRoadConditionView.updateRoadConditionData(RGAssistGuideModel.getInstance().getRoadConditionData());
            this.mRoadConditionView.invalidate();
        }
    }

    public void updateRoadConditionBarTimeInterval() {
        if (this.mRoadConditionView != null && RGAssistGuideModel.getInstance().isTimeToRefreshRoadCondition()) {
            this.mRoadConditionView.updateCarProgress(RGAssistGuideModel.getInstance().getCarProgress());
            this.mRoadConditionView.updateRoadConditionData(RGAssistGuideModel.getInstance().getRoadConditionData());
            this.mRoadConditionView.invalidate();
        }
    }

    public void updateCarProgress() {
        if (this.mRoadConditionView != null) {
            this.mRoadConditionView.updateCarProgress(RGAssistGuideModel.getInstance().getCarProgress());
            this.mRoadConditionView.invalidate();
        }
    }

    public void updateAssistFullViewModeBtn() {
        if (this.mFullViewModeBtn != null) {
            if (RGControlPanelModel.getInstance().getFullviewState()) {
                this.mFullViewModeText.setText("退出全览");
            } else {
                this.mFullViewModeText.setText("全览");
            }
        }
    }

    public void setRoadConditionBarVisible(int visible) {
        if (this.mRoadConditionView != null) {
            this.mRoadConditionView.setVisibility(visible);
        }
    }
}
