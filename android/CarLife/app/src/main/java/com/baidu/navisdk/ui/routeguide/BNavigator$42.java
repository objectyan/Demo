package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$42 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$42(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        LogUtil.m15791e(TAG, "mInitResultViewRunnalbe");
        BNNaviResultController.getInstance().preloadResultView(BNaviModuleManager.getActivity());
        return null;
    }
}
