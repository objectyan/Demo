package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$21 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$21(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_FULL_VIEW);
        return null;
    }
}
