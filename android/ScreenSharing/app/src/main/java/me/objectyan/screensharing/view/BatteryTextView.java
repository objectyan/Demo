package com.baidu.carlife.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.TextView;

public class BatteryTextView extends TextView {

    private class BatteryReceiver extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ BatteryTextView f7055a;

        private BatteryReceiver(BatteryTextView batteryTextView) {
            this.f7055a = batteryTextView;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int level = intent.getIntExtra("level", 0);
                this.f7055a.setText("电池电量为" + ((level * 100) / intent.getIntExtra("scale", 100)) + "%");
            }
        }
    }

    public BatteryTextView(Context context) {
        super(context);
        context.registerReceiver(new BatteryReceiver(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
