package com.baidu.baidumaps.f.a.a;

import android.os.Bundle;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import java.util.HashMap;

public class a
{
  public static final String a = "cache_common_navi_page";
  private static a b = null;
  private static final String c = a.class.getSimpleName();
  private int d = -99;
  private int e = -99;
  private boolean f = true;
  private HashMap<String, a> g = new HashMap();
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  public static void b()
  {
    if (b != null) {
      b.g();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 10;
    NavLogUtils.e(c, "restoreMapMode() noCareBySelf=" + paramBoolean);
    PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if ((this.d >= 0) && (this.e >= 0))
    {
      if (localMapGLSurfaceView != null)
      {
        i = this.e;
        if (((this.e == 0) || (this.e == 5)) && (!MapViewFactory.getInstance().getMapView().isTraffic())) {
          break label195;
        }
        if (!BNStyleManager.getRealDayStyle()) {
          break label198;
        }
        i = 10;
        label103:
        this.d = i;
        if (!BNStyleManager.getRealDayStyle()) {
          break label204;
        }
      }
      label195:
      label198:
      label204:
      for (i = 0;; i = 9)
      {
        a(this.d, i);
        localMapGLSurfaceView.getController().setOverlookGestureEnable(this.f);
        NavLogUtils.e(c, "restoreMapMode() theme=" + this.d + ", scene=" + i + ", over=" + this.f);
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
        return;
        break;
        i = 11;
        break label103;
      }
    }
    if (BNStyleManager.getRealDayStyle())
    {
      label216:
      this.d = i;
      if (!BNStyleManager.getRealDayStyle()) {
        break label262;
      }
    }
    label262:
    for (i = 0;; i = 9)
    {
      a(this.d, i);
      if (localMapGLSurfaceView == null) {
        break;
      }
      localMapGLSurfaceView.getController().setOverlookGestureEnable(this.f);
      break;
      i = 11;
      break label216;
    }
  }
  
  private boolean h()
  {
    return (this.d >= 0) && (this.d != 9) && (this.e >= 0) && (this.e != 2);
  }
  
  public void a(int paramInt)
  {
    LogUtil.e(c, "setMapTheme.theme=" + paramInt);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().setMapTheme(paramInt, new Bundle());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    LogUtil.e(c, "setMapThemeScene.theme=" + paramInt1 + ", scene=" + paramInt2);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().setMapThemeScene(paramInt1, paramInt2, new Bundle());
    }
  }
  
  public void a(BNMapObserver paramBNMapObserver)
  {
    if (com.baidu.baidumaps.f.a.b.a.a().e())
    {
      NavMapManager.getInstance().deleteMapObserver(paramBNMapObserver);
      return;
    }
    NavMapManager.getInstance().addMapObserver(paramBNMapObserver);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    a locala = new a();
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if (localMapGLSurfaceView != null)
    {
      locala.a = localMapGLSurfaceView.getController().getMapTheme();
      locala.b = 0;
      locala.c = localMapGLSurfaceView.getController().isOverlookGestureEnable();
      if (locala.a == 9) {
        locala.a = 1;
      }
      if ((locala.b == 2) || (f(locala.b))) {
        locala.b = 0;
      }
    }
    for (;;)
    {
      NavLogUtils.e(c, "cacheMapMode: --> cacheKey: " + paramString + ", theme: " + locala.a + ", scene: " + locala.b);
      this.g.put(paramString, locala);
      return;
      locala.b = -99;
      locala.c = true;
    }
  }
  
  public void a(boolean paramBoolean, BNMapObserver paramBNMapObserver)
  {
    int j = 1;
    NavLogUtils.e(c, "changeMode() isnaving" + BNavigator.getInstance().isNaviBegin());
    if (BNavigator.getInstance().isNaviBegin()) {
      return;
    }
    Object localObject = MapViewFactory.getInstance().getMapView();
    int i;
    if (com.baidu.baidumaps.f.a.b.a.a().e())
    {
      NavMapManager.getInstance().removeNaviMapListener();
      NavMapManager.getInstance().handleRoadCondition(0);
      NavMapManager.getInstance().setNaviMapMode(0);
      NavMapManager.getInstance().handleMapOverlays(0);
      NavMapManager.getInstance().deleteMapObserver(paramBNMapObserver);
      a().b(true);
      if (localObject != null)
      {
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
        if (this.d < 0) {
          break label259;
        }
        i = this.d;
        label127:
        b(i, 2);
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((MapGLSurfaceView)localObject).getController().setOverlookGestureEnable(false);
        paramBNMapObserver = ((MapGLSurfaceView)localObject).getMapStatus();
        if (paramBNMapObserver != null)
        {
          paramBNMapObserver.overlooking = 0;
          paramBNMapObserver.rotation = 0;
          ((MapGLSurfaceView)localObject).setMapStatus(paramBNMapObserver);
        }
      }
      if (!LogUtil.LOGGABLE) {
        break;
      }
      paramBNMapObserver = c;
      localObject = new StringBuilder().append("changeMode() theme=");
      i = j;
      if (this.d >= 0) {
        i = this.d;
      }
      NavLogUtils.e(paramBNMapObserver, i + ", scene=" + 2 + ", over=" + this.f);
      LogUtil.printCallStatck();
      return;
      label259:
      i = 1;
      break label127;
      if (localObject != null)
      {
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
        PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
      }
      NavMapManager.getInstance().addNaviMapListener();
      NavMapManager.getInstance().initNaviSO();
      NavMapManager.getInstance().handleMapOverlays(5);
      NavMapManager.getInstance().setNaviMapMode(5);
      NavMapManager.getInstance().handleRoadCondition(5);
      NavMapManager.getInstance().addMapObserver(paramBNMapObserver);
      BNRouteGuider.getInstance().setBrowseStatus(true);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    BNMapController.getInstance().showCarResultLayer(paramBoolean);
    return BNMapController.getInstance().setPreRoutePlanStatus(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    LogUtil.e(c, "setMapThemeByJNI.theme=" + paramInt);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().setMapTheme(paramInt, new Bundle());
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    LogUtil.e(c, "setMapThemeSceneByJNI.theme=" + paramInt1 + ", scene=" + paramInt2 + ", self=" + true);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().setMapThemeScene(paramInt1, paramInt2, new Bundle());
    }
  }
  
  public void b(String paramString)
  {
    int i = 10;
    if ((paramString == null) || (paramString.length() == 0) || (!this.g.containsKey(paramString))) {}
    a locala;
    do
    {
      return;
      locala = (a)this.g.get(paramString);
    } while (locala == null);
    PerformStatisticsController.peByType(0, "map_setmpamode_start", System.currentTimeMillis());
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if ((locala.a >= 0) && (locala.b >= 0))
    {
      if (localMapGLSurfaceView != null)
      {
        i = locala.b;
        if (((locala.b == 0) || (locala.b == 5)) && (!MapViewFactory.getInstance().getMapView().isTraffic())) {
          break label202;
        }
        if (!BNStyleManager.getRealDayStyle()) {
          break label205;
        }
        i = 10;
        label120:
        this.d = i;
        if (!BNStyleManager.getRealDayStyle()) {
          break label211;
        }
      }
      label202:
      label205:
      label211:
      for (i = 0;; i = 9)
      {
        NavLogUtils.e(c, "restoreMapMode: all --> cacheKey: " + paramString + ", theme: " + locala.a + ", scene: " + i);
        localMapGLSurfaceView.getController().setOverlookGestureEnable(locala.c);
        this.g.remove(paramString);
        return;
        break;
        i = 11;
        break label120;
      }
    }
    if (BNStyleManager.getRealDayStyle())
    {
      label223:
      this.d = i;
      if (!BNStyleManager.getRealDayStyle()) {
        break label255;
      }
    }
    label255:
    for (;;)
    {
      localMapGLSurfaceView.getController().setOverlookGestureEnable(locala.c);
      break;
      i = 11;
      break label223;
    }
  }
  
  public int c()
  {
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if (localMapGLSurfaceView != null) {
      return localMapGLSurfaceView.getController().getMapTheme();
    }
    return 1;
  }
  
  public void c(int paramInt)
  {
    LogUtil.e(c, "setMapScene.scene=" + paramInt);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().setMapScene(paramInt);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    LogUtil.e(c, "setMapThemeSceneForce.theme=" + paramInt1 + ", scene=" + paramInt2);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().forceSetMapThemeScene(paramInt1, paramInt2, new Bundle());
    }
  }
  
  public boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!this.g.containsKey(paramString)))
    {
      NavLogUtils.e(c, "keyHasCached: false --> key: " + paramString);
      return false;
    }
    NavLogUtils.e(c, "keyHasCached: true --> key: " + paramString);
    return true;
  }
  
  public void d()
  {
    if (h()) {}
    do
    {
      return;
      MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
      if (localMapGLSurfaceView == null) {
        break;
      }
      this.d = localMapGLSurfaceView.getController().getMapTheme();
      this.e = 0;
      this.f = localMapGLSurfaceView.getController().isOverlookGestureEnable();
      if (this.d == 9) {
        this.d = 1;
      }
    } while ((this.e != 2) && (!f(this.e)));
    this.e = 0;
    return;
    this.e = -99;
    this.f = true;
  }
  
  public void d(int paramInt)
  {
    LogUtil.e(c, "setMapSceneByJNI.scene=" + paramInt);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().setMapScene(paramInt);
    }
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    LogUtil.e(c, "setMapSceneForce.scene=" + paramInt);
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().getController().forceSetMapScene(paramInt);
    }
  }
  
  public void f()
  {
    int j = 1;
    Object localObject = MapViewFactory.getInstance().getMapView();
    if (com.baidu.baidumaps.f.a.b.a.a().e())
    {
      NavMapManager.getInstance().setNaviMapMode(0);
      if (localObject != null) {
        if (this.d < 0) {
          break label115;
        }
      }
      label115:
      for (i = this.d;; i = 1)
      {
        b(i, 2);
        localObject = c;
        StringBuilder localStringBuilder = new StringBuilder().append("justChangeThemeScene() theme=");
        i = j;
        if (this.d >= 0) {
          i = this.d;
        }
        NavLogUtils.e((String)localObject, i + ", scene=" + 2 + ", over=" + this.f);
        return;
      }
    }
    if (localObject != null) {
      if (this.d < 0) {
        break label152;
      }
    }
    label152:
    for (int i = this.d;; i = 1)
    {
      b(i, 2);
      NavMapManager.getInstance().setNaviMapMode(5);
      break;
    }
  }
  
  public boolean f(int paramInt)
  {
    return (paramInt >= 8) && (paramInt <= 19);
  }
  
  public void g()
  {
    this.d = -99;
    this.e = -99;
    this.f = true;
    this.g.clear();
  }
  
  public static class a
  {
    public int a = -99;
    public int b = -99;
    public boolean c = true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/f/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */