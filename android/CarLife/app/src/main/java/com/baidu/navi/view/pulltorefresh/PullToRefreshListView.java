package com.baidu.navi.view.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.navi.view.pulltorefresh.internal.EmptyViewMethodAccessor;
import com.baidu.navi.view.pulltorefresh.internal.LoadingLayout;

public class PullToRefreshListView
  extends PullToRefreshAdapterViewBase<ListView>
{
  private LoadingLayout mFooterLoadingView;
  private LoadingLayout mHeaderLoadingView;
  private boolean mListViewExtrasEnabled;
  private FrameLayout mLvFooterLoadingFrame;
  
  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected ListView createListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return new InternalListViewSDK9(paramContext, paramAttributeSet);
    }
    return new InternalListView(paramContext, paramAttributeSet);
  }
  
  protected LoadingLayoutProxy createLoadingLayoutProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = super.createLoadingLayoutProxy(paramBoolean1, paramBoolean2);
    if (this.mListViewExtrasEnabled)
    {
      PullToRefreshBase.Mode localMode = getMode();
      if ((paramBoolean1) && (localMode.showHeaderLoadingLayout())) {
        localLoadingLayoutProxy.addLayout(this.mHeaderLoadingView);
      }
      if ((paramBoolean2) && (localMode.showFooterLoadingLayout())) {
        localLoadingLayoutProxy.addLayout(this.mFooterLoadingView);
      }
    }
    return localLoadingLayoutProxy;
  }
  
  protected ListView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = createListView(paramContext, paramAttributeSet);
    paramContext.setId(16908298);
    return paramContext;
  }
  
  public ListAdapter getAdapter()
  {
    return ((ListView)this.mRefreshableView).getAdapter();
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected void handleStyledAttributes(TypedArray paramTypedArray)
  {
    super.handleStyledAttributes(paramTypedArray);
    this.mListViewExtrasEnabled = paramTypedArray.getBoolean(16, true);
    if (this.mListViewExtrasEnabled)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      this.mHeaderLoadingView = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, paramTypedArray);
      this.mHeaderLoadingView.setVisibility(8);
      localFrameLayout.addView(this.mHeaderLoadingView, localLayoutParams);
      ((ListView)this.mRefreshableView).addHeaderView(localFrameLayout, null, false);
      this.mLvFooterLoadingFrame = new FrameLayout(getContext());
      this.mFooterLoadingView = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, paramTypedArray);
      this.mFooterLoadingView.setVisibility(8);
      this.mLvFooterLoadingFrame.addView(this.mFooterLoadingView, localLayoutParams);
      if (!paramTypedArray.hasValue(15)) {
        setScrollingWhileRefreshingEnabled(true);
      }
    }
  }
  
  public void hideLayoutViews()
  {
    getHeaderLayout().hideAllViews();
    getFooterLayout().hideAllViews();
    this.mLvFooterLoadingFrame.setVisibility(8);
  }
  
  protected void onRefreshing(boolean paramBoolean)
  {
    Object localObject = ((ListView)this.mRefreshableView).getAdapter();
    if ((!this.mListViewExtrasEnabled) || (!getShowViewWhileRefreshing()) || (localObject == null) || (((ListAdapter)localObject).isEmpty()))
    {
      super.onRefreshing(paramBoolean);
      return;
    }
    super.onRefreshing(false);
    LoadingLayout localLoadingLayout2;
    LoadingLayout localLoadingLayout1;
    int j;
    switch (getCurrentMode())
    {
    default: 
      localLoadingLayout2 = getHeaderLayout();
      localObject = this.mHeaderLoadingView;
      localLoadingLayout1 = this.mFooterLoadingView;
      j = 0;
    }
    for (int i = getScrollY() + getHeaderSize();; i = getScrollY() - getFooterSize())
    {
      localLoadingLayout2.reset();
      localLoadingLayout2.hideAllViews();
      localLoadingLayout1.setVisibility(8);
      ((LoadingLayout)localObject).setVisibility(0);
      ((LoadingLayout)localObject).refreshing();
      if (!paramBoolean) {
        break;
      }
      disableLoadingLayoutVisibilityChanges();
      setHeaderScroll(i);
      ((ListView)this.mRefreshableView).setSelection(j);
      smoothScrollTo(0);
      return;
      localLoadingLayout2 = getFooterLayout();
      localObject = this.mFooterLoadingView;
      localLoadingLayout1 = this.mHeaderLoadingView;
      j = ((ListView)this.mRefreshableView).getCount() - 1;
    }
  }
  
  protected void onReset()
  {
    int m = 1;
    int i = 1;
    if (!this.mListViewExtrasEnabled)
    {
      super.onReset();
      return;
    }
    LoadingLayout localLoadingLayout2;
    LoadingLayout localLoadingLayout1;
    int j;
    int k;
    switch (getCurrentMode())
    {
    default: 
      localLoadingLayout2 = getHeaderLayout();
      localLoadingLayout1 = this.mHeaderLoadingView;
      j = -getHeaderSize();
      k = 0;
      if (Math.abs(((ListView)this.mRefreshableView).getFirstVisiblePosition() - 0) > 1) {
        break;
      }
    }
    for (;;)
    {
      if (localLoadingLayout1.getVisibility() == 0)
      {
        localLoadingLayout2.showInvisibleViews();
        localLoadingLayout1.setVisibility(8);
        if ((i != 0) && (getState() != PullToRefreshBase.State.MANUAL_REFRESHING))
        {
          ((ListView)this.mRefreshableView).setSelection(k);
          setHeaderScroll(j);
        }
      }
      super.onReset();
      return;
      localLoadingLayout2 = getFooterLayout();
      localLoadingLayout1 = this.mFooterLoadingView;
      k = ((ListView)this.mRefreshableView).getCount() - 1;
      j = getFooterSize();
      if (Math.abs(((ListView)this.mRefreshableView).getLastVisiblePosition() - k) <= 1) {}
      for (i = m;; i = 0) {
        break;
      }
      i = 0;
    }
  }
  
  protected class InternalListView
    extends ListView
    implements EmptyViewMethodAccessor
  {
    private boolean mAddedLvFooter = false;
    
    public InternalListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        return;
      }
      catch (IndexOutOfBoundsException paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      try
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IndexOutOfBoundsException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      if ((PullToRefreshListView.this.mLvFooterLoadingFrame != null) && (!this.mAddedLvFooter))
      {
        addFooterView(PullToRefreshListView.this.mLvFooterLoadingFrame, null, false);
        this.mAddedLvFooter = true;
      }
      super.setAdapter(paramListAdapter);
    }
    
    public void setEmptyView(View paramView)
    {
      PullToRefreshListView.this.setEmptyView(paramView);
    }
    
    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }
  
  @TargetApi(9)
  final class InternalListViewSDK9
    extends PullToRefreshListView.InternalListView
  {
    public InternalListViewSDK9(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramContext, paramAttributeSet);
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      OverscrollHelper.overScrollBy(PullToRefreshListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
      return bool;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */