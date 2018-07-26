package com.baidu.navisdk.ui.routeguide.mapmode;

import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;

class RGMapModeViewController$19 implements OnNaviClickListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$19(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onClick() {
        try {
            if (RGMapModeViewController.access$300(this.this$0) != null && RGMapModeViewController.access$300(this.this$0).isShowing() && RGMapModeViewController.access$000(this.this$0) != null && !RGMapModeViewController.access$000(this.this$0).isFinishing()) {
                RGMapModeViewController.access$300(this.this$0).dismiss();
            }
        } catch (Exception e) {
        }
    }
}
