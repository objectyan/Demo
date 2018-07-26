package com.baidu.navisdk.ui.routeguide;

import android.location.GpsStatus.NmeaListener;

class BNavigator$10 implements NmeaListener {
    final /* synthetic */ BNavigator this$0;

    BNavigator$10(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onNmeaReceived(long timestamp, String nmeadata) {
        if (BNavigator.access$1000(this.this$0) != null) {
            BNavigator.access$1000(this.this$0).notifyNmeaData(nmeadata);
        }
    }
}
