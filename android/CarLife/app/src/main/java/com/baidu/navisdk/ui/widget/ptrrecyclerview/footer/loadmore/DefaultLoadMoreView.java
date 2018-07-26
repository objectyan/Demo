package com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class DefaultLoadMoreView extends BaseLoadMoreView {
    private int mCircleOffset = 70;
    private int mCircleSize = 25;
    private int mProgress = 30;
    private RectF oval = new RectF();
    private Paint paint = new Paint();

    public DefaultLoadMoreView(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
        setLoadmoreString("加载中...");
    }

    public void onDrawLoadMore(Canvas c, RecyclerView parent) {
        super.onDrawLoadMore(c, parent);
        this.mProgress += 5;
        if (this.mProgress == 100) {
            this.mProgress = 0;
        }
        int left = parent.getPaddingLeft();
        int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        View child = parent.getChildAt(parent.getChildCount() - 1);
        int bottom = (child.getBottom() + ((LayoutParams) child.getLayoutParams()).bottomMargin) + (getLoadMorePadding() / 2);
        this.paint.setAntiAlias(true);
        this.paint.setFlags(1);
        this.paint.setColor(-7829368);
        this.paint.setStrokeWidth(10.0f);
        this.paint.setStyle(Style.STROKE);
        c.drawCircle((float) (((right - left) / 2) - this.mCircleOffset), (float) bottom, (float) this.mCircleSize, this.paint);
        this.paint.setColor(-16711936);
        this.oval.set((float) ((((right - left) / 2) - this.mCircleOffset) - this.mCircleSize), (float) (bottom - this.mCircleSize), (float) ((((right - left) / 2) - this.mCircleOffset) + this.mCircleSize), (float) (this.mCircleSize + bottom));
        c.drawArc(this.oval, -90.0f, 360.0f * (((float) this.mProgress) / 100.0f), false, this.paint);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setFlags(1);
        this.paint.setStrokeWidth(3.0f);
        this.paint.setTextSize(40.0f);
        this.paint.setColor(-16777216);
        c.drawText(getLoadmoreString(), (float) ((right - left) / 2), (float) (bottom + 10), this.paint);
    }
}
