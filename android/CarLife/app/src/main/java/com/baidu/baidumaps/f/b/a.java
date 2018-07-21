package com.baidu.baidumaps.f.b;

import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay.OnTapListener;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.OverlayItem;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private MapGLSurfaceView a = null;
  private BaiduMapItemizedOverlay b;
  
  public static a a()
  {
    return a.a();
  }
  
  private InnerOverlay c(int paramInt)
  {
    try
    {
      InnerOverlay localInnerOverlay = (InnerOverlay)MapViewFactory.getInstance().getMapView().getOverlay(paramInt);
      return localInnerOverlay;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    InnerOverlay localInnerOverlay = c(paramInt);
    if (localInnerOverlay != null)
    {
      localInnerOverlay.SetOverlayShow(paramBoolean);
      localInnerOverlay.UpdateOverlay();
    }
  }
  
  public void a(ArrayList<OverlayItem> paramArrayList, BaiduMapItemizedOverlay.OnTapListener paramOnTapListener)
  {
    if (this.b == null)
    {
      this.b = BaiduMapItemizedOverlay.getInstance();
      this.a.addOverlay(this.b);
    }
    if (this.a.getOverlays().contains(this.b)) {
      this.a.removeOverlay(this.b);
    }
    this.b.removeAll();
    this.b.addItem(paramArrayList);
    if (paramOnTapListener != null) {
      this.b.setOnTapListener(paramOnTapListener);
    }
    for (;;)
    {
      this.a.addOverlay(this.b);
      return;
      this.b.setOnTapListener(null);
    }
  }
  
  public boolean a(int paramInt)
  {
    InnerOverlay localInnerOverlay = c(paramInt);
    if (localInnerOverlay != null)
    {
      boolean bool = localInnerOverlay.IsOverlayShow();
      NavLogUtils.e("DrawRouteUtil", "isOverlayShowing: --> showing: " + bool + ", overlay: " + localInnerOverlay);
      return bool;
    }
    NavLogUtils.e("DrawRouteUtil", "isOverlayShowing: --> showing: false, mapOverlayId: " + paramInt);
    return false;
  }
  
  public OverlayItem b(int paramInt)
  {
    if (this.b != null) {
      return this.b.getItem(paramInt);
    }
    return null;
  }
  
  public void b()
  {
    if (this.b != null)
    {
      this.b.hide();
      this.b.removeAll();
    }
  }
  
  private static class a
  {
    private static final a a = new a(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/f/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */