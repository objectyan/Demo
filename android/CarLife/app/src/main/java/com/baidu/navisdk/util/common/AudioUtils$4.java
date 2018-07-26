package com.baidu.navisdk.util.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class AudioUtils$4 extends BroadcastReceiver {
    final /* synthetic */ AudioUtils this$0;
    final /* synthetic */ int val$fromType;

    AudioUtils$4(AudioUtils this$0, int i) {
        this.this$0 = this$0;
        this.val$fromType = i;
    }

    public void onReceive(Context cx, Intent intent) {
        AudioManager audioManager = AudioUtils.access$100(this.this$0);
        Context context = AudioUtils.access$200(this.this$0);
        if (audioManager != null && context != null) {
            int state = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            LogUtil.m15791e(AudioUtils.TAG, "closeSCO onReceive state = " + state);
            if (state == 0 || !audioManager.isBluetoothScoOn()) {
                audioManager.setBluetoothScoOn(false);
                this.this$0.setSCOConnect(false);
                context.unregisterReceiver(this);
                AudioUtils.access$500(this.this$0, this.val$fromType);
            }
        }
    }
}
