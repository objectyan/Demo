package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.p031j.C0578p;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

public class PushPatchMessageReceiver extends PushMessageReceiver {
    public static final int MSG_ARRIVED = 2;
    public static final int MSG_CLICKED = 3;
    public static final int MSG_PASS = 1;
    public static final String PUSH_MSG = "xm_push_msg";
    public static final String PUSH_MSG_TYPE = "xm_push_msg_type";
    public static final String REGID = "xm_regid";
    public static final String REGISTER_ERRORCODE = "xm_register_errorcode";
    private static final String TAG = "PushPatchMessageReceiver";
    public static final String XIAOMI_PUSH_MSG = "com.xiaomi.mipush.PUSH_MSG";
    public static final String XIAOMI_REGISTER = "com.xiaomi.mipush.REGISTER";

    private void handleXiaomiMsg(Context context, MiPushMessage miPushMessage, int i) {
        try {
            Intent intent = new Intent(XIAOMI_PUSH_MSG);
            intent.putExtra(PUSH_MSG, miPushMessage);
            intent.putExtra(PUSH_MSG_TYPE, i);
            C0578p.m2529a(intent, context.getApplicationContext());
        } catch (Exception e) {
        }
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 2);
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageClicked(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 3);
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
        handleXiaomiMsg(context, miPushMessage, 1);
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        if (miPushCommandMessage != null) {
            try {
                String command = miPushCommandMessage.getCommand();
                List commandArguments = miPushCommandMessage.getCommandArguments();
                String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
                if ("register".equals(command)) {
                    Intent intent = new Intent(XIAOMI_REGISTER);
                    intent.putExtra(REGID, str);
                    intent.putExtra(REGISTER_ERRORCODE, miPushCommandMessage.getResultCode());
                    C0578p.m2529a(intent, context.getApplicationContext());
                }
            } catch (Exception e) {
            }
        }
    }
}
