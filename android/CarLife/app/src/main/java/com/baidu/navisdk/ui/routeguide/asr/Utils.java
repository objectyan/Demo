package com.baidu.navisdk.ui.routeguide.asr;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl.OnTTSPlayStateListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.RoundInstructType;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.VoiceContent;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.userop.UserOPParams.AsrOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.List;

public class Utils {
    private static final long ADDRESS_UPDATE_INTERVAL = 432000000;
    public static final int CONTACTS_NO_UPLOAD_TAG = 2;
    public static final int CONTACTS_UPLOAD_TAG = 1;
    public static final String OP_TAG = "dingbbinOP";
    private static final String TAG = "BNASRUtils";
    private static String mCurrentTips;
    private static OnTTSPlayStateListener mTTSPlayStateListener = new C43381();

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.Utils$1 */
    static class C43381 implements OnTTSPlayStateListener {
        C43381() {
        }

        public void onPlayStart() {
        }

        public void onPlayEnd() {
            TTSPlayerControl.removeTTSPlayStateListener(Utils.mTTSPlayStateListener);
            TTSPlayerControl.playTTS(Utils.mCurrentTips, 0);
        }
    }

    public static String getPhoneNumber(String name) {
        if (BNaviModuleManager.getActivity() == null) {
            return null;
        }
        String phoneStr = null;
        try {
            Cursor cursor = BNaviModuleManager.getActivity().getContentResolver().query(Contacts.CONTENT_URI, null, "display_name = '" + name + "'", null, null);
            if (cursor == null) {
                return null;
            }
            LogUtil.m15791e(TAG, "asr cursor size : " + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String contactId = cursor.getString(cursor.getColumnIndex("_id"));
                    LogUtil.m15791e(TAG, "asr contactId : " + contactId);
                    if (contactId != null) {
                        Cursor phone = BNaviModuleManager.getActivity().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = '" + contactId + "'", null, null);
                        if (phone != null) {
                            LogUtil.m15791e(TAG, "asr phone size : " + phone.getCount());
                            while (phone.moveToNext()) {
                                String phoneNumber = phone.getString(phone.getColumnIndex("data1"));
                                LogUtil.m15791e(TAG, "asr number : " + phoneNumber);
                                if (!TextUtils.isEmpty(phoneNumber)) {
                                    String number = phoneNumber.replaceAll("\\s*", "");
                                    if (PhoneNumberUtils.isGlobalPhoneNumber(number)) {
                                        phoneStr = number;
                                    }
                                }
                            }
                            phone.close();
                        }
                        if (phoneStr != null) {
                            break;
                        }
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
            return phoneStr;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getAddressListString() {
        if (BNaviModuleManager.getActivity() == null) {
            return "";
        }
        StringBuffer addressStrBuf = new StringBuffer();
        Cursor cursor = BNaviModuleManager.getActivity().getContentResolver().query(Contacts.CONTENT_URI, null, null, null, null);
        if (cursor != null) {
            addressStrBuf.append("[");
            while (cursor.moveToNext()) {
                addressStrBuf.append(gatherName(cursor.getString(cursor.getColumnIndex("display_name")), cursor.isLast()));
            }
            cursor.close();
        }
        addressStrBuf.append("]");
        return addressStrBuf.toString();
    }

    private static String gatherName(String name, boolean isLast) {
        StringBuffer buf = new StringBuffer();
        buf.append("{\"name\":\"");
        buf.append(name);
        if (isLast) {
            buf.append("\",\"frequency\":1000}");
        } else {
            buf.append("\",\"frequency\":1000},");
        }
        return buf.toString();
    }

    public static boolean isAsrCanWork() {
        try {
            boolean open = BNSettingManager.isShowNaviAsr();
            if (BNavigator.getInstance().getContext() != null) {
                boolean permission;
                if (BNavigator.getInstance().getContext().getPackageManager().checkPermission("android.permission.RECORD_AUDIO", PackageUtil.getPackageName()) == 0) {
                    permission = true;
                } else {
                    permission = false;
                }
                if (open && permission) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean isAsrCanShow() {
        if (BNSettingManager.isShowNaviAsr()) {
            return true;
        }
        return false;
    }

    public static String getNextManeuverPoint() {
        return "前方100左转";
    }

    public static String getLastTTSSpeech() {
        return "左转";
    }

    public static void asrAvoidJam() {
        BNRoutePlaner.getInstance().selectRoute(RGMultiRouteModel.getInstance().mSelectedRouteIndex);
        BNMapController.getInstance().updateLayer(10);
        BNEventManager.getInstance().onOtherAction(12, 0, 0, null);
    }

    public static void mainAuxiliarySwitch(boolean isSwitch) {
    }

    public static void naviToSearchPoint(SearchPoi poi) {
        RGEngineControl.getInstance().addViaPtToCalcRoute(poi.mGuidePoint, poi.mName);
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            RGRouteSearchModel.getInstance().setRouteSearchMode(false);
            BNPoiSearcher.getInstance().clearBkgCache();
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().showLayer(4, false);
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_ROUTE_SEARCH_VIA, NaviStatConstants.NAVI_ROUTE_SEARCH_VIA);
        }
    }

    public static void naviToDestPark(GeoPoint park) {
        BNRoutePlaner.getInstance().setGuideSceneType(4);
        RGSimpleGuideModel.getInstance();
        RGSimpleGuideModel.mCalcRouteType = 4;
        RGEngineControl.getInstance().setEndPtToCalcRoute(park);
    }

    public static void avoidRoadClose() {
    }

    public static String getPanDemandType(int index) {
        switch (index) {
            case 0:
                return "gs";
            case 1:
                return AsrOPParams.WC_CMD;
            case 2:
                return AsrOPParams.BANK_CMD;
            case 3:
                return "ss";
            case 4:
                return AsrOPParams.FOOD_CMD;
            case 5:
                return AsrOPParams.HOTEL_CMD;
            case 6:
                return AsrOPParams.SERVICE_AREA_CMD;
            case 7:
                return "pl";
            default:
                return null;
        }
    }

    public static String getPushCommandSpeech(String cmd, String tips) {
        if (BNavigator.getInstance().isBackgroundNavi()) {
            return tips;
        }
        if (cmd.equals(RoundInstructType.DEST_PARK)) {
            return tips + "," + VoiceContent.TIPS_DEST_PARK;
        }
        if (cmd.equals(RoundInstructType.ROUTE_RECOMMEND)) {
            return tips + "," + VoiceContent.ROUTE_RECOMMEND_TIPS_SWITCH;
        }
        return null;
    }

    private static void awaitSpeakMessage(String tips) {
        if (mTTSPlayStateListener != null) {
            mCurrentTips = tips;
            TTSPlayerControl.addTTSPlayStateListener(mTTSPlayStateListener);
        }
    }

    private static boolean canSpeakInstant() {
        return !TTSPlayerControl.getMapTTSPlayStatus();
    }

    public static void makeParkingSpeak(String tips) {
        if (BNavigator.getInstance().isNaviBegin()) {
            TTSPlayerControl.playTTS(tips, 0);
        }
    }

    public static boolean checkAuthrity(String auth) {
        Context ctx = BNaviModuleManager.getActivity();
        if (ctx == null) {
            return false;
        }
        try {
            boolean permission;
            if (ctx.getPackageManager().checkPermission(auth, PackageUtil.getPackageName()) == 0) {
                permission = true;
            } else {
                permission = false;
            }
            if (permission) {
                return permission;
            }
            if (auth.equals("android.permission.CALL_PHONE")) {
                BNavigator.getInstance().requestAuth("android.permission.CALL_PHONE");
                TipTool.onCreateToastDialog(ctx, XDVoiceInstructionParams.CALL_PHONE_MSG);
                return permission;
            } else if (auth.equals(XDVoiceInstructionParams.READ_CONTACTS_AUTH)) {
                LogUtil.m15791e(TAG, "no auth in read contacts");
                return permission;
            } else if (!auth.equals("android.permission.RECORD_AUDIO")) {
                return permission;
            } else {
                TipTool.onCreateToastDialog(ctx, "没有麦克风权限，请打开后重试");
                return permission;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static void makeMainAuxiliarySpeak(String tips) {
    }

    public static void makeAvoidJamSpeak(String tips) {
        if (canSpeakInstant()) {
            TTSPlayerControl.playTTS(tips, 0);
        } else {
            awaitSpeakMessage(tips);
        }
    }

    public static void ensureTTSStop() {
        boolean ttsStatus = TTSPlayerControl.getMapTTSPlayStatus();
        if (ttsStatus) {
            TTSPlayerControl.stopVoiceTTSOutput();
            TTSPlayerControl.pauseVoiceTTSOutput();
            BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
            LogUtil.m15791e(TAG, "dingbbinasr need to stop tts,current status is " + ttsStatus);
        }
    }

    public static boolean isAddressNeedUpload() {
        if (BNSettingManager.getAsrUploadAddress() == 1) {
            BNSettingManager.setHasAsrUploadAddress(2);
            LogUtil.m15791e(TAG, "dingbin upload contacts ----> true");
            return true;
        }
        LogUtil.m15791e(TAG, "dingbin upload contacts ----> false");
        return false;
    }

    public static void updateAddressUploadState() {
        if (BNSettingManager.getAsrUploadAddress() == 0) {
            BNSettingManager.setHasAsrUploadAddress(1);
        }
    }

    public static boolean isInOnLineMode() {
        if (BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 1 || BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 3) {
            return true;
        }
        return false;
    }

    public static SearchPoi getNearestPoi(List<SearchPoi> poiList) {
        SearchPoi searchPoi = new SearchPoi();
        int index = 0;
        int key = 0;
        double minDistance = Double.MAX_VALUE;
        LocData locData = BNExtGPSLocationManager.getInstance().getCurLocation();
        if (locData == null) {
            try {
                locData = BNSysLocationManager.getInstance().getCurLocation();
            } catch (Throwable th) {
            }
        }
        if (locData == null) {
            searchPoi.copy((SearchPoi) poiList.get(0));
        } else {
            double curLongtitudeE6 = locData.longitude * 100000.0d;
            double curLatitudeE6 = locData.latitude * 100000.0d;
            for (SearchPoi poi : poiList) {
                double tmpDist = StringUtils.geoSphereDistance(curLongtitudeE6, curLatitudeE6, (double) poi.mViewPoint.getLongitudeE6(), (double) poi.mViewPoint.getLatitudeE6());
                if (tmpDist < minDistance) {
                    key = index;
                    minDistance = tmpDist;
                }
                index++;
            }
            searchPoi.copy((SearchPoi) poiList.get(key));
        }
        return searchPoi;
    }
}
