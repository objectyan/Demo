package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGScreenStatusReceiver extends BroadcastReceiver {
    private static final String TAG = RGScreenStatusReceiver.class.getSimpleName();
    private static Context sContext;
    private static RGScreenStatusReceiver sInstance = new RGScreenStatusReceiver();
    private static boolean sLockScreenReceiverRegisted = false;

    public static void initScreenStatusReceiver(Context context) {
        if (context != null) {
            sContext = context;
            IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
            filter.addAction("android.intent.action.SCREEN_OFF");
            filter.addAction("android.intent.action.SCREEN_ON");
            filter.addAction("android.intent.action.USER_PRESENT");
            filter.setPriority(Integer.MAX_VALUE);
            try {
                sContext.registerReceiver(sInstance, filter);
                sLockScreenReceiverRegisted = true;
            } catch (Exception e) {
            }
        }
    }

    public static void uninitScreenStatusReceiver() {
        try {
            if (sContext != null && sLockScreenReceiverRegisted) {
                sLockScreenReceiverRegisted = false;
                sContext.unregisterReceiver(sInstance);
            }
            sContext = null;
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            LogUtil.m15791e(TAG, "onReceive ACTION_SCREEN_ON");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_2, "1", null, null);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            LogUtil.m15791e(TAG, "onReceive ACTION_SCREEN_OFF");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_2, "2", null, null);
        } else if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            LogUtil.m15791e(TAG, "onReceive ACTION_USER_PRESENT");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_2, "3", null, null);
        }
    }
}
