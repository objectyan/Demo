package com.baidu.navisdk.ui.routedetails;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class TextViewWithSpecifyBackground
  extends TextView
{
  private static final String TAG = TextViewWithSpecifyBackground.class.getName();
  private int mColor;
  private ShapeDrawable mShapeDrawable;
  
  public TextViewWithSpecifyBackground(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    drawDefaultBGColor();
    setSingleLine(true);
  }
  
  public TextViewWithSpecifyBackground(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    drawDefaultBGColor();
    setSingleLine(true);
  }
  
  public void drawDefaultBGColor()
  {
    if (this.mShapeDrawable == null) {
      this.mShapeDrawable = new ShapeDrawable();
    }
    this.mShapeDrawable.setShape(new MyShape(this));
    setBackgroundDrawable(this.mShapeDrawable);
  }
  
  public void setViewBGColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  private class MyShape
    extends Shape
  {
    TextViewWithSpecifyBackground pn;
    
    public MyShape(TextViewWithSpecifyBackground paramTextViewWithSpecifyBackground)
    {
      this.pn = paramTextViewWithSpecifyBackground;
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      paramPaint.setColor(TextViewWithSpecifyBackground.this.mColor);
      int i = ScreenUtil.getInstance().dip2px(1);
      int j = (this.pn.getHeight() - i) / 2;
      paramCanvas.drawRect(j, i, this.pn.getWidth() - j, this.pn.getHeight(), paramPaint);
      paramCanvas.drawCircle(j, j + i, j, paramPaint);
      paramCanvas.drawCircle(this.pn.getWidth() - j, j + i, j, paramPaint);
      LogUtil.e(TextViewWithSpecifyBackground.TAG, "pain Rect And Circle");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routedetails/TextViewWithSpecifyBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */