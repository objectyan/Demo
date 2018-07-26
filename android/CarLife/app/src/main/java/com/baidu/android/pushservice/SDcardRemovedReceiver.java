package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.p025d.C0463a;

public class SDcardRemovedReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static String f1351a = "SDRev";

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_BAD_REMOVAL") || intent.getAction().equals("android.intent.action.MEDIA_REMOVED")) {
            C0463a.m1999a();
        }
    }
}
