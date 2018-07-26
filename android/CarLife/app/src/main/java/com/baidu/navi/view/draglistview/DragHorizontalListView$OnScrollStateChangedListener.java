package com.baidu.navi.view.draglistview;

public interface DragHorizontalListView$OnScrollStateChangedListener {

    /* renamed from: com.baidu.navi.view.draglistview.DragHorizontalListView$OnScrollStateChangedListener$ScrollState */
    public enum ScrollState {
        SCROLL_STATE_IDLE,
        SCROLL_STATE_TOUCH_SCROLL,
        SCROLL_STATE_FLING
    }

    void onScrollStateChanged(ScrollState scrollState);
}
