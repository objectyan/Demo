package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$34 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$34(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        this.this$0.enterNavState();
        return null;
    }
}
