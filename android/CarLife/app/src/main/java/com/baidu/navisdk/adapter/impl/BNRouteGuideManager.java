package com.baidu.navisdk.adapter.impl;

public final class BNRouteGuideManager {

    public interface OnNavigationListener {
        void notifyOtherAction(int i, int i2, int i3, Object obj);

        void onNaviGuideEnd();
    }
}
