package com.baidu.navi.view.pulltorefresh.internal;

import com.baidu.navisdk.util.common.LogUtil;

public class Utils {
    static final String LOG_TAG = "PullToRefresh";

    public static void warnDeprecation(String depreacted, String replacement) {
        LogUtil.m15791e(LOG_TAG, "You're using the deprecated " + depreacted + " attr, please switch over to " + replacement);
    }
}
