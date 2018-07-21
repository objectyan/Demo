package com.baidu.navisdk.lightnavi.utils;

import android.os.Bundle;
import com.baidu.navisdk.lightnavi.listener.LightNaviListener;

public class LightNaviPageJumpHelper
{
  private static volatile LightNaviPageJumpHelper mInstance;
  private LightNaviListener mLightNaviListener;
  
  public static LightNaviPageJumpHelper getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new LightNaviPageJumpHelper();
      }
      return mInstance;
    }
    finally {}
  }
  
  public void onPageJump(int paramInt, Bundle paramBundle)
  {
    if (this.mLightNaviListener != null) {
      this.mLightNaviListener.onPageJump(paramInt, paramBundle);
    }
  }
  
  public void removePageListener()
  {
    this.mLightNaviListener = null;
  }
  
  public void setPageListener(LightNaviListener paramLightNaviListener)
  {
    this.mLightNaviListener = paramLightNaviListener;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/utils/LightNaviPageJumpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */