package com.baidu.navisdk.ui.routeguide;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.util.listener.NetworkListener;

class BNavigator$36 extends Handler {
    final /* synthetic */ BNavigator this$0;

    BNavigator$36(BNavigator this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        if (msg.what != NetworkListener.MSG_TYPE_NET_WORK_CHANGE) {
            return;
        }
        if (1 == msg.arg2) {
            BNavigator.access$4400(this.this$0, 3);
        } else {
            BNavigator.access$4400(this.this$0, 1);
        }
    }
}
