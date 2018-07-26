package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.BaiduNaviParams.NaviEvent;
import com.baidu.baidunavis.ForegroundService;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.tts.AudioUtils;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.ui.BNDownloadPage;
import com.baidu.baidunavis.ui.NavFragmentManager;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNEventManager.NaviMsgListener;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonCallBackListener;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonConstant;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.OfflineDataParams;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.drivertool.BNDrivingToolUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.LocalMapManager;
import com.baidu.platform.comapi.map.LocalMapResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavCommonFuncController {
    public static final String KEY_USE_LY_TTS = "NAVI_USE_LY_TTS";
    private static final String NAVI_ALWAYS_BRIGHT = "NAVI_ALWAYS_BRIGHT";
    private static final String NAVI_CAMERA_NOTIFY = "NAVI_CAMERA_SPEAK_NOTIFY";
    private static final String NAVI_MODE_DAY_AND_NIGHT = "NAVI_MODE_DAY_AND_NIGHT";
    private static final String NAVI_OVER_SPEED = "NAVI_OVER_SPEED";
    private static final String NAVI_ROUTE_CONDITION = "NAVI_ROUTE_CONDITION";
    private static final String NAVI_STRAIGHT = "NAVI_STRAIGHT";
    private static final String NAVI_VOICE_MODE = "NAVI_VOICE_MODE";
    private static final String NAV_SETTING = "navsetting";
    private static final String PREF_NAVI_FIRST_USE = "PREF_NAVI_FIRST_USE";
    private static final String PREF_NAV_NEED_ADAPTER_SETTING = "nav_need_adapter_setting";
    public static final String TAG = NavCommonFuncController.class.getSimpleName();
    private static NavCommonFuncController sInstance = null;
    boolean[] cityDownLoadFlag = null;
    private final String mBackgroundSpeakMsg = "百度地图将持续为您导航";
    private MainLooperHandler mNavEventHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData()) {
        public void onMessage(Message msg) {
            if (msg != null) {
                synchronized (NavCommonFuncController.this.mNaviEventListeners) {
                    if (NavCommonFuncController.this.mNaviEventListeners != null) {
                        for (NaviEvent event : NavCommonFuncController.this.mNaviEventListeners) {
                            event.onOtherAction(msg.what, msg.arg1, msg.arg2, msg.obj);
                        }
                    }
                }
            }
        }
    };
    public NaviCommonCallBackListener mNaviCommonCallBack = new C07801();
    private NaviMsgListener mNaviEventListener = new C07823();
    private List<NaviEvent> mNaviEventListeners = new ArrayList();
    List<LocalMapResource> mapCitys = null;
    private String voiceEnter = "navi";

    /* renamed from: com.baidu.baidunavis.control.NavCommonFuncController$1 */
    class C07801 implements NaviCommonCallBackListener {
        C07801() {
        }

        public Bundle onNaviCommonMsg(int type, int event, Object arg) {
            if (type == 0) {
                NavMapManager.getInstance().unInit();
            } else if (1 == type) {
                String bduss = NavMapAdapter.getInstance().getBduss();
                if (!TextUtils.isEmpty(bduss)) {
                    bd = new Bundle();
                    bd.putString("bduss", bduss);
                    return bd;
                }
            } else if (6 == type) {
                NavRoutePlanModel.getInstance().addSensorChangeListener((ISensorChangeListener) arg);
            } else if (7 == type) {
                NavRoutePlanModel.getInstance().removeSensorChangeListener((ISensorChangeListener) arg);
            } else if (8 == type) {
                bd = new Bundle();
                bd.putInt(NaviCommonCallBackListener.KEY_ICON_ID, NavMapAdapter.getInstance().getIconId());
                return bd;
            } else if (14 != type) {
                if (19 == type) {
                    NavCommonFuncController.this.launcherMapsAcitivityFormBackToFront();
                } else if (22 == type) {
                    bd = new Bundle();
                    bd.putInt(NaviCommonCallBackListener.KEY_PREFER_VALUE, NavMapAdapter.getInstance().onGetLastPreferValue());
                    return bd;
                } else if (23 == type) {
                    NavMapAdapter.getInstance().onSetLastPreferValue(Integer.parseInt(String.valueOf(arg)));
                } else if (24 != type) {
                    if (25 == type) {
                        if (!NavComponentController.getInstance().invokeCollada()) {
                            NavComponentController.getInstance().loadColladaSo(false);
                        }
                    } else if (26 == type) {
                        bd = (Bundle) arg;
                        if (bd != null) {
                            NavMapAdapter.getInstance().shareSafety(bd.getString("LinkUrl"), bd.getString("ImgUrl"), bd.getString("Title"), bd.getString("Desc"), bd.getBoolean("OrientationUser"));
                        }
                    } else if (type == 30) {
                        return new Bundle();
                    }
                }
            }
            return null;
        }

        public boolean isMapModuleFragment() {
            return NavMapAdapter.getInstance().isMapModuleFragment();
        }

        public boolean isFocusUIenable() {
            return NavMapAdapter.getInstance().isFocusUIEnable();
        }

        public boolean buttomNaviTabHasFocus() {
            return NavMapAdapter.getInstance().buttomNaviTabHasFocus();
        }

        public void showBottomBar(boolean show) {
        }

        public boolean onNaviCommonMsgForBoolean(int type, int event, Object arg) {
            int i;
            switch (type) {
                case 2:
                    return NavCommonFuncModel.getInstance().mIsAppForeground;
                case 3:
                    NavMapAdapter.getInstance().removeRequestByType(NavMapAdapter.getInstance().getResultKeyMCarRoute());
                    break;
                case 4:
                    BaseTTSPlayer.getInstance().setTTSStreamType(event);
                    return true;
                case 5:
                    if (!NavCommonFuncModel.getInstance().mIsAppForeground) {
                        break;
                    }
                    break;
                case 10:
                    return NavMapAdapter.getInstance().isGooglePlayChannel();
                case 11:
                    BaiduNaviManager.getInstance().launchDownloadActivity(NavCommonFuncModel.getInstance().getActivity(), null);
                    return true;
                case 13:
                    return NavDrivingCarController.getInstance().isDrvingCar();
                case 15:
                    return NavComponentController.getInstance().invokeCollada();
                case 16:
                    return false;
                case 17:
                    return false;
                case 18:
                    if (NaviCommonConstant.OVERLAY_PERMISSION.equals((String) arg)) {
                        return NavCommonFuncController.this.hasOverlayPermission();
                    }
                    return false;
                case 20:
                    return NavCommonFuncController.this.requestPermission((String) arg);
                case 21:
                    Context ctx = NavCommonFuncModel.getInstance().getContext();
                    if (ctx != null) {
                        AudioUtils.releaseAudioFocus(ctx);
                    }
                    return true;
                case 27:
                    BaiduNaviManager.getInstance().initURLData();
                    return true;
                case 28:
                    if (NavCommonFuncController.this.cityDownLoadFlag == null) {
                        NavCommonFuncController.this.cityDownLoadFlag = new boolean[1000];
                        Arrays.fill(NavCommonFuncController.this.cityDownLoadFlag, false);
                        List<LocalMapResource> citys = LocalMapManager.getInstance().getUserResources();
                        NavCommonFuncController.this.mapCitys = citys;
                        for (i = 0; i < citys.size(); i++) {
                            try {
                                NavCommonFuncController.this.cityDownLoadFlag[((LocalMapResource) citys.get(i)).id] = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    int provinceId = event;
                    if (OfflineDataParams.PROVINCE_NAME == null || provinceId < 0 || OfflineDataParams.PROVINCE_NAME.length <= provinceId) {
                        return true;
                    }
                    String provinceName = OfflineDataParams.PROVINCE_NAME[provinceId];
                    LogUtil.m3004e("DataOffLine:", "current province name is" + provinceName);
                    List<LocalMapResource> mResourceList = LocalMapManager.getInstance().getCitiesByName(provinceName);
                    if (!(mResourceList == null || mResourceList.size() <= 0 || mResourceList.get(0) == null)) {
                        if (((LocalMapResource) mResourceList.get(0)).children != null) {
                            for (LocalMapResource parResource : mResourceList) {
                                if (!(parResource == null || parResource.children == null)) {
                                    for (LocalMapResource mLocalMapResource : parResource.children) {
                                        LogUtil.m3004e("DataOffLine:", "children is not null,cityName is" + mLocalMapResource.name);
                                        if (!mLocalMapResource.name.startsWith("所有") && !NavCommonFuncController.this.cityDownLoadFlag[mLocalMapResource.id]) {
                                            return false;
                                        }
                                    }
                                    continue;
                                }
                            }
                        } else if (((LocalMapResource) mResourceList.get(0)).id < NavCommonFuncController.this.cityDownLoadFlag.length) {
                            return NavCommonFuncController.this.cityDownLoadFlag[((LocalMapResource) mResourceList.get(0)).id];
                        } else {
                            if (NavCommonFuncController.this.mapCitys == null) {
                                return false;
                            }
                            for (i = 0; i < NavCommonFuncController.this.mapCitys.size(); i++) {
                                if (((LocalMapResource) NavCommonFuncController.this.mapCitys.get(i)).id == ((LocalMapResource) mResourceList.get(0)).id) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                    return true;
                case 29:
                    NavCommonFuncController.this.cityDownLoadFlag = new boolean[1000];
                    Arrays.fill(NavCommonFuncController.this.cityDownLoadFlag, false);
                    long start = System.currentTimeMillis();
                    NavCommonFuncController.this.mapCitys = LocalMapManager.getInstance().getUserResources();
                    long cost = System.currentTimeMillis() - start;
                    if (NavCommonFuncController.this.mapCitys != null) {
                        for (i = 0; i < NavCommonFuncController.this.mapCitys.size(); i++) {
                            try {
                                NavCommonFuncController.this.cityDownLoadFlag[((LocalMapResource) NavCommonFuncController.this.mapCitys.get(i)).id] = true;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        break;
                    }
                    break;
                case 31:
                    return false;
                case 36:
                    NavMapAdapter.getInstance().naviDownloadXiJiangSwitch();
                    return true;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavCommonFuncController$3 */
    class C07823 implements NaviMsgListener {
        C07823() {
        }

        public void onSatelliteNumUpdate(int arg0, Drawable arg1) {
        }

        public void onRoadTurnInfoIconUpdate(Drawable arg0) {
        }

        public void onRoadTurnInfoDistanceUpdate(CharSequence arg0) {
        }

        public void onRoadNameUpdate(String arg0) {
        }

        public void onRemainTimeUpdate(CharSequence arg0, Drawable arg1) {
        }

        public void onRemainDistanceUpdate(CharSequence arg0, Drawable arg1) {
        }

        public void onRasterMapUpdate(String arg0, int arg1, String arg2) {
        }

        public void onRasterMapShow(int arg0, Bitmap arg1, Bitmap arg2) {
        }

        public void onRasterMapHide() {
        }

        public void onOtherAction(int type, int arg1, int arg2, Object data) {
            if (NavCommonFuncController.this.mNavEventHandler != null) {
                Message msg = NavCommonFuncController.this.mNavEventHandler.obtainMessage();
                msg.what = type + 9000;
                msg.arg1 = arg1;
                msg.arg2 = arg2;
                msg.obj = data;
                msg.sendToTarget();
            }
        }
    }

    private NavCommonFuncController() {
    }

    public boolean requestPermission(String permission) {
        if (VERSION.SDK_INT < 23 || NavCommonFuncModel.getInstance().getActivity() == null || permission == null) {
            return false;
        }
        return true;
    }

    public boolean hasOverlayPermission() {
        if (VERSION.SDK_INT >= 23) {
            return false;
        }
        return true;
    }

    public static NavCommonFuncController getInstance() {
        if (sInstance == null) {
            sInstance = new NavCommonFuncController();
        }
        return sInstance;
    }

    public boolean isNaviBegin() {
        return BNavigator.getInstance().isNaviBegin() || BCruiser.getInstance().isRouteCruiseBegin();
    }

    public boolean hasGPSPermission() {
        return hasGPSPermission(BNaviModuleManager.getActivity());
    }

    public boolean hasGPSPermission(Activity a) {
        if (a != null) {
            PackageManager pm = a.getPackageManager();
            if (pm != null && -1 == pm.checkPermission("android.permission.ACCESS_FINE_LOCATION", "com.baidu.carlife")) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCurLocationCityOfflineData() {
        if (!BNSysLocationManager.getInstance().isSysLocationValid() || !BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        LocData locData = BNSysLocationManager.getInstance().getCurLocation();
        if (locData.longitude == -1.0d && locData.latitude == -1.0d) {
            return false;
        }
        GeoPoint geoPoint = new GeoPoint();
        if (locData != null) {
            geoPoint.setLatitudeE6((int) (locData.latitude * 100000.0d));
            geoPoint.setLongitudeE6((int) (locData.longitude * 100000.0d));
        }
        DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
        while (districtInfo != null && districtInfo.mType > 2) {
            districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
        }
        if (districtInfo != null) {
            return BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
        }
        return false;
    }

    public boolean hasCurRouteNodesCityOfflineData() {
        boolean ret = false;
        if (BNavigator.getInstance().isNaviBegin() && hasCurLocationCityOfflineData() && RoutePlanModel.sNavNodeList != null && RoutePlanModel.sNavNodeList.size() >= 2) {
            for (int i = 1; i < RoutePlanModel.sNavNodeList.size(); i++) {
                DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(((RoutePlanNode) RoutePlanModel.sNavNodeList.get(i)).mGeoPoint, 0);
                while (districtInfo != null && districtInfo.mType > 2) {
                    districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
                }
                if (districtInfo != null) {
                    ret = BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
                } else {
                    ret = false;
                }
                if (!ret) {
                    break;
                }
            }
        }
        return ret;
    }

    public int getLocationCityIdByPoint() {
        if (BNLocationManagerProxy.getInstance().isLocationValid()) {
            LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
            if (locData != null) {
                return getLocationCityIdByPoint(locData.toGeoPoint());
            }
        }
        return -1;
    }

    public int getLocationCityIdByPoint(GeoPoint point) {
        DistrictInfo di = BNPoiSearcher.getInstance().getDistrictByPoint(point, 2);
        if (di == null || di.mType != 3) {
            return -1;
        }
        return di.mId;
    }

    public int getLocationCityId() {
        boolean isDIOK = false;
        int newDistrictId = -1;
        if (null == null) {
            DistrictInfo di = BNPoiSearcher.getInstance().getDistrictById(NavMapAdapter.getInstance().getRoamCityId());
            if (di != null && di.mType == 3) {
                isDIOK = true;
                newDistrictId = di.mId;
            }
        }
        if (isDIOK) {
            return newDistrictId;
        }
        DistrictInfo pdi = BNPoiSearcher.getInstance().getDistrictById(NavMapAdapter.getInstance().getCurrentLocalCityId());
        if (pdi == null || pdi.mType != 3) {
            return newDistrictId;
        }
        return pdi.mId;
    }

    public int downLoadCityMapData(int cityId) {
        return BNOfflineDataManager.getInstance().downLoadCityMapData(cityId);
    }

    public String getVoiceEnter() {
        return this.voiceEnter;
    }

    public void setVoiceEnter(String voiceEnter) {
        this.voiceEnter = voiceEnter;
    }

    public void onForeground() {
        NavLogUtils.m3003e(TAG, "onForeground()");
        UserOPController.getInstance().add(UserOPParams.COMMON_1_m);
        NavCommonFuncModel.getInstance().mIsAppForeground = true;
        RGViewController.getInstance().onForeground();
        BNStatisticsManager.getInstance().upLoadStatistics();
        BaiduNaviManager.getInstance().notifyMapGPSEnable(true);
    }

    public void onBackground() {
        NavLogUtils.m3003e(TAG, "onBackground()");
        UserOPController.getInstance().add(UserOPParams.COMMON_1_n);
        NavCommonFuncModel.getInstance().mIsAppForeground = false;
        if (!BNavigator.getInstance().isNaviBegin()) {
            BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
        }
        RGViewController.getInstance().onBackground();
        try {
            BNStatisticsManager.getInstance().saveStatistics();
        } catch (Throwable th) {
        }
        BaiduNaviManager.getInstance().notifyMapGPSEnable(false);
    }

    public static void importSettingToNaviSDK(Context context) {
        SharedPreferences sp;
        PreferenceHelper preferenceHelper = PreferenceHelper.getInstance(context);
        try {
            sp = context.getSharedPreferences(NAV_SETTING, 0);
        } catch (Throwable th) {
            sp = null;
        }
        if (preferenceHelper != null) {
            if (preferenceHelper.getBoolean(PREF_NAV_NEED_ADAPTER_SETTING, true) && sp != null) {
                boolean b;
                if (sp.contains("PREF_NAVI_FIRST_USE")) {
                    BNSettingManager.setNaviDisclaimerShow(sp.getBoolean("PREF_NAVI_FIRST_USE", true));
                }
                if (sp.contains("NAVI_MODE_DAY_AND_NIGHT")) {
                    BNSettingManager.setNaviDayAndNightMode(sp.getInt("NAVI_MODE_DAY_AND_NIGHT", 0) + 1);
                }
                if (sp.contains("NAVI_ALWAYS_BRIGHT")) {
                    BNSettingManager.setAlwaysBright(sp.getBoolean("NAVI_ALWAYS_BRIGHT", true));
                }
                if (sp.contains(NAVI_CAMERA_NOTIFY)) {
                    if (sp.getBoolean(NAVI_CAMERA_NOTIFY, false)) {
                        b = false;
                    } else {
                        b = true;
                    }
                    BNSettingManager.setElecCameraSpeakEnable(b);
                }
                if (sp.contains(NAVI_OVER_SPEED)) {
                    if (sp.getBoolean(NAVI_OVER_SPEED, false)) {
                        b = false;
                    } else {
                        b = true;
                    }
                    BNSettingManager.setSpeedCameraSpeakEnable(b);
                }
                if (sp.contains(NAVI_ROUTE_CONDITION)) {
                    if (sp.getBoolean(NAVI_ROUTE_CONDITION, false)) {
                        b = false;
                    } else {
                        b = true;
                    }
                    BNSettingManager.setRoadCondOnOff(b);
                }
                if (sp.contains(NAVI_STRAIGHT)) {
                    if (sp.getBoolean(NAVI_STRAIGHT, false)) {
                        b = false;
                    } else {
                        b = true;
                    }
                    BNSettingManager.setStraightDirectSpeakEnable(b);
                }
                if (sp.contains(KEY_USE_LY_TTS)) {
                    preferenceHelper.putBoolean(KEY_USE_LY_TTS, sp.getBoolean(KEY_USE_LY_TTS, true));
                }
                if (sp.contains("NAVI_VOICE_MODE")) {
                    BNSettingManager.setVoiceMode(sp.getInt("NAVI_VOICE_MODE", 0));
                }
            }
            preferenceHelper.putBoolean(PREF_NAV_NEED_ADAPTER_SETTING, false);
        }
    }

    public static void resetNavConfig(Context context) {
        BNSettingManager.setNaviDisclaimerShow(true);
        BNSettingManager.setNaviDayAndNightMode(1);
        BNSettingManager.setAlwaysBright(true);
        BNSettingManager.setElecCameraSpeakEnable(true);
        BNSettingManager.setSpeedCameraSpeakEnable(true);
        BNSettingManager.setSpeedCameraSpeakEnable(true);
        BNSettingManager.setRoadConditionpeakEnable(true);
        BNSettingManager.setPrefRoutePlanMode(0);
        BNSettingManager.setVoiceMode(0);
    }

    public void setExternalCall(boolean external, Bundle bundle) {
        BNVoice.getInstance().setExternalCall(external, bundle);
    }

    public void launchUgcMangerActivity(Context ctx) {
    }

    public void launchUgcPickActivity(Context ctx, Bundle b) {
    }

    public boolean onBackPressRCEvent() {
        return BNRCEventDetailsViewController.getInstance().onBackPressed();
    }

    public void pauseAllDownload() {
        BNDownloadUIManager.pauseAllDownload();
    }

    public boolean checkFactoryMode(String key) {
        return BNPoiSearcher.getInstance().checkFactoryMode(key);
    }

    public boolean isFastDoubleClick() {
        return ForbidDaulClickUtils.isFastDoubleClick(1500);
    }

    public void resetLastDoubleClickTime() {
        ForbidDaulClickUtils.resetLastDoubleClickTime();
    }

    public void updateAccountInfoWhenLoginSuccess() {
        NavLogUtils.m3003e(TAG, "updateAccountInfoWhenLoginSuccess()  updateUserInfo, bduss=" + NavMapAdapter.getInstance().getBduss() + ", uid=" + NavMapAdapter.getInstance().getUid() + ", islogin=" + (NavMapAdapter.getInstance().isLogin() ? 1 : 0));
    }

    public int getFormatErrorCode(int originErrorCode) {
        if ((originErrorCode >= 200 && originErrorCode <= 207) || ((originErrorCode >= 520 && originErrorCode <= 600) || originErrorCode == 9000)) {
            return 112000000 + originErrorCode;
        }
        if (originErrorCode < 5000) {
            return 412000000 + originErrorCode;
        }
        return 512000000 + originErrorCode;
    }

    public void showNavPage(String pageName, Bundle data) {
        NavFragmentManager.getInstance().showNavMapMapPage(pageName, data);
    }

    public boolean isProvinceDataDownload(int provinceID) {
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0) && BNOfflineDataManager.getInstance().isProvinceDataDownload(provinceID)) {
            return true;
        }
        return false;
    }

    public void launchDownloadActivity(Context ctx, String isFromCruiser) {
        if (isFromCruiser != null) {
            new Bundle().putBoolean(BNDownloadPage.KEY_FROM_CRUISER, true);
        }
        C1328h.m4757a().showFragment(NaviFragmentManager.TYPE_OFFLINE_DATA, null);
    }

    public void launcherMapsAcitivityFormBackToFront() {
    }

    public void drivingToolAction() {
        BNDrivingToolManager.getInstance().setCurrentCityID(getLocationCityId());
        String bduss = NavMapAdapter.getInstance().getBduss();
        if (bduss != null) {
            BNDrivingToolManager.getInstance().getIssueInfo().mBduss = bduss;
        }
    }

    public void setDrivingToolVisibility(boolean show) {
        BNDrivingToolUtils.sCanShow = show;
    }

    public void addNaviEventListener(NaviEvent listener) {
        synchronized (this.mNaviEventListeners) {
            if (listener != null) {
                if (!this.mNaviEventListeners.contains(listener)) {
                    this.mNaviEventListeners.add(listener);
                }
            }
        }
    }

    public void removeNaviEventListener(NaviEvent listener) {
        synchronized (this.mNaviEventListeners) {
            if (listener != null) {
                if (this.mNaviEventListeners.contains(listener)) {
                    this.mNaviEventListeners.remove(listener);
                }
            }
        }
    }

    public void registerNaviEventListener() {
        BNEventManager.getInstance().setNaviMsgListener(this.mNaviEventListener);
    }

    public void unregisterNaviEventListener() {
        BNEventManager.getInstance().setNaviMsgListener(null);
    }

    public void addRoutePlanSuccessLog(long endTime) {
        PerformStatisticsController.getInstance().addRoutePlanSuccessLog(endTime);
    }

    public boolean getAutoEnterLightNavi() {
        return BNSettingManager.getAutoEnterLightNavi();
    }

    public void addTrimMemoryStat() {
        UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_1, "1", null, null);
    }

    public PreferenceHelper getNaviPreferenceHelper(Context context) {
        if (context == null) {
            return null;
        }
        return PreferenceHelper.getInstance(context);
    }

    public boolean isForegroundServiceOpen() {
        boolean cloudConfigOpen = CloudlConfigDataModel.getInstance().mCommonConfig.foregroundService;
        NavLogUtils.m3003e(TAG, "isForegroundServiceOpen: cloudConfigOpen --> " + cloudConfigOpen);
        return cloudConfigOpen;
    }

    public void startForegroundService(Context context) {
        if (context != null) {
            try {
                if (isForegroundServiceOpen()) {
                    NavLogUtils.m3003e(TAG, "startForegroundService: --> ");
                    context.startService(new Intent(context, ForegroundService.class));
                }
            } catch (Throwable th) {
            }
        }
    }

    public void stopForegroundService(Context context) {
        if (context != null) {
            try {
                if (isForegroundServiceOpen()) {
                    NavLogUtils.m3003e(TAG, "stopForegroundService: --> ");
                    context.stopService(new Intent(context, ForegroundService.class));
                }
            } catch (Throwable th) {
            }
        }
    }
}
