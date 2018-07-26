package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$32 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$32(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        BNavigator.access$4200(this.this$0, BNavigator.access$4100(this.this$0));
        this.this$0.autoHideParkPoint(HttpsClient.CONN_MGR_TIMEOUT);
        return null;
    }
}
