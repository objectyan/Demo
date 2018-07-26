package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.ugc.control.UgcFeedbackController.UgcFeedbackCallback;

class BNavigator$38 implements UgcFeedbackCallback {
    final /* synthetic */ BNavigator this$0;

    BNavigator$38(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onDataRequireFinish() {
        if (!RGViewController.getInstance().isUGCFBackMenuVisible()) {
        }
    }
}
