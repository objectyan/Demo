package com.baidu.carlife;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.m.b;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.event.CancelCompassEvent;
import com.baidu.platform.comapi.map.event.MapMoveEvent;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.BMEventBus.OnEvent;
import com.baidu.platform.comapi.util.n;

public class MainActivity
  extends FragmentActivity
  implements View.OnClickListener, BMEventBus.OnEvent
{
  public static Activity a;
  public static FragmentManager b;
  public static MapObj c;
  private static final int g = 1;
  private static final int h = 1;
  private static final int i = 3;
  private static final int j = 12;
  private static final int k = 17;
  private static final double l = 2.0D;
  private static final double m = 30000.0D;
  private MapGLSurfaceView d;
  private MapController e;
  private MapViewConfig f;
  private int n = Integer.MIN_VALUE;
  private int o = Integer.MIN_VALUE;
  private int p = Integer.MIN_VALUE;
  private int q = Integer.MIN_VALUE;
  private LocationManager.LocData r;
  private MapViewConfig.PositionStatus s;
  private Handler t;
  
  private void a()
  {
    int i1 = (int)this.d.getZoomLevel();
    if (i1 >= c()) {
      return;
    }
    this.d.setZoomLevel(i1 + 1);
  }
  
  public static void a(Fragment paramFragment)
  {
    if (paramFragment.isAdded())
    {
      FragmentTransaction localFragmentTransaction = b.beginTransaction();
      localFragmentTransaction.remove(paramFragment);
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public static void a(Fragment paramFragment, Bundle paramBundle)
  {
    FragmentTransaction localFragmentTransaction = b.beginTransaction();
    if (paramFragment.isAdded()) {
      return;
    }
    paramFragment.setArguments(paramBundle);
    localFragmentTransaction.replace(2131625596, paramFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void a(MapViewConfig.PositionStatus paramPositionStatus, boolean paramBoolean)
  {
    float f1 = 18.0F;
    LocationManager.LocData localLocData = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
    MapStatus localMapStatus = this.d.getMapStatus();
    if (localMapStatus == null) {
      return;
    }
    if (paramBoolean) {
      if (this.f.getPositionStatus() == MapViewConfig.PositionStatus.FOLLOWING)
      {
        localMapStatus.centerPtX = ((int)localLocData.longitude);
        localMapStatus.centerPtY = ((int)localLocData.latitude);
        localMapStatus.level = 17.0F;
        if ((localLocData.floorId != null) && (localLocData.buildingId != null)) {
          localMapStatus.level = 20.0F;
        }
        if (paramPositionStatus != MapViewConfig.PositionStatus.NORMAL)
        {
          if (MapViewConfig.getInstance().getMapMode() != MapViewConfig.MapMode._3D) {
            localMapStatus.overlooking = 0;
          }
          localMapStatus.rotation = 0;
        }
      }
    }
    for (;;)
    {
      if (localMapStatus.level < 12.0F) {
        localMapStatus.level = 17.0F;
      }
      a(localLocData, this.f.getPositionStatus());
      paramPositionStatus = this.f.getPositionStatus();
      if (((paramBoolean) && (this.d.getController().isMovedMap())) || ((paramPositionStatus != MapViewConfig.PositionStatus.COMPASS) && (paramPositionStatus != MapViewConfig.PositionStatus.FOLLOWING))) {
        break;
      }
      if (!n.a()) {
        break label448;
      }
      if (!paramBoolean) {
        break label435;
      }
      this.d.setMapStatus(localMapStatus);
      return;
      switch (3.a[this.f.getPositionStatus().ordinal()])
      {
      default: 
        break;
      case 1: 
        localMapStatus.centerPtX = ((int)localLocData.longitude);
        localMapStatus.centerPtY = ((int)localLocData.latitude);
        if (paramPositionStatus != MapViewConfig.PositionStatus.NORMAL)
        {
          if (MapViewConfig.getInstance().getMapMode() != MapViewConfig.MapMode._3D) {
            localMapStatus.overlooking = 0;
          }
          localMapStatus.rotation = 0;
        }
        break;
      }
    }
    localMapStatus.centerPtX = ((int)localLocData.longitude);
    localMapStatus.centerPtY = ((int)localLocData.latitude);
    localMapStatus.overlooking = -45;
    if (localLocData.direction > 0.0F)
    {
      localMapStatus.rotation = ((int)localLocData.direction);
      label369:
      if ((localLocData.buildingId != null) && (localLocData.floorId != null)) {
        break label424;
      }
      if (localMapStatus.level >= 18.0F) {
        break label426;
      }
    }
    for (;;)
    {
      localMapStatus.level = f1;
      break;
      if (this.n == Integer.MIN_VALUE) {
        break label369;
      }
      localMapStatus.rotation = this.n;
      break label369;
      label424:
      break;
      label426:
      f1 = localMapStatus.level;
    }
    label435:
    this.d.animateTo(localMapStatus, 1000);
    return;
    label448:
    if (paramBoolean)
    {
      this.d.setMapStatus(localMapStatus);
      return;
    }
    this.d.animateTo(localMapStatus, 1000);
  }
  
  private void a(LocationManager.LocData paramLocData, MapViewConfig.PositionStatus paramPositionStatus)
  {
    if ((paramLocData.latitude == -1.0D) && (paramLocData.longitude == -1.0D)) {}
    do
    {
      do
      {
        return;
      } while (this.f.getPositionStatus() == MapViewConfig.PositionStatus.TRACKING);
      float f1 = paramLocData.direction;
    } while (!b(paramLocData, paramPositionStatus));
    if (paramPositionStatus == MapViewConfig.PositionStatus.COMPASS) {}
    for (boolean bool = true;; bool = false)
    {
      String str = paramLocData.toLocationOverlayJsonString(bool);
      LocationOverlay localLocationOverlay = (LocationOverlay)this.d.getOverlay(LocationOverlay.class);
      if (localLocationOverlay != null)
      {
        localLocationOverlay.setData(str);
        localLocationOverlay.UpdateOverlay();
      }
      this.r = paramLocData;
      this.s = paramPositionStatus;
      return;
    }
  }
  
  public static void a(Point paramPoint, String paramString1, String paramString2)
  {
    RouteNode localRouteNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), "我的位置", null);
    localRouteNode.mFromType = 3;
    Object localObject = LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
    if (localObject != null)
    {
      localRouteNode.mGPSAccuracy = ((LocationManager.LocData)localObject).accuracy;
      localRouteNode.mGPSSpeed = ((LocationManager.LocData)localObject).speed;
      localRouteNode.mLocType = ((LocationManager.LocData)localObject).type;
      localRouteNode.mGPSAngle = ((LocationManager.LocData)localObject).direction;
      localRouteNode.mNetworkLocStr = ((LocationManager.LocData)localObject).networkLocType;
      localRouteNode.mAltitude = ((LocationManager.LocData)localObject).altitude;
    }
    localRouteNode.mFromType = 3;
    localRouteNode.mCityID = 340;
    NavMapAdapter localNavMapAdapter = NavMapAdapter.getInstance();
    if (paramPoint != null)
    {
      localObject = NavMapAdapter.getInstance().getGeoPoint(paramPoint, false);
      paramString1 = localNavMapAdapter.getRouteNode((NavGeoPoint)localObject, paramString1, paramString2);
      if (paramPoint == null) {
        break label169;
      }
    }
    label169:
    for (paramString1.mFromType = 1;; paramString1.mFromType = 2)
    {
      BaiduNaviManager.getInstance().calcRouteToNaviRoute(localRouteNode, paramString1, null, 1, 15, 120, 1, 5, null);
      return;
      localObject = null;
      break;
    }
  }
  
  private void b()
  {
    int i1 = (int)this.d.getZoomLevel();
    if (i1 <= 4) {
      return;
    }
    this.d.setZoomLevel(i1 - 1);
  }
  
  private boolean b(LocationManager.LocData paramLocData, MapViewConfig.PositionStatus paramPositionStatus)
  {
    return (this.r == null) || (Math.abs(this.r.latitude - paramLocData.latitude) >= 1.0D) || (Math.abs(this.r.longitude - paramLocData.longitude) >= 1.0D) || (Math.abs(this.r.accuracy - paramLocData.accuracy) >= 1.0F) || (Math.abs(this.r.direction - paramLocData.direction) >= 3.0F) || (this.s == null) || (this.s != paramPositionStatus);
  }
  
  private int c()
  {
    return 21;
  }
  
  private void onEventMainThread(CancelCompassEvent paramCancelCompassEvent)
  {
    MapViewConfig.getInstance().setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    a(MapViewConfig.PositionStatus.NORMAL, false);
  }
  
  private void onEventMainThread(MapMoveEvent paramMapMoveEvent)
  {
    MapViewConfig.getInstance().setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    a(MapViewConfig.PositionStatus.NORMAL, false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131625597) {}
    switch (3.a[this.f.getPositionStatus().ordinal()])
    {
    default: 
      if (paramView.getId() == 2131625598)
      {
        this.d.setTraffic(false);
        if (c != null)
        {
          paramView = new Point();
          paramView.setIntX(c.geoPt.getIntX());
          paramView.setIntY(c.geoPt.getIntY());
          a(paramView, c.strText, c.strUid);
        }
      }
      break;
    }
    do
    {
      return;
      this.f.setPositionStatus(MapViewConfig.PositionStatus.FOLLOWING);
      a(MapViewConfig.PositionStatus.NORMAL, false);
      break;
      this.f.setPositionStatus(MapViewConfig.PositionStatus.COMPASS);
      a(MapViewConfig.PositionStatus.FOLLOWING, false);
      break;
      this.f.setPositionStatus(MapViewConfig.PositionStatus.FOLLOWING);
      a(MapViewConfig.PositionStatus.COMPASS, false);
      break;
      if (paramView.getId() == 2131625599)
      {
        this.d.setTraffic(true);
        return;
      }
      if (paramView.getId() == 2131625600)
      {
        a();
        ((LocationOverlay)this.d.getOverlay(LocationOverlay.class)).SetOverlayShow(false);
        BaiduNaviManager.getInstance().launchCruiser(this, Boolean.valueOf(true));
        return;
      }
    } while (paramView.getId() != 2131625601);
    b();
    ((LocationOverlay)this.d.getOverlay(LocationOverlay.class)).SetOverlayShow(true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968916);
    a = this;
    b = getSupportFragmentManager();
    this.f = MapViewConfig.getInstance();
    this.t = new Handler(Looper.getMainLooper());
    paramBundle = (Button)findViewById(2131625597);
    Button localButton1 = (Button)findViewById(2131625598);
    Button localButton2 = (Button)findViewById(2131625599);
    Button localButton3 = (Button)findViewById(2131625600);
    Button localButton4 = (Button)findViewById(2131625601);
    localButton3.setOnClickListener(this);
    localButton4.setOnClickListener(this);
    paramBundle.setOnClickListener(this);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    h.a(new NaviFragmentManager(this));
    paramBundle = (FrameLayout)findViewById(2131623983);
    this.d = MapViewFactory.getInstance().getMapView();
    this.e = this.d.getController();
    this.e.setMapViewListener(new a()
    {
      protected void a(MapObj paramAnonymousMapObj) {}
      
      protected void b(MapObj paramAnonymousMapObj) {}
      
      protected void c(MapObj paramAnonymousMapObj) {}
      
      protected void d(MapObj paramAnonymousMapObj) {}
    });
    MapViewFactory.getInstance().relayoutMapView(paramBundle, 0);
    MapViewConfig.getInstance().setPositionStatus(MapViewConfig.PositionStatus.NORMAL);
    b.a();
    LocationManager.getInstance().init(DemoApp.a());
    LocationManager.getInstance().onResume();
    NavMapAdapter.getInstance().initNaviEngine(this, null);
    LocationManager.getInstance().addLocationChangeLister(new LocationChangeListener()
    {
      public LocationChangeListener.CoordType onGetCoordType()
      {
        return LocationChangeListener.CoordType.CoordType_BD09;
      }
      
      public void onLocationChange(LocationManager.LocData paramAnonymousLocData)
      {
        if (!LocationManager.getInstance().isLocationValid()) {}
        while (MainActivity.a(MainActivity.this) == null) {
          return;
        }
        MapStatus localMapStatus = MainActivity.a(MainActivity.this).getMapStatus();
        localMapStatus.centerPtX = ((int)paramAnonymousLocData.longitude);
        localMapStatus.centerPtY = ((int)paramAnonymousLocData.latitude);
        MainActivity.a(MainActivity.this).animateTo(localMapStatus, 0);
        MainActivity.a(MainActivity.this, paramAnonymousLocData, MainActivity.b(MainActivity.this).getPositionStatus());
        LocationManager.getInstance().removeLocationChangeLister(this);
      }
    });
  }
  
  public void onEvent(Object paramObject)
  {
    if ((paramObject instanceof CancelCompassEvent)) {
      onEventMainThread((CancelCompassEvent)paramObject);
    }
    while (!(paramObject instanceof MapMoveEvent)) {
      return;
    }
    onEventMainThread((MapMoveEvent)paramObject);
  }
  
  protected void onPause()
  {
    super.onPause();
    MapViewFactory.getInstance().getMapView().onPause();
    MapViewFactory.getInstance().getMapView().onBackground();
    BMEventBus.getInstance().unregist(this);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    MapViewFactory.getInstance().getMapView().onResume();
    MapViewFactory.getInstance().getMapView().onForeground();
    BMEventBus.getInstance().registSticky(this, CancelCompassEvent.class, new Class[] { MapMoveEvent.class });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */