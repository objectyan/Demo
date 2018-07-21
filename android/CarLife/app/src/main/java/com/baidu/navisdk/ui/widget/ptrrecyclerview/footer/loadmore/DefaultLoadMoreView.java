package com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class DefaultLoadMoreView
  extends BaseLoadMoreView
{
  private int mCircleOffset = 70;
  private int mCircleSize = 25;
  private int mProgress = 30;
  private RectF oval = new RectF();
  private Paint paint = new Paint();
  
  public DefaultLoadMoreView(Context paramContext, RecyclerView paramRecyclerView)
  {
    super(paramContext, paramRecyclerView);
    setLoadmoreString("加载中...");
  }
  
  public void onDrawLoadMore(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    super.onDrawLoadMore(paramCanvas, paramRecyclerView);
    this.mProgress += 5;
    if (this.mProgress == 100) {
      this.mProgress = 0;
    }
    int i = paramRecyclerView.getPaddingLeft();
    int j = paramRecyclerView.getMeasuredWidth() - paramRecyclerView.getPaddingRight();
    paramRecyclerView = paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramRecyclerView.getLayoutParams();
    int k = paramRecyclerView.getBottom() + localLayoutParams.bottomMargin + getLoadMorePadding() / 2;
    this.paint.setAntiAlias(true);
    this.paint.setFlags(1);
    this.paint.setColor(-7829368);
    this.paint.setStrokeWidth(10.0F);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle((j - i) / 2 - this.mCircleOffset, k, this.mCircleSize, this.paint);
    this.paint.setColor(-16711936);
    this.oval.set((j - i) / 2 - this.mCircleOffset - this.mCircleSize, k - this.mCircleSize, (j - i) / 2 - this.mCircleOffset + this.mCircleSize, this.mCircleSize + k);
    paramCanvas.drawArc(this.oval, -90.0F, 360.0F * (this.mProgress / 100.0F), false, this.paint);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setFlags(1);
    this.paint.setStrokeWidth(3.0F);
    this.paint.setTextSize(40.0F);
    this.paint.setColor(-16777216);
    paramCanvas.drawText(getLoadmoreString(), (j - i) / 2, k + 10, this.paint);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/footer/loadmore/DefaultLoadMoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */