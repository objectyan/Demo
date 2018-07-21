package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.custom.a;
import com.baidu.carlife.custom.b;
import com.baidu.navi.fragment.NaviFragmentManager;

public class InterceptTouchRelativeLayout
  extends RelativeLayout
{
  public InterceptTouchRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((a.a().b()) || (b.a().b())) && (paramMotionEvent.getAction() == 2) && (h.a().getNaviFragmentManager().isDriving())) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/InterceptTouchRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */