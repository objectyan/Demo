package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.core.d;
import com.baidu.carlife.util.r;

public class MusicCircleView
  extends View
{
  private final int a = d.a().c(2);
  
  public MusicCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(r.a(2131558625));
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(this.a);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - this.a / 2, localPaint);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/MusicCircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */