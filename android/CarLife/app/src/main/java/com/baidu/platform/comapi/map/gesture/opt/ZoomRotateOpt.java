package com.baidu.platform.comapi.map.gesture.opt;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapController.MapControlMode;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.NaviMapViewListener;
import com.baidu.platform.comapi.map.Projection;
import com.baidu.platform.comapi.map.event.CancelCompassEvent;
import com.baidu.platform.comapi.map.event.MapZoomEvent;
import com.baidu.platform.comapi.map.gesture.Base.Line;
import com.baidu.platform.comapi.map.gesture.Base.Point;
import com.baidu.platform.comapi.map.gesture.Base.Translation;
import com.baidu.platform.comapi.map.gesture.Base.Vector;
import com.baidu.platform.comapi.map.gesture.GestureMonitor;
import com.baidu.platform.comapi.map.gesture.detector.MoveDetector;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comapi.util.f;
import java.util.LinkedList;
import java.util.Queue;

public class ZoomRotateOpt
  extends Opt
{
  private static final int MAX_ZOOM_LEVEL = 2;
  private static final int MIN_ROTATE = 10;
  private static final int ROTATE_ANGLE = 60;
  private MoveDetector detector;
  private GeoPoint initialCenter;
  private float initialLScale;
  private int initialRotate;
  private Base.Translation initialTranslation;
  private boolean isCompassDone = false;
  private boolean isScale = false;
  private double lastScale = 0.0D;
  private Base.Translation lastTranslation;
  private Queue<Base.Translation> mLastTrans = new LinkedList();
  private boolean rotateMode = false;
  
  public ZoomRotateOpt(MapController paramMapController)
  {
    super(paramMapController);
  }
  
  private void updateMapCenter(MapStatus paramMapStatus)
  {
    if ((this.initialCenter != null) && ((Math.abs(this.lastTranslation.move.x) > 0.0D) || (Math.abs(this.lastTranslation.move.y) > 0.0D)))
    {
      localPoint1 = this.detector.initialPosition.center();
      Base.Point localPoint2 = this.detector.currentPosition.center();
      double d = Math.sqrt((localPoint2.x - localPoint1.x) * (localPoint2.x - localPoint1.x) + (localPoint2.y - localPoint1.y) * (localPoint2.y - localPoint1.y));
      if ((!MapController.isCompass) || (d >= 100.0D)) {
        break label133;
      }
    }
    label133:
    do
    {
      return;
      if ((!MapController.isCompass) && (!this.isCompassDone)) {
        break;
      }
      this.isCompassDone = false;
      BMEventBus.getInstance().post(new CancelCompassEvent());
      paramMapStatus = this.controller.getMapView();
    } while (paramMapStatus == null);
    Base.Point localPoint1 = this.detector.currentPosition.center();
    this.initialCenter = paramMapStatus.getProjection().fromPixels((int)localPoint1.x, (int)localPoint1.y);
    return;
    paramMapStatus.centerPtX = this.initialCenter.getLongitude();
    paramMapStatus.centerPtY = this.initialCenter.getLatitude();
    localPoint1 = this.detector.currentPosition.center();
    paramMapStatus.xOffset = ((float)(localPoint1.x - this.controller.getScreenWidth() / 2));
    paramMapStatus.yOffset = (-1.0F * (float)(localPoint1.y - this.controller.getScreenHeight() / 2));
  }
  
  private void updateRotate(MapStatus paramMapStatus)
  {
    double d1 = Math.abs(new Base.Translation(new Base.Line(this.detector.lastPosition.a, this.detector.currentPosition.a), this.detector.lastPosition).rotate);
    double d2 = Math.abs(new Base.Translation(new Base.Line(this.detector.lastPosition.b, this.detector.currentPosition.b), this.detector.lastPosition).rotate);
    if ((this.lastScale != 0.0D) && (this.lastScale * this.lastTranslation.scale < 0.0D)) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    if (this.rotateMode) {
      paramMapStatus.rotation = ((int)((this.initialRotate + this.initialTranslation.rotate) % 360.0D));
    }
    label229:
    label281:
    label386:
    label390:
    label392:
    label397:
    for (;;)
    {
      this.lastScale = this.lastTranslation.scale;
      return;
      int j;
      if (((this.lastTranslation.scale < 1.0D) && (d1 > 60.0D)) || ((this.lastTranslation.scale > 1.0D) && (Math.abs(d1 - 180.0D) > 60.0D)))
      {
        i = 1;
        if (((this.lastTranslation.scale <= 1.0D) || (d2 <= 60.0D)) && ((this.lastTranslation.scale >= 1.0D) || (Math.abs(d2 - 180.0D) <= 60.0D))) {
          break label386;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label390;
        }
        d1 = Math.abs(this.initialTranslation.rotate);
        if (!MapController.isCompass) {
          break label392;
        }
      }
      for (i = 30;; i = 10)
      {
        if (d1 <= i) {
          break label397;
        }
        this.rotateMode = true;
        this.controller.getGestureMonitor().handleRotate();
        this.initialRotate = ((int)(this.initialRotate - this.initialTranslation.rotate));
        if (!MapController.isCompass) {
          break;
        }
        this.isCompassDone = true;
        BMEventBus.getInstance().post(new CancelCompassEvent());
        break;
        i = 0;
        break label229;
        j = 0;
        break label281;
        break;
      }
    }
  }
  
  private void updateScale(MapStatus paramMapStatus)
  {
    float f = 4.0F;
    double d = Math.log(2.0D);
    paramMapStatus.level = (this.initialLScale + (float)(Math.log(this.initialTranslation.scale) / d));
    if (paramMapStatus.level < 4.0F) {}
    for (;;)
    {
      paramMapStatus.level = f;
      return;
      f = paramMapStatus.level;
    }
  }
  
  public void ZoomAnimation(MapStatus paramMapStatus, MoveDetector paramMoveDetector, Pair<Base.Vector, Base.Vector> paramPair)
  {
    double d1;
    if (paramPair != null)
    {
      d1 = ((Base.Vector)paramPair.first).x;
      if (((Base.Vector)paramPair.second).x * d1 <= 0.0D) {
        break label65;
      }
      d1 = ((Base.Vector)paramPair.first).y;
      if (((Base.Vector)paramPair.second).y * d1 <= 0.0D) {
        break label65;
      }
    }
    label65:
    double d2;
    int i;
    label232:
    int k;
    int j;
    label409:
    Base.Translation localTranslation;
    Object localObject1;
    int m;
    Object localObject2;
    int n;
    do
    {
      do
      {
        do
        {
          return;
        } while ((Math.abs(((Base.Vector)paramPair.first).x - ((Base.Vector)paramPair.second).x) < 1.0D) || (Math.abs(((Base.Vector)paramPair.first).y - ((Base.Vector)paramPair.second).y) < 1.0D));
        d1 = Math.abs(new Base.Translation(new Base.Line(paramMoveDetector.lastPosition.a, paramMoveDetector.currentPosition.a), paramMoveDetector.lastPosition).rotate);
        d2 = Math.abs(new Base.Translation(new Base.Line(paramMoveDetector.lastPosition.b, paramMoveDetector.currentPosition.b), paramMoveDetector.lastPosition).rotate);
        if ((this.lastScale == 0.0D) || (this.lastScale * this.lastTranslation.scale >= 0.0D)) {
          break;
        }
        i = 1;
        if (i != 0) {
          break label587;
        }
        double d3 = ((Base.Vector)paramPair.first).x;
        double d4 = ((Base.Vector)paramPair.second).x;
        double d5 = ((Base.Vector)paramPair.first).x;
        double d6 = ((Base.Vector)paramPair.second).x;
        double d7 = ((Base.Vector)paramPair.first).y;
        double d8 = ((Base.Vector)paramPair.second).y;
        f1 = (float)Math.sqrt((((Base.Vector)paramPair.first).y - ((Base.Vector)paramPair.second).y) * (d7 - d8) + (d3 - d4) * (d5 - d6));
        f.b("zoom_speed:", String.valueOf(f1));
      } while (f1 <= SysOSAPIv2.getInstance().getDensityDpi() * 100 / 320);
      paramMapStatus.hasAnimation = 1;
      paramMapStatus.animationTime = 600;
      paramPair = null;
      paramMoveDetector = null;
      k = 0;
      j = 0;
      i = 0;
      if (i >= this.mLastTrans.size()) {
        break label609;
      }
      localTranslation = (Base.Translation)this.mLastTrans.poll();
      localObject1 = paramPair;
      m = k;
      localObject2 = paramMoveDetector;
      n = j;
      if (localTranslation == null) {
        break;
      }
      f.b("zoom_scale" + i, localTranslation.scale + "");
    } while ((this.mLastTrans.isEmpty()) && (Math.abs(localTranslation.scale - 1.0D) < 0.01D));
    if (localTranslation.scale > 1.0D)
    {
      m = k + 1;
      localObject1 = localTranslation;
      n = j;
      localObject2 = paramMoveDetector;
    }
    for (;;)
    {
      i += 1;
      paramPair = (Pair<Base.Vector, Base.Vector>)localObject1;
      k = m;
      paramMoveDetector = (MoveDetector)localObject2;
      j = n;
      break label409;
      i = 0;
      break label232;
      label587:
      break;
      n = j + 1;
      localObject2 = localTranslation;
      localObject1 = paramPair;
      m = k;
    }
    label609:
    label616:
    label682:
    label742:
    label804:
    boolean bool;
    if (k >= j)
    {
      if ((paramPair != null) && (Math.abs(paramPair.scale - 1.0D) < 0.01D)) {
        break label937;
      }
      if (((paramPair.scale >= 1.0D) || (d1 <= 60.0D)) && ((paramPair.scale <= 1.0D) || (Math.abs(d1 - 180.0D) <= 60.0D))) {
        break label939;
      }
      i = 1;
      if (i != 0) {
        f.b("zoom_ratote", "aMoved");
      }
      if (((paramPair.scale <= 1.0D) || (d2 <= 60.0D)) && ((paramPair.scale >= 1.0D) || (Math.abs(d2 - 180.0D) <= 60.0D))) {
        break label945;
      }
      j = 1;
      if (j != 0) {
        f.b("zoom_ratote", "bMoved");
      }
      f.b("zoom_ratote", String.valueOf(this.initialTranslation.rotate));
      if ((i != 0) || (j != 0))
      {
        d1 = Math.abs(this.initialTranslation.rotate);
        if (!MapController.isCompass) {
          break label951;
        }
        i = 30;
        if (d1 > i) {
          break label956;
        }
      }
      f.b("zoom_scale", String.valueOf(paramPair.scale));
      if (paramPair.scale <= 1.0D) {
        break label958;
      }
      bool = true;
      label838:
      this.isScale = bool;
      float f2 = f1 / (800000 / SysOSAPIv2.getInstance().getDensityDpi());
      f1 = f2;
      if (f2 > 2.0F) {
        f1 = 2.0F;
      }
      if (this.isScale) {
        break label964;
      }
      paramMapStatus.level -= f1;
      label892:
      if (paramMapStatus.level >= 4.0F) {
        break label978;
      }
    }
    label937:
    label939:
    label945:
    label951:
    label956:
    label958:
    label964:
    label978:
    for (float f1 = 4.0F;; f1 = paramMapStatus.level)
    {
      paramMapStatus.level = f1;
      f.b("zoom_level:", String.valueOf(paramMapStatus.level));
      this.controller.setMapStatus(paramMapStatus);
      return;
      paramPair = paramMoveDetector;
      break label616;
      break;
      i = 0;
      break label682;
      j = 0;
      break label742;
      i = 15;
      break label804;
      break;
      bool = false;
      break label838;
      paramMapStatus.level += f1;
      break label892;
    }
  }
  
  public void finish(MoveDetector paramMoveDetector, Pair<Base.Vector, Base.Vector> paramPair)
  {
    this.rotateMode = false;
    Object localObject = this.controller.getMapView();
    if (localObject == null) {
      return;
    }
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
    localObject = ((MapViewInterface)localObject).getProjection().fromPixels(this.controller.getScreenWidth() / 2, this.controller.getScreenHeight() / 2);
    if (localObject != null)
    {
      d1 = ((GeoPoint)localObject).getLongitude();
      d2 = ((GeoPoint)localObject).getLatitude();
    }
    this.controller.MapMsgProc(5, 1, j << 16 | i, 0, 0, d1, d2, 0.0D, 0.0D);
    this.controller.getGestureMonitor().handleZoomChange(this.controller.getZoomLevel());
    ZoomAnimation(this.controller.getMapStatus(), paramMoveDetector, paramPair);
  }
  
  public void init(MoveDetector paramMoveDetector)
  {
    MapViewInterface localMapViewInterface = this.controller.getMapView();
    if (localMapViewInterface == null) {
      return;
    }
    MapStatus localMapStatus = this.controller.getMapStatus();
    paramMoveDetector = paramMoveDetector.initialPosition.center();
    this.initialCenter = localMapViewInterface.getProjection().fromPixels((int)paramMoveDetector.x, (int)paramMoveDetector.y);
    this.initialLScale = this.controller.getZoomLevel();
    this.initialRotate = localMapStatus.rotation;
    this.lastScale = 0.0D;
  }
  
  public void perform(MoveDetector paramMoveDetector)
  {
    this.detector = paramMoveDetector;
    this.initialTranslation = new Base.Translation(paramMoveDetector.initialPosition, paramMoveDetector.currentPosition);
    this.lastTranslation = new Base.Translation(paramMoveDetector.lastPosition, paramMoveDetector.currentPosition);
    paramMoveDetector = this.controller.getMapStatus();
    updateScale(paramMoveDetector);
    if ((this.controller.is3DGestureEnable()) && (this.controller.getMapControlMode() != MapController.MapControlMode.STREET))
    {
      updateMapCenter(paramMoveDetector);
      updateRotate(paramMoveDetector);
    }
    this.controller.setMapStatus(paramMoveDetector);
    if ((this.controller.isNaviMode()) && (this.controller.getNaviMapViewListener() != null)) {
      this.controller.getNaviMapViewListener().onAction(520, null);
    }
    if (this.mLastTrans.size() >= 10) {
      this.mLastTrans.poll();
    }
    this.mLastTrans.offer(this.lastTranslation);
    BMEventBus.getInstance().post(new MapZoomEvent());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/gesture/opt/ZoomRotateOpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */