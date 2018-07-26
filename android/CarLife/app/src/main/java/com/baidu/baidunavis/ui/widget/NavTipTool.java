package com.baidu.baidunavis.ui.widget;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.widget.Toast;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.List;

public class NavTipTool {
    private static final int MAX_TOAST_TEXT_LENGTH = 20;
    static String mLastMessagePrefix;
    static long mLastTime;
    static Toast mToast = null;

    public static void onCreateDebugToast(Context context, String message) {
        if (NavLogUtils.LOGGABLE && message != null && message.length() >= 2) {
            long now = System.currentTimeMillis();
            String prefix = message.split(" ")[0];
            if (now - mLastTime >= BNOffScreenParams.MIN_ENTER_INTERVAL || mLastMessagePrefix == null || !mLastMessagePrefix.equals(prefix)) {
                mLastMessagePrefix = prefix;
                mLastTime = System.currentTimeMillis();
                onCreateToastDialog(context, message);
                return;
            }
            mLastTime = System.currentTimeMillis();
        }
    }

    public static void onCreateToastDialog(Context context, int resId) {
        try {
            String str = context.getString(resId);
            if (str != null && str.length() <= 20) {
                onCreateToastDialog(context, str);
            }
        } catch (Exception e) {
        }
    }

    public static void onCreateToastDialog(Context context, final String message) {
        if (context != null && message != null && message.length() <= 20) {
            final Context appContext = context.getApplicationContext();
            List<RunningAppProcessInfo> appProcesses = ((ActivityManager) appContext.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
            if (appProcesses != null) {
                for (RunningAppProcessInfo appProcess : appProcesses) {
                    if (appProcess.processName.equals(appContext.getPackageName()) && appProcess.importance == 100) {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("NavTipTool", null) {
                            protected String execute() {
                                try {
                                    if (NavTipTool.mToast != null) {
                                        NavTipTool.mToast.cancel();
                                    }
                                } catch (Exception e) {
                                }
                                int duration = 0;
                                try {
                                    if (message.length() > 15) {
                                        duration = 1;
                                    }
                                    NavTipTool.mToast = Toast.makeText(appContext, message, duration);
                                    NavTipTool.mToast.show();
                                } catch (Exception e2) {
                                }
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                        return;
                    }
                }
            }
        }
    }
}
