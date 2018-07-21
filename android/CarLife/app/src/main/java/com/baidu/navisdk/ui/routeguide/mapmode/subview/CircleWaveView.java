package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;

public class CircleWaveView
  extends View
{
  private Paint paint = new Paint();
  private int radius = 0;
  
  public CircleWaveView(Context paramContext)
  {
    super(paramContext);
    this.paint.setAntiAlias(true);
    this.paint.setColor(BNStyleManager.getColor(1711800716));
    this.paint.setStyle(Paint.Style.FILL);
  }
  
  public CircleWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.paint.setAntiAlias(true);
    this.paint.setColor(BNStyleManager.getColor(1711800716));
    this.paint.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth() / 2;
    int j = getMeasuredHeight() / 2;
    paramCanvas.drawCircle(i, j, this.radius, this.paint);
  }
  
  public void setCircleRadius(int paramInt)
  {
    if (paramInt + 10 > 80) {}
    for (this.radius = ((int)(80.0F * ScreenUtil.getInstance().getDensity()));; this.radius = ((int)((paramInt + 10) * ScreenUtil.getInstance().getDensity())))
    {
      invalidate();
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/CircleWaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */