package com.baidu.navisdk.ui.util;

public class ForbidDaulClickUtilsNonStatic {
    private long DAUL_CLICK_INTERVAL = 800;
    private long mLastClickTime;

    public boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - this.mLastClickTime;
        if (0 < timeD && timeD < this.DAUL_CLICK_INTERVAL) {
            return true;
        }
        this.mLastClickTime = time;
        return false;
    }
}
