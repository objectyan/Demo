package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.ui.util.BNStyleManager;

public class RGMainAuxiliaryModel
{
  public static final int MAX_WAIT_TIME = 30;
  public static final int MSG_CANCEL_COUNT = 3;
  public static final int MSG_STOP_COUNT = 2;
  public static final int MSG_TIME_COUNT = 1;
  public static int currentMsgType = -1;
  private static RGMainAuxiliaryModel mInstance = null;
  public int currentCount = 30;
  private boolean mCanCounterRestart = false;
  private boolean mCanMainAuxiliaryShow = false;
  private String mMainAuxiliarySwitch = null;
  private String mMainAuxiliaryTips = null;
  
  public static RGMainAuxiliaryModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGMainAuxiliaryModel();
    }
    return mInstance;
  }
  
  public String getCountStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(BNStyleManager.getString(1711670069));
    return this.currentCount;
  }
  
  public String getmMainAuxiliarySwitch()
  {
    return this.mMainAuxiliarySwitch;
  }
  
  public String getmMainAuxiliaryTips()
  {
    return this.mMainAuxiliaryTips;
  }
  
  public boolean ismCanCounterRestart()
  {
    return this.mCanCounterRestart;
  }
  
  public boolean ismCanMainAuxiliaryShow()
  {
    return this.mCanMainAuxiliaryShow;
  }
  
  public void setmCanCounterRestart(boolean paramBoolean)
  {
    this.mCanCounterRestart = paramBoolean;
  }
  
  public void setmCanMainAuxiliaryShow(boolean paramBoolean)
  {
    this.mCanMainAuxiliaryShow = paramBoolean;
  }
  
  public void setmMainAuxiliarySwitch(String paramString)
  {
    this.mMainAuxiliarySwitch = paramString;
  }
  
  public void setmMainAuxiliaryTips(String paramString)
  {
    this.mMainAuxiliaryTips = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGMainAuxiliaryModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */