package com.baidu.navisdk.module.offscreen;

public class BNOffScreenParams
{
  public static float BACK_AUTO_BRIGHTNESS = 0.5F;
  public static final int BRIGHT_SCREEN_TYPE = 2;
  public static final String ENTER_OFF_SCREEN = "即将进入黑屏导航模式";
  public static final long MIN_ENTER_INTERVAL = 10000L;
  public static final String NORMAL_BRIGHTNESS = "normal_brightness";
  public static float OFF_INTERUPT_BRIGHTNESS = 0.0F;
  public static float OFF_MIDDLE_BRIGHTNESS = 0.0F;
  public static float OFF_MIN_BRIGHTNESS = 0.0F;
  public static final String OFF_SCREEN_LOW_BATTERY = "电量低是否进入黑屏导航";
  public static final int OFF_SCREEN_SHOW_DELAY = 30000;
  public static final int OFF_SCREEN_TYPE = 1;
  public static final int ORIGINAL_BRIGHTNESS = 143;
  
  static
  {
    OFF_MIDDLE_BRIGHTNESS = 0.4F;
    OFF_INTERUPT_BRIGHTNESS = 0.3F;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/offscreen/BNOffScreenParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */