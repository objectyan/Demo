package com.baidu.navi.view.draglistview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class DragHorizontalListView$1 implements OnTouchListener {
    final /* synthetic */ DragHorizontalListView this$0;

    DragHorizontalListView$1(DragHorizontalListView this$0) {
        this.this$0 = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        return DragHorizontalListView.access$100(this.this$0).onTouchEvent(event);
    }
}
