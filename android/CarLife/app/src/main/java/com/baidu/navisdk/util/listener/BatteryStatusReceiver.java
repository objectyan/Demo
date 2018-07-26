package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.navisdk.util.common.LogUtil;

public class BatteryStatusReceiver extends BroadcastReceiver {
    private static final String TAG = "BatteryStatusReceiver";
    private static boolean isBatteryReceiverRegisted = false;
    public static boolean isCharging = false;
    public static int mBatteryLevel = 0;
    private static BatteryStatusReceiver sInstance = new BatteryStatusReceiver();

    private BatteryStatusReceiver() {
    }

    public static void initBatteryStatusReceiver(Context context) {
        if (context != null && !isBatteryReceiverRegisted) {
            IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            filter.setPriority(Integer.MAX_VALUE);
            try {
                context.registerReceiver(sInstance, filter);
                isBatteryReceiverRegisted = true;
            } catch (Exception e) {
            }
        }
    }

    public static void uninitBatteryStatusReceiver(Context context) {
        if (context != null && isBatteryReceiverRegisted) {
            isBatteryReceiverRegisted = false;
            try {
                context.unregisterReceiver(sInstance);
            } catch (Exception e) {
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        String action = intent.getAction();
        if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
            int current = intent.getExtras().getInt("level");
            int total = intent.getExtras().getInt("scale", 100);
            if (100 == total || total == 0) {
                mBatteryLevel = current;
            } else {
                mBatteryLevel = (current * 100) / total;
            }
            int status = intent.getIntExtra("status", 1);
            if (2 != status) {
                z = false;
            }
            isCharging = z;
            LogUtil.m15791e(TAG, "battery action:" + action + "status = " + status);
        }
    }
}
