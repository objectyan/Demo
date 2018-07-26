package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$41 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$41(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        RGViewController.getInstance().hideWaitCalLoading();
        this.this$0.startNavReally();
        return null;
    }
}
