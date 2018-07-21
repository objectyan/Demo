package com.baidu.carlife.view.recyclingviewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class b
  extends Scroller
{
  private int a = 1500;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public b(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/recyclingviewpager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */