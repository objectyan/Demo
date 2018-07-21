package com.baidu.carlife.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UserGuideViewPager
  extends ViewPager
{
  private boolean a;
  
  public UserGuideViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public UserGuideViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setScrollOperationFlag(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/UserGuideViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */