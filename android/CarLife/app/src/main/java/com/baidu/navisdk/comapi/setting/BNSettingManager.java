package com.baidu.navisdk.comapi.setting;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonConstant;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.drivertool.BNDrivingToolParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.BitSet;

public class BNSettingManager {
    public static final int BUDSS_CHECK_INTERVAL = 86400000;
    public static int TTS_PLAY_MODE = -1;
    private static BNSettingManager$CachePrefence mPreferenceHelper;

    public static void init(Context context) {
        if (mPreferenceHelper == null) {
            synchronized (BNSettingManager.class) {
                if (mPreferenceHelper == null) {
                    mPreferenceHelper = new BNSettingManager$CachePrefence(context);
                }
            }
        }
        loadDefaultValue();
    }

    private static void loadDefaultValue() {
    }

    public static void initEngine() {
        setAsrWakupEnable(isAsrWakupEnable());
    }

    public static boolean isNaviDisclaimerShow() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_SHOW_DISCLAIMER, true);
    }

    public static void setNaviDisclaimerShow(boolean isShow) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_SHOW_DISCLAIMER, isShow);
        }
    }

    public static boolean isAlwaysBright() {
        return true;
    }

    public static void setAlwaysBright(boolean bSceenAlwaysBright) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ALWAYS_BRIGHT, bSceenAlwaysBright);
        }
    }

    public static boolean isAutoUpdateNewData() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_AUTO_UPDATE_NEW_DATA, false);
    }

    public static boolean isRecordingHighDefinition() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(BNDrivingToolParams.VIDEO_HIGH_DEFINITION, true);
    }

    public static void setRecordingHighDefinition(boolean isHighDefinition) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(BNDrivingToolParams.VIDEO_HIGH_DEFINITION, isHighDefinition);
        }
    }

    public static boolean isShowingDrivingTool() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(BNDrivingToolParams.SHOW_DRIVING_TOOL, false);
    }

    public static void setShowingDrivingTool(boolean isShowing) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(BNDrivingToolParams.SHOW_DRIVING_TOOL, isShowing);
        }
    }

    public static String getLastDrivingInfo() {
        if (mPreferenceHelper == null) {
            return null;
        }
        return mPreferenceHelper.getString(BNDrivingToolParams.DRIVING_TOOL_INFO, null);
    }

    public static void setLastDrivingInfo(String drivingInfo) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString(BNDrivingToolParams.DRIVING_TOOL_INFO, drivingInfo);
        }
    }

    public static int getNormalBrightness() {
        if (mPreferenceHelper == null) {
            return BNOffScreenParams.ORIGINAL_BRIGHTNESS;
        }
        return mPreferenceHelper.getInt(BNOffScreenParams.NORMAL_BRIGHTNESS, BNOffScreenParams.ORIGINAL_BRIGHTNESS);
    }

    public static void setNormalBrightness(int brightness) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(BNOffScreenParams.NORMAL_BRIGHTNESS, brightness);
        }
    }

    public static boolean isRootScreenshotPermitted() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(BNDrivingToolParams.ROOT_USER_PERMISSION, true);
    }

    public static void setRootScreenshotState(boolean isPermitted) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(BNDrivingToolParams.ROOT_USER_PERMISSION, isPermitted);
        }
    }

    public static void setAutoUpdateNewData(boolean bAutoUpdate) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_AUTO_UPDATE_NEW_DATA, bAutoUpdate);
        }
    }

    public static boolean isShowLocationEnable() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_SHOWLOCATION_ONOFF, false);
    }

    public static void setShowLocationEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_SHOWLOCATION_ONOFF, enable);
            NavSDKDebug.sShowDebugToast = isShowLocationEnable();
        }
    }

    public static boolean isRecordTrackEnable() {
        return true;
    }

    public static void setRecordTrackEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_TRACK_RECORD_ONOFF, enable);
        }
    }

    public static int getNaviDayAndNightMode() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.CARLIFE_NAVI_MODE_DAY_AND_NIGHT, 1);
    }

    public static void setNaviDayAndNightMode(int dayNightMode) {
        if (mPreferenceHelper != null) {
            if (1 == dayNightMode || 2 == dayNightMode || 3 == dayNightMode) {
                mPreferenceHelper.putInt(Key.CARLIFE_NAVI_MODE_DAY_AND_NIGHT, dayNightMode);
                BNAutoDayNightHelper.getInstance().updateDayNightMode();
            }
        }
    }

    public static void setAutoEnterLightNavi(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_AUTO_ENTER_LIGHT_NAVI, open);
        }
    }

    public static boolean getAutoEnterLightNavi() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_AUTO_ENTER_LIGHT_NAVI, true);
    }

    public static void setPlayBackgroundSpeak(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_PLAY_BACKGROUND_SPEAK, open);
        }
    }

    public static boolean isPlayBackgroundSpeak() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_PLAY_BACKGROUND_SPEAK, true);
    }

    public static int getPowerSaveMode() {
        int mode = 2;
        if (mPreferenceHelper == null) {
            return 0;
        }
        if (mPreferenceHelper.getInt(Key.NAVI_POWER_SAVE_MODE, 0) != 2) {
            mode = 0;
        }
        return mode;
    }

    public static void setPowerSaveMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 0 || 1 == mode || 2 == mode) {
                mPreferenceHelper.putInt(Key.NAVI_POWER_SAVE_MODE, mode);
                BNPowerSaver.getInstance().updatePowerSaveMode(mode);
            }
        }
    }

    public static boolean getFirstRoutePlanTag() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.FIRST_ROUTE_PLAN, true);
    }

    public static void setFirstRoutePlanTag(boolean firstRoutePlan) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FIRST_ROUTE_PLAN, firstRoutePlan);
        }
    }

    public static boolean getFirstVoiceNotifyGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.FIRST_VOICE_NOTIFY_GUIDE, true);
    }

    public static void setFirstVoiceNotifyGuide(boolean firstRoutePlan) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FIRST_VOICE_NOTIFY_GUIDE, firstRoutePlan);
        }
    }

    public static int getPrefRoutPlanMode() {
        if (mPreferenceHelper == null) {
            return 3;
        }
        return mPreferenceHelper.getInt(Key.NAVI_RP_NET_MODE, 3);
    }

    public static void setPrefRoutePlanMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 2 || mode == 0) {
                mPreferenceHelper.putInt(Key.NAVI_RP_NET_MODE, 2);
            } else if (mode == 3 || mode == 1) {
                mPreferenceHelper.putInt(Key.NAVI_RP_NET_MODE, 3);
            }
        }
    }

    public static int getPrefSearchMode() {
        if (mPreferenceHelper == null) {
            return 3;
        }
        return mPreferenceHelper.getInt(Key.NAVI_SEARCH_NET_MODE, 3);
    }

    public static void setPrefSearchMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 2 || mode == 0) {
                mPreferenceHelper.putInt(Key.NAVI_SEARCH_NET_MODE, 2);
            } else if (mode == 3 || mode == 1) {
                mPreferenceHelper.putInt(Key.NAVI_SEARCH_NET_MODE, 3);
            }
        }
    }

    public static boolean isAsrWakupEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_ASR_WAKUP_ON_OFF, false);
    }

    public static void setAsrWakupEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ASR_WAKUP_ON_OFF, enable);
            if (enable) {
                BNVoiceCommandController.getInstance().startASR();
            } else {
                BNVoiceCommandController.getInstance().stopASR();
            }
        }
    }

    public static void setUgcShow(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_UGC_SHOW, open);
        }
    }

    public static boolean getUgcShow() {
        return false;
    }

    public static void setGPSHotStart(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_GPS_HOT_STAST, open);
        }
    }

    public static boolean getGPSHotStart() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_GPS_HOT_STAST, false);
    }

    public static void setFellowSwitchStatus(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FELLOW_SWITCH, open);
        }
    }

    public static boolean getFellowSwitchStatus() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.FELLOW_SWITCH, true);
    }

    public static void setColladaStatus(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.COLLADA_SWITCH, open);
            try {
                JNIBaseMap.ColladaEnable(open);
            } catch (Throwable th) {
            }
        }
    }

    public static boolean getColladaStatus() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.COLLADA_SWITCH, true);
    }

    public static boolean isElecCameraSpeakEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.Navi_ElecCamera_Speak, true);
    }

    public static void setElecCameraSpeakEnable(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.Navi_ElecCamera_Speak, b);
        }
    }

    public static boolean isSpeedCameraSpeakEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.Navi_SpeedCamera_Speak, true);
    }

    public static void setSpeedCameraSpeakEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.Navi_SpeedCamera_Speak, enable);
        }
    }

    public static boolean isSaftyDriveSpeakEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.Navi_SaftyDrive_Speak, true);
    }

    public static void setSaftyDriveSpeakEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.Navi_SaftyDrive_Speak, enable);
        }
    }

    public static boolean isRoadConditionSpeakEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.Navi_RoadCondition_Speak, true);
    }

    public static void setRoadConditionpeakEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.Navi_RoadCondition_Speak, enable);
        }
    }

    public static boolean isStraightDirectSpeakEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.Navi_StraightDirect_Speak, true);
    }

    public static void setStraightDirectSpeakEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.Navi_StraightDirect_Speak, enable);
        }
    }

    public static int getVoiceMode() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_VOICE_MODE, 0);
    }

    public static void setVoiceMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 0 || mode == 2 || mode == 1) {
                mPreferenceHelper.putInt(Key.NAVI_VOICE_MODE, mode);
            }
        }
    }

    public static void setLastVoiceMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 0 || mode == 1) {
                mPreferenceHelper.putInt(Key.NAVI_LAST_VOICE_MODE, mode);
            }
        }
    }

    public static int getLastVoiceMode() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_LAST_VOICE_MODE, 0);
    }

    public static void resetVoiceModeParams(int mode) {
        switch (mode) {
            case 0:
                setElecCameraSpeakEnable(true);
                setSpeedCameraSpeakEnable(true);
                setSaftyDriveSpeakEnable(true);
                setRoadConditionpeakEnable(true);
                setStraightDirectSpeakEnable(true);
                return;
            case 1:
                setElecCameraSpeakEnable(true);
                setSpeedCameraSpeakEnable(true);
                setSaftyDriveSpeakEnable(false);
                setRoadConditionpeakEnable(true);
                setStraightDirectSpeakEnable(true);
                return;
            case 2:
                setElecCameraSpeakEnable(false);
                setSpeedCameraSpeakEnable(false);
                setSaftyDriveSpeakEnable(false);
                setRoadConditionpeakEnable(false);
                setStraightDirectSpeakEnable(false);
                return;
            default:
                return;
        }
    }

    public static String getTTSDataPath() {
        if (mPreferenceHelper == null) {
            return "";
        }
        return mPreferenceHelper.getString(Key.NAVI_VOICE_TTS_DATA_PATH, "");
    }

    public static void SetTTSDataPath(String maidouFath) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString(Key.NAVI_VOICE_TTS_DATA_PATH, maidouFath);
        }
    }

    public static void setVoicePersonality(int mode) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_VOICE_PERSONALITY, mode);
        }
    }

    public static int getVoicePersonality() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_VOICE_PERSONALITY, 0);
    }

    public static void setVoiceTaskId(String id) {
        if (mPreferenceHelper != null && id != null && getVoicePersonality() != 0) {
            mPreferenceHelper.putString(Key.NAVI_VOICE_TASK_ID, id);
        }
    }

    public static String getVoiceTaskId() {
        if (mPreferenceHelper == null) {
            return null;
        }
        return mPreferenceHelper.getString(Key.NAVI_VOICE_TASK_ID, null);
    }

    public static Boolean getMaiDouGuideIsShow() {
        if (mPreferenceHelper == null) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(mPreferenceHelper.getBoolean(Key.NAVI_VOICE_MAIDOU_GUIDE, false));
    }

    public static Boolean setMaiDouGuideIsShow(boolean flag) {
        if (mPreferenceHelper == null) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(mPreferenceHelper.putBoolean(Key.NAVI_VOICE_MAIDOU_GUIDE, flag));
    }

    public static int getDefaultLaunchMode() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_DEFAULT_LAUNCH_MODE, 0);
    }

    public static void setDefaultLaunchMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 0 || mode == 1 || mode == 2) {
                mPreferenceHelper.putInt(Key.NAVI_DEFAULT_LAUNCH_MODE, mode);
            }
        }
    }

    public static void setRememberLaunchMode(boolean rem) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_REMEMBER_LAUNCH_MODE, rem);
        }
    }

    public static boolean isRememberLaunchMode() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_REMEMBER_LAUNCH_MODE, false);
    }

    public static int getSearchResultSortPref() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_SEARCH_RESULT_SORT_PREF, 0);
    }

    public static void setSearchResultSortPref(int pref) {
        if (mPreferenceHelper != null) {
            if (pref == 0 || pref == 1) {
                mPreferenceHelper.putInt(Key.NAVI_SEARCH_RESULT_SORT_PREF, pref);
            }
        }
    }

    public static int getRoutePlanResultPref() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.NAVI_ROUTEPLAN_RESULT_PREF, 1);
    }

    public static int getDistrictId() {
        if (mPreferenceHelper == null) {
            return NaviFragmentManager.TYPE_CAR_DRV_LIST;
        }
        return mPreferenceHelper.getInt(Key.SEARCH_DISTRICT_ID, NaviFragmentManager.TYPE_CAR_DRV_LIST);
    }

    public static String getDistrictName() {
        if (mPreferenceHelper == null) {
            return "北京";
        }
        return mPreferenceHelper.getString(Key.SEARCH_DISTRICT_NAME, "北京");
    }

    public static void setDistrictId(int districtId) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.SEARCH_DISTRICT_ID, districtId);
        }
    }

    public static void setDistrictName(String districtName) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(districtName)) {
            mPreferenceHelper.putString(Key.SEARCH_DISTRICT_NAME, districtName);
        }
    }

    public static void setRoutePlanResultPref(int pref) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_ROUTEPLAN_RESULT_PREF, pref);
        }
    }

    public static boolean isNaviAutoCheckNewData() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_AUTO_CHECK_NEW_DATA, true);
    }

    public static void setNaviAutoCheckNewData(boolean bAutoCheck) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_AUTO_CHECK_NEW_DATA, bAutoCheck);
        }
    }

    public static boolean isNaviRealHistoryITS() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_REAL_HISTORY_ITS, true);
    }

    public static void setsNaviRealHistoryITS(boolean bITSReal) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_REAL_HISTORY_ITS, bITSReal);
        }
    }

    public static boolean isRoadCondOnOrOff() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean("NAVI_ROADCOND_ON_OFF", false);
    }

    public static void setRoadCondOnOff(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean("NAVI_ROADCOND_ON_OFF", b);
        }
    }

    public static boolean isIpoRoadCondOnOrOff() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean("NAVI_ROADCOND_ON_OFF", false);
    }

    public static void setIpoRoadCondOnOff(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_IPO_ROADCOND_ON_OFF, b);
        }
    }

    public static boolean isIPOGuideFirstShow() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.IS_IPO_GUIDE_FIRST_SHOW, true);
    }

    public static void setIPOGuideFirstShow(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.IS_IPO_GUIDE_FIRST_SHOW, b);
        }
    }

    public static boolean isFirstItsOn() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.FIRST_ITS_ON, true);
    }

    public static void setFirstItsOn(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FIRST_ITS_ON, b);
        }
    }

    public static boolean isTrackLocateGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.SP_TRACK_LOCATE_GUIDE, false);
    }

    public static void setTrackLocateGuide(boolean bTrack) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.SP_TRACK_LOCATE_GUIDE, bTrack);
        }
    }

    public static int getCurrentUsingMode() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.SP_USING_MODE, 1);
    }

    public static int getPoiListSortRuleType() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.POI_SORT_RULE_TYPE, 1);
    }

    public static void setPoiListSortRuleType(int type) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.POI_SORT_RULE_TYPE, type);
        }
    }

    public static void setCurrentUsingMode(int mode) {
        if (mPreferenceHelper != null) {
            if (mode == 1 || mode == 2) {
                mPreferenceHelper.putInt(Key.SP_USING_MODE, mode);
            }
        }
    }

    public static boolean isUsingMapMode() {
        if (mPreferenceHelper == null || getCurrentUsingMode() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isUserAccountOnline() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.SP_ACCOUNT_ONLINE, true);
    }

    public static void setUserAccountOnline(boolean online) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.SP_ACCOUNT_ONLINE, online);
        }
    }

    public static int getInt(String key, int defValue) {
        return mPreferenceHelper == null ? defValue : mPreferenceHelper.getInt(key, defValue);
    }

    public static void setPrefParkSearch(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_PARK_SEARCH, open);
        }
    }

    public static void setPrefFloatSwitch(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FLOAT_SWITCH, open);
        }
    }

    public static boolean getPrefParkSearch() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_PARK_SEARCH, false);
    }

    public static boolean getPrefFloatSwitch() {
        if (mPreferenceHelper != null && BNaviModuleManager.hasPermission(NaviCommonConstant.OVERLAY_PERMISSION)) {
            return mPreferenceHelper.getBoolean(Key.NAVI_FLOAT_SWITCH, false);
        }
        return false;
    }

    public static boolean getShowCarLogoToEnd() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_SHOW_CAR_LOGO_TO_END, true);
    }

    public static void setShowCarLogoToEnd(boolean isShow) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_SHOW_CAR_LOGO_TO_END, isShow);
        }
    }

    public static boolean setPrefRealEnlargementNavi(boolean open) {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.putBoolean(Key.SP_SHOW_NAVING_REAL_ENLARGEMENT, open);
    }

    public static boolean getPrefRealEnlargementNavi() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.SP_SHOW_NAVING_REAL_ENLARGEMENT, true);
    }

    public static void setRouteGuideEnd(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_GUIDE_END, open);
        }
    }

    public static boolean getRouteGuideEnd() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_GUIDE_END, true);
    }

    public static void setPushMode(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_PUSH_SERVICE, open);
        }
    }

    public static boolean getPushMode() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_PUSH_SERVICE, true);
    }

    public static void setMapMode(int mapMode) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_MAP_MODE, mapMode);
        }
    }

    public static int getMapMode() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.NAVI_MAP_MODE, 1);
    }

    public static String getPluginMD5() {
        if (mPreferenceHelper == null) {
            return null;
        }
        return mPreferenceHelper.getString(Key.NAVI_PLUGIN_MD5, null);
    }

    public static void setPluginMD5(String md5) {
        if (mPreferenceHelper != null && md5 != null) {
            mPreferenceHelper.putString(Key.NAVI_PLUGIN_MD5, md5);
        }
    }

    public static void addDownloadPrivinceId(int provinceId) {
        if (mPreferenceHelper != null && provinceId <= 64 && provinceId >= 0) {
            mPreferenceHelper.putLong(Key.OFFLINEDATA_DOWNLOAD_ITEM_SET, mPreferenceHelper.getLong(Key.OFFLINEDATA_DOWNLOAD_ITEM_SET, 0) | (1 << ((int) ((long) provinceId))));
        }
    }

    public static void removeDownloadProvinceId(int provinceId) {
        if (mPreferenceHelper != null && provinceId <= 64 && provinceId >= 0) {
            mPreferenceHelper.putLong(Key.OFFLINEDATA_DOWNLOAD_ITEM_SET, mPreferenceHelper.getLong(Key.OFFLINEDATA_DOWNLOAD_ITEM_SET, 0) & (-16 << ((int) ((long) provinceId))));
        }
    }

    public static BitSet getDownloadProvinceIdSet() {
        BitSet set = new BitSet(64);
        if (mPreferenceHelper != null) {
            long provinceidSet = mPreferenceHelper.getLong(Key.OFFLINEDATA_DOWNLOAD_ITEM_SET, 0);
            int i = 0;
            while (provinceidSet > 0) {
                if (provinceidSet % 2 == 1) {
                    set.set(i);
                }
                provinceidSet >>= 1;
                i++;
            }
        }
        return set;
    }

    public static void clearDownloadProvinceId() {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putLong(Key.OFFLINEDATA_DOWNLOAD_ITEM_SET, 0);
        }
    }

    public static void setMonkey(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_MONKEY, show);
        }
    }

    public static boolean isMonkey() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_MONKEY, false);
    }

    public static void setTTSVocoderParam(String param) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString(Key.NAVI_TTS_VOCODER, param);
        }
    }

    public static String getTTSVocoderParam() {
        if (mPreferenceHelper == null) {
            return "0";
        }
        return mPreferenceHelper.getString(Key.NAVI_TTS_VOCODER, "0");
    }

    public static void setTTSSpeedParam(int i) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_TTS_SPEED, i);
        }
    }

    public static int getTTSSpeedParam() {
        if (mPreferenceHelper == null) {
            return 5;
        }
        return mPreferenceHelper.getInt(Key.NAVI_TTS_SPEED, 5);
    }

    public static void setFellowDebug(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FELLOW_DEBUG, show);
        }
    }

    public static boolean isFellowDebug() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_FELLOW_DEBUG, false);
    }

    public static void setGPSDebug(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_GPS_DEBUG, show);
        }
    }

    public static boolean isGPSDebug() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_GPS_DEBUG, false);
    }

    public static void setBlueToothPhoneChannel(boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_BLUE_TOOTH_PHONE_CHANNEL, flag);
        }
    }

    public static boolean isBlueToothPhoneChannel() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_BLUE_TOOTH_PHONE_CHANNEL, false);
    }

    public static void setBlueToothName(String name) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString(Key.NAVI_BLUE_TOOTH_NAME, name);
        }
    }

    public static String getBlueToothName() {
        if (mPreferenceHelper == null) {
            return "";
        }
        return mPreferenceHelper.getString(Key.NAVI_BLUE_TOOTH_NAME, "");
    }

    public static void setFristBlueToothChannelGuide(boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE, flag);
        }
    }

    public static boolean getFristBlueToothChannelGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE, false);
    }

    public static void setFirstVoiceGuide(boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FIRST_VOICE_GUIDE, flag);
        }
    }

    public static boolean getFirstVoiceGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_FIRST_VOICE_GUIDE, false);
    }

    public static void setFirstMoreMenuGuide(boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FIRST_MORE_MENU_GUIDE, flag);
        }
    }

    public static boolean getFirstMoreMenuGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_FIRST_MORE_MENU_GUIDE, false);
    }

    public static void setFirstCarLogoGuide(boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FIRST_CAR_LOGO_GUIDE, flag);
        }
    }

    public static boolean getFirsCarLogoGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_FIRST_CAR_LOGO_GUIDE, false);
    }

    public static void setFristMenuGuide(boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_FIRST_MENU_GUIDE, flag);
        }
    }

    public static boolean getFristMenuGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_FIRST_MENU_GUIDE, false);
    }

    public static void setShowNativeLog(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_SHOW_NATIVE_LOG, show);
        }
    }

    public static boolean isShowNativeLog() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_SHOW_NATIVE_LOG, false);
    }

    public static void setShowJavaLog(boolean show) {
        if (mPreferenceHelper != null) {
            LogUtil.LOGGABLE = show;
            mPreferenceHelper.putBoolean(Key.NAVI_SHOW_JAVA_LOG, show);
        }
    }

    public static void setShowNotificationDebug(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_SHOW_NOTIFICATION_DEBUG, show);
        }
    }

    public static void setUseHttpsOfflineURL(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_USE_HTTPS_OFFLINE_URL, b);
        }
    }

    public static boolean isShowNotificationDebug() {
        return false;
    }

    public static boolean isUseHttpsOfflineURL() {
        return false;
    }

    public static boolean isShowJavaLog() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_SHOW_JAVA_LOG, false);
    }

    public static boolean isRootScreenOpen() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_ROOT_SCREEN, false);
    }

    public static void setRootScreenOpen(boolean isOpen) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ROOT_SCREEN, isOpen);
        }
    }

    public static void setAntiCheatOpen(boolean open) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ANTI_CHEAT, open);
        }
    }

    public static boolean isAntiCheatOpen() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_ANTI_CHEAT, true);
    }

    public static void setRouteDetailGuideTextShowTimes(int time) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.ROUTE_DETAIL_GUIDE_SHOW_TIME, time);
        }
    }

    public static int getRouteDetailGuideTextShowTimes() {
        if (mPreferenceHelper == null) {
            return -1;
        }
        return mPreferenceHelper.getInt(Key.ROUTE_DETAIL_GUIDE_SHOW_TIME, 3);
    }

    public static void setShowNaviAsr(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ASR_SHOW, show);
        }
    }

    public static boolean isShowNaviAsr() {
        return false;
    }

    public static void setAsrFirstUse(boolean isFirst) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.ASR_FIRST_USE, isFirst);
        }
    }

    public static boolean isAsrFirstUse() {
        return false;
    }

    public static boolean isAutoLevelMode() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_AUTO_LEVEL, true);
    }

    public static void setAutoLevelMode(boolean state) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_AUTO_LEVEL, state);
        }
    }

    public static void setAddressUploadTime(long uploadTime) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putLong(Key.ADDRESS_LAST_UPLOAD_TIME, uploadTime);
        }
    }

    public static long getLastAddressUploadTime() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getLong(Key.ADDRESS_LAST_UPLOAD_TIME, 0);
    }

    public static void setHasAsrUploadAddress(int uploadTag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.HAS_UPLOAD_ADDRESS, uploadTag);
        }
    }

    public static int getAsrUploadAddress() {
        if (mPreferenceHelper == null) {
            return 2;
        }
        return mPreferenceHelper.getInt(Key.HAS_UPLOAD_ADDRESS, 0);
    }

    public static boolean isFellowTipsShow() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.FELLOW_TIPS_SHOW, true);
    }

    public static void setFellowTipsShow(boolean isShow) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FELLOW_TIPS_SHOW, isShow);
        }
    }

    public static boolean isFellowButtonClick() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.FELLOW_IS_BUTTON_CLICK, false);
    }

    public static void setFellowButtonClick(boolean isClick) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FELLOW_IS_BUTTON_CLICK, isClick);
        }
    }

    public static void setFellowCity(int city) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.FELLOW_DEBUG_CITY_NAME, city);
        }
    }

    public static int getFellowCity() {
        if (mPreferenceHelper == null) {
            return NaviFragmentManager.TYPE_CAR_DRV_LIST;
        }
        return mPreferenceHelper.getInt(Key.FELLOW_DEBUG_CITY_NAME, NaviFragmentManager.TYPE_CAR_DRV_LIST);
    }

    public static void setFellowSupport(boolean support) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FELLOW_SUPPORT, support);
        }
    }

    public static boolean getFellowSupport() {
        return mPreferenceHelper == null ? false : false;
    }

    public static void setFellowTipsTTSStr(String ttsStr) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString(Key.FELLOW_PREFER_TIPS_TTS_KEY, ttsStr);
        }
    }

    public static String getFellowTipsTTSStr() {
        if (mPreferenceHelper == null) {
            return "";
        }
        return mPreferenceHelper.getString(Key.FELLOW_PREFER_TIPS_TTS_KEY, "");
    }

    public static void setFellowTipsTTSPlayCount(int count) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.FELLOW_PREFER_TIPS_TTS_COUNT, count);
        }
    }

    public static int getFellowTipsTTSPlayCount() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.FELLOW_PREFER_TIPS_TTS_COUNT, 0);
    }

    public static void setAutoDownloadJinShaTTS(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_VOICE_JINSHA_AUTO_DOWNLOAD, b);
        }
    }

    public static boolean getAutoDownloadJinShaTTS() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_VOICE_JINSHA_AUTO_DOWNLOAD, true);
    }

    public static void setAutoSwitchJinShaTTS(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_VOICE_JINSHA_AUTO_SWITCH, b);
        }
    }

    public static boolean getAutoSwitchJinShaTTS() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_VOICE_JINSHA_AUTO_SWITCH, true);
    }

    public static void setHasDownloadJinShaTTS(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_VOICE_JINSHA_HAS_DOWNLOAD, b);
        }
    }

    public static boolean getHasDownloadJinShaTTS() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_VOICE_JINSHA_HAS_DOWNLOAD, false);
    }

    public static int getIsShowMapSwitch() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_SHOW_MAP_SWITCH, 0);
    }

    public static void setIsShowMapSwitch(int type) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_SHOW_MAP_SWITCH, type);
        }
    }

    public static int getIPOGuideShowTime() {
        if (mPreferenceHelper == null) {
            return 2;
        }
        return mPreferenceHelper.getInt(Key.IPO_GUIDE_SHOW_TIME, 2);
    }

    public static void setIPOGuideShowTime(int time) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.IPO_GUIDE_SHOW_TIME, time);
        }
    }

    public static int getIPOLockGuideTime() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.IPO_NAVI_LOCK_GUIDE, 2);
    }

    public static void setIPOLockGuideTime(int time) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.IPO_NAVI_LOCK_GUIDE, time);
        }
    }

    public static boolean getFirstHolidayShow(int id) {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.HOLIDAY_RED_GIFT + String.valueOf(id), true);
    }

    public static void setFirstHolidayShow(int id, boolean flag) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.HOLIDAY_RED_GIFT + String.valueOf(id), flag);
        }
    }

    public static void setHUDSDKSwitch(int isOpen) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.HUD_SDK_SWITCH, isOpen);
        }
    }

    public static int getHUDSDKSwitch() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.HUD_SDK_SWITCH, 1);
    }

    public static void setHasShowUserGuide(boolean hasShow) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.USER_GUIDE_STATE, hasShow);
        }
    }

    public static boolean getHasShowUserGuide() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.USER_GUIDE_STATE, false);
    }

    public static void setQuitForExceptionInNaviMode(boolean isInNaviMode) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.QUIT_FOR_EXCEPTION_IN_NAVIMODE, isInNaviMode);
        }
    }

    public static boolean getQuitForExceptionInNaviMode() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.QUIT_FOR_EXCEPTION_IN_NAVIMODE, false);
    }

    public static void setHWSimpleBoardEnable(boolean enable) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.HIGHWAY_SIMPLE_BOARD, enable);
        }
    }

    public static boolean isHWSimpleBoardEnable() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.HIGHWAY_SIMPLE_BOARD, true);
    }

    public static boolean containsKey(String key) {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.containsKey(key);
    }

    public static boolean hasShowFloatCloseMsg() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.RG_FLOAT_CLOSE_MSG, false);
    }

    public static void setShowFloatClosedMsg(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.RG_FLOAT_CLOSE_MSG, show);
        }
    }

    public static boolean isNavEndYellowBannerFirstShow() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAV_END_YELLOW_BANNER_SHOW, true);
    }

    public static void setNavEndYellowBannerFirstShow(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAV_END_YELLOW_BANNER_SHOW, show);
        }
    }

    public static boolean isNavEndYellowBannerFirstClick() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.NAV_END_YELLOW_BANNER_CLICK, true);
    }

    public static void setNavEndYellowBannerFirstClick(boolean show) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAV_END_YELLOW_BANNER_CLICK, show);
        }
    }

    public static boolean isRGFloatOpenGuideHasShow() {
        if (mPreferenceHelper == null) {
            return true;
        }
        return mPreferenceHelper.getBoolean(Key.RG_FLOAT_OPEN_GUIDE_SHOW, false);
    }

    public static void setRGFloatOpenGuideHasShow() {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.RG_FLOAT_OPEN_GUIDE_SHOW, true);
        }
    }

    public static void setInitCloudCfg(boolean offline) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_INIT_CLOUD_CFG, offline);
        }
    }

    public static boolean getInitCloudCfg() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_INIT_CLOUD_CFG, false);
    }

    public static boolean isDisclaimerShow(String key) {
        if (mPreferenceHelper == null || TextUtils.isEmpty(key)) {
            return false;
        }
        return mPreferenceHelper.getBoolean(key, true);
    }

    public static void setDisclaimerShow(String key, boolean isNeedShow) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(key)) {
            mPreferenceHelper.putBoolean(key, isNeedShow);
        }
    }

    public static void setSelectedRouteSortValue(int value) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_SELECTED_ROUTE_SORT_VALUE, value);
        }
    }

    public static int getSelectedRouteSortValue() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.NAVI_SELECTED_ROUTE_SORT_VALUE, 1);
    }

    public static void setSelectedRouteSortCount(int cnt) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_SELECTED_ROUTE_SORT_COUNT, cnt);
        }
    }

    public static int getSelectedRouteSortCount() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_SELECTED_ROUTE_SORT_COUNT, 0);
    }

    public static int getDefaultRouteSort() {
        if (mPreferenceHelper == null) {
            return 1;
        }
        return mPreferenceHelper.getInt(Key.NAVI_DEFAULT_ROUTE_SORT, 1);
    }

    public static void setDefaultRouteSort(int value) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_DEFAULT_ROUTE_SORT, value);
        }
    }

    public static void setHasShowRouteSortSettingGuide(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_HAS_SHOW_ROUTE_SORT_DEFAULT_SETTING_GUIDE, b);
        }
    }

    public static boolean hasShowRouteSortSettingGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_HAS_SHOW_ROUTE_SORT_DEFAULT_SETTING_GUIDE, false);
    }

    public static void setVoiceRecommendNotificationShowCnt(int cnt) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putInt(Key.NAVI_VOICE_RECOMMEN_SHOW_COUNT, cnt);
        }
    }

    public static int getVoiceRecommendNotificationShowCnt() {
        if (mPreferenceHelper == null) {
            return 0;
        }
        return mPreferenceHelper.getInt(Key.NAVI_VOICE_RECOMMEN_SHOW_COUNT, 0);
    }

    public static void setHasVoiceRecommendClicked(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_VOICE_RECOMMEN_HAS_CLICKED, b);
        }
    }

    public static boolean getHasVoiceRecommendClicked() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_VOICE_RECOMMEN_HAS_CLICKED, false);
    }

    public static void setHasRouteSortCardGuideShow(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE, b);
        }
    }

    public static void setEndNode(RoutePlanNode node) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString("mName", node.getName());
            if (node.getGeoPoint() != null) {
                mPreferenceHelper.putString("location", node.getLatitudeE6() + "," + node.getLongitudeE6());
            }
        }
    }

    public static RoutePlanNode getEndNode() {
        if (mPreferenceHelper == null) {
            return null;
        }
        RoutePlanNode endNode = new RoutePlanNode();
        endNode.mName = mPreferenceHelper.getString("mName", "");
        String[] loc = mPreferenceHelper.getString("location", "").split(",");
        if (loc == null || loc.length != 2) {
            return endNode;
        }
        endNode.setGeoPoint(new GeoPoint(Integer.parseInt(loc[1]), Integer.parseInt(loc[0])));
        return endNode;
    }

    public static boolean getHasRouteSortCardGuideShow() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE, false);
    }

    public static void setHasRouteSortSettingGuideShow(boolean b) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE, b);
        }
    }

    public static boolean getHasRouteSortSettingGuideShow() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE, false);
    }

    public static int getPlayTTsVoiceMode() {
        if (TTS_PLAY_MODE > -1) {
            return TTS_PLAY_MODE;
        }
        if (mPreferenceHelper == null) {
            return 0;
        }
        TTS_PLAY_MODE = mPreferenceHelper.getInt(Key.NAVI_TTS_PLAY_MODE, 0);
        return TTS_PLAY_MODE;
    }

    public static void setPlayTTsVoiceMode(int mode) {
        if (mPreferenceHelper != null && mPreferenceHelper.putInt(Key.NAVI_TTS_PLAY_MODE, mode)) {
            TTS_PLAY_MODE = mode;
        }
    }

    public static String getOwnerCarPlate() {
        if (mPreferenceHelper == null) {
            return "";
        }
        return mPreferenceHelper.getString(Key.OWNER_CAR_PLATE, "");
    }

    public static void setOwnerCarPlate(String carPlate) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putString(Key.OWNER_CAR_PLATE, carPlate);
        }
    }

    public static boolean hasPlateFromLocal(Context context) {
        if (context == null) {
            return false;
        }
        return PreferenceHelper.getInstance(context).getPreferences().contains("car_plate_num");
    }

    public static String getPlateFromLocal(Context context) {
        if (context == null) {
            return "";
        }
        return PreferenceHelper.getInstance(context).getString("car_plate_num", "");
    }

    public static void setCarPlateToLocal(Context context, String plateNum) {
        PreferenceHelper.getInstance(context).putString("car_plate_num", plateNum);
    }

    public static boolean getFirstRCStyleGuide() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.FIRST_RC_STYLE_GUIDE_SHOW, true);
    }

    public static void setFirstRCStyleGuide(boolean firstRoutePlan) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.FIRST_RC_STYLE_GUIDE_SHOW, firstRoutePlan);
        }
    }

    public static void setHudMirroShow(boolean isMirroShow) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putBoolean(Key.HUD_MIRRO_SHOW, isMirroShow);
        }
    }

    public static boolean getHudMirroShow() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.getBoolean(Key.HUD_MIRRO_SHOW, false);
    }

    public static void setLastCheckBudssTime(long time) {
        if (mPreferenceHelper != null) {
            mPreferenceHelper.putLong(Key.LAST_TIME_CHECK_BUDSS, time);
        }
    }

    public static long getLastCheckBudssTime() {
        if (mPreferenceHelper == null) {
            return -1;
        }
        return mPreferenceHelper.getLong(Key.LAST_TIME_CHECK_BUDSS, System.currentTimeMillis() - 86400000);
    }

    public static void setGasStationPreference(String preference) {
        if (mPreferenceHelper != null) {
            boolean result = mPreferenceHelper.putString(Key.GAS_STATION_PREFERENCE, preference);
        }
    }

    public static String getGasStationPreference() {
        if (mPreferenceHelper == null) {
            return null;
        }
        return mPreferenceHelper.getString(Key.GAS_STATION_PREFERENCE, "");
    }
}
