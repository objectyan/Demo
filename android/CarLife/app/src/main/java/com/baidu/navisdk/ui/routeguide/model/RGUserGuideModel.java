package com.baidu.navisdk.ui.routeguide.model;

public class RGUserGuideModel
{
  public static final String TAG = "RGUserGuideModel";
  private static volatile RGUserGuideModel mInstance = null;
  public boolean isShowing = false;
  public long mLoadEndTime = 0L;
  public long mLoadStartTime = 0L;
  public boolean mReceivError = false;
  
  public static RGUserGuideModel getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new RGUserGuideModel();
      }
      return mInstance;
    }
    finally {}
  }
  
  public boolean satisfyCondition()
  {
    if (this.mReceivError) {}
    while ((this.mLoadEndTime - this.mLoadStartTime > 3000L) || (this.mLoadEndTime < 1L)) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGUserGuideModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */