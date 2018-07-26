package com.baidu.navi.view.draglistview;

import android.database.DataSetObserver;

class DragHorizontalListView$2 extends DataSetObserver {
    final /* synthetic */ DragHorizontalListView this$0;

    DragHorizontalListView$2(DragHorizontalListView this$0) {
        this.this$0 = this$0;
    }

    public void onChanged() {
        DragHorizontalListView.access$202(this.this$0, true);
        DragHorizontalListView.access$302(this.this$0, false);
        DragHorizontalListView.access$400(this.this$0);
        this.this$0.invalidate();
        this.this$0.requestLayout();
    }

    public void onInvalidated() {
        DragHorizontalListView.access$302(this.this$0, false);
        DragHorizontalListView.access$400(this.this$0);
        DragHorizontalListView.access$500(this.this$0);
        this.this$0.invalidate();
        this.this$0.requestLayout();
    }
}
