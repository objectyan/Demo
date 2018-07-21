package com.baidu.carlife.f;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ScrollView;

public class f
  extends a
{
  public f(ScrollView paramScrollView, int paramInt)
  {
    super(paramScrollView, paramInt);
    paramScrollView.setOnKeyListener(this);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0)) {}
    switch (paramInt)
    {
    default: 
      return super.onKey(paramView, paramInt, paramKeyEvent);
    case 300: 
      ((ScrollView)this.r).arrowScroll(130);
      return true;
    }
    ((ScrollView)this.r).arrowScroll(33);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */