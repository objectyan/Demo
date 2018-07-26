package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.view.TopBarView;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.control.CruiseMapController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.cruise.view.CruiseMenu;
import com.baidu.navisdk.ui.util.TipTool;

public class CruiseMapView {
    private static final String TAG = "Cruise";
    private static final int[] sVerticalLineViewIds = new int[]{C0965R.id.line_cruise_bottom_1, C0965R.id.line_cruise_bottom_2};
    private Activity mActivity;
    private ImageView mBatteryIcon = null;
    private TextView mBatteryTv = null;
    private View mBottomBar;
    private boolean mIsPortrait = true;
    boolean mIsVisible = false;
    public CruiseMainInfoPanel mMainInfoPanel;
    private CruiseMapControlPanel mMapControlPanel;
    private CruiseMenu mMenuView;
    private OnTouchListener mOnTouchListener = new C37663();
    private View mQuitBtn;
    private IQuitCruiseClickListener mQuitCruiseClickListener;
    private ImageView mQuitImageView;
    private View mRoadInfoLayout;
    private TextView mRoadNameTextView;
    private TextView mRoadTitleTextView;
    private ViewGroup mRootView;
    private TopBarView mTopBarView;
    private View[] mVerticalLineViews;

    public interface IQuitCruiseClickListener {
        void onClickQuitCruise();
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapView$1 */
    class C37641 implements OnClickListener {
        C37641() {
        }

        public void onClick(View v) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.CRUISEMODE_OFF, NaviStatConstants.CRUISEMODE_OFF);
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapView$2 */
    class C37652 implements OnClickListener {
        C37652() {
        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapView$3 */
    class C37663 implements OnTouchListener {
        C37663() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (CruiseMapView.this.mMapControlPanel != null) {
                CruiseMapView.this.mMapControlPanel.autoHide();
            }
            return false;
        }
    }

    public CruiseMapView(Activity activity, ViewGroup viewGroup, boolean portrait) {
        this.mActivity = activity;
        this.mIsPortrait = portrait;
        this.mRootView = (ViewGroup) StyleManager.inflate(C0965R.layout.nsdk_layout_cruise_map_land, null);
        if (this.mRootView != null && viewGroup != null) {
            viewGroup.addView(this.mRootView);
            this.mRootView.setOnTouchListener(this.mOnTouchListener);
            this.mMapControlPanel = new CruiseMapControlPanel(activity, viewGroup, portrait);
            this.mMainInfoPanel = new CruiseMainInfoPanel(activity, viewGroup);
            this.mQuitBtn = viewGroup.findViewById(C0965R.id.bnav_cruise_rg_btn_quit);
            this.mQuitBtn.setOnClickListener(new C37641());
            this.mQuitImageView = (ImageView) viewGroup.findViewById(C0965R.id.img_cruise_quit);
            this.mBottomBar = viewGroup.findViewById(C0965R.id.layout_cruise_bottom);
            this.mRoadInfoLayout = viewGroup.findViewById(C0965R.id.layout_cruise_road_info);
            this.mRoadInfoLayout.setOnClickListener(new C37652());
            this.mRoadNameTextView = (TextView) this.mRoadInfoLayout.findViewById(C0965R.id.text_cruise_road_name);
            this.mRoadTitleTextView = (TextView) this.mRoadInfoLayout.findViewById(C0965R.id.text_cruise_road_title);
            this.mBatteryTv = (TextView) viewGroup.findViewById(C0965R.id.bnav_rg_sg_battery_percent);
            this.mBatteryIcon = (ImageView) viewGroup.findViewById(C0965R.id.bnav_rg_sg_battery_icon);
            this.mTopBarView = (TopBarView) viewGroup.findViewById(C0965R.id.time_battary_top_bar);
            this.mTopBarView.setAlpha(1.0f);
            setCurrentRoadName(CruiseUIModel.getInstance().getCurrentRoadName());
            setCurrentRoadVisible(CruiseUIModel.getInstance().isProvinceDataDownloaded());
            setBatteryStatus(BNPowerSaver.getInstance().getmBatteryLevel(), BNPowerSaver.getInstance().ismIsBatteryCharging());
            if (this.mIsPortrait) {
                this.mVerticalLineViews = new View[sVerticalLineViewIds.length];
                for (int i = 0; i < sVerticalLineViewIds.length; i++) {
                    this.mVerticalLineViews[i] = this.mBottomBar.findViewById(sVerticalLineViewIds[i]);
                }
            }
            show();
            updateControlPanel();
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.autoHide();
            }
        }
    }

