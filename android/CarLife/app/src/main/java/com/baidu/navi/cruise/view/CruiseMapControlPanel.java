package com.baidu.navi.cruise.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.carlife.C0965R;
import com.baidu.mobstat.Config;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.cruise.control.CruiseMapController;
import com.baidu.navi.cruise.view.CruiseZoomButtonView.OnZoomBtnClickListener;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class CruiseMapControlPanel {
    private static final int AUTO_HIDE_TIME_DEFAULT = 15000;
    private static final String FIRST_ITS_ON = "FIRST_ITS_ON";
    private static final String TAG = "Cruise";
    private final int CAR_3D_BTN = 1;
    private final int LOC_CAR_BTN = 2;
    private final int NORTH_2D_BTN = 0;
    private Activity mActivity;
    private int mBtnId = 1;
    private Context mContext;
    private CruiseScaleLevelView mCruiseScaleLevelView;
    private CruiseZoomButtonView mCruiseZoomButtonView;
    private Handler mHandler = new Handler();
    private Runnable mHideRunnable = new C37639();
    private boolean mIsItsOpen = false;
    private boolean mIsItsVoiceOpen = true;
    private View mItsButton;
    private ImageView mItsImageView;
    private View mItsVoiceButton;
    private ImageView mItsVoiceImageView;
    private Runnable mLocCarRunnable = new C37606();
    private ProgressBar mLocProgressBar;
    private ImageButton mLocationBtn;
    private View mLocationView;

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$1 */
    class C37551 implements OnZoomBtnClickListener {
        C37551() {
        }

        public void onZoomOutBtnClick() {
            CruiseMapControlPanel.this.autoHide();
            CruiseMapControlPanel.this.mCruiseScaleLevelView.showScale();
        }

        public void onZoomInBtnClick() {
            CruiseMapControlPanel.this.autoHide();
            CruiseMapControlPanel.this.mCruiseScaleLevelView.showScale();
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$2 */
    class C37562 implements OnClickListener {
        C37562() {
        }

        public void onClick(View arg0) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                if (CruiseMapControlPanel.this.mBtnId == 0) {
                    CruiseMapControlPanel.this.mBtnId = (CruiseMapControlPanel.this.mBtnId + 1) % 2;
                    CruiseMapController.getInstance().changeToCar3DView(true);
                    CruiseMapControlPanel.this.showToast(C0965R.string.nsdk_string_cruise_car3d_mode);
                } else if (CruiseMapControlPanel.this.mBtnId == 1) {
                    CruiseMapControlPanel.this.mBtnId = (CruiseMapControlPanel.this.mBtnId + 1) % 2;
                    CruiseMapController.getInstance().changeToNorth2DView();
                    CruiseMapControlPanel.this.showToast(C0965R.string.nsdk_string_cruise_north2d_mode);
                } else if (CruiseMapControlPanel.this.mBtnId == 2) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.CRUISEMODE_ORIENTATE, NaviStatConstants.CRUISEMODE_ORIENTATE);
                    CruiseMapControlPanel.this.locateToCarPt();
                    CruiseMapControlPanel.this.showToast(C0965R.string.nsdk_string_cruise_located_succ);
                }
                CruiseMapControlPanel.this.setLocateIcon(CruiseMapControlPanel.this.mBtnId);
                CruiseMapControlPanel.this.autoHide();
            }
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$3 */
    class C37573 implements OnClickListener {
        C37573() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                if (CruiseMapControlPanel.this.mBtnId == 0) {
                    CruiseMapControlPanel.this.mBtnId = (CruiseMapControlPanel.this.mBtnId + 1) % 2;
                    CruiseMapController.getInstance().changeToCar3DView(true);
                    CruiseMapControlPanel.this.showToast(C0965R.string.nsdk_string_cruise_car3d_mode);
                } else if (CruiseMapControlPanel.this.mBtnId == 1) {
                    CruiseMapControlPanel.this.mBtnId = (CruiseMapControlPanel.this.mBtnId + 1) % 2;
                    CruiseMapController.getInstance().changeToNorth2DView();
                    CruiseMapControlPanel.this.showToast(C0965R.string.nsdk_string_cruise_north2d_mode);
                } else if (CruiseMapControlPanel.this.mBtnId == 2) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.CRUISEMODE_ORIENTATE, NaviStatConstants.CRUISEMODE_ORIENTATE);
                    CruiseMapControlPanel.this.locateToCarPt();
                    CruiseMapControlPanel.this.showToast(C0965R.string.nsdk_string_cruise_located_succ);
                }
                CruiseMapControlPanel.this.setLocateIcon(CruiseMapControlPanel.this.mBtnId);
                CruiseMapControlPanel.this.autoHide();
            }
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$4 */
    class C37584 implements OnClickListener {
        C37584() {
        }

        public void onClick(View v) {
            CruiseMapControlPanel.this.handleItsClick();
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$5 */
    class C37595 implements OnClickListener {
        C37595() {
        }

        public void onClick(View arg0) {
            CruiseMapControlPanel.this.handleItsVoiceClick();
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$6 */
    class C37606 implements Runnable {
        C37606() {
        }

        public void run() {
            CruiseMapControlPanel.this.locateToCarPt();
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$7 */
    class C37617 implements OnNaviClickListener {
        C37617() {
        }

        public void onClick() {
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$8 */
    class C37628 implements OnNaviClickListener {
        C37628() {
        }

        public void onClick() {
            PreferenceHelper.getInstance(CruiseMapControlPanel.this.mContext).putBoolean("FIRST_ITS_ON", false);
            CruiseMapControlPanel.this.showTrafficMap();
        }
    }

    /* renamed from: com.baidu.navi.cruise.view.CruiseMapControlPanel$9 */
    class C37639 implements Runnable {
        C37639() {
        }

        public void run() {
            CruiseMapControlPanel.this.hide();
        }
    }

    public CruiseMapControlPanel(Activity activity, ViewGroup viewGroup, boolean portrait) {
        this.mContext = activity;
        this.mActivity = activity;
        this.mCruiseScaleLevelView = new CruiseScaleLevelView(this.mActivity, viewGroup);
        this.mCruiseScaleLevelView.hide();
        this.mCruiseZoomButtonView = new CruiseZoomButtonView(this.mActivity, viewGroup);
        this.mCruiseZoomButtonView.setZoomBtnClickListener(new C37551());
        this.mLocationBtn = (ImageButton) viewGroup.findViewById(C0965R.id.bnav_cruise_btn_location);
        this.mLocationView = viewGroup.findViewById(C0965R.id.bnav_cruise_location_layout);
        this.mBtnId = PreferenceHelper.getInstance(this.mContext).getBoolean(Key.SP_Last_Cruise_Map_Status, true) ? 0 : 1;
        setLocateIcon(this.mBtnId);
        this.mLocProgressBar = (ProgressBar) viewGroup.findViewById(C0965R.id.bnav_cruise_location_progress);
        if (this.mLocationView != null) {
            this.mLocationView.setOnClickListener(new C37562());
        }
        this.mLocationBtn.setOnClickListener(new C37573());
        this.mItsButton = viewGroup.findViewById(C0965R.id.bnav_cruise_btn_its_switch);
        this.mItsImageView = (ImageView) viewGroup.findViewById(C0965R.id.image_its_switch);
        this.mItsVoiceButton = viewGroup.findViewById(C0965R.id.bnav_cruise_btn_its_voice_witch);
        this.mItsVoiceImageView = (ImageView) viewGroup.findViewById(C0965R.id.image_its_voice_switch);
        this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
        updateItsBtn();
        updateItsVoiceBtn();
        CruiseMapController.getInstance().showTrafficMap(this.mIsItsOpen);
        this.mItsButton.setOnClickListener(new C37584());
        if (this.mItsVoiceButton != null) {
            this.mItsVoiceButton.setOnClickListener(new C37595());
        }
    }

    public void onResume() {
        this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
        updateItsBtn();
        updateItsVoiceBtn();
    }

    public void setLocateIcon(int btnId) {
        LogUtil.m15791e("Cruise", "set locate button icon, btn mode " + btnId);
        if (btnId == 1) {
            this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_orientation));
        } else if (btnId == 0) {
            this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_north));
        } else if (btnId == 2) {
            this.mLocationBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_home_backparking));
        }
    }

    private void locateToCarPt() {
        int i = 1;
        LogUtil.m15791e("Cruise", "locateToCarPt");
        CruiseMapController.getInstance().locateToCarPoint(true);
        if (PreferenceHelper.getInstance(this.mContext).getBoolean(Key.SP_Last_Cruise_Map_Status, true)) {
            i = 0;
        }
        this.mBtnId = i;
        setLocateIcon(this.mBtnId);
    }

    private void showToast(int strResId) {
        TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(strResId));
    }

    public void resetLocMode() {
        this.mBtnId = 2;
        setLocateIcon(this.mBtnId);
        BNRouteGuider.getInstance().setBrowseStatus(true);
        if (this.mHandler != null && this.mLocCarRunnable != null) {
            this.mHandler.removeCallbacks(this.mLocCarRunnable);
            this.mHandler.postDelayed(this.mLocCarRunnable, Config.BPLUS_DELAY_TIME);
        }
    }

    public void removeLocModeRunnable() {
        if (this.mHandler != null && this.mLocCarRunnable != null) {
            this.mHandler.removeCallbacks(this.mLocCarRunnable);
        }
    }

    public void updateItsBtn() {
        this.mIsItsOpen = BNSettingManager.isRoadCondOnOrOff();
        if (this.mIsItsOpen) {
            this.mItsImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_com_traffic_on));
        } else {
            this.mItsImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_com_traffic_off));
        }
    }

    public void updateItsVoiceBtn() {
        if (this.mItsVoiceImageView != null) {
            this.mIsItsVoiceOpen = !BaiduNaviSDKManager.getInstance().isNaviMuteState();
            if (this.mIsItsVoiceOpen) {
                this.mItsVoiceImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_com_broadcast_on));
            } else {
                this.mItsVoiceImageView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_com_broadcast_off));
            }
        }
    }

    public void updateView() {
        updateScale();
        updateZoomButton();
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().UpdataBaseLayers();
    }

    private void updateScale() {
        if (this.mCruiseScaleLevelView != null) {
            this.mCruiseScaleLevelView.update();
        }
    }

    private void updateZoomButton() {
        if (this.mCruiseZoomButtonView != null) {
            this.mCruiseZoomButtonView.updateZoomButton();
        }
    }

    private void showFirstItsDialog() {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            try {
                new BNDialog(this.mActivity).setTitleText(StyleManager.getString(C0965R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(StyleManager.getString(C0965R.string.nsdk_string_cruise_its_first_tip)).setFirstBtnText(StyleManager.getString(C0965R.string.nsdk_string_common_alert_i_know)).setOnFirstBtnClickListener(new C37628()).setSecondBtnText(StyleManager.getString(C0965R.string.nsdk_string_common_alert_cancel)).setOnSecondBtnClickListener(new C37617()).show();
            } catch (Exception e) {
            }
        }
    }

    private void handleItsVoiceClick() {
        boolean z = true;
        autoHide();
        CruiseMapController.getInstance().handleCruiseVoiceChanged(true, true);
        if (BaiduNaviSDKManager.getInstance().isNaviMuteState()) {
            z = false;
        }
        this.mIsItsVoiceOpen = z;
        if (this.mIsItsVoiceOpen) {
            StatisticManager.onEvent(StatisticConstants.NAVI_0008);
        }
        updateItsVoiceBtn();
    }

    private void handleItsClick() {
        autoHide();
        StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
        if (!this.mIsItsOpen && !BNSettingManager.isRoadCondOnOrOff()) {
            StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
            if (!PreferenceHelper.getInstance(this.mContext).getBoolean(SettingParams.Key.NAVI_REAL_HISTORY_ITS, true)) {
                return;
            }
            if (!PreferenceHelper.getInstance(this.mContext).getBoolean("FIRST_ITS_ON", true) || !BCruiser.getInstance().isOfflineDataDownloaded()) {
                showTrafficMap();
            } else if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                PreferenceHelper.getInstance(this.mContext).putBoolean("FIRST_ITS_ON", false);
                showTrafficMap();
            } else {
                TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(C0965R.string.nsdk_string_rg_its_real_offline));
            }
        } else if (this.mIsItsOpen && BNSettingManager.isRoadCondOnOrOff()) {
            CruiseMapController.getInstance().showTrafficMap(false);
            BNSettingManager.setRoadCondOnOff(false);
            this.mIsItsOpen = false;
            updateItsBtn();
            TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(C0965R.string.nsdk_string_rg_its_is_off));
        }
    }

    private void showTrafficMap() {
        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
            TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(C0965R.string.nsdk_string_rg_its_real_offline));
            this.mIsItsOpen = false;
        } else if (isSupportTrafficMap()) {
            CruiseMapController.getInstance().showTrafficMap(true);
            BNSettingManager.setRoadCondOnOff(true);
            this.mIsItsOpen = true;
            TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(C0965R.string.nsdk_string_rg_its_real_is_on));
        } else {
            TipTool.onCreateToastDialog(this.mContext, StyleManager.getString(C0965R.string.nsdk_string_its_online_missing_data));
            return;
        }
        updateItsBtn();
    }

    public void onUpdateStyle(boolean dayStyle) {
        this.mLocationBtn.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
        setLocateIcon(this.mBtnId);
        this.mItsButton.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.carlife_map_its_bg_selector));
        this.mItsImageView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
        this.mItsVoiceImageView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
        updateItsBtn();
        updateItsVoiceBtn();
        this.mCruiseZoomButtonView.onUpdateStyle(dayStyle);
        this.mCruiseScaleLevelView.onUpdateStyle(dayStyle);
    }

    public void show() {
        if (this.mLocationBtn != null && this.mItsButton != null && this.mCruiseZoomButtonView != null && this.mCruiseScaleLevelView != null && this.mItsVoiceButton != null && this.mLocationView != null) {
            this.mLocationBtn.setVisibility(0);
            this.mLocationView.setVisibility(0);
            this.mItsButton.setVisibility(0);
            this.mItsVoiceButton.setVisibility(0);
            this.mCruiseScaleLevelView.show();
            this.mCruiseZoomButtonView.show();
        }
    }

    public void hide() {
        if (this.mLocationBtn != null && this.mItsButton != null && this.mCruiseZoomButtonView != null && this.mCruiseScaleLevelView != null && this.mLocProgressBar != null && this.mItsVoiceButton != null && this.mLocationView != null) {
            this.mLocationBtn.setVisibility(4);
            this.mLocationView.setVisibility(4);
            this.mLocProgressBar.setVisibility(4);
            this.mItsButton.setVisibility(4);
            this.mItsVoiceButton.setVisibility(4);
            this.mCruiseScaleLevelView.hide();
            this.mCruiseZoomButtonView.hide();
        }
    }

    public void onConfigurationChanged() {
    }

    public void autoHide() {
    }

    public void autoHide(long delayMillis) {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, delayMillis);
    }

    private boolean isSupportTrafficMap() {
        GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(this.mActivity.getWindowManager().getDefaultDisplay().getWidth() / 2, this.mActivity.getWindowManager().getDefaultDisplay().getHeight() / 2);
        if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            DistrictInfo mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
            if (!(mDistrict == null || BNMapController.getInstance().checkRoadConditionSupport(mDistrict.mId))) {
                return false;
            }
        }
        return true;
    }
}
