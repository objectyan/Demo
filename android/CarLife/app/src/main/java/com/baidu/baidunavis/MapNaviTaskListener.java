package com.baidu.baidunavis;

import com.baidu.navisdk.ui.voice.controller.VoiceDownloadStatus.NaviTaskListener;

public class MapNaviTaskListener
  implements VoiceDownloadStatus.NaviTaskListener
{
  private boolean isNaviTask()
  {
    return false;
  }
  
  public boolean onCheckNaviTask()
  {
    return isNaviTask();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/MapNaviTaskListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */