package com.baidu.mapframework.commonlib.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ProcessUtil {
    /* renamed from: a */
    private static volatile int f12686a = 0;

    public static synchronized boolean isMainProcess(Context context) {
        boolean z = true;
        synchronized (ProcessUtil.class) {
            if (f12686a == 0) {
                f12686a = getProcessName(context, Process.myPid()).equals(context.getPackageName()) ? 1 : -1;
            }
            if (f12686a <= 0) {
                z = false;
            }
        }
        return z;
    }

    public static String getProcessName(Context context, int pid) {
        try {
            for (RunningAppProcessInfo info : ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses()) {
                if (info.pid == pid) {
                    return info.processName;
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static int[] getPids(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
        try {
            LinkedList<Integer> cachePids = new LinkedList();
            for (RunningAppProcessInfo info : runningAppProcesses) {
                if (info.uid == Process.myUid()) {
                    cachePids.add(Integer.valueOf(info.pid));
                }
            }
            int[] pids = new int[cachePids.size()];
            int len = pids.length;
            for (int i = 0; i < len; i++) {
                pids[i] = ((Integer) cachePids.get(i)).intValue();
            }
            return pids;
        } catch (Exception e) {
            return new int[0];
        }
    }

    public static HashMap<Integer, String> getPidsByPackageName(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses();
        try {
            HashMap<Integer, String> hashMap = new HashMap();
            for (RunningAppProcessInfo info : runningAppProcesses) {
                if (info.processName.contains(context.getPackageName())) {
                    hashMap.put(Integer.valueOf(info.pid), info.processName);
                }
            }
            return hashMap;
        } catch (Exception e) {
            return new HashMap();
        }
    }
}
