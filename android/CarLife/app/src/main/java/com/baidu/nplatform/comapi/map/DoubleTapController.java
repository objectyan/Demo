package com.baidu.nplatform.comapi.map;

import android.view.MotionEvent;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Point;
import com.baidu.nplatform.comapi.map.gesture.Base.Translation;
import com.baidu.nplatform.comapi.map.gesture.Tracker;

public class DoubleTapController
{
  private MapController controller;
  private int count = 0;
  private Base.Line currentPosition;
  private boolean enableMove = false;
  private float endScale;
  private long endTime;
  private int inicount = 3;
  private float initPositionY;
  private float initialLScale;
  private Base.Point initialPoint;
  private Base.Line initialPosition;
  private Base.Translation initialTranslation;
  public boolean isOnlyDoubleTap = true;
  private Base.Line lastPosition;
  private Base.Translation lastTranslation;
  private boolean running = false;
  private float scaleProportion;
  private long startTime;
  private Tracker tracker = new Tracker();
  
  public DoubleTapController(MapController paramMapController)
  {
    this.controller = paramMapController;
  }
  
  private void handleMoving(MotionEvent paramMotionEvent)
  {
    perform(paramMotionEvent);
  }
  
  private void initial(MotionEvent paramMotionEvent)
  {
    if (this.controller.getMapView() == null) {}
    while (this.controller.getMapStatus() == null) {
      return;
    }
    this.initialLScale = this.controller.getLevel();
    this.endScale = this.initialLScale;
    this.initPositionY = paramMotionEvent.getY();
    double d = Math.log(2.0D);
    int i = ScreenUtil.getInstance().getHeightPixels();
    if (((d > 1.0E-7D) || (d < -1.0E-7D)) && (i != 0)) {
      this.scaleProportion = ((float)(20.0F / i / d));
    }
    this.startTime = System.currentTimeMillis();
  }
  
  private void onMove(MotionEvent paramMotionEvent)
  {
    handleMoving(paramMotionEvent);
  }
  
  private void onMoveBegin(MotionEvent paramMotionEvent)
  {
    this.initialPosition = null;
    this.lastPosition = null;
    this.currentPosition = null;
  }
  
  private void onMoveEnd(MotionEvent paramMotionEvent)
  {
    this.tracker.finish();
  }
  
  private void updateScale(MapStatus paramMapStatus)
  {
    double d = Math.log(2.0D);
    if ((d > 1.0E-7D) || (d < -1.0E-7D))
    {
      paramMapStatus._Level = (this.initialLScale + (float)(Math.log(this.initialTranslation.scale) / d));
      this.endScale = paramMapStatus._Level;
      LogUtil.e("mytestlevel", this.endScale + "");
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      if (!this.running)
      {
        this.running = true;
        initial(paramMotionEvent);
        onMoveBegin(paramMotionEvent);
      }
      break;
    }
    for (;;)
    {
      return true;
      this.endTime = System.currentTimeMillis();
      this.controller.handleTouchUp(paramMotionEvent);
      this.controller.onDoubleFingerZoom();
      if (this.running)
      {
        onMoveEnd(paramMotionEvent);
        this.running = false;
      }
      if (this.endTime - this.startTime < 100L)
      {
        BNMapController.getInstance().handleDoubleTouch(paramMotionEvent);
        continue;
        if (this.running) {
          onMove(paramMotionEvent);
        }
      }
    }
  }
  
  public void perform(MotionEvent paramMotionEvent)
  {
    MapStatus localMapStatus = this.controller.getMapStatus();
    if (localMapStatus == null) {
      return;
    }
    float f1 = this.scaleProportion;
    float f2 = this.initPositionY;
    float f3 = paramMotionEvent.getY();
    this.initialLScale = localMapStatus._Level;
    f1 = Math.min(Math.max(this.initialLScale + f1 * (f2 - f3), 3.0F), 20.0F);
    localMapStatus._Level = f1;
    this.initialLScale = f1;
    this.initPositionY = paramMotionEvent.getY();
    this.controller.setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/DoubleTapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */