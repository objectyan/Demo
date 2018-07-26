package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ReplacementTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonConstant;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.iview.IMoreSettingView;
import com.baidu.navisdk.ui.routeguide.mapmode.presenter.MoreSettingPresenter;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseOrientationView;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNDebugModelDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMMenuMoreView extends BNBaseOrientationView implements OnClickListener, OnCheckedChangeListener, OnEditorActionListener, IMoreSettingView {
    public static final int BLUETOOTH_INDEX = 1;
    public static final int DYNAMIC_3D_INDEX = 4;
    public static final int FLOAT_INDEX = 7;
    private static final long K_INTERNEL_CLICK = 1000;
    private static final long K_MAX_CLICK = 7;
    public static final int LICENSE_PLATES_LIMIT_INDEX = 0;
    public static final int LIST_OPTION_CNT = 8;
    public static final int PARK_INDEX = 6;
    public static final int REAL_ENLARGE_INDEX = 3;
    public static final int SCALE_INDEX = 2;
    private static final int SHOT_NAME_CELLS_CNT = 9;
    public static final int SHOW_CAR_LOGO_TO_END_INDEX = 5;
    private static String TAG = ModuleName.ROUTEGUIDE;
    private static String mPlateNumTag = "";
    private RelativeLayout carPlateParent;
    private RadioGroup dayModeSelector;
    private RadioGroup guideAngleSeletor;
    private int[] hDividerLineView = new int[]{C4048R.id.bnav_rg_menu_h_split_0, C4048R.id.bnav_rg_menu_h_split_1, C4048R.id.bnav_rg_menu_h_split_2, C4048R.id.bnav_rg_menu_h_split_3, C4048R.id.bnav_rg_menu_h_split_4, C4048R.id.bnav_rg_menu_h_split_5, C4048R.id.bnav_rg_menu_h_split_6, C4048R.id.bnav_rg_menu_h_split_7, C4048R.id.bnav_rg_menu_h_split_8, C4048R.id.bnav_rg_menu_h_split_10, C4048R.id.bnav_rg_menu_h_split_11, C4048R.id.bnav_rg_menu_h_split_12, C4048R.id.bnav_rg_menu_h_split_13, C4048R.id.bnav_rg_menu_h_split_14};
    private boolean isInputMethodShowing = false;
    private int[] mBackgroundView = new int[]{C4048R.id.nav_view_car_logo_select_layout, C4048R.id.nav_view_voice_selector_rg, C4048R.id.nav_license_plates_limit_layout, C4048R.id.car_plate_setting_view, C4048R.id.nav_bluetooth_layout, C4048R.id.nav_during_tv, C4048R.id.nav_guide_angle_text_tv, C4048R.id.nav_view_guide_angle_selector_rg, C4048R.id.nav_day_night_mode_tv, C4048R.id.nav_view_night_mode_selector_rg, C4048R.id.nav_overview_text_tv, C4048R.id.nav_view_overview_selector_rg, C4048R.id.nav_scale_layout, C4048R.id.nav_real_enlarge_layout, C4048R.id.nav_show_car_logo_to_end_layout, C4048R.id.nav_additional_right_tv, C4048R.id.nav_park_layout, C4048R.id.nav_float_setting_layout, C4048R.id.nav_music_volume_tv, C4048R.id.nav_view_music_volume_selector_rg, C4048R.id.nav_common_use_tv, C4048R.id.nav_voice_switch_layout, C4048R.id.nav_view_menu_more_setting_panel, C4048R.id.car_plate_input_parent};
    private ImageView mCarLogoArrowView = null;
    private ImageView mCarLogoRedGuide;
    private String mCarNum = "";
    private TextView mCarPlate;
    private ImageButton mCarPlateDelete;
    private TextView mCarPlateHead;
    private EditText mCarPlateInput;
    private RelativeLayout mCarPlateSettingView;
    private TextView mCarPlateTs;
    private ImageView[] mCheckboxs = new ImageView[8];
    private LinearLayout mCityShortName;
    private final String[] mCityShotNames = new String[]{"京", "沪", "浙", "苏", "粤", "鲁", "晋", "冀", "豫", "川", "渝", "辽", "吉", "黑", "皖", "鄂", "湘", "赣", "闽", "陕", "甘", "宁", "蒙", "津", "贵", "云", "桂", "琼", "青", "新", "藏"};
    private int mClickNum;
    private int[] mDividerCategoryView = new int[]{C4048R.id.bnav_rg_menu_car_logo_category, C4048R.id.bnav_rg_menu_show_in_guidence_category, C4048R.id.bnav_rg_menu_margin_top_category};
    private ImageView mIVBlueToothRedGuide;
    private boolean[] mIsChecked = new boolean[8];
    private long mLastClickTime;
    private ScrollView mMenuMoreScroll;
    private MoreSettingPresenter mPresenter = new MoreSettingPresenter(this);
    private int[] mTextViewId = new int[]{C4048R.id.nav_license_plates_limit_title_tv, C4048R.id.nav_logo_tv, C4048R.id.nav_during_tv, C4048R.id.nav_day_night_mode_tv, C4048R.id.nav_real_enlarge_tv, C4048R.id.nav_scale_tv, C4048R.id.nav_additional_right_tv, C4048R.id.nav_park_tv, C4048R.id.nav_bluetooth_tv, C4048R.id.nav_float_setting_tv, C4048R.id.nav_common_use_tv, C4048R.id.nav_voice_text_tv, C4048R.id.nav_during_tv, C4048R.id.nav_guide_angle_text_tv, C4048R.id.nav_day_night_mode_tv, C4048R.id.nav_overview_text_tv, C4048R.id.nav_show_car_logo_to_end_tv, C4048R.id.nav_additional_right_tv, C4048R.id.nav_music_volume_tv, C4048R.id.nav_common_use_tv, C4048R.id.nav_voice_text_tv};
    private int[] mTipsTextViewId = new int[]{C4048R.id.nav_real_enlarge_tips_tv, C4048R.id.nav_scale_tips_tv, C4048R.id.nav_park_tips_tv, C4048R.id.nav_bluetooth_tips_tv, C4048R.id.nav_float_setting_tips_tv, C4048R.id.nav_show_car_logo_to_end_tips_tv, C4048R.id.tv_music_volume_tips, C4048R.id.nav_voice_language_text_tv, C4048R.id.nav_license_plates_limit_tips_tv, C4048R.id.nav_logo_tips_tv};
    private BNCommonTitleBar mTitleBar = null;
    private int[] mTogglebuttonGroup = new int[]{C4048R.id.nav_view_voice_selector_rg, C4048R.id.nav_view_guide_angle_selector_rg, C4048R.id.nav_view_night_mode_selector_rg, C4048R.id.nav_view_overview_selector_rg, C4048R.id.nav_view_music_volume_selector_rg};
    private ImageView mVoiceRedGuide = null;
    private TextView mVoiceTV = null;
    private TextView mVoiceValTips;
    private RadioGroup misicVolumeSelector;
    private RadioGroup oververSelector;
    private View shadowView;
    private OnClickListener shotNameOnclickListener = new C43853();
    private RadioGroup voiceModeSeletor;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuMoreView$1 */
    class C43831 implements TextWatcher {
        C43831() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(s)) {
                try {
                    RGMMMenuMoreView.this.mCarPlate.setText(RGMMMenuMoreView.this.mCarPlateHead.getText() + s.toString().toUpperCase().trim().toString());
                } catch (Exception e) {
                }
            }
        }

        public void afterTextChanged(Editable s) {
            try {
                RGMMMenuMoreView.this.mCarPlateTs.setText("");
                RGMMMenuMoreView.this.mCarPlateTs.setTextColor(Color.parseColor("#7a7c80"));
                if (s.length() >= 6) {
                    if (!RGMMMenuMoreView.this.mIsChecked[0]) {
                        return;
                    }
                    if ((RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0 || RGMMMenuMoreView.this.mCarPlate.getVisibility() == 0) && RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0 && RGMMMenuMoreView.this.checkPlate()) {
                        if (s.length() == 7) {
                            RGMMMenuMoreView.this.mCarPlateTs.setText("(新能源车牌)");
                            RGMMMenuMoreView.this.mCarPlateTs.setTextColor(Color.parseColor("#45cc6a"));
                        }
                        RGMMMenuMoreView.this.mPresenter.handleCheckPlateSuccess(RGMMMenuMoreView.this.mContext, RGMMMenuMoreView.this.mCarNum);
                        RGMMMenuMoreView.this.mPresenter.updatePreferValue(32, RGMMMenuMoreView.this.mIsChecked[0]);
                    }
                } else if (s.length() != 0 || RGMMMenuMoreView.this.mCarPlateInput == null || !RGMMMenuMoreView.this.mCarPlateInput.isShown()) {
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuMoreView$2 */
    class C43842 implements OnFocusChangeListener {
        C43842() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                RGMMMenuMoreView.this.mPresenter.addUserOP(UserOPParams.SETTING_b_2);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuMoreView$3 */
    class C43853 implements OnClickListener {
        C43853() {
        }

        public void onClick(View v) {
            if (v != null && RGMMMenuMoreView.this.mCarPlateInput != null && RGMMMenuMoreView.this.mCarPlate != null && RGMMMenuMoreView.this.mCityShortName != null && RGMMMenuMoreView.this.shadowView != null) {
                RGMMMenuMoreView.this.updatePlateView(((TextView) v).getText().toString());
                if (RGMMMenuMoreView.this.mCarPlateInput != null && RGMMMenuMoreView.this.mCarPlateInput.getText().toString().length() >= 6 && RGMMMenuMoreView.this.mIsChecked[0] && ((RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0 || RGMMMenuMoreView.this.mCarPlate.getVisibility() == 0) && RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0 && RGMMMenuMoreView.this.checkPlate())) {
                    RGMMMenuMoreView.this.mPresenter.handleCheckPlateSuccess(RGMMMenuMoreView.this.mContext, RGMMMenuMoreView.this.mCarNum);
                }
                RGMMMenuMoreView.this.setCityShortPanelVisible(8);
                RGMMMenuMoreView.this.shadowView.setVisibility(8);
            }
        }
    }

    static class AllCapTransMethod extends ReplacementTransformationMethod {
        AllCapTransMethod() {
        }

        protected char[] getOriginal() {
            return new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        }

        protected char[] getReplacement() {
            return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }
    }

    public RGMMMenuMoreView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
    }

    public void initViewById() {
        if (this.mRootView != null) {
            this.mTitleBar = (BNCommonTitleBar) this.mRootView.findViewById(C4048R.id.title_bar);
            if (this.mTitleBar != null) {
                this.mTitleBar.setMiddleTextVisible(true);
                this.mTitleBar.setMiddleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_menu_more_setting));
                this.mTitleBar.setMiddleTextSize(16.0f);
                this.mTitleBar.setRightTextVisible(false);
            }
            this.mMenuMoreScroll = (ScrollView) this.mRootView.findViewById(C4048R.id.bnav_rg_menu_more_scroll);
            this.mCheckboxs[0] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_license_plates_limit_condition_cb);
            this.mCheckboxs[1] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_bluetooth_cb);
            this.mCheckboxs[2] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_scale_cb);
            this.mCheckboxs[3] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_real_enlarge_cb);
            this.mCheckboxs[5] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_show_car_logo_to_end_cb);
            this.mCheckboxs[6] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_park_cb);
            this.mCheckboxs[7] = (ImageView) this.mRootView.findViewById(C4048R.id.nav_float_setting_cb);
            this.mPresenter.initRedGuide();
            this.mIVBlueToothRedGuide = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_menu_blue_hfp_red_guide);
            this.mCarLogoRedGuide = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_menu_car_logo_red_guide);
            this.mVoiceRedGuide = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_menu_voice_red_guide);
            this.mCarLogoArrowView = (ImageView) this.mRootView.findViewById(C4048R.id.nav_logo_right_iv);
            this.mVoiceTV = (TextView) this.mRootView.findViewById(C4048R.id.nav_voice_language_text_tv);
            this.mVoiceValTips = (TextView) this.mRootView.findViewById(C4048R.id.tv_music_volume_tips);
            initActionOnOff();
            initLicensePlatesLimitView();
        }
    }

    public int getPortraitLayoutId() {
        return C4048R.layout.nsdk_layout_rg_mapmode_menu_more_setting;
    }

    public int getLandscapeLayoutId() {
        return C4048R.layout.nsdk_layout_rg_mapmode_menu_more_setting;
    }

    public int getContainerViewId() {
        return C4048R.id.bnav_rg_menu_more_setting_container;
    }

    public LayoutParams generalLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public void updateDataByLast() {
    }

    public void initListener() {
        this.mTitleBar.findViewById(C4048R.id.left_imageview).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_view_car_logo_select_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_license_plates_limit_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_real_enlarge_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_show_car_logo_to_end_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_scale_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_park_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_float_setting_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_bluetooth_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_voice_switch_layout).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_guide_angle_hud_rb).setOnClickListener(this);
        this.mRootView.findViewById(C4048R.id.nav_additional_right_tv).setOnClickListener(this);
        this.mTitleBar.setOnClickListener(this);
    }

    private void initActionOnOff() {
        this.mIsChecked = this.mPresenter.initUserConfig();
        for (int i = 0; i < 8; i++) {
            updateCheckDrawable(i);
        }
        if (this.mCarPlateSettingView != null) {
            if (this.mIsChecked[0]) {
                this.mCarPlateSettingView.setVisibility(0);
            } else {
                this.mCarPlateSettingView.setVisibility(8);
            }
        }
        initRadioGroups();
    }

    private void initRadioGroups() {
        this.voiceModeSeletor = (RadioGroup) this.mRootView.findViewById(C4048R.id.nav_view_voice_selector_rg);
        this.guideAngleSeletor = (RadioGroup) this.mRootView.findViewById(C4048R.id.nav_view_guide_angle_selector_rg);
        this.dayModeSelector = (RadioGroup) this.mRootView.findViewById(C4048R.id.nav_view_night_mode_selector_rg);
        this.oververSelector = (RadioGroup) this.mRootView.findViewById(C4048R.id.nav_view_overview_selector_rg);
        this.misicVolumeSelector = (RadioGroup) this.mRootView.findViewById(C4048R.id.nav_view_music_volume_selector_rg);
        this.mPresenter.initActionSwitchSetting();
        this.voiceModeSeletor.setOnCheckedChangeListener(this);
        this.guideAngleSeletor.setOnCheckedChangeListener(this);
        this.dayModeSelector.setOnCheckedChangeListener(this);
        this.oververSelector.setOnCheckedChangeListener(this);
        this.misicVolumeSelector.setOnCheckedChangeListener(this);
    }

    private void initLicensePlatesLimitView() {
        this.mCarPlateSettingView = (RelativeLayout) this.mRootView.findViewById(C4048R.id.car_plate_setting_view);
        this.carPlateParent = (RelativeLayout) this.mRootView.findViewById(C4048R.id.car_plate_input_parent);
        this.mCarPlateTs = (TextView) this.mRootView.findViewById(C4048R.id.nav_limit_tips_tv);
        this.mCarPlateInput = (EditText) this.mRootView.findViewById(C4048R.id.car_plate_input);
        this.mCarPlateDelete = (ImageButton) this.mRootView.findViewById(C4048R.id.car_plate_delete);
        this.mCarPlateHead = (TextView) this.mRootView.findViewById(C4048R.id.car_plate_head);
        this.mRootView.findViewById(C4048R.id.nav_license_plates_limit_link_tv).setOnClickListener(this);
        this.mCarPlate = (TextView) this.mRootView.findViewById(C4048R.id.car_plate);
        this.mCityShortName = (LinearLayout) this.mRootView.findViewById(C4048R.id.city_shortname);
        this.shadowView = this.mRootView.findViewById(C4048R.id.mark);
        initPlateInput();
        updateCheckDrawable(0);
        this.mCarPlateDelete.setOnClickListener(this);
        this.mCarPlate.setOnClickListener(this);
        this.mPresenter.initPlateFromLocal(this.mContext);
        this.mCarPlateInput.setOnEditorActionListener(this);
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        if (this.isInputMethodShowing) {
            this.isInputMethodShowing = false;
            openCarPlatDirectly(true);
        }
    }

    public void setInputMethodShowFlag() {
        if (isVisibility()) {
            InputMethodManager imm = (InputMethodManager) this.mCarPlateInput.getContext().getSystemService("input_method");
            if (this.mCarPlateInput != null && this.mCarPlateInput.isFocused() && imm.isActive(this.mCarPlateInput)) {
                this.isInputMethodShowing = true;
            }
        }
    }

    public void show(Bundle bundle) {
        super.show(bundle);
        RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(BNRoutePlaner.getInstance().getCalcPreference());
        RGNotificationController.getInstance().hideAllCommonView();
        RGNotificationController.getInstance().hideAllOperableView();
        this.mPresenter.getVoiceName();
        initActionOnOff();
        this.mPresenter.getPlateFromLocal(this.mContext);
        if (bundle != null) {
            boolean openCarPlate = bundle.getBoolean("open_car_plate", false);
            LogUtil.m15791e(TAG, "openCarPlate: " + openCarPlate);
            if (openCarPlate) {
                openCarPlatDirectly(false);
            }
        }
        XDVoiceInstructManager.getInstance().setWakeupEnable(false);
    }

    public void hide() {
        if (isVisibility()) {
            RGViewController.getInstance().updateToolBoxStatus();
        }
        super.hide();
        hideInputMethodView();
        setCityShortPanelVisible(8);
        XDVoiceInstructManager.getInstance().setWakeupEnable(true);
    }

    private void openCarPlatDirectly(boolean isOrientation) {
        if (isOrientation) {
            showInputMethodView();
            return;
        }
        this.mMenuMoreScroll.scrollTo(0, 0);
        if (!this.mIsChecked[0]) {
            reverseItemCheck(0);
            this.mPresenter.onSettingsChange(this.mIsChecked, 0);
        }
        showInputMethodView();
    }

    public void onClick(View v) {
        if (v != null) {
            try {
                switch (v.getId()) {
                    case C4048R.id.left_imageview /*1711865878*/:
                        if (this.mSubViewListener != null) {
                            this.mSubViewListener.onMenuMoreAction();
                            return;
                        }
                        return;
                    case C4048R.id.title_bar /*1711865893*/:
                        return;
                    case C4048R.id.nav_voice_switch_layout /*1711866792*/:
                        BNSettingManager.setFirstVoiceGuide(true);
                        if (this.mVoiceRedGuide != null) {
                            this.mVoiceRedGuide.setVisibility(8);
                        }
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_6);
                        if (this.mSubViewListener != null) {
                            this.mSubViewListener.onOtherAction(5, 3, 0, null);
                            return;
                        }
                        return;
                    case C4048R.id.nav_license_plates_limit_layout /*1711866801*/:
                        reverseItemCheck(0);
                        this.mPresenter.onSettingsChange(this.mIsChecked, 0);
                        if (!this.mIsChecked[0]) {
                            hideInputMethodView();
                            return;
                        } else if (this.mCarPlateInput != null && this.mCarPlateInput.isShown()) {
                            showInputMethodView();
                            return;
                        } else {
                            return;
                        }
                    case C4048R.id.nav_license_plates_limit_link_tv /*1711866805*/:
                        hideInputMethodView();
                        BNaviModuleManager.openCarPlateExplainPage(this.mContext);
                        return;
                    case C4048R.id.car_plate /*1711866808*/:
                        hidePlate();
                        showInput();
                        String plateInfo = this.mCarPlate.getText().toString();
                        String plateHead = "";
                        if (!TextUtils.isEmpty(plateInfo)) {
                            if (plateInfo.length() >= 7) {
                                plateHead = plateInfo.substring(0, 1);
                                plateInfo = plateInfo.substring(1, plateInfo.length());
                                this.mCarPlateInput.setText(plateInfo);
                                this.mCarPlateInput.setSelection(plateInfo.length());
                            }
                            this.mCarPlateHead.setText(plateHead);
                            showInputMethodView();
                            return;
                        }
                        return;
                    case C4048R.id.car_plate_head /*1711866810*/:
                        showDialogCityShotName();
                        return;
                    case C4048R.id.car_plate_input /*1711866811*/:
                        this.mPresenter.addUserOP(UserOPParams.SETTING_b_2);
                        return;
                    case C4048R.id.car_plate_delete /*1711866812*/:
                        if (this.mCarPlate != null && this.mCarPlateInput != null) {
                            this.mCarPlate.setText("");
                            this.mCarPlateInput.setText("");
                            hidePlate();
                            showInput();
                            return;
                        }
                        return;
                    case C4048R.id.nav_bluetooth_layout /*1711866814*/:
                        this.mPresenter.setBlueToothChannelGuide(this.mContext, this.mIsChecked[1]);
                        return;
                    case C4048R.id.nav_view_car_logo_select_layout /*1711866820*/:
                        this.mPresenter.setCarLogo();
                        return;
                    case C4048R.id.nav_guide_angle_hud_rb /*1711866833*/:
                        this.mPresenter.onChangeAngleHUDModeSetting();
                        return;
                    case C4048R.id.nav_scale_layout /*1711866846*/:
                        reverseItemCheck(2);
                        this.mPresenter.onSettingsChange(this.mIsChecked, 2);
                        return;
                    case C4048R.id.nav_real_enlarge_layout /*1711866851*/:
                        reverseItemCheck(3);
                        this.mPresenter.onSettingsChange(this.mIsChecked, 3);
                        return;
                    case C4048R.id.nav_show_car_logo_to_end_layout /*1711866856*/:
                        reverseItemCheck(5);
                        this.mPresenter.onSettingsChange(this.mIsChecked, 5);
                        return;
                    case C4048R.id.nav_additional_right_tv /*1711866861*/:
                        if (checkClick()) {
                            new BNDebugModelDialog(this.mContext).show();
                            return;
                        }
                        return;
                    case C4048R.id.nav_park_layout /*1711866863*/:
                        reverseItemCheck(6);
                        this.mPresenter.onSettingsChange(this.mIsChecked, 6);
                        return;
                    case C4048R.id.nav_float_setting_layout /*1711866868*/:
                        boolean isOpen = this.mIsChecked[7];
                        if (isOpen) {
                            this.mPresenter.addUserOP(UserOPParams.GUIDE_3_x_1, null, "", null);
                        } else {
                            this.mPresenter.addUserOP(UserOPParams.GUIDE_3_x_1, "", null, null);
                        }
                        if (isOpen || BNaviModuleManager.hasPermission(NaviCommonConstant.OVERLAY_PERMISSION)) {
                            reverseItemCheck(7);
                            this.mPresenter.onSettingsChange(this.mIsChecked, 7);
                            return;
                        }
                        RGViewController.getInstance().showOpenOverlyPermissonDialog();
                        return;
                    case C4048R.id.mark /*1711866879*/:
                        this.shadowView.setVisibility(8);
                        setCityShortPanelVisible(8);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    public void updateStyle(boolean day) {
        if (!getIsTrueCurDay(day)) {
            View category;
            super.updateStyle(day);
            int i = 0;
            while (this.mRootView != null && i < this.hDividerLineView.length) {
                View v = this.mRootView.findViewById(this.hDividerLineView[i]);
                if (v != null) {
                    v.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
                }
                i++;
            }
            i = 0;
            while (this.mRootView != null && i < this.mDividerCategoryView.length) {
                category = this.mRootView.findViewById(this.mDividerCategoryView[i]);
                if (category != null) {
                    category.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_c));
                }
                i++;
            }
            i = 0;
            while (this.mRootView != null && i < this.mBackgroundView.length) {
                category = this.mRootView.findViewById(this.mBackgroundView[i]);
                if (category != null) {
                    category.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
                }
                i++;
            }
            if (day) {
                updateDayModeView();
            } else {
                updateNightModeView();
            }
        }
    }

    private boolean getIsTrueCurDay(boolean day) {
        if (!(this.mRootView == null || this.hDividerLineView.length <= 0 || this.mRootView.findViewById(this.hDividerLineView[0]) == null)) {
            View view = this.mRootView.findViewById(this.hDividerLineView[0]);
            if (VERSION.SDK_INT >= 11) {
                int color = ((ColorDrawable) view.getBackground()).getColor();
                if (JarUtils.getResources() != null) {
                    boolean z;
                    if (color == JarUtils.getResources().getColor(C4048R.color.cl_bg_b)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mIsCurDay = z;
                }
            }
        }
        if (day == this.mIsCurDay) {
            return true;
        }
        return false;
    }

    private void updateDayModeView() {
        this.mCarLogoArrowView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_ic_setting_right_arrow));
        int i = 0;
        while (this.mRootView != null && i < this.mTextViewId.length) {
            TextView text = (TextView) this.mRootView.findViewById(this.mTextViewId[i]);
            if (text != null) {
                text.setTextColor(Color.parseColor("#333333"));
            }
            i++;
        }
        i = 0;
        while (this.mRootView != null && i < this.mTipsTextViewId.length) {
            text = (TextView) this.mRootView.findViewById(this.mTipsTextViewId[i]);
            if (text != null) {
                text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b));
            }
            i++;
        }
        if (this.mTitleBar != null) {
            this.mTitleBar.setTitleBarBackgroundColor(BNStyleManager.getColor(C4048R.color.bnav_titlebar_bg));
            this.mTitleBar.setMiddleTextColor(BNStyleManager.getColor(C4048R.color.bnav_titlebar_middle_text));
            this.mTitleBar.setLeftIconAlpha(1.0f);
            this.mTitleBar.setTitleBarDivideLineBackgroudColor(BNStyleManager.getColor(C4048R.color.bnav_titlebar_divide_line_color_day));
            this.mTitleBar.setLeftImageViewSrc(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_ic_back_new));
        }
        ColorStateList textStateColor = JarUtils.getResources().getColorStateList(C4048R.color.nsdk_color_more_setting_voice_selector);
        i = 0;
        while (this.mTogglebuttonGroup != null && i < this.mTogglebuttonGroup.length) {
            RadioGroup radioGroup = (RadioGroup) this.mRootView.findViewById(this.mTogglebuttonGroup[i]);
            int j = 0;
            while (radioGroup.getChildCount() > 0 && j < radioGroup.getChildCount()) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(j);
                if (textStateColor != null) {
                    radioButton.setTextColor(textStateColor);
                }
                radioButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_more_setting_voice_day));
                j++;
            }
            i++;
        }
        if (this.carPlateParent != null && this.mCarPlate != null && this.mCarPlateInput != null) {
            this.carPlateParent.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_setting_car_plate_input_day_bg));
            this.mCarPlate.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_setting_car_plate_input_day_bg));
            this.mCarPlateInput.setTextColor(-16777216);
            this.mCarPlate.setTextColor(-16777216);
        }
    }

    private void updateNightModeView() {
        this.mCarLogoArrowView.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_ic_setting_night_right_arrow));
        int i = 0;
        while (this.mRootView != null && i < this.mTextViewId.length) {
            TextView text = (TextView) this.mRootView.findViewById(this.mTextViewId[i]);
            if (text != null) {
                text.setTextColor(Color.parseColor("#ffffff"));
            }
            i++;
        }
        i = 0;
        while (this.mRootView != null && i < this.mTipsTextViewId.length) {
            text = (TextView) this.mRootView.findViewById(this.mTipsTextViewId[i]);
            if (text != null) {
                text.setTextColor(Color.parseColor("#606367"));
            }
            i++;
        }
        if (this.mTitleBar != null) {
            this.mTitleBar.setTitleBarBackgroundColor(JarUtils.getResources().getColor(C4048R.color.cl_bg_d_night));
            this.mTitleBar.setMiddleTextColor(Color.parseColor("#ffffff"));
            this.mTitleBar.setLeftIconAlpha(0.3f);
            this.mTitleBar.setTitleBarDivideLineBackgroudColor(BNStyleManager.getColor(C4048R.color.bnav_titlebar_divide_line_color_night));
            this.mTitleBar.setLeftImageViewSrc(BNStyleManager.getDrawable(C4048R.drawable.bnav_titlebar_ic_back_normal_night));
        }
        i = 0;
        while (this.mTogglebuttonGroup != null && i < this.mTogglebuttonGroup.length) {
            RadioGroup radioGroup = (RadioGroup) this.mRootView.findViewById(this.mTogglebuttonGroup[i]);
            int j = 0;
            while (radioGroup.getChildCount() > 0 && j < radioGroup.getChildCount()) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(j);
                radioButton.setTextColor(-1);
                radioButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_more_setting_voice_night));
                j++;
            }
            i++;
        }
        if (this.carPlateParent != null && this.mCarPlate != null && this.mCarPlateInput != null) {
            this.carPlateParent.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_setting_car_plate_input_night_bg));
            this.mCarPlate.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.bnav_setting_car_plate_input_night_bg));
            this.mCarPlateInput.setTextColor(-1);
            this.mCarPlate.setTextColor(-1);
        }
    }

    public void updateBlueToothView(boolean open) {
        try {
            this.mIsChecked[1] = open;
            updateCheckDrawable(1);
        } catch (Exception e) {
        }
    }

    public void updateCheckDrawable(int index) {
        try {
            if (this.mIsChecked[index]) {
                this.mCheckboxs[index].setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkin_icon));
            } else {
                this.mCheckboxs[index].setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_set_checkout_icon));
            }
        } catch (Exception e) {
        }
    }

    public void onCarPlateInputLayoutVisible(int visible) {
        if (this.mCarPlateSettingView != null && this.mCarPlateTs != null) {
            this.mCarPlateSettingView.setVisibility(visible);
            this.mCarPlateTs.setVisibility(visible);
            if (visible == 8 && JarUtils.getResources().getString(C4048R.string.setting_license_plates_limit_error).equals(this.mCarPlateTs.getText().toString())) {
                this.mCarPlateTs.setText("");
            }
        }
    }

    private void reverseItemCheck(int index) {
        try {
            this.mIsChecked[index] = !this.mIsChecked[index];
        } catch (Exception e) {
        }
    }

    private void initPlateInput() {
        if (this.mCarPlateInput != null && this.mCarPlateHead != null && this.mCarPlate != null) {
            this.mCarPlateInput.addTextChangedListener(new C43831());
            this.mCarPlateInput.setTransformationMethod(new AllCapTransMethod());
            this.mCarPlateHead.setOnClickListener(this);
            this.mCarPlateInput.setClickable(true);
            this.mCarPlateInput.setOnClickListener(this);
            this.mCarPlateInput.setOnFocusChangeListener(new C43842());
        }
    }

    private boolean checkPlate() {
        if (this.mCarPlate == null || this.mCarPlateInput == null) {
            return false;
        }
        this.mCarNum = this.mCarPlate.getText().toString().trim();
        if (TextUtils.isEmpty(this.mCarNum)) {
            this.mCarNum = this.mCarPlateInput.getText().toString().trim();
        }
        return this.mPresenter.checkPlate(this.mCarNum);
    }

    private boolean hideInputMethodView() {
        if (this.mCarPlateInput == null) {
            return false;
        }
        InputMethodManager imm = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (imm == null || !imm.isActive()) {
            return false;
        }
        imm.hideSoftInputFromWindow(this.mCarPlateInput.getWindowToken(), 0);
        this.mCarPlateInput.clearFocus();
        return true;
    }

    private void showInputMethodView() {
        if (this.mCarPlateInput != null) {
            this.mCarPlateInput.setFocusable(true);
            this.mCarPlateInput.setFocusableInTouchMode(true);
            this.mCarPlateInput.requestFocus();
            InputMethodManager imm = (InputMethodManager) this.mCarPlateInput.getContext().getSystemService("input_method");
            if (imm != null) {
                imm.showSoftInput(this.mCarPlateInput, 0);
            }
        }
    }

    private void hideInput() {
        if (this.carPlateParent != null) {
            this.carPlateParent.setVisibility(8);
        }
    }

    private void hidePlate() {
        if (this.mCarPlate != null && this.mCarPlateDelete != null) {
            hideInputMethodView();
            this.mCarPlate.setVisibility(8);
            this.mCarPlateDelete.setVisibility(8);
        }
    }

    private void showPlate() {
        if (this.mCarPlate != null && this.mCarPlateDelete != null) {
            this.mCarPlate.setVisibility(0);
            this.mCarPlateDelete.setVisibility(0);
        }
    }

    private void updatePlateView(String plateHead) {
        if (this.mCarPlateHead != null && this.mCarPlate != null) {
            if (TextUtils.isEmpty(plateHead)) {
                this.mCarPlateHead.setText("");
                return;
            }
            this.mCarPlateHead.setText(plateHead);
            this.mCarPlate.setText(plateHead + this.mCarPlateInput.getText().toString().toUpperCase().trim());
        }
    }

    private void showInput() {
        if (this.carPlateParent != null) {
            this.carPlateParent.setVisibility(0);
            this.mCarPlateInput.setFocusable(true);
            this.mCarPlateInput.setFocusableInTouchMode(true);
            this.mCarPlateInput.requestFocus();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 3001) {
            if (BNaviModuleManager.hasPermission(NaviCommonConstant.OVERLAY_PERMISSION)) {
                reverseItemCheck(7);
                this.mPresenter.onSettingsChange(this.mIsChecked, 7);
            }
        } else if (requestCode == 3002 && this.mPresenter != null) {
            this.mPresenter.getVoiceName();
        }
    }

    private void showDialogCityShotName() {
        if (this.mCityShortName != null && this.shadowView != null) {
            hideInputMethodView();
            this.mCityShortName.requestFocus();
            if (this.mCityShortName.getVisibility() == 0) {
                setCityShortPanelVisible(8);
                this.shadowView.setVisibility(8);
                return;
            }
            setCityShortPanelVisible(0);
            this.shadowView.setVisibility(0);
            this.shadowView.setOnClickListener(this);
            this.mCityShortName.setClickable(true);
            this.mCityShortName.removeAllViews();
            int i = 0;
            while (i < this.mCityShotNames.length) {
                if (i == 0 || i % 9 == 0) {
                    LinearLayout itemRow = (LinearLayout) JarUtils.inflate((Activity) this.mContext, C4048R.layout.city_short_name, null);
                    for (int j = 0; j < 9; j++) {
                        LinearLayout item = (LinearLayout) JarUtils.inflate((Activity) this.mContext, C4048R.layout.city_short_name_item, null);
                        item.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
                        TextView textView = (TextView) item.findViewById(C4048R.id.text_view);
                        if (i < this.mCityShotNames.length) {
                            textView.setText(this.mCityShotNames[i]);
                            textView.setOnClickListener(this.shotNameOnclickListener);
                        } else {
                            textView.setVisibility(4);
                        }
                        itemRow.addView(item);
                        i++;
                    }
                    this.mCityShortName.addView(itemRow);
                }
            }
        }
    }

    private void setCityShortPanelVisible(int visible) {
        if (this.mCityShortName != null) {
            this.mCityShortName.setVisibility(visible);
        }
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case C4048R.id.nav_voice_detail_rb /*1711866797*/:
                this.mPresenter.onChangeDetailVoiceModeSetting();
                changeContinewNavi();
                return;
            case C4048R.id.nav_voice_concise_rb /*1711866798*/:
                this.mPresenter.onChangeConciseVoiceModeSetting();
                changeContinewNavi();
                return;
            case C4048R.id.nav_voice_mute_rb /*1711866799*/:
                this.mPresenter.onChangeQuiteVoiceModeSetting();
                changeContinewNavi();
                return;
            case C4048R.id.nav_guide_angle_follow_rb /*1711866831*/:
                this.mPresenter.onChangeAngleFollowModeSetting();
                return;
            case C4048R.id.nav_guide_angle_true_north_rb /*1711866832*/:
                this.mPresenter.onChangeAngleTrueNorthModeSetting();
                return;
            case C4048R.id.nav_night_mode_auto_rb /*1711866837*/:
                this.mPresenter.setNaviDayAndNightMode(1);
                return;
            case C4048R.id.nav_day_mode_rb /*1711866838*/:
                this.mPresenter.setNaviDayAndNightMode(2);
                return;
            case C4048R.id.nav_night_mode_rb /*1711866839*/:
                this.mPresenter.setNaviDayAndNightMode(3);
                return;
            case C4048R.id.nav_overview_thumbnail_rb /*1711866843*/:
                this.mPresenter.setRouteConditionOverView(0);
                changeContinewNavi();
                return;
            case C4048R.id.nav_overview_road_condition_rb /*1711866844*/:
                this.mPresenter.setRouteConditionOverView(1);
                changeContinewNavi();
                return;
            case C4048R.id.nav_music_volume_lower_rb /*1711866876*/:
                this.mPresenter.setPlayTTSMusicMode(0);
                if (this.mVoiceValTips != null) {
                    this.mVoiceValTips.setText(JarUtils.getResources().getString(C4048R.string.setting_val_lower));
                    return;
                }
                return;
            case C4048R.id.nav_music_volume_stop_rb /*1711866877*/:
                this.mPresenter.setPlayTTSMusicMode(1);
                if (this.mVoiceValTips != null) {
                    this.mVoiceValTips.setText(JarUtils.getResources().getString(C4048R.string.setting_val_stop));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void changeContinewNavi() {
        if (NavState.NAV_STATE_OPERATE.equals(RGControlPanelModel.getInstance().getNavState()) && this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(3, 0, 0, null);
        }
    }

    public void updateVoiceName(String voiceName) {
        if (this.mVoiceTV != null) {
            this.mVoiceTV.setText(voiceName);
        }
    }

    public void setVoiceSpeakSetting(int settingType, int value) {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(6, settingType, value, null);
        }
    }

    public void showCarPlate(String carPlate) {
        mPlateNumTag = carPlate;
        this.mCarNum = carPlate;
        if (!TextUtils.isEmpty(this.mCarNum)) {
            showPlate();
            hideInput();
            if (this.mCarNum.length() >= 1) {
                this.mCarPlateHead.setText(this.mCarNum.substring(0, 1));
                this.mCarPlateInput.setText(this.mCarNum.substring(1));
            }
            this.mPresenter.updatePreferValue(32, this.mIsChecked[0]);
        }
    }

    public void showBlueToothChannelGuide(boolean isConnect) {
        this.mIVBlueToothRedGuide.setVisibility(8);
        if (isConnect) {
            RGMapModeViewController.getInstance().showBtOscDialog();
        } else {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.alert_bt_osc_no_Bt));
        }
    }

    public void jumpCarLogoPage() {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onCarLogoAction();
        }
    }

    public void onBlueToothRedGuide(boolean isShow) {
        if (this.mIVBlueToothRedGuide != null && isShow) {
            this.mIVBlueToothRedGuide.setVisibility(0);
        }
    }

    public void onCarLogoRedGuide(boolean isShow) {
        if (this.mCarLogoRedGuide != null) {
            if (isShow) {
                this.mCarLogoRedGuide.setVisibility(0);
            } else {
                this.mCarLogoRedGuide.setVisibility(8);
            }
        }
    }

    public void onVoiceRedGuide(boolean isShow) {
        if (this.mVoiceRedGuide != null && isShow) {
            this.mVoiceRedGuide.setVisibility(0);
        }
    }

    public void getVoiceMode(int index) {
        if (index == 0) {
            this.voiceModeSeletor.check(C4048R.id.nav_voice_detail_rb);
        } else if (index == 1) {
            this.voiceModeSeletor.check(C4048R.id.nav_voice_concise_rb);
        } else {
            this.voiceModeSeletor.check(C4048R.id.nav_voice_mute_rb);
        }
    }

    public void getMapMode(int index) {
        if (this.guideAngleSeletor == null) {
            return;
        }
        if (index == 0) {
            this.guideAngleSeletor.check(C4048R.id.nav_guide_angle_follow_rb);
        } else if (index == 1) {
            this.guideAngleSeletor.check(C4048R.id.nav_guide_angle_true_north_rb);
        }
    }

    public void getNaviDayAndNightMode(int index) {
        if (this.dayModeSelector == null) {
            return;
        }
        if (index == 0) {
            this.dayModeSelector.check(C4048R.id.nav_night_mode_auto_rb);
        } else if (index == 1) {
            this.dayModeSelector.check(C4048R.id.nav_day_mode_rb);
        } else {
            this.dayModeSelector.check(C4048R.id.nav_night_mode_rb);
        }
    }

    public void setNaviDayAndNightMode(int index) {
        if (this.dayModeSelector == null) {
            return;
        }
        if (index == 3) {
            this.dayModeSelector.check(C4048R.id.nav_night_mode_rb);
        } else if (index == 2) {
            this.dayModeSelector.check(C4048R.id.nav_day_mode_rb);
        } else {
            this.dayModeSelector.check(C4048R.id.nav_night_mode_auto_rb);
        }
    }

    public void getIsShowMapSwitch(int index) {
        if (this.oververSelector == null) {
            return;
        }
        if (index == 0) {
            this.oververSelector.check(C4048R.id.nav_overview_thumbnail_rb);
        } else {
            this.oververSelector.check(C4048R.id.nav_overview_road_condition_rb);
        }
    }

    public void getPlayTTsVoiceMode(int index) {
        if (this.misicVolumeSelector != null && this.mVoiceValTips != null) {
            if (index == 0) {
                this.misicVolumeSelector.check(C4048R.id.nav_music_volume_lower_rb);
                this.mVoiceValTips.setText(JarUtils.getResources().getString(C4048R.string.setting_val_lower));
                return;
            }
            this.misicVolumeSelector.check(C4048R.id.nav_music_volume_stop_rb);
            this.mVoiceValTips.setText(JarUtils.getResources().getString(C4048R.string.setting_val_stop));
        }
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId != 4 && (event == null || event.getKeyCode() != 66)) {
            return false;
        }
        hideInputMethodView();
        return true;
    }

    public boolean checkMenuMoreViewPlateChanged() {
        if (!this.mIsChecked[0] || this.mCarPlateInput == null || this.mCarPlateHead == null) {
            return false;
        }
        String num = this.mCarPlateHead.getText().toString().trim() + this.mCarPlateInput.getText().toString().trim();
        if (StringUtils.isEmpty(mPlateNumTag) || StringUtils.isEmpty(num) || mPlateNumTag.equals(num)) {
            return false;
        }
        return true;
    }

    public boolean menuMoreViewCloseAble() {
        if (this.mCityShortName != null && this.mCityShortName.isShown()) {
            setCityShortPanelVisible(8);
            return false;
        } else if (!this.mIsChecked[0]) {
            return true;
        } else {
            if (carPlateNumIsEmpty()) {
                reverseItemCheck(0);
                this.mPresenter.onSettingsChange(this.mIsChecked, 0);
                if (this.mIsChecked[0]) {
                    return true;
                }
                hideInputMethodView();
                return true;
            }
            boolean validity = checkPlate();
            if (validity) {
                return validity;
            }
            this.mCarPlateTs.setTextColor(-65536);
            this.mCarPlateTs.setText(JarUtils.getResources().getString(C4048R.string.setting_license_plates_limit_error));
            this.mCarPlateTs.setVisibility(0);
            return validity;
        }
    }

    private boolean carPlateNumIsEmpty() {
        if (this.mCarPlate == null || this.mCarPlateInput == null || TextUtils.isEmpty(this.mCarPlateInput.getText().toString().trim())) {
            return true;
        }
        return false;
    }

    public void onSwitchBackground(boolean isBackground) {
        if (!isBackground && this.mCityShortName != null && this.mCityShortName.isShown()) {
            hideInputMethodView();
        }
    }

    public void updateGuideAngleSeletor() {
        if (BNSettingManager.getMapMode() == 1) {
            getMapMode(0);
        } else {
            getMapMode(1);
        }
    }

    public void onResume() {
        if (this.mPresenter != null) {
            this.mPresenter.getVoiceName();
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
}
