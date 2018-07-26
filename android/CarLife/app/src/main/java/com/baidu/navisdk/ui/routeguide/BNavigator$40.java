package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$40 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$40(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        RGViewController.getInstance().hideWaitCalLoading();
        RGViewController.getInstance().initFirstRGInfo();
        XDVoiceInstructManager.getInstance().setXDPlan(RGMapModeViewController.getInstance().getOrientation(), 0);
        return null;
    }
}
