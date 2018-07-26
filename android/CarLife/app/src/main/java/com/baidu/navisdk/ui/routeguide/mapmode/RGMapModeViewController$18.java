package com.baidu.navisdk.ui.routeguide.mapmode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RGMapModeViewController$18 extends Handler {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$18(RGMapModeViewController this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 10702:
                this.this$0.hideMenuMoreView();
                this.this$0.hideRouteSearchView();
                return;
            default:
                return;
        }
    }
}
