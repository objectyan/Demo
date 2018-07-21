package com.baidu.navi.view.draglistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.LogUtil;

public class DragListView
  extends ListView
{
  private static final int ANIMATION_DURATION = 200;
  public static final int MSG_DRAG_MOVE = 4098;
  public static final int MSG_DRAG_STOP = 4097;
  private static final String TAG = "test";
  private static final int TOUCH_TAP = 20;
  private static final int step = 1;
  private boolean bHasGetSapcing = false;
  private int clickCount;
  private int currentStep;
  private int downScrollBounce;
  private ImageView dragImageView;
  private int dragOffset;
  private int dragPoint;
  private int dragPosition;
  DragType dragType = DragType.ITEM_CLICK;
  private int holdPosition;
  private boolean isDragEnable;
  private boolean isLock;
  private boolean isMove;
  private boolean isRelease;
  private boolean isSameDragDirection = true;
  private int lastDownX;
  private int lastDownY;
  private int lastFlag = -1;
  private int lastPosition;
  Runnable longClickRunnable = new Runnable()
  {
    public void run()
    {
      DragListView.access$010(DragListView.this);
      if ((DragListView.this.clickCount > 0) || (DragListView.this.isRelease) || (DragListView.this.isMove)) {
        return;
      }
      DragListView.access$302(DragListView.this, true);
      DragListView.this.performDragEvent(DragListView.this.lastDownX, DragListView.this.lastDownY, DragListView.this.offsetY);
    }
  };
  private Context mContext;
  Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4097: 
        DragListView.this.stopDrag();
        DragListView.this.onDrop(paramAnonymousMessage.arg1);
        return;
      }
      DragListView.this.onDrag(paramAnonymousMessage.arg1);
    }
  };
  private boolean mIsOccpy;
  private int mItemVerticalSpacing = 0;
  private int offsetY;
  private int startPosition;
  Rect touchFrame;
  private int unableDragEndCount = 0;
  private int unableDragStartCount = 0;
  private int upScrollBounce;
  private WindowManager windowManager;
  private WindowManager.LayoutParams windowParams;
  
  public DragListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
    this.mIsOccpy = false;
  }
  
  private void getSpacing()
  {
    this.bHasGetSapcing = true;
    this.upScrollBounce = (getHeight() / 3);
    this.downScrollBounce = (getHeight() * 2 / 3);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    int i = getFirstVisiblePosition();
    ViewGroup localViewGroup1 = (ViewGroup)getChildAt(i + 0);
    ViewGroup localViewGroup2 = (ViewGroup)getChildAt(i + 1);
    if (localViewGroup1 != null)
    {
      localViewGroup1.getLocationOnScreen(arrayOfInt1);
      if (localViewGroup2 != null)
      {
        localViewGroup2.getLocationOnScreen(arrayOfInt2);
        this.mItemVerticalSpacing = Math.abs(arrayOfInt2[1] - arrayOfInt1[1]);
      }
    }
  }
  
  private int getUnableDragEndCount()
  {
    return this.unableDragEndCount + getFooterViewsCount();
  }
  
  private int getUnableDragStartCount()
  {
    return this.unableDragStartCount + getFirstVisiblePosition();
  }
  
  private ListAdapter getWrappedAdapter()
  {
    ListAdapter localListAdapter2 = getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if (localListAdapter2 != null)
    {
      localListAdapter1 = localListAdapter2;
      if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
        localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
      }
    }
    return localListAdapter1;
  }
  
  private void init()
  {
    this.dragType = DragType.ITEM_CLICK;
    this.windowManager = ((WindowManager)getContext().getSystemService("window"));
  }
  
  private boolean isDragPositionValid(int paramInt)
  {
    int i = getAdapter().getCount();
    return (paramInt != -1) && (paramInt + 1 > getUnableDragStartCount()) && (i - paramInt > getUnableDragEndCount());
  }
  
  private void onChangeCopy(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = getWrappedAdapter();
    if ((paramInt1 != paramInt2) && ((localListAdapter instanceof OnDragAdapterListener))) {
      ((OnDragAdapterListener)localListAdapter).onExchange(paramInt1 - getFirstVisiblePosition(), paramInt2 - getFirstVisiblePosition());
    }
  }
  
  private void onDrop(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = getWrappedAdapter();
    if ((localListAdapter instanceof OnDragAdapterListener)) {
      ((BaseAdapter)localListAdapter).notifyDataSetChanged();
    }
  }
  
  private void performDragEvent(int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("test", "performDragEvent()......................enter");
    paramInt1 = pointToPosition(paramInt1, paramInt2);
    this.dragPosition = paramInt1;
    this.startPosition = paramInt1;
    this.lastPosition = paramInt1;
    if (!isDragPositionValid(this.dragPosition)) {
      this.isDragEnable = false;
    }
    if (!this.bHasGetSapcing) {
      getSpacing();
    }
    ViewGroup localViewGroup = (ViewGroup)getChildAt(this.dragPosition - getFirstVisiblePosition());
    this.dragPoint = (paramInt2 - localViewGroup.getTop());
    this.dragOffset = paramInt3;
    Object localObject = new int[2];
    localViewGroup.getLocationOnScreen((int[])localObject);
    paramInt1 = localObject[0];
    localViewGroup.destroyDrawingCache();
    localViewGroup.setDrawingCacheEnabled(true);
    if (localViewGroup.getBackground() != null) {
      localViewGroup.getBackground().setAlpha(80);
    }
    localObject = Bitmap.createBitmap(localViewGroup.getDrawingCache(true));
    localViewGroup.setVisibility(4);
    startDrag((Bitmap)localObject, paramInt1 - 10, paramInt2);
  }
  
  private void startDrag(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.windowParams = new WindowManager.LayoutParams();
    this.windowParams.gravity = 48;
    this.windowParams.x = paramInt1;
    this.windowParams.y = (paramInt2 - this.dragPoint + this.dragOffset);
    this.windowParams.width = -2;
    this.windowParams.height = -2;
    this.windowParams.flags = 408;
    this.windowParams.windowAnimations = 0;
    this.windowParams.alpha = 0.8F;
    this.windowParams.format = -3;
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    this.windowManager.addView(localImageView, this.windowParams);
    this.dragImageView = localImageView;
  }
  
  private void testAnimation(int paramInt)
  {
    int j = pointToPosition(0, paramInt);
    if (j == 0) {
      LogUtil.e("test", "0");
    }
    if ((!isDragPositionValid(j)) || (j == this.lastPosition)) {
      return;
    }
    LogUtil.e("test", "Before:position valid");
    this.dragPosition = j;
    LogUtil.e("test", "Before:lastPosition=" + this.lastPosition + ", dragPosition=" + this.dragPosition);
    onChangeCopy(this.lastPosition, this.dragPosition);
    int k = j - this.lastPosition;
    int m = Math.abs(k);
    paramInt = 1;
    if (paramInt <= m)
    {
      label148:
      label165:
      int i;
      ViewGroup localViewGroup;
      if (k > 0) {
        if (this.lastFlag == -1)
        {
          this.lastFlag = 0;
          this.isSameDragDirection = true;
          if (!this.isSameDragDirection) {
            break label266;
          }
          this.holdPosition = (this.lastPosition + 1);
          i = -this.mItemVerticalSpacing;
          this.lastPosition += 1;
          localViewGroup = (ViewGroup)getChildAt(this.holdPosition - getFirstVisiblePosition());
          if (!this.isSameDragDirection) {
            break label461;
          }
        }
      }
      label266:
      label360:
      label407:
      label461:
      for (Animation localAnimation = getFromSelfAnimation(0, i);; localAnimation = getToSelfAnimation(0, -i))
      {
        localViewGroup.startAnimation(localAnimation);
        paramInt += 1;
        break;
        if (this.lastFlag != 1) {
          break label148;
        }
        this.lastFlag = 0;
        if (!this.isSameDragDirection) {}
        for (boolean bool = true;; bool = false)
        {
          this.isSameDragDirection = bool;
          break;
        }
        if (this.startPosition < j)
        {
          this.holdPosition = (this.lastPosition + 1);
          if (!this.isSameDragDirection) {}
          for (bool = true;; bool = false)
          {
            this.isSameDragDirection = bool;
            break;
          }
        }
        this.holdPosition = this.lastPosition;
        break label165;
        if (this.lastFlag == -1)
        {
          this.lastFlag = 1;
          this.isSameDragDirection = true;
        }
        if (this.lastFlag == 0)
        {
          this.lastFlag = 1;
          if (!this.isSameDragDirection)
          {
            bool = true;
            this.isSameDragDirection = bool;
          }
        }
        else
        {
          if (!this.isSameDragDirection) {
            break label407;
          }
          this.holdPosition = (this.lastPosition - 1);
        }
        for (;;)
        {
          i = this.mItemVerticalSpacing;
          this.lastPosition -= 1;
          break;
          bool = false;
          break label360;
          if (this.startPosition > j)
          {
            this.holdPosition = (this.lastPosition - 1);
            if (!this.isSameDragDirection) {}
            for (bool = true;; bool = false)
            {
              this.isSameDragDirection = bool;
              break;
            }
          }
          this.holdPosition = this.lastPosition;
        }
      }
    }
    Log.d("test", "After:lastPosition=" + this.lastPosition + ", dragPosition=" + this.dragPosition);
  }
  
  public boolean checkDragListIsOccpuy()
  {
    return this.mIsOccpy;
  }
  
  public void doScroller(int paramInt)
  {
    if (paramInt < this.upScrollBounce) {
      this.currentStep = ((this.upScrollBounce - paramInt) / 10 + 1);
    }
    for (;;)
    {
      View localView = getChildAt(this.dragPosition - getFirstVisiblePosition());
      setSelectionFromTop(this.dragPosition, localView.getTop() + this.currentStep);
      return;
      if (paramInt > this.downScrollBounce) {
        this.currentStep = (-(paramInt - this.downScrollBounce + 1) / 10);
      } else {
        this.currentStep = 0;
      }
    }
  }
  
  public Animation getFromSelfAnimation(int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 0, paramInt1, 1, 0.0F, 0, paramInt2);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    return localTranslateAnimation;
  }
  
  public Animation getScaleAnimation()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.0F, 0.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setFillAfter(true);
    return localScaleAnimation;
  }
  
  public Animation getToSelfAnimation(int paramInt1, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, paramInt1, 1, 0.0F, 0, paramInt2, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    return localTranslateAnimation;
  }
  
  public void onDrag(int paramInt)
  {
    int i = this.dragPoint;
    if ((this.dragImageView != null) && (paramInt - i >= 0))
    {
      this.windowParams.alpha = 1.0F;
      this.windowParams.y = (paramInt - this.dragPoint + this.dragOffset);
      this.windowManager.updateViewLayout(this.dragImageView, this.windowParams);
    }
    doScroller(paramInt);
  }
  
  public void onDrop(int paramInt)
  {
    onDrop(0, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      this.mIsOccpy = false;
      stopDrag();
    }
    while ((this.isDragEnable) && (this.dragImageView != null) && (isDragPositionValid(this.dragPosition)))
    {
      return true;
      if ((this.isDragEnable) && (this.dragImageView != null) && (isDragPositionValid(this.dragPosition)))
      {
        i = (int)paramMotionEvent.getY();
        stopDrag();
        onDrop(i);
      }
      for (;;)
      {
        this.mIsOccpy = false;
        break;
        this.isRelease = true;
      }
      int i = (int)paramMotionEvent.getY();
      if ((this.isMove) && (this.isDragEnable) && (this.dragImageView != null) && (isDragPositionValid(this.dragPosition)))
      {
        if (isDragPositionValid(pointToPosition(0, i)))
        {
          onDrag(i);
          testAnimation(i);
        }
      }
      else if ((Math.abs(this.lastDownX - paramMotionEvent.getX()) > 20.0F) || (Math.abs(this.lastDownY - paramMotionEvent.getY()) > 20.0F))
      {
        this.isMove = true;
        continue;
        this.lastDownX = ((int)paramMotionEvent.getX());
        this.lastDownY = ((int)paramMotionEvent.getY());
        i = (int)paramMotionEvent.getRawX();
        if (isDragPositionValid(pointToPosition(this.lastDownX, this.lastDownY)))
        {
          this.offsetY = ((int)(paramMotionEvent.getRawY() - this.lastDownY));
          this.isMove = false;
          this.isRelease = false;
          if (this.dragType == DragType.LONG_CLICK)
          {
            this.isDragEnable = false;
            this.clickCount += 1;
            postDelayed(this.longClickRunnable, ViewConfiguration.getLongPressTimeout());
          }
          else
          {
            View localView = findViewById(2131624592);
            int[] arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            if ((i > arrayOfInt[0] - 20) && (i < arrayOfInt[0] + localView.getWidth() + 20))
            {
              this.mIsOccpy = true;
              this.isDragEnable = true;
              performDragEvent(this.lastDownX, this.lastDownY, this.offsetY);
              StatisticManager.onEvent("410170", "410170");
            }
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Rect localRect2 = this.touchFrame;
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      this.touchFrame = new Rect();
      localRect1 = this.touchFrame;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).getHitRect(localRect1);
      if (localRect1.contains(paramInt1, paramInt2)) {
        return getFirstVisiblePosition() + i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public void setLock(boolean paramBoolean)
  {
    this.isLock = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    stopDrag();
    super.setVisibility(paramInt);
  }
  
  public void stopDrag()
  {
    if (this.dragImageView != null)
    {
      this.windowManager.removeView(this.dragImageView);
      this.dragImageView = null;
    }
    this.isSameDragDirection = true;
    this.lastFlag = -1;
    ListAdapter localListAdapter = getWrappedAdapter();
    if ((localListAdapter instanceof BaseAdapter)) {
      ((BaseAdapter)localListAdapter).notifyDataSetChanged();
    }
  }
  
  static enum DragType
  {
    ITEM_CLICK,  LONG_CLICK;
    
    private DragType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/draglistview/DragListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */