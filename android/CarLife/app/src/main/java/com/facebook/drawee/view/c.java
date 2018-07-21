package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.d.q.b;
import com.facebook.drawee.d.q.c;
import com.facebook.drawee.e.a;
import java.util.Map;

@TargetApi(19)
public class c
  extends Transition
{
  private static final String a = "draweeTransition:bounds";
  private final q.c b;
  private final q.c c;
  
  public c(q.c paramc1, q.c paramc2)
  {
    this.b = paramc1;
    this.c = paramc2;
  }
  
  public static TransitionSet a(q.c paramc1, q.c paramc2)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition(new ChangeBounds());
    localTransitionSet.addTransition(new c(paramc1, paramc2));
    return localTransitionSet;
  }
  
  private void a(TransitionValues paramTransitionValues)
  {
    if ((paramTransitionValues.view instanceof GenericDraweeView)) {
      paramTransitionValues.values.put("draweeTransition:bounds", new Rect(0, 0, paramTransitionValues.view.getWidth(), paramTransitionValues.view.getHeight()));
    }
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, final TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null)) {}
    do
    {
      return null;
      paramViewGroup = (Rect)paramTransitionValues1.values.get("draweeTransition:bounds");
      paramTransitionValues2 = (Rect)paramTransitionValues2.values.get("draweeTransition:bounds");
    } while ((paramViewGroup == null) || (paramTransitionValues2 == null) || (this.b == this.c));
    paramTransitionValues1 = (GenericDraweeView)paramTransitionValues1.view;
    paramViewGroup = new q.b(this.b, this.c, paramViewGroup, paramTransitionValues2);
    ((a)paramTransitionValues1.getHierarchy()).a(paramViewGroup);
    paramTransitionValues2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramTransitionValues2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramViewGroup.a(f);
      }
    });
    paramTransitionValues2.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ((a)paramTransitionValues1.getHierarchy()).a(c.a(c.this));
      }
    });
    return paramTransitionValues2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */