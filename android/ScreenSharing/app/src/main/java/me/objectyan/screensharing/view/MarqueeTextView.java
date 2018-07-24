package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {
    /* renamed from: a */
    private boolean f7191a;

    public MarqueeTextView(Context context) {
        this(context, null);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7191a = true;
    }

    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    public void onWindowFocusChanged(boolean focused) {
        super.onWindowFocusChanged(focused);
    }

    public boolean isFocused() {
        return this.f7191a;
    }

    public void setIsFocused(boolean bool) {
        this.f7191a = bool;
    }
}
