package com.baidu.platform.comapi.map.gesture;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.NaviMapViewListener;
import com.baidu.platform.comapi.map.gesture.detector.ClickDetector;
import com.baidu.platform.comapi.map.gesture.detector.ClickDetector.Listener;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.platform.comapi.map.gesture.opt.OptSelector;

public class GestureController
{
  private ClickDetector clickDetector;
  ClickDetector.Listener clickListener = new ClickDetector.Listener()
  {
    public boolean onTwoTouchClick(ClickDetector paramAnonymousClickDetector)
    {
      GestureController.this.controller.getGestureMonitor().handleTwoClick(GestureController.this.controller.getZoomLevel() - 1.0F);
      GestureController.this.controller.MapMsgProc(8193, 4, 0);
      if ((GestureController.this.controller.isNaviMode()) && (GestureController.this.controller.getNaviMapViewListener() != null)) {
        GestureController.this.controller.getNaviMapViewListener().onAction(521, null);
      }
      return true;
    }
  };
  private MapController controller;
  private MoveDetector moveDetector;
  
  public GestureController(MapController paramMapController)
  {
    this.controller = paramMapController;
    this.moveDetector = new MoveDetector(new OptSelector(paramMapController));
    this.clickDetector = new ClickDetector(this.clickListener);
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.moveDetector.onTouchEvent(paramMotionEvent);
    this.clickDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/gesture/GestureController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */