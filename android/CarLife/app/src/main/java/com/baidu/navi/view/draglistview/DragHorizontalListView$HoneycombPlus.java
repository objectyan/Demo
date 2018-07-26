package com.baidu.navi.view.draglistview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(11)
final class DragHorizontalListView$HoneycombPlus {
    private DragHorizontalListView$HoneycombPlus() {
    }

    public static void setFriction(Scroller scroller, float friction) {
        if (VERSION.SDK_INT >= 11 && scroller != null) {
            scroller.setFriction(friction);
        }
    }
}
