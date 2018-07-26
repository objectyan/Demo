package com.baidu.navisdk.ui.voice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class BNVoice$1 extends Handler {
    final /* synthetic */ BNVoice this$0;

    BNVoice$1(BNVoice this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        BNVoice.getInstance().handleVoiceMessage(msg.what, msg.arg1, msg.obj);
    }
}
