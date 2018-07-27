package com.baidu.carlife.wechat.p105a.p107b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.io.File;
import java.util.List;

/* compiled from: CommonUtils */
/* renamed from: com.baidu.carlife.wechat.a.b.a */
public class C2369a {
    /* renamed from: a */
    public static boolean m9012a(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m9011a(Runnable r) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r);
        }
    }

    /* renamed from: a */
    public static File m9010a(Context context) {
        return context.getExternalCacheDir();
    }

    /* renamed from: b */
    public static boolean m9013b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        String packageName = context.getPackageName();
        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName) && appProcess.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
