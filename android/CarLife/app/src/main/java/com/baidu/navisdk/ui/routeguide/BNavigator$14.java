package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class BNavigator$14 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$14(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        if (BNSettingManager.isShowJavaLog()) {
            TipTool.onCreateToastDialog(BNavigator.access$1100(this.this$0), "提示：丢星超过60秒 重新添加系统Gps监听");
        }
        this.this$0.mReAddGpsLocation = true;
        this.this$0.removeGpsLocation();
        this.this$0.addGpsLocation();
        return null;
    }
}
