package com.baidu.navisdk.lightnavi.listener;

public abstract interface LightNaviListener
{
  public static final int PAGE_JUMP_LIGHT_NAVI = 2;
  public static final int PAGE_JUMP_NORMAL_NAVI = 3;
  public static final int PAGE_JUMP_SLIGHT_END = 4;
  public static final int PAGE_JUMP_TO_BACK = 1;
  public static final String SWITCH_FLAG = "switch";
  
  public abstract void onPageJump(int paramInt, Object paramObject);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/listener/LightNaviListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */