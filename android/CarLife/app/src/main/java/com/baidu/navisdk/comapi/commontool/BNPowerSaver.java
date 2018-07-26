package com.baidu.navisdk.comapi.commontool;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class BNPowerSaver extends BNSubject {
    private static final int CHECK_BATTERY_INTERVAL = 60000;
    public static final int SAVE_MODE_BATTERY_LEVEL = 35;
    private static final String TAG = "PowerSaver";
    public static final int TYPE_START_POWER_SAVE_MODE = 1;
    public static final int TYPE_STOP_POWER_SAVE_MODE = 2;
    private boolean isSettingsWriteAuth;
    private Activity mActivity;
    private int mBatteryLevel;
    private BatteryReceiver mBatteryReceiver;
    private Handler mHandler;
    private boolean mIsAutoBrightnessBeforeInSaveMode;
    private boolean mIsBatteryCharging;
    private boolean mIsInit;
    private boolean mIsPowerSaveMode;
    private int mMode;
    private BNWorkerNormalTask mOnBatteryChangedTask;

    private class BatteryReceiver extends BroadcastReceiver {
        private BatteryReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int current = intent.getExtras().getInt("level");
                int total = intent.getExtras().getInt("scale", 100);
                if (100 == total || total == 0) {
                    BNPowerSaver.this.mBatteryLevel = current;
                } else {
                    BNPowerSaver.this.mBatteryLevel = (current * 100) / total;
                }
                if (2 == intent.getIntExtra("status", 1)) {
                    BNPowerSaver.this.mIsBatteryCharging = true;
                    BNOffScreenManager.getInstance().onChargedAction();
                } else {
                    BNPowerSaver.this.mIsBatteryCharging = false;
                    if (BNOffScreenManager.sIsModelueActive) {
                        LogUtil.m15791e(BNOffScreenManager.MODULE_NAME, "late battery check");
                        BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "late battery check");
                        if (BNOffScreenManager.getInstance().canEnterOffScreenState()) {
                            if (BNOffScreenManager.getInstance().isOffScreenDelaying) {
                                BNOffScreenManager.getInstance().isOffScreenDelaying = false;
                                return;
                            } else if (!BNOffScreenManager.getInstance().isInCheckingTime) {
                                BNOffScreenManager.getInstance().enterOffScreenState();
                            }
                        }
                    }
                }
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("BatteryReceiver-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        BCruiser.getInstance().setBatteryStatus(BNPowerSaver.this.mBatteryLevel, BNPowerSaver.this.mIsBatteryCharging);
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
                LogUtil.m15791e(BNPowerSaver.TAG, "recv BATTERY_CHANGED: level " + current + ", charging " + BNPowerSaver.this.mIsBatteryCharging);
            }
        }
    }

    private static class LazyHolder {
        private static BNPowerSaver sInstance = new BNPowerSaver();

        private LazyHolder() {
        }
    }

    public int getmBatteryLevel() {
        return this.mBatteryLevel;
    }

    public boolean ismIsBatteryCharging() {
        return this.mIsBatteryCharging;
    }

    public boolean isSettingsWriteAuth() {
        return this.isSettingsWriteAuth;
    }

    public void setSettingsWriteAuth(boolean isSettingsWriteAuth) {
        this.isSettingsWriteAuth = isSettingsWriteAuth;
    }

    public static BNPowerSaver getInstance() {
        return LazyHolder.sInstance;
    }

    private BNPowerSaver() {
        this.mIsInit = false;
        this.mBatteryLevel = 0;
        this.isSettingsWriteAuth = true;
        this.mIsBatteryCharging = false;
        this.mIsPowerSaveMode = false;
        this.mIsAutoBrightnessBeforeInSaveMode = false;
        this.mMode = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
            }
        };
        this.mOnBatteryChangedTask = new BNWorkerNormalTask<String, String>("mOnBatteryChangedTask", null) {
            protected String execute() {
                BNPowerSaver.this.unregisterBatteryReceiver();
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("OnBatteryChangedTask-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        BNPowerSaver.this.registerBatteryReceiver();
                        return null;
                    }
                }, new BNWorkerConfig(100, 0), 60000);
                if (BNPowerSaver.this.mMode == 0) {
                    if (BNPowerSaver.this.mIsPowerSaveMode) {
                        if (BNPowerSaver.this.mBatteryLevel >= 35 || BNPowerSaver.this.mIsBatteryCharging) {
                            try {
                                BNPowerSaver.this.stopSaveMode();
                            } catch (Throwable th) {
                            }
                        }
                    } else if (BNPowerSaver.this.mBatteryLevel < 35 && !BNPowerSaver.this.mIsBatteryCharging) {
                        try {
                            BNPowerSaver.this.startSaveMode();
                        } catch (Throwable th2) {
                        }
                        if (BNOffScreenManager.sIsModelueActive) {
                            if (BNOffScreenManager.getInstance().canEnterOffScreenState()) {
                                if (BNOffScreenManager.getInstance().isOffScreenDelaying) {
                                    BNOffScreenManager.getInstance().isOffScreenDelaying = false;
                                } else if (!BNOffScreenManager.getInstance().isInCheckingTime) {
                                    BNOffScreenManager.getInstance().enterOffScreenState();
                                }
                            } else if (BNOffScreenManager.sIsInNavi) {
                                TipTool.onCreateToastDialog(BNPowerSaver.this.mActivity, BNStyleManager.getString(C4048R.string.off_screen_low_battery));
                            }
                        } else if (BNSettingManager.getVoiceMode() != 2) {
                            TipTool.onCreateToastDialog(BNPowerSaver.this.mActivity, BNStyleManager.getString(C4048R.string.nsdk_string_rg_start_power_save_mode));
                        }
                    }
                } else if (BNPowerSaver.this.mMode == 1) {
                }
                return null;
            }
        };
    }

    public void init(Activity activity) {
        if (!this.mIsInit && activity != null) {
            this.mActivity = activity;
            this.mMode = BNSettingManager.getPowerSaveMode();
            this.mIsInit = true;
            updatePowerSaveMode(this.mMode);
        }
    }

    public void uninit() {
        if (this.mIsInit) {
            unregisterBatteryReceiver();
            this.mHandler.removeCallbacksAndMessages(null);
            this.mIsInit = false;
            try {
                stopSaveMode();
            } catch (Throwable th) {
            }
            this.mActivity = null;
        }
    }

    public void updatePowerSaveMode(int mode) {
        this.mMode = mode;
        if (this.mIsInit) {
            registerBatteryReceiver();
            if (mode != 0) {
                if (mode == 1) {
                    this.mHandler.removeCallbacksAndMessages(null);
                    try {
                        startSaveMode();
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
                this.mHandler.removeCallbacksAndMessages(null);
                try {
                    stopSaveMode();
                } catch (Throwable th2) {
                }
            }
        }
    }

    private synchronized void registerBatteryReceiver() {
        if (this.mActivity != null && this.mBatteryReceiver == null) {
            LogUtil.m15791e(TAG, "registerBatteryReceiver");
            IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            this.mBatteryReceiver = new BatteryReceiver();
            try {
                this.mActivity.registerReceiver(this.mBatteryReceiver, filter);
            } catch (Exception e) {
            }
        }
    }

    private synchronized void unregisterBatteryReceiver() {
        if (!(this.mActivity == null || this.mBatteryReceiver == null)) {
            LogUtil.m15791e(TAG, "unregisterBatteryReceiver");
            try {
                this.mActivity.unregisterReceiver(this.mBatteryReceiver);
            } catch (Exception e) {
            }
            this.mBatteryReceiver = null;
        }
    }

    private void startSaveMode() {
        LogUtil.m15791e(TAG, "startSaveMode: isPowerSaveMode " + this.mIsPowerSaveMode);
        if (!this.mIsPowerSaveMode) {
            this.mIsPowerSaveMode = true;
            BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "startSaveMode");
            notifyObservers(1, this.mBatteryLevel, null);
            BNMapController.getInstance().setAnimationGlobalSwitch(false);
            this.mIsAutoBrightnessBeforeInSaveMode = isAutoBrightness(this.mActivity);
            if (!this.mIsAutoBrightnessBeforeInSaveMode) {
                BNaviModuleManager.mapToNaviSaveMode(this.mActivity, 1);
            }
        }
    }

    private void stopSaveMode() {
        LogUtil.m15791e(TAG, "stopSaveMode: isPowerSaveMode " + this.mIsPowerSaveMode);
        if (this.mIsPowerSaveMode) {
            this.mIsPowerSaveMode = false;
            notifyObservers(2, this.mBatteryLevel, null);
            BNMapController.getInstance().setAnimationGlobalSwitch(true);
            if (!this.mIsAutoBrightnessBeforeInSaveMode) {
                BNaviModuleManager.mapToNaviSaveMode(this.mActivity, 0);
            }
        }
    }

    public static boolean isAutoBrightness(Context context) {
        if (context != null) {
            try {
                if (System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1) {
                    return true;
                }
                return false;
            } catch (SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int getBrightness(Context context) {
        if (context != null) {
            try {
                return System.getInt(context.getContentResolver(), "screen_brightness");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void setBrightness(Activity activity, int brightness) {
        if (activity != null) {
            LayoutParams lp = activity.getWindow().getAttributes();
            lp.screenBrightness = Float.valueOf((float) brightness).floatValue() * 0.003921569f;
            activity.getWindow().setAttributes(lp);
        }
    }

    public static void saveBrightness(Context context, int brightness) {
        if (context != null) {
            ContentResolver resolver = context.getContentResolver();
            Uri uri = System.getUriFor("screen_brightness");
            try {
                System.putInt(resolver, "screen_brightness", brightness);
            } catch (Exception e) {
            }
            resolver.notifyChange(uri, null);
        }
    }
}
