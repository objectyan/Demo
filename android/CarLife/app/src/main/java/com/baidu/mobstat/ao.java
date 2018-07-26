package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.util.List;

public enum ao {
    SERVICE(1),
    NO_SERVICE(2),
    RECEIVER(3),
    ERISED(4);
    
    /* renamed from: e */
    private int f19397e;

    /* renamed from: a */
    public abstract void mo2725a(Context context);

    private ao(int i) {
        this.f19397e = i;
    }

    public String toString() {
        return String.valueOf(this.f19397e);
    }

    /* renamed from: a */
    public static ao m15347a(int i) {
        for (ao aoVar : values()) {
            if (aoVar.f19397e == i) {
                return aoVar;
            }
        }
        return NO_SERVICE;
    }

    /* renamed from: b */
    public static boolean m15348b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
        if (activityManager != null) {
            try {
                List runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                int i = 0;
                while (runningServices != null && i < runningServices.size()) {
                    if ("com.baidu.bottom.service.BottomService".equals(((RunningServiceInfo) runningServices.get(i)).service.getClassName())) {
                        return true;
                    }
                    i++;
                }
            } catch (Throwable e) {
                db.m15659a(e);
            }
        }
        return false;
    }
}
