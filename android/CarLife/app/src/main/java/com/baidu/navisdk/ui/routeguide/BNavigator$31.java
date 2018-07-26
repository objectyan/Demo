package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$31 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$31(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        RGControlPanelModel.getInstance().setmIsParkSearching(false);
        RGViewController.getInstance().hideParkPointView();
        RGParkPointModel.getInstance().setmIsParkPointShow(false);
        BNMapController.getInstance().showLayer(4, false);
        BNMapController.getInstance().updateLayer(4);
        this.this$0.enterNavState();
        return null;
    }
}
