package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.cruise.view.CruiseMenu;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.util.ArrayList;
import java.util.BitSet;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SettingStatItem {
    private static final String TAG = "SettingStat";
    private static SettingStatItem instance = null;

    private SettingStatItem() {
    }

    public static SettingStatItem getInstance() {
        if (instance == null) {
            instance = new SettingStatItem();
        }
        return instance;
    }

    public void onEvent() {
        ArrayList<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_ROADCONDITION, Integer.toString(PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false) ? 1 : 0)));
        int voiceMode = -1;
        switch (BNSettingManager.getVoiceMode()) {
            case 0:
                voiceMode = 2;
                break;
            case 1:
                voiceMode = 1;
                break;
            case 2:
                voiceMode = 0;
                break;
        }
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_SPEAKMODE, Integer.toString(voiceMode)));
        switch (BNSettingManager.getIsShowMapSwitch()) {
            case 0:
                break;
            case 2:
                break;
        }
        int mMapMode = -1;
        switch (BNSettingManager.getMapMode()) {
            case 1:
                mMapMode = 1;
                break;
            case 2:
                mMapMode = 0;
                break;
        }
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_NAVIGATIONVIEW, Integer.toString(mMapMode)));
        int dayNightMode = -1;
        switch (BNSettingManager.getNaviDayAndNightMode()) {
            case 1:
                dayNightMode = 0;
                break;
            case 2:
                dayNightMode = 2;
                break;
            case 3:
                dayNightMode = 1;
                break;
        }
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_DAYNIGHT, Integer.toString(dayNightMode)));
        int powSaveMode = -1;
        switch (BNSettingManager.getPowerSaveMode()) {
            case 0:
                powSaveMode = 1;
                break;
            case 1:
                powSaveMode = 2;
                break;
            case 2:
                powSaveMode = 0;
                break;
        }
        params.add(new BasicNameValuePair("sd", Integer.toString(powSaveMode)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_AUTOUPDATE, Integer.toString(BNSettingManager.isAutoUpdateNewData() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_PARKMODE, Integer.toString(BNSettingManager.getPrefParkSearch() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_VIEWENLARGEMENT, Integer.toString(BNSettingManager.getPrefRealEnlargementNavi() ? 1 : 0)));
        params.add(new BasicNameValuePair("cl", Integer.toString(BNSettingManager.getColladaStatus() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_AUTO_LEVEL, Integer.toString(BNSettingManager.isAutoLevelMode() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_ROUTE_SORT, Integer.toString(RGRouteSortController.getInstance().getPreferValue())));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_ROUTE_PREFER, Integer.toString(BNRoutePlaner.getInstance().getCalcPreference())));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_CAR_PLATE, Integer.toString(BNaviModuleManager.isSettingCarPlate() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_COMPLETE_CAR_PLATE, Integer.toString(BNaviModuleManager.isCarPlateNumComplete() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_ONLINE_ROUTE_FIRST, Integer.toString(BNSettingManager.getPrefRoutPlanMode() == 3 ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_AUTO_ENTER_LIGHT, Integer.toString(BNSettingManager.getAutoEnterLightNavi() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_REMAIN_ROAD_CONDITION_OVERVIEW, Integer.toString(BNSettingManager.getIsShowMapSwitch() == 0 ? 1 : 0)));
        params.add(new BasicNameValuePair("bl", Integer.toString(BNSettingManager.isBlueToothPhoneChannel() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_BACKGROUND_FLOAT, Integer.toString(BNSettingManager.getPrefFloatSwitch() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_LIGHT_WIN, Integer.toString(BNSettingManager.getIsShowMapSwitch() == 0 ? 0 : 1)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_RED_LINE, Integer.toString(BNSettingManager.getShowCarLogoToEnd() ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_MUSIC_MODE, Integer.toString(BNSettingManager.getPlayTTsVoiceMode() == 0 ? 1 : 0)));
        params.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SETTING_VOICE_MODE, Integer.toString(BNSettingManager.getVoiceMode() == 2 ? 0 : 1)));
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_SETTING, null, params);
    }

    private static int getSpeekContentIntBits() {
        BitSet bitSet = new BitSet(5);
        bitSet.set(0, BNSettingManager.isElecCameraSpeakEnable());
        bitSet.set(1, BNSettingManager.isStraightDirectSpeakEnable());
        bitSet.set(2, BNSettingManager.isSaftyDriveSpeakEnable());
        bitSet.set(3, BNSettingManager.isRoadConditionSpeakEnable());
        bitSet.set(4, BNSettingManager.isSpeedCameraSpeakEnable());
        int bits = bitSetToInt(bitSet);
        LogUtil.m15791e(TAG, "navi speek content bits: " + Integer.toBinaryString(bits));
        return bits;
    }

    private static int getCruiseSpeekContentIntBits() {
        BitSet bitSet = new BitSet(CruiseMenu.sSettingPrefKeys.length);
        for (int i = 0; i < CruiseMenu.sSettingPrefKeys.length; i++) {
            boolean z;
            if (BNSettingManager.getInt(CruiseMenu.sSettingPrefKeys[i], 0) == 0) {
                z = true;
            } else {
                z = false;
            }
            bitSet.set(i, z);
        }
        int bits = bitSetToInt(bitSet);
        LogUtil.m15791e(TAG, "cruise speek content bits: " + Integer.toBinaryString(bits));
        return bits;
    }

    public static int bitSetToInt(BitSet bitSet) {
        int bitInteger = 0;
        for (int i = 0; i < 32; i++) {
            if (bitSet.get(i)) {
                bitInteger |= 1 << i;
            }
        }
        return bitInteger;
    }
}
