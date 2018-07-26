package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;

public class RGMMRouteGuideFloatView {
    private static final int ROUTE_MODE_ALONG = 1;
    private static final int ROUTE_MODE_FUZZY = 2;
    private static final int ROUTE_MODE_INVALID = -1;
    private static final int ROUTE_MODE_NORMAL = 0;
    private static final String TAG = RGMMRouteGuideFloatView.class.getSimpleName();
    private boolean isMoved = false;
    private boolean isShowing = false;
    private TextView mAfterLabelInfoTV;
    private TextView mAfterMetersInfoTV = null;
    private View mAlongModeContainer = null;
    private ViewGroup mContentView;
    private TextView mCurRoadNameTV = null;
    private TextView mCurRoadRemainDistTV = null;
    private TextView mCurRoadRemainDistWordTV = null;
    private TextView mDirectionTV = null;
    private float mDownX = 0.0f;
    private float mDownY = 0.0f;
    private ViewGroup mFloatLayout;
    private View mFuzzyModeContainer = null;
    private TextView mFuzzyTV;
    private TextView mGoWhereInfoTV;
    private TextView mICCodeTV = null;
    private View mNormalModeContainer = null;
    private int mScreenHight;
    private int mScreenWidth;
    private int mTouchSlop;
    private ImageView mTurnIcon = null;
    private WindowManager mWindowManager;
    private float mXInFloatView;
    private float mXInScreen;
    private float mYInFloatView;
    private float mYInScreen;
    private LayoutParams wmParams;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteGuideFloatView$1 */
    class C44221 implements OnClickListener {
        C44221() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_3);
            RGMMRouteGuideFloatView.this.hide();
            RGCacheStatus.hasClosedFoatView = true;
            if (!BNSettingManager.hasShowFloatCloseMsg()) {
                BNSettingManager.setShowFloatClosedMsg(true);
                RGViewController.getInstance().showCloseRGFloatViewMsg();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteGuideFloatView$2 */
    class C44232 implements OnClickListener {
        C44232() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_4);
                BNaviModuleManager.launchMapsActivityToFront();
                RGMMRouteGuideFloatView.this.hide();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteGuideFloatView$3 */
    class C44243 implements OnTouchListener {
        C44243() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return RGMMRouteGuideFloatView.this.handleMotionEvent(event);
        }
    }

    public RGMMRouteGuideFloatView() {
        initWindowsManger();
        intParams();
        initViews();
    }

    private void initWindowsManger() {
        this.wmParams = new LayoutParams();
        this.mWindowManager = (WindowManager) BNaviModuleManager.getActivity().getApplicationContext().getSystemService("window");
        if (VERSION.SDK_INT >= 19) {
            this.wmParams.type = 2005;
        } else {
            this.wmParams.type = 2002;
        }
        this.wmParams.format = 1;
        this.wmParams.flags = 8;
        this.wmParams.gravity = 51;
        this.wmParams.x = ScreenUtil.getInstance().dip2px(25);
        this.wmParams.y = 0;
        this.wmParams.width = ScreenUtil.getInstance().dip2px(RouteLineResConst.LINE_FOOT_NORMAL);
        this.wmParams.height = ScreenUtil.getInstance().dip2px(52);
    }

    private void intParams() {
        this.mTouchSlop = ScreenUtil.getInstance().dip2px(4);
        this.mScreenWidth = ScreenUtil.getInstance().getWidthPixels();
        this.mScreenHight = ScreenUtil.getInstance().getHeightPixels();
    }

