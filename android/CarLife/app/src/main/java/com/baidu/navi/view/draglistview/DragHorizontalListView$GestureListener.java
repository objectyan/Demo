package com.baidu.navi.view.draglistview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.baidu.navi.view.draglistview.DragHorizontalListView$OnScrollStateChangedListener.ScrollState;

class DragHorizontalListView$GestureListener extends SimpleOnGestureListener {
    final /* synthetic */ DragHorizontalListView this$0;

    private DragHorizontalListView$GestureListener(DragHorizontalListView dragHorizontalListView) {
        this.this$0 = dragHorizontalListView;
    }

    public boolean onDown(MotionEvent e) {
        return this.this$0.onDown(e);
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return this.this$0.onFling(e1, e2, velocityX, velocityY);
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        DragHorizontalListView.access$600(this.this$0, Boolean.valueOf(true));
        DragHorizontalListView.access$700(this.this$0, ScrollState.SCROLL_STATE_TOUCH_SCROLL);
        DragHorizontalListView.access$400(this.this$0);
        DragHorizontalListView dragHorizontalListView = this.this$0;
        dragHorizontalListView.mNextX += (int) distanceX;
        DragHorizontalListView.access$800(this.this$0, Math.round(distanceX));
        this.this$0.requestLayout();
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent e) {
        DragHorizontalListView.access$400(this.this$0);
        OnItemClickListener onItemClickListener = this.this$0.getOnItemClickListener();
        int index = DragHorizontalListView.access$900(this.this$0, (int) e.getX(), (int) e.getY());
        if (index >= 0 && !DragHorizontalListView.access$1000(this.this$0)) {
            View child = this.this$0.getChildAt(index);
            int adapterIndex = DragHorizontalListView.access$1100(this.this$0) + index;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.this$0, child, adapterIndex, this.this$0.mAdapter.getItemId(adapterIndex));
                return true;
            }
        }
        if (!(DragHorizontalListView.access$1200(this.this$0) == null || DragHorizontalListView.access$1000(this.this$0))) {
            DragHorizontalListView.access$1200(this.this$0).onClick(this.this$0);
        }
        return false;
    }

    public void onLongPress(MotionEvent e) {
        DragHorizontalListView.access$400(this.this$0);
        int index = DragHorizontalListView.access$900(this.this$0, (int) e.getX(), (int) e.getY());
        DragHorizontalListView.access$1300(this.this$0, e);
        if (index >= 0 && !DragHorizontalListView.access$1000(this.this$0)) {
            View child = this.this$0.getChildAt(index);
            OnItemLongClickListener onItemLongClickListener = this.this$0.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int adapterIndex = DragHorizontalListView.access$1100(this.this$0) + index;
                if (onItemLongClickListener.onItemLongClick(this.this$0, child, adapterIndex, this.this$0.mAdapter.getItemId(adapterIndex))) {
                    this.this$0.performHapticFeedback(0);
                }
            }
        }
    }
}
