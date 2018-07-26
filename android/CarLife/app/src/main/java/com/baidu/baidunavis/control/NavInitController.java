package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavLocationManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.NavNetworkListener;
import com.baidu.baidunavis.NavSensorManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.navirecover.NaviRecoveryManager;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.mapframework.tts.OnTTSStateChangedListener;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.AppSourceDefine;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNIOfflineDataControl;
import com.baidu.navisdk.jni.nativeif.JNITTSPlayer;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.module.tingphone.control.TingPhoneFileManager;
import com.baidu.navisdk.ui.download.BNDownloadNotifyManager;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceAccountListener;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceDataSwitchListener;
import com.baidu.navisdk.ui.voice.BNVoice$VoiceSwitchData;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.logic.BNSysSensorManager;
import com.baidu.navisdk.util.statistic.IBNStatisticsListener;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.loop.BNPerformceFramework;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.p206a.C4747b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class NavInitController {
    private static final int MSG_CLEAN_TINGPHONE_FILE = 3;
    public static final int MSG_INIT_BASE_ENGINE_INNER = 100;
    private static final int MSG_INIT_CLOUD_CONFIG = 2;
    private static final int MSG_UPDATE_SWITCH_TTS_RESULT = 0;
    public static final String TAG = NavInitController.class.getSimpleName();
    private static NavInitController sInstance = null;
    private BNVoice$VoiceAccountListener mAccountListener = new BNVoice$VoiceAccountListener() {
        public String onGetAccountBduss() {
            String bduss = NavMapAdapter.getInstance().getBduss();
            return !TextUtils.isEmpty(bduss) ? bduss : null;
        }

        public void asynGetAccountHeadUrl() {
        }
    };
    private Callback mChildThreadCallback = new Callback() {
        public void careAbouts() {
            careAbout(50);
            careAbout(51);
            careAbout(55);
            careAbout(CommonHandlerThread.MSG_START_RECORD_TRAJECTORY);
        }

        public void execute(Message message) {
            switch (message.what) {
                case 50:
                    if (NavCommonFuncModel.getInstance().getActivity() == null) {
                        return;
                    }
                    if (message.obj == null || !(message.obj instanceof NaviEngineInitListener)) {
                        NavInitController.this.initBaseEngineStepOne(NavCommonFuncModel.getInstance().getActivity(), null);
                        return;
                    } else {
                        NavInitController.this.initBaseEngineStepOne(NavCommonFuncModel.getInstance().getActivity(), (NaviEngineInitListener) message.obj);
                        return;
                    }
                case 51:
                    NavInitController.this.delayInitModule();
                    return;
                case 55:
                    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-StartRecordTraj", null) {
                        protected String execute() {
                            int i = 1;
                            NavLogUtils.m3003e(TAG, "initAfterEngineInited()  updateUserInfo, bduss=" + NavMapAdapter.getInstance().getBduss() + ", uid=" + NavMapAdapter.getInstance().getUid() + ", islogin=" + (NavMapAdapter.getInstance().isLogin() ? 1 : 0));
                            try {
                                JNITrajectoryControl jNITrajectoryControl = JNITrajectoryControl.sInstance;
                                String bduss = NavMapAdapter.getInstance().getBduss();
                                String uid = NavMapAdapter.getInstance().getUid();
                                if (!NavMapAdapter.getInstance().isLogin()) {
                                    i = 0;
                                }
                                jNITrajectoryControl.updateUserInfo(bduss, uid, i);
                            } catch (Throwable th) {
                            }
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                    return;
                case CommonHandlerThread.MSG_START_RECORD_TRAJECTORY /*150*/:
                    try {
                        if (message.obj != null && (message.obj instanceof Bundle)) {
                            Bundle data = message.obj;
                            String userId = "";
                            if (data.containsKey("userId")) {
                                userId = data.getString("userId");
                            }
                            String startPointName = "";
                            if (data.containsKey("startPointName")) {
                                startPointName = data.getString("startPointName");
                            }
                            NavTrajectoryController.getInstance().startRecordInner(userId, startPointName, data.getInt("fromType"), data.getBoolean("selfRegisterLocation"), data.getBoolean("notInputStartEndGeo"));
                            NavLogUtils.m3003e(NavInitController.TAG, "initAfterEngineInited()  MSG_START_RECORD_TRAJECTORY");
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                default:
                    return;
            }
        }

        public String getName() {
            return "Navi-SDK-Init";
        }
    };
    private Handler mHandler = new Handler(CommonHandlerThread.getInstance().getLooper()) {
        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what == 100) {
                NavInitController.this.initBaseEngineStepTwoForEngine(NavInitController.this.mOutNaviEngineInitListener);
            } else if (msg.what == 0) {
                BNVoice instance = BNVoice.getInstance();
                if (msg.arg1 != 1) {
                    z = false;
                }
                instance.handleVoiceDataSwitchResult(z);
            } else if (msg.what == 2) {
                new CloudConfigObtainManager().initCloudConfigOutline();
            } else if (msg.what == 3) {
                TingPhoneFileManager.cleanPathFileAndConfig();
            }
        }
    };
    private Object mInitObj = new Object();
    private Object mNaviEngineInitListenerObj = new Object();
    private List<NaviEngineInitListener> mNaviEngineInitListeners = new ArrayList();
    private NaviEngineInitListener mOutNaviEngineInitListener = null;
    private BNVoice$VoiceDataSwitchListener mSwitchTTSListener = new BNVoice$VoiceDataSwitchListener() {
        public boolean onVoiceDataSwitch(BNVoice$VoiceSwitchData data) {
            if (data == null) {
                LogUtil.m3004e(BNVoiceParams.MODULE_TAG, "onVoiceDataSwitch data is null");
                return false;
            }
            LogUtil.m3004e(BNVoiceParams.MODULE_TAG, "onVoiceDataSwitch id :" + data.taskId);
            LogUtil.m3004e(BNVoiceParams.MODULE_TAG, "onVoiceDataSwitch mainPath :" + data.mainPath + " subPath:" + data.subPath);
            if (data.type == 0) {
                BaseTTSPlayer.getInstance().setCustomParams(false);
                BaseTTSPlayer.getInstance().loadCustomResource("");
                BaseTTSPlayer.getInstance().switchTTSVoiceData(null, NavInitController.this.mTtsSwitchListener);
            } else if (2 == data.type) {
                boolean setResult = BaseTTSPlayer.getInstance().setCustomParams(true);
                boolean loadResult = BaseTTSPlayer.getInstance().loadCustomResource(data.mainPath);
                boolean switchResult = BaseTTSPlayer.getInstance().switchTTSVoiceData(null, NavInitController.this.mTtsSwitchListener);
                if (!(loadResult && setResult && switchResult)) {
                    LogUtil.m3004e(BNVoiceParams.MODULE_TAG, "onVoiceDataSwitch result :" + loadResult + setResult + switchResult);
                }
            } else if (1 == data.type || 3 == data.type) {
                BaseTTSPlayer.getInstance().setCustomParams(false);
                BaseTTSPlayer.getInstance().loadCustomResource("");
                BaseTTSPlayer.getInstance().switchTTSVoiceData(data.mainPath, NavInitController.this.mTtsSwitchListener);
            } else if (4 == data.type) {
                BaseTTSPlayer.getInstance().setCustomParams(true);
                BaseTTSPlayer.getInstance().loadCustomResource(data.subPath);
                BaseTTSPlayer.getInstance().switchTTSVoiceData(data.mainPath, NavInitController.this.mTtsSwitchListener);
            }
            return true;
        }

        public boolean onFreeCustom(BNVoice$VoiceSwitchData data) {
            if (BaseTTSPlayer.getInstance().getTTSVoiceDataCustom()) {
                boolean resultSetSwitch = BaseTTSPlayer.getInstance().setCustomParams(false);
                LogUtil.m3004e(NavInitController.TAG, "onFreeCustom :" + resultSetSwitch + " resultSetPath" + BaseTTSPlayer.getInstance().loadCustomResource(""));
                if (resultSetSwitch) {
                    return BaseTTSPlayer.getInstance().freeCustomTTSVoiceData(data.subPath, NavInitController.this.mTtsSwitchListener);
                }
                return false;
            }
            LogUtil.m3004e(NavInitController.TAG, "onFreeCustom custom is false");
            return true;
        }

        public boolean onLoadCustom(BNVoice$VoiceSwitchData data) {
            if (data == null) {
                LogUtil.m3004e(BNVoiceParams.MODULE_TAG, "onLoadCustom data is null");
                return false;
            }
            LogUtil.m3004e(BNVoiceParams.MODULE_TAG, "onLoadCustom mainPath :" + data.mainPath + " subPath:" + data.subPath);
            if (BaseTTSPlayer.getInstance().getTTSVoiceDataCustom() && data.subPath != null && data.subPath.equals(BaseTTSPlayer.getInstance().getCustomVoiceDataPath())) {
                LogUtil.m3004e(NavInitController.TAG, "onLoadCustom has loaded");
                return true;
            }
            boolean resultSetSwitch = BaseTTSPlayer.getInstance().setCustomParams(true);
            boolean resultSetPath = BaseTTSPlayer.getInstance().loadCustomResource(data.subPath);
            LogUtil.m3004e(NavInitController.TAG, "onLoadCustom :" + resultSetSwitch + " resultSetPath " + resultSetPath);
            if (resultSetSwitch && resultSetPath) {
                return BaseTTSPlayer.getInstance().loadCustomTTSVoiceData(data.subPath, NavInitController.this.mTtsSwitchListener);
            }
            return false;
        }

        public boolean isCanSwitchVoice() {
            return BaseTTSPlayer.getInstance().canSwitchVoice();
        }
    };
    private OnTTSVoiceDataSwitchListener mTtsSwitchListener = new OnTTSVoiceDataSwitchListener() {
        public void onTTSVoiceDataSwitched(boolean switchSuccessed) {
            int i = 0;
            if (NavInitController.this.mHandler != null) {
                Message msg = NavInitController.this.mHandler.obtainMessage();
                msg.what = 0;
                if (switchSuccessed) {
                    i = 1;
                }
                msg.arg1 = i;
                NavInitController.this.mHandler.sendMessage(msg);
            }
        }
    };

    /* renamed from: com.baidu.baidunavis.control.NavInitController$1 */
    class C07911 implements IBNTTSPlayerListener {
        C07911() {
        }

        public int playTTSText(String arg0, String arg2, int arg1) {
            boolean z = true;
            LogUtil.m3004e(NavInitController.TAG, "tts -- playTTSText arg0 = " + arg0 + ", arg1 = " + arg1 + ", arg2 = " + arg2);
            if (!BNavigator.getInstance().isNaviBegin() && arg0 != null && "GPS信号弱,位置刷新可能不及时，请谨慎驾驶".equals(arg0)) {
                return 1;
            }
            BaseTTSPlayer instance = BaseTTSPlayer.getInstance();
            if (arg1 != 1) {
                z = false;
            }
            return instance.playTTSText(arg0, arg2, z);
        }

        public int playTTSText(String arg0, int arg1) {
            boolean z = true;
            LogUtil.m3004e(NavInitController.TAG, "tts -- playTTSText arg0 = " + arg0 + ", arg1 = " + arg1);
            if (!BNavigator.getInstance().isNaviBegin() && arg0 != null && "GPS信号弱,位置刷新可能不及时，请谨慎驾驶".equals(arg0)) {
                return 1;
            }
            BaseTTSPlayer instance = BaseTTSPlayer.getInstance();
            if (arg1 != 1) {
                z = false;
            }
            return instance.playTTSText(arg0, z);
        }

        public int playXDTTSText(String arg0, String arg2, int arg1) {
            LogUtil.m3004e(NavInitController.TAG, "tts -- playTTSText arg0 = " + arg0 + ", arg1 = " + arg1 + ", arg2 = " + arg2);
            return 0;
        }

        public void phoneHangUp() {
            BaseTTSPlayer.getInstance().setPhoneIn(false);
        }

        public void phoneCalling() {
            BaseTTSPlayer.getInstance().setPhoneIn(true);
            BaseTTSPlayer.getInstance().stopTTS();
            BaseTTSPlayer.getInstance().stopSound();
        }

        public int getTTSState() {
            return BaseTTSPlayer.getInstance().getTTSState();
        }

        public void initTTSPlayer() {
        }

        public void pauseTTS() {
            BaseTTSPlayer.getInstance().pauseTTS();
            LogUtil.m3004e(NavInitController.TAG, "tts -- pauseTTS");
        }

        public void releaseTTSPlayer() {
        }

        public void resumeTTS() {
            BaseTTSPlayer.getInstance().resumeTTS();
            JNIGuidanceControl.getInstance().setTTSPlayEnd();
            LogUtil.m3004e(NavInitController.TAG, "tts -- resumeTTS");
        }

        public void stopTTS() {
            BaseTTSPlayer.getInstance().stopTTS();
            LogUtil.m3004e(NavInitController.TAG, "tts -- stopTTS");
        }

        public int playAudio(String audioPath, AudioPlayerListener lis) {
            return BaseTTSPlayer.getInstance().playAudio(audioPath, lis);
        }

        public int cancelAudio() {
            return BaseTTSPlayer.getInstance().cancelAudio();
        }

        public void setNaviMuteState(boolean isNaviMute) {
            BaseTTSPlayer.getInstance().setNaviMuteState(isNaviMute);
        }

        public boolean isNaviMuteState() {
            return BaseTTSPlayer.getInstance().isNaviMuteState();
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavInitController$2 */
    class C07922 implements OnTTSStateChangedListener {
        C07922() {
        }

        public void onPlayEnd() {
            JNITTSPlayer.sInstance.PlayOver();
            JNIGuidanceControl.getInstance().setTTSPlayEnd();
            LogUtil.m3004e(NavInitController.TAG, "tts -- onPlayEnd");
        }

        public void onPlayStart() {
            LogUtil.m3004e(NavInitController.TAG, "tts -- onPlayStart");
        }

        public void onPlayError(int code, String message) {
        }
    }

    private NavInitController() {
    }

    public static NavInitController getInstance() {
        if (sInstance == null) {
            sInstance = new NavInitController();
        }
        return sInstance;
    }

    private boolean init(Activity a) {
        if (a == null) {
            return false;
        }
        return NavCommonFuncModel.getInstance().initParams(a);
    }

    public void handleAppSource() {
        BNaviModuleManager.sAppSourceStr = AppSourceDefine.DEFAULT_SOURCE;
        BNaviModuleManager.updateAppSource();
    }

    private void initAfterEngineInited() {
        handleAppSource();
        NavCommonFuncController.getInstance().registerNaviEventListener();
        initMTJStatisticsService();
        BNRoutePlaner.getInstance().init(BNaviModuleManager.getContext());
        BNRoutePlaner.getInstance().setCalcPrference(PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(RoutePlanParams.CALC_PREFERENCE, 1));
        setRoutePlanStatistcsUrl();
        try {
            NavRoutePlanController.getInstance().init();
        } catch (Throwable th) {
        }
        BNaviModuleManager.setupNaviCommonCallBackListener(NavCommonFuncController.getInstance().mNaviCommonCallBack);
        RespTimeStatItem.getInstance().addSDKInitTime();
    }

    private void initNaviTTSListener() {
        TTSPlayerControl.setTTSPlayerListener(new C07911());
        TTSPlayerControl.init();
        BaseTTSPlayer.getInstance().setOnTTSStateChangedListener(new C07922());
    }

    public void initBaseEngine(Activity activity, final NaviEngineInitListener naviEngineInitListener) {
        BNPerformceFramework.init(new NavPerformanceFramework());
        BNWorkerCenter.init(new NavWorkerCenter());
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peByType(3, "ad_init_start", System.currentTimeMillis());
        }
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-Init", null) {
            protected String execute() {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                NavInitController.this.initBaseEngineStepOne(NavCommonFuncModel.getInstance().getActivity(), naviEngineInitListener);
                return null;
            }
        }, new BNWorkerConfig(2, 1));
        if (this.mChildThreadCallback != null) {
            CommonHandlerThread.getInstance().registerCallback(this.mChildThreadCallback);
        }
    }

    public void loadNaviSO() {
        int i = 0;
        while (i < 2) {
            try {
                if (C4747b.a().a("gnustl_shared") && C4747b.a().a("app_BaiduVIlib") && C4747b.a().a("BDSpeechDecoder_V1") && C4747b.a().a("etts_domain_data_builder") && C4747b.a().a("app_BaiduNaviApplib") && C4747b.a().a("audiomessage-jni")) {
                    BaiduNaviManager.sIsNaviSoLoadSuccess = true;
                    break;
                } else {
                    BaiduNaviManager.sIsNaviSoLoadSuccess = false;
                    i++;
                }
            } catch (Throwable th) {
                BaiduNaviManager.sIsNaviSoLoadSuccess = false;
            }
        }
        NavLogUtils.m3003e(TAG, "static load so. sIsNaviSoLoadSuccess=" + BaiduNaviManager.sIsNaviSoLoadSuccess);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initBaseEngineStepOne(android.app.Activity r6, com.baidu.baidunavis.wrapper.NaviEngineInitListener r7) {
        /*
        r5 = this;
        r4 = 1;
        r3 = 0;
        r1 = TAG;
        r2 = "initBaseEngineStepOne() ";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r2);
        r5.loadNaviSO();
        r1 = com.baidu.baidunavis.BaiduNaviManager.isNaviSoLoadSuccess();
        if (r1 == 0) goto L_0x0015;
    L_0x0013:
        if (r6 != 0) goto L_0x0029;
    L_0x0015:
        com.baidu.baidunavis.BaiduNaviManager.sIsBaseEngineInitial = r3;
        com.baidu.baidunavis.BaiduNaviManager.sIsBaseEngineInitialized = r3;
        com.baidu.baidunavis.BaiduNaviManager.sIsEngineInitialFailed = r4;
        if (r7 == 0) goto L_0x0020;
    L_0x001d:
        r7.engineInitFail();
    L_0x0020:
        r1 = TAG;
        r2 = "initBaseEngine() return 1 so not loaded or activity is null";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r2);
    L_0x0028:
        return;
    L_0x0029:
        r2 = r5.mInitObj;
        monitor-enter(r2);
        r1 = com.baidu.baidunavis.BaiduNaviManager.sIsBaseEngineInitialized;	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x0042;
    L_0x0030:
        if (r7 == 0) goto L_0x0035;
    L_0x0032:
        r7.engineInitSuccess();	 Catch:{ all -> 0x003f }
    L_0x0035:
        r1 = TAG;	 Catch:{ all -> 0x003f }
        r3 = "initBaseEngine() return 2 inited";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r3);	 Catch:{ all -> 0x003f }
        monitor-exit(r2);	 Catch:{ all -> 0x003f }
        goto L_0x0028;
    L_0x003f:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003f }
        throw r1;
    L_0x0042:
        r1 = com.baidu.baidunavis.BaiduNaviManager.sIsBaseEngineInitial;	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x0066;
    L_0x0046:
        if (r7 == 0) goto L_0x0059;
    L_0x0048:
        r1 = TAG;	 Catch:{ all -> 0x003f }
        r3 = "initBaseEngine() return 3 , listen is added to list.";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r3);	 Catch:{ all -> 0x003f }
        r3 = r5.mNaviEngineInitListenerObj;	 Catch:{ all -> 0x003f }
        monitor-enter(r3);	 Catch:{ all -> 0x003f }
        r1 = r5.mNaviEngineInitListeners;	 Catch:{ all -> 0x0063 }
        r1.add(r7);	 Catch:{ all -> 0x0063 }
        monitor-exit(r3);	 Catch:{ all -> 0x0063 }
    L_0x0059:
        r1 = TAG;	 Catch:{ all -> 0x003f }
        r3 = "initBaseEngine() return 3 is initing.";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r3);	 Catch:{ all -> 0x003f }
        monitor-exit(r2);	 Catch:{ all -> 0x003f }
        goto L_0x0028;
    L_0x0063:
        r1 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0063 }
        throw r1;	 Catch:{ all -> 0x003f }
    L_0x0066:
        r1 = 1;
        com.baidu.baidunavis.BaiduNaviManager.sIsBaseEngineInitial = r1;	 Catch:{ all -> 0x003f }
        r1 = 0;
        com.baidu.baidunavis.BaiduNaviManager.sIsBaseEngineInitialized = r1;	 Catch:{ all -> 0x003f }
        r1 = 0;
        com.baidu.baidunavis.BaiduNaviManager.sIsEngineInitialFailed = r1;	 Catch:{ all -> 0x003f }
        r5.mOutNaviEngineInitListener = r7;	 Catch:{ all -> 0x003f }
        monitor-exit(r2);	 Catch:{ all -> 0x003f }
        if (r6 == 0) goto L_0x0090;
    L_0x0074:
        r1 = com.baidu.baidunavis.NavMapAdapter.getInstance();
        r1 = r1.isExternalStorageEnabled();
        if (r1 != 0) goto L_0x0090;
    L_0x007e:
        r1 = 2131296667; // 0x7f09019b float:1.8211257E38 double:1.0530004643E-314;
        com.baidu.baidunavis.ui.widget.NavTipTool.onCreateToastDialog(r6, r1);
        r5.handleEngineInitFailed();
        r1 = TAG;
        r2 = "initBaseEngine() return 4 sdcard error.";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r2);
        goto L_0x0028;
    L_0x0090:
        r1 = com.baidu.navisdk.util.statistic.RespTimeStatItem.getInstance();
        r1.setStartAppTime();
        r1 = com.baidu.navisdk.util.statistic.RespTimeStatItem.getInstance();
        r1.startCountSDKInitTime();
        r1 = getInstance();
        r1 = r1.init(r6);
        if (r1 != 0) goto L_0x00b5;
    L_0x00a8:
        r5.handleEngineInitFailed();
        r1 = TAG;
        r2 = "initBaseEngine() return 5";
        com.baidu.baidunavis.control.NavLogUtils.m3003e(r1, r2);
        goto L_0x0028;
    L_0x00b5:
        r1 = com.baidu.platform.comapi.util.SysOSAPIv2.getInstance();
        r0 = r1.getSdcardPath();
        r1 = com.baidu.navisdk.util.common.SysOSAPI.getInstance();
        r1.init();
        r1 = com.baidu.navisdk.util.common.SysOSAPI.getInstance();
        r2 = com.baidu.baidunavis.NavMapAdapter.getInstance();
        r2 = r2.getDataFolderName();
        r1.setAppFolderName(r2);
        r1 = com.baidu.navisdk.util.common.SysOSAPI.getInstance();
        r1.initSDcardPath(r0);
        r1 = com.baidu.navisdk.comapi.setting.BNSettingManager.isShowJavaLog();
        com.baidu.navisdk.util.common.LogUtil.LOGGABLE = r1;
        r1 = com.baidu.platform.comapi.util.SysOSAPIv2.getInstance();
        r1 = r1.getCuid();
        com.baidu.navisdk.util.common.PackageUtil.setCuid(r1);
        r1 = new com.baidu.baidunavis.control.NavHttpCenter;
        r1.<init>();
        com.baidu.navisdk.util.http.center.BNHttpCenter.init(r1);
        com.baidu.navisdk.BNaviModuleManager.initListenersForMap(r6);
        r1 = TAG;
        r2 = "initpack-------------";
        android.util.Log.e(r1, r2);
        com.baidu.navisdk.BNaviModuleManager.initContext(r6);
        r1 = com.baidu.navisdk.util.http.HttpURLManager.getInstance();
        r1.initUrlData();
        r1 = r5.mOutNaviEngineInitListener;
        r5.initBaseEngineStepTwoForEngine(r1);
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.control.NavInitController.initBaseEngineStepOne(android.app.Activity, com.baidu.baidunavis.wrapper.NaviEngineInitListener):void");
    }

    private void handleEngineInitStart() {
        LogUtil.m3004e(TAG, "handleEngineInitStart()");
        if (this.mOutNaviEngineInitListener != null) {
            this.mOutNaviEngineInitListener.engineInitStart();
        }
        if (this.mNaviEngineInitListeners.size() > 0) {
            synchronized (this.mNaviEngineInitListenerObj) {
                for (int i = this.mNaviEngineInitListeners.size() - 1; i >= 0; i--) {
                    ((NaviEngineInitListener) this.mNaviEngineInitListeners.get(i)).engineInitStart();
                }
            }
        }
    }

    private void handleEngineInitSuccess() {
        LogUtil.m3004e(TAG, "handleEngineInitSuccess()");
        if (testNaviResourceLoad()) {
            BaiduNaviManager.sIsBaseEngineInitial = false;
            BaiduNaviManager.sIsBaseEngineInitialized = true;
            BaiduNaviManager.sIsEngineInitialFailed = false;
            if (NavCommonFuncModel.getInstance().getActivity() == null) {
                handleEngineInitFailed();
                return;
            }
            try {
                BNaviModuleManager.setupBase(true);
            } catch (Throwable th) {
            }
            getInstance().initAfterEngineInited();
            if (PerformStatItem.sUserTest) {
                PerformStatisticsController.peByType(3, "ad_init_ok", System.currentTimeMillis());
            }
            BNEyeSpyPaperController.getInstance().endInitMonitor(true);
            if (this.mOutNaviEngineInitListener != null) {
                this.mOutNaviEngineInitListener.engineInitSuccess();
            }
            if (this.mNaviEngineInitListeners.size() > 0) {
                synchronized (this.mNaviEngineInitListenerObj) {
                    for (int i = this.mNaviEngineInitListeners.size() - 1; i >= 0; i--) {
                        NavLogUtils.m3003e(TAG, "handleEngineInitSuccess() dispatch to listen" + i);
                        ((NaviEngineInitListener) this.mNaviEngineInitListeners.get(i)).engineInitSuccess();
                        this.mNaviEngineInitListeners.remove(i);
                    }
                }
            }
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-Init-Delay", null) {
                protected String execute() {
                    NavInitController.this.delayInitModule();
                    return null;
                }
            }, new BNWorkerConfig(2, 1));
            return;
        }
        LogUtil.m3004e(TAG, "failed to load jar resource.");
        handleEngineInitFailed();
    }

    private void handleEngineInitFailed() {
        LogUtil.m3004e(TAG, "handleEngineInitFailed()");
        UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_2, "1", null, null);
        BaiduNaviManager.sIsBaseEngineInitial = false;
        BaiduNaviManager.sIsBaseEngineInitialized = false;
        BaiduNaviManager.sIsEngineInitialFailed = true;
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peByType(3, "ad_init_failed", System.currentTimeMillis());
        }
        BNEyeSpyPaperController.getInstance().endInitMonitor(false);
        if (this.mOutNaviEngineInitListener != null) {
            this.mOutNaviEngineInitListener.engineInitFail();
        }
        synchronized (this.mNaviEngineInitListenerObj) {
            for (int i = this.mNaviEngineInitListeners.size() - 1; i >= 0; i--) {
                ((NaviEngineInitListener) this.mNaviEngineInitListeners.get(i)).engineInitFail();
                this.mNaviEngineInitListeners.remove(i);
            }
        }
    }

    private void initBaseEngineStepTwoForEngine(NaviEngineInitListener naviEngineInitListener) {
        BNEyeSpyPaperController.getInstance().startInitMonitor();
        if (NavCommonFuncModel.getInstance().getActivity() == null) {
            handleEngineInitFailed();
            return;
        }
        handleEngineInitStart();
        try {
            if (BNaviEngineManager.getInstance().initEngine(getEngineCommonConfig(), this.mHandler)) {
                handleEngineInitSuccess();
            } else {
                handleEngineInitFailed();
            }
        } catch (Throwable th) {
            handleEngineInitFailed();
        }
    }

    private void delayInitModule() {
        try {
            initNaviTTSListener();
            BNVoice.getInstance().setVoiceDataSwitchListener(this.mSwitchTTSListener);
            BNVoice.getInstance().setVoiceAccountListener(this.mAccountListener);
        } catch (Throwable th) {
        }
        try {
            BNOfflineDataManager.getInstance().initDownloadInfo(true);
            if (NavCommonFuncModel.getInstance().getActivity() != null) {
                NavMapAdapter.getInstance().checkNewVerData(NavCommonFuncModel.getInstance().getActivity());
            }
            BaiduNaviManager.getInstance().downLoadCityMapData(NavCommonFuncController.getInstance().getLocationCityId());
        } catch (Throwable th2) {
        }
        try {
            BNSysLocationManager.getInstance().init(BNaviModuleManager.getContext());
            BNSysSensorManager.getInstance().initSensor(BNaviModuleManager.getContext());
            NavSensorManager.getInstence().addSensorChangeListener();
        } catch (Throwable th3) {
        }
        NavLocationManager.getInstance().addLocationListener();
        if (BaiduNaviManager.getInstance().mIsMapUseGPS) {
            BaiduNaviManager.getInstance().notifyMapGPSEnable(true);
        }
        if (!(NavCommonFuncModel.getInstance().getActivity() == null || NavRoutePlanModel.getInstance().getEntry() == 7)) {
            NavMapAdapter.importSettingToNaviSDK(NavCommonFuncModel.getInstance().getActivity());
            BNRecoverNaviHelper.getInstance().init();
        }
        NaviRecoveryManager.getInstance().resetCrashAndKillTime(NavCommonFuncModel.getInstance().getActivity());
        NavMapManager.getInstance().init();
        NavNetworkListener.getInstance().registNetworkTypeChangeEvent();
        try {
            NavDayNightController.getInstance().init();
            BNStatisticsManager.getInstance().init();
        } catch (Throwable th4) {
        }
        BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("CarNavi-UpdateUserInfo", null) {
            protected String execute() {
                int i = 1;
                NavLogUtils.m3003e(TAG, "initAfterEngineInited()  updateUserInfo, bduss=" + NavMapAdapter.getInstance().getBduss() + ", uid=" + NavMapAdapter.getInstance().getUid() + ", islogin=" + (NavMapAdapter.getInstance().isLogin() ? 1 : 0));
                try {
                    JNITrajectoryControl jNITrajectoryControl = JNITrajectoryControl.sInstance;
                    String bduss = NavMapAdapter.getInstance().getBduss();
                    String uid = NavMapAdapter.getInstance().getUid();
                    if (!NavMapAdapter.getInstance().isLogin()) {
                        i = 0;
                    }
                    jNITrajectoryControl.updateUserInfo(bduss, uid, i);
                } catch (Throwable th) {
                }
                return null;
            }
        }, new BNWorkerConfig(100, 0), BNOffScreenParams.MIN_ENTER_INTERVAL);
        checkXiJiang();
        BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("CarNavi-CloudConfig", null) {
            protected String execute() {
                new CloudConfigObtainManager().initCloudConfigOutline();
                return null;
            }
        }, new BNWorkerConfig(100, 0), 1000);
        BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("CarNavi-TingPhone", null) {
            protected String execute() {
                TingPhoneFileManager.cleanPathFileAndConfig();
                return null;
            }
        }, new BNWorkerConfig(100, 0), 12000);
        NavMapAdapter.sMonkey = BNSettingManager.isMonkey();
        if (NavMapAdapter.sMonkey) {
            try {
                NavRouteGuideController.getInstance().runMonkey();
            } catch (Throwable th5) {
            }
        }
        UserOPController.getInstance().add(UserOPParams.ASYN_WALK_8_2_8, "3", null, null);
        if (NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData) {
            NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData = false;
            UserOPController.getInstance().add(UserOPParams.COMMON_1_q);
        }
        if (PerformStatItem.sBatchTestNetworkAndServerTime && this.mHandler != null) {
            BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("CarNavi-BatchNetworkTest", null) {
                protected String execute() {
                    PerformStatisticsController.getInstance().startBatchTestNetworkAndServer();
                    if (NavCommonFuncModel.getInstance().getActivity() != null) {
                        Toast.makeText(NavCommonFuncModel.getInstance().getActivity(), "开始批量测试百度网络和服务端耗时", 0).show();
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0), BNOffScreenParams.MIN_ENTER_INTERVAL);
        }
    }

    private void checkXiJiang() {
        BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask<String, String>("CarNavi-checkXiJiang", null) {
            protected String execute() {
                try {
                    if (!(NetworkUtils.isNetworkAvailable(NavCommonFuncModel.getInstance().getActivity()) && JNIOfflineDataControl.getInstance().checkNewVer(new Bundle(), new int[35]))) {
                        NavInitController.this.checkXiJiang();
                    }
                } catch (Throwable th) {
                }
                return null;
            }
        }, new BNWorkerConfig(100, 0), 43200000);
    }

    private void setRoutePlanStatistcsUrl() {
        String strUrl = "";
        try {
            strUrl = ((("&mb=" + URLEncoder.encode(VDeviceAPI.getPhoneType(), "UTF-8")) + "&sv=" + URLEncoder.encode(VDeviceAPI.getAppPackageVersion(), "UTF-8")) + "&pcn=" + URLEncoder.encode(VDeviceAPI.getAppPackageName(), "UTF-8")) + "&kv=" + URLEncoder.encode(VDeviceAPI.getSDKVersion(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        strUrl = ((strUrl + "&os=android") + "&net=" + com.baidu.vi.VDeviceAPI.getCurrentNetworkType()) + "&channel=" + SysOSAPIv2.getInstance().getChannel();
        NavRoutePlanModel.getInstance().routePlanStatistcsUrl = strUrl;
        BNRoutePlaner.getInstance().setRoutePlanStatistcsUrl(strUrl);
        NavLogUtils.m3003e(TAG, "setRoutePlanStatistcsUrl() url=" + strUrl);
    }

    private EngineCommonConfig getEngineCommonConfig() {
        String sdcardDir = SysOSAPIv2.getInstance().getSdcardPath();
        SysOSAPI.getInstance().setAppFolderName(NavMapAdapter.getInstance().getDataFolderName());
        SysOSAPI.getInstance().initSDcardPath(sdcardDir);
        SysOSAPI.getInstance().setOfflineDataPath(SysOSAPI.getInstance().GetSDCardPath());
        String mSdcardPath = sdcardDir;
        EngineCommonConfig engineCommonConfig = new EngineCommonConfig();
        engineCommonConfig.mSearchNetMode = BNSettingManager.getPrefSearchMode();
        engineCommonConfig.mGuidanceNetMode = 0;
        engineCommonConfig.mMapEngineNetMode = 0;
        engineCommonConfig.mOtherEngineNetMode = 0;
        engineCommonConfig.mStrProductName = "baiduNavi_SDK_FOR_Map";
        engineCommonConfig.mRootPath = mSdcardPath;
        engineCommonConfig.mStrMapPath = NavMapAdapter.getInstance().getDataPath();
        engineCommonConfig.mStrAppFolderName = NavMapAdapter.getInstance().getDataFolderName();
        try {
            engineCommonConfig.mMengMengDaTTSPath = NavMapAdapter.getInstance().getMengMengDaTTSPath();
        } catch (Throwable th) {
        }
        return engineCommonConfig;
    }

    public void uninitEngine() {
        LogUtil.m3004e("uninitEngine", null);
        NavNetworkListener.getInstance().unregistNetworkTypeChangeEvent();
        BNRoutePlaner.destory();
        BNaviModuleManager.destory();
        BaiduNaviManager.sIsBaseEngineInitial = false;
        BaiduNaviManager.sIsBaseEngineInitialized = false;
        BaiduNaviManager.sIsEngineInitialFailed = false;
        NavCommonFuncController.getInstance().unregisterNaviEventListener();
    }

    private void initMTJStatisticsService() {
        BNStatisticsManager.getInstance().setStatisticsListener(new IBNStatisticsListener() {
            public void onEventStart(Context arg0, String arg1, String arg2) {
            }

            public void onEventEnd(Context arg0, String arg1, String arg2) {
            }

            public void onEventDuration(Context arg0, String arg1, String arg2, int arg3) {
            }

            public void onEvent(String s, String s1) {
                StatisticManager.onEvent(s, s1);
            }

            public void onEventDuration(String s, String s1, int i) {
            }

            public void onEvent(Context arg0, String arg1, String arg2) {
            }
        });
    }

    private boolean testNaviResourceLoad() {
        return true;
    }

    public static void destroy() {
        BNDownloadUIManager.pauseAllDownload();
        BNDownloadNotifyManager.getInstance().clearNotification();
        if (NavUserBehaviour.isInitialized()) {
            NavUserBehaviour.destory();
        }
        BaiduNaviManager.getInstance().uninitEngine();
    }
}
