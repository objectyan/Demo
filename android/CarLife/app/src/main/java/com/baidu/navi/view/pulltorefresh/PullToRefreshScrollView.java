package com.baidu.navi.view.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.navi.view.pulltorefresh.internal.LoadingLayout;

public class PullToRefreshScrollView
  extends PullToRefreshBase<ScrollView>
{
  public PullToRefreshScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected ScrollView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new InternalScrollViewSDK9(paramContext, paramAttributeSet);; paramContext = new ScrollView(paramContext, paramAttributeSet))
    {
      paramContext.setId(2131623938);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  public void hideLayoutViews()
  {
    getHeaderLayout().hideAllViews();
    getFooterLayout().hideAllViews();
  }
  
  protected boolean isReadyForPullEnd()
  {
    View localView = ((ScrollView)this.mRefreshableView).getChildAt(0);
    if (localView != null) {
      return ((ScrollView)this.mRefreshableView).getScrollY() >= localView.getHeight() - getHeight();
    }
    return false;
  }
  
  protected boolean isReadyForPullStart()
  {
    return ((ScrollView)this.mRefreshableView).getScrollY() == 0;
  }
  
  @TargetApi(9)
  final class InternalScrollViewSDK9
    extends ScrollView
  {
    public InternalScrollViewSDK9(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int getScrollRange()
    {
      int i = 0;
      if (getChildCount() > 0) {
        i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
      }
      return i;
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      OverscrollHelper.overScrollBy(PullToRefreshScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, getScrollRange(), paramBoolean);
      return bool;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/PullToRefreshScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */