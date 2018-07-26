package com.baidu.baidumaps.base.localmap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LMBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("com.baidu.BaiduMap.ON_LM_NOTIFICATION_FINISHED")) {
            m2850a(context);
        }
    }

    /* renamed from: a */
    private void m2850a(Context context) {
        C0669b.m2851a(context).m2861b();
    }
}
