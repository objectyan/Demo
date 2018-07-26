package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$3 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$3(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        if (!RGParkPointModel.getInstance().getDoneWithParkSearch()) {
            BNavigator.access$402(this.this$0, true);
            BNavigator.access$500(this.this$0);
        }
        return null;
    }
}
