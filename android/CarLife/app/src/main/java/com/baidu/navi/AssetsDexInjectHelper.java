package com.baidu.navi;

import android.app.Activity;
import android.app.Application;

public class AssetsDexInjectHelper {
    private static final String WALK_NAV_CLASS = "com.baidu.walknavi.WNavigator";
    private volatile boolean injected;
    private boolean isWalkNavigatorInject = false;

    public static AssetsDexInjectHelper getInstance() {
        return AssetsDexInjectHelper$AssetDexInjectHelperHolder.instance;
    }

    public synchronized void inject(Application context, Activity activity) {
        if (!this.injected) {
            this.injected = true;
        }
    }

    public synchronized boolean isWalkNavigatorInject() {
        boolean z = true;
        synchronized (this) {
            if (!this.isWalkNavigatorInject) {
                try {
                    Class.forName(WALK_NAV_CLASS);
                    this.isWalkNavigatorInject = true;
                } catch (Exception e) {
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized boolean isNaviInjectSuccess() {
        return true;
    }

    public void waitInject() {
    }
}
