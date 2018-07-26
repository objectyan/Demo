package com.baidu.navisdk.util.listener;

import android.content.Context;
import android.os.PowerManager;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Method;

public class ScreenObserver {
    private static final String TAG = "ScreenObserver";
    private PowerManager mPowerManager;
    private Method mReflectScreenState;

    public ScreenObserver(Context context) {
        try {
            this.mReflectScreenState = PowerManager.class.getMethod("isScreenOn", new Class[0]);
            this.mPowerManager = (PowerManager) context.getSystemService("power");
        } catch (NoSuchMethodException e) {
            LogUtil.m15791e(TAG, "No such method " + e);
        }
    }

    public boolean isScreenOn() {
        if (this.mReflectScreenState == null) {
            return false;
        }
        try {
            return ((Boolean) this.mReflectScreenState.invoke(this.mPowerManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }
}
