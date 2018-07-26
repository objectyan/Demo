package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.util.common.LogUtil;

class BNavigator$33 implements Runnable {
    final /* synthetic */ BNavigator this$0;

    BNavigator$33(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void run() {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "loc_car");
        this.this$0.enterNavState();
    }
}
