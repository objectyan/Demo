package com.baidu.navisdk.ui.voice.view;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.util.common.LogUtil;

class VoiceDetailView$JavaScriptInterface {
    final /* synthetic */ VoiceDetailView this$0;

    VoiceDetailView$JavaScriptInterface(VoiceDetailView this$0) {
        this.this$0 = this$0;
    }

    @JavascriptInterface
    public void downloadVoiceData(String taskId) {
        LogUtil.e(BNVoiceParams.MODULE_TAG, "js downloadVoiceData taskId = " + taskId);
        if (this.this$0.mJumpListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString(BNVoiceParams.BUNDLE_VOICEINFO_TASKID, taskId);
            this.this$0.mJumpListener.onPageJump(4, 1, bundle);
        }
    }
}
