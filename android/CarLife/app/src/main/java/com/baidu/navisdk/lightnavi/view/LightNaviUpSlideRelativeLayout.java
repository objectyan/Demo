package com.baidu.navisdk.lightnavi.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class LightNaviUpSlideRelativeLayout
  extends RelativeLayout
{
  private Context mContext;
  private View mRoot;
  private int mScreenHeigh;
  private Scroller mScroller;
  private SlideListerner mSlideListerner = null;
  private Handler mhandler = new Handler(Looper.getMainLooper());
  private int originY = -1;
  private BNWorkerNormalTask<String, String> rootViewHandlerTask = new BNWorkerNormalTask("rootViewHandlerTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      LogUtil.e("wangyang", "rootViewHandlerRunable");
      LightNaviUpSlideRelativeLayout.this.mScroller.setFinalY(0);
      if (BNLightNaviManager.getInstance().getType() == 2) {
        LightNaviUpSlideRelativeLayout.this.mRoot.setVisibility(8);
      }
      for (;;)
      {
        return null;
        LightNaviUpSlideRelativeLayout.this.mRoot.setVisibility(0);
      }
    }
  };
  
  public LightNaviUpSlideRelativeLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mRoot = JarUtils.inflate((Activity)paramContext, 1711472682, this);
    paramContext = new BounceInterpolator();
    this.mScroller = new Scroller(this.mContext, paramContext);
    this.mScreenHeigh = ScreenUtil.getInstance().getHeightPixels();
    setClickable(true);
    setEnabled(true);
  }
  
  public LightNaviUpSlideRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mRoot = JarUtils.inflate((Activity)paramContext, 1711472682, this);
    paramContext = new BounceInterpolator();
    this.mScroller = new Scroller(this.mContext, paramContext);
    this.mScreenHeigh = ScreenUtil.getInstance().getHeightPixels();
    setClickable(true);
    setEnabled(true);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onDestory()
  {
    BNWorkerCenter.getInstance().cancelTask(this.rootViewHandlerTask, false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.originY = ((int)paramMotionEvent.getY());
    }
    for (;;)
    {
      return true;
      int i;
      if (paramMotionEvent.getAction() == 2)
      {
        i = (int)paramMotionEvent.getY();
        i = this.originY - i;
        if (i > 0) {
          scrollTo(0, i);
        }
      }
      else
      {
        i = (int)paramMotionEvent.getY();
        i = this.originY - i;
        if (i > 0) {
          if (Math.abs(i) > this.mScreenHeigh / 4)
          {
            if (this.mSlideListerner != null) {
              this.mSlideListerner.onDeblocking();
            }
            startBounceAnim(getScrollY(), this.mScreenHeigh, 1000);
            BNWorkerCenter.getInstance().cancelTask(this.rootViewHandlerTask, false);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.rootViewHandlerTask, new BNWorkerConfig(9, 0), 500L);
          }
          else
          {
            startBounceAnim(getScrollY(), -getScrollY(), 1000);
          }
        }
      }
    }
  }
  
  public void setSlideListerner(SlideListerner paramSlideListerner)
  {
    this.mSlideListerner = paramSlideListerner;
  }
  
  public void startBounceAnim(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mScroller.startScroll(0, paramInt1, 0, paramInt2, paramInt3);
    invalidate();
  }
  
  public static abstract interface SlideListerner
  {
    public abstract void onDeblocking();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/LightNaviUpSlideRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */