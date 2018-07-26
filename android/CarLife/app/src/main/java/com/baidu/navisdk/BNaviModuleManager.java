package com.baidu.navisdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatHelper;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.PhoneStatusReceiver;
import com.baidu.navisdk.util.listener.SDCardListener;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.facebook.common.p141m.C2924g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BNaviModuleManager {
    public static final String KEY_OUTCHINA_CITYID = "key.outchina.cityid";
    private static final String RES_ID = "52";
    private static NaviCommonCallBackListener mNaviCommonCallBackListener;
    private static NetworkListener mNetworkListener;
    private static SDCardListener mSDCardListener;
    public static String sAppSourceStr = AppSourceDefine.DEFAULT_SOURCE;
    private static Activity sCachedActivity;
    private static Context sCachedContext;
    private static GetOuterActivityListener sGetOuterActivityListener = null;

    public static class AppSourceDefine {
        public static final String DEFAULT_SOURCE = "others";
        public static final int DEFAULT_SOURCE_INT = 0;
        public static final String HUAWEI_SOURCE = "huawei";
        public static final int HUAWEI_SOURCE_INT = 1;
        public static final String LESHI_SOURCE = "leshi";
        public static final int LESHI_SOURCE_INT = 2;
    }

    public interface GetOuterActivityListener {
        Activity getNaviActivity();

        Activity getOuterActivity();
    }

    public interface NaviCommonCallBackListener {
        public static final String KEY_BDUSS = "bduss";
        public static final String KEY_ICON_ID = "KEY_ICON_ID";
        public static final String KEY_PREFER_VALUE = "KEY_PREFER_VALUE";
        public static final int NAVI_DOWNLOAD_XIJIANG_SWITCH = 36;
        public static final int NAVI_DRIVING_TOOL = 14;
        public static final int NAVI_EVENT_NOTIFY_INIT = 0;
        public static final int NAVI_EVENT_NOTIFY_UNINIT = 2;
        public static final int NAVI_EVENT_NOTIFY_UPDATE = 1;
        public static final int NAVI_REMOVE_IPO = 3;
        public static final int NAVI_SET_TTS_STREAM_TYPE = 4;
        public static final int NAVI_TYPE_CHECK_PERMISSION = 18;
        public static final int NAVI_TYPE_DESTORY_MAP = 0;
        public static final int NAVI_TYPE_DRIVING_CAR = 13;
        public static final int NAVI_TYPE_FETCH_CAR_OWNER_DATA = 34;
        public static final int NAVI_TYPE_GET_BDUSS = 1;
        public static final int NAVI_TYPE_GET_CITY_ID_OUTCHINA = 30;
        public static final int NAVI_TYPE_GET_ICON_ID = 8;
        public static final int NAVI_TYPE_GET_LAST_ROUTE_SEARCH_MCAR_PREFER = 22;
        public static final int NAVI_TYPE_INIT_URL = 27;
        public static final int NAVI_TYPE_IS_APP_FOREGROUND = 2;
        public static final int NAVI_TYPE_IS_CAR_PLATE_NUM_COMPLETE = 17;
        public static final int NAVI_TYPE_IS_COLLADA_INIT_SUCCESS = 15;
        public static final int NAVI_TYPE_IS_GooglePlay_Channel = 10;
        public static final int NAVI_TYPE_IS_INTERNATIONAL = 31;
        public static final int NAVI_TYPE_IS_SETTING_CAR_PLATE = 16;
        public static final int NAVI_TYPE_Init_Collada = 25;
        public static final int NAVI_TYPE_LAUNCH_MAPSACTIVITY_TO_FRONT = 19;
        public static final int NAVI_TYPE_MAP_SENSOR_ADD = 6;
        public static final int NAVI_TYPE_MAP_SENSOR_REMOVE = 7;
        public static final int NAVI_TYPE_OFFLINE_DATA_CLEAR = 29;
        public static final int NAVI_TYPE_OFFLINE_DATA_DOWNLOAD = 28;
        public static final int NAVI_TYPE_OPEN_CAR_PLATE_EXPLAIN_PAGE = 32;
        public static final int NAVI_TYPE_OPEN_DOWNLOAD_PAGE = 11;
        public static final int NAVI_TYPE_PLATE_LIMIT_RESET = 33;
        public static final int NAVI_TYPE_RELEASE_AUDIO_FOCUS = 21;
        public static final int NAVI_TYPE_REQUEST_PERMISSION = 20;
        public static final int NAVI_TYPE_SET_IPO_RC = 12;
        public static final int NAVI_TYPE_SET_LAST_ROUTE_SEARCH_MCAR_PREFER = 23;
        public static final int NAVI_TYPE_SET_SAVEMODE = 35;
        public static final int NAVI_TYPE_Share_Safety = 26;
        public static final int NAVI_TYPE_UNREGISTER_SENSOR = 5;
        public static final int NAVI_TYPE_putIP2DomainsRecord = 24;

        boolean buttomNaviTabHasFocus();

        boolean isFocusUIenable();

        boolean isMapModuleFragment();

        Bundle onNaviCommonMsg(int i, int i2, Object obj);

        boolean onNaviCommonMsgForBoolean(int i, int i2, Object obj);

        void showBottomBar(boolean z);
    }

    public interface NaviCommonConstant {
        public static final String OVERLAY_PERMISSION = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
        public static final int REQUST_CODE_JUMP_VOICE_SETTING = 3002;
        public static final int REQUST_CODE_OVERLAY_PERMISSION = 3001;
    }

    public static boolean isMapModuleFragment() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.isMapModuleFragment();
        }
        return true;
    }

    public static void showBottomBar(boolean show) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.showBottomBar(show);
        }
    }

    public static boolean buttomNaviTabHasFocus() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.buttomNaviTabHasFocus();
        }
        return false;
    }

    public static boolean isFocusUIenable() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.isFocusUIenable();
        }
        return false;
    }

    public static boolean isInternational(long x, long y, int cityId) {
        if (mNaviCommonCallBackListener == null) {
            return false;
        }
        Bundle request = new Bundle();
        request.putLong("x", x);
        request.putLong("y", y);
        request.putInt("cityId", cityId);
        return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(31, -1, request);
    }

    public static int getOutChinaCurrentCityId() {
        if (mNaviCommonCallBackListener == null) {
            return -1;
        }
        Bundle bd = mNaviCommonCallBackListener.onNaviCommonMsg(30, -1, null);
        if (bd == null || !bd.containsKey(KEY_OUTCHINA_CITYID)) {
            return -1;
        }
        return bd.getInt(KEY_OUTCHINA_CITYID, -1);
    }

    public static boolean checkBaseMapDataExit(int cityId) {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(28, cityId, null);
        }
        return true;
    }

    public static void updateMapDataStutas() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(29, -1, null);
        }
    }

    public static void setupNaviCommonCallBackListener(NaviCommonCallBackListener mListener) {
        mNaviCommonCallBackListener = mListener;
    }

    public static boolean isColladaInitSuccess() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(15, 0, null);
        }
        return false;
    }

    public static boolean isSettingCarPlate() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(16, 0, null);
        }
        return false;
    }

    public static boolean isCarPlateNumComplete() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(17, 0, null);
        }
        return false;
    }

    public static void detoryMapView() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(0, 0, null);
        }
    }

    public static void putIP2DomainsRecord(Bundle bd) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(24, 0, bd);
        }
    }

    public static void resetPlateLimitCounter(boolean isOpen) {
        if (mNaviCommonCallBackListener != null) {
            Bundle bd = new Bundle();
            bd.putBoolean("isOpen", isOpen);
            mNaviCommonCallBackListener.onNaviCommonMsg(33, 0, bd);
        }
    }

    public static String getBduss() {
        if (mNaviCommonCallBackListener == null) {
            return null;
        }
        Bundle bd = mNaviCommonCallBackListener.onNaviCommonMsg(1, 0, null);
        if (bd == null || !bd.containsKey("bduss")) {
            return null;
        }
        return bd.getString("bduss");
    }

    public static boolean isAppForeground() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(2, 0, null);
        }
        return true;
    }

    public static boolean releaseAudioFocus() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(21, 0, null);
        }
        return true;
    }

    public static boolean isGooglePlayChannel() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(10, 0, null);
        }
        return false;
    }

    public static void shareDrivingToolUrl(String url) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(14, 0, url);
        }
    }

    public static void initCollada() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(25, 0, null);
        }
    }

    public static void initUrl() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(27, 0, null);
        }
    }

    public static void shareSafety(Bundle bd) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(26, 0, bd);
        }
    }

    public static boolean isDrivingCar() {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(13, 0, null);
        }
        return false;
    }

    public static int getAppIconId() {
        if (mNaviCommonCallBackListener != null) {
            Bundle bd = mNaviCommonCallBackListener.onNaviCommonMsg(8, 0, null);
            if (bd != null && bd.containsKey(NaviCommonCallBackListener.KEY_ICON_ID)) {
                return bd.getInt(NaviCommonCallBackListener.KEY_ICON_ID);
            }
        }
        return -1;
    }

    public static int getLastPreferValue() {
        if (mNaviCommonCallBackListener != null) {
            Bundle bd = mNaviCommonCallBackListener.onNaviCommonMsg(22, 0, null);
            if (bd != null && bd.containsKey(NaviCommonCallBackListener.KEY_PREFER_VALUE)) {
                return bd.getInt(NaviCommonCallBackListener.KEY_PREFER_VALUE);
            }
        }
        return 1;
    }

    public static void setLastPreferValue(int prefer) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(23, 0, Integer.valueOf(prefer));
        }
    }

    public static void removeIPO() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(3, 0, null);
        }
    }

    public static void setTTSStreamType(int streamType) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(4, streamType, null);
        }
    }

    public static void unregisterMapSensorListener() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(5, 0, null);
        }
    }

    public static void addOrRemoveSensorListener(int isAdd, ISensorChangeListener listener) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(isAdd, 0, listener);
        }
    }

    public static void launchDownloadPage() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(11, 0, null);
        }
    }

    public static void setIPORCToMap(boolean on) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(12, on ? 1 : 0, null);
        }
    }

    public static boolean hasPermission(String permission) {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(18, 0, permission);
        }
        return false;
    }

    public static boolean requstPermission(String permission) {
        if (mNaviCommonCallBackListener != null) {
            return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(20, 0, permission);
        }
        return false;
    }

    public static void launchMapsActivityToFront() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(19, 0, null);
        }
    }

    public static void initContext(Context context) {
        if (true) {
            JarUtils.setAsJar(context);
        }
        PackageUtil.readSDKBuildNumber();
    }

    public static void initListenersForMap(Context context) {
        unRegister();
        sCachedContext = context.getApplicationContext();
        unRegister();
        PackageUtil.init(context);
        initNetworkListener(context);
        initSDCardListener(context);
        initPhoneStateListener(context);
    }

    public static void setContext(Context c) {
    }

    public static void setActivity(Activity a) {
    }

    public static Activity getActivity() {
        if (sGetOuterActivityListener == null || sGetOuterActivityListener.getOuterActivity() == null) {
            return sCachedActivity;
        }
        return sGetOuterActivityListener.getOuterActivity();
    }

    public static Activity getNaviActivity() {
        if (sGetOuterActivityListener == null || sGetOuterActivityListener.getNaviActivity() == null) {
            return sCachedActivity;
        }
        return sGetOuterActivityListener.getNaviActivity();
    }

    public static void setGetOuterActivityListener(GetOuterActivityListener lis) {
        sGetOuterActivityListener = lis;
    }

    public static void setupBase(boolean checkNewData) {
        BNOfflineDataManager.getInstance().isProvinceDataDownload(0);
        NaviStatHelper.initNaviStatHelper();
    }

    public static void setupGuidance(int ttsInitId) {
        BNSysLocationManager.getInstance().init(getContext());
        BNRoutePlaner.getInstance().init(getContext());
    }

    public static void setup(boolean checkNewData) {
        BNStatisticsManager.getInstance().upLoadStatistics();
        BNSysLocationManager.getInstance().init(getContext());
        BNOfflineDataManager.getInstance().initDownloadInfo(checkNewData);
        BNRoutePlaner.getInstance().init(getContext());
        statistics();
    }

    public static Context getContext() {
        if (sGetOuterActivityListener == null || sGetOuterActivityListener.getOuterActivity() == null) {
            return sCachedContext;
        }
        return sGetOuterActivityListener.getOuterActivity();
    }

    private static void setRoutePlanStatistcsUrl() {
        String strUrl = "";
        try {
            strUrl = ((("&mb=" + URLEncoder.encode(VDeviceAPI.getPhoneType(), "UTF-8")) + "&sv=" + URLEncoder.encode(VDeviceAPI.getAppPackageVersion(), "UTF-8")) + "&pcn=" + URLEncoder.encode(VDeviceAPI.getAppPackageName(), "UTF-8")) + "&kv=" + URLEncoder.encode(VDeviceAPI.getDataVersion(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        strUrl = (((strUrl + "&os=android") + "&net=" + VDeviceAPI.getCurrentNetworkType()) + "&resid=52") + "&channel=" + PackageUtil.getChannel();
    }

    public static void initNetworkListener(Context context) {
        mNetworkListener = new NetworkListener(true);
        IntentFilter filter = new IntentFilter();
        filter.addAction(com.baidu.baidumaps.common.network.NetworkListener.f2257d);
        filter.addAction("android.net.wifi.STATE_CHANGE");
        filter.addAction(com.baidu.baidumaps.common.network.NetworkListener.f2258e);
        filter.addAction("android.net.wifi.SCAN_RESULTS");
        if (context != null) {
            try {
                context.getApplicationContext().registerReceiver(mNetworkListener, filter, null, null);
            } catch (Exception e) {
            }
        }
    }

    public static void initSDCardListener(Context context) {
        mSDCardListener = new SDCardListener();
        IntentFilter sdcardfilter = new IntentFilter();
        sdcardfilter.addAction("android.intent.action.MEDIA_REMOVED");
        sdcardfilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        sdcardfilter.addAction("android.intent.action.MEDIA_EJECT");
        sdcardfilter.addAction("android.intent.action.MEDIA_MOUNTED");
        sdcardfilter.addDataScheme(C2924g.f12889c);
        if (context != null) {
            try {
                context.getApplicationContext().registerReceiver(mSDCardListener, sdcardfilter);
            } catch (Exception e) {
            }
        }
    }

    public static void initPhoneStateListener(Context context) {
        PhoneStatusReceiver.initPhoneStatusReceiver(getContext().getApplicationContext());
    }

    private static void unRegister() {
        if (!(mNetworkListener == null || getContext() == null)) {
            try {
                getContext().getApplicationContext().unregisterReceiver(mNetworkListener);
            } catch (Exception e) {
            }
            mNetworkListener = null;
        }
        if (!(mSDCardListener == null || getContext() == null)) {
            try {
                getContext().getApplicationContext().unregisterReceiver(mSDCardListener);
            } catch (Exception e2) {
            }
            mSDCardListener = null;
        }
        PhoneStatusReceiver.uninitPhoneStatusReceiver();
    }

    public static void destory() {
        unRegister();
        RespTimeStatItem.getInstance().onEvent();
        BNStatisticsManager.getInstance().saveStatistics();
        BNStatisticsManager.getInstance().exit();
        SDKDebugUtil.getInstance().destory();
        DataCheckCenter.getInstance().uninit();
    }

    public static void statistics() {
    }

    public static void updateAppSource() {
        LogUtil.m15791e("dingbin", "updateAppSource is " + sAppSourceStr);
        if (AppSourceDefine.HUAWEI_SOURCE.equals(sAppSourceStr)) {
            BNOffScreenManager.sIsModelueActive = true;
            updateAppSource(1);
        } else if (AppSourceDefine.LESHI_SOURCE.equals(sAppSourceStr)) {
            BNOffScreenManager.sIsModelueActive = true;
            updateAppSource(2);
        } else {
            BNOffScreenManager.sIsModelueActive = false;
            updateAppSource(0);
        }
    }

    private static void updateAppSource(int appSource) {
        BNaviEngineManager.getInstance().updateAppSource(appSource);
    }

    public static void openCarPlateExplainPage(Context context) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(32, 0, context);
        }
    }

    public static void fetchCarOwnerData(Context context) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(34, 0, context);
        }
    }

    public static void mapToNaviSaveMode(Context context, int event) {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsg(35, event, context);
        }
    }

    public static void naviDownloadXiJiangSwitch() {
        if (mNaviCommonCallBackListener != null) {
            mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(36, 0, null);
        }
    }
}
