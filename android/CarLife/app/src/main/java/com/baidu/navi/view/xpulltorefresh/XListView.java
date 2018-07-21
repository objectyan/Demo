package com.baidu.navi.view.xpulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class XListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private static final float OFFSET_RADIO = 1.8F;
  private static final int PULL_LOAD_MORE_DELTA = 50;
  private static final int SCROLL_BACK_FOOTER = 1;
  private static final int SCROLL_BACK_HEADER = 0;
  private static final int SCROLL_DURATION = 400;
  private boolean mEnableAutoLoad = false;
  private boolean mEnablePullLoad = false;
  private boolean mEnablePullRefresh = false;
  private LinearLayout mFooterLayout;
  private XFooterView mFooterView;
  private XHeaderView mHeader;
  private RelativeLayout mHeaderContent;
  private int mHeaderHeight;
  private TextView mHeaderTime;
  private boolean mIsFooterReady = false;
  private float mLastY = -1.0F;
  private IXListViewListener mListener;
  private boolean mPullLoading = false;
  private boolean mPullRefreshing = false;
  private int mScrollBack;
  private AbsListView.OnScrollListener mScrollListener;
  private Scroller mScroller;
  private int mTotalItemCount;
  
  public XListView(Context paramContext)
  {
    super(paramContext);
    initWithContext(paramContext);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initWithContext(paramContext);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initWithContext(paramContext);
  }
  
  private void disableEdgeEffect()
  {
    try
    {
      Object localObject2 = Class.forName("android.widget.AbsListView");
      if (localObject2 != null)
      {
        Object localObject4 = Class.forName("android.widget.EdgeEffect");
        Object localObject3 = ((Class)localObject4).getConstructor(new Class[] { Context.class });
        Object localObject1 = ((Constructor)localObject3).newInstance(new Object[] { getContext() });
        localObject3 = ((Constructor)localObject3).newInstance(new Object[] { getContext() });
        Field localField = ((Class)localObject4).getDeclaredField("mEdge");
        localObject4 = ((Class)localObject4).getDeclaredField("mGlow");
        localField.setAccessible(true);
        ((Field)localObject4).setAccessible(true);
        localField.set(localObject1, new ColorDrawable(17170445));
        localField.set(localObject3, new ColorDrawable(17170445));
        ((Field)localObject4).set(localObject1, new ColorDrawable(17170445));
        ((Field)localObject4).set(localObject3, new ColorDrawable(17170445));
        localObject4 = ((Class)localObject2).getDeclaredField("mEdgeGlowTop");
        localObject2 = ((Class)localObject2).getDeclaredField("mEdgeGlowBottom");
        if (localObject4 != null)
        {
          ((Field)localObject4).setAccessible(true);
          ((Field)localObject4).set(this, localObject1);
        }
        if (localObject2 != null)
        {
          ((Field)localObject2).setAccessible(true);
          ((Field)localObject2).set(this, localObject3);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void disableEdgeGlow()
  {
    try
    {
      Object localObject2 = Class.forName("android.widget.AbsListView");
      if (localObject2 != null)
      {
        Object localObject3 = Class.forName("android.widget.EdgeGlow").getConstructor(new Class[] { Drawable.class, Drawable.class });
        Object localObject1 = ((Constructor)localObject3).newInstance(new Object[] { new ColorDrawable(17170445), new ColorDrawable(17170445) });
        localObject3 = ((Constructor)localObject3).newInstance(new Object[] { new ColorDrawable(17170445), new ColorDrawable(17170445) });
        Field localField = ((Class)localObject2).getDeclaredField("mEdgeGlowTop");
        localObject2 = ((Class)localObject2).getDeclaredField("mEdgeGlowBottom");
        if (localField != null)
        {
          localField.setAccessible(true);
          localField.set(this, localObject1);
        }
        if (localObject2 != null)
        {
          ((Field)localObject2).setAccessible(true);
          ((Field)localObject2).set(this, localObject3);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void initWithContext(Context paramContext)
  {
    this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
    super.setOnScrollListener(this);
    setCacheColorHint(0);
    disableEdgeEffect();
    disableEdgeGlow();
    this.mHeader = new XHeaderView(paramContext);
    this.mHeaderContent = ((RelativeLayout)this.mHeader.findViewById(2131625516));
    this.mHeaderTime = ((TextView)this.mHeader.findViewById(2131625519));
    addHeaderView(this.mHeader);
    this.mFooterView = new XFooterView(paramContext);
    this.mFooterLayout = new LinearLayout(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    paramContext.gravity = 17;
    this.mFooterLayout.addView(this.mFooterView, paramContext);
    paramContext = this.mHeader.getViewTreeObserver();
    if (paramContext != null) {
      paramContext.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        @TargetApi(16)
        public void onGlobalLayout()
        {
          XListView.access$002(XListView.this, XListView.this.mHeaderContent.getHeight());
          ViewTreeObserver localViewTreeObserver = XListView.this.getViewTreeObserver();
          if (localViewTreeObserver != null)
          {
            if (Build.VERSION.SDK_INT < 16) {
              localViewTreeObserver.removeGlobalOnLayoutListener(this);
            }
          }
          else {
            return;
          }
          localViewTreeObserver.removeOnGlobalLayoutListener(this);
        }
      });
    }
  }
  
  private void invokeOnScrolling()
  {
    if ((this.mScrollListener instanceof OnXScrollListener)) {
      ((OnXScrollListener)this.mScrollListener).onXScrolling(this);
    }
  }
  
  private void loadMore()
  {
    if ((this.mEnablePullLoad) && (this.mListener != null)) {
      this.mListener.onLoadMore();
    }
  }
  
  private void refresh()
  {
    if ((this.mEnablePullRefresh) && (this.mListener != null)) {
      this.mListener.onRefresh();
    }
  }
  
  private void resetFooterHeight()
  {
    int i = this.mFooterView.getBottomMargin();
    if (i > 0)
    {
      this.mScrollBack = 1;
      this.mScroller.startScroll(0, i, 0, -i, 400);
      invalidate();
    }
  }
  
  private void resetHeaderHeight()
  {
    int k = this.mHeader.getVisibleHeight();
    if (k == 0) {}
    while ((this.mPullRefreshing) && (k <= this.mHeaderHeight)) {
      return;
    }
    int j = 0;
    int i = j;
    if (this.mPullRefreshing)
    {
      i = j;
      if (k > this.mHeaderHeight) {
        i = this.mHeaderHeight;
      }
    }
    this.mScrollBack = 0;
    this.mScroller.startScroll(0, k, 0, i - k, 400);
    invalidate();
  }
  
  private void startLoadMore()
  {
    this.mPullLoading = true;
    this.mFooterView.setState(2);
    loadMore();
  }
  
  private void updateFooterHeight(float paramFloat)
  {
    int i = this.mFooterView.getBottomMargin() + (int)paramFloat;
    if ((this.mEnablePullLoad) && (!this.mPullLoading))
    {
      if (i <= 50) {
        break label48;
      }
      this.mFooterView.setState(1);
    }
    for (;;)
    {
      this.mFooterView.setBottomMargin(i);
      return;
      label48:
      this.mFooterView.setState(0);
    }
  }
  
  private void updateHeaderHeight(float paramFloat)
  {
    this.mHeader.setVisibleHeight((int)paramFloat + this.mHeader.getVisibleHeight());
    if ((this.mEnablePullRefresh) && (!this.mPullRefreshing))
    {
      if (this.mHeader.getVisibleHeight() <= this.mHeaderHeight) {
        break label59;
      }
      this.mHeader.setState(1);
    }
    for (;;)
    {
      setSelection(0);
      return;
      label59:
      this.mHeader.setState(0);
    }
  }
  
  public void autoRefresh()
  {
    this.mHeader.setVisibleHeight(this.mHeaderHeight);
    if ((this.mEnablePullRefresh) && (!this.mPullRefreshing))
    {
      if (this.mHeader.getVisibleHeight() <= this.mHeaderHeight) {
        break label65;
      }
      this.mHeader.setState(1);
    }
    for (;;)
    {
      this.mPullRefreshing = true;
      this.mHeader.setState(2);
      refresh();
      return;
      label65:
      this.mHeader.setState(0);
    }
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      if (this.mScrollBack != 0) {
        break label44;
      }
      this.mHeader.setVisibleHeight(this.mScroller.getCurrY());
    }
    for (;;)
    {
      postInvalidate();
      invokeOnScrolling();
      super.computeScroll();
      return;
      label44:
      this.mFooterView.setBottomMargin(this.mScroller.getCurrY());
    }
  }
  
  public XFooterView getXFooterView()
  {
    return this.mFooterView;
  }
  
  public XHeaderView getXHeaderView()
  {
    return this.mHeader;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTotalItemCount = paramInt3;
    if (this.mScrollListener != null) {
      this.mScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((paramInt == 0) && (this.mEnableAutoLoad) && (getLastVisiblePosition() == getCount() - 1)) {
      startLoadMore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLastY == -1.0F) {
      this.mLastY = paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      this.mLastY = -1.0F;
      if (getFirstVisiblePosition() == 0)
      {
        if ((this.mEnablePullRefresh) && (this.mHeader.getVisibleHeight() > this.mHeaderHeight))
        {
          this.mPullRefreshing = true;
          this.mHeader.setState(2);
          refresh();
        }
        resetHeaderHeight();
      }
      break;
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mLastY = paramMotionEvent.getRawY();
      continue;
      float f = paramMotionEvent.getRawY() - this.mLastY;
      this.mLastY = paramMotionEvent.getRawY();
      if ((getFirstVisiblePosition() == 0) && ((this.mHeader.getVisibleHeight() > 0) || (f > 0.0F)))
      {
        updateHeaderHeight(f / 1.8F);
        invokeOnScrolling();
      }
      else if ((getLastVisiblePosition() == this.mTotalItemCount - 1) && ((this.mFooterView.getBottomMargin() > 0) || (f < 0.0F)))
      {
        updateFooterHeight(-f / 1.8F);
        continue;
        if (getLastVisiblePosition() == this.mTotalItemCount - 1)
        {
          if ((this.mEnablePullLoad) && (this.mFooterView.getBottomMargin() > 50)) {
            startLoadMore();
          }
          resetFooterHeight();
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (!this.mIsFooterReady)
    {
      this.mIsFooterReady = true;
      addFooterView(this.mFooterLayout);
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setAutoLoadEnable(boolean paramBoolean)
  {
    this.mEnableAutoLoad = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setPullLoadEnable(boolean paramBoolean)
  {
    this.mEnablePullLoad = paramBoolean;
    if (!this.mEnablePullLoad)
    {
      this.mFooterView.setBottomMargin(0);
      this.mFooterView.hide();
      this.mFooterView.setPadding(0, 0, 0, this.mFooterView.getHeight() * -1);
      this.mFooterView.setOnClickListener(null);
      return;
    }
    this.mPullLoading = false;
    this.mFooterView.setPadding(0, 0, 0, 0);
    this.mFooterView.show();
    this.mFooterView.setState(0);
    this.mFooterView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        XListView.this.startLoadMore();
      }
    });
  }
  
  public void setPullLoadEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mEnablePullLoad = paramBoolean1;
    if (!this.mEnablePullLoad)
    {
      if (paramBoolean2)
      {
        this.mFooterView.setPadding(0, 0, 0, 0);
        this.mFooterView.show();
        this.mFooterView.setState(0);
      }
      for (;;)
      {
        this.mFooterView.setOnClickListener(null);
        return;
        this.mFooterView.setBottomMargin(0);
        this.mFooterView.hide();
        this.mFooterView.setPadding(0, 0, 0, this.mFooterView.getHeight() * -1);
      }
    }
    this.mPullLoading = false;
    this.mFooterView.setPadding(0, 0, 0, 0);
    this.mFooterView.show();
    this.mFooterView.setState(0);
    this.mFooterView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        XListView.this.startLoadMore();
      }
    });
  }
  
  public void setPullRefreshEnable(boolean paramBoolean)
  {
    this.mEnablePullRefresh = paramBoolean;
    RelativeLayout localRelativeLayout = this.mHeaderContent;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void setRefreshTime(String paramString)
  {
    this.mHeaderTime.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mFooterView != null) {
      this.mFooterView.setTextColor(paramInt);
    }
    if (this.mHeader != null) {
      this.mHeader.setTextColor(paramInt);
    }
  }
  
  public void setXFooterBgColor(int paramInt)
  {
    if (this.mFooterView != null) {
      this.mFooterView.setBackgroundColor(paramInt);
    }
  }
  
  public void setXFooterText(int paramInt)
  {
    if (this.mFooterView != null) {
      this.mFooterView.setText(paramInt);
    }
  }
  
  public void setXHeaderBgColor(int paramInt)
  {
    if (this.mHeader != null) {
      this.mHeader.setBackgroundColor(paramInt);
    }
  }
  
  public void setXListViewListener(IXListViewListener paramIXListViewListener)
  {
    this.mListener = paramIXListViewListener;
  }
  
  public void stopLoadMore()
  {
    if (this.mPullLoading)
    {
      this.mPullLoading = false;
      this.mFooterView.setState(0);
    }
  }
  
  public void stopRefresh()
  {
    if (this.mPullRefreshing)
    {
      this.mPullRefreshing = false;
      resetHeaderHeight();
    }
  }
  
  public static abstract interface IXListViewListener
  {
    public abstract void onLoadMore();
    
    public abstract void onRefresh();
  }
  
  public static abstract interface OnXScrollListener
    extends AbsListView.OnScrollListener
  {
    public abstract void onXScrolling(View paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/xpulltorefresh/XListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */