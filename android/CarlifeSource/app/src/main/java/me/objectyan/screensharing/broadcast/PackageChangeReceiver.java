package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

public class PackageChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            Object packageName = intent.getDataString().substring(8);
            LogUtil.d("ouyang", "-----PACKAGE_ADDED----------" + packageName);
            MsgHandlerCenter.m4458a((int) CommonParams.gQ, (int) CommonParams.iw, packageName);
        }
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            packageName = intent.getDataString().substring(8);
            LogUtil.d("ouyang", "-----PACKAGE_REMOVED----------" + packageName);
            MsgHandlerCenter.m4458a((int) CommonParams.gQ, (int) CommonParams.ix, packageName);
        }
    }
}
