package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.util.common.LogUtil;

public class RGOffScreenModel {
    public static final int MAX_COUNT = 5;
    public static final int MSG_CANCEL_COUNT = 3;
    public static final int MSG_STOP_COUNT = 2;
    public static final int MSG_TIME_COUNT = 1;
    private static RGOffScreenModel mInstance;
    public static int sCurrentMsgType = -1;
    public boolean isCurrentLocationActive = false;
    public boolean isInCounting = false;
    public int mOffScreenCount = 5;

    public static RGOffScreenModel getInstance() {
        if (mInstance == null) {
            mInstance = new RGOffScreenModel();
        }
        return mInstance;
    }

    public boolean canEnterOffScreenShow() {
        boolean z = true;
        if (!BNOffScreenManager.sIsModelueActive) {
            return false;
        }
        boolean ret2;
        boolean ret0 = BNOffScreenManager.getInstance().canOffScreenShow();
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
        boolean ret5 = BNOffScreenManager.sIsBrightOffEffect;
        LogUtil.m15791e(BNOffScreenManager.MODULE_NAME, "ret 0 ,ret2, ret3, ret4 , ret5 is " + ret0 + ret2 + ", " + ret3 + "," + ret4 + "," + ret5);
        BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "ret 0,ret2, ret3, ret4 , ret5 is " + ret0 + ret2 + ", " + ret3 + "," + ret4 + "," + ret5);
        if (!(ret0 && ret2 && ret3 && !ret4 && ret5)) {
            z = false;
        }
        return z;
    }
}
