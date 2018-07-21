package com.baidu.navisdk.module.ugc.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.util.common.LogUtil;

public class UgcCustomLinearScrollView
  extends LinearLayout
{
  public static final int status_bottom = 1;
  public static final int status_top = 0;
  int bottomHight = 0;
  int button;
  private boolean gotoFlag = false;
  boolean hasActionDown = false;
  boolean hasMoveScroll = false;
  private boolean isScrolling;
  private EventCatchListener mEventCatchListener = null;
  private int mLastY;
  private OnStatusChangeListener mOnStatusChangeListener;
  private int mScrollEnd;
  private int mScrollStart;
  private Scroller mScroller;
  private VelocityTracker mVelocityTracker;
  boolean needScroll = false;
  private boolean needStatusChange = false;
  int status = 0;
  boolean statusChange = false;
  int topHight;
  
  public UgcCustomLinearScrollView(Context paramContext)
  {
    this(paramContext, null);
    this.mScroller = new Scroller(paramContext);
  }
  
  public UgcCustomLinearScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mScroller = new Scroller(paramContext);
  }
  
  public UgcCustomLinearScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScroller = new Scroller(paramContext);
  }
  
  private int getVelocity()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.mVelocityTracker.getYVelocity();
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
    if (this.statusChange)
    {
      if (getScrollY() < -this.bottomHight / 2)
      {
        if ((this.mOnStatusChangeListener != null) && (!this.gotoFlag)) {
          this.mOnStatusChangeListener.onStatusChange(1);
        }
        this.status = 1;
        this.statusChange = false;
      }
    }
    else
    {
      this.isScrolling = false;
      if (this.hasMoveScroll)
      {
        if (this.status != 1) {
          break label171;
        }
        scrollTo(0, -this.bottomHight);
      }
    }
    for (;;)
    {
      this.hasMoveScroll = false;
      if (this.needStatusChange) {
        this.statusChange = true;
      }
      this.gotoFlag = false;
      return;
      if ((this.mOnStatusChangeListener != null) && (!this.gotoFlag)) {
        this.mOnStatusChangeListener.onStatusChange(0);
      }
      this.status = 0;
      break;
      label171:
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
    return this.status;
  }
  
  public boolean gotoBottom()
  {
    if (this.status == 1) {
      return false;
    }
    if (this.mScroller != null)
    {
      this.mScroller.startScroll(0, getScrollY(), 0, -this.bottomHight);
      this.statusChange = true;
      this.isScrolling = true;
      this.gotoFlag = true;
      this.hasMoveScroll = true;
      postInvalidate();
    }
    return true;
  }
  
  public boolean gotoTop()
  {
    if (this.status == 0) {
      return false;
    }
    if (this.mScroller != null)
    {
      this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight);
      this.statusChange = true;
      this.isScrolling = true;
      this.gotoFlag = true;
      this.hasMoveScroll = true;
      postInvalidate();
    }
    return true;
  }
  
  public boolean onInterceptHoverEvent(MotionEvent paramMotionEvent)
  {
    return this.hasActionDown;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.bottomHight == 0) {}
    try
    {
      this.bottomHight = findViewById(1711866994).getHeight();
      this.button = findViewById(1711866985).getHeight();
      this.topHight = (getHeight() - this.button);
      LogUtil.e("UgcCustomLinearScrollView: onLayout", " bottomHight:" + this.bottomHight + " button:" + this.button + "topHight: " + this.topHight);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.needScroll) {
      super.onTouchEvent(paramMotionEvent);
    }
    label190:
    do
    {
      return true;
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
        this.mScrollStart = getScrollY();
        if (this.mScrollStart < -this.bottomHight / 2) {}
        for (this.status = 1; this.status == 1; this.status = 0)
        {
          if (i >= this.bottomHight + this.button) {
            break label190;
          }
          LogUtil.e("UgcCustomLinearScrollView: return status_bottom", " " + i);
          return false;
        }
        if (i < this.button)
        {
          LogUtil.e("UgcCustomLinearScrollView: return status_top", " " + i);
          return false;
        }
        LogUtil.e("UgcCustomLinearScrollView: ACTION_DOWN ", " " + this.status + "  " + this.mScrollStart + "  ");
        this.hasActionDown = true;
        this.mLastY = i;
        return true;
      case 2: 
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        j = this.mLastY - i;
        int k = getScrollY();
        if ((j > 0) && (j + k > 0))
        {
          LogUtil.e("UgcCustomLinearScrollView: break move1", " " + j + "  " + k);
          i = -k;
          return true;
        }
        if (-(k + j) > this.bottomHight)
        {
          LogUtil.e("UgcCustomLinearScrollView: break move2", " " + j + "  " + k);
          i = -j;
          return true;
        }
        scrollBy(0, j);
        this.mLastY = i;
        return true;
      }
    } while (!this.hasActionDown);
    this.hasActionDown = false;
    this.mScrollEnd = getScrollY();
    int i = this.mScrollEnd - this.mScrollStart;
    LogUtil.e("UgcCustomLinearScrollView: ACTION_UP ", " " + this.mScrollEnd + "  " + this.mScrollStart + "  " + i);
    if (this.status == 0) {
      if (-(this.mScrollEnd - this.mScrollStart) > this.bottomHight / 3)
      {
        this.mScroller.startScroll(0, getScrollY(), 0, -(this.bottomHight + i));
        LogUtil.e("UgcCustomLinearScrollView: up ", " 1");
        this.status = 1;
        this.statusChange = true;
        this.hasMoveScroll = true;
      }
    }
    for (;;)
    {
      this.isScrolling = true;
      postInvalidate();
      recycleVelocity();
      return true;
      this.mScroller.startScroll(0, getScrollY(), 0, -i);
      this.hasMoveScroll = true;
      LogUtil.e("UgcCustomLinearScrollView: up ", " 2");
      continue;
      if (this.mScrollEnd - this.mScrollStart > (this.topHight - this.bottomHight) / 3)
      {
        this.status = 0;
        this.statusChange = true;
        this.hasMoveScroll = true;
        this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight - i);
        LogUtil.e("UgcCustomLinearScrollView: up ", " 3");
      }
      else
      {
        this.mScroller.startScroll(0, getScrollY(), 0, -i);
        this.hasMoveScroll = true;
        LogUtil.e("UgcCustomLinearScrollView: up ", " 4");
      }
    }
  }
  
  public void setNeedStatusChange(boolean paramBoolean)
  {
    this.needStatusChange = paramBoolean;
  }
  
  public void setOnEventCatchListener(EventCatchListener paramEventCatchListener)
  {
    this.mEventCatchListener = paramEventCatchListener;
  }
  
  public void setOnStatusChangeListener(OnStatusChangeListener paramOnStatusChangeListener)
  {
    this.mOnStatusChangeListener = paramOnStatusChangeListener;
  }
  
  public void setScrollSupport(boolean paramBoolean)
  {
    this.needScroll = paramBoolean;
  }
  
  public static abstract interface EventCatchListener
  {
    public abstract void onEventCatch(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnStatusChangeListener
  {
    public abstract void onStatusChange(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/widget/UgcCustomLinearScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */