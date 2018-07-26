package com.baidu.navisdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comjni.engine.AppEngine;

public class BNaviEngineManager {
    private static final String TAG = "Common";
    private static EngineCommonConfig mEngineCommonConfig;
    private static volatile BNaviEngineManager mInstance = null;
    public boolean mIsEngineInitSucc;
    private JNINaviManager mJNINaviManager;

    private BNaviEngineManager() {
        this.mJNINaviManager = null;
        this.mIsEngineInitSucc = false;
        this.mJNINaviManager = JNINaviManager.sInstance;
    }

    public static synchronized BNaviEngineManager getInstance() {
        BNaviEngineManager bNaviEngineManager;
        synchronized (BNaviEngineManager.class) {
            if (mInstance == null) {
                synchronized (BNaviEngineManager.class) {
                    if (mInstance == null) {
                        mInstance = new BNaviEngineManager();
                    }
                }
            }
            bNaviEngineManager = mInstance;
        }
        return bNaviEngineManager;
    }

    public boolean initEngine(EngineCommonConfig engineCommonConfig, Handler handler) {
        return initEngineBySync(engineCommonConfig);
    }

    public boolean initEngineBySync(EngineCommonConfig engineCommonConfig) {
        LogUtil.m15791e("Common", "initEngineBySync");
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peByType(3, "sdk_initEngineBySync_start", System.currentTimeMillis());
        }
        RespTimeStatItem.getInstance().setStartEngineTime();
        SysOSAPI.getInstance().setAppFolderName(engineCommonConfig.mStrAppFolderName);
        engineCommonConfig.mStrPath = SysOSAPI.getInstance().GetSDCardPath();
        SysOSAPI.getInstance().initEngineRes(BNaviModuleManager.getContext());
        Bundle bundle = SysOSAPI.getInstance().initPhoneInfo();
        bundle.putBoolean("showlog", BNSettingManager.isShowNativeLog());
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peByType(3, "sdk_initEngineBySync_lib_start", System.currentTimeMillis());
        }
        LogUtil.m15791e("Common", "initEngineBySync InitEngine start");
        boolean flag = AppEngine.InitEngine(bundle);
        LogUtil.m15791e("Common", "initEngineBySync InitEngine flag :" + flag);
        if (flag) {
            LogUtil.m15791e("Common", "NaviEngineManager initNaviManager");
            if (PerformStatItem.sUserTest) {
                PerformStatisticsController.peByType(3, "sdk_initEngineBySync.3", System.currentTimeMillis());
            }
            int ret = JNINaviManager.sInstance.initNaviManager(engineCommonConfig);
            LogUtil.m15791e("Common", "NaviEngineManager initNaviManager ret : " + ret);
            if (PerformStatItem.sUserTest) {
                PerformStatisticsController.peByType(3, "sdk_initEngineBySync_lib_end", System.currentTimeMillis());
            }
            if (ret == 0) {
                getInstance().mIsEngineInitSucc = true;
                LogUtil.m15791e("Common", "NaviEngineManager initSubSysHandle GUIDANCE");
                getInstance().initSubSysHandle(1);
                LogUtil.m15791e("Common", "NaviEngineManager initSubSysHandle VOICE_TTS");
                getInstance().initSubSysHandle(8);
                LogUtil.m15791e("Common", "NaviEngineManager mMengMengDa");
                if (engineCommonConfig.mMengMengDaTTSPath != null && engineCommonConfig.mMengMengDaTTSPath.length() > 0) {
                    LogUtil.m15791e("", "NaviEngineManager copy mengmengda.path=" + engineCommonConfig.mMengMengDaTTSPath);
                    long curTime = SystemClock.elapsedRealtime();
                    LogUtil.m15791e("", "NaviEngineManager copy mengmengda.copyOK=" + JNIVoicePersonalityControl.sInstance.CopyMaiDouPath(engineCommonConfig.mMengMengDaTTSPath) + ", time=" + (SystemClock.elapsedRealtime() - curTime) + "ms");
                }
                LogUtil.m15791e("Common", "NaviEngineManager setSpecVoiceTaskId");
                int mode = BNSettingManager.getVoicePersonality();
                String taskId = null;
                if (mode != 0) {
                    taskId = BNSettingManager.getVoiceTaskId();
                }
                BNRouteGuider instance;
                if (mode == 4) {
                    instance = BNRouteGuider.getInstance();
                    if (taskId == null) {
                        taskId = "0";
                    }
                    instance.setSpecVoiceTaskId(taskId, true);
                } else {
                    instance = BNRouteGuider.getInstance();
                    if (taskId == null) {
                        taskId = "0";
                    }
                    instance.setSpecVoiceTaskId(taskId);
                }
                LogUtil.m15791e("Common", "NaviEngineManager after init Engine");
                BNRoutePlaner.destory();
                BNRoutePlaner.getInstance();
            }
            RespTimeStatItem.getInstance().setEndEngineTime();
            if (PerformStatItem.sUserTest) {
                PerformStatisticsController.peByType(3, "sdk_initEngineBySync_end", System.currentTimeMillis());
            }
            if (ret == 0) {
                return true;
            }
            return false;
        }
        AppEngine.UnInitEngine();
        return false;
    }

    public synchronized boolean uninit() {
        boolean ret;
        ret = this.mJNINaviManager.uninitNaviManager() == 0;
        this.mJNINaviManager = null;
        mInstance = null;
        return ret;
    }

    public boolean reload() {
        uninitSubSysHandle(1);
        initSubSysHandle(1);
        if (0 == 0) {
            return true;
        }
        return false;
    }

    public synchronized boolean reloadSubSystem(int subSytemType) {
        uninitSubSysHandle(subSytemType);
        initSubSysHandle(subSytemType);
        return 0 == 0;
    }

    public int getFavoriteHandle() {
        return 1000;
    }

    public void initNaviStatistics() {
        if (VDeviceAPI.isWifiConnected() == 1) {
            try {
                this.mJNINaviManager.initNaviStatistics(2);
            } catch (Throwable th) {
            }
        }
    }

    public void changeNaviStatisticsNetworkStatus(int networkStatus) {
        try {
            if (isEngineInitSucc()) {
                this.mJNINaviManager.initNaviStatistics(networkStatus);
            }
        } catch (Throwable th) {
        }
    }

    public void uninitNaviStatistics() {
        this.mJNINaviManager.uninitNaviStatistics();
    }

    public synchronized boolean uninitEngine() {
        if (this.mJNINaviManager != null) {
            this.mJNINaviManager.uninitNaviManager();
        }
        this.mJNINaviManager = null;
        mInstance = null;
        return true;
    }

    public synchronized void uninitGuidanceEngine() {
        uninitSubSysHandle(1);
    }

    public boolean isEngineInitSucc() {
        return this.mIsEngineInitSucc;
    }

    public int initSubSysHandle(int sysType) {
        if (this.mJNINaviManager != null) {
            try {
                this.mJNINaviManager.initSubSystem(sysType);
            } catch (Throwable th) {
            }
        }
        return 0;
    }

    public void uninitSubSysHandle(int sysType) {
        if (this.mJNINaviManager != null) {
            try {
                this.mJNINaviManager.uninitSubSystem(sysType);
            } catch (Throwable th) {
            }
        }
    }

    public void updateAppSource(int appSource) {
        if (this.mJNINaviManager != null) {
            try {
                this.mJNINaviManager.updateAppSource(appSource);
            } catch (Throwable th) {
            }
        }
    }

    public String getIPByHost(String strHost) {
        try {
            return this.mJNINaviManager.getIPByHost(strHost);
        } catch (Throwable th) {
            return null;
        }
    }
}
