package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundCornerImageView extends ImageView {
    public RoundCornerImageView(Context context) {
        super(context);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        clipPath.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), 20.0f, 20.0f, Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
