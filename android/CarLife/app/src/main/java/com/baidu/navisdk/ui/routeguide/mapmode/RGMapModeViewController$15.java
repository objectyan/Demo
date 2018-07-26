package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class RGMapModeViewController$15 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$15(RGMapModeViewController this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        if (RGMapModeViewController.access$200(this.this$0) != null) {
            RGMapModeViewController.access$200(this.this$0).onEmptyPoiAction();
            RGMapModeViewController.access$102(this.this$0, false);
        }
        return null;
    }
}
