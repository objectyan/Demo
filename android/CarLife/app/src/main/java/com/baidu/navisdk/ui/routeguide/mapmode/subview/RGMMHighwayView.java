package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMHighwayView extends BNBaseView {
    private static String TAG = "Highway";
    private TextView mAfterLabelInfoTV = null;
    private TextView mAfterMetersMultiTV = null;
    private TextView mArriveTimeTV = null;
    private TextView mCurRoadNameTV = null;
    private TextView mCurRoadRemainDistTV = null;
    private TextView mCurRoadRemainDistWordTV = null;
    private int mCurTurnIconType = -1;
    private TextView mDirectionTV = null;
    private View mExitDirectionsPanel = null;
    private ImageView mExitTurnIcon = null;
    private TextView mGoWhereInfoMultiTV = null;
    private View mHighwayAlongMode = null;
    private View mHighwayDirectionMode = null;
    private View mHighwayView = null;
    private ViewGroup mHighwayViewContainer = null;
    private ViewGroup mHighwayViewLayout = null;
    private ViewGroup mHighwayViewMiniLayout = null;
    private TextView mICCodeTV = null;
    private String mLastArriveTimeS = "";
    private int mLastSateliteNum = -1;
    private String mLastTotalRemainDistS = "";
    private TextView mMiniAfterMetersMultiTv;
    private LinearLayout mMiniAlongMode;
    private TextView mMiniCurRoadDistTv;
    private TextView mMiniCurRoadDistWordTv;
    private TextView mMiniCurRoadNameTv;
    private RelativeLayout mMiniDirectionMode;
    private TextView mMiniDirectionTv;
    private TextView mMiniGoWhereMultiTv;
    private float mMiniPanerDownY;
    private ImageView mMiniTurnIcon;
    private TextView mTotalDistTV = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMHighwayView$1 */
    class C43781 implements OnClickListener {
        C43781() {
        }

        public void onClick(View arg0) {
            if (2 != BNavConfig.pRGLocateMode) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_8);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMHighwayView$2 */
    class C43792 implements OnTouchListener {
        C43792() {
        }

        public boolean onTouch(View arg0, MotionEvent event) {
            RGMMHighwayView.this.miniPanerCutAction(arg0, event);
            return true;
        }
    }

    public RGMMHighwayView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
    }

    private void initViews() {
        boolean visible = true;
        if (this.mRootViewGroup != null) {
            this.mHighwayViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_highway_container);
            if (this.mHighwayViewContainer != null) {
                this.mHighwayViewContainer.removeAllViews();
                if (1 == RGViewController.getInstance().getPreloadOrientation()) {
                    this.mCurOrientation = 1;
                    this.mHighwayView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_highway, null);
                } else {
                    this.mCurOrientation = 2;
                    this.mHighwayView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_highway_land, null);
                }
                if (this.mHighwayView != null) {
                    LayoutParams lp;
                    if (1 == RGViewController.getInstance().getPreloadOrientation()) {
                        lp = new LayoutParams(-1, -2);
                    } else {
                        lp = new LayoutParams(-1, -1);
                    }
                    this.mHighwayViewContainer.addView(this.mHighwayView, lp);
                    this.mHighwayViewContainer.requestLayout();
                    this.mHighwayDirectionMode = this.mHighwayView.findViewById(C4048R.id.bnav_rg_hg_direction_mode);
                    this.mTotalDistTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_total_dist);
                    this.mArriveTimeTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_sg_arrive_time);
                    this.mExitTurnIcon = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_turn_icon);
                    this.mExitDirectionsPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_go_where_panel);
                    this.mGoWhereInfoMultiTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_go_where_multi_tv);
                    if (RGViewController.getInstance().getPreloadOrientation() == 2) {
                        LinearLayout.LayoutParams layoutPrams = (LinearLayout.LayoutParams) this.mGoWhereInfoMultiTV.getLayoutParams();
                        layoutPrams.gravity = 1;
                        layoutPrams.width = ScreenUtil.getInstance().getGuidePanelWidth();
                        this.mGoWhereInfoMultiTV.setLayoutParams(layoutPrams);
                    }
                    this.mAfterMetersMultiTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_after_meters_multi_tv);
                    this.mAfterLabelInfoTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_after_label_info);
                    this.mICCodeTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_ic_code);
                    this.mDirectionTV = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_hw_direction);
                    if (this.mExitTurnIcon != null) {
                        this.mExitTurnIcon.setOnClickListener(new C43781());
                    }
                    if (this.mHighwayView != null) {
                        this.mHighwayView.setOnTouchListener(new C43792());
                    }
                    if (1 == RGViewController.getInstance().getPreloadOrientation()) {
                        this.mHighwayViewLayout = (ViewGroup) this.mHighwayView.findViewById(C4048R.id.bnav_defaul_layout);
                    }
                    this.mHighwayAlongMode = this.mHighwayView.findViewById(C4048R.id.bnav_rg_hg_along_mode);
                    this.mCurRoadNameTV = (TextView) this.mHighwayView.findViewById(C4048R.id.bnav_rg_hg_cur_road_name_tv);
                    this.mCurRoadRemainDistTV = (TextView) this.mHighwayView.findViewById(C4048R.id.bnav_rg_hg_cur_road_remain_dist_tv);
                    this.mCurRoadRemainDistWordTV = (TextView) this.mHighwayView.findViewById(C4048R.id.bnav_rg_hg_cur_road_remain_dist_word);
                    if (RGViewController.getInstance().getPreloadOrientation() == 1) {
                        if (RGHighwayModel.getInstance().getCurrentPanerMode() == 0) {
                            visible = false;
                        }
                        showMiniPaner(visible);
                    }
                    updateDataByLastest();
                }
            }
        }
    }

    private void miniPanerCutAction(View arg0, MotionEvent event) {
        boolean visible = true;
        if (RGViewController.getInstance().getPreloadOrientation() != 1) {
            return;
        }
        if (event.getAction() == 0) {
            if (RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
                this.mMiniPanerDownY = event.getRawY();
                LogUtil.m15791e(TAG, "mMiniPanerDownY = " + this.mMiniPanerDownY);
            }
        } else if (event.getAction() == 1 && RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
            float moveDis = event.getRawY() - this.mMiniPanerDownY;
            LogUtil.m15791e(TAG, "moveDis = " + moveDis);
            if (moveDis > 30.0f) {
                LogUtil.m15791e(TAG, " pull-down paner, mAutoShowMiniPanerAble = false");
                showMiniPaner(false);
                RGHighwayModel.getInstance().setAutoShowMiniPanerAble(false);
            } else if (moveDis < -30.0f) {
                LogUtil.m15791e(TAG, "pull-up paner");
                showMiniPaner(true);
            } else if (Math.abs(moveDis) <= 10.0f) {
                if (ismMiniPanelShowing()) {
                    visible = false;
                }
                showMiniPaner(visible);
                RGHighwayModel.getInstance().setAutoShowMiniPanerAble(false);
                LogUtil.m15791e(TAG, "click paner, mAutoShowMiniPanerAble = false");
            }
        }
    }

    public void updateData(Bundle b) {
        if (RouteGuideFSM.getInstance().getCurrentEvent() == null || !RouteGuideFSM.getInstance().getCurrentEvent().equals(FsmEvent.MSG_YAWING_START)) {
            int i;
            this.mCurTurnIconType = RGHighwayModel.getInstance().getExitTurnIconType();
            String afterMetersS = RGHighwayModel.getInstance().getFormatExitRemainDist();
            String start = RGSimpleGuideModel.getInstance().getDistStart(afterMetersS);
            String end = RGSimpleGuideModel.getInstance().getDistEnd(afterMetersS);
            String direction = RGHighwayModel.getInstance().formatDirections();
            if (this.mHighwayAlongMode != null) {
                this.mHighwayAlongMode.setVisibility(direction == null ? 0 : 8);
            }
            if (this.mHighwayDirectionMode != null) {
                View view = this.mHighwayDirectionMode;
                if (direction == null) {
                    i = 8;
                } else {
                    i = 0;
                }
                view.setVisibility(i);
            }
            if (ismMiniPanelShowing()) {
                if (this.mMiniDirectionMode != null) {
                    RelativeLayout relativeLayout = this.mMiniDirectionMode;
                    if (direction == null) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                    relativeLayout.setVisibility(i);
                }
                if (this.mMiniAlongMode != null) {
                    LinearLayout linearLayout = this.mMiniAlongMode;
                    if (direction == null) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    linearLayout.setVisibility(i);
                }
            }
            updateTotalRemainInfo();
            switchMiniPanelVisible();
            if (direction == null) {
                if (this.mCurRoadNameTV != null) {
                    this.mCurRoadNameTV.setText(RGHighwayModel.getInstance().getCurRoadName());
                }
                if (this.mCurRoadRemainDistTV != null) {
                    this.mCurRoadRemainDistTV.setText(start);
                }
                if (this.mCurRoadRemainDistWordTV != null) {
                    this.mCurRoadRemainDistWordTV.setText(end);
                }
                if (RGViewController.getInstance().getPreloadOrientation() == 1 && RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
                    initMiniPaner();
                    if (this.mMiniCurRoadNameTv != null && this.mMiniCurRoadDistTv != null && this.mMiniCurRoadDistWordTv != null) {
                        this.mMiniCurRoadNameTv.setText(RGHighwayModel.getInstance().getCurRoadName());
                        this.mMiniCurRoadDistTv.setText(start);
                        this.mMiniCurRoadDistWordTv.setText(end);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(this.mAfterMetersMultiTV == null || this.mAfterLabelInfoTV == null || start == null || end == null)) {
                this.mAfterMetersMultiTV.setText(start);
                this.mAfterLabelInfoTV.setText(end + "后");
            }
            if (RGViewController.getInstance().getPreloadOrientation() == 1) {
                if (!(RGHighwayModel.getInstance().hasExitCode() || this.mDirectionTV == null)) {
                    this.mDirectionTV.setVisibility(0);
                }
                if (!(this.mGoWhereInfoMultiTV == null || direction == null)) {
                    this.mGoWhereInfoMultiTV.setText(subDirectionText(this.mGoWhereInfoMultiTV, getGoWhereViewWidth(), direction, 1));
                    this.mGoWhereInfoMultiTV.setVisibility(0);
                }
                if (RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
                    initMiniPaner();
                    if (this.mMiniTurnIcon != null && this.mMiniGoWhereMultiTv != null && this.mMiniAfterMetersMultiTv != null && this.mMiniDirectionTv != null && start != null && end != null) {
                        this.mMiniAfterMetersMultiTv.setText(start + end + "后");
                        setMiniDirectionText(direction);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mDirectionTV != null) {
                this.mDirectionTV.setVisibility(8);
            }
            SpannableStringBuilder builder = getSpannableStringBuilder(subDirectionText(this.mGoWhereInfoMultiTV, getGoWhereViewWidth(), direction + "  " + JarUtils.getResources().getString(C4048R.string.bnav_string_hw_direction), 2));
            if (this.mGoWhereInfoMultiTV != null && builder != null) {
                this.mGoWhereInfoMultiTV.setMaxLines(2);
                this.mGoWhereInfoMultiTV.setText(builder);
                this.mGoWhereInfoMultiTV.setVisibility(0);
            }
        }
    }

    private void switchMiniPanelVisible() {
        if (RGViewController.getInstance().getPreloadOrientation() != 1 || !RGHighwayModel.getInstance().isAutoShowMiniPanerAble()) {
            return;
        }
        if (!RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
            showMiniPaner(false);
        } else if (FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
            LogUtil.m15791e(TAG, "FsmState = BrowseMap miniPaner, don't show!");
        } else {
            String afterMetersS = RGHighwayModel.getInstance().getFormatExitRemainDist();
            String start = RGSimpleGuideModel.getInstance().getDistStart(afterMetersS);
            String end = RGSimpleGuideModel.getInstance().getDistEnd(afterMetersS);
            if (start != null && end != null) {
                RGMapModeViewController.getInstance().hideDeviceStateView();
                if (!ismMiniPanelShowing()) {
                    showMiniPaner(true);
                }
            }
        }
    }

    private void setMiniDirectionText(final String direction) {
        if (this.mMiniGoWhereMultiTv != null) {
            this.mMiniGoWhereMultiTv.post(new Runnable() {
                public void run() {
                    int miniDirectionMaxWidth = RGMMHighwayView.this.getMiniDirectionWidth();
                    RGMMHighwayView.this.mMiniGoWhereMultiTv.setMaxWidth(miniDirectionMaxWidth);
                    if (StringUtils.isEmpty(direction) || !direction.contains(" ")) {
                        RGMMHighwayView.this.mMiniGoWhereMultiTv.setText(direction);
                    } else {
                        RGMMHighwayView.this.mMiniGoWhereMultiTv.setText(RGMMHighwayView.this.subDirectionText(RGMMHighwayView.this.mMiniGoWhereMultiTv, miniDirectionMaxWidth, direction, 1));
                    }
                }
            });
        }
    }

    private int getMiniDirectionWidth() {
        if (this.mMiniAfterMetersMultiTv == null || this.mMiniGoWhereMultiTv == null || this.mMiniDirectionTv == null) {
            return 0;
        }
        int[] location = new int[2];
        this.mMiniGoWhereMultiTv.getLocationOnScreen(location);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMiniDirectionTv.getLayoutParams();
        return ((ScreenUtil.getInstance().getWidthPixels() - location[0]) - ((this.mMiniDirectionTv.getWidth() + layoutParams.rightMargin) + layoutParams.leftMargin)) - ScreenUtil.getInstance().dip2px(5);
    }

    private void showMiniPaner(boolean isShow) {
        LogUtil.m15791e(TAG, "showMiniPaner -> " + isShow);
        if (isShow) {
            initMiniPaner();
            if (!(this.mHighwayViewLayout == null || this.mHighwayViewMiniLayout == null || this.mMiniCurRoadDistTv == null)) {
                this.mHighwayViewLayout.setVisibility(8);
                this.mHighwayViewMiniLayout.setVisibility(0);
                RGMapModeViewController.getInstance().hideDeviceStateView();
                RGHighwayModel.getInstance().setCurrentPanerMode(1);
            }
        } else if (!(this.mHighwayViewLayout == null || this.mHighwayViewMiniLayout == null)) {
            this.mHighwayViewLayout.setVisibility(0);
            this.mHighwayViewMiniLayout.setVisibility(8);
            RGMapModeViewController.getInstance().showDeviceStateView();
            RGHighwayModel.getInstance().setCurrentPanerMode(0);
        }
        RGViewController.getInstance().setMapDrawScreenRect();
        BNMapController.getInstance().setMapShowScreenRect();
    }

    public boolean ismMiniPanelShowing() {
        return isVisibility() && this.mHighwayViewMiniLayout != null && this.mHighwayViewMiniLayout.getVisibility() == 0;
    }

    private void initMiniPaner() {
        LogUtil.m15791e(TAG, "initMiniPaner - viewStub.inflate : mHighwayViewMiniLayout = " + this.mHighwayViewMiniLayout + ", mRootViewGroup = " + this.mRootViewGroup);
        if (this.mHighwayViewMiniLayout == null && this.mRootViewGroup != null) {
            ViewStub miniPanerStub = (ViewStub) this.mRootViewGroup.findViewById(C4048R.id.bnav_mini_layout);
            if (miniPanerStub != null) {
                this.mHighwayViewMiniLayout = (ViewGroup) miniPanerStub.inflate();
            }
            if (this.mHighwayViewMiniLayout == null) {
                this.mHighwayViewMiniLayout = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_mini_layout_root);
            }
            if (this.mHighwayViewMiniLayout != null) {
                this.mMiniDirectionMode = (RelativeLayout) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hw_direction_mode_layout);
                this.mMiniAlongMode = (LinearLayout) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hw_along_mode_layout);
                this.mMiniTurnIcon = (ImageView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hw_turn_mini_icon);
                this.mMiniAfterMetersMultiTv = (TextView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hw_after_meters_multi_mini_tv);
                this.mMiniGoWhereMultiTv = (TextView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hw_go_where_multi_mini_tv);
                this.mMiniDirectionTv = (TextView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hw_direction_text);
                this.mMiniCurRoadNameTv = (TextView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hg_mini_cur_road_name_tv);
                this.mMiniCurRoadDistTv = (TextView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hg_mini_cur_road_remain_dist_tv);
                this.mMiniCurRoadDistWordTv = (TextView) this.mHighwayViewMiniLayout.findViewById(C4048R.id.bnav_rg_hg_mini_cur_road_remain_dist_word);
                this.mHighwayViewMiniLayout.setVisibility(8);
            }
        }
    }

    private String subDirectionText(TextView textView, int viewWidth, String direction, int lineCount) {
        if (textView == null || UIUtils.isTextFullDisplay(textView, viewWidth, direction, lineCount)) {
            return direction;
        }
        int lastSpace = direction.lastIndexOf(" ");
        return lastSpace >= 0 ? subDirectionText(textView, viewWidth, direction.substring(0, lastSpace), lineCount) : direction;
    }

    private int getGoWhereViewWidth() {
        if (RGViewController.getInstance().getPreloadOrientation() != 1) {
            return ScreenUtil.getInstance().getGuidePanelWidth();
        }
        int maxWidth = ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(134);
        if (this.mICCodeTV != null && this.mICCodeTV.getVisibility() == 0) {
            maxWidth = (maxWidth - ScreenUtil.getInstance().dip2px(8)) - UIUtils.mearsureTextWidth(this.mICCodeTV, this.mICCodeTV.getText().toString());
        }
        if (this.mDirectionTV.getVisibility() == 0) {
            return maxWidth - ScreenUtil.getInstance().dip2px(52);
        }
        return maxWidth;
    }

    private SpannableStringBuilder getSpannableStringBuilder(String direction) {
        ForegroundColorSpan mainInfoSpan = new ForegroundColorSpan(JarUtils.getResources().getColor(C4048R.color.nsdk_rg_main_info));
        ForegroundColorSpan dirInfoSpan = new ForegroundColorSpan(JarUtils.getResources().getColor(C4048R.color.nsdk_text_rg_normal_info));
        SpannableStringBuilder builder = new SpannableStringBuilder(direction);
        if (direction.endsWith(JarUtils.getResources().getString(C4048R.string.bnav_string_hw_direction))) {
            builder.setSpan(mainInfoSpan, 0, direction.length() - 2, 33);
            builder.setSpan(dirInfoSpan, direction.length() - 2, direction.length(), 33);
        } else {
            builder.setSpan(mainInfoSpan, 0, direction.length(), 33);
        }
        return builder;
    }

    private void updateExitCodeView() {
        if (this.mICCodeTV != null) {
            if (RGHighwayModel.getInstance().hasExitCode()) {
                String icCodeS = String.format(BNStyleManager.getString(C4048R.string.nsdk_string_hw_ic_code), new Object[]{RGHighwayModel.getInstance().getExitCode()});
                if (!TextUtils.isEmpty(icCodeS)) {
                    this.mICCodeTV.setVisibility(0);
                    this.mICCodeTV.setText(icCodeS);
                    if (this.mDirectionTV != null) {
                        this.mDirectionTV.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mICCodeTV.setVisibility(8);
        }
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void updateTotalRemainInfo() {
        if (this.mTotalDistTV != null && this.mArriveTimeTV != null) {
            String tmp1 = RGSimpleGuideModel.getInstance().getTotalRemainDistString();
            String tmp2 = RGSimpleGuideModel.getInstance().getArriveTimeString();
            if (!this.mLastTotalRemainDistS.equals(tmp1) || !this.mLastArriveTimeS.equals(tmp2)) {
                this.mLastTotalRemainDistS = tmp1;
                this.mLastArriveTimeS = tmp2;
                this.mTotalDistTV.setText(tmp1);
                this.mArriveTimeTV.setText(tmp2);
            }
        }
    }

    public void updateHighwayFsmSate(String state) {
        if (state.equals(FsmState.North2D) || state.equals(FsmState.Car3D)) {
            if (RGViewController.getInstance().getPreloadOrientation() == 1 && RGHighwayModel.getInstance().getMiniPanerDisplayable() && RGHighwayModel.getInstance().isAutoShowMiniPanerAble()) {
                showMiniPaner(true);
                LogUtil.m15791e(TAG, "checked state --> " + state + " , showMiniPaner --> " + true);
            }
        } else if (state.equals(FsmState.SimpleGuide)) {
            RGHighwayModel.getInstance().setMiniPanerDisplayable(false);
        }
    }

    public void resetHighwayPanel() {
        showMiniPaner(false);
        RGHighwayModel.getInstance().reset();
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        this.mHighwayViewMiniLayout = null;
        initViews();
        if (RGViewController.getInstance().getPreloadOrientation() == 1 && RGHighwayModel.getInstance().getMiniPanerDisplayable()) {
            initMiniPaner();
            if (this.mMiniCurRoadDistTv != null && StringUtils.isEmpty(this.mMiniCurRoadDistTv.getText().toString())) {
                updateDataByLastest();
            }
        }
    }

    public void onSwitchBackground(boolean isBackground) {
        if (!isVisibility() || !isBackground) {
        }
    }

    public void show() {
        super.show();
        updateDataByLastest();
        if (this.mHighwayViewContainer != null) {
            this.mHighwayViewContainer.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        if (this.mHighwayViewContainer != null) {
            this.mHighwayViewContainer.setVisibility(4);
        }
    }
}
