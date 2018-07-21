package com.baidu.navisdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.util.common.LogUtil;

public class CustomLinearScrollView
  extends LinearLayout
{
  public static final int STATUS_BOTTOM = 1;
  public static final int STATUS_TOP = 0;
  private static final String TAG = "CustomLinearScrollView";
  private int bottomHight = 0;
  private int button;
  private boolean hasMoveScroll = false;
  private boolean isBreakCallback = false;
  private boolean isScrolling;
  private EventCatchListener mEventCatchListener = null;
  private int mFirstInitStatus = 1;
  boolean mIsBeingDragged = false;
  public boolean mLastEventIsScroll = false;
  private int mLastY;
  private OnStatusChangeListener mOnStatusChangeListener;
  private int mScrollEnd;
  private int mScrollStart;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private boolean needScroll = false;
  private int status = 0;
  private boolean statusChange = false;
  private int topBoxHeight = 0;
  private int topHight;
  
  public CustomLinearScrollView(Context paramContext)
  {
    this(paramContext, null);
    initScroller(paramContext);
  }
  
  public CustomLinearScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initScroller(paramContext);
  }
  
  @TargetApi(11)
  public CustomLinearScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScroller(paramContext);
  }
  
  private int getVelocity()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.mVelocityTracker.getYVelocity();
  }
  
  private boolean gotoBottom(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.status == 1) || (this.mScroller == null) || (this.bottomHight == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("gotoBottom return : status=").append(this.status).append(" mScroller=");
      if (this.mScroller == null) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        LogUtil.e("CustomLinearScrollView", paramBoolean1 + " bottomHight = " + this.bottomHight);
        return false;
      }
    }
    LogUtil.e("CustomLinearScrollView", "gotoBottom showAnim:" + paramBoolean1 + " needCallback" + paramBoolean2);
    if (paramBoolean1)
    {
      this.mScroller.startScroll(0, getScrollY(), 0, -this.bottomHight);
      this.status = 1;
      this.statusChange = true;
      this.isScrolling = true;
      if (paramBoolean2) {
        break label207;
      }
    }
    label207:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.isBreakCallback = paramBoolean1;
      this.hasMoveScroll = true;
      this.mLastEventIsScroll = false;
      postInvalidate();
      return true;
      this.mScroller.startScroll(0, getScrollY(), 0, -this.bottomHight, 0);
      break;
    }
  }
  
  private boolean gotoTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.status == 0) {}
    while ((this.mScroller == null) || (this.bottomHight == 0)) {
      return false;
    }
    LogUtil.e("CustomLinearScrollView", "gotoTop showAnim:" + paramBoolean1 + " needCallback" + paramBoolean2);
    if (paramBoolean1)
    {
      this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight);
      this.status = 0;
      this.statusChange = true;
      this.isScrolling = true;
      if (paramBoolean2) {
        break label140;
      }
    }
    label140:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.isBreakCallback = paramBoolean1;
      this.hasMoveScroll = true;
      this.mLastEventIsScroll = false;
      postInvalidate();
      return true;
      this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight, 0);
      break;
    }
  }
  
  private void initScroller(Context paramContext)
  {
    this.mScroller = new Scroller(paramContext);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void obtainVelocity(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void recycleVelocity()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
      return;
    }
    LogUtil.e("CustomLinearScrollView", "computeScroll statusChange :" + this.statusChange);
    if (this.statusChange) {
      if (getScrollY() < -this.bottomHight / 2)
      {
        if ((this.mOnStatusChangeListener != null) && (!this.isBreakCallback))
        {
          this.mOnStatusChangeListener.onStatusChange(1);
          this.mOnStatusChangeListener.onProgressChange(100);
        }
        this.status = 1;
        LogUtil.e("CustomLinearScrollView", "STATUS_BOTTOM");
        this.statusChange = false;
        label131:
        this.isScrolling = false;
        if (this.status != 1) {
          break label358;
        }
        scrollTo(0, -this.bottomHight);
      }
    }
    for (;;)
    {
      this.isBreakCallback = false;
      return;
      if ((this.mOnStatusChangeListener != null) && (!this.isBreakCallback))
      {
        this.mOnStatusChangeListener.onStatusChange(0);
        this.mOnStatusChangeListener.onProgressChange(0);
      }
      this.status = 0;
      LogUtil.e("CustomLinearScrollView", "STATUS_TOP");
      break;
      if (this.mIsBeingDragged) {
        break label131;
      }
      if (getScrollY() < -this.bottomHight / 2)
      {
        if ((this.mOnStatusChangeListener != null) && (!this.isBreakCallback))
        {
          if (this.status != 1)
          {
            LogUtil.e("CustomLinearScrollView", "statusChange STATUS_BOTTOM");
            this.mOnStatusChangeListener.onStatusChange(1);
          }
          this.mOnStatusChangeListener.onProgressChange(100);
        }
        this.status = 1;
        LogUtil.e("CustomLinearScrollView", "STATUS_BOTTOM");
        break label131;
      }
      if ((this.mOnStatusChangeListener != null) && (!this.isBreakCallback))
      {
        if (this.status != 0)
        {
          LogUtil.e("CustomLinearScrollView", "statusChange STATUS_TOP");
          this.mOnStatusChangeListener.onStatusChange(0);
        }
        this.mOnStatusChangeListener.onProgressChange(0);
      }
      this.status = 0;
      LogUtil.e("CustomLinearScrollView", "STATUS_TOP");
      break label131;
      label358:
      scrollTo(0, 0);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    if (this.mEventCatchListener != null) {
      this.mEventCatchListener.onEventCatch(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getCurStatus()
  {
    if (this.bottomHight == 0) {
      return this.mFirstInitStatus;
    }
    return this.status;
  }
  
  public boolean gotoBottom()
  {
    return gotoBottom(true, true);
  }
  
  public boolean gotoTop()
  {
    return gotoTop(true, true);
  }
  
  public boolean isScrolling()
  {
    return this.isScrolling;
  }
  
  public boolean onInterceptHoverEvent(MotionEvent paramMotionEvent)
  {
    return this.mIsBeingDragged;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.needScroll) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i;
    do
    {
      return bool;
      i = paramMotionEvent.getAction();
    } while ((i == 2) && (this.mIsBeingDragged));
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (Math.abs((int)paramMotionEvent.getY() - this.mLastY) > this.mTouchSlop)
      {
        this.mIsBeingDragged = true;
        return true;
        this.mLastY = ((int)paramMotionEvent.getY());
        this.mScrollStart = getScrollY();
        if (this.mScrollStart < -this.bottomHight / 2) {
          this.status = 1;
        } else {
          this.status = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    for (;;)
    {
      try
      {
        this.bottomHight = findViewById(1711866681).getHeight();
        this.topBoxHeight = findViewById(1711866659).getHeight();
        View localView = findViewById(1711866658);
        if (localView == null) {
          continue;
        }
        this.button = localView.getHeight();
        this.topHight = (getHeight() - this.button);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.bottomHight = (getHeight() - this.topBoxHeight);
      if (this.mFirstInitStatus == 1) {
        gotoBottom(false, false);
      }
      return;
      this.button = 0;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.needScroll) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool;
      if (this.isScrolling)
      {
        super.onTouchEvent(paramMotionEvent);
        return true;
      }
      i = (int)paramMotionEvent.getY();
      int j = paramMotionEvent.getAction();
      obtainVelocity(paramMotionEvent);
      switch (j)
      {
      default: 
        return true;
      case 0: 
        if (this.status == 1)
        {
          if (i < this.bottomHight + this.button)
          {
            LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_DOWN return status_bottom getY:" + i);
            return false;
          }
        }
        else if (i < this.button)
        {
          LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_DOWN return status_top getY:" + i);
          return false;
        }
        LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_DOWN status " + this.status + "  " + this.mScrollStart + "  ");
        this.mIsBeingDragged = true;
        this.mLastY = i;
        return true;
      case 2: 
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        j = this.mLastY - i;
        int k = getScrollY();
        int m = (int)(k / this.bottomHight * 100.0F);
        if (this.mOnStatusChangeListener != null) {
          this.mOnStatusChangeListener.onProgressChange(Math.abs(m));
        }
        if ((j > 0) && (j + k > 0))
        {
          LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_MOVE break move1 dy:" + j + " scrollY:" + k);
          i = -k;
          return true;
        }
        if (-(k + j) > this.bottomHight)
        {
          LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_MOVE break move2 " + j + "  " + k);
          i = -j;
          return true;
        }
        scrollBy(0, j);
        this.mLastY = i;
        return true;
      }
    } while (!this.mIsBeingDragged);
    this.mIsBeingDragged = false;
    this.mScrollEnd = getScrollY();
    int i = this.mScrollEnd - this.mScrollStart;
    LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_UP " + this.mScrollEnd + "  " + this.mScrollStart + "  " + i);
    if (this.status == 0) {
      if (-(this.mScrollEnd - this.mScrollStart) > this.bottomHight / 3)
      {
        this.mScroller.startScroll(0, getScrollY(), 0, -(this.bottomHight + i));
        LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_UP 1");
        this.status = 1;
        this.statusChange = true;
        this.hasMoveScroll = true;
      }
    }
    for (;;)
    {
      this.isScrolling = true;
      this.mLastEventIsScroll = true;
      postInvalidate();
      recycleVelocity();
      return true;
      this.mScroller.startScroll(0, getScrollY(), 0, -i);
      this.hasMoveScroll = true;
      LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_UP 2");
      continue;
      if (this.mScrollEnd - this.mScrollStart > (this.topHight - this.bottomHight) / 3)
      {
        this.status = 0;
        this.statusChange = true;
        this.hasMoveScroll = true;
        this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight - i);
        LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_UP 3");
      }
      else
      {
        this.mScroller.startScroll(0, getScrollY(), 0, -i);
        this.hasMoveScroll = true;
        LogUtil.e("CustomLinearScrollView", "onTouchEvent ACTION_UP 4");
      }
    }
  }
  
  public void setInitScrollStatus(int paramInt)
  {
    this.mFirstInitStatus = paramInt;
  }
  
  public void setOnEventCatchListener(EventCatchListener paramEventCatchListener)
  {
    this.mEventCatchListener = paramEventCatchListener;
  }
  
  public void setOnStatusChangeListener(OnStatusChangeListener paramOnStatusChangeListener)
  {
    this.mOnStatusChangeListener = paramOnStatusChangeListener;
  }
  
  public void setScrollSupport(boolean paramBoolean) {}
  
  public static abstract interface EventCatchListener
  {
    public abstract void onEventCatch(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnStatusChangeListener
  {
    public abstract void onProgressChange(int paramInt);
    
    public abstract void onStatusChange(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/CustomLinearScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */