package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.vi.VMsgDispatcher;

class BNavigator$19 extends MsgHandler {
    final /* synthetic */ BNavigator this$0;

    BNavigator$19(BNavigator this$0, Looper looper) {
        this.this$0 = this$0;
        super(looper);
    }

    public void careAbout() {
        observe(4099);
    }

    public void handleMessage(Message msg) {
        if (msg.what == 4099) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRouteGuideUiHandler MSG_NAVI_ROUTE_PLAN_RESULT:" + BNavigator.hasReallyStartedNav);
            if (!(msg.arg1 != 0 || BNavigator.hasReallyStartedNav || RGSimpleGuideModel.getInstance().isFirstDataOk)) {
                Bundle bundle = new Bundle();
                JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                RGSimpleGuideModel.getInstance().setFirstRGInfo(bundle);
                RGViewController.getInstance().initFirstRGInfo();
            }
            VMsgDispatcher.unregisterMsgHandler(BNavigator.access$1600(this.this$0));
        }
    }
}
