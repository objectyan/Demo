package com.baidu.navisdk.vi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.navisdk.util.common.LogUtil;

class VDeviceAPI$2 extends BroadcastReceiver {
    VDeviceAPI$2() {
    }

    public void onReceive(Context context, Intent intent) {
        LogUtil.m15791e("VDeviceAPI in java", "network changed.");
        try {
            VDeviceAPI.onNetworkStateChanged();
        } catch (Throwable th) {
        }
    }
}
