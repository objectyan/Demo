package com.baidu.navisdk.ui.util;

public class ForbidDaulClickUtils {
    private static long DAUL_CLICK_INTERVAL = 800;
    private static long mLastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        if (0 < timeD && timeD < DAUL_CLICK_INTERVAL) {
            return true;
        }
        mLastClickTime = time;
        return false;
    }

    public boolean isFastDoubleClickNonStatic() {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        if (0 < timeD && timeD < DAUL_CLICK_INTERVAL) {
            return true;
        }
        mLastClickTime = time;
        return false;
    }

    public static boolean isFastDoubleClick(long clickInterval) {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        if (0 < timeD && timeD < clickInterval) {
            return true;
        }
        mLastClickTime = time;
        return false;
    }

    public static void resetLastDoubleClickTime() {
        mLastClickTime = -1;
    }
}
