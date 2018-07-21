package com.baidu.navisdk.ui.util;

public class ForbidDaulClickUtils
{
  private static long DAUL_CLICK_INTERVAL = 800L;
  private static long mLastClickTime;
  
  public static boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - mLastClickTime;
    if ((0L < l2) && (l2 < DAUL_CLICK_INTERVAL)) {
      return true;
    }
    mLastClickTime = l1;
    return false;
  }
  
  public static boolean isFastDoubleClick(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - mLastClickTime;
    if ((0L < l2) && (l2 < paramLong)) {
      return true;
    }
    mLastClickTime = l1;
    return false;
  }
  
  public static void resetLastDoubleClickTime()
  {
    mLastClickTime = -1L;
  }
  
  public boolean isFastDoubleClickNonStatic()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - mLastClickTime;
    if ((0L < l2) && (l2 < DAUL_CLICK_INTERVAL)) {
      return true;
    }
    mLastClickTime = l1;
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/ForbidDaulClickUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */