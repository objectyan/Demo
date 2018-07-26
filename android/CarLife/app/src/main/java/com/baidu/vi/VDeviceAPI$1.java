package com.baidu.vi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class VDeviceAPI$1 extends BroadcastReceiver {
    VDeviceAPI$1() {
    }

    public void onReceive(Context context, Intent intent) {
        VDeviceAPI.onNetworkStateChanged();
    }
}
