package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$16 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;
    final /* synthetic */ String val$voiceTips;

    BNavigator$16(BNavigator this$0, String taskName, String pInData, String str) {
        this.this$0 = this$0;
        this.val$voiceTips = str;
        super(taskName, pInData);
    }

    protected String execute() {
        TTSPlayerControl.playTTS(this.val$voiceTips, 0);
        return null;
    }
}
