package com.baidu.nplatform.comapi.map.gesture.opt;

import android.view.MotionEvent;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.MapStatus.WinRound;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapController.MapControlMode;
import com.baidu.nplatform.comapi.map.gesture.Base.Line;
import com.baidu.nplatform.comapi.map.gesture.Base.Point;
import com.baidu.nplatform.comapi.map.gesture.Base.Translation;
import com.baidu.nplatform.comapi.map.gesture.Base.Vector;
import com.baidu.nplatform.comapi.map.gesture.detector.MoveDetector;

public class ZoomRotateOpt
  extends Opt
{
  private static final int MIN_ROTATE = 10;
  private static final int ROTATE_ANGLE = 60;
  public static boolean isRotateOpt = false;
  private MoveDetector detector;
  private int endRotate;
  private float endScale;
  private GeoPoint initialCenter;
  private float initialLScale;
  private int initialRotate;
  private Base.Translation initialTranslation;
  private double lastScale = 0.0D;
  private Base.Translation lastTranslation;
  private boolean rotateMode = false;
  
  public ZoomRotateOpt(MapController paramMapController)
  {
    super(paramMapController);
  }
  
  private void updateMapCenter(MapStatus paramMapStatus)
  {
    if (paramMapStatus == null) {}
    while ((this.initialCenter == null) || ((Math.abs(this.lastTranslation.move.x) <= 0.0D) && (Math.abs(this.lastTranslation.move.y) <= 0.0D))) {
      return;
    }
    paramMapStatus._CenterPtX = this.initialCenter.getLongitudeE6();
    paramMapStatus._CenterPtY = this.initialCenter.getLatitudeE6();
    Base.Point localPoint = this.detector.currentPosition.center();
    int i = this.controller.getMapStatus()._WinRound.right;
    int j = this.controller.getMapStatus()._WinRound.left;
    int k = this.controller.getMapStatus()._WinRound.bottom;
    int m = this.controller.getMapStatus()._WinRound.top;
    paramMapStatus._Xoffset = ((localPoint.x - (i - j) / 2));
    paramMapStatus._Yoffset = (-1L * (localPoint.y - (k - m) / 2));
  }
  
  private void updateRotate(MapStatus paramMapStatus)
  {
    if (paramMapStatus == null) {
      return;
    }
    double d1 = Math.abs(new Base.Translation(new Base.Line(this.detector.lastPosition.a, this.detector.currentPosition.a), this.detector.lastPosition).rotate);
    double d2 = Math.abs(new Base.Translation(new Base.Line(this.detector.lastPosition.b, this.detector.currentPosition.b), this.detector.lastPosition).rotate);
    int i;
    if ((this.lastScale != 0.0D) && (this.lastScale * this.lastTranslation.scale < 0.0D))
    {
      i = 1;
      label131:
      if (i != 0) {
        break label199;
      }
      if (!this.rotateMode) {
        break label201;
      }
      paramMapStatus._Rotation = ((int)((this.initialRotate + this.initialTranslation.rotate) % 360.0D));
      this.endRotate = paramMapStatus._Rotation;
      UserOPController.getInstance().addMapOP(2, 521);
    }
    label199:
    label201:
    label251:
    label362:
    label366:
    for (;;)
    {
      this.lastScale = this.lastTranslation.scale;
      return;
      i = 0;
      break label131;
      break;
      if (((this.lastTranslation.scale < 1.0D) && (d1 > 60.0D)) || ((this.lastTranslation.scale > 1.0D) && (Math.abs(d1 - 180.0D) > 60.0D)))
      {
        i = 1;
        if (((this.lastTranslation.scale <= 1.0D) || (d2 <= 60.0D)) && ((this.lastTranslation.scale >= 1.0D) || (Math.abs(d2 - 180.0D) <= 60.0D))) {
          break label362;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (((i == 0) && (j == 0)) || (Math.abs(this.initialTranslation.rotate) <= 10.0D)) {
          break label366;
        }
        this.rotateMode = true;
        this.initialRotate = ((int)(this.initialRotate - this.initialTranslation.rotate));
        break;
        i = 0;
        break label251;
      }
    }
  }
  
  private void updateScale(MapStatus paramMapStatus)
  {
    double d = Math.log(2.0D);
    if ((d > 1.0E-7D) || (d < -1.0E-7D))
    {
      paramMapStatus._Level = (this.initialLScale + (float)(Math.log(this.initialTranslation.scale) / d));
      this.endScale = paramMapStatus._Level;
    }
  }
  
  public void finish(MoveDetector paramMoveDetector)
  {
    this.rotateMode = false;
    if (this.controller.getMapView() == null) {}
    do
    {
      do
      {
        return;
      } while (this.controller.getMapStatus() == null);
      double d1 = 0.0D;
      double d2 = 0.0D;
      int j = (int)paramMoveDetector.event.getX();
      int k = (int)paramMoveDetector.event.getY();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k < 0) {
        j = 0;
      }
      k = this.controller.getMapStatus()._WinRound.right;
      int m = this.controller.getMapStatus()._WinRound.left;
      int n = this.controller.getMapStatus()._WinRound.bottom;
      int i1 = this.controller.getMapStatus()._WinRound.top;
      paramMoveDetector = this.controller.scrPtToGeoPoint((k - m) / 2, (n - i1) / 2);
      if (paramMoveDetector != null)
      {
        d1 = paramMoveDetector.getLongitudeE6();
        d2 = paramMoveDetector.getLatitudeE6();
      }
      this.controller.MapMsgProc(5, 1, j << 16 | i, 0, 0, d1, d2, 0.0D, 0.0D);
      if (this.endRotate != this.initialRotate) {
        BNStatisticsManager.getInstance().onGestureEvent("sx");
      }
      if (this.endScale - this.initialLScale > 0.5D)
      {
        BNStatisticsManager.getInstance().onMapScaleSet((int)this.endScale);
        BNStatisticsManager.getInstance().onGestureEvent("gb");
        return;
      }
    } while (this.initialLScale - this.endScale <= 0.5D);
    BNStatisticsManager.getInstance().onMapScaleSet((int)this.endScale);
    BNStatisticsManager.getInstance().onGestureEvent("gs");
  }
  
  public void init(MoveDetector paramMoveDetector)
  {
    if (this.controller.getMapView() == null) {}
    MapStatus localMapStatus;
    do
    {
      return;
      localMapStatus = this.controller.getMapStatus();
    } while (localMapStatus == null);
    paramMoveDetector = paramMoveDetector.initialPosition.center();
    this.initialCenter = this.controller.scrPtToGeoPoint((int)paramMoveDetector.x, (int)paramMoveDetector.y);
    this.initialLScale = this.controller.getLevel();
    this.initialRotate = localMapStatus._Rotation;
    this.endScale = this.initialLScale;
    this.endRotate = this.initialRotate;
    this.lastScale = 0.0D;
  }
  
  public void perform(MoveDetector paramMoveDetector)
  {
    this.detector = paramMoveDetector;
    this.initialTranslation = new Base.Translation(paramMoveDetector.initialPosition, paramMoveDetector.currentPosition);
    this.lastTranslation = new Base.Translation(paramMoveDetector.lastPosition, paramMoveDetector.currentPosition);
    paramMoveDetector = this.controller.getMapStatus();
    if (paramMoveDetector == null) {
      return;
    }
    updateScale(paramMoveDetector);
    if ((this.controller.get3DGestureEnable()) && (this.controller.getMapControlMode() != MapController.MapControlMode.STREET))
    {
      updateMapCenter(paramMoveDetector);
      updateRotate(paramMoveDetector);
    }
    LogUtil.e("dingbbinpage", "zoomrotateopt perform level is " + paramMoveDetector._Level);
    LogUtil.e("mytestmapStatus", paramMoveDetector._Level + "");
    this.controller.setMapStatus(paramMoveDetector, MapController.AnimationType.eAnimationNone);
    isRotateOpt = true;
    this.controller.onDoubleFingerZoom();
    isRotateOpt = false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/gesture/opt/ZoomRotateOpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */