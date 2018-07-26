package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$5 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$5(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        if (BNavigator.access$700(this.this$0)) {
            BNavigator.access$800(this.this$0);
            Bundle bundle = new Bundle();
            bundle.putBoolean("not_set_mapstate", BNavigator.hasShowEnterAnim);
            RouteGuideFSM.getInstance().runInitialState(bundle);
        }
        return null;
    }
}
