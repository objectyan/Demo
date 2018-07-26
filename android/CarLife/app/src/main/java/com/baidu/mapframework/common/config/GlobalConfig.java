package com.baidu.mapframework.common.config;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.map.config.Preferences;
import java.util.HashSet;
import java.util.Set;

public class GlobalConfig {
    private Preferences mPreferences;
    private int roamCityID;
    private String roamCityName;
    private int roamCityType;

    public static GlobalConfig getInstance() {
        return GlobalConfig$Holder.GLOBAL_CONFIG;
    }

    private GlobalConfig() {
        this.roamCityID = 0;
        this.roamCityName = "";
        this.roamCityType = 0;
        this.mPreferences = Preferences.build(C2907c.m10977f(), "global_app");
    }

    public boolean getDexFirstInstall() {
        return false;
    }

    public void setDexFirstInstall(boolean flag) {
    }

    public boolean isVoiceWakeUpOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_WAKEUP_ON, false);
    }

    public void setVoiceWakeUpOn(boolean isOn) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_WAKEUP_ON, isOn);
    }

    public boolean isVoiceSmartModeOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SMART_MODE_ON, false);
    }

    public void setVoiceSmartModeOn(boolean isOn) {
        this.mPreferences.putBoolean(GlobalConfigKey.SMART_MODE_ON, isOn);
    }

    public boolean isVoiceShakeOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_SHAKE_ON, false);
    }

    public void setVoiceShakeOn(boolean isOn) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_SHAKE_ON, isOn);
    }

    public boolean isAppFirstLaunch() {
        return this.mPreferences.getBoolean(GlobalConfigKey.APP_FIRST_LAUNCH, true);
    }

    public void setAppFirstLaunch(boolean flag) {
        this.mPreferences.putBoolean(GlobalConfigKey.APP_FIRST_LAUNCH, flag);
    }

    public boolean isServiceTermsShwon() {
        return this.mPreferences.getBoolean(GlobalConfigKey.APP_SERVICE_TERMS_SHWON, false);
    }

    public void setServiceTermsShwon(boolean flag) {
        this.mPreferences.putBoolean(GlobalConfigKey.APP_SERVICE_TERMS_SHWON, flag);
    }

    public int getLastAppVersionCode() {
        return this.mPreferences.getInt(GlobalConfigKey.APP_LAST_VERSION_CODE, 0);
    }

    public void setLastAppVersionCode(int code) {
        this.mPreferences.putInt(GlobalConfigKey.APP_LAST_VERSION_CODE, code);
    }

    public String getLastAppVersionName() {
        return this.mPreferences.getString(GlobalConfigKey.APP_LAST_VERSION_NAME, "");
    }

    public void setLastAppVersionName(String vname) {
        this.mPreferences.putString(GlobalConfigKey.APP_LAST_VERSION_NAME, vname);
    }

    public int getLastLocationCityCode() {
        return this.mPreferences.getInt(GlobalConfigKey.LAST_LOC_CITY_ID, 1);
    }

    public void setLastLocationCityCode(int code) {
        this.mPreferences.putInt(GlobalConfigKey.LAST_LOC_CITY_ID, code);
    }

    public String getLastLocationCityName() {
        return this.mPreferences.getString(GlobalConfigKey.LAST_LOC_CITY_NAME, "");
    }

    public void setLastLocationCityName(String name) {
        if (name != null) {
            this.mPreferences.putString(GlobalConfigKey.LAST_LOC_CITY_NAME, name);
        }
    }

    public String getLastLocationAreaName() {
        return this.mPreferences.getString(GlobalConfigKey.LAST_LOC_AREA_NAME, "");
    }

    public void setLastLocationAreaName(String name) {
        if (name != null) {
            this.mPreferences.putString(GlobalConfigKey.LAST_LOC_AREA_NAME, name);
        }
    }

    public void setLastLocationAddress(String address) {
        if (!TextUtils.isEmpty(address)) {
            this.mPreferences.putString(GlobalConfigKey.LAST_LOC_ADDRESS, address);
        }
    }

    public String getLastLocationAddress() {
        return this.mPreferences.getString(GlobalConfigKey.LAST_LOC_ADDRESS, "");
    }

    public int getRoamCityId() {
        return this.roamCityID;
    }

    public void setRoamCityId(int id) {
        this.roamCityID = id;
    }

    public String getRoamCityName() {
        return this.roamCityName;
    }

    public void setRoamCityName(String info) {
        this.roamCityName = info;
    }

    public int getRoamCityType() {
        return this.roamCityType;
    }

    public void setRoamCityType(int type) {
        this.roamCityType = type;
    }

    public boolean isFavouriteLayerOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.FAVOURITE_LAYER_SWITCH, true);
    }

    public void setFavouriteLayerOnOff(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.FAVOURITE_LAYER_SWITCH, on);
    }

    public boolean isRecommandLayerOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.RECOMMAND_LAYER_SWITCH, true);
    }

    public void setRecommandSwitchShow(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.RECOMMAND_SWITCH_BTN_SHOW, on);
    }

    public boolean isRecommandSwitchShow() {
        return this.mPreferences.getBoolean(GlobalConfigKey.RECOMMAND_SWITCH_BTN_SHOW, false);
    }

    public void setRecommandLayerOnOff(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.RECOMMAND_LAYER_SWITCH, on);
    }

    public boolean isRecommandLocUpdate() {
        return this.mPreferences.getBoolean(GlobalConfigKey.RECOMMAND_UPDATE_BY_LOC, false);
    }

    public void setRecommandLocUpdate(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.RECOMMAND_UPDATE_BY_LOC, on);
    }

    public boolean isHotMapLayerOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.HOTMAP_LAYER_SWITCH, false);
    }

    public void setHotMapLayerOnOff(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.HOTMAP_LAYER_SWITCH, on);
    }

    public boolean isHotMapLayerNewOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.HOTMAP_LAYER_NEW_SWITCH, true);
    }

    public void setHotMapLayerNewOnOff(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.HOTMAP_LAYER_NEW_SWITCH, on);
    }

    public boolean isLayerNewOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.NEW_LAYER_SWITCH, true);
    }

    public void setLayerNewOnOff(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.NEW_LAYER_SWITCH, on);
    }

    public boolean isAllBright() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_ALBRIGHT, false);
    }

    public void setAllBright(Boolean mAllBright) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_ALBRIGHT, mAllBright.booleanValue());
    }

    public boolean isReceivePush() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_RECEIVE_PUSH, true);
    }

    public void setIsReceivePush(Boolean IsReceivePush) {
    }

    public boolean isOpen3D() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_ROTATE_GESTURE, false);
    }

    public void setmOpen3D(Boolean mOpen3D) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_ROTATE_GESTURE, mOpen3D.booleanValue());
    }

    public boolean isOpenOverlook() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_OVERLOOK_GESTURE, true);
    }

    public void setOpenOverlook(Boolean openOverlook) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_OVERLOOK_GESTURE, openOverlook.booleanValue());
    }

    public boolean isAutoDownload() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_AUTO_DOWNLAOD, true);
    }

    public void setIsAutoDownload(boolean isAutoDownload) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_AUTO_DOWNLAOD, isAutoDownload);
    }

    public boolean isRouteConditionOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFP_ROUTE_CONDITION_ON, true);
    }

    public void setRouteConditionOn(boolean isOn) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFP_ROUTE_CONDITION_ON, isOn);
    }

    public boolean getSateLayer() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_SATE_OPEN, false);
    }

    public void setSateLayer(boolean sateLayerOpen) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_SATE_OPEN, sateLayerOpen);
    }

    public void setTonightHotelClickedDate(String date) {
        this.mPreferences.putString(GlobalConfigKey.MAIN_MAP_TONIGHT_HOTEL_CLICKED_DATE, date);
    }

    public int getClearOverlay() {
        return this.mPreferences.getInt(GlobalConfigKey.SYSCFG_CLEAR_OVERLAY, 0);
    }

    public void setClearOverlay(int mClearOverlay) {
        this.mPreferences.putInt(GlobalConfigKey.SYSCFG_CLEAR_OVERLAY, mClearOverlay);
    }

    public boolean getTraffic() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_TRAFFIC_OPEN, false);
    }

    public void setTraffic(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_TRAFFIC_OPEN, b);
    }

    public long getSaveFlax() {
        return this.mPreferences.getLong(GlobalConfigKey.SYSCFG_FLAX_SAVE, 0).longValue();
    }

    public void setSaveFlax(long saveFlax) {
        this.mPreferences.putLong(GlobalConfigKey.SYSCFG_FLAX_SAVE, saveFlax);
    }

    public int getLMFirstLocateCityId() {
        return this.mPreferences.getInt(GlobalConfigKey.LOCAL_MAP_FIRST_LOCATE_CITYID, 1);
    }

    public void setLMFirstLocateCityId(int firstLocateCityId) {
        this.mPreferences.putInt(GlobalConfigKey.LOCAL_MAP_FIRST_LOCATE_CITYID, firstLocateCityId);
    }

    public long getLMDataUpdateTime() {
        return this.mPreferences.getLong(GlobalConfigKey.LOCAL_MAP_DATA_UPDATE_TIME, 0).longValue();
    }

    public void setLMDataUpdateTime(long time) {
        this.mPreferences.putLong(GlobalConfigKey.LOCAL_MAP_DATA_UPDATE_TIME, time);
    }

    public long getLMDataTipTime() {
        return this.mPreferences.getLong(GlobalConfigKey.LOCAL_MAP_DATA_TIP_TIME, 0).longValue();
    }

    public void setLMDataTipTime(long time) {
        this.mPreferences.putLong(GlobalConfigKey.LOCAL_MAP_DATA_TIP_TIME, time);
    }

    public Set<Integer> getLocalMapAutoResumeCityIds() {
        String[] splits = this.mPreferences.getString(GlobalConfigKey.LOCAL_MAP_TASKS_AUTO_START_CITY_IDS, "").split(",");
        Set<Integer> result = new HashSet(splits.length);
        for (String split : splits) {
            if (split != null && split.length() > 0) {
                result.add(Integer.valueOf(split));
            }
        }
        return result;
    }

    public void setLocalMapAutoResumeCityIds(Set<Integer> ids) {
        StringBuilder sbuf = new StringBuilder();
        int i = 0;
        for (Integer id : ids) {
            if (i > 0) {
                sbuf.append(",");
            }
            sbuf.append(id.toString());
            i++;
        }
        this.mPreferences.putString(GlobalConfigKey.LOCAL_MAP_TASKS_AUTO_START_CITY_IDS, sbuf.toString());
    }

    public boolean getStreetScapeEnabled() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_STREET_SCAPE_ENABLED, false);
    }

    public void setStreetScapeEnabled(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_STREET_SCAPE_ENABLED, b);
    }

    public boolean isStreetRoad() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SYSCFG_STREET_ROAD_OPEN, false);
    }

    public void setStreetRoad(boolean isStreet) {
        this.mPreferences.putBoolean(GlobalConfigKey.SYSCFG_STREET_ROAD_OPEN, isStreet);
    }

    public int getLMSDCardCheckTime() {
        return Preferences.build(C2907c.m10977f()).getInt(GlobalConfigKey.LOCAL_MAP_SDCARD_CHECK_TIME, 0);
    }

    public void setLMSDCardCheckTime(int time) {
        Preferences.build(C2907c.m10977f()).putInt(GlobalConfigKey.LOCAL_MAP_SDCARD_CHECK_TIME, time);
    }

    public void setCleanOutDateShortcut() {
        this.mPreferences.putBoolean(GlobalConfigKey.HAS_CLEAN_OUT_DATE_SHORTCUT, true);
    }

    public boolean getHasCleanOutDateShortcut() {
        return this.mPreferences.getBoolean(GlobalConfigKey.HAS_CLEAN_OUT_DATE_SHORTCUT, false);
    }

    public void setStreetscapeConfirmNoWifi() {
        this.mPreferences.putBoolean(GlobalConfigKey.STREETSCAPE_CONFIRM_NO_WIFI, true);
    }

    public boolean getStreetscapeConfirmNoWifi() {
        return this.mPreferences.getBoolean(GlobalConfigKey.STREETSCAPE_CONFIRM_NO_WIFI, false);
    }

    public boolean isAnimationEnabled() {
        return false;
    }

    public String getHotIconId(String iconName) {
        return this.mPreferences.getString(iconName, "");
    }

    public boolean isFloorGuideHot() {
        return this.mPreferences.getBoolean(GlobalConfigKey.FLOOR_GUIDE_HOT, true);
    }

    public void setFloorGuideHot(boolean able) {
        this.mPreferences.putBoolean(GlobalConfigKey.FLOOR_GUIDE_HOT, able);
    }

    public boolean isGuidePageOfflineMapAutoDownloadOpen() {
        return this.mPreferences.getBoolean(GlobalConfigKey.LOCAL_MAP_GUIDE_PAGE_AUTO_DOWNLOAD, false);
    }

    public void setGuidePageOfflineMapAutoDownloadOpen(boolean isOpen) {
        this.mPreferences.putBoolean(GlobalConfigKey.LOCAL_MAP_GUIDE_PAGE_AUTO_DOWNLOAD, isOpen);
    }

    public boolean isLocalMapExpire() {
        return this.mPreferences.getBoolean(GlobalConfigKey.LOCAL_MAP_EXPIRE, false);
    }

    public void setLocalMapExpire(boolean isExpire) {
        this.mPreferences.putBoolean(GlobalConfigKey.LOCAL_MAP_EXPIRE, isExpire);
    }

    public boolean isGuideFromSettingPage() {
        return this.mPreferences.getBoolean(GlobalConfigKey.GUIDE_PAGE_FROM_SETTINGPAGE, false);
    }

    public void setGuideFromSettingPage(boolean isFromSettingPage) {
        this.mPreferences.putBoolean(GlobalConfigKey.GUIDE_PAGE_FROM_SETTINGPAGE, isFromSettingPage);
    }

    public boolean isLocalMapPopupWifiShow(int formatVersion) {
        return this.mPreferences.getBoolean(GlobalConfigKey.LOCAL_MAP_POPUP_WIFI_SHOW + String.valueOf(formatVersion), false);
    }

    public void setLocalMapPopupWifiShow(int formatVersion) {
        this.mPreferences.putBoolean(GlobalConfigKey.LOCAL_MAP_POPUP_WIFI_SHOW + String.valueOf(formatVersion), true);
    }

    public void setTurnOnLocalMapWiFiDownload(boolean isTurnOn) {
        this.mPreferences.putBoolean(GlobalConfigKey.LOCAL_MAP_TURN_ON_WIFI_AUTO_DOWNLOAD, isTurnOn);
    }

    public boolean isTurnOnLocalMapWiFiDownload() {
        return this.mPreferences.getBoolean(GlobalConfigKey.LOCAL_MAP_TURN_ON_WIFI_AUTO_DOWNLOAD, false);
    }

    public void setGuidePageShow(boolean isShow) {
        this.mPreferences.putBoolean(GlobalConfigKey.GUIDE_PAGE_SHOW, isShow);
    }

    public void setMonitorPid(int pid) {
        this.mPreferences.putInt(GlobalConfigKey.MONITOR_UNINSTALL_PID, pid);
    }

    public int getMonitorPid() {
        return this.mPreferences.getInt(GlobalConfigKey.MONITOR_UNINSTALL_PID, -1);
    }

    public void setRecommandUpdateTime(long time) {
        this.mPreferences.putLong(GlobalConfigKey.RECOMMAND_UPDATE_TIME, time);
    }

    public long getRecommandUpdateTime() {
        return this.mPreferences.getLong(GlobalConfigKey.RECOMMAND_UPDATE_TIME, 300000).longValue();
    }

    public void setRecommandUpdateDistance(int distance) {
        this.mPreferences.putInt(GlobalConfigKey.RECOMMAND_UPDATE_DISTANCE, distance);
    }

    public int getRecommandUpdateDistance() {
        return this.mPreferences.getInt(GlobalConfigKey.RECOMMAND_UPDATE_DISTANCE, 500);
    }

    public void setAutoSyncPoi(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.AUTO_SYNC_POI, b);
    }

    public void setAutoSyncRoute(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.AUTO_SYNC_ROUTE, b);
    }

    public boolean shouldAutoSyncPoi() {
        return this.mPreferences.getBoolean(GlobalConfigKey.AUTO_SYNC_POI, true);
    }

    public boolean shouldAutoSyncRoute() {
        return this.mPreferences.getBoolean(GlobalConfigKey.AUTO_SYNC_ROUTE, true);
    }

    public String getPortraitUrl(String uid) {
        if (TextUtils.isEmpty(uid)) {
            return "";
        }
        return this.mPreferences.getString(GlobalConfigKey.USER_PORTRIAT_URL + uid, "");
    }

    public void setPortraitUrl(String url, String uid) {
    }

    public void setNlpVer(String nlpver) {
        this.mPreferences.putString(GlobalConfigKey.NLP_VER, nlpver);
    }

    public String getNlpVer() {
        return this.mPreferences.getString(GlobalConfigKey.NLP_VER, getLastLocationCityCode() + "_1");
    }

    public void setMsdkVer(String nlpver) {
        this.mPreferences.putString(GlobalConfigKey.MSDK_VER, nlpver);
    }

    public String getMsdkVer() {
        return this.mPreferences.getString(GlobalConfigKey.MSDK_VER, "0");
    }

    public boolean isInitialPortraitUrl(String uid) {
        if (TextUtils.isEmpty(uid)) {
            return false;
        }
        return this.mPreferences.getBoolean(GlobalConfigKey.IS_USER_ININT_PORTRIAT_URL + uid, false);
    }

    public void setInitialPortraitUrl(boolean isInitialPortraitUrl, String uid) {
        this.mPreferences.putBoolean(GlobalConfigKey.IS_USER_ININT_PORTRIAT_URL + uid, isInitialPortraitUrl);
    }

    public int getLastMessageTime() {
        return this.mPreferences.getInt(GlobalConfigKey.LAST_MESSAGE_ID, 0);
    }

    public void setLastMessageTime(int id) {
        this.mPreferences.putInt(GlobalConfigKey.LAST_MESSAGE_ID, id);
    }

    public boolean getPushOpenPop() {
        return this.mPreferences.getBoolean(GlobalConfigKey.PUSH_OPEN_POP, false);
    }

    public void setPushOpenPop() {
        this.mPreferences.putBoolean(GlobalConfigKey.PUSH_OPEN_POP, true);
    }

    public boolean shouldShowPerfectNotice() {
        return !this.mPreferences.contains(GlobalConfigKey.NOTICE_SHOW_PERFECT);
    }

    public void setShowPerfectNotice(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.NOTICE_SHOW_PERFECT, b);
    }

    public boolean shouldUpdateMsgData() {
        long lastTime = this.mPreferences.getLong(GlobalConfigKey.MSG_LAST_UPDATE_TIME, 0).longValue();
        if (lastTime != -1 && System.currentTimeMillis() - lastTime <= 600000) {
            return false;
        }
        return true;
    }

    public void setMsgUpdateTime(long time) {
        this.mPreferences.putLong(GlobalConfigKey.MSG_LAST_UPDATE_TIME, time);
    }

    public void setFirstRequestMsg(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.FIRST_REQUEST_MSG, b);
    }

    public boolean isFirstRequestMsg() {
        return this.mPreferences.getBoolean(GlobalConfigKey.FIRST_REQUEST_MSG, true);
    }

    public void switchTravelMapLayer(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.TRAVEL_MAPLAYER_ON, on);
    }

    public boolean isTravelMapLayerOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.TRAVEL_MAPLAYER_ON, false);
    }

    public void setLastShowTravelTipCity(int cityId) {
        this.mPreferences.putInt(GlobalConfigKey.TRAVEL_TIP_LAST_CITYID, cityId);
    }

    public int getLastShowTravelTipCity() {
        return this.mPreferences.getInt(GlobalConfigKey.TRAVEL_TIP_LAST_CITYID, 0);
    }

    public void increaseShowTravelTipTime() {
        this.mPreferences.putInt(GlobalConfigKey.TRAVEL_TIP_SWITCH_ON_TIMES, getShowTravelTipTime() + 1);
    }

    public int getShowTravelTipTime() {
        return this.mPreferences.getInt(GlobalConfigKey.TRAVEL_TIP_SWITCH_ON_TIMES, 1);
    }

    public int getBadgeCount() {
        return this.mPreferences.getInt(GlobalConfigKey.BADGE_COUNT, 0);
    }

    public void setBadgeCount(int count) {
        this.mPreferences.putInt(GlobalConfigKey.BADGE_COUNT, count);
    }

    public boolean getShowUgcTips() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SHOW_UGC_TIP, true);
    }

    public void setShwoUgcTips(boolean shwoUgcTips) {
        this.mPreferences.putBoolean(GlobalConfigKey.SHOW_UGC_TIP, shwoUgcTips);
    }

    public boolean isTrafficUgcLayerOn() {
        return this.mPreferences.getBoolean(GlobalConfigKey.UGC_LAYER_SWITCH, true);
    }

    public void setTrafficUgcLayerOnOff(boolean on) {
        this.mPreferences.putBoolean(GlobalConfigKey.UGC_LAYER_SWITCH, on);
    }

    public boolean shouldShowSubscribeRemind() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SHOW_SUBSCRIBE_REMIND, true);
    }

    public void setShouldShowSubscribeRemind(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.SHOW_SUBSCRIBE_REMIND, b);
    }

    public boolean shouldUpdateLiveRoomEntry() {
        return System.currentTimeMillis() - this.mPreferences.getLong(GlobalConfigKey.LIVEROOM_UPDATE_TIME, 0).longValue() > Config.BPLUS_DELAY_TIME;
    }

    public void setLiveRoomEntryUpdateTime(long time) {
        this.mPreferences.putLong(GlobalConfigKey.LIVEROOM_UPDATE_TIME, time);
    }

    public boolean shouldUpdateTaSetting() {
        return false;
    }

    public void setShouldUpdateTASetting(boolean should) {
        this.mPreferences.putBoolean(GlobalConfigKey.UPDATE_TA_SETTING, should);
    }

    public void setClosedTripBubbleID(String id) {
        this.mPreferences.putString(GlobalConfigKey.CLOSED_BIGBUBBLE_ID, id);
    }

    public void setClosedMidTripBubbleID(String id) {
        this.mPreferences.putString(GlobalConfigKey.CLOSED_MIDBUBBLE_ID, id);
    }

    public String getClosedTripBubbleID() {
        return this.mPreferences.getString(GlobalConfigKey.CLOSED_BIGBUBBLE_ID, "");
    }

    public String getClosedMidTripBubbleID() {
        return this.mPreferences.getString(GlobalConfigKey.CLOSED_MIDBUBBLE_ID, "");
    }

    public boolean shouldShowShowTALead() {
        if (this.mPreferences.contains(GlobalConfigKey.SHOW_TA_LEAD)) {
            return false;
        }
        this.mPreferences.putBoolean(GlobalConfigKey.SHOW_TA_LEAD, false);
        return true;
    }

    public boolean shouldShowMapBubble() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SHOW_MAP_BUBBLE, true);
    }

    public void setShowMapBubble(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.SHOW_MAP_BUBBLE, b);
    }

    public boolean shouldShowMapBubbleSettingTip() {
        return this.mPreferences.getBoolean(GlobalConfigKey.SHOW_MAP_BUBBLE_TIP, true);
    }

    public void setShowMapBubbleSettingTip(boolean b) {
        this.mPreferences.putBoolean(GlobalConfigKey.SHOW_MAP_BUBBLE_TIP, b);
    }

    public int getHotspotState(String wifiMac) {
        return this.mPreferences.getInt(GlobalConfigKey.HOTSPOT + wifiMac, -1);
    }

    public void setHotspotState(String wifiMac, int hotspotState) {
        this.mPreferences.putInt(GlobalConfigKey.HOTSPOT + wifiMac, hotspotState);
    }

    public void setMapBox(boolean enable) {
        this.mPreferences.putBoolean(GlobalConfigKey.MAPBOX, enable);
    }

    public boolean getMapBox() {
        return this.mPreferences.getBoolean(GlobalConfigKey.MAPBOX, false);
    }

    public boolean ifHaveShowPoidetailFavshareGuide() {
        return this.mPreferences.getBoolean(GlobalConfigKey.POIDETAIL_FAVSHARE_GUIDE, false);
    }

    public void setHaveShowPoidetailFavshareGuide() {
        this.mPreferences.putBoolean(GlobalConfigKey.POIDETAIL_FAVSHARE_GUIDE, true);
    }

    public void setBigBubbleCloseNum(int num) {
        this.mPreferences.putInt(GlobalConfigKey.BIGBUBBLE_CLOSE, num);
    }

    public int getBigBubbleCloseNum() {
        return this.mPreferences.getInt(GlobalConfigKey.BIGBUBBLE_CLOSE, 0);
    }

    public void setSmallBubbleOpenNum(int num) {
        this.mPreferences.putInt(GlobalConfigKey.SMALLBUBBLE_OPEN, num);
    }

    public int getSmallBubbleOpenNum() {
        return this.mPreferences.getInt(GlobalConfigKey.SMALLBUBBLE_OPEN, 0);
    }

    public int getGuidleLastWeekShowTime() {
        return this.mPreferences.getInt(GlobalConfigKey.GUIDEBUBBLE_WEEK_TIME, -1);
    }

    public void setGuideBubbleLastWeekTime(int time) {
        this.mPreferences.putInt(GlobalConfigKey.GUIDEBUBBLE_WEEK_TIME, time);
    }

    public int getGuidleLastMonthShowTime() {
        return this.mPreferences.getInt(GlobalConfigKey.GUIDEBUBBLE_MONTH_TIME, -1);
    }

    public void setGuideBubbleLastMonthTime(int time) {
        this.mPreferences.putInt(GlobalConfigKey.GUIDEBUBBLE_MONTH_TIME, time);
    }

    public int getGuidleShowCount() {
        return this.mPreferences.getInt(GlobalConfigKey.GUIDEBUBBLE_COUNT, 0);
    }

    public void setGuideBubbleShowCount(int count) {
        this.mPreferences.putInt(GlobalConfigKey.GUIDEBUBBLE_COUNT, count);
    }

    public String getNearbyPath() {
        return this.mPreferences.getString(GlobalConfigKey.NEARBY_WEB_PATH, "");
    }

    public void setNearbyPath(String filePath) {
        this.mPreferences.putString(GlobalConfigKey.NEARBY_WEB_PATH, filePath);
    }

    public boolean getWeatherWarningShwon(String id) {
        return this.mPreferences.getBoolean(GlobalConfigKey.WEATHER_WARNING_EFFECT + id, false);
    }

    public void setWeatherWarningShwon(String id) {
        this.mPreferences.putBoolean(GlobalConfigKey.WEATHER_WARNING_EFFECT + id, true);
    }

    public void setForceDeleteData() {
        this.mPreferences.putBoolean(GlobalConfigKey.FORCE_DELETE_NEARBY_DATA, true);
    }

    public boolean isForceDeleteData() {
        return this.mPreferences.getBoolean(GlobalConfigKey.FORCE_DELETE_NEARBY_DATA, false);
    }

    public String getCpuName() {
        return this.mPreferences.getString(GlobalConfigKey.CURRENT_CPU_NAME, "");
    }

    public void setCpuName(String name) {
        this.mPreferences.putString(GlobalConfigKey.CURRENT_CPU_NAME, name);
    }

    public boolean getFirstRequestPermision() {
        return this.mPreferences.getBoolean(GlobalConfigKey.IS_FIRST_REQUSET_PERMISION, true);
    }

    public void setFirstRequestPermision(boolean flag) {
        this.mPreferences.putBoolean(GlobalConfigKey.IS_FIRST_REQUSET_PERMISION, flag);
    }

    public boolean getFirstUploadSDCardLog() {
        return this.mPreferences.getBoolean(GlobalConfigKey.IS_FIRST_SD_CARD_LOG, true);
    }

    public void setFirstUploadSDCardLog(boolean flag) {
        this.mPreferences.putBoolean(GlobalConfigKey.IS_FIRST_SD_CARD_LOG, flag);
    }

    public String getActUpdateKey() {
        return this.mPreferences.getString(GlobalConfigKey.USER_CENTER_ACT_RED_ICON_KEY, "");
    }

    public void setActUpdateState(String value) {
        this.mPreferences.putString(GlobalConfigKey.USER_CENTER_ACT_RED_ICON_KEY, value);
    }
}
