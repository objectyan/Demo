package com.baidu.navisdk.ui.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.widget.Toast;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.List;

public class TipTool {
    private static final int MAX_TOAST_TEXT_LENGTH = 30;
    static String mLastMessagePrefix;
    static long mLastTime;
    static Toast mToast = null;
    static ToastInterface mToastinInterface;

    /* renamed from: com.baidu.navisdk.ui.util.TipTool$a */
    public class C4523a {
        int in;
    }

    public static void onCreateToastDialog(Context context, int resId) {
        try {
            String str = context.getString(resId);
            if (str != null && str.length() <= 30) {
                onCreateToastDialog(context, str);
            }
        } catch (Exception e) {
        }
    }

    public static void onCreateDebugToast(Context context, String message) {
        if (NavSDKDebug.sShowDebugToast && message != null && message.length() >= 2) {
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

    public static void onCreateToastDialog(Context context, final String message) {
        if (context != null && message != null && message.length() <= 30) {
            if (!DialogReplaceToastUtils.hasNotifiyAuth()) {
                int duration = 0;
                if (message.length() > 15) {
                    duration = 1;
                }
                if (mToastinInterface != null) {
                    mToastinInterface.showToast(message, duration);
                    return;
                }
            }
            final Context appContext = context.getApplicationContext();
            List<RunningAppProcessInfo> appProcesses = ((ActivityManager) appContext.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
            if (appProcesses != null) {
                for (RunningAppProcessInfo appProcess : appProcesses) {
                    if (appProcess.processName.equals(appContext.getPackageName())) {
                        if (appProcess.importance == 100) {
                            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("", null) {
                                protected String execute() {
                                    int duration = 0;
                                    try {
                                        if (message.length() > 15) {
                                            duration = 1;
                                        }
                                        if (TipTool.mToastinInterface != null) {
                                            TipTool.mToastinInterface.showToast(message, duration);
                                        } else {
                                            if (TipTool.mToast != null) {
                                                TipTool.mToast.cancel();
                                            }
                                            TipTool.mToast = Toast.makeText(appContext, message, duration);
                                            TipTool.mToast.show();
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new BNWorkerConfig(100, 0));
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public static ToastInterface getToastinInterface() {
        return mToastinInterface;
    }

    public static void setToastinInterface(ToastInterface toastinInterface) {
        mToastinInterface = toastinInterface;
    }
}
