package com.baidu.navi.view.draglistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ScrollView;

public class NaviScrollView
  extends ScrollView
{
  private ImageView mDragImage;
  
  public NaviScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NaviScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NaviScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    this.mDragImage = ((ImageView)findViewById(2131624592));
    int[] arrayOfInt = new int[2];
    this.mDragImage.getLocationOnScreen(arrayOfInt);
    if ((i > arrayOfInt[0] - 20) && (i < arrayOfInt[0] + this.mDragImage.getWidth() + 20)) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/draglistview/NaviScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */