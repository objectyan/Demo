package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;

public class PackageChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            Object packageName = intent.getDataString().substring(8);
            C1260i.m4435b("ouyang", "-----PACKAGE_ADDED----------" + packageName);
            C1261k.m4458a((int) C1253f.gQ, (int) C1253f.iw, packageName);
        }
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            packageName = intent.getDataString().substring(8);
            C1260i.m4435b("ouyang", "-----PACKAGE_REMOVED----------" + packageName);
            C1261k.m4458a((int) C1253f.gQ, (int) C1253f.ix, packageName);
        }
    }
}
