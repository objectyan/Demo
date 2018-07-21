package com.baidu.navisdk.ui.util;

public class ForbidDaulClickUtilsNonStatic
{
  private long DAUL_CLICK_INTERVAL = 800L;
  private long mLastClickTime;
  
  public boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mLastClickTime;
    if ((0L < l2) && (l2 < this.DAUL_CLICK_INTERVAL)) {
      return true;
    }
    this.mLastClickTime = l1;
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/ForbidDaulClickUtilsNonStatic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */