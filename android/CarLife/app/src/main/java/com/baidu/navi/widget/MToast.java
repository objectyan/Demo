package com.baidu.navi.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.util.C2201w;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.util.List;

public class MToast {
    public static void show(Context context, String message) {
        if (context != null && !TextUtils.isEmpty(message)) {
            List<RunningTaskInfo> infos = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningTasks(1);
            if (infos != null && infos.get(0) != null && context.getPackageName().equals(((RunningTaskInfo) infos.get(0)).baseActivity.getPackageName())) {
                int duration = 0;
                if (message.length() > 15) {
                    duration = 1;
                }
                C2201w.a(message, duration);
            }
        }
    }

    public static void show(Context context, int resId) {
        if (context != null) {
            show(context, context.getString(resId));
        }
    }
}
