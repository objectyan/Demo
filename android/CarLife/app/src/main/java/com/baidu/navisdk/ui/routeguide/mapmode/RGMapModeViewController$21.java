package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonConstant;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;

class RGMapModeViewController$21 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$21(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        BNaviModuleManager.requstPermission(NaviCommonConstant.OVERLAY_PERMISSION);
    }
}
