package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$15 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$15(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        Bundle totalInfoBundle = RGSimpleGuideModel.getInstance().getTotalInfo();
        int totalDist = RGEngineControl.getInstance().getTotalDistance();
        int totalTime = RGEngineControl.getInstance().getTotalTime();
        if (totalInfoBundle != null && totalInfoBundle.containsKey(SimpleGuideInfo.TotalDist)) {
            totalDist = totalInfoBundle.getInt(SimpleGuideInfo.TotalDist);
        }
        if (totalInfoBundle != null && totalInfoBundle.containsKey(SimpleGuideInfo.TotalTime)) {
            totalTime = totalInfoBundle.getInt(SimpleGuideInfo.TotalTime);
        }
        RGViewController.getInstance().updateSimpleGuideInfo(RGSimpleGuideModel.getInstance().updateTotalRemainDistAndTime(totalDist, totalTime));
        RGViewController.getInstance().updateTotalRemainInfo();
        BNWorkerCenter.getInstance().cancelTask(BNavigator.access$1500(this.this$0), false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(BNavigator.access$1500(this.this$0), new BNWorkerConfig(2, 0), 60000);
        return null;
    }
}
