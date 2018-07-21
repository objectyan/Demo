package com.baidu.navi.view.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Mode;

@SuppressLint({"ViewConstructor"})
public class IndicatorLayout
  extends FrameLayout
  implements Animation.AnimationListener
{
  static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
  private ImageView mArrowImageView;
  private Animation mInAnim;
  private Animation mOutAnim;
  private final Animation mResetRotateAnimation;
  private final Animation mRotateAnimation;
  
  public IndicatorLayout(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.mArrowImageView = new ImageView(paramContext);
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839242);
    this.mArrowImageView.setImageDrawable(localDrawable);
    int i = paramContext.getResources().getDimensionPixelSize(2131362070);
    this.mArrowImageView.setPadding(i, i, i, i);
    addView(this.mArrowImageView);
    int j;
    switch (paramMode)
    {
    default: 
      i = 2131034137;
      j = 2131034139;
      setBackgroundResource(2130839244);
    }
    for (;;)
    {
      this.mInAnim = AnimationUtils.loadAnimation(paramContext, i);
      this.mInAnim.setAnimationListener(this);
      this.mOutAnim = AnimationUtils.loadAnimation(paramContext, j);
      this.mOutAnim.setAnimationListener(this);
      paramContext = new LinearInterpolator();
      this.mRotateAnimation = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
      this.mRotateAnimation.setInterpolator(paramContext);
      this.mRotateAnimation.setDuration(150L);
      this.mRotateAnimation.setFillAfter(true);
      this.mResetRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.mResetRotateAnimation.setInterpolator(paramContext);
      this.mResetRotateAnimation.setDuration(150L);
      this.mResetRotateAnimation.setFillAfter(true);
      return;
      i = 2131034136;
      j = 2131034138;
      setBackgroundResource(2130839243);
      this.mArrowImageView.setScaleType(ImageView.ScaleType.MATRIX);
      paramMode = new Matrix();
      paramMode.setRotate(180.0F, localDrawable.getIntrinsicWidth() / 2.0F, localDrawable.getIntrinsicHeight() / 2.0F);
      this.mArrowImageView.setImageMatrix(paramMode);
    }
  }
  
  public void hide()
  {
    startAnimation(this.mOutAnim);
  }
  
  public final boolean isVisible()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null) {
      if (this.mInAnim != localAnimation) {}
    }
    while (getVisibility() == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.mOutAnim)
    {
      this.mArrowImageView.clearAnimation();
      setVisibility(8);
    }
    for (;;)
    {
      clearAnimation();
      return;
      if (paramAnimation == this.mInAnim) {
        setVisibility(0);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
  
  public void pullToRefresh()
  {
    this.mArrowImageView.startAnimation(this.mResetRotateAnimation);
  }
  
  public void releaseToRefresh()
  {
    this.mArrowImageView.startAnimation(this.mRotateAnimation);
  }
  
  public void show()
  {
    this.mArrowImageView.clearAnimation();
    startAnimation(this.mInAnim);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/internal/IndicatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */