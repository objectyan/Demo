package com.baidu.platform.comapi.map;

import android.util.Log;
import com.baidu.mobstat.Config;

public final class MapTrace {
    static boolean enableTrace = false;

    public static void enable(boolean enable) {
        enableTrace = enable;
    }

    static void trace(String tag, String msg) {
        if (enableTrace) {
            Log.d("MapTrace-" + tag, "thread:" + Thread.currentThread().getName() + Config.TRACE_TODAY_VISIT_SPLIT + Thread.currentThread().getId() + "," + msg);
        }
    }
}
