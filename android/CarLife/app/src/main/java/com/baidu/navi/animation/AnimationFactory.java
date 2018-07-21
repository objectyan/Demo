package com.baidu.navi.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationFactory
{
  public static final int ANIM_DOWN_IN = 21;
  public static final int ANIM_DOWN_OUT = 22;
  public static final int ANIM_ECLIPSE_UP = 28;
  public static final int ANIM_EMPTY = 0;
  public static final int ANIM_ENTER_HOME_FROM_LAUNCH = 257;
  public static final int ANIM_EXPAND_DOWN = 27;
  public static final int ANIM_FADE_IN = 1;
  public static final int ANIM_FADE_OUT = 2;
  public static final int ANIM_LEFT_IN = 23;
  public static final int ANIM_LEFT_OUT = 24;
  public static final int ANIM_POP_IN = 17;
  public static final int ANIM_POP_OUT = 18;
  public static final int ANIM_RIGHT_IN = 25;
  public static final int ANIM_RIGHT_OUT = 26;
  public static final int ANIM_SLIDE_IN_LEFT = 3;
  public static final int ANIM_SLIDE_IN_RIGHT = 5;
  public static final int ANIM_SLIDE_OUT_LEFT = 4;
  public static final int ANIM_SLIDE_OUT_RIGHT = 6;
  public static final int ANIM_UP_IN = 19;
  public static final int ANIM_UP_OUT = 20;
  
  public static Animation getAnimation(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramContext = new Animation() {};
    }
    for (;;)
    {
      paramContext.setFillAfter(true);
      return paramContext;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034130);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034131);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034148);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034150);
      continue;
      AnimationUtils.loadAnimation(paramContext, 2131034149);
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034151);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034140);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034141);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034152);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034153);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034125);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034126);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034133);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034134);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034146);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034147);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034128);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034129);
      continue;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034127);
    }
  }
  
  public static Animation getAnimation(Context paramContext, int paramInt, long paramLong1, long paramLong2)
  {
    paramContext = getAnimation(paramContext, paramInt);
    if ((paramContext != null) && (paramLong1 >= 0L)) {
      paramContext.setStartOffset(paramLong1);
    }
    if ((paramContext != null) && (paramLong2 >= 0L)) {
      paramContext.setDuration(paramLong2);
    }
    return paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/animation/AnimationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */