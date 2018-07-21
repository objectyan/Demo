package com.baidu.nplatform.comapi.map.gesture.opt;

import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Point;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;

public class OverLookOpt
  extends Opt
{
  private static final double DOWN_SPEED = 2.0D;
  public static final int MAX_OVER_LOOK = 0;
  public static final int MIN_OVER_LOOK = -45;
  private static final int UP_SPEED = 4;
  private int initialOverlook;
  
  public OverLookOpt(MapController paramMapController)
  {
    super(paramMapController);
  }
  
  private void rotateOverlook(double paramDouble, MapStatus paramMapStatus)
  {
    if (paramDouble > 0.0D)
    {
      paramMapStatus._Overlooking -= 4;
      return;
    }
    paramMapStatus._Overlooking = ((int)(paramMapStatus._Overlooking + 2.0D));
  }
  
  public void finish(MoveDetector paramMoveDetector)
  {
    paramMoveDetector = this.controller.getMapStatus();
    if (paramMoveDetector._Overlooking > this.initialOverlook)
    {
      LogUtil.e("MapGesture", "OverLookOpt: finish event UP");
      BNStatisticsManager.getInstance().onGestureEvent("sst");
    }
    while (paramMoveDetector._Overlooking >= this.initialOverlook) {
      return;
    }
    LogUtil.e("MapGesture", "OverLookOpt: finish event DOWN");
    BNStatisticsManager.getInstance().onGestureEvent("sxt");
  }
  
  public void init(MoveDetector paramMoveDetector)
  {
    this.initialOverlook = this.controller.getMapStatus()._Overlooking;
  }
  
  public void perform(MoveDetector paramMoveDetector)
  {
    Base.Line localLine = paramMoveDetector.lastPosition;
    paramMoveDetector = paramMoveDetector.currentPosition;
    MapStatus localMapStatus = this.controller.getMapStatus();
    double d1 = paramMoveDetector.a.y - localLine.a.y;
    double d2 = paramMoveDetector.b.y - localLine.b.y;
    if (d1 * d2 > 0.0D)
    {
      rotateOverlook(d1, localMapStatus);
      if (localMapStatus._Overlooking <= 0) {
        break label175;
      }
      localMapStatus._Overlooking = 0;
    }
    for (;;)
    {
      this.controller.setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
      return;
      if (d1 * d2 == 0.0D)
      {
        if (d1 != 0.0D)
        {
          rotateOverlook(d1, localMapStatus);
          break;
        }
        if (d2 == 0.0D) {
          break;
        }
        rotateOverlook(d2, localMapStatus);
        break;
      }
      if (Math.abs(d1) > Math.abs(d2))
      {
        rotateOverlook(d1, localMapStatus);
        break;
      }
      rotateOverlook(d2, localMapStatus);
      break;
      label175:
      if (localMapStatus._Overlooking < -45) {
        localMapStatus._Overlooking = -45;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/opt/OverLookOpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */