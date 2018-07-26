package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.ArrayList;
import java.util.List;

public class UsbListener extends BroadcastReceiver {
    public static final int MSG_TYPE_USB_CHANGE = 10501;
    private static final String TAG = "UsbListener";
    private static final String USB_STATE_ACTION = "android.hardware.usb.action.USB_STATE";
    public static boolean isUSBConnect = false;
    private static final List<Handler> outboxHandlers = new ArrayList();
    private static UsbListener sInstance = new UsbListener();

    public static void registerReceiver(Context context) {
        try {
            isUSBConnect = false;
            IntentFilter filter = new IntentFilter();
            filter.addAction(USB_STATE_ACTION);
            context.registerReceiver(sInstance, filter);
        } catch (Exception e) {
        }
    }

    public static void unregisterReceiver(Context context) {
        try {
            isUSBConnect = false;
            context.unregisterReceiver(sInstance);
        } catch (Exception e) {
        }
    }

    public static void registerMessageHandler(Handler handler) {
        if (handler != null && !outboxHandlers.contains(handler)) {
            outboxHandlers.add(handler);
        }
    }

    public static void unRegisterMessageHandler(Handler handler) {
        if (handler != null && outboxHandlers.contains(handler)) {
            outboxHandlers.remove(handler);
        }
    }

    private static void dispatchMessage(int what, int arg1, int arg2) {
        if (!outboxHandlers.isEmpty()) {
            for (Handler handler : outboxHandlers) {
                Message.obtain(handler, what, arg1, arg2, null).sendToTarget();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(USB_STATE_ACTION)) {
            int arg1;
            if (intent.getExtras().getBoolean("connected")) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_r_2);
                isUSBConnect = true;
                arg1 = 1;
                dispatchMessage(MSG_TYPE_USB_CHANGE, 1, 0);
            } else {
                isUSBConnect = false;
                arg1 = 0;
                dispatchMessage(MSG_TYPE_USB_CHANGE, 0, 0);
            }
            LogUtil.m15791e(TAG, "usb connect is changed arg1 " + arg1);
        }
    }
}
