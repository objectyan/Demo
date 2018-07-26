package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.task.TaskRunnable;

class BNavigator$6 extends TaskRunnable<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$6(BNavigator this$0, String taskName, String pInData, int type) {
        this.this$0 = this$0;
        super(taskName, pInData, type);
    }

    public void doTask() {
        if (this.this$0.isNaviBegin()) {
            boolean isReady;
            if (TextUtils.isEmpty(BNavConfig.pRGMrsl)) {
                isReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
                LogUtil.m15791e(TAG, "initFirstRGInfoTask judgeRouteInfo isReady:" + isReady);
            } else {
                isReady = JNIGuidanceControl.getInstance().isBuildRouteReady(false, BNavConfig.pRGMrsl);
            }
            if (isReady && !RGSimpleGuideModel.getInstance().isFirstDataOk) {
                Bundle bundle = new Bundle();
                JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                LogUtil.m15791e(TAG, "isFirstDataOk --> getFirstRouteGuideInfo bundle = " + bundle.toString());
                RGSimpleGuideModel.getInstance().setFirstRGInfo(bundle);
                RGViewController.getInstance().initFirstRGInfo();
            }
            if (BNSettingManager.getFirstRCStyleGuide()) {
                BNSettingManager.setFirstRCStyleGuide(false);
                return;
            }
            return;
        }
        LogUtil.m15791e(TAG, "initFirstRGInfoTask return navi end");
    }
}
