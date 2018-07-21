package com.baidu.navi.view.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.baidu.navi.view.pulltorefresh.internal.LoadingLayout;

public class PullToRefreshHorizontalScrollView
  extends PullToRefreshBase<HorizontalScrollView>
{
  public PullToRefreshHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected HorizontalScrollView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new InternalHorizontalScrollViewSDK9(paramContext, paramAttributeSet);; paramContext = new slowHorizontalScrollView(paramContext, paramAttributeSet))
    {
      paramContext.setId(2131623938);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.HORIZONTAL;
  }
  
  public void hideLayoutViews()
  {
    getHeaderLayout().hideAllViews();
    getFooterLayout().hideAllViews();
  }
  
  protected boolean isReadyForPullEnd()
  {
    View localView = ((HorizontalScrollView)this.mRefreshableView).getChildAt(0);
    if (localView != null) {
      return ((HorizontalScrollView)this.mRefreshableView).getScrollX() >= localView.getWidth() - getWidth();
    }
    return false;
  }
  
  protected boolean isReadyForPullStart()
  {
    return ((HorizontalScrollView)this.mRefreshableView).getScrollX() == 0;
  }
  
  @TargetApi(9)
  final class InternalHorizontalScrollViewSDK9
    extends PullToRefreshHorizontalScrollView.slowHorizontalScrollView
  {
    public InternalHorizontalScrollViewSDK9(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramContext, paramAttributeSet);
    }
    
    private int getScrollRange()
    {
      int i = 0;
      if (getChildCount() > 0) {
        i = Math.max(0, getChildAt(0).getWidth() - (getWidth() - getPaddingLeft() - getPaddingRight()));
      }
      return i;
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      OverscrollHelper.overScrollBy(PullToRefreshHorizontalScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, getScrollRange(), paramBoolean);
      return bool;
    }
  }
  
  class slowHorizontalScrollView
    extends HorizontalScrollView
  {
    public slowHorizontalScrollView(Context paramContext)
    {
      super();
    }
    
    public slowHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public slowHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public void fling(int paramInt)
    {
      super.fling(paramInt / 2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/PullToRefreshHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */