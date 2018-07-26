package com.baidu.navisdk.ui.widget.ptrrecyclerview.header;

import android.support.v7.widget.RecyclerView.ItemDecoration;

public class BaseHeader extends ItemDecoration {
    protected int mHeaderHeight;

    public void setHeight(int height) {
        this.mHeaderHeight = height;
    }

    public int getHeight() {
        return this.mHeaderHeight;
    }
}
