package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;

class RGMapModeViewController$3 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$3(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        BNRoutePlaner.getInstance().showReCalRouteProgressDialog();
    }
}
