package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.PackageUtil;

public class XDUtils {
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

    public static boolean isInOnLineMode() {
        if (BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 1 || BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 3) {
            return true;
        }
        return false;
    }

    public static void makeParkingSpeak(String tips) {
        if (BNavigator.getInstance().isNaviBegin()) {
            TTSPlayerControl.playTTS(tips, 0);
        }
    }
}
