package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseMenu implements OnClickListener, OnCheckedChangeListener {
    private static final String TAG = CruiseMenu.class.getSimpleName();
    private static final int[] sItemNameTextViewIds = new int[]{C4048R.id.bnav_cruise_menu_tv_data, C4048R.id.bnav_cruise_menu_tv_qa};
    private static final int[] sItemViewIds = new int[]{C4048R.id.layout_cruise_menu_offline_data, C4048R.id.layout_cruise_menu_qa};
    private static final int[] sLineViewIds = new int[]{C4048R.id.bnav_cruise_menu_line1, C4048R.id.bnav_cruise_menu_line2, C4048R.id.bnav_cruise_menu_line3};
    private static final int[] sSettingCheckBoxIds = new int[]{C4048R.id.checkbox_cruise_menu_speed, C4048R.id.checkbox_cruise_menu_camera, C4048R.id.checkbox_cruise_menu_break_rules, C4048R.id.checkbox_cruise_menu_safe};
    public static final String[] sSettingPrefKeys = new String[]{Key.SP_Close_Speed_Camera, Key.SP_Close_Traffic_Camera, Key.SP_Close_Break_Rules, "CloseTrafficSign"};
    private static final String[] sSettingStatEventIds = new String[]{NaviStatConstants.CRUISEMODE_MORE_SPEEDLIMIT, NaviStatConstants.CRUISEMODE_MORE_REDLIGHT, NaviStatConstants.CRUISEMODE_MORE_PECCANCY, NaviStatConstants.CRUISEMODE_MORE_SAFEDRIVING};
    private static final int[][] sSettingToastResIds = new int[][]{new int[]{C4048R.string.nsdk_string_cruise_voice_speed_open, C4048R.string.nsdk_string_cruise_voice_speed_close}, new int[]{C4048R.string.nsdk_string_cruise_voice_camera_open, C4048R.string.nsdk_string_cruise_voice_camera_close}, new int[]{C4048R.string.nsdk_string_cruise_voice_break_rules_open, C4048R.string.nsdk_string_cruise_voice_break_rules_close}, new int[]{C4048R.string.nsdk_string_cruise_voice_safe_open, C4048R.string.nsdk_string_cruise_voice_safe_close}};
    private Activity mActivity;
    private Button mCloseButton;
    private Context mContext;
    private boolean mDayStyle = true;
    private TextView[] mItemNameTextViews = new TextView[sItemNameTextViewIds.length];
    private View[] mItemViews = new View[sItemViewIds.length];
    private View[] mLineViews = new View[sLineViewIds.length];
    private IOnMenuItemClickedListener mMenuBackClickListener = null;
    public View mMenuList;
    private PreferenceHelper mPrefs;
    public View mRootView;
    private CheckBox[] mSettingCheckBoxes = new CheckBox[sSettingCheckBoxIds.length];
    private Bundle mSettingPrefs;
    private TextView mSettingTitleTextView;

    public interface IOnMenuItemClickedListener {
        void onClickClose();

        void onClickHelp();

        void onClickOfflineData();
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseMenu$1 */
    class C42901 implements OnTouchListener {
        C42901() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public CruiseMenu(Context context) {
        this.mActivity = (Activity) context;
        this.mContext = context;
        this.mPrefs = PreferenceHelper.getInstance(context);
        this.mSettingPrefs = new Bundle();
        int oldValue = this.mPrefs.getInt("CloseCamera", 0);
        for (String initSettingPref : sSettingPrefKeys) {
            initSettingPref(initSettingPref, oldValue);
        }
    }

    public void initViews() {
        this.mRootView = JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_cruise_menu, null);
        this.mRootView.setOnTouchListener(new C42901());
        this.mCloseButton = (Button) this.mRootView.findViewById(C4048R.id.btn_cruise_menu_close);
        if (this.mCloseButton != null) {
            this.mCloseButton.setOnClickListener(this);
        }
        this.mMenuList = this.mRootView.findViewById(C4048R.id.layout_cruise_menu_list);
        if (this.mMenuList != null) {
            int i;
            this.mSettingTitleTextView = (TextView) this.mMenuList.findViewById(C4048R.id.text_cruise_menu_voice_setting_title);
            View settingView = this.mMenuList.findViewById(C4048R.id.layout_cruise_menu_voice_setting);
            if (settingView != null) {
                int paddingLeft = BNStyleManager.getDimension(C4048R.dimen.nsdk_checkbox_padding_left);
                if (VERSION.SDK_INT >= 17) {
                    paddingLeft -= ScreenUtil.getInstance().dip2px(20);
                }
                for (i = 0; i < sSettingCheckBoxIds.length; i++) {
                    this.mSettingCheckBoxes[i] = (CheckBox) settingView.findViewById(sSettingCheckBoxIds[i]);
                    if (this.mSettingCheckBoxes[i] != null) {
                        boolean z;
                        this.mSettingCheckBoxes[i].setOnCheckedChangeListener(this);
                        int value = this.mPrefs.getInt(sSettingPrefKeys[i], 0);
                        CheckBox checkBox = this.mSettingCheckBoxes[i];
                        if (value == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        checkBox.setChecked(z);
                        this.mSettingCheckBoxes[i].setPadding(paddingLeft, this.mSettingCheckBoxes[i].getPaddingTop(), this.mSettingCheckBoxes[i].getPaddingRight(), this.mSettingCheckBoxes[i].getPaddingBottom());
                    }
                }
            }
            for (i = 0; i < sItemViewIds.length; i++) {
                this.mItemViews[i] = this.mMenuList.findViewById(sItemViewIds[i]);
                if (this.mItemViews[i] != null) {
                    this.mItemViews[i].setOnClickListener(this);
                }
            }
            for (i = 0; i < sLineViewIds.length; i++) {
                this.mLineViews[i] = this.mMenuList.findViewById(sLineViewIds[i]);
            }
            for (i = 0; i < sItemNameTextViewIds.length; i++) {
                this.mItemNameTextViews[i] = (TextView) this.mMenuList.findViewById(sItemNameTextViewIds[i]);
            }
            onUpdateStyle(this.mDayStyle);
        }
    }

    private void initSettingPref(String prefKey, int oldValue) {
        if (this.mPrefs.contains(prefKey)) {
            this.mSettingPrefs.putInt(prefKey, this.mPrefs.getInt(prefKey, 0));
            return;
        }
        this.mPrefs.putInt(prefKey, oldValue);
        this.mSettingPrefs.putInt(prefKey, oldValue);
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onClick(View v) {
        if (v.getId() == C4048R.id.btn_cruise_menu_close) {
            onMenuBack();
        } else if (v.getId() == C4048R.id.layout_cruise_menu_offline_data) {
            BCruiser.getInstance().innerJumpToOfflineDataManagerPage();
            BNStatisticsManager.getInstance().onEvent(this.mContext, NaviStatConstants.CRUISEMODE_MORE_OFFLINEMAP, NaviStatConstants.CRUISEMODE_MORE_OFFLINEMAP);
        } else if (v.getId() == C4048R.id.layout_cruise_menu_qa) {
            BNStatisticsManager.getInstance().onEvent(this.mContext, NaviStatConstants.CRUISEMODE_MORE_HELP, NaviStatConstants.CRUISEMODE_MORE_HELP);
            showQaDialog();
        }
    }

    private void showQaDialog() {
        if (NetworkUtils.isNetworkAvailable(this.mContext)) {
            new CruiseQADialog(this.mActivity, 16973833).show();
        } else {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_cruise_no_network));
        }
    }

    public void setMenuItemClickListener(IOnMenuItemClickedListener listener) {
        this.mMenuBackClickListener = listener;
    }

    public void onMenuBack() {
        if (this.mMenuBackClickListener != null) {
            this.mMenuBackClickListener.onClickClose();
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        int i = 0;
        this.mDayStyle = dayStyle;
        if (this.mMenuList != null) {
            this.mRootView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.nsdk_cruise_bg_bar));
            this.mCloseButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_cruise_menu_close_bg));
            if (this.mSettingTitleTextView != null) {
                this.mSettingTitleTextView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_setting_list_item_text_main));
            }
            for (CheckBox checkBoxView : this.mSettingCheckBoxes) {
                if (checkBoxView != null) {
                    checkBoxView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_setting_list_item_text_main));
                }
            }
            for (View lineView : this.mLineViews) {
                if (lineView != null) {
                    lineView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_line_horizontal));
                }
            }
            for (View itemView : this.mItemViews) {
                if (itemView != null) {
                    itemView.setBackgroundDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
                    int padding = ScreenUtil.getInstance().dip2px(10);
                    itemView.setPadding(padding, 0, padding, 0);
                }
            }
            TextView[] textViewArr = this.mItemNameTextViews;
            int length = textViewArr.length;
            while (i < length) {
                TextView titleView = textViewArr[i];
                if (titleView != null) {
                    titleView.setTextColor(BNStyleManager.getColor(C4048R.color.nsdk_color_setting_list_item_text_main));
                }
                i++;
            }
        }
    }

    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        for (int i = 0; i < sSettingCheckBoxIds.length; i++) {
            if (button.getId() == sSettingCheckBoxIds[i]) {
                int value = this.mPrefs.getInt(sSettingPrefKeys[i], 0);
                if (isChecked && value == 1) {
                    handleVoiceSettingItemChanged(i, true);
                    return;
                } else if (!isChecked && value == 0) {
                    handleVoiceSettingItemChanged(i, false);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private void handleVoiceSettingItemChanged(int itemIdx, boolean open) {
        int value;
        int index = 0;
        if (open) {
            value = 0;
        } else {
            value = 1;
        }
        if (itemIdx >= 0 && itemIdx < sSettingPrefKeys.length) {
            this.mSettingPrefs.putInt(sSettingPrefKeys[itemIdx], value);
            BNRouteGuider.getInstance().SetCruiseSetting(this.mSettingPrefs);
            this.mPrefs.putInt(sSettingPrefKeys[itemIdx], value);
        }
        if (!open) {
            index = 1;
        }
        if (itemIdx >= 0 && index >= 0 && itemIdx < sSettingToastResIds.length && index < sSettingToastResIds[itemIdx].length) {
            TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(sSettingToastResIds[itemIdx][index]));
        }
        if (itemIdx >= 0 && itemIdx < sSettingStatEventIds.length) {
            BNStatisticsManager.getInstance().onEvent(this.mContext, sSettingStatEventIds[itemIdx], sSettingStatEventIds[itemIdx]);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void show() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(0);
        }
    }

    public void hide() {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(8);
        }
    }

    public boolean isShowing() {
        if (this.mRootView == null || this.mRootView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void handleCruiseVoiceChanged(boolean isShowToast, boolean open) {
        TTSPlayerControl.setNaviMuteState(open);
        if (!isShowToast) {
            return;
        }
        if (TTSPlayerControl.isNaviMuteState()) {
            TipTool.onCreateToastDialog(this.mContext, "电子狗播报已静音");
        } else {
            TipTool.onCreateToastDialog(this.mContext, "电子狗播报已开启");
        }
    }
}
