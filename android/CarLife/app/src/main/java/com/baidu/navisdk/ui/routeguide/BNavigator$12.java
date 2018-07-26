package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM.IFSMDestStateListener;

class BNavigator$12 implements IFSMDestStateListener {
    final /* synthetic */ BNavigator this$0;

    BNavigator$12(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onDestState(String destState) {
        if (FsmState.Fullview.equals(destState)) {
            if (BNavigator.access$1000(this.this$0) != null) {
                BNavigator.access$1000(this.this$0).notifyViewModeChanged(2);
            }
        } else if (BNavigator.access$1000(this.this$0) != null) {
            BNavigator.access$1000(this.this$0).notifyViewModeChanged(1);
        }
    }
}
