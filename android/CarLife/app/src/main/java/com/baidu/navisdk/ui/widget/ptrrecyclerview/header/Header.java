package com.baidu.navisdk.ui.widget.ptrrecyclerview.header;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

public class Header extends BaseHeader {
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (itemPosition == 0) {
            outRect.set(0, this.mHeaderHeight, 0, 0);
        }
    }
}
