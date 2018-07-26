package com.baidu.navisdk;

public class BNaviSDKManager {
    private static BNaviSDKManager instance = new BNaviSDKManager();

    private BNaviSDKManager() {
    }

    public static BNaviSDKManager getInstance() {
        if (instance == null) {
            instance = new BNaviSDKManager();
        }
        return instance;
    }

    public void SDKNavigatorInit() {
    }
}
