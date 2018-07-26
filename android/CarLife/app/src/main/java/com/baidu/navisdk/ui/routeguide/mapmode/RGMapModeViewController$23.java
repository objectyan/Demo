package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView.LoadingCallback;

class RGMapModeViewController$23 implements LoadingCallback {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$23(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onQuitClick() {
        BusinessActivityManager.getInstance().isCancelShareSafe = true;
    }
}
