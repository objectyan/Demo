package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonConstant;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.widget.BNImageTextDialog.OnNaviClickListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

class RGMapModeViewController$7 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$7(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_7, "2", null, null);
        BNSettingManager.setPrefFloatSwitch(true);
        if (BNaviModuleManager.hasPermission(NaviCommonConstant.OVERLAY_PERMISSION)) {
            RGNotificationController.getInstance().showFloatWindowSuccess();
        } else {
            this.this$0.showOpenOverlyPermissonDialog();
        }
    }
}
