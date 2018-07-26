package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

public class SDCardListener extends BroadcastReceiver {
    public static final int MSG_SDCARD_BAD_REMOVAL = 3;
    public static final int MSG_SDCARD_EJECT = 4;
    public static final int MSG_SDCARD_MOUNTED = 1;
    public static final int MSG_SDCARD_REMOVED = 5;
    public static final int MSG_SDCARD_UNMOUNTED = 2;
    public static final int MSG_TYPE_SDCARD_CHANGE = 5565;
    private static final String TAG = "Common";
    private static final List<Handler> outboxHandlers = new ArrayList();

    public static void registerMessageHandler(Handler handler) {
        outboxHandlers.add(handler);
    }

    public static void unRegisterMessageHandler(Handler handler) {
        outboxHandlers.remove(handler);
    }

    private static void dispatchMessage(int what, int arg1, int arg2) {
        LogUtil.m15791e("Common", "dispatchMessage arg1=" + arg1 + "arg2=" + arg2);
        if (!outboxHandlers.isEmpty()) {
            for (Handler handler : outboxHandlers) {
                Message.obtain(handler, what, arg1, arg2, null).sendToTarget();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!"android.intent.action.MEDIA_MOUNTED".equals(action)) {
                if (!"android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
                    if (!"android.intent.action.MEDIA_BAD_REMOVAL".equals(action)) {
                        if (!"android.intent.action.MEDIA_EJECT".equals(action)) {
                            if (!"android.intent.action.MEDIA_REMOVED".equals(action)) {
                            }
                        }
                    }
                }
            }
        }
    }
}
