package com.baidu.navisdk.ui.routeguide;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;

class BNavigator$9 extends BroadcastReceiver {
    final /* synthetic */ BNavigator this$0;

    BNavigator$9(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (RouteGuideParams.ACTION_QUITNAVI.equals(intent.getAction())) {
            this.this$0.quitNav(false);
        }
    }
}
