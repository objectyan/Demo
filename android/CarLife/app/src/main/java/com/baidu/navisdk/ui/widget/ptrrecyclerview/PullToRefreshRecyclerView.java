package com.baidu.navisdk.ui.widget.ptrrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView.DragState;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.DefaultLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.header.Header;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.util.PullToRefreshRecyclerViewUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class PullToRefreshRecyclerView
  extends TwoStateScrollView
  implements PrvInterface
{
  private static final int FINGER_SIZE = 5;
  private static final int INNER_VIEW_TOUCH_SIZE = 20;
  private static final String TAG = PullToRefreshRecyclerView.class.getSimpleName();
  private int downY = -1;
  private boolean hasMoreItems = false;
  private boolean interceptHasActionDown = false;
  private int interceptLastY = -1;
  private boolean isLoading = false;
  private AdapterObserver mAdapterObserver;
  private int mCurScroll;
  private View mEmptyView;
  private View mHeader;
  private InterOnScrollListener mInterOnScrollListener;
  private boolean mIsSwipeEnable = false;
  private int mLoadMoreCount = 10;
  private BaseLoadMoreView mLoadMoreFooter;
  private OnScrollListener mOnScrollLinstener;
  private PagingableListener mPagingableListener;
  private PullToRefreshRecyclerViewUtil mPtrrvUtil;
  private RecyclerView mRecyclerView;
  private Header mRootHeader;
  private RelativeLayout mRootRelativeLayout;
  
  public PullToRefreshRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    this.mRootRelativeLayout = ((RelativeLayout)JarUtils.inflate((Activity)paramContext, 1711472788, null));
    addView(this.mRootRelativeLayout);
    this.mRecyclerView = ((RecyclerView)this.mRootRelativeLayout.findViewById(1711867332));
    this.mRecyclerView.setHasFixedSize(true);
    if (!this.mIsSwipeEnable) {
      setEnabled(false);
    }
  }
  
  private void setHasMoreItems(boolean paramBoolean)
  {
    this.hasMoreItems = paramBoolean;
    if (this.mLoadMoreFooter == null) {
      this.mLoadMoreFooter = new DefaultLoadMoreView(getContext(), getRecyclerView());
    }
    if (!this.hasMoreItems)
    {
      this.mRecyclerView.removeItemDecoration(this.mLoadMoreFooter);
      return;
    }
    this.mRecyclerView.removeItemDecoration(this.mLoadMoreFooter);
    this.mRecyclerView.addItemDecoration(this.mLoadMoreFooter);
  }
  
  private void setLinster()
  {
    this.mInterOnScrollListener = new InterOnScrollListener(null);
    this.mRecyclerView.setOnScrollListener(this.mInterOnScrollListener);
  }
  
  private void setup(Context paramContext)
  {
    this.mScroller = new Scroller(paramContext);
    setupExtra();
    initView(paramContext);
    setLinster();
  }
  
  private void setupExtra()
  {
    this.isLoading = false;
    this.hasMoreItems = false;
    this.mPtrrvUtil = new PullToRefreshRecyclerViewUtil();
  }
  
  public void addHeaderView(View paramView)
  {
    if (this.mHeader != null) {
      this.mRootRelativeLayout.removeView(this.mHeader);
    }
    this.mHeader = paramView;
    if (this.mHeader == null) {
      return;
    }
    this.mHeader.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        if (Build.VERSION.SDK_INT >= 16) {
          PullToRefreshRecyclerView.this.mHeader.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        while ((PullToRefreshRecyclerView.this.getRecyclerView() == null) || (PullToRefreshRecyclerView.this.mHeader == null))
        {
          return;
          PullToRefreshRecyclerView.this.mHeader.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        if (PullToRefreshRecyclerView.this.mRootHeader == null) {
          PullToRefreshRecyclerView.access$302(PullToRefreshRecyclerView.this, new Header());
        }
        PullToRefreshRecyclerView.this.mRootHeader.setHeight(PullToRefreshRecyclerView.this.mHeader.getMeasuredHeight());
        PullToRefreshRecyclerView.this.getRecyclerView().removeItemDecoration(PullToRefreshRecyclerView.this.mRootHeader);
        PullToRefreshRecyclerView.this.getRecyclerView().addItemDecoration(PullToRefreshRecyclerView.this.mRootHeader);
        PullToRefreshRecyclerView.this.getRecyclerView().getAdapter().notifyDataSetChanged();
      }
    });
    this.mRootRelativeLayout.addView(this.mHeader);
  }
  
  public void addOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollLinstener = paramOnScrollListener;
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    return this.mPtrrvUtil.findFirstCompletelyVisibleItemPosition(getLayoutManager());
  }
  
  public int findFirstVisibleItemPosition()
  {
    return this.mPtrrvUtil.findFirstVisibleItemPosition(getLayoutManager());
  }
  
  public int findLastVisibleItemPosition()
  {
    return this.mPtrrvUtil.findLastVisibleItemPosition(getLayoutManager());
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    if (this.mRecyclerView != null) {
      return this.mRecyclerView.getLayoutManager();
    }
    return null;
  }
  
  public BaseLoadMoreView getLoadMoreFooter()
  {
    return this.mLoadMoreFooter;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public boolean isSwipeEnable()
  {
    return this.mIsSwipeEnable;
  }
  
  public void onFinishLoading(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getLayoutManager() == null) {}
    do
    {
      return;
      if ((!paramBoolean1) && (this.mLoadMoreFooter != null)) {
        this.mCurScroll -= this.mLoadMoreFooter.getLoadMorePadding();
      }
      if (getLayoutManager().getItemCount() < this.mLoadMoreCount) {
        paramBoolean1 = false;
      }
      setHasMoreItems(paramBoolean1);
      this.isLoading = false;
    } while (!paramBoolean2);
    int i = findFirstVisibleItemPosition();
    this.mRecyclerView.scrollToPosition(i - 1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.needScroll) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    LogUtil.e(TAG, "onInterceptTouchEvent : isScrolling --> " + this.isScrolling + ", action: " + j);
    if ((this.isScrolling) && (j != 0)) {
      return false;
    }
    int i = (int)paramMotionEvent.getY();
    obtainVelocity(paramMotionEvent);
    switch (j)
    {
    }
    for (;;)
    {
      return false;
      if (!this.mScroller.isFinished())
      {
        this.mScroller.abortAnimation();
        this.isScrolling = false;
      }
      this.mScrollStart = getScrollY();
      LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_DOWN): mScrollStart --> " + this.mScrollStart);
      if ((getLayoutManager() != null) && (getLayoutManager().getChildAt(0) != null))
      {
        j = getLayoutManager().getChildAt(0).getTop();
        LogUtil.e(TAG, "onInterceptTouchEvent: firstItemTop --> " + j);
        if ((j == -1) && (Build.VERSION.SDK_INT >= 11)) {
          getLayoutManager().getChildAt(0).setTop(0);
        }
      }
      j = findFirstCompletelyVisibleItemPosition();
      LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_DOWN): firstCompletelyVisibleItem --> " + j);
      if (this.mScrollStart < -this.foldableHeight / 2)
      {
        this.status = TwoStateScrollView.DragState.BOTTOM;
        if ((this.status != TwoStateScrollView.DragState.TOP) || (this.mScrollStart != 0) || (j != 0)) {
          break label435;
        }
      }
      for (this.interceptHasActionDown = true;; this.interceptHasActionDown = true) {
        label435:
        do
        {
          this.interceptLastY = i;
          this.downY = i;
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_DOWN): status --> " + this.status);
          if (this.status != TwoStateScrollView.DragState.BOTTOM) {
            break label465;
          }
          if ((this.isScrolling) || (i >= this.blankSpaceHeight)) {
            break label523;
          }
          this.interceptHasActionDown = false;
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_DOWN): --> blank space clicked: " + i);
          return false;
          this.status = TwoStateScrollView.DragState.TOP;
          break;
        } while ((this.status != TwoStateScrollView.DragState.BOTTOM) || (this.mScrollStart != -this.foldableHeight));
      }
      label465:
      if ((!this.isScrolling) && (i < getMeasuredHeight() - this.persistantHeight - this.foldableHeight))
      {
        this.interceptHasActionDown = false;
        LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_DOWN): --> beyond view range: " + i);
        return false;
      }
      label523:
      this.hasActionDown = true;
      this.mLastY = i;
      continue;
      LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE): interceptHasActionDown --> " + this.interceptHasActionDown);
      if (!this.interceptHasActionDown) {
        return false;
      }
      this.interceptHasActionDown = false;
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      j = i - this.interceptLastY;
      int k = i - this.downY;
      LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE): --> status: " + this.status + ", dy: " + j);
      if (this.status == TwoStateScrollView.DragState.TOP)
      {
        if (j > 0)
        {
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 1: - scroll down");
          scrollBy(0, -j);
          this.interceptLastY = i;
          this.mLastY = i;
          return true;
        }
        if (j < -5)
        {
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 2: - scroll up");
          this.interceptLastY = i;
          this.mLastY = i;
        }
        else
        {
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 3: - touch equivalent");
          this.interceptLastY = i;
          this.mLastY = i;
          this.interceptHasActionDown = true;
          return false;
        }
      }
      else
      {
        boolean bool = false;
        if (k < -20)
        {
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 7: - outer view event");
          bool = true;
          if (j >= 0) {
            break label856;
          }
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 4: - scroll up");
          scrollBy(0, -j);
        }
        for (;;)
        {
          this.mLastY = i;
          this.interceptLastY = i;
          LogUtil.e(TAG, "onInterceptTouchEvent: containerEvent --> " + bool + ", dyToDown: " + k);
          return bool;
          LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 8: - inner view event");
          this.interceptHasActionDown = true;
          break;
          label856:
          if (j > 5)
          {
            LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 5: - scroll down");
            bool = true;
          }
          else
          {
            LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 6: - touch equivalent");
            this.interceptHasActionDown = true;
          }
        }
        LogUtil.e(TAG, "onInterceptTouchEvent (ACTION_UP): interceptHasActionDown --> " + this.interceptHasActionDown);
        this.interceptHasActionDown = false;
        this.interceptLastY = i;
      }
    }
  }
  
  public void release() {}
  
  public void removeHeader()
  {
    if (this.mRootHeader != null)
    {
      getRecyclerView().removeItemDecoration(this.mRootHeader);
      this.mRootHeader = null;
    }
    if (this.mHeader != null)
    {
      this.mRootRelativeLayout.removeView(this.mHeader);
      this.mHeader = null;
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mRecyclerView.scrollToPosition(paramInt);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    this.mRecyclerView.setAdapter(paramAdapter);
    if (this.mAdapterObserver == null) {
      this.mAdapterObserver = new AdapterObserver(null);
    }
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mAdapterObserver);
      this.mAdapterObserver.onChanged();
    }
  }
  
  public void setEmptyView(View paramView)
  {
    if (this.mEmptyView != null) {
      this.mRootRelativeLayout.removeView(this.mEmptyView);
    }
    this.mEmptyView = paramView;
  }
  
  public void setFooter(View paramView) {}
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.setLayoutManager(paramLayoutManager);
    }
  }
  
  public void setLoadMoreCount(int paramInt)
  {
    this.mLoadMoreCount = paramInt;
  }
  
  public void setLoadMoreFooter(BaseLoadMoreView paramBaseLoadMoreView)
  {
    this.mLoadMoreFooter = paramBaseLoadMoreView;
  }
  
  public void setLoadmoreString(String paramString)
  {
    if (this.mLoadMoreFooter != null) {
      this.mLoadMoreFooter.setLoadmoreString(paramString);
    }
  }
  
  public void setOnLoadMoreComplete()
  {
    setHasMoreItems(false);
  }
  
  public void setOnRefreshComplete()
  {
    setRefreshing(false);
  }
  
  public void setPagingableListener(PagingableListener paramPagingableListener)
  {
    this.mPagingableListener = paramPagingableListener;
  }
  
  public void setRefreshing(boolean paramBoolean) {}
  
  public void setSwipeEnable(boolean paramBoolean)
  {
    this.mIsSwipeEnable = paramBoolean;
    setEnabled(this.mIsSwipeEnable);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    this.mRecyclerView.smoothScrollToPosition(paramInt);
  }
  
  private class AdapterObserver
    extends RecyclerView.AdapterDataObserver
  {
    private AdapterObserver() {}
    
    public void onChanged()
    {
      super.onChanged();
      if (PullToRefreshRecyclerView.this.mRecyclerView == null) {}
      RecyclerView.Adapter localAdapter;
      do
      {
        return;
        localAdapter = PullToRefreshRecyclerView.this.mRecyclerView.getAdapter();
      } while ((localAdapter == null) || (PullToRefreshRecyclerView.this.mEmptyView == null));
      if (localAdapter.getItemCount() == 0)
      {
        if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
          PullToRefreshRecyclerView.this.setEnabled(false);
        }
        if (PullToRefreshRecyclerView.this.mEmptyView.getParent() != PullToRefreshRecyclerView.this.mRootRelativeLayout) {
          PullToRefreshRecyclerView.this.mRootRelativeLayout.addView(PullToRefreshRecyclerView.this.mEmptyView);
        }
        PullToRefreshRecyclerView.this.mEmptyView.setVisibility(0);
        PullToRefreshRecyclerView.this.mRecyclerView.setVisibility(8);
        return;
      }
      if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
        PullToRefreshRecyclerView.this.setEnabled(true);
      }
      PullToRefreshRecyclerView.this.mEmptyView.setVisibility(8);
      PullToRefreshRecyclerView.this.mRecyclerView.setVisibility(0);
    }
  }
  
  private class InterOnScrollListener
    extends RecyclerView.OnScrollListener
  {
    private InterOnScrollListener() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (PullToRefreshRecyclerView.this.mOnScrollLinstener != null) {
        PullToRefreshRecyclerView.this.mOnScrollLinstener.onScrollStateChanged(paramRecyclerView, paramInt);
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (PullToRefreshRecyclerView.this.getLayoutManager() == null) {}
      label227:
      label288:
      for (;;)
      {
        return;
        PullToRefreshRecyclerView.access$502(PullToRefreshRecyclerView.this, PullToRefreshRecyclerView.this.mCurScroll + paramInt2);
        if ((PullToRefreshRecyclerView.this.mHeader != null) && (Build.VERSION.SDK_INT >= 11)) {
          PullToRefreshRecyclerView.this.mHeader.setTranslationY(-PullToRefreshRecyclerView.this.mCurScroll);
        }
        int i = PullToRefreshRecyclerView.this.getLayoutManager().getChildCount();
        int j = PullToRefreshRecyclerView.this.getLayoutManager().getItemCount();
        int k = PullToRefreshRecyclerView.this.findFirstVisibleItemPosition();
        int m = PullToRefreshRecyclerView.this.findLastVisibleItemPosition();
        if (PullToRefreshRecyclerView.this.mIsSwipeEnable)
        {
          if (PullToRefreshRecyclerView.this.findFirstCompletelyVisibleItemPosition() != 0) {
            PullToRefreshRecyclerView.this.setEnabled(false);
          }
        }
        else
        {
          if (j >= PullToRefreshRecyclerView.this.mLoadMoreCount) {
            break label227;
          }
          PullToRefreshRecyclerView.this.setHasMoreItems(false);
          PullToRefreshRecyclerView.access$902(PullToRefreshRecyclerView.this, false);
        }
        for (;;)
        {
          if (PullToRefreshRecyclerView.this.mOnScrollLinstener == null) {
            break label288;
          }
          PullToRefreshRecyclerView.this.mOnScrollLinstener.onScrolled(paramRecyclerView, paramInt1, paramInt2);
          PullToRefreshRecyclerView.this.mOnScrollLinstener.onScroll(paramRecyclerView, k, i, j);
          return;
          PullToRefreshRecyclerView.this.setEnabled(true);
          break;
          if ((!PullToRefreshRecyclerView.this.isLoading) && (PullToRefreshRecyclerView.this.hasMoreItems) && (m + 1 == j) && (PullToRefreshRecyclerView.this.mPagingableListener != null))
          {
            PullToRefreshRecyclerView.access$902(PullToRefreshRecyclerView.this, true);
            PullToRefreshRecyclerView.this.mPagingableListener.onLoadMoreItems();
          }
        }
      }
    }
  }
  
  public static abstract interface OnScrollListener
  {
    public abstract void onScroll(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt);
    
    public abstract void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface PagingableListener
  {
    public abstract void onLoadMoreItems();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/ptrrecyclerview/PullToRefreshRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */