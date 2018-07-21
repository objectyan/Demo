package com.baidu.platform.comapi.map.gesture.opt;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.gesture.Base.Line;
import com.baidu.platform.comapi.map.gesture.Base.Point;
import com.baidu.platform.comapi.map.gesture.Base.Vector;
import com.baidu.platform.comapi.map.gesture.GestureMonitor;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;

public class OverLookOpt
  extends Opt
{
  private static final double DOWN_SPEED = 2.0D;
  public static final int MAX_OVER_LOOK = 0;
  private static final int UP_SPEED = 4;
  private boolean isFirst = true;
  
  public OverLookOpt(MapController paramMapController)
  {
    super(paramMapController);
  }
  
  private void rotateOverlook(double paramDouble, MapStatus paramMapStatus)
  {
    if (paramDouble > 0.0D)
    {
      paramMapStatus.overlooking -= 4;
      return;
    }
    paramMapStatus.overlooking = ((int)(paramMapStatus.overlooking + 2.0D));
  }
  
  public void finish(MoveDetector paramMoveDetector, Pair<Base.Vector, Base.Vector> paramPair)
  {
    paramMoveDetector = this.controller.getMapStatus();
    if (paramMoveDetector.bOverlookSpringback) {
      if (paramMoveDetector.overlooking <= 0) {
        break label39;
      }
    }
    label39:
    for (paramMoveDetector.overlooking = 0;; paramMoveDetector.overlooking = paramMoveDetector.minOverlooking)
    {
      this.controller.setMapStatusWithAnimation(paramMoveDetector, 200);
      return;
    }
  }
  
  public void perform(MoveDetector paramMoveDetector)
  {
    Base.Line localLine = paramMoveDetector.lastPosition;
    paramMoveDetector = paramMoveDetector.currentPosition;
    MapStatus localMapStatus = this.controller.getMapStatus();
    double d1 = paramMoveDetector.a.y - localLine.a.y;
    double d2 = paramMoveDetector.b.y - localLine.b.y;
    if (d1 * d2 > 0.0D) {
      rotateOverlook(d1, localMapStatus);
    }
    for (;;)
    {
      this.controller.setMapStatus(localMapStatus);
      if (this.isFirst)
      {
        this.isFirst = false;
        this.controller.getGestureMonitor().handleMoveOverlook();
      }
      return;
      if (d1 * d2 == 0.0D)
      {
        if (d1 != 0.0D) {
          rotateOverlook(d1, localMapStatus);
        } else if (d2 != 0.0D) {
          rotateOverlook(d2, localMapStatus);
        }
      }
      else if (Math.abs(d1) > Math.abs(d2)) {
        rotateOverlook(d1, localMapStatus);
      } else {
        rotateOverlook(d2, localMapStatus);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/gesture/opt/OverLookOpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */