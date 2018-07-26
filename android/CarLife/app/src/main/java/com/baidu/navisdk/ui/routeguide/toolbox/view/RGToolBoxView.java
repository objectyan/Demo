package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.toolbox.RGToolboxConstant;
import com.baidu.navisdk.ui.routeguide.toolbox.present.BaseNavPresent;
import com.baidu.navisdk.ui.routeguide.toolbox.present.RGToolBoxPresent;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.CustomLinearScrollView;
import com.baidu.navisdk.ui.widget.CustomLinearScrollView.OnStatusChangeListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RGToolBoxView implements IRGToolBoxView, OnStatusChangeListener {
    public static final int SETTING_ST_CLOSE = 2;
    public static final int SETTING_ST_OPEN = 1;
    private static final String TAG = "BNToolBoxView";
    public static final int TOPBAR_STATE_BROWSEMAP = 1;
    public static final int TOPBAR_STATE_NORMAL = 0;
    private final int closeColor = BNStyleManager.getColor(C4048R.color.nsdk_rg_transparent);
    private Activity mActivity;
    private TextView mArrivetime;
    private BNWorkerNormalTask<String, String> mAutoHideRunnable = new BNWorkerNormalTask<String, String>("RGToolBoxView-autoHideTask", null) {
        protected String execute() {
            RGToolBoxView.this.closeToolBox();
            return null;
        }
    };
    public String mCarNum;
    private View mClearPoiView = null;
    private int mContainnerViewId;
    private TextView mCurStateTipsTv;
    private boolean mIsCurDay = true;
    private TextView mNoProgressLoadingView;
    private ImageView mOpenCloseIV;
    private View mOpenCloseLy;
    private TextView mOpenCloseText;
    private View mQuitDividerView;
    private ImageView mQuitImageView;
    private TextView mReRoutePlanTextView = null;
    private View mReRoutePlanWattingView = null;
    private TextView mRemainTimeTv;
    private View mResumeSwitchLy = null;
    private View mRootView;
    private ViewGroup mRootViewContainer;
    private CustomLinearScrollView mScrollView;
    private View mTimeAndDistLy;
    private BaseNavPresent mToolBoxPresent = null;
    private View mViewBottomPanel;
    private View mViewChange;
    private View mViewClear;
    private View mViewContinue;
    private View mViewContinue2;
    private View mViewExit;
    private SparseArray<View> mViewMap = new SparseArray();
    private View mViewSetting;
    private SparseArray<Integer> mViewStatus = new SparseArray();
    private final int openColor = BNStyleManager.getColor(C4048R.color.cl_rg_bg_a);

    public interface LoadingCallback {
        void onQuitClick();
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView$1 */
    class C44691 implements OnTouchListener {
        C44691() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView$3 */
    class C44713 implements OnTouchListener {
        C44713() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() != 0 || RGToolBoxView.this.mScrollView == null || RGToolBoxView.this.mScrollView.getCurStatus() != 0) {
                return false;
            }
            RGToolBoxView.this.closeToolBox();
            return true;
        }
    }

    public RGToolBoxView(Activity activity, ViewGroup viewGroup, int containnerId) {
        this.mActivity = activity;
        this.mContainnerViewId = containnerId;
        this.mRootViewContainer = (ViewGroup) viewGroup.findViewById(containnerId);
        inflate();
        updateStyle(BNStyleManager.getDayStyle());
        initPresent();
        this.mToolBoxPresent.startInit();
    }

    public Context getContext() {
        if (this.mActivity != null) {
            return this.mActivity.getApplicationContext();
        }
        LogUtil.m15791e(TAG, "getContext activity is null");
        return null;
    }

    private void initPresent() {
        this.mToolBoxPresent = new RGToolBoxPresent(this);
    }

    public void updateSubListener(OnRGSubViewListener listener) {
        this.mToolBoxPresent.setOnSubViewClickListener(listener);
    }

    public View inflate() {
        if (this.mRootView != null) {
            return this.mRootView;
        }
        this.mRootView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox, null);
        if (this.mRootView == null) {
            LogUtil.m15791e(TAG, "inflate fail mRootView null");
            return null;
        }
        this.mScrollView = (CustomLinearScrollView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_scroollview);
        this.mScrollView.setInitScrollStatus(1);
        this.mScrollView.setOnStatusChangeListener(this);
        this.mNoProgressLoadingView = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_loading_no_progress);
        this.mTimeAndDistLy = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_time_and_dist_ly);
        this.mRemainTimeTv = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_remain_time_and_dist);
        this.mArrivetime = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_arrive_time);
        this.mCurStateTipsTv = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_continue_nav);
        for (int index = 0; index < RGToolboxConstant.VIEW_CLICK_IDS.length; index++) {
            this.mViewMap.put(index, this.mRootView.findViewById(RGToolboxConstant.VIEW_CLICK_IDS[index]));
        }
        this.mOpenCloseLy = (View) this.mViewMap.get(9);
        this.mOpenCloseText = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_open_close_tv);
        this.mOpenCloseIV = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_open_close_iv);
        this.mQuitImageView = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_quit_iv);
        this.mQuitDividerView = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_quit_divider);
        this.mReRoutePlanWattingView = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_rp_watting);
        this.mReRoutePlanTextView = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_rp_watting_tv);
        this.mReRoutePlanWattingView.setOnTouchListener(new C44691());
        for (int id : RGToolboxConstant.CLICK_ViewIndex) {
            final int viewID = id;
            ((View) this.mViewMap.get(id)).setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    RGToolBoxView.this.mToolBoxPresent.onClick(v, viewID);
                }
            });
        }
        this.mViewExit = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_quit_ly);
        this.mViewContinue = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_continue_nav);
        this.mViewSetting = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_open_close_ly);
        this.mViewContinue2 = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_resume_tv);
        this.mViewChange = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_switch_route_tv);
        this.mViewClear = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_clear_poi_tv);
        this.mViewBottomPanel = this.mRootView.findViewById(C4048R.id.nsdk_rg_bottom_panel);
        return this.mRootView;
    }

    public void updateStyle(boolean day) {
        if (!getIsTrueCurDay(day)) {
            View styleView;
            TextView v;
            View v2;
            this.mIsCurDay = day;
            if (this.mOpenCloseIV != null) {
                if (this.mScrollView.getCurStatus() == 0) {
                    this.mOpenCloseIV.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_toolbox_icon_close_toolbox));
                } else {
                    this.mOpenCloseIV.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_toolbox_icon_open_toolbox));
                }
            }
            if (this.mQuitImageView != null) {
                this.mQuitImageView.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_toolbox_icon_quit_nav));
            }
            if (this.mReRoutePlanWattingView != null) {
                this.mReRoutePlanWattingView.setBackgroundColor(getColor(C4048R.color.cl_bg_d));
            }
            int allViewLen = RGToolboxConstant.VIEW_SETTINGS_ITEM.length;
            for (int index = 0; index < allViewLen; index++) {
                styleView = (View) this.mViewMap.get(RGToolboxConstant.VIEW_SETTINGS_ITEM[index]);
                styleView.setBackgroundDrawable(getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
                styleView.setPadding(0, ScreenUtil.getInstance().dip2px(16), 0, 0);
                int color;
                Drawable drawable;
                switch (index) {
                    case 0:
                        color = getColor(C4048R.color.cl_text_b_mm);
                        drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_route_sort);
                        ((TextView) styleView).setTextColor(color);
                        ((TextView) styleView).setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                        break;
                    case 1:
                        color = getColor(C4048R.color.cl_text_b_mm);
                        drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_way_search);
                        ((TextView) styleView).setTextColor(color);
                        ((TextView) styleView).setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                        break;
                    case 2:
                        color = getColor(C4048R.color.cl_text_b_mm);
                        drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_ugc_report);
                        ((TextView) styleView).setTextColor(color);
                        ((TextView) styleView).setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                        break;
                    case 3:
                        color = getColor(C4048R.color.cl_text_b_mm);
                        drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_route_share);
                        ((TextView) styleView).setTextColor(color);
                        ((TextView) styleView).setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        Integer value = (Integer) this.mViewStatus.get(RGToolboxConstant.VIEW_SETTINGS_ITEM[index]);
                        if (value == null) {
                            break;
                        }
                        updateSettingStatus(RGToolboxConstant.VIEW_SETTINGS_ITEM[index], value.intValue());
                        break;
                    default:
                        break;
                }
            }
            styleView = (View) this.mViewMap.get(14);
            if (styleView != null && (styleView instanceof ImageView)) {
                ((ImageView) styleView).setImageDrawable(getDrawable(C4048R.drawable.nsdk_notification_quit_icon));
            }
            ProgressBar progressBar = (ProgressBar) this.mRootView.findViewById(1711866945);
            if (progressBar != null) {
                Drawable barDrawable = getDrawable(C4048R.drawable.nsdk_drawable_black_loading_progress);
                barDrawable.setBounds(0, 0, barDrawable.getIntrinsicWidth(), barDrawable.getIntrinsicHeight());
                progressBar.setIndeterminateDrawable(barDrawable);
            }
            for (int id : RGToolboxConstant.VIEW_TEXT_A) {
                v = (TextView) this.mRootView.findViewById(id);
                if (v != null) {
                    v.setTextColor(getColor(C4048R.color.cl_text_a_mm));
                }
            }
            for (int id2 : RGToolboxConstant.VIEW_TEXT_B) {
                v = (TextView) this.mRootView.findViewById(id2);
                if (v != null) {
                    v.setTextColor(getColor(C4048R.color.cl_text_b_mm));
                }
            }
            for (int id22 : RGToolboxConstant.VIEW_TEXT_B_TITLE) {
                v = (TextView) this.mRootView.findViewById(id22);
                if (v != null) {
                    v.setTextColor(getColor(C4048R.color.cl_text_b_mm_title));
                }
            }
            for (int id222 : RGToolboxConstant.VIEW_TEXT_B_SINGLE) {
                v = (TextView) this.mRootView.findViewById(id222);
                if (v != null) {
                    v.setTextColor(getColor(C4048R.color.cl_text_b_mm_single));
                }
            }
            for (int id2222 : RGToolboxConstant.VIEW_BG_ID) {
                v2 = this.mRootView.findViewById(id2222);
                if (v2 != null) {
                    v2.setBackgroundColor(getColor(C4048R.color.cl_bg_d));
                }
            }
            for (int id22222 : RGToolboxConstant.DIVIDER_H) {
                v2 = this.mRootView.findViewById(id22222);
                if (v2 != null) {
                    v2.setBackgroundColor(getColor(C4048R.color.cl_rg_bg_b));
                }
            }
            for (int id222222 : RGToolboxConstant.DIVIDER_V) {
                v2 = this.mRootView.findViewById(id222222);
                if (v2 != null) {
                    v2.setBackgroundColor(getColor(C4048R.color.cl_rg_bg_c));
                }
            }
            this.mViewExit.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_toolbox_selector));
            this.mViewContinue.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_toolbox_selector));
            this.mViewContinue2.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_toolbox_selector));
            this.mViewSetting.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_toolbox_selector));
            this.mViewChange.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_toolbox_selector));
            this.mViewClear.setBackgroundDrawable(getDrawable(C4048R.drawable.bnav_common_cp_toolbox_selector));
        }
    }

    private boolean getIsTrueCurDay(boolean day) {
        boolean z;
        if (!(this.mViewMap == null || this.mViewMap.size() <= 0 || this.mViewMap.get(0) == null)) {
            View view = (View) this.mViewMap.get(0);
            if (view instanceof TextView) {
                int color = ((TextView) view).getCurrentTextColor();
                if (JarUtils.getResources() != null) {
                    if (color == JarUtils.getResources().getColor(C4048R.color.cl_text_b_mm)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mIsCurDay = z;
                }
            }
        }
        String str = TAG;
        StringBuilder append = new StringBuilder().append("getIsTrueCurDay mIsCurDay");
        if (day == this.mIsCurDay) {
            z = true;
        } else {
            z = false;
        }
        LogUtil.m15791e(str, append.append(z).toString());
        if (day == this.mIsCurDay) {
            return true;
        }
        return false;
    }

    public void updateSettingStatus(int key, int value) {
        LogUtil.m15791e(TAG, "updateSettingStatus key=" + key + " value = " + value);
        this.mViewStatus.put(key, Integer.valueOf(value));
        int color = -1;
        Drawable drawable = null;
        String title = "";
        switch (key) {
            case 4:
                color = BNStyleManager.getColor(C4048R.color.cl_text_g, this.mIsCurDay);
                if (value != 1) {
                    drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_north2d_mode);
                    title = BNStyleManager.getString(C4048R.string.nsdk_string_rg_menu_view_north2d);
                    break;
                }
                drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_car3d_mode);
                title = BNStyleManager.getString(C4048R.string.nsdk_string_rg_menu_view_car3d);
                break;
            case 5:
                title = "导航声音";
                if (value != 1) {
                    color = getColor(C4048R.color.cl_text_g);
                    drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_voice_open);
                    break;
                }
                color = getColor(C4048R.color.cl_text_b_mm);
                drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_voice_closed);
                break;
            case 6:
                color = getColor(C4048R.color.cl_text_g);
                if (value != 1) {
                    drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_beam_chart);
                    title = "路况条";
                    break;
                }
                drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_fullview_state);
                title = "全览小窗";
                break;
            case 7:
                if (value != 1) {
                    color = getColor(C4048R.color.cl_text_b_mm);
                    drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_car_plate_closed);
                    title = "车牌限行";
                    break;
                }
                color = getColor(C4048R.color.cl_text_g);
                drawable = getDrawable(C4048R.drawable.nsdk_drawable_toolbox_car_plate_open);
                title = this.mCarNum;
                break;
        }
        TextView textView = (TextView) this.mViewMap.get(key);
        if (textView != null) {
            textView.setText(title);
            textView.setTextColor(color);
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }
    }

    public void showToolBox() {
        LogUtil.m15791e(TAG, "showToolBox :");
        if (this.mRootViewContainer.getChildCount() == 0) {
            addToContainner();
        }
        updateStyle(BNStyleManager.getDayStyle());
        if (this.mRootView != null) {
            this.mRootView.setVisibility(0);
        }
        if (this.mRootViewContainer != null) {
            this.mRootViewContainer.setVisibility(0);
        }
    }

    public void hideToolBox() {
        LogUtil.m15791e(TAG, "hideToolBox :");
        if (this.mRootView != null) {
            this.mRootView.setVisibility(8);
        } else {
            LogUtil.m15791e(TAG, "showToolBox error");
        }
        if (this.mRootViewContainer != null) {
            this.mRootViewContainer.setVisibility(8);
        }
        BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
    }

    public void openToolBox() {
        boolean result = false;
        if (this.mScrollView != null) {
            result = this.mScrollView.gotoTop();
            rootViewFadeInAnim();
        }
        LogUtil.m15791e(TAG, "openToolBox result :" + result);
    }

    public void closeToolBox() {
        boolean result = false;
        if (this.mScrollView != null && isOpenStatus()) {
            result = this.mScrollView.gotoBottom();
            rootViewFadeOutAnim();
        }
        LogUtil.m15791e(TAG, "closeToolBox result :" + result);
    }

    public void closeToolBox(boolean isNeedAnim) {
        LogUtil.m15791e(TAG, "closeToolBox isNeedAnim:" + isNeedAnim);
        if (this.mScrollView != null && isOpenStatus()) {
            this.mScrollView.gotoBottom();
            if (isNeedAnim) {
                rootViewFadeOutAnim();
            }
        }
    }

    public boolean isOpenStatus() {
        if (this.mScrollView == null || this.mScrollView.getCurStatus() != 0) {
            return false;
        }
        return true;
    }

    public boolean isToolboxScrolling() {
        if (this.mScrollView != null) {
            return this.mScrollView.isScrolling();
        }
        return false;
    }

    public RGToolBoxPresent getPresent() {
        return (RGToolBoxPresent) this.mToolBoxPresent;
    }

    public void switchToolBarMode(int mode) {
    }

    public void setCurStateTips(String tips) {
        LogUtil.m15791e(TAG, "setCurStateTips tips:" + tips);
        this.mCurStateTipsTv.setText(tips);
    }

    public void updateRemainTimeAndDist(String remainTime) {
        LogUtil.m15791e(TAG, "updateRemainTimeAndDist remainTime:" + remainTime);
        if (this.mRemainTimeTv != null) {
            this.mRemainTimeTv.setText(remainTime);
        }
    }

    public void updateArriveTime(String timeAndDist) {
        LogUtil.m15791e(TAG, "updateArriveTime:" + timeAndDist);
        if (this.mArrivetime != null) {
            this.mArrivetime.setText(timeAndDist);
        }
    }

    public void onOrientationChange(ViewGroup viewGroup, int orientation) {
        LogUtil.m15791e(TAG, "onOrientationChange");
        this.mRootViewContainer.removeAllViews();
        this.mRootViewContainer = (ViewGroup) viewGroup.findViewById(C4048R.id.bnav_rg_toolbox_panel_container);
        addToContainner();
        if (isOpenStatus()) {
            this.mRootViewContainer.setBackgroundColor(this.openColor);
        }
    }

    public void onSizeChanged() {
        LogUtil.m15791e(TAG, "onSizeChanged");
        if (RGViewController.getInstance().getPreloadOrientation() != 1) {
            this.mRootViewContainer.setPadding(RGViewController.getInstance().getmRootViewHeight() / 4, 0, 0, 0);
        } else {
            this.mRootViewContainer.setPadding(0, 0, 0, 0);
        }
    }

    private void addToContainner() {
        LogUtil.m15791e(TAG, "addToContainner");
        if (this.mRootView == null) {
            inflate();
        }
        this.mRootViewContainer.addView(this.mRootView);
        if (RGViewController.getInstance().getPreloadOrientation() == 1) {
            this.mRootViewContainer.setPadding(0, 0, 0, 0);
        } else {
            this.mRootViewContainer.setPadding(RGViewController.getInstance().getmRootViewHeight() / 4, 0, 0, 0);
        }
        this.mRootViewContainer.setOnTouchListener(new C44713());
        if (this.mRootView.getVisibility() == 0) {
            this.mRootViewContainer.setVisibility(0);
        } else {
            this.mRootViewContainer.setVisibility(8);
        }
    }

    public void onDestroy() {
        LogUtil.m15791e(TAG, "onDestroy :");
        this.mViewMap.clear();
        this.mActivity = null;
        this.mRemainTimeTv = null;
        this.mArrivetime = null;
        this.mCurStateTipsTv = null;
        this.mScrollView = null;
    }

    public void onStatusChange(int currentPage) {
        LogUtil.m15791e(TAG, "onStatusChange :" + currentPage);
        if (this.mViewMap.size() >= 1) {
            switch (currentPage) {
                case 0:
                    if (this.mQuitDividerView != null) {
                        this.mQuitDividerView.setVisibility(4);
                    }
                    if (this.mOpenCloseText != null) {
                        this.mOpenCloseText.setText("收起");
                    }
                    if (this.mOpenCloseIV != null) {
                        this.mOpenCloseIV.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_toolbox_icon_close_toolbox));
                    }
                    this.mToolBoxPresent.onTopStatus();
                    BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mAutoHideRunnable, new BNWorkerConfig(2, 0), BNOffScreenParams.MIN_ENTER_INTERVAL);
                    return;
                case 1:
                    if (this.mQuitDividerView != null) {
                        this.mQuitDividerView.setVisibility(0);
                    }
                    if (this.mOpenCloseText != null) {
                        this.mOpenCloseText.setText("更多");
                    }
                    if (this.mOpenCloseIV != null) {
                        this.mOpenCloseIV.setImageDrawable(getDrawable(C4048R.drawable.nsdk_drawable_toolbox_icon_open_toolbox));
                    }
                    BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
                    return;
                default:
                    return;
            }
        }
    }

    public void onProgressChange(int progress) {
        LogUtil.m15791e(TAG, "onProgressChange : " + progress);
        View viewQuit = (View) this.mViewMap.get(8);
        float progressF = ((float) progress) / 100.0f;
        if (viewQuit != null) {
            viewQuit.setAlpha(progressF);
            if (progress < 10) {
                viewQuit.setVisibility(4);
            } else if (progress > 10) {
                viewQuit.setVisibility(0);
            }
        }
        if (this.mRootViewContainer != null) {
            this.mRootViewContainer.setBackgroundColor(((int) ((0.5f * (1.0f - progressF)) * 255.0f)) * ((int) Math.pow(16.0d, 6.0d)));
            if (progress > 98) {
                this.mRootViewContainer.setBackgroundColor(this.closeColor);
            } else if (progress < 2) {
                this.mRootViewContainer.setBackgroundColor(this.openColor);
            }
        }
    }

    public void setTopBarState(int state) {
        LogUtil.m15791e(TAG, "setTopBarState : " + state);
        if (state == 1) {
            if (this.mTimeAndDistLy != null) {
                this.mTimeAndDistLy.setVisibility(8);
            }
            if (this.mCurStateTipsTv != null) {
                this.mCurStateTipsTv.setVisibility(0);
            }
        } else if (state == 0) {
            showResumeSwitchView(false);
            if (this.mTimeAndDistLy != null) {
                this.mTimeAndDistLy.setVisibility(0);
            }
            if (this.mCurStateTipsTv != null) {
                this.mCurStateTipsTv.setVisibility(8);
            }
        }
    }

    public void showResumeSwitchView(boolean show) {
        int i = 8;
        boolean z = false;
        LogUtil.m15791e(TAG, "showResumeSwitchView : " + show);
        if (this.mResumeSwitchLy == null) {
            if (show) {
                this.mResumeSwitchLy = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_resume_switch_layout);
            } else {
                return;
            }
        }
        if (this.mViewBottomPanel != null) {
            int i2;
            View view = this.mViewBottomPanel;
            if (show) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
        View view2 = this.mResumeSwitchLy;
        if (show) {
            i = 0;
        }
        view2.setVisibility(i);
        CustomLinearScrollView customLinearScrollView = this.mScrollView;
        if (!show) {
            z = true;
        }
        customLinearScrollView.setScrollSupport(z);
    }

    public void showClearPoiView(boolean show) {
        int i = 8;
        boolean z = false;
        LogUtil.m15791e(TAG, "showClearPoiView : " + show);
        if (this.mClearPoiView == null) {
            if (show) {
                this.mClearPoiView = this.mRootView.findViewById(C4048R.id.bnav_rg_toolbox_clear_poi_tv);
            } else {
                return;
            }
        }
        if (this.mViewBottomPanel != null) {
            int i2;
            View view = this.mViewBottomPanel;
            if (show) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
        View view2 = this.mClearPoiView;
        if (show) {
            i = 0;
        }
        view2.setVisibility(i);
        CustomLinearScrollView customLinearScrollView = this.mScrollView;
        if (!show) {
            z = true;
        }
        customLinearScrollView.setScrollSupport(z);
        closeToolBox();
    }

    public void showLoadingViewNoProgress(String text) {
        LogUtil.m15791e(TAG, "showLoadingViewNoProgress");
        this.mNoProgressLoadingView.setText(text);
        this.mRemainTimeTv.setVisibility(8);
        this.mArrivetime.setVisibility(8);
        this.mNoProgressLoadingView.setVisibility(0);
        this.mScrollView.setScrollSupport(false);
        this.mOpenCloseLy.setEnabled(false);
        this.mTimeAndDistLy.setEnabled(false);
        this.mOpenCloseLy.setAlpha(0.5f);
        closeToolBox();
    }

    public void hideLoadingViewNoProgress() {
        LogUtil.m15791e(TAG, "hideLoadingViewNoProgress");
        this.mNoProgressLoadingView.setVisibility(8);
        this.mRemainTimeTv.setVisibility(0);
        this.mArrivetime.setVisibility(0);
        this.mScrollView.setScrollSupport(true);
        this.mOpenCloseLy.setEnabled(true);
        this.mTimeAndDistLy.setEnabled(true);
        this.mOpenCloseLy.setAlpha(1.0f);
    }

    public void showLoadingViewHasProgress(String text) {
        LogUtil.m15791e(TAG, "showLoadingViewHasProgress");
        this.mReRoutePlanWattingView.setVisibility(0);
        this.mViewBottomPanel.setVisibility(8);
        this.mReRoutePlanTextView.setText(text);
        this.mScrollView.setScrollSupport(false);
        closeToolBox(false);
    }

    public void hideLoadingViewHasProgress() {
        LogUtil.m15791e(TAG, "hideLoadingViewHasProgress");
        this.mReRoutePlanWattingView.setVisibility(8);
        this.mViewBottomPanel.setVisibility(0);
        this.mScrollView.setScrollSupport(true);
    }

    private void rootViewFadeInAnim() {
        if (VERSION.SDK_INT >= 11 && this.mRootViewContainer != null) {
            ValueAnimator valueAnimator = ObjectAnimator.ofInt(this.mRootViewContainer, "backgroundColor", new int[]{this.closeColor, this.openColor});
            valueAnimator.setDuration(200);
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.start();
        }
    }

    private void rootViewFadeOutAnim() {
        if (VERSION.SDK_INT >= 11 && this.mRootViewContainer != null) {
            ValueAnimator valueAnimator = ObjectAnimator.ofInt(this.mRootViewContainer, "backgroundColor", new int[]{this.openColor, this.closeColor});
            valueAnimator.setDuration(200);
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.start();
        }
    }

    public void updateUIForStartNav() {
        if (this.mToolBoxPresent != null) {
            ((RGToolBoxPresent) this.mToolBoxPresent).updateToolBoxItemState(7);
        }
    }

    public boolean isLastScrollEvent() {
        if (this.mScrollView != null) {
            return this.mScrollView.mLastEventIsScroll;
        }
        return false;
    }

    private Drawable getDrawable(int resId) {
        return BNStyleManager.getDrawable(resId, this.mIsCurDay);
    }

    private int getColor(int resId) {
        return BNStyleManager.getColor(resId, this.mIsCurDay);
    }
}
