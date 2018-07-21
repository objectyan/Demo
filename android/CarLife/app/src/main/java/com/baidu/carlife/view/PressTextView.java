package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.navisdk.util.common.ScreenUtil;

public class PressTextView
  extends TextView
{
  public static final int a = 1;
  public static final int b = 2;
  private boolean c = false;
  private int d = 0;
  
  public PressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!this.c) || ((this.d != 1) && (this.d != 2))) {
      return;
    }
    int i;
    if (this.d == 1)
    {
      i = 94;
      if (this.d != 1) {
        break label132;
      }
    }
    label132:
    for (int j = 118;; j = 66)
    {
      i = ScreenUtil.getInstance().dip2px(i);
      j = ScreenUtil.getInstance().dip2px(j);
      int k = ScreenUtil.getInstance().dip2px(5);
      Paint localPaint = new Paint();
      localPaint.setColor(-59580);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawCircle(i, j, k, localPaint);
      return;
      i = 90;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      setAlpha(0.4F);
      continue;
      setAlpha(1.0F);
    }
  }
  
  public void setNeedRedPoint(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setPageType(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/PressTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */