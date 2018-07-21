package com.baidu.navi.view.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.navi.view.pulltorefresh.ILoadingLayout;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Mode;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout
  extends FrameLayout
  implements ILoadingLayout
{
  static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
  static final String LOG_TAG = "PullToRefresh-LoadingLayout";
  protected final ImageView mHeaderImage;
  protected final ProgressBar mHeaderProgress;
  private final TextView mHeaderText;
  private FrameLayout mInnerLayout;
  protected final PullToRefreshBase.Mode mMode;
  private CharSequence mPullLabel;
  private CharSequence mRefreshingLabel;
  private CharSequence mReleaseLabel;
  protected final PullToRefreshBase.Orientation mScrollDirection;
  private final TextView mSubHeaderText;
  private boolean mUseIntrinsicAnimation;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.mMode = paramMode;
    this.mScrollDirection = paramOrientation;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    switch (1.$SwitchMap$com$baidu$navi$view$pulltorefresh$PullToRefreshBase$Orientation[paramOrientation.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(2130968979, this);
      this.mInnerLayout = ((FrameLayout)findViewById(2131625957));
      this.mHeaderText = ((TextView)this.mInnerLayout.findViewById(2131625960));
      this.mHeaderProgress = ((ProgressBar)this.mInnerLayout.findViewById(2131625959));
      this.mSubHeaderText = ((TextView)this.mInnerLayout.findViewById(2131625961));
      this.mHeaderImage = ((ImageView)this.mInnerLayout.findViewById(2131625958));
      localLayoutParams = (FrameLayout.LayoutParams)this.mInnerLayout.getLayoutParams();
      switch (paramMode)
      {
      default: 
        if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL)
        {
          i = 80;
          label179:
          localLayoutParams.gravity = i;
          this.mPullLabel = paramContext.getResources().getString(2131296816);
          this.mRefreshingLabel = paramContext.getResources().getString(2131296817);
          this.mReleaseLabel = paramContext.getResources().getString(2131296818);
          if (paramTypedArray.hasValue(3))
          {
            paramOrientation = paramTypedArray.getDrawable(3);
            if (paramOrientation != null) {
              ViewCompat.setBackground(this, paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(12))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(12, paramOrientation);
            setTextAppearance(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(13))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(13, paramOrientation);
            setSubTextAppearance(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(4))
          {
            paramOrientation = paramTypedArray.getColorStateList(4);
            if (paramOrientation != null) {
              setTextColor(paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(5))
          {
            paramOrientation = paramTypedArray.getColorStateList(5);
            if (paramOrientation != null) {
              setSubTextColor(paramOrientation);
            }
          }
          paramOrientation = null;
          if (paramTypedArray.hasValue(8)) {
            paramOrientation = paramTypedArray.getDrawable(8);
          }
          switch (paramMode)
          {
          default: 
            if (paramTypedArray.hasValue(9)) {
              paramMode = paramTypedArray.getDrawable(9);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramOrientation = paramMode;
      if (paramMode == null) {
        paramOrientation = paramContext.getResources().getDrawable(getDefaultDrawableResId());
      }
      setLoadingDrawable(paramOrientation);
      reset();
      return;
      LayoutInflater.from(paramContext).inflate(2130968978, this);
      break;
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {}
      for (i = 48;; i = 3)
      {
        localLayoutParams.gravity = i;
        this.mPullLabel = paramContext.getResources().getString(2131296813);
        this.mRefreshingLabel = paramContext.getResources().getString(2131296814);
        this.mReleaseLabel = paramContext.getResources().getString(2131296815);
        break;
      }
      i = 5;
      break label179;
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(19))
      {
        Utils.warnDeprecation("ptrDrawableTop", "ptrDrawableStart");
        paramMode = paramTypedArray.getDrawable(19);
        continue;
        if (paramTypedArray.hasValue(10))
        {
          paramMode = paramTypedArray.getDrawable(10);
        }
        else
        {
          paramMode = paramOrientation;
          if (paramTypedArray.hasValue(20))
          {
            Utils.warnDeprecation("ptrDrawableBottom", "ptrDrawableEnd");
            paramMode = paramTypedArray.getDrawable(20);
          }
        }
      }
    }
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    if (this.mSubHeaderText != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        this.mSubHeaderText.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.mSubHeaderText.setText(paramCharSequence);
    this.mSubHeaderText.setVisibility(0);
  }
  
  private void setSubTextAppearance(int paramInt)
  {
    if (this.mSubHeaderText != null) {
      this.mSubHeaderText.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    if (this.mSubHeaderText != null) {
      this.mSubHeaderText.setTextColor(paramColorStateList);
    }
  }
  
  private void setTextAppearance(int paramInt)
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setTextAppearance(getContext(), paramInt);
    }
    if (this.mSubHeaderText != null) {
      this.mSubHeaderText.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setTextColor(paramColorStateList);
    }
    if (this.mSubHeaderText != null) {
      this.mSubHeaderText.setTextColor(paramColorStateList);
    }
  }
  
  public final int getContentSize()
  {
    switch (1.$SwitchMap$com$baidu$navi$view$pulltorefresh$PullToRefreshBase$Orientation[this.mScrollDirection.ordinal()])
    {
    default: 
      return this.mInnerLayout.getHeight();
    }
    return this.mInnerLayout.getWidth();
  }
  
  protected abstract int getDefaultDrawableResId();
  
  public final void hideAllViews()
  {
    if ((this.mHeaderText != null) && (this.mHeaderText.getVisibility() == 0)) {
      this.mHeaderText.setVisibility(4);
    }
    if (this.mHeaderProgress.getVisibility() == 0) {
      this.mHeaderProgress.setVisibility(4);
    }
    if (this.mHeaderImage.getVisibility() == 0) {
      this.mHeaderImage.setVisibility(4);
    }
    if ((this.mSubHeaderText != null) && (this.mSubHeaderText.getVisibility() == 0)) {
      this.mSubHeaderText.setVisibility(4);
    }
  }
  
  protected abstract void onLoadingDrawableSet(Drawable paramDrawable);
  
  public final void onPull(float paramFloat)
  {
    if (!this.mUseIntrinsicAnimation) {
      onPullImpl(paramFloat);
    }
  }
  
  protected abstract void onPullImpl(float paramFloat);
  
  public final void pullToRefresh()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mPullLabel);
    }
    pullToRefreshImpl();
  }
  
  protected abstract void pullToRefreshImpl();
  
  public final void refreshing()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mRefreshingLabel);
    }
    if (this.mUseIntrinsicAnimation) {
      ((AnimationDrawable)this.mHeaderImage.getDrawable()).start();
    }
    for (;;)
    {
      if (this.mSubHeaderText != null) {
        this.mSubHeaderText.setVisibility(8);
      }
      return;
      refreshingImpl();
    }
  }
  
  protected abstract void refreshingImpl();
  
  public final void releaseToRefresh()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mReleaseLabel);
    }
    releaseToRefreshImpl();
  }
  
  protected abstract void releaseToRefreshImpl();
  
  public final void reset()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mPullLabel);
    }
    if (this.mUseIntrinsicAnimation) {
      ((AnimationDrawable)this.mHeaderImage.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.mSubHeaderText != null)
      {
        if (!TextUtils.isEmpty(this.mSubHeaderText.getText())) {
          break;
        }
        this.mSubHeaderText.setVisibility(8);
      }
      return;
      resetImpl();
    }
    this.mSubHeaderText.setVisibility(0);
  }
  
  protected abstract void resetImpl();
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.mHeaderImage.setImageDrawable(paramDrawable);
    this.mUseIntrinsicAnimation = (paramDrawable instanceof AnimationDrawable);
    onLoadingDrawableSet(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.mPullLabel = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.mRefreshingLabel = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.mReleaseLabel = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.mHeaderText.setTypeface(paramTypeface);
  }
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
  
  public final void showInvisibleViews()
  {
    if (4 == this.mHeaderText.getVisibility()) {
      this.mHeaderText.setVisibility(0);
    }
    if (4 == this.mHeaderProgress.getVisibility()) {
      this.mHeaderProgress.setVisibility(0);
    }
    if (4 == this.mHeaderImage.getVisibility()) {
      this.mHeaderImage.setVisibility(0);
    }
    if (4 == this.mSubHeaderText.getVisibility()) {
      this.mSubHeaderText.setVisibility(0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/pulltorefresh/internal/LoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */