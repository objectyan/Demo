package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.p031j.C0578p;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;

public class MzPushPatchMessageReceiver extends MzPushMessageReceiver {
    public void onMessage(Context context, String str) {
    }

    public void onNotificationArrived(Context context, String str, String str2, String str3) {
    }

    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        try {
            Intent intent = new Intent("com.meizu.mzpush.PUSH_MSG");
            intent.putExtra("mz_notification_title", str);
            intent.putExtra("mz_notification_content", str2);
            intent.putExtra("mz_notification_self_define_content", str3);
            intent.putExtra("mz_push_msg_type", 3);
            C0578p.m2529a(intent, context.getApplicationContext());
        } catch (Exception e) {
        }
    }

    public void onNotificationDeleted(Context context, String str, String str2, String str3) {
    }

    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
    }

    public void onRegister(Context context, String str) {
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        if (registerStatus != null) {
            try {
                String pushId = registerStatus.getPushId();
                Intent intent = new Intent("com.meizu.mzpush.REGISTER");
                intent.putExtra("mz_pushid", pushId);
                intent.putExtra("mz_register_errorcode", registerStatus.getCode());
                C0578p.m2529a(intent, context.getApplicationContext());
            } catch (Exception e) {
            }
        }
    }

    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    public void onUnRegister(Context context, boolean z) {
    }

    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
    }
}
