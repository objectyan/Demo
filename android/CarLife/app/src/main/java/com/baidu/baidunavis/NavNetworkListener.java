package com.baidu.baidunavis;

import com.baidu.baidumaps.common.p039a.C0697b;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.platform.comapi.util.NetworkUtil;
import de.greenrobot.event.EventBus;

public class NavNetworkListener {
    public static final int NetStatusInvalid = 0;
    public static final int NetStatusNoNet = 1;
    public static final int NetStatusWIFINet = 2;
    public static final int NetStatusWWANNet = 3;
    private static NavNetworkListener mInstance = null;

    private NavNetworkListener() {
    }

    public static NavNetworkListener getInstance() {
        if (mInstance == null) {
            mInstance = new NavNetworkListener();
        }
        return mInstance;
    }

    private void performNetworkTypeChange(int networkType, boolean isConnected) {
        int i = 0;
        if (isConnected) {
            i = 1;
        }
        NetworkUtils.mConnectState = i;
        LogUtil.m3004e(ModuleName.MAP, "NetworkUtils.mConnectState=" + NetworkUtils.mConnectState);
        int status = 1;
        switch (networkType) {
            case 1:
                status = 2;
                NetworkUtils.mWifiState = 1;
                break;
        }
        final int toExeStatus = status;
        try {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("performNetworkTypeChange", null) {
                protected String execute() {
                    if (BaiduNaviManager.sIsBaseEngineInitialized) {
                        try {
                            BNaviEngineManager.getInstance().changeNaviStatisticsNetworkStatus(toExeStatus);
                        } catch (Throwable th) {
                        }
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        } catch (Throwable th) {
            LogUtil.m3004e("NavNetworkListener", "error!");
        }
    }

    public void registNetworkTypeChangeEvent() {
        int i = 1;
        EventBus.getDefault().register(this);
        try {
            if (!NetworkUtil.isNetworkAvailable(NavMapAdapter.getInstance().getBaiduMapApplicationInstance())) {
                i = 0;
            }
            NetworkUtils.mConnectState = i;
        } catch (Exception e) {
        }
    }

    public void unregistNetworkTypeChangeEvent() {
        EventBus.getDefault().unregister(this);
    }

    private void onEventMainThread(C0697b event) {
        performNetworkTypeChange(event.f2250a, event.f2251b);
    }
}
