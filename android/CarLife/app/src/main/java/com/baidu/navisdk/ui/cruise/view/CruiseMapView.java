package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.control.CruiseMapController;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.cruise.view.CruiseMapControlPanel.ControlPanelClickListener;
import com.baidu.navisdk.ui.cruise.view.CruiseMenu.IOnMenuItemClickedListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseMapView {
    private static final String TAG = "Cruise";
    private static final int[] sVerticalLineViewIds = new int[]{C4048R.id.line_cruise_bottom_1, C4048R.id.line_cruise_bottom_2};
    private Activity mActivity;
    private ImageView mBatteryIcon = null;
    private TextView mBatteryTv = null;
    private View mBottomBar;
    private boolean mIsPortrait = true;
    boolean mIsVisible = false;
    public CruiseMainInfoPanel mMainInfoPanel;
    private CruiseMapControlPanel mMapControlPanel;
    private ImageView mMenuImageView;
    private View mMenuMaskView;
    private CruiseMenu mMenuView;
    private OnTouchListener mOnTouchListener = new C42893();
    private View mQuitBtn;
    private IQuitCruiseClickListener mQuitCruiseClickListener;
    private ImageView mQuitImageView;
    private View mRoadInfoLayout;
    private TextView mRoadNameTextView;
    private TextView mRoadTitleTextView;
    private ViewGroup mRootView;
    private View[] mVerticalLineViews;

    public interface IQuitCruiseClickListener {
        void onClickQuitCruise();
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseMapView$1 */
    class C42871 implements OnClickListener {
        C42871() {
        }

        public void onClick(View v) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.CRUISEMODE_OFF, NaviStatConstants.CRUISEMODE_OFF);
            if (CruiseMapView.this.mQuitCruiseClickListener != null) {
                CruiseMapView.this.mQuitCruiseClickListener.onClickQuitCruise();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseMapView$2 */
    class C42882 implements IOnMenuItemClickedListener {
        C42882() {
        }

        public void onClickOfflineData() {
        }

        public void onClickHelp() {
        }

        public void onClickClose() {
            CruiseMapView.this.hideMenu();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.cruise.view.CruiseMapView$3 */
    class C42893 implements OnTouchListener {
        C42893() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (CruiseMapView.this.mMenuView.isShowing()) {
                CruiseMapView.this.hideMenu();
            }
            if (CruiseMapView.this.mMapControlPanel != null) {
                CruiseMapView.this.mMapControlPanel.autoHide();
            }
            return false;
        }
    }

    public CruiseMapView(Activity activity, ViewGroup viewGroup, boolean portrait) {
        this.mActivity = activity;
        this.mIsPortrait = portrait;
        this.mRootView = (ViewGroup) JarUtils.inflate(activity, portrait ? C4048R.layout.nsdk_layout_cruise_map : C4048R.layout.nsdk_layout_cruise_map_land, null);
        if (this.mRootView != null && viewGroup != null) {
            viewGroup.addView(this.mRootView);
            this.mRootView.setOnTouchListener(this.mOnTouchListener);
            this.mMapControlPanel = new CruiseMapControlPanel(activity, viewGroup, portrait);
            initMenuView(viewGroup);
            this.mMainInfoPanel = new CruiseMainInfoPanel(activity, viewGroup);
            this.mQuitBtn = viewGroup.findViewById(C4048R.id.bnav_cruise_rg_btn_quit);
            this.mQuitBtn.setOnClickListener(new C42871());
            this.mQuitImageView = (ImageView) viewGroup.findViewById(C4048R.id.img_cruise_quit);
            this.mMenuImageView = (ImageView) viewGroup.findViewById(C4048R.id.img_cruise_setting);
            this.mBottomBar = viewGroup.findViewById(C4048R.id.layout_cruise_bottom);
            this.mRoadInfoLayout = viewGroup.findViewById(C4048R.id.layout_cruise_road_info);
            this.mRoadNameTextView = (TextView) this.mRoadInfoLayout.findViewById(C4048R.id.text_cruise_road_name);
            this.mRoadTitleTextView = (TextView) this.mRoadInfoLayout.findViewById(C4048R.id.text_cruise_road_title);
            this.mBatteryTv = (TextView) viewGroup.findViewById(C4048R.id.bnav_rg_sg_battery_percent);
            this.mBatteryIcon = (ImageView) viewGroup.findViewById(C4048R.id.bnav_rg_sg_battery_icon);
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

    private void initMenuView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            LogUtil.m15791e("Cruise", "initMenuView");
            this.mMenuView = new CruiseMenu(this.mActivity);
            this.mMenuView.initViews();
            ViewGroup menuParent = (ViewGroup) viewGroup.findViewById(C4048R.id.layout_cruise_menu_parent);
            if (menuParent != null) {
                menuParent.addView(this.mMenuView.getView(), 0);
                this.mMenuView.hide();
                this.mMenuView.setMenuItemClickListener(new C42882());
                this.mMenuMaskView = viewGroup.findViewById(C4048R.id.layout_cruise_menu_mask);
                if (this.mMenuMaskView != null) {
                    this.mMenuMaskView.setVisibility(8);
                }
                boolean isShowing = CruiseUIModel.getInstance().isShowingMenu();
                LogUtil.m15791e("Cruise", "initMenuView: isShowingMenu " + isShowing);
                if (isShowing) {
                    showMenu();
                }
            }
        }
    }

    private void showMenu() {
        LogUtil.m15791e("Cruise", "showMenu...");
        if (this.mMenuView != null) {
            this.mMenuView.show();
        }
        if (this.mMenuMaskView != null) {
            this.mMenuMaskView.setVisibility(0);
        }
        CruiseUIModel.getInstance().setIsShowingMenu(true);
    }

    private void hideMenu() {
        LogUtil.m15791e("Cruise", "hideMenu.");
        if (this.mMenuView != null) {
            this.mMenuView.hide();
        }
        if (this.mMenuMaskView != null) {
            this.mMenuMaskView.setVisibility(8);
        }
        CruiseUIModel.getInstance().setIsShowingMenu(false);
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
        if (this.mQuitImageView != null && this.mMainInfoPanel != null && this.mBottomBar != null && this.mRoadTitleTextView != null && this.mRoadNameTextView != null) {
            this.mQuitImageView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.map_bg_btn_selector));
            this.mMainInfoPanel.onUpdateStyle(dayStyle);
            this.mBottomBar.setBackgroundDrawable(null);
            this.mRoadTitleTextView.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_cruise_text_assis));
            this.mRoadNameTextView.setTextColor(JarUtils.getResources().getColor(C4048R.color.nsdk_cruise_text_main));
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.onUpdateStyle(dayStyle);
            }
        }
    }

    public void show() {
        if (this.mMainInfoPanel != null) {
            this.mIsVisible = true;
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.show();
            }
            this.mQuitBtn.setVisibility(0);
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
        if (CruiseUIModel.getInstance().isShowingMenu() && !this.mMenuView.isShowing()) {
            showMenu();
        }
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
            this.mRoadNameTextView.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_cruise_unknow_road));
        }
    }

    public void setCurrentRoadVisible(boolean visible) {
        int visibility = visible ? 0 : 4;
        if (this.mRoadNameTextView != null) {
            this.mRoadNameTextView.setVisibility(visibility);
        }
        if (this.mRoadTitleTextView != null) {
            this.mRoadTitleTextView.setVisibility(visibility);
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
        if (!CruiseUIModel.getInstance().isShowingMenu()) {
            return true;
        }
        hideMenu();
        return false;
    }

    public boolean isOrientationPortrait() {
        return false;
    }

    public void showMapButtons() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.show();
        }
    }

    public void exitCruiser() {
        BCruiser.getInstance().notifyCruiseFragmentQuitCruise();
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
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_red;
            } else if (batteryLevel > 35 && batteryLevel <= 65) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_white_1;
            } else if (batteryLevel > 65 && batteryLevel <= 95) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_white_2;
            } else if (batteryLevel > 95 && batteryLevel <= 100) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_white_3;
            }
            if (this.mBatteryIcon != null && resId != -1) {
                this.mBatteryIcon.setImageDrawable(JarUtils.getResources().getDrawable(resId));
                return;
            }
            return;
        }
        this.mBatteryIcon.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_battery_charging));
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
        if (this.mMenuView != null) {
            this.mMenuView.handleCruiseVoiceChanged(isShowToast, open);
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
        TipTool.onCreateToastDialog(this.mActivity, BNStyleManager.getString(C4048R.string.nsdk_string_cruise_car3d_mode));
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setLocateIcon(1);
        }
    }

    public void changeToNorth2DView() {
        CruiseMapController.getInstance().changeToNorth2DView();
        TipTool.onCreateToastDialog(this.mActivity, BNStyleManager.getString(C4048R.string.nsdk_string_cruise_north2d_mode));
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setLocateIcon(0);
        }
    }

    public void setOnControlPanelClickListener(ControlPanelClickListener listener) {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setControlPanelClickLis(listener);
        }
    }
}
