package com.baidu.nplatform.comapi.map.gesture.opt;

import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;

public abstract class Opt
{
  protected MapController controller;
  
  public Opt(MapController paramMapController)
  {
    this.controller = paramMapController;
  }
  
  public void finish(MoveDetector paramMoveDetector) {}
  
  public void init(MoveDetector paramMoveDetector) {}
  
  public abstract void perform(MoveDetector paramMoveDetector);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/opt/Opt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */