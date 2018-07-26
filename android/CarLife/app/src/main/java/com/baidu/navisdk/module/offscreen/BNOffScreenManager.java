package com.baidu.navisdk.module.offscreen;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings.System;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class BNOffScreenManager {
    public static final String MODULE_NAME = "offScreen";
    private static BNOffScreenManager mInstance = null;
    public static boolean sIsBrightOffEffect = false;
    public static boolean sIsInNavi = false;
    public static boolean sIsInOffScreenMode = false;
    public static boolean sIsModelueActive = false;
    public static boolean sIsReallyLeave = false;
    private static long sLastEnterTime = -100000;
    public boolean isEnterOffScreen = false;
    public boolean isInCheckingTime = false;
    public boolean isOffScreenDelaying = false;
    private float mHalfBright = 102.0f;
    private Handler mHandler = new Handler();
    private IOffScreenListener mOffScreenListener;

    public interface IOffScreenListener {
        boolean setOffScreenBackground(boolean z);
    }

    public static BNOffScreenManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNOffScreenManager();
        }
        return mInstance;
    }

    public void setOffScreenListener(IOffScreenListener listener) {
        this.mOffScreenListener = listener;
    }

    public void setOffScreenBackground(boolean isOffScreen) {
        if (this.mOffScreenListener != null) {
            this.mOffScreenListener.setOffScreenBackground(isOffScreen);
        }
    }

    public void initOffScreen() {
        BNSettingManager.setNormalBrightness(BNPowerSaver.getBrightness(BNaviModuleManager.getNaviActivity()));
        testPrint(MODULE_NAME, "initOffScreen");
        sIsInNavi = true;
        this.isEnterOffScreen = false;
    }

    public boolean canEnterOffScreenState() {
        boolean z = true;
        if (!sIsModelueActive) {
            return false;
        }
        boolean ret2;
        boolean ret0 = canOffScreenShow();
        if (BNPowerSaver.getInstance().getmBatteryLevel() < 35) {
            ret2 = true;
        } else {
            ret2 = false;
        }
        boolean ret3 = true;
        if (BNSettingManager.getPowerSaveMode() == 2) {
            ret3 = false;
        }
        boolean ret4 = BNPowerSaver.getInstance().ismIsBatteryCharging();
        boolean ret5 = sIsBrightOffEffect;
        LogUtil.m15791e(MODULE_NAME, "manger ret 0 ,ret2, ret3, ret4 , ret5 is " + ret0 + ret2 + ", " + ret3 + "," + ret4 + "," + ret5);
        testPrint(MODULE_NAME, "manager ret 0,ret2, ret3, ret4 , ret5 is " + ret0 + ret2 + ", " + ret3 + "," + ret4 + "," + ret5);
        if (!(ret0 && ret2 && ret3 && !ret4 && ret5)) {
            z = false;
        }
        return z;
    }

    public boolean canOffScreenShow() {
        return !RGMapModeViewController.getInstance().getHudShowStatus();
    }

    public void enterOffScreenState() {
        if (this.isInCheckingTime || RGOffScreenModel.getInstance().isInCounting || sIsInOffScreenMode) {
            testPrint(MODULE_NAME, "failed enterOffScreenState , isInCheckingTime is , isInCounting is , sIsInOffScreenMode " + this.isInCheckingTime + RGOffScreenModel.getInstance().isInCounting);
            LogUtil.m15791e(MODULE_NAME, "failed enterOffScreenState , isInCheckingTime is , isInCounting is , sIsInOffScreenMode " + this.isInCheckingTime + RGOffScreenModel.getInstance().isInCounting);
            return;
        }
        long currentTime = System.currentTimeMillis();
        long timeInterval = currentTime - sLastEnterTime;
        sLastEnterTime = currentTime;
        if (timeInterval < BNOffScreenParams.MIN_ENTER_INTERVAL) {
            testPrint(MODULE_NAME, "time stop it");
            return;
        }
        test();
        this.isInCheckingTime = true;
        LogUtil.m15791e(MODULE_NAME, "enter in enterOffScreenState");
        testPrint(MODULE_NAME, "enter in enterOffScreenState");
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("enterOffScreenState-" + getClass().getSimpleName(), null) {
            protected String execute() {
                TTSPlayerControl.playTTS(BNOffScreenParams.OFF_SCREEN_LOW_BATTERY, 0);
                return null;
            }
        }, new BNWorkerConfig(2, 0));
        RGOffScreenModel.getInstance().isCurrentLocationActive = true;
        RGMapModeViewController.getInstance().requestShowExpendView(1, true);
        this.isInCheckingTime = false;
    }

    public void offScreenAction() {
        LogUtil.m15791e(MODULE_NAME, "original brightness is " + BNPowerSaver.getBrightness(BNaviModuleManager.getNaviActivity()));
        sIsInOffScreenMode = true;
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("offScreenAction-" + getClass().getSimpleName(), null) {
            protected String execute() {
                TTSPlayerControl.playTTS(BNOffScreenParams.OFF_SCREEN_LOW_BATTERY, 0);
                return null;
            }
        }, new BNWorkerConfig(2, 0));
        BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), (int) (BNOffScreenParams.OFF_MIN_BRIGHTNESS * 255.0f));
        BNMapController.getInstance().onPause();
        darkScreen();
    }

    private void darkScreen() {
        setOffScreenBackground(true);
    }

    public void backToNormalGuide() {
        BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), BNSettingManager.getNormalBrightness());
    }

    protected void exitOffScreenState() {
        BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), (int) this.mHalfBright);
        BNMapController.getInstance().onResume();
        setOffScreenBackground(false);
        sIsInOffScreenMode = false;
        this.isOffScreenDelaying = false;
    }

    public void handleExitOffScreen() {
        if (sIsModelueActive && sIsInOffScreenMode) {
            LogUtil.m15791e(MODULE_NAME, "handleExitOffScreen");
            testPrint(MODULE_NAME, "handleExitOffScreen");
            exitOffScreenState();
            if (!sIsReallyLeave) {
                LogUtil.m15791e(MODULE_NAME, "not sIsReallyLeave");
                testPrint(MODULE_NAME, "not sIsReallyLeave");
                this.isOffScreenDelaying = true;
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("HandleExitOffScreen-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        BNOffScreenManager.this.isOffScreenDelaying = false;
                        if (BNOffScreenManager.this.canEnterOffScreenState()) {
                            BNOffScreenManager.this.enterOffScreenState();
                        }
                        return null;
                    }
                }, new BNWorkerConfig(2, 0), HttpsClient.CONN_MGR_TIMEOUT);
            }
        }
    }

    public void onChargedAction() {
        if (sIsModelueActive && sIsInOffScreenMode) {
            sIsReallyLeave = true;
            LogUtil.m15791e(MODULE_NAME, "onChargedAction");
            testPrint(MODULE_NAME, "onChargedAction");
            setOffScreenBackground(false);
            backToNormalGuide();
            BNMapController.getInstance().onResume();
            sIsInOffScreenMode = false;
            RGOffScreenModel.getInstance().isCurrentLocationActive = false;
        }
    }

    public void uninitOffScreen() {
        RGOffScreenModel.getInstance().isCurrentLocationActive = false;
        sIsReallyLeave = true;
        sIsInOffScreenMode = false;
        sIsBrightOffEffect = false;
        setOffScreenBackground(false);
        if (this.isEnterOffScreen) {
            backResetBrightness();
        }
        testPrint(MODULE_NAME, "uninit off screen");
        test();
        testPrint(MODULE_NAME, "uninitOffScreen");
        sIsInNavi = false;
    }

    private void backResetBrightness() {
        Context ctx = BNaviModuleManager.getContext();
        if (ctx != null) {
            try {
                if (System.getInt(ctx.getContentResolver(), "screen_brightness_mode") == 1) {
                    int brightness = (int) (BNOffScreenParams.BACK_AUTO_BRIGHTNESS * 255.0f);
                    LogUtil.m15791e("MODULE_NAME", "backResetBrightness mode is automode bright ness is " + brightness);
                    BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), brightness);
                    return;
                }
                BNPowerSaver.setBrightness(BNaviModuleManager.getNaviActivity(), BNSettingManager.getNormalBrightness());
                LogUtil.m15791e("MODULE_NAME", "backResetBrightness mode is mannully mode bright ness is " + BNSettingManager.getNormalBrightness());
            } catch (Exception e) {
            }
        }
    }

    public void handeMsgBrightAction(int type) {
        if (!sIsModelueActive) {
            return;
        }
        if (RGOffScreenModel.getInstance().isInCounting) {
            testPrint(MODULE_NAME, "handeMsgBrightAction isincounting");
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("HandeMsgBrightAction-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    if (BNOffScreenManager.sIsInOffScreenMode && RGOffScreenModel.sCurrentMsgType == 2) {
                        BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "handeMsgBrightAction in it,haha");
                        BNOffScreenManager.this.handleOffScreenMsg(2);
                    }
                    return null;
                }
            }, new BNWorkerConfig(2, 0), 6000);
            return;
        }
        handleOffScreenMsg(2);
    }

    public void handleOffScreenMsg(int type) {
        if (type == 1) {
            if (canEnterOffScreenState()) {
                enterOffScreenState();
            }
        } else if (type == 2) {
            handleExitOffScreen();
        }
    }

    public void handleOffScreenInterupt(boolean isStart) {
        if (sIsModelueActive && sIsInOffScreenMode) {
            Activity activity = BNaviModuleManager.getNaviActivity();
            if (isStart) {
                BNPowerSaver.setBrightness(activity, (int) (BNOffScreenParams.OFF_INTERUPT_BRIGHTNESS * 255.0f));
            } else if (sIsInOffScreenMode) {
                BNPowerSaver.setBrightness(activity, (int) (BNOffScreenParams.OFF_MIN_BRIGHTNESS * 255.0f));
            }
        }
    }

    public static void testPrint(String moduleName, String str) {
    }

    private static String makeLogDetailInfoString(String moduleName, String str, StackTraceElement ste) {
        return ("[" + moduleName + "]-" + ste.getFileName() + "(" + ste.getLineNumber() + "): ") + str;
    }

    public static void test() {
        LogUtil.m15791e(MODULE_NAME, "start test");
    }

    public static void printCallStatck() {
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            testPrint("printCallStatck", "----start----");
            for (int i = 0; i < stackElements.length; i++) {
                testPrint("printCallStatck", "at " + stackElements[i].getClassName() + "." + stackElements[i].getMethodName() + "(" + stackElements[i].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackElements[i].getLineNumber() + ")\n");
            }
            testPrint("printCallStatck", "----end----");
        }
    }

    public static String getCallStack() {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                sb.append("at " + stackElements[i].getClassName() + "." + stackElements[i].getMethodName() + "(" + stackElements[i].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackElements[i].getLineNumber() + ")\n");
            }
        }
        return sb.toString();
    }
}
