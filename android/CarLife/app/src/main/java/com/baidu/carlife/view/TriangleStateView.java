package com.baidu.carlife.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TriangleStateView
  extends ImageView
{
  private int a;
  private Paint b;
  private int c;
  
  public TriangleStateView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TriangleStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TriangleStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext.getResources().getDimensionPixelSize(2131361843);
    this.a = paramContext.getResources().getColor(2131558610);
    this.b = new Paint();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(this.a);
    this.b.setAntiAlias(true);
    Path localPath = new Path();
    localPath.moveTo(this.c, 0.0F);
    localPath.lineTo(this.c, this.c);
    localPath.lineTo(0.0F, this.c);
    localPath.close();
    paramCanvas.drawPath(localPath, this.b);
  }
  
  public void setBgColor(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/TriangleStateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */