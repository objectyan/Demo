package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class OnSizeChangedRelativeLayout extends RelativeLayout {
    private OnSizeChangedListener listener;

    public interface OnSizeChangedListener {
        void OnSizeChanged(int i, int i2, int i3, int i4);
    }

    public OnSizeChangedRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OnSizeChangedRelativeLayout(Context context) {
        super(context);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.listener != null) {
            this.listener.OnSizeChanged(w, h, oldw, oldh);
        }
    }

    public OnSizeChangedListener getListener() {
        return this.listener;
    }

    public void setListener(OnSizeChangedListener listener) {
        this.listener = listener;
    }
}
