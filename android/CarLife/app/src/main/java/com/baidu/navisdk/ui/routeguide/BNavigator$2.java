package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.ugc.control.UgcFeedbackController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$2 implements Runnable {
    final /* synthetic */ BNavigator this$0;

    BNavigator$2(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void run() {
        try {
            RGViewController.getInstance().hideAllViews();
            RGViewController.destory();
        } catch (Exception e) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "dispose hideAllViews crash:" + e.getMessage());
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("dispose-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    LogUtil.m15791e(TAG, "dispose hideAllViews main");
                    RGViewController.getInstance().hideAllViews();
                    RGViewController.destory();
                    return null;
                }
            }, new BNWorkerConfig(2, 0));
        }
        NMapControlProxy.destory();
        RouteGuideFSM.destory();
        BNavConfig.clear();
        BNavigator.access$300(this.this$0);
        UgcFeedbackController.getInstance().uninitUgcFeedbakController();
    }
}
