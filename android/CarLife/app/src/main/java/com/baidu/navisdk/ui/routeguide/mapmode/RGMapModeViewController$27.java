package com.baidu.navisdk.ui.routeguide.mapmode;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class RGMapModeViewController$27 implements OnLayoutChangeListener {
    final /* synthetic */ RGMapModeViewController this$0;

    RGMapModeViewController$27(RGMapModeViewController this$0) {
        this.this$0 = this$0;
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (v != RGMapModeViewController.access$500(this.this$0) || left != 0 || left != 0 || right != 0 || bottom != 0) {
            int w = right - left;
            int h = bottom - top;
            int maxH = Math.max(w, h);
            int minW = Math.min(w, h);
            if (minW != 0 && maxH != 0) {
                if (minW != RGMapModeViewController.access$600(this.this$0) || RGMapModeViewController.access$700(this.this$0) != maxH) {
                    RGMapModeViewController.access$602(this.this$0, minW);
                    RGMapModeViewController.access$702(this.this$0, maxH);
                    RGMapModeViewController.access$800(this.this$0);
                }
            }
        }
    }
}
