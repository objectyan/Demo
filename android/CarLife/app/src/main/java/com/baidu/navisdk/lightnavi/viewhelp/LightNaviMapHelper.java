package com.baidu.navisdk.lightnavi.viewhelp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.IItsClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanel.ILocationBtnClickListener;
import com.baidu.navisdk.ui.widget.BNMapControlPanelSimple;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;

public class LightNaviMapHelper {
    private static volatile LightNaviMapHelper mInstance;
    private boolean isRoadCondNeedOpen = false;
    private boolean mAddMapCtrlPanel = true;
    private Context mContext;
    private DistrictInfo mDistrict;
    private boolean mFirstItsOn = false;
    public IItsClickListener mItsClickListener = new C41241();
    private BNMessageDialog mItsSettingAlertDialog;
    private BNMapControlPanelSimple mMapControlPanel;
    private boolean mShowTwoBtn = true;

    /* renamed from: com.baidu.navisdk.lightnavi.viewhelp.LightNaviMapHelper$1 */
    class C41241 implements IItsClickListener {
        C41241() {
        }

        public void onClickIts() {
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_2);
            LightNaviMapHelper.this.mFirstItsOn = BNSettingManager.isFirstItsOn();
            GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
            if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
                LightNaviMapHelper.this.mDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
            }
            if (BNSettingManager.isIpoRoadCondOnOrOff()) {
                BNMapController.getInstance().showTrafficMap(false);
                BNSettingManager.setIpoRoadCondOnOff(false);
                BNaviModuleManager.setIPORCToMap(false);
            } else if (PreferenceHelper.getInstance(LightNaviMapHelper.this.mContext).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
                if (LightNaviMapHelper.this.mFirstItsOn) {
                    BNSettingManager.setFirstItsOn(false);
                }
                if (NetworkUtils.isNetworkAvailable(LightNaviMapHelper.this.mContext)) {
                    BNMapController.getInstance().switchITSMode(true);
                    BNMapController.getInstance().showTrafficMap(true);
                    BNSettingManager.setIpoRoadCondOnOff(true);
                    BNaviModuleManager.setIPORCToMap(true);
                    if (LightNaviMapHelper.this.mDistrict == null || BNMapController.getInstance().checkRoadConditionSupport(LightNaviMapHelper.this.mDistrict.mId)) {
                        TipTool.onCreateToastDialog(LightNaviMapHelper.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_is_on));
                    } else {
                        TipTool.onCreateToastDialog(LightNaviMapHelper.this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_missing_data));
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.viewhelp.LightNaviMapHelper$2 */
    class C41252 implements OnNaviClickListener {
        C41252() {
        }

        public void onClick() {
            if (LightNaviMapHelper.this.mContext != null && LightNaviMapHelper.this.mItsSettingAlertDialog != null) {
                LightNaviMapHelper.this.mItsSettingAlertDialog.dismiss();
                LightNaviMapHelper.this.mItsSettingAlertDialog = null;
            }
        }
    }

    private LightNaviMapHelper(Context context) {
        this.mContext = context;
    }

    public static LightNaviMapHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new LightNaviMapHelper(context);
        }
        return mInstance;
    }

    public void openRoadCond() {
        if (this.isRoadCondNeedOpen) {
            this.isRoadCondNeedOpen = false;
            BNMapController.getInstance().showTrafficMap(true);
            BNSettingManager.setIpoRoadCondOnOff(true);
        }
    }

    public void colsedRoadCond() {
        if (BNSettingManager.isIpoRoadCondOnOrOff()) {
            this.isRoadCondNeedOpen = true;
            BNMapController.getInstance().showTrafficMap(false);
            BNSettingManager.setIpoRoadCondOnOff(false);
        }
    }

    private void showItsSettingDialog() {
        if (this.mItsSettingAlertDialog == null) {
            this.mItsSettingAlertDialog = new BNMessageDialog((Activity) this.mContext);
            this.mItsSettingAlertDialog.setTitleText(BNStyleManager.getString(C4048R.string.alert_notification));
            this.mItsSettingAlertDialog.setMessage(BNStyleManager.getString(C4048R.string.its_switch_to_history));
            this.mItsSettingAlertDialog.setFirstBtnText(BNStyleManager.getString(C4048R.string.alert_know));
            this.mItsSettingAlertDialog.setOnFirstBtnClickListener(new C41252());
        }
        this.mItsSettingAlertDialog.show();
    }

    public void unInit() {
        mInstance = null;
    }

    public void checkITSRoad() {
        if (BNLightNaviManager.getInstance().getType() == 2 && BNSettingManager.isIpoRoadCondOnOrOff() && PreferenceHelper.getInstance(this.mContext).getBoolean(Key.NAVI_REAL_HISTORY_ITS, true)) {
            BNMapController.getInstance().switchITSMode(true);
            BNMapController.getInstance().showTrafficMap(true);
        }
    }

    public void mapSetting() {
        MapController mMapController = BNMapController.getInstance().getMapController();
        if (mMapController != null && mMapController.get3DGestureEnable()) {
            BNMapController.getInstance().getMapController().set3DGestureEnable(false);
        }
        if (BNLightNaviManager.getInstance().getType() == 2) {
            BNMapController.getInstance().setSlightScreenStatus(2);
        } else {
            BNMapController.getInstance().setSlightScreenStatus(1);
        }
        BNRoutePlaner.getInstance().SetRouteSpec(false);
        BNRouteGuider.getInstance().setBrowseStatus(true);
        if (BNLightNaviManager.getInstance().getType() == 2) {
            BNMapController.getInstance().setNightMode(false);
        } else {
            BNMapController.getInstance().setNightMode(true);
        }
    }

    public void onResume() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.onResume();
        }
    }

    public void onPause() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.onPause();
        }
    }

    public void reloadMapControlPanel(View view, ILocationBtnClickListener listener) {
        if (view != null && this.mContext != null && this.mAddMapCtrlPanel) {
            this.mMapControlPanel = new BNMapControlPanelSimple(this.mContext, view, this.mShowTwoBtn);
            this.mMapControlPanel.onUpdateStyle(true);
            this.mMapControlPanel.updateView();
            this.mMapControlPanel.setItsClickListener(this.mItsClickListener);
            this.mMapControlPanel.setLocationBtnClickListener(listener);
        }
    }

    public void loadMapCtrlPanel(View view, boolean showTwoBtn, boolean showMapCtrlPanel, ILocationBtnClickListener listener) {
        this.mShowTwoBtn = showTwoBtn;
        this.mAddMapCtrlPanel = showMapCtrlPanel;
        reloadMapControlPanel(view, listener);
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.setVisible(true);
        }
    }

    public void updateView() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.updateView();
        }
    }

    public void handleScrollGesture() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.handleScrollGesture();
        }
    }

    public void handleSingleTouchGesture() {
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.handleSingleTouchGesture();
        }
    }
}
