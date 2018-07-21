package com.baidu.navisdk.ui.routeguide.subview.util;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RGAnimUtil
{
  private static IAnimationLister mAnimationListener;
  
  public static void applyRotation(ViewGroup paramViewGroup, View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(paramFloat1, paramFloat2, paramViewGroup.getWidth() / 2.0F, paramViewGroup.getHeight() / 2.0F, 310.0F, true);
    localRotate3dAnimation.setDuration(500L);
    localRotate3dAnimation.setFillAfter(true);
    localRotate3dAnimation.setRepeatMode(1);
    localRotate3dAnimation.setInterpolator(new AccelerateInterpolator());
    localRotate3dAnimation.setAnimationListener(new DisplayNextView(paramInt, paramView, null));
    paramViewGroup.startAnimation(localRotate3dAnimation);
  }
  
  public static void setAnimationListener(IAnimationLister paramIAnimationLister)
  {
    mAnimationListener = paramIAnimationLister;
  }
  
  private static final class DisplayNextView
    implements Animation.AnimationListener
  {
    private View mDestView;
    private final int mPosition;
    
    private DisplayNextView(int paramInt, View paramView)
    {
      this.mPosition = paramInt;
      this.mDestView = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      LogUtil.e("anim", "src onAnimationEnd");
      BNWorkerCenter.getInstance().submitMainThreadTask(new RGAnimUtil.SwapViews("RGAnimUtil.SwapViews", null, this.mPosition, this.mDestView), new BNWorkerConfig(2, 0));
      RGAnimUtil.mAnimationListener.onEnd1();
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public static abstract interface IAnimationLister
  {
    public abstract void onEnd1();
    
    public abstract void onEnd2();
  }
  
  private static class Rotate3dAnimation
    extends Animation
  {
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final float mFromDegrees;
    private final boolean mReverse;
    private final float mToDegrees;
    
    public Rotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
    {
      this.mFromDegrees = paramFloat1;
      this.mToDegrees = paramFloat2;
      this.mCenterX = paramFloat3;
      this.mCenterY = paramFloat4;
      this.mDepthZ = paramFloat5;
      this.mReverse = paramBoolean;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f1 = this.mFromDegrees;
      float f2 = this.mToDegrees;
      float f3 = this.mCenterX;
      float f4 = this.mCenterY;
      Camera localCamera = this.mCamera;
      paramTransformation = paramTransformation.getMatrix();
      localCamera.save();
      if (this.mReverse) {
        localCamera.translate(0.0F, 0.0F, this.mDepthZ * paramFloat);
      }
      for (;;)
      {
        localCamera.rotateY(f1 + (f2 - f1) * paramFloat);
        localCamera.getMatrix(paramTransformation);
        localCamera.restore();
        paramTransformation.preTranslate(-f3, -f4);
        paramTransformation.postTranslate(f3, f4);
        return;
        localCamera.translate(0.0F, 0.0F, this.mDepthZ * (1.0F - paramFloat));
      }
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      this.mCamera = new Camera();
    }
  }
  
  private static final class SwapViews<K, T>
    extends BNWorkerNormalTask<K, T>
  {
    private final int mPosition;
    private View mView;
    
    public SwapViews(String paramString, K paramK, int paramInt, View paramView)
    {
      super(paramK);
      this.mPosition = paramInt;
      this.mView = paramView;
    }
    
    public T execute()
    {
      float f1 = this.mView.getWidth() / 2.0F;
      float f2 = this.mView.getHeight() / 2.0F;
      if (this.mPosition > -1)
      {
        this.mView.setVisibility(0);
        this.mView.requestFocus();
      }
      for (RGAnimUtil.Rotate3dAnimation localRotate3dAnimation = new RGAnimUtil.Rotate3dAnimation(90.0F, 180.0F, f1, f2, 310.0F, false);; localRotate3dAnimation = new RGAnimUtil.Rotate3dAnimation(90.0F, 0.0F, f1, f2, 310.0F, false))
      {
        localRotate3dAnimation.setDuration(500L);
        localRotate3dAnimation.setFillAfter(false);
        localRotate3dAnimation.setRepeatMode(1);
        localRotate3dAnimation.setInterpolator(new DecelerateInterpolator());
        localRotate3dAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            RGAnimUtil.mAnimationListener.onEnd2();
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.mView.startAnimation(localRotate3dAnimation);
        return null;
        this.mView.setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/util/RGAnimUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */