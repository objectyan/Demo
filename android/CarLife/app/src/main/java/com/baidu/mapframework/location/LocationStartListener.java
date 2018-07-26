package com.baidu.mapframework.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.location.C3377f;
import com.baidu.mapframework.common.config.GlobalConfig;

public class LocationStartListener extends BroadcastReceiver {
    public void onReceive(Context ctx, Intent intent) {
        if (GlobalConfig.getInstance().isReceivePush()) {
            ctx.getApplicationContext().startService(new Intent(ctx, C3377f.class));
        }
    }
}
