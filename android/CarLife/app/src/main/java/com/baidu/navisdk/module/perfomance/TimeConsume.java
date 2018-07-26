package com.baidu.navisdk.module.perfomance;

import android.util.Log;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import java.util.HashMap;
import java.util.Map;

public class TimeConsume {
    public static final boolean OPEN = true;
    public static final String TAG = "time_consume";
    public static final String TARGET_NAVING = "tc_naving";
    public static final String TARGET_NAVI_INIT = "tc_navi_init";
    public static final String TARGET_NAVI_MAP_RENDER = "navi_map_render";
    public static Map<String, Long> sBaseTime = null;
    public static Map<String, Integer> sSumTime = null;

    public static void dot(String target, String step, boolean isStartPoint) {
        if (!BNSettingManager.isShowJavaLog() || target == null || target.length() == 0 || !init()) {
            return;
        }
        if (isStartPoint) {
            sBaseTime.put(target, Long.valueOf(System.currentTimeMillis()));
            sSumTime.put(target, Integer.valueOf(0));
            SDKDebugFileUtil.get(target).add("耗时：0, 累积耗时：0, 基准时间：" + sBaseTime.get(target) + ", " + step);
            Log.e(TAG, target + ", 耗时：" + 0 + ", 累积耗时：" + 0 + ", 基准时间：" + sBaseTime.get(target) + ", " + step);
            return;
        }
        if (!sBaseTime.containsKey(target)) {
            sBaseTime.put(target, Long.valueOf(System.currentTimeMillis()));
            sSumTime.put(target, Integer.valueOf(0));
        }
        int oldSum = ((Integer) sSumTime.get(target)).intValue();
        int sum = (int) (System.currentTimeMillis() - ((Long) sBaseTime.get(target)).longValue());
        sSumTime.put(target, Integer.valueOf(sum));
        SDKDebugFileUtil.get(target).add("耗时：" + (sum - oldSum) + ", 累积耗时：" + sum + ", 基准时间：" + sBaseTime.get(target) + ", " + step);
        Log.e(TAG, target + ", 耗时：" + (sum - oldSum) + ", 累积耗时：" + sum + ", 基准时间：" + sBaseTime.get(target) + ", " + step);
    }

    public static void dotEng(String target, String step, boolean isStartPoint) {
        if (!BNSettingManager.isShowJavaLog() || target == null || target.length() == 0 || !init()) {
            return;
        }
        if (isStartPoint) {
            sBaseTime.put(target, Long.valueOf(System.currentTimeMillis()));
            sSumTime.put(target, Integer.valueOf(0));
            SDKDebugFileUtil.get(target).add("TimeConsume: 0, TotalTimeConsume: 0, BaseTime: " + sBaseTime.get(target) + ", " + step);
            Log.e(TAG, target + ", TimeConsume: " + 0 + ", TotalTimeConsume: " + 0 + ", BaseTime: " + sBaseTime.get(target) + ", " + step);
            return;
        }
        if (!sBaseTime.containsKey(target)) {
            sBaseTime.put(target, Long.valueOf(System.currentTimeMillis()));
            sSumTime.put(target, Integer.valueOf(0));
        }
        int oldSum = ((Integer) sSumTime.get(target)).intValue();
        int sum = (int) (System.currentTimeMillis() - ((Long) sBaseTime.get(target)).longValue());
        sSumTime.put(target, Integer.valueOf(sum));
        SDKDebugFileUtil.get(target).add("TimeConsume: " + (sum - oldSum) + ", TotalTimeConsume: " + sum + ", BaseTime: " + sBaseTime.get(target) + ", " + step);
        Log.e(TAG, target + ", TimeConsume: " + (sum - oldSum) + ", TotalTimeConsume: " + sum + ", BaseTime: " + sBaseTime.get(target) + ", " + step);
    }

    public static void dotTmp(String target, String step, boolean isStartPoint) {
        if (target != null && target.length() != 0 && init()) {
            if (isStartPoint) {
                sBaseTime.put(target, Long.valueOf(System.currentTimeMillis()));
                sSumTime.put(target, Integer.valueOf(0));
                Log.e(TAG, target + ", 耗时：" + 0 + ", 累积耗时：" + 0 + ", 基准时间：" + sBaseTime.get(target) + ", " + step);
                return;
            }
            if (!sBaseTime.containsKey(target)) {
                sBaseTime.put(target, Long.valueOf(System.currentTimeMillis()));
                sSumTime.put(target, Integer.valueOf(0));
            }
            int oldSum = ((Integer) sSumTime.get(target)).intValue();
            int sum = (int) (System.currentTimeMillis() - ((Long) sBaseTime.get(target)).longValue());
            sSumTime.put(target, Integer.valueOf(sum));
            Log.e(TAG, target + ", 耗时：" + (sum - oldSum) + ", 累积耗时：" + sum + ", 基准时间：" + sBaseTime.get(target) + ", " + step);
        }
    }

    private static boolean init() {
        if (sBaseTime == null || sSumTime == null) {
            sBaseTime = new HashMap();
            sSumTime = new HashMap();
        }
        return true;
    }
}
