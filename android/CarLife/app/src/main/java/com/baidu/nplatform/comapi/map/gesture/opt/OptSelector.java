package com.baidu.nplatform.comapi.map.gesture.opt;

import android.util.Pair;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.gesture.Base;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Vector;
import com.baidu.nplatform.comapi.map.gesture.Tracker;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector.Listener;
import java.util.Iterator;
import java.util.LinkedList;

public class OptSelector
  implements MoveDetector.Listener
{
  public static final int FACTOR = 3;
  public static final int FINGER_HORIZONTAL_ANGLE = 45;
  public static final int FINGER_VERTICAL_ANGLE = 40;
  private static final int OVERLOOK_CHECK_POINTS = 5;
  private MapController controller;
  private boolean isCheckOverlook = false;
  private int minFling;
  private Opt opt;
  private LinkedList<Base.Line> positionList = new LinkedList();
  private Tracker tracker = new Tracker();
  
  public OptSelector(MapController paramMapController)
  {
    this.controller = paramMapController;
    this.minFling = (this.tracker.MIN_FLING_VELOCITY / 3);
  }
  
  private boolean checkOverlook()
  {
    this.isCheckOverlook = true;
    Object localObject1 = this.positionList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Base.Line)((Iterator)localObject1).next();
      if (Base.Vector.angle(Base.HORIZONTAL.vector(), ((Base.Line)localObject2).vector()) > 45.0D) {
        return false;
      }
    }
    Object localObject2 = this.tracker.velocity();
    localObject1 = (Base.Vector)((Pair)localObject2).first;
    localObject2 = (Base.Vector)((Pair)localObject2).second;
    int i;
    if ((Math.abs(((Base.Vector)localObject1).y) > this.minFling) && (Math.abs(((Base.Vector)localObject2).y) > this.minFling))
    {
      i = 1;
      Base.Line localLine2 = (Base.Line)this.positionList.getFirst();
      Base.Line localLine3 = (Base.Line)this.positionList.getLast();
      Base.Line localLine1 = new Base.Line(localLine3.a, localLine2.a);
      localLine2 = new Base.Line(localLine3.b, localLine2.b);
      int n = (int)Base.Vector.angle(localLine1.vector(), Base.VERTICAL.vector());
      int m = (int)Base.Vector.angle(localLine2.vector(), Base.VERTICAL.vector());
      int k = n;
      j = m;
      if (((Base.Vector)localObject1).y > 0.0D)
      {
        k = n;
        j = m;
        if (((Base.Vector)localObject2).y > 0.0D)
        {
          k = n + 180;
          j = m + 180;
        }
      }
      if ((Math.abs(k) >= 40) || (Math.abs(j) >= 40)) {
        break label301;
      }
    }
    label301:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label306;
      }
      return true;
      i = 0;
      break;
    }
    label306:
    return false;
  }
  
  private void switchOverlook(MoveDetector paramMoveDetector)
  {
    this.opt.finish(paramMoveDetector);
    this.opt = new OverLookOpt(this.controller);
    this.opt.init(paramMoveDetector);
  }
  
  private void updateOpt(MoveDetector paramMoveDetector)
  {
    if (this.positionList.size() < 5)
    {
      this.positionList.addLast(paramMoveDetector.currentPosition);
      this.tracker.addMovement(paramMoveDetector.event);
    }
    while ((this.isCheckOverlook) || (this.positionList.size() != 5) || (!checkOverlook())) {
      return;
    }
    switchOverlook(paramMoveDetector);
  }
  
  public boolean onMove(MoveDetector paramMoveDetector)
  {
    updateOpt(paramMoveDetector);
    if (this.positionList.size() == 1) {
      this.opt.init(paramMoveDetector);
    }
    this.opt.perform(paramMoveDetector);
    return true;
  }
  
  public boolean onMoveBegin(MoveDetector paramMoveDetector)
  {
    this.positionList.clear();
    this.tracker.init();
    this.opt = new ZoomRotateOpt(this.controller);
    this.isCheckOverlook = false;
    return true;
  }
  
  public boolean onMoveEnd(MoveDetector paramMoveDetector)
  {
    this.tracker.finish();
    this.opt.finish(paramMoveDetector);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/opt/OptSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */