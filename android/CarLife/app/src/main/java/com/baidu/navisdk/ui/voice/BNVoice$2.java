package com.baidu.navisdk.ui.voice;

import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus;
import com.baidu.navisdk.ui.voice.view.VoiceBaseView;
import com.baidu.navisdk.ui.voice.view.VoiceMainView;
import com.baidu.navisdk.ui.voice.view.VoiceSquareView;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNVoice$2 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNVoice this$0;
    final /* synthetic */ boolean val$result;
    final /* synthetic */ String val$taskId;

    BNVoice$2(BNVoice this$0, String taskName, String pInData, boolean z, String str) {
        this.this$0 = this$0;
        this.val$result = z;
        this.val$taskId = str;
        super(taskName, pInData);
    }

    protected String execute() {
        VoiceBaseView mainView = (VoiceBaseView) BNVoice.access$100(this.this$0).get(Integer.valueOf(1));
        VoiceBaseView squareView = (VoiceBaseView) BNVoice.access$100(this.this$0).get(Integer.valueOf(5));
        if (mainView == null && squareView == null) {
            VoiceDownloadStatus.getInstance().handleSwitchVoiceData(this.val$result, this.val$taskId);
        } else {
            if (mainView != null && (mainView instanceof VoiceMainView)) {
                ((VoiceMainView) mainView).handleSwitchVoiceData(this.val$result, this.val$taskId);
            }
            if (squareView != null && (squareView instanceof VoiceSquareView)) {
                ((VoiceSquareView) squareView).handleSwitchVoiceData(this.val$result, this.val$taskId);
            }
            BNVoice.access$200(this.this$0, this.val$result, this.val$taskId);
        }
        return null;
    }
}
