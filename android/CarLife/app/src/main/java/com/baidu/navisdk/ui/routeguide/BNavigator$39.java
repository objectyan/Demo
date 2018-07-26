package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.RouteGuideThread;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;

class BNavigator$39 extends Callback {
    final /* synthetic */ BNavigator this$0;

    BNavigator$39(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void careAbouts() {
        careAbout(501);
        careAbout(502);
    }

    public void execute(Message message) {
        switch (message.what) {
            case 501:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "INIT_VIEW START");
                int routeIdxBg = JNIGuidanceControl.getInstance().getSelectRouteIdx();
                if (BNavigator.access$4500(this.this$0) && JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(routeIdxBg)) {
                    BNavigator.hasShowEnterAnim = BNMapController.getInstance().showEnterNavAnim();
                }
                BNavigator.access$4600(this.this$0);
                if (JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(routeIdxBg)) {
                    RouteGuideThread.getInstance().removeMessage(502);
                    RouteGuideThread.getInstance().sendMessage(502);
                }
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "INIT_VIEW end");
                return;
            case 502:
                if (BNavigator.hasReallyStartedNav) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "REALLY_START hasReallyStartedNav");
                    return;
                }
                boolean isReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "REALLY_START judgeRouteInfoAllReady isReady:" + isReady);
                if (isReady) {
                    if (!BNavigator.hasShowEnterAnim && BNavigator.access$4500(this.this$0)) {
                        BNavigator.hasShowEnterAnim = BNMapController.getInstance().showEnterNavAnim();
                    }
                    BNavigator.hasReallyStartedNav = BNavigator.access$4700(this.this$0);
                    if (BNavigator.hasReallyStartedNav) {
                        if (BNavConfig.pRGLocateMode == 2) {
                            XDVoiceInstructManager.getInstance().setWakeupEnable(false);
                        } else {
                            XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                        }
                        if (!RGSimpleGuideModel.getInstance().isFirstDataOk) {
                            Bundle bundle = new Bundle();
                            JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                            RGSimpleGuideModel.getInstance().setFirstRGInfo(bundle);
                            BNWorkerCenter.getInstance().submitMainThreadTask(BNavigator.access$4800(this.this$0), new BNWorkerConfig(2, 0));
                        }
                        BNWorkerCenter.getInstance().submitMainThreadTask(BNavigator.access$4900(this.this$0), new BNWorkerConfig(2, 0));
                        return;
                    }
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "REALLY_START judgeRouteInfoAllReady startRouteGuide fail");
                    return;
                }
                return;
            default:
                return;
        }
    }

    public String getName() {
        return "Navi-SDK-Inpage-Init";
    }
}
