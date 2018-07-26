package com.baidu.navisdk.comapi.voicecommand;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams.VoiceRegActionFinishResult;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.AppStateUtils;
import com.baidu.navisdk.util.common.AppStateUtils.AppStateListener;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.PhoneStatusReceiver;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.sapi2.SapiWebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class BNVoiceCommandController extends BNLogicController {
    private static final boolean Open_Stat = true;
    public static final String TAG = BNVoiceCommandController.class.getSimpleName();
    private static byte[] appID = new String("navinavinavinavinavinavinavinavi").getBytes();
    private static String cuid = "baidu";
    private static int len = license.length;
    private static byte[] license = new String("bdccd9288c0e962011eae8bf12369e61a0fcb254d48f340b5755ac0ef46dd3dd9bdd09100f2c681cc78b634824e9ff2d2babbdcea918214c0459d34755455407d8f0def5b5c6f09a40b60915c204cef2159a6c89b0a658aef707393d02081a0df0421cdb3fee0b33dd32d449ef330175fa8309d8992abb92044de98ea320a482").getBytes();
    private static BNVoiceCommandController sInstance = null;
    private static Object sObj = new Object();
    private APPVoiceFuncCallback mAPPVoiceFuncCallback = null;
    private AppStateListener mAppStateListener = null;
    private boolean mHadResponseActionFinish = true;
    private Handler mHandler = null;
    private boolean mIsASRStarted = false;
    private boolean mIsJustStart = false;
    private boolean mIsRequestDelayResponse = false;
    private boolean mIsSettingHome = false;
    private boolean mIsSettingOffice = false;
    private int mLastestVCSubType = -1;
    private int mLastestVCTarget = -1;
    private int mLastestVCTopType = -1;
    private int mLastestVoiceStatus = 0;
    private OnVoiceCommandListener mOnVoiceCommandListener = null;
    private Set<OnVoiceStatusListener> mOnVoiceStatusListeners = new HashSet();
    private Object mSyncObj = new Object();

    /* renamed from: com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController$1 */
    class C40761 extends Handler {
        C40761() {
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            int topType = -1;
            switch (msg.what) {
                case 100:
                    BNVoiceCommandController.this.onResponseTimeout();
                    break;
                case 4154:
                    topType = 2;
                    LogUtil.m15791e(BNVoiceCommandController.TAG, "ui, arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                    break;
                case 4155:
                    topType = 3;
                    LogUtil.m15791e(BNVoiceCommandController.TAG, "PAGE, arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                    break;
                case 4156:
                    topType = 5;
                    LogUtil.m15791e(BNVoiceCommandController.TAG, "SEARCH, arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                    break;
                case 4157:
                    topType = 4;
                    LogUtil.m15791e(BNVoiceCommandController.TAG, "GUIDANCE, arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                    break;
                case 4159:
                    if (!BNVoiceCommandController.this.mIsJustStart || msg.arg1 != 0) {
                        LogUtil.m15791e(BNVoiceCommandController.TAG, "BNVoiceCommandController.status=" + msg.arg1);
                        if (msg.arg1 >= 0 && msg.arg1 <= 3) {
                            BNVoiceCommandController.this.mLastestVoiceStatus = msg.arg1;
                        }
                        if (msg.arg1 >= 0 && msg.arg1 <= 3 && BNVoiceCommandController.this.mOnVoiceStatusListeners.size() > 0) {
                            for (OnVoiceStatusListener onVoiceStatusChanged : BNVoiceCommandController.this.mOnVoiceStatusListeners) {
                                onVoiceStatusChanged.onVoiceStatusChanged(msg.arg1);
                            }
                        }
                        if (msg.arg1 == 3) {
                            BNVoiceCommandController.this.statVoiceCommandNotUnderstand();
                            break;
                        }
                    }
                    BNVoiceCommandController.this.mIsJustStart = false;
                    break;
                    break;
                case 4161:
                    if (BNVoiceCommandController.this.mAPPVoiceFuncCallback != null) {
                        BNVoiceCommandController.this.mAPPVoiceFuncCallback.poiDataNotNew();
                        break;
                    }
                    break;
                case NetworkListener.MSG_TYPE_NET_WORK_CHANGE /*5555*/:
                    BNVoiceCommandController bNVoiceCommandController = BNVoiceCommandController.this;
                    boolean z2 = msg.arg2 == 1;
                    if (msg.arg1 != 1) {
                        z = false;
                    }
                    bNVoiceCommandController.handleNetworkChanged(z2, z);
                    break;
                case PhoneStatusReceiver.MSG_TYPE_PHONE_CHANGE /*5556*/:
                    BNVoiceCommandController.this.handlePhoneStateChanged(msg.arg1);
                    break;
            }
            if (topType >= 0) {
                BNVoiceCommandController.this.handleVoiceCommandMsg(topType, msg.arg1, msg.arg2);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController$2 */
    class C40772 implements AppStateListener {
        C40772() {
        }

        public void onAppStateChanged(int type, int arg1, int arg2, Object obj) {
            if (1 == type) {
                BNVoiceCommandController.this.handleAppStateChanged(AppStateUtils.getInstance().getPhoneStatus(), AppStateUtils.getInstance().isForeground());
            }
        }
    }

    private BNVoiceCommandController() {
    }

    public static BNVoiceCommandController getInstance() {
        if (sInstance == null) {
            synchronized (sObj) {
                if (sInstance == null) {
                    sInstance = new BNVoiceCommandController();
                }
            }
        }
        return sInstance;
    }

    public void init() {
        initHandler();
        initListener();
        NetworkListener.registerMessageHandler(this.mHandler);
        PhoneStatusReceiver.registerMessageHandler(this.mHandler);
    }

    private void uninit() {
        uninitListener();
        NetworkListener.unRegisterMessageHandler(this.mHandler);
        PhoneStatusReceiver.unRegisterMessageHandler(this.mHandler);
    }

    public void setAPPVoiceFuncCallback(APPVoiceFuncCallback callback) {
        this.mAPPVoiceFuncCallback = callback;
    }

    public void addOnVoiceStatusListener(OnVoiceStatusListener lis) {
        if (lis != null) {
            this.mOnVoiceStatusListeners.add(lis);
        }
    }

    public void removeOnVoiceStatusListener(OnVoiceStatusListener lis) {
        if (lis != null) {
            this.mOnVoiceStatusListeners.remove(lis);
        }
    }

    public int getLastestVCTopType() {
        return this.mLastestVCTopType;
    }

    public int getLastestVCSubType() {
        return this.mLastestVCSubType;
    }

    public int getLastestVCTarget() {
        return this.mLastestVCTarget;
    }

    public int getLastestVoiceStatus() {
        return this.mLastestVoiceStatus;
    }

    public void setIsSettingHome(boolean setting) {
        this.mIsSettingHome = setting;
    }

    public boolean isSettingHome() {
        return this.mIsSettingHome;
    }

    public void setIsSettingOffice(boolean setting) {
        this.mIsSettingOffice = setting;
    }

    public boolean isSettingOffice() {
        return this.mIsSettingOffice;
    }

    public boolean isStarted() {
        return this.mIsASRStarted;
    }

    public boolean isRequestDelayResponse() {
        return this.mIsRequestDelayResponse;
    }

    public void requestDelayResponse(boolean delayResponse) {
        this.mIsRequestDelayResponse = delayResponse;
    }

    public boolean startASR() {
        if (!this.mIsASRStarted) {
            synchronized (sObj) {
                if (!this.mIsASRStarted) {
                    if (voiceASRVerifyLicense() == 0) {
                        LogUtil.m15791e(TAG, "startASR() success");
                        handleAppStateChanged(AppStateUtils.getInstance().getPhoneStatus(), AppStateUtils.getInstance().isForeground());
                        DistrictInfo di = GeoLocateModel.getInstance().getProvinceDistrict();
                        if (di != null) {
                            int provinceID = di.mId;
                        }
                        this.mIsASRStarted = false;
                    } else {
                        this.mIsASRStarted = false;
                        LogUtil.m15791e(TAG, "startASR() failed");
                    }
                }
            }
        }
        return this.mIsASRStarted;
    }

    public boolean stopASR() {
        if (this.mIsASRStarted) {
            synchronized (sObj) {
                if (this.mIsASRStarted) {
                }
            }
        }
        return !this.mIsASRStarted;
    }

    public int pauseASR() {
        return 0;
    }

    public int resumeASR() {
        return 0;
    }

    public void setOnVoiceCommandListener(OnVoiceCommandListener lis) {
        this.mOnVoiceCommandListener = lis;
    }

    private Bundle asrGetVoiceASRRegResult() {
        return new Bundle();
    }

    private int asrTriggerRegActionFinish(VoiceRegActionFinishResult actionFinishStatus) {
        LogUtil.m15791e(TAG, "asrTriggerRegActionFinish() response, mode=" + actionFinishStatus.regStatus + ", result=" + actionFinishStatus.actionStatus);
        cancelResponseTimeoutMsg();
        requestDelayResponse(false);
        this.mHadResponseActionFinish = true;
        statVoiceCommand(actionFinishStatus.actionStatus);
        return 0;
    }

    public int asrTriggerAppStatus(int appStatus) {
        return 0;
    }

    public int asrTriggerRecorderStatus(int recorderStatus) {
        return 0;
    }

    public int startVoiceRegDecode() {
        return 0;
    }

    public int stopVoiceRegDecode() {
        return 0;
    }

    private int voiceASRVerifyLicense() {
        return -1;
    }

    private void initHandler() {
        Collection careMsgTypes = new ArrayList();
        careMsgTypes.add(Integer.valueOf(4154));
        careMsgTypes.add(Integer.valueOf(4155));
        careMsgTypes.add(Integer.valueOf(4156));
        careMsgTypes.add(Integer.valueOf(4157));
        careMsgTypes.add(Integer.valueOf(4158));
        careMsgTypes.add(Integer.valueOf(4159));
        careMsgTypes.add(Integer.valueOf(4161));
        this.mHandler = new C40761();
        VMsgDispatcher.registerMsgHandler(this.mHandler, careMsgTypes);
    }

    private void initListener() {
        if (this.mAppStateListener == null) {
            this.mAppStateListener = new C40772();
        }
        AppStateUtils.getInstance().addAppStateListener(this.mAppStateListener);
    }

    private void uninitListener() {
        AppStateUtils.getInstance().removeAppStateListener(this.mAppStateListener);
    }

    private void handleNetworkChanged(boolean networkConnected, boolean wifiContected) {
    }

    private void handlePhoneStateChanged(int phoneState) {
        switch (phoneState) {
            case 1:
            case 3:
            case 4:
                handleAppStateChanged(phoneState, AppStateUtils.getInstance().isForeground());
                return;
            default:
                return;
        }
    }

    private void handleAppStateChanged(int phoneState, boolean isForeground) {
        if (3 == phoneState || 1 == phoneState) {
            asrTriggerAppStatus(2);
        } else if (isForeground) {
            asrTriggerAppStatus(1);
        } else {
            asrTriggerAppStatus(3);
        }
    }

    private void cancelResponseTimeoutMsg() {
        if (this.mHandler != null && this.mHandler.hasMessages(100)) {
            this.mHandler.removeMessages(100);
        }
    }

    private void arrangeResponseTimeoutMsg() {
        if (this.mHandler != null) {
            cancelResponseTimeoutMsg();
            this.mHandler.sendEmptyMessageDelayed(100, SapiWebView.DEFAULT_TIMEOUT_MILLIS);
        }
    }

    private void onResponseTimeout() {
        synchronized (this.mSyncObj) {
            if (!this.mHadResponseActionFinish) {
                this.mHadResponseActionFinish = true;
                VoiceRegActionFinishResult ret = new VoiceRegActionFinishResult();
                ret.regStatus = getLastestVCTopType();
                ret.actionStatus = 2;
                ret.extras = new Bundle();
                LogUtil.m15791e(TAG, "BNVoiceCommandController.onResponseTimeout() timeout response.");
                asrTriggerRegActionFinish(ret);
            }
        }
    }

    private void handleVoiceCommandMsg(int topType, int subType, int arg) {
        synchronized (this.mSyncObj) {
            this.mHadResponseActionFinish = false;
            arrangeResponseTimeoutMsg();
        }
        this.mLastestVCTopType = topType;
        this.mLastestVCSubType = subType;
        this.mLastestVCTarget = arg;
        Bundle data = null;
        if (5 == topType) {
            data = asrGetVoiceASRRegResult();
        }
        if (preHandleVoiceCommand(topType, subType, arg, data)) {
            if (this.mOnVoiceCommandListener != null) {
                this.mOnVoiceCommandListener.onVoiceCommand(topType, subType, arg, null, false);
            }
        } else if (this.mOnVoiceCommandListener == null) {
            defaultHandleVoiceCommand(topType, subType, arg, data);
        } else if (!this.mOnVoiceCommandListener.onVoiceCommand(topType, subType, arg, data, true) && defaultHandleVoiceCommand(topType, subType, arg, data)) {
            this.mOnVoiceCommandListener.onVoiceCommand(topType, subType, arg, null, false);
        }
        synchronized (this.mSyncObj) {
            if (!(isRequestDelayResponse() || this.mHadResponseActionFinish || 5 == topType)) {
                this.mHadResponseActionFinish = true;
                VoiceRegActionFinishResult ret = new VoiceRegActionFinishResult();
                ret.regStatus = topType;
                ret.actionStatus = 3;
                ret.extras = new Bundle();
                LogUtil.m15791e(TAG, "BNVoiceCommandController.handleVoiceCommandMsg() default response");
                asrTriggerRegActionFinish(ret);
            }
        }
    }

    public void handleVoiceCommandMsg(int topType, int subType, int arg, Bundle data) {
        synchronized (this.mSyncObj) {
            this.mHadResponseActionFinish = false;
            arrangeResponseTimeoutMsg();
        }
        this.mLastestVCTopType = topType;
        this.mLastestVCSubType = subType;
        this.mLastestVCTarget = arg;
        if (preHandleVoiceCommand(topType, subType, arg, data)) {
            if (this.mOnVoiceCommandListener != null) {
                this.mOnVoiceCommandListener.onVoiceCommand(topType, subType, arg, null, false);
            }
        } else if (this.mOnVoiceCommandListener == null) {
            defaultHandleVoiceCommand(topType, subType, arg, data);
        } else if (!this.mOnVoiceCommandListener.onVoiceCommand(topType, subType, arg, data, true) && defaultHandleVoiceCommand(topType, subType, arg, data)) {
            this.mOnVoiceCommandListener.onVoiceCommand(topType, subType, arg, null, false);
        }
        synchronized (this.mSyncObj) {
            if (!(isRequestDelayResponse() || this.mHadResponseActionFinish || 5 == topType)) {
                this.mHadResponseActionFinish = true;
                VoiceRegActionFinishResult ret = new VoiceRegActionFinishResult();
                ret.regStatus = topType;
                ret.actionStatus = 3;
                ret.extras = new Bundle();
                LogUtil.m15791e(TAG, "BNVoiceCommandController.handleVoiceCommandMsg() default respone");
                asrTriggerRegActionFinish(ret);
            }
        }
    }

    private boolean preHandleVoiceCommand(int type, int subType, int arg1, Object arg2) {
        if (2 != type) {
            if (!(3 == type || 5 == type || 4 != type)) {
                switch (subType) {
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        }
        switch (subType) {
            case 1:
                Intent it = new Intent("android.intent.action.CALL");
                if (BNaviModuleManager.getContext() != null) {
                    BNaviModuleManager.getContext().startActivity(it);
                }
                commonVoiceCommandResponse(type, 1);
                return true;
            case 4:
                AudioUtils.volumeUp(BNaviModuleManager.getContext());
                commonVoiceCommandResponse(type, 1);
                return true;
            case 5:
                AudioUtils.volumeDown(BNaviModuleManager.getContext());
                commonVoiceCommandResponse(type, 1);
                return true;
            case 6:
            case 11:
                BNSettingManager.setVoiceMode(2);
                BNRouteGuider.getInstance().setVoiceMode(2);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 9:
            case 33:
                BNSettingManager.setVoiceMode(0);
                BNRouteGuider.getInstance().setVoiceMode(0);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 10:
            case 34:
            case 35:
            case 36:
            case 37:
                BNSettingManager.setVoiceMode(1);
                BNRouteGuider.getInstance().setVoiceMode(1);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 12:
                BNSettingManager.setStraightDirectSpeakEnable(true);
                BNRouteGuider.getInstance().setStraightDirectSpeak(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 13:
                BNSettingManager.setStraightDirectSpeakEnable(false);
                BNRouteGuider.getInstance().setStraightDirectSpeak(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 14:
                BNSettingManager.setSpeedCameraSpeakEnable(true);
                BNRouteGuider.getInstance().setSpeedCameraSpeak(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 15:
                BNSettingManager.setSpeedCameraSpeakEnable(false);
                BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 31:
                if (this.mAPPVoiceFuncCallback == null) {
                    return false;
                }
                this.mAPPVoiceFuncCallback.switchDayNightMode(3);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 32:
                if (this.mAPPVoiceFuncCallback == null) {
                    return false;
                }
                this.mAPPVoiceFuncCallback.switchDayNightMode(2);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 40:
                if (this.mAPPVoiceFuncCallback != null) {
                    return this.mAPPVoiceFuncCallback.washCar();
                }
                getInstance().commonVoiceCommandResponse(type, 2);
                return true;
            case 41:
                if (this.mAPPVoiceFuncCallback != null) {
                    return this.mAPPVoiceFuncCallback.weather();
                }
                getInstance().commonVoiceCommandResponse(type, 2);
                return true;
            case 42:
                if (this.mAPPVoiceFuncCallback != null) {
                    return this.mAPPVoiceFuncCallback.limitLine();
                }
                getInstance().commonVoiceCommandResponse(type, 2);
                return true;
            case 43:
                VoiceCommandHelper.help();
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 46:
                BNSettingManager.setElecCameraSpeakEnable(true);
                BNRouteGuider.getInstance().setElecCameraSpeak(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 47:
                BNSettingManager.setElecCameraSpeakEnable(false);
                BNRouteGuider.getInstance().setElecCameraSpeak(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 48:
                BNSettingManager.setSaftyDriveSpeakEnable(true);
                BNRouteGuider.getInstance().setSaftyDriveSpeak(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 49:
                BNSettingManager.setSaftyDriveSpeakEnable(false);
                BNRouteGuider.getInstance().setSaftyDriveSpeak(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 56:
                BNSettingManager.setPrefSearchMode(3);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 57:
                BNSettingManager.setPrefSearchMode(2);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 58:
                BNSettingManager.setPrefRoutePlanMode(3);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 59:
                BNSettingManager.setPrefRoutePlanMode(2);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 60:
                BNSettingManager.setRoadConditionpeakEnable(true);
                BNRouteGuider.getInstance().setRoadConditionSpeak(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 61:
                BNSettingManager.setRoadConditionpeakEnable(false);
                BNRouteGuider.getInstance().setRoadConditionSpeak(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 62:
                BNSettingManager.setSpeedCameraSpeakEnable(true);
                BNRouteGuider.getInstance().setSpeedCameraSpeak(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 63:
                BNSettingManager.setSpeedCameraSpeakEnable(false);
                BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 64:
                if (this.mAPPVoiceFuncCallback == null) {
                    return false;
                }
                this.mAPPVoiceFuncCallback.showVoiceHelp();
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
        }
        return false;
    }

    private boolean defaultHandleVoiceCommand(int type, int subType, int arg1, Object arg2) {
        if (2 != type) {
            if (3 != type) {
                if (5 != type) {
                    if (4 == type) {
                        switch (subType) {
                            case 1:
                                String speakContent = BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_unknown);
                                if (BNGeoLocateManager.getInstance().isGPSLocationValid() && BNGeoLocateManager.getInstance().getCurLocation() != null) {
                                    speakContent = StringUtils.getDirection((double) BNGeoLocateManager.getInstance().getCurLocation().direction, speakContent);
                                }
                                getInstance().commonVoiceCommandResponse(type, 1, speakContent + BNStyleManager.getString(C4048R.string.bnav_string_hw_direction));
                                return true;
                            case 2:
                                if (this.mAPPVoiceFuncCallback == null) {
                                    return true;
                                }
                                String myloc = this.mAPPVoiceFuncCallback.myLoc();
                                if (myloc == null || myloc.length() <= 0) {
                                    commonVoiceCommandResponse(type, 2);
                                    return true;
                                }
                                commonVoiceCommandResponse(type, 1, myloc);
                                return true;
                            default:
                                break;
                        }
                    }
                }
                Bundle data;
                String name;
                switch (subType) {
                    case 3:
                        data = null;
                        if (arg2 != null && (arg2 instanceof Bundle)) {
                            data = (Bundle) arg2;
                        }
                        name = null;
                        if (data != null && data.containsKey("poiname")) {
                            name = data.getString("poiname");
                            LogUtil.m15791e(TAG, "Searchname2  poi=" + name);
                        }
                        if (name == null) {
                            commonVoiceCommandResponse(type, 0);
                            return true;
                        } else if (this.mAPPVoiceFuncCallback.nameSearch(name)) {
                            return true;
                        } else {
                            commonVoiceCommandResponse(type, 2);
                            return true;
                        }
                    case 4:
                        data = null;
                        if (arg2 != null && (arg2 instanceof Bundle)) {
                            data = (Bundle) arg2;
                        }
                        name = null;
                        if (data != null && data.containsKey("poiname")) {
                            name = data.getString("poiname");
                            LogUtil.m15791e(TAG, "SearchAround  poi=" + name);
                        }
                        if (name == null) {
                            commonVoiceCommandResponse(type, 0);
                            return true;
                        } else if (this.mAPPVoiceFuncCallback.spaceSearch(name)) {
                            return true;
                        } else {
                            commonVoiceCommandResponse(type, 2);
                            return true;
                        }
                    case 5:
                        if (this.mAPPVoiceFuncCallback != null) {
                            setIsSettingHome(true);
                            setIsSettingOffice(false);
                            this.mAPPVoiceFuncCallback.goHome();
                            return true;
                        }
                        commonVoiceCommandResponse(type, 2);
                        return true;
                    case 6:
                        if (this.mAPPVoiceFuncCallback != null) {
                            setIsSettingHome(false);
                            setIsSettingOffice(true);
                            this.mAPPVoiceFuncCallback.goOffice();
                            return true;
                        }
                        commonVoiceCommandResponse(type, 2);
                        return true;
                    default:
                        break;
                }
            }
            switch (subType) {
                case 2:
                    break;
                default:
                    break;
            }
        }
        switch (subType) {
            case 2:
                NMapControlProxy.getInstance().zoomOut();
                commonVoiceCommandResponse(type, 1);
                return true;
            case 3:
                NMapControlProxy.getInstance().zoomIn();
                commonVoiceCommandResponse(type, 1);
                return true;
            case 7:
                VoiceCommandHelper.onITSChanged(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 8:
                VoiceCommandHelper.onITSChanged(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 16:
                if (this.mAPPVoiceFuncCallback == null || !this.mAPPVoiceFuncCallback.onFullview()) {
                    getInstance().commonVoiceCommandResponse(type, 2);
                    return true;
                }
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 18:
                return true;
            case 20:
                VoiceCommandHelper.MapMoveLeft();
                commonVoiceCommandResponse(type, 1);
                return true;
            case 21:
                VoiceCommandHelper.MapMoveRight();
                commonVoiceCommandResponse(type, 1);
                return true;
            case 22:
                VoiceCommandHelper.MapMoveUp();
                commonVoiceCommandResponse(type, 1);
                return true;
            case 23:
                VoiceCommandHelper.MapMoveDown();
                commonVoiceCommandResponse(type, 1);
                return true;
            case 29:
            case 53:
                if (this.mAPPVoiceFuncCallback == null) {
                    commonVoiceCommandResponse(type, 3);
                    return true;
                } else if (this.mAPPVoiceFuncCallback.changeLocationMode(1)) {
                    commonVoiceCommandResponse(type, 1);
                    return true;
                } else {
                    commonVoiceCommandResponse(type, 2);
                    return true;
                }
            case 30:
                if (this.mAPPVoiceFuncCallback == null) {
                    commonVoiceCommandResponse(type, 3);
                    return true;
                } else if (this.mAPPVoiceFuncCallback.changeLocationMode(2)) {
                    commonVoiceCommandResponse(type, 1);
                    return true;
                } else {
                    commonVoiceCommandResponse(type, 2);
                    return true;
                }
            case 39:
                if (this.mAPPVoiceFuncCallback != null) {
                    this.mAPPVoiceFuncCallback.exitAPP();
                    commonVoiceCommandResponse(type, 1);
                    return true;
                }
                commonVoiceCommandResponse(type, 3);
                return true;
            case 54:
                BNSettingManager.setAlwaysBright(true);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
            case 55:
                BNSettingManager.setAlwaysBright(false);
                getInstance().commonVoiceCommandResponse(type, 1);
                return true;
        }
        return false;
    }

    public int commonVoiceCommandResponse(int voiceRegMode, int voiceRegActionRet) {
        return commonVoiceCommandResponse(voiceRegMode, voiceRegActionRet, new Bundle());
    }

    public int commonVoiceCommandResponse(int voiceRegMode, int voiceRegActionRet, String speakContent) {
        Bundle data = new Bundle();
        if (speakContent != null) {
            switch (voiceRegMode) {
                case 2:
                    data.putString(BNVoiceCommandParams.Key_VoiceASR_Weather_Info, speakContent);
                    break;
                case 3:
                    data.putString(BNVoiceCommandParams.Key_VoiceASR_Weather_Info, speakContent);
                    break;
                case 4:
                    data.putString(BNVoiceCommandParams.Key_VoiceASR_Guidance_Info, speakContent);
                    break;
                case 5:
                    data.putString(BNVoiceCommandParams.Key_VoiceASR_Cur_POI_Info, speakContent);
                    break;
            }
        }
        return commonVoiceCommandResponse(voiceRegMode, voiceRegActionRet, data);
    }

    public int commonVoiceCommandResponse(int voiceRegMode, int voiceRegActionRet, Bundle data) {
        synchronized (this.mSyncObj) {
            if (this.mHadResponseActionFinish) {
                return 0;
            }
            this.mHadResponseActionFinish = true;
            VoiceRegActionFinishResult ret = new VoiceRegActionFinishResult();
            ret.regStatus = voiceRegMode;
            ret.actionStatus = voiceRegActionRet;
            ret.extras = data;
            return asrTriggerRegActionFinish(ret);
        }
    }

    private void statVoiceCommand(int actionStatus) {
        String lt = null;
        switch (actionStatus) {
            case 1:
                lt = "1";
                break;
            case 2:
                lt = "2";
                break;
            case 3:
                lt = "3";
                break;
        }
        if (lt != null && lt.length() > 0) {
            ArrayList<NameValuePair> list = new ArrayList();
            int pageType = 0;
            if (this.mAPPVoiceFuncCallback != null) {
                pageType = this.mAPPVoiceFuncCallback.getPageType();
            }
            NameValuePair param1 = new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_VC_Page_Type, Integer.toString(pageType));
            NameValuePair param2 = new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_VC_Top_VC, Integer.toString(getLastestVCTopType()));
            NameValuePair param3 = new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_VC_Sub_VC, Integer.toString(getLastestVCSubType()));
            NameValuePair param4 = new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_VC_Target, Integer.toString(getLastestVCTarget()));
            list.add(param1);
            list.add(param2);
            list.add(param3);
            list.add(param4);
            BNStatisticsManager.getInstance().onEventWithParam(50008, lt, list);
        }
    }

    private void statVoiceCommandNotUnderstand() {
        int pageType = 0;
        if (this.mAPPVoiceFuncCallback != null) {
            pageType = this.mAPPVoiceFuncCallback.getPageType();
        }
        BNStatisticsManager.getInstance().onEventWithParam(50008, "4", new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_VC_Page_Type, Integer.toString(pageType)));
    }
}
