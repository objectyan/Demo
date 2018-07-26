package com.baidu.navisdk.vi;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

class VDeviceAPI$1 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ String val$showtoast;

    VDeviceAPI$1(String taskName, String pInData, String str) {
        this.val$showtoast = str;
        super(taskName, pInData);
    }

    protected String execute() {
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), this.val$showtoast);
        return null;
    }
}
