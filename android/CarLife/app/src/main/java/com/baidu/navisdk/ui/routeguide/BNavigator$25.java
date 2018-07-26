package com.baidu.navisdk.ui.routeguide;

import android.database.ContentObserver;
import android.os.Handler;

class BNavigator$25 extends ContentObserver {
    final /* synthetic */ BNavigator this$0;

    BNavigator$25(BNavigator this$0, Handler x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void onChange(boolean selfChange) {
        BNavigator.access$2300(this.this$0, true);
    }
}