    public void onResume() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.onResume();
        }
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.onResume();
        }
    }

    public void updateControlPanel() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.updateView();
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        if (this.mQuitImageView != null && this.mMainInfoPanel != null && this.mRoadNameTextView != null) {
            this.mQuitImageView.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
            this.mQuitImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_common_btn_quit_selector));
            this.mRoadNameTextView.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn));
            this.mRoadNameTextView.setTextColor(StyleManager.getColor(C0965R.color.nav_cl_text));
            this.mMainInfoPanel.onUpdateStyle(dayStyle);
            if (this.mIsPortrait) {
                this.mBottomBar.setBackgroundColor(StyleManager.getColor(C0965R.color.nsdk_cruise_bg_bar));
                this.mRoadTitleTextView.setTextColor(StyleManager.getColor(C0965R.color.nsdk_cruise_text_road_title));
                for (int i = 0; i < this.mVerticalLineViews.length; i++) {
                    if (this.mVerticalLineViews[i] != null) {
                        this.mVerticalLineViews[i].setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_common_line_vertical));
                    }
                }
            } else {
                this.mBottomBar.setBackgroundDrawable(null);
                this.mRoadTitleTextView.setTextColor(StyleManager.getColor(C0965R.color.nsdk_cruise_text_assis));
            }
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.onUpdateStyle(dayStyle);
            }
            this.mTopBarView.a(dayStyle);
        }
    }

    public void show() {
        if (this.mMainInfoPanel != null) {
            this.mIsVisible = true;
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.show();
            }
            setNetworkAvailable(CruiseUIModel.getInstance().isConnected());
        }
    }

    public void hide() {
        if (this.mMainInfoPanel != null) {
            this.mIsVisible = false;
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.hide();
            }
            this.mQuitBtn.setVisibility(4);
            this.mMainInfoPanel.hide();
        }
    }

    public void updateData(Bundle b) {
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.updateData(b);
        }
    }

    public void setViewWhenNoGPS() {
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.setViewWhenNoGPS();
        }
        updateCurrentSpeed(0);
        updateSatelliteViews(0);
    }

    public void setViewWhenGPSRecover() {
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.setViewWhenGPSRecover();
        }
    }

    public void setViewWhenNotLocated() {
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.setViewWhenNotLocated();
        }
        updateCurrentSpeed(0);
        updateSatelliteViews(0);
    }

    public void onConfigurationChanged() {
    }

    public void setNetworkAvailable(boolean hasNetwork) {
        if (!this.mIsVisible) {
            return;
        }
        if (hasNetwork) {
            if (this.mMainInfoPanel != null) {
                this.mMainInfoPanel.setToConnected();
            }
        } else if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.setToDisconnected();
        }
    }

    public void setCurrentRoadName(String roadName) {
        CruiseUIModel.getInstance().setCurrentRoadName(roadName);
        if (this.mRoadNameTextView == null) {
            return;
        }
        if (roadName != null) {
            this.mRoadNameTextView.setText(roadName);
        } else {
            this.mRoadNameTextView.setText(StyleManager.getString(C0965R.string.nsdk_string_cruise_unknow_road));
        }
    }

    public void setCurrentRoadVisible(boolean visible) {
        int visibility = visible ? 0 : 4;
        if (this.mRoadNameTextView != null) {
            this.mRoadNameTextView.setVisibility(visibility);
        }
        if (this.mRoadTitleTextView != null) {
            this.mRoadTitleTextView.setVisibility(8);
        }
    }

    public void updateSatelliteViews(int satelliteNum) {
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.updateSatelliteViews(satelliteNum);
        }
    }

    public void updateCurrentSpeed(int speed) {
        if (this.mMainInfoPanel != null) {
            this.mMainInfoPanel.updateCurrentSpeed(speed);
        }
    }

    public boolean isPortrait() {
        return this.mIsPortrait;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public boolean onBackPressed() {
        if (CruiseUIModel.getInstance().isShowingMenu()) {
            return false;
        }
        return true;
    }

    public boolean isOrientationPortrait() {
        if (this.mActivity == null || this.mActivity.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public void showMapButtons() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.show();
        }
    }

    public void resetLocMode() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.resetLocMode();
        }
    }

    public void setBatteryStatus(int batteryLevel, boolean mIsBatteryCharging) {
        if (this.mBatteryTv != null) {
            this.mBatteryTv.setText(batteryLevel + "%");
        }
        if (!mIsBatteryCharging || this.mBatteryIcon == null) {
            int resId = -1;
            if (batteryLevel <= 35) {
                resId = C0965R.drawable.nsdk_drawable_rg_ic_battery_red;
            } else if (batteryLevel > 35 && batteryLevel <= 65) {
                resId = C0965R.drawable.nsdk_drawable_rg_ic_battery_white_1;
            } else if (batteryLevel > 65 && batteryLevel <= 95) {
                resId = C0965R.drawable.nsdk_drawable_rg_ic_battery_white_2;
            } else if (batteryLevel > 95 && batteryLevel <= 100) {
                resId = C0965R.drawable.nsdk_drawable_rg_ic_battery_white_3;
            }
            if (this.mBatteryIcon != null && resId != -1) {
                this.mBatteryIcon.setImageDrawable(StyleManager.getDrawable(resId));
                return;
            }
            return;
        }
        this.mBatteryIcon.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.nsdk_drawable_rg_ic_battery_charging));
    }

    public void setBCruiserQuitCruiseClickListener(IQuitCruiseClickListener listener) {
        this.mQuitCruiseClickListener = listener;
    }

    public void removeLocModeRunnable() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.removeLocModeRunnable();
        }
    }

    public void handleCruiseVoiceChanged(boolean isShowToast, boolean open) {
        BaiduNaviSDKManager.getInstance().setNaviMuteState(open);
        if (!isShowToast) {
            return;
        }
        if (BaiduNaviSDKManager.getInstance().isNaviMuteState()) {
            TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(C0965R.string.cruise_follow_voice_turn_off));
        } else {
            TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(C0965R.string.cruise_follow_voice_turn_on));
        }
    }

    public void updateItsVoiceBtn() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.updateItsVoiceBtn();
        }
    }

    public void updateItsBtn() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.updateItsBtn();
        }
    }

    public void changeToCar3DView() {
        CruiseMapController.getInstance().changeToCar3DView(true);
        TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(C0965R.string.nsdk_string_cruise_car3d_mode));
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setLocateIcon(1);
        }
    }

    public void changeToNorth2DView() {
        CruiseMapController.getInstance().changeToNorth2DView();
        TipTool.onCreateToastDialog(this.mActivity, StyleManager.getString(C0965R.string.nsdk_string_cruise_north2d_mode));
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setLocateIcon(0);
        }
    }
}
