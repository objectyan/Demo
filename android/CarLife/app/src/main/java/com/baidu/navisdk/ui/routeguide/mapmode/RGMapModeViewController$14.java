package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class RGMapModeViewController$14 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$14(RGMapModeViewController this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        BNavigator.getInstance().enterNavState();
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            RGViewController.getInstance().hidePickPointView();
            if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1) {
                BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                BNMapController.getInstance().updateLayer(4);
                RGRouteSearchModel.getInstance().resetLastBkgItemId();
            }
            RGMapModeViewController.access$102(this.this$0, true);
        }
        return null;
    }
}
