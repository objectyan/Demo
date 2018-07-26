package com.baidu.navisdk.util.common;

public class RouteGuideThread extends CommonHandlerThread {
    private static final String TAG = RouteGuideThread.class.getSimpleName();
    private static RouteGuideThread sInstance = null;

    private RouteGuideThread() {
    }

    public static RouteGuideThread getInstance() {
        if (sInstance == null) {
            synchronized (RouteGuideThread.class) {
                if (sInstance == null) {
                    sInstance = new RouteGuideThread();
                }
            }
        }
        return sInstance;
    }
}
