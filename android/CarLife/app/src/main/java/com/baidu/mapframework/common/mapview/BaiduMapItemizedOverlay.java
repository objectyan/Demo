package com.baidu.mapframework.common.mapview;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import java.util.List;

public class BaiduMapItemizedOverlay
  extends ItemizedOverlay
{
  private OnTapListener a;
  private MapGLSurfaceView b = MapViewFactory.getInstance().getMapView();
  
  private BaiduMapItemizedOverlay()
  {
    super(MapViewFactory.getInstance().getMapView().getContext().getResources().getDrawable(2130838736), MapViewFactory.getInstance().getMapView());
  }
  
  public static BaiduMapItemizedOverlay getInstance()
  {
    return Holder.a;
  }
  
  public OnTapListener getOnTapListener()
  {
    return this.a;
  }
  
  public void hide()
  {
    if (this.b.getOverlays().contains(this)) {
      this.b.removeOverlay(this);
    }
  }
  
  public final boolean onTap(int paramInt)
  {
    if ((this.a != null) && (this.a.onTap(paramInt))) {
      return true;
    }
    return super.onTap(paramInt);
  }
  
  public final boolean onTap(int paramInt1, int paramInt2, GeoPoint paramGeoPoint)
  {
    if ((this.a != null) && (this.a.onTap(paramInt1, paramInt2, paramGeoPoint))) {
      return true;
    }
    return super.onTap(paramInt1, paramInt2, paramGeoPoint);
  }
  
  public final boolean onTap(GeoPoint paramGeoPoint, MapGLSurfaceView paramMapGLSurfaceView)
  {
    if ((this.a != null) && (this.a.onTap(paramGeoPoint, paramMapGLSurfaceView))) {
      return true;
    }
    return super.onTap(paramGeoPoint, paramMapGLSurfaceView);
  }
  
  public void setOnTapListener(OnTapListener paramOnTapListener)
  {
    this.a = paramOnTapListener;
  }
  
  public void show()
  {
    if (this.b.getOverlays().contains(this)) {
      hide();
    }
    this.b.addOverlay(this);
  }
  
  private static class Holder
  {
    static final BaiduMapItemizedOverlay a = new BaiduMapItemizedOverlay(null);
  }
  
  public static abstract interface OnTapListener
  {
    public abstract boolean onTap(int paramInt);
    
    public abstract boolean onTap(int paramInt1, int paramInt2, GeoPoint paramGeoPoint);
    
    public abstract boolean onTap(GeoPoint paramGeoPoint, MapGLSurfaceView paramMapGLSurfaceView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/mapview/BaiduMapItemizedOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */