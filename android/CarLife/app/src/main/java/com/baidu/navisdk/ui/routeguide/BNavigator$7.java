package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.RouteGuideThread;
import com.baidu.navisdk.util.task.TaskRunnable;

class BNavigator$7 extends TaskRunnable<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$7(BNavigator this$0, String taskName, String pInData, int type) {
        this.this$0 = this$0;
        super(taskName, pInData, type);
    }

    public void doTask() {
        if (this.this$0.isNaviBegin()) {
            this.this$0.initOnMainThread();
            RouteGuideThread.getInstance().sendMessage(501);
            return;
        }
        LogUtil.m15791e(TAG, "initOtherTask return navi end");
    }
}
