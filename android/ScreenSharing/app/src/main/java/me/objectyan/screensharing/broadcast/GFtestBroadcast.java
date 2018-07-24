package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.p087l.C1663a;

public class GFtestBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        LogUtil.d("yftech", "BroadcastReceiver : " + intent.getAction());
        if (intent.getAction().equals("com.baidu.carlife.driving.start") && C1663a.m5979a().m5993N() && (C1342a.m4926a().m4929b() || C1343b.m4932a().m4935b())) {
            C1342a.m4926a().m4928a(true);
            FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().driving();
        }
        if (!intent.getAction().equals("com.baidu.carlife.driving.stop") || !C1663a.m5979a().m5993N()) {
            return;
        }
        if (C1342a.m4926a().m4929b() || C1343b.m4932a().m4935b()) {
            FragmentManagerCallbackProxy.m4757a().getNaviFragmentManager().stopDriving();
        }
    }
}
