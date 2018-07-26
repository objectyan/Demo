package com.baidu.navisdk.util.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

class AudioUtils$3 extends BroadcastReceiver {
    final /* synthetic */ AudioUtils this$0;
    final /* synthetic */ int val$fromType;

    AudioUtils$3(AudioUtils this$0, int i) {
        this.this$0 = this$0;
        this.val$fromType = i;
    }

    public void onReceive(Context cx, Intent intent) {
        AudioManager audioManager = AudioUtils.access$100(this.this$0);
        Context context = AudioUtils.access$200(this.this$0);
        if (audioManager == null || context == null) {
            AudioUtils.access$300(this.this$0);
            return;
        }
        int state = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        LogUtil.m15791e(AudioUtils.TAG, "openSCO onReceive state = " + state);
        if (1 == state) {
            audioManager.setBluetoothScoOn(true);
            this.this$0.setSCOConnect(true);
            context.unregisterReceiver(this);
            AudioUtils.access$400(this.this$0, this.val$fromType);
        }
    }
}
