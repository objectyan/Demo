package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$4 extends BNWorkerNormalTask<String, String> {
    BNavigator$4(String taskName, String pInData) {
        super(taskName, pInData);
    }

    protected String execute() {
        RGMapModeViewController.getInstance().miniRequestRender(false);
        BNWorkerCenter.getInstance().cancelTask(BNavigator.access$600(), false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(BNavigator.access$600(), new BNWorkerConfig(2, 0), 1000);
        return null;
    }
}
