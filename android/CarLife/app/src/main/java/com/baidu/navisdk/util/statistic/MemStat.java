package com.baidu.navisdk.util.statistic;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.BusinessActivityManager;

public class MemStat {
    ActivityManager mActivityMan;
    int[] mPid;

    private static class LazyHolder {
        private static MemStat sInstance = new MemStat();

        private LazyHolder() {
        }
    }

    public static MemStat getInstance() {
        return LazyHolder.sInstance;
    }

    private MemStat() {
        this.mPid = new int[]{Process.myPid()};
        if (BNaviModuleManager.getContext() != null) {
            this.mActivityMan = (ActivityManager) BNaviModuleManager.getContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        }
    }

    public int getProfileVal() {
        if (this.mActivityMan == null && BNaviModuleManager.getContext() != null) {
            this.mPid = new int[]{Process.myPid()};
            this.mActivityMan = (ActivityManager) BNaviModuleManager.getContext().getSystemService(BusinessActivityManager.AUDIO_DIR);
        }
        if (this.mActivityMan == null) {
            return 0;
        }
        try {
            MemoryInfo mMeminfo = this.mActivityMan.getProcessMemoryInfo(this.mPid)[0];
            if (mMeminfo == null) {
                return 0;
            }
            return mMeminfo.getTotalPss();
        } catch (Exception e) {
            return 0;
        }
    }
}
