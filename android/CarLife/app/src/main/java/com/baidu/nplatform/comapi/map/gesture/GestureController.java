package com.baidu.nplatform.comapi.map.gesture;

import android.view.MotionEvent;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.gesture.detector.ClickDetector;
import com.baidu.nplatform.comapi.map.gesture.detector.ClickDetector.Listener;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.nplatform.comapi.map.gesture.opt.OptSelector;

public class GestureController
{
  private ClickDetector clickDetector;
  ClickDetector.Listener clickListener = new ClickDetector.Listener()
  {
    public boolean onTwoTouchClick(ClickDetector paramAnonymousClickDetector)
    {
      LogUtil.e("MapGesture", "onTwoTouchClick");
      paramAnonymousClickDetector = GestureController.this.controller.getMapStatus();
      BNStatisticsManager.getInstance().onMapScaleSet(Math.max((int)(paramAnonymousClickDetector._Level - 1.0F), 3));
      BNStatisticsManager.getInstance().onGestureEvent("sd");
      GestureController.this.controller.MapMsgProc(8193, 4, 0);
      if (BNMapController.getInstance().getMapController() != null) {
        BNMapController.getInstance().getMapController().onDoubleFingerZoom();
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/GestureController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */