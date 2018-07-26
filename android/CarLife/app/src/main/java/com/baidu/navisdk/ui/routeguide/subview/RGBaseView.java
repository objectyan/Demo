package com.baidu.navisdk.ui.routeguide.subview;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

public abstract class RGBaseView {
    protected Context mContext;
    protected ViewGroup mRootViewGroup;
    protected OnRGSubViewListener mSubViewListener;
    private boolean mVisibility;

    public abstract void destory();

    public abstract void updateData(Bundle bundle);

    public void show() {
        this.mVisibility = true;
        onShow();
    }

    public void hide() {
        this.mVisibility = false;
        onHide();
    }

    public boolean isVisibility() {
        return this.mVisibility;
    }

    protected void onShow() {
    }

    protected void onHide() {
    }
}
