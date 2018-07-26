package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;

public abstract class RGSlightBaseView {
    protected Context mContext;
    protected Handler mHandler;
    protected ViewGroup mRootViewGroup;

    public RGSlightBaseView(Context c, ViewGroup p) {
        this.mContext = c;
        this.mRootViewGroup = p;
    }

    public RGSlightBaseView(Context c, ViewGroup p, Handler h) {
        this.mContext = c;
        this.mRootViewGroup = p;
        this.mHandler = h;
    }
}
