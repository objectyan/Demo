package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.ui.widget.BNImageTextDialog.OnNaviClickListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

class RGMapModeViewController$6 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$6(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_7, "3", null, null);
    }
}
