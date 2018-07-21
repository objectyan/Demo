package com.baidu.navi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class HeightWrapableViewPager
  extends ViewPager
{
  private View mCurrentView;
  
  public HeightWrapableViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeightWrapableViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int measureHeight(int paramInt, View paramView)
  {
    int i = 0;
    int k = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (k == 1073741824) {
      i = j;
    }
    do
    {
      return i;
      paramInt = i;
      if (paramView != null) {
        paramInt = paramView.getMeasuredHeight();
      }
      i = paramInt;
    } while (k != Integer.MIN_VALUE);
    return Math.min(paramInt, j);
  }
  
  public View getCurrentView(int paramInt)
  {
    return this.mCurrentView;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = findViewWithTag(Integer.valueOf(getCurrentItem()));
    this.mCurrentView = localView;
    if (localView != null)
    {
      localView.measure(paramInt1, paramInt2);
      setMeasuredDimension(getMeasuredWidth(), measureHeight(paramInt2, localView));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/HeightWrapableViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */