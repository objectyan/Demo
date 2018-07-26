package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView.LoadingCallback;

class RGMapModeViewController$26 implements LoadingCallback {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$26(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onQuitClick() {
        BNRoutePlaner.getInstance().CancelCurCalcRoute();
        this.this$0.hideRefreshRoadProgess();
    }
}