    private void initViews() {
        this.mFloatLayout = (ViewGroup) JarUtils.inflate(BNaviModuleManager.getActivity(), C4048R.layout.nsdk_layout_rg_mapmode_floatview_layout, null);
        this.mNormalModeContainer = this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_direction_mode);
        this.mAlongModeContainer = this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_along_mode);
        this.mFuzzyModeContainer = this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_fuzzy_mode);
        this.mContentView = (ViewGroup) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_floatview_content);
        this.mTurnIcon = (ImageView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_turn_icon);
        this.mAfterMetersInfoTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_after_meters_multi_tv);
        this.mGoWhereInfoTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_go_where_multi_tv);
        this.mAfterLabelInfoTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_after_label_info);
        this.mICCodeTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_ic_code);
        this.mDirectionTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_direction);
        this.mCurRoadNameTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_cur_road_name_tv);
        this.mCurRoadRemainDistTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_cur_road_remain_dist_tv);
        this.mCurRoadRemainDistWordTV = (TextView) this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_cur_road_remain_dist_word);
        this.mFuzzyTV = (TextView) this.mFuzzyModeContainer.findViewById(C4048R.id.bnav_rg_float_fuzzy_tv);
        this.mFloatLayout.findViewById(C4048R.id.bnav_rg_float_control_panel_close).setOnClickListener(new C44221());
        this.mFloatLayout.setOnClickListener(new C44232());
    }

    public void updateData(Bundle bundle, boolean isHighway) {
        int mode;
        if ("Highway".equals(RouteGuideFSM.getInstance().getCurrentState())) {
            if (isHighway) {
                mode = updateHighwayData();
            } else {
                return;
            }
        } else if (!isHighway) {
            if (bundle == null) {
                bundle = RGSimpleGuideModel.getInstance().getNextGuideInfo();
            }
            mode = updateSimpleGuideData(bundle);
        } else {
            return;
        }
        if (mode == 0) {
            this.mNormalModeContainer.setVisibility(0);
            this.mAlongModeContainer.setVisibility(8);
            this.mFuzzyModeContainer.setVisibility(8);
        } else if (1 == mode) {
            this.mNormalModeContainer.setVisibility(8);
            this.mAlongModeContainer.setVisibility(0);
            this.mFuzzyModeContainer.setVisibility(8);
        } else if (2 == mode) {
            this.mNormalModeContainer.setVisibility(8);
            this.mAlongModeContainer.setVisibility(8);
            this.mFuzzyModeContainer.setVisibility(0);
        }
        this.mContentView.requestLayout();
        this.mContentView.invalidate();
    }

    public int updateHighwayData() {
        String afterMetersS = RGHighwayModel.getInstance().getFormatExitRemainDist();
        String start = RGSimpleGuideModel.getInstance().getDistStart(afterMetersS);
        String end = RGSimpleGuideModel.getInstance().getDistEnd(afterMetersS);
        String direction = RGHighwayModel.getInstance().formatDirections();
        try {
            this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_turn_along));
        } catch (Throwable th) {
        }
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
            if (this.mDirectionTV != null) {
                this.mDirectionTV.setVisibility(8);
            }
            updateExitCodeView();
            return 1;
        }
        if (!(this.mAfterMetersInfoTV == null || this.mAfterLabelInfoTV == null || start == null || end == null)) {
            if (RGHighwayModel.getInstance().getTypeRemainDist(4) < 10) {
                this.mAfterMetersInfoTV.setText("现在");
                this.mAfterLabelInfoTV.setText("");
            } else {
                this.mAfterMetersInfoTV.setText(start);
                this.mAfterLabelInfoTV.setText(end + "后");
            }
        }
        if (!(this.mGoWhereInfoTV == null || direction == null)) {
            this.mGoWhereInfoTV.setText(subDirectionText(ScreenUtil.getInstance().dip2px(72), direction));
            this.mGoWhereInfoTV.setVisibility(0);
        }
        if (this.mDirectionTV != null) {
            this.mDirectionTV.setVisibility(0);
        }
        updateExitCodeView();
        return 0;
    }

    private String subDirectionText(int viewWidth, String direction) {
        if (this.mGoWhereInfoTV == null || UIUtils.isTextFullDisplay(this.mGoWhereInfoTV, viewWidth, direction, 1)) {
            return direction;
        }
        int lastSpace = direction.lastIndexOf(" ");
        return lastSpace >= 0 ? subDirectionText(viewWidth, direction.substring(0, lastSpace)) : direction;
    }

    private void updateExitCodeView() {
    }

    public int updateSimpleGuideData(Bundle b) {
        if (b.getInt("updatetype") != 1) {
            return -1;
        }
        if (RGMapModeViewController.getInstance().isFuzzyMode()) {
            this.mFuzzyTV.setText(RGSimpleGuideModel.getInstance().getFuzzyTV());
            this.mTurnIcon.setImageResource(C4048R.drawable.bnav_drawable_set_off);
            return 2;
        }
        int resId = b.getInt("resid", 0);
        int remainDist = b.getInt(SimpleGuideInfo.RemainDist, 0);
        String nextRoad = b.getString("road_name");
        if (nextRoad == null || nextRoad.length() == 0) {
            nextRoad = JarUtils.getResources().getString(C4048R.string.nsdk_string_navi_no_name_road);
        }
        if (resId != 0) {
            try {
                this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(resId));
            } catch (OutOfMemoryError e) {
            }
        }
        String frontInfo = RGSimpleGuideModel.getInstance().getFormatAfterMeters(remainDist);
        String start = RGSimpleGuideModel.getInstance().getDistStart(frontInfo);
        String end = RGSimpleGuideModel.getInstance().getDistEnd(frontInfo);
        if (!(this.mAfterMetersInfoTV == null || this.mAfterLabelInfoTV == null || start == null || end == null)) {
            if (remainDist < 10) {
                this.mAfterMetersInfoTV.setText("现在");
                this.mAfterLabelInfoTV.setText("");
            } else {
                this.mAfterMetersInfoTV.setText(start);
                this.mAfterLabelInfoTV.setText(end + "后");
            }
        }
        String nextRoadInfo = RGSimpleGuideModel.getInstance().getFormatGoNextRoad(nextRoad);
        if (!(nextRoadInfo == null || this.mGoWhereInfoTV == null || this.mGoWhereInfoTV.getText().equals(nextRoadInfo))) {
            this.mGoWhereInfoTV.setText(nextRoadInfo);
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
        if (this.mICCodeTV != null) {
            this.mICCodeTV.setVisibility(8);
        }
        if (this.mDirectionTV != null) {
            this.mDirectionTV.setVisibility(8);
        }
        if (!RGSimpleGuideModel.getInstance().isStraight()) {
            return 0;
        }
        try {
            this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_turn_along));
        } catch (Throwable th) {
        }
        return 1;
    }

    public void updateDataByLastest() {
        if ("Highway".equals(RouteGuideFSM.getInstance().getCurrentState())) {
            updateData(null, true);
        } else {
            updateData(RGSimpleGuideModel.getInstance().getNextGuideInfo(), false);
        }
    }

    public boolean show() {
        LogUtil.m15791e(TAG, "show :" + isShow());
        if (isShow()) {
            return true;
        }
        try {
            if (!RGCacheStatus.hasRecordFloatViewShow) {
                RGCacheStatus.hasRecordFloatViewShow = true;
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_2);
            }
            updateDataByLastest();
            this.mFloatLayout.setOnTouchListener(new C44243());
            this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
            this.isShowing = true;
            return true;
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "float excetion e:" + e.getMessage());
            this.isShowing = false;
            return false;
        }
    }

    public void hide() {
        LogUtil.m15791e(TAG, "hide");
        try {
            if (!(this.mFloatLayout == null || this.mFloatLayout.getParent() == null)) {
                this.mWindowManager.removeView(this.mFloatLayout);
            }
            this.isShowing = false;
        } catch (Exception e) {
            LogUtil.m15791e(TAG, "hide float excetion e:" + e.getMessage());
        }
    }

    public boolean isShow() {
        return this.isShowing;
    }

    public void dispose() {
        this.isShowing = false;
        if (this.mFloatLayout != null) {
            this.mWindowManager.removeView(this.mFloatLayout);
        }
    }

    private boolean handleMotionEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                this.mXInFloatView = event.getX();
                this.mYInFloatView = event.getY();
                this.mDownX = event.getRawX();
                this.mDownY = event.getRawY();
                this.isMoved = false;
                return false;
            case 1:
                updateViewPosition();
                return this.isMoved;
            case 2:
                this.mXInScreen = event.getRawX();
                this.mYInScreen = event.getRawY() - ((float) ScreenUtil.getInstance().getStatusBarHeight());
                if (Math.abs(this.mDownX - event.getRawX()) > ((float) this.mTouchSlop) || Math.abs(this.mDownY - event.getRawY()) > ((float) this.mTouchSlop)) {
                    this.isMoved = true;
                }
                updateViewPosition();
                return false;
            default:
                return false;
        }
    }

    private void updateViewPosition() {
        this.wmParams.x = (int) (this.mXInScreen - this.mXInFloatView);
        this.wmParams.y = (int) (this.mYInScreen - this.mYInFloatView);
        try {
            this.mWindowManager.updateViewLayout(this.mFloatLayout, this.wmParams);
        } catch (Exception e) {
        }
    }
}
