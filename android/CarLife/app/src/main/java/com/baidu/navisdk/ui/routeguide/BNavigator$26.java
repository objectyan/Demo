package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$26 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$26(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_mock_gps_open));
        return null;
    }
}
