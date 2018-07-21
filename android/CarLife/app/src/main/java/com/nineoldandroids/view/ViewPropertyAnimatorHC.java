package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class ViewPropertyAnimatorHC
  extends ViewPropertyAnimator
{
  private static final int ALPHA = 512;
  private static final int NONE = 0;
  private static final int ROTATION = 16;
  private static final int ROTATION_X = 32;
  private static final int ROTATION_Y = 64;
  private static final int SCALE_X = 4;
  private static final int SCALE_Y = 8;
  private static final int TRANSFORM_MASK = 511;
  private static final int TRANSLATION_X = 1;
  private static final int TRANSLATION_Y = 2;
  private static final int X = 128;
  private static final int Y = 256;
  private Runnable mAnimationStarter = new Runnable()
  {
    public void run()
    {
      ViewPropertyAnimatorHC.this.startAnimation();
    }
  };
  private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener(null);
  private HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap();
  private long mDuration;
  private boolean mDurationSet = false;
  private Interpolator mInterpolator;
  private boolean mInterpolatorSet = false;
  private Animator.AnimatorListener mListener = null;
  ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList();
  private long mStartDelay = 0L;
  private boolean mStartDelaySet = false;
  private final WeakReference<View> mView;
  
  ViewPropertyAnimatorHC(View paramView)
  {
    this.mView = new WeakReference(paramView);
  }
  
  private void animateProperty(int paramInt, float paramFloat)
  {
    float f = getValue(paramInt);
    animatePropertyBy(paramInt, f, paramFloat - f);
  }
  
  private void animatePropertyBy(int paramInt, float paramFloat)
  {
    animatePropertyBy(paramInt, getValue(paramInt), paramFloat);
  }
  
  private void animatePropertyBy(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.mAnimatorMap.size() > 0)
    {
      Object localObject2 = null;
      Iterator localIterator = this.mAnimatorMap.keySet().iterator();
      PropertyBundle localPropertyBundle;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Animator)localIterator.next();
        localPropertyBundle = (PropertyBundle)this.mAnimatorMap.get(localObject1);
      } while ((!localPropertyBundle.cancel(paramInt)) || (localPropertyBundle.mPropertyMask != 0));
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
    }
    Object localObject1 = new NameValuesHolder(paramInt, paramFloat1, paramFloat2);
    this.mPendingAnimations.add(localObject1);
    localObject1 = (View)this.mView.get();
    if (localObject1 != null)
    {
      ((View)localObject1).removeCallbacks(this.mAnimationStarter);
      ((View)localObject1).post(this.mAnimationStarter);
    }
  }
  
  private float getValue(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 1: 
      return localView.getTranslationX();
    case 2: 
      return localView.getTranslationY();
    case 16: 
      return localView.getRotation();
    case 32: 
      return localView.getRotationX();
    case 64: 
      return localView.getRotationY();
    case 4: 
      return localView.getScaleX();
    case 8: 
      return localView.getScaleY();
    case 128: 
      return localView.getX();
    case 256: 
      return localView.getY();
    }
    return localView.getAlpha();
  }
  
  private void setValue(int paramInt, float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localView.setTranslationX(paramFloat);
      return;
    case 2: 
      localView.setTranslationY(paramFloat);
      return;
    case 16: 
      localView.setRotation(paramFloat);
      return;
    case 32: 
      localView.setRotationX(paramFloat);
      return;
    case 64: 
      localView.setRotationY(paramFloat);
      return;
    case 4: 
      localView.setScaleX(paramFloat);
      return;
    case 8: 
      localView.setScaleY(paramFloat);
      return;
    case 128: 
      localView.setX(paramFloat);
      return;
    case 256: 
      localView.setY(paramFloat);
      return;
    }
    localView.setAlpha(paramFloat);
  }
  
  private void startAnimation()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.mPendingAnimations.clone();
    this.mPendingAnimations.clear();
    int j = 0;
    int k = localArrayList.size();
    int i = 0;
    while (i < k)
    {
      j |= ((NameValuesHolder)localArrayList.get(i)).mNameConstant;
      i += 1;
    }
    this.mAnimatorMap.put(localValueAnimator, new PropertyBundle(j, localArrayList));
    localValueAnimator.addUpdateListener(this.mAnimatorEventListener);
    localValueAnimator.addListener(this.mAnimatorEventListener);
    if (this.mStartDelaySet) {
      localValueAnimator.setStartDelay(this.mStartDelay);
    }
    if (this.mDurationSet) {
      localValueAnimator.setDuration(this.mDuration);
    }
    if (this.mInterpolatorSet) {
      localValueAnimator.setInterpolator(this.mInterpolator);
    }
    localValueAnimator.start();
  }
  
  public ViewPropertyAnimator alpha(float paramFloat)
  {
    animateProperty(512, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator alphaBy(float paramFloat)
  {
    animatePropertyBy(512, paramFloat);
    return this;
  }
  
  public void cancel()
  {
    if (this.mAnimatorMap.size() > 0)
    {
      localObject = ((HashMap)this.mAnimatorMap.clone()).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Animator)((Iterator)localObject).next()).cancel();
      }
    }
    this.mPendingAnimations.clear();
    Object localObject = (View)this.mView.get();
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.mAnimationStarter);
    }
  }
  
  public long getDuration()
  {
    if (this.mDurationSet) {
      return this.mDuration;
    }
    return new ValueAnimator().getDuration();
  }
  
  public long getStartDelay()
  {
    if (this.mStartDelaySet) {
      return this.mStartDelay;
    }
    return 0L;
  }
  
  public ViewPropertyAnimator rotation(float paramFloat)
  {
    animateProperty(16, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationBy(float paramFloat)
  {
    animatePropertyBy(16, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationX(float paramFloat)
  {
    animateProperty(32, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    animatePropertyBy(32, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationY(float paramFloat)
  {
    animateProperty(64, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    animatePropertyBy(64, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleX(float paramFloat)
  {
    animateProperty(4, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    animatePropertyBy(4, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleY(float paramFloat)
  {
    animateProperty(8, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    animatePropertyBy(8, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator setDuration(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.mDurationSet = true;
    this.mDuration = paramLong;
    return this;
  }
  
  public ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolatorSet = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }
  
  public ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.mListener = paramAnimatorListener;
    return this;
  }
  
  public ViewPropertyAnimator setStartDelay(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.mStartDelaySet = true;
    this.mStartDelay = paramLong;
    return this;
  }
  
  public void start()
  {
    startAnimation();
  }
  
  public ViewPropertyAnimator translationX(float paramFloat)
  {
    animateProperty(1, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator translationXBy(float paramFloat)
  {
    animatePropertyBy(1, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator translationY(float paramFloat)
  {
    animateProperty(2, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator translationYBy(float paramFloat)
  {
    animatePropertyBy(2, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator x(float paramFloat)
  {
    animateProperty(128, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator xBy(float paramFloat)
  {
    animatePropertyBy(128, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator y(float paramFloat)
  {
    animateProperty(256, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator yBy(float paramFloat)
  {
    animatePropertyBy(256, paramFloat);
    return this;
  }
  
  private class AnimatorEventListener
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    private AnimatorEventListener() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (ViewPropertyAnimatorHC.this.mListener != null) {
        ViewPropertyAnimatorHC.this.mListener.onAnimationCancel(paramAnimator);
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (ViewPropertyAnimatorHC.this.mListener != null) {
        ViewPropertyAnimatorHC.this.mListener.onAnimationEnd(paramAnimator);
      }
      ViewPropertyAnimatorHC.this.mAnimatorMap.remove(paramAnimator);
      if (ViewPropertyAnimatorHC.this.mAnimatorMap.isEmpty()) {
        ViewPropertyAnimatorHC.access$202(ViewPropertyAnimatorHC.this, null);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (ViewPropertyAnimatorHC.this.mListener != null) {
        ViewPropertyAnimatorHC.this.mListener.onAnimationRepeat(paramAnimator);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (ViewPropertyAnimatorHC.this.mListener != null) {
        ViewPropertyAnimatorHC.this.mListener.onAnimationStart(paramAnimator);
      }
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f1 = paramValueAnimator.getAnimatedFraction();
      paramValueAnimator = (ViewPropertyAnimatorHC.PropertyBundle)ViewPropertyAnimatorHC.this.mAnimatorMap.get(paramValueAnimator);
      Object localObject;
      if ((paramValueAnimator.mPropertyMask & 0x1FF) != 0)
      {
        localObject = (View)ViewPropertyAnimatorHC.this.mView.get();
        if (localObject != null) {
          ((View)localObject).invalidate();
        }
      }
      paramValueAnimator = paramValueAnimator.mNameValuesHolder;
      if (paramValueAnimator != null)
      {
        int j = paramValueAnimator.size();
        int i = 0;
        while (i < j)
        {
          localObject = (ViewPropertyAnimatorHC.NameValuesHolder)paramValueAnimator.get(i);
          float f2 = ((ViewPropertyAnimatorHC.NameValuesHolder)localObject).mFromValue;
          float f3 = ((ViewPropertyAnimatorHC.NameValuesHolder)localObject).mDeltaValue;
          ViewPropertyAnimatorHC.this.setValue(((ViewPropertyAnimatorHC.NameValuesHolder)localObject).mNameConstant, f2 + f3 * f1);
          i += 1;
        }
      }
      paramValueAnimator = (View)ViewPropertyAnimatorHC.this.mView.get();
      if (paramValueAnimator != null) {
        paramValueAnimator.invalidate();
      }
    }
  }
  
  private static class NameValuesHolder
  {
    float mDeltaValue;
    float mFromValue;
    int mNameConstant;
    
    NameValuesHolder(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.mNameConstant = paramInt;
      this.mFromValue = paramFloat1;
      this.mDeltaValue = paramFloat2;
    }
  }
  
  private static class PropertyBundle
  {
    ArrayList<ViewPropertyAnimatorHC.NameValuesHolder> mNameValuesHolder;
    int mPropertyMask;
    
    PropertyBundle(int paramInt, ArrayList<ViewPropertyAnimatorHC.NameValuesHolder> paramArrayList)
    {
      this.mPropertyMask = paramInt;
      this.mNameValuesHolder = paramArrayList;
    }
    
    boolean cancel(int paramInt)
    {
      if (((this.mPropertyMask & paramInt) != 0) && (this.mNameValuesHolder != null))
      {
        int j = this.mNameValuesHolder.size();
        int i = 0;
        while (i < j)
        {
          if (((ViewPropertyAnimatorHC.NameValuesHolder)this.mNameValuesHolder.get(i)).mNameConstant == paramInt)
          {
            this.mNameValuesHolder.remove(i);
            this.mPropertyMask &= (paramInt ^ 0xFFFFFFFF);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/nineoldandroids/view/ViewPropertyAnimatorHC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */