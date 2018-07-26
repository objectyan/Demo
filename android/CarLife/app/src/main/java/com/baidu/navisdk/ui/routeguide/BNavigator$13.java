package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$13 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$13(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        RGViewController.getInstance().hideEnlargeRoadMapWithoutAnimation();
        RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
        if (RGHighwayModel.getInstance().isExists()) {
            RGViewController.getInstance().showHighwayView();
            RGViewController.getInstance().hideRGSimpleGuideView();
        } else {
            RGViewController.getInstance().showRGSimpleGuideView();
            RGViewController.getInstance().hideHighwayView();
        }
        RGViewController.getInstance().showDeviceStateView();
        RGViewController.getInstance().updateMainAuxiliaryBridgeViewByLastType();
        RGViewController.getInstance().showScaleLevelView();
        return null;
    }
}
