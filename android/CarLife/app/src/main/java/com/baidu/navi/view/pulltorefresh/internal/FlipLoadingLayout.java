package com.baidu.navi.view.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Mode;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout
  extends LoadingLayout
{
  static final int FLIP_ANIMATION_DURATION = 150;
  private final Animation mResetRotateAnimation;
  private final Animation mRotateAnimation;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START) {}
    for (int i = 65356;; i = 180)
    {
      this.mRotateAnimation = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
      this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
      this.mRotateAnimation.setDuration(150L);
      this.mRotateAnimation.setFillAfter(true);
      this.mResetRotateAnimation = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
      this.mResetRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
      this.mResetRotateAnimation.setDuration(150L);
      this.mResetRotateAnimation.setFillAfter(true);
      return;
    }
  }
  
  private float getDrawableRotationAngle()
  {
    switch (this.mMode)
    {
    }
    do
    {
      return 0.0F;
      if (this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL) {
        return 90.0F;
      }
      return 180.0F;
    } while (this.mScrollDirection != PullToRefreshBase.Orientation.HORIZONTAL);
    return 270.0F;
  }
  
  protected int getDefaultDrawableResId()
  {
    return 2130839240;
  }
  
  protected void onLoadingDrawableSet(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      paramDrawable = this.mHeaderImage.getLayoutParams();
      int k = Math.max(i, j);
      paramDrawable.height = k;
      paramDrawable.width = k;
      this.mHeaderImage.requestLayout();
      this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((paramDrawable.width - j) / 2.0F, (paramDrawable.height - i) / 2.0F);
      localMatrix.postRotate(getDrawableRotationAngle(), paramDrawable.width / 2.0F, paramDrawable.height / 2.0F);
      this.mHeaderImage.setImageMatrix(localMatrix);
    }
  }
  
  protected void onPullImpl(float paramFloat) {}
  
  protected void pullToRefreshImpl()
  {
    if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
      this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
    }
  }
  
  protected void refreshingImpl()
  {
    this.mHeaderImage.clearAnimation();
    this.mHeaderImage.setVisibility(4);
    this.mHeaderProgress.setVisibility(0);
  }
  
  protected void releaseToRefreshImpl()
  {
    this.mHeaderImage.startAnimation(this.mRotateAnimation);
  }
  
  protected void resetImpl()
  {
    this.mHeaderImage.clearAnimation();
    this.mHeaderProgress.setVisibility(8);
    this.mHeaderImage.setVisibility(0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/internal/FlipLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */