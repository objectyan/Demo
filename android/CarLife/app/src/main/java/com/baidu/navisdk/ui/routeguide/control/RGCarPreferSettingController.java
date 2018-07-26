package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.LogUtil;

public class RGCarPreferSettingController {
    private static final String TAG = RGCarPreferSettingController.class.getSimpleName();
    private static RGCarPreferSettingController sInstance = null;
    public static boolean sIsSupportNoHighway = true;
    private static Object sObj = new Object();
    public boolean mIsSelectPlate = false;
    public int mLastRPPreferSetting = -1;

    public static RGCarPreferSettingController getInstance() {
        if (sInstance == null) {
            synchronized (sObj) {
                if (sInstance == null) {
                    sInstance = new RGCarPreferSettingController();
                }
            }
        }
        return sInstance;
    }

    public void reset() {
        this.mIsSelectPlate = false;
        this.mLastRPPreferSetting = -1;
    }

    public void setLastRPPreferSettingValue(int value) {
        this.mLastRPPreferSetting = value;
    }

    public boolean isRPPreferSettingValueChange(int RPPreferValue) {
        if (this.mLastRPPreferSetting == -1 || this.mLastRPPreferSetting == RPPreferValue) {
            return false;
        }
        return true;
    }

    public int calcPreferenceValue(int lastPreferValue, int changePrefer, boolean isPreferOpen) {
        if (!isPreferOpen && (lastPreferValue & changePrefer) == 0) {
            return lastPreferValue;
        }
        int value;
        if (lastPreferValue == 1) {
            value = 0;
        } else if (lastPreferValue == 33) {
            value = 32;
        } else {
            value = lastPreferValue;
        }
        if (isPreferOpen) {
            value |= changePrefer;
        } else {
            value ^= changePrefer;
        }
        if (value == 32) {
            value = 33;
        }
        if (value == 0) {
            value = 1;
        }
        return value;
    }

    public void updatePreferValue(int changePrefer, boolean isPreferOpen) {
        int lastPreferValue = BNaviModuleManager.getLastPreferValue();
        int updatedPreferValue = calcPreferenceValue(lastPreferValue, changePrefer, isPreferOpen);
        BNaviModuleManager.setLastPreferValue(updatedPreferValue);
        RGRouteSortController.getInstance().setPreferValue(updatedPreferValue);
        BNRoutePlaner.getInstance().setCalcPrference(updatedPreferValue);
        LogUtil.m15791e(TAG, "updatePreferValue lastPreferValue = " + lastPreferValue + ", updatedPreferValue = " + updatedPreferValue + ", changePrefer = " + changePrefer + ", isPreferOpen = " + isPreferOpen);
    }

    public boolean isOpenPrefer(int preferValue) {
        return (BNaviModuleManager.getLastPreferValue() & preferValue) != 0;
    }

    public boolean isCarLimitOpen() {
        return isOpenPrefer(32);
    }

    public void setCarLimitOpen(boolean open) {
        BNaviModuleManager.resetPlateLimitCounter(open);
        updatePreferValue(32, open);
    }
}
