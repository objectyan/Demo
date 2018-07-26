package com.baidu.navi.view.draglistview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(14)
final class DragHorizontalListView$IceCreamSandwichPlus {
    private DragHorizontalListView$IceCreamSandwichPlus() {
    }

    public static float getCurrVelocity(Scroller scroller) {
        if (VERSION.SDK_INT >= 14) {
            return scroller.getCurrVelocity();
        }
        return 0.0f;
    }
}
