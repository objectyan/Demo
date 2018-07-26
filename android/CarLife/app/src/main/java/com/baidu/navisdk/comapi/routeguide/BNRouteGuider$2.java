package com.baidu.navisdk.comapi.routeguide;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.ui.routeguide.BNavigator;

class BNRouteGuider$2 extends Handler {
    final /* synthetic */ BNRouteGuider this$0;

    BNRouteGuider$2(BNRouteGuider this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        if (msg.what == 0) {
            BNavigator.getInstance().addGpsLocation();
        } else if (msg.what == 1) {
            BNavigator.getInstance().removeGpsLocation();
        }
    }
}
