package com.baidu.mapframework.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RouteLoadingView
  extends ImageView
{
  private AnimationDrawable a;
  
  public RouteLoadingView(Context paramContext)
  {
    super(paramContext, null);
    startAni();
  }
  
  public RouteLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    startAni();
  }
  
  public RouteLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    startAni();
  }
  
  public void startAni()
  {
    setImageResource(2130839400);
    this.a = ((AnimationDrawable)getDrawable());
    this.a.start();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/widget/RouteLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */