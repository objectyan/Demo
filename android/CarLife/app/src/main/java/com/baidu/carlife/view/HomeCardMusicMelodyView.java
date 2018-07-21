package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.core.d;
import com.baidu.carlife.core.i;

public class HomeCardMusicMelodyView
  extends View
{
  private Paint a = new Paint();
  private final int b = d.a().c(2);
  private final int c = d.a().a(3.6F);
  private int d;
  private int e;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i;
  private int j;
  private boolean k = true;
  private int[] l = { 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 6, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 7, 8, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9, 9, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 4, 6, 5, 7, 7, 6, 6, 5, 5, 6, 7, 8, 8, 7, 9 };
  
  public HomeCardMusicMelodyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setColor(1728053247);
    this.a.setStrokeWidth(0.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.k)
    {
      this.k = false;
      this.d = getWidth();
      this.e = getHeight();
      this.g = ((this.d - this.b) / (this.b + this.c));
      this.h = (this.d - this.g * (this.b + this.c));
      if (this.h >= this.b)
      {
        this.g += 1;
        this.h -= this.b;
      }
      this.h /= 2;
      i.b("HomeCardMusicMelodyView", "width = " + this.b);
      i.b("HomeCardMusicMelodyView", "padding = " + this.c);
      i.b("HomeCardMusicMelodyView", "margin = " + this.h);
      i.b("HomeCardMusicMelodyView", "parentwidth = " + this.d);
    }
    int m = 0;
    while ((m < this.l.length) && (m < this.g))
    {
      this.i = ((this.c + this.b) * m + this.h);
      this.j = (this.e - (int)(this.e * 0.1D * this.l[(this.f + m)]));
      paramCanvas.drawRect(this.i, this.j, this.i + this.b, this.e, this.a);
      m += 1;
    }
  }
  
  public void setStartIndex(int paramInt)
  {
    if (this.g + paramInt < this.l.length) {
      this.f = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/HomeCardMusicMelodyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */