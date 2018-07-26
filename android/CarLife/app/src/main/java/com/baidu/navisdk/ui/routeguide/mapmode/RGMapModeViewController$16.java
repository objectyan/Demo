package com.baidu.navisdk.ui.routeguide.mapmode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;

class RGMapModeViewController$16 implements OnCancelListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$16(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onCancel(DialogInterface dialog) {
        BNLightNaviSwitchManager.getInstance().cancleRoutePlan();
        this.this$0.dismissSwitchProgressDialog();
    }
}
