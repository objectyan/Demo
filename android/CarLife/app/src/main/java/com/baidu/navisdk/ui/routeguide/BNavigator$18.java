package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$18 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$18(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        if (BNavigator.access$1000(this.this$0) != null) {
            try {
                BNavigator.access$1000(this.this$0).onPageJump(2, null);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
