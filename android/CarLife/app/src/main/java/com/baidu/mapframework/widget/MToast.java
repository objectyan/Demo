package com.baidu.mapframework.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mapframework.nirvana.looper.LooperManager;
import com.baidu.mapframework.nirvana.looper.LooperTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.util.C4835n;
import java.util.List;

public class MToast {
    /* renamed from: a */
    private static int f19344a;

    public static void show(int strId) {
        show(C2907c.f().getResources().getString(strId));
    }

    public static void show(String message) {
        show(C2907c.f(), message);
    }

    public static void show(final Context context, final String message) {
        if (context != null && !TextUtils.isEmpty(message)) {
            f19344a = 0;
            if (message.length() > 15) {
                f19344a = 1;
            }
            if (VERSION.SDK_INT < 21) {
                List<RunningTaskInfo> infos = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningTasks(1);
                if (infos != null && infos.size() > 0 && infos.get(0) != null && context.getPackageName().equals(((RunningTaskInfo) infos.get(0)).baseActivity.getPackageName())) {
                    LooperManager.executeTask(Module.COMMON_WIDGET_MODULE, new LooperTask() {
                        public void run() {
                            if (context != null) {
                                Toast.makeText(context, message, MToast.f19344a).show();
                            }
                        }
                    }, ScheduleConfig.forData());
                    return;
                }
                return;
            }
            LooperManager.executeTask(Module.COMMON_WIDGET_MODULE, new LooperTask() {
                public void run() {
                    Toast.makeText(context, message, MToast.f19344a).show();
                }
            }, ScheduleConfig.forData());
        }
    }

    public static void show(final Context context, final int resId) {
        if (context != null) {
            C4835n.m16033a(new Runnable() {
                public void run() {
                    MToast.show(context, context.getString(resId));
                }
            });
        }
    }
}
