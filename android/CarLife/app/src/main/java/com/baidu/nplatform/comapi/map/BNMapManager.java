package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.Point;

public class BNMapManager
{
  private static final String TAG = BNMapManager.class.getSimpleName();
  
  public static BNMapManager getInstance()
  {
    return Holder.sInstance;
  }
  
  public void addMapObserver(BNMapObserver paramBNMapObserver)
  {
    if (paramBNMapObserver != null) {
      BNMapController.getInstance().addObserver(paramBNMapObserver);
    }
  }
  
  public void deleteMapObserver(BNMapObserver paramBNMapObserver)
  {
    if (paramBNMapObserver != null) {
      BNMapController.getInstance().deleteObserver(paramBNMapObserver);
    }
  }
  
  public void init(Context paramContext, Bundle paramBundle)
  {
    LogUtil.e(TAG, "init: -->");
    BNMapController.getInstance().initMapController(paramContext, paramBundle);
  }
  
  public void onAction(int paramInt, Object paramObject)
  {
    LogUtil.e(TAG, "onAction: actionType --> " + paramInt);
    switch (paramInt)
    {
    case 519: 
    default: 
      return;
    case 513: 
      LogUtil.e(TAG, " --> onDoubleTap");
      BNMapController.getInstance().handleDoubleTouch(paramObject);
      return;
    case 514: 
      LogUtil.e(TAG, " --> onSingleTapConfirmed");
      BNMapController.getInstance().handleSingleTouch(paramObject);
      return;
    case 515: 
      LogUtil.e(TAG, " --> onDown");
      BNMapController.getInstance().notifyMapObservers(2, 515, null);
      return;
    case 516: 
      LogUtil.e(TAG, " --> onFling");
      BNStatisticsManager.getInstance().onGestureEvent("td");
      BNMapController.getInstance().notifyMapObservers(2, 516, null);
      return;
    case 517: 
      LogUtil.e(TAG, " --> onLongPress");
      BNStatisticsManager.getInstance().onGestureEvent("dc");
      BNMapController.getInstance().notifyMapObservers(2, 517, paramObject);
      return;
    case 518: 
      LogUtil.e(TAG, " --> onScroll");
      BNMapController.getInstance().notifyMapObservers(2, 518, null);
      return;
    case 520: 
      LogUtil.e(TAG, " --> onDoubleFingerZoom");
      BNMapController.getInstance().notifyMapObservers(2, 520, null);
      return;
    }
    LogUtil.e(TAG, " --> onDoubleFingerRotate");
    BNMapController.getInstance().notifyMapObservers(2, 520, null);
  }
  
  public boolean onItemClick(String paramString, int paramInt1, int paramInt2)
  {
    LogUtil.e(TAG, "onItemClick: jsonStr --> " + paramString);
    return BNMapController.getInstance().onMapItemClick(paramString, paramInt1, paramInt2);
  }
  
  public void onMapAnimationFinish()
  {
    LogUtil.e(TAG, "onMapAnimationFinish:  --> ");
    BNMapController.getInstance().onMapAnimationFinish();
  }
  
  public void onMapRenderModeChange(int paramInt)
  {
    LogUtil.e(TAG, "onMapRenderModeChange: value --> " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return;
    }
    JNIBaseMap.UpdateNeedRender(true);
  }
  
  public Point onTapInterception(Point paramPoint)
  {
    if (paramPoint != null)
    {
      LogUtil.e(TAG, "onTap: input --> x: " + paramPoint.getmPtx() + ", y: " + paramPoint.getmPty());
      if (RouteGuideParams.getRouteGuideMode() == 2)
      {
        paramPoint.setmPty(paramPoint.getmPty() + ScreenUtil.getInstance().getStatusBarHeight() - ScreenUtil.getInstance().dip2px(20));
        LogUtil.e(TAG, "onTap: output --> x: " + paramPoint.getmPtx() + ", y: " + paramPoint.getmPty());
      }
    }
    return paramPoint;
  }
  
  public void setItemizedOverlayMapWrapper(ItemizedOverlayUtil.MapWrapper paramMapWrapper)
  {
    ItemizedOverlayUtil.getInstance().setMapWrapper(paramMapWrapper);
  }
  
  public void unInit()
  {
    LogUtil.e(TAG, "unInit: -->");
    BNMapController.destory();
    NMapControlProxy.destory();
  }
  
  static class Holder
  {
    private static BNMapManager sInstance = new BNMapManager(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/BNMapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */