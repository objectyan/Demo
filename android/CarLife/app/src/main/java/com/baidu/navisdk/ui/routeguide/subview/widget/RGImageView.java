package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RGImageView extends ImageView {
    public RGImageView(Context context) {
        super(context);
    }

    public RGImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RGImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
        }
    }
}
