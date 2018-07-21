package com.baidu.baidunavis.control;

import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay.OnTapListener;
import com.baidu.mapframework.common.mapview.BaseMapViewListener;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.map.BNMapManager;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.MapWrapper;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.OnTapListener;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapObj;
import java.util.ArrayList;

public class NavItemizedOverlayUtil
{
  private static final String TAG = NavItemizedOverlayUtil.class.getSimpleName();
  private ItemizedOverlayUtil.OnTapListener navOnTapListener;
  
  private com.baidu.platform.comapi.map.OverlayItem convert2MapOverlayItem(com.baidu.nplatform.comapi.map.OverlayItem paramOverlayItem)
  {
    if (paramOverlayItem == null) {
      return null;
    }
    Object localObject = paramOverlayItem.getPoint();
    com.baidu.platform.comapi.map.OverlayItem localOverlayItem = new com.baidu.platform.comapi.map.OverlayItem(new com.baidu.platform.comapi.basestruct.GeoPoint(((com.baidu.nplatform.comapi.basestruct.GeoPoint)localObject).getLatitudeE6(), ((com.baidu.nplatform.comapi.basestruct.GeoPoint)localObject).getLongitudeE6()), paramOverlayItem.getTitle(), paramOverlayItem.getSnippet());
    if ((paramOverlayItem.getClickRect() != null) && (paramOverlayItem.getClickRect().size() > 0)) {
      localOverlayItem.setClickRect(paramOverlayItem.getClickRect());
    }
    localOverlayItem.setMarker(paramOverlayItem.getMarker());
    localOverlayItem.setAnchor(paramOverlayItem.getAnchorX(), paramOverlayItem.getAnchorY());
    localOverlayItem.setAnimate(paramOverlayItem.getAnimate());
    if (paramOverlayItem.getCoordType() == com.baidu.nplatform.comapi.map.OverlayItem.CoordType.CoordType_BD09LL) {}
    for (localObject = com.baidu.platform.comapi.map.OverlayItem.CoordType.CoordType_BD09LL;; localObject = com.baidu.platform.comapi.map.OverlayItem.CoordType.CoordType_BD09)
    {
      localOverlayItem.setCoordType((com.baidu.platform.comapi.map.OverlayItem.CoordType)localObject);
      localOverlayItem.setLevel(paramOverlayItem.getLevel());
      localOverlayItem.setMask(paramOverlayItem.getMask());
      return localOverlayItem;
    }
  }
  
  public static NavItemizedOverlayUtil getInstance()
  {
    return Holder.OVERLAY;
  }
  
  public ItemizedOverlayUtil.OnTapListener getNavOnTapListener()
  {
    return this.navOnTapListener;
  }
  
  public void initWrapper(final boolean paramBoolean, final ItemClickListener paramItemClickListener)
  {
    NavLogUtils.e(TAG, "initWrapper: --> ");
    NavMapManager.getInstance().setBaseMapViewListener(new BaseMapViewListener()
    {
      public void onClickedBackground(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onClickedBackground(paramAnonymousInt1, paramAnonymousInt2);
        BNMapController.getInstance().notifyMapObservers(2, 514, MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, paramAnonymousInt1, paramAnonymousInt2, 0));
      }
      
      public void onClickedTrafficUgcEventMapObj(MapObj paramAnonymousMapObj, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousMapObj != null)
        {
          if (paramBoolean) {
            break label23;
          }
          BNavigator.getInstance().showUgcDetailView(paramAnonymousMapObj.strUid, paramAnonymousBoolean);
        }
        label23:
        while (paramItemClickListener == null) {
          return;
        }
        paramItemClickListener.ugcItemClick(paramAnonymousMapObj, paramAnonymousBoolean);
      }
      
      protected void onCompassClick(MapObj paramAnonymousMapObj) {}
      
      protected void onFavouritePoiClick(MapObj paramAnonymousMapObj) {}
      
      protected void onLocationPointClick(MapObj paramAnonymousMapObj) {}
      
      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        super.onLongPress(paramAnonymousMotionEvent);
        BNMapController.getInstance().notifyMapObservers(2, 517, paramAnonymousMotionEvent);
      }
      
      protected void onPoiMarkerClick(MapObj paramAnonymousMapObj)
      {
        if ((paramAnonymousMapObj == null) || (paramAnonymousMapObj.geoPt == null)) {}
        do
        {
          return;
          paramAnonymousMapObj.strText = paramAnonymousMapObj.strText.replaceAll("\\\\", "");
          localObject = NavMapAdapter.MC2LLE6(paramAnonymousMapObj.geoPt.getIntX(), paramAnonymousMapObj.geoPt.getIntY());
        } while ((localObject == null) || (((Bundle)localObject).isEmpty()));
        Object localObject = new com.baidu.nplatform.comapi.basestruct.GeoPoint(((Bundle)localObject).getInt("LLx"), ((Bundle)localObject).getInt("LLy"));
        MapItem localMapItem = new MapItem();
        localMapItem.mTitle = paramAnonymousMapObj.strText;
        localMapItem.mLongitude = ((com.baidu.nplatform.comapi.basestruct.GeoPoint)localObject).getLongitudeE6();
        localMapItem.mLatitude = ((com.baidu.nplatform.comapi.basestruct.GeoPoint)localObject).getLatitudeE6();
        localMapItem.mUid = paramAnonymousMapObj.strUid;
        BNMapController.getInstance().notifyMapObservers(1, 264, localMapItem);
      }
    });
    BNMapManager.getInstance().setItemizedOverlayMapWrapper(new ItemizedOverlayUtil.MapWrapper()
    {
      public void addMapItem(com.baidu.nplatform.comapi.map.OverlayItem paramAnonymousOverlayItem)
      {
        NavLogUtils.e(NavItemizedOverlayUtil.TAG, "addMapItem: --> " + paramAnonymousOverlayItem);
        if (paramAnonymousOverlayItem == null) {
          return;
        }
        paramAnonymousOverlayItem = NavItemizedOverlayUtil.this.convert2MapOverlayItem(paramAnonymousOverlayItem);
        BaiduMapItemizedOverlay.getInstance().addItem(paramAnonymousOverlayItem);
      }
      
      public ItemizedOverlayUtil.OnTapListener getOnTapListener()
      {
        return NavItemizedOverlayUtil.this.navOnTapListener;
      }
      
      public void refresh()
      {
        NavLogUtils.e(NavItemizedOverlayUtil.TAG, "refresh: --> ");
        MapViewFactory.getInstance().getMapView().refresh(BaiduMapItemizedOverlay.getInstance());
      }
      
      public void removeAllItems()
      {
        NavLogUtils.e(NavItemizedOverlayUtil.TAG, "removeAllItems: --> ");
        BaiduMapItemizedOverlay.getInstance().removeAll();
      }
      
      public void removeMapItem(com.baidu.nplatform.comapi.map.OverlayItem paramAnonymousOverlayItem)
      {
        NavLogUtils.e(NavItemizedOverlayUtil.TAG, "removeMapItem: --> " + paramAnonymousOverlayItem);
        if (paramAnonymousOverlayItem == null) {
          return;
        }
        paramAnonymousOverlayItem = NavItemizedOverlayUtil.this.convert2MapOverlayItem(paramAnonymousOverlayItem);
        BaiduMapItemizedOverlay.getInstance().removeItem(paramAnonymousOverlayItem);
      }
      
      public void setOnTapListener(ItemizedOverlayUtil.OnTapListener paramAnonymousOnTapListener)
      {
        NavLogUtils.e(NavItemizedOverlayUtil.TAG, "setOnTapListener: onTapListener --> " + paramAnonymousOnTapListener);
        NavItemizedOverlayUtil.access$302(NavItemizedOverlayUtil.this, paramAnonymousOnTapListener);
        if (NavItemizedOverlayUtil.this.navOnTapListener == null)
        {
          BaiduMapItemizedOverlay.getInstance().setOnTapListener(null);
          return;
        }
        BaiduMapItemizedOverlay.getInstance().setOnTapListener(new BaiduMapItemizedOverlay.OnTapListener()
        {
          public boolean onTap(int paramAnonymous2Int)
          {
            return NavItemizedOverlayUtil.this.navOnTapListener.onTap(paramAnonymous2Int);
          }
          
          public boolean onTap(int paramAnonymous2Int1, int paramAnonymous2Int2, com.baidu.platform.comapi.basestruct.GeoPoint paramAnonymous2GeoPoint)
          {
            com.baidu.nplatform.comapi.basestruct.GeoPoint localGeoPoint = null;
            if (paramAnonymous2GeoPoint != null) {
              localGeoPoint = new com.baidu.nplatform.comapi.basestruct.GeoPoint(paramAnonymous2GeoPoint.getLongitudeE6(), paramAnonymous2GeoPoint.getLatitudeE6());
            }
            return NavItemizedOverlayUtil.this.navOnTapListener.onTap(paramAnonymous2Int1, paramAnonymous2Int2, localGeoPoint);
          }
          
          public boolean onTap(com.baidu.platform.comapi.basestruct.GeoPoint paramAnonymous2GeoPoint, MapGLSurfaceView paramAnonymous2MapGLSurfaceView)
          {
            paramAnonymous2MapGLSurfaceView = null;
            if (paramAnonymous2GeoPoint != null) {
              paramAnonymous2MapGLSurfaceView = new com.baidu.nplatform.comapi.basestruct.GeoPoint(paramAnonymous2GeoPoint.getLongitudeE6(), paramAnonymous2GeoPoint.getLatitudeE6());
            }
            return NavItemizedOverlayUtil.this.navOnTapListener.onTap(paramAnonymous2MapGLSurfaceView);
          }
        });
      }
      
      public void showItemizedOverlay(boolean paramAnonymousBoolean)
      {
        NavLogUtils.e(NavItemizedOverlayUtil.TAG, "showItemizedOverlay: show --> " + paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          BaiduMapItemizedOverlay.getInstance().show();
          return;
        }
        BaiduMapItemizedOverlay.getInstance().hide();
      }
    });
  }
  
  public void setNavOnTapListener(ItemizedOverlayUtil.OnTapListener paramOnTapListener)
  {
    this.navOnTapListener = paramOnTapListener;
  }
  
  public void unInitWrapper()
  {
    NavLogUtils.e(TAG, "unInitWrapper: --> ");
    NavMapManager.getInstance().resetBaseMapViewListener();
  }
  
  private static class Holder
  {
    static final NavItemizedOverlayUtil OVERLAY = new NavItemizedOverlayUtil(null);
  }
  
  public static abstract interface ItemClickListener
  {
    public abstract void ugcItemClick(MapObj paramMapObj, boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavItemizedOverlayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */