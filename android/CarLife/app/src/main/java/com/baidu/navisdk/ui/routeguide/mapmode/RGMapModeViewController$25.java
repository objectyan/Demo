package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView.LoadingCallback;

class RGMapModeViewController$25 implements LoadingCallback {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$25(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onQuitClick() {
        RGRouteSearchModel.getInstance().isSearching = false;
    }
}
