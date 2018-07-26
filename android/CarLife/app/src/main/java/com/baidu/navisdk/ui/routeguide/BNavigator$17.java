package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDUtils;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$17 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;
    final /* synthetic */ String val$voiceTips;

    BNavigator$17(BNavigator this$0, String taskName, String pInData, String str) {
        this.this$0 = this$0;
        this.val$voiceTips = str;
        super(taskName, pInData);
    }

    protected String execute() {
        if (RGRouteRecommendModel.getInstance().isViewCanShow) {
            if (XDUtils.isAsrCanWork()) {
                XDVoiceInstructManager.getInstance().askRouteRecommend(this.val$voiceTips);
            } else {
                TTSPlayerControl.playXDTTSText(this.val$voiceTips, 1);
            }
        }
        return null;
    }
}
